package id.go.ojk.client.vc;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.service.UserService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.lib.client.model.Tupple3;
import id.go.ojk.lib.client.model.bind.UserModel;
import id.go.ojk.lib.client.model.security.UserRole;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UserOfflineManagementController extends BaseController {

	@FXML private Button addButton;
	@FXML private Button editButton;
	@FXML private Button deleteButton;

    @FXML private TableView<UserModel> userTable;

    @FXML private TableColumn<UserModel, String> numberColumn;
    @FXML private TableColumn<UserModel, String> userLoginIdColumn;
    @FXML private TableColumn<UserModel, String> userNameColumn;
    @FXML private TableColumn<UserModel, String> roleDescColumn;

    private final BooleanProperty editableData = new SimpleBooleanProperty();
    @FXML private UserModel selectedUserModel;

    private UserService userService;
    private MainApplication mainApplication;

	@FXML
	protected void initialize() {
		super.initialize();
		this.userService = appCtx.getService(UserService.class);
		mainApplication = appCtx.getService(MainApplication.class);

		numberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty);
		userLoginIdColumn.setCellValueFactory(cellData -> cellData.getValue().userLoginIdProperty);
		userNameColumn.setCellValueFactory(cellData -> cellData.getValue().userNameProperty);
		roleDescColumn.setCellValueFactory(cellData -> cellData.getValue().roleDescProperty);

		editButton.disableProperty().bind(editableData.not());
		deleteButton.disableProperty().bind(editableData.not());

		setSelectedUserModel(null);
		userTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> setSelectedUserModel(newValue));
	}

	public void setSelectedUserModel(UserModel selectedUserModel) {
		this.selectedUserModel = selectedUserModel;
		if ( selectedUserModel == null ) {
			editableData.set(false);
			return;
		}

		if ( selectedUserModel.roleProperty.get().equals(UserRole.ljkOffline.name()) )
			editableData.set(true);
		else
			editableData.set(false);
	}

    private Tupple3<AnchorPane, UserFormController, Stage> userFormDialog;
    @FXML
	private void handleAddUser() {
    	mainApplication.createDialog("vc/UserForm.fxml", "Tambah Pengguna", StageStyle.UTILITY, Modality.WINDOW_MODAL, userFormDialog, true,
			e -> {
				e.getB().setUser(null);
				e.getB().setCallback( newUser -> reset());
			}
		);
	}

    @FXML
	private void handleEditUser() {
    	mainApplication.createDialog("vc/UserForm.fxml", "Tambah Pengguna", StageStyle.UTILITY, Modality.WINDOW_MODAL, userFormDialog, true,
			e -> {
				e.getB().setUser(selectedUserModel.cloneQuietly());
				e.getB().setCallback( newUser -> reset());
			}
		);
	}

    @FXML
	private void handleDeleteUser() {
		try {
			if ( !AlertUtil.confirmDialog("Konfirmasi", "Konfirmasi", "Apakah anda yakin akan menghapus user " + selectedUserModel.userNameProperty.get() + "?") )
				return;
			if (userService.deleteUserOffline(selectedUserModel.toUser()))
				AlertUtil.showAlert(AlertType.INFORMATION, "Sukses", "Sukses menghapus");
			else
				AlertUtil.showAlert(AlertType.WARNING, "Gagal", "Gagal menghapus");
			reset();
		} catch (Throwable t){
			AlertUtil.showError(logger, "Error saat ubah pengguna", t);
		}
	}

	@Override
	public void reset(){
		userTable.setItems(userService.getUserModels());
		setSelectedUserModel(null);
	}
	
	@Override
	public boolean isReused(){
		return true;
	}

}
