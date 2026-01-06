package id.go.ojk.lib.client;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class ThreadUtil {
	public static void sleep(long millis){
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			Thread.currentThread().interrupt();
		}
	}
}
