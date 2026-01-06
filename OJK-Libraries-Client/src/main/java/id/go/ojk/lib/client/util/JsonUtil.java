package id.go.ojk.lib.client.util;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtil {

	public static String toJson(Object obj, boolean compact) {
		GsonBuilder builder = new GsonBuilder();
		if (!compact) {
			builder.setPrettyPrinting();
		}
		return obj != null ? builder.create().toJson(obj) : "";
	}
	
	@SuppressWarnings("unchecked")
	public static <R> R fromJson(String json, Class<?> clazz) {
		if (StringUtils.isEmpty(json)) {
			return null;
		}
		Gson gson = new Gson();
		return (R) gson.fromJson(json, clazz);
	}
}
