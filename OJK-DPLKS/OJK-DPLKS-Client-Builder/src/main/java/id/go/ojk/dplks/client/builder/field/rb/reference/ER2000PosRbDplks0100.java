package id.go.ojk.dplks.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2000PosRbDplks0100 implements IObject<KeyValueString> {
	R_0101000000 ("0101000000", "Nama"),
	R_0102000000 ("0102000000", "SK Pengesahan"),
	R_0103000000 ("0103000000", "Program"),
	R_0104000000 ("0104000000", "Pengurus"),
	R_0105000000 ("0105000000", "Plt. Pengurus"),
	R_0106000000 ("0106000000", "Dewan Pengawas"),
	R_0107000000 ("0107000000", "Dewan Pengawas Syariah"),
	R_0108000000 ("0108000000", "Alamat Kantor"),
	R_0109000000 ("0109000000", "Tahun Rencana Bisnis"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2000PosRbDplks0100 eEnum : ER2000PosRbDplks0100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2000PosRbDplks0100.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2000PosRbDplks0100.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 7, 8 });
	}
	
	public static SegmentValidation genValidationMaxLength80() {
		return UtilSegmentValidation.genMaxLength("2", R_0101000000.key + "|" + R_0102000000.key, 80);
	}
	
	public static SegmentValidation genValidationMaxLength100() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 3, 6), 100);
	}
	
	public static SegmentValidation genValidationMaxLength4() {
		return UtilSegmentValidation.genMaxLength("2", R_0103000000.key + "|" + R_0109000000.key , 4);
	}
	
	public static SegmentValidation genValidationProgramA() {
		return UtilSegmentValidation.genFixedValue("2", R_0103000000.key, "DPLK");
	}
	
	public static SegmentValidation genValidationProgramB() {
		return UtilSegmentValidation.genRegexAlfa("2", R_0103000000.key);
	}
	
	public static SegmentValidation genValidationKodePerusahaan() {
		return UtilSegmentValidation.genRegexNumeric("2", R_0102000000.key);
	}
	
	public static SegmentValidation genValidationTahunRencanaBisnisA() {
		return UtilSegmentValidation.genRegexYear("2", R_0109000000.key);
	}
	
	public static SegmentValidation genValidationTahunRencanaBisnisB() {
		return UtilSegmentValidation.genPeriodYear("2", R_0109000000.key);
	}
}
