package id.go.ojk.asrus.client.builder.field.lb.reference;

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
public enum ER3000PosLbAsrus000 implements IObject<KeyValueString> {
	R_0100000000 ("0100000000", "Nama Perusahaan"),
	R_0200000000 ("0200000000", "Alamat Lengkap"),
	R_0300000000 ("0300000000", "Telepon dan Fax"),
	R_0400000000 ("0400000000", "E-mail"),
	R_0500000000 ("0500000000", "NPWP"),
	R_0600000000 ("0600000000", "No. & Tanggal Izin Usaha"),
	R_0700000000 ("0700000000", "Jumlah Cabang/Perwakilan"),
	R_0800000000 ("0800000000", "Jumlah Tenaga Kerja"),
	R_0900000000 ("0900000000", "Jumlah Tertanggung"),
	R_1000000000 ("1000000000", "Auditor Eksternal"),
	R_1100000000 ("1100000000", "Pengendali"),
//	R_1200000000 ("1200000000", "PIC Laporan Keuangan"),
//	R_1201000000 ("1201000000", "Penyusun Laporan"),
	R_1201010000 ("1201010000", "Nama Petugas"),
	R_1201020000 ("1201020000", "Divisi"),
	R_1201030000 ("1201030000", "Telepon"),
	R_1201040000 ("1201040000", "Fax"),
	R_1201050000 ("1201050000", "Email"),
//	R_1202000000 ("1202000000", "Penanggung Jawab Direksi"),
	R_1202010000 ("1202010000", "Nama Penanggung Jawab"),
	R_1202020000 ("1202020000", "Jabatan"),
	R_1202030000 ("1202030000", "Telepon"),
	R_1202040000 ("1202040000", "Fax"),
	R_1202050000 ("1202050000", "E-mail"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3000PosLbAsrus000 eEnum : ER3000PosLbAsrus000.values()) {
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
		return UtilSegmentValidation.genMaxLength("2", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 3, 7, 8, 9, 10, 11, 12, 15, 16, 17, 20 }), 50);
	}
	
	public static SegmentValidation genValidationMaxLen15() {
		return UtilSegmentValidation.genMaxLength("2", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 2, 13, 14, 18, 19 }), 15);
	}
	
	public static SegmentValidation genValidationMaxLen25() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 4, 5 }), 25);
	}
	
	public static SegmentValidation genValidationMaxLen10() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 6 }), 10);
	}
	
	public static SegmentValidation genValidationCompanyName() {
		return UtilSegmentValidation.genRegexCompanyName("2", R_0100000000.key);
	}
	
	public static SegmentValidation genValidationCompanyAddress() {
		return UtilSegmentValidation.genRegexCompanyAddress("2", R_0200000000.key);
	}
	
	public static SegmentValidation genValidationPhone() {
		return UtilSegmentValidation.genRegexPhone("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 2, 13, 14, 18, 19 }));
	}
	
	public static SegmentValidation genValidationEmail() {
		return UtilSegmentValidation.genRegexEmail("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 3, 15, 20 }));
	}
	
	public static SegmentValidation genValidationNpwp() {
		return UtilSegmentValidation.genRegexNpwp("2", R_0500000000.key);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 6, 7, 8 }));
	}
	
	public static SegmentValidation genValidationName() {
		return UtilSegmentValidation.genRegexLjkName("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 9, 10, 11, 12, 16, 17 }));
	}
}
