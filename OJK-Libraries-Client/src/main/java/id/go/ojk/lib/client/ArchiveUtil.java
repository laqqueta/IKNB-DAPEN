package id.go.ojk.lib.client;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.ar.ArArchiveEntry;
import org.apache.commons.compress.archivers.ar.ArArchiveInputStream;
import org.apache.commons.compress.archivers.ar.ArArchiveOutputStream;
import org.apache.commons.compress.archivers.arj.ArjArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.dump.DumpArchiveEntry;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.lib.client.exception.FileIntegrityException;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.ObjectHolder;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.bind.ProgressModel;
import id.go.ojk.lib.client.model.compression.ArchiveResult;
import id.go.ojk.lib.client.model.compression.FileIntegrity;
import javafx.application.Platform;

public class ArchiveUtil {
	private static Logger logger = LoggerFactory.getLogger(ArchiveUtil.class);

	private final static String archiverName = ArchiveStreamFactory.TAR;

	public static void archive(ProgressModel progressModel, List<FileIntegrity> sourceFiles, OutputStream outputStream) throws IOException, ArchiveException, NoSuchAlgorithmException{
		final ProgressModel progressModel2 = progressModel == null ? new ProgressModel("", false) : progressModel;
		if ( progressModel != null ){
			progressModel2.setTotalLength(sourceFiles.stream().mapToLong(e -> e.getLength()).sum());
		}

		archiveReal(progressModel2, sourceFiles, outputStream);
		if ( progressModel2.isRunInJavaFx() ) {
			Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
			    	progressModel2.setProgress(1d);
			    }
			});
		} else {
			progressModel2.setProgress(1d);
		}
	}

	public static ArchiveResult archive(ProgressModel progressModel, long splitFileSize, List<FileIntegrity> sourceFiles, File destFile) throws IOException, ArchiveException, NoSuchAlgorithmException{
		final ProgressModel progressModel2 = progressModel == null ? new ProgressModel("", false) : progressModel;
		if ( progressModel != null ){
			progressModel2.setTotalLength(sourceFiles.stream().mapToLong(e -> e.getLength()).sum());
		}

		destFile.getParentFile().mkdir();
		SplitOutputStream splitOutputStream = null;
		try {
			splitOutputStream = new SplitOutputStream(progressModel2, destFile, splitFileSize);
			splitOutputStream.setMessageDigest(MessageDigest.getInstance("SHA-1"));
			archive(progressModel2, sourceFiles, splitOutputStream);
	    	progressModel2.setProgress(1d);

	    	ArchiveResult compressionResult = new ArchiveResult();
	    	compressionResult.setFileIntegrities(splitOutputStream.getFileIntegrities());
	    	compressionResult.setHash(EncryptionUtil.getChecksum(splitOutputStream.getMessageDigest()));
			return compressionResult;
		} finally {
			IOUtils.closeQuietly(splitOutputStream);
		}
	}

	private static void archiveReal(ProgressModel progressModel, List<FileIntegrity> sourceFiles, OutputStream os) throws IOException, ArchiveException, NoSuchAlgorithmException {
		ArchiveOutputStream archive = new ArchiveStreamFactory().createArchiveOutputStream(archiverName, os);
//		for (FileIntegrity fileIntegrity : sourceFiles) {
//			System.out.println( fileIntegrity.getFile().getName() );
//		}

		try {
			if ( archive instanceof ZipArchiveOutputStream ){
				((ZipArchiveOutputStream)archive).setUseZip64(Zip64Mode.Always);
			} else if ( archive instanceof ArArchiveOutputStream ){
				((ArArchiveOutputStream)archive).setLongFileMode(ArArchiveOutputStream.LONGFILE_BSD);
			}


			MeteredIOCopyers copyers = new MeteredIOCopyers(
				progressModel.getTotalLength(),
				new MeteredIOCopyers.PersentageCallBack() {
					@Override
					public void updatePersentage(double persentage) {
						progressModel.setProgress(persentage);
					}

					@Override
					public boolean isStopProcess() {
						return progressModel.isStop();
					}
				}
			);

			int counter = 0;
			for (FileIntegrity sourceFile : sourceFiles) {
				if ( progressModel.isStop() )
					break;

				counter++;
				String entryName = sourceFile.getFile().getName();
				if ( archiverName.equals(ArchiveStreamFactory.AR)){
					entryName = "0101.000008" + counter + "";
				}

				progressModel.writeProcessLog(StringUtils.join("Kompresi - file sumber ", entryName), false);

				ArchiveEntry entry = null;
				if ( archiverName.equals(ArchiveStreamFactory.AR)){
					entry = new ArArchiveEntry(entryName, sourceFile.getFile().length());
				} else if (archiverName.equals(ArchiveStreamFactory.ARJ)){
					entry = new ArjArchiveEntry();
				} else if (archiverName.equals(ArchiveStreamFactory.TAR)){
					entry = new TarArchiveEntry(entryName);
					((TarArchiveEntry)entry).setSize(sourceFile.getFile().length());
				} else if (archiverName.equals(ArchiveStreamFactory.JAR)){
					entry = new JarArchiveEntry(entryName);
				} else if (archiverName.equals(ArchiveStreamFactory.CPIO)){
					entry = new CpioArchiveEntry(entryName);
				} else if (archiverName.equals(ArchiveStreamFactory.SEVEN_Z)){
					entry = new SevenZArchiveEntry();
					((SevenZArchiveEntry)entry).setName(entryName);
				} else if (archiverName.equals(ArchiveStreamFactory.DUMP)){
					entry = new DumpArchiveEntry(entryName, entryName);
				} else {
					entry = new ZipArchiveEntry(entryName);
				}


				archive.putArchiveEntry(entry);

				BufferedInputStream input = null;
				try {
					if ( sourceFile.getFile().length() != sourceFile.getLength()){
						throw new FileIntegrityException("Ukuran file " + sourceFile.getFile().getAbsolutePath() + " berubah ", null);
					}

					input = new BufferedInputStream(new FileInputStream(sourceFile.getFile()));

					if ( sourceFile.getChecksum() != null ){
						MessageDigest shaDigest = MessageDigest.getInstance("SHA-1");
						copyers.setMessageDigest(shaDigest);
						copyers.copy(input, archive);

						String checkSum = EncryptionUtil.getChecksum(shaDigest);
						if ( !checkSum.equals(sourceFile.getChecksum()) ){
							throw new FileIntegrityException("checksum file " + sourceFile.getFile().getAbsolutePath() + " berubah ", null);
						}
					} else {
						copyers.copy(input, archive);
					}

				} finally {
					IOUtils.closeQuietly(input);
				}
				archive.closeArchiveEntry();

				progressModel.writeProcessLog(StringUtils.join("Kompresi - file ", entryName, "selesai"), false);
			}

			archive.finish();
		} finally {
		}
	}

	public static ArchiveResult deArchiveAndChecksum(List<FileIntegrity> sourceFileIntegrities, File destDir) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException {
		destDir.mkdirs();
		List<FileIntegrity> fileIntegrities = new ArrayList<FileIntegrity>();
		ArchiveResult archiveResult = new ArchiveResult();

		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream(pis);
		ObjectHolder<Throwable> objectHolder = new ObjectHolder<>();

		MeteredIOCopyersPararel ioCopyers = new MeteredIOCopyersPararel(new MeteredIOCopyersPararel.EmptyPersentageCallBack());
		MessageDigest shaDigest = MessageDigest.getInstance("SHA-1");
		ioCopyers.setMessageDigest(shaDigest);

		ArchiveInputStream ais = null;
		try {
			Thread thread =
				new Thread(
					new Runnable(){
						public void run(){
							try {
								for (FileIntegrity fileIntegrity : sourceFileIntegrities) {
									try ( FileInputStream fis = new FileInputStream(fileIntegrity.getFile()) ){
										ioCopyers.copy(fis, pos);
									}
								}
							} catch (Throwable t){
								logger.error("Encryption error", t);
								objectHolder.setObject(t);
							} finally {
								IOUtils.closeQuietly(pos);
							}
							logger.debug("deArchiveAndChecksum Thread finished");
						}
					}
				);
			thread.start();

			ais = new ArchiveStreamFactory().createArchiveInputStream(archiverName, pis);
			ArchiveEntry entry =  ais.getNextEntry();
			while (entry != null) {
				File outputFile = new File(destDir.getAbsolutePath(), entry.getName());
				OutputStream outputStream = null;
				try {
					outputStream = new FileOutputStream(outputFile);
					IOUtils.copy(ais, outputStream);
				} finally {
					outputStream.close();
				}
				fileIntegrities.add(new FileIntegrity(outputFile, null));
				entry = ais.getNextEntry();
			}
		} finally{
			ais.close();
		}
		archiveResult.setHash(EncryptionUtil.getChecksum(shaDigest));
		archiveResult.setFileIntegrities(fileIntegrities);

		return archiveResult;
	}

	public static ArchiveResult deArchiveChecksumDecryptDecompress(List<FileIntegrity> sourceFileIntegrities, String aesKey, File destDir) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException, CompressorException {
		destDir.mkdirs();
		List<FileIntegrity> fileIntegrities = new ArrayList<FileIntegrity>();
		ArchiveResult archiveResult = new ArchiveResult();

		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream(pis);
		ObjectHolder<Throwable> objectHolder = new ObjectHolder<>();

		MeteredIOCopyersPararel ioCopyers = new MeteredIOCopyersPararel(new MeteredIOCopyersPararel.EmptyPersentageCallBack());
		MessageDigest shaDigest = MessageDigest.getInstance("SHA-1");
		ioCopyers.setMessageDigest(shaDigest);

		ArchiveInputStream ais = null;
		try {
			Thread thread =
				new Thread(
					new Runnable(){
						public void run(){
							try {
								for (FileIntegrity fileIntegrity : sourceFileIntegrities) {
									try ( FileInputStream fis = new FileInputStream(fileIntegrity.getFile()) ){
										ioCopyers.copy(fis, pos);
									}
								}
							} catch (Throwable t){
								logger.error("Encryption error", t);
								objectHolder.setObject(t);
							} finally {
								IOUtils.closeQuietly(pos);
							}
							logger.debug("deArchiveChecksumDecryptDecompress Thread finished");
						}
					}
				);
			thread.start();

			ais = new ArchiveStreamFactory().createArchiveInputStream(archiverName, pis);

			ArchiveEntry entry =  ais.getNextEntry();
			
			//List<String> destFileNameList = new ArrayList<>();
			
			Map<String, Tupple2<File, DigestOutputStream>> destFileMap = new LinkedHashMap<>();
			
			while (entry != null) {
				String fileName = FilenameUtils.getBaseName(entry.getName());
				boolean createNewFile = false;
				
				Tupple2<File, DigestOutputStream> tupple2 = null;
				if ( !destFileMap.containsKey(fileName) ){
					createNewFile = true;
					tupple2 = Tupple2.<File, DigestOutputStream>builder()
							.a(new File(destDir.getAbsolutePath(), fileName))
							.b(new DigestOutputStream(null))
							.build();
					destFileMap.put(fileName, tupple2);
				} else {
					tupple2 = destFileMap.get(fileName);
				}
				
//				File outputFile = new File(destDir.getAbsolutePath(), fileName);
				OutputStream outputStream = null;
				try {
					outputStream = new FileOutputStream(tupple2.getA(), !createNewFile);
					DigestOutputStream digestOutputStream = tupple2.getB();
					digestOutputStream.setOut(outputStream);
					
					EncryptionCompressionUtilBig.decryptAndDecompress(CompressionUtilBig.GZIP, aesKey, ais, digestOutputStream, null);
				} finally {
					IOUtils.closeQuietly(outputStream);
				}
//				if ( createNewFile ){
//					fileIntegrities.add(new FileIntegrity(outputFile, digestOutputStream.getChecksum()));					
//				}
				entry = ais.getNextEntry();
			}
			
			for (Entry<String, Tupple2<File, DigestOutputStream>> entry2 : destFileMap.entrySet()) {
				Tupple2<File, DigestOutputStream> tupple2 = entry2.getValue();
				fileIntegrities.add(new FileIntegrity(tupple2.getA(), tupple2.getB().getChecksum()));
				IOUtils.closeQuietly(tupple2.getB());
			}
		} finally{
			IOUtils.closeQuietly(ais);
		}
		
		if ( objectHolder.getObject() != null )
			throw new SlikException("", objectHolder.getObject());
		
		archiveResult.setHash(EncryptionUtil.getChecksum(shaDigest));
		archiveResult.setFileIntegrities(fileIntegrities);

		return archiveResult;
	}

	public static ArchiveResult deArchive(ProgressModel progressModel, List<FileIntegrity> sourceFileIntegrities, File destDir) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException, CompressorException {
		destDir.mkdirs();
		List<FileIntegrity> fileIntegrities = new ArrayList<FileIntegrity>();
		ArchiveResult archiveResult = new ArchiveResult();

		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream(pis);
		ObjectHolder<Throwable> objectHolder = new ObjectHolder<>();

		MeteredIOCopyersPararel tmpIoCopyers = null;
		if ( progressModel == null ){
			tmpIoCopyers = new MeteredIOCopyersPararel(new MeteredIOCopyersPararel.EmptyPersentageCallBack());
		} else {
			progressModel.setTotalLength(sourceFileIntegrities.stream().mapToLong( e -> e.getLength()).sum() );
			tmpIoCopyers = new MeteredIOCopyersPararel(new MeteredIOCopyersPararel.PersentageCallBack() {

				@Override
				public boolean isStopProcess() {
					return progressModel.isStop();
				}

				@Override
				public void addProgress(long byteLong) {
					progressModel.addProgress(byteLong);
				}
			});
		}
		final MeteredIOCopyersPararel ioCopyers = tmpIoCopyers;
		MessageDigest shaDigest = MessageDigest.getInstance("SHA-1");
		ioCopyers.setMessageDigest(shaDigest);

		ArchiveInputStream ais = null;
		try {
			Thread thread =
				new Thread(
					new Runnable(){
						public void run(){
							try {
								for (FileIntegrity fileIntegrity : sourceFileIntegrities) {
									progressModel.writeProcessLog("Dearchive - " + fileIntegrity.getFile().getName(), false);
									try ( FileInputStream fis = new FileInputStream(fileIntegrity.getFile()) ){
										ioCopyers.copy(fis, pos);
									}
									progressModel.writeProcessLog("Dearchive - " + fileIntegrity.getFile().getName() + " - selesai", false);
								}
							} catch (Throwable t){
								logger.error("Encryption error", t);
								objectHolder.setObject(t);
							} finally {
								IOUtils.closeQuietly(pos);
							}
							logger.debug("deArchive Thread finished");
						}
					}
				);
			thread.start();

			ais = new ArchiveStreamFactory().createArchiveInputStream(archiverName, pis);
			ArchiveEntry entry =  ais.getNextEntry();
			while (entry != null) {
				File outputFile = new File(destDir.getAbsolutePath(), entry.getName());
				OutputStream outputStream = null;
				try {
					outputStream = new FileOutputStream(outputFile);
					IOUtils.copy(ais, outputStream);
				} finally {
					IOUtils.closeQuietly(outputStream);
				}
				fileIntegrities.add(new FileIntegrity(outputFile, null));
				entry = ais.getNextEntry();
			}
		} finally{
			IOUtils.closeQuietly(ais);
		}
		archiveResult.setHash(EncryptionUtil.getChecksum(shaDigest));
		archiveResult.setFileIntegrities(fileIntegrities);

		return archiveResult;
	}

	public static List<File> toFiles(List<FileIntegrity> fileIntegrities){
		List<File> files = new ArrayList<>();
		for (FileIntegrity fileIntegrity : fileIntegrities) {
			files.add(fileIntegrity.getFile());
		}
		return files;
	}

	public static List<FileIntegrity> toFileIntegrities(List<File> files){
		List<FileIntegrity> fileIntegrities = new ArrayList<>();
		for (File file : files) {
			fileIntegrities.add(new FileIntegrity(file, null));
		}
		return fileIntegrities;
	}
	
	public void compressEncryptArchive(String base64Key, List<File> files, File destDir) {
		
	}

}
