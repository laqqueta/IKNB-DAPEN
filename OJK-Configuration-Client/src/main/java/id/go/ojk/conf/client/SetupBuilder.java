package id.go.ojk.conf.client;

import static id.go.ojk.client.service.SetupService.KEY_URL_AUTH;
import static id.go.ojk.client.service.SetupService.KEY_URL_SUBMISSION;
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
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.constant.ESectorType;
import id.go.ojk.lib.client.EncryptionCompressionUtil;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.SetupHeader;
import id.go.ojk.lib.client.model.compression.MemoryFile;
import id.go.ojk.lib.client.model.constant.ClientTypeFlag;
import id.go.ojk.lib.client.model.constant.ConfigVersion;
import id.go.ojk.lib.client.model.security.ClientEntity;
import id.go.ojk.lib.client.model.security.ClientUser;
import id.go.ojk.lib.client.model.security.User;
import id.go.ojk.lib.client.model.security.UserRole;
import id.go.ojk.lib.client.service.security.BCryptPasswordEncoder;
import id.go.ojk.lib.client.util.FileUtil;
import lombok.Setter;

public class SetupBuilder extends BaseBuilder implements ISetupBuilder {
	private static final Logger logger = LoggerFactory.getLogger(SetupBuilder.class);
	private String base64Key;
	private String setupFolder;
	private final String SETUP_JAR = "setup.jar";
	private final String HEADER_XML = "header.xml";
	private final String SETUP_XML = "setup.xml";
	private final String USER_XML = "user.xml";
	@Setter
	private ESectorType eSectorType;
	@Setter
	private DummyServerConfig serverConfig;
	@Setter
	private ClientEntity clientEntity;
	@Setter
	private Map<String, String> ftpAccount;
	@Setter
	private Map<String, String> mapReport;
	@Setter
	private Map<String, List<String>> userAppAccess;
	@Setter
	private Map<String, List<String>> mapReportBySector;
	@Setter
	private Map<String, List<KeyValueString>> references;

	public SetupBuilder(String rootFolder, String base64Key) {
		super(rootFolder);
		this.base64Key = base64Key;
		initSetupFolder();
	}

	@Override
	public void init() { }
	
	@Override
	public String buildAll() {
		File folderInput = new File(setupFolder);
		File fileOutput = new File(FileUtil.concat(jarFolder, SETUP_JAR));
		try {
			init();
			FileUtil.deleteDirContent(folderInput);
			buildHeaderXml();
			buildReferenceXml();
			buildSetupXml();
			buildUserXml();
			EncryptionCompressionUtil.compressAndEncrypt(base64Key, folderInput, fileOutput);
		} catch (NoSuchAlgorithmException | ArchiveException | IOException e) {
			logger.error(e.getMessage(), e);
		}
		return fileOutput.getAbsolutePath();
	}

	@Override
	public String buildHeaderXml() {
		String res = "";
		try {
			res = new FromSetupHeader().toXml(FileUtil.concat(setupFolder, HEADER_XML), getSetupHeader());
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return res;
	}

	@Override
	public List<String> buildReferenceXml() {
		List<String> res = new ArrayList<>();
		try {
			res = new FromKeyValueString().toXml(references, setupFolder);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return res;
	}

	@Override
	public String buildSetupXml() {
		String res = "";
		try {
			res = new FromMap().toXml(FileUtil.concat(setupFolder, SETUP_XML), getSetup());
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return res;
	}

	@Override
	public String buildUserXml() {
		String res = "";
		try {
			res = new FromUser().toXml(FileUtil.concat(setupFolder, USER_XML), getUser());
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return res;
	}

	@Override
	public void testBundle(String filename) {
		File file = new File(filename);
		try {
			List<MemoryFile> memoryFiles = EncryptionCompressionUtil.decryptAndDecompressToMemory(base64Key,
					Arrays.asList(file), null);
			if (memoryFiles != null) {
				for (MemoryFile memoryFile : memoryFiles) {
					logger.info(memoryFile.getName() + "=" + new String(memoryFile.getContent()));
				}
			} else {
				logger.error("Null result");
			}
		} catch (NoSuchAlgorithmException | ArchiveException | IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	private SetupHeader getSetupHeader() {
		SetupHeader setupHeader = new SetupHeader();
		setupHeader.setVersion(ConfigVersion.SETUP_VERSION);
		setupHeader.setLastModified(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
		setupHeader.setMapReport(mapReport);
		setupHeader.setMapReportBySector(mapReportBySector);
		return setupHeader;
	}

	private HashMap<String, String> getSetup() {
		HashMap<String, String> res = new HashMap<>();
		String[] splittedFullEntityCode = StringUtils.split(clientEntity.getFullEntityCode(), "-");
		String entityCode = splittedFullEntityCode[1];
		res.put(key_clientTypeFlag, ClientTypeFlag.E.name());
		res.put(key_memberTypeCode, eSectorType.getCode());
		res.put(key_memberTypeDesc, eSectorType.getName());
		res.put(key_memberCode, entityCode);
		res.put(key_memberName, clientEntity.getEntityName());
		res.put(key_sectorCode, clientEntity.getSectorCode());
		res.put(key_cpubApolo, "");
		res.put(key_sprivApolo, "");
		res.put(key_ftpHost, serverConfig.getFtp().getFtpHost());
		res.put(key_ftpHost2, serverConfig.getFtp2().getFtpHost());
		res.put(key_ftpPort, String.valueOf(serverConfig.getFtp().getFtpPort()));
		res.put(key_ftpUser, getFtpUser(entityCode));
		res.put(key_ftpPass, getFtpPwd(entityCode));
		res.put(key_allowSendSummary, "true");
		res.put(key_rsaPublicKeyBase64,
				"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqxY0y+UExvwkJg2UBp6ktpyfPNW2buR06wl4eWEeT45ejIVHZibNX7f9a4qvFpgiC7CNSs4CtD78FlQpCi+tuHHkt+0Z+egkq+rNpQ63JBDhfU1huFeHDkDNZ/6anW/hLz51l19y9yyq13M34p9ABwNFaEW/dWCHSkm0vpNBwP1gwnWsbMONF1RRa/tiR+vcnRWOxmeETJYoQ/TrRH1FYxyYVeffODBj34spwNNVpArFKM9q3u3ESpQBizlzm6uXodEH7UPCYrwX6FQvZt3EOujABLxC4oNATMafFmTsof+vWdQ4IReVDid0KIQGgTzC9/0EKwjOowBaOOqqzxuYlQIDAQAB");
		res.put(key_aesStaticKeyBase64, "gph9aA0Xhb3W8YngKuDsieNg13EjXmx1TqMw58pAiEk=");
		res.put(KEY_URL_AUTH, serverConfig.getUrlAuth());
		res.put(KEY_URL_SUBMISSION, serverConfig.getUrlSubmission());
		return res;
	}

	private Map<String, User> getUser() {
		Map<String, User> res = new HashMap<>();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		List<ClientUser> listClientUser = clientEntity.getListClientUser();
		for (int i = 0; i < listClientUser.size(); i++) {
			ClientUser clientUser = listClientUser.get(i);
			String userName = clientUser.getUserName();
			String name = clientUser.getNamaPengguna().replaceAll(String.valueOf((char) 160), "") // karakter &npsp;
					.replaceAll(String.valueOf((char) 8217), ""); // karakter �
			List<String> appAccess = userAppAccess.get(userName);
			User user = new User(userName, name, "Manajer", passwordEncoder.encode(userName), UserRole.ljkOffline,
					maskingPassword(userName), false, appAccess);
			res.put(userName, user);
		}
		return res;
	}

	private String getFtpUser(String entityCode) {
		return serverConfig.isDevMode() ? serverConfig.getFtp().getFtpUser() : "acc" + entityCode;
	}

	private String getFtpPwd(String entityCode) {
		String res = null;
		String key = "acc" + entityCode;

		if (serverConfig.isDevMode()) {
			res = getRandomString(10) + serverConfig.getFtp().getFtpPass();
		} else {
			if (ftpAccount != null && ftpAccount.containsKey(key)) {
				res = getRandomString(10) + ftpAccount.get(key);
			} else {
				res = getRandomString(10) + "Pwd4cc" + entityCode;
			}
		}
		return res;
	}

	private String getRandomString(int len) {
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();
	}

	private String maskingPassword(String text) {
		String password = text;
		StringBuffer maskPassword = new StringBuffer();
		for (int i = 0; i < password.length(); i++) {
			if (i == 0 || i == (password.length() - 1) || i == (password.length() - 2)) {
				maskPassword.append(password.charAt(i));
			} else {
				maskPassword.append("*");
			}
		}

		return maskPassword.toString();
	}
	
	private void initSetupFolder() {
		setupFolder = createFolders(rootFolder, "setup");
	}
}
