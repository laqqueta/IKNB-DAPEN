package id.go.ojk.conf.client;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.util.FileUtil;

public abstract class BaseBuilder extends BaseAppConsole {
	private static final String INSTALLER_FOLDER = ".." + File.separator + "_installer";
	protected String rootFolder;
	protected String jarFolder;
	protected String sourceFolder;
	
	protected BaseBuilder(String rootFolder) {
		if (StringUtils.isEmpty(rootFolder)) {
			rootFolder = INSTALLER_FOLDER;
		}
		this.rootFolder = FileUtil.getNormalizedFullPath(rootFolder);
		initRootFolder();
		initJarFolder();
		initSourceFolder();
	}
	
	protected String createFolders(String... folder) {
		String res = FileUtil.concat(folder);
		File file = new File(res);
		if (!file.exists()) {
			file.mkdirs();
		}
		return res;
	}
	
	private void initRootFolder() {
		rootFolder = createFolders(rootFolder);
	}
	
	private void initJarFolder() {
		jarFolder = createFolders(rootFolder, "jar");
	}
	
	private void initSourceFolder() {
		sourceFolder = FileUtil.concat(rootFolder, "source");
	}
}
