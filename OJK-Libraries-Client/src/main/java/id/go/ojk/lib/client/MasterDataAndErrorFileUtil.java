package id.go.ojk.lib.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.Cipher;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.bind.ProgressModel;
import id.go.ojk.lib.client.model.compression.ArchiveResult;
import id.go.ojk.lib.client.model.compression.FileEncryptSignature;
import id.go.ojk.lib.client.model.compression.FileIntegrity;

public class MasterDataAndErrorFileUtil {
	private static Logger logger = LoggerFactory.getLogger(MasterDataAndErrorFileUtil.class);
	public final static boolean debug = false;

	public static Tupple2<File, List<File>> compressEncryptMasterData(String easKeyBase64, int numberOfThread, File sourceDir, long maxSize) 
			throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException{
		
		validateSourceDir(sourceDir);
		
		File workDir = sourceDir;
		File destDir = sourceDir;
		
		File[] sourceFiles = sourceDir.listFiles( (File dir, String name) -> {
			String nameLower = name.toLowerCase();
			return nameLower.endsWith(".txt");			
		});		
			
		if (sourceFiles.length == 0){
			throw new SlikException("Tidak ditemukan file .txt pada direktori " + sourceDir.getAbsolutePath());
		}
		
		String firstFileName = sourceFiles[0].getName();
		String[] fileNameSplited = firstFileName.split("[.]");
		if ( fileNameSplited.length < 6 ){
			throw new SlikException("File " + firstFileName + " tidak valid, format harus memberTypeCode, MemberCode, officeCode, reportYearMonth, dataFormaId, txt");
		}
		String sourceFileNamePrefix = fileNameSplited[0] + "." + fileNameSplited[1] + "." + fileNameSplited[2] + "." + fileNameSplited[3];
		
		List<File> files = Arrays.asList(sourceFiles).stream().filter( f -> f.getName().startsWith(sourceFileNamePrefix) && f.getName().endsWith(".txt")).collect(Collectors.toList());
		for (File file : files) {
			logger.debug("filename=" + file.getName());
		}
		
		return compressEncrypt(easKeyBase64, sourceFileNamePrefix, numberOfThread, files, workDir, destDir, "master", maxSize);
	}

	
	/**
	 * 
	 * Format file hasil : <br/>
	 * sourceFileNamePrefix.error.zip <br/>
	 * sourceFileNamePrefix.error.signature <br/>
	 * 
	 * memberTypeCode, MemberCode, officeCode, reportYearMonth, dataFormaId, txt
	 * hasil master.zip.partX
	 * hasil master.signature
	 * 
	 * @param easKeyBase64
	 * @param sourceFileNamePrefix format = &ltmemberTypeCode&gt.&ltmemberCode&gt.&ltyyyyMMddHHmmssSSS&gt
	 * @param numberOfThread
	 * @param sourceDir berisi file-file dengan format &sourceFileNamePrefix&gt.&XXX&gt.master, XXX D01, D02 dst
	 * @param workDir
	 * @param destDir
	 * @param maxSize
	 * @return
	 * @throws FileNotFoundException
	 * @throws NoSuchAlgorithmException
	 * @throws ArchiveException
	 * @throws IOException
	 */
	public static Tupple2<File, List<File>> compressEncryptMasterData(String easKeyBase64, String sourceFileNamePrefix, int numberOfThread, File sourceDir, File workDir, File destDir, long maxSize) 
		throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException{
	
		validateSourceDir(sourceDir);
	
		File[] sourceFiles = sourceDir.listFiles( (File dir, String name) -> {
			String nameLower = name.toLowerCase();
			return nameLower.startsWith(sourceFileNamePrefix) && nameLower.endsWith(".master");			
		});
		
		if (sourceFiles.length == 0){
			throw new SlikException("Tidak ditemukan file " + sourceFileNamePrefix + ".<XXX>.master pada direktori " + sourceDir.getAbsolutePath());
		}
	
		return compressEncrypt(easKeyBase64, sourceFileNamePrefix, numberOfThread, Arrays.asList(sourceFiles), workDir, destDir, "master", maxSize);
	}
	
	/**
	 * Format file hasil : <br/>
	 * SubmissionID.error.zip <br/>
	 * SubmissionID.error.signature <br/>
	 * 
	 * @param submissionId format = &ltmemberTypeCode&gt.&ltmemberCode&gt.&ltyyyyMMddHHmmssSSS&gt
	 * @param sourceDir berisi file-file dengan format &sourceFileNamePrefix&gt.&lt;XXX&gt.etlerr, XXX D01, D02 dst
	 * @param destDir
	 * @param splitFileSize
	 * @return
	 * @throws IOException 
	 * @throws ArchiveException 
	 * @throws NoSuchAlgorithmException 
	 * @throws FileNotFoundException 
	 */
	public static Tupple2<File, List<File>> compressEncryptEtlError(String easKeyBase64, String submissionId, int numberOfThread, File sourceDir, File workDir, File destDir, long maxSize) 
				throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException{
		
		validateSourceDir(sourceDir);

//		File[] sourceFiles = sourceDir.listFiles( (File dir, String name) -> {
//			String nameLower = name.toLowerCase();
//			File file = new File(dir.getAbsolutePath() + "/" + name);
//			return file.isFile() && (nameLower.endsWith(".etlerr") || nameLower.endsWith(".valerr"));			
//		});
		File[] sourceFiles = listValerrEtlErrFile(sourceDir);
		
		if (sourceFiles.length == 0){
			logger.error("Tidak ditemukan file *.etlerr  atau *.valerr pada direktori " + sourceDir.getAbsolutePath());
			return null;
		}
		
		List<File> sourceFileList = Arrays.asList(sourceFiles);
				
		if (debug){
			try {
				setPosixFilePermissionsAllReadWrite(sourceFileList);					
			} catch (Throwable t){
				logger.error("Fail set rwx ", t);
			}

			for (File file : sourceFileList) {
				logger.info(file.getName() + " (" + file.length() + ") " + file.canRead() + ", " + file.canWrite() + ", " + file.canExecute());
				try {
					FileUtils.copyFile(file, new File(file.getAbsolutePath() + ".testcopy"), false);					
				} catch (Throwable t){
					logger.error("Fail test Copy File", t);
				}
			}
		}

		return compressEncrypt(easKeyBase64, submissionId, numberOfThread, sourceFileList, workDir, destDir, "error", maxSize);
	}
	
	public static List<File> compressEtlError(String submissionId, File sourceDir, File destDir, long maxSize) 
			throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException{
	
		validateSourceDir(sourceDir);
	
		File[] sourceFiles = listValerrEtlErrFile(sourceDir);
		
		if (sourceFiles.length == 0){
			logger.error("Tidak ditemukan file *.etlerr  atau *.valerr pada direktori " + sourceDir.getAbsolutePath());
			return null;
		}
		
		//0101.008.20161024101015895.error.signature
		List<File> sourceFileList = Arrays.asList(sourceFiles);
		File dest = new File(destDir + "/" + submissionId + ".error.plain.zip");
		ZipSplitOutputStream os = null;
		
		List<File> result = new ArrayList<>();
		try {
			os = new ZipSplitOutputStream(dest, maxSize);
			CompressionUtil.zip(sourceFileList, os);
			result = os.getFileIntegrities().stream().map( fi -> fi.getFile()).collect(Collectors.toList());
		} finally {
			IOUtils.closeQuietly(os);
		}			
	
		return result;
	
	}
	
//	private static void zip(List<File> sourceFiles, OutputStream os) throws ArchiveException, IOException {
//		ArchiveOutputStream archive = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP, os);
//
//		BufferedOutputStream bos = new BufferedOutputStream(archive, 8000);
//
//		try {
//			if ( archive instanceof ZipArchiveOutputStream ){
//				((ZipArchiveOutputStream)archive).setUseZip64(Zip64Mode.Always);
//			}
//
//			for (File sourceFile : sourceFiles) {
//
//				String entryName = sourceFile.getName();
//				ArchiveEntry entry = new ZipArchiveEntry(entryName);
//				archive.putArchiveEntry(entry);
//
//				BufferedInputStream input = null;
//				try {
//					input = new BufferedInputStream(new FileInputStream(sourceFile));
//					IOUtils.copy(input, archive);
//				} finally {
//					IOUtils.closeQuietly(input);
//				}
//				archive.closeArchiveEntry();
//			}
//
//			archive.finish();
//		} finally {
//			IOUtils.closeQuietly(bos);
//		}
//	}
	
	private static File[] listValerrEtlErrFile(File sourceDir){
		File[] sourceFiles = sourceDir.listFiles( (File dir, String name) -> {
			String nameLower = name.toLowerCase();
			File file = new File(dir.getAbsolutePath() + "/" + name);
			return file.isFile() && (nameLower.endsWith(".etlerr") || nameLower.endsWith(".valerr"));			
		});
		return sourceFiles;
	}
	
	private static Tupple2<File, List<File>> compressEncrypt(String easKeyBase64, String sourceFileNamePrefix, int numberOfThread, List<File> sourceFiles, File workDir, File destDir, String destSuffix, long maxSize) 
			throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException{
			
		List<FileIntegrity> sourceFileIntegrities = sourceFiles.stream().map( file -> new FileIntegrity(file, "")).collect(Collectors.toList());
		
		File tmpDir = new File(workDir.getAbsolutePath() + "/" + sourceFileNamePrefix);
		
		tmpDir.mkdirs();
		destDir.mkdirs();
	
		List<FileIntegrity> encFileIntegrities = EncryptionCompressionUtilBig.compressAndEncryptChunckFileIntegrities(
				new ProgressModel("", false),
				CompressionUtilBig.GZIP,
				easKeyBase64,
				sourceFileIntegrities,
				maxSize,
				tmpDir,
				numberOfThread
			);
	
		File destFile = new File(destDir.getAbsolutePath() + "/" + sourceFileNamePrefix + "." + destSuffix + ".zip"); 
		ArchiveResult archiveResult = ArchiveUtil.archive(
				new ProgressModel("", false),
				maxSize,
				encFileIntegrities,
				destFile
			);
		
		FileUtils.deleteDirectory(tmpDir);
		
		//0101.009.20160808084104054
		//SubmissionIdParse submissionIdParse = SubmissionIdParse.fromStringThrowExceptionIfNotValid(sourceFileNamePrefix);
		String[] sourceFileNamePrefixSplited = sourceFileNamePrefix.split("[.]");
		
		FileEncryptSignature fileEncryptSignature = new FileEncryptSignature();
		fileEncryptSignature.setIdentity(sourceFileNamePrefix + "." + DateUtil.formatNowMs());
		fileEncryptSignature.setMemberTypeCode(sourceFileNamePrefixSplited[0]);
		fileEncryptSignature.setMemberCode(sourceFileNamePrefixSplited[1]);
		fileEncryptSignature.setCreatedBy("slik");
		fileEncryptSignature.setCreatedDatetime(DateUtil.formatNowMs());
		fileEncryptSignature.setOriginalFiles(sourceFileIntegrities);
		fileEncryptSignature.setArchiveChecksums(archiveResult.getHash());
		fileEncryptSignature.setArchiveFilenames(archiveResult.getFileIntegrities().stream().map(e -> e.getFileName()).collect(Collectors.toList()));
		
		XStream xstream = instanceStream();
		File destSigFile = new File(destDir.getAbsolutePath() + "/" + sourceFileNamePrefix + "." + destSuffix + ".signature");
		
		try (FileOutputStream signatureEncOutputStream = new FileOutputStream(destSigFile)){
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			xstream.toXML(fileEncryptSignature, byteArrayOutputStream);
			EncryptionUtil.aesEncryption(
				Cipher.ENCRYPT_MODE, 
				easKeyBase64, 
				new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), 
				signatureEncOutputStream, 
				(MeteredIOCopyers)null);
		}
		
		return Tupple2.<File, List<File>>builder()
			.a(destSigFile)
			.b(archiveResult.getFileIntegrities().stream().map( fi -> fi.getFile()).collect(Collectors.toList()))
			.build();
	}
	
	private static void validateSourceDir(File sourceDir) {	
		if ( !sourceDir.exists() ){
			throw new SlikException(sourceDir.getAbsolutePath() + " tidak ditemukan!");
		}
		
		if ( !sourceDir.isDirectory()  ){
			throw new SlikException(sourceDir.getAbsolutePath() + " bukan direktori!");
		}
	}

	public static XStream instanceStream(){
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(
				new Class[]{
					FileEncryptSignature.class, FileIntegrity.class,
				}
			);
		return xstream;
	}

	private final static HashSet<PosixFilePermission> allRearWrite = new HashSet<>();
	static {
		allRearWrite.add(PosixFilePermission.OWNER_READ);
		allRearWrite.add(PosixFilePermission.OWNER_WRITE);
		allRearWrite.add(PosixFilePermission.OWNER_EXECUTE);
		
		allRearWrite.add(PosixFilePermission.GROUP_READ);
		allRearWrite.add(PosixFilePermission.GROUP_WRITE);
		allRearWrite.add(PosixFilePermission.GROUP_EXECUTE);
		
		allRearWrite.add(PosixFilePermission.OTHERS_READ);
		allRearWrite.add(PosixFilePermission.OTHERS_WRITE);
		allRearWrite.add(PosixFilePermission.OTHERS_EXECUTE);
	}
	
	public static void setPosixFilePermissionsAllReadWrite(List<File> files) throws IOException{
		String os = System.getProperty("os.name").toLowerCase();
		logger.debug("os " + os);
		if ( os.contains("win") ){
			logger.info("skip setPosixFilePermissionsRecursive on windows");
			return;
		}
		for (File file : files) {
			Files.setPosixFilePermissions(file.toPath(), allRearWrite);
		}
	}

}
