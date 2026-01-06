package id.go.ojk.asruk.client.builder.field.lb.reference;

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
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3008PosLbAsruk400 implements IObject<KeyValueString> {
//	R_3410000099 ("3410000099", "Ekuitas SAK"),
	R_3410000000 ("3410000000", "Saldo Awal"),
//	R_3411000000 ("3411000000", "Penambahan:"),
	R_3401000000 ("3401000000", "Modal Disetor"),
	R_3403040000 ("3403040000", "Laba (Rugi) Komprehensif Periode Berjalan"),
//	R_3411990099 ("3411990099", "Penambahan Lainnya:"),
	R_3411990100 ("3411990100", "Penambahan Lainnya"),
	R_3411990000 ("3411990000", "Jumlah Penambahan"),
//	R_3412000001 ("3412000001", "Pengurangan:"),
	R_3412010000 ("3412010000", "Pembayaran Dividen"),
//	R_3412990001 ("3412990001", "Pengurangan Lainnya:"),
	R_3412990100 ("3412990100", "Pengurangan Lainnya"),
	R_3412990000 ("3412990000", "Jumlah Pengurangan"),
	R_3411000099 ("3411000099", "Saldo Akhir SAK "),
//	R_3420000099 ("3420000099", "Ekuitas SAP"),
	R_3420000000 ("3420000000", "Saldo Awal "),
	R_3412000000 ("3412000000", "Perubahan Ekuitas SAK "),
	R_3421000000 ("3421000000", "Kenaikan (penurunan) Selisih Penilaian SAK dan SAP"),
	R_3422000000 ("3422000000", "(Kenaikan) penurunan Aset Yang Tidak Termasuk AYD"),
	R_3423000000 ("3423000000", "Saldo Akhir SAP"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3008PosLbAsruk400 eEnum : ER3008PosLbAsruk400.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 4, 5, 7, 8, 9, 10, 11, 12, 13 });
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3|4", getObjects());
	}

	public static ConditionalRequired genConditionalExistPos2() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 3, 6 }));
	}

	public static SegmentValidation genValidationPenambahan() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_3411990000.key, 
				UtilMetadata.genPlusRow(getObjects(), 1, 3),
				"Total penambahan|Penjumlahan penambahan");
	}
	
	public static SegmentValidation genValidationPengurangan() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_3412990000.key, 
				UtilMetadata.genPlusRow(getObjects(), 5, 6),
				"Total pengurangan|Penjumlahan pengurangan");
	}
	
	public static SegmentValidation genValidationPerubahanEkuitasSAK() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_3412000000.key, 
				R_3411000099.key + "-" + R_3410000000.key, 
				"Total perubahan ekuitas SAK|Perhitungan perubahan ekuitas SAK");
	}

	public static SegmentValidation genValidationSaldoAkhirSAK() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_3411000099.key, 
				R_3410000000.key + "+" + R_3411990000.key + "-" + R_3412990000.key, 
				"Total saldo akhir SAK|Perhitungan saldo akhir SAK");
	}
	
	public static SegmentValidation genValidationSaldoAkhirSAP() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_3423000000.key, 
				R_3420000000.key + "+" + R_3412000000.key + "+" + R_3421000000.key + "-" + R_3422000000.key, 
				"Total saldo akhir SAP|Perhitungan saldo akhir SAP");
	}
}
