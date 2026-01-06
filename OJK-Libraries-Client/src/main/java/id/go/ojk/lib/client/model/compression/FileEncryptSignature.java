package id.go.ojk.lib.client.model.compression;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
@XStreamAlias("fileEncryptSignature")
public class FileEncryptSignature {

	private String identity;
	private String memberTypeCode;
	private String memberCode;
	private String createdBy;
	private String createdDatetime;	
	private List<FileIntegrity> originalFiles;
	private String archiveChecksums;
	private List<String> archiveFilenames;

	@Tolerate
	public FileEncryptSignature(){
	}

}
