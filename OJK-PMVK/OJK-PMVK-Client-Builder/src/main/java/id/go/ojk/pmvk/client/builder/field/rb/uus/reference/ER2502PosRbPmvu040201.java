package id.go.ojk.pmvk.client.builder.field.rb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pmvk.client.builder.field.EFormRencanaBisnisUus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2502PosRbPmvu040201 implements IObject<KeyValueString> {
//	R_04020101000000 ("04020101000000", "Rencana Pembiayaan/Penyertaan Baru:  "),
	R_04020101010000 ("04020101010000", "Sektor Ekonomi Lapangan Usaha"),
	R_04020101010100 ("04020101010100", "Pertanian, Kehutanan, dan Perikanan"),
	R_04020101010200 ("04020101010200", "Pertambangan dan Penggalian"),
	R_04020101010300 ("04020101010300", "Industri Pengolahan"),
	R_04020101010400 ("04020101010400", "Pengadaan Listrik, Gas, Uap/Air Panas, dan Udara Dingin"),
	R_04020101010500 ("04020101010500", "Pengadaan Air, Pengelolan Air Limbah, Pengelolaan dan Daur Ulang Sampah, dan Aktivitas Remediasi"),
	R_04020101010600 ("04020101010600", "Konstruksi"),
	R_04020101010700 ("04020101010700", "Perdagangan Besar dan Eceran, Reparasi dan Perawatan Mobil dan Sepeda Motor"),
	R_04020101010800 ("04020101010800", "Pengangkutan dan Pergudangan"),
	R_04020101010900 ("04020101010900", "Penyediaan Akomodasi dan Penyediaan Makan Minum"),
	R_04020101011000 ("04020101011000", "Informasi dan Komunikasi"),
	R_04020101011100 ("04020101011100", "Aktivitas Keuangan dan Asuransi"),
	R_04020101011200 ("04020101011200", "Real Estat"),
	R_04020101011300 ("04020101011300", "Aktivitas Profesional, Ilmiah, dan Teknis"),
	R_04020101011400 ("04020101011400", "Aktivitas Penyewaan dan Sewa Guna Usaha Tanpa Hak Opsi, Ketenagakerjaan, Agen Perjalanan, dan Penunjang Usaha Lainnya"),
	R_04020101011500 ("04020101011500", "Administrasi Pemerintahan, Pertahanan, dan Jaminan Sosial Wajib"),
	R_04020101011600 ("04020101011600", "Pendidikan"),
	R_04020101011700 ("04020101011700", "Aktivitas Kesehatan Manusia dan Aktivitas Sosial"),
	R_04020101011800 ("04020101011800", "Kesenian, Hiburan, dan Rekreasi"),
	R_04020101011900 ("04020101011900", "Aktivitas Jasa Lainnya"),
	R_04020101012000 ("04020101012000", "Aktivitas Rumah Tangga sebagai Pemberi Kerja, Aktivitas yang Menghasilkan Barang dan Jasa oleh Rumah Tangga yang Digunakan untuk Memenuhi Kebutuhan Sendiri"),
	R_04020101012100 ("04020101012100", "Aktivitas Badan Internasional dan Badan Ekstra Internasional Lainnya"),
	R_04020101020000 ("04020101020000", "Sektor Ekonomi Bukan Lapangan Usaha"),
	R_04020101020100 ("04020101020100", "Rumah Tangga"),
	R_04020101020200 ("04020101020200", "Bukan Lapangan Usaha Lainnya"),
	R_04020101030000 ("04020101030000", "Total Rencana Penyaluran Pembiayaan Baru"),
//	R_04020102000000 ("04020102000000", "Saldo Posisi (Outstanding Principal):"),
	R_04020102010000 ("04020102010000", "Sektor Ekonomi Lapangan Usaha"),
	R_04020102010100 ("04020102010100", "Pertanian, Kehutanan, dan Perikanan"),
	R_04020102010200 ("04020102010200", "Pertambangan dan Penggalian"),
	R_04020102010300 ("04020102010300", "Industri Pengolahan"),
	R_04020102010400 ("04020102010400", "Pengadaan Listrik, Gas, Uap/Air Panas, dan Udara Dingin"),
	R_04020102010500 ("04020102010500", "Pengadaan Air, Pengelolan Air Limbah, Pengelolaan dan Daur Ulang Sampah, dan Aktivitas Remediasi"),
	R_04020102010600 ("04020102010600", "Konstruksi"),
	R_04020102010700 ("04020102010700", "Perdagangan Besar dan Eceran, Reparasi dan Perawatan Mobil dan Sepeda Motor"),
	R_04020102010800 ("04020102010800", "Pengangkutan dan Pergudangan"),
	R_04020102010900 ("04020102010900", "Penyediaan Akomodasi dan Penyediaan Makan Minum"),
	R_04020102011000 ("04020102011000", "Informasi dan Komunikasi"),
	R_04020102011100 ("04020102011100", "Aktivitas Keuangan dan Asuransi"),
	R_04020102011200 ("04020102011200", "Real Estat"),
	R_04020102011300 ("04020102011300", "Aktivitas Profesional, Ilmiah, dan Teknis"),
	R_04020102011400 ("04020102011400", "Aktivitas Penyewaan dan Sewa Guna Usaha Tanpa Hak Opsi, Ketenagakerjaan, Agen Perjalanan, dan Penunjang Usaha Lainnya"),
	R_04020102011500 ("04020102011500", "Administrasi Pemerintahan, Pertahanan, dan Jaminan Sosial Wajib"),
	R_04020102011600 ("04020102011600", "Pendidikan"),
	R_04020102011700 ("04020102011700", "Aktivitas Kesehatan Manusia dan Aktivitas Sosial"),
	R_04020102011800 ("04020102011800", "Kesenian, Hiburan, dan Rekreasi"),
	R_04020102011900 ("04020102011900", "Aktivitas Jasa Lainnya"),
	R_04020102012000 ("04020102012000", "Aktivitas Rumah Tangga sebagai Pemberi Kerja, Aktivitas yang Menghasilkan Barang dan Jasa oleh Rumah Tangga yang Digunakan untuk Memenuhi Kebutuhan Sendiri"),
	R_04020102012100 ("04020102012100", "Aktivitas Badan Internasional dan Badan Ekstra Internasional Lainnya"),
	R_04020102020000 ("04020102020000", "Sektor Ekonomi Bukan Lapangan Usaha"),
	R_04020102020100 ("04020102020100", "Rumah Tangga"),
	R_04020102020200 ("04020102020200", "Bukan Lapangan Usaha Lainnya"),
	R_04020102030000 ("04020102030000", "Total Saldo Posisi (Outstanding Principal)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2502PosRbPmvu040201 eEnum : ER2502PosRbPmvu040201.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2502PosRbPmvu040201.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2502PosRbPmvu040201.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationSektorEkonomiLapanganUsahaA() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_04020101010000.key, 
				UtilMetadata.genPlusRow(getObjects(), 1, 21),
				"Total Sektor Ekonomi Lapangan Usaha A|Penjumlahan Sektor Ekonomi Lapangan Usaha A");
	}

	public static SegmentValidation genValidationSektorEkonomiBukanLapanganUsahaA() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_04020101020000.key, 
				UtilMetadata.genPlusRow(getObjects(), 23, 24),
				"Total Sektor Ekonomi Bukan Lapangan Usaha A|Penjumlahan Sektor Ekonomi Bukan Lapangan Usaha A");
	}

	public static SegmentValidation genValidationTotalRencanaPenyaluranPembiayaanBaru() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_04020101030000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 22 }),
				"Total Rencana Penyaluran Pembiayaan Baru|Penjumlahan Rencana Penyaluran Pembiayaan Baru");
	}

	public static SegmentValidation genValidationSektorEkonomiLapanganUsahaB() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_04020102010000.key, 
				UtilMetadata.genPlusRow(getObjects(), 27, 47),
				"Total Sektor Ekonomi Lapangan Usaha B|Penjumlahan Sektor Ekonomi Lapangan Usaha B");
	}

	public static SegmentValidation genValidationSektorEkonomiBukanLapanganUsahaB() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_04020102020000.key, 
				UtilMetadata.genPlusRow(getObjects(), 49, 50),
				"Total Sektor Ekonomi Bukan Lapangan Usaha B|Penjumlahan Sektor Ekonomi Bukan Lapangan Usaha B");
	}

	public static SegmentValidation genValidationTotalSaldoPosisi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_04020102030000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 26, 48 }),
				"Total Saldo Posisi (Outstanding Principal)|Penjumlahan Saldo Posisi (Outstanding Principal)");
	}

	public static SegmentValidation genValidationFormTotalRencanaPenyaluranPembiayaanBaru() {
		String comparatorFormCode = EFormRencanaBisnisUus.RB_040102.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_04020101030000.key, comparatorFormCode, 
				ER2501PosRbPmvu040102.R_04010201060000.getKey(), 
				"Total Rencana Penyaluran Pembiayaan Baru|Total Rencana Investasi Modal Ventura Berdasarkan Prinsip Syariah Baru form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormTotalSaldoPosisi() {
		String comparatorFormCode = EFormRencanaBisnisUus.RB_040102.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_04020102030000.key, comparatorFormCode, 
				ER2501PosRbPmvu040102.R_04010202060000.getKey(), 
				"Total Saldo Posisi (Outstanding Principal)|Total Saldo Posisi (Outstanding Principal) form " + comparatorFormCode + " #kolom#");
	}
}
