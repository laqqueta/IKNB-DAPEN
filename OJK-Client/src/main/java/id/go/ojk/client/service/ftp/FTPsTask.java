package id.go.ojk.client.service.ftp;

import org.apache.commons.compress.utils.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.lib.client.ThreadUtil;
import id.go.ojk.lib.client.exception.StopProsesException;
import id.go.ojk.lib.client.model.FileChunk;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.bind.SendingModel;
import id.go.ojk.lib.client.service.ftp.FtpConnectionParameter;
import id.go.ojk.lib.client.util.MeteredMultiThreadIOCopyers;
import javafx.scene.control.Alert.AlertType;

public class FTPsTask implements Runnable {
	private static Logger logger = LoggerFactory.getLogger(FTPsTask.class);
	private SendingModel sendingModel;
	private FtpConnectionParameter parameter;
	private FileChunk fileChunk;
	private MeteredMultiThreadIOCopyers ioCopyers;

	public FTPsTask(SendingModel sendingModel, FtpConnectionParameter parameter, FileChunk fileChunk, MeteredMultiThreadIOCopyers ioCopyers){
		this.sendingModel = sendingModel;
		this.parameter = parameter.cloneSafe();
		this.fileChunk = fileChunk;
		this.ioCopyers = ioCopyers;
	}

	@Override
	public void run() {
		while ( !sendingModel.getProgressModel().isStop() ) {
			FTPsUploader uploader = openFTPs();
			if ( uploader == null )
				break;
			try {
				sendingModel.getProgressModel().writeProcessLog( String.format("Pengiriman - Data - %1$s ", fileChunk.getChunkFileName()));
				if ( uploader.uploadData(sendingModel.getSubmissionId(), fileChunk, ioCopyers) ) {

					if( !sendingModel.getProgressModel().isStop() ){
						sendingModel.getProgressModel().writeProcessLog( String.format("Pengiriman - Data - %1$s - Selesai", fileChunk.getChunkFileName()));						
					}

					break;
				}
			} catch (StopProsesException spe){
				AlertUtil.showAlertSafe(AlertType.ERROR, "Kesalahan", "Kesalahan", spe.getMessage());
				sendingModel.getProgressModel().setStop(true, false);
			} catch ( Throwable e ){
				logger.error("", e);
			} finally {
				IOUtils.closeQuietly(uploader);
			}
			logger.info(String.format("FTP Retry - %1$s ", fileChunk.getChunkFileName()));
			ThreadUtil.sleep(10000);
		}
	}

	private FTPsUploader openFTPs(){
		SecurityService securityService = ApplicationContextClient.getInstance().getService(SecurityService.class);
		while ( !sendingModel.getProgressModel().isStop() ) {
			FTPsUploader uploader = null;
			try {
				parameter.setPassword(securityService.getUserSession().getSessionId());
				uploader = new FTPsUploader(parameter);
				
				Tupple2<Boolean, Integer> loginResult = uploader.login();
				if ( !loginResult.getA() ){
					securityService.relogin();
				}
				
				return uploader;
			} catch ( Exception e ){
				logger.error("", e);
			}
			logger.info("FTP Retry - FTP Login");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
