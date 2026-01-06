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
public enum ER3013PosLbFink6908 implements IObject<KeyValueString> {
//	R_690801000000("690801000000", "1. Pendanaan Lancar", ""),
	R_690801010000("690801010000", "a. Jawa", ""),
	R_690801010100("690801010100", "1. Banten", "e249"),
	R_690801010200("690801010200", "2. DKI Jakarta", "e250"),
	R_690801010300("690801010300", "3. Jawa Barat", "e248"),
	R_690801010400("690801010400", "4. Jawa Tengah", "e252"),
	R_690801010500("690801010500", "5. DI Yogyakarta", "e251"),
	R_690801010600("690801010600", "6. Jawa Timur", "e253"),
	R_690801020000("690801020000", "b. Luar Jawa", ""),
	R_690801020100("690801020100", "1. Nangroe Aceh Darussalam", "e256"),
	R_690801020200("690801020200", "2. Sumatera Utara", "e257"),
	R_690801020300("690801020300", "3. Sumatera Barat", "e258"),
	R_690801020400("690801020400", "4. Riau", "e259"),
	R_690801020500("690801020500", "5. Kepulauan Riau", "e262"),
	R_690801020600("690801020600", "6. Kepulauan Bangka Belitung", "e261"),
	R_690801020700("690801020700", "7. Jambi", "e255"),
	R_690801020800("690801020800", "8. Sumatera Selatan", "e260"),
	R_690801020900("690801020900", "9. Bengkulu", "e254"),
	R_690801021000("690801021000", "10. Lampung", "e263"),
	R_690801021100("690801021100", "11. Kalimantan Barat", "e265"),
	R_690801021200("690801021200", "12. Kalimantan Tengah", "e267"),
	R_690801021300("690801021300", "13. Kalimantan Utara", "e796"),
	R_690801021400("690801021400", "14. Kalimantan Timur", "e266"),
	R_690801021500("690801021500", "15. Kalimantan Selatan", "e264"),
	R_690801021600("690801021600", "16. Sulawesi Utara", "e270"),
	R_690801021700("690801021700", "17. Gorontalo", "e271"),
	R_690801021800("690801021800", "18. Sulawesi Tengah", "e268"),
	R_690801021900("690801021900", "19. Sulawesi Barat", "e272"),
	R_690801022000("690801022000", "20. Sulawesi Selatan", "e269"),
	R_690801022100("690801022100", "21. Sulawesi Tenggara", "e273"),
	R_690801022200("690801022200", "22. Bali", "e275"),
	R_690801022300("690801022300", "23. Nusa Tenggara Barat", "e274"),
	R_690801022400("690801022400", "24. Nusa Tenggara Timur", "e276"),
	R_690801022500("690801022500", "25. Maluku Utara", "e279"),
	R_690801022600("690801022600", "26. Maluku", "e277"),
	R_690801022700("690801022700", "27. Papua Barat", "e280"),
	R_690801022800("690801022800", "28. Papua", "e278"),
	R_690801022900("690801022900", "29. Papua Tengah", "e244"),
	R_690801023000("690801023000", "30. Papua Pegunungan", "e245"),
	R_690801023100("690801023100", "31. Papua Selatan", "e246"),
	R_690801023200("690801023200", "32. Papua Barat Daya", "e247"),
	R_690801030000("690801030000", "c. Total Outstanding Pendanaan Lancar", ""),
	R_690801030100("690801030100", "- Laki-laki", ""),
	R_690801030200("690801030200", "- Perempuan", ""),
	R_690801030300("690801030300", "- Badan Usaha", ""),
//	R_690801040000("690801040000", "d. Usia Borrower Perseorangan yang masuk dalam kategori Pendanaan Lancar", ""),
	R_690801040100("690801040100", "- <19 tahun", ""),
	R_690801040200("690801040200", "- 19-34 Tahun", ""),
	R_690801040300("690801040300", "- 35-54 Tahun", ""),
	R_690801040400("690801040400", "- >54 Tahun", ""),
//	R_690802000000("690802000000", "2. Pendanaan Dalam Perhatian Khusus", ""),
	R_690802010000("690802010000", "a. Jawa", ""),
	R_690802010100("690802010100", "1. Banten", "e249"),
	R_690802010200("690802010200", "2. DKI Jakarta", "e250"),
	R_690802010300("690802010300", "3. Jawa Barat", "e248"),
	R_690802010400("690802010400", "4. Jawa Tengah", "e252"),
	R_690802010500("690802010500", "5. DI Yogyakarta", "e251"),
	R_690802010600("690802010600", "6. Jawa Timur", "e253"),
	R_690802020000("690802020000", "b. Luar Jawa", ""),
	R_690802020100("690802020100", "1. Nangroe Aceh Darussalam", "e256"),
	R_690802020200("690802020200", "2. Sumatera Utara", "e257"),
	R_690802020300("690802020300", "3. Sumatera Barat", "e258"),
	R_690802020400("690802020400", "4. Riau", "e259"),
	R_690802020500("690802020500", "5. Kepulauan Riau", "e262"),
	R_690802020600("690802020600", "6. Kepulauan Bangka Belitung", "e261"),
	R_690802020700("690802020700", "7. Jambi", "e255"),
	R_690802020800("690802020800", "8. Sumatera Selatan", "e260"),
	R_690802020900("690802020900", "9. Bengkulu", "e254"),
	R_690802021000("690802021000", "10. Lampung", "e263"),
	R_690802021100("690802021100", "11. Kalimantan Barat", "e265"),
	R_690802021200("690802021200", "12. Kalimantan Tengah", "e267"),
	R_690802021300("690802021300", "13. Kalimantan Utara", "e796"),
	R_690802021400("690802021400", "14. Kalimantan Timur", "e266"),
	R_690802021500("690802021500", "15. Kalimantan Selatan", "e264"),
	R_690802021600("690802021600", "16. Sulawesi Utara", "e270"),
	R_690802021700("690802021700", "17. Gorontalo", "e271"),
	R_690802021800("690802021800", "18. Sulawesi Tengah", "e268"),
	R_690802021900("690802021900", "19. Sulawesi Barat", "e272"),
	R_690802022000("690802022000", "20. Sulawesi Selatan", "e269"),
	R_690802022100("690802022100", "21. Sulawesi Tenggara", "e273"),
	R_690802022200("690802022200", "22. Bali", "e275"),
	R_690802022300("690802022300", "23. Nusa Tenggara Barat", "e274"),
	R_690802022400("690802022400", "24. Nusa Tenggara Timur", "e276"),
	R_690802022500("690802022500", "25. Maluku Utara", "e279"),
	R_690802022600("690802022600", "26. Maluku", "e277"),
	R_690802022700("690802022700", "27. Papua Barat", "e280"),
	R_690802022800("690802022800", "28. Papua", "e278"),
	R_690802022900("690802022900", "29. Papua Tengah", "e244"),
	R_690802023000("690802023000", "30. Papua Pegunungan", "e245"),
	R_690802023100("690802023100", "31. Papua Selatan", "e246"),
	R_690802023200("690802023200", "32. Papua Barat Daya", "e247"),
	R_690802030000("690802030000", "c. Total Outstanding Dalam Perhatian Khusus", ""),
	R_690802030100("690802030100", "- Laki-laki", ""),
	R_690802030200("690802030200", "- Perempuan", ""),
	R_690802030300("690802030300", "- Badan Usaha", ""),
//	R_690802040000("690802040000", "d. Usia Borrower Perseorangan yang masuk dalam kategori Pendanaan Dalam Perhatian Khusus", ""),
	R_690802040100("690802040100", "- <19 tahun", ""),
	R_690802040200("690802040200", "- 19-34 Tahun", ""),
	R_690802040300("690802040300", "- 35-54 Tahun", ""),
	R_690802040400("690802040400", "- >54 Tahun", ""),
//	R_690803000000("690803000000", "3. Pendanaan Kurang Lancar", ""),
	R_690803010000("690803010000", "a. Jawa", ""),
	R_690803010100("690803010100", "1. Banten", "e249"),
	R_690803010200("690803010200", "2. DKI Jakarta", "e250"),
	R_690803010300("690803010300", "3. Jawa Barat", "e248"),
	R_690803010400("690803010400", "4. Jawa Tengah", "e252"),
	R_690803010500("690803010500", "5. DI Yogyakarta", "e251"),
	R_690803010600("690803010600", "6. Jawa Timur", "e253"),
	R_690803020000("690803020000", "b. Luar Jawa", ""),
	R_690803020100("690803020100", "1. Nangroe Aceh Darussalam", "e256"),
	R_690803020200("690803020200", "2. Sumatera Utara", "e257"),
	R_690803020300("690803020300", "3. Sumatera Barat", "e258"),
	R_690803020400("690803020400", "4. Riau", "e259"),
	R_690803020500("690803020500", "5. Kepulauan Riau", "e262"),
	R_690803020600("690803020600", "6. Kepulauan Bangka Belitung", "e261"),
	R_690803020700("690803020700", "7. Jambi", "e255"),
	R_690803020800("690803020800", "8. Sumatera Selatan", "e260"),
	R_690803020900("690803020900", "9. Bengkulu", "e254"),
	R_690803021000("690803021000", "10. Lampung", "e263"),
	R_690803021100("690803021100", "11. Kalimantan Barat", "e265"),
	R_690803021200("690803021200", "12. Kalimantan Tengah", "e267"),
	R_690803021300("690803021300", "13. Kalimantan Utara", "e796"),
	R_690803021400("690803021400", "14. Kalimantan Timur", "e266"),
	R_690803021500("690803021500", "15. Kalimantan Selatan", "e264"),
	R_690803021600("690803021600", "16. Sulawesi Utara", "e270"),
	R_690803021700("690803021700", "17. Gorontalo", "e271"),
	R_690803021800("690803021800", "18. Sulawesi Tengah", "e268"),
	R_690803021900("690803021900", "19. Sulawesi Barat", "e272"),
	R_690803022000("690803022000", "20. Sulawesi Selatan", "e269"),
	R_690803022100("690803022100", "21. Sulawesi Tenggara", "e273"),
	R_690803022200("690803022200", "22. Bali", "e275"),
	R_690803022300("690803022300", "23. Nusa Tenggara Barat", "e274"),
	R_690803022400("690803022400", "24. Nusa Tenggara Timur", "e276"),
	R_690803022500("690803022500", "25. Maluku Utara", "e279"),
	R_690803022600("690803022600", "26. Maluku", "e277"),
	R_690803022700("690803022700", "27. Papua Barat", "e280"),
	R_690803022800("690803022800", "28. Papua", "e278"),
	R_690803022900("690803022900", "29. Papua Tengah", "e244"),
	R_690803023000("690803023000", "30. Papua Pegunungan", "e245"),
	R_690803023100("690803023100", "31. Papua Selatan", "e246"),
	R_690803023200("690803023200", "32. Papua Barat Daya", "e247"),
	R_690803030000("690803030000", "c. Total Outstanding Pendanaan Kurang Lancar", ""),
	R_690803030100("690803030100", "- Laki-laki", ""),
	R_690803030200("690803030200", "- Perempuan", ""),
	R_690803030300("690803030300", "- Badan Usaha", ""),
//	R_690803040000("690803040000", "d. Usia Borrower Perseorangan yang masuk dalam kategori Pendanaan Kurang Lancar", ""),
	R_690803040100("690803040100", "- <19 tahun", ""),
	R_690803040200("690803040200", "- 19-34 Tahun", ""),
	R_690803040300("690803040300", "- 35-54 Tahun", ""),
	R_690803040400("690803040400", "- >54 Tahun", ""),
//	R_690804000000("690804000000", "4 Pendanaan Diragukan", ""),
	R_690804010000("690804010000", "a. Jawa", ""),
	R_690804010100("690804010100", "1. Banten", "e249"),
	R_690804010200("690804010200", "2. DKI Jakarta", "e250"),
	R_690804010300("690804010300", "3. Jawa Barat", "e248"),
	R_690804010400("690804010400", "4. Jawa Tengah", "e252"),
	R_690804010500("690804010500", "5. DI Yogyakarta", "e251"),
	R_690804010600("690804010600", "6. Jawa Timur", "e253"),
	R_690804020000("690804020000", "b. Luar Jawa", ""),
	R_690804020100("690804020100", "1. Nangroe Aceh Darussalam", "e256"),
	R_690804020200("690804020200", "2. Sumatera Utara", "e257"),
	R_690804020300("690804020300", "3. Sumatera Barat", "e258"),
	R_690804020400("690804020400", "4. Riau", "e259"),
	R_690804020500("690804020500", "5. Kepulauan Riau", "e262"),
	R_690804020600("690804020600", "6. Kepulauan Bangka Belitung", "e261"),
	R_690804020700("690804020700", "7. Jambi", "e255"),
	R_690804020800("690804020800", "8. Sumatera Selatan", "e260"),
	R_690804020900("690804020900", "9. Bengkulu", "e254"),
	R_690804021000("690804021000", "10. Lampung", "e263"),
	R_690804021100("690804021100", "11. Kalimantan Barat", "e265"),
	R_690804021200("690804021200", "12. Kalimantan Tengah", "e267"),
	R_690804021300("690804021300", "13. Kalimantan Utara", "e796"),
	R_690804021400("690804021400", "14. Kalimantan Timur", "e266"),
	R_690804021500("690804021500", "15. Kalimantan Selatan", "e264"),
	R_690804021600("690804021600", "16. Sulawesi Utara", "e270"),
	R_690804021700("690804021700", "17. Gorontalo", "e271"),
	R_690804021800("690804021800", "18. Sulawesi Tengah", "e268"),
	R_690804021900("690804021900", "19. Sulawesi Barat", "e272"),
	R_690804022000("690804022000", "20. Sulawesi Selatan", "e269"),
	R_690804022100("690804022100", "21. Sulawesi Tenggara", "e273"),
	R_690804022200("690804022200", "22. Bali", "e275"),
	R_690804022300("690804022300", "23. Nusa Tenggara Barat", "e274"),
	R_690804022400("690804022400", "24. Nusa Tenggara Timur", "e276"),
	R_690804022500("690804022500", "25. Maluku Utara", "e279"),
	R_690804022600("690804022600", "26. Maluku", "e277"),
	R_690804022700("690804022700", "27. Papua Barat", "e280"),
	R_690804022800("690804022800", "28. Papua", "e278"),
	R_690804022900("690804022900", "29. Papua Tengah", "e244"),
	R_690804023000("690804023000", "30. Papua Pegunungan", "e245"),
	R_690804023100("690804023100", "31. Papua Selatan", "e246"),
	R_690804023200("690804023200", "32. Papua Barat Daya", "e247"),
	R_690804030000("690804030000", "c. Total Outstanding Pendanaan Diragukan", ""),
	R_690804030100("690804030100", "- Laki-laki", ""),
	R_690804030200("690804030200", "- Perempuan", ""),
	R_690804030300("690804030300", "- Badan Usaha", ""),
//	R_690804040000("690804040000", "d.Usia Borrower Perseorangan yang masuk dalam kategori Pendanaan Diragukan", ""),
	R_690804040100("690804040100", "- <19 tahun", ""),
	R_690804040200("690804040200", "- 19-34 Tahun", ""),
	R_690804040300("690804040300", "- 35-54 Tahun", ""),
	R_690804040400("690804040400", "- >54 Tahun", ""),
//	R_690805000000("690805000000", "5 Pendanaan Macet", ""),
	R_690805010000("690805010000", "a. Jawa", ""),
	R_690805010100("690805010100", "1. Banten", "e249"),
	R_690805010200("690805010200", "2. DKI Jakarta", "e250"),
	R_690805010300("690805010300", "3. Jawa Barat", "e248"),
	R_690805010400("690805010400", "4. Jawa Tengah", "e252"),
	R_690805010500("690805010500", "5. DI Yogyakarta", "e251"),
	R_690805010600("690805010600", "6. Jawa Timur", "e253"),
	R_690805020000("690805020000", "b. Luar Jawa", ""),
	R_690805020100("690805020100", "1. Nangroe Aceh Darussalam", "e256"),
	R_690805020200("690805020200", "2. Sumatera Utara", "e257"),
	R_690805020300("690805020300", "3. Sumatera Barat", "e258"),
	R_690805020400("690805020400", "4. Riau", "e259"),
	R_690805020500("690805020500", "5. Kepulauan Riau", "e262"),
	R_690805020600("690805020600", "6. Kepulauan Bangka Belitung", "e261"),
	R_690805020700("690805020700", "7. Jambi", "e255"),
	R_690805020800("690805020800", "8. Sumatera Selatan", "e260"),
	R_690805020900("690805020900", "9. Bengkulu", "e254"),
	R_690805021000("690805021000", "10. Lampung", "e263"),
	R_690805021100("690805021100", "11. Kalimantan Barat", "e265"),
	R_690805021200("690805021200", "12. Kalimantan Tengah", "e267"),
	R_690805021300("690805021300", "13. Kalimantan Utara", "e796"),
	R_690805021400("690805021400", "14. Kalimantan Timur", "e266"),
	R_690805021500("690805021500", "15. Kalimantan Selatan", "e264"),
	R_690805021600("690805021600", "16. Sulawesi Utara", "e270"),
	R_690805021700("690805021700", "17. Gorontalo", "e271"),
	R_690805021800("690805021800", "18. Sulawesi Tengah", "e268"),
	R_690805021900("690805021900", "19. Sulawesi Barat", "e272"),
	R_690805022000("690805022000", "20. Sulawesi Selatan", "e269"),
	R_690805022100("690805022100", "21. Sulawesi Tenggara", "e273"),
	R_690805022200("690805022200", "22. Bali", "e275"),
	R_690805022300("690805022300", "23. Nusa Tenggara Barat", "e274"),
	R_690805022400("690805022400", "24. Nusa Tenggara Timur", "e276"),
	R_690805022500("690805022500", "25. Maluku Utara", "e279"),
	R_690805022600("690805022600", "26. Maluku", "e277"),
	R_690805022700("690805022700", "27. Papua Barat", "e280"),
	R_690805022800("690805022800", "28. Papua", "e278"),
	R_690805022900("690805022900", "29. Papua Tengah", "e244"),
	R_690805023000("690805023000", "30. Papua Pegunungan", "e245"),
	R_690805023100("690805023100", "31. Papua Selatan", "e246"),
	R_690805023200("690805023200", "32. Papua Barat Daya", "e247"),
	R_690805030000("690805030000", "c. Total Outstanding Pendanaan Macet", ""),
	R_690805030100("690805030100", "- Laki-laki", ""),
	R_690805030200("690805030200", "- Perempuan", ""),
	R_690805030300("690805030300", "- Badan Usaha", ""),
//	R_690805040000("690805040000", "d.Usia Borrower Perseorangan yang masuk dalam kategori Pendanaan Macet", ""),
	R_690805040100("690805040100", "- <19 tahun", ""),
	R_690805040200("690805040200", "- 19-34 Tahun", ""),
	R_690805040300("690805040300", "- 35-54 Tahun", ""),
	R_690805040400("690805040400", "- >54 Tahun", ""),
	R_690806000000("690806000000", "6. Total Pendanaan", ""),
	R_690807000000("690807000000", "7. TKB 90 (dalam %)", ""),
	R_690808000000("690808000000", "8. TWP 90 (dalam %)", ""),
	;

	@Getter
	private String key;
	private String value;
	private String dati1;

	public String getKeyForm() {
		return EFormLaporanBulanan.LB_6908.getCode() + key;
	}
	
	public String getValue() {
		String marker = ". ";
		value = StringUtils.strip(value, "-").trim();
		int idx = value.indexOf(marker);
		return idx > -1 ? value.substring(idx + 1).trim() : value;
	}

	public KeyValueString getObject() {
		return new KeyValueString(key, getValue(), new String[] {});
	}

	public KeyValueString getObjectForm() {
		return new KeyValueString(getKeyForm(), getValue(), new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3013PosLbFink6908 eEnum : ER3013PosLbFink6908.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static List<KeyValueString> getObjectsForm() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3013PosLbFink6908 eEnum : ER3013PosLbFink6908.values()) {
			res.add(eEnum.getObjectForm());
		}
		return res;
	}

	public static String getName() {
		return ER3013PosLbFink6908.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3013PosLbFink6908.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3|4", getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER3013PosLbFink6908[] eEnums = ER3013PosLbFink6908.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER3013PosLbFink6908 eEnum = eEnums[i];
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
						new int[] { 0, 7, 40, 41, 42, 43, 44, 45, 46, 47, 48, 55, 88, 89, 90, 91, 92, 93, 94, 95, 96,
								103, 136, 137, 138, 139, 140, 141, 142, 143, 144, 151, 184, 185, 186, 187, 188, 189,
								190, 191, 192, 199, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242 }));
	}
	
	public static ConditionalRequired genConditional3() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), 241, 242));
	}

	public static FieldValidation genFieldValidation2() {
		return UtilFieldValidation.genLookup("1", getLookup());
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumericNegative("3|4",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 241, 242 }));
	}
	
	public static SegmentValidation genValidationDecimal() {
		return UtilSegmentValidation.genRegexNumericDotNegative("4",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 241, 242 }));
	}
	
	public static SegmentValidation genRowValidation001() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690801010000.key,
				UtilMetadata.genPlusRow(getObjects(), 1, 6),
				UtilMetadata.genMessage(R_690801010000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 1, 6)));
	}
	
	public static SegmentValidation genRowValidation008() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690801020000.key,
				UtilMetadata.genPlusRow(getObjects(), 8, 39),
				UtilMetadata.genMessage(R_690801020000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 8, 39)));
	}
	
	public static SegmentValidation genRowValidation041() {
		int[] rows = new int[] { 0, 7 };
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690801030000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_690801030000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation049() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690802010000.key,
				UtilMetadata.genPlusRow(getObjects(), 49, 54),
				UtilMetadata.genMessage(R_690802010000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 49, 54)));
	}
	
	public static SegmentValidation genRowValidation056() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690802020000.key,
				UtilMetadata.genPlusRow(getObjects(), 56, 87),
				UtilMetadata.genMessage(R_690802020000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 56, 87)));
	}
	
	public static SegmentValidation genRowValidation089() {
		int[] rows = new int[] { 48, 55 };
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690802030000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_690802030000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation097() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690803010000.key,
				UtilMetadata.genPlusRow(getObjects(), 97, 102),
				UtilMetadata.genMessage(R_690803010000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 97, 102)));
	}
	
	public static SegmentValidation genRowValidation104() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690803020000.key,
				UtilMetadata.genPlusRow(getObjects(), 104, 135),
				UtilMetadata.genMessage(R_690803020000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 104, 135)));
	}
	
	public static SegmentValidation genRowValidation137() {
		int[] rows = new int[] { 96, 103 };
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690803030000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_690803030000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation145() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690804010000.key,
				UtilMetadata.genPlusRow(getObjects(), 145, 150),
				UtilMetadata.genMessage(R_690804010000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 145, 150)));
	}
	
	public static SegmentValidation genRowValidation152() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690804020000.key,
				UtilMetadata.genPlusRow(getObjects(), 152, 183),
				UtilMetadata.genMessage(R_690804020000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 152, 183)));
	}
	
	public static SegmentValidation genRowValidation185() {
		int[] rows = new int[] { 144, 151 };
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690804030000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_690804030000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation193() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690805010000.key,
				UtilMetadata.genPlusRow(getObjects(), 193, 198),
				UtilMetadata.genMessage(R_690805010000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 193, 198)));
	}
	
	public static SegmentValidation genRowValidation200() {
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690805020000.key,
				UtilMetadata.genPlusRow(getObjects(), 200, 231),
				UtilMetadata.genMessage(R_690805020000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 200, 231)));
	}
	
	public static SegmentValidation genRowValidation233() {
		int[] rows = new int[] { 192, 199 };
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690805030000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_690805030000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation234() {
		return UtilSegmentValidation.genEqualsFormula2("3|4", R_690805030100.key, UtilMetadata.genPlusRow(getObjects(), 233, 234),
				UtilMetadata.genPlusRow(getObjects(), 236, 239), 
				UtilMetadata.genMessage(UtilMetadata.genPlusDesc(getObjects(), 233, 234), UtilMetadata.genPlusDesc(getObjects(), 236, 239)), 2);
	}
	
	public static SegmentValidation genRowValidation241() {
		int[] rows = new int[] { 40, 88, 136, 184, 232 };
		return UtilSegmentValidation.genEqualsFormula("3|4", R_690806000000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_690806000000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation242() {
		int[] rows = new int[] { 40, 88, 136, 184 };
		return UtilSegmentValidation.genEqualsRatio("4", R_690807000000.key,
				UtilMetadata.genPlusRow(getObjects(), rows) + "|" + R_690806000000.key,
				UtilMetadata.genMessage(R_690807000000.getValue(),
						"(" + UtilMetadata.genPlusDesc(getObjects(), rows) + ")/" + R_690806000000.getValue()));
	}
	
	public static SegmentValidation genRowValidation243() {
		int[] rows = new int[] { 232, 240 };
		return UtilSegmentValidation.genEqualsRatio("4", R_690808000000.key,
				UtilMetadata.genPipeRow(getObjects(), rows),
				UtilMetadata.genMessage(R_690808000000.getValue(), UtilMetadata.genDevideDesc(getObjects(), rows)));
	}
}
