package id.go.ojk.fins.client.builder.field.apu.reference;

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
public enum ER5000PosApuFins01 implements IObject<KeyValueString> {
//	R_0101000000000000 ("0101000000000000", "I. Pengguna Borrower"),
//	R_0101010000000000 ("0101010000000000", "A. Jenis Pengguna"),
	R_0101010100000000 ("0101010100000000", "1) Pengguna Orang Perseorangan"),
	R_0101010101000000 ("0101010101000000", "a) Pengguna Orang Perseorangan WNI"),
	R_0101010101010000 ("0101010101010000", "i) Pengguna WNI yang bertindak untuk dan atas nama/kepentingan sendiri"),
	R_0101010101020000 ("0101010101020000", "ii) Pengguna WNI yang memiliki Beneficial Owner"),
	R_0101010102000000 ("0101010102000000", "b) Pengguna Orang Perseorangan WNA"),
	R_0101010102010000 ("0101010102010000", "i) Pengguna WNA yang bertindak untuk dan atas nama/kepentingan sendiri"),
	R_0101010102020000 ("0101010102020000", "ii) Pengguna WNA yang memiliki Beneficial Owner"),
	R_0101010200000000 ("0101010200000000", "2) Pengguna Korporasi"),
	R_0101010201000000 ("0101010201000000", "a) Pengguna Berbentuk Korporasi Domestik (Dalam Negeri)"),
	R_0101010202000000 ("0101010202000000", "b) Pengguna Berbentuk Korporasi Asing"),
//	R_0101020000000000 ("0101020000000000", "B. Tingkat Risiko Pengguna"),
//	R_0101020100000000 ("0101020100000000", "1) Pengguna Berisiko Tinggi"),
	R_0101020101000000 ("0101020101000000", "a) Pengguna Orang Perseorangan yang Tergolong PEP"),
	R_0101020101010000 ("0101020101010000", "i) PEP Domestik (Dalam Negeri)"),
	R_0101020101020000 ("0101020101020000", "ii) PEP Asing"),
	R_0101020101030000 ("0101020101030000", "iii) Orang yang Diberi Kewenangan untuk Melakukan Fungsi Penting (Prominent Function) oleh Organisasi Internasional"),
	R_0101020102000000 ("0101020102000000", "b) Pengguna Berisiko Tinggi Selain PEP"),
	R_0101020102010000 ("0101020102010000", "i) Pengguna Orang Perseorangan yang Berisiko Tinggi"),
	R_0101020102010100 ("0101020102010100", "a. Pengguna WNI yang Berisiko Tinggi"),
	R_0101020102010200 ("0101020102010200", "b. Pengguna WNA yang Berisiko Tinggi"),
	R_0101020102020000 ("0101020102020000", "ii) Pengguna Korporasi yang Berisiko Tinggi"),
	R_0101020102020100 ("0101020102020100", "a. Pengguna Korporasi Domestik (Dalam Negeri) yang Berisiko Tinggi"),
	R_0101020102020200 ("0101020102020200", "b. Pengguna Korporasi Asing yang Berisiko Tinggi"),
//	R_0101020200000000 ("0101020200000000", "2) Pengguna Berisiko Menengah"),
	R_0101020201000000 ("0101020201000000", "a) Pengguna Orang Perseorangan yang Berisiko Menengah"),
	R_0101020201010000 ("0101020201010000", "i) Pengguna WNI yang Berisiko Menengah"),
	R_0101020201020000 ("0101020201020000", "ii) Pengguna WNA yang Berisiko Menengah"),
	R_0101020202000000 ("0101020202000000", "b) Pengguna Korporasi yang Berisiko Menengah"),
	R_0101020202010000 ("0101020202010000", "i) Pengguna Korporasi Domestik (Dalam Negeri) yang Berisiko Menengah"),
	R_0101020202020000 ("0101020202020000", "ii) Pengguna Korporasi Asing yang Berisiko Menengah"),
//	R_0101020300000000 ("0101020300000000", "3) Pengguna Berisiko Rendah"),
	R_0101020301000000 ("0101020301000000", "a) Pengguna Orang Perseorangan yang Berisiko Rendah"),
	R_0101020301010000 ("0101020301010000", "i) Pengguna WNI yang Berisiko Rendah"),
	R_0101020301020000 ("0101020301020000", "ii) Pengguna WNA yang Berisiko Rendah"),
	R_0101020302000000 ("0101020302000000", "b) Pengguna Korporasi yang Berisiko Rendah"),
	R_0101020302010000 ("0101020302010000", "i) Pengguna Korporasi Domestik (Dalam Negeri) yang Berisiko Rendah"),
	R_0101020302020000 ("0101020302020000", "ii) Pengguna Korporasi Asing yang Berisiko Rendah"),
//	R_0102000000000000 ("0102000000000000", "II. Pengguna Lender"),
//	R_0102010000000000 ("0102010000000000", "A. Jenis Pengguna"),
	R_0102010100000000 ("0102010100000000", "1) Pengguna Orang Perseorangan"),
	R_0102010101000000 ("0102010101000000", "a) Pengguna Orang Perseorangan WNI"),
	R_0102010101010000 ("0102010101010000", "i) Pengguna WNI yang bertindak untuk dan atas nama/kepentingan sendiri"),
	R_0102010101020000 ("0102010101020000", "ii) Pengguna WNI yang memiliki Beneficial Owner"),
	R_0102010102000000 ("0102010102000000", "b) Pengguna Orang Perseorangan WNA"),
	R_0102010102010000 ("0102010102010000", "i) Pengguna WNA yang bertindak untuk dan atas nama/kepentingan sendiri"),
	R_0102010102020000 ("0102010102020000", "ii) Pengguna WNA yang memiliki Beneficial Owner"),
	R_0102010200000000 ("0102010200000000", "2) Pengguna Korporasi"),
	R_0102010201000000 ("0102010201000000", "a) Pengguna Berbentuk Korporasi Domestik (Dalam Negeri)"),
	R_0102010202000000 ("0102010202000000", "b) Pengguna Berbentuk Korporasi Asing"),
//	R_0102020000000000 ("0102020000000000", "B. Tingkat Risiko Pengguna"),
	R_0102020100000000 ("0102020100000000", "1) Pengguna Berisiko Tinggi"),
	R_0102020101000000 ("0102020101000000", "a) Pengguna Orang Perseorangan yang Tergolong PEP"),
	R_0102020101010000 ("0102020101010000", "i) PEP Domestik (Dalam Negeri)"),
	R_0102020101020000 ("0102020101020000", "ii) PEP Asing"),
	R_0102020101030000 ("0102020101030000", "iii) Orang yang Diberi Kewenangan untuk Melakukan Fungsi Penting (Prominent Function) oleh Organisasi Internasional"),
	R_0102020102000000 ("0102020102000000", "b) Pengguna Berisiko Tinggi Selain PEP"),
	R_0102020102010000 ("0102020102010000", "i) Pengguna Orang Perseorangan yang Berisiko Tinggi"),
	R_0102020102010100 ("0102020102010100", "a. Pengguna WNI yang Berisiko Tinggi"),
	R_0102020102010200 ("0102020102010200", "b. Pengguna WNA yang Berisiko Tinggi"),
	R_0102020102020000 ("0102020102020000", "ii) Pengguna Korporasi yang Berisiko Tinggi"),
	R_0102020102020100 ("0102020102020100", "a. Pengguna Korporasi Domestik (Dalam Negeri) yang Berisiko Tinggi"),
	R_0102020102020200 ("0102020102020200", "b. Pengguna Korporasi Asing yang Berisiko Tinggi"),
	R_0102020200000000 ("0102020200000000", "2) Pengguna Berisiko Menengah"),
	R_0102020201000000 ("0102020201000000", "a) Pengguna Orang Perseorangan yang Berisiko Menengah"),
	R_0102020201010000 ("0102020201010000", "i) Pengguna WNI yang Berisiko Menengah"),
	R_0102020201020000 ("0102020201020000", "ii) Pengguna WNA yang Berisiko Menengah"),
	R_0102020202000000 ("0102020202000000", "b) Pengguna Korporasi yang Berisiko Menengah"),
	R_0102020202010000 ("0102020202010000", "i) Pengguna Korporasi Domestik (Dalam Negeri) yang Berisiko Menengah"),
	R_0102020202020000 ("0102020202020000", "ii) Pengguna Korporasi Asing yang Berisiko Menengah"),
	R_0102020300000000 ("0102020300000000", "3) Pengguna Berisiko Rendah"),
	R_0102020301000000 ("0102020301000000", "a) Pengguna Orang Perseorangan yang Berisiko Rendah"),
	R_0102020301010000 ("0102020301010000", "i) Pengguna WNI yang Berisiko Rendah"),
	R_0102020301020000 ("0102020301020000", "ii) Pengguna WNA yang Berisiko Rendah"),
	R_0102020302000000 ("0102020302000000", "b) Pengguna Korporasi yang Berisiko Rendah"),
	R_0102020302010000 ("0102020302010000", "i) Pengguna Korporasi Domestik (Dalam Negeri) yang Berisiko Rendah"),
	R_0102020302020000 ("0102020302020000", "ii) Pengguna Korporasi Asing yang Berisiko Rendah"),
//	R_0103000000000000 ("0103000000000000", "III. Produk Jasa"),
	R_0103010000000000 ("0103010000000000", "A.Pinjaman Multiguna (konsumtif)"),
	R_0103010100000000 ("0103010100000000", "1) Borrower Orang Perseorangan WNI"),
	R_0103010200000000 ("0103010200000000", "2) Borrower Koporasi Domestik (Dalam Negeri)"),
	R_0103020000000000 ("0103020000000000", "B.Pinjaman Produktif"),
	R_0103020100000000 ("0103020100000000", "1) Pertanian, Perburuan dan Kehutanan"),
	R_0103020101000000 ("0103020101000000", "a) Borrower Orang Perseorangan WNI"),
	R_0103020102000000 ("0103020102000000", "b) Borrower Koporasi Domestik (Dalam Negeri)"),
	R_0103020200000000 ("0103020200000000", "2) Perdagangan Besar dan Eceran"),
	R_0103020201000000 ("0103020201000000", "a) Borrower Orang Perseorangan WNI"),
	R_0103020202000000 ("0103020202000000", "b) Borrower Koporasi Domestik (Dalam Negeri)"),
	R_0103020300000000 ("0103020300000000", "3) Transportasi, Pergudangan, dan Komunikasi"),
	R_0103020301000000 ("0103020301000000", "a) Borrower Orang Perseorangan WNI"),
	R_0103020302000000 ("0103020302000000", "b) Borrower Koporasi Domestik (Dalam Negeri)"),
	R_0103020400000000 ("0103020400000000", "4) Jasa Pendidikan"),
	R_0103020401000000 ("0103020401000000", "a) Borrower Orang Perseorangan WNI"),
	R_0103020402000000 ("0103020402000000", "b) Borrower Koporasi Domestik (Dalam Negeri)"),
	R_0103020500000000 ("0103020500000000", "5) Pinjaman Produktif Lainnya"),
	R_0103020501000000 ("0103020501000000", "a) Perikanan"),
	R_0103020501010000 ("0103020501010000", "i) Borrower Orang Perseorangan WNI"),
	R_0103020501020000 ("0103020501020000", "ii) Borrower Korporasi (Dalam Negeri)"),
	R_0103020502000000 ("0103020502000000", "b) Listrik, Gas dan Air"),
	R_0103020502010000 ("0103020502010000", "i) Borrower Orang Perseorangan WNI"),
	R_0103020502020000 ("0103020502020000", "ii) Borrower Korporasi (Dalam Negeri)"),
	R_0103020503000000 ("0103020503000000", "c) Lainnya"),
	R_0103020503010000 ("0103020503010000", "i) Borrower Orang Perseorangan WNI"),
	R_0103020503020000 ("0103020503020000", "ii) Borrower Korporasi (Dalam Negeri)"),
//	R_0104000000000000 ("0104000000000000", "IV. Penyaluran Pinjaman dan Pengembalian Pinjaman"),
	R_0104010000000000 ("0104010000000000", "A.Penyaluran Pinjaman oleh Lender"),
	R_0104010100000000 ("0104010100000000", "I Penyaluran Pinjaman oleh Lender melalui Tatap Muka kepada Petugas/Karyawan Lapangan"),
	R_0104010101000000 ("0104010101000000", "1) Lender Orang Perseroangan"),
	R_0104010102000000 ("0104010102000000", "2) Lender Korporasi"),
	R_0104010200000000 ("0104010200000000", "II Tidak Tatap Muka"),
	R_0104010201000000 ("0104010201000000", "1) Penyaluran Pinjaman oleh Lender melalui Virtual Account Bank"),
	R_0104010201010000 ("0104010201010000", "a) Lender Orang Perseroangan"),
	R_0104010201020000 ("0104010201020000", "b) Lender Korporasi"),
	R_0104010202000000 ("0104010202000000", "2) Penyaluran Pinjaman melalui Autodebet Rekening Bank"),
	R_0104010202010000 ("0104010202010000", "a) Lender Orang Perseroangan"),
	R_0104010202020000 ("0104010202020000", "b) Lender Korporasi"),
	R_0104020000000000 ("0104020000000000", "B.Penyaluran Pinjaman kepada Borrower"),
	R_0104020100000000 ("0104020100000000", "I Penyaluran Pinjaman kepada Borrower melalui Tatap Muka oleh Petugas/Karyawan Lapangan"),
	R_0104020101000000 ("0104020101000000", "1) Borrower Orang Perseroangan"),
	R_0104020102000000 ("0104020102000000", "2) Borrower Korporasi"),
	R_0104020200000000 ("0104020200000000", "II Penyaluran Pinjaman oleh Lender secara Tidak Tatap Muka melalui Virtual Account Bank"),
	R_0104020201000000 ("0104020201000000", "1) Borrower Orang Perseroangan"),
	R_0104020202000000 ("0104020202000000", "2) Borrower Korporasi"),
	R_0104030000000000 ("0104030000000000", "C.Pengembalian Pinjaman oleh Borrower"),
	R_0104030100000000 ("0104030100000000", "I Pengembalian Pinjaman oleh Borrower melalui Tatap Muka kepada Petugas/Karyawan Lapangan"),
	R_0104030101000000 ("0104030101000000", "1) Borrower Orang Perseroangan"),
	R_0104030102000000 ("0104030102000000", "2) Borrower Korporasi"),
	R_0104030200000000 ("0104030200000000", "II Tidak Tatap Muka"),
	R_0104030201000000 ("0104030201000000", "1) Pengembalian Pinjaman oleh Borrower melalui Virtual Account Bank"),
	R_0104030201010000 ("0104030201010000", "a) Borrower Orang Perseroangan"),
	R_0104030201020000 ("0104030201020000", "b) Borrower Korporasi"),
	R_0104030202000000 ("0104030202000000", "2) Pengembalian Pinjaman melalui Autodebet Rekening Bank"),
	R_0104030202010000 ("0104030202010000", "a) Borrower Orang Perseroangan"),
	R_0104030202020000 ("0104030202020000", "b) Borrower Korporasi"),
	R_0104030203000000 ("0104030203000000", "3) Pembayaran melalui Agen (Misalnya melalui minimarket, kantor pos, dll)"),
	R_0104030204000000 ("0104030204000000", "4) Pembayaran melalui Cara Tidak Tatap Muka Lainnya:"),
	R_0104030204010000 ("0104030204010000", "a) virtual account"),
	R_0104030204020000 ("0104030204020000", "b) Aplikasi web (tokopedia/ovo/link aja dll)"),
	R_0104030204030000 ("0104030204030000", "c) Lainnya"),
//	R_0104040000000000 ("0104040000000000", "D.Pengembalian Pinjaman kepada Lender"),
	R_0104040100000000 ("0104040100000000", "I Pengembalian Pinjaman kepada Lender melalui Tatap Muka oleh Petugas/Karyawan Lapangan"),
	R_0104040101000000 ("0104040101000000", "1) Lender Orang Perseroangan"),
	R_0104040102000000 ("0104040102000000", "2) Lender Korporasi"),
	R_0104040200000000 ("0104040200000000", "II Pengembalian Pinjaman kepada Lender melalui Tidak Tatap Muka melalui Virtual Account Bank"),
	R_0104040201000000 ("0104040201000000", "1) Lender Orang Perseroangan"),
	R_0104040202000000 ("0104040202000000", "2) Lender Korporasi"),
	;

	private String key;
	private String value;
	private static final String FIELDS = "2|3";
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER5000PosApuFins01 eEnum : ER5000PosApuFins01.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER5000PosApuFins01.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER5000PosApuFins01.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(FIELDS, getObjects());
	}

	public static SegmentValidation genRowValidation002() {
		int[] rows = new int[] { 1, 4 };
		return genPlusValidation(R_0101010100000000, rows);
	}

	public static SegmentValidation genRowValidation003() {
		int[] rows = new int[] { 2, 3 };
		return genPlusValidation(R_0101010101000000, rows);
	}

	public static SegmentValidation genRowValidation006() {
		int[] rows = new int[] { 5, 6 };
		return genPlusValidation(R_0101010102000000, rows);
	}

	public static SegmentValidation genRowValidation009() {
		int[] rows = new int[] { 8, 9 };
		return genPlusValidation(R_0101010200000000, rows);
	}

	public static SegmentValidation genRowValidation012() {
		int[] rows = new int[] { 11, 12, 13 };
		return genPlusValidation(R_0101020101000000, rows);
	}

	public static SegmentValidation genRowValidation016() {
		int[] rows = new int[] { 15, 18 };
		return genPlusValidation(R_0101020102000000, rows);
	}

	public static SegmentValidation genRowValidation017() {
		int[] rows = new int[] { 16, 17 };
		return genPlusValidation(R_0101020102010000, rows);
	}

	public static SegmentValidation genRowValidation020() {
		int[] rows = new int[] { 19, 20 };
		return genPlusValidation(R_0101020102020000, rows);
	}

	public static SegmentValidation genRowValidation023() {
		int[] rows = new int[] { 22, 23 };
		return genPlusValidation(R_0101020201000000, rows);
	}

	public static SegmentValidation genRowValidation026() {
		int[] rows = new int[] { 25, 26 };
		return genPlusValidation(R_0101020202000000, rows);
	}

	public static SegmentValidation genRowValidation029() {
		int[] rows = new int[] { 28, 29 };
		return genPlusValidation(R_0101020301000000, rows);
	}

	public static SegmentValidation genRowValidation032() {
		int[] rows = new int[] { 31, 32 };
		return genPlusValidation(R_0101020302000000, rows);
	}

	public static SegmentValidation genRowValidation035() {
		int[] rows = new int[] { 34, 37 };
		return genPlusValidation(R_0102010100000000, rows);
	}

	public static SegmentValidation genRowValidation036() {
		int[] rows = new int[] { 35, 36 };
		return genPlusValidation(R_0102010101000000, rows);
	}

	public static SegmentValidation genRowValidation039() {
		int[] rows = new int[] { 38, 39 };
		return genPlusValidation(R_0102010102000000, rows);
	}

	public static SegmentValidation genRowValidation042() {
		int[] rows = new int[] { 41, 42 };
		return genPlusValidation(R_0102010200000000, rows);
	}

	public static SegmentValidation genRowValidation045() {
		int[] rows = new int[] { 44, 48 };
		return genPlusValidation(R_0102020100000000, rows);
	}

	public static SegmentValidation genRowValidation046() {
		int[] rows = new int[] { 45, 46, 47 };
		return genPlusValidation(R_0102020101000000, rows);
	}

	public static SegmentValidation genRowValidation050() {
		int[] rows = new int[] { 49, 52 };
		return genPlusValidation(R_0102020102000000, rows);
	}

	public static SegmentValidation genRowValidation051() {
		int[] rows = new int[] { 50, 51 };
		return genPlusValidation(R_0102020102010000, rows);
	}

	public static SegmentValidation genRowValidation054() {
		int[] rows = new int[] { 53, 54 };
		return genPlusValidation(R_0102020102020000, rows);
	}

	public static SegmentValidation genRowValidation057() {
		int[] rows = new int[] { 56, 59 };
		return genPlusValidation(R_0102020200000000, rows);
	}

	public static SegmentValidation genRowValidation058() {
		int[] rows = new int[] { 57, 58 };
		return genPlusValidation(R_0102020201000000, rows);
	}

	public static SegmentValidation genRowValidation061() {
		int[] rows = new int[] { 60, 61 };
		return genPlusValidation(R_0102020202000000, rows);
	}

	public static SegmentValidation genRowValidation064() {
		int[] rows = new int[] { 63, 66 };
		return genPlusValidation(R_0102020300000000, rows);
	}

	public static SegmentValidation genRowValidation065() {
		int[] rows = new int[] { 64, 65 };
		return genPlusValidation(R_0102020301000000, rows);
	}

	public static SegmentValidation genRowValidation068() {
		int[] rows = new int[] { 67, 68 };
		return genPlusValidation(R_0102020302000000, rows);
	}

	public static SegmentValidation genRowValidation071() {
		int[] rows = new int[] { 70, 71 };
		return genPlusValidation(R_0103010000000000, rows);
	}

	public static SegmentValidation genRowValidation074() {
		int[] rows = new int[] { 73, 76, 79, 82, 85 };
		return genPlusValidation(R_0103020000000000, rows);
	}

	public static SegmentValidation genRowValidation075() {
		int[] rows = new int[] { 74, 75 };
		return genPlusValidation(R_0103020100000000, rows);
	}

	public static SegmentValidation genRowValidation078() {
		int[] rows = new int[] { 77, 78 };
		return genPlusValidation(R_0103020200000000, rows);
	}

	public static SegmentValidation genRowValidation081() {
		int[] rows = new int[] { 80, 81 };
		return genPlusValidation(R_0103020300000000, rows);
	}

	public static SegmentValidation genRowValidation084() {
		int[] rows = new int[] { 83, 84 };
		return genPlusValidation(R_0103020400000000, rows);
	}

	public static SegmentValidation genRowValidation087() {
		int[] rows = new int[] { 86, 89, 92 };
		return genPlusValidation(R_0103020500000000, rows);
	}

	public static SegmentValidation genRowValidation088() {
		int[] rows = new int[] { 87, 88 };
		return genPlusValidation(R_0103020501000000, rows);
	}

	public static SegmentValidation genRowValidation091() {
		int[] rows = new int[] { 90, 91 };
		return genPlusValidation(R_0103020502000000, rows);
	}

	public static SegmentValidation genRowValidation094() {
		int[] rows = new int[] { 93, 94 };
		return genPlusValidation(R_0103020503000000, rows);
	}

	public static SegmentValidation genRowValidation097() {
		int[] rows = new int[] { 96, 99 };
		return genPlusValidation(R_0104010000000000, rows);
	}

	public static SegmentValidation genRowValidation098() {
		int[] rows = new int[] { 97, 98 };
		return genPlusValidation(R_0104010100000000, rows);
	}

	public static SegmentValidation genRowValidation101() {
		int[] rows = new int[] { 100, 103 };
		return genPlusValidation(R_0104010200000000, rows);
	}

	public static SegmentValidation genRowValidation102() {
		int[] rows = new int[] { 101, 102 };
		return genPlusValidation(R_0104010201000000, rows);
	}

	public static SegmentValidation genRowValidation105() {
		int[] rows = new int[] { 104, 105 };
		return genPlusValidation(R_0104010202000000, rows);
	}

	public static SegmentValidation genRowValidation108() {
		int[] rows = new int[] { 107, 110 };
		return genPlusValidation(R_0104020000000000, rows);
	}

	public static SegmentValidation genRowValidation109() {
		int[] rows = new int[] { 108, 109 };
		return genPlusValidation(R_0104020100000000, rows);
	}

	public static SegmentValidation genRowValidation112() {
		int[] rows = new int[] { 111, 112 };
		return genPlusValidation(R_0104020200000000, rows);
	}

	public static SegmentValidation genRowValidation115() {
		int[] rows = new int[] { 114, 117 };
		return genPlusValidation(R_0104030000000000, rows);
	}

	public static SegmentValidation genRowValidation116() {
		int[] rows = new int[] { 115, 116 };
		return genPlusValidation(R_0104030100000000, rows);
	}

	public static SegmentValidation genRowValidation119() {
		int[] rows = new int[] { 118, 121, 124, 125 };
		return genPlusValidation(R_0104030200000000, rows);
	}

	public static SegmentValidation genRowValidation122() {
		int[] rows = new int[] { 119, 120 };
		return genPlusValidation(R_0104030201000000, rows);
	}

	public static SegmentValidation genRowValidation123() {
		int[] rows = new int[] { 122, 123 };
		return genPlusValidation(R_0104030202000000, rows);
	}

	public static SegmentValidation genRowValidation127() {
		int[] rows = new int[] { 126, 127, 128 };
		return genPlusValidation(R_0104030204000000, rows);
	}

	public static SegmentValidation genRowValidation131() {
		int[] rows = new int[] { 130, 131 };
		return genPlusValidation(R_0104040100000000, rows);
	}

	public static SegmentValidation genRowValidation134() {
		int[] rows = new int[] { 133, 134 };
		return genPlusValidation(R_0104040200000000, rows);
	}
	
	private static SegmentValidation genPlusValidation(ER5000PosApuFins01 eEnum, int[] rows) {
		return UtilSegmentValidation.genEqualsFormula(FIELDS, eEnum.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(eEnum.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
}
