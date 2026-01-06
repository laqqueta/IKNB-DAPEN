package id.go.ojk.reask.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3058PosLbReask119 implements IObject<KeyValueString> {
	R_1408010000 ("1408010000", "SBN"),
	R_1408010001 ("1408010001", "Rincian SBN"),
	R_1408020000 ("1408020000", "OBLIGASI / SUKUK INFRASTRUKTUR"),
	R_1408020001 ("1408020001", "Rincian Obligasi/Sukuk Infrastruktur"),
	R_1408030000 ("1408030000", "REKSADANA UNDERLYING SBN"),
	R_1408030001 ("1408030001", "Rincian Reksadana Underlying SBN"),
	R_1408040000 ("1408040000", "REKSADANA PENYERTAAN TERBATAS"),
	R_1408040001 ("1408040001", "Rincian Reksadana Penyertaan Terbatas"),
	R_1408050000 ("1408050000", "EFEK BERAGUN ASET"),
	R_1408050001 ("1408050001", "Rincian Efek Beragun Aset"),
	R_1408060000 ("1408060000", "INVESTASI LAIN UNTUK PEMBIAYAAN PROYEK INFRASTRUKTUR PEMERINTAH"),
	R_1408060001 ("1408060001", "Rincian Investasi Lain untuk Pembiayaan Proyek Infrastruktur Pemerintah"),
	R_1408000000 ("1408000000", "Total"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3058PosLbReask119 eEnum : ER3058PosLbReask119.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 2, 4, 6, 8, 10, 12 });
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("8", getObjects());
	}
	
	public static ConditionalRequired genConditionField2() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 2, 4, 6, 8, 10, 12 }));
	}
	
	public static ConditionalRequired genConditionField345() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRow(getObjects(), new int[] { 3, 9 }));
	}
	
	public static ConditionalRequired genConditionField6() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRow(getObjects(), new int[] { 5, 7 }));
	}
	
	public static ConditionalRequired genConditionField7() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRow(getObjects(), new int[] { 7 }));
	}
	
	public static SegmentValidation genValidationSbn() {
		return UtilSegmentValidation.genEqualsFormula("8", R_1408010000.key, R_1408010001.key, "Total SBN|Penjumlahan SBN");
	}
	
	public static SegmentValidation genValidationObligasiSukukInfrastruktur() {
		return UtilSegmentValidation.genEqualsFormula("8", R_1408020000.key, R_1408020001.key, "Total obligasi sukuk infrastruktur|Penjumlahan obligasi sukuk infrastruktur");
	}
	
	public static SegmentValidation genValidationReksadanaUnderlyingSbn() {
		return UtilSegmentValidation.genEqualsFormula("8", R_1408030000.key, R_1408030001.key, "Total reksadana underlying SBN|Penjumlahan reksadana underlying SBN");
	}
	
	public static SegmentValidation genValidationReksadanaPenyertaanTerbatas() {
		return UtilSegmentValidation.genEqualsFormula("8", R_1408040000.key, R_1408040001.key, "Total reksadana penyertaan terbatas|Penjumlahan reksadana penyertaan terbatas");
	}
	
	public static SegmentValidation genValidationEfekBeragunAset() {
		return UtilSegmentValidation.genEqualsFormula("8", R_1408050000.key, R_1408050001.key, "Total efek beragun aset|Penjumlahan efek beragun aset");
	}
	
	public static SegmentValidation genValidationInvestasiLain() {
		return UtilSegmentValidation.genEqualsFormula("8", R_1408060000.key, R_1408060001.key, "Total investasi lain untuk pembiayaan proyek infrastruktur pemerintah|Penjumlahan investasi lain untuk pembiayaan proyek infrastruktur pemerintah");
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("8", R_1408000000.key, UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 2, 4, 6, 9, 10 }), "Total|Penjumlahan detail");
	}
}
