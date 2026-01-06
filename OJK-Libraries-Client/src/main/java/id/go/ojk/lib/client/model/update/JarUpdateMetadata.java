package id.go.ojk.lib.client.model.update;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
public class JarUpdateMetadata {
	
	private String name;
	private String version;
	
	@Tolerate
	public JarUpdateMetadata(){
	}
	
	public String getFileName(){
		return name + "-" + version + ".jar";
	}
}
