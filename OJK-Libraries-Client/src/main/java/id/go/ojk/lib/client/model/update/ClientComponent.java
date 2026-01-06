package id.go.ojk.lib.client.model.update;

import org.apache.commons.lang3.StringUtils;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
public class ClientComponent {
	private String name;
	private String description;
	private String version;
	private String fileName;
	private String dirPath;

	@Tolerate
	public ClientComponent(){
	}
	
	public String getFullPath(){
		return (StringUtils.isEmpty(dirPath) ? "" : dirPath + "/") + fileName;  
	}

}
