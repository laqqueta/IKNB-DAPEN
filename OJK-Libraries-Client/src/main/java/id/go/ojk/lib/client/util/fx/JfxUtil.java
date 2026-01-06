package id.go.ojk.lib.client.util.fx;

import java.awt.Desktop;
import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JfxUtil {
	
	private static Logger logger = LoggerFactory.getLogger(JfxUtil.class);
	
	public static void openDir(File dir){
		try {
			Desktop.getDesktop().open(dir);
		} catch (Exception e) {
			logger.error("Fail open direktory " + dir.getAbsolutePath(), e);
		}		
	}
}
