package id.go.ojk.fins.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.fins.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.fins.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3011PosLbFins6903 implements IObject<KeyValueString> {
	R_690301000000("690301000000", "Rasio Pendanaan Lancar"),
	R_690302000000("690302000000", "Rasio Pendanaan Dalam Perhatian Khusus"),
	R_690303000000("690303000000", "Rasio Pendanaan Kurang Lancar"),
	R_690304000000("690304000000", "Rasio Pendanaan Diragukan"),
	R_690305000000("690305000000", "Rasio Pendanaan Macet"),
	R_690306000000("690306000000", "Total"),
//	R_690307000000("690307000000", "Debt Collector:"),
	R_690307010000("690307010000", "a. Apakah Penyelenggara memiliki fungsi internal yang menangani collection?"),
	R_690307020000("690307020000", "b. Apakah Penyelenggara memiliki kerja sama dengan pihak ketiga dalam hal collection?"),
//	R_690308000000("690308000000", "Biaya Modal Tahunan"),
//	R_690308010000("690308010000", "Biaya Modal bagi Borrower"),
	R_690308020000("690308020000", "Biaya Modal bagi Borrower terendah p.a."),
	R_690308030000("690308030000", "Biaya Modal bagi Borrower tertinggi p.a."),
	R_690308040000("690308040000", "Rata-rata Biaya Modal bagi Borrower p.a."),
//	R_690309000000("690309000000", "Manfaat Ekonomi Efektif Tahunan"),
//	R_690309010000("690309010000", "Manfaat Ekonomi Efektif bagi Lender"),
	R_690309020000("690309020000", "Manfaat Ekonomi Efektif bagi Lender terendah p.a."),
	R_690309030000("690309030000", "Manfaat Ekonomi Efektif bagi Lender tertinggi p.a."),
	R_690309040000("690309040000", "Rata-rata Manfaat Ekonomi Efektif bagi Lender p.a."),
//	R_690310000000("690310000000", "Velocity/tempo"),
//	R_690310010000("690310010000", "Jangka Waktu Pendanaan (tenor)"),
	R_690310020000("690310020000", "Jangka waktu Pendanaan tercepat (satuan hari)"),
	R_690310030000("690310030000", "Jangka waktu Pendanaan terlama (satuan hari)"),
	R_690310040000("690310040000", "Rata-rata realisasi jangka waktu Pendanaan (satuan hari)"),
//	R_690310050000("690310050000", "Jangka Waktu Pendanaan Disetujui"),
	R_690310060000("690310060000", "Jangka waktu Pendanaan tercepat disetujui (satuan hari/jam/menit)"),
	R_690310070000("690310070000", "Jangka waktu Pendanaan terlama disetujui (satuan hari/jam/menit)"),
	R_690310080000("690310080000", "Rata-rata Jangka waktu Pendanaan disetujui (satuan hari/jam/menit)"),
//	R_690310090000("690310090000", "Jangka Waktu Pendanaan didanai"),
	R_690310100000("690310100000", "Jangka waktu Pendanaan tercepat didanai (satuan hari/jam/menit)"),
	R_690310110000("690310110000", "Jangka waktu Pendanaan terlama didanai (satuan hari/jam/menit)"),
	R_690310120000("690310120000", "Rata-rata Jangka waktu Pendanaan didanai (satuan hari/jam/menit)"),
//	R_690311000000("690311000000", "Sektor Produktif"),
//	R_690311010000("690311010000", "Sektor Produktif menurut Klasifikasi Baku Lapangan Usaha Indonesia (KBLI)"),
	R_690311010100("690311010100", "a. Pertanian, Kehutanan dan Perikanan"),
	R_690311010200("690311010200", "b. Pertambangan dan Penggalian"),
	R_690311010300("690311010300", "c. Industri Pengolahan"),
	R_690311010400("690311010400", "d. Pengadaan Listrik, Gas, Uap/Air Panas dan Udara Dingin"),
	R_690311010500("690311010500", "e. Treatment Air, Treatment Air Limbah, Treatment dan Pemulihan Material Sampah, dan Aktivitas Remediasi"),
	R_690311010600("690311010600", "f. Konstruksi"),
	R_690311010700("690311010700", "g. Perdagangan Besar dan Eceran; Reparasi dan Perawatan Mobil dan Sepeda Motor"),
	R_690311010800("690311010800", "h. Pengangkutan dan Pergudangan"),
	R_690311010900("690311010900", "i. Penyediaan Akomodasi dan Penyediaan Makan Minum"),
	R_690311011000("690311011000", "j. Informasi dan Komunikasi"),
	R_690311011100("690311011100", "k. Aktivitas Keuangan dan Asuransi"),
	R_690311011200("690311011200", "l. Real Estat"),
	R_690311011300("690311011300", "m. Aktivitas Profesional, Ilmiah dan Teknis"),
	R_690311011400("690311011400", "n. Aktivitas penyewaan dan sewa guna usaha tanpa hak opsi, ketenagakerjaan, agen perjalanan dan penunjang usaha lainnya"),
	R_690311011500("690311011500", "o. Administrasi Pemerintahan, Pertahanan dan Jaminan Sosial Wajib"),
	R_690311011600("690311011600", "p. Pendidikan"),
	R_690311011700("690311011700", "q. Aktivitas Kesehatan Manusia dan Aktivitas Sosial"),
	R_690311011800("690311011800", "r. Kesenian, Hiburan dan Rekreasi"),
	R_690311011900("690311011900", "s. Aktivitas Jasa lainnya"),
	R_690311012000("690311012000", "t. Aktivitas Yang Menghasilkan Barang dan Jasa Oleh Rumah Tangga Yang Digunakan Untuk Memenuhi Kebutuhan Sendiri"),
	R_690311012100("690311012100", "u. Aktivitas Badan Internasional dan Badan Ekstra Internasional Lainnya"),
	R_690311020000("690311020000", "Total Pendanaan kepada sektor produktif (dalam Rp)"),
	R_690312000000("690312000000", "Total Pendanaan"),
	R_690313000000("690313000000", "Persentase Pendanaan sektor produktif terhadap total Pendanaan (dalam %)"),
//	R_690314000000("690314000000", "Informasi Terkait Dengan:"),
//	R_690314010000("690314010000", "Kerja sama Penyaluran Pendanaan"),
//	R_690314010100("690314010100", "a. Kerja sama dengan Program Pemerintah:"),
	R_690314010101("690314010101", "1) Akumulasi Jumlah Institusi Pemerintah Lender (satuan entitas)"),
	R_690314010102("690314010102", "2) Akumulasi Jumlah Pendanaan yang telah diberikan kepada Borrower (dalam Rp)"),
//	R_690314010103("690314010103", "3) Pendanaan Quality:"),
	R_690314010104("690314010104", "a) Rasio Pendanaan Lancar"),
	R_690314010105("690314010105", "b) Rasio Pendanaan Dalam Perhatian Khusus"),
	R_690314010106("690314010106", "c) Rasio Pendanaan Kurang Lancar"),
	R_690314010107("690314010107", "d) Rasio Pendanaan Diragukan"),
	R_690314010108("690314010108", "e) Rasio Pendanaan Macet"),
	R_690314010109("690314010109", "Jumlah"),
//	R_690314010200("690314010200", "b. Kerja sama dengan Lembaga Jasa Keuangan:"),
	R_690314010201("690314010201", "1) Akumulasi Jumlah Lembaga Jasa Keuangan Lender (satuan entitas)"),
	R_690314010202("690314010202", "2) Akumulasi Jumlah Pendanaan yang telah diberikan kepada Borrower (dalam Rp)"),
//	R_690314010203("690314010203", "3) Pendanaan Quality:"),
	R_690314010204("690314010204", "a) Rasio Pendanaan Lancar"),
	R_690314010205("690314010205", "b) Rasio Pendanaan Dalam Perhatian Khusus"),
	R_690314010206("690314010206", "c) Rasio Pendanaan Kurang Lancar"),
	R_690314010207("690314010207", "d) Rasio Pendanaan Diragukan"),
	R_690314010208("690314010208", "e) Rasio Pendanaan Macet"),
	R_690314010209("690314010209", "Jumlah"),
//	R_690315000000("690315000000", "Others"),
	R_690316000000("690316000000", "Rata-rata biaya collection"),
//	R_690317000000("690317000000", "Nilai Pendanaan"),
	R_690318000000("690318000000", "Nilai Pendanaan tertinggi yang disalurkan kepada 1 borrower"),
	R_690319000000("690319000000", "Nilai Pendanaan terendah yang disalurkan kepada 1 borrower"),
	R_690320000000("690320000000", "Rata-rata nilai Pendanaan yang disalurkan"),
	R_690321000000("690321000000", "Jumlah Pengajuan Permohonan Pendanaan (Unit)"),
	R_690322000000("690322000000", "Jumlah Pengajuan Permohonan Pendanaan Yang Ditolak/ Tidak Disetujui (Unit)"),
	R_690323000000("690323000000", "Jumlah Permohonan Pendanaan Yang Ditolak karena tidak 100% terdanai (Unit)"),
	;

	@Getter
	private String key;
	private String value;

	public String getValue() {
		List<String> markers = Arrays.asList(". ", ") ");
		for (String marker : markers) {
			int idx = value.indexOf(marker);
			if (idx > -1) {
				return value.substring(idx + 1).trim();
			}
		}
		return value;
	}

	public KeyValueString getObject() {
		return new KeyValueString(key, getValue(), new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3011PosLbFins6903 eEnum : ER3011PosLbFins6903.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3011PosLbFins6903.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3011PosLbFins6903.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static ConditionalRequired genConditional2() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), 6, 7));
	}
	
	public static ConditionalRequired genConditional3() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), 0, 5));
	}
	
	public static FieldValidation genFieldValidation() {
		return UtilFieldValidation.genNotEqualsPosFixedValue("00:00:00", UtilMetadata.genPipeRow(getObjects(), 17, 22));
	}
	
	public static SegmentValidation genValidationLen1() {
		return UtilSegmentValidation.genMaxLength("2|3", UtilMetadata.genPipeRow(getObjects(), new int[] { 6, 7 }),
				1);
	}
	
	public static SegmentValidation genValidationDecimalA() {
		return UtilSegmentValidation.genRegexNumericDot("3",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 3, 4, 5 }));
	}

	public static SegmentValidation genValidationDecimalB() {
		return UtilSegmentValidation.genRegexNumericDot("2|3", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 8, 9, 10, 11, 12, 13, 46, 49, 50, 51, 52, 53, 54, 57, 58, 59, 60, 61, 62, 63 }));
	}

	public static SegmentValidation genValidationNumericA() {
		return UtilSegmentValidation.genRegexNumeric("3",
				UtilMetadata.genPipeRow(getObjects(),
						new int[] { 6, 7 }));
	}

	public static SegmentValidation genValidationNumericB() {
		return UtilSegmentValidation.genRegexNumeric("2|3",
				UtilMetadata.genPipeRow(getObjects(),
						new int[] { 14, 15, 16, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38,
								39, 40, 41, 42, 43, 44, 45, 47, 48, 55, 56, 64, 65, 66, 67, 68, 69 }));
	}
	
	public static SegmentValidation genValidationPeriod() {
		return UtilSegmentValidation.genPeriodValidation("2|3",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 17, 18, 19, 20, 21, 22 }));
	}

	public static SegmentValidation genValidationReferenceAvailable() {
		return UtilSegmentValidation.genReference("3", UtilMetadata.genPipeRow(getObjects(), new int[] { 6, 7 }),
				EHeaderMetadataShared.R002.getNumber());
	}
	
	public static SegmentValidation genRowValidation01() {
		return UtilSegmentValidation.genEqualsPercentageForm("2", R_690301000000.key,
				EFormLaporanBulanan.LB_6908.getCode(), "4", ER3013PosLbFins6908.R_690801030000.getKey(),
				EFormLaporanBulanan.LB_6902.getCode(), "3", ER3010PosLbFins6902.R_690203030000.getKey(),
				UtilMetadata.genMessage(R_690301000000.getValue(), genMessage(
						ER3013PosLbFins6908.R_690801030000.getValue(), ER3010PosLbFins6902.R_690203030000.getValue())),
				2);
	}
	
	public static SegmentValidation genRowValidation02() {
		return UtilSegmentValidation.genEqualsPercentageForm("2", R_690302000000.key,
				EFormLaporanBulanan.LB_6908.getCode(), "4", ER3013PosLbFins6908.R_690802030000.getKey(),
				EFormLaporanBulanan.LB_6902.getCode(), "3", ER3010PosLbFins6902.R_690203030000.getKey(),
				UtilMetadata.genMessage(R_690302000000.getValue(), genMessage(
						ER3013PosLbFins6908.R_690802030000.getValue(), ER3010PosLbFins6902.R_690203030000.getValue())),
				2);
	}
	
	public static SegmentValidation genRowValidation03() {
		return UtilSegmentValidation.genEqualsPercentageForm("2", R_690303000000.key,
				EFormLaporanBulanan.LB_6908.getCode(), "4", ER3013PosLbFins6908.R_690803030000.getKey(),
				EFormLaporanBulanan.LB_6902.getCode(), "3", ER3010PosLbFins6902.R_690203030000.getKey(),
				UtilMetadata.genMessage(R_690303000000.getValue(), genMessage(
						ER3013PosLbFins6908.R_690803030000.getValue(), ER3010PosLbFins6902.R_690203030000.getValue())),
				2);
	}
	
	public static SegmentValidation genRowValidation04() {
		return UtilSegmentValidation.genEqualsPercentageForm("2", R_690304000000.key,
				EFormLaporanBulanan.LB_6908.getCode(), "4", ER3013PosLbFins6908.R_690804030000.getKey(),
				EFormLaporanBulanan.LB_6902.getCode(), "3", ER3010PosLbFins6902.R_690203030000.getKey(),
				UtilMetadata.genMessage(R_690304000000.getValue(), genMessage(
						ER3013PosLbFins6908.R_690804030000.getValue(), ER3010PosLbFins6902.R_690203030000.getValue())),
				2);
	}
	
	public static SegmentValidation genRowValidation05() {
		return UtilSegmentValidation.genEqualsPercentageForm("2", R_690305000000.key,
				EFormLaporanBulanan.LB_6908.getCode(), "4", ER3013PosLbFins6908.R_690805030000.getKey(),
				EFormLaporanBulanan.LB_6902.getCode(), "3", ER3010PosLbFins6902.R_690203030000.getKey(),
				UtilMetadata.genMessage(R_690305000000.getValue(), genMessage(
						ER3013PosLbFins6908.R_690805030000.getValue(), ER3010PosLbFins6902.R_690203030000.getValue())),
				2);
	}
	
	public static SegmentValidation genRowValidation06A() {
		return UtilSegmentValidation.genEqualsFormula3("2", R_690306000000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 4), ".50", "100.00",
				UtilMetadata.genPlusDesc(getObjects(), 0, 4));
	}
	
	public static SegmentValidation genRowValidation06B() {
		return UtilSegmentValidation.genFixedValue("2", R_690306000000.key, "100.00");
	}
	
	public static SegmentValidation genRowValidation10() {
		return UtilSegmentValidation.genGreaterEquals("2|3", R_690308030000.key, R_690308020000.key);
	}
	
	public static SegmentValidation genRowValidation11A() {
		return UtilSegmentValidation.genGreaterEquals("2|3", R_690308040000.key, R_690308020000.key);
	}
	
	public static SegmentValidation genRowValidation11B() {
		return UtilSegmentValidation.genLessEquals("2|3", R_690308040000.key, R_690308030000.key);
	}
	
	public static SegmentValidation genRowValidation13() {
		return UtilSegmentValidation.genGreaterEquals("2|3", R_690309030000.key, R_690309020000.key);
	}
	
	public static SegmentValidation genRowValidation114A() {
		return UtilSegmentValidation.genGreaterEquals("2|3", R_690309040000.key, R_690309020000.key);
	}
	
	public static SegmentValidation genRowValidation14B() {
		return UtilSegmentValidation.genLessEquals("2|3", R_690309040000.key, R_690309030000.key);
	}
	
	public static SegmentValidation genRowValidation15() {
		return UtilSegmentValidation.genLessEquals("2|3", R_690310020000.key, R_690310030000.key);
	}
	
	public static SegmentValidation genRowValidation17A() {
		return UtilSegmentValidation.genGreaterEquals("2|3", R_690310040000.key, R_690310020000.key);
	}
	
	public static SegmentValidation genRowValidation17B() {
		return UtilSegmentValidation.genLessEquals("2|3", R_690310040000.key, R_690310030000.key);
	}
	
	public static SegmentValidation genRowValidation45() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_690311020000.key,
				UtilMetadata.genPlusRow(getObjects(), 23, 43),
				UtilMetadata.genMessage(R_690311020000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 23, 43)));
	}

	public static SegmentValidation genRowValidation46A() {
		return UtilSegmentValidation.genEqualsForm("2", R_690312000000.key, EFormLaporanBulanan.LB_6902.getCode(), "3",
				ER3010PosLbFins6902.R_690202030000.getKey(),
				UtilMetadata.genMessage(R_690312000000.getValue(), "Agregat (Total) pada form 6902"));
	}

	public static SegmentValidation genRowValidation46B() {
		return UtilSegmentValidation.genEqualsForm("3", R_690312000000.key, EFormLaporanBulanan.LB_6902.getCode(), "4",
				ER3010PosLbFins6902.R_690202030000.getKey(),
				UtilMetadata.genMessage(R_690312000000.getValue(), "Agregat (Total) pada form 6902"));
	}
	
	public static SegmentValidation genRowValidation47() {
		int[] rows = new int[] { 44, 45 };
		return UtilSegmentValidation.genEqualsRatio("2|3", R_690313000000.key, R_690311020000.key + "|" + R_690312000000.key,
				UtilMetadata.genMessage(R_690313000000.getValue(), UtilMetadata.genDevideDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation55() {
		return UtilSegmentValidation.genPendanaanQuality("2|3", R_690314010109.key, UtilMetadata.genPlusRow(getObjects(), 49, 53), 
				"100.00", "0.50", R_690314010101.key + "|" + R_690314010102.key, "0.00", UtilMetadata.genPlusDesc(getObjects(), 49, 53));
	}
	
	public static SegmentValidation genRowValidation63() {
		return UtilSegmentValidation.genPendanaanQuality("2|3", R_690314010209.key, UtilMetadata.genPlusRow(getObjects(), 57, 61), 
				"100.00", "0.50", R_690314010201.key + "|" + R_690314010202.key, "0.00", UtilMetadata.genPlusDesc(getObjects(), 57, 61));
	}
	
	public static SegmentValidation genRowValidation66() {
		return UtilSegmentValidation.genLessEquals("2|3", R_690319000000.key, R_690318000000.key);
	}
	
	public static SegmentValidation genRowValidation67A() {
		return UtilSegmentValidation.genGreaterEquals("2|3", R_690320000000.key, R_690319000000.key);
	}
	
	public static SegmentValidation genRowValidation67B() {
		return UtilSegmentValidation.genLessEquals("2|3", R_690320000000.key, R_690318000000.key);
	}
	
	private static String genMessage(String nameRow1, String nameRow2) {
		return nameRow1 + " pada form 6908/" + nameRow2 + " pada form 6902";
	}
}
