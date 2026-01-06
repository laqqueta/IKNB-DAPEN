package id.go.ojk.pmvk.client.builder.field.rb.uus.reference;

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
public enum ER2757PosRePmvu070102 implements IObject<KeyValueString> {
//	R_07010201000000 ("07010201000000", "Penerimaan Pendanaan Baru:"),
	R_07010201010000 ("07010201010000", "1.        Pendanaan dari pemerintah"),
	R_07010201020000 ("07010201020000", "2.        Pendanaan dari badan usaha milik negara atau badan usaha milik daerah"),
	R_07010201030000 ("07010201030000", "3.        Pendanaan dari perusahaan pembiayaan"),
	R_07010201040000 ("07010201040000", "4.        Pendanaan dari lembaga pembiayaan ekspor Indonesia"),
	R_07010201050000 ("07010201050000", "5.        Pendanaan dari bank "),
	R_07010201060000 ("07010201060000", "6.        Pendanaan dari lembaga keuangan lainnya"),
	R_07010201070000 ("07010201070000", "7.        Pendanaan dari lembaga keuangan multilateral"),
	R_07010201080000 ("07010201080000", "8.        Pendanaan dari badan usaha lain"),
	R_07010201090000 ("07010201090000", "9.        Pendanaan dari orang perseorangan"),
	R_07010201100000 ("07010201100000", "10.       Sekuritisasi aset"),
	R_07010201110000 ("07010201110000", "11.        Penerbitan medium term notes "),
	R_07010201120000 ("07010201120000", "12.        Penerbitan obligasi"),
	R_07010201130000 ("07010201130000", "13.        Pendanaan subordinasi"),
	R_07010201140000 ("07010201140000", "14.        Wakaf"),
	R_07010201150000 ("07010201150000", "15.        Hibah"),
	R_07010201160000 ("07010201160000", "Total Penerimaan Pendanaan Baru"),
//	R_07010202000000 ("07010202000000", "Saldo Penerimaan Pendanaan (Outstanding):"),
	R_07010202010000 ("07010202010000", "1.        Pendanaan dari pemerintah"),
	R_07010202020000 ("07010202020000", "2.        Pendanaan dari badan usaha milik negara atau badan usaha milik daerah"),
	R_07010202030000 ("07010202030000", "3.        Pendanaan dari perusahaan pembiayaan"),
	R_07010202040000 ("07010202040000", "4.        Pendanaan dari lembaga pembiayaan ekspor Indonesia"),
	R_07010202050000 ("07010202050000", "5.        Pendanaan dari bank "),
	R_07010202060000 ("07010202060000", "6.        Pendanaan dari lembaga keuangan lainnya"),
	R_07010202070000 ("07010202070000", "7.        Pendanaan dari lembaga keuangan multilateral"),
	R_07010202080000 ("07010202080000", "8.        Pendanaan dari badan usaha lain"),
	R_07010202090000 ("07010202090000", "9.        Pendanaan dari orang perseorangan"),
	R_07010202100000 ("07010202100000", "10.       Sekuritisasi aset"),
	R_07010202110000 ("07010202110000", "11.        Penerbitan medium term notes "),
	R_07010202120000 ("07010202120000", "12.        Penerbitan obligasi"),
	R_07010202130000 ("07010202130000", "13.        Pendanaan subordinasi"),
	R_07010202140000 ("07010202140000", "14.        Wakaf"),
	R_07010202150000 ("07010202150000", "15.        Hibah"),
	R_07010202160000 ("07010202160000", "Total Saldo Penerimaan Pendanaan (Outstanding)"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2757PosRePmvu070102 eEnum : ER2757PosRePmvu070102.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2757PosRePmvu070102.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2757PosRePmvu070102.class.getSimpleName().substring(2, 6));
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
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_07010201160000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 14),
				"Total Penerimaan Pendanaan Baru|Penjumlahan Penerimaan Pendanaan Baru");
	}

	public static SegmentValidation genValidationTotalSaldoPenerimaanPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_07010202160000.key,
				UtilMetadata.genPlusRow(getObjects(), 16, 30),
				"Total Saldo Penerimaan Pendanaan (Outstanding)|Penjumlahan Saldo Penerimaan Pendanaan (Outstanding)");
	}
}
