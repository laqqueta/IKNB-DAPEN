package id.go.ojk.pnmk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3003PosLbPnmk1100 implements IObject<KeyValueString> {
	R_1100010000("1100010000", "Aset"), 
	R_1100010100("1100010100", "Kas dan Setara Kas"),
	R_1100010200("1100010200", "Penempatan Pada Bank"), 
	R_1100010300("1100010300", "Surat Berharga yang Dimiliki"),
	R_1100010400("1100010400", "Investasi pada Entitas Asosiasi"), 
	R_1100010500("1100010500", "Piutang"),
	R_1100010501("1100010501", "Penyaluran Pinjaman ULaMM"), 
	R_1100010502("1100010502", "Penyaluran Pinjaman Mekaar"),
	R_1100010503("1100010503", "Jasa Manajemen"), 
	R_1100010504("1100010504", "Lain-lain"),
	R_1100010600("1100010600", "Pendapatan yang Masih Akan Diterima"),
	R_1100010700("1100010700", "Uang Muka dan Biaya Dibayar Dimuka"),
	R_1100010800("1100010800", "Cadangan Kerugian Penurunan Nilai"),
	R_1100010900("1100010900", "Asset Tetap dan Inventaris"), 
	R_1100011000("1100011000", "Asset Tidak Berwujud"),
	R_1100011100("1100011100", "Agunan yang Diambil Alih"), 
	R_1100011200("1100011200", "Asset Pajak Tangguhan"),
	R_1100011300("1100011300", "Asset Lain-lain"),
//	R_1100020000 ("1100020000", "Liabilitas dan Ekuitas"),
//	R_1100030000 ("1100030000", "Liabilitas"),
	R_1100030100("1100030100", "Pinjaman yang Diterima"),
	R_1100030101("1100030101", "Pinjaman Pemerintah/Badan Layanan Umum (BLU)"),
	R_1100030102("1100030102", "Pinjaman Luar Negeri"), 
	R_1100030103("1100030103", "Pinjaman Bank"),
	R_1100030104("1100030104", "Pinjaman Non Bank"), 
	R_1100030105("1100030105", "Pendanaan Syariah"),
	R_1100030106("1100030106", "Pinjaman Subordinasi"), 
	R_1100030107("1100030107", "Pinjaman Lain-lain"),
	R_1100030200("1100030200", "Surat Berharga yang Diterbitkan"), 
	R_1100030201("1100030201", "Obligasi"),
	R_1100030202("1100030202", "Medium Term Notes (MTN)"), 
	R_1100030203("1100030203", "Sukuk"),
	R_1100030204("1100030204", "Surat Berharga Lainnya"), 
	R_1100030300("1100030300", "Hutang Pajak"),
	R_1100030400("1100030400", "Dana Cadangan Angsuran"), 
	R_1100030401("1100030401", "Dana Cadangan Nasabah"),
	R_1100030402("1100030402", "Uang Pertanggung Jawaban"), 
	R_1100030500("1100030500", "Titipan Dana"),
	R_1100030600("1100030600", "Beban yang Masih Harus Dibayar"),
	R_1100030700("1100030700", "Liabilitas Imbalan Kerja"), 
	R_1100030800("1100030800", "Liabilitas Lain-lain"),
	R_1100040000("1100040000", "Total Liabilitas"),
//	R_1100050000 ("1100050000", "Ekuitas"),
	R_1100050100("1100050100", "Modal"), 
	R_1100050101("1100050101", "Modal Saham"),
	R_1100050102("1100050102", "Penyertaan Modal Negara"), 
	R_1100050103("1100050103", "Hibah"),
	R_1100050200("1100050200", "Cadangan"),
	R_1100050201("1100050201", "Umum"), 
	R_1100050202("1100050202", "Bertujuan"),
	R_1100050300("1100050300", "Saldo Laba"), 
	R_1100050301("1100050301", "Laba (Rugi) Ditahan"),
	R_1100050302("1100050302", "Laba (Rugi) Periode Berjalan"), 
	R_1100050400("1100050400", "Komponen Ekuitas Lainnya"),
	R_1100050401("1100050401", "Keuntungan (Kerugian) atas Revaluasi Asset Tetap"),
	R_1100050402("1100050402", "Keuntungan (Kerugian) Akibat Pengukuran Kembali Asset Keuangan Tersedia untuk Dijual"),
	R_1100050403("1100050403", "Keuntungan (Kerugian) Aktuarial Atas Program Imbalan Kerja"),
	R_1100050404("1100050404", "Keuntungan (Kerugian) Atas Komponen Ekuitas Lainnya Sesuai Prinsip Standar Akutansi Keuangan"),
	R_1100060000("1100060000", "Total Ekuitas"), 
	R_1100070000("1100070000", "Total Liabilitas dan Ekuitas"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3003PosLbPnmk1100 eEnum : ER3003PosLbPnmk1100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3003PosLbPnmk1100.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3003PosLbPnmk1100.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 12 }));
	}
	
	public static SegmentValidation genRowValidation02A() {
		int[] fields = new int[] { 1, 2, 3, 4, 5, 10, 11, 13, 14, 15, 16, 17 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1100010000.key, UtilMetadata.genPlusRow(getObjects(), fields) + "-" + R_1100010800.key, 
				UtilMetadata.genMessage(R_1100010000.value, UtilMetadata.genPlusDesc(getObjects(), fields) + "-'" + R_1100010800.value + "'"));
	}
	
	public static SegmentValidation genRowValidation02B() {
		return UtilSegmentValidation.genEqualRowColumn("2", R_1100010000.key, "2", R_1100070000.key, 
				UtilMetadata.genMessage(R_1100010000.value, R_1100070000.value));
	}
	
	public static SegmentValidation genRowValidation03A() {
		return UtilSegmentValidation.genEqualsForm("2", R_1100010100.key, EFormLaporanBulanan.LB_1300.getCode(), "2", 
				ER3005PosLbPnmk1300.R_1300060000.getKey(), R_1100010100.value);
	}
	
	public static SegmentValidation genRowValidation03B() {
		return UtilSegmentValidation.genEqualsForm("2", R_1100010100.key, EFormLaporanBulanan.LB_2100.getCode(), "2", 
				ER3007PosLbPnmk2100.R_2100040000.getKey(), R_1100010100.value);
	}
	
	public static SegmentValidation genRowValidation04() {
		return UtilSegmentValidation.genEqualsFormulaForm("2", R_1100010200.key, "7", 
				UtilMetadata.genPlusRow(ER3008PosLbPnmk2200.getFormObjects()), 
				UtilMetadata.genMessage(R_1100010200.value, 
						UtilMetadata.genMessageFormTotal("Jumlah", EFormLaporanBulanan.LB_2200.getCode())));
	}
	
	public static SegmentValidation genRowValidation05() {
		return UtilSegmentValidation.genEqualsFormulaForm("2", R_1100010300.key, "14", 
				UtilMetadata.genPlusRow(ER3009PosLbPnmk2300.getFormObjects()), 
				UtilMetadata.genMessage(R_1100010300.value, 
						UtilMetadata.genMessageFormTotal("Jumlah", EFormLaporanBulanan.LB_2300.getCode())));
	}
	
	public static SegmentValidation genRowValidation07() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1100010500.key, UtilMetadata.genPlusRow(getObjects(), 6, 9), 
				UtilMetadata.genMessage(R_1100010500.value, UtilMetadata.genPlusDesc(getObjects(), 6, 9)));
	}
	
	public static SegmentValidation genRowValidation14() {
		return UtilSegmentValidation.genEqualsFormulaForm("2", R_1100010800.key, "3", 
				UtilMetadata.genPlusRow(ER3014PosLbPnmk2800.getFormObjects()), 
				UtilMetadata.genMessage(R_1100010800.value, 
						UtilMetadata.genMessageFormTotal("CKPN", EFormLaporanBulanan.LB_2800.getCode())));
	}
	
	public static SegmentValidation genRowValidation20A() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1100030100.key, UtilMetadata.genPlusRow(getObjects(), 19, 25), 
				UtilMetadata.genMessage(R_1100030100.value, UtilMetadata.genPlusDesc(getObjects(), 19, 25)));
	}
	
	public static SegmentValidation genRowValidation20B() {
		return UtilSegmentValidation.genEqualsFormulaForm("2", R_1100030100.key, "7", 
				UtilMetadata.genPlusRow(ER3013PosLbPnmk2700.getFormObjects()), 
				UtilMetadata.genMessage(R_1100030100.value, 
						UtilMetadata.genMessageFormTotal("Jumlah bulan laporan", EFormLaporanBulanan.LB_2700.getCode())));
	}
	
	public static SegmentValidation genRowValidation28A() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1100030200.key, UtilMetadata.genPlusRow(getObjects(), 27, 30), 
				UtilMetadata.genMessage(R_1100030200.value, UtilMetadata.genPlusDesc(getObjects(), 27, 30)));
	}
	
	public static SegmentValidation genRowValidation28B() {
		return UtilSegmentValidation.genEqualsFormulaForm("2", R_1100030200.key, "7", 
				UtilMetadata.genPlusRow(ER3012PosLbPnmk2600.getFormObjects()), 
				UtilMetadata.genMessage(R_1100030200.value, 
						UtilMetadata.genMessageFormTotal("Nominal", EFormLaporanBulanan.LB_2600.getCode())));
	}
	
	public static SegmentValidation genRowValidation34() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1100030400.key, UtilMetadata.genPlusRow(getObjects(), 33, 34), 
				UtilMetadata.genMessage(R_1100030400.value, UtilMetadata.genPlusDesc(getObjects(), 33, 34)));
	}
	
	public static SegmentValidation genRowValidation41() {
		int[] fields = new int[] { 18, 26, 31, 32, 35, 36, 37, 38 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1100040000.key, UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1100040000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation42() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1100050100.key, UtilMetadata.genPlusRow(getObjects(), 41, 43), 
				UtilMetadata.genMessage(R_1100050100.value, UtilMetadata.genPlusDesc(getObjects(), 41, 43)));
	}
	
	public static SegmentValidation genRowValidation46() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1100050200.key, UtilMetadata.genPlusRow(getObjects(), 45, 46), 
				UtilMetadata.genMessage(R_1100050200.value, UtilMetadata.genPlusDesc(getObjects(), 45, 46)));
	}
	
	public static SegmentValidation genRowValidation49() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1100050300.key, UtilMetadata.genPlusRow(getObjects(), 48, 49), 
				UtilMetadata.genMessage(R_1100050300.value, UtilMetadata.genPlusDesc(getObjects(), 48, 49)));
	}
	
	public static SegmentValidation genRowValidation51() {
		return UtilSegmentValidation.genEqualsForm("2", R_1100050302.key, EFormLaporanBulanan.LB_1200.getCode(), "2", 
				ER3004PosLbPnmk1200.R_1200090000.getKey(), R_1100050302.value);
	}
	
	public static SegmentValidation genRowValidation52() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1100050400.key, UtilMetadata.genPlusRow(getObjects(), 51, 54), 
				UtilMetadata.genMessage(R_1100050400.value, UtilMetadata.genPlusDesc(getObjects(), 51, 54)));
	}
	
	public static SegmentValidation genRowValidation57() {
		int[] fields = new int[] { 40, 44, 47, 50 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1100060000.key, UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1100060000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation58() {
		int[] fields = new int[] { 39, 55 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1100070000.key, UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1100070000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
}
