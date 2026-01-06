package id.go.ojk.lib.client.model;

import java.io.File;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class FileChunk {
	private File file;
	private long byteOffset;
	private long byteLength;
	private int chunkNumber;
	private String chunkFileName;

	volatile private long byteProgress = 0l;
	private boolean complete = false;

	public FileChunk( File file, long byteOffset, long byteLength, int chunkNumber){
		this.file = file;
		this.byteOffset = byteOffset;
		this.byteLength = byteLength;
		this.chunkNumber = chunkNumber;
		this.chunkFileName = file.getName() + "." + chunkNumber;
	}

	public synchronized long getByteProgress() {
		return byteProgress;
	};
	public synchronized void setByteProgress(long byteProgress) {
		this.byteProgress = byteProgress;
	};
	public synchronized void setCurrentOffsetProgress(long currentOffsetProgress) {
		setByteProgress(currentOffsetProgress - byteOffset);
	};

	public File getFile() {
		return file;
	};
	public long getByteOffset() {
		return byteOffset;
	};
	public long getByteLength() {
		return byteLength;
	};
	public int getChunkNumber() {
		return chunkNumber;
	};
	public String getChunkFileName() {
		return chunkFileName;
	};

	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
