package id.go.ojk.pmvk.client.builder.field.rb.reference;

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

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2263PosRePmvk100100 implements IObject<KeyValueString> {
//	R_10010100000000 ("10010100000000", "Asumsi Makro:"),
	R_10010101000000 ("10010101000000", "Pertumbuhan Produk Domestik Bruto (%)"),
	R_10010102000000 ("10010102000000", "Nilai Tukar (Rp)"),
	R_10010103000000 ("10010103000000", "Tingkat Inflasi (%)"),
	R_10010104000000 ("10010104000000", "Tingkat Suku Bunga Acuan (%)"),
	R_10010105000000 ("10010105000000", "Lainnya, dirinci per jenis asumsi"),
//	R_10010200000000 ("10010200000000", "Asumsi Mikro:"),
	R_10010201000000 ("10010201000000", "Pertumbuhan Pembiayaan (%)"),
	R_10010202000000 ("10010202000000", "Pertumbuhan Penyertaan (%)"),
	R_10010203000000 ("10010203000000", "Pertumbuhan Pendanaan (%)"),
	R_10010204000000 ("10010204000000", "Tingkat Bunga/Imbal Hasil Pendanaan (%)"),
	R_10010205000000 ("10010205000000", "Tingkat Bunga/Imbal Hasil Pembiayaan/Penyertaan (%)"),
	R_10010206000000 ("10010206000000", "Rasio Aset Pembiayaan/Penyertaan Bermasalah"),
	R_10010207000000 ("10010207000000", "Lainnya, dirinci per jenis asumsi"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2263PosRePmvk100100 eEnum : ER2263PosRePmvk100100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2263PosRePmvk100100.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2263PosRePmvk100100.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4, 11 });
	}

	public static ConditionalRequired genConditionalMustEmpty() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRow(getObjects(), new int[] {4, 11}));
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumericNegative("3|4|5", R_10010102000000.key);
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("3|4|5",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 2, 3, 5, 6, 7, 8, 9, 10 }));
	}

	public static SegmentValidation genValidationMaxLengthNumeric() {
		return UtilSegmentValidation.genMaxLength("3|4|5",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4, 11 }), 16);
	}
	
	public static FieldValidation genValidationSum() {
		return UtilFieldValidation.genEqualsPosFormula("4-3", 2,
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4, 11 }));
	}
}
