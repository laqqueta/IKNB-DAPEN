package id.go.ojk.lib.client.model.encryption;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import id.go.ojk.lib.client.model.compression.FileIntegrity;

public class EncryptionResult {
	private File encryptionDir;
	private String aesKey;
	private String hash;
	private List<FileIntegrity> encResultFiles = new ArrayList<FileIntegrity>();
	private File signatureFile;
	private File signatureReadyToSendFile;

	public EncryptionResult(){
	}

	public EncryptionResult(String hash, List<FileIntegrity> encResultFiles){
		this.hash = hash;
		this.encResultFiles = encResultFiles;
	}

	public long getTotalSize() {
		return encResultFiles.stream().mapToLong( e -> e.getLength()).sum();
	}

	public void moveToReady(File readyToTransferDir) throws IOException{
		readyToTransferDir.getParentFile().mkdirs();
				
		FileUtils.moveDirectory(
			new File(encryptionDir.getAbsolutePath()), 
			new File(readyToTransferDir.getAbsolutePath())
		);
		
//		Files.move(
//			Paths.get(encryptionDir.getAbsolutePath()),
//			Paths.get(readyToTransferDir.getAbsolutePath())
//		);

		signatureReadyToSendFile = new File(readyToTransferDir.getAbsoluteFile() + "/" + signatureFile.getName());
		List<FileIntegrity> tmpFileIntegrities = new ArrayList<>();
		for (FileIntegrity fileIntegrity : encResultFiles) {
			File file = new File(readyToTransferDir.getAbsoluteFile() + "/" + fileIntegrity.getFile().getName());
			tmpFileIntegrities.add(new FileIntegrity(file, fileIntegrity.getChecksum()));
		}
		encResultFiles = tmpFileIntegrities;
	}

	//~ getter setter

	public File getEncryptionDir() {
		return encryptionDir;
	}
	public void setEncryptionDir(File encryptionDir) {
		this.encryptionDir = encryptionDir;
	}

	public String getAesKey() {
		return aesKey;
	}
	public void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}

	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}

	public List<FileIntegrity> getEncResultFiles() {
		return encResultFiles;
	}
	public void setEncResultFiles(List<FileIntegrity> encResultFiles) {
		this.encResultFiles = encResultFiles;
	}

	public File getSignatureFile() {
		return signatureFile;
	}
	public void setSignatureFile(File signatureFile) {
		this.signatureFile = signatureFile;
	}

	public File getSignatureReadyToSendFile() {
		return signatureReadyToSendFile;
	}

}
