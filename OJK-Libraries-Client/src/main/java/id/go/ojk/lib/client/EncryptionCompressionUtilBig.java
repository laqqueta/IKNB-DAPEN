package id.go.ojk.lib.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javax.crypto.Cipher;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.FileChunk;
import id.go.ojk.lib.client.model.ObjectHolder;
import id.go.ojk.lib.client.model.bind.ProgressModel;
import id.go.ojk.lib.client.model.compression.FileIntegrity;

public class EncryptionCompressionUtilBig {

	private static Logger logger = LoggerFactory.getLogger(EncryptionCompressionUtilBig.class);

//	public static List<FileIntegrity> compressAndEncryptChunckFileIntegrities(ProgressModel progressModel, String compressAlgoritm, String base64Key, List<FileIntegrity> sourceFile, long splitSize, File destDirectory, int numberThread) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException {
//		List<FileChunk> fileChunks = chunkFileIntegrity(splitSize, sourceFile);
//		return compressAndEncryptChunck(progressModel, compressAlgoritm, base64Key, fileChunks, destDirectory, numberThread);
//	}

	public static List<FileIntegrity> compressAndEncryptChunckFileIntegrities(ProgressModel progressModel, String compressAlgoritm, String base64Key, List<FileIntegrity> sourceFile, long splitSize, File destDirectory, int numberThread) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException {
		
		long totalFileSize = sourceFile.stream().mapToLong(e -> e.getLength()).sum();
		progressModel.setTotalLength( (long)(totalFileSize * 1.5) );
		
		List<FileIntegrity> resultFileIntegrities = new ArrayList<>();

		MeteredIOCopyersPararel ioCopyers = new MeteredIOCopyersPararel(
			new MeteredIOCopyersPararel.PersentageCallBack() {
				@Override
				public boolean isStopProcess() {
					return progressModel.isStop();
				}

				@Override
				public void addProgress(long byteLong) {
					progressModel.addProgress(byteLong);
				}
			}
		);

		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numberThread);
		
		for (FileIntegrity fileIntegrity : sourceFile) {
			
			if ( executor.getActiveCount() > 0 )
				TaskExecutorUtil.waitAllTaskFinish(executor, 300);
			
			if ( fileIntegrity.getLength() != fileIntegrity.getFile().length() ){
				progressModel.setStop(true);
				throw new SlikException(String.format("Ukuran file %1$s berubah",  fileIntegrity.getFile().getName()));
			}
			
			//String checkSum = EncryptionUtil.getChecksum(fileIntegrity.getFile());
			String checkSum = EncryptionUtil.getFileChecksum(progressModel, 0.5d, fileIntegrity.getFile());
			
			if ( StringUtils.isNotEmpty(fileIntegrity.getChecksum()) && !checkSum.equals(fileIntegrity.getChecksum()) ){
				progressModel.setStop(true);
				throw new SlikException(String.format("CheckSum file %1$s berubah",  fileIntegrity.getFile().getName()));
			} else {
				fileIntegrity.setChecksum(checkSum);
			}
			
			if (progressModel.isStop()){
				break;
			}

			List<FileChunk> fileChunks = chunkFile(splitSize, fileIntegrity.getFile());
			for (FileChunk fileChunk : fileChunks) {
				File destFile = new File(destDirectory.getAbsolutePath() + "/" + fileChunk.getChunkFileName());
				FileIntegrity result = new FileIntegrity(destFile, null);
				resultFileIntegrities.add(result);
				executor.execute( new Runnable() {
					@Override
					public void run() {
						if ( progressModel.isStop() ){
							progressModel.writeProcessLog("process stop", false);
							return;
						}

						progressModel.writeProcessLog("Compress Encrypt file " + fileChunk.getChunkFileName() + " Mulai", false);

						ChunkInputStream inputStream = null;
						DigestInputStream digestInputStream = null;
						FileOutputStream outputStream = null;
						try {
							inputStream = new ChunkInputStream(fileChunk, 0);

							digestInputStream = new DigestInputStream(inputStream);
							outputStream = new FileOutputStream(destFile);
							compressAndEncrypt(compressAlgoritm, base64Key, digestInputStream, outputStream, ioCopyers);

							progressModel.writeProcessLog("Compress Encrypt file " + fileChunk.getChunkFileName() + " Selesai", false);
							result.synchLength();
						} catch (Throwable t){
							progressModel.setStop(true);
							result.setThrowable(t);
						} finally {
							IOUtils.closeQuietly(inputStream);
							IOUtils.closeQuietly(digestInputStream);
							IOUtils.closeQuietly(outputStream);
						}
					}
				});
			}
		}

		for(int i=1; i<=100; i++){
			progressModel.writeProcessLog("Menunggu semua task compressAndEncryptChunck selesai ke " + i);
			int activeTask = TaskExecutorUtil.waitAllTaskFinish(executor, 900);
			progressModel.writeProcessLog("ActiveTask compressAndEncryptChunck = " + activeTask);
			if ( activeTask == 0 ){
				progressModel.writeProcessLog("Semua task compressAndEncryptChunck selesai");
				break;				
			}
		}
		executor.shutdown();

		for (FileIntegrity fileIntegrity : resultFileIntegrities) {
			if ( fileIntegrity.isError() ){
				throw new SlikException("compresi dan enkipsi file " + fileIntegrity.getFile().getName() + " gagal!", fileIntegrity.getThrowable());
			}
		}

		return resultFileIntegrities;
	}

	public static List<FileIntegrity> compressAndEncrypt(ProgressModel progressModel, String compressAlgoritm, String base64Key, List<FileIntegrity> sourceFile, File destDirectory, int numberThread) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException {
		ConcurrentMap<String, FileIntegrity> concurrentMap = new ConcurrentHashMap<>();

		MeteredIOCopyersPararel ioCopyers = new MeteredIOCopyersPararel(
			new MeteredIOCopyersPararel.PersentageCallBack() {
				@Override
				public boolean isStopProcess() {
					return progressModel.isStop();
				}

				@Override
				public void addProgress(long byteLong) {
					progressModel.addProgress(byteLong);
				}
			}
		);
		for (FileIntegrity fileIntegrity : sourceFile) {
			if ( fileIntegrity.getFile().length() != fileIntegrity.getLength() ){
				throw new SlikException("Ukuran file " + fileIntegrity.getFile().getName() + " berubah" );
			}
		}

		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numberThread);
		for (FileIntegrity fileIntegrity : sourceFile) {
			executor.execute( new Runnable() {
				@Override
				public void run() {
					if ( progressModel.isStop() ){
						progressModel.writeProcessLog("process stop");
						return;
					}

					progressModel.writeProcessLog("Compress Encrypt file " + fileIntegrity.getFile().getName() + " Mulai");

					File destFile = new File(destDirectory.getAbsolutePath() + "/" + fileIntegrity.getFile().getName());
					FileInputStream inputStream = null;
					DigestInputStream digestInputStream = null;
					FileOutputStream outputStream = null;
					FileIntegrity result = null;
					try {
						inputStream = new FileInputStream(fileIntegrity.getFile());
						digestInputStream = new DigestInputStream(inputStream);
						outputStream = new FileOutputStream(destFile);
						compressAndEncrypt(compressAlgoritm, base64Key, digestInputStream, outputStream, ioCopyers);

						if ( fileIntegrity.getChecksum() != null && !digestInputStream.getChecksum().equals(fileIntegrity.getChecksum()) ){
							throw new SlikException("Ceksum file " + fileIntegrity.getFile().getName() + " berubah" );
						}

						result = new FileIntegrity(destFile, null);
						progressModel.writeProcessLog("Compress Encrypt file " + fileIntegrity.getFile().getName() + " Selesai");
					} catch (Throwable t){
						progressModel.setStop(true);
						result = new FileIntegrity(destFile, null);
						result.setThrowable(t);
					} finally {
						IOUtils.closeQuietly(inputStream);
						IOUtils.closeQuietly(digestInputStream);
						IOUtils.closeQuietly(outputStream);
					}
					concurrentMap.put(result.getFile().getName(), result);
				}
			});
		}

		TaskExecutorUtil.waitAllTaskFinish(executor);
		executor.shutdown();

		List<FileIntegrity> result = new ArrayList<FileIntegrity>();
		for (Entry<String, FileIntegrity> entry : concurrentMap.entrySet()) {
			if ( entry.getValue().isError() ){
				throw new SlikException("compresi dan enkipsi file " + entry.getValue().getFile().getName() + " gagal!", entry.getValue().getThrowable());
			}

			result.add(entry.getValue());
		}
		return result;
	}

	public static void compressAndEncrypt(String compressAlgoritm, String base64Key, InputStream inputStream, OutputStream outputStream, MeteredIOCopyersPararel ioCopyers) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException {
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream(pis);
		ObjectHolder<Throwable> objectHolder = new ObjectHolder<>();

		Thread thread =
			new Thread(
				new Runnable(){
					public void run(){
						try {
							CompressionUtilBig.compress(compressAlgoritm, inputStream, pos, ioCopyers);
						} catch (Throwable t){
							logger.error("Encryption error", t);
							objectHolder.setObject(t);
						} finally {
							IOUtils.closeQuietly(pos);
						}
						logger.debug("compressAndEncrypt Thread finished");
					}
				}
			);
		thread.start();

		EncryptionUtil.aesEncryption(Cipher.ENCRYPT_MODE, base64Key, pis, outputStream, (MeteredIOCopyersPararel)null);
		IOUtils.closeQuietly(pis);

		if (objectHolder.getObject() != null)
			throw new SlikException("Exception while compression", objectHolder.getObject());
	}

	public static List<File> decryptAndDecompress(ProgressModel progressModel, int numberOfThread, String compressAlgoritm, String base64Key, List<FileIntegrity> sources, File destDir) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException, CompressorException {
		destDir.mkdirs();
		List<File> result = new ArrayList<>();
		progressModel.setTotalLength( sources.stream().mapToLong( e -> e.getFile().length()).sum() );
		MeteredIOCopyersPararel ioCopyers2 = new MeteredIOCopyersPararel(
			new MeteredIOCopyersPararel.PersentageCallBack() {

				@Override
				public boolean isStopProcess() {
					return progressModel.isStop();
				}

				@Override
				public void addProgress(long byteLong) {
					progressModel.addProgress(byteLong);
				}
			}
		);

		Map<String, List<FileIntegrity>> dearchiveFileMap = new LinkedHashMap<>();

		for (FileIntegrity fileIntegrity : sources) {
			String fileName = fileIntegrity.getFile().getName();
			String baseName = FilenameUtils.getBaseName(fileName);
			List<FileIntegrity> fileIntegrityList = dearchiveFileMap.get(baseName);
			if ( fileIntegrityList == null ){
				fileIntegrityList = new ArrayList<>();
				dearchiveFileMap.put(baseName, fileIntegrityList);
			}
			fileIntegrityList.add(fileIntegrity);
		}

		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numberOfThread);
		ObjectHolder<Throwable> objectHolder = new ObjectHolder<>();

		for (Entry<String, List<FileIntegrity>> entry : dearchiveFileMap.entrySet()) {
			File destFile = new File(destDir.getAbsolutePath() + "/" + entry.getKey());
			result.add(destFile);
			executor.execute(new Runnable() {

				@Override
				public void run() {
					if ( progressModel.isStop() ){
						return;
					}

					try ( FileOutputStream outputStream = new FileOutputStream(destFile) ){
						progressModel.writeProcessLog("Dekrip dan dekompresi - " + destFile.getName());
						for (FileIntegrity fileIntegrity : entry.getValue()) {
							try ( FileInputStream inputStream = new FileInputStream(fileIntegrity.getFile()) ){
								EncryptionCompressionUtilBig.decryptAndDecompress(compressAlgoritm, base64Key, inputStream, outputStream, ioCopyers2);
							}
						}
						progressModel.writeProcessLog("Dekrip dan dekompresi - " + destFile.getName() + " -  selesai");

					} catch (Throwable t) {
						progressModel.setStop(true);
						objectHolder.setObject(t);
					}
				}
			});

		}

		if ( executor != null ) {
			if ( TaskExecutorUtil.waitAllTaskFinish(executor) > 0 ){
				progressModel.writeProcessLog("Ada proses yang belum selesai");
			} else {
				progressModel.writeProcessLog("Semua Task sudah berhenti");
			}
			executor.shutdown();
		}

		if ( objectHolder.getObject() != null )
			throw new SlikException("Error saat dekrip dan dekompress", objectHolder.getObject());

		return result;
	}

	public static void decryptAndDecompress(String compressAlgoritm, String base64Key, InputStream inputStream, OutputStream outputStream, MeteredIOCopyersPararel ioCopyers) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException, CompressorException {
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream(pis);
		ObjectHolder<Throwable> objectHolder = new ObjectHolder<>();

		Thread thread =
			new Thread(
				new Runnable(){
					public void run(){
						try {
							EncryptionUtil.aesEncryption(Cipher.DECRYPT_MODE, base64Key, inputStream, pos, ioCopyers);
						} catch (Throwable t){
							logger.error("Encryption error", t);
							objectHolder.setObject(t);
						} finally {
							IOUtils.closeQuietly(pos);
						}
						logger.debug("decryptAndDecompress Thread finished");
					}
				}
			);
		thread.start();

		CompressionUtilBig.deCompress(compressAlgoritm, pis, outputStream, null);

		IOUtils.closeQuietly(pis);

		if (objectHolder.getObject() != null)
			throw new SlikException("Exception while compression", objectHolder.getObject());
	}

	private static List<FileChunk> chunkFile(long chunkSize, File file){
		List<FileChunk> fileChunks = new ArrayList<FileChunk>();
		long byteOffset = 0;
		int chunkNumber = 0;
		while ( true ) {
			if ( byteOffset + chunkSize >= file.length() ){
				FileChunk fileChunk = new FileChunk(file, byteOffset, file.length() - byteOffset, chunkNumber);
				fileChunks.add(fileChunk);
				break;
			} else {
				FileChunk fileChunk = new FileChunk(file, byteOffset, chunkSize, chunkNumber);
				fileChunks.add(fileChunk);
				byteOffset += chunkSize;
				if ( byteOffset == file.length() )
					break;
			}
			chunkNumber++;
		}
		return fileChunks;
	}

}
