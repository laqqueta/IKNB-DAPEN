package id.go.ojk.conf.client;

import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.conf.client.dto.DtoFtpInfo;
import id.go.ojk.lib.client.IObject;
import lombok.Getter;

public enum EFtpInfo implements IObject<DtoFtpInfo> {
//	DEV_1 (ConfigConstant.DEV_FTP_HOST, ConfigConstant.DEV_FTP_HOST, 889, "ojk\\abdul.basit", "password.123"),
//	DEV_1 (ConfigConstant.DEV_FTP_HOST, ConfigConstant.DEV_FTP_HOST, 889, "admfatca", "P4$$word"),
	DEV_TRX_1(ClientConstant.DEV_FTP_HOST, ClientConstant.DEV_FTP_HOST_INTERNAL, ClientConstant.DEV_FTP_PORT, ClientConstant.DEV_FTP_USER,
			ClientConstant.DEV_FTP_PWD),
	DEV_TRX_2(ClientConstant.DEV_FTP_HOST_2, ClientConstant.DEV_FTP_HOST_INTERNAL_2, ClientConstant.DEV_FTP_PORT_2, ClientConstant.DEV_FTP_USER_2,
			ClientConstant.DEV_FTP_PWD_2),
	DEV_1(ConfigConstant.DEV_FTP_HOST, ConfigConstant.DEV_FTP_HOST_INTERNAL, ConfigConstant.DEV_FTP_PORT, ConfigConstant.DEV_FTP_USER,
			ConfigConstant.DEV_FTP_PWD),
	DEV_2(ConfigConstant.DEV_FTP_HOST_2, ConfigConstant.DEV_FTP_HOST_INTERNAL_2, ConfigConstant.DEV_FTP_PORT_2, ConfigConstant.DEV_FTP_USER_2,
			ConfigConstant.DEV_FTP_PWD_2),
	PROD_TRX_1("", "", 889, "", ""), 
	PROD_TRX_2("", "", 889, "", ""), 
	PROD_1("", "", 889, "", ""), 
	PROD_2("", "", 0, "", ""),
	DEV_ENTITY(ConfigConstant.DEV_FTP_HOST_ENTITY, ConfigConstant.DEV_FTP_HOST_ENTITY, ConfigConstant.DEV_FTP_ENTITY_PORT, ConfigConstant.DEV_FTP_USER_ENTITY,
			ConfigConstant.DEV_FTP_PWD_ENTITY),
	DEV_ENTITY_2(ConfigConstant.DEV_FTP_HOST_ENTITY_2, ConfigConstant.DEV_FTP_HOST_ENTITY_2, ConfigConstant.DEV_FTP_ENTITY_PORT_2, ConfigConstant.DEV_FTP_USER_ENTITY_2,
			ConfigConstant.DEV_FTP_PWD_ENTITY_2),
	PROD_ENTITY(ConfigConstant.PROD_FTP_HOST_ENTITY, ConfigConstant.PROD_FTP_HOST_ENTITY, 21, "prodUser",
			"rxTfcpKw4gPnBGQbDS2U5N"),
	PROD_ENTITY_2(ConfigConstant.PROD_FTP_HOST_ENTITY_2, ConfigConstant.PROD_FTP_HOST_ENTITY_2, 21, "prodUser",
			"rxTfcpKw4gPnBGQbDS2U5N"),;

	@Getter
	private String ftpHost;
	@Getter
	private String ftpHostInternal;
	@Getter
	private int ftpPort;
	@Getter
	private String ftpUser;
	@Getter
	private String ftpPass;

	private EFtpInfo(String ftpHost, String ftpHostInternal, int ftpPort, String ftpUser, String ftpPass) {
		this.ftpHost = ftpHost;
		this.ftpHostInternal = ftpHostInternal;
		this.ftpPort = ftpPort;
		this.ftpUser = ftpUser;
		this.ftpPass = ftpPass;
	}

	@Override
	public DtoFtpInfo getObject() {
		DtoFtpInfo res = new DtoFtpInfo();
		res.setFtpHost(ftpHost);
		res.setFtpHostInternal(ftpHostInternal);
		res.setFtpPass(ftpPass);
		res.setFtpPort(ftpPort);
		res.setFtpUser(ftpUser);
		return res;
	}

}
