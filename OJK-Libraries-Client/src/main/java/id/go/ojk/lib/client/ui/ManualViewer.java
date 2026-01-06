package id.go.ojk.lib.client.ui;

import java.util.Properties;
import java.util.ResourceBundle;

import org.icepdf.ri.util.PropertiesManager;

import id.go.ojk.lib.client.util.pdf.WindowManager;

public class ManualViewer implements WindowLauncher {

	private PropertiesManager icePdfPropertiesManager;
	private ResourceBundle icePdfMessageBundle;
	private WindowManager icePdfwindowManager;

	public ManualViewer(){
	}

	public void showHelpDialog() {

		if ( icePdfPropertiesManager == null ){
			String contentProperties = null;
			icePdfMessageBundle = ResourceBundle.getBundle("IcePdfMessageBundle");
	        Properties sysProps = System.getProperties();
	        sysProps.put("org.icepdf.core.verbose", "false");
	        icePdfPropertiesManager = new PropertiesManager(sysProps, contentProperties, icePdfMessageBundle);
	        icePdfPropertiesManager.set(PropertiesManager.PROPERTY_VIEWPREF_HIDEMENUBAR, "true");
	        icePdfPropertiesManager.set(PropertiesManager.PROPERTY_SHOW_UTILITY_OPEN, "false");
	        icePdfwindowManager = WindowManager.createInstance(icePdfPropertiesManager, icePdfMessageBundle);
		}

        String contentFile = "resources/help/manual.pdf";
        icePdfwindowManager.newWindow(contentFile);
	}

	@Override
	public void showWindow() {
		showHelpDialog();
	}

}
