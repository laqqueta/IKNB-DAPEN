package id.go.ojk.client.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.service.ConfigService;

public class UtilConfiguration {
	private static final Logger logger = LoggerFactory.getLogger(UtilConfiguration.class);
	
	public static String buildClientProperties(String path) {
		String fileName = path + ClientConstant.CLIENT_PROPERTIES;
		Properties props = initClientProperties();
		try (FileOutputStream fos = new FileOutputStream(new File(fileName))) {
			props.store(fos, "OJKClient");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return fileName;
	}
	
	private static Properties initClientProperties() {
		Properties res = new Properties();
		res.setProperty(ConfigService.connectionType.getKey(), ConfigService.connectionType.getDefaultValueAsString());
		res.setProperty(ConfigService.errorDataDoneDir.getKey(), ConfigService.errorDataDoneDir.getDefaultValueAsString());
		res.setProperty(ConfigService.errorDataSourceDir.getKey(), ConfigService.errorDataSourceDir.getDefaultValueAsString());
		res.setProperty(ConfigService.masterDataDoneDir.getKey(), ConfigService.masterDataDoneDir.getDefaultValueAsString());
		res.setProperty(ConfigService.masterDataSourceDir.getKey(), ConfigService.masterDataSourceDir.getDefaultValueAsString());
		res.setProperty(ConfigService.proxyHost.getKey(), ConfigService.proxyHost.getDefaultValueAsString());
		res.setProperty(ConfigService.proxyPassword.getKey(), ConfigService.proxyPassword.getDefaultValueAsString());
		res.setProperty(ConfigService.proxyPort.getKey(), ConfigService.proxyPort.getDefaultValueAsString());
		res.setProperty(ConfigService.proxyUser.getKey(), ConfigService.proxyUser.getDefaultValueAsString());
		res.setProperty(ConfigService.sendindSourceDir.getKey(), ConfigService.sendindSourceDir.getDefaultValueAsString());
		res.setProperty(ConfigService.splitFileSize.getKey(), ConfigService.splitFileSize.getDefaultValueAsString());
		res.setProperty(ConfigService.submissionDoneDir.getKey(), ConfigService.submissionDoneDir.getDefaultValueAsString());
		res.setProperty(ConfigService.submissionProcessDir.getKey(), ConfigService.submissionProcessDir.getDefaultValueAsString());
		res.setProperty(ConfigService.submissionSourceDir.getKey(), ConfigService.submissionSourceDir.getDefaultValueAsString());
		res.setProperty(ConfigService.summarySourceDir.getKey(), ConfigService.summarySourceDir.getDefaultValueAsString());
		res.setProperty(ConfigService.updateOfflineFile.getKey(), ConfigService.updateOfflineFile.getDefaultValueAsString());
		res.setProperty(ConfigService.maxThread.getKey(), ConfigService.maxThread.getDefaultValueAsString());
		res.setProperty(ConfigService.validationLoopDelay.getKey(), ConfigService.validationLoopDelay.getDefaultValueAsString());
		res.setProperty(ConfigService.maxErrorCount.getKey(), ConfigService.maxErrorCount.getDefaultValueAsString());
		res.setProperty(ConfigService.connectTimeout.getKey(), ConfigService.connectTimeout.getDefaultValueAsString());
		res.setProperty(ConfigService.readTimeout.getKey(), ConfigService.readTimeout.getDefaultValueAsString());
		return res;
	}

	private UtilConfiguration() {
	}
}
