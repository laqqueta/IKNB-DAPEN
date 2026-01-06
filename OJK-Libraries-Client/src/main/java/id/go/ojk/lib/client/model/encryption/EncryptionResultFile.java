package id.go.ojk.lib.client.model.encryption;

import java.io.File;

public class EncryptionResultFile {
	private File sourceFile;
	private File destFile;
	private File readyToTransferFile;
	private String hash;

	public EncryptionResultFile(){
	}

	public EncryptionResultFile(File sourceFile, File destFile, String hash){
		this.sourceFile = sourceFile;
		this.destFile = destFile;
		this.hash = hash;
	}

	public long getSize(){
		if ( readyToTransferFile != null )
			return readyToTransferFile.length();
		else
			return destFile.length();
	}

	public void initReadyToSend(File readyToTransferDir){
		readyToTransferFile = new File(readyToTransferDir.getAbsoluteFile() + "/" + destFile.getName());
	}

	//~getter setter

	public File getSourceFile() {
		return sourceFile;
	}
	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	public File getDestFile() {
		return destFile;
	}
	public void setDestFile(File destFile) {
		this.destFile = destFile;
	}

	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}

	public File getReadyToTransferFile() {
		return readyToTransferFile;
	}

}
