package id.go.ojk.asrjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3059PosLbAsrjk616 implements IObject<KeyValueString> {
//	R_6161000099 ("6161000099", "1. Pertanggungan Perorangan"),
	R_6161010000 ("6161010000", "Ekawarsa"),
	R_6161020000 ("6161020000", "Kematian Berjangka Selain Ekawarsa"),
	R_6161030000 ("6161030000", "Dwiguna"),
	R_6161040000 ("6161040000", "Dwiguna Kombinasi"),
	R_6161050000 ("6161050000", "Seumur Hidup"),
	R_6161060000 ("6161060000", "Seumur Hidup Kombinasi"),
	R_6161070000 ("6161070000", "Anuitas Umum"),
	R_6161080000 ("6161080000", "Anuitas Dana Pensiun"),
	R_6161090000 ("6161090000", "Kecelakaan Diri"),
	R_6161100000 ("6161100000", "Kesehatan"),
	R_6161110000 ("6161110000", "Produk Investasi"),
	R_6161000000 ("6161000000", "Subtotal (1)"),
//	R_6162000099 ("6162000099", "2. Pertanggungan Kumpulan"),
	R_6162010000 ("6162010000", "Ekawarsa"),
	R_6162020000 ("6162020000", "Kematian Berjangka Selain Ekawarsa"),
	R_6162030000 ("6162030000", "Dwiguna"),
	R_6162040000 ("6162040000", "Dwiguna Kombinasi"),
	R_6162050000 ("6162050000", "Seumur Hidup"),
	R_6162060000 ("6162060000", "Seumur Hidup Kombinasi"),
	R_6162070000 ("6162070000", "Anuitas Umum"),
	R_6162080000 ("6162080000", "Anuitas Dana Pensiun"),
	R_6162090000 ("6162090000", "Kecelakaan Diri"),
	R_6162100000 ("6162100000", "Kesehatan"),
	R_6162110000 ("6162110000", "Produk Investasi"),
	R_6162000000 ("6162000000", "Subtotal (2)"),
	R_6160000000 ("6160000000", "Jumlah ((1) + (2))"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3059PosLbAsrjk616 eEnum : ER3059PosLbAsrjk616.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3059PosLbAsrjk616.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3059PosLbAsrjk616.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 10), getObjects());
	}
	
	public static SegmentValidation genValidationTotal1() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_6161000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 10), "Subtotal (1)|Penjumlahan detail 1");
	}
	
	public static SegmentValidation genValidationTotal2() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_6162000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 12, 22), "Subtotal (2)|Penjumlahan detail 2");
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_6160000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 11, 23 }), "Total 1 + 2|Penjumlahan detail 1 + 2");
	}
}
