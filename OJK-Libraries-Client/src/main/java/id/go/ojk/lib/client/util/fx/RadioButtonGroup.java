package id.go.ojk.lib.client.util.fx;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.model.KeyValueString;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class RadioButtonGroup {

	private List<RadioButton> radioButtons;

	public RadioButtonGroup(VBox vbox, String toggleGroupName, List<KeyValueString> idNames ){
		radioButtons = new ArrayList<>();
		ToggleGroup toggleGroup = new ToggleGroup();
		for (KeyValueString keyValueString : idNames) {
			RadioButton radioButton = new RadioButton(keyValueString.getValue());
			radioButton.setId(keyValueString.getKey());
			radioButton.setToggleGroup(toggleGroup);
			radioButtons.add(radioButton);
		}
		vbox.getChildren().addAll(radioButtons);
	}

	public RadioButtonGroup(VBox vbox, String toggleGroupName, KeyValueString ... idNames ){
		radioButtons = new ArrayList<>();
		for (KeyValueString keyValueString : idNames) {
			RadioButton radioButton = new RadioButton(keyValueString.getValue());
			radioButton.setId(keyValueString.getKey());
			radioButtons.add(radioButton);
		}
	}

	public RadioButtonGroup(Scene parentScene, String ... radioIds ){
		radioButtons = new ArrayList<>();
		for (int i=0; i< radioIds.length; i++) {
			radioButtons.add((RadioButton) parentScene.lookup("#" + radioIds[i]));
		}
	}

	public RadioButtonGroup(List<RadioButton> radioButtons){
		this.radioButtons = radioButtons;
	}

	public void setSelected(String controlId){
		for (RadioButton radioButton : radioButtons) {
			if( StringUtils.equals(controlId, radioButton.getId())  ){
				radioButton.setSelected(true);
			} else {
				radioButton.setSelected(false);
			}
		}
	}

	public void setSelected(RadioButton selectedRadioButton){
		for (RadioButton radioButton : radioButtons) {
			if( selectedRadioButton == radioButton ){
				radioButton.setSelected(true);
			} else {
				radioButton.setSelected(false);
			}
		}
	}

	public RadioButton getSelected(){
		for (RadioButton radioButton : radioButtons) {
			if( radioButton.isSelected() ){
				return radioButton;
			}
		}
		return null;
	}

	public String getSelectedId(){
		RadioButton selected = getSelected();
		return selected == null ? null : selected.getId();
	}
	
	public RadioButton getInternetRadioButton(){
		return radioButtons.get(0);
	}

}
