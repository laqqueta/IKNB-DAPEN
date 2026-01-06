package id.go.ojk.fins.client.builder.field.lt.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.fins.client.builder.field.EFormLaporanTahunan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER6001PosLtFins1100 implements IObject<KeyValueString> {
//	R_110001000000("110001000000", "I.Aset"),
//	R_110001010000("110001010000", "A. Aset Lancar"),
	R_110001010100("110001010100", "1. Kas dan Setara Kas"),
	R_110001010200("110001010200", "2. Piutang Usaha"),
	R_110001010201("110001010201", "a. Pihak Berelasi"),
	R_110001010202("110001010202", "b. Pihak Ketiga"),
	R_110001010300("110001010300", "3. Cadangan Kerugian Penurunan Nilai"),
	R_110001010400("110001010400", "4. Pajak dibayar di muka"),
	R_110001010500("110001010500", "5. Biaya dibayar di muka"),
	R_110001010600("110001010600", "6. Uang Jaminan/Deposit"),
	R_110001010700("110001010700", "7. Investasi Jangka Pendek"),
	R_110001010800("110001010800", "8. Piutang Lancar Lainnya"),
	R_110001010801("110001010801", "a. Pihak Berelasi"),
	R_110001010802("110001010802", "b. Pihak Ketiga"),
	R_110001010900("110001010900", "9. Aset Lancar Lainnya"),
	R_110001020000("110001020000", "Jumlah Aset Lancar"),
//	R_110001030000("110001030000", "B. Aset Tidak Lancar"),
	R_110001030100("110001030100", "1. Aset Takberwujud"),
	R_110001030200("110001030200", "2. Akumulasi Amortisasi"),
	R_110001030300("110001030300", "3. Gedung, Tanah dan Peralatan"),
	R_110001030400("110001030400", "4. Akumulasi Penyusutan"),
	R_110001030500("110001030500", "5. Investasi Jangka Panjang"),
	R_110001030600("110001030600", "6. Aset Pajak Tangguhan"),
	R_110001030700("110001030700", "7. Piutang Tidak Lancar Lainnya"),
	R_110001030701("110001030701", "a. Pihak Berelasi"),
	R_110001030702("110001030702", "b. Pihak Ketiga"),
	R_110001030800("110001030800", "8. Aset Tidak Lancar Lainnya "),
	R_110001040000("110001040000", "Jumlah Aset Tidak Lancar"),
	R_110002000000("110002000000", "Jumlah Aset"),
//	R_110003000000("110003000000", "II. Liabilitas"),
//	R_110003010000("110003010000", "A. Liabilitas Jangka Pendek"),
	R_110003010100("110003010100", "1. Pendapatan Diterima Di Muka"),
	R_110003010200("110003010200", "2. Utang Usaha - Pihak Ketiga"),
	R_110003010300("110003010300", "3. Utang Jangka Pendek lainnya"),
	R_110003010301("110003010301", "a. Pihak Berelasi"),
	R_110003010302("110003010302", "b. Pihak Ketiga"),
	R_110003010400("110003010400", "4. Utang Pajak"),
	R_110003010500("110003010500", "5. Beban yang masih harus dibayar"),
	R_110003020000("110003020000", "Jumlah Liabilitas Jangka Pendek"),
//	R_110003030000("110003030000", "B. Liabilitas Jangka Panjang"),
	R_110003030100("110003030100", "1. Utang Jangka Panjang Lainnya"),
	R_110003030101("110003030101", "a. Pihak Berelasi"),
	R_110003030102("110003030102", "b. Pihak Ketiga"),
	R_110003030200("110003030200", "2. Liabilitas imbalan pasca kerja"),
	R_110003030300("110003030300", "3. Liabilitas Sewa"),
	R_110003040000("110003040000", "Jumlah Liabilitas Jangka Panjang"),
	R_110004000000("110004000000", "Jumlah Liabilitas"),
//	R_110005000000("110005000000", "III. Ekuitas"),
	R_110005010000("110005010000", "1. Modal Saham"),
	R_110005020000("110005020000", "2. Tambahan Modal Disetor"),
	R_110005030000("110005030000", "3. Uang Muka Setoran Modal"),
	R_110005040000("110005040000", "4. Laba (Rugi) Ditahan"),
	R_110005050000("110005050000", "5. Laba (Rugi) Periode Berjalan"),
	R_110005060000("110005060000", "6. Kepentingan Non-Pengendali"),
	R_110005070000("110005070000", "7. Ekuitas Lainnya"),
	R_110006000000("110006000000", "Jumlah Ekuitas"),
	R_110007000000("110007000000", "Jumlah Liabilitas dan Ekuitas"),
	;

	private String key;
	private String value;

	public String getKeyForm() {
		return EFormLaporanTahunan.LT_1100.getCode() + key;
	}

	public String getValue() {
		String marker = ". ";
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
		for (ER6001PosLtFins1100 eEnum : ER6001PosLtFins1100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static List<KeyValueString> getObjectsForm() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER6001PosLtFins1100 eEnum : ER6001PosLtFins1100.values()) {
			res.add(eEnum.getObjectForm());
		}
		return res;
	}

	public static String getName() {
		return ER6001PosLtFins1100.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER6001PosLtFins1100.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}

	public static SegmentValidation genRowValidation01A() {
		return UtilSegmentValidation.genEqualsForm2("2", R_110001010100.key, EFormLaporanTahunan.LT_1300.getCode(),
				ER6004PosLtFins1300.R_130007000000.getKey(),
				UtilMetadata.genMessage(R_110001010100.getValue(), "Kas dan Setara Kas pada Akhir Periode pada form 1300"));
	}

	public static SegmentValidation genRowValidation01B() {
		return UtilSegmentValidation.genEqualsForm("2", R_110001010100.key, EFormLaporanTahunan.LT_2111.getCode(), "4",
				ER6006PosLtFins2111.R_211101000000.getKey(),
				UtilMetadata.genMessage(R_110001010100.getValue(), "Total jumlah pada form 2111"));
	}

	public static SegmentValidation genRowValidation02() {
		return UtilSegmentValidation.genEqualsFormula("2", R_110001010200.key,
				UtilMetadata.genPlusRow(getObjects(), 2, 3),
				UtilMetadata.genMessage(R_110001010200.getValue(), UtilMetadata.genPlusDesc(getObjects(), 2, 3)));
	}

	public static SegmentValidation genRowValidation10A() {
		return UtilSegmentValidation.genEqualsFormula("2", R_110001010800.key,
				UtilMetadata.genPlusRow(getObjects(), 10, 11),
				UtilMetadata.genMessage(R_110001010800.getValue(), UtilMetadata.genPlusDesc(getObjects(), 10, 11)));
	}

	public static SegmentValidation genRowValidation10B() {
		return UtilSegmentValidation.genEqualsForm("2", R_110001010800.key, EFormLaporanTahunan.LT_2112.getCode(), "5",
				ER6007PosLtFins2112.R_211201000000.getKey(),
				UtilMetadata.genMessage(R_110001010800.getValue(), "Total jumlah piutang lancar lainnya pada form 2112"));
	}

	public static SegmentValidation genRowValidation14() {
		int[] rows = new int[] { 0, 1, 4, 5, 6, 7, 8, 9, 12 };
		return UtilSegmentValidation.genEqualsFormula("2", R_110001020000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_110001020000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation15() {
		return UtilSegmentValidation.genEqualsForm("2", R_110001030100.key, EFormLaporanTahunan.LT_2116.getCode(), "6",
				ER6008PosLtFins2116.R_211601000000.getKey(),
				UtilMetadata.genMessage(R_110001030100.getValue(), "Total jumlah saldo akhir pada form 2116"));
	}

	public static SegmentValidation genRowValidation16() {
		return UtilSegmentValidation.genRegexNumericMustNegative("2", R_110001030200.key);
	}
	
	public static SegmentValidation genRowValidation18() {
		return UtilSegmentValidation.genRegexNumericMustNegative("2", R_110001030400.key);
	}

	public static SegmentValidation genRowValidation21A() {
		return UtilSegmentValidation.genEqualsFormula("2", R_110001030700.key,
				UtilMetadata.genPlusRow(getObjects(), 21, 22),
				UtilMetadata.genMessage(R_110001030700.getValue(), UtilMetadata.genPlusDesc(getObjects(), 21, 22)));
	}

	public static SegmentValidation genRowValidation21B() {
		return UtilSegmentValidation.genEqualsForm("2", R_110001030700.key, EFormLaporanTahunan.LT_2113.getCode(), "5",
				ER6009PosLtFins2113.R_211301000000.getKey(),
				UtilMetadata.genMessage(R_110001030700.getValue(), "Total jumlah piutang lancar lainnya pada form 2113"));
	}

	public static SegmentValidation genRowValidation25() {
		int[] rows = new int[] { 14, 15, 16, 17, 18, 19, 20, 23 };
		return UtilSegmentValidation.genEqualsFormula("2", R_110001040000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_110001040000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation26A() {
		int[] rows = new int[] { 13, 24 };
		return UtilSegmentValidation.genEqualsFormula("2", R_110002000000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_110002000000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation26B() {
		return UtilSegmentValidation.genEqualsFormula("2", R_110002000000.key, R_110007000000.key,
				UtilMetadata.genMessage(R_110002000000.getValue(), R_110007000000.getValue()));
	}

	public static SegmentValidation genRowValidation29A() {
		return UtilSegmentValidation.genEqualsFormula("2", R_110003010300.key,
				UtilMetadata.genPlusRow(getObjects(), 29, 30),
				UtilMetadata.genMessage(R_110003010300.getValue(), UtilMetadata.genPlusDesc(getObjects(), 29, 30)));
	}

	public static SegmentValidation genRowValidation29B() {
		return UtilSegmentValidation.genEqualsForm("2", R_110003010300.key, EFormLaporanTahunan.LT_2114.getCode(), "5",
				ER6010PosLtFins2114.R_211401000000.getKey(),
				UtilMetadata.genMessage(R_110003010300.getValue(), "Total jumlah utang jangka pendek lainnya pada form 2114"));
	}

	public static SegmentValidation genRowValidation33() {
		return UtilSegmentValidation.genEqualsForm("2", R_110003010500.key, EFormLaporanTahunan.LT_2117.getCode(), "3",
				ER6011PosLtFins2117.R_211701000000.getKey(),
				UtilMetadata.genMessage(R_110003010500.getValue(), "Total jumlah biaya pada form 2117"));
	}

	public static SegmentValidation genRowValidation34() {
		int[] rows = new int[] { 26, 27, 28, 31, 32 };
		return UtilSegmentValidation.genEqualsFormula("2", R_110003020000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_110003020000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation35A() {
		return UtilSegmentValidation.genEqualsFormula("2", R_110003030100.key,
				UtilMetadata.genPlusRow(getObjects(), 35, 36),
				UtilMetadata.genMessage(R_110003030100.getValue(), UtilMetadata.genPlusDesc(getObjects(), 35, 36)));
	}

	public static SegmentValidation genRowValidation35B() {
		return UtilSegmentValidation.genEqualsForm("2", R_110003030100.key, EFormLaporanTahunan.LT_2115.getCode(), "5",
				ER6012PosLtFins2115.R_211501000000.getKey(),
				UtilMetadata.genMessage(R_110003030100.getValue(), "Total jumlah utang jangka panjang lainnya pada form 2115"));
	}

	public static SegmentValidation genRowValidation40() {
		int[] rows = new int[] { 34, 37, 38 };
		return UtilSegmentValidation.genEqualsFormula("2", R_110003040000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_110003040000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation41() {
		int[] rows = new int[] { 33, 39 };
		return UtilSegmentValidation.genEqualsFormula("2", R_110004000000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_110004000000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation46() {
		return UtilSegmentValidation.genEqualsForm2("2", R_110005050000.key, EFormLaporanTahunan.LT_1200.getCode(), 
				ER6002PosLtFins1200.R_120013000000.getKey(),
				UtilMetadata.genMessage(R_110005050000.getValue(), "Laba (Rugi) Komprehensif pada form 1200"));
	}

	public static SegmentValidation genRowValidation48A() {
		return UtilSegmentValidation.genEqualsFormula("2", R_110006000000.key,
				UtilMetadata.genPlusRow(getObjects(), 41, 47),
				UtilMetadata.genMessage(R_110006000000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 41, 47)));
	}

	public static SegmentValidation genRowValidation48B() {
		return UtilSegmentValidation.genEqualsForm2("2", R_110006000000.key, EFormLaporanTahunan.LT_1201.getCode(), 
				ER6003PosLtFins1201.R_120103000000.getKey(),
				UtilMetadata.genMessage(R_110006000000.getValue(), "Saldo ekuitas akhir periode pada form 1201"));
	}

	public static SegmentValidation genRowValidation49() {
		int[] rows = new int[] { 40, 48 };
		return UtilSegmentValidation.genEqualsFormula("2", R_110007000000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_110007000000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
}
