package id.go.ojk.pps.client.builder.field.apu.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5000PosApuPps01 implements IObject<KeyValueString> {
//	R_0101000000000000 ("0101000000000000", "I. NASABAH"),
//	R_0101010000000000 ("0101010000000000", " A. Jenis Nasabah"),
//	R_0101010100000000 ("0101010100000000", "  1) Nasabah Orang Perseroangan"),
//	R_0101010101000000 ("0101010101000000", "     a) Nasabah Orang Perseroangan WNI"),
	R_0101010101010000 ("0101010101010000", "      i) Nasabah WNI yang bertindak untuk dan atas nama/kepentingan sendiri"),
	R_0101010101020000 ("0101010101020000", "      ii) Nasabah WNI yang memiliki Beneficial Owner"),
//	R_0101010102000000 ("0101010102000000", "b) Nasabah Orang Perseroangan WNA"),
	R_0101010102010000 ("0101010102010000", "      i) Nasabah WNA yang bertindak untuk dan atas nama/kepentingan sendiri"),
	R_0101010102020000 ("0101010102020000", "      ii) Nasabah WNA yang memiliki Beneficial Owner"),
//	R_0101010200000000 ("0101010200000000", "  2) Nasabah Korporasi"),
	R_0101010201000000 ("0101010201000000", "     a) Nasabah Berbentuk Korporasi Domestik (Dalam Negeri)"),
	R_0101010202000000 ("0101010202000000", "b) Nasabah Berbentuk Korporasi Asing"),
//	R_0101020000000000 ("0101020000000000", "B. Tingkat Risiko Nasabah"),
//	R_0101020100000000 ("0101020100000000", "  1) Nasabah Berisiko Tinggi"),
//	R_0101020101000000 ("0101020101000000", " a) Nasabah Orang Perseorangan yang Tergolong PEP"),
	R_0101020101010000 ("0101020101010000", "  i) PEP Domestik (Dalam Negeri)"),
	R_0101020101020000 ("0101020101020000", "  ii) PEP Asing"),
	R_0101020101030000 ("0101020101030000", "  iii) Orang yang Diberi Kewenangan untuk Melakukan Fungsi Penting (Prominent Function) oleh Organisasi Internasional"),
//	R_0101020102000000 ("0101020102000000", " b) Nasabah Berisiko Tinggi Selain PEP"),
//	R_0101020102010000 ("0101020102010000", "  i) Nasabah Orang Perseorangan yang Berisiko Tinggi"),
	R_0101020102010100 ("0101020102010100", "   a. Nasabah WNI yang Berisiko Tinggi"),
	R_0101020102010200 ("0101020102010200", "   b. Nasabah WNA yang Berisiko Tinggi"),
//	R_0101020102020000 ("0101020102020000", "  ii) Nasabah Korporasi yang Berisiko Tinggi"),
	R_0101020102020100 ("0101020102020100", "   a. Nasabah Korporasi Domestik (Dalam Negeri) yang Berisiko Tinggi"),
	R_0101020102020200 ("0101020102020200", "   b. Nasabah Korporasi Asing yang Berisiko Tinggi"),
//	R_0101020200000000 ("0101020200000000", "2) Nasabah Berisiko Menengah"),
//	R_0101020201000000 ("0101020201000000", "     a) Nasabah Orang Perseorangan yang Berisiko Menengah"),
	R_0101020201010000 ("0101020201010000", "      i) Nasabah WNI yang Berisiko Menengah"),
	R_0101020201020000 ("0101020201020000", "  ii) Nasabah WNA yang Berisiko Menengah"),
//	R_0101020202000000 ("0101020202000000", "  b) Nasabah Korporasi yang Berisiko Menengah"),
	R_0101020202010000 ("0101020202010000", "   i) Nasabah Korporasi Domestik (Dalam Negeri) yang Berisiko Menengah"),
	R_0101020202020000 ("0101020202020000", "   ii) Nasabah Korporasi Asing yang Berisiko Menengah"),
//	R_0101020300000000 ("0101020300000000", "  3) Nasabah Berisiko Rendah"),
//	R_0101020301000000 ("0101020301000000", "  a) Nasabah Orang Perseorangan yang Berisiko Rendah"),
	R_0101020301010000 ("0101020301010000", "i) Nasabah WNI yang Berisiko Rendah"),
	R_0101020301020000 ("0101020301020000", "ii) Nasabah WNA yang Berisiko Rendah"),
//	R_0101020302000000 ("0101020302000000", "  b) Nasabah Korporasi yang Berisiko Rendah"),
	R_0101020302010000 ("0101020302010000", "i) Nasabah Korporasi Domestik (Dalam Negeri) yang Berisiko Rendah"),
	R_0101020302020000 ("0101020302020000", "ii) Nasabah Korporasi Asing yang Berisiko Rendah"),
//	R_0102000000000000 ("0102000000000000", "II. SALURAN DISTRIBUSI"),
//	R_0102010000000000 ("0102010000000000", " A. Tatap Muka"),
	R_0102010100000000 ("0102010100000000", "  1) Pembayaran melalui Kasir/Counter di Kantor Perusahaan Modal Ventura"),
//	R_0103010200000000 ("0103010200000000", "  2) Pembayaran melalui Cara Tatap Muka Lainnya:"),
	R_0103010201000000 ("0103010201000000", "  a) Pegawai Melakukan Penagihan Kepada Konsumen Secara Langsung"),
	R_0103010202000000 ("0103010202000000", "b) EDC"),
	R_0103010203000000 ("0103010203000000", "c) Lainnya"),
//	R_0102020000000000 ("0102020000000000", " B. Tidak Tatap Muka"),
	R_0102020100000000 ("0102020100000000", "  1) Pembayaran melalui Transfer Bank"),
	R_0102020200000000 ("0102020200000000", "  2) Pembayaran melalui Autodebet Rekening Bank"),
	R_0102020300000000 ("0102020300000000", "  3) Pembayaran melalui Agen (Misalnya melalui minimarket, kantor pos, dll)"),
//	R_0102020400000000 ("0102020400000000", "  4) Pembayaran melalui Cara Tidak Tatap Muka Lainnya:"),
	R_0102020401000000 ("0102020401000000", "   a) virtual account"),
	R_0102020402000000 ("0102020402000000", "   b) Aplikasi web (tokopedia/ovo/link aja dll)"),
	R_0102020403000000 ("0102020403000000", "c) Lainnya"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER5000PosApuPps01 eEnum : ER5000PosApuPps01.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER5000PosApuPps01.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER5000PosApuPps01.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
