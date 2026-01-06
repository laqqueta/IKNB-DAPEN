package id.go.ojk.lib.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.ar.ArArchiveEntry;
import org.apache.commons.compress.archivers.arj.ArjArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.exception.FileIntegrityException;
import id.go.ojk.lib.client.model.bind.ProgressModel;
import id.go.ojk.lib.client.model.compression.CompressionResult;
import id.go.ojk.lib.client.model.compression.FileIntegrity;
import id.go.ojk.lib.client.model.compression.MemoryFile;
import javafx.application.Platform;

public class CompressionUtil {

	//private static Logger logger = LoggerFactory.getLogger(CompressionUtil.class);

	private final static String archiverName = ArchiveStreamFactory.ZIP;
	
	public static void compress(ProgressModel progressModel, File directory, List<MemoryFile> memoryFiles, File destFile) throws IOException, ArchiveException, NoSuchAlgorithmException{
		try ( FileOutputStream outputStream = new FileOutputStream(destFile)){
			compress(progressModel, directory, memoryFiles, outputStream);
		}
	}
	
	public static void compress(ProgressModel progressModel, File directory, List<MemoryFile> memoryFiles, OutputStream outputStream) throws IOException, ArchiveException, NoSuchAlgorithmException{
		final ProgressModel progressModel2 = progressModel == null ? new ProgressModel("", false) : progressModel;
		if ( progressModel != null ){
			//todo
			progressModel2.setTotalLength(100);
		}
		
		ArchiveOutputStream archive = new ArchiveStreamFactory().createArchiveOutputStream(archiverName, outputStream);

		BufferedOutputStream bos = new BufferedOutputStream(archive, 8000);

		try {
			if ( archive instanceof ZipArchiveOutputStream ){
				((ZipArchiveOutputStream)archive).setUseZip64(Zip64Mode.Always);
			}

			MeteredIOCopyers copyers = new MeteredIOCopyers(
					progressModel2.getTotalLength(),
				new MeteredIOCopyers.PersentageCallBack() {
					@Override
					public void updatePersentage(double persentage) {
						progressModel2.setProgress(persentage);
					}

					@Override
					public boolean isStopProcess() {
						return progressModel2.isStop();
					}
				}
			);
			compress(copyers, "SlikClient", directory, archive);
			
			for (MemoryFile memoryFile : memoryFiles) {
				
				if ( copyers.getPersentageCallBack().isStopProcess() )
					break;

				String entryName =  "SlikClient/" + memoryFile.getName();
				ArchiveEntry entry = new ZipArchiveEntry(entryName);
				archive.putArchiveEntry(entry);

				BufferedInputStream input = null;
				try {
					input = new BufferedInputStream(new ByteArrayInputStream(memoryFile.getContent()));
					copyers.copy(input, archive);
				} finally {
					IOUtils.closeQuietly(input);
				}
				archive.closeArchiveEntry();
			}

			archive.finish();
		} finally {
			IOUtils.closeQuietly(bos);
		}
		
		progressModel2.setProgress(1d);
	}
	
	public static void compress(MeteredIOCopyers copyers, String parentDir, File directory, ArchiveOutputStream archive) throws IOException, ArchiveException, NoSuchAlgorithmException{

		File[] sourceFiles = directory.listFiles();
		
		for (File file : sourceFiles) {
			if ( file.isDirectory() ){
				String baseDir = (StringUtils.isNotEmpty(parentDir) ? parentDir + "/" : "") + file.getName();
				compress(copyers, baseDir, file, archive);
				continue;
			}
			
			if ( copyers.getPersentageCallBack().isStopProcess() )
				break;

			String entryName = file.getName();
			if (StringUtils.isNotEmpty(parentDir)){
				entryName = parentDir + "/" + entryName;
			}
			ArchiveEntry entry = new ZipArchiveEntry(entryName);
			archive.putArchiveEntry(entry);

			BufferedInputStream input = null;
			try {
				input = new BufferedInputStream(new FileInputStream(file));
				copyers.copy(input, archive);
			} finally {
				IOUtils.closeQuietly(input);
			}
			archive.closeArchiveEntry();
		}
	}

	public static void compress(List<File> sourceFiles, File destFile) throws IOException, ArchiveException, NoSuchAlgorithmException{
		try (FileOutputStream outputStream = new FileOutputStream(destFile)){
			List<FileIntegrity> fileIntegrities = sourceFiles.stream().map( e -> new FileIntegrity(e, null)).collect(Collectors.toList());
			compress(null, fileIntegrities, outputStream);
		}
	}

	public static void compress(ProgressModel progressModel, List<FileIntegrity> sourceFiles, OutputStream outputStream) throws IOException, ArchiveException, NoSuchAlgorithmException{
		final ProgressModel progressModel2 = progressModel == null ? new ProgressModel("", false) : progressModel;
		if ( progressModel != null ){
			progressModel2.setTotalLength(sourceFiles.stream().mapToLong(e -> e.getLength()).sum());
		}

		zip(progressModel2, sourceFiles, outputStream);
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

	public static void compressInMemory(ProgressModel progressModel, List<MemoryFile> memoryFiles, OutputStream outputStream) throws IOException, ArchiveException, NoSuchAlgorithmException{
		final ProgressModel progressModel2 = progressModel == null ? new ProgressModel("", false) : progressModel;
		if ( progressModel != null ){
			progressModel2.setTotalLength(memoryFiles.stream().mapToLong(e -> e.getContent().length).sum());
		}

		zipMemory(progressModel2, memoryFiles, outputStream);
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

	public static CompressionResult compress(ProgressModel progressModel, long splitFileSize, List<FileIntegrity> sourceFiles, File destFile) throws IOException, ArchiveException, NoSuchAlgorithmException{
		final ProgressModel progressModel2 = progressModel == null ? new ProgressModel("", false) : progressModel;
		if ( progressModel != null ){
			progressModel2.setTotalLength(sourceFiles.stream().mapToLong(e -> e.getLength()).sum());
		}

		destFile.getParentFile().mkdir();
		SplitOutputStream splitOutputStream = null;

		try {
			splitOutputStream = new SplitOutputStream(progressModel2, destFile, splitFileSize);
			compress(progressModel2, sourceFiles, splitOutputStream);
	    	progressModel2.setProgress(1d);

	    	CompressionResult compressionResult = new CompressionResult();
			return compressionResult;
		} finally {
			IOUtils.closeQuietly(splitOutputStream);
		}
	}

	private static void zip(ProgressModel progressModel, List<FileIntegrity> sourceFiles, OutputStream os) throws IOException, ArchiveException, NoSuchAlgorithmException {
		ArchiveOutputStream archive = new ArchiveStreamFactory().createArchiveOutputStream(archiverName, os);

		BufferedOutputStream bos = new BufferedOutputStream(archive, 8000);

		try {
			if ( archive instanceof ZipArchiveOutputStream ){
				((ZipArchiveOutputStream)archive).setUseZip64(Zip64Mode.Always);
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
					entryName = counter + "";
				}

				progressModel.writeProcessLog(StringUtils.join("Kompresi - file sumber ", entryName), false);

				ArchiveEntry entry = null;
				if ( archiverName.equals(ArchiveStreamFactory.AR)){
					entry = new ArArchiveEntry(entryName, sourceFile.getFile().length());
				} else if (archiverName.equals(ArchiveStreamFactory.ARJ)){
					entry = new ArjArchiveEntry();
				} else if (archiverName.equals(ArchiveStreamFactory.TAR)){
					entry = new TarArchiveEntry(entryName);
				} else if (archiverName.equals(ArchiveStreamFactory.JAR)){
					entry = new JarArchiveEntry(entryName);
				} else if (archiverName.equals(ArchiveStreamFactory.CPIO)){
					entry = new CpioArchiveEntry(entryName);
				} else if (archiverName.equals(ArchiveStreamFactory.SEVEN_Z)){
					entry = new SevenZArchiveEntry();
					((SevenZArchiveEntry)entry).setName(entryName);
				} else {
					//ZipArchiveEntry entry = new ZipArchiveEntry(entryName);
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
						if ( StringUtils.isNotEmpty(sourceFile.getChecksum()) && !checkSum.equals(sourceFile.getChecksum()) ){
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
			IOUtils.closeQuietly(bos);
		}
	}

	private static void zipMemory(ProgressModel progressModel, List<MemoryFile> sourceFiles, OutputStream os) throws IOException, ArchiveException, NoSuchAlgorithmException {
		ArchiveOutputStream archive = new ArchiveStreamFactory().createArchiveOutputStream(archiverName, os);

		BufferedOutputStream bos = new BufferedOutputStream(archive, 8000);

		try {
			if ( archive instanceof ZipArchiveOutputStream ){
				((ZipArchiveOutputStream)archive).setUseZip64(Zip64Mode.Always);
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
			for (MemoryFile memoryFile : sourceFiles) {
				if ( progressModel.isStop() )
					break;

				counter++;
				String entryName = memoryFile.getName();
				if ( archiverName.equals(ArchiveStreamFactory.AR)){
					entryName = counter + "";
				}

				progressModel.writeProcessLog(StringUtils.join("Kompresi - file sumber ", entryName), false);

				ArchiveEntry entry = null;
				if ( archiverName.equals(ArchiveStreamFactory.AR)){
					entry = new ArArchiveEntry(entryName, memoryFile.getContent().length);
				} else if (archiverName.equals(ArchiveStreamFactory.ARJ)){
					entry = new ArjArchiveEntry();
				} else if (archiverName.equals(ArchiveStreamFactory.TAR)){
					entry = new TarArchiveEntry(entryName);
				} else if (archiverName.equals(ArchiveStreamFactory.JAR)){
					entry = new JarArchiveEntry(entryName);
				} else if (archiverName.equals(ArchiveStreamFactory.CPIO)){
					entry = new CpioArchiveEntry(entryName);
				} else if (archiverName.equals(ArchiveStreamFactory.SEVEN_Z)){
					entry = new SevenZArchiveEntry();
					((SevenZArchiveEntry)entry).setName(entryName);
				} else {
					//ZipArchiveEntry entry = new ZipArchiveEntry(entryName);
					entry = new ZipArchiveEntry(entryName);
				}

				archive.putArchiveEntry(entry);

				BufferedInputStream input = null;
				try {
					input = new BufferedInputStream(new ByteArrayInputStream(memoryFile.getContent()));
					copyers.copy(input, archive);
				} finally {
					IOUtils.closeQuietly(input);
				}
				archive.closeArchiveEntry();

				progressModel.writeProcessLog(StringUtils.join("Kompresi - file ", entryName, "selesai"), false);
			}

			archive.finish();
		} finally {
			IOUtils.closeQuietly(bos);
		}
	}

	public static List<FileIntegrity> decompressAndChecksum(InputStream inputStream, File destDir, boolean calculateCheckSum) throws FileNotFoundException, ArchiveException, IOException, NoSuchAlgorithmException {
		destDir.mkdirs();
		List<FileIntegrity> result = new ArrayList<FileIntegrity>();

		ArchiveInputStream ais = null;
		try {
			ais = new ArchiveStreamFactory().createArchiveInputStream(archiverName, inputStream);
			ZipArchiveEntry entry = (ZipArchiveEntry) ais.getNextEntry();
			while (entry != null) {
				File outputFile = new File(destDir.getAbsolutePath(), entry.getName());
				OutputStream outputStream = null;
				try {
					if ( calculateCheckSum ) {
						outputStream = new DigestOutputStream(new FileOutputStream(outputFile));
					} else {
						outputStream = new FileOutputStream(outputFile);
					}
					IOUtils.copy(ais, outputStream);
				} finally {
					outputStream.close();
				}
				String checksum = null;
				if ( calculateCheckSum ) {
					checksum = ((DigestOutputStream)outputStream).getChecksum();
				}
				result.add(new FileIntegrity(outputFile, checksum));
				entry = (ZipArchiveEntry) ais.getNextEntry();
			}
		} finally{
//			ais.close();
		}
		return result;
	}

	public static List<File> decompress(File inputFile, File destDir) throws FileNotFoundException, ArchiveException, IOException {
		try ( FileInputStream inputStream = new FileInputStream(inputFile)){
			return decompress(inputStream, destDir);
		}
	}
	
	public static Map<String, File> decompressToMap(File inputFile, File destDir) throws FileNotFoundException, ArchiveException, IOException {
		Map<String, File> map = new TreeMap<>();
		List<File> files = decompress(inputFile, destDir);
		for (File file : files) {
			map.put(file.getName(), file);
		}
		return map;
	}

	public static List<File> decompress(InputStream inputStream, File destDir) throws FileNotFoundException, ArchiveException, IOException {
		destDir.mkdirs();
		List<File> archiveContents = new ArrayList<File>();

		ArchiveInputStream ais = null;
		try {
			ais = new ArchiveStreamFactory().createArchiveInputStream(archiverName, inputStream);
			ArchiveEntry entry =  ais.getNextEntry();
			while (entry != null) {
				File outputFile = new File(destDir.getAbsolutePath(), entry.getName());
				try (OutputStream outputStream = new FileOutputStream(outputFile)){
					IOUtils.copy(ais, outputStream);
				}
				archiveContents.add(outputFile);
				entry = ais.getNextEntry();
			}
		} finally{
			ais.close();
		}
		return archiveContents;
	}

	public static List<MemoryFile> decompressToMemory(InputStream inputStream) throws FileNotFoundException, ArchiveException, IOException {
		List<MemoryFile> archiveContents = new ArrayList<MemoryFile>();

		ArchiveInputStream ais = null;
		try {
			ais = new ArchiveStreamFactory().createArchiveInputStream(archiverName, inputStream);
			ZipArchiveEntry entry = (ZipArchiveEntry) ais.getNextEntry();
			while (entry != null) {
				ByteArrayOutputStream outputStream = null;
				try {
					outputStream = new ByteArrayOutputStream();
					IOUtils.copy(ais, outputStream);
				} finally {
					outputStream.close();
				}
				archiveContents.add(
					new MemoryFile(entry.getName(), outputStream.toByteArray())
				);
				entry = (ZipArchiveEntry) ais.getNextEntry();
			}
		} finally {
			ais.close();
		}
		return archiveContents;
	}
	
	public static void zip(List<File> sourceFiles, OutputStream os) throws ArchiveException, IOException {
		ArchiveOutputStream archive = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP, os);

		BufferedOutputStream bos = new BufferedOutputStream(archive, 8000);

		try {
			if ( archive instanceof ZipArchiveOutputStream ){
				((ZipArchiveOutputStream)archive).setUseZip64(Zip64Mode.Always);
			}

			for (File sourceFile : sourceFiles) {

				String entryName = sourceFile.getName();
				ArchiveEntry entry = new ZipArchiveEntry(entryName);
				archive.putArchiveEntry(entry);

				BufferedInputStream input = null;
				try {
					input = new BufferedInputStream(new FileInputStream(sourceFile));
					IOUtils.copy(input, archive);
				} finally {
					IOUtils.closeQuietly(input);
				}
				archive.closeArchiveEntry();
			}

			archive.finish();
		} finally {
			IOUtils.closeQuietly(bos);
		}
	}

}
