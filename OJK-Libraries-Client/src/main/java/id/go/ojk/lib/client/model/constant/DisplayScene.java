package id.go.ojk.lib.client.model.constant;

public enum DisplayScene {
	homeNotLogin(""),
	home(""),
	other(""),

	preparationAndSending("Validasi Laporan"),
	sending("Kirim Data"),
	summaryData("Pelaporan Inisial"),
	openErrorFile("Buka File Error"),
	openMasterData("Buka Data Master"),

	userOfflineManagement("Pengaturan Akses Offline"),

	//RBB
	pelaporanPreparationRbb("Penyampaian Rencana Bisnis"),
	perubahanPreparationRbb("Perubahan Rencana Bisnis"),
	penyesuaianPreparationRbb("Penyesuaian Rencana Bisnis"),
	realisasiPreparationRbb("Realisasi Rencana Bisnis"),
	pengawasanPreparationRbb("Pengawasan Rencana Bisnis"),

	//LB
	rutinPreparationLb("Laporan Bulanan"),
	perubahanPreparationLb("Perubahan Laporan Bulanan"),
	penyesuaianPreparationLb("Penyesuaian Laporan Bulanan"),
	penyesuaianKapPreparationLb("Penyesuaian KAP Laporan Bulanan"),
	penyesuaianPreparationLb2("Penyesuaian Laporan Bulanan"),

	//LBK
	lbkBulananPreparation("Laporan Bulanan"),
	lbkTahunanPreparation("Laporan Tahunan"),

	//SA
	pelaporanPreparationSa("Laporan Self Assessment"),
	pelaporanKoreksiPreparationSa("Koreksi Laporan Self Assessment"),
	pengkinianPreparationSa("Pengkinian Laporan Self Assessment"),
	pengkinianKoreksiPreparationSa("Koreksi Pengkinian Laporan Self Assessment"),

	//APU-PPT
	penilaianPreparationApu("Penilaian Tingkat Risiko"),
	penilaianPreparationApu2("Penilaian Tingkat Risiko"),
	rencanaPreparationApu("Rencana Kegiatan"),
	realisasiPreparationApu("Realisasi Pengkinian"),

	//TL
	pelaporanPreparationTl("Laporan Tindak Lanjut"),
	koreksiPreparationTl("Koreksi Laporan Tindak Lanjut"),

	//PLS
	pelaporanPreparationPls("Laporan Polis"),
	koreksiPreparationPls("Koreksi Laporan Polis"),

	// TPP
	rencanaPrepartionTpp("Laporan Rencana Pengkinian"),
	realisasiPreprationTpp("Laporan Realisasi Pengkinian"),
	penilaianPreprationTpp("Laporan Penilaian Risiko Secara Individu (Individual Risk Assessment)"),


	//BPJS KS
	LBBPKSLK("Laporan Keuangan BPJS Kesehatan"),
	LBBPKSDJS("Laporan Keuangan Dana Jaminan Sosial (DJS) BPJS Kesehatan"),
	LBBPKSLPP("Laporan Pengelolaan Program (LPP) Jaminan Sosial Kesehatan Bulanan bagi BPJS Kesehatan"),

	//BPJS TK
	LBBPTKBDN("Laporan Badan BPJS Ketenagakerjaan"),
	LBBPTKJKK("Laporan Program Jaminan Kecelakaan Kerja"),
	LBBPTKJK("Laporan Program Jaminan Kematian"),
	LBBPTKJHT("Laporan Program Jaminan Hari Tua"),
	LBBPTKJKP("Laporan Program Jaminan Kehilangan Pekerjaan"),
	LBBPTKJP("Laporan Program Jaminan Pensiun"),
	LPBPTKJKK("Laporan Program Jaminan Kecelakaan Kerja"),
	LPBPTKJK("Laporan Program Jaminan Kematian"),
	LPBPTKJHT("Laporan Program Jaminan Hari Tua"),
	LPBPTKJKP("Laporan Program Jaminan Kehilangan Pekerjaan"),
	LPBPTKJP("Laporan Program Jaminan Pensiun"),
	LTBPTKBDN("Laporan Badan BPJS Ketenagakerjaan"),
	LTBPTKJKK("Laporan Program Jaminan Kecelakaan Kerja"),
	LTBPTKJK("Laporan Program Jaminan Kematian"),
	LTBPTKJHT("Laporan Program Jaminan Hari Tua"),
	LTBPTKJKP("Laporan Program Jaminan Kehilangan Pekerjaan"),
	LTBPTKJP("Laporan Program Jaminan Pensiun"),
	LABPTKJKK("Laporan Program Jaminan Kecelakaan Kerja"),
	LABPTKJK("Laporan Program Jaminan Kematian"),
	LABPTKJHT("Laporan Program Jaminan Hari Tua"),
	LABPTKJKP("Laporan Program Jaminan Kehilangan Pekerjaan"),
	LABPTKJP("Laporan Program Jaminan Pensiun"),

    // DPPK Konven
    LKB_DP("Laporan Keuangan Bulanan"),
    LKT_DP("Laporan Keuangan Tahunan"),
	;

	private String name;

	private DisplayScene(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static boolean isCustom(DisplayScene eEnum) {
		boolean res = false;
		switch (eEnum) {
		case pelaporanPreparationRbb:
		case perubahanPreparationRbb:
		case penyesuaianPreparationRbb:
		case realisasiPreparationRbb:
		case pengawasanPreparationRbb:
		case rutinPreparationLb:
		case perubahanPreparationLb:
		case penyesuaianPreparationLb:
		case penyesuaianPreparationLb2:
		case penyesuaianKapPreparationLb:
		case pelaporanPreparationSa:
		case pelaporanKoreksiPreparationSa:
		case pengkinianPreparationSa:
		case pengkinianKoreksiPreparationSa:
		case penilaianPreparationApu:
		case penilaianPreparationApu2:
		case rencanaPreparationApu:
		case realisasiPreparationApu:
		case lbkBulananPreparation:
		case lbkTahunanPreparation:
		case koreksiPreparationTl:
		case pelaporanPreparationTl:
		case pelaporanPreparationPls:
		case koreksiPreparationPls:
		case realisasiPreprationTpp:
		case rencanaPrepartionTpp:
		case penilaianPreprationTpp:
		case LBBPKSLK:
		case LBBPKSDJS:
		case LBBPKSLPP:
		case LBBPTKBDN:
		case LBBPTKJKK:
		case LBBPTKJK:
		case LBBPTKJHT:
		case LBBPTKJKP:
		case LBBPTKJP:
		case LPBPTKJKK:
		case LPBPTKJK:
		case LPBPTKJHT:
		case LPBPTKJKP:
		case LPBPTKJP:
		case LTBPTKBDN:
		case LTBPTKJKK:
		case LTBPTKJK:
		case LTBPTKJHT:
		case LTBPTKJKP:
		case LTBPTKJP:
		case LABPTKJKK:
		case LABPTKJK:
		case LABPTKJHT:
		case LABPTKJKP:
		case LABPTKJP:
        case LKB_DP:
        case LKT_DP:
			res = true;
			break;
		default:
			res = false;
			break;
		}
		return res;
	}
}
