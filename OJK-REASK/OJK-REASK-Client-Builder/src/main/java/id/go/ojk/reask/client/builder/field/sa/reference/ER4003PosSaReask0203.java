package id.go.ojk.reask.client.builder.field.sa.reference;

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
public enum ER4003PosSaReask0203 implements IObject<KeyValueString> {
//	R_02030100000000 ("02030100000000", "Tabel II.C.1: Parameter atau Indikator Penilaian Risiko Inheren untuk Risiko Asuransi"),
//	R_02030101000000 ("02030101000000", "I. Kuantitatif "),
	R_02030101010000 ("02030101010000", "1.  Rasio premi neto terhadap modal sendiri "),
//	R_02030101020000 ("02030101020000", "2.  Rasio klaim terhadap premi"),
	R_02030101020100 ("02030101020100", " a. Rasio klaim bruto terhadap premi bruto"),
	R_02030101020200 ("02030101020200", " b. Rasio klaim neto terhadap premi neto"),
	R_02030101030000 ("02030101030000", "3.  Rasio cadangan teknis terhadap premi neto"),
	R_02030101040000 ("02030101040000", "4.  Lapse ratio"),
	R_02030101050000 ("02030101050000", "5.  Retention ratio"),
	R_02030101060000 ("02030101060000", "6.  Rasio pertumbuhan bisnis baru"),
	R_02030101070000 ("02030101070000", "7.  Rasio pertumbuhan cadangan teknis"),
	R_02030101080000 ("02030101080000", "8.  Pertumbuhan risiko asuransi (dari MMBR)"),
	R_02030101090000 ("02030101090000", "9.  Loss ratio dari bisnis utama"),
	R_02030101100000 ("02030101100000", "10.  Rasio imbal hasil terbesar yang digaransi/rata-rata imbal hasil 3 (tiga) tahun terakhir"),
	R_02030101110000 ("02030101110000", "11.  Rasio kecukupan premi dan hasil investasi terhadap pembayaran klaim dan biaya umum"),
//	R_02030102000000 ("02030102000000", "II Kualitatif"),
//	R_02030102010000 ("02030102010000", "1.  Underwriting"),
	R_02030102010100 ("02030102010100", " a. infrastruktur underwriting;"),
	R_02030102010200 ("02030102010200", " b. kualitas data/informasi"),
	R_02030102010300 ("02030102010300", " c. alih daya fungsi underwriting"),
//	R_02030102020000 ("02030102020000", "2.  Penetapan premi /kontribusi"),
	R_02030102020100 ("02030102020100", "a. asumsi aktuaria; b. estimasi klaim; c. target tingkat keuntungan; d. tujuan dan hasil investasi; e. jaminan yang diberikan; f. kemampuan dan standar underwriting; g. kebijakan klaim; h. tingkat hasil investasi; i. estimasi volume penjualan dan komisi; j. biaya operasional seperti biaya administrasi, biaya manajemen dan biaya hukum; k. strategi reasuransi; l. alokasi modal dan tingkat pengembalian yang diharapkan; m. tingkat pemutusan polis; n. ketentuan perpajakan; o. tingkat inflasi, dan p. faktor-faktor lain seperti biaya sistem (teknologi informasi), biaya pemasaran dan biaya promosi."),
//	R_02030102030000 ("02030102030000", "3.  Struktur Reasuransi "),
	R_02030102030100 ("02030102030100", " Jenis perjanjian reasuransi dapat dikategorikan menjadi treaty dan fakultatif, sedangkan program reasuransi treaty dapat dilakukan secara proporsional atau non proporsional."),
//	R_02030102040000 ("02030102040000", "4.  Klaim"),
	R_02030102040100 ("02030102040100", " a. infrastruktur klaim"),
	R_02030102040200 ("02030102040200", " b. peran dan kerjasama Perusahaan Reasuransi dan Perusahaan Reasuransi Syariah"),
	R_02030102040300 ("02030102040300", " c. alih daya fungsi klaim"),
//	R_02030102050000 ("02030102050000", "5.  Pemantauan kinerja produk asuransi"),
	R_02030102050100 ("02030102050100", " a. Pemantauan kinerja setiap produk asuransi"),
	R_02030102050200 ("02030102050200", " b. Evaluasi pemantauan atas kinerja setiap produk asuransi"),
//	R_02030102060000 ("02030102060000", "6.  Risiko terhadap produk "),
	R_02030102060100 ("02030102060100", " a. Desain produk: 1) lini usaha/jenis produk yang akan dikembangkan; 2) penilaian risiko produk; 3) modifikasi produk; 4) ketentuan polis (policy wording); dan 5) dukungan reasuransi."),
	R_02030102060200 ("02030102060200", " b. Produk tradisional (produk asuransi yang tidak dikaitkan dengan investasi) atau paydi (produk tradisional yang memberikan manfaat investasi)"),
	R_02030102070000 ("02030102070000", "7.  Saluran Pemasaran"),
//	R_02030102080000 ("02030102080000", "8.  Risiko liabilitas"),
	R_02030102080100 ("02030102080100", " a. penggunaan metode dan asumsi dalam pembentukan cadangan/penyisihan teknis"),
	R_02030102080200 ("02030102080200", " b. perbedaan antara beban klaim yang terjadi dan beban klaim yang diperkirakan"),
//	R_02030102090000 ("02030102090000", "9.  Sifat bisnis asuransi"),
	R_02030102090100 ("02030102090100", " a. produk short tail dan long tail"),
	R_02030102090200 ("02030102090200", " b. pertanggungan jangka pendek dan pertanggungan jangka panjang"),
	R_02030102090300 ("02030102090300", " c. tingkat hazard dari bisnis yang ditanggung"),
	R_02030102090400 ("02030102090400", " d. penggunaan jasa pihak ketiga untuk proses underwriting dan klaim"),
//	R_02030102100000 ("02030102100000", "10.  Komposisi dan diversifikasi portofolio bisnis"),
	R_02030102100100 ("02030102100100", " a. diversifikasi bisnis"),
	R_02030102100200 ("02030102100200", " b. segmentasi pasar"),
	R_02030102110000 ("02030102110000", "11.  Wilayah geografi"),
//	R_02030200000000 ("02030200000000", "Tabel II.C.2: Tingkat Risiko Inheren untuk Risiko Asuransi"),
	R_02030201000000 ("02030201000000", "Tingkat Risiko Inheren untuk Risiko Asuransi"),
//	R_02030300000000 ("02030300000000", "Tabel II.C.3: Kualitas Penerapan Manajemen Risiko untuk Risiko Asuransi"),
	R_02030301000000 ("02030301000000", "Kualitas Penerapan Manajemen Risiko untuk Risiko Asuransi"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4003PosSaReask0203 eEnum : ER4003PosSaReask0203.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationNumericDotNegative() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2", UtilMetadata.genPipeRow(getObjects(), 0, 11));
	}
	
	public static SegmentValidation genValidationMaxLengthNumericDotNegative() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 0, 11), 8);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 34, 35 }));
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 34, 35 }), 1);
	}
	
	public static SegmentValidation genValidationPeringkat() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 34, 35 }), ER1099Peringkat.getPipedKey());
	}
}
