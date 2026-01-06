package id.go.ojk.client.model;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import lombok.Getter;

public class ValidFile {
	@Getter private File file;
	@Getter private String fullFileName;
	@Getter private String fileName;
	@Getter private String extension;
	@Getter private String[] splittedFilename;

	public ValidFile(File file) {
		this.file = file;
		String fullFileName = file.getName();
		this.extension = "." + FilenameUtils.getExtension(fullFileName);
		this.fileName = FilenameUtils.getBaseName(fullFileName);
		this.fullFileName = fullFileName;
		this.splittedFilename = StringUtils.split(getFileName(), "-");
	}
	
	public String getPart(int idx) {
		return splittedFilename != null && splittedFilename.length >= (idx + 1) ? splittedFilename[idx] : "";
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("fullFileName=").append(fullFileName).append("|");
		builder.append("fileName=").append(fileName).append("|");
		builder.append("extension=").append(extension).append("|");
		builder.append("splittedFilename=").append(splittedFilename != null ? splittedFilename.length : 0).append("|");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullFileName == null) ? 0 : fullFileName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValidFile other = (ValidFile) obj;
		if (fullFileName == null) {
			if (other.fullFileName != null)
				return false;
		} else if (!fullFileName.equals(other.fullFileName))
			return false;
		return true;
	}
}
