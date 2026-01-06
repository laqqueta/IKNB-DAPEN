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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2260PosRePps070102 implements IObject<KeyValueString> {
//	R_07010201000000 ("07010201000000", "Penerimaan Pendanaan Baru:"),
	R_07010201010000 ("07010201010000", "Pendanaan dari lembaga pemerintah"),
	R_07010201020000 ("07010201020000", "Pendanaan dari bank"),
	R_07010201030000 ("07010201030000", "Pendanaan dari industri keuangan nonbank"),
	R_07010201040000 ("07010201040000", "Pendanaan dari lembaga dan/atau badan usaha lain"),
	R_07010201050000 ("07010201050000", "Pendanaan subordinasi"),
	R_07010201060000 ("07010201060000", "Penerbitan sukuk melalui penawaran umum"),
	R_07010201070000 ("07010201070000", "Penerbitan sukuk tidak melalui penawaran umum"),
	R_07010201080000 ("07010201080000", "Sekuritisasi aset"),
	R_07010201090000 ("07010201090000", "Total Penerimaan Pendanaan Baru"),
//	R_07010202000000 ("07010202000000", "Saldo Penerimaan Pendanaan (Outstanding):"),
	R_07010202010000 ("07010202010000", "Pendanaan dari lembaga pemerintah"),
	R_07010202020000 ("07010202020000", "Pendanaan dari bank"),
	R_07010202030000 ("07010202030000", "Pendanaan dari industri keuangan nonbank"),
	R_07010202040000 ("07010202040000", "Pendanaan dari lembaga dan/atau badan usaha lain"),
	R_07010202050000 ("07010202050000", "Pendanaan subordinasi"),
	R_07010202060000 ("07010202060000", "Penerbitan sukuk melalui penawaran umum"),
	R_07010202070000 ("07010202070000", "Penerbitan sukuk tidak melalui penawaran umum"),
	R_07010202080000 ("07010202080000", "Sekuritisasi aset"),
	R_07010202090000 ("07010202090000", "Total Saldo Penerimaan Pendanaan (Outstanding)"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2260PosRePps070102 eEnum : ER2260PosRePps070102.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2260PosRePps070102.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2260PosRePps070102.class.getSimpleName().substring(2, 6));
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

	public static SegmentValidation genValidationTotalPenerimaanPendanaanBaru() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_07010201090000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 7),
				"Total Penerimaan Pendanaan Baru|Penjumlahan Penerimaan Pendanaan Baru");
	}

	public static SegmentValidation genValidationTotalSaldoPenerimaanPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_07010202090000.key,
				UtilMetadata.genPlusRow(getObjects(), 9, 16),
				"Total Saldo Penerimaan Pendanaan|Penjumlahan Saldo Penerimaan Pendanaan");
	}
}
