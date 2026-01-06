package id.go.ojk.dplks.client.builder.field.apu.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5000PosApuDplks01 implements IObject<KeyValueString> {
//	R_0101000000000000 ("0101000000000000",  "I. PESERTA"),
//	R_0101010000000000 ("0101010000000000",  " A. Jenis Peserta"),
//	R_0101010100000000 ("0101010100000000",  "  1) Peserta Mandiri"),
	R_0101010101000000 ("0101010101000000",  "   a) Peserta WNI"),
	R_0101010102000000 ("0101010102000000",  "   b) Peserta WNA"),
//	R_0101010200000000 ("0101010200000000",  "  2) Korporasi yang Menjadi Peserta Kelompok"),
//	R_0101010201000000 ("0101010201000000",  "   a) Kelompok Berupa Korporasi Domestik (Dalam Negeri)"),
//	R_0101010201010000 ("0101010201010000",  "    i) Peserta WNI"),
	R_0101010201010100 ("0101010201010100",  "     a. Peserta WNI yang bisa top up mandiri"),
	R_0101010201010200 ("0101010201010200",  "     b. Peserta WNI yang tidak bisa top up mandiri"),
//	R_0101010201020000 ("0101010201020000",  "    ii) Peserta WNA"),
	R_0101010201020100 ("0101010201020100",  "     a. Peserta WNA yang bisa top up mandiri"),
	R_0101010201020200 ("0101010201020200",  "     b. Peserta WNA yang tidak bisa top up mandiri"),
//	R_0101010202000000 ("0101010202000000",  "   b) Kelompok Berupa Korporasi Asing"),
//	R_0101010202010000 ("0101010202010000",  "    i) Peserta WNI"),
	R_0101010202010100 ("0101010202010100",  "     a. Peserta WNI yang bisa top up mandiri"),
	R_0101010202010200 ("0101010202010200",  "     b. Peserta WNI yang tidak bisa top up mandiri"),
//	R_0101010202020000 ("0101010202020000",  "    ii) Peserta WNA"),
	R_0101010202020100 ("0101010202020100",  "     a. Peserta WNA yang bisa top up mandiri"),
	R_0101010202020200 ("0101010202020200",  "     b. Peserta WNA yang tidak bisa top up mandiri"),
//	R_0101020000000000 ("0101020000000000",  " B. Tingkat Risiko Peserta"),
//	R_0101020100000000 ("0101020100000000",  "  1) Peserta Berisiko Tinggi"),
//	R_0101020101000000 ("0101020101000000",  "   a) Peserta Mandiri yang Tergolong PEP"),
	R_0101020101010000 ("0101020101010000",  "i) PEP Domestik (Dalam Negeri)"),
	R_0101020101020000 ("0101020101020000",  "ii) PEP Asing"),
	R_0101020101030000 ("0101020101030000",  "iii) Orang yang Diberi Kewenangan untuk Melakukan Fungsi Penting (Prominent Function) oleh Organisasi Internasional"),
//	R_0101020102000000 ("0101020102000000",  "   b) Peserta Berisiko Tinggi Selain PEP"),
//	R_0101020102010000 ("0101020102010000",  "    i) Peserta Mandiri yang Berisiko Tinggi"),
	R_0101020102010100 ("0101020102010100",  "     a. WNI yang Berisiko Tinggi"),
	R_0101020102010200 ("0101020102010200",  "     b. WNA yang Berisiko Tinggi"),
//	R_0101020102020000 ("0101020102020000",  "    ii) Peserta Kelompok berupa Korporasi yang Berisiko Tinggi"),
//	R_0101020102020100 ("0101020102020100",  "     a. Peserta Kelompok berupa Korporasi Domestik (Dalam Negeri) yang Berisiko Tinggi"),
	R_0101020102020101 ("0101020102020101",  "      (1) Peserta WNI dalam Kelompok Berupa Korporasi Domestik (Dalam Negeri) yang Berisiko Tinggi"),
	R_0101020102020102 ("0101020102020102",  "      (2) Peserta WNA dalam Kelompok Berupa Korporasi Domestik (Dalam Negeri) yang Berisiko Tinggi"),
//	R_0101020102020200 ("0101020102020200",  "     b. Peserta Kelompok berupa Korporasi Asing yang Berisiko Tinggi"),
	R_0101020102020201 ("0101020102020201",  "      (1) Peserta WNI dalam Kelompok Berupa Korporasi Asing yang Berisiko Tinggi"),
	R_0101020102020202 ("0101020102020202",  "      (2) Peserta WNA dalam Kelompok Berupa Korporasi Asing yang Berisiko Tinggi"),
//	R_0101020200000000 ("0101020200000000",  "  2) Peserta Berisiko Menengah"),
//	R_0101020201000000 ("0101020201000000",  "   a) Peserta Mandiri yang Berisiko Menengah"),
	R_0101020201010000 ("0101020201010000",  "    i) WNI yang Berisiko Menengah"),
	R_0101020201020000 ("0101020201020000",  "    ii) WNA yang BerisikoMenengah"),
//	R_0101020202000000 ("0101020202000000",  "   b) Peserta Kelompok berupa Korporasi yang Berisiko Menengah"),
//	R_0101020202010000 ("0101020202010000",  "    i) Peserta Kelompok berupa Korporasi Domestik (Dalam Negeri) yang Berisiko Menengah"),
	R_0101020202010100 ("0101020202010100",  "     a. Peserta WNI dalam Kelompok Berupa Korporasi Domestik (Dalam Negeri) yang Berisiko Menengah"),
	R_0101020202010200 ("0101020202010200",  "     b. Peserta WNA dalam Kelompok Berupa Korporasi Domestik (Dalam Negeri) yang Berisiko Menengah"),
//	R_0101020202020000 ("0101020202020000",  "    ii) Peserta Kelompok berupa Korporasi Asing yang Berisiko Menengah"),
	R_0101020202020100 ("0101020202020100",  "a. Peserta WNI dalam Kelompok Berupa Korporasi Asing yang Berisiko Menengah"),
	R_0101020202020200 ("0101020202020200",  "     b. Peserta WNA dalam Kelompok Berupa Korporasi Asing yang Berisiko Menengah"),
//	R_0101020300000000 ("0101020300000000",  "  3) Peserta Berisiko Rendah"),
//	R_0101020301000000 ("0101020301000000",  "   a) Peserta Mandiri yang Berisiko Rendah"),
	R_0101020301010000 ("0101020301010000",  "    i) WNI yang Berisiko Rendah"),
	R_0101020301020000 ("0101020301020000",  "    ii) WNA yang Berisiko Rendah"),
//	R_0101020302000000 ("0101020302000000",  "   b) Peserta Kelompok berupa Korporasi yang Berisiko Rendah"),
//	R_0101020302010000 ("0101020302010000",  "    i) Peserta Kelompok berupa Korporasi Domestik (Dalam Negeri) yang Berisiko Rendah"),
	R_0101020302010100 ("0101020302010100",  "     a. Peserta WNI dalam Kelompok Berupa Korporasi Domestik (Dalam Negeri) yang Berisiko Rendah"),
	R_0101020302010200 ("0101020302010200",  "     b. Jumlah Peserta WNA dalam Kelompok Berupa Korporasi Domestik (Dalam Negeri) yang Berisiko Rendah"),
//	R_0101020302020000 ("0101020302020000",  "    ii) Peserta Kelompok berupa Korporasi Asing yang Berisiko Rendah"),
	R_0101020302020100 ("0101020302020100",  "     a. Peserta WNI dalam Kelompok Berupa Korporasi Asing yang Berisiko Rendah"),
	R_0101020302020200 ("0101020302020200",  "     b. Peserta WNA dalam Kelompok Berupa Korporasi Asing yang Berisiko Rendah"),
//	R_0102000000000000 ("0102000000000000",  "II. MANFAAT PENSIUN DAN PENARIKAN IURAN"),
//	R_0102010000000000 ("0102010000000000",  " A. Manfaat Pensiun"),
//	R_0102010100000000 ("0102010100000000",  "  1) Peserta Mandiri"),
	R_0102010101000000 ("0102010101000000",  "a) Manfaat Pensiun Sekaligus"),
	R_0102010102000000 ("0102010102000000",  "b) Manfaat Pensiun Anuitas"),
//	R_0102010200000000 ("0102010200000000",  "  2) Peserta Kelompok"),
	R_0102010201000000 ("0102010201000000",  "   a) Manfaat Pensiun Sekaligus"),
	R_0102010202000000 ("0102010202000000",  "   b) Manfaat Pensiun Anuitas"),
//	R_0102020000000000 ("0102020000000000",  " B. Penarikan Iuran"),
	R_0102020100000000 ("0102020100000000",  "  1) Peserta Mandiri"),
	R_0102020200000000 ("0102020200000000",  "  2) Peserta Kelompok"),
//	R_0103000000000000 ("0103000000000000",  "III. SALURAN DISTRIBUSI"),
//	R_0103010000000000 ("0103010000000000",  "A. Tatap Muka"),
	R_0103010100000000 ("0103010100000000",  "1) Pembayaran melalui Kasir/Counter di Kantor DPLK"),
	R_0103010200000000 ("0103010200000000",  "2) Pembayaran melalui Cara Tatap Muka Lainnya"),
//	R_0103020000000000 ("0103020000000000",  "B. Tidak Tatap Muka"),
	R_0103020100000000 ("0103020100000000",  " 1) Pembayaran melalui Transfer Bank"),
	R_0103020200000000 ("0103020200000000",  " 2) Pembayaran melalui Autodebet Rekening Bank"),
	R_0103020300000000 ("0103020300000000",  " 3) Pembayaran melalui Virtual Account"),
	R_0103020400000000 ("0103020400000000",  " 4) Pembayaran melalui Cara Tidak Tatap Muka Lainnya"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER5000PosApuDplks01 eEnum : ER5000PosApuDplks01.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER5000PosApuDplks01.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER5000PosApuDplks01.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
