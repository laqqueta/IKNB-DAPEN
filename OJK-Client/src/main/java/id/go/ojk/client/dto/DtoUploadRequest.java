package id.go.ojk.client.dto;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DtoUploadRequest extends DtoBaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("AntrianID")
	private long antrianId;
	@SerializedName("SummaryID")
	private long summaryId;
	@SerializedName("UserName")
	private String userName;
	@SerializedName("File")
	private String fileName;

}
