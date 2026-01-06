package id.go.ojk.asrjs.client.builder.field.lb.reference;

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
public enum ER3046PosLbAsrjs607 implements IObject<KeyValueString> {
	R_6071010099 ("6071010099", "1. Pertanggungan Yang Masih Berjalan Pada Awal Tahun"),
	R_6071010100 ("6071010100", "2. Pertanggungan Baru"),
	R_6071010101 ("6071010101", "3. Pemulihan Kembali"),
	R_6071010102 ("6071010102", "4. Perubahan Dari Cabang Asuransi Lain"),
	R_6071010103 ("6071010103", "5. Jumlah I (1+2+3+4)"),
	R_6071010104 ("6071010104", "6. Meninggal"),
	R_6071010105 ("6071010105", "7. Habis Kontrak"),
	R_6071010106 ("6071010106", "8. Pemutusan Kontrak Produk Yang Dihasilkan Pada Tahun Bersangkutan (xxxx)"),
	R_6071010107 ("6071010107", "9. Pemutusan Kontrak Produk Yang Dihasilkan Sebelum Tahun Lalu (xxxx-1)"),
	R_6071010108 ("6071010108", "10. Pemutusan Kontrak Produk Yang Dihasilkan Sebelum Tahun lalu (xxxx-1)"),
	R_6071010109 ("6071010109", "11. Perubahan Ke Cabang Asuransi Lain"),
	R_6071010110 ("6071010110", "12. Jumlah II (6+7+8+9+10+11)"),
	R_6071010111 ("6071010111", "13. Pertanggungan Pada Akhir Tahun (5-12)"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3046PosLbAsrjs607 eEnum : ER3046PosLbAsrjs607.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 25), getObjects());
	}
	
	public static FieldValidation genFieldValidation24() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(new int[] { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22 }), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4, 11, 12}));
	}
	
	public static FieldValidation genFieldValidation25() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(new int[] { 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23 }), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4, 11, 12}));
	}
	
	public static SegmentValidation genValidationJumlah1() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 25), R_6071010103.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 3), "Jumlah 1|Penjumlahan detail 1");
	}
	
	public static SegmentValidation genValidationJumlah2() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 25), R_6071010110.key, 
				UtilMetadata.genPlusRow(getObjects(), 5, 10), "Jumlah 2|Penjumlahan detail 2");
	}
	
	public static SegmentValidation genValidationPertanggunganPadaAkhirTahun() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 25), R_6071010111.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 4, 11 }), 
				"Total pertanggungan pada akhir tahun|Perhitungan pertanggungan pada akhir tahun");
	}
}
