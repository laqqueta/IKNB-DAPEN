package id.go.ojk.reass.client.builder.field.lb.reference;

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
public enum ER3042PosLbReass234 implements IObject<KeyValueString> {
//	R_2343000001 ("2343000001", "1. Ringkasan Perkembangan Dana Jaminan"),
	R_2343000002 ("2343000002", "Saldo Awal Dana Jaminan"),
//	R_2343000003 ("2343000003", "Penempatan Dana Jaminan Baru:"),
	R_2343000004 ("2343000004", "a. Dana Jaminan Dalam Bentuk Deposito"),
	R_2343000005 ("2343000005", "b. Dana Jaminan dalam Bentuk SUN/Surat Berharga Lain yang Diterbitkan Negara (SBN)"),
	R_2343000006 ("2343000006", "Total Penempatan Dana Jaminan Baru (3 + 4)"),
//	R_2343000007 ("2343000007", "Pencairan Dana Jaminan:"),
	R_2343000008 ("2343000008", "a. Dana Jaminan Dalam Bentuk Deposito"),
	R_2343000009 ("2343000009", "b. Dana Jaminan dalam Bentuk SUN/Surat Berharga Lain yang Diterbitkan Negara (SBN)"),
	R_2343000010 ("2343000010", "Total pencairan Dana Jaminan (7 + 8)"),
	R_2343000011 ("2343000011", "Saldo Akhir Dana Jaminan (1 + 5 – 9)"),
//	R_2343000012 ("2343000012", "2. Perhitungan Kecukupan Dana Jaminan Tahunan"),
	R_2343000013 ("2343000013", "Ekuitas minimum yang dipersyaratkan"),
	R_2343000014 ("2343000014", "Jumlah Kontribusi neto*)"),
	R_2343000015 ("2343000015", "Jumlah Kontribusi reasuransi*)"),
	R_2343000016 ("2343000016", "Jumlah Penyisihan atas PAYDI yang digaransi"),
	R_2343000017 ("2343000017", "Batas Minimum Dana Jaminan I (20% x 1)"),
	R_2343000018 ("2343000018", "Batas Minimum Dana Jaminan II ((1% x 2) + (0,25% x 3 ) + (2% x 4)) "),
	R_2343000019 ("2343000019", "Batas Minimum Dana Jaminan Yang Digunakan ( Nilai antara 5 dan 6 mana yang lebih besar)"),
	R_2343000020 ("2343000020", "Dana Jaminan Yang Dimiliki"),
	R_2343000021 ("2343000021", "Kelebihan (Kekurangan) Dana Jaminan (8 - 7)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3042PosLbReass234 eEnum : ER3042PosLbReass234.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationTotalPenempatanDanaJaminanBaru() {
		return UtilSegmentValidation.genEqualsFormula("2", R_2343000006.key, 
				UtilMetadata.genPlusRow(getObjects(), 1, 2), "Total Penempatan Dana Jaminan Baru|Penjumlahan Penempatan Dana Jaminan Baru");
	}
	
	public static SegmentValidation genValidationTotalPencairanDanaJaminan() {
		return UtilSegmentValidation.genEqualsFormula("2", R_2343000010.key, 
				UtilMetadata.genPlusRow(getObjects(), 4, 5), "Total Pencairan Dana Jaminan|Penjumlahan Pencairan Dana Jaminan");
	}
	
	public static SegmentValidation genValidationSaldoAkhirDanaJaminan() {
		return UtilSegmentValidation.genEqualsFormula("2", R_2343000011.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 3 }) + "-" + R_2343000010.key,  
				"Total Saldo Akhir Dana Jaminan|Perhitungan Saldo Akhir Dana Jaminan");
	}
	
	public static SegmentValidation genValidationBatasMinimumDanaJaminanI() {
		return UtilSegmentValidation.genSumMultiply("2", R_2343000017.key, 
				R_2343000013.key, ".2", "perhitungan Batas Minimum Dana Jaminan I", 0);
	}
	
	public static SegmentValidation genValidationBatasMinimumDanaJaminanII() {
		return UtilSegmentValidation.genSumMultiply("2", R_2343000018.key, 
				UtilMetadata.genPipeRow(getObjects(), 9, 11), ".01|.0025|.02", "perhitungan Batas Minimum Dana Jaminan II", 0);
	}
	
	public static SegmentValidation genValidationBatasMinimumDanaJaminanYangDigunakan() {
		return UtilSegmentValidation.genMaxValue("2", R_2343000019.key, 
				UtilMetadata.genPipeRow(getObjects(), 12, 13), "",  
				"Batas Minimum Dana Jaminan Yang Digunakan|nilai maksimum antara kode komponen 2343000017 dengan kode komponen 2343000018");
	}
	
	public static SegmentValidation genValidationDanaJaminanYangDimiliki() {
		return UtilSegmentValidation.genEqualsFormula("2", R_2343000020.key, 
				R_2343000011.key, "Dana Jaminan Yang Dimiliki|Perhitungan Dana Jaminan Yang Dimiliki");
	}
	
	public static SegmentValidation genValidationKelebihanDanaJaminan() {
		return UtilSegmentValidation.genEqualsFormula("2", R_2343000021.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 15, 14 }), "Total Kelebihan (Kekurangan) Dana Jaminan|Perhitungan Kelebihan (Kekurangan) Dana Jaminan");
	}
}
