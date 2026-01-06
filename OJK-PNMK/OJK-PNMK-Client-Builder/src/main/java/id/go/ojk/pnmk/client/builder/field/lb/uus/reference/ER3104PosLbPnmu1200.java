package id.go.ojk.pnmk.client.builder.field.lb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3104PosLbPnmu1200 implements IObject<KeyValueString> {
	R_1200010000 ("1200010000", "Pendapatan Operasional"),
	R_1200010100 ("1200010100", "Pendapatan Margin Murabahah"),
	R_1200010200 ("1200010200", "Pendapatan Bagi Hasil Mudharabah"),
	R_1200010300 ("1200010300", "Pendapatan Bagi Hasil Musyarakah"),
	R_1200010400 ("1200010400", "Pendapatan Ujrah"),
	R_1200010500 ("1200010500", "Pendapatan Kegiatan Usaha dengan Akad Lain"),
	R_1200020000 ("1200020000", "Beban Operasional"),
	R_1200020100 ("1200020100", "Beban Bagi Hasil Pendanaan Pemerintah/Badan Layanan Umum (BLU)"),
	R_1200020200 ("1200020200", "Beban Bagi Hasil Pendanaan Luar Negeri "),
	R_1200020300 ("1200020300", "Beban Bagi Hasil Pendanaan Bank Syariah"),
	R_1200020400 ("1200020400", "Beban Bagi Hasil Pendanaan Lembaga Jasa Keuangan Nonbank Syariah"),
	R_1200020500 ("1200020500", "Beban Bagi Hasil Pendanaan Syariah Lain-lain"),
	R_1200020600 ("1200020600", "Beban Bagi Hasil Surat Berharga Syariah "),
	R_1200020700 ("1200020700", "Beban Provisi dan Komisi"),
	R_1200020800 ("1200020800", "Beban Pemasaran dan Penagihan "),
	R_1200030000 ("1200030000", "Pendapatan Operasional Lainnya"),
	R_1200030100 ("1200030100", "Pendapatan Administrasi dan Provisi "),
	R_1200030200 ("1200030200", "Pendapatan Imbal Hasil Investasi"),
	R_1200030300 ("1200030300", "Pendapatan Investasi Lain "),
	R_1200030400 ("1200030400", "Keuntungan Transaksi Surat Berharga Syariah-Bersih"),
	R_1200030500 ("1200030500", "Pendapatan Ganti Rugi (Ta'widh)"),
	R_1200030600 ("1200030600", "Pendapatan Lain-lain "),
	R_1200040000 ("1200040000", "Beban Operasional Lainnya"),
	R_1200040100 ("1200040100", "Umum dan Administrasi"),
	R_1200040200 ("1200040200", "Gaji dan Tunjangan"),
	R_1200040300 ("1200040300", "Pendidikan dan Pelatihan"),
	R_1200040400 ("1200040400", "Sewa Kantor"),
	R_1200040500 ("1200040500", "Penjaminan/Asuransi"),
	R_1200040600 ("1200040600", "Amortisasi dan Depresiasi Aset"),
	R_1200040700 ("1200040700", "Penyisihan Penghapusan Piutang"),
	R_1200040701 ("1200040701", "Murabahah"),
	R_1200040702 ("1200040702", "Mudharabah"),
	R_1200040703 ("1200040703", "Musyarakah"),
	R_1200040704 ("1200040704", "Ijarah"),
	R_1200040705 ("1200040705", "Kegiatan Usaha dengan Akad Lain"),
	R_1200040800 ("1200040800", "Lain-lain"),
	R_1200050000 ("1200050000", "Laba Rugi Operasional"),
	R_1200060000 ("1200060000", "Pendapatan/Beban Non Operasional"),
	R_1200060100 ("1200060100", "Pendapatan Non Operasional"),
	R_1200060200 ("1200060200", "Beban Non Operasional"),
	R_1200070000 ("1200070000", "Laba (Rugi) Sebelum Pajak Penghasilan"),
	R_1200080000 ("1200080000", "Pajak Penghasilan"),
	R_1200080100 ("1200080100", "Pajak Kini"),
	R_1200080200 ("1200080200", "Pajak Tangguhan"),
	R_1200080201 ("1200080201", "Penghasilan Pajak Tangguhan"),
	R_1200080202 ("1200080202", "Beban Pajak Tangguhan"),
	R_1200090000 ("1200090000", "Laba (Rugi) Periode Berjalan"),
	R_1200100000 ("1200100000", "Penghasilan (Beban) Komprehensif Lain Periode Berjalan"),
	R_1200110000 ("1200110000", "Laba (Rugi) Komprehensif"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3104PosLbPnmu1200 eEnum : ER3104PosLbPnmu1200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3104PosLbPnmu1200.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3104PosLbPnmu1200.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genRowValidation02() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200010000.key, UtilMetadata.genPlusRow(getObjects(), 1, 5), 
				UtilMetadata.genMessage(R_1200010000.value, UtilMetadata.genPlusDesc(getObjects(), 1, 5)));
	}
	
	public static SegmentValidation genRowValidation08() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200020000.key, UtilMetadata.genPlusRow(getObjects(), 7, 14), 
				UtilMetadata.genMessage(R_1200020000.value, UtilMetadata.genPlusDesc(getObjects(), 7, 14)));
	}
	
	public static SegmentValidation genRowValidation17() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200030000.key, UtilMetadata.genPlusRow(getObjects(), 16, 21), 
				UtilMetadata.genMessage(R_1200030000.value, UtilMetadata.genPlusDesc(getObjects(), 16, 21)));
	}
	
	public static SegmentValidation genRowValidation24() {
		int[] fields = {23, 24, 25, 26, 27, 28, 29, 35};
		return UtilSegmentValidation.genEqualsFormula("2", R_1200040000.key, UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1200040000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation31() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200040700.key, UtilMetadata.genPlusRow(getObjects(), 30, 34), 
				UtilMetadata.genMessage(R_1200040700.value, UtilMetadata.genPlusDesc(getObjects(), 30, 34)));
	}
	
	public static SegmentValidation genRowValidation38() {
		int[] fields1 = new int[] { 0, 15 };
		int[] fields2 = new int[] { 6, 22 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1200050000.key,
				UtilMetadata.genPlusRow(getObjects(), fields1) + "-" + UtilMetadata.genMinusRow(getObjects(), fields2),
				UtilMetadata.genMessage(R_1200050000.value, UtilMetadata.genPlusDesc(getObjects(), fields1) + "-"
						+ UtilMetadata.genMinusDesc(getObjects(), fields2)));
	}
	
	public static SegmentValidation genRowValidation39() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200060000.key, UtilMetadata.genPlusRow(getObjects(), 38, 39), 
				UtilMetadata.genMessage(R_1200060000.value, UtilMetadata.genPlusDesc(getObjects(), 38, 39)));
	}
	
	public static SegmentValidation genRowValidation42() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200070000.key, UtilMetadata.genPlusRow(getObjects(), 36, 37), 
				UtilMetadata.genMessage(R_1200070000.value, UtilMetadata.genPlusDesc(getObjects(), 36, 37)));
	}
	
	public static SegmentValidation genRowValidation43() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200080000.key, UtilMetadata.genPlusRow(getObjects(), 42, 43), 
				UtilMetadata.genMessage(R_1200080000.value, UtilMetadata.genPlusDesc(getObjects(), 42, 43)));
	}
	
	public static SegmentValidation genRowValidation45() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200080200.key, UtilMetadata.genPlusRow(getObjects(), 44, 45), 
				UtilMetadata.genMessage(R_1200080200.value, UtilMetadata.genPlusDesc(getObjects(), 44, 45)));
	}
	
	public static SegmentValidation genRowValidation48() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200090000.key, UtilMetadata.genPlusRow(getObjects(), 40, 41), 
				UtilMetadata.genMessage(R_1200090000.value, UtilMetadata.genPlusDesc(getObjects(), 40, 41)));
	}
	
	public static SegmentValidation genRowValidation50() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200110000.key, UtilMetadata.genPlusRow(getObjects(), 46, 47), 
				UtilMetadata.genMessage(R_1200110000.value, UtilMetadata.genPlusDesc(getObjects(), 46, 47)));
	}
}
