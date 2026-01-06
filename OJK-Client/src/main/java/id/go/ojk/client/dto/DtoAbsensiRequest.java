package id.go.ojk.client.dto;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DtoAbsensiRequest extends DtoBaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("ReportCode")
	private String reportCode;
	@SerializedName("ReportFormGroupCode")
	private String reportFormGroupCode;
	@SerializedName("FullEntityCode")
	private String fullEntityCode;
	@SerializedName("RutinFlag")
	private String rutinFlag;
	@SerializedName("JenisKoreksi")
	private String jenisKoreksi;
	@SerializedName("PeriodDate")
	private String periodDate;
	@SerializedName("PeriodCode")
	private String periodCode;
	@SerializedName("Username")
	private String userName;

}
