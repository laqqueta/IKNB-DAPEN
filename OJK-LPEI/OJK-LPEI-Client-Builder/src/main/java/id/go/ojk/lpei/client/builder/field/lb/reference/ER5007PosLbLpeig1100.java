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
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5007PosLbLpeig1100 implements IObject<KeyValueString> {
	R_11000101000000 ("11000101000000","Kas"),
	R_11000102000000 ("11000102000000","Emas dan Commemorative Coins"),
	R_11000103000000 ("11000103000000","Penempatan pada Bank Indonesia dalam Bentuk Simpanan"),
	R_11000104000000 ("11000104000000","Penempatan pada Bank dalam Bentuk Simpanan"),
	R_11000104010000 ("11000104010000","CKPN - Penempatan pada Bank -/-"),
	R_11000105000000 ("11000105000000","Pembiayaan"),
	R_11000105010000 ("11000105010000","Investasi"),
	R_11000105020000 ("11000105020000","Modal Kerja"),
	R_11000105030000 ("11000105030000","Lainnya"),
	R_11000105040000 ("11000105040000","CKPN - Pembiayaan -/-"),
	R_11000106000000 ("11000106000000","Pembiayaan berdasarkan Prinsip Syariah"),
	R_11000106010000 ("11000106010000","CKPN - Pembiayaan berdasarkan Prinsip Syariah -/-"),
	R_11000107000000 ("11000107000000","Surat Berharga yang Dimiliki"),
	R_11000107010000 ("11000107010000","CKPN - Surat Berharga yang Dimiliki -/-"),
	R_11000108000000 ("11000108000000","Aset Ijarah"),
	R_11000108010000 ("11000108010000","Aset Ijarah Bruto"),
	R_11000108020000 ("11000108020000","Pendapatan dan Biaya Lainnya sehubungan Transaksi Pembiayaan yang Diamortisasi"),
	R_11000108030000 ("11000108030000","Akumulasi Penyusutan"),
	R_11000109000000 ("11000109000000","Penyertaan Modal"),
	R_11000109010000 ("11000109010000","Pada Badan Hukum atau Badan Lainnya"),
	R_11000109020000 ("11000109020000","Dalam Rangka Restrukturisasi Pembiayaan"),
	R_11000109030000 ("11000109030000","CKPN - Penyertaan Modal -/-"),
	R_11000110000000 ("11000110000000","Tagihan Derivatif"),
	R_11000110010000 ("11000110010000","CKPN - Tagihan Derivatif -/-"),
	R_11000111000000 ("11000111000000","Tagihan Akseptasi"),
	R_11000111010000 ("11000111010000","CKPN - Tagihan Akseptasi -/-"),
	R_11000112000000 ("11000112000000","Piutang Premi Asuransi dan Imbal Jasa Penjaminan"),
	R_11000112010000 ("11000112010000","Piutang Premi Asuransi"),
	R_11000112020000 ("11000112020000","Piutang Imbal Jasa Penjaminan"),
	R_11000113000000 ("11000113000000","Aset Reasuransi"),
	R_11000113010000 ("11000113010000","CKPN - Aset Reasuransi -/-"),
	R_11000114000000 ("11000114000000","Tagihan Lainnya Kepada atau Dijamin"),
	R_11000115000000 ("11000115000000","Aset Tetap dan Inventaris"),
	R_11000115010000 ("11000115010000","Akumulasi Penyusutan Aset Tetap dan Inventaris -/-"),
	R_11000116000000 ("11000116000000","16. Agunan yang Diambil Alih"),
	R_11000116010000 ("11000116010000","CKPN - Agunan yang Diambil Alih -/-"),
	R_11000117000000 ("11000117000000","Aset Pajak Tangguhan"),
	R_11000118000000 ("11000118000000","Rupa-Rupa Aset"),
	R_11000200000000 ("11000200000000","Jumlah Total Aset"),
	R_11000301000000 ("11000301000000","Penempatan Dana oleh Bank Indonesia"),
	R_11000302000000 ("11000302000000","Surat Berharga yang Diterbitkan"),
	R_11000303000000 ("11000303000000","Liabilitas Derivatif"),
	R_11000304000000 ("11000304000000","Liabilitas Akseptasi"),
	R_11000305000000 ("11000305000000","Utang Pajak"),
	R_11000306000000 ("11000306000000","Pendanaan yang Diterima"),
	R_11000307000000 ("11000307000000","Provisi atas Liabilitas Kontijensi"),
	R_11000308000000 ("11000308000000","Liabilitas Asuransi dan Penjaminan"),
	R_11000308010000 ("11000308010000","Liabilitas Asuransi"),
	R_11000308020000 ("11000308020000","Liabilitas Penjaminan"),
	R_11000309000000 ("11000309000000","Utang Premi Reasuransi"),
	R_11000310000000 ("11000310000000","Utang Imbal Jasa Penjaminan Ulang"),
	R_11000311000000 ("11000311000000","Liabilitas Pajak Tangguhan"),
	R_11000312000000 ("11000312000000","Rupa-Rupa Liabilitas"),
	R_11000400000000 ("11000400000000","Jumlah Total Liabilitas"),
	R_11000501000000 ("11000501000000","Kontribusi Modal Pemerintah"),
	R_11000501010000 ("11000501010000","Modal Awal"),
	R_11000501020000 ("11000501020000","Modal Tambahan"),
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
		for (ER5007PosLbLpeig1100 eEnum : ER5007PosLbLpeig1100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER5007PosLbLpeig1100.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER5007PosLbLpeig1100.class.getSimpleName().substring(2, 6));
	}

	/*
	 * Unique and required validation
	 */
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
		return UtilFieldValidation.genEqualsPosFormula("2+3", UtilMetadata.genPipeRowExcept(getObjects(), new int[] {74}));
	}

	public static SegmentValidation genRowValidation04() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000103000000.key,
				EFormLaporanBulanan.LB_2000.getCode(), "4", ER5011PosLbLpeig2000.R_2000010000.getKey());
	}

	public static SegmentValidation genRowValidation05() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000104000000.key,
				EFormLaporanBulanan.LB_2050.getCode(), "14", ER5012PosLbLpeig2050.R_2050010000.getKey());
	}

	public static SegmentValidation genRowValidation07() {
		int[] fields = new int[] {6, 7, 8};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000105000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000105000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation12() {
		return UtilSegmentValidation.genComparisonFormReferenceValidation("4", R_11000106000000.key,
				EFormLaporanBulanan.LB_2100.getCode(), 27, 12, EHeaderMetadataShared.R054.getNumber(), "JK:e53", ER5013PosLbLpeig2100.R_2100010000.getKey());
	}

	public static SegmentValidation genRowValidation14() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107000000.key,
				EFormLaporanBulanan.LB_2200.getCode(), "20", ER5015PosLbLpeig2200.R_2200010000.getKey());
	}

	public static SegmentValidation genRowValidation16() {
		int[] fields = new int[] {15, 16, 17};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000108000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000108000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation20() {
		int[] fields = new int[] {19, 20};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000109000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000109000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation21() {
		return UtilSegmentValidation.genComparisonFormReferenceValidation("4", R_11000109010000.key,
				EFormLaporanBulanan.LB_2300.getCode(), 15, 8, EHeaderMetadataShared.R056.getNumber(), "TP:e01", ER5016PosLbLpeig2300.R_2300010000.getKey());
	}

	public static SegmentValidation genRowValidation22() {
		return UtilSegmentValidation.genComparisonFormReferenceValidation("4", R_11000109020000.key,
				EFormLaporanBulanan.LB_2300.getCode(), 15, 8, EHeaderMetadataShared.R056.getNumber(), "TP:e02", ER5016PosLbLpeig2300.R_2300010000.getKey());
	}

	public static SegmentValidation genRowValidation24() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000110000000.key,
				EFormLaporanBulanan.LB_2400.getCode(), "10", ER5018PosLbLpeig2400.R_2400010000.getKey());
	}

	public static SegmentValidation genRowValidation26() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000111000000.key,
				EFormLaporanBulanan.LB_2450.getCode(), "12", ER5019PosLbLpeig2450.R_2450010000.getKey());
	}

	public static SegmentValidation genRowValidation27() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000111010000.key,
				EFormLaporanBulanan.LB_2450.getCode(), "16|17|18", ER5019PosLbLpeig2450.R_2450010000.getKey());
	}

	public static SegmentValidation genRowValidation28() {
		int[] fields = new int[] {27, 28};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000112000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000112000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation31() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000113000000.key,
				EFormLaporanBulanan.LB_2350.getCode(), "5", ER5017PosLbLpeig2350.R_2350010000.getKey());
	}

	public static SegmentValidation genRowValidation39() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000118000000.key,
				EFormLaporanBulanan.LB_2490.getCode(), "5", ER5020PosLbLpeig2490.R_2490010000.getKey());
	}

	public static SegmentValidation genRowValidation40() {
		String selectPosCode = "11000101000000+11000102000000+11000103000000+11000104000000-11000104010000+11000105010000+"
				+ "11000105020000+11000105030000-11000105040000+11000106000000-11000106010000+11000107000000-11000107010000+"
				+ "11000108010000+11000108020000+11000108030000+11000109010000+11000109020000-11000109030000+11000110000000-"
				+ "11000110010000+11000111000000-11000111010000+11000112010000+11000112020000+11000113000000-11000113010000+"
				+ "11000114000000+11000115000000-11000115010000+11000116000000-11000116010000+11000117000000+11000118000000";
		String selectPosCodeDesc = UtilMetadata.genDelimitedDescByPosCode(getObjects(), selectPosCode);
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000200000000.key, selectPosCode,
				UtilMetadata.genMessage(R_11000200000000.value, selectPosCodeDesc));
	}

	public static SegmentValidation genRowValidation42() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000302000000.key,
				EFormLaporanBulanan.LB_2600.getCode(), "18", ER5022PosLbLpeig2600.R_2600010000.getKey());
	}

	public static SegmentValidation genRowValidation43() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000303000000.key,
				EFormLaporanBulanan.LB_2700.getCode(), "9", ER5023PosLbLpeig2700.R_2700010000.getKey());
	}

	public static SegmentValidation genRowValidation44() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000304000000.key,
				EFormLaporanBulanan.LB_2730.getCode(), "11", ER5024PosLbLpeig2730.R_2730010000.getKey());
	}

	public static SegmentValidation genRowValidation46() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000306000000.key,
				EFormLaporanBulanan.LB_2550.getCode(), "21", ER5021PosLbLpeig2550.R_2550010000.getKey());
	}

	public static SegmentValidation genRowValidation48() {
		String selectPosCode = "11000308010000+11000308020000";
		String selectPosCodeDesc = UtilMetadata.genDelimitedDescByPosCode(getObjects(), selectPosCode);
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000308000000.key, selectPosCode,
				UtilMetadata.genMessage(R_11000308000000.value, selectPosCodeDesc));
	}

	// pending confirmation
	//	public static SegmentValidation genRowValidation49() {
	//		return UtilSegmentValidation.genComparisonFormReferenceValidation("4", R_11000105010000.key,
	//				EFormLaporanBulanan.LB_2760.getCode(), 0, 3, EHeaderMetadataShared.R057.getNumber(), "JR:e01|JR:e02|JR:e03|JR:e04", ER5025PosLbLpeig2760.R_2760010000.getKey());
	//	}
	//
	//	public static SegmentValidation genRowValidation50() {
	//		return UtilSegmentValidation.genComparisonFormReferenceValidation("4", R_11000105010000.key,
	//				EFormLaporanBulanan.LB_2760.getCode(), 0, 3, EHeaderMetadataShared.R057.getNumber(), "JR:e05|JR:e06|JR:e07|JR:e08", ER5025PosLbLpeig2760.R_2760010000.getKey());
	//	}

	public static SegmentValidation genRowValidation54() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000312000000.key,
				EFormLaporanBulanan.LB_2790.getCode(), "4", ER5026PosLbLpeig2790.R_2790010000.getKey());
	}

	public static SegmentValidation genRowValidation55() {
		int[] fields = new int[] {39, 40, 41, 42, 43, 44, 45, 46, 49, 50, 51, 52};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000400000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000400000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation56() {
		int[] fields = new int[] {55, 56};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000501000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000501000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation60() {
		int[] fields = new int[] {59, 62};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000503000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000503000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation61() {
		int[] fields = new int[] {60, 61};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000503010000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000503010000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation65A() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000504000000.key,
				EFormLaporanBulanan.LB_1200.getCode(), "2", ER5009PosLbLpeig1200.R_12000600000000.getKey());
	}

	public static SegmentValidation genRowValidation65B() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000504000000.key,
				EFormLaporanBulanan.LB_1200.getCode(), "3", ER5009PosLbLpeig1200.R_12000600000000.getKey());
	}

	public static SegmentValidation genRowValidation67() {
		int[] fields = new int[] {66, 72};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000506000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000506000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation68() {
		int[] fields = new int[] {67, 68, 69, 70, 71};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000506010000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000506010000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation74A() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000506020000.key,
				EFormLaporanBulanan.LB_1200.getCode(), "2", ER5009PosLbLpeig1200.R_12000700000000.getKey());
	}

	public static SegmentValidation genRowValidation74B() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000506020000.key,
				EFormLaporanBulanan.LB_1200.getCode(), "3", ER5009PosLbLpeig1200.R_12000700000000.getKey());
	}

	public static SegmentValidation genRowValidation75() {
		int[] fields = new int[] {54, 57, 58, 63, 64, 65};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000600000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000600000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation76() {
		int[] fields = new int[] {53, 73};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_11000700000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000700000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
}
