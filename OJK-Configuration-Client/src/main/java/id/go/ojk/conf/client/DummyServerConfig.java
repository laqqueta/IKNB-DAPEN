package id.go.ojk.conf.client;

import java.util.List;
import java.util.Map;

import id.go.ojk.conf.client.dto.DtoFtpInfo;
import id.go.ojk.conf.client.dto.DtoJdbcInfo;
import lombok.Getter;
import lombok.Setter;

public class DummyServerConfig {
	private DtoFtpInfo ftp;
	private DtoFtpInfo ftp2;
	private DtoJdbcInfo jdbc;
	@Getter
	@Setter
	private String urlAuth;
	@Getter
	@Setter
	private String urlSubmission;
	
	public String CAMService;
	private boolean devMode;
	
	public Map<String, String> mapReport;
	public Map<String, List<String>> mapReportBySector;
	public Map<String, List<String>> userAppAccess;
	
	public DummyServerConfig() {
	}

	public DtoFtpInfo getFtp() {
		return ftp;
	}

	public void setFtp(DtoFtpInfo ftp) {
		this.ftp = ftp;
	}

	public DtoFtpInfo getFtp2() {
		return ftp2;
	}

	public void setFtp2(DtoFtpInfo ftp2) {
		this.ftp2 = ftp2;
	}

	public DtoJdbcInfo getJdbc() {
		return jdbc;
	}

	public void setJdbc(DtoJdbcInfo jdbc) {
		this.jdbc = jdbc;
	}

	public String getCAMService() {
		return CAMService;
	}

	public void setCAMService(String cAMService) {
		CAMService = cAMService;
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

	public Map<String, List<String>> getUserAppAccess() {
		return userAppAccess;
	}

	public void setUserAppAccess(Map<String, List<String>> userAppAccess) {
		this.userAppAccess = userAppAccess;
	}

	public boolean isDevMode() {
		return devMode;
	}

	public void setDevMode(boolean devMode) {
		this.devMode = devMode;
	}

}
