package id.go.ojk.client.service.ftp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.lib.client.TaskExecutorUtil;
import id.go.ojk.lib.client.model.FileChunk;
import id.go.ojk.lib.client.model.bind.SendingModel;
import id.go.ojk.lib.client.model.constant.OjkClientConstant;
import id.go.ojk.lib.client.service.ftp.FtpConnectionParameter;
import id.go.ojk.lib.client.util.MeteredMultiThreadIOCopyers;
import javafx.application.Platform;

public class FTPsTaskManager {

	private static Logger logger = LoggerFactory.getLogger(FTPsTask.class);

	private SendingModel sendingModel;
	private FtpConnectionParameter parameter;
	private int numberOfThread = 1;
	private List<FTPsTask> ftpsTasks = new ArrayList<>();
	private List<Future<?>> futures = new ArrayList<>();

	public FTPsTaskManager(SendingModel sendingModel, FtpConnectionParameter parameter, int numberOfThread){
		this.sendingModel = sendingModel;
		this.parameter = parameter;
		this.numberOfThread = numberOfThread;
		initChunkFile();
		if( OjkClientConstant.isLocalRuntime() ){
			debugChunk();
		}
	}

	public void debugChunk(){
		for (FileChunk fileChunk : sendingModel.getFtpResult().getFileChunks()) {
			logger.debug(fileChunk.toString());
		}
	}

	public void startTask(){
		MeteredMultiThreadIOCopyers ioCopyers =
			new MeteredMultiThreadIOCopyers(
				sendingModel.getProgressModel(),
				sendingModel.getProgressModel().getTotalLength(),
				persentage -> {
					Platform.runLater(new Runnable() {
						@Override
					    public void run() {
					    	sendingModel.getProgressModel().setProgress(persentage);
					    }
					});
				}
			);

		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numberOfThread);
		for (FileChunk fileChunk : sendingModel.getFtpResult().getFileChunks()) {
			FTPsTask ftpsTask = new FTPsTask(sendingModel, parameter, fileChunk, ioCopyers);
			ftpsTasks.add(ftpsTask);
			Future<?> future = executor.submit(ftpsTask);
			futures.add(future);
		}

		logger.info("Waittes All task finish");
		TaskExecutorUtil.waitAllTaskFinish(executor, 100000);
		
		logger.info("Shutdown executor");
		executor.shutdown();
		
		logger.info("Shutdown executor complete");
	}

	private void initChunkFile(){
		List<FileChunk> fileChunks = new ArrayList<FileChunk>();
		for (File file : sendingModel.getReadyToSendFiles()) {
			long byteOffset = 0;
			int chunkNumber = 0;
			while ( true ) {
				if ( byteOffset + OjkClientConstant.getFtpchunkfilesizeByte() >= file.length() ){
					FileChunk fileChunk = new FileChunk(file, byteOffset, file.length() - byteOffset, chunkNumber);
					fileChunks.add(fileChunk);
					break;
				} else {
					FileChunk fileChunk = new FileChunk(file, byteOffset, OjkClientConstant.getFtpchunkfilesizeByte(), chunkNumber);
					fileChunks.add(fileChunk);
					byteOffset += OjkClientConstant.getFtpchunkfilesizeByte();
					if ( byteOffset == file.length() )
						break;
				}
				chunkNumber++;
			}
		}
		sendingModel.getFtpResult().setFileChunks(fileChunks);
	}

}
