package id.go.ojk.lib.client.model.reference;

import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import id.go.ojk.lib.client.CollectionUtil;
import lombok.Getter;
import lombok.Setter;

@XStreamAlias("referenceMetadata")
public class ReferenceMetadata {

	@XStreamAsAttribute
	private int number;

	@XStreamAsAttribute
	private String name;

	@XStreamAsAttribute
	private ReferenceType type;
	
	@Getter @Setter private boolean perSegment;

	private String description;
	
	@Getter @Setter private Map<String, String> label1Map;
	
	@Getter @Setter private String errorDescription;

	public ReferenceMetadata(int number, String name, ReferenceType type, String description){
		this(number, name, type, description, null);
	}

	public ReferenceMetadata(int number, String name, ReferenceType type, String description, String errorDescription){
		setNumber(number);
		setName(name);
		setType(type);
		setDescription(description);
		setErrorDescription(errorDescription);
	}
	
	public ReferenceMetadata perSegment(boolean perSegment){
		setPerSegment(perSegment);
		return this;
	}
	
	public ReferenceMetadata initLabel1Map(String initLabel1Map){
		this.label1Map = CollectionUtil.toMap(initLabel1Map);
		return this;
	}
	
	public ReferenceMetadata initLabel1Map(Map<String, String> label1Map){
		this.label1Map = label1Map;
		return this;
	}
	
	public String getLabel1Description(String label1){
		if ( label1Map == null )
			return label1;
		String label1Desc = label1Map.get(label1);
		return label1Desc == null ? label1 : label1Desc;
	}

	public String getFileName(){
		return "R" + getNumber() + getName() + ".xml";
	}

	public ReferenceMetadata(){
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ReferenceType getType() {
		return type;
	}

	public void setType(ReferenceType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static final ReferenceMetadata R1EntityType 				= new ReferenceMetadata(1, 	"EntityType", 			ReferenceType.keyValue, 		"JENIS LJK");
	public static final ReferenceMetadata R2Entity					= new ReferenceMetadata(2, 	"Entity", 				ReferenceType.keyValue, 		"KODE LJK");
	public static final ReferenceMetadata R3Branch					= new ReferenceMetadata(3, 	"Branch", 				ReferenceType.keyValue, 		"KODE KANTOR CABANG");
	public static final ReferenceMetadata R4AcademicDegree			= new ReferenceMetadata(4, 	"AcademicDegree", 		ReferenceType.keyValue, 		"STATUS GELAR");
	public static final ReferenceMetadata R5City					= new ReferenceMetadata(5, 	"City", 				ReferenceType.keyValue, 		"KABUPATEN/KOTA DATI II");
	public static final ReferenceMetadata R6Country					= new ReferenceMetadata(6, 	"Country", 				ReferenceType.keyValue, 		"NEGARA");
	public static final ReferenceMetadata R7Occupation				= new ReferenceMetadata(7, 	"Occupation", 			ReferenceType.keyValue, 		"PEKERJAAN");
	public static final ReferenceMetadata R8DebtorRelType			= new ReferenceMetadata(8, 	"DebtorRelType", 		ReferenceType.keyValue, 		"HUBUNGAN DENGAN LJK");
	
	public static final ReferenceMetadata R9DebtorClass				= new ReferenceMetadata(9, 	"DebtorClass", 			ReferenceType.keyValue, 		"PIHAK KETIGA BUKAN BANK");
	public static final ReferenceMetadata R9001DebtorClassI			= new ReferenceMetadata(9001, "DebtorClassI", 		ReferenceType.keyValue, 		"PIHAK KETIGA BUKAN BANK (INDIVIDU)");
	public static final ReferenceMetadata R9002DebtorClassC			= new ReferenceMetadata(9002, "DebtorClassC", 		ReferenceType.keyValue, 		"PIHAK KETIGA BUKAN BANK (BADAN)");
	
	public static final ReferenceMetadata R10CompanyType			= new ReferenceMetadata(10,	"CompanyType", 			ReferenceType.keyValue, 		"JENIS BADAN");

	public static final ReferenceMetadata R11EconomicSector			= new ReferenceMetadata(11, "EconomicSector", 		ReferenceType.keyValue, 		"SEKTOR EKONOMI");
	public static final ReferenceMetadata R12RatingAgency			= new ReferenceMetadata(12, "RatingAgency", 		ReferenceType.keyValue, 		"LEMBAGA PEMERINGKAT/RATING");
	public static final ReferenceMetadata R13JobPosition			= new ReferenceMetadata(13, "JobPosition", 			ReferenceType.keyValueLabel1, 	"JABATAN PENGURUS/PEMILIK").initLabel1Map("O=Pemilik&M=Pengurus&B=Pemilik Pengurus&N=Bukan Pemilik");
	public static final ReferenceMetadata R14CreditNature			= new ReferenceMetadata(14, "CreditNature", 		ReferenceType.keyValue, 		"SIFAT KREDIT");
	public static final ReferenceMetadata R15CreditType				= new ReferenceMetadata(15, "CreditType", 			ReferenceType.keyValueLabel1, 	"JENIS KREDIT").initLabel1Map("Y='Dengan PK'&T='Tanpa PK'&C='Kartu Kredit'");
	public static final ReferenceMetadata R16FinancingScheme		= new ReferenceMetadata(16, "FinancingScheme", 		ReferenceType.keyValue, 		"SKIM/AKAD PEMBIAYAAN");
	public static final ReferenceMetadata R17DebtorCategory			= new ReferenceMetadata(17, "DebtorCategory", 		ReferenceType.keyValue, 		"KATEGORI DEBITUR");
	public static final ReferenceMetadata R18CreditUsage			= new ReferenceMetadata(18, "CreditUsage", 			ReferenceType.keyValue, 		"JENIS PENGGUNAAN");
	public static final ReferenceMetadata R19CreditOrientation		= new ReferenceMetadata(19, "CreditOrientation", 	ReferenceType.keyValue, 		"ORIENTASI PENGGUNAAN");
	public static final ReferenceMetadata R20Currency				= new ReferenceMetadata(20, "Currency", 			ReferenceType.keyValue, 		"VALUTA");

	public static final ReferenceMetadata R21CollectibilityType		= new ReferenceMetadata(21, "CollectibilityType", 	ReferenceType.keyValue, 		"KOLEKTIBILITAS");
	public static final ReferenceMetadata R22NonPerformingReason	= new ReferenceMetadata(22, "NonPerformingReason", 	ReferenceType.keyValue, 		"SEBAB MACET");
	public static final ReferenceMetadata R23RestructureMethod		= new ReferenceMetadata(23, "RestructureMethod", 	ReferenceType.keyValue, 		"CARA RESTRUKTURISASI");
	public static final ReferenceMetadata R24Condition				= new ReferenceMetadata(24, "Condition", 			ReferenceType.keyValueLabel2, 	"KONDISI")
		.initLabel1Map("Y=DEBITUR MEMILIKI KEWAJIBAN&T=DEBITUR TIDAK MEMILIKI KEWAJIBAN")
		.perSegment(true);
	public static final ReferenceMetadata R25SecurityType			= new ReferenceMetadata(25, "SecurityType", 		ReferenceType.keyValue, 		"JENIS SURAT BERHARGA");
	public static final ReferenceMetadata R26SecurityOwnPurpose		= new ReferenceMetadata(26, "SecurityOwnPurpose", 	ReferenceType.keyValue, 		"TUJUAN KEPEMILIKAN SURAT BERHARGA");
	public static final ReferenceMetadata R27LcType					= new ReferenceMetadata(27, "LcType", 				ReferenceType.keyValue, 		"JENIS LC");
	public static final ReferenceMetadata R28LcPurpose				= new ReferenceMetadata(28, "LcPurpose", 			ReferenceType.keyValue, 		"TUJUAN LC");
	public static final ReferenceMetadata R29BankGuaranteeType		= new ReferenceMetadata(29, "BankGuaranteeType", 	ReferenceType.keyValue, 		"JENIS GARANSI");
	public static final ReferenceMetadata R30BankGuaranteePurpose	= new ReferenceMetadata(30, "BankGuaranteePurpose", ReferenceType.keyValue, 		"TUJUAN GARANSI");

	public static final ReferenceMetadata R31OtherFacilityType		= new ReferenceMetadata(31, "OtherFacilityType", 	ReferenceType.keyValue, 		"JENIS FASILITAS LAINNYA");
	public static final ReferenceMetadata R32CollateralType			= new ReferenceMetadata(32, "CollateralType", 		ReferenceType.keyValue, 		"JENIS AGUNAN");
	public static final ReferenceMetadata R33ContractType			= new ReferenceMetadata(33, "ContractType", 		ReferenceType.keyValue, 		"JENIS PENGIKATAN");
	public static final ReferenceMetadata R34SourceOfIncome			= new ReferenceMetadata(34, "SourceOfIncome", 		ReferenceType.keyValue, 		"SUMBER PENGHASILAN");

	//TODO
	public static final ReferenceMetadata R38SegmenFacilityType		= new ReferenceMetadata(38, "SegmenFacilityType", 	ReferenceType.keyValue, 		"JENIS SEGMENT FASILITAS");
	public static final ReferenceMetadata R40GovernmentCreditProgram= new ReferenceMetadata(40, "GovernmentCreditProgram", ReferenceType.keyValue, 		"KREDIT PROGRAM PEMERINTAH");

	//public static final ReferenceMetadata R39GenderType				= new ReferenceMetadata(39, "GenderType", 		ReferenceType.keyValueLabel1, 	"JENIS KELAMIN");
	public static final ReferenceMetadata R3901GenderType			= new ReferenceMetadata(3901, "GenderType", 		ReferenceType.keyValue, 		"JENIS KELAMIN INDIVIDU");
	public static final ReferenceMetadata R3902OffclsSharehldrType	= new ReferenceMetadata(3902, "OffclsSharehldrType", ReferenceType.keyValue, 		"JENIS KELAMIN BADAN USAHA");
	
	public static final ReferenceMetadata R41InterestType			= new ReferenceMetadata(41, "InterestType", 		ReferenceType.keyValue, 		"JENIS SUKU BUNGA");
	public static final ReferenceMetadata R42CollateralStatus		= new ReferenceMetadata(42, "CollateralStatus", 	ReferenceType.keyValue, 		"STATUS AGUNAN");
	public static final ReferenceMetadata R43OwnerStatus			= new ReferenceMetadata(43, "OwnerStatus", 			ReferenceType.keyValue, 		"STATUS PENGURUS/PEMILIK");

	public static final ReferenceMetadata R44MaritalStatus			= new ReferenceMetadata(44, "MaritalStatus", 		ReferenceType.keyValue, 		"STATUS PERKAWINAN");
	
	//public static final ReferenceMetadata R45IdentityType			= new ReferenceMetadata(45, "IdentityType", 		ReferenceType.keyValueLabel1, 	"JENIS IDENTITAS");
//	public static final ReferenceMetadata R4501IdentityTypeI		= new ReferenceMetadata(4501, "IdentityTypeI", 		ReferenceType.keyValue, 		"JENIS IDENTITAS INDIVIDU");
//	public static final ReferenceMetadata R4502IdentityTypeA		= new ReferenceMetadata(4502, "IdentityTypeA", 		ReferenceType.keyValue, 		"JENIS IDENTITAS BADAN USAHA");

	public static final ReferenceMetadata R45IdentityType			= new ReferenceMetadata(45,   "IdentityType", 		ReferenceType.keyValue, 		"JENIS IDENTITAS")
		.perSegment(true);
	
	public static final ReferenceMetadata R88JenisTabungan			= new ReferenceMetadata(88, "JenisTabungan", 		ReferenceType.keyValue, 		"JENIS TABUNGAN");
//	public static final ReferenceMetadata R4501IdentityTypeD01		= new ReferenceMetadata(4501, "IdentityTypeD01", 	ReferenceType.keyValue, 		"JENIS IDENTITAS D01");
//	public static final ReferenceMetadata R4502IdentityTypeM01		= new ReferenceMetadata(4502, "IdentityTypeM01", 	ReferenceType.keyValue, 		"JENIS IDENTITAS M01");
//	public static final ReferenceMetadata R4503IdentityTypeP01		= new ReferenceMetadata(4503, "IdentityTypeP01", 	ReferenceType.keyValue, 		"JENIS IDENTITAS P01");
	
	public static final ReferenceMetadata R9101OperationCUN			= new ReferenceMetadata(9101, "OperationCUN", 		ReferenceType.keyValue, 		"Operation C/U/N",				"harus berisi C/U/N");
	public static final ReferenceMetadata R9102OperationCU			= new ReferenceMetadata(9102, "OperationCU", 		ReferenceType.keyValue, 		"Operation C/U", 				"harus berisi C/U");
	public static final ReferenceMetadata R9103OperationCUD			= new ReferenceMetadata(9103, "OperationCUD", 		ReferenceType.keyValue, 		"Operation C/U/D",				"harus berisi C/U/D");
	public static final ReferenceMetadata R9104OperationCUDN		= new ReferenceMetadata(9104, "OperationCUDN", 		ReferenceType.keyValue, 		"Operation C/U/D/N",			"harus berisi C/U/D/N");
	public static final ReferenceMetadata R9201Yn					= new ReferenceMetadata(9201, "Yn", 				ReferenceType.keyValue, 		"Y/T", 							"harus berisi Y/T");
	public static final ReferenceMetadata R9202YT					= new ReferenceMetadata(9202, "YT", 				ReferenceType.keyValue, 		"Y/T", 							"harus bernilai 1 (Ya) atau 2 (Tidak)");

	public static final ReferenceMetadata R99001OfflineUploadReason = new ReferenceMetadata(99001, 	"OfflineUploadReason", 	ReferenceType.keyValue, 	"Alasan upload offline");

	public static final ReferenceMetadata R101PosIndikatorKeuanganUtama = new ReferenceMetadata(101, "PosIndikatorKeuanganUtama", ReferenceType.keyValue, "KODE KOMPONEN/BARIS INDIKATOR KEUANGAN UTAMA");
	public static final ReferenceMetadata R102PosProyeksiNeraca			= new ReferenceMetadata(102, "PosProyeksiNeraca", ReferenceType.keyValue, "KODE KOMPONEN/BARIS PROYEKSI NERACA");
	public static final ReferenceMetadata R103PosProyeksiLabaRugi		= new ReferenceMetadata(103, "PosProyeksiLabaRugi", ReferenceType.keyValue, "KODE KOMPONEN/BARIS PROYEKSI LABA RUGI");
	public static final ReferenceMetadata R104PosTargetRasioDanPos		= new ReferenceMetadata(104, "PosTargetRasioDanPos", ReferenceType.keyValue, "KODE KOMPONEN/BARIS TARGET RASIO-RASIO DAN POS-POS KEUANGAN");
	public static final ReferenceMetadata R105PosPenghimpunanDPK		= new ReferenceMetadata(105, "PosPenghimpunanDPK", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENGHIMPUNAN DANA PIHAK KETIGA");
	public static final ReferenceMetadata R106PosPendanaanLainnya		= new ReferenceMetadata(106, "PosPendanaanLainnya", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENDANAAN LAINNYA");
	public static final ReferenceMetadata R107PosKreditPihakTerkait		= new ReferenceMetadata(107, "PosKreditPihakTerkait", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENYALURAN DANA KEPADA PIHAK TERKAIT");
	public static final ReferenceMetadata R108PosPenempatanBankLain		= new ReferenceMetadata(108, "PosPenempatanBankLain", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENEMPATAN PADA BANK LAIN");
	public static final ReferenceMetadata R109PosKreditBankLain			= new ReferenceMetadata(109, "PosKreditBankLain", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENYALURAN KREDIT KEPADA BANK LAIN");
	public static final ReferenceMetadata R110PosKreditDebiturInti		= new ReferenceMetadata(110, "PosKreditDebiturInti", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENYALURAN KREDIT KEPADA DEBITUR INTI");
	public static final ReferenceMetadata R111PosKreditSektorEkonomi	= new ReferenceMetadata(111, "PosKreditSektorEkonomi", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENYALURAN KREDIT BERDASARKAN SEKTOR EKONOMI");
	public static final ReferenceMetadata R112PosKreditJenisPenggunaan	= new ReferenceMetadata(112, "PosKreditJenisPenggunaan", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENYALURAN KREDIT BERDASARKAN JENIS PENGGUNAAN");
	public static final ReferenceMetadata R113PosKreditJenisUsaha		= new ReferenceMetadata(113, "PosKreditJenisUsaha", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENYALURAN KREDIT BERDASARKAN JENIS USAHA");
	public static final ReferenceMetadata R114PosKPMMdanMonti			= new ReferenceMetadata(114, "PosKPMMdanMonti", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PEMENUHAN RASIO KEWAJIBAN PENYEDIAAN MODAL MINIMUM");
	public static final ReferenceMetadata R115PosPemenuhanMonti			= new ReferenceMetadata(115, "PosPemenuhanMonti", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PEMENUHAN MODAL INTI MINIMUM");
	public static final ReferenceMetadata R116PosPenambahanModal		= new ReferenceMetadata(116, "PosPenambahanModal", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENAMBAHAN MODAL");
	public static final ReferenceMetadata R117PosRealisasiNeraca		= new ReferenceMetadata(117, "PosRealisasiNeraca", ReferenceType.keyValue, "KODE KOMPONEN/BARIS REALISASI NERACA");
	public static final ReferenceMetadata R118PosRealisasiLabaRugi		= new ReferenceMetadata(118, "PosRealisasiLabaRugi", ReferenceType.keyValue, "KODE KOMPONEN/BARIS REALISASI LABA RUGI");
	public static final ReferenceMetadata R119PosRealisasiRasioDanPos	= new ReferenceMetadata(119, "PosRealisasiRasioDanPos", ReferenceType.keyValue, "KODE KOMPONEN/BARIS REALISASI RASIO KEUANGAN POKOK DAN POS-POS TERTENTU LAINNYA");
	public static final ReferenceMetadata R120PosKPMMdanMonti20XX		= new ReferenceMetadata(120, "PosKPMMdanMonti20XX", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PEMENUHAN RASIO KPMM DAN RASIO MODAL INTI 20XX");
	
	// BPRK
	public static final ReferenceMetadata R201RefPendanaanLainnya		= new ReferenceMetadata(201, "RefPendanaanLainnya", ReferenceType.keyValue, "KODE JENIS PENDANAAN LAINNYA");
	public static final ReferenceMetadata R202RefKreditPihakTerkait		= new ReferenceMetadata(202, "RefKreditPihakTerkait", ReferenceType.keyValue, "KODE JENIS PENYALURAN DANA");
	public static final ReferenceMetadata R203RefSektorEkonomi			= new ReferenceMetadata(203, "RefSektorEkonomi", ReferenceType.keyValue, "KODE SEKTOR EKONOMI");
	
	// BPRS
	public static final ReferenceMetadata R301RefPendanaanLainnya		= new ReferenceMetadata(301, "RefPendanaanLainnya", ReferenceType.keyValue, "KODE JENIS PENDANAAN LAINNYA");
	public static final ReferenceMetadata R302RefPembiayaanPihakTerkait	= new ReferenceMetadata(302, "RefPembiayaanPihakTerkait", ReferenceType.keyValue, "KODE JENIS PENYALURAN DANA");

	public static final ReferenceMetadata R501PosIndikatorKeuanganUtama = new ReferenceMetadata(501, "PosIndikatorKeuanganUtama", ReferenceType.keyValue, "KODE KOMPONEN/BARIS INDIKATOR KEUANGAN UTAMA");
	public static final ReferenceMetadata R502PosProyeksiNeraca			= new ReferenceMetadata(502, "PosProyeksiNeraca", ReferenceType.keyValue, "KODE KOMPONEN/BARIS PROYEKSI NERACA");
	public static final ReferenceMetadata R503PosProyeksiLabaRugi		= new ReferenceMetadata(503, "PosProyeksiLabaRugi", ReferenceType.keyValue, "KODE KOMPONEN/BARIS PROYEKSI LABA RUGI");
	public static final ReferenceMetadata R504PosTargetRasioDanPos		= new ReferenceMetadata(504, "PosTargetRasioDanPos", ReferenceType.keyValue, "KODE KOMPONEN/BARIS TARGET RASIO-RASIO DAN POS-POS KEUANGAN");
	public static final ReferenceMetadata R505PosPenghimpunanDPK		= new ReferenceMetadata(505, "PosPenghimpunanDPK", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENGHIMPUNAN DANA PIHAK KETIGA");
	public static final ReferenceMetadata R506PosPendanaanLainnya		= new ReferenceMetadata(506, "PosPendanaanLainnya", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENDANAAN LAINNYA");
	public static final ReferenceMetadata R507PosKreditPihakTerkait		= new ReferenceMetadata(507, "PosKreditPihakTerkait", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENYALURAN DANA KEPADA PIHAK TERKAIT");
	public static final ReferenceMetadata R508PosPenempatanBankLain		= new ReferenceMetadata(508, "PosPenempatanBankLain", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENEMPATAN PADA BANK LAIN");
	public static final ReferenceMetadata R509PosKreditBankLain			= new ReferenceMetadata(509, "PosKreditBankLain", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENYALURAN PEMBIAYAAN KEPADA BANK LAIN");
	public static final ReferenceMetadata R510PosKreditDebiturInti		= new ReferenceMetadata(510, "PosKreditDebiturInti", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENYALURAN PEMBIAYAAN KEPADA DEBITUR INTI");
	public static final ReferenceMetadata R511PosKreditSektorEkonomi	= new ReferenceMetadata(511, "PosKreditSektorEkonomi", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENYALURAN PEMBIAYAAN BERDASARKAN SEKTOR EKONOMI");
	public static final ReferenceMetadata R512PosKreditJenisPenggunaan	= new ReferenceMetadata(512, "PosKreditJenisPenggunaan", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENYALURAN PEMBIAYAAN BERDASARKAN JENIS PENGGUNAAN");
	public static final ReferenceMetadata R513PosKreditJenisUsaha		= new ReferenceMetadata(513, "PosKreditJenisUsaha", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENYALURAN PEMBIAYAAN BERDASARKAN JENIS USAHA");
	public static final ReferenceMetadata R514PosKreditJenisAkad		= new ReferenceMetadata(514, "PosKreditJenisAkad", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENYALURAN PEMBIAYAAN BERDASARKAN JENIS AKAD");
	public static final ReferenceMetadata R515PosKPMMdanMonti			= new ReferenceMetadata(515, "PosKPMMdanMonti", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PEMENUHAN RASIO KEWAJIBAN PENYEDIAAN MODAL MINIMUM");
	public static final ReferenceMetadata R516PosPemenuhanMonti			= new ReferenceMetadata(516, "PosPemenuhanMonti", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PEMENUHAN MODAL INTI MINIMUM");
	public static final ReferenceMetadata R517PosPenambahanModal		= new ReferenceMetadata(517, "PosPenambahanModal", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PENAMBAHAN MODAL");
	public static final ReferenceMetadata R518PosRealisasiNeraca		= new ReferenceMetadata(518, "PosRealisasiNeraca", ReferenceType.keyValue, "KODE KOMPONEN/BARIS REALISASI NERACA");
	public static final ReferenceMetadata R519PosRealisasiLabaRugi		= new ReferenceMetadata(519, "PosRealisasiLabaRugi", ReferenceType.keyValue, "KODE KOMPONEN/BARIS REALISASI LABA RUGI");
	public static final ReferenceMetadata R520PosRealisasiRasioDanPos	= new ReferenceMetadata(520, "PosRealisasiRasioDanPos", ReferenceType.keyValue, "KODE KOMPONEN/BARIS REALISASI RASIO-RASIO DAN POS-POS KEUANGAN");
	public static final ReferenceMetadata R521PosKPMMdanMonti20XX		= new ReferenceMetadata(521, "PosKPMMdanMonti20XX", ReferenceType.keyValue, "KODE KOMPONEN/BARIS RENCANA PEMENUHAN RASIO KPMM DAN RASIO MODAL INTI 20XX");
	
	public static final ReferenceMetadata R9999DummyReference			= new ReferenceMetadata(9999, "DummyReference", ReferenceType.keyValue, "DUMMY REFERENCE");

	
	//LAPBUL BPR
	public static final ReferenceMetadata R1001JenisAgunan = new ReferenceMetadata(1001,"JenisAgunan",ReferenceType.keyValue,"JENIS AGUNAN");
	public static final ReferenceMetadata R1002JenisAgunanDiambilAlih = new ReferenceMetadata(1002,"JenisAgunanDiambilAlih",ReferenceType.keyValue,"JENIS AGUNAN DIAMBIL ALIH");
	public static final ReferenceMetadata R1003NamaProvinsiKabupatenKota = new ReferenceMetadata(1003,"NamaProvinsiKabupatenKota",ReferenceType.keyValue,"NAMA PROVINSI, KABUPATEN, KOTA");
	public static final ReferenceMetadata R1004JenisAsetTetapInventarisDanAsetTidakBerwujud = new ReferenceMetadata(1004,"JenisAsetTetapInventarisDanAsetTidakBerwujud",ReferenceType.keyValue,"JENIS ASET TETAP, INVENTARIS DAN ASET TIDAK BERWUJUD");
	public static final ReferenceMetadata R1005SumberPerolehanAsetTetapInventarisDanAsetTidakBerwujud = new ReferenceMetadata(1005,"SumberPerolehanAsetTetapInventarisDanAsetTidakBerwujud",ReferenceType.keyValue,"SUMBER PEROLEHAN ASET TETAP, INVENTARIS DAN ASET TIDAK BERWUJUD");
	public static final ReferenceMetadata R1006PihakPenilai = new ReferenceMetadata(1006,"PihakPenilai",ReferenceType.keyValue,"PIHAK PENILAI");
	public static final ReferenceMetadata R1007JenisSimpananDariBankLain = new ReferenceMetadata(1007,"JenisSimpananDariBankLain",ReferenceType.keyValue,"JENIS SIMPANAN DARI BANK LAIN");
//	public static final ReferenceMetadata R1008MetodePenyusutan = new ReferenceMetadata(1008,"MetodePenyusutan",ReferenceType.keyValue,"METODE PENYUSUTAN");
	public static final ReferenceMetadata R1008JenisTabungan = new ReferenceMetadata(1008,"JenisTabungan",ReferenceType.keyValue,"JENIS TABUNGAN");
	public static final ReferenceMetadata R1009KlasifikasiSuratBerharga = new ReferenceMetadata(1009,"KlasifikasiSuratBerharga",ReferenceType.keyValue,"KLASIFIKASI SURAT BERHARGA");
	public static final ReferenceMetadata R1010JenisPenempatanPadaBankLain = new ReferenceMetadata(1010,"JenisPenempatanPadaBankLain",ReferenceType.keyValue,"JENIS PENEMPATAN PADA BANK LAIN");
	public static final ReferenceMetadata R1011Keterkaitan = new ReferenceMetadata(1011,"Keterkaitan",ReferenceType.keyValue,"KETERKAITAN");
	public static final ReferenceMetadata R1012KualitasPenempatanPadaBankLain = new ReferenceMetadata(1012,"KualitasPenempatanPadaBankLain",ReferenceType.keyValue,"KUALITAS PENEMPATAN PADA BANK LAIN");
	public static final ReferenceMetadata R1013JenisKredit = new ReferenceMetadata(1013,"JenisKredit",ReferenceType.keyValue,"JENIS KREDIT");
	public static final ReferenceMetadata R1014StatusRestrukturisasi = new ReferenceMetadata(1014,"StatusRestrukturisasi",ReferenceType.keyValue,"STATUS RESTRUKTURISASI");
	public static final ReferenceMetadata R1015JenisPenggunaan = new ReferenceMetadata(1015,"JenisPenggunaan",ReferenceType.keyValue,"JENIS PENGGUNAAN");
	public static final ReferenceMetadata R1016KeterkaitanKredit = new ReferenceMetadata(1016,"KeterkaitanKredit",ReferenceType.keyValue,"KETERKAITAN KREDIT");
	public static final ReferenceMetadata R1017SumberDanaPelunasan = new ReferenceMetadata(1017,"SumberDanaPelunasan",ReferenceType.keyValue,"SUMBER DANA PELUNASAN");
	public static final ReferenceMetadata R1018PeriodePembayaran = new ReferenceMetadata(1018,"PeriodePembayaran",ReferenceType.keyValue,"PERIODE PEMBAYARAN");
	public static final ReferenceMetadata R1019Kualitas = new ReferenceMetadata(1019,"Kualitas",ReferenceType.keyValue,"KUALITAS");
	public static final ReferenceMetadata R1020KategoriUsaha = new ReferenceMetadata(1020,"KategoriUsaha",ReferenceType.keyValue,"KATEGORI USAHA");
	public static final ReferenceMetadata R1021CaraPerhitunganSukuBunga = new ReferenceMetadata(1021,"CaraPerhitunganSukuBunga",ReferenceType.keyValue,"CARA PERHITUNGAN SUKU BUNGA");
	public static final ReferenceMetadata R1022JenisSetoranModal = new ReferenceMetadata(1022,"JenisSetoranModal",ReferenceType.keyValue,"JENIS SETORAN MODAL");
	public static final ReferenceMetadata R1023JenisModal = new ReferenceMetadata(1023,"JenisModal",ReferenceType.keyValue,"JENIS MODAL");
	public static final ReferenceMetadata R1024JenisPinjamanYangDiterima = new ReferenceMetadata(1024,"JenisPinjamanYangDiterima",ReferenceType.keyValue,"JENIS PINJAMAN YANG DITERIMA");
	public static final ReferenceMetadata R1025JenisAsetYangDihapusbuku = new ReferenceMetadata(1025,"JenisAsetYangDihapusbuku",ReferenceType.keyValue,"JENIS ASET YANG DIHAPUSBUKU");
	public static final ReferenceMetadata R1026JenisPihakTerkait = new ReferenceMetadata(1026,"JenisPihakTerkait",ReferenceType.keyValue,"JENIS PIHAK TERKAIT");
	public static final ReferenceMetadata R1027JenisPemilik = new ReferenceMetadata(1027,"JenisPemilik",ReferenceType.keyValue,"JENIS PEMILIK");
	public static final ReferenceMetadata R1028HubunganPihakTerkait = new ReferenceMetadata(1028,"HubunganPihakTerkait",ReferenceType.keyValue,"HUBUNGAN PIHAK TERKAIT");
	public static final ReferenceMetadata R1029JabatanPengurus = new ReferenceMetadata(1029,"JabatanPengurus",ReferenceType.keyValue,"JABATAN PENGURUS");
	public static final ReferenceMetadata R1030PendidikanFormal = new ReferenceMetadata(1030,"PendidikanFormal",ReferenceType.keyValue,"PENDIDIKAN FORMAL");
	public static final ReferenceMetadata R1031KeanggotaanKomite = new ReferenceMetadata(1031,"KeanggotaanKomite",ReferenceType.keyValue,"KEANGGOTAAN KOMITE");
	public static final ReferenceMetadata R1032StatusKepemilikanGedung = new ReferenceMetadata(1032,"StatusKepemilikanGedung",ReferenceType.keyValue,"STATUS KEPEMILIKAN GEDUNG");
	public static final ReferenceMetadata R1033JabatanOrgan = new ReferenceMetadata(1033,"JabatanOrgan",ReferenceType.keyValue,"JABATAN ORGAN");
	public static final ReferenceMetadata R1034SandiBank = new ReferenceMetadata(1034,"SandiBank",ReferenceType.keyValue,"SANDI BANK");
	public static final ReferenceMetadata R1035SandiMataUang = new ReferenceMetadata(1035,"SandiMataUang",ReferenceType.keyValue,"SANDI MATA UANG");
	public static final ReferenceMetadata R1036SandiPihakLawan = new ReferenceMetadata(1036,"SandiPihakLawan",ReferenceType.keyValue,"SANDI PIHAK LAWAN");
	public static final ReferenceMetadata R1037SandiSektorEkonomi = new ReferenceMetadata(1037,"SandiSektorEkonomi",ReferenceType.keyValue,"SANDI SEKTOR EKONOMI");
	public static final ReferenceMetadata R1038StatusBMPK = new ReferenceMetadata(1038,"StatusBMPK",ReferenceType.keyValue,"STATUS BMPK");
	public static final ReferenceMetadata R1046StatusAsetTetapInventarisDanAsetTidakBerwujud = new ReferenceMetadata(1046,"StatusAsetTetapInventarisDanAsetTidakBerwujud",ReferenceType.keyValue,"STATUS ASET TETAP, INVENTARIS DAN ASET TIDAK BERWUJUD");
	public static final ReferenceMetadata R1047AlasanDiblokir = new ReferenceMetadata(1047,"AlasanDiblokir",ReferenceType.keyValue,"ALASAN DIBLOKIR");
	public static final ReferenceMetadata R1048StatusBMPKIndividu = new ReferenceMetadata(1048,"StatusBMPKIndividu",ReferenceType.keyValue,"STATUS BMPK INDIVIDU");
	public static final ReferenceMetadata R1049PSP = new ReferenceMetadata(1049,"PSP",ReferenceType.keyValue,"PEMEGANG SAHAM PENGENDALI");
	
	public static final ReferenceMetadata R1039PosLaporanPosisiKeuangan = new ReferenceMetadata(1039,"PosLaporanPosisiKeuangan",ReferenceType.keyValue,"POS LAPORAN POSISI KEUANGAN");
	public static final ReferenceMetadata R1040PosRekeningAdministratif = new ReferenceMetadata(1040,"PosRekeningAdministratif",ReferenceType.keyValue,"POS REKENING ADMINISTRATIF");
	public static final ReferenceMetadata R1041PosLabaRugi = new ReferenceMetadata(1041,"PosLabaRugi",ReferenceType.keyValue,"POS LABA RUGI");
	public static final ReferenceMetadata R1042PosRincianAsetLainnya = new ReferenceMetadata(1042,"PosRincianAsetLainnya",ReferenceType.keyValue,"POS ASET LAIN-LAIN");
	public static final ReferenceMetadata R1043PosRincianLiabilitasSegera = new ReferenceMetadata(1043,"PosRincianLiabilitasSegera",ReferenceType.keyValue,"POS RINCIAN LIABILITAS SEGERA");
	public static final ReferenceMetadata R1044PosRincianLiabilitasLainnya = new ReferenceMetadata(1044,"PosRincianLiabilitasLainnya",ReferenceType.keyValue,"POS RINCIAN LIABILITAS LAINNYA");
	public static final ReferenceMetadata R1045PosRincianRasioKeuanganTriwulanan = new ReferenceMetadata(1045,"PosRincianRasioKeuanganTriwulanan",ReferenceType.keyValue,"POS RINCIAN RASIO KEUANGAN TRIWULANAN");
	
	public static final String R24_Category_Y 		= "00";			//MK DEBITUR MEMILIKI KEWAJIBAN
	public static final String R24_Category_T 		= "01";			//TMK DEBITUR TIDAK MEMILIKI KEWAJIBAN

	public static final String R24_CLOSED_FLAG_Y	= "Y";			//
	public static final String R24_CLOSED_FLAG_T	= "T";			//

	public static final String R13_Category_O 		= "O";			//O Pemilik 
	public static final String R13_Category_S 		= "S";			//M Share holder Pengurus
	public static final String R13_Category_B 		= "B";			//MO Pemilik Pengurus
	
	public static final String R13_Category_N 		= "N";			//NO bukan pemilik

	public static final String R15_Category_Y 		= "Y";			//Dengan Perjanjian Kredit
	public static final String R15_Category_T 		= "T";			//Tanpa Perjanjian Kredit
	public static final String R15_Category_C 		= "C";			//Cartu Credit
	
	public static final String R43_ACTIVE_1 		= "1";			//aktif


	public ReferenceMetadata cloneSafe() {
		try {
			return clone();
		} catch (Throwable t){
			t.printStackTrace();
			return null;
		}
	}

	@Override
	public ReferenceMetadata clone() throws CloneNotSupportedException {
		ReferenceMetadata referenceMetadata = new ReferenceMetadata();
		referenceMetadata.setNumber(number);
		referenceMetadata.setName(name);
		referenceMetadata.setType(type);
		referenceMetadata.setPerSegment(perSegment);
		referenceMetadata.setDescription(description);
		referenceMetadata.setLabel1Map(label1Map);
		referenceMetadata.setErrorDescription(errorDescription);
		return referenceMetadata;
	}
	
}