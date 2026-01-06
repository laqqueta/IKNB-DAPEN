package id.go.ojk.client.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.crypto.Cipher;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import id.go.ojk.client.service.base.BaseService;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.client.util.RuntimeUtil;
import id.go.ojk.lib.client.ArchiveUtil;
import id.go.ojk.lib.client.CollectionUtil;
import id.go.ojk.lib.client.CompressionUtilBig;
import id.go.ojk.lib.client.DateUtil;
import id.go.ojk.lib.client.EncryptionCompressionUtilBig;
import id.go.ojk.lib.client.EncryptionUtil;
import id.go.ojk.lib.client.MeteredIOCopyers;
import id.go.ojk.lib.client.TimeCounter;
import id.go.ojk.lib.client.model.bind.FinishCallback;
import id.go.ojk.lib.client.model.bind.StatusCallback;
import id.go.ojk.lib.client.model.compression.ArchiveResult;
import id.go.ojk.lib.client.model.compression.DecryptDecompressModel;
import id.go.ojk.lib.client.model.compression.FileEncryptSignature;
import id.go.ojk.lib.client.model.compression.FileIntegrity;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import id.go.ojk.lib.client.util.FileUtil;
import javafx.scene.control.Alert.AlertType;

public class DecryptDecompressService extends BaseService {

	private SetupService setupService;
	private SecurityService securityService;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		super.setApplicationContext(applicationContext);
		this.setupService = applicationContext.getService(SetupService.class);
		this.securityService = applicationContext.getService(SecurityService.class);
	}
	
	public List<String> readSourceDirectory(DecryptDecompressModel model) throws IOException {
		List<String> errors = new ArrayList<String>();
		
		if ( !model.getSourceDir().exists() ){
			errors.add("Direktori tidak ditemukan!");
			return errors;
		}

		if ( !model.getSourceDir().isDirectory() ){
			errors.add("Bukan direktori!");
			return errors;
		}

		List<File> files = CollectionUtil.toArrayList(model.getSourceDir().listFiles());
		if ( files.size() == 0 ){
			errors.add("Direktori Kosong!");
			return errors;
		}
		
		String prefix = null;
		if ( setupService.isClientTypeOJK() ){
			Optional<File> optional = files.stream().filter( e -> e.getName().toLowerCase().endsWith(".error.signature")).findFirst();
			if ( !optional.isPresent() ){
				errors.add("File signature tidak ditemukan!");
				return errors;
			}
			String signatureFileName = optional.get().getName();
			String[] signatureFileNames = signatureFileName.split("[.]");
			String memberTypeCode = signatureFileNames[0];
			String memberCode = signatureFileNames[1];
			
			model.setMemberTypeCode(memberTypeCode);
			model.setMemberCode(memberCode);

			prefix = memberTypeCode + "." + memberCode + ".";
		} else {
			prefix = setupService.getMemberTypeCode() + "." + setupService.getMemberCode() + ".";
		}
		
		String aesKeyBase64 = null;
		if (setupService.isClientTypeOJK()){
			aesKeyBase64 = securityService.getMemberStaticKey(model.getMemberTypeCode(), model.getMemberCode()); 
		} else {
			aesKeyBase64 = setupService.getAesStaticKeyBase64();
		}
		model.setAesKeyBase64(aesKeyBase64);
		
		//read signature
		File signatureFile = null;
		for (File file : files) {
			String fileName = file.getName().toLowerCase();
			if( file.isDirectory() ) {
				errors.add(String.format("Tidak boleh ada direktori '%1$s'", fileName));
			}  if( fileName.startsWith(prefix) && fileName.endsWith("." + model.getSuffix() + ".signature") ){
				signatureFile = file;
			}
		}
		if ( signatureFile == null ){
			errors.add("File signature tidak ditemukan!");
			return errors;
		}
		
		FileEncryptSignature signature = readSignature(model, signatureFile);		
		files.remove(signatureFile);

		List<File> archiveFiles = new ArrayList<>();

		for (String archiveFilename : signature.getArchiveFilenames()) {
			File archiveFile = null;
			for (File file : files) {
				if ( archiveFilename.equals(file.getName()) ){
					archiveFile = file;
					break;
				}
			}
			
			if ( archiveFile == null ){
				errors.add(String.format("File '%1$s' tidak ditemukan!", archiveFilename) );				
			} else {
				archiveFiles.add(archiveFile);
			}
		}
		
		files.removeAll(archiveFiles);
		
		if ( files.size() > 0 ){
			errors.add(
				String.format(
					"File '%1$s' tidak valid!", 
					files.stream().map( e -> e.getName() ).collect(Collectors.joining(", "))
				)
			);
		}
		
		if ( errors.size() > 0 )
			return errors;
		
		model.setSourceFiles(archiveFiles);
		model.setReadyToProcess(true);

		return errors;
	}
	
	public FileEncryptSignature readSignature(DecryptDecompressModel model, File signatureFile) throws IOException{
		XStream xstream = instanceStream();
		
		try (FileInputStream inputStream = new FileInputStream(signatureFile)){
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			EncryptionUtil.aesEncryption(Cipher.DECRYPT_MODE, model.getAesKeyBase64(), inputStream, outputStream, (MeteredIOCopyers)null);
			FileEncryptSignature fileEncryptSignature = (FileEncryptSignature) xstream.fromXML(new ByteArrayInputStream(outputStream.toByteArray()));
			model.setFileEncryptSignature(fileEncryptSignature);
			return fileEncryptSignature;
		} 
	}
	
	public XStream instanceStream(){
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(
				new Class[]{
					FileEncryptSignature.class, FileIntegrity.class,
				}
			);
		return xstream;
	}

	public void decryptAndDecompress(String base64Key, DecryptDecompressModel model, FinishCallback finishCallback) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				decryptAndDecompressReal(base64Key, model, finishCallback);
			}
		}).start();
	}

	private void decryptAndDecompressReal(String base64Key, DecryptDecompressModel model, FinishCallback finishCallback) {
		try {
			TimeCounter timeCounter = new TimeCounter();
			model.writeProcessLog("Mulai", false);

			model.startProcess();

			model.writeProcessLog("Dearchive - Mulai", false);
			model.getDearchiveProgressModel().updateStatus(StatusCallback.start);
			File dearchiveDir = new File(model.getDestDir().getAbsolutePath() + "/" + DateUtil.formatNow());
			ArchiveResult dearchiveResult = ArchiveUtil.deArchive(
				model.getDearchiveProgressModel(),
				ArchiveUtil.toFileIntegrities(model.getSourceFiles()),
				dearchiveDir
			);
			
//			if ( !dearchiveResult.getHash().equals(anObject) ){
//				
//			}
			
			if ( model.isStopProsess() ){
				return;
			} else {
				model.getDearchiveProgressModel().updateStatus(StatusCallback.success);
			}
			
			model.writeProcessLog(String.format("Dearchive selesai dalam %1$s", timeCounter.getTimeElapseFormated()) , true);
			timeCounter = new TimeCounter();
			
			model.writeProcessLog("Dekrip dan dekompresi - Mulai", false);
			model.getDecryptProgressModel().updateStatus(StatusCallback.start);
			List<File> resultFiles = EncryptionCompressionUtilBig.decryptAndDecompress(
				model.getDecryptProgressModel(),
				RuntimeUtil.getNumberOfThread(),
				CompressionUtilBig.GZIP,
				base64Key,
				dearchiveResult.getFileIntegrities(),
				model.getDestDir()
			);
			model.setResultFiles(resultFiles);
			if ( !model.isStopProsess() ){
				model.writeProcessLog(String.format("Dekrip dan Dekompresi selesai dalam %1$s", timeCounter.getTimeElapseFormated()), true);
				model.getDecryptProgressModel().updateStatus(StatusCallback.success);
				model.getDecryptProgressModel().setShowDir(true);
			} 

			model.writeProcessLog("Hapus file temporary", false);
			FileUtil.deleteDir(dearchiveDir, true);
			if ( model.isStopProsess() ){
				return;
			}

			finishCallback.finish();

			model.writeProcessLog("Selesai dalam " + timeCounter.getTimeElapseFormated(), false);

		} catch (Throwable e) {
			AlertUtil.showErrorSafe(logger, "Error saat buka data", e);
		} finally {
			boolean isStop = model.isStopProsess();
			model.finish();
			if ( isStop ){
				String message = "Proses dihentikan";
				model.writeProcessLog(message, true);
				AlertUtil.showAlertSafe(AlertType.ERROR, "Kesalahan", "Kesalahan", message);
				return;
			}
		}
	}

	public static List<File> getZipFileOrdered(String prefix, File dir){
		File[] files = dir.listFiles(file -> file.getName().startsWith(prefix));
		Arrays.sort(files, new Comparator<File>(){

			@Override
			public int compare(File o1, File o2) {
				String fileName1 = o1.getName();
				String fileName2 = o2.getName();

				int zip1 = Integer.parseInt(fileName1.substring( fileName1.indexOf(".zip.part") + 9 ,  fileName1.length() ));
				int zip2 = Integer.parseInt(fileName2.substring( fileName2.indexOf(".zip.part") + 9 ,  fileName2.length() ));

				if ( zip1 > zip2 )
					return 1;
				else if ( zip1 < zip2 )
					return -1;
				else {
					return 0;
				}
			}
		});
		return Arrays.asList(files);
	}

}
