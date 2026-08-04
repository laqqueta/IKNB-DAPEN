package id.go.ojk.client.vc;

import id.go.ojk.client.module.lktb.EReportGroupLktb;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.client.util.states.JenisProgramState;
import id.go.ojk.lib.client.model.config.ConfigString;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.vc.object.ReportValue;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.util.StringConverter;

import java.util.HashMap;
import java.util.Map;

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

    private static final Map<String, String> mapReport = new HashMap<>();

    static {
        mapReport.put("PPMP-M", "PPMP Murni");
        mapReport.put("PPMP-K", "PPMP Kompleks");
        mapReport.put("PPIP-M", "PPIP Murni");
        mapReport.put("PPIP-K", "PPIP Kompleks");
        mapReport.put("PPMP PPIP K", "PPMP PPIP Kompleks");
    }

    private String reportCode = "";

    @Override
    protected void initialize() {
        super.initialize();

        // make sure this block run, hence its inside synchronized block
        synchronized (this) {
            reportCode = super.getSecurityService()
                    .getUserSession()
                    .getReportCode();

            if (reportCode.equalsIgnoreCase("LKDLK") || reportCode.equalsIgnoreCase("LKDLS")) {
                cbxReport.setDisable(true);
                cbxReport.setVisible(false);
                JenisProgramState.selectedValue = "DPLK";
                JenisProgramState.selectedKey = "DPLK";
                JenisProgramState.program = "DPLK";

                return;
            }
        }

        ObservableList<ReportValue> reportValue = FXCollections.observableArrayList();
        reportValue.add(new ReportValue("0", "Pilih Jenis Program :"));
        for (Map.Entry<String, String> entry : mapReport.entrySet()) {
            reportValue.add(new ReportValue(entry.getKey(), entry.getValue()));

        }

        cbxReport.setItems(reportValue);
        cbxReport.getSelectionModel().select(0);
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

        cbxReport.setOnAction(actionEvent -> {
            ReportValue selected = cbxReport.getSelectionModel()
                    .getSelectedItem();

            JenisProgramState.selectedValue = selected.nameProperty().getValue();
            JenisProgramState.selectedKey = selected.idProperty().getValue();
            JenisProgramState.validationState.setValue(true);

            if (JenisProgramState.selectedKey.equalsIgnoreCase("PPMP-K") || JenisProgramState.selectedKey.equalsIgnoreCase("PPMP-M")) {
                JenisProgramState.program = "PPMP";
            } else if (JenisProgramState.selectedKey.equalsIgnoreCase("PPIP-K") || JenisProgramState.selectedKey.equalsIgnoreCase("PPIP-M")) {
                JenisProgramState.program = "PPIP";
            } else if (JenisProgramState.selectedKey.equalsIgnoreCase("DPLK")) {
                JenisProgramState.program = "DPLK";
            } else {
                JenisProgramState.program = "PPMPPPIPK";
            }
        });

        JenisProgramState.validationState.addListener(e -> {
            Platform.runLater(() -> {
                if (!JenisProgramState.validationState.getValue()) {
                    cbxReport.requestFocus();
                }
            });
        });
    }

    @Override
    @FXML
    protected void handleOpen() {
        if (reportCode.equalsIgnoreCase("LKDLK") || reportCode.equalsIgnoreCase("LKDLS")) {
            handleOpenDplk();
            return;
        }

        handleOpenDppk();
    }

    protected void handleOpenDppk() {
        ReportValue selected = cbxReport.getSelectionModel()
                .getSelectedItem();

        if (!mapReport.containsKey(selected.idProperty().getValue())) {
            AlertUtil.showAlert(Alert.AlertType.ERROR, "Kesalahan", "Kesalahan", "Jenis Program belum dipilih.");
            cbxReport.requestFocus();
            return;
        }

        super.handleOpen();
    }

    protected void handleOpenDplk() {
        super.handleOpen();
    }

    @Override
    public void setServiceAndBind(SubmissionService submissionService, ConfigString submissionSourceDir,
                                  int reportFormGroupCode) {
        super.setServiceAndBind(submissionService, submissionSourceDir, reportFormGroupCode);
    }

    private int getMenuCode() {
        int baseMenuCode = 100;

        String reportCode = this.appCtx.getService(SecurityService.class)
                .getUserSession()
                .getReportCode();

        if (reportCode.equalsIgnoreCase("LKDPK")) {
            baseMenuCode += 10;
        } else if (reportCode.equalsIgnoreCase("LKDPS")) {
            baseMenuCode += 20;
        } else if (reportCode.equalsIgnoreCase("LKDLK")) {
            baseMenuCode += 30;
        } else if (reportCode.equalsIgnoreCase("LKDLS")) {
            baseMenuCode += 40;
        }

        return baseMenuCode;
    }


    @Override
    protected int getReportFormGroupCode() {
        int res = reportFormGroupCode;
        int menuCode = getMenuCode();

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
        }

        res += menuCode;

        return res;
    }
}
