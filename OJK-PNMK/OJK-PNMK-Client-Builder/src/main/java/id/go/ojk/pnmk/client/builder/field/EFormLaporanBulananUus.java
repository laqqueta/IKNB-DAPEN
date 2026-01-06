package id.go.ojk.pnmk.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLaporanBulananUus {
	LB_0000 ("0000", "Profil UUS"),
	LB_0020 ("0020", "Rincian Kantor Selain Kantor Pusat"),
	LB_0030 ("0030", "Rincian Jumlah Pegawai"),
	LB_1100 ("1100", "Laporan Posisi Keuangan"),
	LB_1200 ("1200", "Laporan Laba Rugi dan Penghasilan Komprehensif Lain"),
	LB_1300 ("1300", "Laporan Arus Kas"),
	LB_1400 ("1400", "Laporan Analisis Kesesuaian Aset dan Liabilitas"),
	LB_2100 ("2100", "Rincian Kas Dan Setara Kas"),
	LB_2200 ("2200", "Rincian Penempatan Pada Bank"),
	LB_2300 ("2300", "Rincian Surat Berharga Syariah yang Dimiliki"),
	LB_2400 ("2400", "Rincian Pembiayaan yang Diberikan"),
	LB_2500 ("2500", "Rincian Aset Ijarah"),
	LB_2600 ("2600", "Rincian Surat Berharga Syariah yang Diterbitkan"),
	LB_2700 ("2700", "Rincian Pendanaan yang Diterima"),
	LB_2800 ("2800", "Rincian Cadangan Kerugian Penurunan Nilai (CKPN) Asset Keuangan"),
	LB_2900 ("2900", "Laporan Sumber dan Penggunaan Dana Kebajikan"),
	;

	@Getter
	private String code;
	@Getter
	private String name;
}
