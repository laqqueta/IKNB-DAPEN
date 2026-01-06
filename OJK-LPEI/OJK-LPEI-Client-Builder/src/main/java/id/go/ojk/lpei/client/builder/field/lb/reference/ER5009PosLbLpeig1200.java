package id.go.ojk.lpei.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5009PosLbLpeig1200 implements IObject<KeyValueString> {
	//	R_12000100000000 ("12000100000000","PENDAPATAN DAN BEBAN OPERASIONAL"),
	//	R_12000101000000 ("12000101000000","Pendapatan Bunga, Provisi dan Komisi, Bagi Hasil, Margin, serta Ujrah"),
	R_12000101010000 ("12000101010000","Pendapatan Bunga serta Provisi dan Komisi"),
	R_12000101010100 ("12000101010100","Bunga"),
	R_12000101010200 ("12000101010200","Provisi dan Komisi"),
	R_12000101020000 ("12000101020000","Pendapatan Bagi Hasil, Margin, serta Ujrah"),
	R_12000101020100 ("12000101020100","Bagi Hasil"),
	R_12000101020200 ("12000101020200","Margin"),
	R_12000101020300 ("12000101020300","Ujrah"),
	R_12000101030000 ("12000101030000","Jumlah Pendapatan Bunga, Provisi dan Komisi, Bagi Hasil, Margin, serta Ujrah"),
	//	R_12000102000000 ("12000102000000","Beban Bunga, Provisi dan Komisi, Bagi Hasil, Margin, serta Ujrah"),
	R_12000102010000 ("12000102010000","Beban Bunga"),
	R_12000102020000 ("12000102020000","Beban Provisi dan Komisi"),
	R_12000102030000 ("12000102030000","Beban Bagi Hasil"),
	R_12000102040000 ("12000102040000","Beban Margin"),
	R_12000102050000 ("12000102050000","Beban Ujrah"),
	R_12000102060000 ("12000102060000","Jumlah Beban Bunga, Provisi dan Komisi, Bagi Hasil, serta Ujrah"),
	R_12000103000000 ("12000103000000","Pendapatan Bunga, Provisi dan Komisi, Bagi Hasil, Margin, serta Ujrah - Neto"),
	//	R_12000104000000 ("12000104000000","Pendapatan Asuransi dan Penjaminan"),
	//	R_12000104010000 ("12000104010000","Pendapatan Premi"),
	R_12000104010100 ("12000104010100","Premi Bruto"),
	R_12000104010200 ("12000104010200","Premi Reasuransi (-/-)"),
	R_12000104010300 ("12000104010300","Penurunan (Kenaikan) Premi yang Belum merupakan Pendapatan"),
	R_12000104010400 ("12000104010400","Jumlah Pendapatan Premi"),
	R_12000104020000 ("12000104020000","Pendapatan Imbal Jasa Penjaminan"),
	R_12000104030000 ("12000104030000","Pendapatan Komisi Reasuransi"),
	R_12000104040000 ("12000104040000","Pendapatan Lainnya"),
	R_12000104050000 ("12000104050000","Jumlah Pendapatan Asuransi dan Penjaminan"),
	//	R_12000105000000 ("12000105000000","Beban Asuransi dan Penjaminan"),
	//	R_12000105010000 ("12000105010000","Beban Klaim Asuransi"),
	R_12000105010100 ("12000105010100","Premi yang Belum Merupakan Pendapatan"),
	R_12000105010200 ("12000105010200","Klaim Bruto"),
	R_12000105010300 ("12000105010300","Klaim Reasuransi"),
	R_12000105010400 ("12000105010400","Penurunan (Kenaikan) Estimasi Klaim Retensi Sendiri"),
	R_12000105010500 ("12000105010500","Jumlah Beban Klaim Asuransi"),
	R_12000105020000 ("12000105020000","Beban Klaim Penjaminan"),
	R_12000105030000 ("12000105030000","Penurunan (Kenaikan) Aset Reasuransi"),
	R_12000105040000 ("12000105040000","Beban Lainnya"),
	R_12000105050000 ("12000105050000","Jumlah Beban Asuransi dan Penjaminan"),
	R_12000106000000 ("12000106000000","Pendapatan Asuransi dan Penjaminan - Neto"),
	//	R_12000107000000 ("12000107000000","Pendapatan Operasional Lainnya"),
	R_12000107010000 ("12000107010000","Keuntungan Transaksi Surat Berharga - Neto"),
	R_12000107020000 ("12000107020000","Keuntungan Transaksi Mata Uang Asing - Neto"),
	R_12000107030000 ("12000107030000","Lain-Lain"),
	R_12000107040000 ("12000107040000","Jumlah Pendapatan Operasional Lainnya"),
	R_12000108000000 ("12000108000000","Beban Penyisihan/Penyusutan"),
	R_12000108010000 ("12000108010000","Beban Penyisihan Penilaian Kualitas Aset"),
	R_12000108020000 ("12000108020000","Beban Penyisihan Penilaian Kualitas Aset Berdasarkan Prinsip Syariah"),
	R_12000108030000 ("12000108030000","Beban Penyusutan Aset Tetap dan Inventaris"),
	R_12000108040000 ("12000108040000","Beban Amortisasi Aset Tidak Berwujud"),
	R_12000108050000 ("12000108050000","Beban Penyusutan Aset Ijarah"),
	R_12000109000000 ("12000109000000","Beban Provisi atas Liabilitas Kontijensi"),
	//	R_12000110000000 ("12000110000000","Beban Operasional Lainnya"),
	R_12000110010000 ("12000110010000","Beban Sewa"),
	R_12000110020000 ("12000110020000","Beban Pemeliharaan dan Perbaikan"),
	R_12000110030000 ("12000110030000","Beban Administrasi dan Umum"),
	R_12000110040000 ("12000110040000","Beban Tenaga Kerja"),
	R_12000110040100 ("12000110040100","Beban Gaji, Upah, dan Tunjangan"),
	R_12000110040200 ("12000110040200","Beban Pengembangan dan Pelatihan Tenaga Kerja"),
	R_12000110040300 ("12000110040300","Beban Tenaga Kerja Lainnya"),
	R_12000110050000 ("12000110050000","Beban Pemasaran"),
	R_12000110060000 ("12000110060000","Beban Lainnya"),
	R_12000110070000 ("12000110070000","Jumlah Beban Operasional Lainnya"),
	R_12000200000000 ("12000200000000","LABA (RUGI) OPERASIONAL"),
	//	R_12000300000000 ("12000300000000","PENDAPATAN DAN BEBAN NON OPERASIONAL"),
	R_12000301000000 ("12000301000000","Pendapatan Non Operasional"),
	R_12000302000000 ("12000302000000","Beban Non Operasional"),
	R_12000303000000 ("12000303000000","Pendapatan (Beban) Non Operasional"),
	R_12000400000000 ("12000400000000","LABA (RUGI) SEBELUM PAJAK"),
	//	R_12000500000000 ("12000500000000","TAKSIRAN PAJAK PENGHASILAN"),
	R_12000501000000 ("12000501000000","Pajak Tahun Berjalan"),
	R_12000502000000 ("12000502000000","Pendapatan (Beban) Pajak Tangguhan"),
	R_12000600000000 ("12000600000000","LABA (RUGI) BERSIH SETELAH PAJAK"),
	R_12000700000000 ("12000700000000","KEUNTUNGAN (KERUGIAN) PENDAPATAN KOMPREHENSIF LAINNYA PERIODE BERJALAN"),
	R_12000701000000 ("12000701000000","Keuntungan (Kerugian) Akibat Perubahan dalam Surplus Revaluasi Aset Tetap"),
	R_12000702000000 ("12000702000000","Selisih Kurs Karena Penjabaran Laporan Keuangan dalam Mata Uang Asing"),
	R_12000703000000 ("12000703000000","Keuntungan (Kerugian) Akibat Pengukuran Kembali Aset Keuangan Tersedia untuk Dijual"),
	R_12000704000000 ("12000704000000","Keuntungan (Kerugian) Akibat Bagian Efektif Instrumen Keuangan Lindung Nilai dalam Rangka Lindung Nilai Arus Kas"),
	R_12000705000000 ("12000705000000","Keuntungan (Kerugian) atas Komponen Ekuitas Lainnya Sesuai Prinsip Standar Akuntansi Keuangan"),
	R_12000800000000 ("12000800000000","LABA (RUGI) BERSIH KOMPREHENSIF TAHUN BERJALAN"),
	;

	@Getter
	private String key;
	private String value;

	@Override
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER5009PosLbLpeig1200 eEnum : ER5009PosLbLpeig1200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER5009PosLbLpeig1200.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER5009PosLbLpeig1200.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String getUniquePos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 4), getObjects());
	}

	public static FieldValidation genFieldValidation04() {
		return UtilFieldValidation.genEqualsPosFormula("2+3", UtilMetadata.genPipeRowExcept(getObjects(), new int[] {47,48}));
	}

	public static SegmentValidation genRowValidation00() {
		int[] fields = new int[] {1, 2};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000101010000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000101010000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation03() {
		int[] fields = new int[] {4, 5, 6};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000101020000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000101020000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation07() {
		int[] fields = new int[] {0, 3};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000101030000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000101030000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation13() {
		int[] fields = new int[] {8, 9, 10, 11, 12};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000102060000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000102060000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation14() {
		int[] fields = new int[] {7, 13};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000103000000.key,
				UtilMetadata.genMinusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000103000000.value, "", UtilMetadata.genMinusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation18() {
		String selectPosCode = "12000104010100-12000104010200+12000104010300";
		String selectPosCodeDesc = UtilMetadata.genDelimitedDescByPosCode(getObjects(), selectPosCode);
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000104010400.key, selectPosCode,
				UtilMetadata.genMessage(R_12000104010400.value, selectPosCodeDesc));
	}

	public static SegmentValidation genRowValidation22() {
		int[] fields = new int[] {18, 19, 20, 21};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000104050000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000104050000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation27() {
		int[] fields = new int[] {23, 24, 25, 26};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000105010500.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000105010500.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation31() {
		int[] fields = new int[] {27, 28, 29, 30};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000105050000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000105050000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation32() {
		int[] fields = new int[] {22, 31};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000106000000.key,
				UtilMetadata.genMinusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000106000000.value, "", UtilMetadata.genMinusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation36() {
		int[] fields = new int[] {33, 34, 35};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000107040000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000107040000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation37() {
		int[] fields = new int[] {38, 39, 40, 41, 42};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000108000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000108000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation47() {
		int[] fields = new int[] {48, 49, 50};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_12000110040000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000110040000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation53() {
		int[] fields = new int[] {44, 45, 46, 47, 51, 52};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000110070000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000110070000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation54() {
		int[] plusFields = new int[] {14, 32, 36};
		int[] minusFields = new int[] {37, 43, 53};
		String plusMinusRow = UtilMetadata.genPlusRow(getObjects(), plusFields) + "-" + UtilMetadata.genMinusRow(getObjects(), minusFields);
		String plusMinusDesc = UtilMetadata.genPlusDesc(getObjects(), plusFields) + "-" + UtilMetadata.genMinusDesc(getObjects(), minusFields);
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000200000000.key,
				plusMinusRow, UtilMetadata.genMessage(R_12000200000000.value, "", plusMinusDesc));
	}

	public static SegmentValidation genRowValidation57() {
		int[] fields = new int[] {55, 56};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000303000000.key,
				UtilMetadata.genMinusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000303000000.value, "", UtilMetadata.genMinusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation58() {
		int[] plusFields = new int[] {14, 32, 36};
		int[] minusFields1 = new int[] {37, 43, 53};
		int[] minusFields2 = new int[] {55, 56};

		String plusMinusRow = UtilMetadata.genPlusRow(getObjects(), plusFields)
				+ "-" + UtilMetadata.genMinusRow(getObjects(), minusFields1)
				+ "+" + UtilMetadata.genMinusRow(getObjects(), minusFields2);

		String plusMinusDesc = UtilMetadata.genPlusDesc(getObjects(), plusFields)
				+ "-" + UtilMetadata.genMinusDesc(getObjects(), minusFields1)
				+ "+" + UtilMetadata.genMinusDesc(getObjects(), minusFields2);

		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000400000000.key,
				plusMinusRow, UtilMetadata.genMessage(R_12000400000000.value, "", plusMinusDesc));
	}

	public static SegmentValidation genRowValidation61() {
		int[] fields = new int[] {58, 59, 60};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000600000000.key,
				UtilMetadata.genMinusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000600000000.value, "", UtilMetadata.genMinusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation62() {
		int[] fields = new int[] {63, 64, 65, 66, 67};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000700000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000700000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation68A() {
		int[] fields = new int[] {61, 62};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000800000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000800000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation68B() {
		return UtilSegmentValidation.genEqualsForm("2", R_12000700000000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "2", ER5007PosLbLpeig1100.R_11000506020000.getKey());
	}

	public static SegmentValidation genRowValidation68C() {
		return UtilSegmentValidation.genEqualsForm("3", R_12000700000000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000506020000.getKey());
	}
}