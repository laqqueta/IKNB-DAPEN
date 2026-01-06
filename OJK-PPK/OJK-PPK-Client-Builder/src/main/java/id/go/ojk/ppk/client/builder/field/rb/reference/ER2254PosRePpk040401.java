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
import id.go.ojk.ppk.client.builder.field.EFormRealisasiBisnis;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2254PosRePpk040401 implements IObject<KeyValueString> {
//	R_04040101000000 ("04040101000000", "Rencana Penyaluran Pembiayaan Baru:"),
	R_04040101010000 ("04040101010000", "Sektor Ekonomi Lapangan Usaha"),
	R_04040101010100 ("04040101010100", "Pertanian, Kehutanan, dan Perikanan"),
	R_04040101010200 ("04040101010200", "Pertambangan dan Penggalian"),
	R_04040101010300 ("04040101010300", "Industri Pengolahan"),
	R_04040101010400 ("04040101010400", "Pengadaan Listrik, Gas, Uap/Air Panas, dan Udara Dingin"),
	R_04040101010500 ("04040101010500",
			"Pengadaan Air, Pengelolan Air Limbah, Pengelolaan dan Daur Ulang Sampah, dan Aktivitas Remediasi"),
	R_04040101010600 ("04040101010600", "Konstruksi"),
	R_04040101010700 ("04040101010700", "Perdagangan Besar dan Eceran, Reparasi dan Perawatan Mobil dan Sepeda Motor"),
	R_04040101010800 ("04040101010800", "Pengangkutan dan Perdagangan"),
	R_04040101010900 ("04040101010900", "Penyediaan Akomodasi dan Penyediaan Makan Minum"),
	R_04040101011000 ("04040101011000", "Informasi dan Komunikasi"),
	R_04040101011100 ("04040101011100", "Aktivitas Keuangan dan Asuransi"),
	R_04040101011200 ("04040101011200", "Real Estat"),
	R_04040101011300 ("04040101011300", "Jasa Profesional, Ilmiah, dan Teknis"),
	R_04040101011400 ("04040101011400",
			"Aktivitas Penyewaan dan Sewa Guna Usaha Tanpa Hak Opsi, Ketenagakerjaan, Agen Perjalanan, dan Penunjang Usaha Lainnya"),
	R_04040101011500 ("04040101011500", "Administrasi Pemerintahan, Pertahanan, dan Jaminan Sosial Wajib"),
	R_04040101011600 ("04040101011600", "Pendidikan"),
	R_04040101011700 ("04040101011700", "Aktivitas Kesehatan Manusia dan Aktivitas Sosial"),
	R_04040101011800 ("04040101011800", "Kesenian, Hiburan, dan Rekreasi"),
	R_04040101011900 ("04040101011900", "Aktivitas Jasa Lainnya"),
	R_04040101012000 ("04040101012000",
			"Aktivitas Rumah Tangga sebagai Pemberi Kerja, Aktivitas yang Menghasilkan Barang dan Jasa oleh Rumah Tangga yang Digunakan untuk Memenuhi Kebutuhan Sendiri"),
	R_04040101012100 ("04040101012100", "Aktivitas Badan Internasional dan Badan Ekstra Internasional Lainnya"),
	R_04040101020000 ("04040101020000", "Sektor Ekonomi Bukan Lapangan Usaha"),
	R_04040101020100 ("04040101020100", "Rumah Tangga"),
	R_04040101020200 ("04040101020200", "Bukan Lapangan Usaha Lainnya"),
	R_04040101030000 ("04040101030000", "Total Rencana Penyaluran Pembiayaan Baru"),
//	R_04040102000000 ("04040102000000", "Saldo Piutang Pembiayaan (Outstanding Principal):"),
	R_04040102010000 ("04040102010000", "Sektor Ekonomi Lapangan Usaha"),
	R_04040102010100 ("04040102010100", "Pertanian, Kehutanan, dan Perikanan"),
	R_04040102010200 ("04040102010200", "Pertambangan dan Penggalian"),
	R_04040102010300 ("04040102010300", "Industri Pengolahan"),
	R_04040102010400 ("04040102010400", "Pengadaan Listrik, Gas, Uap/Air Panas, dan Udara Dingin"),
	R_04040102010500 ("04040102010500",
			"Pengadaan Air, Pengelolan Air Limbah, Pengelolaan dan Daur Ulang Sampah, dan Aktivitas Remediasi"),
	R_04040102010600 ("04040102010600", "Konstruksi"),
	R_04040102010700 ("04040102010700", "Perdagangan Besar dan Eceran, Reparasi, dan Perawatan Mobil dan Sepeda Motor"),
	R_04040102010800 ("04040102010800", "Pengangkutan dan Perdagangan"),
	R_04040102010900 ("04040102010900", "Penyediaan Akomodasi dan Penyediaan Makan Minum"),
	R_04040102011000 ("04040102011000", "Informasi dan Komunikasi"),
	R_04040102011100 ("04040102011100", "Aktivitas Keuangan dan Asuransi"),
	R_04040102011200 ("04040102011200", "Real Estat"),
	R_04040102011300 ("04040102011300", "Aktivitas Profesional, Ilmiah, dan Teknis"),
	R_04040102011400 ("04040102011400",
			"Aktivitas Penyewaan dan Sewa Guna Usaha Tanpa Hak Opsi, Ketenagakerjaan, Agen Perjalanan, dan Penunjang Usaha Lainnya"),
	R_04040102011500 ("04040102011500", "Administrasi Pemerintahan, Pertahanan, dan Jaminan Sosial Wajib"),
	R_04040102011600 ("04040102011600", "Pendidikan"),
	R_04040102011700 ("04040102011700", "Aktivitas Kesehatan Manusia dan Aktivitas Sosial"),
	R_04040102011800 ("04040102011800", "Kesenian, Hiburan, dan Rekreasi"),
	R_04040102011900 ("04040102011900", "Aktivitas Jasa Lainnya"),
	R_04040102012000 ("04040102012000",
			"Aktivitas Rumah Tangga sebagai Pemberi Kerja, Aktivitas yang Menghasilkan Barang dan Jasa oleh Rumah Tangga yang Digunakan untuk Memenuhi Kebutuhan Sendiri"),
	R_04040102012100 ("04040102012100", "Aktivitas Badan Internasional dan Badan Ekstra Internasional Lainnya"),
	R_04040102020000 ("04040102020000", "Sektor Ekonomi Bukan Lapangan Usaha"),
	R_04040102020100 ("04040102020100", "Rumah Tangga"),
	R_04040102020200 ("04040102020200", "Bukan Lapangan Usaha Lainnya"),
	R_04040102030000 ("04040102030000", "Total Saldo Piutang Pembiayaan (Outstanding Principal)"),;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2254PosRePpk040401 eEnum : ER2254PosRePpk040401.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2254PosRePpk040401.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2254PosRePpk040401.class.getSimpleName().substring(2, 6));
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

	public static SegmentValidation genValidationFormRencanaPenyaluranPembiayaanBaru() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_040101.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_04040101030000.key, comparatorFormCode, 
				ER2251PosRePpk040101.R_04010101050000.getKey(), 
				"Total Rencana Penyaluran Pembiayaan Baru|Total Rencana Penyaluran Pembiayaan Baru form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormSaldoPiutangPembiayaan() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_040101.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_04040102030000.key, comparatorFormCode, 
				ER2251PosRePpk040101.R_04010102050000.getKey(), 
				"Total Saldo Piutang Pembiayaan|Total Saldo Piutang Pembiayaan form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationTotalSektorEkonomiLapanganUsahaA() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04040101010000.key,
				UtilMetadata.genPlusRow(getObjects(), 1, 21),
				"Total Sektor Ekonomi Lapangan Usaha|Penjumlahan Sektor Ekonomi Lapangan Usaha");
	}

	public static SegmentValidation genValidationTotalSektorEkonomiBukanLapanganUsahaA() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04040101020000.key,
				R_04040101020100.key + "+" + R_04040101020200.key,
				"Total Sektor Ekonomi Bukan Lapangan Usaha|Penjumlahan Sektor Ekonomi Bukan Lapangan Usaha");
	}

	public static SegmentValidation genValidationTotalRencanaPenyaluranPembiayaanBaru() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04040101030000.key,
				R_04040101010000.key + "+" + R_04040101020000.key,
				"Total Rencana Penyaluran Pembiayaan Baru|Penjumlahan Rencana Penyaluran Pembiayaan Baru");
	}

	public static SegmentValidation genValidationTotalSektorEkonomiLapanganUsahaB() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04040102010000.key, 
				UtilMetadata.genPlusRow(getObjects(), 27, 47),
				"Total Sektor Ekonomi Lapangan Usaha|Penjumlahan Sektor Ekonomi Lapangan Usaha");
	}

	public static SegmentValidation genValidationTotalSektorEkonomiBukanLapanganUsahaB() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04040102020000.key,
				R_04040102020100.key + "+" + R_04040102020200.key,
				"Total Sektor Ekonomi Bukan Lapangan Usaha|Penjumlahan Sektor Ekonomi Bukan Lapangan Usaha");
	}

	public static SegmentValidation genValidationTotalSaldoPiutangPembiayaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04040102030000.key,
				R_04040102010000.key + "+" + R_04040102020000.key,
				"Total Saldo Piutang Pembiayaan|Penjumlahan Saldo Piutang Pembiayaan");
	}
}
