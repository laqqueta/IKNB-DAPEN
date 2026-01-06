package id.go.ojk.asrjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3031PosLbAsrjk114 implements IObject<KeyValueString> {
//	R_2504010000 ("2504010000", "A. Asuransi Jiwa"),
	R_2504010101 ("2504010101", "1. Kematian Jangka Warsa (Term Life)"),
	R_2504010102 ("2504010102", "2. Dwiguna (Endowment) dan/atau Kombinasinya"),
	R_2504010103 ("2504010103", "3. Seumur Hidup (Whole Life)"),
	R_2504010104 ("2504010104", "4. Kecelakaan Diri"),
	R_2504010105 ("2504010105", "5. Kesehatan"),
	R_2504010106 ("2504010106", "6. Lainnya"),
	R_2504010200 ("2504010200", " Sub Jumlah A"),
	R_2504020000 ("2504020000", "B. Anuitas"),
	R_2504000000 ("2504000000", "Total Cadangan Atas Risiko Bencana"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3031PosLbAsrjk114 eEnum : ER3031PosLbAsrjk114.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3031PosLbAsrjk114.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3031PosLbAsrjk114.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}
	
	public static SegmentValidation genValidationAsuransiJiwa() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_2504010200.key, UtilMetadata.genPlusRow(getObjects(), 0, 5), 
				"Total asuransi jiwa|Penjumlahan asuransi jiwa");
	}
	
	public static SegmentValidation genValidationCadanganAtasRisikoBencana() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_2504000000.key, UtilMetadata.genPlusRow(getObjects(), 6, 7), 
				"Total cadangan atas risiko bencana|Penjumlahan cadangan atas risiko bencana");
	}
}
