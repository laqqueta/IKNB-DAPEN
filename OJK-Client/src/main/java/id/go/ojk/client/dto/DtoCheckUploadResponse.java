package id.go.ojk.client.dto;

import java.io.File;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DtoCheckUploadResponse extends DtoBaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("Data")
	private List<DtoCheckUploadResponseData> data;
	
	public boolean isFileExist(File file) {
		if (data != null) {
			for (DtoCheckUploadResponseData dto : data) {
				if (file.getName().equalsIgnoreCase(dto.getFileName())) {
					return true;
				}
			}
		}
		return false;
	}
}
