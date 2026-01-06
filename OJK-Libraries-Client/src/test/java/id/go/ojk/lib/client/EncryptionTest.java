package id.go.ojk.lib.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.compress.archivers.ArchiveException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import id.go.ojk.lib.client.model.compression.FileEncryptSignature;
import id.go.ojk.lib.client.model.compression.FileIntegrity;

public class EncryptionTest {

	public static void main(String args[]) throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException{
		
		
		System.out.println(EncryptionUtil.generateRandomAESKeyBase64(256));

//		String aesStaticKeyBase64 = "gph9aA0Xhb3W8YngKuDsieNg13EjXmx1TqMw58pAiEk=";
//
//		String memberTypeCode = "0101";
//		String memberCode = "008";
//		String identity = "m." + memberTypeCode + "." + memberCode + "." + DateUtil.formatNowMs();
//		
//		TimeCounter timeCounter = new TimeCounter();
//		ProgressModel progressModel = new ProgressModel("", false);
//		File sourceDir = new File("D:/rifano/java/ws3/client1/data/source/sample2");
//		
//		String baseDir = "E:/tmp/test_compress/master/";
//		File workDir = new File(baseDir + "tmp/");
//		File destFile = new File(baseDir + identity + ".zip");
//		
//		File[] files = sourceDir.listFiles();
//		List<FileIntegrity> fileIntegrities = new ArrayList<FileIntegrity>();
//		for (File file : files) {
//			fileIntegrities.add(new FileIntegrity(file, ""));
//		}
//		
//		int numberOfThread = 2;
//		
//		long encryptSlitSize = fileIntegrities.stream().mapToLong(e -> e.getFile().length()).sum() / (numberOfThread*3);;
//		if ( encryptSlitSize < 100000000l )
//			encryptSlitSize = 100000000l;
//		if ( encryptSlitSize > 500000000l )
//			encryptSlitSize = 500000000l;
//		progressModel.writeProcessLog( String.format("Kompresi, enkripsi dan archive - ukuran split data asli %1$s ", encryptSlitSize), false);
//		workDir.mkdirs();
//		
//		List<FileIntegrity> comEncs = EncryptionCompressionUtilBig.compressAndEncryptChunckFileIntegrities(
//				new ProgressModel("", false),
//				CompressionUtilBig.GZIP,
//				aesStaticKeyBase64,
//				fileIntegrities,
//				encryptSlitSize,
//				workDir,
//				numberOfThread
//			);
//		
//		ArchiveResult archiveResult = ArchiveUtil.archive(
//				new ProgressModel("", false),
//				1000000,
//				comEncs,
//				destFile
//			);
//		
//		FileEncryptSignature fileEncryptSignature = new FileEncryptSignature();
//		fileEncryptSignature.setIdentity(identity);
//		fileEncryptSignature.setMemberTypeCode(memberTypeCode);
//		fileEncryptSignature.setMemberCode(memberCode);
//		fileEncryptSignature.setCreatedBy("dev");
//		fileEncryptSignature.setCreatedDatetime(DateUtil.formatNowMs());
//		fileEncryptSignature.setOriginalFiles(fileIntegrities);
//		fileEncryptSignature.setArchiveChecksums(archiveResult.getHash());
//		fileEncryptSignature.setArchiveFilenames(archiveResult.getFileIntegrities().stream().map(e -> e.getFileName()).collect(Collectors.toList()));
//		
//		XStream xstream = instanceStream();
//		File destSigFile = new File(baseDir + identity + ".signature");
//		
//		try (FileOutputStream signatureEncOutputStream = new FileOutputStream(destSigFile)){
//			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//			xstream.toXML(fileEncryptSignature, byteArrayOutputStream);
//			EncryptionUtil.aesEncryption(
//				Cipher.ENCRYPT_MODE, 
//				aesStaticKeyBase64, 
//				new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), 
//				signatureEncOutputStream, 
//				(MeteredIOCopyers)null);
//		}
//				
//		FileUtils.deleteDirectory(workDir);
//				
//		System.out.println(timeCounter.getTimeElapseFormated());
		
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


//	public static void main(String args[]) throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException{
//		TimeCounter timeCounter = new TimeCounter();
//		ProgressModel progressModel = new ProgressModel("", false);
//		File dir = new File("D:/rifano/java/ws3/client1/data/source/sample5");
//		File destFile = new File("E:/tmp/test_compress/test.zip");
//		
//		File[] files = dir.listFiles();
//		List<FileIntegrity> fileIntegrities = new ArrayList<FileIntegrity>();
//		for (File file : files) {
//			fileIntegrities.add(new FileIntegrity(file, ""));
//		}
//		
//		String aesStaticKeyBase64 = "gph9aA0Xhb3W8YngKuDsieNg13EjXmx1TqMw58pAiEk=";
//		EncryptionCompressionUtil.compressAndEncrypt(progressModel, 500000000, aesStaticKeyBase64, fileIntegrities, destFile);
//		
//		System.out.println(timeCounter.getTimeElapseFormated());
//	}
	
}
