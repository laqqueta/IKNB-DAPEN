package id.go.ojk.ppk.client.builder.field.rb.reference;

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
public enum ER2010PosRbPpk070101 implements IObject<KeyValueString> {
//	R_07010101000000 ("07010101000000", "Penerimaan Pendanaan Baru:"),
	R_07010101010000 ("07010101010000", "Pinjaman dari lembaga pemerintah"),
	R_07010101020000 ("07010101020000", "Pinjaman dari bank"),
	R_07010101030000 ("07010101030000", "Pinjaman dari industri keuangan nonbank"),
	R_07010101040000 ("07010101040000", "Pinjaman dari lembaga dan/atau badan usaha lain"),
	R_07010101050000 ("07010101050000", "Pinjaman subordinasi"),
	R_07010101060000 ("07010101060000", "Penerbitan efek bersifat utang melalui penawaran umum"),
	R_07010101070000 ("07010101070000", "Penerbitan efek bersifat utang tidak melalui penawaran umum"),
	R_07010101080000 ("07010101080000", "Sekuritisasi aset"),
	R_07010101090000 ("07010101090000", "Total Penerimaan Pendanaan Baru"),
//	R_07010102000000 ("07010102000000", "Saldo Penerimaan Pendanaan (Outstanding):"),
	R_07010102010000 ("07010102010000", "Pinjaman dari lembaga pemerintah"),
	R_07010102020000 ("07010102020000", "Pinjaman dari bank"),
	R_07010102030000 ("07010102030000", "Pinjaman dari industri keuangan nonbank, lembaga, dan/atau badan usaha lain"),
	R_07010102040000 ("07010102040000", "Pinjaman dari lembaga dan/atau badan usaha lain"),
	R_07010102050000 ("07010102050000", "Pinjaman subordinasi"),
	R_07010102060000 ("07010102060000", "Penerbitan efek bersifat utang melalui penawaran umum"),
	R_07010102070000 ("07010102070000", "Penerbitan efek bersifat utang tidak melalui penawaran umum"),
	R_07010102080000 ("07010102080000", "Sekuritisasi aset"),
	R_07010102090000 ("07010102090000", "Total Saldo Penerimaan Pendanaan (Outstanding)"),;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2010PosRbPpk070101 eEnum : ER2010PosRbPpk070101.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2010PosRbPpk070101.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2010PosRbPpk070101.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationTotalPenerimaanPendanaanBaru() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_07010101090000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 7),
				"Total Penerimaan Pendanaan Baru|Penjumlahan Penerimaan Pendanaan Baru");
	}

	public static SegmentValidation genValidationTotalSaldoPenerimaanPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_07010102090000.key,
				UtilMetadata.genPlusRow(getObjects(), 9, 16),
				"Total Saldo Penerimaan Pendanaan|Penjumlahan Saldo Penerimaan Pendanaan");
	}
}
