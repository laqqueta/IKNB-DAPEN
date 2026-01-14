package id.go.ojk.client.vc;

import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class HomeMetroBpjsControllerLBBPTK extends HomeMetroBpjsController {
  @FXML
  private Button btnBDN;
  @FXML
  private ImageView imageBDN;
  @FXML
  private Button btnJKK;
  @FXML
  private ImageView imageJKK;
  @FXML
  private Button btnJK;
  @FXML
  private ImageView imageJK;
  @FXML
  private Button btnJHT;
  @FXML
  private ImageView imageJHT;
  @FXML
  private Button btnJKP;
  @FXML
  private ImageView imageJKP;
  @FXML
  private Button btnJP;
  @FXML
  private ImageView imageJP;

  @Override
  protected List<Button> getCustomButtons() {
    return Arrays.asList(btnBDN, btnJKK, btnJK, btnJHT, btnJKP, btnJP);
  }

  @Override
  protected List<ImageView> getCustomButtonImages() {
    return Arrays.asList(imageBDN, imageJKK, imageJK, imageJHT, imageJKP, imageJP);
  }
}
