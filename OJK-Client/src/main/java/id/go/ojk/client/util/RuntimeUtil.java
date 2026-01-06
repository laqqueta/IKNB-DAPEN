package id.go.ojk.client.util;

import id.go.ojk.client.ClientProperties;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class RuntimeUtil {
	public static int getNumberOfThread(){
		int result = ClientProperties.getInstance().getValueAsInt(ClientProperties.MAX_THREAD, 0);
		if (result <= 0) {
			result = Runtime.getRuntime().availableProcessors() - 1;
		}
		result = result < 1 ? 1 : result;
		log.info("Number of thread={}", result);
		return result;
	}
}
