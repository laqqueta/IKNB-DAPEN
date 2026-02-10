package id.go.ojk.bptk.client.builder;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.conf.client.AppUploaderFtp;
import id.go.ojk.lib.client.constant.LogTemplate;
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
			log.error(LogTemplate.EMPTY_1, "EnviType or ftpServer or appFtpFolder");
		}
	}
}
