package id.go.ojk.lib.client.model.compression;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import lombok.Getter;
import lombok.Setter;

@XStreamAlias("fileIntegrity")
public class FileIntegrity {
	
	@XStreamOmitField
	@Getter private File file;
	
	@Getter private String fileName;
	@Getter private long length;
	@Getter @Setter private String checksum;
	
	@Getter @Setter private Throwable throwable;

	public FileIntegrity(File file, String checksum){
		this.file = file;
		this.fileName = file.getName();
		this.checksum = checksum;
		this.length = file.length();
	}

	public void synchLength(){
		this.length = file.length();
	}

//	public File getFile() {
//		return file;
//	};
//	public long getLength() {
//		return length;
//	};
//
//	public String getChecksum() {
//		return checksum;
//	};
//	public void setChecksum(String checksum) {
//		this.checksum = checksum;
//	}
//
//	public Throwable getThrowable() {
//		return throwable;
//	}
//	public void setThrowable(Throwable throwable) {
//		this.throwable = throwable;
//	}
	
	public boolean isError(){
		return throwable != null;
	}

	@Override
	public String toString() {
		return StringUtils.join(
			"file:", file.getName(), ";",
			"length:", length + "", ";",
			"checksum:", checksum
		);
	}


}
