package id.go.ojk.client.service;

import static id.go.ojk.lib.client.model.update.ClientComponents.clApplication;
import static id.go.ojk.lib.client.model.update.ClientComponents.clLibrary;
import static id.go.ojk.lib.client.model.update.ClientComponents.clMetadata;
import static id.go.ojk.lib.client.model.update.ClientComponents.clReferences;
import static id.go.ojk.lib.client.model.update.ClientComponents.clSetup;
import static id.go.ojk.lib.client.model.update.ClientComponents.clSetupBranch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.constant.EVersion;
import id.go.ojk.client.service.base.BaseService;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.service.validation.MetadataService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.client.util.UpdateRollBackUtil;
import id.go.ojk.lib.client.CompressionUtil;
import id.go.ojk.lib.client.DateUtil;
import id.go.ojk.lib.client.HttpUtil;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.DtoVersion;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.bind.ProgressModel;
import id.go.ojk.lib.client.model.bind.VersionModel;
import id.go.ojk.lib.client.model.config.SlikClientCfg;
import id.go.ojk.lib.client.model.constant.OjkClientConstant;
import id.go.ojk.lib.client.model.update.ClientComponent;
import id.go.ojk.lib.client.model.update.ClientComponents;
import id.go.ojk.lib.client.model.update.UpdateHeader;
import id.go.ojk.lib.client.model.update.UpdateLog;
import id.go.ojk.lib.client.model.update.Version;
import id.go.ojk.lib.client.util.XStreamUtil;
import javafx.application.Platform;
import javafx.scene.control.Alert.AlertType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationUpdateService extends BaseService {

    public final static String key_version_libs 	= "libs";

    public final static String key_latestVersion 	= "latestVersion";
	public final static String key_latestStatus 	= "latestStatus";
	public final static String key_versionCheck 	= "versionCheck";

	public final static String file_header 			= "header.xml";
	
	final VersionModel versionModel = new VersionModel();

	public ApplicationUpdateService(){
	}

	public VersionModel getVersionModel() {
		return versionModel;
	}

	public Map<String, String> getClientVersion(){
		Map<String, String> clientVersion = new HashMap<>();
		clientVersion.put(clApplication.getName(), 		getApplicationVersion());
		clientVersion.put(clLibrary.getName(), 			getLibraryVersion());
		clientVersion.put(clSetup.getName(), 			getSetupVersion());
		
		if( !setupService.isClientTypeOJK() ){
			clientVersion.put(clSetupBranch.getName(), 		getSetupBranchModified());
			clientVersion.put(clReferences.getName(), 		getReferencesVersion());
			clientVersion.put(clMetadata.getName(), 		getMetadataVersion());			
		}
		
		return clientVersion;
	}
	
	public boolean validateVersion() {
		DtoVersion serverVersion = securityService.getUserSession().getVersion();
		if (serverVersion == null) {
			return true;
		}
		Map<String, String> localVersion = getClientVersion();
		String appVersionLocal = localVersion.get(EVersion.APPLICATION.getId());
		boolean appNeedUpdate = !StringUtils.equals(serverVersion.getApplication(), 
				appVersionLocal);
		log.info("App version, local:{}, server:{}; needUpdate:{}", appVersionLocal, serverVersion.getApplication(), appNeedUpdate);
		String metadataVersionLocal = localVersion.get(EVersion.METADATA.getId());
		String refVersionLocal = localVersion.get(EVersion.REFERENCES.getId());
		boolean datNeedUpdate = !(StringUtils.equals(serverVersion.getMetadata(), metadataVersionLocal) && 
				StringUtils.equals(serverVersion.getReference(),  refVersionLocal));
		log.info("Metadata version, local:{}, server:{}; Reference version, local:{}, server:{}; needUpdate:{}", 
				metadataVersionLocal, serverVersion.getMetadata(), refVersionLocal, serverVersion.getReference(), datNeedUpdate);
		if (appNeedUpdate && datNeedUpdate) {
			AlertUtil.showAlertSafe(AlertType.INFORMATION, "Download Installer Client", "Download Installer Client", 
					"Aplikasi Client perlu diperbaharui.\n"
					+ "Download dan install ulang aplikasi Client terbaru melalui website APOLO.\n"
					+ "Setelah selesai, ulangi proses validasi kembali.");
			
			return false;
		} 
		if (appNeedUpdate && !datNeedUpdate) {
			AlertUtil.showAlertSafe(AlertType.INFORMATION, "Download Installer Client", "Download Installer Client", 
					"Aplikasi Client perlu diperbaharui.\n"
					+ "Download dan install ulang aplikasi Client terbaru melalui website APOLO.\n"
					+ "Setelah selesai, ulangi proses validasi kembali.");
			
			return false;
		}
		if (!appNeedUpdate && datNeedUpdate) {
			AlertUtil.showAlertSafe(AlertType.INFORMATION, "Download Update Data", "Download Update Data",
					"Data aplikasi Client perlu diperbaharui.\n"
					+ "Download file update data melalui website APOLO.\n"
					+ "Lakukan update data melalui MENU UPDATE OFFLINE. \n"
					+ "Setelah selesai, ulangi proses validasi kembali.");
			
			return false;
		}			
		return true;
	}
	
	public Map<String, Map<String, Object>> cekVersion() throws ClientProtocolException, IOException, URISyntaxException{
		return cekVersion(true);
	}

	public Map<String, Map<String, Object>> cekVersion(boolean tryReloginIfNeeded) throws ClientProtocolException, IOException, URISyntaxException{
		Map<String, Object> responseMap = httpService.postMapReturnJsonMap(httpService.getCheckVersionUrl(), getClientVersion(), tryReloginIfNeeded);
		if ( HttpUtil.isSuccessResponse(responseMap) ){
			return (Map<String, Map<String, Object>>) responseMap.get("payload");			
		} else {
			throw new SlikException(HttpUtil.getMessage(responseMap));
		}
	}

	public boolean isNeedUpdatePayload(Map<String, Object> responsePayload) {
		Map<String, Map<String, Object>> versionCheck = (Map<String, Map<String, Object>>) responsePayload.get(key_versionCheck);
		return isNeedUpdate(versionCheck);
	}

	public boolean isNeedUpdate(Map<String, Map<String, Object>> versionCheck) {
		for (Entry<String, Map<String, Object>> tmp : versionCheck.entrySet()) {
			Boolean latestStatus = (Boolean) tmp.getValue().get(key_latestStatus);
			if ( !latestStatus )
				return true;
		}
		return false;
	}

	public Tupple2<Boolean, List<String>> doUpdate(ProgressModel progressModel, File updateFile) {
		UpdateLog updateLog = null;
		if (setupService.isClientTypeOJK()){
			updateLog =  UpdateLog.builder()
					.datetime(DateUtil.formatNow())
					.details(Arrays.asList(
						UpdateLog.UpdateLogDetail.builder().componentCode(clApplication.getName()).previousVersion(getApplicationVersion()).afterVersion(getApplicationVersion()).build(),
						UpdateLog.UpdateLogDetail.builder().componentCode(clLibrary.getName()).previousVersion(getLibraryVersion()).afterVersion(getLibraryVersion()).build(),
						UpdateLog.UpdateLogDetail.builder().componentCode(clSetup.getName()).previousVersion(getSetupVersion()).afterVersion(getSetupVersion()).build()
					))
					.build()
					; 
		} else {
			updateLog =  UpdateLog.builder()
					.datetime(DateUtil.formatNow())
					.details(Arrays.asList(
						UpdateLog.UpdateLogDetail.builder().componentCode(clApplication.getName()).previousVersion(getApplicationVersion()).afterVersion(getApplicationVersion()).build(),
						UpdateLog.UpdateLogDetail.builder().componentCode(clLibrary.getName()).previousVersion(getLibraryVersion()).afterVersion(getLibraryVersion()).build(),
						UpdateLog.UpdateLogDetail.builder().componentCode(clSetup.getName()).previousVersion(getSetupVersion()).afterVersion(getSetupVersion()).build(),
						UpdateLog.UpdateLogDetail.builder().componentCode(clSetupBranch.getName()).previousVersion(getSetupBranchModified()).afterVersion(getSetupBranchModified()).build(),
						UpdateLog.UpdateLogDetail.builder().componentCode(clReferences.getName()).previousVersion(getReferencesVersion()).afterVersion(getReferencesVersion()).build(),
						UpdateLog.UpdateLogDetail.builder().componentCode(clMetadata.getName()).previousVersion(getMetadataVersion()).afterVersion(getMetadataVersion()).build()
					))
					.build()
					; 			
		}
		
		boolean mustStart = false;
		List<String> messages = new ArrayList<>();
		
		progressModel.setTotalLength(4);
		File tmpDir = new File(updateFile.getParent() + "/" + DateUtil.formatNow() + "_extract");
		File backupDir = new File("backup/" + DateUtil.formatNow());

		try {
			tmpDir.mkdirs();
			backupDir.mkdirs();

			progressModel.setProgress(0d);

			//extract
			Map<String, File> fileMap = CompressionUtil.decompressToMap(updateFile, tmpDir);
			
			progressModel.addProgress(1);

			//read header
			File headerFile = fileMap.get(file_header);
			if ( headerFile == null ){
				messages.add("File update tidak valid!!");
				return Tupple2.<Boolean, List<String>>builder().a(mustStart).b(messages).build();
			}
			
			XStream xstream = xStreamUpdateHeader();

			UpdateHeader updateHeader = (UpdateHeader) xstream.fromXML(headerFile);
			progressModel.addProgress(1);

			//copy
			Map<String, String> clientVersions = getClientVersion();
			for (Entry<String, String> header : updateHeader.getVersions().entrySet()) {
				String headerName 		= header.getKey();
				String serverVersion	= header.getValue();
				String clientVersion	= clientVersions.get(headerName);
				ClientComponent component = ClientComponents.valueOf(headerName);

				if (component == null){
					throw new SlikException(headerName + " not found");
				}
				File updateComponentFile = fileMap.get(component.getFileName());
				if (updateComponentFile == null){
					throw new SlikException(headerName + " not found");
				}

				if ( component != ClientComponents.clSetup && Version.compare(serverVersion, clientVersion) <= 0){
//					String message = component.getName() + " sudah versi terakhir (" + serverVersion + ")";
					String message = component.getName() + " sudah versi terakhir (" + clientVersion + ")"; //arnol modif : versi client
					messages.add(message);
					logger.info(message);
					continue;
				}

				String message = null;
				if ( clApplication == component ){
					updateApplication(serverVersion, updateComponentFile, backupDir, updateLog);
					mustStart = true;
					message = component.getName() + " berhasil diperbaharui ke versi " + serverVersion ;
				} else if ( clLibrary == component ){
					updateLibrary(serverVersion, updateComponentFile, backupDir, updateLog);
					mustStart = true;
					message = component.getName() + " berhasil diperbaharui ke versi " + serverVersion ;
				} else if ( clSetup == component ){
					List<String> updateSetupMessages = setupService.updateSetupjar(updateComponentFile, backupDir, updateLog);
					messages.addAll(updateSetupMessages);
				} else if ( clMetadata == component ){
					doUpdateCopy(component, serverVersion, backupDir, updateComponentFile, updateLog);
					mustStart = true;
					message = component.getName() + " berhasil diperbaharui ke versi " + serverVersion;
				} else if ( clReferences == component){
					doUpdateCopy(component, serverVersion, backupDir, updateComponentFile, updateLog);
					mustStart = true;
					message = component.getName() + " berhasil diperbaharui ke versi " + serverVersion;
				}
				
				if (StringUtils.isNotEmpty(message)){
					messages.add(message);
					logger.info(message);
				}
			}
			progressModel.addProgress(3);
			
			saveUpdateLog(backupDir, updateLog);
			if( !mustStart ) {
				setupService.initialize();
				referenceService.initialize();
				metadataService.initialize();
				submissionService.initialize();
				summarySubmissionService.initialize();
				
				MainApplication mainApplication = appContext.getService(MainApplication.class);
//				mainApplication.getHomeUI().getB().synchSummaryMenu();
			}
			
			progressModel.setProgress(1d);
		} catch (Throwable e) {
			logger.error("", e);
			final UpdateLog updateLogFinal = updateLog;
			Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
			    	AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", "Update gagal, mencoba rollback");
			    	if ( UpdateRollBackUtil.rollBackSafe(updateLogFinal) ){
			    		AlertUtil.showAlert(AlertType.INFORMATION, "Informasi", "Rollback berhasil, aplikasi akan direstart!");
			    		appContext.getService(MainApplication.class).restartApplication();
			    	} else {
			    		AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", "Rollback gagal, aplikasi akan ditutup!");
			    		System.exit(-1);
			    	}
			    }
			});
			return null;
//			roolBackUpdate(backupDir);
//			throw new SlikException("", e);
		} finally {
			progressModel.setOnProcess(false);
		}
		return Tupple2.<Boolean, List<String>>builder().a(mustStart).b(messages).build();
	}
	
	private File saveUpdateLog(File backupDir, UpdateLog updateLog) throws FileNotFoundException, IOException{
		File updateLogFile = new File(backupDir.getAbsolutePath() + ".updatelog");
		
		XStream xstream = updateLogXStream();
		xstream.processAnnotations(
			new Class[]{
				UpdateLog.class, UpdateLog.UpdateLogDetail.class,
			}
		);
		try ( FileOutputStream fos = new FileOutputStream(updateLogFile) ){
			xstream.toXML(updateLog, fos);
		}

		return updateLogFile;
	}
	
	public static XStream updateLogXStream() throws FileNotFoundException, IOException{		
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(
			new Class[]{
				UpdateLog.class, UpdateLog.UpdateLogDetail.class,
			}
		);
		return xstream;
	}


	public void roolBackUpdate(File backupDir) {
		//TODO
//		if ( !backupDir.exists() )
//			return;
//
//		File[] files = backupDir.listFiles();
//		for (File srcFile : files) {
//			File destFile = new File("")
//
//			FileUtils.copyFile(srcFile, destFile);
//		}
	}

	private void doUpdateCopy(ClientComponent component, String serverVersion, File backupDir, File file, UpdateLog updateLog) throws IOException{
		logger.info("updating " + component.getName());
		File destFile = new File(component.getDirPath() + "/" + component.getFileName());
		File backupFile = new File(backupDir.getAbsolutePath() + "/" + component.getFileName());
		
		Path destPath = Files.move(
			Paths.get(destFile.getAbsolutePath()),
			Paths.get(backupFile.getAbsolutePath())
		);
		
		updateLog.updateVersion(component.getName(), serverVersion, backupFile.getAbsolutePath());
		
		FileUtils.copyFile(file, destFile);
	}

	//~ getter

	public final File libVersionFile = new File("resources/version.xml");
	
	public String getApplicationVersion(){
		return OjkClientConstant.applicationVersion;
	}
	
	public Properties getVersionProperties(){
		try {
			Properties properties = new Properties(); 
			if ( libVersionFile.exists() ){
				try ( FileInputStream is = new FileInputStream(libVersionFile) ){
					properties.loadFromXML(is);
				}
			} else {
				saveVersionProperties(properties);
			}
			
			return properties;
		} catch (Throwable t){
			logger.error("", t);
			throw new SlikException("", t);
		}
	}
	
	public void saveVersionProperties(Properties properties) throws FileNotFoundException, IOException{
		try (FileOutputStream os = new FileOutputStream(libVersionFile, false)){
			properties.storeToXML(os, "Slik Version");	
		}
	}

	public String getLibraryVersion(){
		try {
			Properties properties = getVersionProperties(); 
			
			String libVersion = properties.getProperty(key_version_libs);
			if ( StringUtils.isEmpty(libVersion) ){
				libVersion = OjkClientConstant.libraryVersion;
				properties.setProperty(key_version_libs, libVersion);
				saveVersionProperties(properties);
			}

			return libVersion;
		} catch (Throwable t){
			logger.error("", t);
			throw new SlikException("", t);
		}
	}
	
	public void updateVersionProperties(String key, String value){
		try {
			Properties properties = getVersionProperties(); 
			properties.setProperty(key, value);

			saveVersionProperties(properties);
		} catch (Throwable t){
			logger.error("", t);
			throw new SlikException("", t);
		}
	}

	public String getSetupVersion(){
		return setupService.getSetupHeader().getVersion();
	}

	public String getSetupBranchModified(){
		return setupService.getSetupHeader().getLastModified();
	}

	public String getReferencesVersion(){
		return referenceService.getVersion();
	}

	public String getMetadataVersion(){
		return submissionService.getMetadata().getVersion();
	}

	//~ initialize

	private HttpService httpService;
	private SetupService setupService;
	private ReferenceService referenceService;
	private SubmissionService submissionService;
	private SubmissionService summarySubmissionService;
	private SecurityService securityService;
	private MetadataService metadataService;

	@Override
	public void initialize() {
		this.httpService = appContext.getService(HttpService.class);
		this.setupService = appContext.getService(SetupService.class);
		this.referenceService = appContext.getService(ReferenceService.class);
		this.metadataService = appContext.getService(MetadataService.class);
		
		this.submissionService = appContext.getService("submissionService", SubmissionService.class);
		this.summarySubmissionService = appContext.getService("summarySubmissionService", SubmissionService.class);
		this.securityService = appContext.getService(SecurityService.class);

		reloadVersion();
	}

	public void reloadVersionSafe(){
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	reloadVersion();
		    }
		});
	}

	public void reloadVersion(){
		versionModel.applicationVersionProperty.set(getApplicationVersion());
		versionModel.libraryVersionProperty.set(getLibraryVersion());
		
		if(!setupService.isClientTypeOJK())
		{
			versionModel.referencesVersionProperty.set(getReferencesVersion());
			versionModel.metadataVersionProperty.set(getMetadataVersion());			
		}
		
		String setupBranchModified = getSetupBranchModified();
		versionModel.setupModifiedProperty.set(setupBranchModified);

		versionModel.setupModifiedParseProperty.set(DateUtil.convertFormatDate(setupBranchModified));
	}
	
	//~ update application
	
	private void updateApplication(String version, File updateFile, File backupDir, UpdateLog updateLog) throws FileNotFoundException, ArchiveException, IOException{
		String destFileName = FilenameUtils.getBaseName(clApplication.getFileName()) + "-" + version + "." + FilenameUtils.getExtension(clApplication.getFileName());
		
		File destFile = new File("./" + clApplication.getDirPath() + "/" + destFileName);
		FileUtils.copyFile(updateFile, destFile);
		
		SlikClientCfg slikClientCfg = SlikClientCfg.newInstance();
		
		updateLog.updateVersion(clApplication.getName(), version, slikClientCfg.getAppMainjar());
		
		slikClientCfg.setAppMainjar(destFileName);
		slikClientCfg.store();
	}

	private void updateLibrary(String version, File updateFile, File backupDir, UpdateLog updateLog) throws FileNotFoundException, ArchiveException, IOException{
		String dirName = clLibrary.getDirPath() + "-" + version;
		File libDestDir = new File("./" + dirName);
		List<File> files = CompressionUtil.decompress(updateFile, libDestDir);
		
		String appClasspath = files.stream().map( f -> dirName + "/" + f.getName() ).collect(Collectors.joining(";"));
		
		SlikClientCfg slikClientCfg = SlikClientCfg.newInstance();
		updateLog.updateVersion(clLibrary.getName(), version, slikClientCfg.getAppClasspath());
		
		slikClientCfg.setAppClasspath(appClasspath);
		slikClientCfg.store();
		
		updateVersionProperties(key_version_libs, version);
	}
	
	public XStream xStreamUpdateJarHeader(){
		XStream xstream = XStreamUtil.instanceStream();
		xstream.processAnnotations(
			new Class[]{
				UpdateHeader.class
			}
		);
		return xstream;
	}

	public XStream xStreamUpdateHeader(){
		XStream xstream = XStreamUtil.instanceStream();
		xstream.processAnnotations(
			new Class[]{
				UpdateHeader.class
			}
		);
		return xstream;
	}
	
	
	// RBB custom
	public void saveHeader(File file, UpdateHeader updateHeader) throws FileNotFoundException, IOException {
		file.getParentFile().mkdirs();
		XStream xstream = instanceXStream();
		try ( FileOutputStream fos = new FileOutputStream(file)){
			xstream.toXML(updateHeader, fos);
		}
	}
	
	public XStream instanceXStream(){
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(
				new Class[]{
					UpdateHeader.class
				}
			);
		
		return xstream;
	}

}
