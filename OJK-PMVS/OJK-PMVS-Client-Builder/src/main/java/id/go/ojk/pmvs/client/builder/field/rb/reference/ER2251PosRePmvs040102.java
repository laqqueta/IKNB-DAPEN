package id.go.ojk.pmvs.client.builder.field.rb.reference;

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
public enum ER2251PosRePmvs040102 implements IObject<KeyValueString> {
//	R_04010201000000 ("04010201000000", "Rencana Investasi Modal Ventura Berdasarkan Prinsip Syariah Baru:"),
	R_04010201010000 ("04010201010000", "Penyertaan Saham (Equity Participation)"),
	R_04010201020000 ("04010201020000", "Pembelian Sukuk atau Obligasi Syariah Konversi "),
	R_04010201030000 ("04010201030000", "Pembelian Sukuk atau Obligasi Syariah yang Diterbitkan Pasangan Usaha pada Tahap Rintisan Awal (Start-up) dan/atau Pengembangan Usaha "),
	R_04010201040000 ("04010201040000", "Pembiayaan Berdasarkan Prinsip Bagi Hasil"),
	R_04010201050000 ("04010201050000", "Kegiatan Usaha Lain Berdasarkan Persetujuan Otoritas Jasa Keuangan"),
	R_04010201060000 ("04010201060000", "Total Rencana Investasi Modal Ventura Berdasarkan Prinsip Syariah Baru"),
//	R_04010202000000 ("04010202000000", "Saldo Posisi (Outstanding Principal):"),
	R_04010202010000 ("04010202010000", "Penyertaan Saham (Equity Participation)"),
	R_04010202020000 ("04010202020000", "Pembelian Sukuk atau Obligasi Syariah Konversi "),
	R_04010202030000 ("04010202030000", "Pembelian Sukuk atau Obligasi Syariah yang Diterbitkan Pasangan Usaha pada Tahap Rintisan Awal (Start-up) dan/atau Pengembangan Usaha  "),
	R_04010202040000 ("04010202040000", "Pembiayaan Berdasarkan Prinsip Bagi Hasil"),
	R_04010202050000 ("04010202050000", "Kegiatan Usaha Lain Berdasarkan Persetujuan Otoritas Jasa Keuangan"),
	R_04010202060000 ("04010202060000", "Total Saldo Posisi (Outstanding Principal)"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2251PosRePmvs040102 eEnum : ER2251PosRePmvs040102.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2251PosRePmvs040102.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2251PosRePmvs040102.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4", getObjects());
	}
	
	public static FieldValidation genValidationSum() {
		return UtilFieldValidation.genEqualsPosFormula("3-2", 2, UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 5, 11 }));
	}

	public static SegmentValidation genValidationTotalRencanaPembiayaanPenyertaanBaru() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_04010201060000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 4),
				"Total Rencana Investasi Modal Ventura Berdasarkan Prinsip Syariah Baru|Penjumlahan Rencana Investasi Modal Ventura Berdasarkan Prinsip Syariah Baru");
	}

	public static SegmentValidation genValidationSaldoPosisi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_04010202060000.key,
				UtilMetadata.genPlusRow(getObjects(), 6, 10),
				"Total Saldo Posisi (Outstanding Principal)|Penjumlahan Saldo Posisi (Outstanding Principal)");
	}
}
