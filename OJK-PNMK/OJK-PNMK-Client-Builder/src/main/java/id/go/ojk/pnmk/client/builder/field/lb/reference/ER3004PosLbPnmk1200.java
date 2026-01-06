package id.go.ojk.pnmk.client.builder.field.lb.reference;

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
public enum ER3004PosLbPnmk1200 implements IObject<KeyValueString> {
	R_1200010000("1200010000", "Pendapatan Operasional"), 
	R_1200010100("1200010100", "Pendapatan ULaMM"),
	R_1200010200("1200010200", "Pendapatan Mekaar"), 
	R_1200010300("1200010300", "Pendapatan Jasa Manajemen"),
	R_1200010400("1200010400", "Pendapatan Lain-lain"), 
	R_1200020000("1200020000", "Beban Operasional"),
	R_1200020100("1200020100", "Beban Bunga"), 
	R_1200020200("1200020200", "Provisi dan Komisi"),
	R_1200030000("1200030000", "Pendapatan Operasional Lainnya"),
	R_1200030100("1200030100", "Pendapatan Bunga Inventasi"),
	R_1200030200("1200030200", "Pendapatan Investasi Selain Bunga"),
	R_1200030300("1200030300", "Keuntungan Transaksi Surat Berharga-Bersih"), 
	R_1200030400("1200030400", "Lain-lain"),
	R_1200040000("1200040000", "Beban Operasional Lainnya"), 
	R_1200040100("1200040100", "Umum dan Administrasi"),
	R_1200040200("1200040200", "Gaji dan Tunjangan"), 
	R_1200040300("1200040300", "Pendidikan dan Pelatihan"),
	R_1200040400("1200040400", "Sewa Kantor"), 
	R_1200040500("1200040500", "Penjamin Kredit/Asuransi Kredit"),
	R_1200040600("1200040600", "Amortisasi dan Depresiasi"),
	R_1200040700("1200040700", "Penyisihan Penghapusan Piutang"), 
	R_1200040800("1200040800", "Lain-lain"),
	R_1200050000("1200050000", "Laba Rugi Operasional"), 
	R_1200060000("1200060000", "Pendapatan/Beban Non Operasional"),
	R_1200060100("1200060100", "Pendapatan Non Operasional"), 
	R_1200060200("1200060200", "Beban Non Operasional"),
	R_1200070000("1200070000", "Laba (Rugi) Sebelum Pajak Penghasilan"),
	R_1200080000("1200080000", "Pajak Penghasilan"), 
	R_1200080100("1200080100", "Pajak Kini"),
	R_1200080200("1200080200", "Pajak Tangguhan"), 
	R_1200080201("1200080201", "Penghasilan Pajak Tangguhan"),
	R_1200080202("1200080202", "Beban Pajak Tangguhan"), 
	R_1200090000("1200090000", "Laba (Rugi) Periode Berjalan"),
	R_1200100000("1200100000", "Penghasilan (Beban) Komprehensif Lain Periode Berjalan"),
	R_1200110000("1200110000", "Laba (Rugi) Komprehensif"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3004PosLbPnmk1200 eEnum : ER3004PosLbPnmk1200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3004PosLbPnmk1200.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3004PosLbPnmk1200.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genRowValidation02() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200010000.key, UtilMetadata.genPlusRow(getObjects(), 1, 4), 
				UtilMetadata.genMessage(R_1200010000.value, UtilMetadata.genPlusDesc(getObjects(), 1, 4)));
	}
	
	public static SegmentValidation genRowValidation07() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200020000.key, UtilMetadata.genPlusRow(getObjects(), 6, 7), 
				UtilMetadata.genMessage(R_1200020000.value, UtilMetadata.genPlusDesc(getObjects(), 6, 7)));
	}
	
	public static SegmentValidation genRowValidation10() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200030000.key, UtilMetadata.genPlusRow(getObjects(), 9, 12), 
				UtilMetadata.genMessage(R_1200030000.value, UtilMetadata.genPlusDesc(getObjects(), 9, 12)));
	}
	
	public static SegmentValidation genRowValidation15() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200040000.key, UtilMetadata.genPlusRow(getObjects(), 14, 21), 
				UtilMetadata.genMessage(R_1200040000.value, UtilMetadata.genPlusDesc(getObjects(), 14, 21)));
	}
	
	public static SegmentValidation genRowValidation24() {
		int[] fields1 = new int[] { 0, 8 };
		int[] fields2 = new int[] { 5, 13 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1200050000.key,
				UtilMetadata.genPlusRow(getObjects(), fields1) + "-"
						+ UtilMetadata.genMinusRow(getObjects(), fields2),
				UtilMetadata.genMessage(R_1200050000.value, UtilMetadata.genPlusDesc(getObjects(), fields1)
						+ "-" + UtilMetadata.genMinusDesc(getObjects(), fields2)));
	}
	
	public static SegmentValidation genRowValidation25() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200060000.key, UtilMetadata.genPlusRow(getObjects(), 24, 25), 
				UtilMetadata.genMessage(R_1200060000.value, UtilMetadata.genPlusDesc(getObjects(), 24, 25)));
	}
	
	public static SegmentValidation genRowValidation28() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200070000.key, UtilMetadata.genPlusRow(getObjects(), 22, 23), 
				UtilMetadata.genMessage(R_1200070000.value, UtilMetadata.genPlusDesc(getObjects(), 22, 23)));
	}
	
	public static SegmentValidation genRowValidation29() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200080000.key, UtilMetadata.genPlusRow(getObjects(), 28, 29), 
				UtilMetadata.genMessage(R_1200080000.value, UtilMetadata.genPlusDesc(getObjects(), 28, 29)));
	}
	
	public static SegmentValidation genRowValidation31() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200080200.key, UtilMetadata.genPlusRow(getObjects(), 30, 31), 
				UtilMetadata.genMessage(R_1200080200.value, UtilMetadata.genPlusDesc(getObjects(), 30, 31)));
	}
	
	public static SegmentValidation genRowValidation34() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200090000.key, UtilMetadata.genPlusRow(getObjects(), 26, 27), 
				UtilMetadata.genMessage(R_1200090000.value, UtilMetadata.genPlusDesc(getObjects(), 26, 27)));
	}
	
	public static SegmentValidation genRowValidation36() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1200110000.key, UtilMetadata.genPlusRow(getObjects(), 32, 33), 
				UtilMetadata.genMessage(R_1200110000.value, UtilMetadata.genPlusDesc(getObjects(), 32, 33)));
	}
}
