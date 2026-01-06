package id.go.ojk.client.service;

import java.io.File;
import java.util.List;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.service.base.BaseService;
import id.go.ojk.client.util.UtilConfiguration;
import id.go.ojk.lib.client.CompressionUtil;
import id.go.ojk.lib.client.exception.SlikException;

public class PreStartService extends BaseService {

	public final static File setupJarFile = new File(ClientConstant.RESOURCES + File.separator + "setup.jar");
	public final static File metadataJarFile = new File(ClientConstant.RESOURCES + File.separator + "metadata.jar");
	public final static File referencesJarFile = new File(ClientConstant.RESOURCES + File.separator + "references.jar");
	public final static File versionXmlFile = new File(ClientConstant.RESOURCES + File.separator + "version.xml");
	
	private File dataDatFile = new File(ClientConstant.RESOURCES + File.separator + "data.dat");
	private File clientPropertiesFile = new File(ClientConstant.RESOURCES + File.separator + ClientConstant.CLIENT_PROPERTIES);
	public final static File resourcesDir = new File("resources");

	@Override
	public void initialize() {
		try {
			if (!clientPropertiesFile.exists()) {
				UtilConfiguration.buildClientProperties(ClientConstant.RESOURCES + File.separator);
			}
			if ( dataDatFile.exists() ) {
				setupJarFile.delete();
				metadataJarFile.delete();
				referencesJarFile.delete();
				versionXmlFile.delete();
				
				CompressionUtil.decompress(dataDatFile, new File("resources"));
				
				dataDatFile.delete();
			}
			
			if ( !setupJarFile.exists() || !metadataJarFile.exists() || !referencesJarFile.exists() ){
				throw new SlikException("File tidak lengkap, mohon install ulang!");
			}
		} catch (Exception e){
			throw new SlikException("", e);
		}
	}
	
	public void cekDataData(MainApplication mainApplication){	
		if ( !dataDatFile.exists() && (!setupJarFile.exists() || !metadataJarFile.exists() || !referencesJarFile.exists()) ){
			mainApplication.showSelectDataDatDialog();
		}
	}
	
	public boolean isAllFileExist(List<String> fileNames, File ... cekFiles){
		for (File cekFile : cekFiles) {
			if (!isFileExist(fileNames, cekFile)){
				return false;
			}
		}
		return true;
	}
	
	public boolean isFileExist(List<String> fileNames, File cekFile){
		String cekFileName = PreStartService.setupJarFile.getName().toLowerCase();
		return fileNames.contains(cekFileName);
	}
	
}
