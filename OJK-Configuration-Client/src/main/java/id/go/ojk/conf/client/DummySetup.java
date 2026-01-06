package id.go.ojk.conf.client;


import static id.go.ojk.client.service.SetupService.key_aesStaticKeyBase64;
import static id.go.ojk.client.service.SetupService.key_allowSendSummary;
import static id.go.ojk.client.service.SetupService.key_clientTypeFlag;
import static id.go.ojk.client.service.SetupService.key_cpubApolo;
import static id.go.ojk.client.service.SetupService.key_ftpHost;
import static id.go.ojk.client.service.SetupService.key_ftpHost2;
import static id.go.ojk.client.service.SetupService.key_ftpPass;
import static id.go.ojk.client.service.SetupService.key_ftpPort;
import static id.go.ojk.client.service.SetupService.key_ftpUser;
import static id.go.ojk.client.service.SetupService.key_memberCode;
import static id.go.ojk.client.service.SetupService.key_memberName;
import static id.go.ojk.client.service.SetupService.key_memberTypeCode;
import static id.go.ojk.client.service.SetupService.key_memberTypeDesc;
import static id.go.ojk.client.service.SetupService.key_rsaPublicKeyBase64;
import static id.go.ojk.client.service.SetupService.key_sectorCode;
import static id.go.ojk.client.service.SetupService.key_sprivApolo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.ArchiveException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.service.SetupService;
import id.go.ojk.client.service.UserService;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.dto.DtoFtpInfo;
import id.go.ojk.lib.client.EncryptionCompressionUtil;
import id.go.ojk.lib.client.model.SetupHeader;
import id.go.ojk.lib.client.model.compression.MemoryFile;
import id.go.ojk.lib.client.model.constant.ClientTypeFlag;
import id.go.ojk.lib.client.model.constant.ConfigVersion;
import id.go.ojk.lib.client.model.security.User;
import id.go.ojk.lib.client.model.security.UserRole;
import id.go.ojk.lib.client.service.security.BCryptPasswordEncoder;

@Deprecated
public class DummySetup {
	private static Logger logger = LoggerFactory.getLogger(DummySetup.class);

	public static DummyServerConfig serverConfig = DummyEnvironment.config(EEnvironment.DEVEL);
//	public static DummyServerConfig serverConfig = DummyEnvironment.config("PRODUCTION");
	
//	public static String ftpHost = "";						// server offline
//	public static String ftpHost = "10.210.240.18"; 		// server devel
//	public static String ftpHost2 = "10.210.240.18"; 		// server devel
//	public static String ftpHost = "BGRDCO-APLFTP01"; 		// server production internal
//	public static String ftpHost2 = "BGRDCO-APLFTP02"; 		// server production internal 2
//	public static String ftpHost = "stoapolo.ojk.go.id"; 	// server production external
//	public static String ftpHost2 = "stoapolo2.ojk.go.id"; 	// server production external 2
//	public static String ftpHost2 = ""; 	// server production external 2
	
//	public static String ftpPort = "889";
	
//	public static String ftpUser = "ojk\\abdul.basit";		// server devel
//	public static String ftpPass = "password.123";			// server devel
//	public static String ftpUser = "acc609999";				// server production per LJK
//	public static String ftpPass = "Pwd4cc609999";			// server production per LJK
//	public static String ftpUser = "administrator";			// server production
//	public static String ftpPass = "password.1";			// server production
	
	public static DtoFtpInfo ftp = serverConfig.getFtp();
	public static DtoFtpInfo ftp2 = serverConfig.getFtp2();
	
//	private static final String basePathKeyApolo = "\\\\10.210.240.18\\ftp\\KEY\\";

	public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException {
//		allTask();
		logger.error("please run DummyDataDat!!");
	}

	public static void allTask(String entityName, String entityType, String entityCode, Map<Integer, List<String>> entityClientMap, 
			Map<String, String> ftpAccount, Map<String, String> mapReport, Map<String, List<String>> userAppAccess, Map<String, List<String>> mapReportBySector,
			Map<String, List<String>> mapKeyApolo) 
			throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException {
		String metaFTPuser = null;
		String metaFTPpass = null;
		
		String key = "acc" + entityCode;
		
		if (serverConfig.isDevMode()) {
			// Devel
			metaFTPuser = ftp.getFtpUser();
			metaFTPpass = randomString(10) + ftp.getFtpPass();
		} else {	
			// Production
			if (ftpAccount.size() != 0 && ftpAccount.containsKey(key)) {
				metaFTPuser = key;
				metaFTPpass = randomString(10) + ftpAccount.get(key);
			} else {
				metaFTPuser = key;
				metaFTPpass = randomString(10) + "Pwd4cc" + entityCode;
			}	
		}
		
		saveSetupHeader(mapReport, mapReportBySector);
		saveSetup(entityName, entityType, entityCode, metaFTPuser, metaFTPpass, mapKeyApolo);
		saveUserDummy(entityClientMap, userAppAccess);

		compressAndEncrypt();
	}

	public static void compressAndEncrypt() throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException{
		File plainDir = new File("../OJK-ASRJ-Client-Launcher/resources/plain/setup");
		File encryptedFile = new File("../OJK-ASRJ-Client-Launcher/resources/setup.jar");

		EncryptionCompressionUtil.compressAndEncrypt(HomeController.homeButton, plainDir, encryptedFile);
		List<MemoryFile> memoryFiles = EncryptionCompressionUtil.decryptAndDecompressToMemory(HomeController.homeButton, Arrays.asList(encryptedFile), null);
	}

	public static void saveSetupHeader(Map<String, String> mapReport, Map<String, List<String>> mapReportBySector) {
		SetupService setupService = new SetupService();
		File file = new File("../OJK-ASRJ-Client-Launcher/resources/plain/setup/header.xml");

		SetupHeader setupHeader = new SetupHeader();

		setupHeader.setVersion(ConfigVersion.SETUP_VERSION);
		//setupHeader.setLastModified(LocalDateTime.now().minusMonths(1).format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
		setupHeader.setLastModified(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
		setupHeader.setMapReport(mapReport);
		setupHeader.setMapReportBySector(mapReportBySector);

		setupService.saveXStream(file, setupHeader);
	}

	public static void saveUserDummy(Map<Integer, List<String>> entityClientMap, Map<String, List<String>> userAppAccess) {
		UserService userService = new UserService();
		File file = new File("../OJK-ASRJ-Client-Launcher/resources/plain/setup/user.xml");
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		List<User> users = new ArrayList<>();
//		String pass1 = "trial";
		String pass1 = "passrbb123";
		
		for (int i = 0; i < entityClientMap.size(); i++) {
			String userName = entityClientMap.get(i).get(1);
			String name = entityClientMap.get(i).get(0)
					.replaceAll(String.valueOf((char) 160), "")	 // karakter &npsp;
					.replaceAll(String.valueOf((char) 8217), ""); // karakter �
			List<String> appAccess = userAppAccess.get(userName);
			
//			if(userName.equals("arnol.faizal@ojk.go.id"))	// HARDCODE TESTING
//				appAccess.add("2349");
			
			users.add(new User(userName, name, "Manajer", passwordEncoder.encode(userName), UserRole.ljkOffline, maskingPassword(userName), false, appAccess));
		}		
//		users.add(new User("rbbadmin", "Administrator", "Manajer", passwordEncoder.encode("9w8q6x1h"), UserRole.ljkOffline, "", true));
		
		userService.saveXStream(file, users);
		HashMap<String, User> check = userService.readXStream(file);
	}
	
	private static String specialChar(String str) {
		String newString = new String(str);
		
		newString.replaceAll(String.valueOf((char) 160), "");	 // karakter &npsp
		
		return newString;
	}
	
	private static String maskingPassword(String text) {
		String password = text;
		StringBuffer maskPassword = new StringBuffer();
		
		for (int i = 0; i < password.length(); i++) {
			if (i == 0 || i == (password.length()-1) || i == (password.length()-2)) {
				maskPassword.append(password.charAt(i));
			} else {
				maskPassword.append("*");
			}
		}
		
		return maskPassword.toString();		
	}
	
	private static String randomString(int len) {
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();
		
		StringBuilder sb = new StringBuilder(len);
		for( int i = 0; i < len; i++ ) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}

		return sb.toString();
	}

	public static void saveSetup(String entityName, String entityType, String entityCode, String metaFTPuser, String metaFTPpass, Map<String, List<String>> mapKeyApolo) {
		SetupService setupService = new SetupService();
		File file = new File("../OJK-ASRJ-Client-Launcher/resources/plain/setup/setup.xml");
		String entityTypeDesc;
		
		if (entityType.substring(4).equals("01")) {
			entityTypeDesc = "BPR Konvensional";
		} else {
			entityTypeDesc = "BPR Syariah";
		}
		
		String fullEntityCode = entityType + "-" + entityCode;
		String cpubKey = "";
		String sprivKey = "";
		
		// Untuk BUK / BUS
//		if(mapKeyApolo.containsKey(fullEntityCode)) {
//			List<String> listKeyApolo = mapKeyApolo.get(fullEntityCode);
//			File fileCpub = new File(basePathKeyApolo + listKeyApolo.get(0));
//			File fileSpriv = new File(basePathKeyApolo + listKeyApolo.get(1));
//			
//			BufferedReader brCpub = null;
//			FileReader frCpub = null;	
//			
//			BufferedReader brSpriv = null;
//			FileReader frSpriv = null;
//			try {
//				frCpub = new FileReader(fileCpub);
//				brCpub = new BufferedReader(frCpub);
//				cpubKey = brCpub.readLine();
//				
//				frSpriv = new FileReader(fileSpriv);
//				brSpriv = new BufferedReader(frSpriv);
//				sprivKey = brSpriv.readLine();
//			} catch (Exception e) {
//				
//			} finally {
//				try {
//					frCpub.close();
//					brCpub.close();
//					
//					frSpriv.close();
//					brSpriv.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		
		HashMap<String, String> setupMap = new HashMap<>();
		setupMap.put(key_clientTypeFlag, 		ClientTypeFlag.E.name());
//		setupMap.put(key_clientTypeFlag, 		ClientTypeFlag.I.name());
		
		setupMap.put(key_memberTypeCode, 		entityType.substring(4));
		setupMap.put(key_memberTypeDesc, 		entityTypeDesc);
		setupMap.put(key_memberCode, 			entityCode);
		setupMap.put(key_memberName, 			entityName);
		setupMap.put(key_sectorCode,			entityType);
		setupMap.put(key_cpubApolo, 			cpubKey);
		setupMap.put(key_sprivApolo, 			sprivKey);
		
//		setupMap.put(key_memberTypeCode, 		"02");
//		setupMap.put(key_memberTypeDesc, 		"BPR Syariah");
//		setupMap.put(key_memberCode, 			"620002");
//		setupMap.put(key_memberName, 			"Amanah Rabbaniah");
//		setupMap.put(key_memberCode, 			"620008"); // >6M
//		setupMap.put(key_memberName, 			"Mentari");
//		setupMap.put(key_memberCode, 			"620009"); // 5M
//		setupMap.put(key_memberName, 			"Tulen Amanah");
//		setupMap.put(key_memberCode, 			"620025"); // 1M
//		setupMap.put(key_memberName, 			"Tengku ChiekDipante");
		
//		setupMap.put(key_memberTypeCode, 		"01");
//		setupMap.put(key_memberTypeDesc, 		"BPR Konvensional");
//		setupMap.put(key_memberCode, 			"600001");
//		setupMap.put(key_memberName, 			"PT. BPR Jawa Timur");
//		setupMap.put(key_memberCode, 			"600010"); // >6M
//		setupMap.put(key_memberName, 			"PT. BPR Dana Usaha");
//		setupMap.put(key_memberCode, 			"600012"); // 1M
//		setupMap.put(key_memberName, 			"PT. BPR Daya Arta");
//		setupMap.put(key_memberCode, 			"600228"); // 5M
//		setupMap.put(key_memberName, 			"PD. BPR Tapin Selatan");
		
		setupMap.put(key_ftpHost, 				ftp.getFtpHost());
		setupMap.put(key_ftpHost2, 				ftp2.getFtpHost());
		setupMap.put(key_ftpPort, 				String.valueOf(ftp.getFtpPort()));
		setupMap.put(key_ftpUser, 				metaFTPuser);
		setupMap.put(key_ftpPass, 				metaFTPpass);

		setupMap.put(key_allowSendSummary, 		"true");
		setupMap.put(key_rsaPublicKeyBase64, 	"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqxY0y+UExvwkJg2UBp6ktpyfPNW2buR06wl4eWEeT45ejIVHZibNX7f9a4qvFpgiC7CNSs4CtD78FlQpCi+tuHHkt+0Z+egkq+rNpQ63JBDhfU1huFeHDkDNZ/6anW/hLz51l19y9yyq13M34p9ABwNFaEW/dWCHSkm0vpNBwP1gwnWsbMONF1RRa/tiR+vcnRWOxmeETJYoQ/TrRH1FYxyYVeffODBj34spwNNVpArFKM9q3u3ESpQBizlzm6uXodEH7UPCYrwX6FQvZt3EOujABLxC4oNATMafFmTsof+vWdQ4IReVDid0KIQGgTzC9/0EKwjOowBaOOqqzxuYlQIDAQAB");
		setupMap.put(key_aesStaticKeyBase64, 	"gph9aA0Xhb3W8YngKuDsieNg13EjXmx1TqMw58pAiEk=");

		setupService.saveXStream(file, setupMap);
	}

}
