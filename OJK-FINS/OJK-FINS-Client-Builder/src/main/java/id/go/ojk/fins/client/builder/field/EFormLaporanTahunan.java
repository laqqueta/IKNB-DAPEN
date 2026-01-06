package id.go.ojk.fins.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLaporanTahunan {
	LT_0000("0000", "Profil Perusahaan"),
	LT_1100("1100", "Laporan Posisi Keuangan"),
	LT_1200("1200", "Lap Laba rugi"),
	LT_1201("1201", "Lap Perubahan Modal (ekuitas)"),
	LT_1300("1300", "Lap Arus Kas"),
	LT_8800("8800", "Catatan Atas Laporan Keuangan"),
	LT_2111("2111", "Rincian Kas dan Setara Kas"),
	LT_2112("2112", "Rincian Piutang Lancar Lainnya"),
	LT_2116("2116", "Rincian Aset Tak Berwujud"),
	LT_2113("2113", "Rincian Piutang Tidak Lancar Lainnya"),
	LT_2114("2114", "Rincian Utang Jangka Pendek Lainnya"),
	LT_2117("2117", "Rincian Biaya yang masih harus dibayar"),
	LT_2115("2115", "Rincian Utang Jangka Panjang Lainnya"),
	LT_2118("2118", "Rincian Beban Pemasaran dan Periklanan"),
	LT_2913("2913", "Rincian Beban Pengembangan dan Pemeliharaan IT"),
	LT_2119("2119", "Rincian Pendapatan Non Operasional"),
	LT_2310("2310", "Rincian Laporan Arus Kas"),
	;
	
	@Getter
	private String code;
	@Getter
	private String name;
}
