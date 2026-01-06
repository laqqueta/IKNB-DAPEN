package id.go.ojk.lib.client.service.ftp;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.model.FileChunk;

public class FtpResult {
	private long transferedByte = 0l;
	private List<FileChunk> fileChunks = new ArrayList<>();

	public FtpResult(){
	}

	public FtpResult(List<FileChunk> fileChunks){
		this.fileChunks = fileChunks;
	}

	public long getTransferedByte() {
		return transferedByte;
	};
	public void setTransferedByte(long transferedByte) {
		this.transferedByte = transferedByte;
	};

	public void addTransferedByte(long addtransferedByte) {
		this.transferedByte += addtransferedByte;
	};

	public List<FileChunk> getFileChunks() {
		return fileChunks;
	};
	public void setFileChunks(List<FileChunk> fileChunks) {
		this.fileChunks = fileChunks;
	}

}
