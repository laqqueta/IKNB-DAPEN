package id.go.ojk.conf.client;

import id.go.ojk.conf.client.dto.DtoJdbcInfo;
import id.go.ojk.lib.client.IObject;

public enum EJdbcInfo implements IObject<DtoJdbcInfo> {
	DEV (ConfigConstant.JDBC_URL, ConfigConstant.JDBC_URL + ";databasename=APOLO_FROM_PROD;", ConfigConstant.JDBC_URL + ";databasename=CAM;", "sa", "password.1"),
	PROD (ConfigConstant.JDBC_URL_PROD_MASTER, ConfigConstant.JDBC_URL_PROD_APOLO + ";databasename=APOLO_FROM_PROD;", ConfigConstant.JDBC_URL_PROD_CAM + ";databasename=CAM;", "sa", "password.1"),
	;

	private String jdbcMaster;
	private String jdbcApolo;
	private String jdbcCAM;
	private String sqlUser;
	private String sqlPass;

	private EJdbcInfo(String jdbcMaster, String jdbcApolo, String jdbcCAM, String sqlUser, String sqlPass) {
		this.jdbcMaster = jdbcMaster;
		this.jdbcApolo  =  jdbcApolo;
		this.jdbcCAM =  jdbcCAM;
		this.sqlUser = sqlUser;
		this.sqlPass = sqlPass;
	}
	
	@Override
	public DtoJdbcInfo getObject() {
		DtoJdbcInfo res = new DtoJdbcInfo();
		res.setJdbcApolo(jdbcApolo);
		res.setJdbcCAM(jdbcCAM);
		res.setJdbcMaster(jdbcMaster);
		res.setSqlPass(sqlPass);
		res.setSqlUser(sqlUser);
		return res;
	}

}
