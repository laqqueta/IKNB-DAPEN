package id.go.ojk.lpei.client.builder.field.lb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulananUus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7009PosLbLpeiu1200 implements IObject<KeyValueString> {
	//	R_12000100000000 ("12000100000000","PENDAPATAN DAN BEBAN OPERASIONAL"),
	//	R_12000101000000 ("12000101000000","Pendapatan Provisi dan Komisi, Bagi Hasil, Margin, serta Ujrah"),
	R_12000101010000 ("12000101010000","Provisi dan Komisi"),
	R_12000101020000 ("12000101020000","Bagi Hasil"),
	R_12000101030000 ("12000101030000","Margin"),
	R_12000101040000 ("12000101040000","Ujrah"),
	R_12000101050000 ("12000101050000","Jumlah Pendapatan Provisi dan Komisi, Bagi Hasil, Margin, serta Ujrah"),
	//	R_12000102000000 ("12000102000000","Beban Provisi dan Komisi, Bagi Hasil, Margin, serta Ujrah"),
	R_12000102010000 ("12000102010000","Beban Provisi dan Komisi"),
	R_12000102020000 ("12000102020000","Beban Bagi Hasil"),
	R_12000102030000 ("12000102030000","Beban Margin"),
	R_12000102040000 ("12000102040000","Beban Ujrah"),
	R_12000102050000 ("12000102050000","Jumlah Beban Provisi dan Komisi, Bagi Hasil, Margin, serta Ujrah"),
	R_12000103000000 ("12000103000000","Pendapatan Provisi dan Komisi, Bagi Hasil, Margin, serta Ujrah - Neto"),
	//	R_12000104000000 ("12000104000000","Pendapatan Asuransi dan Penjaminan"),
	//	R_12000104010000 ("12000104010000","Pendapatan Kontribusi"),
	R_12000104010100 ("12000104010100","Kontribusi Bruto"),
	R_12000104010200 ("12000104010200","Kontribusi Reasuransi (-/-)"),
	R_12000104010300 ("12000104010300","Penurunan (Kenaikan) Kontribusi yang Belum merupakan Pendapatan"),
	R_12000104010400 ("12000104010400","Jumlah Pendapatan Kontribusi"),
	R_12000104020000 ("12000104020000","Pendapatan Imbal Jasa Kafalah"),
	R_12000104030000 ("12000104030000","Pendapatan Komisi Reasuransi"),
	R_12000104040000 ("12000104040000","Pendapatan Lainnya"),
	R_12000104050000 ("12000104050000","Jumlah Pendapatan Asuransi dan Penjaminan"),
	//	R_12000105000000 ("12000105000000","Beban Asuransi dan Penjaminan"),
	//	R_12000105010000 ("12000105010000","Beban Klaim Asuransi"),
	R_12000105010100 ("12000105010100","Kontribusi yang Belum Merupakan Pendapatan"),
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
	R_12000109010000 ("12000109010000","Beban Provisi atas Liabilitas Kontijensi"),
	//	R_12000110000000 ("12000110000000","Beban Operasional Lainnya"),
	R_12000110100000 ("12000110100000","Beban Sewa"),
	R_12000110200000 ("12000110200000","Beban Pemeliharaan dan Perbaikan"),
	R_12000110300000 ("12000110300000","Beban Administrasi dan Umum"),
	R_12000110400000 ("12000110400000","Beban Tenaga Kerja"),
	R_12000110401000 ("12000110401000","Beban Gaji, Upah, dan Tunjangan"),
	R_12000110402000 ("12000110402000","Beban Pengembangan dan Pelatihan Tenaga Kerja"),
	R_12000110403000 ("12000110403000","Beban Tenaga Kerja Lainnya"),
	R_12000110500000 ("12000110500000","Beban Pemasaran"),
	R_12000110600000 ("12000110600000","Beban Lainnya"),
	R_12000111000000 ("12000111000000","Jumlah Beban Operasional Lainnya"),
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
		for (ER7009PosLbLpeiu1200 eEnum : ER7009PosLbLpeiu1200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER7009PosLbLpeiu1200.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER7009PosLbLpeiu1200.class.getSimpleName().substring(2, 6));
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
		return UtilFieldValidation.genEqualsPosFormula("2+3",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 9, 14, 23, 27, 32, 49, 53, 57, 58 }));
	}


	public static SegmentValidation genRowValidation06() {
		int[] fields = new int[] {0, 1, 2, 3};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000101050000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000101050000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation11() {
		int[] fields = new int[] { 5, 6, 7, 8 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_12000102050000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000102050000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation12() {
		String selectPosCode = "12000101050000-12000102050000";
		String selectPosCodeDesc = UtilMetadata.genDelimitedDescByPosCode(getObjects(), selectPosCode);
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000103000000.key, selectPosCode,
				UtilMetadata.genMessage(R_12000103000000.value, selectPosCodeDesc));
	}

	public static SegmentValidation genRowValidation16() {
		String selectPosCode = "12000104010100-12000104010200+12000104010300";
		String selectPosCodeDesc = UtilMetadata.genDelimitedDescByPosCode(getObjects(), selectPosCode);
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_12000104010400.key, selectPosCode,
				UtilMetadata.genMessage(R_12000104010400.value, selectPosCodeDesc));
	}

	public static SegmentValidation genRowValidation20() {
		int[] fields = new int[] { 14, 15, 16, 17 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000104050000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000104050000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation25() {
		int[] fields = new int[] { 19, 20, 21, 22 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_12000105010500.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000105010500.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation29() {
		int[] fields = new int[] { 23, 24, 25, 26 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_12000105050000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000105050000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation30() {
		int[] fields = new int[] { 18, 27 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000106000000.key,
				UtilMetadata.genMinusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000106000000.value, "", UtilMetadata.genMinusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation34() {
		int[] fields = new int[] { 29, 30, 31 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_12000107040000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000107040000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation35() {
		int[] fields = new int[] { 34, 35, 36, 37, 38 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000108000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000108000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation45() {
		int[] fields = new int[] { 44, 45, 46 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000110400000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000110400000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation51() {
		int[] fields = new int[] { 40, 41, 42, 43, 47, 48 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_12000111000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000111000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation52() {
		String selectPosCode = "12000103000000+12000106000000+12000107040000-12000108000000-12000109010000-12000111000000";
		String selectPosCodeDesc = UtilMetadata.genDelimitedDescByPosCode(getObjects(), selectPosCode);
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000200000000.key, selectPosCode,
				UtilMetadata.genMessage(R_12000200000000.value, selectPosCodeDesc));
	}

	public static SegmentValidation genRowValidation55() {
		int[] fields = new int[] { 51, 52 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_12000303000000.key,
				UtilMetadata.genMinusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000303000000.value, "", UtilMetadata.genMinusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation56() {
		int[] fields = new int[] { 50, 53 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000400000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000400000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation59() {
		int[] fields = new int[] { 54, 55, 56 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_12000600000000.key,
				UtilMetadata.genMinusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000600000000.value, "", UtilMetadata.genMinusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation60() {
		int[] fields = new int[] { 59, 60, 61, 62, 63 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_12000700000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000700000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

//	public static SegmentValidation genRowValidation60B() {
//		return UtilSegmentValidation.genEqualsForm("2", R_12000700000000.key,
//				EFormLaporanBulananUus.LB_1100.getCode(), "2", ER7007PosLbLpeiu1100.R_11000506020000.getKey());
//	}
//
//	public static SegmentValidation genRowValidation60C() {
//		return UtilSegmentValidation.genEqualsForm("3", R_12000700000000.key,
//				EFormLaporanBulananUus.LB_1100.getCode(), "3", ER7007PosLbLpeiu1100.R_11000506020000.getKey());
//	}

	public static SegmentValidation genRowValidation66A() {
		int[] fields = new int[] { 57, 58 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_12000800000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_12000800000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
}