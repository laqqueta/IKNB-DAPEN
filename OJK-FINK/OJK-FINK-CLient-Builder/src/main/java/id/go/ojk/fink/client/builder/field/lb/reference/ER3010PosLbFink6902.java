package id.go.ojk.fink.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.fink.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3010PosLbFink6902 implements IObject<KeyValueString> {
//	R_690201000000("690201000000", "Akumulasi jumlah Pendanaan yang telah diberikan dari Lender (dalam Rp)", ""),
	R_690201010000("690201010000", "a. Jawa (Lender dari Jawa)", ""),
	R_690201010100("690201010100", "1. Banten", "e249"),
	R_690201010200("690201010200", "2. DKI Jakarta", "e250"),
	R_690201010300("690201010300", "3. Jawa Barat", "e248"),
	R_690201010400("690201010400", "4. Jawa Tengah", "e252"),
	R_690201010500("690201010500", "5. DI Yogyakarta", "e251"),
	R_690201010600("690201010600", "6. Jawa Timur", "e253"),
	R_690201020000("690201020000", "b. Luar Jawa (Lender dari Luar Jawa)", ""),
	R_690201020100("690201020100", "1. Nangroe Aceh Darussalam", "e256"),
	R_690201020200("690201020200", "2. Sumatera Utara", "e257"),
	R_690201020300("690201020300", "3. Sumatera Barat", "e258"),
	R_690201020400("690201020400", "4. Riau", "e259"),
	R_690201020500("690201020500", "5. Kepulauan Riau", "e262"),
	R_690201020600("690201020600", "6. Kepualauan Bangka Belitung", "e261"),
	R_690201020700("690201020700", "7. Jambi", "e255"),
	R_690201020800("690201020800", "8. Sumatera Selatan", "e260"),
	R_690201020900("690201020900", "9. Bengkulu", "e254"),
	R_690201021000("690201021000", "10. Lampung", "e263"),
	R_690201021100("690201021100", "11. Kalimantan Barat", "e265"),
	R_690201021200("690201021200", "12. Kalimantan Tengah", "e267"),
	R_690201021300("690201021300", "13. Kalimantan Utara", "e796"),
	R_690201021400("690201021400", "14. Kalimantan Timur", "e266"),
	R_690201021500("690201021500", "15. Kalimantan Selatan", "e264"),
	R_690201021600("690201021600", "16. Sulawesi Utara", "e270"),
	R_690201021700("690201021700", "17. Gorontalo", "e271"),
	R_690201021800("690201021800", "18. Sulawesi Tengah", "e268"),
	R_690201021900("690201021900", "19. Sulawesi Barat", "e272"),
	R_690201022000("690201022000", "20. Sulawesi Selatan", "e269"),
	R_690201022100("690201022100", "21. Sulawesi Tenggara", "e273"),
	R_690201022200("690201022200", "22. Bali", "e275"),
	R_690201022300("690201022300", "23. Nusa Tenggara Barat", "e274"),
	R_690201022400("690201022400", "24. Nusa Tenggara Timur", "e276"),
	R_690201022500("690201022500", "25. Maluku Utara", "e279"),
	R_690201022600("690201022600", "26. Maluku", "e277"),
	R_690201022700("690201022700", "27. Papua Barat", "e280"),
	R_690201022800("690201022800", "28. Papua", "e278"),
	R_690201022900("690201022900", "29. Papua Tengah", "e244"),
	R_690201023000("690201023000", "30. Papua Pegunungan", "e245"),
	R_690201023100("690201023100", "31. Papua Selatan", "e246"),
	R_690201023200("690201023200", "32. Papua Barat Daya", "e247"),
	R_690201030000("690201030000", "c. Luar Negeri (Lender Luar Negeri)", "LO_e1"),
	R_690201040000("690201040000", "d. Agregat (Total)", ""),
	R_690201050000("690201050000", "e. Rata-rata", ""),
//	R_690202000000("690202000000", "Akumulasi jumlah Pendanaan yang telah diberikan kepada Borrower (dalam Rp)", ""),
	R_690202010000("690202010000", "a. Jawa (Borrower dari Jawa)", ""),
	R_690202010100("690202010100", "1. Banten", "e249"),
	R_690202010200("690202010200", "2. DKI Jakarta", "e250"),
	R_690202010300("690202010300", "3. Jawa Barat", "e248"),
	R_690202010400("690202010400", "4. Jawa Tengah", "e252"),
	R_690202010500("690202010500", "5. DI Yogyakarta", "e251"),
	R_690202010600("690202010600", "6. Jawa Timur", "e253"),
	R_690202020000("690202020000", "b. Luar Jawa (Borrower dari Luar Jawa)", ""),
	R_690202020100("690202020100", "1. Nangroe Aceh Darussalam", "e256"),
	R_690202020200("690202020200", "2. Sumatera Utara", "e257"),
	R_690202020300("690202020300", "3. Sumatera Barat", "e258"),
	R_690202020400("690202020400", "4. Riau", "e259"),
	R_690202020500("690202020500", "5. Kepulauan Riau", "e262"),
	R_690202020600("690202020600", "6. Kepualauan Bangka Belitung", "e261"),
	R_690202020700("690202020700", "7. Jambi", "e255"),
	R_690202020800("690202020800", "8. Sumatera Selatan", "e260"),
	R_690202020900("690202020900", "9. Bengkulu", "e254"),
	R_690202021000("690202021000", "10. Lampung", "e263"),
	R_690202021100("690202021100", "11. Kalimantan Barat", "e265"),
	R_690202021200("690202021200", "12. Kalimantan Tengah", "e267"),
	R_690202021300("690202021300", "13. Kalimantan Utara", "e796"),
	R_690202021400("690202021400", "14. Kalimantan Timur", "e266"),
	R_690202021500("690202021500", "15. Kalimantan Selatan", "e264"),
	R_690202021600("690202021600", "16. Sulawesi Utara", "e270"),
	R_690202021700("690202021700", "17. Gorontalo", "e271"),
	R_690202021800("690202021800", "18. Sulawesi Tengah", "e268"),
	R_690202021900("690202021900", "19. Sulawesi Barat", "e272"),
	R_690202022000("690202022000", "20. Sulawesi Selatan", "e269"),
	R_690202022100("690202022100", "21. Sulawesi Tenggara", "e273"),
	R_690202022200("690202022200", "22. Bali", "e275"),
	R_690202022300("690202022300", "23. Nusa Tenggara Barat", "e274"),
	R_690202022400("690202022400", "24. Nusa Tenggara Timur", "e276"),
	R_690202022500("690202022500", "25. Maluku Utara", "e279"),
	R_690202022600("690202022600", "26. Maluku", "e277"),
	R_690202022700("690202022700", "27. Papua Barat", "e280"),
	R_690202022800("690202022800", "28. Papua", "e278"),
	R_690202022900("690202022900", "29. Papua Tengah", "e244"),
	R_690202023000("690202023000", "30. Papua Pegunungan", "e245"),
	R_690202023100("690202023100", "31. Papua Selatan", "e246"),
	R_690202023200("690202023200", "32. Papua Barat Daya", "e247"),
	R_690202030000("690202030000", "c. Agregat (Total)", ""),
	R_690202040000("690202040000", "d. Rata-rata", ""),
//	R_690203000000("690203000000", "Total Outstanding Pendanaan per Bulan Laporan (dalam Rp)", ""),
	R_690203010000("690203010000", "a. Jawa", ""),
	R_690203010100("690203010100", "1. Banten", "e249"),
	R_690203010200("690203010200", "2. DKI Jakarta", "e250"),
	R_690203010300("690203010300", "3. Jawa Barat", "e248"),
	R_690203010400("690203010400", "4. Jawa Tengah", "e252"),
	R_690203010500("690203010500", "5. DI Yogyakarta", "e251"),
	R_690203010600("690203010600", "6. Jawa Timur", "e253"),
	R_690203020000("690203020000", "b. Luar Jawa", ""),
	R_690203020100("690203020100", "1. Nangroe Aceh Darussalam", "e256"),
	R_690203020200("690203020200", "2. Sumatera Utara", "e257"),
	R_690203020300("690203020300", "3. Sumatera Barat", "e258"),
	R_690203020400("690203020400", "4. Riau", "e259"),
	R_690203020500("690203020500", "5. Kepulauan Riau", "e262"),
	R_690203020600("690203020600", "6. Kepualauan Bangka Belitung", "e261"),
	R_690203020700("690203020700", "7. Jambi", "e255"),
	R_690203020800("690203020800", "8. Sumatera Selatan", "e260"),
	R_690203020900("690203020900", "9. Bengkulu", "e254"),
	R_690203021000("690203021000", "10. Lampung", "e263"),
	R_690203021100("690203021100", "11. Kalimantan Barat", "e265"),
	R_690203021200("690203021200", "12. Kalimantan Tengah", "e267"),
	R_690203021300("690203021300", "13. Kalimantan Utara", "e796"),
	R_690203021400("690203021400", "14. Kalimantan Timur", "e266"),
	R_690203021500("690203021500", "15. Kalimantan Selatan", "e264"),
	R_690203021600("690203021600", "16. Sulawesi Utara", "e270"),
	R_690203021700("690203021700", "17. Gorontalo", "e271"),
	R_690203021800("690203021800", "18. Sulawesi Tengah", "e268"),
	R_690203021900("690203021900", "19. Sulawesi Barat", "e272"),
	R_690203022000("690203022000", "20. Sulawesi Selatan", "e269"),
	R_690203022100("690203022100", "21. Sulawesi Tenggara", "e273"),
	R_690203022200("690203022200", "22. Bali", "e275"),
	R_690203022300("690203022300", "23. Nusa Tenggara Barat", "e274"),
	R_690203022400("690203022400", "24. Nusa Tenggara Timur", "e276"),
	R_690203022500("690203022500", "25. Maluku Utara", "e279"),
	R_690203022600("690203022600", "26. Maluku", "e277"),
	R_690203022700("690203022700", "27. Papua Barat", "e280"),
	R_690203022800("690203022800", "28. Papua", "e278"),
	R_690203022900("690203022900", "29. Papua Tengah", "e244"),
	R_690203023000("690203023000", "30. Papua Pegunungan", "e245"),
	R_690203023100("690203023100", "31. Papua Selatan", "e246"),
	R_690203023200("690203023200", "32. Papua Barat Daya", "e247"),
	R_690203030000("690203030000", "c. Agregat (Total)", ""),
	R_690204000000("690204000000", "Saldo Dana Pada Escrow Account per Bulan Laporan (dalam Rp)", ""),
	;

	@Getter
	private String key;
	private String value;
	private String dati1;

	public String getValue() {
		String marker = ". ";
		int idx = value.indexOf(marker);
		return idx > -1 ? value.substring(idx + 1).trim() : value;
	}

	public KeyValueString getObject() {
		return new KeyValueString(key, getValue(), new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3010PosLbFink6902 eEnum : ER3010PosLbFink6902.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3010PosLbFink6902.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3010PosLbFink6902.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3|4", getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER3010PosLbFink6902[] eEnums = ER3010PosLbFink6902.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER3010PosLbFink6902 eEnum = eEnums[i];
			if (StringUtils.isNotEmpty(eEnum.dati1)) {
				res.append(eEnum.key).append(":").append(eEnum.dati1);
				if (i + 1 < enumLength) {
					res.append("|");
				}
			}
		}
		return res.toString();
	}

	public static ConditionalRequired genConditional2() {
		return UtilFieldConditional.genExistPos("N", "M",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 7, 41, 42, 43, 50, 83, 84, 85, 92, 125, 126 }));
	}

	public static ConditionalRequired genConditional4() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), 85, 126));
	}

	public static FieldValidation genFieldValidation2() {
		return UtilFieldValidation.genLookup("1", getLookup());
	}
	
	public static SegmentValidation genRowValidation001() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690201010000.key,
				UtilMetadata.genPlusRow(getObjects(), 1, 6),
				UtilMetadata.genMessage(R_690201010000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 1, 6)));
	}
	
	public static SegmentValidation genRowValidation008() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690201020000.key,
				UtilMetadata.genPlusRow(getObjects(), 8, 39),
				UtilMetadata.genMessage(R_690201020000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 8, 39)));
	}
	
	public static SegmentValidation genRowValidation042() {
		int[] rows = new int[] { 0, 7, 40 };
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690201040000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_690201040000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation043() {
		return UtilSegmentValidation.genEqualsRatioForm("3|4", R_690201050000.key, R_690201040000.key,
				EFormLaporanBulanan.LB_6901.getCode(), ER3009PosLbFink6901.R_690102010400.getKey(),
				UtilMetadata.genMessage(R_690201050000.getValue(), R_690201040000.getValue() + "/Agregat (Total) pada form 6901"), 0);
	}
	
	public static SegmentValidation genRowValidation044() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690202010000.key,
				UtilMetadata.genPlusRow(getObjects(), 44, 49),
				UtilMetadata.genMessage(R_690202010000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 44, 49)));
	}
	
	public static SegmentValidation genRowValidation051() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690202020000.key,
				UtilMetadata.genPlusRow(getObjects(), 51, 82),
				UtilMetadata.genMessage(R_690202020000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 51, 82)));
	}
	
	public static SegmentValidation genRowValidation084() {
		int[] rows = new int[] { 43, 50 };
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690202030000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_690202030000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation085() {
		return UtilSegmentValidation.genEqualsRatioForm("3|4", R_690202040000.key, R_690202030000.key,
				EFormLaporanBulanan.LB_6901.getCode(), ER3009PosLbFink6901.R_690102020300.getKey(),
				UtilMetadata.genMessage(R_690202040000.getValue(), R_690202030000.getValue() + "/Agregat (Total) pada form 6901"), 0);
	}
	
	public static SegmentValidation genRowValidation086() {
		return UtilSegmentValidation.genEqualsFormula("3", R_690203010000.key,
				UtilMetadata.genPlusRow(getObjects(), 86, 91),
				UtilMetadata.genMessage(R_690203010000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 86, 91)));
	}
	
	public static SegmentValidation genRowValidation093() {
		return UtilSegmentValidation.genEqualsFormula("3", R_690203020000.key,
				UtilMetadata.genPlusRow(getObjects(), 93, 124),
				UtilMetadata.genMessage(R_690203020000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 93, 124)));
	}
	
	public static SegmentValidation genRowValidation126() {
		int[] rows = new int[] { 85, 92 };
		return UtilSegmentValidation.genEqualsFormula("3", R_690203030000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_690203030000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
}
