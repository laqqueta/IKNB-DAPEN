package id.go.ojk.client.vc;

import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class PreparationAndSendingBpjsController extends BasePreparationAndSendingController {
  @FXML
  RadioButton rutinRadio;
  @FXML
  RadioButton koreksiRadio;
  @FXML
  RadioButton koreksiPengawasRadio;
  @FXML
  ToggleGroup reportGroup;
  @FXML
  HBox boxReport;

  private static final Map<Integer, Integer> koreksiMap = new HashMap<>();
  private static final Map<Integer, Integer> koreksiPengawasMap = new HashMap<>();

  static {
    int start = 1;
    int increment = 3;
    int end = 73; // akhir lap rutin di EReportGroupBpjs

    for (int key = start; key <= end; key += increment) {
      koreksiMap.put(key, key + 1);
      koreksiPengawasMap.put(key, key + 2);
    }
  }

  @Override
  protected int getReportFormGroupCode() {
    if (koreksiRadio.isSelected()) {
      return koreksiMap.getOrDefault(reportFormGroupCode, reportFormGroupCode);
    } else if (koreksiPengawasRadio.isSelected()) {
      return koreksiPengawasMap.getOrDefault(reportFormGroupCode, reportFormGroupCode);
    }
    return reportFormGroupCode;
  }
}
