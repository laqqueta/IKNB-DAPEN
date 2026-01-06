package id.go.ojk.reask.client.builder.field.sa.uus.reference;

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
public enum ER4100PosSaReasu0201 implements IObject<KeyValueString> {
//	R_02010100000000 ("02010100000000", "Tabel II.A.1: Parameter atau Indikator Penilaian Risiko Inheren untuk Risiko Strategis"),
//	R_02010101000000 ("02010101000000", "I Kuantitatif"),
//	R_02010101010000 ("02010101010000", "1. Rasio perbandingan realisasi terhadap target"),
	R_02010101010100 ("02010101010100", " a. Kontribusi Bruto"),
	R_02010101010200 ("02010101010200", " b. Klaim"),
	R_02010101010300 ("02010101010300", " c. Surplus/Defisit Underwriting"),
	R_02010101010400 ("02010101010400", " d. Hasil Investasi"),
	R_02010101010500 ("02010101010500", " e. Laba Usaha Dana Perusahaan"),
	R_02010101020000 ("02010101020000", "2. Realisasi pengembangan produk baru terhadap target"),
	R_02010101030000 ("02010101030000", "3. Realisasi pengembangan jaringan kantor terhadap target"),
	R_02010101040000 ("02010101040000", "4. Pertumbuhan kontribusi bruto polis baru"),
	R_02010101050000 ("02010101050000", "5. Rasio pertumbuhan laba dana perusahaan dari kontribusi dana perusahaan bisnis utama"),
//	R_02010102000000 ("02010102000000", "II. Kualitatif"),
//	R_02010102010000 ("02010102010000", "1.  Kesesuaian strategi bisnis dengan visi misi Perusahaan serta kondisi lingkungan usaha"),
	R_02010102010100 ("02010102010100", " a. Tahapan atau mekanisme penyusunan rencana strategis oleh Direksi."),
	R_02010102010200 ("02010102010200", " b. Pemahaman Direksi atas keseluruhan rencana strategis Perusahaan."),
	R_02010102010300 ("02010102010300", " c. Proses Perusahaan dalam melakukan formulasi strategi bisnis serta perubahan strategi bisnis yang dilakukan (jika ada)."),
	R_02010102010400 ("02010102010400", " d. Strategi alternatif (kontinjen/emergent strategy) dalam hal terjadi perubahan lingkungan bisnis yang telah diantisipasi."),
	R_02010102010500 ("02010102010500", " e. Pertimbangan faktor internal dan eksternal bisnis dalam rangka penetapan tujuan strategis Perusahaan."),
//	R_02010102020000 ("02010102020000", "2.  Pilihan Tingkat Strategi bisnis, yaitu: strategi berisiko tinggi dan strategi berisiko rendah"),
	R_02010102020100 ("02010102020100", "Pilihan strategi Perusahaan apakah cenderung menggunakan strategi berisiko tinggi atau strategi berisiko rendah."),
//	R_02010102030000 ("02010102030000", "3.  Posisi Strategis  Perusahaan di Industri Perasuransian"),
	R_02010102030100 ("02010102030100", " a. Pasar dimana Perusahaan menjalankan kegiatan usaha."),
	R_02010102030200 ("02010102030200", " b. Kecukupan analisis terhadap keunggulan kompetitif yang dimiliki oleh Perusahaan dibandingkan dengan kompetitornya."),
	R_02010102030300 ("02010102030300", " c. Efisiensi dalam menjalankan kegiatan usaha."),
	R_02010102030400 ("02010102030400", " d. Strategi Perusahaan dalam mempertahankan atau meningkatkan posisi strategis di pasar, yang akan dilakukan Perusahaan baik kegiatan usaha, cakupan wilayah operasional atau lainnya."),
	R_02010102030500 ("02010102030500", " e. Kesiapan Perusahaan dalam menghadapi perubahan ekonomi secara makro dan dampaknya terhadap kondisi Perusahaan, antara lain tingkat suku bunga, inflasi, dan nilai tukar."),
//	R_02010102040000 ("02010102040000", "4.  Pencapaian realisasi bisnis Perusahaan"),
	R_02010102040100 ("02010102040100", " a. Tingkat deviasi pencapaian rencana bisnis."),
	R_02010102040200 ("02010102040200", " b. Tren tingkat deviasi rencana bisnis."),
	R_02010102040300 ("02010102040300", " c. Kecukupan dokumentasi terhadap faktor yang menyebabkan terjadinya deviasi rencana bisnis."),
//	R_02010200000000 ("02010200000000", "Tabel II.A.2: Tingkat Risiko Inheren untuk Risiko Strategis Individu"),
	R_02010201000000 ("02010201000000", "Tingkat Risiko Inheren untuk Risiko Strategis"),
//	R_02010300000000 ("02010300000000", "Tabel II.A.3: Kualitas Penerapan Manajemen Risiko untuk Risiko Strategis Individu"),
	R_02010301000000 ("02010301000000", "Kualitas Penerapan Manajemen Risiko untuk Risiko Strategis"),
//	R_02010302000000 ("02010302000000", "Tingkat Risiko Strategis"),
	R_02010303000000 ("02010303000000", "Tingkat Risiko Strategis Nett Risk"),
	R_02010400000000 ("02010400000000", "ANALISIS"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4100PosSaReasu0201 eEnum : ER4100PosSaReasu0201.values()) {
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
	
	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2", UtilMetadata.genPipeRow(getObjects(), 0, 8));
	}
	
	public static SegmentValidation genValidationMaxLengthNumericDot() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 0, 8), 10);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), 23, 25));
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 23, 25), 1);
	}
	
	public static SegmentValidation genValidationPeringkat() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), 23, 25), ER1099Peringkat.getPipedKey());
	}
}
