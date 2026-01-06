package id.go.ojk.pnjk.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLaporanBulanan {
	LB_0000 ("0000", "Profil Perusahaan Penjaminan"),
	LB_0020 ("0020", "Rincian Kantor Cabang"),
	LB_0030 ("0030", "Rincian Jumlah Pegawai"),
	LB_1000 ("1000", "Ikhtisar Laporan Bulanan"),
	LB_1100 ("1100", "Laporan Posisi Keuangan"),
	LB_1200 ("1200", "Laporan Laba Rugi Komprehensif"),
	LB_1300 ("1300", "Laporan Arus Kas"),
	LB_2100A1 ("2100A1", "Daftar Rincian Aset Investasi Deposito - Kategori Lancar"),
	LB_2100A2 ("2100A2", "Daftar Rincian Aset Investasi Deposito - Kategori Tidak Lancar"),
	LB_2100B1 ("2100B1", "Daftar Rincian Aset Investasi Surat Berharga-Kategori Lancar"),
	LB_2100B2 ("2100B2", "Daftar Rincian Aset Investasi Surat Berharga-Kategori Tidak Lancar"),
	LB_2100B3 ("2100B3", "Rekapitulasi Surat Berharga Negara"),
	LB_2100C1 ("2100C1", "Daftar Rincian Aset Investasi Tanah dan Bangunan-Kategori Lancar"),
	LB_2100C2 ("2100C2", "Daftar Rincian Aset Investasi Tanah dan Bangunan-Kategori Tidak Lancar"),
	LB_2100D1 ("2100D1", "Daftar Rincian Aset Investasi Penyertaan Langsung-Kategori Lancar"),
	LB_2100D2 ("2100D2", "Daftar Rincian Aset Investasi Penyertaan Langsung-Kategori Tidak Lancar"),
	LB_2200 ("2200", "Daftar Rincian Piutang IJP"),
	LB_2300 ("2300", "Daftar Rincian Piutang Co-Guarantee dan Reasuransi/Penjaminan Ulang"),
	LB_2400 ("2400", "Daftar Rincian Aset Lain-Lain"),
	LB_2500 ("2500", "Daftar Rincian Aset Tetap - Neto"),
	LB_2600 ("2600", "Daftar Rincian Utang Komisi"),
	LB_2700 ("2700", "Daftar Rincian Utang Klaim Co-Guarantee"),
	LB_2800 ("2800", "Daftar Rincian Utang IJP Co-Guarantee dan Reasuransi/Penjaminan Ulang"),
	LB_2900 ("2900", "Daftar Rincian Liabilitas Lain-Lain"),
	LB_3000 ("3000", "Daftar Rincian Obligasi Wajib Konversi"),
	LB_3100 ("3100", "Daftar Rincian Penjaminan"),
	LB_3200A ("3200A", "Daftar Rincian Laporan Klaim Penjaminan per Lokasi Terjamin - Penjamin Kredit"),
	LB_3200B ("3200B", "Daftar Rincian Laporan Klaim Penjaminan per Lokasi Terjamin - Penjamin Lainnya"),
	LB_3300A ("3300A", "Daftar Rincian Laporan Klaim Penjaminan per Lokasi Penerima Jaminan - Penjaminan Kredit"),
	LB_3300B ("3300B", "Daftar Rincian Laporan Klaim Penjaminan Per Lokasi Penerima Jaminan - Penjaminan Lainnya"),
	LB_3400A ("3400A", "Daftar Rincian Laporan Klaim Penjaminan per Sektor Ekonomi - Penjaminan Kredit"),
	LB_3400B ("3400B", "Daftar Rincian Laporan Klaim Penjaminan Per Sektor Ekonomi- Penjaminan Lainnya"),
	LB_3500A ("3500A", "Daftar Rincian Laporan Klaim Penjaminan per Status Klaim - Penjaminan Kredit"),
	LB_3500B ("3500B", "Daftar Rincian Laporan Klaim Penjaminan Per Status Klaim- Penjaminan Lainnya"),
	LB_4100 ("4100", "Laporan Analisis Kesesuaian Aset dan Liabilitas"),
	LB_5100 ("5100", "Daftar Kinerja Operasional Perusahaan Penjaminan"),
	LB_6100 ("6100", "Laporan Piutang Subrogasi"),
	LB_7100 ("7100", "Laporan Gearing Ratio"),
	LB_8100 ("8100", "Laporan Kualitas Penjaminan Kredit"),
	LB_9100 ("9100", "Laporan 10 Besar Non Performing Guarantee/NPG"),
	LB_9001 ("9001", "Catatan Penyampaian Laporan"),
	;
	
	@Getter
	private String code;
	@Getter
	private String name;
}
