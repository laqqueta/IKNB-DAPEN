package id.go.ojk.fins.client.builder.field.lb.reference;

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
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3009PosLbFins6901 implements IObject<KeyValueString> {
//	R_690101000000("690101000000", "Akumulasi jumlah Unique Lender dan Unique Borrower (Satuan entitas)", ""),
//	R_690101010000("690101010000", "1) Akumulasi jumlah Unique Lender (Satuan entitas)", ""),
	R_690101010100("690101010100", "a. Jawa (Unique Lender dari Jawa)", ""),
	R_690101010101("690101010101", "1. Banten", "e249"),
	R_690101010102("690101010102", "2. DKI Jakarta", "e250"),
	R_690101010103("690101010103", "3. Jawa Barat", "e248"),
	R_690101010104("690101010104", "4. Jawa Tengah", "e252"),
	R_690101010105("690101010105", "5. DI Yogyakarta", "e251"),
	R_690101010106("690101010106", "6. Jawa Timur", "e253"),
	R_690101010200("690101010200", "b. Luar Jawa (Unique Lender dari Luar Jawa)", ""),
	R_690101010201("690101010201", "1. Nangroe Aceh Darussalam", "e256"),
	R_690101010202("690101010202", "2. Sumatera Utara", "e257"),
	R_690101010203("690101010203", "3. Sumatera Barat", "e258"),
	R_690101010204("690101010204", "4. Riau", "e259"),
	R_690101010205("690101010205", "5. Kepulauan Riau", "e262"),
	R_690101010206("690101010206", "6. Kepulauan Bangka Belitung", "e261"),
	R_690101010207("690101010207", "7. Jambi", "e255"),
	R_690101010208("690101010208", "8. Sumatera Selatan", "e260"),
	R_690101010209("690101010209", "9. Bengkulu", "e254"),
	R_690101010210("690101010210", "10. Lampung", "e263"),
	R_690101010211("690101010211", "11. Kalimantan Barat", "e265"),
	R_690101010212("690101010212", "12. Kalimantan Tengah", "e267"),
	R_690101010213("690101010213", "13. Kalimantan Utara", "e796"),
	R_690101010214("690101010214", "14. Kalimantan Timur", "e266"),
	R_690101010215("690101010215", "15. Kalimantan Selatan", "e264"),
	R_690101010216("690101010216", "16. Sulawesi Utara", "e270"),
	R_690101010217("690101010217", "17. Gorontalo", "e271"),
	R_690101010218("690101010218", "18. Sulawesi Tengah", "e268"),
	R_690101010219("690101010219", "19. Sulawesi Barat", "e272"),
	R_690101010220("690101010220", "20. Sulawesi Selatan", "e269"),
	R_690101010221("690101010221", "21. Sulawesi Tenggara", "e273"),
	R_690101010222("690101010222", "22. Bali", "e275"),
	R_690101010223("690101010223", "23. Nusa Tenggara Barat", "e274"),
	R_690101010224("690101010224", "24. Nusa Tenggara Timur", "e276"),
	R_690101010225("690101010225", "25. Maluku Utara", "e279"),
	R_690101010226("690101010226", "26. Maluku", "e277"),
	R_690101010227("690101010227", "27. Papua Barat", "e280"),
	R_690101010228("690101010228", "28. Papua", "e278"),
	R_690101010229("690101010229", "29. Papua Tengah", "e244"),
	R_690101010230("690101010230", "30. Papua Pegunungan", "e245"),
	R_690101010231("690101010231", "31. Papua Selatan", "e246"),
	R_690101010232("690101010232", "32. Papua Barat Daya", "e247"),
	R_690101010300("690101010300", "c. Luar Negeri", "LO_e1"),
	R_690101010400("690101010400", "d. Agregat (Total)", ""),
	R_690101010401("690101010401", "- Laki-laki", ""),
	R_690101010402("690101010402", "- Perempuan", ""),
	R_690101010403("690101010403", "- Badan Usaha", ""),
//	R_690101010500("690101010500", "e. Akumulasi Jumlah Unique Lender Berdasarkan Usia (Bagi Unique Lender perseorangan)", ""),
	R_690101010501("690101010501", "- <19 tahun", ""),
	R_690101010502("690101010502", "- 19-34 Tahun", ""),
	R_690101010503("690101010503", "- 35-54 Tahun", ""),
	R_690101010504("690101010504", "- >54 Tahun", ""),
//	R_690101020000("690101020000", "2) Akumulasi jumlah Unique Borrower (Satuan entitas)", ""),
	R_690101020100("690101020100", "a. Jawa (Unique Borrower dari Jawa)", ""),
	R_690101020101("690101020101", "1. Banten", "e249"),
	R_690101020102("690101020102", "2. DKI Jakarta", "e250"),
	R_690101020103("690101020103", "3. Jawa Barat", "e248"),
	R_690101020104("690101020104", "4. Jawa Tengah", "e252"),
	R_690101020105("690101020105", "5. DI Yogyakarta", "e251"),
	R_690101020106("690101020106", "6. Jawa Timur", "e253"),
	R_690101020200("690101020200", "b. Luar Jawa (Unique Borrower dari Luar Jawa)", ""),
	R_690101020201("690101020201", "1. Nangroe Aceh Darussalam", "e256"),
	R_690101020202("690101020202", "2. Sumatera Utara", "e257"),
	R_690101020203("690101020203", "3. Sumatera Barat", "e258"),
	R_690101020204("690101020204", "4. Riau", "e259"),
	R_690101020205("690101020205", "5. Kepulauan Riau", "e262"),
	R_690101020206("690101020206", "6. Kepulauan Bangka Belitung", "e261"),
	R_690101020207("690101020207", "7. Jambi", "e255"),
	R_690101020208("690101020208", "8. Sumatera Selatan", "e260"),
	R_690101020209("690101020209", "9. Bengkulu", "e254"),
	R_690101020210("690101020210", "10. Lampung", "e263"),
	R_690101020211("690101020211", "11. Kalimantan Barat", "e265"),
	R_690101020212("690101020212", "12. Kalimantan Tengah", "e267"),
	R_690101020213("690101020213", "13. Kalimantan Utara", "e796"),
	R_690101020214("690101020214", "14. Kalimantan Timur", "e266"),
	R_690101020215("690101020215", "15. Kalimantan Selatan", "e264"),
	R_690101020216("690101020216", "16. Sulawesi Utara", "e270"),
	R_690101020217("690101020217", "17. Gorontalo", "e271"),
	R_690101020218("690101020218", "18. Sulawesi Tengah", "e268"),
	R_690101020219("690101020219", "19. Sulawesi Barat", "e272"),
	R_690101020220("690101020220", "20. Sulawesi Selatan", "e269"),
	R_690101020221("690101020221", "21. Sulawesi Tenggara", "e273"),
	R_690101020222("690101020222", "22. Bali", "e275"),
	R_690101020223("690101020223", "23. Nusa Tenggara Barat", "e274"),
	R_690101020224("690101020224", "24. Nusa Tenggara Timur", "e276"),
	R_690101020225("690101020225", "25. Maluku Utara", "e279"),
	R_690101020226("690101020226", "26. Maluku", "e277"),
	R_690101020227("690101020227", "27. Papua Barat", "e280"),
	R_690101020228("690101020228", "28. Papua", "e278"),
	R_690101020229("690101020229", "29. Papua Tengah", "e244"),
	R_690101020230("690101020230", "30. Papua Pegunungan", "e245"),
	R_690101020231("690101020231", "31. Papua Selatan", "e246"),
	R_690101020232("690101020232", "32. Papua Barat Daya", "e247"),
	R_690101020300("690101020300", "c. Agregat (Total)", ""),
	R_690101020301("690101020301", "- Laki-laki", ""),
	R_690101020302("690101020302", "- Perempuan", ""),
	R_690101020303("690101020303", "- Badan Usaha", ""),
//	R_690101020400("690101020400", "d. Akumulasi Jumlah Unique Borrower Berdasarkan Usia (Bagi Unique Borrower Perseorangan)", ""),
	R_690101020401("690101020401", "- <19 tahun", ""),
	R_690101020402("690101020402", "- 19-34 Tahun", ""),
	R_690101020403("690101020403", "- 35-54 Tahun", ""),
	R_690101020404("690101020404", "- >54 Tahun", ""),
//	R_690102000000("690102000000", "Akumulasi Jumlah Lender Lending Account dan Borrower Credit Account (Satuan Akun)", ""),
//	R_690102010000("690102010000", "1) Akumulasi Jumlah Lender Lending Account (Satuan Akun)", ""),
	R_690102010100("690102010100", "a. Jawa (Jumlah Lending Account dari Lender Jawa)", ""),
	R_690102010101("690102010101", "1. Banten", "e249"),
	R_690102010102("690102010102", "2. DKI Jakarta", "e250"),
	R_690102010103("690102010103", "3. Jawa Barat", "e248"),
	R_690102010104("690102010104", "4. Jawa Tengah", "e252"),
	R_690102010105("690102010105", "5. DI Yogyakarta", "e251"),
	R_690102010106("690102010106", "6. Jawa Timur", "e253"),
	R_690102010200("690102010200", "b. Luar Jawa (Jumlah Lending Account dari Lender Luar Jawa)", ""),
	R_690102010201("690102010201", "1. Nangroe Aceh Darussalam", "e256"),
	R_690102010202("690102010202", "2. Sumatera Utara", "e257"),
	R_690102010203("690102010203", "3. Sumatera Barat", "e258"),
	R_690102010204("690102010204", "4. Riau", "e259"),
	R_690102010205("690102010205", "5. Kepulauan Riau", "e262"),
	R_690102010206("690102010206", "6. Kepulauan Bangka Belitung", "e261"),
	R_690102010207("690102010207", "7. Jambi", "e255"),
	R_690102010208("690102010208", "8. Sumatera Selatan", "e260"),
	R_690102010209("690102010209", "9. Bengkulu", "e254"),
	R_690102010210("690102010210", "10. Lampung", "e263"),
	R_690102010211("690102010211", "11. Kalimantan Barat", "e265"),
	R_690102010212("690102010212", "12. Kalimantan Tengah", "e267"),
	R_690102010213("690102010213", "13. Kalimantan Utara", "e796"),
	R_690102010214("690102010214", "14. Kalimantan Timur", "e266"),
	R_690102010215("690102010215", "15. Kalimantan Selatan", "e264"),
	R_690102010216("690102010216", "16. Sulawesi Utara", "e270"),
	R_690102010217("690102010217", "17. Gorontalo", "e271"),
	R_690102010218("690102010218", "18. Sulawesi Tengah", "e268"),
	R_690102010219("690102010219", "19. Sulawesi Barat", "e272"),
	R_690102010220("690102010220", "20. Sulawesi Selatan", "e269"),
	R_690102010221("690102010221", "21. Sulawesi Tenggara", "e273"),
	R_690102010222("690102010222", "22. Bali", "e275"),
	R_690102010223("690102010223", "23. Nusa Tenggara Barat", "e274"),
	R_690102010224("690102010224", "24. Nusa Tenggara Timur", "e276"),
	R_690102010225("690102010225", "25. Maluku Utara", "e279"),
	R_690102010226("690102010226", "26. Maluku", "e277"),
	R_690102010227("690102010227", "27. Papua Barat", "e280"),
	R_690102010228("690102010228", "28. Papua", "e278"),
	R_690102010229("690102010229", "29. Papua Tengah", "e244"),
	R_690102010230("690102010230", "30. Papua Pegunungan", "e245"),
	R_690102010231("690102010231", "31. Papua Selatan", "e246"),
	R_690102010232("690102010232", "32. Papua Barat Daya", "e247"),
	R_690102010300("690102010300", "c. Luar Negeri (Jumlah Lending Account dari Lender Luar Negeri)", "LO_e1"),
	R_690102010400("690102010400", "d. Agregat (Total)", ""),
	R_690102010401("690102010401", "- Laki-laki", ""),
	R_690102010402("690102010402", "- Perempuan", ""),
	R_690102010403("690102010403", "- Badan Usaha", ""),
//	R_690102010500("690102010500", "e. Akumulasi Jumlah Akun Lender Berdasarkan Usia (Bagi Lending Account dari Lender perseorangan)", ""),
	R_690102010501("690102010501", "- <19 tahun", ""),
	R_690102010502("690102010502", "- 19-34 Tahun", ""),
	R_690102010503("690102010503", "- 35-54 Tahun", ""),
	R_690102010504("690102010504", "- >54 Tahun", ""),
//	R_690102020000("690102020000", "2) Akumulasi Jumlah Borrower Credit Account (Satuan Akun)", ""),
	R_690102020100("690102020100", "a. Jawa (Jumlah Credit Account dari Borrower Jawa)", ""),
	R_690102020101("690102020101", "1. Banten", "e249"),
	R_690102020102("690102020102", "2. DKI Jakarta", "e250"),
	R_690102020103("690102020103", "3. Jawa Barat", "e248"),
	R_690102020104("690102020104", "4. Jawa Tengah", "e252"),
	R_690102020105("690102020105", "5. DI Yogyakarta", "e251"),
	R_690102020106("690102020106", "6. Jawa Timur", "e253"),
	R_690102020200("690102020200", "b. Luar Jawa (Jumlah Credit Account dari Borrower Luar Jawa)", ""),
	R_690102020201("690102020201", "1. Nangroe Aceh Darussalam", "e256"),
	R_690102020202("690102020202", "2. Sumatera Utara", "e257"),
	R_690102020203("690102020203", "3. Sumatera Barat", "e258"),
	R_690102020204("690102020204", "4. Riau", "e259"),
	R_690102020205("690102020205", "5. Kepulauan Riau", "e262"),
	R_690102020206("690102020206", "6. Kepulauan Bangka Belitung", "e261"),
	R_690102020207("690102020207", "7. Jambi", "e255"),
	R_690102020208("690102020208", "8. Sumatera Selatan", "e260"),
	R_690102020209("690102020209", "9. Bengkulu", "e254"),
	R_690102020210("690102020210", "10. Lampung", "e263"),
	R_690102020211("690102020211", "11. Kalimantan Barat", "e265"),
	R_690102020212("690102020212", "12. Kalimantan Tengah", "e267"),
	R_690102020213("690102020213", "13. Kalimantan Utara", "e796"),
	R_690102020214("690102020214", "14. Kalimantan Timur", "e266"),
	R_690102020215("690102020215", "15. Kalimantan Selatan", "e264"),
	R_690102020216("690102020216", "16. Sulawesi Utara", "e270"),
	R_690102020217("690102020217", "17. Gorontalo", "e271"),
	R_690102020218("690102020218", "18. Sulawesi Tengah", "e268"),
	R_690102020219("690102020219", "19. Sulawesi Barat", "e272"),
	R_690102020220("690102020220", "20. Sulawesi Selatan", "e269"),
	R_690102020221("690102020221", "21. Sulawesi Tenggara", "e273"),
	R_690102020222("690102020222", "22. Bali", "e275"),
	R_690102020223("690102020223", "23. Nusa Tenggara Barat", "e274"),
	R_690102020224("690102020224", "24. Nusa Tenggara Timur", "e276"),
	R_690102020225("690102020225", "25. Maluku Utara", "e279"),
	R_690102020226("690102020226", "26. Maluku", "e277"),
	R_690102020227("690102020227", "27. Papua Barat", "e280"),
	R_690102020228("690102020228", "28. Papua", "e278"),
	R_690102020229("690102020229", "29. Papua Tengah", "e244"),
	R_690102020230("690102020230", "30. Papua Pegunungan", "e245"),
	R_690102020231("690102020231", "31. Papua Selatan", "e246"),
	R_690102020232("690102020232", "32. Papua Barat Daya", "e247"),
	R_690102020300("690102020300", "c. Agregat (Total)", ""),
	R_690102020301("690102020301", "- Laki-laki", ""),
	R_690102020302("690102020302", "- Perempuan", ""),
	R_690102020303("690102020303", "- Badan Usaha", ""),
//	R_690102020400("690102020400", "d. Akumulasi Jumlah Akun Borrower Berdasarkan Usia (Bagi Credit Account dari Borrower perseorangan)", ""),
	R_690102020401("690102020401", "- <19 tahun", ""),
	R_690102020402("690102020402", "- 19-34 Tahun", ""),
	R_690102020403("690102020403", "- 35-54 Tahun", ""),
	R_690102020404("690102020404", "- >54 Tahun", ""),
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
		for (ER3009PosLbFins6901 eEnum : ER3009PosLbFins6901.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3009PosLbFins6901.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3009PosLbFins6901.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3|4", getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER3009PosLbFins6901[] eEnums = ER3009PosLbFins6901.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER3009PosLbFins6901 eEnum = eEnums[i];
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
				UtilMetadata.genPipeRow(getObjects(),
						new int[] { 0, 7, 41, 42, 43, 44, 45, 46, 47, 48, 49, 56, 89, 90, 91, 92, 93, 94, 95, 96, 97,
								104, 138, 139, 140, 141, 142, 143, 144, 145, 146, 153, 186, 187, 188, 189, 190, 191,
								192, 193 }));
	}

	public static FieldValidation genFieldValidation2() {
		return UtilFieldValidation.genLookup("1", getLookup());
	}
	
	public static SegmentValidation genRowValidation001() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690101010100.key,
				UtilMetadata.genPlusRow(getObjects(), 1, 6),
				UtilMetadata.genMessage(R_690101010100.getValue(), UtilMetadata.genPlusDesc(getObjects(), 1, 6)));
	}
	
	public static SegmentValidation genRowValidation008() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690101010200.key,
				UtilMetadata.genPlusRow(getObjects(), 8, 39),
				UtilMetadata.genMessage(R_690101010200.getValue(), UtilMetadata.genPlusDesc(getObjects(), 8, 39)));
	}
	
	public static SegmentValidation genRowValidation042() {
		int[] rows = new int[] { 0, 7, 40};
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690101010400.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_690101010400.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation050() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690101020100.key,
				UtilMetadata.genPlusRow(getObjects(), 50, 55),
				UtilMetadata.genMessage(R_690101020100.getValue(), UtilMetadata.genPlusDesc(getObjects(), 50, 55)));
	}
	
	public static SegmentValidation genRowValidation056() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690101020200.key,
				UtilMetadata.genPlusRow(getObjects(), 57, 88),
				UtilMetadata.genMessage(R_690101020200.getValue(), UtilMetadata.genPlusDesc(getObjects(), 57, 88)));
	}
	
	public static SegmentValidation genRowValidation090() {
		int[] rows = new int[] { 49, 56 };
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690101020300.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_690101020300.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation097() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690102010100.key,
				UtilMetadata.genPlusRow(getObjects(), 98, 103),
				UtilMetadata.genMessage(R_690102010100.getValue(), UtilMetadata.genPlusDesc(getObjects(), 98, 103)));
	}
	
	public static SegmentValidation genRowValidation104() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690102010200.key,
				UtilMetadata.genPlusRow(getObjects(), 105, 136),
				UtilMetadata.genMessage(R_690102010200.getValue(), UtilMetadata.genPlusDesc(getObjects(), 105, 136)));
	}
	
	public static SegmentValidation genRowValidation139() {
		int[] rows = new int[] { 97, 104, 137 };
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690102010400.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_690102010400.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation147() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690102020100.key,
				UtilMetadata.genPlusRow(getObjects(), 147, 152),
				UtilMetadata.genMessage(R_690102020100.getValue(), UtilMetadata.genPlusDesc(getObjects(), 147, 152)));
	}
	
	public static SegmentValidation genRowValidation153() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690102020200.key,
				UtilMetadata.genPlusRow(getObjects(), 154, 185),
				UtilMetadata.genMessage(R_690102020200.getValue(), UtilMetadata.genPlusDesc(getObjects(), 154, 185)));
	}
	
	public static SegmentValidation genRowValidation187() {
		int[] rows = new int[] { 146, 153 };
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690102020300.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_690102020300.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation188() {
		return UtilSegmentValidation.genEqualsFormula2("3|4", R_690102020301.key, UtilMetadata.genPlusRow(getObjects(), 187, 188),
				UtilMetadata.genPlusRow(getObjects(), 190, 193), 
				UtilMetadata.genMessage(UtilMetadata.genPlusDesc(getObjects(), 187, 188), UtilMetadata.genPlusDesc(getObjects(), 190, 193)), 2);
	}
}
