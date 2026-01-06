package id.go.ojk.lib.client.model.constant;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum OsCode {
	win64("exe"), 
	lin64(
			//"rpm"
			"tar.gz"
			), 
	mac64("dmg"),
	all("");
	
	private String installerExt;
	
	private OsCode(String installerExt){
		this.installerExt = installerExt;
	}
	
	public String getInstallerExt() {
		return installerExt;
	}
	
	public Optional<String> validateExt(String filename) {
		String errorMessage = null;
		
		if ( !filename.endsWith(installerExt) ){
			errorMessage = "Nama file " + filename + " tidak valid, ext harus " + installerExt;
		}
		
//		String fileExt = FilenameUtils.getExtension(filename);
//		if ( !installerExt.equals(fileExt) ) {
//			errorMessage = "Nama file " + filename + " tidak valid, ext harus " + installerExt;
//		}
		
		return errorMessage == null ? Optional.empty() : Optional.of(errorMessage);
	}

	//static util
	
	public static String getInstallerExt(String osCodeString){
		OsCode osCode = OsCode.valueOf(osCodeString);
		return (osCode == null) ? null : osCode.getInstallerExt();
	}
	
	public static List<String> getValueList(){
		return Arrays.asList(OsCode.values()).stream().map( e -> e.name()).collect(Collectors.toList());
	}

}
