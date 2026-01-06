package id.go.ojk.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketException;
import java.text.ParseException;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPHTTPClient;
import org.tempuri.ICAMServiceProxy;

import id.go.ojk.conf.client.DummyEnvironment;
import id.go.ojk.conf.client.EEnvironment;

public class TestMain {

	private static final Pattern PATTERN = Pattern.compile("^/(S[A-Z]{1}\\d{8})$");
	private static String passFTP = "";
	private static String TEST = null;

	public static void main(String[] args) throws ParseException {
		
//		String patternAll = "^(?=.*[1-9])\\d*(?:\\.\\d{2})$";
//
//		System.out.println(Pattern.matches(patternAll, ".0"));
//		System.out.println(Pattern.matches(patternAll, ".00"));
//		System.out.println(Pattern.matches(patternAll, "0.00"));
//		System.out.println(Pattern.matches(patternAll, "0.01"));
//		System.out.println(Pattern.matches(patternAll, "-0.00"));
//		System.out.println(Pattern.matches(patternAll, "-0.01"));
//		System.out.println(Pattern.matches(patternAll, "1.00"));
//		System.out.println(Pattern.matches(patternAll, "1."));
//		System.out.println(Pattern.matches(patternAll, "1.0"));
//		System.out.println(Pattern.matches(patternAll, "1.000"));
//		System.out.println(Pattern.matches(patternAll, "01.00"));
		
//		System.out.println(1 % 3);
//		System.out.println(2 % 3);
//		System.out.println(3 % 3);
//		System.out.println(4 % 3);
//		System.out.println(5 % 3);
//		System.out.println(6 % 3);
//		System.out.println(7 % 3);
//		System.out.println(8 % 3);
//		System.out.println(9 % 3);
//		System.out.println(10 % 3);
//		System.out.println(11 % 3);
//		System.out.println(12 % 3);

//		List<BigDecimal> datas = Arrays.asList(new BigDecimal(7.0d), new BigDecimal(15.96d), new BigDecimal(77.04d));
//		BigDecimal sum = BigDecimal.ZERO;
//		for (BigDecimal data : datas) {
//			sum = sum.add(data);
//		}
//		System.out.println(sum.doubleValue());
//		System.out.println(sum.doubleValue() == 100d);
//		datas.stream().forEach(e -> {
//			sum = sum.add(e);
//		});
		
//		Double sum = datas.stream().mapToDouble( d -> d).sum();
//		System.out.println("sum " + sum);
//		
//		BigDecimal sumBd = new BigDecimal(sum);
//		
//		System.out.println("sumBd " + sumBd);

		
//		List<Double> datas = Arrays.asList(7.0, 15.96, 77.04);
//		Double sum = datas.stream().mapToDouble( d -> d).sum();
//		System.out.println("sum " + sum);
//		
//		BigDecimal sumBd = new BigDecimal(sum);
//		
//		System.out.println("sumBd " + sumBd);

//		String url = "/instance";
//        Matcher matcher = PATTERN.matcher(url);
//
//        if (!matcher.matches()) {
//        	System.out.println("TIDAK COCOK");
//        } else {
//        	System.out.println("COCOK");
//        }

//		try {
//			System.out.println("START");
//			return;
//		} finally {
//			System.out.println("FINALLY");
//		}
		

//		File file = new File("D:/share/PROVISIONING/COMPRESS_FILE/BI/201609/SLIK_D01_201608_201607_BI_T1.zip");
//    	//String realFileName = FilenameUtils.getBaseName(new File("D:/share/PROVISIONING/COMPRESS_FILE/BI/201609/SLIK_D01_201608_201607_BI_T1.zip").getAbsolutePath());
//		String realFileName = FilenameUtils.getName(file.getAbsolutePath());
//    	System.out.println(realFileName);
//
//    	System.out.println( FilenameUtils.getName(file.getParent()) );
		
//		for(int i=0; i<10; i++){
//			UUID idOne = UUID.randomUUID();
//			System.out.println(idOne.toString());			
//		}
		
//		Date test = new SimpleDateFormat("dd-MM-yyyy").parse("10-1-1998");
//		System.out.println(test);
		
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		System.out.println(bCryptPasswordEncoder.encode("aA@123")); 
//		System.out.println(bCryptPasswordEncoder.encode("aA@123"));
		
//		for (String string : FormatCategoryFlag.getValueList()) {
//			System.out.println(string);
//		}
		
//		System.out.println("A : " + "A".hashCode());
//		System.out.println("A : " + "A".hashCode());
//		System.out.println("a : " + "a".hashCode());
//		System.out.println("a : " + "a".hashCode());
//		
//		System.out.println("abcasdsadsadasdasdasjklfklkjkljfskd1212 ABCASDSADSADASDASDASJKLFKLKJKLJFSKD1212 : " + "abcasdsadsadasdasdasjklfklkjkljfskd1212 ABCASDSADSADASDASDASJKLFKLKJKLJFSKD1212".hashCode());
//		System.out.println("abcasdsadsadasdasdasjklfklkjkljfskd1212 ABCASDSADSADASDASDASJKLFKLKJKLJFSKD1212 : " + "abcasdsadsadasdasdasjklfklkjkljfskd1212 ABCASDSADSADASDASDASJKLFKLKJKLJFSKD1212".hashCode());
//		
//		System.out.println("abcasdsadsadasdasdasjklfklkjkljfskd1212 ABCASDSADSADASDASDASJKLFKLKJKLJFSKD1212 : " + "abcasdsadsadasdasdasjklfklkjkljfskd1212 ABCASDSADSADASDASDASJKLFKLKJKLJFSKD1212 abcasdsadsadasdasdasjklfklkjkljfskd1212 ABCASDSADSADASDASDASJKLFKLKJKLJFSKD1212 abcasdsadsadasdasdasjklfklkjkljfskd1212 ABCASDSADSADASDASDASJKLFKLKJKLJFSKD1212 abcasdsadsadasdasdasjklfklkjkljfskd1212 ABCASDSADSADASDASDASJKLFKLKJKLJFSKD1212 abcasdsadsadasdasdasjklfklkjkljfskd1212 ABCASDSADSADASDASDASJKLFKLKJKLJFSKD1212 abcasdsadsadasdasdasjklfklkjkljfskd1212 ABCASDSADSADASDASDASJKLFKLKJKLJFSKD1212 abcasdsadsadasdasdasjklfklkjkljfskd1212 ABCASDSADSADASDASDASJKLFKLKJKLJFSKD1212 abcasdsadsadasdasdasjklfklkjkljfskd1212 ABCASDSADSADASDASDASJKLFKLKJKLJFSKD1212".hashCode());
//		
//		System.out.println("abcasdsadsadasdasdasjklfklkjkljfskd1212 ABCASDSADSADASDASDASJKLFKLKJKLJFSKD1212 : " + "Abcasdsadsadasdasdasjklfklkjkljfskd1212 ABCASDSADSADASDASDASJKLFKLKJKLJFSKD1212".hashCode());
//		
//		System.out.println("abcasdsadsadasdasdasjklfklkjkljfskd1212 ABCASDSADSADASDASDASJKLFKLKJKLJFSKD1212 : " + "abcasdsadsadasdasdasjklfklkjkljfskd1212 ABCASDSADSADASDASDASJKLFKLKJKLJFSKD1212 ".hashCode());
		
//		String submissionId = "0101.022.20160829164000341";
//		//submissionId.substring(beginIndex, endIndex)
//		System.out.println(submissionId.split("\\.")[0]);
//		System.out.println(submissionId.split("\\.")[1]);
		
//		System.out.println(String.format("nilai harus '%1$s' '%2$s'", "A", "B"));
//		String row = "||";
//		String[] rowSplited = row.split("[|]", -1);
//		for (String string : rowSplited) {
//			System.out.println("string = " + string);
//		}
//		System.out.println(rowSplited.length);
		
//		ServletRequestListener
		
//		String input = "1.2.3.4";
//		String[] inputs = input.split("[.]");
//		for (String string : inputs) {
//			System.out.println(string);
//		}
		
//		String patternAll 				= "[\\w[ @#$%^&*(){}\\[\\]<=>~_\\-\\+`'\".,:;|/?!]]+";
//
//		System.out.println( Pattern.matches(patternAll, "A+") );

//		String input = "1,5";
//		DecimalFormat numberFormat = FormatUtil.getIdDecimalFormat();
//		try {
//			Number tmp = numberFormat.p (input);
//			System.out.println(tmp);
//			System.out.println(tmp.doubleValue());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
//		getSingleAksesUser2();
//		testFTPProxy();
		engineEval();
	}
	
	private static void engineEval() {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
		try {
			System.out.println(engine.eval("5<0||5==0"));
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void testFTPProxy() {
//		String ftpHost = "stoapolo.ojk.go.id";
		String ftpHost = "BGRDCO-APLFTP01";
		int ftpPort = 889;
		String ftpUser = "administrator";
		String ftpPass = "password.1";
		
		String proxyHost = "inetgw-proxy";
		int proxyPort = 8080;
		String proxyUser = "arnol.faizal";
		String proxyPass = passFTP;		

		FTPClient ftpClient = null;
		
//		ftpClient = new FTPClient();
		ftpClient = new FTPHTTPClient(proxyHost, proxyPort, proxyUser, proxyPass);
		ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));
		
		try {
			ftpClient.connect(ftpHost, ftpPort);
			ftpClient.login(ftpUser, ftpPass);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.logout();
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	private static void getSingleAksesUser2() {
		ICAMServiceProxy CAMService = new ICAMServiceProxy(DummyEnvironment.config(EEnvironment.DEVEL.name()).getCAMService());
		String aksesUSer = "TEST";
		String token = "a0fad6dd3a08ccb6901cde567a6031be";
		String[] sector = {"010201"};
		
		String username = "@ojk\\arnol.faizal";
		
		try {
//			aksesUSer = CAMService.getSingleAksesUser2("ojk\\arnol.faizal", "431301000c51954230c969f2e04c3add");
//			StringUtils.normalizeSpace(aksesUSer);
			
//			System.out.println(CAMService.getUserUnderEntitySector(token, sector));
			
//			System.out.println(CAMService.getTopLevelEconomicSector());
			
//			System.out.println(CAMService.getSingleAksesUser2("asdfad", "asdasd"));
//			System.out.println(CAMService.isApplicationAccessGranted(465, 1052));
			
			System.out.println(CAMService.getEntityList(10, null, null, 1, 1));
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
	}

}
