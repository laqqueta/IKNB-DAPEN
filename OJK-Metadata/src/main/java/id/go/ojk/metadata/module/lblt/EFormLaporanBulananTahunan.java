package id.go.ojk.metadata.module.lblt;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLaporanBulananTahunan {
	LTLB_DTUM("DTUM", "Form Data Umum"),
	LTLB_LAN("LAN", "Form Laporan Aset Neto"),
	LTLB_LPAN("LPAN", "Form Laporan Perubahan Aset Neto Murni"),
	LTLB_NERACA("NRC", "Form Neraca"),
	LTLB_LPHU("LPHU", "Form Laporan Perhitungan Hasil Usaha"),
	LTLB_LAK("LAK", "Form Laporan Arus Kas"),
	LTLB_PST("PST", "Form Kepesertaan Dana Pensiun"),
	LTLB_KUP("KUP", "Form Kekayaan Pendanaan Untuk Program Pensiun"),
	LTLB_REKINV("REKINV", "Form Rekap Investasi"),
	LTLB_ROI("ROI", "Form Laporan Hasil Investasi"),
	LTLB_ROI_ML("ROIML", "Form Laporan Hasil Investasi Manfaat Lain"),
	LTLB_ROI_SM("ROISM", "Form Laporan Hasil Investasi Iuran Sukarela"),
	LTLB_ALM("ALM", "Form Rekapitulasi Aset dan Liabilitas"),
	LTLB_INSP("INSP", "Form Rincian Investasi Pada Satu Pihak"),
	LTLB_INPT("INPT", "Form Rincian Investasi Pada Pihak Terafiliasi"),
	LTLB_INBM("INBM", "Form Rincian Investasi Yang Terindikasi Bermasalah"),
	LTLB_SBN("SBN", "Form Rincian Pemenuhan Ketentuan Mengenai Investasi SBN"),
	LTLB_RAS_1("RAS1", "Form Rasio Keuangan"),
	LTLB_RAS_2("RAS2", "Form Rasio Pendidikan dan Pelatihan"),
	LTLB_PIUS("PIUS", "Form Pengelolaan Iuran Sukarela"),
	LTLB_PMI("PMI", "Form Penggunaan Manajer Investasi"),
	LTLB_TBDSP("TBDSP", "Form Rincian Dana Yang Tidak Boleh Diakui Sebagai Pendapatan"),
	LTLB_DOC("DOC", "Form Rincian Deposito On Call Pada Bank"),
	LTLB_DPJKA("DPJKA", "Form Rincian Deposito Berjangka Pada Bank"),
	LTLB_DPJKV("DPJKV", "Form Rincian Deposito Berjangka Valas Pada Bank"),
	LTLB_SRDP("SRDP", "Form Rincian Sertifikat Deposito Pada Bank"),
	LTLB_SBI("SBI", "Form Rincian Surat Berharga Yang Diterbitkan Oleh Bank Indonesia"),
	LTLB_RSBN("RSBN", "Form Rincian Surat Berharga Negara"),
	LTLB_SHM("SHM", "Form Rincian Saham Yang Tercatat Di Bursa Efek Di Indonesia"),
	LTLB_OBLI("OBLI", "Form Rincian Obligasi Korporasi Yang Tercatat Di Bursa Efek Di Indonesia"),
	LTLB_SUKUK("SUKUK", "Form Rincian Sukuk Korporasi Yang Tercatat Di Bursa Efek Di Indonesia"),
	LTLB_OBSUD("OBSUD", "Form Rincian Obligasi/Sukuk Daerah"),
	LTLB_RKSD("RKSD", "Form Rincian Reksa Dana"),
	LTLB_MTN("MTN", "Form Rincian Medium Term Note (MTN)"),
	LTLB_EBA("EBA", "Form Rincian Efek Beragun Aset"),
	LTLB_DIRE("DIRE", "Form Rincian Dana Investasi Real Estat Berbentuk Kontrak Investasi Kolektif"),
	LTLB_DNFRA("DNFRA", "Form Rincian Dana Investasi Infrastruktur Berbentuk Kontrak Investasi Kolektif"),
	LTLB_KOKB("KOKB", "Form Rincian Kontrak Opsi dan Kontrak Berjangka Efek Yang Diperdagangkan Di Bursa Efek Di Indonesia"),
	LTLB_REPO("REPO", "Form Rincian Repo"),
	LTLB_PNYL("PNYL", "Form Rincian Penyertaan Langsung Di Indonesia"),
	LTLB_PROP("PROP", "Form Rincian Tanah, Bangunan, Atau Tanah dan Bangunan Di Indonesia"),
	LTLB_KASB("KASB", "Form Rincian Kas dan Bank"),
	LTLB_PIUT("PIUT", "Form Rincian Piutang Iuran"),
	LTLB_PIUB("PIUB", "Form Rincian Piutang Bunga Keterlambatan Iuran"),
	LTLB_BBMK("BBMK", "Form Rincian Beban Dibayar Di Muka"),
	LTLB_PIUI("PIUI", "Form Rincian Piutang Investasi"),
	LTLB_PIHI("PIHI", "Form Rincian Piutang Hasil Investasi"),
	LTLB_PILL("PILL", "Form Rincian Piutang Lain-Lain"),
	LTLB_TNBG("TNBG", "Form Rincian Tanah dan Bangunan"),
	LTLB_KNDR("KNDR", "Form Rincian Kendaraan"),
	LTLB_PKOM("PKOM", "Form Rincian Peralatan Komputer"),
	LTLB_PKAN("PKAN", "Form Rincian Peralatan Kantor"),
	LTLB_ASOL("ASOL", "Form Rincian Aset Operasional Lain"),
	LTLB_ASLN("ASLN", "Form Rincian Aset Lain-Lain"),
	LTLB_UMPJ("UMPJ", "Form Rincian Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo"),
	LTLB_UMPS("UMPS", "Form Rincian Utang Manfaat Sukarela"),
	LTLB_UTIN("UTIN", "Form Rincian Utang Investasi"),
	LTLB_PDDM("PDDM", "Form Rincian Pendapatan Diterima Di Muka"),
	LTLB_BMHB("BMHB", "Form Rincian Beban Yang Masih Harus Dibayar"),
	LTLB_UTLN("UTLN", "Form Rincian Utang Lain-Lain"),
	LTLB_PPIN("PPIN", "Form Rincian Peningkatan/Penurunan Nilai Investasi"),
	LTLB_IUR("IUR", "Form Rincian Iuran"),
	LTLB_PDIN("PDIN", "Form Rincian Pendapatan Di Luar Investasi"),
	LTLB_PDPL("PDPL", "Form Rincian Pengalihan Dari Dana Pensiun Lain"),
	LTLB_BINV("BINV", "Form Rincian Beban Investasi"),
	LTLB_BOPR("BOPR", "Form Rincian Beban Operasional"),
	LTLB_BIPR("BIPR", "Form Rincian Beban Di Luar Investasi dan Operasional"),
	LTLB_PPH("PPH", "Form Rincian Pajak Penghasilan"),
	LTLB_PKPL("PKPL", "Form Rincian Pengalihan Dana Ke Dana Pensiun Lain"),

	/* PPIP Form */

	LTLB_ROI_MPL("ROIMPL", "Form Laporan Hasil Investasi Manfaat Pensiun Lainnya"),
	LTLB_PINV("PINV", "Form Laporan Paket Investigasi"),
	LTLB_PINVS("PINVS", "Form Laporan Paket Investigasi Syariah"),
	LTLB_MPBK("MPBK", "Form Laporan Investasi Manfaat Pensiun Berkala"),
	LTLB_PMBK("PMBK", "Form Laporan Pengelolaan Manfaat Pensiun Berkala"),
	LTLB_LCF("LCF", "Form Laporan Life Cycle Fund"),

	LTLB_COVER("COVER", "LAPORAN BULANAN / LAPORAN KEUANGAN TAHUNAN DATA ELEKTRONIK DANA PENSIUN PEMBERI KERJA PROGRAM PENSIUN IURAN PASTI"),

	;

	@Getter
	private final String code;
	@Getter
	private final String name;
}
