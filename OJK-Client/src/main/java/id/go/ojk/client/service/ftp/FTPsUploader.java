package id.go.ojk.client.service.ftp;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;
import org.apache.commons.net.ftp.FTPSHTTPClient;
import org.apache.commons.net.util.TrustManagerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.lib.client.ChunkInputStream;
import id.go.ojk.lib.client.exception.FtpException;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.exception.StopProsesException;
import id.go.ojk.lib.client.model.FileChunk;
import id.go.ojk.lib.client.model.ProxyConfig;
import id.go.ojk.lib.client.model.SubmissionIdParse;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.security.UserRole;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.service.ftp.FtpConnectionParameter;
import id.go.ojk.lib.client.util.MeteredMultiThreadIOCopyers;

public class FTPsUploader implements Closeable {

	public final static String TEST_FILENAME = "testConnection.txt";
	public final static String TEST_CONTENT = "TEST CONNECTION";
	
	private static Logger logger = LoggerFactory.getLogger(FTPsTask.class);
	private FtpConnectionParameter parameter;
	private FTPSClient ftps = null;

	public FTPsUploader(FtpConnectionParameter parameter) throws Exception {
		this.parameter = parameter;
		ProxyConfig proxyConfig = parameter.getProxyConfig();
		
		if ( proxyConfig != null && StringUtils.isNotEmpty(proxyConfig.getHost())  ){			
			ftps = new FTPSHTTPClient(proxyConfig.getHost(), proxyConfig.getPort(), proxyConfig.getUser(), proxyConfig.getPassword());
			ftps.setRemoteVerificationEnabled(false);
			ftps.setTrustManager(TrustManagerUtils.getAcceptAllTrustManager());
			ftps.setDataTimeout(1800000); // 30 			
		} else {
			ftps = new FTPSClient("SSL", true);

//			ftps.setRemoteVerificationEnabled(false);
//			ftps.setTrustManager(TrustManagerUtils.getAcceptAllTrustManager());
		}
		
		ftps.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		int reply;
		
		logger.info("FTPs host " + parameter.getHost());
		ftps.connect(parameter.getHost(), parameter.getPort());
		reply = ftps.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftps.disconnect();
			throw new FtpException("Exception in connecting to FTP Server");
		}
	}
	
	public Tupple2<Boolean, Integer> login() throws Exception {
		ftps.login(parameter.getUserName(), parameter.getPassword());
		Tupple2<Boolean, Integer> result = cekLoginStatus(true);
		if ( !result.getA() )
			return result;
			
	    ftps.setCharset(Charset.forName("UTF-8"));
	    ftps.setBufferSize(0);
	    ftps.execPROT("P");
		ftps.setFileType(FTP.BINARY_FILE_TYPE);
		ftps.enterLocalPassiveMode();
		result = cekLoginStatus(true);
		
		return result;		
	}
	
	private Tupple2<Boolean, Integer> cekLoginStatus(boolean disconnectIfNegativRespose) throws IOException{
		int replyCode = ftps.getReplyCode();
		Tupple2<Boolean, Integer> result = 
			Tupple2.<Boolean, Integer>builder()
			.a(FTPReply.isPositiveCompletion(replyCode))
			.b(replyCode)
			.build();
		if ( disconnectIfNegativRespose && !result.getA() ){
			ftps.disconnect();
		}
		return result;
	}

	public boolean uploadData(String submissionId, FileChunk fileChunk, MeteredMultiThreadIOCopyers ioCopyers) throws Exception {
		
		String fileName = fileChunk.getFile().getName();
		
		if ( !fileChunk.getFile().exists() ){
			throw new StopProsesException("File " + fileChunk.getFile().getName() + " tidak ditemukan!");
		}		
		
		SecurityService securityService = ApplicationContextClient.getInstance().getService(SecurityService.class);
		UserSession userSession = securityService.getUserSession();
		UserRole userRole =  userSession.getUser().getRole();
		
		String destDir = submissionId;
		if ( userRole == UserRole.ojk ){
			SubmissionIdParse submissionIdParse = SubmissionIdParse.fromStringThrowExceptionIfNotValid(submissionId);
			destDir = submissionIdParse.getMemberTypeCode() + "-" + submissionIdParse.getMemberCode() + "/" + submissionId ;
		}
		
		if ( !ftps.changeWorkingDirectory(destDir) )
			throw new SlikException("gagal change directory");

		ChunkInputStream inputStream = null;
		OutputStream output = null;

		boolean result = false;
		try (InputStream fis = new FileInputStream(fileChunk.getFile())) {

			FTPFile[] ftpFiles = ftps.listFiles();

			FTPFile existingFtpFile = null;
			for (FTPFile ftpFile : ftpFiles) {
				if (ftpFile.getName().equalsIgnoreCase(fileChunk.getChunkFileName())) {
					existingFtpFile = ftpFile;
				}
			}

			ftps.enterLocalPassiveMode();
			long additionalOffset = 0;

			if (existingFtpFile != null) {
				additionalOffset = existingFtpFile.getSize();
				logger.info(fileName + " Resume start form " + additionalOffset);
				output = ftps.appendFileStream(fileChunk.getChunkFileName());
			} else {
				logger.info(fileName + " Start form begining");
				output = ftps.storeFileStream(fileChunk.getChunkFileName());
			}

			ioCopyers.setByteCount(fileChunk.getChunkFileName(), additionalOffset);
			if (fileChunk.getByteLength() > additionalOffset){
				logger.info(fileName + " start copy");

				inputStream = new ChunkInputStream(fileChunk, additionalOffset);
				ioCopyers.copy(fileChunk.getChunkFileName(), inputStream, output);
				logger.info(fileName + " finish copy");
			} else {
				logger.info(fileName + " All byte already on server");
			}

		} finally {
			IOUtils.closeQuietly(inputStream);
			IOUtils.closeQuietly(output);
		}
		result = ftps.completePendingCommand();

		return result;
	}
	
	public boolean uploadTestConnection() throws IOException {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(TEST_CONTENT.getBytes());
		return ftps.storeFile(TEST_FILENAME, inputStream);
	}

	//~ util

	public void disconnect() {
		if (this.ftps.isConnected()) {
			try {
				this.ftps.logout();
				this.ftps.disconnect();
			} catch (Throwable f) {
				logger.warn("", f);
				// do nothing as file is already saved to server
			}
		}
	}

	@Override
	public void close() throws IOException {
		disconnect();
	}

}