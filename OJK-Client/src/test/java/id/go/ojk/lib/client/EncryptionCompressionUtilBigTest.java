package id.go.ojk.lib.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.compressors.CompressorException;
import org.junit.Test;

public class EncryptionCompressionUtilBigTest {

	public static String aesStaticKeyBase64 = "gph9aA0Xhb3W8YngKuDsieNg13EjXmx1TqMw58pAiEk=";
	
	@Test
	public void test1() throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException, CompressorException{
//		TimeCounter timeCounter = new TimeCounter();
//		System.out.println("START");
//
//		File sourceDir = new File("D:/rifano/java/ws3/client1/data/source/PAkbar");
//		File destDir = new File("D:/rifano/java/ws3/client1/data/source/PAkbarEnc");
//		File archiveFile = new File("D:/rifano/java/ws3/client1/data/source/PAkbar3Ar/test.zip");
//		File decDir = new File("D:/rifano/java/ws3/client1/data/source/PAkbarDec");
//
//		//~ Kompresi dan Enkripsi
//		
//		destDir.mkdirs();
//		File[] files = sourceDir.listFiles();
//		List<FileIntegrity> sourceFile = Arrays.asList(files).stream().map( e -> new FileIntegrity(e, null)).collect(Collectors.toList());
//
//		ProgressModel progressModel = new ProgressModel("Kompresi dan Enkripsi", false){
//			@Override
//			public void writeProcessLog(String message) {
//				System.out.println(message);
//			};
//			@Override
//			public void setProgress(double progress) {
//				System.out.println("progress " + progress);
//			};
//		};
//		progressModel.setTotalLength(sourceFile.stream().mapToLong(e -> e.getLength()).sum());
//		List<FileIntegrity> encFiles = EncryptionCompressionUtilBig.compressAndEncryptChunckFileIntegrities(progressModel, CompressionUtilBig.BZIP2, aesStaticKeyBase64, sourceFile, 100000000l, destDir, 8);
//
//		//~ Archive
//		
//		ProgressModel progressModel1 = new ProgressModel("", false){
//			@Override
//			public void writeProcessLog(String message) {
//				System.out.println(message);
//			};
//			@Override
//			public void setProgress(double progress) {
//				System.out.println("progress " + progress);
//			};
//		};
//
//		ArchiveResult archiveResult = ArchiveUtil.archive(progressModel1, 100000000l, encFiles, archiveFile);
//
//		//~ deArchive Checksum Decrypt Decompress
//		
//		ArchiveUtil.deArchiveChecksumDecryptDecompress(archiveResult.getFileIntegrities(), aesStaticKeyBase64, decDir);
//
//		System.out.println("END " + timeCounter.getTimeElapse() + " ms");
	}
}
