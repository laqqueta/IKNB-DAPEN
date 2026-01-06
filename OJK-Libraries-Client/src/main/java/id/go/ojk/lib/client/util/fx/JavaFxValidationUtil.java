package id.go.ojk.lib.client.util.fx;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.model.KeyValue;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class JavaFxValidationUtil {

	public static boolean validateRequired(List<String> errors, KeyValue<String, TextField> ... textFields){
		boolean result = true;
		for (KeyValue<String, TextField> keyValue : textFields) {
			if ( StringUtils.isEmpty(keyValue.getValue().getText())  ){
				errors.add("Field " + keyValue.getKey() + " harus diisi!");
				result = false;
			}
		}
		return result;
	}

	public static boolean validateRequired(List<String> errors, List<KeyValue<String, TextField>> textFields){
		boolean result = true;
		for (KeyValue<String, TextField> keyValue : textFields) {
			if ( StringUtils.isEmpty(keyValue.getValue().getText())  ){
				errors.add("Field " + keyValue.getKey() + " harus diisi!");
				result = false;
			}
		}
		return result;
	}

	public static void addMaxLengthListener(TextField textField, int maxLength){		
		textField.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textField.getText().length() >= maxLength) {
						textField.setText(textField.getText().substring(0, maxLength));
					}
				}				
			}
		});
	}

}
