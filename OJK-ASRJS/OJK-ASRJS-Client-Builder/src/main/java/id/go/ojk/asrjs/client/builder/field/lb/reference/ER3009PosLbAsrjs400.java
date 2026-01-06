package id.go.ojk.asrjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3009PosLbAsrjs400 implements IObject<KeyValueString> {
	R_3410000099 ("3410000099", "I. Saldo Dana Awal"),
	R_3410000000 ("3410000000", "II. Penambahan"),
	R_3411000000 ("3411000000", "Modal Disetor"),
	R_3401000000 ("3401000000", "Laba komprehensif periode berjalan"),
	R_3403040000 ("3403040000", "Kenaikan akumulasi dana tabarru'/dana investasi peserta"),
	R_3411990099 ("3411990099", "Penambahan lainnya"),
	R_3411990100 ("3411990100", "III. Pengurangan"),
	R_3411990101 ("3411990101", "Rugi komprehensif periode berjalan"),
	R_3411990102 ("3411990102", "Penurunan akumulasi dana tabarru' / dana investasi peserta"),
	R_3411990000 ("3411990000", "Pembayaran Deviden"),
	R_3412000001 ("3412000001", "Pengurangan lainnya"),
	R_3412010000 ("3412010000", "IV. Saldo Akhir Dana"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3009PosLbAsrjs400 eEnum : ER3009PosLbAsrjs400.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 6), getObjects());
	}
	
	public static ConditionalRequired genConditional2() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4, 8 }));
	}
	
	public static ConditionalRequired genConditional3() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 2, 3, 7, 9 }));
	}
	
	public static ConditionalRequired genConditional4() {
		return genConditional3();
	}
	
	public static ConditionalRequired genConditional5() {
		return genConditional3();
	}
	
	public static FieldValidation genValidation6() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 5), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 1, 6, 11 }));
	}

	public static SegmentValidation genValidationPenambahan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_3410000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 2, 5),
				"Total Penambahan|Penjumlahan Penambahan");
	}

	public static SegmentValidation genValidationPengurangan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_3411990100.key, 
				UtilMetadata.genPlusRow(getObjects(), 7, 10),
				"Total Pengurangan|Penjumlahan Pengurangan");
	}

	public static SegmentValidation genValidationSaldoAkhirDana() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_3412010000.key, 
				R_3410000099.key + "+" + R_3410000000.key + "-" + R_3411990100.key, 
				"Total Saldo Akhir Dana|Perhitungan Saldo Akhir Dana");
	}
}
