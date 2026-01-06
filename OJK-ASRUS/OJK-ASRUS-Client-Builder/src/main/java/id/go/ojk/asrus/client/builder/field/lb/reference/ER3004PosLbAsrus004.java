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
public enum ER3004PosLbAsrus004 implements IObject<KeyValueString> {
	R_0040100000 ("0040100000", "Biaya Pegawai dan Pengurus"),
	R_0040200000 ("0040200000", "Biaya Pendidikan dan Latihan"),
	R_0040300000 ("0040300000", "a. Diklat Pegawai"),
	R_0040400000 ("0040400000", "b. Diklat Direksi"),
	R_0040500000 ("0040500000", "c. Diklat Komisaris"),
	R_0040600000 ("0040600000", "d. Diklat Dewan Pengawas Syariah"),
	R_0040700000 ("0040700000", "Total Biaya Diklat "),
	R_0040800000 ("0040800000", "Rasio Biaya Diklat dan Biaya Pegawai dan Pengurus"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3004PosLbAsrus004 eEnum : ER3004PosLbAsrus004.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2|3", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 7 }));
	}
	
	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDot("2|3", R_0040800000.key);
	}
	
	public static SegmentValidation genValidationMaxLength6() {
		return UtilSegmentValidation.genMaxLength("2|3", R_0040800000.key, 6);
	}
	
	public static SegmentValidation genValidationTotalBiayaDiklat() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0040700000.key, UtilMetadata.genPlusRow(getObjects(), 2, 5), 
				"Total Biaya Diklat|Penjumlahan Biaya Diklat");
	}
	
	public static SegmentValidation genValidationRasioBiayaDiklatDanBiayaPegawaiDanPengurus() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_0040800000.key, UtilMetadata.genPipeRow(getObjects(), new int[] { 6, 0 }), 
				"Rasio Biaya Diklat dan Biaya Pegawai dan Pengurus|Perhitungan Rasio Biaya Diklat dan Biaya Pegawai dan Pengurus");
	}
}
