package id.go.ojk.pmvk.client.builder.field.rb.reference;

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
public enum ER2257PosRePmvk070101 implements IObject<KeyValueString> {
//	R_07010101000000 ("07010101000000", "Penerimaan Pendanaan Baru:"),
	R_07010101010000 ("07010101010000", "1.        Pinjaman dari pemerintah"),
	R_07010101020000 ("07010101020000", "2.        Pinjaman dari badan usaha milik negara atau badan usaha milik daerah"),
	R_07010101030000 ("07010101030000", "3.        Pinjaman dari perusahaan pembiayaan"),
	R_07010101040000 ("07010101040000", "4.        Pinjaman dari lembaga pembiayaan ekspor Indonesia"),
	R_07010101050000 ("07010101050000", "5.        Pinjaman dari bank "),
	R_07010101060000 ("07010101060000", "6.        Pinjaman dari lembaga keuangan lainnya"),
	R_07010101070000 ("07010101070000", "7.        Pinjaman dari lembaga keuangan multilateral"),
	R_07010101080000 ("07010101080000", "8.        Pinjaman dari badan usaha lain"),
	R_07010101090000 ("07010101090000", "9.        Pinjaman dari orang perseorangan"),
	R_07010101100000 ("07010101100000", "10.     Sekuritisasi aset"),
	R_07010101110000 ("07010101110000", "11.     Penerbitan medium term notes "),
	R_07010101120000 ("07010101120000", "12.     Penerbitan obligasi"),
	R_07010101130000 ("07010101130000", "13.     Pinjaman subordinasi"),
	R_07010101140000 ("07010101140000", "14.     Wakaf"),
	R_07010101150000 ("07010101150000", "15.     Hibah"),
	R_07010101160000 ("07010101160000", "Total Penerimaan Pendanaan Baru"),
//	R_07010102000000 ("07010102000000", "Saldo Penerimaan Pendanaan (Outstanding):"),
	R_07010102010000 ("07010102010000", "1.        Pinjaman dari pemerintah"),
	R_07010102020000 ("07010102020000", "2.        Pinjaman dari badan usaha milik negara atau badan usaha milik daerah"),
	R_07010102030000 ("07010102030000", "3.        Pinjaman dari perusahaan pembiayaan"),
	R_07010102040000 ("07010102040000", "4.        Pinjaman dari lembaga pembiayaan ekspor Indonesia"),
	R_07010102050000 ("07010102050000", "5.        Pinjaman dari bank "),
	R_07010102060000 ("07010102060000", "6.        Pinjaman dari lembaga keuangan lainnya"),
	R_07010102070000 ("07010102070000", "7.        Pinjaman dari lembaga keuangan multilateral"),
	R_07010102080000 ("07010102080000", "8.        Pinjaman dari badan usaha lain"),
	R_07010102090000 ("07010102090000", "9.        Pinjaman dari orang perseorangan"),
	R_07010102100000 ("07010102100000", "10.     Sekuritisasi aset"),
	R_07010102110000 ("07010102110000", "11.     Penerbitan medium term notes "),
	R_07010102120000 ("07010102120000", "12.     Penerbitan obligasi"),
	R_07010102130000 ("07010102130000", "13.     Pinjaman subordinasi"),
	R_07010102140000 ("07010102140000", "14.     Wakaf"),
	R_07010102150000 ("07010102150000", "15.     Hibah"),
	R_07010102160000 ("07010102160000", "Total Saldo Penerimaan Pendanaan (Outstanding)"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2257PosRePmvk070101 eEnum : ER2257PosRePmvk070101.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2257PosRePmvk070101.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2257PosRePmvk070101.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4", getObjects());
	}
	
	public static FieldValidation genValidationField4() {
		return UtilFieldValidation.genEqualsPosFormula("3-2", 0, UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 15, 31 }));
	}

	public static SegmentValidation genValidationTotalPenerimaanPendanaanBaru() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_07010101160000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 14),
				"Total Penerimaan Pendanaan Baru|Penjumlahan Penerimaan Pendanaan Baru");
	}

	public static SegmentValidation genValidationTotalSaldoPenerimaanPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_07010102160000.key,
				UtilMetadata.genPlusRow(getObjects(), 16, 30),
				"Total Saldo Penerimaan Pendanaan (Outstanding)|Penjumlahan Saldo Penerimaan Pendanaan (Outstanding)");
	}
}
