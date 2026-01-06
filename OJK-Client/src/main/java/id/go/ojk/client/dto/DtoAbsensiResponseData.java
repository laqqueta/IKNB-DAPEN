package id.go.ojk.client.dto;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class DtoAbsensiResponseData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("AntrianID")
	private long antrianID;
	@SerializedName("SummaryID")
	private long summaryID;
	@SerializedName("FolderPath")
	private String folderPath;
	
}
