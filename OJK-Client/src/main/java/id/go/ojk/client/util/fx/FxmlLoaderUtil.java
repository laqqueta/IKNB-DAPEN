package id.go.ojk.client.util.fx;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.undecorator.UndecoratorScene;
import id.go.ojk.client.vc.BaseController;
import id.go.ojk.client.vc.BaseDialogController;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.Tupple3;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FxmlLoaderUtil {

	private static Logger logger = LoggerFactory.getLogger(FxmlLoaderUtil.class);

	public static  <R extends Region, C extends BaseController> Tupple2<R, C> loadFxml(String fxmlFile) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxmlFile));
		R region = fxmlLoader.load();
		C controller = fxmlLoader.getController();
		return Tupple2.<R, C>builder()
			.a(region)
			.b(controller)
			.build();
	}

	public static  <R extends Region, C extends BaseDialogController> Tupple3<R, C, Stage> createDialog(
			Stage primaryStage,
			String fxmlFile,
			String title,
			StageStyle stageStyle,
			Modality modality,
			boolean show, boolean plain ) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxmlFile));
		R region = fxmlLoader.load();
		C controller = fxmlLoader.getController();
		Stage stage = createDialog(primaryStage, region, title, stageStyle, modality, show, plain);

		return Tupple3.<R, C, Stage>builder()
			.a(region)
			.b(controller)
			.c(stage)
			.build();
	}

	public static Stage createDialog(Stage primaryStage, Region rootRegion, String title, StageStyle stageStyle, Modality modality, boolean show) {
		return createDialog(primaryStage, rootRegion, title, stageStyle, modality, show, false);
	}

	public static Stage createDialog(Stage primaryStage, Region rootRegion, String title, StageStyle stageStyle, Modality modality, boolean show, boolean plain) {
		Stage utilityStage = new Stage();
		if ( plain )
			utilityStage.setResizable(false);
		utilityStage.setTitle(title);
		UndecoratorScene scene = new UndecoratorScene(utilityStage, stageStyle, rootRegion, plain ? UndecoratorScene.DEFAULT_STAGEDECORATION_UTILITY_PLAIN : null);
		// Overrides defaults
		scene.addStylesheet(MainApplication.class.getResource("vc/ojk.css").toExternalForm());

		utilityStage.setScene(scene);
		utilityStage.initModality(modality);
		if ( modality != Modality.NONE )
			utilityStage.initOwner(primaryStage);

		if ( show )
			utilityStage.show();

//		utilityStage.setMinHeight(primaryStage.getMinHeight());
//		utilityStage.setMinWidth(primaryStage.getMinWidth());

		return utilityStage;
	}

	public static interface AfterInitFxml<R extends Region, C extends BaseController>{
		void init(Tupple2<R, C> ui);
	}

	public static interface BeforeReShow<R extends Region, C extends BaseController>{
		void beforeReShow(Tupple2<R, C> ui);
	}
	
	public static interface AfterInitDialog<R extends Region, C extends BaseController, Stage>{
		void init(Tupple3<R, C, Stage> dialogUi);
	}


}
