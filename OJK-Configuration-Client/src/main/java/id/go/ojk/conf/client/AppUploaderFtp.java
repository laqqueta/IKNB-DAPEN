package id.go.ojk.conf.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPHTTPClient;

import id.go.ojk.client.constant.EFtpServer;
import id.go.ojk.conf.client.dto.DtoFtpInfo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class AppUploaderFtp extends BaseAppConsole {
//	private static Logger log = LoggerFactory.getLogger(AppUploaderFtp.class);
	private static DtoFtpInfo ftp;
	private static DtoFtpInfo ftp2;
//	private static String ftpHost;
//	private static int ftpPort;
//	private static String ftpUser;
//	private static String ftpPass;
//	private static String ftpHost2;
//	private static String ftpUser2;
//	private static String ftpPass2;
	private static String proxyHost = "";
	private static int proxyPort = 8080;
	private static String proxyUser = "arnol.faizal";
	private static String proxyPass = "";
	private static FTPClient ftpClient = null;
	private static String enviType = EEnvironment.DEVEL.name();

//	public static void main(String[] args) throws FileNotFoundException, IOException {
//		final String ftpServer = "FTP01";
//		final String sectorCode = "031201";
//		final String ftpFolder = "D:\\_workspace\\wdg\\ojk\\v1.0.0\\OJK-ASRJK\\_installer\\ftp";
//		final String datFtpFolder = "D:\\_workspace\\wdg\\ojk\\v1.0.0\\OJK-ASRJK\\_installer\\datFtp";
//		
//		allTask(ftpServer, sectorCode, ftpFolder, datFtpFolder);
//	}

	public static void upload(String[] args) {
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
	
	public static void setEnvi(String enviType) {
		AppUploaderFtp.enviType = enviType;
		if (StringUtils.isNotEmpty(enviType)) {
			DummyServerConfig serverConfig = DummyEnvironment.config(enviType);
			ftp =  serverConfig.getFtp();
			ftp2 = serverConfig.getFtp2();
//			ftpHost = serverConfig.getFtpHostInternal();
//			ftpPort = serverConfig.getFtpPort();
//			ftpUser = serverConfig.getFtpUser();
//			ftpPass = serverConfig.getFtpPass();
//			ftpHost2 = serverConfig.getFtpHost2();
//			ftpUser2 = serverConfig.getFtpUser2();
//			ftpPass2 = serverConfig.getFtpPass2();
		}
	}
	
	public static String getParameterFtpServer(String[] args) {
		return getParameter(EConsoleParameter.FTP_SERVER.getKey(), args, EFtpServer.FTP01.name());
	}
	
	public static String getParameterEnviType(String[] args) {
		return getParameter(EConsoleParameter.ENVI_TYPE.getKey(), args, EEnvironment.OFFLINE.name());
	}
	
	public static String getParameterFtpFolder(String[] args) {
		return getParameter(EConsoleParameter.FTP_FOLDER.getKey(), args, ".\\_installer\\ftp");
	}
	
	public static String getParameterFtpAppFolder(String[] args) {
		return getParameter(EConsoleParameter.FTP_APP_FOLDER.getKey(), args, ".\\_installer\\ftp\\app");
	}
	
	public static void allTask(String ftpServer, String sectorCode, String ftpFolder, String datFtpFolder) {
		log.info("---- Transfering all data to FTP Server ----");
		sendVersionToFtp(ftpServer, sectorCode, ftpFolder);
		sendClientDatToFtp(ftpServer, datFtpFolder);
		copyVersionToEntity(ftpServer, sectorCode, datFtpFolder);
	}

	public static Map<String, String> getFTPAccount(String sectorCode) {
		Map<String, String> ftpAccountMap = new HashMap<>();
		if (isLogin(EFtpServer.FTP01.name())) {
			String filename = "/CLIENT_CONFIG/" + sectorCode + "/access.txt";
			try (InputStream is = ftpClient.retrieveFileStream(filename);) {
				if (is != null) {
					ftpAccountMap.putAll(getAccess(is));
				} else {
					log.error("Failed to retrieve '" + filename + "'!!!");
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			} finally {
				disconnect();
			}
		}
		return ftpAccountMap;
	}
	
	private static Map<String, String> getAccess(InputStream is) {
		Map<String, String> res = new HashMap<>();
		try (InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);) {
			ftpClient.completePendingCommand();
			String listFtpAccount;
			while ((listFtpAccount = br.readLine()) != null) {
				String[] splitFtpAccount = StringUtils.split(listFtpAccount, "[|]");
				String ftpUser = splitFtpAccount[0].trim();
				String ftpPass = splitFtpAccount[1].trim();
				res.put(ftpUser, ftpPass);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return res;
	}

	public static List<String> readListEntityFTP() {
		List<String> listEntityFTP = new ArrayList<>();
		if (isLogin(EFtpServer.FTP01.name())) {
			try {
				// use local passive mode to pass firewall
				boolean changeDir = ftpClient.changeWorkingDirectory("DOWNLOAD/INSTALLER/APP_CLIENT");
				log.info("Change dir={};Working dir={}", changeDir, ftpClient.printWorkingDirectory());
				FTPFile[] files = ftpClient.listFiles();
				for (FTPFile ftpFile : files) {
					listEntityFTP.add(ftpFile.getName());
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			} finally {
				disconnect();
			}
		}

		return listEntityFTP;
	}

	public static void cutFolder() {
		ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));
		if (isLogin("FTP02")) {
			try {
				FTPFile[] listSourceFile = ftpClient.listFiles();

				for (FTPFile ftpFile : listSourceFile) {
					if (ftpFile.getName().length() == 6) {
						String existingFilepath = ftpFile.getName() + "/LBBPRK/Config";
						String newFilepath = ftpFile.getName() + "/Config";
						log.info(existingFilepath);
//					    ftpClient.completePendingCommand();	
						ftpClient.rename(existingFilepath, newFilepath);
					}
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			} finally {
				disconnect();
			}
		}
	}

	public static void sendClientExeToFtp(String ftpServer, String appFolder) {
		File folder = new File(appFolder);
		File[] allFiles = filterFiles(folder.listFiles(), "exe") ;
		sendVersionToFtp(allFiles, ftpServer, appFolder);
		if (isLogin(ftpServer)) {
			log.info("Preparation send installer file to FTP Server...");
			try {
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);
				boolean changeDir = changeFtpDirectories("DOWNLOAD/INSTALLER/APP_CLIENT");
				log.info("Change dir={};Working dir={}", changeDir, ftpClient.printWorkingDirectory());
				sendExtToFtp(allFiles);
			} catch (IOException e) {
				log.error("Failed transfered to FTP Server!", e);
			} finally {
				disconnect();
			}
		}
	}
	
	public static void sendVersionToFtp(File[] files, String ftpServer, String appFolder) {
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			String fileName = file.getName();
			String sectorCode = fileName.substring(0, fileName.indexOf('-'));
			sendVersionToFtp(ftpServer, sectorCode, appFolder.substring(0, appFolder.lastIndexOf('\\')));
			copyVersionToEntity(ftpServer, sectorCode, appFolder);
		}
	}
	
	private static File[] filterFiles(File[] files, String ext)  {
		List<File> res = new ArrayList<>();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			if (FilenameUtils.getExtension(file.getName()).equalsIgnoreCase(ext)) {
				res.add(file);
			}
		}
		return res.toArray(new File[res.size()]);
	}

	private static void copyVersionToEntity(String ftpServer, String sectorCode, String datFolder) {
		if (isLogin(ftpServer.equals(EFtpServer.FTP02.name()) ? EFtpServer.FTP_ENTITY2.name() : EFtpServer.FTP_ENTITY.name())) {
			try {
				log.info("Preparation copy file config to entity directory...");
				File allDataDAT = new File(datFolder);

				changeFtpDirectories("CLIENT_CONFIG");
				changeFtpDirectories(sectorCode);
				changeFtpDirectories("Config");

				FTPFile[] listSourceFile = ftpClient.listFiles();
				String entityCode;

				File[] allDataDATFiles = allDataDAT.listFiles();
				for (int i = 0; i < allDataDATFiles.length; i++) {// File file : allDataDAT.listFiles()) {
					File file = allDataDATFiles[i];
					if (FilenameUtils.getExtension(file.getName()).equals("dat")) {
						entityCode = FilenameUtils.getBaseName(file.getName()).split("[-]")[2];
						String configDirPath = entityCode + "/Config"; // Untuk keperluan Cangkang
						if (copyFileVersionFTP(configDirPath, sectorCode, listSourceFile)) {
							String msg = "(" + (i + 1) + ") Success transfer File Config to " + entityCode + " directory!";
							log.info(msg);
						} else {
							String msg = "(" + (i + 1) + ") Failed transfer File Config to " + entityCode + " directory!";
							log.info(msg);
						}
					}
				}
			} catch (Exception e) {
				log.error("Failed transfer file config!", e);
			} finally {
				disconnect();
			}
		}
	}

	private static void sendClientDatToFtp(String ftpServer, String datFolder) {
		if (isLogin(ftpServer)) {
			log.info("Preparation send dat file to FTP Server...");
			try {
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);
				boolean changeDir = changeFtpDirectories("DOWNLOAD/INSTALLER/APP_CLIENT");
				log.info("Change dir={};Working dir={}", changeDir, ftpClient.printWorkingDirectory());
				File allDataDAT = new File(datFolder);
				File[] allDataDATFiles = filterFiles(allDataDAT.listFiles(), "dat");
				sendExtToFtp(allDataDATFiles);
			} catch (IOException e) {
				log.error("Failed transfered to FTP Server!", e);
			} finally {
				disconnect();
			}
		}
	}
	
	private static void sendExtToFtp(File[] allFiles) {
		for (int i = 0; i < allFiles.length; i++) {
			File file = allFiles[i];
			if (storeFTP(file)) {
				String msg = "(" + (i + 1) + ") " + file.getAbsolutePath()
						+ " success transfered to FTP Server!";
				log.info(msg);
			} else {
				String msg = "(" + (i + 1) + ") " + file.getAbsolutePath()
						+ " failed transfered to FTP Server!";
				log.info(msg);
			}
		}
	}

	private static void sendVersionToFtp(String ftpServer, String sectorCode, String ftpFolder) {
		if (isLogin(ftpServer.equals(EFtpServer.FTP02.name()) ? EFtpServer.FTP_ENTITY2.name() : EFtpServer.FTP_ENTITY.name())) {
			try {
				log.info("Preparation transfer file version...");
				changeFtpDirectories("CLIENT_CONFIG");
				changeFtpDirectories(sectorCode);
				changeFtpDirectories("Config");

				FileUtils.forceMkdir(new File(ftpFolder));
				storeFTP("header.xml", new File(ftpFolder + File.separator + "headerFTP.xml"));
				storeFTP(new File(ftpFolder + File.separator + "version.txt"));
			} catch (IOException e) {
				log.error("Failed transfer file version to FTP Server.", e);
			} finally {
				log.info("Success transfer file version to FTP Server.");
				disconnect();
			}
		}
	}

	private static boolean copyFileVersionFTP(String dirPath, String sectorCode, FTPFile[] listSourceFile) {
		boolean res = false;
		try {
			ftpClient.changeWorkingDirectory("/");
			changeFtpDirectories(dirPath);

			for (FTPFile ftpFile : listSourceFile) {
				try (InputStream is = ftpClient
						.retrieveFileStream("/CLIENT_CONFIG/" + sectorCode + "/Config/" + ftpFile.getName());) {
					ftpClient.completePendingCommand();
					res = ftpClient.storeFile(ftpFile.getName(), is);
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return res;
	}

	private static boolean changeFtpDirectories(String dirPath) throws IOException {
		String[] pathElements = StringUtils.split(dirPath, "/");
		log.info("Go to folder " + dirPath);
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

	private static boolean isLogin(String server) {
		boolean res = false;
		try {
			setFtpConnection();
			EFtpServer eFtpServer = EFtpServer.getEnum(server);
			if (eFtpServer != null) {
				String ftpHost;
				int ftpPort;
				switch (eFtpServer) {
				case FTP01:
					ftpHost = ftp.getFtpHostInternal();
					ftpPort = ftp.getFtpPort();
					log.info("ftpHost=" + ftpHost + "|ftpPort=" + ftpPort);
					if (StringUtils.isNotEmpty(ftpHost)) {
						ftpClient.connect(ftpHost, ftpPort);
						res = ftpClient.login(ftp.getFtpUser(), ftp.getFtpPass());
					}
					break;
				case FTP02:
					ftpHost = ftp2.getFtpHostInternal();
					ftpPort = ftp2.getFtpPort();
					log.info("ftpHost2=" + ftpHost + "|ftpPort2=" + ftpPort);
					if (StringUtils.isNotEmpty(ftpHost)) {
						ftpClient.connect(ftpHost, ftpPort);
						res = ftpClient.login(ftp2.getFtpUser(), ftp2.getFtpPass());
					}
					break;
				case FTP_ENTITY:
					ftpHost = EEnvironment.isProduction(AppUploaderFtp.enviType) ? EFtpInfo.PROD_ENTITY.getFtpHost() : EFtpInfo.DEV_ENTITY.getFtpHost();
					ftpPort = EEnvironment.isProduction(AppUploaderFtp.enviType) ? EFtpInfo.PROD_ENTITY.getFtpPort() : EFtpInfo.DEV_ENTITY.getFtpPort();
					log.info("ftpHostEntity=" + ftpHost + "|ftpPortEntity=" + ftpPort);
					if (StringUtils.isNotEmpty(ftpHost)) {
						ftpClient.connect(ftpHost, ftpPort);
						String user = EEnvironment.isProduction(AppUploaderFtp.enviType) ? EFtpInfo.PROD_ENTITY.getFtpUser() : EFtpInfo.DEV_ENTITY.getFtpUser();
						String pass = EEnvironment.isProduction(AppUploaderFtp.enviType) ? EFtpInfo.PROD_ENTITY.getFtpPass() : EFtpInfo.DEV_ENTITY.getFtpPass();
						res = ftpClient.login(user, pass);
					}
					break;
				case FTP_ENTITY2:
					ftpHost = EEnvironment.isProduction(AppUploaderFtp.enviType) ? EFtpInfo.PROD_ENTITY_2.getFtpHost() : EFtpInfo.DEV_ENTITY_2.getFtpHost();
					ftpPort = EEnvironment.isProduction(AppUploaderFtp.enviType) ? EFtpInfo.PROD_ENTITY_2.getFtpPort() : EFtpInfo.DEV_ENTITY_2.getFtpPort();
					log.info("ftpHostEntity=" + ftpHost + "|ftpPortEntity=" + ftpPort);
					if (StringUtils.isNotEmpty(ftpHost)) {
						ftpClient.connect(ftpHost, ftpPort);
						String user = EEnvironment.isProduction(AppUploaderFtp.enviType) ? EFtpInfo.PROD_ENTITY_2.getFtpUser() : EFtpInfo.DEV_ENTITY_2.getFtpUser();
						String pass = EEnvironment.isProduction(AppUploaderFtp.enviType) ? EFtpInfo.PROD_ENTITY_2.getFtpPass() : EFtpInfo.DEV_ENTITY_2.getFtpPass();
						res = ftpClient.login(user, pass);
					}
					break;
				default:
					break;
				}
			}
			if (!res) {
				log.error("Gagal terhubung ke server, " + ftpClient.getReplyString());
			} else {
				ftpClient.enterLocalPassiveMode();
				ftpClient.setCharset(Charset.forName("UTF-8"));
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return res;
	}

	private static boolean storeFTP(File file) {
		return storeFTP(file.getName(), file);
	}

	private static boolean storeFTP(String newFileName, File file) {
		boolean success = false;
		log.info("sending " + file.getName());
		try (FileInputStream fis = new FileInputStream(file)) {
			success = ftpClient.storeFile(newFileName, fis);
			if (success) {
				log.info(newFileName + " stored to FTP server");
			}
		} catch (Exception e) {
			log.error("Failed transfer " + file.getAbsolutePath() + " to FTP Server!", e);
		}
		return success;
	}

	private static void disconnect() {
		if (ftpClient != null && ftpClient.isConnected()) {
			try {
				ftpClient.logout();
				ftpClient.disconnect();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	private static void setFtpConnection() {
		if (ftpClient == null) {
			if (proxyHost.isEmpty()) {
				ftpClient = new FTPClient();
			} else {
				ftpClient = new FTPHTTPClient(proxyHost, proxyPort, proxyUser, proxyPass);
			}
		}
	}
}
