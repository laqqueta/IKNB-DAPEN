package id.go.ojk.asrjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3043PosLbAsrjs604 implements IObject<KeyValueString> {
//	R_6040000099 ("6040000099", "1. Pertanggungan Perorangan Kontribusi Tunggal"),
//	R_6040000100 ("6040000100", "Ekawarsa"),
	R_6040000101 ("6040000101", "Kontribusi Tunggal"),
	R_6040000102 ("6040000102", "Kontribusi Reguler"),
//	R_6040000103 ("6040000103", "Kematian Berjangka selain Ekawarsa"),
	R_6040000104 ("6040000104", "Kontribusi Tunggal"),
	R_6040000105 ("6040000105", "Kontribusi Reguler"),
//	R_6040000106 ("6040000106", "Dwiguna"),
	R_6040000107 ("6040000107", "Kontribusi Tunggal"),
	R_6040000108 ("6040000108", "Kontribusi Reguler"),
//	R_6040000109 ("6040000109", "Dwiguna Kombinasi"),
	R_6040000110 ("6040000110", "Kontribusi Tunggal"),
	R_6040000111 ("6040000111", "Kontribusi Reguler"),
//	R_6040000112 ("6040000112", "Seumur Hidup"),
	R_6040000113 ("6040000113", "Kontribusi Tunggal"),
	R_6040000114 ("6040000114", "Kontribusi Reguler"),
//	R_6040000115 ("6040000115", "Seumur Hidup Kombinasi"),
	R_6040000116 ("6040000116", "Kontribusi Tunggal"),
	R_6040000117 ("6040000117", "Kontribusi Reguler"),
//	R_6040000118 ("6040000118", "Anuitas Umum"),
	R_6040000119 ("6040000119", "Kontribusi Tunggal"),
	R_6040000120 ("6040000120", "Kontribusi Reguler"),
//	R_6040000121 ("6040000121", "100 Dana Pensiun"),
	R_6040000122 ("6040000122", "Kontribusi Tunggal"),
	R_6040000123 ("6040000123", "Kontribusi Reguler"),
//	R_6040000124 ("6040000124", "Kecelakaan Diri"),
	R_6040000125 ("6040000125", "Kontribusi Tunggal"),
	R_6040000126 ("6040000126", "Kontirbussi Reguler"),
//	R_6040000127 ("6040000127", "Kesehatan"),
	R_6040000128 ("6040000128", "Kontribusi Tunggal"),
	R_6040000129 ("6040000129", "Kontribusi Reguler"),
//	R_6040000130 ("6040000130", "Sub Total (1)"),
	R_6040000131 ("6040000131", "Kontribusi Tunggal"),
	R_6040000132 ("6040000132", "Kontribusi Reguler"),
//	R_6040000133 ("6040000133", "2. Pertanggungan Kumpulan"),
//	R_6040000134 ("6040000134", "Ekawarsa"),
	R_6040000135 ("6040000135", "Kontribusi Tunggal"),
	R_6040000136 ("6040000136", "Kontribusi Reguler"),
//	R_6040000137 ("6040000137", "Kematian Berjangka selain Ekawarsa"),
	R_6040000138 ("6040000138", "Kontribusi Tunggal"),
	R_6040000139 ("6040000139", "Kontribusi Reguler"),
//	R_6040000140 ("6040000140", "Dwiguna"),
	R_6040000141 ("6040000141", "Kontribusi Tunggal"),
	R_6040000142 ("6040000142", "Kontribusi Reguler"),
//	R_6040000143 ("6040000143", "Dwiguna Kombinasi"),
	R_6040000144 ("6040000144", "Kontribusi Tunggal"),
	R_6040000145 ("6040000145", "Kontribusi Reguler"),
//	R_6040000146 ("6040000146", "Seumur Hidup"),
	R_6040000147 ("6040000147", "Kontribusi Tunggal"),
	R_6040000148 ("6040000148", "Kontribusi Reguler"),
//	R_6040000149 ("6040000149", "Seumur Hidup Kombinasi"),
	R_6040000150 ("6040000150", "Kontribusi Tunggal"),
	R_6040000151 ("6040000151", "Kontribusi Reguler"),
//	R_6040000152 ("6040000152", "Anuitas Umum"),
	R_6040000153 ("6040000153", "Kontribusi Tunggal"),
	R_6040000154 ("6040000154", "Kontribusi Reguler"),
//	R_6040000155 ("6040000155", "Anuitas Dana Pensiun"),
	R_6040000156 ("6040000156", "Kontribusi Tunggal"),
	R_6040000157 ("6040000157", "Kontribusi Reguler"),
//	R_6040000158 ("6040000158", "Kecelakaan Diri"),
	R_6040000159 ("6040000159", "Kontribusi Tunggal"),
	R_6040000160 ("6040000160", "Kontribusi Reguler"),
//	R_6040000161 ("6040000161", "Kesehatan"),
	R_6040000162 ("6040000162", "Kontribusi Tunggal"),
	R_6040000163 ("6040000163", "Kontribusi Reguler"),
//	R_6040000164 ("6040000164", "Sub Total (2)"),
	R_6040000165 ("6040000165", "Kontribusi Tunggal"),
	R_6040000166 ("6040000166", "Kontribusi Reguler"),
//	R_6040000167 ("6040000167", "Sub Total (1 + 2)"),
	R_6040000168 ("6040000168", "Kontribusi Tunggal"),
	R_6040000169 ("6040000169", "Kontribusi Reguler"),
	R_6040000170 ("6040000170", "Total"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3043PosLbAsrjs604 eEnum : ER3043PosLbAsrjs604.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 11), getObjects());
	}
	
	public static ConditionalRequired genConditional3() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41, 43, 44, 45, 46 }));
	}
	
	public static FieldValidation genFieldValidation11() {
		return UtilFieldValidation.genEqualsPosFormula("4+10", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 20, 21, 42, 43, 44, 45, 46 }));
	}
	
	public static SegmentValidation genValidationKontribusiTunggalSubTotal1() {
		return UtilSegmentValidation.genEqualsFormula("2|4|5|6|7|8|9|10|11", R_6040000131.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18 }), 
				"Total Kontribusi Tunggal Sub Total (1)|Penjumlahan Kontribusi Tunggal Sub Total (1)");
	}
	
	public static SegmentValidation genValidationKontribusiRegulerSubTotal1() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_6040000132.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 }), 
				"Total Kontribusi Reguler Sub Total (1)|Penjumlahan Kontribusi Reguler Sub Total (1)");
	}
	
	public static SegmentValidation genValidationKontribusiTunggalSubTotal2() {
		return UtilSegmentValidation.genEqualsFormula("2|4|5|6|7|8|9|10|11", R_6040000165.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 }), 
				"Total Kontribusi Tunggal Sub Total (2)|Penjumlahan Kontribusi Tunggal Sub Total (2)");
	}
	
	public static SegmentValidation genValidationKontribusiRegulerSubTotal2() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_6040000166.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 23, 25, 27, 29, 31, 33, 35, 37, 39, 41 }), 
				"Total Kontribusi Reguler Sub Total (2)|Penjumlahan Kontribusi Reguler Sub Total (2)");
	}
	
	public static SegmentValidation genValidationKontribusiTunggalSubTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_6040000168.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 20, 42 }), 
				"Total Kontribusi Tunggal Sub Total (1+2)|Penjumlahan Kontribusi Tunggal Sub Total (1+2)");
	}
	
	public static SegmentValidation genValidationKontribusiRegulerSubTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_6040000169.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 21, 43 }), 
				"Total Kontribusi Reguler Sub Total (1+2)|Penjumlahan Kontribusi Reguler Sub Total (1+2)");
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_6040000170.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 44, 45 }), 
				"Total Kontribusi|Penjumlahan Kontribusi");
	}
}
