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
public enum ER2251PosRePmvk040101 implements IObject<KeyValueString> {
//	R_04010101000000 ("04010101000000", "Rencana Pembiayaan/Penyertaan Baru:"),
	R_04010101010000 ("04010101010000", "Penyertaan Saham (Equity Participation)"),
	R_04010101020000 ("04010101020000", "Penyertaan Melalui Pembelian Obligasi Konversi (Quasi Equity Participation) "),
	R_04010101030000 ("04010101030000", "Pembiayaan Melalui Pembelian Surat Utang yang Diterbitkan Pasangan Usaha pada Tahap Rintisan Awal (Start-up) dan/atau Pengembangan Usaha "),
	R_04010101040000 ("04010101040000", "Pembiayaan Usaha Produktif"),
	R_04010101050000 ("04010101050000", "Kegiatan Usaha Lain Berdasarkan Persetujuan Otoritas Jasa Keuangan"),
	R_04010101060000 ("04010101060000", "Total Rencana Pembiayaan/Penyertaan Baru"),
//	R_04010102000000 ("04010102000000", "Saldo Posisi (Outstanding Principal):"),
	R_04010102010000 ("04010102010000", "Penyertaan Saham (Equity Participation)"),
	R_04010102020000 ("04010102020000", "Penyertaan Melalui Pembelian Obligasi Konversi (Quasi Equity Participation) "),
	R_04010102030000 ("04010102030000", "Pembiayaan Melalui Pembelian Surat Utang yang Diterbitkan Pasangan Usaha pada Tahap Rintisan Awal (Start-up) dan/atau Pengembangan Usaha "),
	R_04010102040000 ("04010102040000", "Pembiayaan Usaha Produktif"),
	R_04010102050000 ("04010102050000", "Kegiatan Usaha Lain Berdasarkan Persetujuan Otoritas Jasa Keuangan"),
	R_04010102060000 ("04010102060000", "Total Saldo Posisi (Outstanding Principal)"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2251PosRePmvk040101 eEnum : ER2251PosRePmvk040101.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2251PosRePmvk040101.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2251PosRePmvk040101.class.getSimpleName().substring(2, 6));
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
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_04010101060000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 4),
				"Total Rencana Pembiayaan/Penyertaan Baru|Penjumlahan Rencana Pembiayaan/Penyertaan Baru");
	}

	public static SegmentValidation genValidationSaldoPosisi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_04010102060000.key,
				UtilMetadata.genPlusRow(getObjects(), 6, 10),
				"Total Saldo Posisi (Outstanding Principal)|Penjumlahan Saldo Posisi (Outstanding Principal)");
	}
}
