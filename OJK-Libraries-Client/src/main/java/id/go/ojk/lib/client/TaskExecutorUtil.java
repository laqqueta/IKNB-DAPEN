package id.go.ojk.lib.client;

import java.util.concurrent.ThreadPoolExecutor;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class TaskExecutorUtil {
	
	public static boolean isQueueFull(ThreadPoolExecutor executor) {
		int queueSize = executor.getQueue().size();
		int maxQueueSize = 50 * executor.getMaximumPoolSize();
		boolean res = queueSize >= maxQueueSize/* && activeThread == executor.getMaximumPoolSize()*/;
		if (res) {
			log.warn("Queue is full (queue={})!!!", queueSize);
		}
		return res;
	}
	
	public static boolean isThreadBusy(ThreadPoolExecutor executor) {
		int activeThread = executor.getActiveCount();
		boolean res = activeThread == executor.getMaximumPoolSize();
		if (res) {
			log.warn("Executor is busy (thread={})!!!", activeThread);
		}
		return res;
	}

	public static int waitAllTaskFinish(ThreadPoolExecutor executor) {
		log.trace("Wait all task finish...");
		while (executor.getActiveCount() > 0 || !executor.getQueue().isEmpty()) {
			ThreadUtil.sleep(50);
		}
		return executor.getActiveCount();
	}

	public static int waitAllTaskFinish(ThreadPoolExecutor executor, int maxCounter) {
		log.trace("Wait all task finish...");
		for (int i = 0; i < maxCounter; i++) {
			if (i == 0)
				ThreadUtil.sleep(100);
			int active = executor.getActiveCount();
			if (active == 0) {
				break;
			} else {
				if (i % 30 == 0) {
					log.info("active executor {}", active);
				}
			}
			ThreadUtil.sleep(1000);
		}
		return executor.getActiveCount();
	}
}
