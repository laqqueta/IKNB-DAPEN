package id.go.ojk.client.vc;

import id.go.ojk.client.service.ApplicationUpdateService;
import id.go.ojk.lib.client.model.bind.VersionModel;
import id.go.ojk.lib.client.model.constant.OjkClientConstant;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AboutController extends BaseDialogController {

	@FXML private Label applicationVersionLabel;
	@FXML private Label libraryVersionLabel;
	@FXML private Label referencesVersionLabel;
	@FXML private Label metadataVersionLabel;
	@FXML private Label setupModifiedLabel;

	@FXML private Label buildDateLabel;

	private ApplicationUpdateService applicationUpdateService;
	
	@FXML
	protected void initialize() {
		super.initialize();
		this.applicationUpdateService = appCtx.getService(ApplicationUpdateService.class);

		VersionModel versionModel = applicationUpdateService.getVersionModel();

		applicationVersionLabel.textProperty().bindBidirectional(versionModel.applicationVersionProperty);
		libraryVersionLabel.textProperty().bindBidirectional(versionModel.libraryVersionProperty);
		referencesVersionLabel.textProperty().bindBidirectional(versionModel.referencesVersionProperty);
		metadataVersionLabel.textProperty().bindBidirectional(versionModel.metadataVersionProperty);
		setupModifiedLabel.textProperty().bindBidirectional(versionModel.setupModifiedParseProperty);

//		buildDateLabel.setVisible(SlikClientConstant.isShowBuildDate());
//		buildDateLabel.setText(SlikClientConstant.applicationBuildDate);
		
		buildDateLabel.setVisible(true);
		if ( OjkClientConstant.isShowBuildDate() ){
			buildDateLabel.setText(OjkClientConstant.applicationBuildDate);
		} else {
			buildDateLabel.setText(OjkClientConstant.applicationBuildDateProd);
		}

	}
	
	@Override
	public void reset(){
	}
	
	@Override
	public boolean isReused(){
		return false;
	}

}
