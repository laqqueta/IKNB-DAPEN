package id.go.ojk.asrjk.client.builder.field.apu.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5000PosApuAsrjk01 implements IObject<KeyValueString> {
//	R_0101000000 ("0101000000", "I. Jenis Nasabah"),
//	R_0101010000 ("0101010000", "1. Nasabah Orang Perorangan (Individu)"),
	R_0101010100 ("0101010100", "a. WNI"),
	R_0101010200 ("0101010200", "b. WNA"),
//	R_0101020000 ("0101020000", "2. Nasabah Korporasi"),
	R_0101020100 ("0101020100", "a. Domestik"),
	R_0101020200 ("0101020200", "b. Asing"),
//	R_0102000000 ("0102000000", "II. Jenis Pekerjaan Nasabah"),
//	R_0102010000 ("0102010000", "1. Nasabah Orang Perorangan (Individu)"),
	R_0102010100 ("0102010100", "a. Pengusaha"),
	R_0102010200 ("0102010200", "b. Pejabat Lembaga Legislatif dan Pemerintah"),
	R_0102010300 ("0102010300", "c. Pengurus Partai Politik"),
	R_0102010400 ("0102010400", "d. Pegawai Swasta (selain Pegawai Bank)"),
	R_0102010500 ("0102010500", "e. PNS/Pegawai BUMN"),
	R_0102010600 ("0102010600", "f. Ibu Rumah Tangga"),
	R_0102010700 ("0102010700", "g. Pegawai Bank (selain Bank Milik Pemerintah)"),
	R_0102010800 ("0102010800", "h. Pengurus Yayasan/LSM"),
	R_0102010900 ("0102010900", "i. Pelajar"),
	R_0102011000 ("0102011000", "j. Profesional dan Konsultan (contoh: pengacara, arsitek, dll.)"),
	R_0102011100 ("0102011100", "k. Lainnya"),
//	R_0102020000 ("0102020000", "2. Nasabah Korporasi"),
	R_0102020100 ("0102020100", "a. Yayasan/LSM"),
	R_0102020200 ("0102020200", "b. Perusahaan Swasta"),
	R_0102020300 ("0102020300", "c. UKM/UMKM"),
	R_0102020400 ("0102020400", "d. Badan Usaha Milik Negara (BUMN)"),
	R_0102020500 ("0102020500", "e. Lainnya"),
//	R_0103000000 ("0103000000", "III. Politically Exposed Person (PEP)"),
	R_0103000100 ("0103000100", "a. Lokal"),
	R_0103000200 ("0103000200", "b. Asing"),
//	R_0104000000 ("0104000000", "IV. Area Geografis"),
	R_0104000100 ("0104000100", "a. Provinsi Aceh  "),
	R_0104000200 ("0104000200", "b. Provinsi Sumatera Utara  "),
	R_0104000300 ("0104000300", "c. Provinsi Sumatera Barat  "),
	R_0104000400 ("0104000400", "d. Provinsi Riau  "),
	R_0104000500 ("0104000500", "e. Provinsi Kepulauan Riau  "),
	R_0104000600 ("0104000600", "f. Provinsi Jambi  "),
	R_0104000700 ("0104000700", "g. Provinsi Bengkulu  "),
	R_0104000800 ("0104000800", "h. Provinsi Sumatera Selatan  "),
	R_0104000900 ("0104000900", "i. Provinsi Kepulauan Bangka Belitung  "),
	R_0104001000 ("0104001000", "j. Provinsi Lampung  "),
	R_0104001100 ("0104001100", "k. Provinsi Banten  "),
	R_0104001200 ("0104001200", "l. Provinsi Jawa Barat  "),
	R_0104001300 ("0104001300", "m. Provinsi DKI Jakarta  "),
	R_0104001400 ("0104001400", "n. Provinsi Jawa Tengah  "),
	R_0104001500 ("0104001500", "o. Provinsi Daerah Istimewa Yogyakarta  "),
	R_0104001600 ("0104001600", "p. Provinsi Jawa Timur  "),
	R_0104001700 ("0104001700", "q. Provinsi Kalimantan Barat  "),
	R_0104001800 ("0104001800", "r. Provinsi Kalimantan Tengah  "),
	R_0104001900 ("0104001900", "s. Provinsi Kalimantan Selatan  "),
	R_0104002000 ("0104002000", "t. Provinsi Kalimantan Timur  "),
	R_0104002100 ("0104002100", "u. Provinsi Kalimantan Utara  "),
	R_0104002200 ("0104002200", "v. Provinsi Bali  "),
	R_0104002300 ("0104002300", "w. Provinsi Nusa Tenggara Barat  "),
	R_0104002400 ("0104002400", "x. Provinsi Nusa Tenggara Timur  "),
	R_0104002500 ("0104002500", "y. Provinsi Sulawesi Utara  "),
	R_0104002600 ("0104002600", "z. Provinsi Sulawesi Barat  "),
	R_0104002700 ("0104002700", "aa. Provinsi Sulawesi Tengah  "),
	R_0104002800 ("0104002800", "ab. Provinsi Sulawesi Selatan  "),
	R_0104002900 ("0104002900", "ac. Provinsi Sulawesi Tenggara  "),
	R_0104003000 ("0104003000", "ad. Provinsi Gorontalo  "),
	R_0104003100 ("0104003100", "ae. Provinsi Maluku  "),
	R_0104003200 ("0104003200", "af. Provinsi Maluku Utara  "),
	R_0104003300 ("0104003300", "ag. Provinsi Papua  "),
	R_0104003400 ("0104003400", "ah. Provinsi Papua Barat  "),
//	R_0105000000 ("0105000000", "V. Produk Asuransi"),
//	R_0105010000 ("0105010000", "Kategorisasi Produk"),
	R_0105010100 ("0105010100", "1. Polis Surrender"),
//	R_0106000000 ("0106000000", "VI. Kategorisasi Risiko"),
	R_0106010000 ("0106010000", "1. Nasabah Berisiko Tinggi (High)"),
	R_0106020000 ("0106020000", "2. Nasabah Berisiko Sedang (Medium)"),
	R_0106030000 ("0106030000", "3. Nasabah Berisiko Rendah (Low)"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER5000PosApuAsrjk01 eEnum : ER5000PosApuAsrjk01.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER5000PosApuAsrjk01.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER5000PosApuAsrjk01.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
