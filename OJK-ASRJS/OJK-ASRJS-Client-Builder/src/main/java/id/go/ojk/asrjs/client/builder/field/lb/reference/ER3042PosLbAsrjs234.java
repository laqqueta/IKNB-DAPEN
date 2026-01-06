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
public enum ER3042PosLbAsrjs234 implements IObject<KeyValueString> {
//	R_2343000001 ("2343000001", "I. Ringkasan Perkembangan Dana Jaminan"),
	R_2343000002 ("2343000002", "1. Saldo Awal Dana Jaminan"),
	R_2343000003 ("2343000003", "2. Penempatan Dana Jaminan Baru:"),
	R_2343000004 ("2343000004", "a. Dana Jaminan Dalam Bentuk Deposito"),
	R_2343000005 ("2343000005", "b. Dana Jaminan dalam Bentuk SUN/Surat Berharga Lain yang Diterbitkan Negara (SBN)"),
	R_2343000006 ("2343000006", "3. Pencairan Dana Jaminan:"),
	R_2343000007 ("2343000007", "a. Dana Jaminan Dalam Bentuk Deposito"),
	R_2343000008 ("2343000008", "b. Dana Jaminan dalam Bentuk SUN/Surat Berharga Lain yang Diterbitkan Negara (SBN)"),
	R_2343000009 ("2343000009", "4. Saldo Akhir Dana Jaminan (1 + 2 – 3)"),
//	R_2343000010 ("2343000010", "II. Perhitungan Kecukupan Dana Jaminan Tahunan"),
	R_2343000011 ("2343000011", "1. Ekuitas minimum yang dipersyaratkan"),
	R_2343000012 ("2343000012", "2. Penyisihan kontribusi tabarru' dan tanahud"),
	R_2343000013 ("2343000013", "3. Penyisihan kontribusi tabarru’ yang belum merupakan pendapatan"),
	R_2343000014 ("2343000014", "4. Jumlah Penyisihan (2+3)"),
	R_2343000015 ("2343000015", "5. Penyisihan atas PAYDI Garansi"),
	R_2343000016 ("2343000016", "6. Batas Minimum Dana Jaminan I (20% x 1)"),
	R_2343000017 ("2343000017", "7. Batas Minimum Dana Jaminan II (2% x 5) + (5% x 4)"),
	R_2343000018 ("2343000018", "8. Batas Minimum Dana Jaminan Yang Digunakan ( Nilai antara 6 dan 7 mana yang lebih besar)"),
	R_2343000019 ("2343000019", "9. Dana Jaminan Yang Dimiliki"),
	R_2343000020 ("2343000020", "10. Kelebihan (Kekurangan) Dana Jaminan (9-8))"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3042PosLbAsrjs234 eEnum : ER3042PosLbAsrjs234.values()) {
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
	
	public static SegmentValidation genValidationPenempatanDanaJaminanBaru() {
		return UtilSegmentValidation.genEqualsFormula("2", R_2343000003.key, 
				UtilMetadata.genPlusRow(getObjects(), 2, 3), "Total Penempatan Dana Jaminan Baru|Penjumlahan Penempatan Dana Jaminan Baru");
	}
	
	public static SegmentValidation genValidationPencairanDanaJaminan() {
		return UtilSegmentValidation.genEqualsFormula("2", R_2343000006.key, 
				UtilMetadata.genPlusRow(getObjects(), 5, 6), "Total Pencairan Dana Jaminan|Penjumlahan Pencairan Dana Jaminan");
	}
	
	public static SegmentValidation genValidationSaldoAkhirDanaJaminan() {
		return UtilSegmentValidation.genEqualsFormula("2", R_2343000009.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 1) + "-" + R_2343000006.key,  
				"Total Saldo Akhir Dana Jaminan|Perhitungan Saldo Akhir Dana Jaminan");
	}
	
	public static SegmentValidation genValidationBatasMinimumDanaJaminanI() {
		return UtilSegmentValidation.genSumMultiply("2", R_2343000016.key, 
				UtilMetadata.genPipeRow(getObjects(), 10, 11), ".05|.02", "perhitungan Batas Minimum Dana Jaminan I", 0);
	}
	
	public static SegmentValidation genValidationBatasMinimumDanaJaminanII() {
		return UtilSegmentValidation.genSumMultiply("2", R_2343000017.key, 
				UtilMetadata.genPipeRow(getObjects(), 11, 12), ".05|.02", "perhitungan Batas Minimum Dana Jaminan II", 0);
	}
	
	public static SegmentValidation genValidationBatasMinimumDanaJaminanYangDigunakan() {
		return UtilSegmentValidation.genMaxValue("2", R_2343000018.key, 
				UtilMetadata.genPipeRow(getObjects(), 13, 14), "",  
				"perhitungan Batas Minimum Dana Jaminan Yang Digunakan");
	}
	
	public static SegmentValidation genValidationKelebihanDanaJaminan() {
		return UtilSegmentValidation.genEqualsFormula("2", R_2343000020.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 16, 15 }), "Total Kelebihan (Kekurangan) Dana Jaminan|Perhitungan Kelebihan (Kekurangan) Dana Jaminan");
	}
}
