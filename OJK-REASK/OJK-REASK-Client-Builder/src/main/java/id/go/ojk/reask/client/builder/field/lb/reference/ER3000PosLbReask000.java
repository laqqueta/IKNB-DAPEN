package id.go.ojk.reask.client.builder.field.lb.reference;

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
public enum ER3000PosLbReask000 implements IObject<KeyValueString> {
	R_0100000000 ("0100000000", "Nama Perusahaan"),
	R_0200000000 ("0200000000", "Alamat Lengkap"),
	R_0300000000 ("0300000000", "DATI I (Provinsi)"),
	R_0400000000 ("0400000000", "DATI II (Kabupaten/Kotamdya)"),
	R_0500000000 ("0500000000", "Telepon"),
	R_0600000000 ("0600000000", "Fax"),
	R_0700000000 ("0700000000", "Email"),
	R_0800000000 ("0800000000", "NPWP"),
	R_0900000000 ("0900000000", "No Izin Usaha"),
	R_1000000000 ("1000000000", "Tgl Izin Usaha"),
//	R_1100000000 ("1100000000", "11. Informasi Kantor Cabang/Perwakilan"),
	R_1101000000 ("1101000000", "Jumlah Cabang/Perwakilan"),
	R_1102000000 ("1102000000", "Jumlah Tertanggung"),
	R_1200000000 ("1200000000", "Auditor Eksternal"),
	R_1300000000 ("1300000000", "Single Investor Identification (SID)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3000PosLbReask000 eEnum : ER3000PosLbReask000.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationMaxLen50() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 6, 11, 12, 13 }), 
				50);
	}
	
	public static SegmentValidation genValidationMaxLen10() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 2, 3, 10 }), 
				10);
	}
	
	public static SegmentValidation genValidationMaxLen15() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 4, 5 }), 
				15);
	}
	
	public static SegmentValidation genValidationMaxLen25() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 7, 8 }), 
				25);
	}
	
	public static SegmentValidation genValidationMaxLen8() {
		return UtilSegmentValidation.genMaxLength("2", R_1000000000.key, 8);
	}
	
	public static SegmentValidation genValidationCompanyName() {
		return UtilSegmentValidation.genRegexCompanyName("2", R_0100000000.key);
	}
	
	public static SegmentValidation genValidationCompanyAddress() {
		return UtilSegmentValidation.genRegexCompanyAddress("2", R_0200000000.key);
	}
	
	public static SegmentValidation genValidationDati1() {
		return UtilSegmentValidation.genReference("2", R_0300000000.key, "5015");
	}
	
	public static SegmentValidation genValidationDati2() {
		return UtilSegmentValidation.genReferenceCondition("2", R_0400000000.key, "5048", R_0300000000.key);
	}
	
	public static SegmentValidation genValidationPhone() {
		return UtilSegmentValidation.genRegexPhone("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 4, 5 }));
	}
	
	public static SegmentValidation genValidationEmail() {
		return UtilSegmentValidation.genRegexEmail("2", R_0700000000.key);
	}
	
	public static SegmentValidation genValidationNpwp() {
		return UtilSegmentValidation.genRegexNpwp("2", R_0800000000.key);
	}
	
	public static SegmentValidation genValidationDate() {
		return UtilSegmentValidation.genRegexDate("2", R_1000000000.key, "yyyyMMdd");
	}
	
	public static SegmentValidation genValidationNiu() {
		return UtilSegmentValidation.genRegexSkNumber("2", R_0900000000.key);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 10, 11 }));
	}
	
	public static SegmentValidation genValidationName() {
		return UtilSegmentValidation.genRegexLjkName("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 12, 13 }));
	}
}
