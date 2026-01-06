package id.go.ojk.lib.client.instance;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseProperties {
	private Properties properties;
	private String fileName;
	private long fileLastModified = 0;
	
	protected BaseProperties(String fileName) {
		this.fileName = fileName;
		load();
	}
	
	public String getValue(String key) {
		reload();
		return properties != null ? properties.getProperty(key) : null;
	}
	
	public String getValue(String key, String defaultValue) {
		reload();
		return properties != null ? properties.getProperty(key, defaultValue) : defaultValue;
	}
	
	public int getValueAsInt(String key) {
		String value = getValue(key);
		return StringUtils.isNumeric(value) ? Integer.parseInt(value) : 0;
	}
	
	public int getValueAsInt(String key, int defaultValue) {
		String value = getValue(key);
		return StringUtils.isNumeric(value) ? Integer.parseInt(value) : defaultValue;
	}
	
	private void reload() {
		File file = new File(fileName);
		if (fileLastModified == 0 || fileLastModified < file.lastModified()) {
			load();
		}
	}
	
	private void load() {
		properties = new Properties();
		File file = new File(fileName);
		try (InputStream stream = new FileInputStream(file)) {
			properties.load(stream);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			fileLastModified = file.lastModified();
		}
	}
}
