package id.go.ojk.client.lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketException;
import java.nio.charset.Charset;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPSHTTPClient;
import org.apache.commons.net.util.TrustManagerUtils;

public class TestFtpsHttp {

	public static void main(String[] args) throws SocketException, IOException {
		test();
	}
	
	private static String proxyHost = "inetgw-proxy.ojk.go.id";
	private static int proxyPort = 8080;
	private static String proxyUser = "corp/ext.arif";
	private static String proxyPass	= "arifpuji123";

//	private static String proxyHost = "127.0.0.2";
//	private static int proxyPort = 8080;
//	private static String proxyUser = "";
//	private static String proxyPass	= "";

	
	private static String ftpHost = "202.124.203.175";
	private static int ftpPort = 990;

	private static String ftpUser = "arif.ananto@gmail.com";
	private static String ftpPassword = "aA@123";

	private static void test() throws SocketException, IOException{
		 // client with explicit security, TLS protocol and tunneled over HTTP proxy
		FTPSHTTPClient ftps = null;
		if (StringUtils.isEmpty(proxyUser)){
			ftps = new FTPSHTTPClient(proxyHost, proxyPort);
		} else {
			ftps = new FTPSHTTPClient(proxyHost, proxyPort, proxyUser, proxyPass);	
		}
	    
	    // to show FTP commands in prompt
	    ftps.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));
	    // disable remote host verification
	    ftps.setRemoteVerificationEnabled(false);
	    // trust in ALL
	    ftps.setTrustManager(TrustManagerUtils.getAcceptAllTrustManager());
	    // data transfer timeout
	    ftps.setDataTimeout(1800000); // 30 

	    // keepAlive - DON'T USE, HAS A BUG WITH HTTP PROXY - java.net.SocketTimeoutException: Read timed out
	    //ftps.setControlKeepAliveTimeout(10l);

	    // connect
	    ftps.connect(ftpHost, ftpPort);
	    ftps.login(ftpUser, ftpPassword);

	    // config
	    ftps.setCharset(Charset.forName("UTF-8"));
	    ftps.setBufferSize(0);
	    ftps.execPROT("P");
	    ftps.setFileType(FTP.BINARY_FILE_TYPE);
	    ftps.enterLocalPassiveMode();

	    // ... do some operations
//	    ftps.changeWorkingDirectory("0101.009.20160622150936655");
	    ftps.storeFile("test.txt", new FileInputStream("other/test_note.txt"));

	    FTPFile[] ftpFiles = ftps.listFiles();
	    for (FTPFile ftpFile : ftpFiles) {
			System.out.println(ftpFile.getName());
		}
	    
//	    BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("other/test_aja.txt"));
//	    ftps.retrieveFile("0101.009.20160622150936655.signature", outputStream);
//	    outputStream.close();

	    // close
	    ftps.logout();
	    ftps.disconnect();
	}

}
