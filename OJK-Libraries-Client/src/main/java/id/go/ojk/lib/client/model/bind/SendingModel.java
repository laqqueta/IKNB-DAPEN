package id.go.ojk.lib.client.model.bind;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import id.go.ojk.lib.client.service.ftp.FtpResult;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import lombok.Getter;
import lombok.Setter;

public class SendingModel {
	
	@Getter @Setter private String memberRefNumber;
	@Getter @Setter private Date memberRefDate;
	@Getter @Setter private String offlineUplReasonCode;
	
	@Getter @Setter private String loginID;
	
	@Getter @Setter private String submissionId;
	@Getter @Setter private String submissionFTP;
	@Getter @Setter private File readyToSendDir;
	@Getter @Setter private File transferedDir;

	@Getter @Setter private File signatureFile;
	@Getter @Setter private File signatureFileTxt;
	@Getter @Setter private List<File> readyToSendFiles = new ArrayList<>();
	@Getter @Setter private HashMap<String, String> signatureData = new HashMap<String, String>();
	@Getter @Setter private FtpResult ftpResult;

	private final BooleanProperty readFileProperty = new SimpleBooleanProperty();
	private final BooleanProperty signatureValidProperty = new SimpleBooleanProperty();

	private final BooleanProperty sendingSuccessProperty = new SimpleBooleanProperty();

	@Getter private final ProgressModel progressModel;

	public SendingModel(ProgressModel progressModel){
		this.progressModel = progressModel;
	}

	public void reset(boolean sendFile){
		setReadFile(false);
		setSignatureValid(false);
		sendingSuccessProperty.set(false);
		if (sendFile ){
			progressModel.reset(StatusCallback.start);
		} else {
			progressModel.reset(StatusCallback.disable);
		}
	}

	public void stopProcess(){
		progressModel.setStop(true);
	}

	public long getTotalFileSize(){
		return readyToSendFiles.stream().mapToLong(e -> e.length()).sum();
	}

	//~ BooleanProperty readFileProperty

	public BooleanProperty readFileProperty(){
		return readFileProperty;
	}
	public boolean isReadFile(){
		return readFileProperty.get();
	}
	public void setReadFile(boolean value){
		readFileProperty.set(value);
	}

	//~ BooleanProperty signatureValidProperty

	public BooleanProperty signatureValidProperty(){
		return signatureValidProperty;
	}

	public boolean isSignatureValid(){
		return signatureValidProperty.get();
	}

	public void setSignatureValid(boolean value){
		signatureValidProperty.set(value);
	}

	//~ BooleanProperty sendingSuccessProperty

	public BooleanProperty sendingSuccessProperty(){
		return sendingSuccessProperty;
	}

	public boolean isSendingSuccess(){
		return sendingSuccessProperty.get();
	}

	public void setSendingSuccess(boolean value){
		sendingSuccessProperty.set(value);
	}

}
