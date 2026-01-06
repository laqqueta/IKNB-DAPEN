package id.go.ojk.client.util;

import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.service.ReferenceService;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class AlertUtil {
	
	private static Logger logger = LoggerFactory.getLogger(AlertUtil.class);
	
	private static String alertErrorDefTitle 		= "Kesalahan";
	private static String alertErrorDefHeader 		= "Kesalahan";
	
	private static String alertInfoDefTitle 		= "Informasi";
	private static String alertInfoDefHeader 		= "Informasi";

	private static String alertWarnDefTitle 		= "Peringatan";
	private static String alertWarnDefHeader 		= "Peringatan";

	private static String alertConfDefTitle 		= "Konfirmasi";
	private static String alertConfDefHeader 		= "Konfirmasi";
	
	public static void initMessage(ReferenceService referenceService){
		try {
			alertErrorDefTitle = referenceService.getMessage(ReferenceService.messageConfig_err_title);
			alertErrorDefHeader = referenceService.getMessage(ReferenceService.messageConfig_err_header);

			alertInfoDefTitle = referenceService.getMessage(ReferenceService.messageConfig_info_title);
			alertInfoDefHeader = referenceService.getMessage(ReferenceService.messageConfig_info_header);

			alertWarnDefTitle = referenceService.getMessage(ReferenceService.messageConfig_warn_title);
			alertWarnDefHeader = referenceService.getMessage(ReferenceService.messageConfig_warn_header);

			alertConfDefTitle = referenceService.getMessage(ReferenceService.messageConfig_confirm_title);
			alertConfDefHeader = referenceService.getMessage(ReferenceService.messageConfig_confirm_header);	
		} catch (Throwable t){
			logger.error("initMessage", t);
		}
	}

	public static boolean showAlertError(String title, String header, List<String> errors){
		if ( errors.size() == 0 )
			return true;
		
		if (title == null){
			title = alertErrorDefTitle;
		}
		if (header == null){
			header = alertErrorDefHeader;
		}
		
		String content = errors.stream().collect(Collectors.joining("\n- ", "- ", ""));
		showAlert(AlertType.ERROR, title, header, content);
		return false;
	}

	public static void showAlert(AlertType alertType, String title, String header, String content){
		
		if ( AlertType.ERROR == alertType ){
			if (title == null){
				title = alertErrorDefTitle;
			}
			if (header == null){
				header = alertErrorDefHeader;
			}
		} else if ( AlertType.INFORMATION == alertType ){
			if (title == null){
				title = alertInfoDefTitle;
			}
			if (header == null){
				header = alertInfoDefHeader;
			}			
		}

		
		Alert alert = new Alert(alertType);

		if(title != null)
			alert.setTitle(title);

		if (header != null)
			alert.setHeaderText(header);

		if ( content != null )
			alert.setContentText(content);

		alert.showAndWait();
	}

	public static void showAlert(AlertType alertType, String title, String content){
		ButtonType oke = new ButtonType("Oke", ButtonBar.ButtonData.OK_DONE);
		Alert alert = new Alert(alertType,"",oke);

		if ( AlertType.ERROR == alertType ){
			if (title == null){
				title = alertErrorDefTitle;
			}
		} else if ( AlertType.INFORMATION == alertType ){
			if (title == null){
				title = alertInfoDefTitle;
			}
		}
		
		if( title != null )
			alert.setTitle(title);
		
		if ( AlertType.ERROR == alertType ) {
			alert.setHeaderText(alertErrorDefHeader);			
		} else if ( AlertType.INFORMATION == alertType ){
			alert.setHeaderText(alertInfoDefHeader);
		}

		if ( content != null )
			alert.setContentText(content);

		alert.showAndWait();
	}

	public static boolean confirmDialog(String title, String header, String content){
		ButtonType ya = new ButtonType("Ya", ButtonBar.ButtonData.OK_DONE);
		ButtonType tidak = new ButtonType("Tidak", ButtonBar.ButtonData.CANCEL_CLOSE);
		
		Alert alert = new Alert(AlertType.CONFIRMATION, "", ya, tidak);
		
		if (title == null){
			title = alertConfDefTitle;
		}
		if (header == null){
			header = alertConfDefHeader;
		}
		
		if(title != null)
			alert.setTitle(title);

		if (header != null)
			alert.setHeaderText(header);

		if ( content != null )
			alert.setContentText(content);

		Optional<ButtonType> result = alert.showAndWait();
		return result.get() == ya;
	}

	public static void showAlertSafe(AlertType alertType, String title, String headerText, String message) {
		if ( AlertType.ERROR == alertType ){
			if (title == null){
				title = alertErrorDefTitle;
			}
			if (headerText == null){
				headerText = alertErrorDefHeader;
			}
		} else if ( AlertType.INFORMATION == alertType ){
			if (title == null){
				title = alertInfoDefTitle;
			}
			if (headerText == null){
				headerText = alertInfoDefHeader;
			}			
		} else if ( AlertType.WARNING == alertType ){
			if (title == null){
				title = alertWarnDefTitle;
			}
			if (headerText == null){
				headerText = alertWarnDefHeader;
			}			
		}
		
		final String titleFinal = title; 
		final String headerTextFinal = headerText;
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	showAlert(alertType, titleFinal, headerTextFinal, message);
		    }
		});
	}

	public static void showErrorSafe(String message, String detailError) {
		
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	showError(message, detailError);
		    }
		});
	}

	public static void showErrorSafe(Logger logger, String message, Throwable t) {
		String msg = message == null ? t.getMessage() : message;
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	showError(logger, msg, t);
		    }
		});
	}

	public static void showError(Logger logger, String message, Throwable t) {
		if ( logger != null ){
			String msg = message == null ? t.getMessage() : message;
			logger.error(msg, t);
		}
		
		String exceptionText = null;
		if ( t != null ){
			if ( t instanceof ConnectException){
				exceptionText = "Koneksi ke server gagal!";
			} else if ( t instanceof FileNotFoundException){
				exceptionText = "File tidak ditemukan!";
			} else {
				exceptionText = t.getMessage();
			}			
		}
		
		showError(message, exceptionText);
	}

	public static void showError(String message) {
		Alert alert = new Alert(AlertType.ERROR);

		alert.setTitle(alertErrorDefTitle);
		alert.setHeaderText(alertErrorDefHeader);
		
		alert.setContentText(message);

		alert.showAndWait();
		
	}

    public static void showError(String message, String detailError) {
        Alert alert = new Alert(AlertType.ERROR);

        alert.setTitle(alertErrorDefTitle);
        alert.setHeaderText(alertErrorDefHeader);

		if (StringUtils.isNotEmpty(detailError)){
			message += "\n" + detailError;
		}

        alert.setContentText(message);

        alert.showAndWait();

    }

}
