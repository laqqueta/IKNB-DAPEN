package id.go.ojk.ppk.client.builder.field.rb.reference;

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
public enum ER2251PosRePpk040101 implements IObject<KeyValueString> {
//	R_04010101000000 ("04010101000000", "Rencana Penyaluran Pembiayaan Baru:"),
	R_04010101010000 ("04010101010000", "Pembiayaan Investasi"), 
	R_04010101010100 ("04010101010100", "Sewa Pembiayaan"),
	R_04010101010200 ("04010101010200", "Jual dan Sewa-Balik"),
	R_04010101010300 ("04010101010300", "Anjak Piutang dengan Pemberian Jaminan dari Penjual Piutang"),
	R_04010101010400 ("04010101010400", "Anjak Piutang tanpa Pemberian Jaminan dari Penjual Piutang"),
	R_04010101010500 ("04010101010500", "Pembelian dengan Pembayaran secara Angsuran"),
	R_04010101010600 ("04010101010600", "Pembiayaan Proyek"),
	R_04010101010700 ("04010101010700", "Pembiayaan Infrastruktur"),
	R_04010101010800 ("04010101010800",
			"Pembiayaan Lain Setelah Terlebih Dahulu Mendapatkan Persetujuan dari Otoritas Jasa Keuangan"),
	R_04010101020000 ("04010101020000", "Pembiayaan Modal Kerja"),
	R_04010101020100 ("04010101020100", "Jual dan Sewa-Balik"),
	R_04010101020200 ("04010101020200", "Anjak Piutang dengan Pemberian Jaminan dari Penjual Piutang"),
	R_04010101020300 ("04010101020300", "Anjak Piutang tanpa Pemberian Jaminan dari Penjual Piutang"),
	R_04010101020400 ("04010101020400", "Fasilitas Modal Usaha"),
	R_04010101020500 ("04010101020500",
			"Pembiayaan Lain Setelah Terlebih Dahulu Mendapatkan Persetujuan dari Otoritas Jasa Keuangan"),
	R_04010101030000 ("04010101030000", "Pembiayaan Multiguna"), 
	R_04010101030100 ("04010101030100", "Sewa Pembiayaan"),
	R_04010101030200 ("04010101030200", "Pembelian dengan Pembayaran secara Angsuran"),
	R_04010101030300 ("04010101030300", "Fasilitas Dana"),
	R_04010101030400 ("04010101030400",
			"Pembiayaan Lain Setelah Terlebih Dahulu Mendapatkan Persetujuan dari Otoritas Jasa Keuangan"),
	R_04010101040000 ("04010101040000", "Kegiatan Usaha Pembiayaan Lain Berdasarkan Persetujuan Otoritas Jasa Keuangan"),
	R_04010101060000 ("04010101060000", "Pembiayaan Berdasarkan Prinsip Syariah"),
	R_04010101050000 ("04010101050000", "Total Rencana Penyaluran Pembiayaan Baru"),
//	R_04010102000000 ("04010102000000", "Saldo Piutang Pembiayaan (Outstanding Principal):"),
	R_04010102010000 ("04010102010000", "Pembiayaan Investasi"), 
	R_04010102010100 ("04010102010100", "Sewa Pembiayaan"),
	R_04010102010200 ("04010102010200", "Jual dan Sewa-Balik"),
	R_04010102010300 ("04010102010300", "Anjak Piutang dengan Pemberian Jaminan dari Penjual Piutang"),
	R_04010102010400 ("04010102010400", "Anjak Piutang tanpa Pemberian Jaminan dari Penjual Piutang"),
	R_04010102010500 ("04010102010500", "Pembelian dengan Pembayaran secara Angsuran"),
	R_04010102010600 ("04010102010600", "Pembiayaan Proyek"),
	R_04010102010700 ("04010102010700", "Pembiayaan Infrastruktur"),
	R_04010102010800 ("04010102010800",
			"Pembiayaan Lain Setelah Terlebih Dahulu Mendapatkan Persetujuan dari Otoritas Jasa Keuangan"),
	R_04010102020000 ("04010102020000", "Pembiayaan Modal Kerja"),
	R_04010102020100 ("04010102020100", "Jual dan Sewa-Balik"),
	R_04010102020200 ("04010102020200", "Anjak Piutang dengan Pemberian Jaminan dari Penjual Piutang"),
	R_04010102020300 ("04010102020300", "Anjak Piutang tanpa Pemberian Jaminan dari Penjual Piutang"),
	R_04010102020400 ("04010102020400", "Fasilitas Modal Usaha"),
	R_04010102020500 ("04010102020500",
			"Pembiayaan Lain Setelah Terlebih Dahulu Mendapatkan Persetujuan dari Otoritas Jasa Keuangan"),
	R_04010102030000 ("04010102030000", "Pembiayaan Multiguna"), 
	R_04010102030100 ("04010102030100", "Sewa Pembiayaan"),
	R_04010102030200 ("04010102030200", "Pembelian dengan Pembayaran secara Angsuran"),
	R_04010102030300 ("04010102030300", "Fasilitas Dana"),
	R_04010102030400 ("04010102030400",
			"Pembiayaan Lain Setelah Terlebih Dahulu Mendapatkan Persetujuan dari Otoritas Jasa Keuangan"),
	R_04010102040000 ("04010102040000", "Kegiatan Usaha Pembiayaan Lain Berdasarkan Persetujuan Otoritas Jasa Keuangan"),
	R_04010102060000 ("04010102060000", "Pembiayaan Berdasarkan Prinsip Syariah"),
	R_04010102050000 ("04010102050000", "Total Saldo Piutang Pembiayaan (Outstanding Principal)"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2251PosRePpk040101 eEnum : ER2251PosRePpk040101.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2251PosRePpk040101.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2251PosRePpk040101.class.getSimpleName().substring(2, 6));
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

	public static SegmentValidation genValidationPembiayaanInvestasiA() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010101010000.key,
				UtilMetadata.genPlusRow(getObjects(), 1, 8),
				"Total Pembiayaan Investasi|Penjumlahan Pembiayaan Investasi");
	}

	public static SegmentValidation genValidationPembiayaanModalKerjaA() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010101020000.key,
				UtilMetadata.genPlusRow(getObjects(), 10, 14),
				"Total Pembiayaan Modal Kerja|Penjumlahan Pembiayaan Modal Kerja");
	}

	public static SegmentValidation genValidationPembiayaanMultigunaA() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010101030000.key,
				UtilMetadata.genPlusRow(getObjects(), 16, 19),
				"Total Pembiayaan Multiguna|Penjumlahan Pembiayaan Multiguna");
	}

	public static SegmentValidation genValidationTotalRencanaPenyaluranPembiayaanBaru() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010101050000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 9, 15, 20, 21 }),
				"Total Rencana Penyaluran Pembiayaan Baru|Penjumlahan Rencana Penyaluran Pembiayaan Baru");
	}

	public static SegmentValidation genValidationPembiayaanInvestasiB() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010102010000.key,
				UtilMetadata.genPlusRow(getObjects(), 24, 31),
				"Total Pembiayaan Investasi|Penjumlahan Pembiayaan Investasi");
	}

	public static SegmentValidation genValidationPembiayaanModalKerjaB() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010102020000.key,
				UtilMetadata.genPlusRow(getObjects(), 33, 37),
				"Total Pembiayaan Modal Kerja|Penjumlahan Pembiayaan Modal Kerja");
	}

	public static SegmentValidation genValidationPembiayaanMultigunaB() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010102030000.key,
				UtilMetadata.genPlusRow(getObjects(), 39, 42),
				"Total Pembiayaan Multiguna|Penjumlahan Pembiayaan Multiguna");
	}

	public static SegmentValidation genValidationTotalSaldoPiutangPembiayaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010102050000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 23, 32, 38, 43, 44 }),
				"Total Saldo Piutang Pembiayaan|Penjumlahan Saldo Piutang Pembiayaan");
	}
}
