package id.go.ojk.lib.client;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
//		System.out.println(new String(readContentIntoByteArray(new File("D:/0101.167.20170530152034873/rsaPrivateKey/b64private.key"))));
		try {
			System.out.println("start...");
			ExecutorService executor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
	                new LinkedBlockingQueue<Runnable>(1));
//			boolean res = fileExist();
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(((ThreadPoolExecutor) executor).getActiveCount());
		} finally {
			System.out.println("end...");
		}
		assertTrue(true);
	}

	private byte[] readContentIntoByteArray(File file) {
		FileInputStream fileInputStream = null;
		byte[] bFile = new byte[(int) file.length()];
		try {
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bFile;
	}
	
	private boolean fileExist() {
		boolean res = false;
		String filename = "D:\\cronos-bag.log";
		File file = new File(filename);
		long start = System.currentTimeMillis();
		while ((System.currentTimeMillis() - start < 10000) && !res) {
			res = file.exists();
			try {
				Thread.sleep(1000);
				System.out.println("retry...");
			} catch (Exception e) {
			}
		}
		System.out.println("res = " + res);
		return res;
	}
}
