package id.go.ojk.asrjk.client.builder.field.sa.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1099Peringkat;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4101PosSaAsrju0202 implements IObject<KeyValueString> {
//	R_02020100000000 ("02020100000000", "Tabel II.B.1: Parameter atau Indikator Penilaian Risiko Inheren untuk Risiko Operasional "),
//	R_02020101000000 ("02020101000000", "I Kuantitatif"),
	R_02020101010000 ("02020101010000", "1.  Pertumbuhan kontribusi bruto"),
	R_02020101020000 ("02020101020000", "2.  Rasio tagihan kontribusi terhadap kontribusi bruto"),
	R_02020101030000 ("02020101030000", "3.  Pertumbuhan beban usaha"),
	R_02020101040000 ("02020101040000", "4.  Rasio beban komisi terhadap kontribusi dana perusahaan (ujrah)"),
	R_02020101050000 ("02020101050000", "5.  Rasio jumlah biaya operasional yang dikeluarkan kepada afiliasi dibandingkan dengan total biaya operasional"),
//	R_02020101060000 ("02020101060000", "6.  Pertumbuhan risiko Operasional (dari DTMBR dan MMBR)"),
	R_02020101060100 ("02020101060100", "a. Dana Tabarru"),
	R_02020101060200 ("02020101060200", "b. Dana Perusahaan"),
	R_02020101070000 ("02020101070000", "7.  Jumlah riwayat kecurangan (fraud) internal dan eksternal"),
	R_02020101080000 ("02020101080000", "8.  Jumlah kejadian gangguan sistem teknologi informasi yang mengakibatkan kegagalan proses transaksi"),
	R_02020101090000 ("02020101090000", "9. Rasio turnover pegawai"),
	R_02020101100000 ("02020101100000", "10. Rata-rata jumlah karyawan"),
	R_02020101110000 ("02020101110000", "11.  Rasio biaya (expense ratio)"),
//	R_02020102000000 ("02020102000000", "II Kualitatif"),
//	R_02020102010000 ("02020102010000", "1.  Karakteristik dan kompleksitas usaha Perusahaan"),
	R_02020102010100 ("02020102010100", " a. Skala usaha dan struktur organisasi Perusahaan;"),
	R_02020102010200 ("02020102010200", " b. Kompleksitas proses bisnis dan keragaman produk/jasa;"),
	R_02020102010300 ("02020102010300", " c. Aksi korporasi (corporate action) dan pengembangan bisnis baru"),
	R_02020102010400 ("02020102010400", " d. Penggunaan jasa pihak ketiga (outsourcing)"),
//	R_02020102020000 ("02020102020000", "2.  Sumber Daya Manusia (SDM)"),
	R_02020102020100 ("02020102020100", " a. Penerapan manajemen sumber daya manusia"),
	R_02020102020200 ("02020102020200", " b. Kegagalan karena faktor manusia (human error)"),
//	R_02020102030000 ("02020102030000", "3.  Teknologi informasi dan infrastruktur pendukung."),
	R_02020102030100 ("02020102030100", " a. Kompleksitas teknologi informasi."),
	R_02020102030200 ("02020102030200", " b. Perubahan sistem teknologi informasi."),
	R_02020102030300 ("02020102030300", " c. Kerentanan sistem teknologi informasi terhadap ancaman dan serangan teknologi informasi."),
	R_02020102030400 ("02020102030400", " d. Maturity sistem teknologi informasi"),
	R_02020102030500 ("02020102030500", " e. Kegagalan sistem teknologi informasi"),
	R_02020102030600 ("02020102030600", " f. Keandalan infrastruktur pendukung"),
//	R_02020102040000 ("02020102040000", "4.  Risiko kecurangan (fraud)"),
	R_02020102040100 ("02020102040100", " a. Riwayat kecurangan (fraud) internal"),
	R_02020102040200 ("02020102040200", " b. Riwayat kecurangan (fraud) eksternal."),
//	R_02020102050000 ("02020102050000", "5.  Kejadian Eksternal"),
	R_02020102050100 ("02020102050100", " a. Frekuensi dan materialitas kejadian eksternal. (antara lain: terorisme, kriminalitas, pandemik, dan bencana alam) "),
	R_02020102050200 ("02020102050200", " b. Lokasi dan kondisi geografis Perusahaan "),
//	R_02020102060000 ("02020102060000", "6.  Sistem Administrasi"),
	R_02020102060100 ("02020102060100", " a. Sistem dan prosedur administrasi"),
	R_02020102060200 ("02020102060200", " b. Tingkat kesalahan/penyimpangan prosedur administrasi."),
	R_02020102060300 ("02020102060300", " c. Tingkat penyimpangan Service Level Agreement (SLA) proses administrasi."),
	R_02020102060400 ("02020102060400", " d. Tingkat interaksi dan ketergantungan Perusahaan (khusus untuk Perusahaan Asuransi Syariah, Perusahaan Reasuransi Syariah, dan Unit Syariah)"),
//	R_02020200000000 ("02020200000000", "Tabel II.B.2: Tingkat Risiko Inheren untuk Risiko Operasional "),
	R_02020201000000 ("02020201000000", "Tingkat Risiko Inheren untuk Risiko Operasional"),
//	R_02020300000000 ("02020300000000", "Tabel II.B.3: Kualitas Penerapan Manajemen Risiko untuk Risiko Operasional "),
	R_02020301000000 ("02020301000000", "Kualitas Penerapan Manajemen Risiko untuk Risiko Operasional"),
//	R_02020302000000 ("02020302000000", "Tingkat Risiko Operasional "),
	R_02020303000000 ("02020303000000", "Tingkat Risiko Operasional Net Risk"),
	R_02020400000000 ("02020400000000", "ANALISIS"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4101PosSaAsrju0202 eEnum : ER4101PosSaAsrju0202.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER4101PosSaAsrju0202.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER4101PosSaAsrju0202.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 3, 4, 5, 6, 9, 10, 11 }));
	}
	
	public static SegmentValidation genValidationMaxLengthNumericDot() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 3, 4, 5, 8, 9 }), 10);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 7, 8, 32, 33, 34 }));
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric1() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 7, 8 }), 10);
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric2() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 32, 34), 1);
	}
	
	public static SegmentValidation genValidationPeringkat() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), 32, 34), ER1099Peringkat.getPipedKey());
	}
}
