package id.go.ojk.lib.client.util.fx;

import id.go.ojk.lib.client.model.bind.ProgressModel;
import id.go.ojk.lib.client.model.bind.StatusCallback;
import javafx.application.Platform;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;

public class ProgressUtil {

	public static void bindProgressModel(ProgressModel progressModel, Pane statusPane, Label progressLabel, ProgressBar progressBar, Hyperlink dirHyperlink){
		progressBar.progressProperty().bindBidirectional(progressModel.progressBarProperty());
		progressLabel.textProperty().bindBidirectional(progressModel.progressLabelProperty());
		if ( dirHyperlink != null ) {
			dirHyperlink.visibleProperty().bind(progressModel.showDirProperty());
		}
		if ( statusPane != null ){
			progressModel.setStatusCallback(e -> ProgressUtil.updateStatusPane(statusPane, e));					
		}
	}

	public static void updateStatusPane(Pane pane, int status){
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	String newStyle = "-fx-background-color: rgb(255,166,2)";
		    	switch (status) {
				case StatusCallback.disable:
					newStyle = "-fx-background-color: grey";
					break;
				case StatusCallback.start:
					newStyle = "-fx-background-color: rgb(255,166,2)";
					break;
				case StatusCallback.success:
					newStyle = "-fx-background-color: rgb(116,195,18)";
					break;
				case StatusCallback.error:
					newStyle = "-fx-background-color: red";
					break;
				default:
					newStyle = "-fx-background-color: rgb(255,166,2)";
					break;
				}
		    	pane.setStyle(newStyle);
		    }
		});
	}

}
