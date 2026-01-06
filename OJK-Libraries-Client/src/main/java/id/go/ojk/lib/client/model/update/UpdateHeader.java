package id.go.ojk.lib.client.model.update;

import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
@XStreamAlias("updateHeader")
public class UpdateHeader {

	@XStreamAsAttribute
	private String createdDatetime;

	@XStreamAsAttribute
	private String createdBy;

	@XStreamAsAttribute
	private String memberTypeCode;

	@XStreamAsAttribute
	private String memberCode;

	private Map<String, String> versions;

	@Tolerate
	public UpdateHeader(){
	}
	
	// RBB version
	public UpdateHeader addAllVersion(String name, String version) {
		this.versions.put(name, version);
		
		return this;
	}
	
	
}