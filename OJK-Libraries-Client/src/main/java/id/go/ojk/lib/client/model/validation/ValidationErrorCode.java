package id.go.ojk.lib.client.model.validation;

import java.util.LinkedHashMap;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import lombok.Getter;
import lombok.Setter;

@XStreamAlias("validationErrorCode")
public class ValidationErrorCode {

	public static final Map<String, ValidationErrorCode> validationErrorCodeMap = new LinkedHashMap<>();

	//Type Error
	//-Digunakan @RBB
	public static final ValidationErrorCode E11_00_FORMAT 				= bvec("11",	"00",	"Format",							"format data yang diperbolehkan adalah %1$s");
	public static final ValidationErrorCode E11_01_MIN_LENGTH 			= bvec("11",	"01",	"Panjang Minimum",					"panjang minimum %1$s");
	public static final ValidationErrorCode E11_02_MAX_LENGTH 			= bvec("11",	"02",	"Panjang Maksimum",					"panjang maksimum %1$s");	
	public static final ValidationErrorCode E11_06_EQUAL 				= bvec("11",	"06",	"Sama Dengan",						"nilai harus sama dengan %2$s");
	public static final ValidationErrorCode E11_07_EQUAL 				= bvec("11",	"07",	"Sama Dengan",						"nilai harus sama dengan %1$s");
	public static final ValidationErrorCode E11_08_NOT_EQUAL 			= bvec("11",	"08",	"Tidak Sama Dengan",				"nilai harus selain %1$s");
	public static final ValidationErrorCode E11_09_LESS_EQUAL 			= bvec("11",	"09",	"Kurang dari atau Sama Dengan",		"nilai harus kurang dari atau sama dengan %1$s");
	public static final ValidationErrorCode E11_10_NOT_ZERO 			= bvec("11",	"10",	"Tidak sama dengan nol",			"kolom %1$s hanya boleh satu yang tidak nol");
	public static final ValidationErrorCode E11_11_GREATER_EQUAL 		= bvec("11",	"11",	"Lebih dari atau Sama Dengan",		"nilai harus lebih dari atau sama dengan %1$s");
	public static final ValidationErrorCode E11_12_LESS_EQUAL 			= bvec("11",	"12",	"Kurang dari atau Sama Dengan",		"nilai %1$s harus kurang dari atau sama dengan %2$s");
	public static final ValidationErrorCode E11_13_GREATER 				= bvec("11",	"13",	"Lebih dari",						"nilai harus lebih dari %1$s");
	
	//-Tidak digunakan
	public static final ValidationErrorCode E11_03_FIX_LENGTH 			= bvec("11",	"03",	"Panjang fix",						"panjang harus %1$s");
	public static final ValidationErrorCode E11_04_NUMBER 				= bvec("11",	"04",	"Number",							"nilai harus angka. %1$s");
	public static final ValidationErrorCode E11_05_DECIMAL 				= bvec("11",	"05",	"desimal",							"nilai harus angka desimal. %1$s");
	
	//Domain Error
	//-Digunakan @RBB
	public static final ValidationErrorCode E12_01_REFERENCE 			= bvec("12",	"01",	"Referensi",						"tidak ditemukan pada Referensi '%1$s'");
	
	//-Tidak digunakan
	public static final ValidationErrorCode E12_00_REFERENCE 			= bvec("12",	"00",	"Table Referensi tidak ditemukan",	"tabel referensi no %1$s tidak ditemukan");	
	public static final ValidationErrorCode E12_02_REFERENCE 			= bvec("12",	"02",	"Referensi 2",						"%1$s");
	public static final ValidationErrorCode E12_03_DATE 				= bvec("12",	"03",	"Tanggal",							"format tanggal yyyyMMdd");
	public static final ValidationErrorCode E12_04_ALL_DATE_MIN 		= bvec("12",	"04",	"Tanggal minimum (global)",			"semua tanggal minimum %1$s");
	public static final ValidationErrorCode E12_05_ALL_DATE_MAX 		= bvec("12",	"05",	"Tanggal maksimum (global)",		"semua tanggal maksimum %1$s");
	public static final ValidationErrorCode E12_06_DATE_MIN 			= bvec("12",	"06",	"Tanggal minimum",					"tanggal minimum %1$s");
	public static final ValidationErrorCode E12_07_DATE_MAX 			= bvec("12",	"07",	"Tanggal maksimum",					"tanggal maksimum %1$s");	
	public static final ValidationErrorCode E12_08_MIN_VALUE 			= bvec("12",	"08",	"Nilai minimum",					"nilai harus %1$s %2$s");
	public static final ValidationErrorCode E12_09_MAX_VALUE 			= bvec("12",	"09",	"Nilai maximum",					"nilai harus %1$s %2$s");
	public static final ValidationErrorCode E12_10_YEARMONTH 			= bvec("12",	"10",	"Bulan Tahun",						"format harus yyyyMM");
	public static final ValidationErrorCode E12_11_YEARMONTH_MIN 		= bvec("12",	"11",	"Min Bulan Tahun",					"minimum %1$s");
	public static final ValidationErrorCode E12_12_YEARMONTH_MAX 		= bvec("12",	"12",	"MaxBulan Tahun",					"maksimum %1$s");
	public static final ValidationErrorCode E12_13_YEAR		 			= bvec("12",	"13",	"Tahun",							"format harus yyyy");
	public static final ValidationErrorCode E12_14_YEAR_MIN 			= bvec("12",	"14",	"Min Tahun",						"minimum tahun %1$s");
	public static final ValidationErrorCode E12_15_YEAR_MAX 			= bvec("12",	"15",	"Max Tahun",						"maksimum tahun %1$s");
	public static final ValidationErrorCode E12_16_DATE_GREATER_EQUALS 	= bvec("12",	"16",	"Tanggal sesudah lebih atau sama dengan",		"tanggal kolom %1$s harus >= kolom %2$s");
	public static final ValidationErrorCode E12_17_DATE_LESS		 	= bvec("12",	"17",	"Tanggal sebelum",					"tanggal kolom %1$s harus < kolom %2$s");
	public static final ValidationErrorCode E12_18_DATE_LESS_EQUALS		= bvec("12",	"18",	"Tanggal sebelum",					"tanggal kolom %1$s harus <= kolom %2$s");
	public static final ValidationErrorCode E12_19_VALUE_BETWEEN 		= bvec("12",	"19",	"Nilai antara",						"nilai harus antara %1$s dan %2$s");
	public static final ValidationErrorCode E12_20_DATE_GREATER			= bvec("12",	"20",	"Tanggal sesudah",			"tanggal kolom %1$s harus > kolom %2$s");
  public static final ValidationErrorCode E12_21_ALL_DATE_MIN_MAX = bvec("12",  "21", "Tanggal minimum dan maksimum (global)",    "semua tanggal minimum %1$s dan maksimum %2$s");
	
	//Not Null Error
	//-Digunakan @RBB
	public static final ValidationErrorCode E13_00_MANDATORY 			= bvec("13",	"00",	"Harus Diisi",						"harus diisi");
	public static final ValidationErrorCode E13_01_MUSTEMPTY 			= bvec("13",	"01",	"Harus Kosong",						"harus kosong (pastikan tidak ada spasi/tab)");

	//-Tidak digunakan
	public static final ValidationErrorCode E13_10_SUM_MANDATORY 		= bvec("13",	"10",	"Summary Wajib diisi",				"harus diisi, %1$s");
	public static final ValidationErrorCode E13_11_SUM_MUSTEMPTY 		= bvec("13",	"11",	"Summary Harus Kosong",				"harus kosong, %1$s");
	public static final ValidationErrorCode E13_12_SUM_MUSTEMPTY_FACI 	= bvec("13",	"12",	"Summary Tunggakan Harus Kosong",	"harus kosong untuk fasilitas %1$s");

	//Duplication Error
	//-Digunakan @RBB
	public static final ValidationErrorCode E14_00_UNIQUE 					= bvec("14",	"00",	"Unik",							"harus unik");
	public static final ValidationErrorCode E14_01_UNIQUE_COMBINE 			= bvec("14",	"01",	"Unik Kombinasi",				"%1$s harus unik");
	public static final ValidationErrorCode E14_02_UNIQUE_POS_NOT_COMBINE	= bvec("14",	"02",	"Unik Pos Tidak Kombinasi",		"kode Komponen/Baris '%1$s' harus unik");
	public static final ValidationErrorCode E14_03_UNIQUE 					= bvec("14",	"03",	"Unik",							"harus unik karena %1$s");
	public static final ValidationErrorCode E14_04_SEGMENT_VALUE_UNIQUE 	= bvec("14",	"04",	"Nila Kode baris Unik",			"%1$s harus unik di kode baris %2$s");

	//Reuse Error
	//-Tidak digunakan
	public static final ValidationErrorCode E15_00_FIELD_UNIQUE 				= bvec("15",	"00",	"Field Unik",				"'%1$s' sudah dipakai di kolom lain");

	//Logical Error Between Columns
	//-Digunakan @RBB
	public static final ValidationErrorCode E20_01_MANDATORY 			= bvec("20",	"01",	"Conditional Harus Diisi",			"harus diisi jika %1$s");
	public static final ValidationErrorCode E20_02_MUSTEMPTY 			= bvec("20",	"02",	"Conditional Harus Kosong",			"harus kosong %1$s (pastikan tidak ada spasi/tab)");
	
	//-Tidak digunakan
	public static final ValidationErrorCode E20_00_GENERAL 				= bvec("20",	"00",	"Validasi antar kolom",				"validasi antar kolom");
	public static final ValidationErrorCode E20_03_DATE_MATRIX 			= bvec("20",	"03",	"Date matrix",						"nilai harus \"%1$s %2$s %3$s\"");
	public static final ValidationErrorCode E20_04_CONTRACT_DATE 		= bvec("20",	"04",	"Tanggal Kontrak",					"%1$s");	
	public static final ValidationErrorCode E20_05_AMOUNT_BASE_CONDITION = bvec("20",	"05",	"Amount base Condition",			"nilai field %1$s harus sama dengan %2$s, karena kode kondisi '%3$s' dengan kategori kondisi 'DEBITUR TIDAK MEMILIKI KEWAJIBAN'");
	public static final ValidationErrorCode E20_06_COLLECTIBILITY 		= bvec("20",	"06",	"Kolektibilitas",					"nilai field %1$s harus sama dengan %2$s, karena kode kondisi '%3$s' dengan kategori kondisi 'DEBITUR TIDAK MEMILIKI KEWAJIBAN'");
	public static final ValidationErrorCode E20_08_NEW_RENEWAL			= bvec("20",	"08",	"Baru/Perpanjangan",				"harus > 0, karena %1$s");
	public static final ValidationErrorCode E20_09_DATE_MATRIX_REASON 	= bvec("20",	"09",	"Date matrix with reason",			"%1$s harus %2$s %3$s karena %4$s");
	public static final ValidationErrorCode E20_11_OVERDUE 				= bvec("20",	"11",	"Validasi Overdue 1",				"%1$s harus = 0, karena kategori kondisi 'DEBITUR TIDAK MEMILIKI KEWAJIBAN");
	public static final ValidationErrorCode E20_12_OVERDUE 				= bvec("20",	"12",	"Validasi Overdue 2",				"%1$s harus = 0, karena TUNGGAKAN POKOK=0 dan TUNGGAKAN BUNGA=0");
	public static final ValidationErrorCode E20_13_OVERDUE 				= bvec("20",	"13",	"Validasi Overdue 3",				"%1$s harus = 0, karena TUNGGAKAN=0");
	public static final ValidationErrorCode E20_14_OVERDUE 				= bvec("20",	"14",	"Validasi Overdue 4",				"%1$s harus > 0, karena TUNGGAKAN POKOK>0 atau TUNGGAKAN BUNGA>0");
	public static final ValidationErrorCode E20_17_OVERDUE 				= bvec("20",	"17",	"Validasi Overdue 4",				"%1$s harus > 0, karena TUNGGAKAN>0");
	public static final ValidationErrorCode E20_15_RESTRUCTURE_FREQ 	= bvec("20",	"15",	"Frequency restrukturisasi 1",		"%1$s harus > 0, Sifat Kredit Adalah Kredit yang direstrukturisasi.");
	public static final ValidationErrorCode E20_16_RESTRUCTURE_FREQ 	= bvec("20",	"16",	"Frequency restrukturisasi 2",		"%1$s harus = 0, Sifat Kredit Adalah Kredit lainnya.");
	public static final ValidationErrorCode E20_21_ORI_CURRENCY 		= bvec("20",	"21",	"Original Currency 1",				"Harus > 0, karena %1$s");
	public static final ValidationErrorCode E20_22_ORI_CURRENCY 		= bvec("20",	"22",	"Original Currency 2",				"Harus = 0, karena %1$s");
	public static final ValidationErrorCode E20_25_FIN_RPT_SUM 			= bvec("20",	"25",	"Financial Report Sum",				"%1$s");
	public static final ValidationErrorCode E20_26_FIN_RPT_REVENUE		= bvec("20",	"26",	"Financial Report Revenue",			"(Pendapatan Usaha/Operasional - Beban Pokok Pendapatan/Beban Operasional) harus sama dengan Laba/Rugi Bruto");
	public static final ValidationErrorCode E20_27_FIN_RPT_PROFITBEFORETAX	= bvec("20",	"27",	"Financial Report profitBeforeTax",	"(Laba/Rugi Bruto + Pendapatan Lain-lain/Non Operasional) - Beban Lain-lain/Non Operasional harus sama dengan Laba/Rugi sebelum pajak");
	public static final ValidationErrorCode E20_30_EST_DATE 			= bvec("20",	"30",	"Establisment Date",				"%1$s harus sama dengan %2$s, karena %3$s = %4$s");
	public static final ValidationErrorCode E20_35_CANCELED_CONDITION	= bvec("20",	"35",	"Canceled Condition",				"kode kondisi %1$s operasi data tidak boleh C");
	
	//Logical Error Between Columns
	//-Tidak digunakan
	public static final ValidationErrorCode E40_00_RELATION 			= bvec("40",	"00",	"Relasi",							"tidak ditemukan relasi ke %1$s");
	public static final ValidationErrorCode E40_01_RELATION_MULTI 		= bvec("40",	"01",	"Relasi Multi",						"relasi tidak valid, %1$s");
	public static final ValidationErrorCode E40_02_SUMMARY_REQUIRED 	= bvec("40",	"02",	"Summary wajib ada",				"summary untuk fasilitas %1$s, cif %2$s, nomor rekening %3$s wajib ada");
	public static final ValidationErrorCode E40_03_PARIPASU_UNIQUE 		= bvec("40",	"03",	"Paripasu unik",					"Harus unik karena bukan paripasu!");
	public static final ValidationErrorCode E40_04_MUST_PARIPASU 		= bvec("40",	"04",	"Harus paripasu",					"KODE REGISTER AGUNAN %1$s Harus paripasu karena digunakan lebih dari 1 kali!");
	public static final ValidationErrorCode E40_05_COLL_JOIN_CRE_1 		= bvec("40",	"05",	"Coll Joined Credit 1",				"Nomor Rekening untuk KODE REGISTER AGUNAN %1$s tidak ditemukan di Kredit Join!");
	public static final ValidationErrorCode E40_06_COLL_JOIN_CRE_2 		= bvec("40",	"06",	"Coll Joined Credit 2",				"STATUS KREDIT JOIN ACCOUNT harus Y karena Nomor Rekening terdaftar di Fasilitas Kredit Join!");
	//public static final ValidationErrorCode E40_07_COLL_JOIN_CRE_3 		= bvec("40",	"07",	"Coll Joined Credit 3",				"KODE REGISTER AGUNAN %1$s harus menjadi agunan Credit join CIF %2$s!");
	public static final ValidationErrorCode E40_07_COLL_MUST_EXIST 		= bvec("40",	"07",	"Coll Joined Must Exist",			"Harus ada agunan KODE REGISTER AGUNAN %1$s, No. Rekening %2$s, CIF %3$s karena terdaftar di Kredit Join");
	public static final ValidationErrorCode E40_08_COLL_MUST_EQUAL 		= bvec("40",	"08",	"Coll must equal",					"Detail data untuk KODE REGISTER AGUNAN %1$s muncul lebih dari satu kali, informasi harus sama");
	public static final ValidationErrorCode E40_09_GUA_MUST_EQUAL 		= bvec("40",	"09",	"Gua must equal",					"Detail data untuk No Identitas %1$s muncul lebih dari satu kali, informasi harus sama");
	public static final ValidationErrorCode E40_12_GUA_MUST_EXIST 		= bvec("40",	"12",	"Gua must exist",					"Harus ada penjamin No Identitas Penjamin %1$s, No. Rekening %2$s, CIF %3$s karena terdaftar di Kredit Join");
	public static final ValidationErrorCode E40_10_CREDIT_JOIN_1 		= bvec("40",	"10",	"Kredit Join 1",					"Kredit join no rekening %1$s harus terhubung ke lebih dari 1 CIF");
	public static final ValidationErrorCode E40_11_CREDIT_JOIN_2 		= bvec("40",	"11",	"Kredit Join 2",					"Sequence debitur tidak urut");
	public static final ValidationErrorCode E40_22_CREDIT_JOIN_MUST_EQUAL= bvec("40",	"22",	"Kredit Join Must Equal",			"Detail data kredit join No Rekening %1$s harus sama");
	public static final ValidationErrorCode E40_13_MAN_MUST_EQUAL 		= bvec("40",	"13",	"Man must equal",					"Detail data untuk NOMOR IDENTITAS %1$s muncul lebih dari satu kali, informasi harus sama");
	public static final ValidationErrorCode E40_14_MAN_SHARE_MUST_100 	= bvec("40",	"14",	"Man share harus 100%",				"Jumlah pangsa kepemilikan untuk CIF %1$s harus 100 persen. Jumlah saat ini %2$s");
	public static final ValidationErrorCode E40_15_MUST_NOT_PARIPASU 	= bvec("40",	"15",	"Harus bukan paripasu",				"KODE REGISTER AGUNAN %1$s Harus bukan paripasu karena digunakan 1 kali!");
	public static final ValidationErrorCode E40_20_FAC_MUST_EXIST 		= bvec("40",	"20",	"Fac Must Exist",					"Nomor CIF %1$s tidak memiliki fasilitas");
	public static final ValidationErrorCode E40_21_MAN_MUST_EXIST 		= bvec("40",	"21",	"Management Must Exist",			"Nomor CIF %1$s tidak memiliki data Pengurus/Pemilik");
	public static final ValidationErrorCode E40_25_COL_GUA_MUST_DELETE 	= bvec("40",	"25",	"Col Gua Must Delete",				"harus D karena fasilitas kondisi closed");
	public static final ValidationErrorCode E40_26_COL_GUA_MUST_NOTSEND = bvec("40",	"26",	"Col Gua Must Not Submit",			"%1$s tidak tidak boleh dikirim karena fasilitas operasi C dan kondisi closed");
	public static final ValidationErrorCode E40_30_D01C_F_MUST_C 		= bvec("40",	"30",	"D01 C F must C",					"Debtor operasi C, %1$s juga harus C");
	public static final ValidationErrorCode E40_31_D02C_M_MUST_C 		= bvec("40",	"31",	"D02 C M must C",					"Debtor Badan Usaha operasi C, pengurus/pemilik juga harus C");
	public static final ValidationErrorCode E40_32_FC_AP_MUST_C 		= bvec("40",	"32",	"F C A dan P must C",				"Fasilitas operasi C, %1$s juga harus C");
	public static final ValidationErrorCode E40_33_FC_F_MUST_C 			= bvec("40",	"33",	"F C Fin must C",					"Fasilitas operasi C, laporan keuangan juga harus C");

	//Value
	//-Digunakan @RBB
	public static final ValidationErrorCode E50_01_PERCENT				= bvec("50", 	"01", 	"Percent", 							"nilai persentase tidak sesuai");
	public static final ValidationErrorCode E50_02_FORMULA 				= bvec("50",	"02",	"Kesalahan Formula",				"nilai harus \"%2$s\"");
	public static final ValidationErrorCode E50_03_POS_MUST_EXIST		= bvec("50",	"03",	"Pos Must Exist",					"Kode Komponen/Baris '%2$s' tidak ditemukan");	
    public static final ValidationErrorCode E50_06_PERCENT_OPTION_TRUE	= bvec("50",	"06",	"Percent True",						"nilai harus angka desimal dengan 2 angka di belakang . (titik). Contoh: 10.00");
    public static final ValidationErrorCode E50_07_PERCENT_OPTION_FALSE	= bvec("50",	"07",	"Percent False",					"nilai tidak boleh angka desimal");
    public static final ValidationErrorCode E50_08_DIFF_VALUE 			= bvec("50",	"08",	"Selisih Nilai",					"nilai selisih '%2$s' tidak sesuai");
    
    //-Digunakan @LBBPRK
	public static final ValidationErrorCode E50_09_TOTAL_PERCENT		= bvec("50", 	"09", 	"Total Percent", 					"nilai total penjumlahan Kolom '%1$s' harus %2$s");
	public static final ValidationErrorCode E50_10_FORMULA2 			= bvec("50",	"10",	"Kesalahan Formula 2",				"nilai harus \"%1$s\"");
	public static final ValidationErrorCode E50_11_OFFICE_CODE 			= bvec("50",	"11",	"Kantor Cabang",					"Sandi Kantor '%1$s' tidak terdaftar pada Form Daftar Rincian Kantor");
	public static final ValidationErrorCode E50_12_POS_NOT_EXIST		= bvec("50",	"12",	"Pos tidak ditemukan",				"Sandi Kantor '%1$s' dengan Sandi Pos '%2$s' tidak ditemukan");
	public static final ValidationErrorCode E50_13_SANDI_GABUNGAN		= bvec("50",	"13",	"Validasi sandi gabungan",			"nilai harus \"Pos Sandi Kantor Gabungan = seluruh nilai akumulasi Kantor Pusat dan Cabang pada pos yang sama\"");
	public static final ValidationErrorCode E50_14_OFFICE_CODE_00		= bvec("50",	"14",	"Kantor Cabang",					"Sandi Kantor '%1$s' hanya digunakan untuk Form Laporan Posisi Keuangan, Rekening Administratif, dan Laporan Laba Rugi");
	public static final ValidationErrorCode E50_15_COLUMNCONDITION		= bvec("50",	"15",	"Validasi Kolom Conditional",		"nilai harus %1$s karena Kolom '%2$s' bernilai %3$s");
	public static final ValidationErrorCode E50_16_COLUMNCONDITION2		= bvec("50",	"16",	"Validasi Kolom Conditional",		"nilai harus %1$s");
	public static final ValidationErrorCode E50_17_SINGLEPOSITION		= bvec("50",	"17",	"Validasi Posisi Tunggal",			"hanya boleh ada 1 %1$s");
	public static final ValidationErrorCode E50_18_FORMULA3 			= bvec("50",	"18",	"Kesalahan Formula 3",				"nilai harus %1$s");
	public static final ValidationErrorCode E50_19_COLUMNCONDITION		= bvec("50",	"19",	"Validasi Kolom Conditional",		"nilai harus lebih dari %1$s karena Kolom '%2$s' bernilai %3$s");
	public static final ValidationErrorCode E50_20_FORMULA_TOTAL 		= bvec("50",	"20",	"Kesalahan Formula",				"nilai total penjumlahan Kolom '%1$s' harus %2$s");
	public static final ValidationErrorCode E50_21_FORMULA_SUMIF 		= bvec("50",	"21",	"Kesalahan Formula SUMIF",				"nilai harus sama dengan total penjumlahan pada form '%1$s' kolom '%2$s' dengan kriteria '%3$s' pada kolom '%4$s'");
	public static final ValidationErrorCode E50_22_FORMULA_GEOMEAN 		= bvec("50",	"22",	"Kesalahan Formula",				"nilai harus sama dengan total %1$s ^ (1 / total nilai positif dari kolom %2$s - kolom %3$s) pada form %4$s");
	public static final ValidationErrorCode E50_23_FORMULA_MULTICRITERIASUMIF = bvec("50",	"23",	"Kesalahan Formula SUMIF",				"nilai harus sama dengan total penjumlahan pada form '%1$s' kolom '%2$s' dengan kriteria '%3$s' pada kolom %4$s dan '%5$s' pada kolom %6$s");
	public static final ValidationErrorCode E50_24_FORMULA_MULTIFORMSUMIF = bvec("50",	"24",	"Kesalahan Formula SUMIF",				"nilai harus sama dengan total penjumlahan pada '%1$s'");
	public static final ValidationErrorCode E50_25_FORMULA_CONDITION 	= bvec("50",	"25",	"Kesalahan Formula",				"nilai harus diisi '%1$s' karena %2$s");
	public static final ValidationErrorCode E50_26_FORMULA_CONDITIONVALUE = bvec("50",	"25",	"Kesalahan Formula",				"kolom hanya dapat diisi '%1$s'");

    //-Tidak digunakan
    public static final ValidationErrorCode E50_00_OTHER 				= bvec("50",	"00",	"Kesalahan lain",					"Kesalahan %1$s");
    public static final ValidationErrorCode E50_04_DIVIDE_BY_0			= bvec("50",	"04",	"Divide by Zero",					"Penyebut tidak boleh sama dengan 0");
	public static final ValidationErrorCode E50_05_VALUE_NOT_FOUND		= bvec("50",	"05",	"Nilai tidak ditemukan",			"Nilai '%2$s' Tidak Ditemukan");
	public static final ValidationErrorCode E50_06_VALUE_NOT_FOUND		= bvec("50",	"06",	"Nilai tidak ditemukan",			"Nilai '%1$s' Tidak Ditemukan pada form %2$s kolom %3$s");

    
	//Preparation Prosess
	//-Digunakan @RBB
	public static final ValidationErrorCode E01_00_ON_PROCESS			= bvec("01",	"00",	"Proses masih berjalan",			"Proses masih berjalan");
	public static final ValidationErrorCode E01_01_DATA_NOT_READY		= bvec("01",	"01",	"Data belum siap",					"Data belum siap");
	public static final ValidationErrorCode E01_02_DIR_NOT_FOUND		= bvec("01",	"02",	"Direktori tidak ditemukan!",		"Direktori '%1$s' tidak ditemukan!");
	public static final ValidationErrorCode E01_03_NOT_A_DIR			= bvec("01",	"03",	"Bukan direktori!",					"'%1$s' bukan direktori!");
	public static final ValidationErrorCode E01_04_DIR_EMPTY			= bvec("01",	"04",	"Direktori Kosong!",				"Direktori '%1$s' kosong!");
	public static final ValidationErrorCode E01_05_INVALID_FILE			= bvec("01",	"05",	"File tidak valid",					"File tidak valid : %1$s!");
	
	//-Tidak digunakan
	public static final ValidationErrorCode E01_06_SEQUENCE				= bvec("01",	"06",	"file sequence",					"Urutan file pada format %1$s tidak valid. Urutan file harus urut dimulai dari 1");

	//Member Code
	//-Digunakan @RBB
	public static final ValidationErrorCode E02_01_ENTITY_CODE 			= bvec("02",	"01",	"Entity Code",						"Error di Kolom 3 'Kode LJK', tidak valid");
	public static final ValidationErrorCode E02_02_SECTOR_CODE			= bvec("02",	"02",	"Sector Code",						"Error di Kolom 2 'Kode Sektor LJK', Kode Sektor '%1$s' tidak valid seharusnya '%2$s'");
	
	//-Tidak digunakan
	public static final ValidationErrorCode E02_00_ENTITYTYPE_CODE 		= bvec("02",	"00",	"EntityType Code",					"Kode jenis LJK tidak valid");
	public static final ValidationErrorCode E02_03_SECTOR_CODE			= bvec("02",	"03",	"LJK Code",							"Kode LJK '%1$s' tidak valid, seharusnya '%2$s'");

	//Header
	//-Digunakan @RBB
	public static final ValidationErrorCode E03_01_COL_NUMBER 			= bvec("03",	"01",	"Header - Jumlah Kolom",			"Jumlah kolom Header harus %1$s");
	public static final ValidationErrorCode E03_02_FLAG_H 		 		= bvec("03",	"02",	"Header - Flag H01",				"Error di Kolom 1 'Flag Header', harus berisi 'H01'");
	public static final ValidationErrorCode E03_05_FORMCODE 		 	= bvec("03",	"05",	"Header - Kode Form",				"Error di Kolom 6 'Kode Form Laporan', Kode Form '%1$s' tidak valid seharusnya '%2$s'");
	public static final ValidationErrorCode E03_07_FILE_ROWCOUNT 		= bvec("03",	"07",	"Header - Jumlah Baris Form",		"Jumlah baris form %1$s seharusnya %2$s. Pastikan hanya ada 1 (satu) enter/baris kosong saja setelah baris F02 tanpa spasi/tab");
	public static final ValidationErrorCode E03_08_FORMAT_ROWCOUNT 		= bvec("03",	"08",	"Header - jumlah baris Form",		"Jumlah baris form %1$s minimum %2$s. Pastikan hanya ada 1 (satu) enter/baris kosong saja setelah baris F02 tanpa spasi/tab");
	public static final ValidationErrorCode E03_09_PERIOD_CODE			= bvec("03",	"09",	"Header - Periode Data",			"Error di Kolom 4 'Periode Data Pelaporan', Periode '%1$s' tidak valid seharusnya '%2$s'");
	public static final ValidationErrorCode E03_10_REPORT_CODE			= bvec("03",	"10",	"Header - Kode Jenis Laporan",		"Error di Kolom 5 'Kode Jenis Laporan', Kode Jenis Laporan '%1$s' tidak valid seharusnya '%2$s'");
	public static final ValidationErrorCode E03_11_FORMAT_MODAL_INTI	= bvec("03",	"11",	"Header - Format Modal Inti",		"Error di Kolom 7 'Modal Inti', format data harus angka (bilangan bulat tanpa pemisah ribuan). Contoh: 1000000");
	public static final ValidationErrorCode E03_12_VALUE_MODAL_INTI		= bvec("03",	"12",	"Header - Nilai Modal Inti",		"Error di Kolom 7 'Modal Inti', nilai modal inti '%1$s' tidak sama dengan form lain");
	public static final ValidationErrorCode E03_13_MIN_ROWCOUNT			= bvec("03",	"13",	"Header - Jumlah Baris Minimum D01","Jumlah baris D01 paling sedikit %1$s yaitu D01 penggunaan Single");
	public static final ValidationErrorCode E03_14_MAX_LENGTH_MONTI		= bvec("03",	"14",	"Header - Panjang Modal Inti",		"Error di Kolom 7 'Modal Inti', panjang maksimum %1$s");
	public static final ValidationErrorCode E03_15_NO_SURAT				= bvec("03",	"15",	"Header - Nomor Surat",				"Error di Kolom 8 'Nomor Surat OJK', harus diisi");
	public static final ValidationErrorCode E03_16_NO_SURAT_EQUAL		= bvec("03",	"16",	"Header - Nomor Surat Harus Sama",	"Error di Kolom 8 'Nomor Surat OJK', Nomor Surat OJK '%1$s' tidak sama dengan form lain");
	public static final ValidationErrorCode E03_17_NO_SURAT_EMPTY		= bvec("03",	"17",	"Header - Nomor Surat Harus Kosong","Error di Kolom 8 'Nomor Surat OJK', harus kosong (pastikan tidak ada spasi/tab)");
	public static final ValidationErrorCode E03_18_NO_SURAT_PATTERN		= bvec("03",	"18",	"Header - Format Nomor Surat",		"Error di Kolom 8 'Nomor Surat OJK', format data yang diperbolehkan huruf, angka dan karakter -.,/");
	public static final ValidationErrorCode E03_19_HEADER_ONLY			= bvec("03",	"19",	"Header Only",						"Isi Form 1 baris Header (H01) saja tanpa Detail (D01) dan Footer (F01 dan F02). Pastikan hanya ada 1 (satu) enter/baris kosong saja setelah baris H01 tanpa spasi/tab");
	public static final ValidationErrorCode E03_20_REPORT_FORM_GROUP	= bvec("03", 	"20", 	"Header - Report Form Group",		"Error di Kolom 7 'Kode Status Koreksi', harus diisi '%1$s'");
	
	//-Digunakan @LBBPRK
	public static final ValidationErrorCode E03_21_FILE_ROWCOUNT 		= bvec("03",	"21",	"Header - Jumlah Baris Form",		"Jumlah baris form %1$s seharusnya %2$s. Pastikan hanya ada 1 (satu) enter/baris kosong saja setelah baris terakhir tanpa spasi/tab");
	public static final ValidationErrorCode E03_22_MIN_ROWCOUNT			= bvec("03",	"22",	"Header - Jumlah Baris Minimum D01","Jumlah baris D01 paling sedikit harus %1$s baris");
	public static final ValidationErrorCode E03_23_HEADER_NO_DATA		= bvec("03",	"23",	"Header - Tanpa data",				"Form harus diisi hanya baris Header (H01) %1$s. Pastikan hanya ada 1 (satu) enter/baris kosong saja setelah baris terakhir tanpa spasi/tab");
	public static final ValidationErrorCode E03_24_HEADER_WITH_DATA		= bvec("03",	"24",	"Header - Dengan data",				"Form tidak boleh kosong %1$s");
	public static final ValidationErrorCode E03_25_FILE_ROWCOUNT 		= bvec("03",	"25",	"Header - Jumlah Baris Form",		"Jumlah baris form %1$s seharusnya %2$s. Pastikan hanya ada 1 (satu) enter/baris kosong saja setelah baris terakhir tanpa spasi/tab");
	
	public static final ValidationErrorCode E03_26_MAX_LENGTH_NO_SURAT	= bvec("03",	"26",	"Header - Panjang Nomor Surat",		"Error di Kolom 8 'Nomor Surat OJK', panjang maksimum %1$s");

    // ~ Apolo PM 2025
    public static final ValidationErrorCode E03_27_NO_SURAT_PATTERN_PM	= bvec("03",	"27",	"Header - Format Nomor Surat",		"Error di Kolom 8 'Nomor Surat OJK', format data yang diperbolehkan huruf, angka, spasi dan karakter -./");
    public static final ValidationErrorCode E03_28_TARGET_ZERO	        = bvec("03",	"28",	"Kesalah",		"Harus diisi sama dengan '%s' karena '%s' = 0.");
    public static final ValidationErrorCode E03_29_DEVIATION_CALCULATION= bvec("03",	"29",	"Validasi Formula",		"Perhitungan Deviasi = ('%s' - '%s') / '%s'");

	// Dapen 2026
	public static final ValidationErrorCode E03_30_JENIS_PROGRAM		= bvec("03", 	"30", 	"Header - Jenis Program",		"Error di Kolom 9 'Jenis Program'. Jenis Program '%1$s' tidak sesuai dengan Program yang dipilih '%2$s'.");
	public static final ValidationErrorCode E03_31_JENIS_PROGRAM_NOT_EXISTS	= bvec("03", 	"31", 	"Header - Jenis Program",		"Error di Kolom 9 'Jenis Program'. Jenis Program '%1$s' Tidak Terdaftar.");
	public static final ValidationErrorCode E03_32_EQUAL_PENISUN 				= bvec("03",	"32",	"Sama Dengan",						"Program Pensiun harus diisi '%1$s' karena Jenis Program yang dipilih adalah '%2$s'");
	public static final ValidationErrorCode E03_33_ROW_COUNT 				= bvec("03",	"33",	"Kesalahan",						"Jumlah baris '%1$s' minimal %2$s");
	public static final ValidationErrorCode E03_34_EQUAL_FORM 				= bvec("03",	"34",	"Sama Dengan",						"nilai harus sama dengan %1$s pada form %2$s");
	public static final ValidationErrorCode E03_35_EQUAL_FORM 				= bvec("03",	"35",	"Sama Dengan",						"nilai harus %1$s");

	//-Tidak digunakan
	public static final ValidationErrorCode E03_00_HEADER 				= bvec("03",	"00",	"Header",							"Header tidak valid, %1$s");
	public static final ValidationErrorCode E03_03_YEAR 		 		= bvec("03",	"03",	"Header - tahun",					"Tahun '%1$s' tidak sesuai dengan nama file %2$s");
	public static final ValidationErrorCode E03_04_MONTH 		 		= bvec("03",	"04",	"Header - bulan",					"Bulan '%1$s' tidak sesuai dengan nama file %2$s");
	public static final ValidationErrorCode E03_06_FORMAT_ROWCOUNT 		= bvec("03",	"06",	"Header - jumlah baris per format",	"Jumlah baris lampiran %1$s tidak valid, seharusnya %2$s");
//	public static final ValidationErrorCode E03_07_FILE_ROWCOUNT 		= bvec("03",	"07",	"Header - kodeform",				"Jumlah baris header %1$s tidak sama dengan jumlah data sebenarnya %2$s");
	
	//Detail
	//-Digunakan @RBB
	public static final ValidationErrorCode E04_00_DETAIL_COLUMN_AMOUNT	= bvec("04",	 "00",	"Jumlah kolom Detail",				"Jumlah kolom %1$s, seharusnya %2$s kolom");
	public static final ValidationErrorCode E04_01_CRLF					= bvec("04",	 "01",	"Cr Lf",							"Karakter ganti baris harus CR LF");
	public static final ValidationErrorCode E04_02_DETAIL_COLUMN_AMOUNT = bvec("04",   "02",  "Jumlah kolom Detail",        "Jumlah kolom harus %1$s kolom");

	public static final ValidationErrorCode E04_20_DATI2_DATI1 = bvec("04",   "20",  "DATI II dan I",        "Lokasi DATI II %1$s tidak sesuai dengan DATI I %2$s");

	//Footer
	//-Digunakan @RBB
	public static final ValidationErrorCode E05_00_FLAG_F01				= bvec("05", 	 "00", 	"Footer - Flag F01", 				"Error di Kolom 1 'Flag Footer', harus berisi 'F01'");
	public static final ValidationErrorCode E05_01_FLAG_F02				= bvec("05", 	 "01", 	"Footer - Flag F02", 				"Error di Kolom 1 'Flag Footer', harus berisi 'F02'");
	public static final ValidationErrorCode E05_02_MAX_LENGTH			= bvec("05", 	 "02", 	"Footer - Max Length", 				"Error di Kolom 2 'Keterangan Footer', panjang maksimum 5000 karakter");
	public static final ValidationErrorCode E05_04_MUST_EMPTY			= bvec("05", 	 "04", 	"Footer - Harus Kosong",			"Error di Kolom 2 'Keterangan Footer', harus kosong (pastikan tidak ada spasi/tab)");
	public static final ValidationErrorCode E05_05_MANDATORY			= bvec("05", 	 "05", 	"Footer - Harus Diisi", 			"Error di Kolom 2 'Keterangan Footer', harus diisi");
	public static final ValidationErrorCode E05_06_FOOTER_COLUMN_AMOUNT	= bvec("05", 	 "06", 	"Footer - Jumlah Kolom",			"Jumlah kolom Footer harus 2");	
	public static final ValidationErrorCode E05_07_MORE_ENTER			= bvec("05", 	 "07", 	"Footer - Banyak Enter dibawah",	"Pastikan hanya ada 1 (satu) enter/baris kosong saja setelah baris F02 tanpa spasi/tab");
	public static final ValidationErrorCode E05_08_F02_FIRST_CHECK		= bvec("05", 	 "08", 	"Footer - F02 First Check",			"Pastikan baris terakhir adalah F02. Contoh: F02|isi footer");
	public static final ValidationErrorCode E05_09_F01_FIRST_CHECK		= bvec("05", 	 "09", 	"Footer - F01 First Check",			"Pastikan baris terakhir adalah F01. Contoh: F01|isi footer");
	public static final ValidationErrorCode E05_10_FLAG_FOOTER			= bvec("05", 	 "10", 	"Footer - Flag", 					"Error di Kolom 1 'Flag Footer', harus berisi '%1$s'");
	public static final ValidationErrorCode E05_11_MAX_LENGTH			= bvec("05", 	 "02", 	"Footer - Max Length", 				"Error di Kolom 2 'Keterangan Footer', panjang maksimum %1$s karakter");
	//-Digunakan @LBBPRK
	public static final ValidationErrorCode E05_09_MORE_ENTER			= bvec("05", 	 "09", 	"Footer - Banyak Enter dibawah",	"Pastikan hanya ada 1 (satu) enter/baris kosong saja setelah baris terakhir tanpa spasi/tab");
	
	//-Tidak digunakan
	public static final ValidationErrorCode E05_03_FORMAT_FOOTER		= bvec("05", 	 "03", 	"Footer - Format",	 				"huruf, angka, spasi dan special karakter karakter");
	
	//DLL
    public static final ValidationErrorCode E06_00_FORMAT_NOT_FOUND		= bvec("06", 	 "00", 	"Format Not Found", 				"Format pelaporan tidak ditemukan");
	
	public static final ValidationErrorCode E07_01_NO_SURAT_PENGANTAR	= bvec("07",	"01",	"Header - Nomor Surat Pengantar",	"Error di Kolom 8 'Nomor Surat Pengantar', harus diisi");
	public static final ValidationErrorCode E07_02_NO_SURAT_LHPL		= bvec("07",	"02",	"Header - Nomor LHPL",		"Error di Kolom 9 'Nomor LHPL', harus diisi");
	public static final ValidationErrorCode E07_03_MAX_LENGTH_NO_SURAT_PENGANTAR = bvec("07", "03", "Header - Panjang Nomor Surat Pengantar", "Error di Kolom 8 'Nomor Surat Pengantar', panjang maksimum %1$s");
	public static final ValidationErrorCode E07_04_MAX_LENGTH_NO_SURAT_LHPL = bvec("07", "04", "Header - Panjang Nomor LHPL", "Error di Kolom 9 'Nomor LHPL', panjang maksimum %1$s");
	public static final ValidationErrorCode E07_05_NO_SURAT_PENGANTAR_PATTERN	= bvec("07",	"05",	"Header - Format Nomor Surat Pengantar", "Error di Kolom 8 'Nomor Surat Pengantar', format data yang diperbolehkan huruf, angka dan karakter -.,/");
	public static final ValidationErrorCode E07_06_NO_SURAT_LHPL_PATTERN		= bvec("07",	"06",	"Header - Format Nomor LHPL",	"Error di Kolom 9 'Nomor LHPL', format data yang diperbolehkan huruf, angka dan karakter -.,/");
	public static final ValidationErrorCode E99_00_OTHER         = bvec("99",  "00", "Kesalahan",         "%1$s");

	private static ValidationErrorCode bvec(String code, String subCode, String description, String descriptionFormat){
		ValidationErrorCode validationErrorCode = new ValidationErrorCode(code, subCode, description, descriptionFormat);
		validationErrorCodeMap.put(validationErrorCode.getCode() + "." + validationErrorCode.getSubCode(), validationErrorCode);
		return validationErrorCode;
	}
	public static Map<String, ValidationErrorCode> getMap() {
		return validationErrorCodeMap;
	}

	@XStreamAsAttribute
	@Getter public String code;

	@XStreamAsAttribute
	@Getter public String subCode;

	@Getter public String description;
	@Getter @Setter public String messageFormat;

	public ValidationErrorCode(String code, String subCode, String description, String messageFormat){
		this.code = code;
		this.subCode = subCode;
		this.description = description;
		this.messageFormat = messageFormat;
	}

	public String constructDescription(Object ... args ) {
		return String.format(messageFormat, args);
	}
}