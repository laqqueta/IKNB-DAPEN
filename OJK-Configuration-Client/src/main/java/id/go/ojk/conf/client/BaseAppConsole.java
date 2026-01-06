package id.go.ojk.conf.client;

import org.apache.commons.lang3.StringUtils;

public abstract class BaseAppConsole {
	
	protected static String getParameter(String key, String[] args, String defaultValue) {
		String res = null;
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				String[] splitted = StringUtils.split(args[i], "=");
				if (splitted.length > 1 && key.equals(splitted[0])) {
					res = splitted[1];
					break;
				}
			}
		}
		return StringUtils.isNotBlank(res) ? res : defaultValue;
	}

}
