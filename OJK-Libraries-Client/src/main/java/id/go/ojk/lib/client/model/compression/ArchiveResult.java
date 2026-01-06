package id.go.ojk.lib.client.model.compression;

import java.util.ArrayList;
import java.util.List;

public class ArchiveResult {
	private String hash;
	private List<FileIntegrity> fileIntegrities = new ArrayList<FileIntegrity>();

	public ArchiveResult(){
	}

	public long getTotalSize() {
		return fileIntegrities.stream().mapToLong(e -> e.getLength()).sum();
	};

	public String getHash() {
		return hash;
	};
	public void setHash(String hash) {
		this.hash = hash;
	};

	public List<FileIntegrity> getFileIntegrities() {
		return fileIntegrities;
	}
	public void setFileIntegrities(List<FileIntegrity> fileIntegrities) {
		this.fileIntegrities = fileIntegrities;
	}
}
