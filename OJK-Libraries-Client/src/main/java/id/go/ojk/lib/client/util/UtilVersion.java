package id.go.ojk.lib.client.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtilVersion {

	public static String getVersion(Class<?> clazz) {
		String res = "";
		try {
			if (clazz != null) {
				res = clazz.getPackage().getImplementationVersion();
				if (res == null) {
					res = clazz.getPackage().getSpecificationVersion();
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return res == null ? "0.0.0" : res;
	}

	private UtilVersion() {
	}
}
