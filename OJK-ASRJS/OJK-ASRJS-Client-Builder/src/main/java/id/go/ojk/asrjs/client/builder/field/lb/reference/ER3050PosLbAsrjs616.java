package id.go.ojk.asrjs.client.builder.field.lb.reference;

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
public enum ER3050PosLbAsrjs616 implements IObject<KeyValueString> {
	R_6161010099 ("6161010099", "Pertanggungan Perorangan :"),
	R_6161010100 ("6161010100", "Ekawarsa"),
	R_6161010101 ("6161010101", "Kematian Berjangka"),
	R_6161010102 ("6161010102", "Dwiguna"),
	R_6161010103 ("6161010103", "Dwiguna Kombinasi"),
	R_6161010104 ("6161010104", "Seumur Hidup"),
	R_6161010105 ("6161010105", "Seumur Hidup Kombinasi"),
	R_6161010106 ("6161010106", "Anuitas Umum"),
	R_6161010107 ("6161010107", "Anuitas Dana Pensiun"),
	R_6161010108 ("6161010108", "Kecelakaan Diri"),
	R_6161010109 ("6161010109", "Kesehatan"),
	R_6161010110 ("6161010110", "Produk Investasi"),
	R_6161010111 ("6161010111", "Pertanggungan Kumpulan:"),
	R_6161010112 ("6161010112", "Ekawarsa"),
	R_6161010113 ("6161010113", "Kematian Berjangka"),
	R_6161010114 ("6161010114", "Dwiguna"),
	R_6161010115 ("6161010115", "Dwiguna Kombinasi"),
	R_6161010116 ("6161010116", "Seumur Hidup"),
	R_6161010117 ("6161010117", "Seumur Hidup Kombinasi"),
	R_6161010118 ("6161010118", "Anuitas Umum"),
	R_6161010119 ("6161010119", "Anuitas Dana Pensiun"),
	R_6161010120 ("6161010120", "Kecelakaan Diri"),
	R_6161010121 ("6161010121", "Kesehatan"),
	R_6161010122 ("6161010122", "Produk Investasi"),
	R_6161010123 ("6161010123", "JUMLAH"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3050PosLbAsrjs616 eEnum : ER3050PosLbAsrjs616.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 10), getObjects());
	}
	
	public static SegmentValidation genValidationPertanggunganPerorangan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_6161010099.key, 
				UtilMetadata.genPlusRow(getObjects(), 1, 11), "Total Pertanggungan Perorangan|Penjumlahan Pertanggungan Perorangan");
	}
	
	public static SegmentValidation genValidationPertanggunganKumpulan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_6161010111.key, 
				UtilMetadata.genPlusRow(getObjects(), 13, 23), "Total Pertanggungan Kumpulan|Penjumlahan Pertanggungan Kumpulan");
	}
	
	public static SegmentValidation genValidationJumlah() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_6161010123.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 12 }), "Jumlah|Penjumlahan detail");
	}
}
