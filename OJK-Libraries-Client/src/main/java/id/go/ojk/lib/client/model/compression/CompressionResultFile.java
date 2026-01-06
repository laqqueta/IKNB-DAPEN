package id.go.ojk.lib.client.model.compression;

import java.io.File;

public class CompressionResultFile {
	private File file;
	private long fileSize;
	private String hash;

	public CompressionResultFile(){
	}

	public long getSize(){
		return file.length();
	}

	//~ getter setter

	public File getFile() {
		return file;
	};
	public void setFile(File file) {
		this.file = file;
	};

	public long getFileSize() {
		return fileSize;
	};
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	};

	public String getHash() {
		return hash;
	};
	public void setHash(String hash) {
		this.hash = hash;
	};

}
