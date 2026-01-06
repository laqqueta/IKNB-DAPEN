package id.go.ojk.client.util;

import static id.go.ojk.lib.client.model.update.ClientComponents.clApplication;
import static id.go.ojk.lib.client.model.update.ClientComponents.clLibrary;
import static id.go.ojk.lib.client.model.update.ClientComponents.clMetadata;
import static id.go.ojk.lib.client.model.update.ClientComponents.clReferences;
import static id.go.ojk.lib.client.model.update.ClientComponents.clSetup;
import static id.go.ojk.lib.client.model.update.ClientComponents.clSetupBranch;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalLong;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;

import id.go.ojk.client.service.ApplicationUpdateService;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.client.service.impl.ReferenceServiceClient;
import id.go.ojk.client.service.validation.MetadataService;
import id.go.ojk.lib.client.model.config.SlikClientCfg;
import id.go.ojk.lib.client.model.update.UpdateLog;
import id.go.ojk.lib.client.model.update.UpdateLog.UpdateLogDetail;
import javafx.scene.control.Alert.AlertType;

public class UpdateRollBackUtil {

	protected static Logger logger = LoggerFactory.getLogger(UpdateRollBackUtil.class);
	
	public static boolean rollBackSafe(){
		try {
			return rollBack();
		} catch (IOException e) {
			logger.error("", e);
			AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", "Gagal rollback aplikasi, mohon install ulang aplikasi");
			return false;
		}
	}
	
	public static boolean rollBack() throws IOException{
		File backupDir = new File("backup");
		File[] fileArray = backupDir.listFiles(f -> f.isFile() && f.getName().endsWith(".updatelog") );
		List<File> files = Arrays.asList(fileArray);
		OptionalLong optionalLong = files.stream().mapToLong( f -> Long.parseLong(FilenameUtils.getBaseName(f.getName()))).max();
		if ( optionalLong.isPresent() ){
			File updateLogFile = new File(backupDir.getAbsolutePath() + "/" + optionalLong.getAsLong() + ".updatelog");
			
			XStream xStream = ApplicationUpdateService.updateLogXStream();
			UpdateLog updateLog = (UpdateLog) xStream.fromXML(updateLogFile);
			rollBack(updateLog);	
		} else {
			AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", "Gagal rollback aplikasi, tidak ditemukan history update");
			return false;
		}
		return true;
	}
	
	public static boolean rollBackSafe(UpdateLog updateLog) {
		try {
			return rollBack(updateLog);
		} catch (IOException e) {
			logger.error("", e);
			AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", "Gagal rollback aplikasi, mohon install ulang aplikasi");
			return false;
		}
	}
	
	private static boolean rollBack(UpdateLog updateLog) throws IOException {
		List<UpdateLogDetail> details = updateLog.getDetails();
		for (UpdateLogDetail updateLogDetail : details) {
			if ( !updateLogDetail.isVersionChange() ){
				continue;
			}
			
			String componentCode = updateLogDetail.getComponentCode();
			if ( clApplication.getName().equals(componentCode)){
				SlikClientCfg slikClientCfg = SlikClientCfg.newInstance();				
				slikClientCfg.setAppMainjar(updateLogDetail.getPreviousResource());
				slikClientCfg.store();
			} else if ( clLibrary.getName().equals(componentCode) ){
				SlikClientCfg slikClientCfg = SlikClientCfg.newInstance();				
				slikClientCfg.setAppClasspath(updateLogDetail.getPreviousResource());
				slikClientCfg.store();
			} 
			
			else if ( clSetup.getName().equals(componentCode) || clSetupBranch.getName().equals(componentCode) ){
				FileUtils.forceDelete(SetupService.setupJarFile);
				FileUtils.moveFile(new File(updateLogDetail.getPreviousResource()), SetupService.setupJarFile);
			} 
			
			
			else if ( clMetadata.getName().equals(componentCode) ){
				FileUtils.forceDelete(MetadataService.metadataFile);
				FileUtils.moveFile(new File(updateLogDetail.getPreviousResource()), MetadataService.metadataFile);				
			} else if ( clReferences.getName().equals(componentCode)){
				FileUtils.forceDelete(ReferenceServiceClient.referenceJarFile);
				FileUtils.moveFile(new File(updateLogDetail.getPreviousResource()), ReferenceServiceClient.referenceJarFile);								
			}

		}
		return true;
	}
	
}
