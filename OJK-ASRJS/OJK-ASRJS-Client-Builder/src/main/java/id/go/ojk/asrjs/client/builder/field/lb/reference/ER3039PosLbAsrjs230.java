package id.go.ojk.asrjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3039PosLbAsrjs230 implements IObject<KeyValueString> {
//	R_2300070100 ("2300070100", "A. Asuransi Jiwa"),
	R_2300070101 ("2300070101", "1. Kematian Jangka Warsa (Term Life)"),
	R_2300070102 ("2300070102", "2. Dwiguna (Endowment) dan/atau Kombinasinya"),
	R_2300070103 ("2300070103", "3. Seumur Hidup (Whole Life)"),
	R_2300070104 ("2300070104", "4. Kesehatan"),
	R_2300070105 ("2300070105", "5. Kecelakaan Diri"),
	R_2300070106 ("2300070106", "6. Lainnya"),
	R_2300070107 ("2300070107", "Sub Jumlah A"),
	R_2300070108 ("2300070108", "B. Anuitas"),
	R_2300070109 ("2300070109", "Sub Jumlah B"),
	R_2300070110 ("2300070110", "Total Penyisihan Atas Risiko Bencana"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3039PosLbAsrjs230 eEnum : ER3039PosLbAsrjs230.values()) {
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

	public static FieldValidation genValidation4() {
		return UtilFieldValidation.genEqualsPosFormula("2+3", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 6, 8, 9 }));
	}
	
	public static SegmentValidation genValidationSubJumlahA() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_2300070107.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 5), "Sub Jumlah A|Penjumlahan Sub Jumlah A");
	}
	
	public static SegmentValidation genValidationSubJumlahB() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_2300070109.key, 
				R_2300070108.key, "Sub Jumlah B|Nilai B. Anuitas");
	}
	
	public static SegmentValidation genValidationTotalPenyisihanAtasRisikoBencana() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_2300070110.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 6, 8 }), "Total Penyisihan Atas Risiko Bencana|Penjumlahan Penyisihan Atas Risiko Bencana");
	}
}
