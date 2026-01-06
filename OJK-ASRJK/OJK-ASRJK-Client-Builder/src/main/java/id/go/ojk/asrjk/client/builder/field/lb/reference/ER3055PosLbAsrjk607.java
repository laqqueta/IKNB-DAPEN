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
public enum ER3055PosLbAsrjk607 implements IObject<KeyValueString> {
	R_6071010000 ("6071010000", "Pertanggungan yang masih berjalan pada awal tahun"),
	R_6071020000 ("6071020000", "Pertanggungan baru"),
	R_6071030000 ("6071030000", "Pemulihan kembali"),
	R_6071040000 ("6071040000", "Perubahan dari cabang  asuransi lain"),
	R_6071000000 ("6071000000", "Jumlah I"),
	R_6072010000 ("6072010000", "Meninggal"),
	R_6072020000 ("6072020000", "Habis kontrak"),
	R_6072030000 ("6072030000", "Pemutusan kontrak produk yang dihasilkan pada tahun bersangkutan (xxxx)"),
	R_6072040000 ("6072040000", "Pemutusan kontrak produk yang dihasilkan pada tahun lalu (xxxx-1)"),
	R_6072050000 ("6072050000", "Pemutusan kontrak produk yang dihasilkan sebelum tahun lalu (xxxx-1)"),
	R_6072060000 ("6072060000", "Perubahan ke cabang asuransi lain"),
	R_6072000000 ("6072000000", "Jumlah II -/-"),
	R_6070000000 ("6070000000", "Pertanggungan pada akhir tahun"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3055PosLbAsrjk607 eEnum : ER3055PosLbAsrjk607.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3055PosLbAsrjk607.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3055PosLbAsrjk607.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 37), getObjects());
	}
	
	public static FieldValidation genFieldValidation35() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(new int[] { 2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32 }), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4, 11, 12}));
	}
	
	public static FieldValidation genFieldValidation36() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(new int[] { 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33 }), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4, 11, 12}));
	}
	
	public static FieldValidation genFieldValidation37() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(new int[] { 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34 }), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4, 11, 12}));
	}
	
	public static SegmentValidation genValidationTotal1() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 37), R_6071000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 3), "Total 1|Penjumlahan detail 1");
	}
	
	public static SegmentValidation genValidationTotal2() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 37), R_6072000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 5, 10), "Total 2|Penjumlahan detail 2");
	}
	
	public static SegmentValidation genValidationPertanggunganPadaAkhirTahun() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 37), R_6070000000.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 4, 11 }), 
				"Total pertanggungan pada akhir tahun|Perhitungan pertanggungan pada akhir tahun");
	}
}
