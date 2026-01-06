package id.go.ojk.client.vc;

import java.io.File;
import java.io.IOException;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.io.FileUtils;

import id.go.ojk.lib.client.CompressionUtil;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class FAQController extends BaseDialogController {

	@FXML private WebView webView;

	@FXML
	protected void initialize() {
		super.initialize();
		try {
			WebEngine webEngine = webView.getEngine();
			
			File zipFile = new File("resources/help/faq.zip");
			if ( zipFile.exists() ){
				File faqDir = new File("resources/help/faq");
				FileUtils.deleteDirectory(faqDir);
				CompressionUtil.decompress(zipFile, faqDir);
				FileUtils.forceDelete(zipFile);
			}
			
			File indexFile = new File("resources/help/faq/index.html");
			String url = indexFile.toURI().toURL().toString();
			webEngine.load(url);
		} catch (IOException | ArchiveException e) {
			logger.error("", e);
		} 
	}
	
	@Override
	public void reset(){
	}
	
	@Override
	public boolean isReused(){
		return true;
	}

}
