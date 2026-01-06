package id.go.ojk.client.model.config;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import id.go.ojk.lib.client.model.config.SlikClientCfg;


public class SlikClientCfgTest {

	@Test
	public void test1From() throws IOException{
		System.out.println(new File(".").getAbsolutePath());
		SlikClientCfg slikClientCfg = SlikClientCfg.newInstance(new File("src/test/resources/BprkClient.cfg"));
		assertEquals("SlikClient", slikClientCfg.getAppName());
		assertEquals("OJK-ASRJ-Client-Launcher.jar", slikClientCfg.getAppMainjar());
		assertEquals("1.0", slikClientCfg.getAppVersion());
		assertEquals("fxApplication", slikClientCfg.getAppPreferencesId());
		assertEquals("id/go/ojk/bprk/client/launcher/BprkClientMain", slikClientCfg.getAppMainclass());
		assertEquals("OJK-ASRJ-Client-Launcher.jar;libs/OJK-ASRJ-Client-0.0.1-SNAPSHOT.jar;libs/OJK-BPRK-Libraries-Client-0.0.1-SNAPSHOT.jar;libs/commons-compress-1.10.jar;libs/commons-io-2.4.jar;libs/commons-lang3-3.4.jar;libs/commons-logging-1.2.jar;libs/commons-net-3.4.jar;libs/guava-19.0.jar;libs/hamcrest-core-1.3.jar;libs/httpclient-4.5.2.jar;libs/httpcore-4.4.4.jar;libs/icepdf-batik-awt-util.jar;libs/icepdf-batik-dom.jar;libs/icepdf-batik-svg-dom.jar;libs/icepdf-batik-svggen.jar;libs/icepdf-batik-util.jar;libs/icepdf-batik-xml.jar;libs/icepdf-bcpkix-jdk15on.jar;libs/icepdf-bcprov-ext-jdk15on.jar;libs/icepdf-bcprov-jdk15on.jar;libs/icepdf-core.jar;libs/icepdf-viewer.jar;libs/jackson-annotations-2.7.0.jar;libs/jackson-core-2.7.1.jar;libs/jackson-databind-2.7.1.jar;libs/junit-4.12.jar;libs/logback-classic-1.1.6.jar;libs/logback-core-1.1.6.jar;libs/lombok.jar;libs/slf4j-api-1.7.19.jar;libs/xstream-1.4.9.jar;libs/xz-1.5.jar;resources/help/faq2/index.html;resources/help/faq2/jquery-ui.css;resources/help/faq2/jquery-ui.js;resources/help/faq2/jquery.js;resources/slik-client.properties", slikClientCfg.getAppClasspath());
		assertEquals("$APPDIR\\runtime", slikClientCfg.getAppRuntime());
		assertEquals("fxApplication", slikClientCfg.getAppIdentifier());
		
		assertEquals(1024, slikClientCfg.getXms());
		assertEquals(12240, slikClientCfg.getXmx());
		
		assertEquals("123456", slikClientCfg.getArgOptions());
		
		slikClientCfg.store(new File( slikClientCfg.getFile().getAbsolutePath() + ".test" ));
	}

}
