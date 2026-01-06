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
public enum ER3050PosLbAsrjk602 implements IObject<KeyValueString> {
//	R_6020100099 ("6020100099", "1 Ringkasan Perkembangan Dana Jaminan"),
	R_6020101000 ("6020101000", "Saldo Awal Dana Jaminan"),
//	R_6020102099 ("6020102099", "Penempatan Dana Jaminan Baru:"),
	R_6020102001 ("6020102001", "a Dana Jaminan Dalam Bentuk Deposito"),
	R_6020102002 ("6020102002", "b Dana Jaminan dalam Bentuk Surat Berharga yang Diterbitkan Negara (SBN)"),
	R_6020102000 ("6020102000", "Total Penempatan Dana Jaminan Baru"),
//	R_6020103099 ("6020103099", "Pencairan Dana Jaminan:"),
	R_6020103001 ("6020103001", "a Dana Jaminan Dalam Bentuk Deposito"),
	R_6020103002 ("6020103002", "b Dana Jaminan dalam Bentuk Surat Berharga yang Diterbitkan Negara (SBN)"),
	R_6020103000 ("6020103000", "Total pencairan Dana Jaminan -/-"),
	R_6020100000 ("6020100000", "Saldo Akhir Dana Jaminan"),
//	R_6020200099 ("6020200099", "2 Perhitungan Kecukupan Dana Jaminan Tahunan"),
	R_6020201000 ("6020201000", "Ekuitas minimum yang dipersyaratkan"),
	R_6020202000 ("6020202000", "Jumlah Cadangan Premi Non PAYDI"),
	R_6020203000 ("6020203000", "Jumlah Cadangan Premi PAYDI"),
	R_6020204000 ("6020204000", "Jumlah CAPYBMP"),
	R_6020205000 ("6020205000", "Batas Minimum Dana Jaminan I"),
	R_6020206000 ("6020206000", "Batas Minimum Dana Jaminan II"),
	R_6020207000 ("6020207000", "Batas Minimum Dana Jaminan Yang Digunakan"),
	R_6020208000 ("6020208000", "Dana Jaminan yang dimiliki"),
	R_6020209000 ("6020209000", "Kelebihan (Kekurangan) Dana Jaminan"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3050PosLbAsrjk602 eEnum : ER3050PosLbAsrjk602.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3050PosLbAsrjk602.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3050PosLbAsrjk602.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationTotalPenempatanDanaJaminanBaru() {
		return UtilSegmentValidation.genEqualsFormula("2", R_6020102000.key, UtilMetadata.genPlusRow(getObjects(), 1, 2), 
				"Total penempatan dana jaminan baru|Penjumlahan penempatan dana jaminan baru");
	}
	
	public static SegmentValidation genValidationTotalPencairanDanaJaminan() {
		return UtilSegmentValidation.genEqualsFormula("2", R_6020103000.key, UtilMetadata.genPlusRow(getObjects(), 4, 5), 
				"Total pencairan dana jaminan|Penjumlahan pencairan dana jaminan");
	}
	
	public static SegmentValidation genValidationSaldoAkhirDanaJaminan() {
		return UtilSegmentValidation.genEqualsFormula("2", R_6020100000.key, R_6020101000.key + "+" + R_6020102000.key + "-" + R_6020103000.key, 
				"Saldo saldo akhir dana jaminan|Perhitungan saldo akhir dana jaminan");
	}
	
	public static SegmentValidation genValidationBatasMinimumDanaJaminanI() {
		return UtilSegmentValidation.genMultiply("2", R_6020205000.key, R_6020201000.key, ".2",
				"perkalian 0.20 dengan ekuitas minimum yang dipersyaratkan");
	}
	
	public static SegmentValidation genValidationBatasMinimumDanaJaminanII() {
		return UtilSegmentValidation.genSumMultiply3("2", R_6020206000.key, R_6020203000.key, ".02", R_6020202000.key, ".05",
				R_6020204000.key, ".05", "penjumlahan Batas Minimum Dana Jaminan II", 0);
	}
	
	public static SegmentValidation genValidationBatasMinimumDanaJaminanYangDigunakan() {
		return UtilSegmentValidation.genMaxValue("2", R_6020207000.key, UtilMetadata.genPipeRow(getObjects(), 12, 13), "0",
				"nilai maksimum antara Batas Minimum Dana Jaminan I dengan Batas Minimum Dana Jaminan II");
	}
	
	public static SegmentValidation genValidationKelebihanDanaJaminan() {
		return UtilSegmentValidation.genEqualsFormula("2", R_6020209000.key, R_6020208000.key + "-" + R_6020207000.key, 
				"Total kelebihan (Kekurangan) dana jaminan|Perhitungan kelebihan (Kekurangan) dana jaminan");
	}
}
