package id.go.ojk.client.model.config;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("metadata")
public class SubmissionMetadata {

	@XStreamAsAttribute
	public String version;

	@XStreamAsAttribute
	public String lastModified;

	@XStreamAsAttribute
	private String entityTypeCode;

	@XStreamAsAttribute
	private String entityTypeDesc;
	
	@XStreamAsAttribute
	private String valMIDelimiter;
	
	@XStreamOmitField
	public static String jarVersion;

	private List<SubmissionFormat> formats = new ArrayList<>();

	public SubmissionMetadata(){

	}

	//~ getter setter

	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
		jarVersion = version;
	}

	public String getEntityTypeCode() {
		return entityTypeCode;
	}
	public void setEntityTypeCode(String entityTypeCode) {
		this.entityTypeCode = entityTypeCode;
	}

	public String getEntityTypeDesc() {
		return entityTypeDesc;
	}
	public void setEntityTypeDesc(String entityTypeDesc) {
		this.entityTypeDesc = entityTypeDesc;
	}

	public String getValMIDelimiter() {
		return valMIDelimiter;
	}
	
	public void setValMIDelimiter(String valMIDelimiter) {
		this.valMIDelimiter = valMIDelimiter;
	}
	
	public List<SubmissionFormat> getFormats() {
		return formats;
	}
	public void setFormats(List<SubmissionFormat> formats) {
		this.formats = formats;
	}

}