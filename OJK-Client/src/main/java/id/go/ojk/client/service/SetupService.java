package id.go.ojk.client.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.service.base.BaseService;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.lib.client.DateUtil;
import id.go.ojk.lib.client.EncryptionCompressionUtil;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.SetupHeader;
import id.go.ojk.lib.client.model.compression.MemoryFile;
import id.go.ojk.lib.client.model.constant.ClientTypeFlag;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.security.User;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.model.update.ClientComponents;
import id.go.ojk.lib.client.model.update.UpdateLog;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.Getter;
import lombok.Setter;

public class SetupService extends BaseService {

	public final static String key_clientTypeFlag = "clientTypeFlag";
	public final static String key_memberTypeCode = "memberTypeCode";
	public final static String key_memberTypeDesc = "memberTypeDesc";
	public final static String key_memberCode = "memberCode";
	public final static String key_memberName = "memberName";
	public final static String key_sectorCode = "sectorCode";
	public final static String key_allowSendSummary = "allowSendSummary";
	public final static String key_rsaPublicKeyBase64 = "rsaPublicKeyBase64";
	public final static String key_aesStaticKeyBase64 = "aesStaticKeyBase64";
	public final static String key_cpubApolo = "cpubApolo";
	public final static String key_sprivApolo = "sprivApolo";

	public final static String key_ftpHost = "clientFtpHost";
	public final static String key_ftpHost2 = "clientFtpHost2";
	public final static String key_ftpPort = "clientFtpPort";
	public final static String key_ftpUser = "clientFtpUser";
	public final static String key_ftpPass = "clientFtpPass";
	public final static String KEY_URL_AUTH = "clientUrlAuth";
	public final static String KEY_URL_SUBMISSION = "clientUrlSubmission";

	public final static String fileName_setupHeader = "header.xml";
	public final static String fileName_setup = "setup.xml";
	public final static String fileName_user = "user.xml";
	public final static String fileName_R3Branch = ReferenceMetadata.R3Branch.getFileName();

	private ReferenceService referenceService;

	public final static File setupJarFile = new File("resources/setup.jar");

	@Override
	public void initialize() {
		this.referenceService = appContext.getService(ReferenceService.class);
		try {
			loadSetupJar();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException | ArchiveException | IOException e) {
			throw new SlikException("", e);
		}
	}

	@Getter
	private SetupHeader setupHeader;
	@Getter
	private HashMap<String, String> setupMap;
	@Getter
	private Map<String, User> userMap = new HashMap<>();
	@Getter
	private List<KeyValueString> branchReference;

	@Getter
	private Map<String, String> mapReport = new HashMap<>();
	@Getter
	private Map<String, List<String>> mapReportBySector = new HashMap<>();

	@Getter
	private ClientTypeFlag clientTypeFlag;
	@Setter @Getter
	private String memberTypeCode;
	@Getter
	private String memberTypeName;
	@Getter
	private String memberCode;
	@Getter
	private String memberName;
	@Getter
	private String sectorCode;
	@Getter
	private boolean allowSendSummary;
	@Getter
	private String rsaPublicKeyBase64;
	@Getter
	private PublicKey rsaPublicKey;
	@Getter
	private String aesStaticKeyBase64;
	@Getter
	private String aesStaticKey;

	@Getter
	private String clientFtpHost;
	@Getter
	private String clientFtpHost2;
	@Getter
	private int clientFtpPort;
	@Getter
	private String clientFtpUser;
	@Getter
	private String clientFtpPass;
	@Getter
	private String clientUrlAuth;
	@Getter
	private String clientUrlSubmission;

	// ~ method

	public boolean loadSetupJar() throws NoSuchAlgorithmException, InvalidKeySpecException, FileNotFoundException,
			ArchiveException, IOException {
		Map<String, MemoryFile> memoryFileMap = EncryptionCompressionUtil
				.decryptAndDecompressToMemoryMap(HomeController.homeButton, setupJarFile);

		// setupHeader.xml
		setupHeader = readHeader(memoryFileMap.get(fileName_setupHeader).getContent());

		// setup.xml
		setupMap = readMap(memoryFileMap.get(fileName_setup).getContent());
		readSetupXml();

		if (!isClientTypeOJK()) {
			// user.xml
			userMap = readUserMap(memoryFileMap.get(fileName_user).getContent());

			// R3Branch.xml
			branchReference = referenceService.readReferences(memoryFileMap.get(fileName_R3Branch).getContent());
		}

		return true;
	}

	private void readSetupXml() throws NoSuchAlgorithmException, InvalidKeySpecException {
		clientTypeFlag = ClientTypeFlag.valueOf(setupMap.get(key_clientTypeFlag));

		if (!isClientTypeOJK()) {
			memberTypeCode = setupMap.get(key_memberTypeCode);
			memberTypeName = setupMap.get(key_memberTypeDesc);

			memberCode = setupMap.get(key_memberCode);
			memberName = setupMap.get(key_memberName);
			sectorCode = setupMap.get(key_sectorCode);

			clientFtpHost = setupMap.get(key_ftpHost);
			clientFtpHost2 = setupMap.get(key_ftpHost2);
			clientFtpPort = Integer.parseInt(setupMap.get(key_ftpPort));
			clientFtpUser = setupMap.get(key_ftpUser);
			clientFtpPass = setupMap.get(key_ftpPass);
			clientUrlAuth = setupMap.get(KEY_URL_AUTH);
			clientUrlSubmission = setupMap.get(KEY_URL_SUBMISSION);

			allowSendSummary = Boolean.parseBoolean(setupMap.get(key_allowSendSummary));

			rsaPublicKeyBase64 = setupMap.get(key_rsaPublicKeyBase64);
			rsaPublicKey = loadPublicKey(rsaPublicKeyBase64);

			aesStaticKeyBase64 = setupMap.get(key_aesStaticKeyBase64);
			aesStaticKey = new String(Base64.getDecoder().decode(aesStaticKeyBase64));

			mapReport = setupHeader.getMapReport();
			mapReportBySector = setupHeader.getMapReportBySector();
		}
	}

	private PublicKey loadPublicKey(String keyBase64) throws NoSuchAlgorithmException, InvalidKeySpecException {
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec pkSpec = new X509EncodedKeySpec(Base64.getDecoder().decode(keyBase64));
		PublicKey publicKey = keyFactory.generatePublic(pkSpec);
		return publicKey;
	}

	public List<ValidationError> validateEntityTypeAndEntityCode(String entityTypeCode, String entityCode) {
		List<ValidationError> errors = new ArrayList<ValidationError>();

		// Entity Type Code
		if (!this.memberTypeCode.equals(entityTypeCode)) {
			errors.add(new ValidationError(null, ValidationErrorCode.E02_00_ENTITYTYPE_CODE));
		}

		// Entity Code
		if (entityCode.length() < 3) {
			errors.add(new ValidationError(null, ValidationErrorCode.E02_01_ENTITY_CODE/* E02_00_ENTITYTYPE_CODE */));
		} else if (entityCode.length() < 6) {
			if (!this.memberCode.endsWith(entityCode)) {
				errors.add(
						new ValidationError(null, ValidationErrorCode.E02_01_ENTITY_CODE/* E02_00_ENTITYTYPE_CODE */));
			}
		} else {
			if (!this.memberCode.equals(entityCode)) {
				errors.add(
						new ValidationError(null, ValidationErrorCode.E02_01_ENTITY_CODE/* E02_00_ENTITYTYPE_CODE */));
			}
		}

		return errors;
	}

	public void loginOnlineSuccess(UserSession userSession) {
		if (getClientTypeFlag() == ClientTypeFlag.I) {
			// tidak perlu syncrhonize password
			return;
		}

		Map<String, Object> loginResponse = userSession.getLoginOnlineResponse();
		// update user
		User user = userSession.getUser();
		User checkUser = userMap.get(user.getUserLoginId());
		if (checkUser == null) {
			checkUser = user.cloneQuietly();
			userMap.put(checkUser.getUserLoginId(), checkUser);
		} else {
			checkUser.setUserName(user.getUserName());
			checkUser.setPasswordHash(user.getPasswordHash());
		}

		// update setupMap
		updateSetupMap(loginResponse, key_memberTypeDesc);
		updateSetupMap(loginResponse, key_memberName);
		updateSetupMap(loginResponse, key_allowSendSummary);

		// reload and persist
		try {
			readSetupXml();

			persist();
		} catch (NoSuchAlgorithmException | IOException | ArchiveException | InvalidKeySpecException e) {
			String message = "Fail persist setup";
			logger.error(message, e);
			throw new SlikException(message, e);
		}
	}

	public void persist() throws IOException, NoSuchAlgorithmException, ArchiveException {
		File backupFile = new File("backup/resources/" + DateUtil.formatNow() + "_setup.jar");

		// backup
		backupFile.getParentFile().mkdirs();
		FileUtils.moveFile(setupJarFile, backupFile);

		// create new
		XStream xstream = instanceStream();
		List<MemoryFile> memoryFiles = new ArrayList<>();
		memoryFiles.add(new MemoryFile(fileName_setupHeader, xstream.toXML(setupHeader).getBytes()));
		memoryFiles.add(new MemoryFile(fileName_setup, xstream.toXML(setupMap).getBytes()));
		memoryFiles.add(new MemoryFile(fileName_user, xstream.toXML(userMap).getBytes()));
		memoryFiles.add(new MemoryFile(fileName_R3Branch, xstream.toXML(branchReference).getBytes()));

		EncryptionCompressionUtil.compressAndEncrypt(HomeController.homeButton, memoryFiles, setupJarFile);
	}

	private void updateSetupMap(Map<String, Object> loginResponse, String key) {
		String newValue = (String) loginResponse.get(key);
		if (StringUtils.isNotEmpty(newValue)) {
			setupMap.put(key, newValue);
		}
	}

	public boolean isClientTypeOJK() {
		return clientTypeFlag == ClientTypeFlag.I;
	}

	public List<String> updateSetupjar(File newSetupJarFile, File backupDir, UpdateLog updateLog)
			throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException {
		Map<String, MemoryFile> newMemoryFileMap = EncryptionCompressionUtil
				.decryptAndDecompressToMemoryMap(HomeController.homeButton, newSetupJarFile);
		List<String> messages = new ArrayList<>();

		SetupHeader newSetupHeader = readHeader(newMemoryFileMap.get(fileName_setupHeader).getContent());
		if (Long.parseLong(newSetupHeader.getLastModified()) <= Long.parseLong(setupHeader.getLastModified())) {
			messages.add("Tanggal modifikasi setup sudah terakhir "
					+ DateUtil.convertFormatDate(setupHeader.getLastModified()));
			return messages;
		}

		// backup
		File backupFile = new File(backupDir.getAbsolutePath() + "/" + setupJarFile.getName());
		Files.move(Paths.get(setupJarFile.getAbsolutePath()), Paths.get(backupFile.getAbsolutePath()));

		MemoryFile userMemoryFile = newMemoryFileMap.get(fileName_user);
		Map<String, User> newUserMap = readUserMap(userMemoryFile.getContent());
		for (Entry<String, User> entry : userMap.entrySet()) {
			if (!entry.getValue().isOnlineUser()) {
				newUserMap.put(entry.getKey(), entry.getValue());
			}
		}
		XStream xstream = instanceStream();
		userMemoryFile.setContent(xstream.toXML(newUserMap).getBytes());

		EncryptionCompressionUtil.compressAndEncrypt(HomeController.homeButton,
				newMemoryFileMap.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList()), setupJarFile);

		updateLog.updateVersion(ClientComponents.clSetupBranch.getName(), newSetupHeader.getLastModified(),
				backupFile.getAbsolutePath());
		updateLog.updateVersion(ClientComponents.clSetup.getName(), setupHeader.getVersion(),
				backupFile.getAbsolutePath());

		messages.add("Update setup " + DateUtil.convertFormatDate(newSetupHeader.getLastModified()));

		return messages;
	}

	// ~ persistence

	public HashMap<String, String> readMap(File file) {
		XStream xstream = instanceStream();
		HashMap<String, String> dataMap = (HashMap<String, String>) xstream.fromXML(file);
		return dataMap;
	}

	public HashMap<String, String> readMap(byte[] data) {
		XStream xstream = instanceStream();
		HashMap<String, String> dataMap = (HashMap<String, String>) xstream.fromXML(new ByteArrayInputStream(data));
		return dataMap;
	}

	public HashMap<String, User> readUserMap(byte[] data) {
		XStream xstream = instanceStream();
		HashMap<String, User> dataMap = (HashMap<String, User>) xstream.fromXML(new ByteArrayInputStream(data));
		HashMap<String, User> lowerDataMap = new HashMap<>();
		for (Entry<String, User> entry : dataMap.entrySet()) {
			lowerDataMap.put(entry.getKey().toLowerCase(), entry.getValue());
		}
		return lowerDataMap;
	}

	public SetupHeader readHeader(byte[] data) {
		XStream xstream = instanceStream();
		SetupHeader setupHeader = (SetupHeader) xstream.fromXML(new ByteArrayInputStream(data));
		return setupHeader;
	}

	@Deprecated
	public void saveXStream(File file, HashMap<String, String> dataMap) {
		file.getParentFile().mkdirs();
		XStream xstream = instanceStream();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			xstream.toXML(dataMap, fos);
		} catch (FileNotFoundException e) {
			throw new SlikException("", e);
		} finally {
			IOUtils.closeQuietly(fos);
		}
	}

	@Deprecated
	public void saveXStream(File file, SetupHeader setupHeader) {
		file.getParentFile().mkdirs();
		XStream xstream = instanceStream();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			xstream.toXML(setupHeader, fos);
		} catch (FileNotFoundException e) {
			throw new SlikException("", e);
		} finally {
			IOUtils.closeQuietly(fos);
		}
	}

	public XStream instanceStream() {
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(new Class[] { SetupHeader.class, User.class, });
		return xstream;
	}

}
