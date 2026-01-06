package id.go.ojk.lib.client.model.compression;

import java.util.ArrayList;
import java.util.List;

public class CompressionResult {
	private String hash;
	private List<CompressionResultFile> zipResultFiles = new ArrayList<CompressionResultFile>();

	public CompressionResult(){
	}

	public long getTotalSize() {
		return zipResultFiles.stream().mapToLong(e -> e.getFileSize()).sum();
	};

	public String getHash() {
		return hash;
	};
	public void setHash(String hash) {
		this.hash = hash;
	};

	public List<CompressionResultFile> getZipResultFiles() {
		return zipResultFiles;
	};
	public void setZipResultFiles(List<CompressionResultFile> zipResultFiles) {
		this.zipResultFiles = zipResultFiles;
	};
}
