package id.go.ojk.lib.client.service.ftp;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceFtp implements Closeable {
	protected FTPClient ftpClient = new FTPClient();
	protected boolean isLoggedIn = false;
	
	public ServiceFtp(String ip, int port, String id, String pwd) {
		if (!init(ip, port, id, pwd)) {
			log.error("Ftp Client initialization [ip={}, port={}, id={}, pwd={}] failed!!!", ip, port, id, pwd.length());
		}
	}

	@Override
	public void close() throws IOException {
		try {
			if (ftpClient.isConnected()) {
				ftpClient.quit();
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		isLoggedIn = false;
	}

	protected boolean createChangeDirectories(String dir) throws IOException {
		String[] arrDir = StringUtils.split(dir, "/");
		log.info("Go to folder {}", dir);
		if (arrDir != null && arrDir.length > 0) {
			for (String singleDir : arrDir) {
				boolean existed = ftpClient.changeWorkingDirectory(singleDir);
				if (!existed) {
					boolean created = ftpClient.makeDirectory(singleDir);
					if (created) {
						ftpClient.changeWorkingDirectory(singleDir);
					} else {
						return false;
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	private boolean connect(String ip, int port) {
		try {
			ftpClient.connect(ip, port);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
		return true;
	}
	
	private boolean login(String id, String pwd) {
		try {
			boolean res = ftpClient.login(id, pwd);
			isLoggedIn = res;
			ftpClient.enterLocalPassiveMode();
			ftpClient.setCharset(StandardCharsets.UTF_8);
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);
			return res;
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}
	
	private boolean init(String ip, int port, String id, String pwd) {
		if (connect(ip, port) && ftpClient.isConnected()) {
			return login(id, pwd);
		}
		return false;
	}
}
