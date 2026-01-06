package id.go.ojk.client;

import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.module.bpjs.EReportGroupBpjs;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.client.vc.HomeMetroBpjsController;
import id.go.ojk.client.vc.PreparationAndSendingBpjsController;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import javafx.scene.layout.BorderPane;

public class FormBpjsTkBase<C extends HomeMetroBpjsController> extends BaseCustomForm {
  private Tupple2<BorderPane, C> homeController;
  private Tupple2<BorderPane, PreparationAndSendingBpjsController> preparationController;
  private String fxmlHomeFile;

  protected FormBpjsTkBase(ApplicationContext appContext, MainApplication mainApplication, String fxmlHomeFile) {
    super(appContext, mainApplication);
    this.fxmlHomeFile = fxmlHomeFile;
  }

  @Override
  void init() {
  }

  public void initHome() {
    homeController = UtilForm.initAndShowPane(mainApplication, fxmlHomeFile, homeController, null, null, null);
  }

  public Tupple2<BorderPane, ? extends HomeMetroBpjsController> getHome() {
    if (homeController == null) {
      initHome();
    }
    return homeController;
  }

  public void dispose() {
    if (homeController != null) {
      homeController.getB().logout();
      homeController = null;
    }
  }

  public void showForm(DisplayScene scene) {
    int menuCode = EReportGroupBpjs.getReportGroupByScene(scene).getMenuCode();
    preparationController = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingBpjs.fxml",
        preparationController, scene, null, null);
    preparationController.getB().setServiceAndBind(
        appContext.getService(ClientConstant.SUBMISSIION_SERVICE_BPJS, SubmissionService.class),
        ConfigService.submissionSourceDir, menuCode);
    preparationController.getB().reset();
  }

  public void ensureVisibleScrollPane(ProgressSegment progressSegment) {
    if (preparationController != null) {
      preparationController.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
    }
  }
}
