package id.go.ojk.client.vc;

import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class HomeMetroBpjsControllerLBBPKS extends HomeMetroBpjsController {
  @FXML
  private Button btnLK;
  @FXML
  private ImageView imageLK;
  @FXML
  private Button btnDJS;
  @FXML
  private ImageView imageDJS;
  @FXML
  private Button btnLPP;
  @FXML
  private ImageView imageLPP;

  @Override
  protected List<Button> getCustomButtons() {
    return Arrays.asList(btnLK, btnDJS, btnLPP);
  }

  @Override
  protected List<ImageView> getCustomButtonImages() {
    return Arrays.asList(imageLK, imageDJS, imageLPP);
  }

  @FXML
  public void handleLBBPKSLK() {
    mainApplication.getCustomForm().getFormBpjsKs().showLBBPKSLK();
    mainApplication.synchMenuToRealDisplay();
  }

  @FXML
  public void handleLBBPKSDJS() {
    mainApplication.getCustomForm().getFormBpjsKs().showLBBPKSDJS();
    mainApplication.synchMenuToRealDisplay();
  }

  @FXML
  public void handleLBBPKSLPP() {
    mainApplication.getCustomForm().getFormBpjsKs().showLBBPKSLPP();
    mainApplication.synchMenuToRealDisplay();
  }
}
