package id.go.ojk.dppkk.client.builder.field.rb.reference;

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
public enum ER2000PosRbDppkk0100 implements IObject<KeyValueString> {
	R_0101000000 ("0101000000", "Nama Perusahaan"),
	R_0102000000 ("0102000000", "Kode Perusahaan"),
	R_0103000000 ("0103000000", "SK Pengesahan"),
	R_0104000000 ("0104000000", "Program"),
	R_0105000000 ("0105000000", "Pengurus"),
	R_0106000000 ("0106000000", "Dewan Pengawas"),
	R_0107000000 ("0107000000", "Alamat Kantor"),
	R_0108000000 ("0108000000", "Tahun Rencana Bisnis"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2000PosRbDppkk0100 eEnum : ER2000PosRbDppkk0100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2000PosRbDppkk0100.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2000PosRbDppkk0100.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 3, 6, 7 });
	}
	
	public static SegmentValidation genValidationNamaPerusahaanMaxLength() {
		return UtilSegmentValidation.genMaxLength("2", R_0101000000.key, 80);
	}
	
	public static SegmentValidation genValidationKodePerusahaan() {
		return UtilSegmentValidation.genRegexNumeric("2", R_0102000000.key);
	}
	
	public static SegmentValidation genValidationKodePerusahaanMaxLength() {
		return UtilSegmentValidation.genMaxLength("2", R_0102000000.key, 10);
	}
	
	public static SegmentValidation genValidationSkPengesahanMaxLength() {
		return UtilSegmentValidation.genMaxLength("2", R_0103000000.key, 80);
	}
	
	public static SegmentValidation genValidationProgram() {
		return UtilSegmentValidation.genFixedValue("2", R_0104000000.key, "PPIP|PPMP");
	}
	
	public static SegmentValidation genValidationProgramMaxLength() {
		return UtilSegmentValidation.genMaxLength("2", R_0104000000.key, 4);
	}
	
	public static SegmentValidation genValidationPengurus() {
		return UtilSegmentValidation.genRegexAlfaSpace("2", R_0105000000.key);
	}
	
	public static SegmentValidation genValidationPengurusMaxLength() {
		return UtilSegmentValidation.genMaxLength("2", R_0105000000.key, 20);
	}
	
	public static SegmentValidation genValidationDewanPengawas() {
		return UtilSegmentValidation.genRegexAlfaSpace("2", R_0106000000.key);
	}
	
	public static SegmentValidation genValidationDewanPengawasMaxLength() {
		return UtilSegmentValidation.genMaxLength("2", R_0106000000.key, 20);
	}
	
	public static SegmentValidation genValidationTahunRencanaBisnisA() {
		return UtilSegmentValidation.genRegexNumeric("2", R_0108000000.key);
	}
	
	public static SegmentValidation genValidationTahunRencanaBisnisB() {
		return UtilSegmentValidation.genPeriodYear("2", R_0108000000.key);
	}
	
	public static SegmentValidation genValidationTahunRencanaBisnisMaxLength() {
		return UtilSegmentValidation.genMaxLength("2", R_0108000000.key, 4);
	}
}
