package id.go.ojk.client.service.ftp;

import static id.go.ojk.client.service.ReferenceService.messageConfig_SendFileSuccess;
import static id.go.ojk.client.service.ReferenceService.messageConfig_SendFileSuccess_header;
import static id.go.ojk.client.service.ReferenceService.messageConfig_SendFileSuccess_title;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_applicationVersion;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_metadataVersion;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_referenceDataVersion;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_setupVersion;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_submissionFTP;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_totalFileSize;
import static id.go.ojk.lib.client.model.update.ClientComponents.clApplication;
import static id.go.ojk.lib.client.model.update.ClientComponents.clMetadata;
import static id.go.ojk.lib.client.model.update.ClientComponents.clReferences;
import static id.go.ojk.lib.client.model.update.ClientComponents.clSetup;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import id.go.ojk.client.module.tpp.EReportTpp;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.io.CopyStreamAdapter;
import org.apache.http.client.ClientProtocolException;

import com.thoughtworks.xstream.XStream;

import id.go.ojk.client.api.ApiAbsensi;
import id.go.ojk.client.api.ApiCheckUpload;
import id.go.ojk.client.api.ApiInitUpload;
import id.go.ojk.client.api.ApiPrivateKey;
import id.go.ojk.client.api.ApiUpload;
import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.constant.EFtpServer;
import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.constant.EReportGroup;
import id.go.ojk.client.constant.EVersion;
import id.go.ojk.client.dto.DtoAbsensiRequest;
import id.go.ojk.client.dto.DtoAbsensiResponse;
import id.go.ojk.client.dto.DtoCheckUploadRequest;
import id.go.ojk.client.dto.DtoCheckUploadResponse;
import id.go.ojk.client.dto.DtoInitUploadRequest;
import id.go.ojk.client.dto.DtoInitUploadResponse;
import id.go.ojk.client.dto.DtoPrivateKeyRequest;
import id.go.ojk.client.dto.DtoPrivateKeyResponse;
import id.go.ojk.client.dto.DtoUploadRequest;
import id.go.ojk.client.dto.DtoUploadResponse;
import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.module.apu.EReportApu;
import id.go.ojk.client.module.bpjs.EReportBpjs;
import id.go.ojk.client.module.lb.EReportLb;
import id.go.ojk.client.module.lbk.EReportLbk;
import id.go.ojk.client.module.lt.EReportLt;
import id.go.ojk.client.module.pls.EReportPls;
import id.go.ojk.client.module.rb.EReportRb;
import id.go.ojk.client.module.sa.EReportSa;
import id.go.ojk.client.module.tl.EReportTl;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.HttpService;
import id.go.ojk.client.service.ServiceUpload;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.client.service.base.BaseService;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.lib.client.EncryptionUtil;
import id.go.ojk.lib.client.HttpUtil;
import id.go.ojk.lib.client.ThreadUtil;
import id.go.ojk.lib.client.TimeCounter;
import id.go.ojk.lib.client.model.ProxyConfig;
import id.go.ojk.lib.client.model.bind.SendingModel;
import id.go.ojk.lib.client.model.bind.StatusCallback;
import id.go.ojk.lib.client.model.constant.ConfigVersion;
import id.go.ojk.lib.client.model.constant.ConnectionType;
import id.go.ojk.lib.client.model.constant.OjkClientConstant;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.model.update.UpdateHeader;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import id.go.ojk.lib.client.service.ftp.FtpConnectionParameter;
import id.go.ojk.lib.client.service.ftp.FtpResult;
import javafx.scene.control.Alert.AlertType;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FtpService extends BaseService {
	private ConfigService configService;
	private HttpService httpService;
	private SecurityService securityService;
	private SetupService setupService;	
	private String ftpHost;
	private String ftpHost2;
	private int ftpPort;
	private String ftpUser;
	private String ftpPass;
	private FTPClient ftpClient;
	private boolean develRootFTP = ConfigVersion.DEVEL_ROOT_FTP;	// True jika menggunakan server devel

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		super.setApplicationContext(applicationContext);
		this.configService = applicationContext.getService(ConfigService.class);
		this.httpService = appContext.getService(HttpService.class);
		this.securityService = appContext.getService(SecurityService.class);
		this.setupService = appContext.getService(SetupService.class);
		
		this.ftpHost = setupService.getClientFtpHost();
		this.ftpHost2 = setupService.getClientFtpHost2();
		this.ftpPort = setupService.getClientFtpPort();
		this.ftpUser = setupService.getClientFtpUser();
		this.ftpPass = setupService.getClientFtpPass().substring(10);
		this.develRootFTP = ftpHost.equals(ClientConstant.DEV_FTP_HOST);
		this.ftpClient = new FTPClient();
	}
	
	public boolean isLoginFTP(String ftpServer, boolean alertStatus) {
		boolean ftpLogin = false;
		String host = ftpHost;
		int port = ftpPort;
		try {
			if (ftpServer.equalsIgnoreCase(EFtpServer.FTP02.name())) {
				host = ftpHost2;
			}
			if (host.isEmpty()) {
				if (alertStatus) {
					AlertUtil.showErrorSafe(log, "Gagal terhubung ke server!", null);
				} else {
					log.error("FTP Host Kosong..");
				}
				
				return false;
			}
			ftpClient.connect(host, port);
			ftpLogin = ftpClient.login(ftpUser, ftpPass);
			log.info(ftpClient.getReplyString() + " (isLoginFTP)");
			if (!ftpLogin && alertStatus) {
				AlertUtil.showErrorSafe(log, "Gagal terhubung ke server!", null);
				return false;
			}
			ftpClient.setCharset(StandardCharsets.UTF_8);
			ftpClient.setBufferSize(0);
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);
			ftpClient.enterLocalPassiveMode();
		} catch (Exception e) {
			log.error("Gagal terhubung ke server " + host + ":" + port);
			if (alertStatus) {
				AlertUtil.showErrorSafe(log, "Gagal terhubung ke server!", e);
			}
			return false;
		}
		
		return ftpLogin;
	}
	
	@SneakyThrows
	private String getSignatureFtp() {
		if(!isLoginFTP(EFtpServer.FTP01.name(), true)) {
			return "";
		}
		String res = "";
		ftpClient.enterLocalPassiveMode();
		if (develRootFTP) {
			ftpClient.changeWorkingDirectory(setupService.getMemberCode());		// Khusus untuk Devel
		}
		ftpClient.changeWorkingDirectory("Config");
		try (InputStream rsaKey = ftpClient.retrieveFileStream("rsaPrivate.key");) {
			res = IOUtils.toString(rsaKey);
			disconnect(ftpClient);
		}
		return res;
	}
	
	public boolean readSignatureFile(SendingModel sendingModel) {
		HashMap<String, String> signatureData = new HashMap<>();
		try (FileInputStream inputStream = new FileInputStream(sendingModel.getSignatureFile());) {
			String rsaKey = securityService.useSendApi() ? new ServiceUpload().getPrivateKey() : getSignatureFtp();
			byte[] encrypted = IOUtils.toByteArray(inputStream);
			try {
				byte[] decrypted = EncryptionUtil.rsaDecryption(rsaKey, encrypted);
				String decString = new String(decrypted);
				String fixDecString = decString.replace("\\", "");
				String[] listData = fixDecString.split("[\n]");
				
				for (String data : listData) {
					String[] dataDetil = data.split("[=]");
					
					if (dataDetil.length == 2) {
						signatureData.put(dataDetil[0], dataDetil[1].substring(0, (dataDetil[1].length() - 1)));
					}
				}
				
				// validasi signature file
				if (!sendingModel.getSignatureFile().getName().equals(signatureData.get(sigKey_submissionFTP) + ".signature.part1")) {
					AlertUtil.showErrorSafe(log, "File signature tidak valid, lakukan validasi ulang kembali!", null);
					return false;
				}
				
				// Ukuran file Data
				if (getTotalZip(sendingModel) != Long.parseLong(signatureData.get(sigKey_totalFileSize))) {
					AlertUtil.showErrorSafe(log, "File zip tidak valid, lakukan validasi ulang kembali!", null);
					return false;
				}
				//System.out.println(sendingModel.getReadyToSendFiles().get(0).length());
				//System.out.println(signatureData.get(sigKey_totalFileSize));
				
				// Member code
				//System.out.println(setupService.getMemberCode());
				//System.out.println(signatureData.get(sigKey_memberCode));
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				AlertUtil.showErrorSafe(log, "Gagal cek file signature! lakukan validasi ulang kembali!", e);
				return false;
			}

			sendingModel.setSignatureData(signatureData);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			AlertUtil.showErrorSafe(log, "Gagal cek file signature!", e);
		}
		return false;
	}

	private long getTotalZip(SendingModel sendingModel) {
		long res = 0;
		List<File> listZip = sendingModel.getReadyToSendFiles();
		if (listZip != null) {
			for (File file : listZip) {
				res += file.length();
			}
		}
		return res;
	}

	
	public boolean uploadFTP(SendingModel sendingModel, int reportFormGroupCode) {
		String reportCode = securityService.getUserSession().getReportCode();
		String sectorCode = setupService.getSectorCode();
		String ftpServer = "";
		
		log.info("develRootFTP={}", develRootFTP);
		ftpServer = reportCode.equals("LBBPRK") ? EFtpServer.FTP02.name() : EFtpServer.FTP01.name();
		log.info("ftpServer={}", ftpServer);
		if (!sendingModel.getTransferedDir().exists()) {
			sendingModel.getTransferedDir().mkdirs();
		}
		try (PrintWriter writer = new PrintWriter(sendingModel.getTransferedDir() + File.separator + "sending.log", "UTF-8");) {
			if (!isLoginFTP(ftpServer, true)) {
				return false;
			}
			sendingModel.getProgressModel().setOnProcess(true);
			TimeCounter timeCounter = new TimeCounter();
//			if (!ftpClient.changeWorkingDirectory(setupService.getMemberCode())) {
//				ftpClient.makeDirectory(setupService.getMemberCode());
//				ftpClient.changeWorkingDirectory(setupService.getMemberCode());
//			}
			
			if(develRootFTP) {
				boolean res = ftpClient.changeWorkingDirectory(setupService.getMemberCode());		// Khusus untuk Devel
				log.info("Change to {}={}", setupService.getMemberCode(), res);
			}
			
			initReportCodePath(sectorCode, reportCode, reportFormGroupCode);
//			if (!ftpClient.changeWorkingDirectory(reportCode)) {
//				boolean res = ftpClient.makeDirectory(reportCode);
//				log.info("Create directory {}={}", reportCode, res);
//				res = ftpClient.changeWorkingDirectory(reportCode);
//				log.info("Change to {}={}", reportCode, res);
//			}			

			// Test Read directory FTP
			// readFtpDirectory(ftpClient.listFiles());
			
			File submissionDir = sendingModel.getReadyToSendDir().getAbsoluteFile();
			if (!submissionDir.exists()) {
				sendingModel.getProgressModel().writeProcessLog("Sending - Direktori file kirim tidak ditemukan!");
				return false;
			}			
			List<File> files = Arrays.asList(submissionDir.listFiles());
			/**
			 * TO DO
			 * Need to save detail file info to signature
			 */
//			if (!validateLocalFile(files, sendingModel)) {
//				AlertUtil.showErrorSafe(log, "File tidak valid, lakukan validasi ulang kembali!", null);
//				return false;
//			}
			
			// Create and change directory
			String[] submissionFTP = files.get(0).getName().split("[-]");//yyyymmdd
			String fileDate = submissionFTP[3];
			String dateReport = fileDate.substring(0, 4) + "-" + fileDate.substring(4, 6) + "-" + fileDate.substring(6);	
			String dirPath = genReportPath(sectorCode, reportCode, reportFormGroupCode) + "/" + dateReport;
			if (!makeDirectories(ftpClient, dirPath)) {
				sendingModel.getProgressModel().writeProcessLog("Sending - Gagal membentuk direktori file kirim!");
				return false;
			}	
			// send file
//			String etlInfo = "OR-" + reportCode + "-" + sectorCode + "-" + submissionFTP[4] + "-" + fileDate + ".txt";
			File etlAddFile = genEtlFile(sendingModel, submissionDir.getAbsolutePath(), reportCode, sectorCode, submissionFTP[4], fileDate, reportFormGroupCode);// new File(submissionDir + File.separator + etlInfo);
//			try (BufferedWriter bw = new BufferedWriter(new FileWriter(etlAddFile));) {
//				String dateNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
//				bw.write(sendingModel.getLoginID() + "|" + dateNow + "|" + dateNow + "||client");
//			}
			if (sendingModel.getProgressModel().isStop()) {
				throw new IOException("Inisialisasi upload dihentikan");
			}
			
			files = compareToServerFile(writer, files, etlAddFile);
			double totalPercentFile = 0;
			double percentPerFile = (double)99 / (double)files.size();
			for (File file : files) {
				if (sendingModel.getProgressModel().isStop()) {
					throw new IOException("Proses upload dihentikan");
//					AlertUtil.showAlertSafe(AlertType.WARNING, "Kesalahan", "Kesalahan", "Proses berhentikan");
//					break;
				}
				String fileName = file.getName();
				double finalPercent = totalPercentFile;
				boolean successUpload = false;
				try {
					CopyStreamAdapter streamListener = new CopyStreamAdapter() {
					    @Override
					    public void bytesTransferred(long totalBytesTransferred, int bytesTransferred, long streamSize) {
					       //this method will be called everytime some bytes are transferred

					    	double percent = (((double)totalBytesTransferred / (double)file.length()) * percentPerFile) + finalPercent;
					    	sendingModel.getProgressModel().setProgress(percent / 100);
					    	
					    }
					};
					ftpClient.setCopyStreamListener(streamListener);
					totalPercentFile += percentPerFile;
//					successUpload = ftpClient.storeFile(fileName, new FileInputStream(file));
					log.info("Uploading {}", fileName);
					successUpload = ftpStoreFile(file, fileName);
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				} finally {
					if(!successUpload) {
						sendingModel.getProgressModel().writeProcessLog(String.format("Sending - Gagal mengirim file %1$s", fileName), false);
						writer.println(String.format("Sending - file name   : %1$s ", fileName));
						writer.println(String.format("Sending - file size   : %1$s bytes", file.length()));
						writer.println(String.format("Sending - file status : Gagal Terkirim!\n"));
						log.error(successUpload + "|File " + fileName + " gagal terkirim!!!");
						writer.flush();
						return false;
					} else {
						writer.println(String.format("Sending - file name   : %1$s ", fileName));
						writer.println(String.format("Sending - file size   : %1$s bytes", file.length()));
						writer.println(String.format("Sending - file status : Berhasil Terkirim!\n"));
					}
				}
//				if(!successUpload) {
//					sendingModel.getProgressModel().writeProcessLog(String.format("Sending - Gagal mengirim file %1$s", fileName), false);
//					writer.println(String.format("Sending - file name   : %1$s ", fileName));
//					writer.println(String.format("Sending - file size   : %1$s bytes", file.length()));
//					writer.println(String.format("Sending - file status : Gagal Terkirim!\n"));
//					return false;
//				} else {
//					writer.println(String.format("Sending - file name   : %1$s ", fileName));
//					writer.println(String.format("Sending - file size   : %1$s bytes", file.length()));
//					writer.println(String.format("Sending - file status : Berhasil Terkirim!\n"));
//				}
			}			
//			ftpClient.storeFile(etlInfo, new FileInputStream(etlAddFile));
//			ftpClient.storeFile(etlAddFile.getName(), new FileInputStream(etlAddFile));

			sendingModel.getProgressModel().writeProcessLog(String.format("Pengiriman selesai dalam %1$s", timeCounter.getTimeElapseFormated()), true);
			sendingModel.setSendingSuccess(true);
			writer.flush();
			return true;
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			return false;
		} finally {
			sendingModel.getProgressModel().setProgress(1);
			disconnect(ftpClient);
			sendingModel.getProgressModel().setOnProcess(false);
		}
	}
	
	private boolean ftpStoreFile(File sourceFile, String targetFilename) {
		try (InputStream inputStream = new FileInputStream(sourceFile)) {
			return ftpClient.storeFile(targetFilename, inputStream);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}
	
	private File genEtlFile(SendingModel sendingModel, String submissionDir, String reportCode, String sectorCode,
			String ljk, String fileDate, int reportFormGroupCode) throws IOException {
		String tmpReportCode = getReportCode(reportCode, reportFormGroupCode);
		String etlInfo = "OR-" + tmpReportCode + "-" + sectorCode + "-" + ljk + "-" + fileDate + ".txt";
		File res = new File(submissionDir + File.separator + etlInfo);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(res));) {
			String dateNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
			bw.write(sendingModel.getLoginID() + "|" + dateNow + "|" + dateNow + "||client");
		}
		return res;
	}
	
	private List<File> compareToServerFile(PrintWriter logWriter, List<File> files, File etlFile) {
		List<File> res = new ArrayList<>();
		try {
			FTPFile[] ftpFiles = ftpClient.listFiles(".", FTPFile::isFile);
			if (ftpFiles == null || ftpFiles.length < 1) {
				log.info("Remote files not found");
				res.addAll(files);
				res.add(etlFile);
				return res;
			} 
			if (!compareSignFile(files)) {
				res.addAll(files);
				res.add(etlFile);
				return res;
			}
			files.forEach(v -> {
				if (!compareToServerFile(logWriter, ftpFiles, v)) {
					res.add(v);
				}
			});
			res.add(etlFile);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return res;
	}
	
	private boolean compareSignFile(List<File> files) {
		final String SIGN0 = ".signature.part0";
		for (File file : files) {
			if (file.getName().endsWith(SIGN0)) {
				try (InputStream localStream = new FileInputStream(file);
						InputStream remoteStream = ftpClient.retrieveFileStream(file.getName())) {
					if (remoteStream != null) {
						boolean res = IOUtils.contentEquals(remoteStream, localStream);
						log.info("Compare {}={}", file.getName(), res);
						completePendingCommand();
						return res;
					}
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
			}
		};
		return false;
	}
	
//	@SneakyThrows
//	private String getSignature(List<File> files) {
//		final String SIGN0 = ".signature.part0";
//		for (File file : files) {
//			if (file.getName().endsWith(SIGN0)) {
//				try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
//					Optional<String> value = stream.skip(1).findFirst();
//					if (value.isPresent()) {
//						return value.get();
//					}
//				}
//			}
//		};
//		return "";
//	}
	
	private void completePendingCommand() {
		try {
			ftpClient.completePendingCommand();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}
	
	private boolean compareToServerFile(PrintWriter logWriter, FTPFile[] ftpFiles, File localFile) {
		if (ftpFiles != null && ftpFiles.length > 0) {
			for (int i = 0; i < ftpFiles.length; i++) {
				FTPFile ftpFile = ftpFiles[i];
				if (ftpFile.isFile() && localFile.isFile()) {
					String localFileName = localFile.getName();
					long localFileSize = localFile.length();
					String remoteFileName = ftpFile.getName();
					long remoteFileSize = ftpFile.getSize();
					if (remoteFileName.equalsIgnoreCase(localFileName) && remoteFileSize == localFileSize) {
						logWriter.println(String.format("Skipped - file name   : %1$s ", localFileName));
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private String getReportCode(String reportCode, int reportFormGroupCode) {
		String res = reportCode;
		if (EReport.isFin(reportCode)) {
			if (EReport.isLb(reportCode)) {
				ReportInfo reportInfo = EReportLb.getReportInfo(reportCode, reportFormGroupCode);
				res = reportInfo.getReport().getSector().name();
			} else if (EReport.isLbk(reportCode)) {
				ReportInfo reportInfo = EReportLbk.getReportInfo(reportCode, reportFormGroupCode);
				res = reportInfo.getReport().getSector().name();
			}
		}
		return res;
	}
	
	private void initReportCodePath(String sectorCode, String reportCode, int reportFormGroupCode) throws IOException {
		if (EReport.isApuFin(reportCode) || EReport.isLbPnj(reportCode) || EReport.isPls(reportCode) || EReport.isTpp(reportCode) || EReport.isBpjsKs(reportCode) || EReport.isBpjsTk(reportCode)) {
			tryChangeDir(sectorCode);
		}
		String tmp = getReportCode(reportCode, reportFormGroupCode);
		tryChangeDir(tmp);
	}
	
	private void tryChangeDir(String dir) throws IOException {
		if (!ftpClient.changeWorkingDirectory(dir)) {
			boolean res = ftpClient.makeDirectory(dir);
			log.info("Create directory {}={}", dir, res);
			res = ftpClient.changeWorkingDirectory(dir);
			log.info("Change to {}={}", dir, res);
		}			
	}
	
	private String genReportPath(String sectorCode, String reportCode, int reportFormGroupCode) {
		StringBuilder res = new StringBuilder();
		if (EReport.isSa(reportCode)) {
			ReportInfo reportInfo = EReportSa.getReportInfo(reportCode, reportFormGroupCode);
			res.append(genReportPath(reportInfo));
		} else if (EReport.isApu(reportCode)) {
			ReportInfo reportInfo = EReportApu.getReportInfo(reportCode, reportFormGroupCode);
			res.append(genReportPath(reportInfo));
		} else if (EReport.isLb(reportCode)) {
			if (EReport.isPnm(reportCode) || EReport.isFin(reportCode) || EReport.isPnj(reportCode)) {
				ReportInfo reportInfo = EReportLb.getReportInfo(reportCode, reportFormGroupCode);
				res.append(genReportPath(reportInfo));
			} else {
				res.append("0").append(reportFormGroupCode);
			}
		} else if (EReport.isLbk(reportCode)) {
			ReportInfo reportInfo = EReportLbk.getReportInfo(reportCode, reportFormGroupCode);
			res.append(genReportPath(reportInfo));
		} else if (EReport.isTl(reportCode)) {
			ReportInfo reportInfo = EReportTl.getReportInfo(reportCode, reportFormGroupCode);
			res.append(genReportPath(reportInfo));
		} else if (EReport.isPls(reportCode)) {
			ReportInfo reportInfo = EReportPls.getReportInfo(reportCode, reportFormGroupCode);
			res.append(genReportPath(reportInfo));
		} else if (EReport.isTpp(reportCode)) {
			ReportInfo reportInfo = EReportTpp.getReportInfo(reportCode, reportFormGroupCode);
			res.append(genReportPath(reportInfo));
		} else if (EReport.isBpjsKs(reportCode) || EReport.isBpjsTk(reportCode)) {
		  	ReportInfo reportInfo = EReportBpjs.getReportInfo(reportCode, reportFormGroupCode);
      		res.append(genReportPath(reportInfo));
		} else {
			res.append("0").append(reportFormGroupCode);
		}
		log.info("Report path={}", res);
		return res.toString();
	}
	
	private String genReportPath(ReportInfo reportInfo) {
		log.info("reportInfo={}", reportInfo);
		StringBuilder res = new StringBuilder();
		res.append(reportInfo.getReportTypeCode());
		res.append("/");
		if (EReport.isApuFin(reportInfo.getReport().getCode()) || EReport.isLbPnj(reportInfo.getReport().getCode()) || EReport.isBpjsKs(reportInfo.getReport().getCode()) || EReport.isBpjsTk(reportInfo.getReport().getCode())) {
			res.append("0").append(reportInfo.getReportGroup().getRevisionCode() + 1);
		} else {
			res.append(reportInfo.getReportTypeCode()).append("-").append(reportInfo.getReportGroup().getDeliveryCode());
		}
		return res.toString();
	}
	
	public boolean checkUpdate(Map<String, String> clientVersions, XStream xstream) {
		try {
//			ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));
			if(!isLoginFTP(EFtpServer.FTP01.name(), true)) {
				return false;
			}
			
			ftpClient.enterLocalPassiveMode();
			ftpClient.changeWorkingDirectory(setupService.getMemberCode());
			ftpClient.changeWorkingDirectory("Config");			
			
			File headerFile = new File("resources/update.xml");
			OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(headerFile));
			boolean success = ftpClient.retrieveFile("header.xml", outputStream1);
			outputStream1.close();
			
			boolean appNeedUpdate = false;
			boolean datNeedUpdate = false;
			
			if (success) {
				UpdateHeader serverUpdateHeader = (UpdateHeader) xstream.fromXML(headerFile);
				Map<String, String> serverVersion = serverUpdateHeader.getVersions();
				appNeedUpdate = !StringUtils.equals(serverVersion.get(EVersion.APPLICATION.getId()), 
						clientVersions.get(EVersion.APPLICATION.getId()));
				datNeedUpdate = !(StringUtils.equals(serverVersion.get(EVersion.METADATA.getId()), 
						clientVersions.get(EVersion.METADATA.getId())) && 
						StringUtils.equals(serverVersion.get(EVersion.REFERENCES.getId()), 
								clientVersions.get(EVersion.REFERENCES.getId())));
			} else {
				log.error("Failed to retrieve header.xml!!!");
				return false;
			}
			if (appNeedUpdate & datNeedUpdate) {
				AlertUtil.showAlertSafe(AlertType.INFORMATION, "Download Installer Client", "Download Installer Client", 
						"Aplikasi Client perlu diperbaharui.\n"
						+ "Download dan install ulang aplikasi Client terbaru melalui website APOLO.\n"
						+ "Setelah selesai, ulangi proses validasi kembali.");
				
				return false;
			} else if (appNeedUpdate & !datNeedUpdate) {
				AlertUtil.showAlertSafe(AlertType.INFORMATION, "Download Installer Client", "Download Installer Client", 
						"Aplikasi Client perlu diperbaharui.\n"
						+ "Download dan install ulang aplikasi Client terbaru melalui website APOLO.\n"
						+ "Setelah selesai, ulangi proses validasi kembali.");
				
				return false;
			} else if (!appNeedUpdate & datNeedUpdate) {
				AlertUtil.showAlertSafe(AlertType.INFORMATION, "Download Update Data", "Download Update Data",
						"Data aplikasi Client perlu diperbaharui.\n"
						+ "Download file update data melalui website APOLO.\n"
						+ "Lakukan update data melalui MENU UPDATE OFFLINE. \n"
						+ "Setelah selesai, ulangi proses validasi kembali.");
				
				return false;
			} else {
//				disconnect(ftpClient);
				return true;
			}			
		} catch (IOException e) {
			log.error(e.getMessage());
			return false;
		} finally {
			disconnect(ftpClient);
		}	
	}
	
	public Map<String, String> getClientVersion(SendingModel sendingModel){		
		Map<String, String> clientVersion = new HashMap<>();
		clientVersion.put(clApplication.getName(), 		sendingModel.getSignatureData().get(sigKey_applicationVersion));
		clientVersion.put(clSetup.getName(), 			sendingModel.getSignatureData().get(sigKey_setupVersion));
		clientVersion.put(clReferences.getName(), 		sendingModel.getSignatureData().get(sigKey_referenceDataVersion));
		clientVersion.put(clMetadata.getName(), 		sendingModel.getSignatureData().get(sigKey_metadataVersion));
		
		return clientVersion;
	}

	private boolean makeDirectories(FTPClient ftpClient, String dirPath) throws IOException {
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

	private void disconnect(FTPClient ftpClient) {
		if (ftpClient.isConnected()) {
			try {
				ftpClient.logout();
				ftpClient.disconnect();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void uploadAsync(SendingModel sendingModel, int jenisPelaporan) throws Exception {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
//					if (isLoginAndUploadFTP(sendingModel, jenisPelaporan, true)) {
					if (uploadFTP(sendingModel, jenisPelaporan)) {
//					if (upload(sendingModel, true)) {
						sendingModel.getProgressModel().updateStatus(StatusCallback.success);
						AlertUtil.showAlertSafe(AlertType.INFORMATION, 
								getMessage(messageConfig_SendFileSuccess_title), 
								getMessage(messageConfig_SendFileSuccess_header),
								getMessage(messageConfig_SendFileSuccess));
					} else {
						sendingModel.getProgressModel().updateStatus(StatusCallback.error);
					}

					if (sendingModel.getProgressModel().isStop()
							&& sendingModel.getProgressModel().isShowAlertOnStop()) {
						AlertUtil.showAlertSafe(AlertType.ERROR, "Kesalahan", "Kesalahan", "Proses berhentikan");
					}
				} catch (Exception e) {
					AlertUtil.showErrorSafe(log, "Error saat men", e);
					sendingModel.getProgressModel().updateStatus(StatusCallback.error);
				}
			}
		}).start();
	}

	public boolean upload(SendingModel sendingModel, boolean alertOnFinish)
			throws ClientProtocolException, IOException, URISyntaxException {
		try {
			// adjust length 2, x, 8
			long originalLength = sendingModel.getProgressModel().getTotalLength();
			long totalLength = (long) (1.1 * originalLength);
			sendingModel.getProgressModel().setTotalLength(totalLength);

			sendingModel.getProgressModel().setOnProcess(true);

			TimeCounter timeCounter = new TimeCounter();
			sendingModel.getProgressModel().writeProcessLog(
					String.format("Pengiriman %1$s", sendingModel.getReadyToSendDir().getAbsolutePath()), true);

			UserSession userSession = securityService.getUserSession();
			FtpConnectionParameter parameter = new FtpConnectionParameter(configService.getServerAddress(),
					OjkClientConstant.getFtpsPort(configService.isExtranetConnectionType()),
					userSession.getUser().getUserLoginId(), userSession.getPlainPassword(),
					configService.getProxyConfig());

			// ~ upload signature

			sendingModel.getProgressModel().writeProcessLog(String.format("Pengiriman - Signature"), false);
			while (!sendingModel.getProgressModel().isStop()) {
				try {
					// httpService.logout();
					Map<String, Object> responseMap = httpService.sendSignature(sendingModel);
					if (HttpUtil.isSuccessResponse(responseMap)) {
						sendingModel.getProgressModel().writeProcessLog("Pengiriman - Signature sukses");
						break;
					}
					if (HttpUtil.isNeedRelogin401(responseMap)) {
						sendingModel.getProgressModel().writeProcessLog("Pengiriman - Signature login ulang");
						securityService.relogin();
					} else {
						String message = HttpUtil.getMessage(responseMap);
						AlertUtil.showErrorSafe(log, "gagal Mengirim signature, " + message, null);
						return false;
					}
				} catch (Throwable t) {
					log.error(t.getMessage(), t);
					sendingModel.getProgressModel().writeProcessLog("Pengiriman - Signature error : " + t.getMessage());
				}
				ThreadUtil.sleep(2000);
			}

			if (sendingModel.getProgressModel().isStop())
				return false;

			// sendingModel.getProgressModel().addProgress((long)(0.01 *
			// originalLength));
			sendingModel.getProgressModel().writeProcessLog(String.format("Pengiriman - Signature - Selesai"), false);

			// ~ upload data

			sendingModel.getProgressModel().writeProcessLog(String.format("Pengiriman - Data"), false);
			sendingModel.setFtpResult(new FtpResult());
			FTPsTaskManager ftPsTaskManager = new FTPsTaskManager(sendingModel, parameter, 4);
			ftPsTaskManager.startTask();

			if (sendingModel.getProgressModel().isStop())
				return false;
			sendingModel.getProgressModel().writeProcessLog(String.format("Pengiriman - Data - Selesai"), false);

			// ~upload ready

			sendingModel.getProgressModel().writeProcessLog(String.format("Pengiriman - Ready"), false);
			while (!sendingModel.getProgressModel().isStop()) {
				try {
					Map<String, Object> responseMap = httpService.sendReady(sendingModel.getSubmissionId());
					if (HttpUtil.isSuccessResponse(responseMap)) {
						sendingModel.getProgressModel().writeProcessLog("Pengiriman - Ready sukses");
						// sendingModel.getProgressModel().setProgress(0.99);
						break;
					}
					if (HttpUtil.isNeedRelogin401(responseMap)) {
						sendingModel.getProgressModel().writeProcessLog("Pengiriman - Ready login ulang");
						securityService.relogin();
					} else {
						String message = HttpUtil.getMessage(responseMap);
						AlertUtil.showErrorSafe(log, "gagal Mengirim Ready, " + message, null);
						return false;
					}
				} catch (Throwable t) {
					log.error(t.getMessage(), t);
					sendingModel.getProgressModel().writeProcessLog("Pengiriman - Signature error : " + t.getMessage());
				}
				ThreadUtil.sleep(2000);
			}

			if (sendingModel.getProgressModel().isStop())
				return false;
			sendingModel.getProgressModel().writeProcessLog(String.format("Pengiriman - Ready - Selesai"), false);

			// ~ cek status ready

			sendingModel.getProgressModel().writeProcessLog(String.format("Pengiriman - Cek Status Ready"), false);

			int counter = 0;
			while (!sendingModel.getProgressModel().isStop()) {
				try {
					Map<String, Object> responseMap = httpService.cekStatusReady(sendingModel.getSubmissionId());
					if (HttpUtil.isSuccessResponse(responseMap)) {
						Map<String, Object> payload = HttpUtil.getPayload(responseMap);
						String status = (String) payload.get("status");
						if ("OK".equals(status)) {
							sendingModel.getProgressModel().writeProcessLog("Pengiriman - Cek Status Ready sukses");
							sendingModel.getProgressModel().setProgress(0.99);
							break;
						} else {
							sendingModel.getProgressModel().writeProcessLog("Pengiriman - Cek Status Ready " + status);
							continue;
						}
					}
					if (HttpUtil.isNeedRelogin401(responseMap)) {
						sendingModel.getProgressModel().writeProcessLog("Pengiriman - Ready login ulang");
						securityService.relogin();
					} else {
						String message = HttpUtil.getMessage(responseMap);
						AlertUtil.showErrorSafe(log, "gagal Mengirim Ready, " + message, null);
						return false;
					}
				} catch (Throwable t) {
					log.error(t.getMessage(), t);
					sendingModel.getProgressModel().writeProcessLog("Pengiriman - Signature error : " + t.getMessage());
				} finally {
					log.info("counter " + counter);
					counter++;
					if (counter >= 10) {
						log.info("sleep 10000");
						ThreadUtil.sleep(10000);
					} else {
						log.info("sleep counter * 1000");
						ThreadUtil.sleep(counter * 1000);
					}
				}
			}

			if (sendingModel.getProgressModel().isStop())
				return false;
			sendingModel.getProgressModel().writeProcessLog(String.format("Pengiriman - Ready - Selesai"), false);

			// move file
			sendingModel.getTransferedDir().getParentFile().mkdirs();
			java.nio.file.Files.move(Paths.get(sendingModel.getReadyToSendDir().getAbsolutePath()),
					Paths.get(sendingModel.getTransferedDir().getAbsolutePath()));

			sendingModel.getProgressModel().writeProcessLog(
					String.format("Pengiriman selesai dalam %1$s", timeCounter.getTimeElapseFormated()), true);
			sendingModel.getProgressModel().setProgress(1);
			sendingModel.setSendingSuccess(true);
			if (alertOnFinish)
				AlertUtil.showAlertSafe(AlertType.INFORMATION, "Pengiriman Sukses", "Pengiriman Sukses",
						"File kirim telah berhasil dikirim ke server OJK!");
			return true;
		} finally {
			sendingModel.getProgressModel().setOnProcess(false);
		}
	}

	public List<String> readReadyToSend(SendingModel model) {
		model.reset(true);
		List<String> errors = new ArrayList<String>();

		if (!model.getReadyToSendDir().exists()) {
			errors.add("Direktori tidak ditemukan!");
			return errors;
		}

		if (!model.getReadyToSendDir().isDirectory()) {
			errors.add("Bukan direktori!");
			return errors;
		}

		List<File> files = Arrays.asList(model.getReadyToSendDir().listFiles());
		if (files.isEmpty()) {
			errors.add("Direktori Kosong!");
			return errors;
		}
		if (files.size() < 3) {
			errors.add("Jumlah File kirim tidak sesuai!");
			return errors;
		}

		// cari file signature part 1
		File signatureFile = null;
		List<File> files2 = new ArrayList<>();
		for (File file : files) {
			String fileName = file.getName();
			if (!file.isDirectory() && "signature.part1".equals("signature." + FilenameUtils.getExtension(fileName)) && signatureFile == null) {
				signatureFile = file;
			} else {
				files2.add(file);
			}
		}
		if (signatureFile == null) {
			errors.add("File signature .part1 tidak ditemukan!");
			return errors;
		}

		// cari file signature part 0
		String baseName = StringUtils.substring(signatureFile.getName(), 0, signatureFile.getName().indexOf("."));//stripExtension();
		String prefixSignature = baseName + ".signature.part0";
		File signatureFileTxt = null;
		List<File> files3 = new ArrayList<>();		
		for (File file : files2) {
			String fileName = file.getName();
			if (!file.isDirectory() && prefixSignature.equals(fileName) && signatureFileTxt == null) {
				signatureFileTxt = file;
			} else {
				files3.add(file);
			}
		}
		if (signatureFileTxt == null) {
			errors.add(String.format("Nama file signature harus %1$s", prefixSignature));
			return errors;
		}
		
		String entityCodeReady = baseName.split("[-]")[4];
		if (!entityCodeReady.equals(setupService.getMemberCode())) {
			errors.add("file kirim tidak sesuai dengan LJK anda!");
			return errors;
		}
		
		String prefix = baseName + ".zip.part";

		// cek direktori dan harus .zip.part
		List<File> files4 = new ArrayList<>();

		for (File file : files3) {
			List<String> tmpErrors = new ArrayList<String>();
			String fileName = file.getName();
			if (file.isDirectory()) {
				tmpErrors.add(String.format("Tidak boleh ada direktori '%1$s'", fileName));
			} else {
				if (!fileName.startsWith(prefix)) {
					tmpErrors.add(String.format("Nama file %1$s seharusnya diawali '%2$s'", fileName, prefix));
				} else if (!StringUtils.isNumeric(fileName.substring(prefix.length()))) {
					tmpErrors.add(String.format("Nama file %1$s seharusnya diakhiri dengan angka", fileName));
				}
			}
			
			if (tmpErrors.isEmpty()) {
				files4.add(file);
			} else {
				errors.addAll(tmpErrors);
			}
		}

		if (files4.isEmpty()) {
			errors.add("File zip tidak ditemukan!");
			return errors;
		}

		if (errors.isEmpty()) {
			model.setSignatureFile(signatureFile);
			model.setSignatureFileTxt(signatureFileTxt);
			model.setReadyToSendFiles(files4);
			model.setReadFile(true);
		}

		return errors;
	}

	public Map<String, Object> checkSignature(SendingModel sendingModel) throws ClientProtocolException, IOException {
		HttpService httpService = appContext.getService(HttpService.class);
		Map<String, Object> map = httpService.checkSignature(sendingModel);
		return map;
	}

	public boolean sendConnectionTest() throws Exception {
		return sendConnectionTest(configService.geConnectionType(), configService.getProxyConfig());
	}

	public boolean sendConnectionTest(ConnectionType connectionType, ProxyConfig proxyConfig) throws Exception {
		try (FTPsUploader uploader = openFTPs(connectionType, proxyConfig)) {
			if (!uploader.login().getA())
				return false;
			return uploader.uploadTestConnection();
		}
	}

	private FTPsUploader openFTPs(ConnectionType connectionType, ProxyConfig proxyConfig) throws Exception {
		UserSession userSession = securityService.getUserSession();
		FtpConnectionParameter parameter = FtpConnectionParameter.builder()
				.host(OjkClientConstant.getServerAddress(connectionType))
				.port(OjkClientConstant.getFtpsPort(connectionType)).userName(userSession.getUser().getUserLoginId())
				.password(userSession.getPlainPassword()).proxyConfig(proxyConfig).build();

		parameter.setPassword(securityService.getUserSession().getSessionId());
		FTPsUploader uploader = new FTPsUploader(parameter);
		return uploader;
	}
	
	private boolean validateLocalFile(List<File> realFiles, SendingModel sendingModel) {
		if (realFiles != null) {
			for (File file : realFiles) {
				if (!validateLocalFile(file, sendingModel)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean validateLocalFile(File realFile, SendingModel sendingModel) {
		String filename = realFile.getName();
		for (File file : sendingModel.getReadyToSendFiles()) {
			if (filename.toLowerCase().indexOf(".signature.part") > 0) {
				return true;
			}
			if (filename.equals(file.getName())) {
				if (file.lastModified() == realFile.lastModified()) {
//					System.out.println(filename + "|" + realFile.lastModified() + "|" + file.lastModified());
					return true;
				} else {
//					System.out.println(filename + "|" + realFile.lastModified() + "|" + file.lastModified());
					log.error("{}, invalid file datetime, actual {}, expected {}", filename, realFile.lastModified(), file.lastModified());
					return false;
				}
			}
		}
		return false;
	}
//	
//	private static String stripExtension(String str) {
//		// Handle null case specially.
//		if (str == null)
//			return null;
//
//		// Get position of last '.'.
//		int pos = str.lastIndexOf(".");
//
//		// If there wasn't any '.' just return the string as is.
//		if (pos == -1)
//			return str;
//
//		// Otherwise return the string, up to the dot.
//		return str.substring(0, pos);
//	}
//
}
