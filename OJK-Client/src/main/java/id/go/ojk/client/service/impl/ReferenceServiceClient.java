package id.go.ojk.client.service.impl;

import static id.go.ojk.lib.client.model.update.ClientComponents.clFaq;
import static id.go.ojk.lib.client.model.update.ClientComponents.clManual;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.io.FileUtils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.client.util.SystemMessageUtil;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.lib.client.EncryptionCompressionUtil;
import id.go.ojk.lib.client.model.compression.MemoryFile;
import id.go.ojk.lib.client.model.constant.ClientTypeFlag;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.security.UserSession;

public class ReferenceServiceClient extends ReferenceServiceBase implements ReferenceService {

	public final static File referenceJarFile = new File("resources/references.jar");
	
	//~ load

	@Override
	protected void loadReference() throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException{
		SetupService setupService =  ApplicationContextClient.getInstance().getService(SetupService.class);
		if ( setupService.isClientTypeOJK() ){
			return;
		}
		//File referenceJarFile = new File("resources/references.jar");
		Map<String, MemoryFile> memoryFileMap = EncryptionCompressionUtil.decryptAndDecompressToMemoryMap(HomeController.homeButton, referenceJarFile);
		loadReference(memoryFileMap);

		//Faq and manual
		File helpDir = new File(clFaq.getDirPath());
		helpDir.mkdirs();
		FileUtils.writeByteArrayToFile(new File( helpDir.getAbsoluteFile() + "/" + clFaq.getFileName() ), memoryFileMap.get(clFaq.getFileName()).getContent());
		FileUtils.writeByteArrayToFile(new File( helpDir.getAbsoluteFile() + "/" + clManual.getFileName() ), memoryFileMap.get(clManual.getFileName()).getContent());
		
		AlertUtil.initMessage(this);
		SystemMessageUtil.initMessage(this);
	}	
	
	@Override
	protected void loadBranch(Builder<Integer, ImmutableList<String>> builder) {
		builder.put(
			ReferenceMetadata.R3Branch.getNumber(),
			readReferencesList(appContext.getService(SetupService.class).getBranchReference())
		);		
	}
	
	//~ online on client
	
	private Map<String, Map<String, String>> onlineReferenceMap = new HashMap<>();
	
	public void loginOnlineSuccess(UserSession userSession){
		SetupService setupService =  ApplicationContextClient.getInstance().getService(SetupService.class);
		if ( setupService.getClientTypeFlag() != ClientTypeFlag.I ){
			//tidak ada referensi
			return;
		}
		Map<String, Map<String, String>> onlineReferenceMap = (Map<String, Map<String, String>>) userSession.getLoginOnlineResponse().get("referenceMap");
		if ( onlineReferenceMap != null ){
			this.onlineReferenceMap = onlineReferenceMap;
		}		
	}
	
	public Map<String, String> getOnlineReference(String referenceName){
		return onlineReferenceMap.get(referenceName);
	}
	
  public ImmutableMap<Integer, ImmutableList<String>> getReferenceDataList() {
    return referenceDataList;
  }

  public ImmutableMap<Integer, ReferenceMetadata> getReferenceMetadatas() {
    return referenceMetadatas;
  }
}
