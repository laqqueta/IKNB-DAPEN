package id.go.ojk.conf.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.tempuri.ICAMServiceProxy;

import com.thoughtworks.xstream.XStream;

import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.constant.EFtpServer;
import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.constant.EReportBySector;
import id.go.ojk.client.constant.ESector;
import id.go.ojk.client.constant.ESectorType;
import id.go.ojk.client.util.UtilConfiguration;
import id.go.ojk.lib.client.CompressionUtil;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.compression.MemoryFile;
import id.go.ojk.lib.client.model.constant.ConfigVersion;
import id.go.ojk.lib.client.model.security.ClientEntity;
import id.go.ojk.lib.client.model.security.ClientEntityList;
import id.go.ojk.lib.client.model.update.UpdateHeader;
import id.go.ojk.lib.client.util.FileUtil;
import id.go.ojk.lib.client.util.JsonUtil;
import id.go.ojk.lib.client.util.XStreamUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseDatBuilder extends BaseBuilder implements IDatBuilder {
	protected String base64Key;
	private static final String VERSION_TXT = "version.txt";
	private static final String HEADER_FTP_XML = "headerFTP.xml";
	private static final String HEADER_XML = "header.xml";
	private static final String DATA_DAT = "data.dat";
	private String entityFolder;
	private String ftpFolder;
	private String ftpAppFolder;
	private String deployFolder;
	private ESector sector;
	private Map<String, String> ftpAccount;
	private Map<String, String> mapReport;
	private Map<String, List<String>> userAppAccess;
	private Map<String, List<String>> mapReportBySector;
	private final String selectedLjkCode;
	private int ljkCodeMinLen = 0;
	private int ljkCodeMaxLen = 0;
	private String enviType;
	private String ftpServer;
	private String resourceFolder;
	private UpdateHeader updateHeader;
	private UpdateHeader updateHeaderFtp;
	private String version;
	private Map<String, List<KeyValueString>> setupReferences;
	private List<String> listDatEntity = new ArrayList<>();

	protected BaseDatBuilder(String[] args, String base64Key, ESector sector) {
		super(BaseDatBuilder.getParameterRootFolder(args));
		selectedLjkCode = BaseDatBuilder.getParameterLjkCode(args);
		enviType = BaseDatBuilder.getParameterEnviType(args);
		ftpServer = BaseDatBuilder.getParameterFtpServer(args);
		resourceFolder = BaseDatBuilder.getParameterResourceFolder(args);
		this.base64Key = base64Key;
		this.sector = sector;
		initEntityFolder();
		initFtpFolder();
		initFtpAppFolder();
		initDeployFolder();
		initDeployResourcesFolder();
	}

	public void setLjkCodeMinLen(int ljkCodeMinLen) {
		this.ljkCodeMinLen = ljkCodeMinLen;
	}

	public List<String> getListDatEntity() {
		return listDatEntity;
	}

	public void setLjkCodeMaxLen(int ljkCodeMaxLen) {
		this.ljkCodeMaxLen = ljkCodeMaxLen;
	}

	public void setSetupReferences(Map<String, List<KeyValueString>> setupReferences) {
		this.setupReferences = setupReferences;
	}

	@Override
	public void init() {
		ftpAccount = initFtpAccount();
		mapReport = initMapReport();
		mapReportBySector = initReportBySector();
		userAppAccess = initUserAppAccess();
		updateHeader = initUpdateHeader();
		updateHeaderFtp = initUpdateHeaderFtp();
		version = initVersion();
	}

	@Override
	public String buildAll() {
		log.info("rootFolder=" + rootFolder + "|ljkCode=" + selectedLjkCode + "|enviType=" + enviType + "|ftpServer="
				+ ftpServer);
		buildClientCfg();
		UtilConfiguration.buildClientProperties(sourceFolder + File.separator);
		FileUtil.forceDeleteDirContent(entityFolder);
		ClientEntityList clientEntityList = getListClientEntity();
		List<ClientEntity> listClientEntity = clientEntityList != null ? clientEntityList.getClientEntityList() : null;
		if (listClientEntity != null) {
			init();
			buildVersionTxt();
			buildHeaderFtpXml();
			List<File> publicFiles = new ArrayList<>();
			publicFiles.add(new File(buildHeaderXml()));
			publicFiles.add(new File(buildMetadataJar()));
			publicFiles.add(new File(buildReferenceJar()));
			for (int i = 0; i < listClientEntity.size(); i++) {
				ClientEntity clientEntity = listClientEntity.get(i);
				if (StringUtils.isNotEmpty(selectedLjkCode)) {
					if (clientEntity.getEntityCode().equals(selectedLjkCode)) {
						buildClientEntityDat(publicFiles, clientEntity);
						break;
					}
				} else {
					buildClientEntityDat(publicFiles, clientEntity);
				}
			}
			uploadToFtp();
		}
		updateIssFile();
		copyToResource();
		return null;
	}

	@Override
	public String buildSetupJar(ClientEntity clientEntity) {
		SetupBuilder builder = new SetupBuilder(getEntityCodeFolder(clientEntity.getEntityCode()), base64Key);
		builder.setClientEntity(clientEntity);
		builder.setESectorType(ESectorType.getEnumByCode(sector.getType().getCode()));
		builder.setFtpAccount(ftpAccount);
		builder.setMapReport(mapReport);
		builder.setMapReportBySector(mapReportBySector);
		builder.setReferences(setupReferences);
		builder.setServerConfig(DummyEnvironment.configTrx(enviType));
		builder.setUserAppAccess(userAppAccess);
		return builder.buildAll();
	}

	@Override
	public String buildVersionTxt() {
		String res = "";
		try {
			File file = new File(FileUtil.concat(ftpFolder, VERSION_TXT));
			FileUtils.write(file, version);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return res;
	}

	@Override
	public String buildHeaderFtpXml() {
		String res = "";
		try {
			res = new FromUpdateHeader().toXml(FileUtil.concat(ftpFolder, HEADER_FTP_XML), updateHeaderFtp);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return res;
	}

	@Override
	public String buildHeaderXml() {
		String res = "";
		try {
			res = new FromUpdateHeader().toXml(FileUtil.concat(jarFolder, HEADER_XML), updateHeader);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return res;
	}

	@Override
	public void testBundle(String filename) {
		File file = new File(filename);
		try (InputStream inputStream = new FileInputStream(file)) {

			List<MemoryFile> memoryFiles = CompressionUtil.decompressToMemory(inputStream);
			if (memoryFiles != null) {
				for (MemoryFile memoryFile : memoryFiles) {
					log.info(memoryFile.getName());
				}
			} else {
				log.error("Null result");
			}
		} catch (ArchiveException | IOException e) {
			log.error(e.getMessage());
		}
	}

	public String getClientEntityString() {
		String res = "";
		if (EEnvironment.isOffline(enviType)) {
			res = genDummyClientEntity();
		} else {
			String endPoint = DummyEnvironment.config(EEnvironment.valueOf(enviType)).getCAMService();
			ICAMServiceProxy camService = new ICAMServiceProxy(endPoint);
			try {
				final String token = "a0fad6dd3a08ccb6901cde567a6031be";
				res = camService.getUserUnderEntitySector(token, new String[] { sector.getCode() });
				log.info("Client entity from CAM Service = {} \n", res);
			} catch (Exception e) {
				log.error("Failed get data from CAM Service.", e);
			}
		}
		return res;
	}

	public static String getParameterRootFolder(String[] args) {
		return getParameter(EConsoleParameter.ROOT_FOLDER.getKey(), args, ".\\_installer");
	}

	public static String getParameterLjkCode(String[] args) {
		return getParameter(EConsoleParameter.LJK_CODE.getKey(), args, "");
	}

	public static String getParameterEnviType(String[] args) {
		return getParameter(EConsoleParameter.ENVI_TYPE.getKey(), args, EEnvironment.OFFLINE.name());
	}

	public static String getParameterFtpServer(String[] args) {
		return getParameter(EConsoleParameter.FTP_SERVER.getKey(), args, EFtpServer.FTP01.name());
	}

	public static String getParameterResourceFolder(String[] args) {
		return getParameter(EConsoleParameter.RESOURCE_FOLDER.getKey(), args, "");
	}

	protected Map<String, String> initMapReport() {
		Map<String, String> res = null;
		if (EEnvironment.isOffline(enviType)) {
			res = EReport.getMap();
		} else {
			res = new SqlConnectionApolo(enviType).getMapReport();
			if (res == null || res.isEmpty()) {
				log.warn("Map report from Apolo server is empty, will use sample data");
				res = EReport.getMap();
			}
		}
		return excludeMapReport(res);
	}
	
	private Map<String, String> excludeMapReport(Map<String, String> source) {
		Map<String, String> res = new HashMap<>();
		log.info("MapReport Original={}", JsonUtil.toJson(source, true));
		Iterator<Entry<String, String>> iterator = source.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			String key = entry.getKey();
			String value = entry.getValue();
			if (!key.contains("SAFT")) {
				res.put(key, value);
			} else {
				log.warn("Exclude {}={}", key, value);
			}
		}
		log.info("MapReport Result={}", JsonUtil.toJson(res, true));
		return res;
	}

	protected Map<String, List<String>> initReportBySector() {
		Map<String, List<String>> res = null;
		if (EEnvironment.isOffline(enviType)) {
			res = EReportBySector.getMap();
		} else {
			res = new SqlConnectionApolo(enviType).getReportBySector();
			if (res == null || res.isEmpty()) {
				log.warn("Report by sector from Apolo server is empty, will use sample data");
				res = EReportBySector.getMap();
			}
		}
		return res;
	}

	protected Map<String, List<String>> initUserAppAccess() {
		return EEnvironment.isOffline(enviType) ? genDummyUserAppAccess()
				: new SqlConnectionApolo(enviType).getUserAppAccess();
	}

	protected abstract Map<String, List<String>> genDummyUserAppAccess();

	protected abstract UpdateHeader initUpdateHeader();

	protected abstract UpdateHeader initUpdateHeaderFtp();

	protected abstract String initVersion();

	protected String buildClientCfg() {
		String fileName = sourceFolder + File.separator + ClientConstant.CLIENT_CFG;
		try {
			FileUtils.writeLines(new File(fileName), "UTF-8", initClientCfg(), false);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return fileName;
	}

	protected List<String> initClientCfg() {
		List<String> res = new ArrayList<>();
		res.add("[Application]");
		res.add("app.name=OJKClient");
		res.add("");
		res.add("[JVMOptions]");
		res.add("-Xms1024m");
		res.add("-Xmx12240m");
		res.add("");
		res.add("[JVMUserOptions]");
		res.add("");
		res.add("[ArgOptions]");
		res.add("123456");
		return res;
	}
	
	private void updateIssFile() {
		final String fileName = sourceFolder + File.separator + "Client.iss";
		StringBuilder res = new StringBuilder();
		boolean needUpdate = false;
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line = reader.readLine();
			while (line != null) {
				boolean isAppVersion = line.startsWith("AppVersion");
				boolean isAppVerName = line.startsWith("AppVerName");
				if (isAppVerName && !line.contains(ConfigVersion.APPLICATION_VERSION)) {
					line = line.substring(0, line.indexOf(' ') + 1) + ConfigVersion.APPLICATION_VERSION;
					needUpdate = true;
				} else if (isAppVersion && !line.contains(ConfigVersion.APPLICATION_VERSION)) {
					line = line.substring(0, line.indexOf('=') + 1) + ConfigVersion.APPLICATION_VERSION;
					needUpdate = true;
				}
				res.append(line).append("\r\n");
				line = reader.readLine();
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		if (needUpdate) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
				writer.write(res.toString());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	private List<File> copySetupFileToEntityFolder(String rootEntityFolder, List<File> files) {
		List<File> res = new ArrayList<>();
		String folderEntityJar = getJarEntityFolder(rootEntityFolder);
		for (int i = 0; i < files.size(); i++) {
			File file = files.get(i);
			File newFile = new File(FileUtil.concat(folderEntityJar, file.getName()));
			try {
				FileUtils.copyFile(file, newFile);
				res.add(newFile);
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}
		return res;
	}

	private String buildClientEntityDat(List<File> publicFiles, ClientEntity clientEntity) {
		String res = "";
		String entityCode = clientEntity.getEntityCode();
		if (validateEntityCode(entityCode)) {
			String rootEntityFolder = getEntityCodeFolder(entityCode);
			List<File> files = copySetupFileToEntityFolder(rootEntityFolder, publicFiles);
			String datEntity = "data-" + clientEntity.getFullEntityCode() + ".dat";
			log.info("Preparing " + datEntity);
			File fileOutput = new File(FileUtil.concat(rootEntityFolder, DATA_DAT));
			try {
				String setupJar = buildSetupJar(clientEntity);
				files.add(new File(setupJar));
				CompressionUtil.compress(files, fileOutput);
				File fileDatEntity = new File(FileUtil.concat(ftpAppFolder, datEntity));
				FileUtils.copyFile(fileOutput, fileDatEntity);
				log.info(fileDatEntity.getAbsolutePath() + " ready!!!");
				listDatEntity.add(fileDatEntity.getAbsolutePath());
			} catch (NoSuchAlgorithmException | ArchiveException | IOException e) {
				log.error(e.getMessage());
			}
			res = fileOutput.getAbsolutePath();
		}
		return res;
	}

	private boolean validateEntityCode(String entityCode) {
		boolean res = false;
		if (StringUtils.isNotBlank(entityCode)) {
			if (ljkCodeMinLen <= 0 && ljkCodeMaxLen <= 0) {
				res = true;
			} else {
				int len = entityCode.length();
				res = len >= ljkCodeMinLen && len <= ljkCodeMaxLen;
			}
		}
		if (!res) {
			log.error("Invalid entityCode=" + entityCode + ";minLen=" + ljkCodeMinLen + ";maxLen=" + ljkCodeMaxLen);
		}
		return res;
	}

	private Map<String, String> initFtpAccount() {
		AppUploaderFtp.setEnvi(enviType);
		return AppUploaderFtp.getFTPAccount(sector.getCode());
	}

	private ClientEntityList getListClientEntity() {
		String clientEntityXml = getClientEntityXml();
		ClientEntityList res = null;
		if (StringUtils.isNotEmpty(clientEntityXml)) {
			XStream xstream = XStreamUtil.instanceStream();
			xstream.processAnnotations(new Class[] { ClientEntityList.class, ClientEntity.class });
			xstream.addImplicitCollection(ClientEntityList.class, "clientEntityList");
			res = (ClientEntityList) xstream.fromXML(new File(clientEntityXml));
		}
		return res;
	}

	private String getClientEntityXml() {
		File res = new File(FileUtil.concat(entityFolder, "clientEntity.xml"));
		String clientEntity = null;
		try (PrintWriter writer = new PrintWriter(res, "UTF-8");) {
			clientEntity = getClientEntityString();
			StringUtils.normalizeSpace(clientEntity);
			writer.write(clientEntity);
			log.info("Succeed to generate " + res.getAbsolutePath() + " from CAM Services.");
		} catch (IOException e) {
			log.error("Failed to get data from CAM Services.", e);
		}
		return res.getAbsolutePath();
	}

	private void initEntityFolder() {
		entityFolder = createFolders(rootFolder, "entity");
	}

	private void initFtpFolder() {
		ftpFolder = createFolders(rootFolder, "ftp");
	}

	private void initFtpAppFolder() {
		ftpAppFolder = createFolders(ftpFolder, "app");
	}

	private void initDeployFolder() {
		deployFolder = createFolders(rootFolder, "deploy");
	}

	private void initDeployResourcesFolder() {
		createFolders(deployFolder, "resources");
	}

	private String getEntityCodeFolder(String entityCode) {
		return createFolders(entityFolder, entityCode);
	}

	private String getJarEntityFolder(String entityCodeFolder) {
		return createFolders(entityCodeFolder, "jar");
	}

	protected String genDummyClientEntity(String sectorCode, List<String> listLjkCode, String userName) {
		StringBuilder res = new StringBuilder();
		res.append("<ArrayOfClientEntity>\n");
		for (int i = 0; i < listLjkCode.size(); i++) {
			res.append(genDummyClientEntity(sectorCode, listLjkCode.get(i), userName));
		}
		res.append("</ArrayOfClientEntity>");
		return res.toString();
	}

	protected String genDummyClientEntity(String sectorCode, List<String> listLjkCode, List<String> userNames) {
		StringBuilder res = new StringBuilder();
		res.append("<ArrayOfClientEntity>\n");
		for (int i = 0; i < listLjkCode.size(); i++) {
			res.append(genDummyClientEntity(sectorCode, listLjkCode.get(i), userNames));
		}
		res.append("</ArrayOfClientEntity>");
		return res.toString();
	}

	protected abstract String genDummyClientEntity();

	private String genDummyClientEntity(String sectorCode, String ljkCode, String userName) {
		String fullEntityCode = sectorCode + "-" + ljkCode;
		ESector eSector = ESector.getEnumByCode(sectorCode);
		String entityName = eSector != null ? eSector.getName() : "-";
		StringBuilder res = new StringBuilder();
		res.append(" <ClientEntity>\n");
		res.append("  <EntityName>" + entityName + "</EntityName>\n");
		res.append("  <FullEntityCode>" + fullEntityCode + "</FullEntityCode>\n");
		res.append("  <ListClientUser>\n");
		res.append("   <ClientUser>\n");
		res.append("    <NamaPengguna>" + userName.substring(0, userName.indexOf("@")) + "</NamaPengguna>\n");
		res.append("    <UserKey>uKIKC5CRUUxd+9F+zQQXSQ==</UserKey>\n");
		res.append("    <UserName>" + userName + "</UserName>\n");
		res.append("    </ClientUser>\n");
		res.append("   </ListClientUser>\n");
		res.append("  <SectorCode>" + sectorCode + "</SectorCode>\n");
		res.append(" </ClientEntity>\n");
		return res.toString();
	}

	private String genDummyClientEntity(String sectorCode, String ljkCode, List<String> userNames) {
		ESector eSector = null;

		List<String> codeAliasAsList = Arrays.asList(StringUtils.split(sectorCode,"-"));
		if (codeAliasAsList.size() == 2) {
			eSector = ESector.getEnumByCodeAlias(sectorCode);
			sectorCode = codeAliasAsList.get(0);
		} else
			eSector = ESector.getEnumByCode(sectorCode);

		String fullEntityCode = sectorCode + "-" + ljkCode;
		String entityName = eSector != null ? eSector.getName() : "-";
		StringBuilder res = new StringBuilder();
		res.append(" <ClientEntity>\n");
		res.append("  <EntityName>" + entityName + "</EntityName>\n");
		res.append("  <FullEntityCode>" + fullEntityCode + "</FullEntityCode>\n");
		res.append("  <ListClientUser>\n");
		for (String userName : userNames) {
			res.append("   <ClientUser>\n");
			res.append("    <NamaPengguna>" + userName.substring(0, userName.indexOf("@")) + "</NamaPengguna>\n");
			res.append("    <UserKey>uKIKC5CRUUxd+9F+zQQXSQ==</UserKey>\n");
			res.append("    <UserName>" + userName + "</UserName>\n");
			res.append("    </ClientUser>\n");
		}
		res.append("   </ListClientUser>\n");
		res.append("  <SectorCode>" + sectorCode + "</SectorCode>\n");
		res.append(" </ClientEntity>\n");
		return res.toString();
	}

	private void uploadToFtp() {
		if (StringUtils.isNotEmpty(enviType)) {
			AppUploaderFtp.setEnvi(enviType);
			AppUploaderFtp.allTask(ftpServer, sector.getCode(), ftpFolder, ftpAppFolder);
		}
	}
	
	private void copyToResource() {
		if (StringUtils.isNoneEmpty(selectedLjkCode, resourceFolder)) {
			File folder = new File(resourceFolder + File.separator + "resources");
			if (folder.exists()) {
				try {
					FileUtils.deleteDirectory(folder);
					String datFile = entityFolder + File.separator + selectedLjkCode + File.separator + DATA_DAT;
					FileUtils.copyFileToDirectory(new File(datFile), folder);
					FileUtils.copyFileToDirectory(new File(sourceFolder + File.separator + "Client.properties"), folder);
					FileUtils.copyFileToDirectory(new File(sourceFolder + File.separator + "Client.cfg "), folder);
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}
}
