package id.go.ojk.lib.client.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("setupHeader")
//@Data
public class SetupHeader {

    private String version;
//    private String branchLastModified;
    private String lastModified;
    
    private Map<String, String> mapReport = new HashMap<>();
    private Map<String, List<String>> mapReportBySector = new HashMap<>();
    
	@XStreamOmitField
	public static String jarVersion;

    public SetupHeader(){
    }
    
    public String getVersion() {
		return version;
	}

    public void setVersion(String version) {
		this.version = version;
		jarVersion = version;
	}
    
    public String getLastModified() {
		return lastModified;
	}

    public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
    
    public Map<String, String> getMapReport() {
    	return mapReport;
    }
    
    public void setMapReport(Map<String, String> mapReport) {
    	this.mapReport = mapReport;
    }
    
    public Map<String, List<String>> getMapReportBySector() {
    	return mapReportBySector;
    }
    
    public void setMapReportBySector(Map<String, List<String>> mapReportBySector) {
    	this.mapReportBySector = mapReportBySector;
    }

}