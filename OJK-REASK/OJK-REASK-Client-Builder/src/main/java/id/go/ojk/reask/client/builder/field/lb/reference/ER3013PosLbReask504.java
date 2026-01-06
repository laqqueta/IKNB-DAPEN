package id.go.ojk.reask.client.builder.field.lb.reference;

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
public enum ER3013PosLbReask504 implements IObject<KeyValueString> {
//	R_7303010100 ("7303010100", "INVESTASI","0.00"),
//	R_7303010200 ("7303010200", "Saham","0.00"),
	R_7303010201 ("7303010201", "Termasuk IDX30 atau JII","15.00"),
	R_7303010202 ("7303010202", "Saham yang tercatat di bursa efek di Indonesia selain IDX30 atau JII","20.00"),
//	R_7303010300 ("7303010300", "Saham yang tercatat di bursa efek luar negeri:","0.00"),
	R_7303010301 ("7303010301", "Saham penyusun indeks utama bursa utama negara Asia Pasifik dan Eropa anggota World Federation of Exchanges ","20.00"),
	R_7303010302 ("7303010302", "Saham Lainnya","30.00"),
//	R_7303010400 ("7303010400", "Reksa Dana","0.00"),
	R_7303010401 ("7303010401", "Sepenuhnya berupa surat utang pemerintah","0.00"),
	R_7303010402 ("7303010402", "Sepenuhnya berupa surat utang swasta dan atau surat  berharga pasar uang (SBPU)","6.00"),
	R_7303010403 ("7303010403", "Sepenuhnya berupa surat berharga ekuitas atau indeks","16.00"),
	R_7303010404 ("7303010404", "Campuran","0.00"),
//	R_7303010500 ("7303010500", "Efek Beragun Aset","0.00"),
	R_7303010501 ("7303010501", "a. Peringkat klaster 1","1.60"),
	R_7303010502 ("7303010502", "b. Peringkat klaster 2","2.80"),
	R_7303010503 ("7303010503", "c. Peringkat klaster 3","4.00"),
	R_7303010504 ("7303010504", "d. Peringkat klaster 4","6.00"),
	R_7303010505 ("7303010505", "e. Peringkat klaster 5","12.00"),
	R_7303010506 ("7303010506", "Dana Investasi Real Estat","10.00"),
	R_7303010507 ("7303010507", "Dana Investasi Infrastruktur Berbentuk Kontrak Investasi Kolektif","10.00"),
//	R_7303010600 ("7303010600", "Penyertaan Langsung","0.00"),
	R_7303010601 ("7303010601", "Dalam Pengawasan OJK","10.00"),
	R_7303010602 ("7303010602", "Tidak Dalam Pengawasan OJK","20.00"),
	R_7303010603 ("7303010603", "Penyertaan langsung pada Perusahaan dengan tujuan khusus (SPV)**","0.00"),
//	R_7303010700 ("7303010700", "Tanah, Bangunan dengan Hak Strata, atau Tanah dengan Bangunan untuk Investasi","0.00"),
	R_7303010701 ("7303010701", "Hasil Investasi 4% atau lebih","7.00"),
	R_7303010702 ("7303010702", "Hasil Investasi 2% - 4%","15.00"),
	R_7303010703 ("7303010703", "Hasil Investasi kurang dari 2%","40.00"),
	R_7303010704 ("7303010704", "Emas Murni","3.00"),
//	R_7303010800 ("7303010800", "BUKAN INVESTASI","0.00"),
	R_7303010801 ("7303010801", "Bangunan dengan Hak Strata, atau Tanah dengan Bangunan, untuk dipakai sendiri","4.00"),
	R_7303010900 ("7303010900", "Total","0.00"),
//	R_7303010901 ("7303010901", "*) rt= Rata-rata tertimbang","0.00"),
//	R_7303010902 ("7303010902", "**) Faktor risikonya disesuaikan dengan bidang usaha anak  usaha yang dominan yang dibobot  berdasarkan aset Perusahaan","0.00"),
	;

	private String key;
	private String value;
	private String field2;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3013PosLbReask504 eEnum : ER3013PosLbReask504.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3|4|5|6|7", getObjects());
	}
	
	public static ConditionalRequired genConditionMustEmpty2() {
		return UtilFieldConditional.genExistPos("N", "M", R_7303010900.key);
	}
	
	public static ConditionalRequired genConditionMustEmpty56() {
		return UtilFieldConditional.genExistPos("N", "M", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 13, 14, 15, 16, 17, 18, 19, 20, 22 }));
	}
	
	public static FieldValidation genFieldValidation2() {
		return UtilFieldValidation.genPosLookup("1", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 7, 17 }), getLookup());
	}

	public static FieldValidation genFieldValidation4() {
		return UtilFieldValidation.genPosPercentage("2|3", UtilMetadata.genPipeRow(getObjects(), 0, 22));
	}

	public static FieldValidation genFieldValidation6() {
		return UtilFieldValidation.genPosPercentage("2|5", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 21 }));
	}

	public static FieldValidation genFieldValidation7a() {
		return UtilFieldValidation.genEqualsPosFormula("4+6", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 21 }));
	}

	public static FieldValidation genFieldValidation7b() {
		return UtilFieldValidation.genEqualsPosFormula("4", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 13, 14, 15, 16, 17, 18, 19, 20, 22 }));
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("3|4|5|6|7", R_7303010900.key, UtilMetadata.genPlusRow(getObjects(), 0, 22), 
				"Total|Penjumlahan detail");
	}

	private static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER3013PosLbReask504[] eEnums = ER3013PosLbReask504.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER3013PosLbReask504 eEnum = ER3013PosLbReask504.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.field2);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
