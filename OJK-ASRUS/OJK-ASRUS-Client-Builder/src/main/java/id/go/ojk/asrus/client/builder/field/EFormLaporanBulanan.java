package id.go.ojk.asrus.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLaporanBulanan {
	LB_000 ("000", "Profil Perusahaan "),
	LB_001 ("001", "a. Rincian Pemegang Saham"),
	LB_002 ("002", "b. Rincian Pihak Utama"),
	LB_003 ("003", "c. Rasio Pendidikan dan Pelatihan - I"),
	LB_004 ("004", "d. Rasio Pendidikan dan Pelatihan - II"),
	LB_910 ("910", "Surat Pernyataan"),
	LB_100 ("100", "Laporan Posisi Keuangan"),
	LB_200 ("200", "Laporan Kinerja Keuangan"),
	LB_300 ("300", "Laporan Arus Kas "),
	LB_400 ("400", "Laporan Perubahan Dana "),
	LB_500 ("500", "Analisis Dana Perusahaan - Perhitungan Aset dan Liabilitas Dana Perusahaan"),
	LB_501 ("501", "Analisis Dana Perusahaan - Perhitungan Liabilitas Dana Perusahaan"),
	LB_600 ("600", "Analisis Dana Tabarru - Perhitungan Aset dan Liabilitas Dana Tabarru"),
	LB_601 ("601", "Analisis Dana Tabarru - Perhitungan Liabilitas Dana Tabarru"),
	LB_700 ("700", "Analisis Dana Investasi Peserta - Perhitungan Aset dan Liabilitas Dana Investasi Peserta"),
	LB_701 ("701", "Analisis Dana Investasi Peserta - Perhitungan Liabilitas Dana Investasi Peserta Pada PAYDI yang Digaransi"),
	LB_110 ("110", "Rasio Keuangan Pencapaian Tingkat Solvabilitas"),
	LB_111 ("111", "Rasio Keuangan Selain Tingkat Solvabilitas"),
	LB_210 ("210", "Modal Minimum Berbasis Risiko dan Dana Tabarru Minimum Berbasis Risiko - Risiko Kredit"),
	LB_211 ("211", "Modal Minimum Berbasis Risiko dan Dana Tabarru Minimum Berbasis Risiko - Risiko Kredit - Risiko Kegagalan atau Ketidakmampuan Debitur atau Pihak Lain"),
	LB_212 ("212", "Dana Tabarru Minimum Berbasis Risiko - Risiko Kredit - Kegagalan/Ketidakmampuan Penanggung Ulang"),
	LB_213 ("213", "Modal Minimum Berbasis Risiko dan Dana Tabarru Minimum Berbasis Risiko - Risiko Likuiditas"),
	LB_214 ("214", "Modal Minimum Berbasis Risiko dan Dana Tabarru Minimum Berbasis Risiko - Risiko Pasar"),
	LB_215 ("215", "Modal Minimum Berbasis Risiko dan Dana Tabarru Minimum Berbasis Risiko - Risiko Pasar - Perubahan Harga Pasar"),
	LB_216 ("216", "Modal Minimum Berbasis Risiko dan Dana Tabarru Minimum Berbasis Risiko - Risiko Pasar - Perubahan Nilai Tukar Mata Uang Asing"),
	LB_217 ("217", "Modal Minimum Berbasis Risiko dan Dana Tabarru Minimum Berbasis Risiko - Risiko Pasar - Risiko Perubahan Tingkat Hasil Investasi"),
	LB_218 ("218", "Modal Minimum Berbasis Risiko dan Dana Tabarru Minimum Berbasis Risiko - Risiko Asuransi"),
	LB_219 ("219", "Modal Minimum Berbasis Risiko dan Dana Tabarru Minimum Berbasis Risiko - Risiko Asuransi - Penyisihan Kontribusi"),
	LB_220 ("220", "Modal Minimum Berbasis Risiko dan Dana Tabarru Minimum Berbasis Risiko - Risiko Asuransi - Penyisihan Atas Kontribusi yang Belum Merupakan Pendapatan"),
	LB_221 ("221", "Modal Minimum Berbasis Risiko dan Dana Tabarru Minimum Berbasis Risiko - Risiko Asuransi - Penyisihan Klaim"),
	LB_222 ("222", "Modal Minimum Berbasis Risiko dan Dana Tabarru Minimum Berbasis Risiko - Risiko Asuransi - Penyisihan Atas Risiko Bencana"),
	LB_223 ("223", "Modal Minimum Berbasis Risiko dan Dana Tabarru Minimum Berbasis Risiko - Risiko Operasional"),
	LB_224 ("224", "Rincian A-110. Rincian Investasi dan Property"),
	LB_225 ("225", "Rincian A-120. Rincian Tagihan"),
	LB_226 ("226", "Rincian A-130. Rincian Aset Lain"),
	LB_227 ("227", "Rincian A-210. Rincian Utang"),
	LB_228 ("228", "Rincian A-220. Penyisihan Ujroh, Penyisihan Kontribusi, dan Penyisihan Atas Kontribusi yang Belum Merupakan Pendapatan"),
	LB_229 ("229", "Rincian A-221. Penyisihan Klaim"),
	LB_230 ("230", "Rincian A-222. Penyisihan Risiko Bencana"),
	LB_231 ("231", "Rincian A-310. Rincian Rekapitulasi Aset dan Liabilitas Berdasarkan Mata Uang dan Umur Jatuh Tempo"),
	LB_232 ("232", "Rincian A-310. Rincian Rekapitulasi Aset dan Liabilitas Berdasarkan Mata Uang dan Umur Jatuh Tempo - I"),
	LB_233 ("233", "Rincian B-110. Kontribusi dan Klaim Berdasarkan Lini Usaha"),
	LB_234 ("234", "Rincian C-110. Laporan Dana Jaminan - Ringkasan Perkembangan Dana Jaminan dan Perhitungan Kecukupan Dana Jaminan"),
	LB_235 ("235", "Rincian D-110. Kinerja Pemasaran Asuransi Mikro Per Jenis Produk Asuransi"),
	LB_236 ("236", "Rincian D-120. Kinerja Saluran Pemasaran Asuransi Mikro"),
	;
	
	@Getter
	private String code;
	@Getter
	private String name;
}
