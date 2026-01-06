package id.go.ojk.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class TestFTP {

	public static void main(String[] args) throws SocketException, IOException {
		startFTP();
	}

	private static boolean makeDirectories(FTPClient ftpClient, String dirPath) throws IOException {
		String[] pathElements = dirPath.split("/");
		if (pathElements != null && pathElements.length > 0) {
			for (String singleDir : pathElements) {
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

	private static void storeFiles(FTPClient ftpClient, List<File> files, File submissionDir) throws FileNotFoundException, IOException {
		for (File file : files) {
			String fileName = file.getName();
			ftpClient.storeFile(fileName, new FileInputStream(submissionDir + "/" + fileName));
		}
	}

	private static void startFTP() {
		// String ftpHost = "10.210.240.18";
		// int ftpPort = 889;
		// String ftpUser = "ojk\\abdul.basit";
		// String ftpPass = "password.123";
		String ftpHost = "ftp.klinik.xyz";
		int ftpPort = 21;
		String ftpUser = "arnol";
		String ftpPass = "9y1o7a2n";
		FTPClient ftpClient = new FTPClient();

		// to show FTP commands in prompt
		ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));

		try {
			// login connection
			ftpClient.connect(ftpHost, ftpPort);
			boolean ftpLogin = ftpClient.login(ftpUser, ftpPass);
			if (!ftpLogin) {
				System.out.println("Could not login to the server");
				return;
			}

			// config
			ftpClient.setCharset(Charset.forName("UTF-8"));
			ftpClient.setBufferSize(0);
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

			// use local passive mode to pass firewall
			ftpClient.enterLocalPassiveMode();

			ftpClient.changeWorkingDirectory("public_ftp/rbb");
			// ftpClient.changeWorkingDirectory("/rbb/BPRS");
			// String dirPath = "BPRK/600001/01/2018-12-31";
			// if(!makeDirectories(ftpClient, dirPath)) {
			// System.out.println("Failed create directory");
			// return;
			// }
			//
			// File submissionDir = new
			// File("C:/rbb-validate/selesai/01.600001.20170602143625977.01.20181231/siap-kirim");
			// List<File> files = Arrays.asList(submissionDir.listFiles());
			// storeFiles(ftpClient, files, submissionDir);

			// Read directory FTP
			readFtpDirectory(ftpClient.listFiles());

			disconnect(ftpClient);
		} catch (IOException ex) {
			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("Operation failed. Server reply code: " + replyCode);
				return;
			}
		}

	}
	
	private static void readFtpDirectory(FTPFile[] files) {
		for (FTPFile file : files) {
			String fileName = file.getName();
			System.out.println(fileName);
		}
	}

	private static void disconnect(FTPClient ftpClient) {
		if (ftpClient.isConnected()) {
			try {
				ftpClient.logout();
				ftpClient.disconnect();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
