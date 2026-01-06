package id.go.ojk.asrjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3052PosLbAsrjk604 implements IObject<KeyValueString> {
//	R_6101000099 ("6101000099", "1. Pertanggungan Perorangan"),
//	R_6101010000 ("6101010000", "Ekawarsa"),
	R_6101010001 ("6101010001", "Premi Tunggal Ekawarsa"),
	R_6101010002 ("6101010002", "Premi Reguler Ekawarsa"),
//	R_6101020000 ("6101020000", "Kematian Berjangka Selain Ekawarsa"),
	R_6101020001 ("6101020001", "Premi Tunggal Kematian Berjangka Selain Ekawarsa"),
	R_6101020002 ("6101020002", "Premi Reguler Kematian Berjangka Selain Ekawarsa"),
//	R_6101030000 ("6101030000", "Dwiguna"),
	R_6101030001 ("6101030001", "Premi Tunggal Dwiguna"),
	R_6101030002 ("6101030002", "Premi Reguler Dwiguna"),
//	R_6101040000 ("6101040000", "Dwiguna Kombinasi"),
	R_6101040001 ("6101040001", "Premi Tunggal Dwiguna Kombinasi"),
	R_6101040002 ("6101040002", "Premi Reguler Dwiguna Kombinasi"),
//	R_6101050000 ("6101050000", "Seumur Hidup"),
	R_6101050001 ("6101050001", "Premi Tunggal Seumur Hidup"),
	R_6101050002 ("6101050002", "Premi Reguler Seumur Hidup"),
//	R_6101060000 ("6101060000", "Seumur Hidup Kombinasi"),
	R_6101060001 ("6101060001", "Premi Tunggal Seumur Hidup Kombinasi"),
	R_6101060002 ("6101060002", "Premi Reguler Seumur Hidup Kombinasi"),
//	R_6101070000 ("6101070000", "Anuitas Umum"),
	R_6101070001 ("6101070001", "Premi Tunggal Anuitas Umum"),
	R_6101070002 ("6101070002", "Premi Reguler Anuitas Umum"),
//	R_6101080000 ("6101080000", "Anuitas Dana Pensiun"),
	R_6101080001 ("6101080001", "Premi Tunggal Anuitas Dana Pensiun"),
	R_6101080002 ("6101080002", "Premi Reguler Anuitas Dana Pensiun"),
//	R_6101090000 ("6101090000", "Kecelakaan Diri"),
	R_6101090001 ("6101090001", "Premi Tunggal Kecelakaan Diri"),
	R_6101090002 ("6101090002", "Premi Reguler Kecelakaan Diri"),
//	R_6101100000 ("6101100000", "Kesehatan"),
	R_6101100001 ("6101100001", "Premi Tunggal Kesehatan"),
	R_6101100002 ("6101100002", "Premi Reguler Kesehatan"),
//	R_6101000000 ("6101000000", "Subtotal (1)"),
	R_6101000001 ("6101000001", "Premi Tunggal Subtotal (1)"),
	R_6101000002 ("6101000002", "Premi Reguler Subtotal (1)"),
//	R_6102000099 ("6102000099", "2. Pertanggungan Kumpulan"),
//	R_6102010000 ("6102010000", "Ekawarsa"),
	R_6102010001 ("6102010001", "Premi Tunggal Ekawarsa"),
	R_6102010002 ("6102010002", "Premi Reguler Ekawarsa"),
//	R_6102020000 ("6102020000", "Kematian Berjangka Selain Ekawarsa"),
	R_6102020001 ("6102020001", "Premi Tunggal Kematian Berjangka Selain Ekawarsa"),
	R_6102020002 ("6102020002", "Premi Reguler Kematian Berjangka Selain Ekawarsa"),
//	R_6102030000 ("6102030000", "Dwiguna"),
	R_6102030001 ("6102030001", "Premi Tunggal Dwiguna"),
	R_6102030002 ("6102030002", "Premi Reguler Dwiguna"),
//	R_6102040000 ("6102040000", "Dwiguna Kombinasi"),
	R_6102040001 ("6102040001", "Premi Tunggal Dwiguna Kombinasi"),
	R_6102040002 ("6102040002", "Premi Reguler Dwiguna Kombinasi"),
//	R_6102050000 ("6102050000", "Seumur Hidup"),
	R_6102050001 ("6102050001", "Premi Tunggal Seumur Hidup"),
	R_6102050002 ("6102050002", "Premi Reguler Seumur Hidup"),
//	R_6102060000 ("6102060000", "Seumur Hidup Kombinasi"),
	R_6102060001 ("6102060001", "Premi Tunggal Seumur Hidup Kombinasi"),
	R_6102060002 ("6102060002", "Premi Reguler Seumur Hidup Kombinasi"),
//	R_6102070000 ("6102070000", "Anuitas Umum"),
	R_6102070001 ("6102070001", "Premi Tunggal Anuitas Umum"),
	R_6102070002 ("6102070002", "Premi Reguler Anuitas Umum"),
//	R_6102080000 ("6102080000", "Anuitas Dana Pensiun"),
	R_6102080001 ("6102080001", "Premi Tunggal Anuitas Dana Pensiun"),
	R_6102080002 ("6102080002", "Premi Reguler Anuitas Dana Pensiun"),
//	R_6102090000 ("6102090000", "Kecelakaan Diri"),
	R_6102090001 ("6102090001", "Premi Tunggal Kecelakaan Diri"),
	R_6102090002 ("6102090002", "Premi Reguler Kecelakaan Diri"),
//	R_6102100000 ("6102100000", "Kesehatan"),
	R_6102100001 ("6102100001", "Premi Tunggal Kesehatan"),
	R_6102100002 ("6102100002", "Premi Reguler Kesehatan"),
//	R_6102000000 ("6102000000", "Subtotal (2)"),
	R_6102000001 ("6102000001", "Premi Tunggal Subtotal (2)"),
	R_6102000002 ("6102000002", "Premi Reguler Subtotal (2)"),
//	R_6100000099 ("6100000099", "Subtotal (1 + 2)"),
	R_6100000001 ("6100000001", "Premi Tunggal Subtotal (1 + 2)"),
	R_6100000002 ("6100000002", "Premi Reguler Subtotal (1 + 2)"),
	R_6100000000 ("6100000000", "Total"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3052PosLbAsrjk604 eEnum : ER3052PosLbAsrjk604.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3052PosLbAsrjk604.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3052PosLbAsrjk604.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 11), getObjects());
	}
	
	public static FieldValidation genFieldValidation10() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(5, 9), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 20, 21, 42, 43, 44, 45, 46 }));
	}
	
	public static FieldValidation genFieldValidation11() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 3), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 20, 21, 42, 43, 44, 45, 46 }));
	}
	
	public static SegmentValidation genValidationPremiTunggal1() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_6101000001.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18 }), 
				"Total premi tunggal 1|Penjumlahan premi tunggal 1");
	}
	
	public static SegmentValidation genValidationPremiReguler1() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_6101000002.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 }), 
				"Total premi reguler 1|Penjumlahan premi reguler 1");
	}
	
	public static SegmentValidation genValidationPremiTunggal2() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_6102000001.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 }), 
				"Total premi tunggal 2|Penjumlahan premi tunggal 2");
	}
	
	public static SegmentValidation genValidationPremiReguler2() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_6102000002.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 23, 25, 27, 29, 31, 33, 35, 37, 39, 41 }), 
				"Total premi reguler 2|Penjumlahan premi reguler 2");
	}
	
	public static SegmentValidation genValidationPremiTunggal12() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_6100000001.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 20, 42 }), 
				"Total premi tunggal 1 + 2|Penjumlahan premi tunggal 1 + 2");
	}
	
	public static SegmentValidation genValidationPremiReguler12() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_6100000002.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 21, 43 }), 
				"Total premi reguler 1 + 2|Penjumlahan premi reguler 1 + 2");
	}
	
	public static SegmentValidation genValidationPremi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_6100000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 44, 45 }), 
				"Total premi|Penjumlahan premi");
	}
}
