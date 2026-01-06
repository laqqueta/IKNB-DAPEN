package id.go.ojk.lib.client.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamUtil {
	
	public static XStream instanceStream(){
		XStream xstream = new XStream(new DomDriver());
		return xstream;
	}
	
	public static XStream instanceStream(Class<?>... classAnnotations){
		XStream xstream = new XStream(new DomDriver());
		if (classAnnotations != null) {
			xstream.processAnnotations(classAnnotations);
		}
		return xstream;
	}

	public static String writeToXml(XStream xstream, Object data, String filename) throws IOException {
        String res = "";
		if (StringUtils.isNotBlank(filename) && data != null) {
			File file = new File(filename);
			File folder = new File(file.getParent());
			if (!folder.exists()) {
				folder.mkdirs();
			}
			try (FileOutputStream fos = new FileOutputStream(file)) {
				xstream.toXML(data, fos);
				res = file.getAbsolutePath();
			}
        }
		return res;
	}
}
