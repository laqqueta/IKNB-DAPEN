package id.go.ojk.client.vc;

import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.lib.client.model.config.ConfigString;
import id.go.ojk.lib.client.vc.object.ReportValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.util.StringConverter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PreparationAndSendingLktbController extends BasePreparationAndSendingController {
    @FXML
    RadioButton rutinRadio;
    @FXML
    RadioButton koreksiRadio;

    @FXML
    ComboBox<ReportValue> cbxReport = new ComboBox<>();

    @FXML
    ToggleGroup reportGroup;
    @FXML
    HBox boxReport;

    private static Map<Integer, String> mapReport = new HashMap<>();

    static {
        String[] listReport = {
                "PPMP Murni",
                "PPMP Kompleks",
                "PPIP Murni",
                "PPIP Kompleks",
                "PPMP PPIP Kompleks",
        };
        for (int i = 0; i < listReport.length; i++) {
            mapReport.put(i + 1, listReport[i]);
        }
    }

    @Override
    protected void initialize() {
        super.initialize();

        ObservableList<ReportValue> reportValue = FXCollections.observableArrayList();
        reportValue.add(new ReportValue("0", "Pilih Laporan :"));
        for (Map.Entry<Integer, String> entry : mapReport.entrySet()) {
            reportValue.add(new ReportValue(entry.getKey().toString(), entry.getValue()));

        }

        cbxReport.setItems(reportValue);

        cbxReport.setConverter(new StringConverter<ReportValue>() {

            @Override
            public String toString(ReportValue object) {
                return object.nameProperty().get();
            }

            @Override
            public ReportValue fromString(String id) {
                return null;
            }
        });

        cbxReport.getSelectionModel().select(0);
    }

    @Override
    public void setServiceAndBind(SubmissionService submissionService, ConfigString submissionSourceDir,
                                  int reportFormGroupCode) {
        super.setServiceAndBind(submissionService, submissionSourceDir, reportFormGroupCode);
    }

    @Override
    protected int getReportFormGroupCode() {
        int res = reportFormGroupCode;

        switch (res) {
            case 1:
            case 2:
                res = 1;
                if (koreksiRadio.isSelected())
                    res = 2;
                break;
            case 3:
            case 4:
                res = 3;
                if (koreksiRadio.isSelected())
                    res = 4;
                break;
            case 5:
            case 6:
                res = 5;
                if (koreksiRadio.isSelected())
                    res = 6;
                break;
        }

        return res;
    }
}
