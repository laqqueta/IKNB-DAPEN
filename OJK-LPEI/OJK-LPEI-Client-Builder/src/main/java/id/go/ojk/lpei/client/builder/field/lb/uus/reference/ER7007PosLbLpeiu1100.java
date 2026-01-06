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
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7007PosLbLpeiu1100 implements IObject<KeyValueString> {
	//	R_11000100000000 ("11000100000000","Aset"),
	R_11000101000000 ("11000101000000","Kas"),
	R_11000102000000 ("11000102000000","Emas dan Commemorative Coins"),
	R_11000103000000 ("11000103000000","Penempatan pada Bank Indonesia dalam Bentuk Simpanan"),
	R_11000104000000 ("11000104000000","Penempatan pada Bank dalam Bentuk Simpanan"),
	R_11000104010000 ("11000104010000","PPKA - Penempatan pada Bank -/-"),
	R_11000105000000 ("11000105000000","Pembiayaan berdasarkan Prinsip Syariah"),
	R_11000105010000 ("11000105010000","Pembiayaan yang Diberikan"),
	R_11000105010100 ("11000105010100","Akad Murabahah"),
	R_11000105010200 ("11000105010200","Akad Musyarakah"),
	R_11000105010300 ("11000105010300","Akad Mudharabah"),
	R_11000105010400 ("11000105010400","Akad Mudharabah Musytarakah"),
	R_11000105010500 ("11000105010500","Akad Musyarakah Mutanaqisah"),
	R_11000105010600 ("11000105010600","Akad Qardh"),
	R_11000105010700 ("11000105010700","Akad Ijarah/IMBT"),
	R_11000105010800 ("11000105010800","Akad Lainnya"),
	R_11000105020000 ("11000105020000","Piutang Ijarah"),
	R_11000105030000 ("11000105030000","Lainnya"),
	R_11000105030100 ("11000105030100","PPKA - Pembiayaan berdasarkan Prinsip Syariah -/-"),
	R_11000106000000 ("11000106000000","Surat Berharga Syariah yang Dimiliki"),
	R_11000106010000 ("11000106010000","PPKA - Surat Berharga yang Dimiliki -/-"),
	R_11000107000000 ("11000107000000","Aset Ijarah"),
	R_11000107010000 ("11000107010000","Aset Ijarah Bruto"),
	R_11000107020000 ("11000107020000","Pendapatan dan Biaya Lainnya sehubungan Transaksi Pembiayaan yang Diamortisasi"),
	R_11000107030000 ("11000107030000","Akumulasi Penyusutan"),
	R_11000108000000 ("11000108000000","Tagihan Derivatif"),
	R_11000108010000 ("11000108010000","PPKA - Tagihan Derivatif -/-"),
	R_11000109000000 ("11000109000000","Tagihan Akseptasi"),
	R_11000109010000 ("11000109010000","PPKA - Tagihan Akseptasi -/-"),
	R_11000110000000 ("11000110000000","Piutang Kontribusi Asuransi dan Imbal Jasa Kafalah"),
	R_11000110100000 ("11000110100000","Piutang Kontribusi"),
	R_11000110200000 ("11000110200000","Piutang Imbal Jasa Kafalah"),
	R_11000111000000 ("11000111000000","Aset Reasuransi"),
	R_11000111010000 ("11000111010000","PPKA - Aset Reasuransi -/-"),
	R_11000112000000 ("11000112000000","Tagihan Lainnya Kepada atau Dijamin"),
	R_11000113000000 ("11000113000000","Aset Tetap dan Inventaris"),
	R_11000113010000 ("11000113010000","Akumulasi Penyusutan Aset Tetap dan Inventaris -/-"),
	R_11000114000000 ("11000114000000","Agunan yang Diambil Alih"),
	R_11000114010000 ("11000114010000","PPKA - Agunan yang Diambil Alih -/-"),
	R_11000115000000 ("11000115000000","Aset Pajak Tangguhan"),
	R_11000116000000 ("11000116000000","Rupa-Rupa Aset"),
	R_11000200000000 ("11000200000000","Jumlah Total Aset"),
	//	R_11000300000000 ("11000300000000","LIABILITAS"),
	R_11000301000000 ("11000301000000","Penempatan Dana oleh Bank Indonesia"),
	R_11000302000000 ("11000302000000","Surat Berharga Syariah yang Diterbitkan"),
	R_11000303000000 ("11000303000000","Liabilitas Derivatif"),
	R_11000304000000 ("11000304000000","Liabilitas Akseptasi"),
	R_11000305000000 ("11000305000000","Utang Pajak"),
	R_11000306000000 ("11000306000000","Pendanaan yang Diterima"),
	R_11000307000000 ("11000307000000","Provisi atas Liabilitas Kontijensi"),
	R_11000308000000 ("11000308000000","Liabilitas Asuransi dan Penjaminan"),
	R_11000308010000 ("11000308010000","Liabilitas Asuransi"),
	R_11000308020000 ("11000308020000","Liabilitas Penjaminan"),
	R_11000309000000 ("11000309000000","Utang Kontribusi Reasuransi"),
	R_11000310000000 ("11000310000000","Utang Imbal Jasa Kafalah Ulang"),
	R_11000311000000 ("11000311000000","Liabilitas Pajak Tangguhan"),
	R_11000312000000 ("11000312000000","Rupa-Rupa Liabilitas"),
	R_11000400000000 ("11000400000000","Jumlah Total Liabilitas"),
	//	R_11000500000000 ("11000500000000","EKUITAS"),
	R_11000501000000 ("11000501000000","Modal Kerja yang Dialokasikan"),
	R_11000502000000 ("11000502000000","Hibah"),
	R_11000503000000 ("11000503000000","Saldo Laba"),
	R_11000503010000 ("11000503010000","Saldo Laba yang Telah Ditentukan Penggunaanya"),
	R_11000503010100 ("11000503010100","Cadangan Umum"),
	R_11000503010200 ("11000503010200","Cadangan Tujuan"),
	R_11000503020000 ("11000503020000","Saldo Laba yang Belum Ditentukan Penggunaanya"),
	R_11000504000000 ("11000504000000","Laba (Rugi) Bersih Setelah Pajak"),
	R_11000505000000 ("11000505000000","Selisih Lebih (Kurang) Penjabaran Laporan Keuangan"),
	R_11000506000000 ("11000506000000","Komponen Ekuitas Lainnya"),
	R_11000506010000 ("11000506010000","Saldo Komponen Ekuitas Lainnya"),
	R_11000506010100 ("11000506010100","Saldo Keuntungan (Kerugian) Akibat Perubahan dalam Surplus Revaluasi Aset Tetap"),
	R_11000506010200 ("11000506010200","Saldo Keuntungan (Kerugian) Akibat Selisih Kurs Karena Penjabaran Laporan Keuangan dalam Mata Uang Asing"),
	R_11000506010300 ("11000506010300","Saldo Keuntungan (Kerugian) Akibat Pengukuran Kembali Aset Keuangan Tersedia untuk Dijual"),
	R_11000506010400 ("11000506010400","Saldo Keuntungan (Kerugian) Akibat Bagian Efektif Instrumen Keuangan Lindung Nilai dalam Rangka Lindung Nilai Arus Kas"),
	R_11000506010500 ("11000506010500","Saldo Keuntungan (Kerugian) atas Komponen Ekuitas Lainnya Sesuai Prinsip Standar Akuntansi Keuangan"),
	R_11000506020000 ("11000506020000","Keuntungan (Kerugian) Komprehensif Lainnya Periode Berjalan"),
	R_11000600000000 ("11000600000000","Jumlah Total Ekuitas"),
	R_11000700000000 ("11000700000000","Jumlah Total Liabilitas dan Ekuitas"),
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
		for (ER7007PosLbLpeiu1100 eEnum : ER7007PosLbLpeiu1100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER7007PosLbLpeiu1100.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER7007PosLbLpeiu1100.class.getSimpleName().substring(2, 6));
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
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 73, 74 }));
	}

	public static SegmentValidation genRowValidation04() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000103000000.key, EFormLaporanBulananUus.LB_2000.getCode(),
				"4", ER7011PosLbLpeiu2000.R_2000010000.getKey());
	}

	public static SegmentValidation genRowValidation05() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000104000000.key, EFormLaporanBulananUus.LB_2050.getCode(),
				"13", ER7012PosLbLpeiu2050.R_2050010000.getKey());
	}

	public static SegmentValidation genRowValidation07() {
		int[] fields = new int[] { 6, 15, 16};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000105000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000105000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation07B() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000105000000.key, EFormLaporanBulananUus.LB_2100.getCode(),
				"28", ER7013PosLbLpeiu2100.R_2100100000.getKey());
	}

	public static SegmentValidation genRowValidation08() {
		int[] fields = new int[] { 7, 8, 9, 10, 11, 12, 13, 14 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000105010000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000105010000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation09() {
		return UtilSegmentValidation.genComparisonFormReferenceValidation("4", R_11000105010100.key, EFormLaporanBulananUus.LB_2100.getCode(), 28, 13,
				EHeaderMetadataShared.R041.getNumber(), "JK:e26", ER7013PosLbLpeiu2100.R_2100010000.getKey());
	}

	public static SegmentValidation genRowValidation10() {
		return UtilSegmentValidation.genComparisonFormReferenceValidation("4", R_11000105010200.key, EFormLaporanBulananUus.LB_2100.getCode(), 28, 13,
				EHeaderMetadataShared.R041.getNumber(), "JK:e32", ER7013PosLbLpeiu2100.R_2100010000.getKey());
	}

	public static SegmentValidation genRowValidation11() {
		return UtilSegmentValidation.genComparisonFormReferenceValidation("4", R_11000105010300.key, EFormLaporanBulananUus.LB_2100.getCode(), 28, 13,
				EHeaderMetadataShared.R041.getNumber(), "JK:e31", ER7013PosLbLpeiu2100.R_2100010000.getKey());
	}

	public static SegmentValidation genRowValidation12() {
		return UtilSegmentValidation.genComparisonFormReferenceValidation("4", R_11000105010400.key, EFormLaporanBulananUus.LB_2100.getCode(), 28, 13,
				EHeaderMetadataShared.R041.getNumber(), "JK:e33", ER7013PosLbLpeiu2100.R_2100010000.getKey());
	}

	public static SegmentValidation genRowValidation13() {
		return UtilSegmentValidation.genComparisonFormReferenceValidation("4", R_11000105010500.key, EFormLaporanBulananUus.LB_2100.getCode(), 28, 13,
				EHeaderMetadataShared.R041.getNumber(), "JK:e34", ER7013PosLbLpeiu2100.R_2100010000.getKey());
	}

	public static SegmentValidation genRowValidation14() {
		return UtilSegmentValidation.genComparisonFormReferenceValidation("4", R_11000105010600.key, EFormLaporanBulananUus.LB_2100.getCode(), 28, 13,
				EHeaderMetadataShared.R041.getNumber(), "JK:e46", ER7013PosLbLpeiu2100.R_2100010000.getKey());
	}

	public static SegmentValidation genRowValidation15() {
		return UtilSegmentValidation.genComparisonFormReferenceValidation("4", R_11000105010700.key, EFormLaporanBulananUus.LB_2100.getCode(), 28, 13,
				EHeaderMetadataShared.R041.getNumber(), "JK:e37", ER7013PosLbLpeiu2100.R_2100010000.getKey());
	}

	public static SegmentValidation genRowValidation16() {
		return UtilSegmentValidation.genComparisonFormReferenceValidation("4", R_11000105010800.key, EFormLaporanBulananUus.LB_2100.getCode(), 28, 13,
				EHeaderMetadataShared.R041.getNumber(), "JK:e48", ER7013PosLbLpeiu2100.R_2100010000.getKey());
	}

	public static SegmentValidation genRowValidation17() {
		return UtilSegmentValidation.genComparisonFormReferenceValidation("4", R_11000105020000.key, EFormLaporanBulananUus.LB_2100.getCode(), 28, 13,
				EHeaderMetadataShared.R041.getNumber(), "JK:e37", ER7013PosLbLpeiu2100.R_2100010000.getKey());
	}

	public static SegmentValidation genRowValidation20() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000106000000.key, EFormLaporanBulananUus.LB_2200.getCode(),
				"21", ER7015PosLbLpeiu2200.R_2200010000.getKey());
	}

	public static SegmentValidation genRowValidation22() {
		int[] fields = new int[] { 21, 22, 23};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000107000000.key,
				UtilMetadata.genMinusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000107000000.value, "", UtilMetadata.genMinusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation26() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000108000000.key, EFormLaporanBulananUus.LB_2400.getCode(),
				"10", ER7018PosLbLpeiu2400.R_2400010000.getKey());
	}

	public static SegmentValidation genRowValidation28() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000109000000.key, EFormLaporanBulananUus.LB_2450.getCode(),
				"12", ER7019PosLbLpeiu2450.R_2450010000.getKey());
	}

	public static SegmentValidation genRowValidation30() {
		int[] fields = new int[] { 29, 30};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000110000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000110000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation33() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000111000000.key, EFormLaporanBulananUus.LB_2350.getCode(),
				"5", ER7017PosLbLpeiu2350.R_2350010000.getKey());
	}

	public static SegmentValidation genRowValidation41() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000116000000.key, EFormLaporanBulananUus.LB_2490.getCode(),
				"5", ER7020PosLbLpeiu2490.R_2490010000.getKey());
	}

	public static SegmentValidation genRowValidation42() {
		String selectPosCode = "11000101000000+11000102000000+11000103000000+11000104000000-11000104010000+11000105010000+"
				+ "11000105020000+11000105030000-11000105030100+11000106000000-11000106010000+11000107000000+11000108000000-"
				+ "11000108010000+11000109000000-11000109010000+11000110000000+11000111000000-11000111010000+11000112000000+"
				+ "11000113000000-11000113010000+11000114000000-11000114010000+11000115000000+11000116000000";
		String selectPosCodeDesc = UtilMetadata.genDelimitedDescByPosCode(getObjects(), selectPosCode);
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000200000000.key, selectPosCode,
				UtilMetadata.genMessage(R_11000200000000.value, selectPosCodeDesc));
	}

//	public static SegmentValidation genRowValidation42B() {
//		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_11000200000000.key, R_11000700000000.key,
//				UtilMetadata.genMessage(R_11000200000000.value, R_11000700000000.value));
//	}

	public static SegmentValidation genRowValidation44() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000302000000.key, EFormLaporanBulananUus.LB_2600.getCode(),
				"18", ER7022PosLbLpeiu2600.R_2600010000.getKey());
	}

	public static SegmentValidation genRowValidation45() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000303000000.key, EFormLaporanBulananUus.LB_2700.getCode(),
				"9", ER7023PosLbLpeiu2700.R_2700010000.getKey());
	}

	public static SegmentValidation genRowValidation46() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000304000000.key, EFormLaporanBulananUus.LB_2730.getCode(),
				"11", ER7024PosLbLpeiu2730.R_2730010000.getKey());
	}

	public static SegmentValidation genRowValidation48() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000306000000.key, EFormLaporanBulananUus.LB_2550.getCode(),
				"21", ER7021PosLbLpeiu2550.R_2550010000.getKey());
	}

	public static SegmentValidation genRowValidation50() {
		int[] fields = new int[] { 49, 50};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000308000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000308000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	// TODO: Yahya - validasi row 51, 52?

	public static SegmentValidation genRowValidation56() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000312000000.key, EFormLaporanBulananUus.LB_2790.getCode(),
				"4", ER7026PosLbLpeiu2790.R_2790010000.getKey());
	}

	public static SegmentValidation genRowValidation57() {
		String selectPosCode = "11000301000000+11000302000000+11000303000000+11000304000000+11000305000000+11000306000000+11000307000000+11000308000000+11000309000000+11000310000000+11000311000000+11000312000000";
		String selectPosCodeDesc = UtilMetadata.genDelimitedDescByPosCode(getObjects(), selectPosCode);
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000400000000.key, selectPosCode,
				UtilMetadata.genMessage(R_11000400000000.value, selectPosCodeDesc));
	}

	public static SegmentValidation genRowValidation60() {
		int[] fields = new int[] { 59, 62};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000503000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000503000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation61() {
		int[] fields = new int[] { 60, 61};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000503010000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000503010000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation65A() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000504000000.key, EFormLaporanBulananUus.LB_1200.getCode(),
				"2", ER7009PosLbLpeiu1200.R_12000600000000.getKey());
	}

	public static SegmentValidation genRowValidation65B() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000504000000.key, EFormLaporanBulananUus.LB_1200.getCode(),
				"3", ER7009PosLbLpeiu1200.R_12000600000000.getKey());
	}

	public static SegmentValidation genRowValidation67() {
		int[] fields = new int[] { 66, 72};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000506000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000506000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation68() {
		int[] fields = new int[] { 67, 68, 69, 70, 71 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000506010000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000506010000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation74A() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000506020000.key, EFormLaporanBulananUus.LB_1200.getCode(),
				"2", ER7009PosLbLpeiu1200.R_12000700000000.getKey());
	}

	public static SegmentValidation genRowValidation74B() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000506020000.key, EFormLaporanBulananUus.LB_1200.getCode(),
				"3", ER7009PosLbLpeiu1200.R_12000700000000.getKey());
	}

	public static SegmentValidation genRowValidation75() {
		int[] fields = new int[] { 56, 57, 58, 63, 64, 65 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_11000600000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000600000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation76() {
		int[] fields = new int[] { 55, 73 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_11000700000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000700000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genComparisonFormReferenceValidation() {
		//		String errorMessage = R_11000105010100.value + " sama dengan penjumlahan nilai di akun \"Outstanding Pembiayaan\" di kolom \"Dalam Ekuivalen Rupiah\" hasil dari akumulasi akun \"Akad Yang Digunakan\" yang berisi \"Akad Murabahah\" pada 2100";
		return UtilSegmentValidation.genComparisonFormReferenceValidation("4", R_11000105010100.key, EFormLaporanBulananUus.LB_2100.getCode(), 28, 13, EHeaderMetadataShared.R041.getNumber(), "JK:e26", ER7013PosLbLpeiu2100.R_2100010000.getKey());
	}
}
