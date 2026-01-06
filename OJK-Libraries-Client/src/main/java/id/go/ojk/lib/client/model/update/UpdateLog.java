package id.go.ojk.lib.client.model.update;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
@XStreamAlias("updateLog")
public class UpdateLog {

	private String datetime;

	private List<UpdateLogDetail> details = new ArrayList<>();
	
	public boolean updateVersion(String componentCode, String afterVersion, String previousResource){
		boolean result = false;
		for (UpdateLogDetail detail : details) {
			if ( detail.getComponentCode().equals(componentCode) ){
				detail.setAfterVersion(afterVersion);
				detail.setPreviousResource(previousResource);
				result = true;
				break;
			}
		}
		return result;
	}

	@Tolerate
	public UpdateLog(){
	}

	@Data
	@Builder
	@XStreamAlias("detail")
	public static class UpdateLogDetail {
		
		private String componentCode;
		
		private String previousVersion;
		
		private String afterVersion;
		
		private String previousResource;
		
		public boolean isVersionChange(){
			return !previousVersion.equals(afterVersion);
		}
		
		@Tolerate
		public UpdateLogDetail(){
		}
		
	}
}