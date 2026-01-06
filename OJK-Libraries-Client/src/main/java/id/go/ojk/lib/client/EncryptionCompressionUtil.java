package id.go.ojk.lib.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.crypto.Cipher;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.lib.client.MeteredIOCopyers.PersentageCallBack;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.ObjectHolder;
import id.go.ojk.lib.client.model.bind.ProgressModel;
import id.go.ojk.lib.client.model.compression.FileIntegrity;
import id.go.ojk.lib.client.model.compression.MemoryFile;
import id.go.ojk.lib.client.model.encryption.EncryptionResult;

public class EncryptionCompressionUtil {

	private static Logger logger = LoggerFactory.getLogger(EncryptionCompressionUtil.class);

	public static EncryptionResult compressAndEncrypt(ProgressModel progressModel, long splitFileSize, String base64Key, List<FileIntegrity> fileIntegrities, File destFile) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException {
		logger.debug("start compressAndEncrypt");
		EncryptionResult encryptionResult = new EncryptionResult();
		encryptionResult.setEncryptionDir(destFile.getParentFile());
		encryptionResult.setAesKey(base64Key);

		destFile.getParentFile().mkdirs();

		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream(pis);
		ObjectHolder<Throwable> objectHolder = new ObjectHolder<>();

		SplitOutputStream splitOutputStream = null;
		DigestOutputStream digestOutputStream = null;

		try {

			splitOutputStream = new SplitOutputStream(progressModel, destFile, splitFileSize);
			digestOutputStream = new DigestOutputStream(splitOutputStream);

			Thread thread =
				new Thread(
					new Runnable(){
						public void run(){
							try {
								CompressionUtil.compress(progressModel, fileIntegrities, pos );
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

			EncryptionUtil.aesEncryption(Cipher.ENCRYPT_MODE, base64Key, pis, digestOutputStream, (MeteredIOCopyers)null);
			IOUtils.closeQuietly(pis);
			
			for(int i=0; i<1000; i++){
				if ( !thread.isAlive() ){
					logger.debug("Compression Thread detected finish");
					break;
				}
				ThreadUtil.sleep(1000);
			}
			if (objectHolder.getObject() != null)
				throw new SlikException("Exception while compression", objectHolder.getObject());

			encryptionResult.setHash(digestOutputStream.getChecksum());
			encryptionResult.setEncResultFiles(splitOutputStream.getFileIntegrities());

			logger.debug("end compressAndEncrypt");
		} finally {
			IOUtils.closeQuietly(splitOutputStream);
			IOUtils.closeQuietly(digestOutputStream);
		}

		return encryptionResult;
	}

	public static List<MemoryFile> decryptAndDecompressToMemory(String base64Key, List<File> sourceFiles, ProgressModel model) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException {
		logger.debug("start DecryptAndExtract");
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream(pis);
		ObjectHolder<Throwable> objectHolder = new ObjectHolder<>();

		final ProgressModel progressModel = model == null ? new ProgressModel("", false) : model;
		if ( model == null ){
			progressModel.setTotalLength( sourceFiles.stream().mapToLong( e -> e.length()).sum());
		}

		PersentageCallBack persentageCallBack = new PersentageCallBack() {
			@Override
			public void updatePersentage(double persentage) {
				progressModel.setProgress(persentage);
			}

			@Override
			public boolean isStopProcess() {
				return progressModel.isOnProcess();
			}
		};

		MeteredIOCopyers meteredIOCopyers = new MeteredIOCopyers(
			progressModel.getTotalLength(),
			persentageCallBack
		);

		Thread thread =
			new Thread(
				new Runnable(){
					public void run(){
						try {
							EncryptionUtil.aesEncryption(Cipher.DECRYPT_MODE, base64Key, sourceFiles, pos, meteredIOCopyers);
						} catch (Throwable t){
							logger.error("Encryption error", t);
							objectHolder.setObject(t);
						} finally {
							IOUtils.closeQuietly(pos);
						}
						logger.debug("decryptAndDecompressToMemory Thread finished");
					}
				}
			);
		thread.start();
		List<MemoryFile> result = CompressionUtil.decompressToMemory(pis);
		IOUtils.closeQuietly(pis);
		for(int i=0; i<1000; i++){
			if ( !thread.isAlive() ){
				logger.debug("Encryption Thread detected finish");
				break;
			}
			ThreadUtil.sleep(1000);
		}
		if (objectHolder.getObject() != null)
			throw new SlikException("Exception while encryption", objectHolder.getObject());

		logger.debug("end DecryptAndExtract");
		return result;
	}
	
	
	public static List<MemoryFile> decryptAndDecompressToMemory(String base64Key, byte[] inputBytes, ProgressModel model) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException {
		logger.debug("start DecryptAndExtract");
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream(pis);
		ObjectHolder<Throwable> objectHolder = new ObjectHolder<>();

		final ProgressModel progressModel = model == null ? new ProgressModel("", false) : model;
		if ( model == null ){
			progressModel.setTotalLength(inputBytes.length);
		}

		PersentageCallBack persentageCallBack = new PersentageCallBack() {
			@Override
			public void updatePersentage(double persentage) {
				progressModel.setProgress(persentage);
			}

			@Override
			public boolean isStopProcess() {
				return progressModel.isOnProcess();
			}
		};

		MeteredIOCopyers meteredIOCopyers = new MeteredIOCopyers(
			progressModel.getTotalLength(),
			persentageCallBack
		);

		Thread thread =
			new Thread(
				new Runnable(){
					public void run(){
						try ( ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes) ){
							EncryptionUtil.aesEncryption(Cipher.DECRYPT_MODE, base64Key, inputStream, pos, meteredIOCopyers);
							//EncryptionUtil.aesEncryption(Cipher.DECRYPT_MODE, base64Key, sourceFiles, pos, meteredIOCopyers);
						} catch (Throwable t){
							logger.error("Encryption error", t);
							objectHolder.setObject(t);
						} finally {
							IOUtils.closeQuietly(pos);
						}
						logger.debug("decryptAndDecompressToMemory Thread finished");
					}
				}
			);
		thread.start();
		List<MemoryFile> result = CompressionUtil.decompressToMemory(pis);
		IOUtils.closeQuietly(pis);
		for(int i=0; i<1000; i++){
			if ( !thread.isAlive() ){
				logger.debug("Encryption Thread detected finish");
				break;
			}
			ThreadUtil.sleep(1000);
		}
		if (objectHolder.getObject() != null)
			throw new SlikException("Exception while encryption", objectHolder.getObject());

		logger.debug("end DecryptAndExtract");
		return result;
	}

	public static List<FileIntegrity> decryptAndDecompress(String base64Key, List<File> sourceFiles, File destDir, ProgressModel model) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException {
		logger.debug("start DecryptAndExtract");
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream(pis);
		ObjectHolder<Throwable> objectHolder = new ObjectHolder<>();

		PersentageCallBack persentageCallBack = new PersentageCallBack() {
			@Override
			public void updatePersentage(double persentage) {
				model.setProgress(persentage);
			}

			@Override
			public boolean isStopProcess() {
				return model.isOnProcess();
			}
		};

		MeteredIOCopyers meteredIOCopyers = new MeteredIOCopyers(
			model.getTotalLength(),
			persentageCallBack
		);

		Thread thread =
			new Thread(
				new Runnable(){
					public void run(){
						try {
							EncryptionUtil.aesEncryption(Cipher.DECRYPT_MODE, base64Key, sourceFiles, pos, meteredIOCopyers);
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
		List<FileIntegrity> result = CompressionUtil.decompressAndChecksum(pis, destDir, true);
		IOUtils.closeQuietly(pis);
		for(int i=0; i<1000; i++){
			if ( !thread.isAlive() ){
				logger.debug("Encryption Thread detected finish");
				break;
			}
			ThreadUtil.sleep(1000);
		}
		if (objectHolder.getObject() != null)
			throw new SlikException("Exception while encryption", objectHolder.getObject());

		logger.debug("end DecryptAndExtract");

		return result;
	}

	public static void compressAndEncrypt(String base64Key, File sourceDir, File destFile) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException {
		logger.debug("start compressAndEncrypt");
		destFile.getParentFile().mkdirs();

		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream(pis);
		ObjectHolder<Throwable> objectHolder = new ObjectHolder<>();

		OutputStream outputStream = null;

		try {
			outputStream = new FileOutputStream(destFile);

			Thread thread =
					new Thread(
						new Runnable(){
							public void run(){
								try {
									CompressionUtil.compress(
											null,
											Arrays.asList(sourceDir.listFiles()).stream().map(e -> new FileIntegrity(e, null)).collect(Collectors.toList()),
											pos
									);
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
				EncryptionUtil.aesEncryption(Cipher.ENCRYPT_MODE, base64Key, pis, outputStream, (MeteredIOCopyers)null);

				for(int i=0; i<1000; i++){
					if ( !thread.isAlive() ){
						logger.debug("Compression Thread detected finish");
						break;
					}
					ThreadUtil.sleep(1000);
				}
				if (objectHolder.getObject() != null)
					throw new SlikException("Exception while compression", objectHolder.getObject());

				logger.debug("end compressAndEncrypt");

		} finally {
			IOUtils.closeQuietly(outputStream);
		}
	}

	public static byte[] compressAndEncrypt(String base64Key, List<MemoryFile> memoryFiles) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		compressAndEncrypt(base64Key, memoryFiles, outputStream);
		return outputStream.toByteArray();
	}

	public static void compressAndEncrypt(String base64Key, List<MemoryFile> memoryFiles, File destFile) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException {
		destFile.getParentFile().mkdirs();
		try( FileOutputStream outputStream = new FileOutputStream(destFile) ){
			compressAndEncrypt(base64Key, memoryFiles, outputStream);
		}
	}

	public static void compressAndEncrypt(String base64Key, List<MemoryFile> memoryFiles, OutputStream outputStream) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException {
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream(pis);
		ObjectHolder<Throwable> objectHolder = new ObjectHolder<>();

		Thread thread =
				new Thread(
					new Runnable(){
						public void run(){
							try {
								CompressionUtil.compressInMemory(null, memoryFiles, pos);
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
		EncryptionUtil.aesEncryption(Cipher.ENCRYPT_MODE, base64Key, pis, outputStream, (MeteredIOCopyers)null);
		if (objectHolder.getObject() != null) {
			throw new SlikException("Exception while compression", objectHolder.getObject());
		}
	}

	public static Map<String, MemoryFile> decryptAndDecompressToMemoryMap(String base64Key, File sourceFile) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException {
		List<MemoryFile> memoryFiles = decryptAndDecompressToMemory(base64Key, Arrays.asList(sourceFile), null);
		Map<String, MemoryFile> result = new HashMap<String, MemoryFile>();
		for (MemoryFile memoryFile : memoryFiles) {
			result.put(memoryFile.getName(), memoryFile);
		}
		return result;
	}

	public static Map<String, MemoryFile> decryptAndDecompressToMemoryMap(String base64Key, byte[] inputBytes) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException {
		List<MemoryFile> memoryFiles = decryptAndDecompressToMemory(base64Key, inputBytes, null);
		Map<String, MemoryFile> result = new HashMap<String, MemoryFile>();
		for (MemoryFile memoryFile : memoryFiles) {
			result.put(memoryFile.getName(), memoryFile);
		}
		return result;
	}

}
