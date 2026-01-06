package id.go.ojk.conf.client.dto;

public class DtoJdbcInfo {
	private String jdbcMaster;
	private String jdbcApolo;
	private String jdbcCAM;
	private String sqlUser;
	private String sqlPass;

	public DtoJdbcInfo() {
	}

	public String getJdbcMaster() {
		return jdbcMaster;
	}

	public void setJdbcMaster(String jdbcMaster) {
		this.jdbcMaster = jdbcMaster;
	}

	public String getJdbcApolo() {
		return jdbcApolo;
	}

	public void setJdbcApolo(String jdbcApolo) {
		this.jdbcApolo = jdbcApolo;
	}

	public String getJdbcCAM() {
		return jdbcCAM;
	}

	public void setJdbcCAM(String jdbcCAM) {
		this.jdbcCAM = jdbcCAM;
	}

	public String getSqlUser() {
		return sqlUser;
	}

	public void setSqlUser(String sqlUser) {
		this.sqlUser = sqlUser;
	}

	public String getSqlPass() {
		return sqlPass;
	}

	public void setSqlPass(String sqlPass) {
		this.sqlPass = sqlPass;
	}
}
