package id.go.ojk.pnmk.client.builder.field.lb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulananUus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3103PosLbPnmu1100 implements IObject<KeyValueString> {
	R_1100010000 ("1100010000", "Aset"),
	R_1100010100 ("1100010100", "Kas dan Setara Kas"),
	R_1100010200 ("1100010200", "Penempatan Pada Bank"),
	R_1100010300 ("1100010300", "Investasi pada Surat Berharga Syariah"),
	R_1100010400 ("1100010400", "Investasi pada Entitas Asosiasi"),
	R_1100010500 ("1100010500", "Piutang Pembiayaan Berdasarkan Prinsip Syariah"),
	R_1100010501 ("1100010501", "Pembiayaan Akad Murabahah"),
	R_1100010502 ("1100010502", "Pembiayaan Akad Mudharabah"),
	R_1100010503 ("1100010503", " Pembiayaan Akad Musyarakah"),
	R_1100010504 ("1100010504", " Piutang Bagi Hasil Mudharabah"),
	R_1100010505 ("1100010505", " Piutang Bagi Hasil Musyarakah"),
	R_1100010506 ("1100010506", " Piutang Akad Ijarah"),
	R_1100010507 ("1100010507", " Piutang atas Kegiatan Usaha dengan Akad Lain"),
	R_1100010600 ("1100010600", "Aset Ijarah"),
	R_1100010601 ("1100010601", "Aset Ijarah-Bruto"),
	R_1100010602 ("1100010602", "Akumulasi Penyusutan Aset Ijarah"),
	R_1100010700 ("1100010700", "Piutang Lain-lain"),
	R_1100010800 ("1100010800", "Pendapatan yang Masih Akan Diterima"),
	R_1100010900 ("1100010900", "Uang Muka dan Biaya Dibayar Dimuka"),
	R_1100011000 ("1100011000", "Cadangan Kerugian Penurunan Nilai"),
	R_1100011100 ("1100011100", "Aset Tetap dan Inventaris"),
	R_1100011200 ("1100011200", "Aset Tidak Berwujud"),
	R_1100011300 ("1100011300", "Agunan yang Diambil Alih"),
	R_1100011400 ("1100011400", "Aset Pajak Tangguhan"),
	R_1100011500 ("1100011500", "Aset Lain-lain"),
//	R_1100020000 ("1100020000", "Liabilitas dan Ekuitas"),
//	R_1100030000 ("1100030000", "Liabilitas"),
	R_1100030100 ("1100030100", "Pendanaan yang Diterima"),
	R_1100030101 ("1100030101", "Pendanaan Pemerintah/Badan Layanan Umum (BLU)"),
	R_1100030102 ("1100030102", "Pendanaan Luar Negeri"),
	R_1100030103 ("1100030103", "Pendanaan dari Bank Syariah"),
	R_1100030104 ("1100030104", "Pendanaan dari Lembaga Jasa Keuangan Nonbank Syariah"),
	R_1100030105 ("1100030105", "Pinjaman Subordinasi"),
	R_1100030106 ("1100030106", "Pendanaan Syariah Lain"),
	R_1100030200 ("1100030200", "Surat Berharga yang Diterbitkan"),
	R_1100030201 ("1100030201", "Medium Term Notes (MTN) Syariah"),
	R_1100030202 ("1100030202", "Sukuk"),
	R_1100030203 ("1100030203", "Surat Berharga Syariah Lainnya"),
	R_1100030300 ("1100030300", "Hutang Pajak"),
	R_1100030400 ("1100030400", "Dana Cadangan Angsuran"),
	R_1100030401 ("1100030401", "Dana Cadangan Nasabah"),
	R_1100030402 ("1100030402", "Uang Pertanggung Jawaban"),
	R_1100030500 ("1100030500", "Titipan Dana (Wadi'ah)"),
	R_1100030600 ("1100030600", "Denda Keterlambatan (ta'zir)"),
	R_1100030700 ("1100030700", "Beban yang Masih Harus Dibayar"),
	R_1100030800 ("1100030800", "Liabilitas Imbalan Kerja"),
	R_1100030900 ("1100030900", "Liabilitas Lain-lain"),
	R_1100040000 ("1100040000", "Total Liabilitas"),
//	R_1100050000 ("1100050000", "Ekuitas"),
	R_1100050100 ("1100050100", "Modal"),
	R_1100050101 ("1100050101", "Modal Kerja"),
	R_1100050200 ("1100050200", "Cadangan"),
	R_1100050201 ("1100050201", "Umum"),
	R_1100050202 ("1100050202", "Bertujuan"),
	R_1100050300 ("1100050300", "Saldo Laba"),
	R_1100050301 ("1100050301", "Laba (Rugi) Ditahan"),
	R_1100050302 ("1100050302", "Laba (Rugi) Periode Berjalan"),
	R_1100050400 ("1100050400", "Komponen Ekuitas Lainnya"),
	R_1100050401 ("1100050401", "Keuntungan (Kerugian) atas Revaluasi Aset Tetap"),
	R_1100050402 ("1100050402", "Keuntungan (Kerugian) Akibat Pengukuran Kembali Aset Keuangan Tersedia untuk Dijual"),
	R_1100050403 ("1100050403", "Keuntungan (Kerugian) Aktuarial Atas Program Imbalan Kerja"),
	R_1100050404 ("1100050404", "Keuntungan (Kerugian) Atas Komponen Ekuitas Lainnya Sesuai Prinsip Standar Akutansi Keuangan"),
	R_1100060000 ("1100060000", "Total Ekuitas"),
	R_1100070000 ("1100070000", "Total Liabilitas dan Ekuitas"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3103PosLbPnmu1100 eEnum : ER3103PosLbPnmu1100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3103PosLbPnmu1100.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3103PosLbPnmu1100.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 19 }));
	}
	
	public static SegmentValidation genRowValidation02A() {
		int[] fields = new int[] { 1, 2, 3, 4, 5, 13, 16, 17, 18, 20, 21, 22, 23, 24 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1100010000.key, UtilMetadata.genPlusRow(getObjects(), fields) + "-" + R_1100011000.key, 
				UtilMetadata.genMessage(R_1100010000.value, UtilMetadata.genPlusDesc(getObjects(), fields) + "-'" + R_1100011000.value + "'"));
	}
	
	public static SegmentValidation genRowValidation02B() {
		return UtilSegmentValidation.genEqualRowColumn("2", R_1100010000.key, "2", R_1100070000.key, 
				UtilMetadata.genMessage(R_1100010000.value, R_1100070000.value));
	}
	
	public static SegmentValidation genRowValidation03A() {
		return UtilSegmentValidation.genEqualsForm("2", R_1100010100.key, EFormLaporanBulananUus.LB_1300.getCode(), "2", 
				ER3105PosLbPnmu1300.R_1300060000.getKey(), R_1100010100.value);
	}
	
	public static SegmentValidation genRowValidation03B() {
		return UtilSegmentValidation.genEqualsForm("2", R_1100010100.key, EFormLaporanBulananUus.LB_2100.getCode(), "2", 
				ER3107PosLbPnmu2100.R_2100040000.getKey(), R_1100010100.value);
	}
	
	public static SegmentValidation genRowValidation04() {
		return UtilSegmentValidation.genEqualsFormulaForm("2", R_1100010200.key, "7", 
				UtilMetadata.genPlusRow(ER3108PosLbPnmu2200.getFormObjects()), 
				UtilMetadata.genMessage(R_1100010200.value, 
						UtilMetadata.genMessageFormTotal("Jumlah", EFormLaporanBulananUus.LB_2200.getCode())));
	}
	
	public static SegmentValidation genRowValidation05() {
		return UtilSegmentValidation.genEqualsFormulaForm("2", R_1100010300.key, "14", 
				UtilMetadata.genPlusRow(ER3109PosLbPnmu2300.getFormObjects()), 
				UtilMetadata.genMessage(R_1100010300.value, 
						UtilMetadata.genMessageFormTotal("Jumlah", EFormLaporanBulananUus.LB_2300.getCode())));
	}
	
	public static SegmentValidation genRowValidation07() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1100010500.key, UtilMetadata.genPlusRow(getObjects(), 6, 12), 
				UtilMetadata.genMessage(R_1100010500.value, UtilMetadata.genPlusDesc(getObjects(), 6, 12)));
	}
	
	public static SegmentValidation genRowValidation15A() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1100010600.key, UtilMetadata.genMinusRow(getObjects(), 14, 15), 
				UtilMetadata.genMessage(R_1100010600.value, UtilMetadata.genMinusDesc(getObjects(), 14, 15)));
	}
	
	public static SegmentValidation genRowValidation15B() {
		return UtilSegmentValidation.genEqualsFormulaForm("2", R_1100010600.key, "15", 
				UtilMetadata.genPlusRow(ER3111PosLbPnmu2500.getFormObjects()), 
				UtilMetadata.genMessage(R_1100010600.value, 
						UtilMetadata.genMessageFormTotal("Aset Ijarah Netto", EFormLaporanBulananUus.LB_2500.getCode())));
	}
	
	public static SegmentValidation genRowValidation17() {
		return UtilSegmentValidation.genEqualsFormulaForm("2", R_1100010602.key, "14", 
				UtilMetadata.genPlusRow(ER3111PosLbPnmu2500.getFormObjects()), 
				UtilMetadata.genMessage(R_1100010602.value, 
						UtilMetadata.genMessageFormTotal("Akumulasi Penyusutan", EFormLaporanBulananUus.LB_2500.getCode())));
	}
	
	public static SegmentValidation genRowValidation21() {
		return UtilSegmentValidation.genEqualsFormulaForm("2", R_1100011000.key, "3", 
				UtilMetadata.genPlusRow(ER3114PosLbPnmu2800.getFormObjects()), 
				UtilMetadata.genMessage(R_1100011000.value, 
						UtilMetadata.genMessageFormTotal("CKPN", EFormLaporanBulananUus.LB_2800.getCode())));
	}
	
	public static SegmentValidation genRowValidation27A() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1100030100.key, UtilMetadata.genPlusRow(getObjects(), 26, 31), 
				UtilMetadata.genMessage(R_1100030100.value, UtilMetadata.genPlusDesc(getObjects(), 26, 31)));
	}
	
	public static SegmentValidation genRowValidation27B() {
		return UtilSegmentValidation.genEqualsFormulaForm("2", R_1100030100.key, "8", 
				UtilMetadata.genPlusRow(ER3113PosLbPnmu2700.getFormObjects()), 
				UtilMetadata.genMessage(R_1100030100.value, 
						UtilMetadata.genMessageFormTotal("Jumlah bulan laporan", EFormLaporanBulananUus.LB_2700.getCode())));
	}
	
	public static SegmentValidation genRowValidation34A() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1100030200.key, UtilMetadata.genPlusRow(getObjects(), 33, 35), 
				UtilMetadata.genMessage(R_1100030200.value, UtilMetadata.genPlusDesc(getObjects(), 33, 35)));
	}
	
	public static SegmentValidation genRowValidation34B() {
		return UtilSegmentValidation.genEqualsFormulaForm("2", R_1100030200.key, "7", 
				UtilMetadata.genPlusRow(ER3112PosLbPnmu2600.getFormObjects()), 
				UtilMetadata.genMessage(R_1100030200.value, 
						UtilMetadata.genMessageFormTotal("Nominal", EFormLaporanBulananUus.LB_2600.getCode())));
	}
	
	public static SegmentValidation genRowValidation39() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1100030400.key, UtilMetadata.genPlusRow(getObjects(), 38, 39), 
				UtilMetadata.genMessage(R_1100030400.value, UtilMetadata.genPlusDesc(getObjects(), 38, 39)));
	}
	
	public static SegmentValidation genRowValidation47() {
		int[] fields = new int[] { 25, 32, 36, 37, 40, 41, 42, 43, 44 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1100040000.key, UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1100040000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation48() {
		return UtilSegmentValidation.genEqualRowColumn("2", R_1100050100.key, "2", R_1100050101.key, 
				UtilMetadata.genMessage(R_1100050100.value, R_1100050101.value));
	}
	
	public static SegmentValidation genRowValidation50() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1100050200.key, UtilMetadata.genPlusRow(getObjects(), 49, 50), 
				UtilMetadata.genMessage(R_1100050200.value, UtilMetadata.genPlusDesc(getObjects(), 49, 50)));
	}
	
	public static SegmentValidation genRowValidation53() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1100050300.key, UtilMetadata.genPlusRow(getObjects(), 52, 53), 
				UtilMetadata.genMessage(R_1100050300.value, UtilMetadata.genPlusDesc(getObjects(), 52, 53)));
	}
	
	public static SegmentValidation genRowValidation55() {
		return UtilSegmentValidation.genEqualsForm("2", R_1100050302.key, EFormLaporanBulananUus.LB_1200.getCode(), "2", 
				ER3104PosLbPnmu1200.R_1200090000.getKey(), R_1100050302.value);
	}
	
	public static SegmentValidation genRowValidation56() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1100050400.key, UtilMetadata.genPlusRow(getObjects(), 55, 58), 
				UtilMetadata.genMessage(R_1100050400.value, UtilMetadata.genPlusDesc(getObjects(), 55, 58)));
	}
	
	public static SegmentValidation genRowValidation61() {
		int[] fields = new int[] { 46, 48, 51, 54 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1100060000.key, UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1100060000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation62() {
		int[] fields = new int[] { 45, 59 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1100070000.key, UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1100070000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
}
