package id.go.ojk.ppis.client.builder;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.conf.client.AppUploaderFtp;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InstallerFtpSync {

	public static void main(String[] args) {
		final String enviType = AppUploaderFtp.getParameterEnviType(args);
		final String ftpServer = AppUploaderFtp.getParameterFtpServer(args);
		final String appFtpFolder = AppUploaderFtp.getParameterFtpAppFolder(args);
		
		if (StringUtils.isNoneEmpty(enviType, ftpServer, appFtpFolder)) {
			AppUploaderFtp.setEnvi(enviType);
			AppUploaderFtp.sendClientExeToFtp(ftpServer, appFtpFolder);
		} else {
			log.error("EnviType or ftpServer or appFtpFolder is empty!!!");
		}
	}
}
