package id.go.ojk.client.vc;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.MainApplication.InitCompletionHandler;
import javafx.animation.FadeTransition;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class SplashScreenController extends BaseController {

	private static final int SPLASH_WIDTH = 480; //860
	private static final int SPLASH_HEIGHT = 337; //315

	@FXML private VBox parentPane;
	@FXML private Label progressLabel;
	@FXML private ProgressIndicator progressIndicator;
	
	@FXML
	public void initialize() {
		progressIndicator.setProgress(0d);
	}
	
    public void showSplash(
            final Stage initStage,
            Task<?> task,
            InitCompletionHandler initCompletionHandler
    ) {
    	Image image = new Image(MainApplication.class.getResourceAsStream(MainApplication.APPLICATION_ICON));
        initStage.getIcons().addAll(image);

        progressLabel.textProperty().bind(task.messageProperty());
        progressIndicator.progressProperty().bind(task.progressProperty());
        task.stateProperty().addListener((observableValue, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
            	progressIndicator.progressProperty().unbind();
                progressIndicator.setProgress(1);
                initStage.toFront();
                FadeTransition fadeSplash = new FadeTransition(Duration.seconds(1.2), parentPane);
                fadeSplash.setFromValue(1.0);
                fadeSplash.setToValue(0.0);
                fadeSplash.setOnFinished(actionEvent -> initStage.hide());
                fadeSplash.play();

                initCompletionHandler.complete();
            } // todo add code to gracefully handle other task states.
        });

        Scene splashScene = new Scene(parentPane);
        splashScene.getStylesheets().add(MainApplication.class.getResource("vc/ojk.css").toExternalForm());

        initStage.initStyle(StageStyle.UNDECORATED);
        final Rectangle2D bounds = Screen.getPrimary().getBounds();
        initStage.setScene(splashScene);
        initStage.setX(bounds.getMinX() + bounds.getWidth() / 2 - SPLASH_WIDTH / 2);
        initStage.setY(bounds.getMinY() + bounds.getHeight() / 2 - SPLASH_HEIGHT / 2);
        initStage.show();
    }
    
    @FXML
    private void handleClose(){
    	System.exit(-1);
    }

}
