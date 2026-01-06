package id.go.ojk.pps.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pps.client.builder.field.EFormRealisasiBisnis;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2262PosRePps070301 implements IObject<KeyValueString> {
//	R_07030101000000 ("07030101000000", "Penerimaan Pendanaan Baru:"),
	R_07030101010000 ("07030101010000", "Akad Mudharabah"),
	R_07030101020000 ("07030101020000", "Akad Mudharabah Musytarakah"),
	R_07030101030000 ("07030101030000", "Akad Musyarakah"),
	R_07030101040000 ("07030101040000", "Akad Ijarah"),
	R_07030101050000 ("07030101050000", "Akad Qardh"),
	R_07030101060000 ("07030101060000", "Akad Pendanaan Lainnya"),
	R_07030101070000 ("07030101070000", "Total Penerimaan Pendanaan Baru"),
//	R_07030102000000 ("07030102000000", "Saldo Penerimaan Pendanaan (Outstanding):"),
	R_07030102010000 ("07030102010000", "Akad Mudharabah"),
	R_07030102020000 ("07030102020000", "Akad Mudharabah Musytarakah"),
	R_07030102030000 ("07030102030000", "Akad Musyarakah"),
	R_07030102040000 ("07030102040000", "Akad Ijarah"),
	R_07030102050000 ("07030102050000", "Akad Qardh"),
	R_07030102060000 ("07030102060000", "Akad Pendanaan Lainnya"),
	R_07030102070000 ("07030102070000", "Total Saldo Penerimaan Pendanaan (Outstanding)"),
	;
	
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2262PosRePps070301 eEnum : ER2262PosRePps070301.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2262PosRePps070301.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2262PosRePps070301.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static FieldValidation genValidationSum() {
		return UtilFieldValidation.genEqualsFormula("3-2", 2);
	}

	public static SegmentValidation genValidationFormPenerimaanPendanaanBaru() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_070102.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_07030101070000.key, comparatorFormCode, 
				ER2260PosRePps070102.R_07010201090000.getKey(), "Total Penerimaan Pendanaan Baru|Total Penerimaan Pendanaan Baru form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormSaldoPenerimaanPendanaan() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_070102.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_07030102070000.key, comparatorFormCode, 
				ER2260PosRePps070102.R_07010202090000.getKey(), "Total Saldo Penerimaan Pendanaan|Total Saldo Penerimaan Pendanaan form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationTotalPenerimaanPendanaanBaru() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_07030101070000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 5),
				"Total Penerimaan Pendanaan Baru|Penjumlahan Penerimaan Pendanaan Baru");
	}

	public static SegmentValidation genValidationTotalSaldoPenerimaanPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_07030102070000.key,
				UtilMetadata.genPlusRow(getObjects(), 7, 12),
				"Total Saldo Penerimaan Pendanaan|Penjumlahan Saldo Penerimaan Pendanaan");
	}
}
