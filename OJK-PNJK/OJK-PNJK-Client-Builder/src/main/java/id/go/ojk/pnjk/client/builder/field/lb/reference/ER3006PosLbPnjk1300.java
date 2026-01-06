package id.go.ojk.pnjk.client.builder.field.lb.reference;

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
public enum ER3006PosLbPnjk1300 implements IObject<KeyValueString> {
//	R_13000100000000 ("13000100000000", "Arus Kas Dari Aktivitas Operasional"),
//	R_13000101000000 ("13000101000000", "Arus Kas Masuk"),
	R_13000101010000 ("13000101010000", "Pendapatan IJP"),
	R_13000101020000 ("13000101020000", "Penerimaan Klaim Co-Guarantee"),
	R_13000101030000 ("13000101030000", "Penerimaan Klaim Penjaminan Ulang/Reasuransi"),
	R_13000101040000 ("13000101040000", "Penerimaan Operasional Lainnya"),
	R_13000101050000 ("13000101050000", "Penerimaan Non-Operasional"),
	R_13000101060000 ("13000101060000", "Total Arus Kas Masuk Dari Aktivitas Operasional"),
//	R_13000102000000 ("13000102000000", "Arus Kas Keluar"),
	R_13000102010000 ("13000102010000", "Pembayaran IJP Co-Guarantee /IJP Penjaminan Ulang/Premi Reasuransi"),
	R_13000102020000 ("13000102020000", "Pembayaran Klaim Kepada Penerima Jaminan"),
	R_13000102030000 ("13000102030000", "Pembayaran Beban Operasional Lainnya"),
	R_13000102040000 ("13000102040000", "Pembayaran Beban Non- Operasional Lainnya"),
	R_13000102050000 ("13000102050000", "Total Arus Kas Keluar Dari Aktivitas Operasional"),
	R_13000102060000 ("13000102060000", "Arus Kas Bersih Dari Aktivitas Operasional"),
//	R_13000200000000 ("13000200000000", "Arus Kas Dari Aktivitas Investasi"),
//	R_13000201000000 ("13000201000000", "Arus Kas Masuk"),
	R_13000201010000 ("13000201010000", "Penerimaan Hasil Investasi"),
	R_13000201020000 ("13000201020000", "Penerimaan Penjualan Aset Tetap"),
	R_13000201030000 ("13000201030000", "Penerimaan Hasil Penjualan Investasi"),
	R_13000201040000 ("13000201040000", "Total Arus Kas Masuk Dari Aktivitas Investasi"),
//	R_13000202000000 ("13000202000000", "Arus Kas Keluar"),
	R_13000202010000 ("13000202010000", "Penempatan Investasi Yang Diperkenankan"),
	R_13000202020000 ("13000202020000", "Perolehan Aset Tetap"),
	R_13000202030000 ("13000202030000", "Total Arus Kas Keluar Dari Aktivitas Investasi"),
	R_13000202040000 ("13000202040000", "Arus Kas Bersih Dari Aktivitas Investasi"),
//	R_13000300000000 ("13000300000000", "Arus Kas Dari Aktivitas Pendanaan"),
//	R_13000301000000 ("13000301000000", "Arus Kas Masuk"),
	R_13000301010000 ("13000301010000", "Penerimaan Setoran Modal"),
	R_13000301020000 ("13000301020000", "Penerbitan Obligasi Wajib Konversi"),
	R_13000301030000 ("13000301030000", "Penerimaan Lainnya"),
	R_13000301040000 ("13000301040000", "Total Arus Kas Masuk Dari Aktivitas Pendanaan"),
//	R_13000302000000 ("13000302000000", "Arus Kas Keluar"),
	R_13000302010000 ("13000302010000", "Pembayaran Dividen"),
	R_13000302020000 ("13000302020000", "Pengeluaran Lainnya"),
	R_13000302030000 ("13000302030000", "Total Arus Kas Keluar Dari Aktivitas Pendanaan"),
	R_13000303000000 ("13000303000000", "Arus Kas Bersih Dari Aktivitas Pendanaan"),
	R_13000400000000 ("13000400000000", "Kenaikan (Penurunan) Kas"),
	R_13000500000000 ("13000500000000", "Saldo Kas Awal Tahun"),
	R_13000600000000 ("13000600000000", "Saldo Kas Akhir Tahun"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3006PosLbPnjk1300 eEnum : ER3006PosLbPnjk1300.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3006PosLbPnjk1300.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3006PosLbPnjk1300.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationNumericNegative() {
		return UtilSegmentValidation.genRegexNumericNegative("2",
				UtilMetadata.genPipeRow(getObjects()));
	}
	
	public static SegmentValidation genValidation07() {
		return UtilSegmentValidation.genEqualsFormula("2", R_13000101060000.key, UtilMetadata.genPlusRow(getObjects(), 0, 4),
				UtilMetadata.genMessage(R_13000101060000.value, UtilMetadata.genPlusDesc(getObjects(), 0, 4)));
	}
	
	public static SegmentValidation genValidation12() {
		return UtilSegmentValidation.genEqualsFormula("2", R_13000102050000.key, UtilMetadata.genPlusRow(getObjects(), 6, 9),
				UtilMetadata.genMessage(R_13000102050000.value, UtilMetadata.genPlusDesc(getObjects(), 6, 9)));
	}
	
	public static SegmentValidation genValidation13() {
		int[] field = new int[] { 5, 10 };
		return UtilSegmentValidation.genEqualsFormula("2", R_13000102060000.key, UtilMetadata.genMinusRow(getObjects(), field),
				UtilMetadata.genMessage(R_13000102060000.value, UtilMetadata.genMinusDesc(getObjects(), field)));
	}
	
	public static SegmentValidation genValidation17() {
		return UtilSegmentValidation.genEqualsFormula("2", R_13000201040000.key, UtilMetadata.genPlusRow(getObjects(), 12, 14),
				UtilMetadata.genMessage(R_13000201040000.value, UtilMetadata.genPlusDesc(getObjects(), 12, 14)));
	}
	
	public static SegmentValidation genValidation20() {
		return UtilSegmentValidation.genEqualsFormula("2", R_13000202030000.key, UtilMetadata.genPlusRow(getObjects(), 16, 17),
				UtilMetadata.genMessage(R_13000202030000.value, UtilMetadata.genPlusDesc(getObjects(), 16, 17)));
	}
	
	public static SegmentValidation genValidation21() {
		int[] field = new int[] { 15, 18 };
		return UtilSegmentValidation.genEqualsFormula("2", R_13000202040000.key, UtilMetadata.genMinusRow(getObjects(), field),
				UtilMetadata.genMessage(R_13000202040000.value, UtilMetadata.genMinusDesc(getObjects(), field)));
	}
	
	public static SegmentValidation genValidation26() {
		return UtilSegmentValidation.genEqualsFormula("2", R_13000301040000.key, UtilMetadata.genPlusRow(getObjects(), 20, 22),
				UtilMetadata.genMessage(R_13000301040000.value, UtilMetadata.genPlusDesc(getObjects(), 20, 22)));
	}
	
	public static SegmentValidation genValidation29() {
		return UtilSegmentValidation.genEqualsFormula("2", R_13000302030000.key, UtilMetadata.genPlusRow(getObjects(), 24, 25),
				UtilMetadata.genMessage(R_13000302030000.value, UtilMetadata.genPlusDesc(getObjects(), 24, 25)));
	}
	
	public static SegmentValidation genValidation30() {
		int[] field = new int[] { 23, 26 };
		return UtilSegmentValidation.genEqualsFormula("2", R_13000303000000.key, UtilMetadata.genMinusRow(getObjects(), field),
				UtilMetadata.genMessage(R_13000303000000.value, UtilMetadata.genMinusDesc(getObjects(), field)));
	}
	
	public static SegmentValidation genValidation31() {
		int[] field = new int[] { 11, 19, 27 };
		return UtilSegmentValidation.genEqualsFormula("2", R_13000400000000.key, UtilMetadata.genPlusRow(getObjects(), field),
				UtilMetadata.genMessage(R_13000400000000.value, UtilMetadata.genPlusDesc(getObjects(), field)));
	}
	
	public static SegmentValidation genValidation33() {
		return UtilSegmentValidation.genEqualsFormula("2", R_13000600000000.key, UtilMetadata.genPlusRow(getObjects(), 28, 29),
				UtilMetadata.genMessage(R_13000600000000.value, UtilMetadata.genPlusDesc(getObjects(), 28, 29)));
	}
}
