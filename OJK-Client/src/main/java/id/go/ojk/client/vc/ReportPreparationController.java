package id.go.ojk.client.vc;

import id.go.ojk.client.MainApplication;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class ReportPreparationController extends BaseDialogController {

    @FXML
    private BorderPane borderPane;    

	private MainApplication mainApplication;
    
	@FXML
	protected void initialize() {
		super.initialize();		

		mainApplication = appCtx.getService(MainApplication.class);
	}

    @FXML
    private void handleNo() {
		mainApplication.getCustomForm().getFormRbb().showPelaporanData();
		mainApplication.synchMenuToRealDisplay();
		stage.close();
    }

    @FXML
    private void handleYes() {
    	mainApplication.getCustomForm().getFormRbb().showPelaporanData();
		mainApplication.synchMenuToRealDisplay();
		stage.close();
    }
	
	@Override
	public void reset(){
	}
	
	@Override
	public boolean isReused(){
		return false;
	}

}
