package id.go.ojk.asrjk.client.builder.field.lb.reference;

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
public enum ER3013PosLbAsrjk504 implements IObject<KeyValueString> {
//	R_1400000000 ("1400000000", "INVESTASI","0"),
//	R_1403000000 ("1403000000", "Saham","0"),
	R_1403010000 ("1403010000", "Termasuk IDX30 atau JII","15.00"),
	R_1403020000 ("1403020000", "Saham yang tercatat di bursa efek di Indonesia selain IDX30 atau JII","20.00"),
//	R_1407000000 ("1407000000", "Saham yang tercatat di bursa efek luar negeri:","0"),
	R_1407010000 ("1407010000", "Saham penyusun indeks utama bursa utama negara Asia Pasifik dan Eropa anggota World Federation of Exchanges ","20.00"),
	R_1407020000 ("1407020000", "Saham Lainnya","30.00"),
//	R_1410000000 ("1410000000", "Reksa Dana","0"),
	R_1410010000 ("1410010000", "Sepenuhnya berupa surat utang pemerintah","0.00"),
	R_1410020000 ("1410020000", "Sepenuhnya berupa surat utang swasta dan atau surat  berharga pasar uang (SBPU)","6.00"),
	R_1410030000 ("1410030000", "Sepenuhnya berupa surat berharga ekuitas atau indeks","16.00"),
	R_1410040000 ("1410040000", "Campuran","0.00"),
//	R_1411000000 ("1411000000", "Efek Beragun Aset","0"),
	R_1411010000 ("1411010000", "a. Peringkat klaster 1","1.60"),
	R_1411020000 ("1411020000", "b. Peringkat klaster 2","2.80"),
	R_1411030000 ("1411030000", "c. Peringkat klaster 3","4.00"),
	R_1411040000 ("1411040000", "d. Peringkat klaster 4","6.00"),
	R_1411050000 ("1411050000", "e. Peringkat klaster 5","12.00"),
	R_1412000000 ("1412000000", "Dana Investasi Real Estat","10.00"),
	R_1413000000 ("1413000000", "Dana Investasi Infrastruktur Berbentuk Kontrak Investasi Kolektif","10.00"),
//	R_1414000000 ("1414000000", "Penyertaan Langsung","0"),
	R_1414010000 ("1414010000", "Dalam Pengawasan OJK","10.00"),
	R_1414020000 ("1414020000", "Tidak Dalam Pengawasan OJK","20.00"),
	R_1414030000 ("1414030000", "Penyertaan langsung pada Perusahaan dengan tujuan khusus (SPV)**","0.00"),
//	R_1415000000 ("1415000000", "Tanah, Bangunan dengan Hak Strata, atau Tanah dengan Bangunan untuk Investasi","0"),
	R_1415010000 ("1415010000", "Hasil Investasi 4% atau lebih","7.00"),
	R_1415020000 ("1415020000", "Hasil Investasi 2% - 4%","15.00"),
	R_1415030000 ("1415030000", "Hasil Investasi kurang dari 2%","40.00"),
	R_1417000000 ("1417000000", "Emas Murni","3.00"),
//	R_1500000000 ("1500000000", "BUKAN INVESTASI","0"),
	R_1509000000 ("1509000000", "Bangunan dengan Hak Strata, atau Tanah dengan Bangunan, untuk dipakai sendiri","4.00"),
	R_1000000000 ("1000000000", "Total","0.00"),
//	R_1091000000 ("1091000000", "*) rt= Rata-rata tertimbang","0"),
//	R_1092000000 ("1092000000", "**) Faktor risikonya disesuaikan dengan bidang usaha anak  usaha yang dominan yang dibobot  berdasarkan aset Perusahaan","0"),
	;

	private String key;
	private String value;
	private String field2;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3013PosLbAsrjk504 eEnum : ER3013PosLbAsrjk504.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3013PosLbAsrjk504.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3013PosLbAsrjk504.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3|4|5|6|7", getObjects());
	}
	
	public static ConditionalRequired genConditionMustEmpty2() {
		return UtilFieldConditional.genExistPos("N", "M", R_1000000000.key);
	}
	
	public static ConditionalRequired genConditionMustEmpty56() {
		return UtilFieldConditional.genExistPos("N", "M", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 13, 14, 15, 16, 17, 18, 19, 20, 22 }));
	}
	
	public static FieldValidation genFieldValidation2() {
		return UtilFieldValidation.genPosLookup("1", UtilMetadata.genPipeRow(getObjects(), 0, 23), getLookup());
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
		return UtilSegmentValidation.genEqualsFormula("3|4|5|6|7", R_1000000000.key, UtilMetadata.genPlusRow(getObjects(), 0, 22), 
				"Total|Penjumlahan detail");
	}

	private static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER3013PosLbAsrjk504[] eEnums = ER3013PosLbAsrjk504.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER3013PosLbAsrjk504 eEnum = ER3013PosLbAsrjk504.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.field2);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
