package id.go.ojk.dplkk.client.builder.field.apu.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5001PosApuDplkk02 implements IObject<KeyValueString> {
//	R_0201000000 ("0201000000", "1. PENGAWASAN AKTIF DIREKSI DAN DEWAN KOMISARIS"),
	R_0201010000 ("0201010000", "PADK 1.  Keikutsertaan Direksi dan Dewan Komisaris dalam mereview dan memberikan persetujuan atas penyusunan setiap kebijakan-kebijakan terkait program penerapan APU dan PPT"),
	R_0201020000 ("0201020000", "PADK 2.  Penunjukan dan penetapan pejabat atau unit yang bertanggung jawab atas penerapan program APU dan PPT oleh  Direksi"),
	R_0201030000 ("0201030000", "PADK 3.  Pemahaman Direksi yang cukup terhadap risiko APU dan PPT"),
	R_0201040000 ("0201040000", "PADK 4. Pengawasan yang dilakukan oleh Direksi dan Komisaris terhadap pengendalian risiko APU-PPT"),
	R_0201050000 ("0201050000", "PADK 5.Keterlibatan Direksi dalam penanganan atau tindak lanjut hasil analisis atas LTKM dan LTKT yang dilaporkan kepada PPATK"),
	R_0201060000 ("0201060000", "PADK 6. Evaluasi berkala oleh Direksi dan Dewan Komisaris atas penerapan program APU dan PPT"),
//	R_0202000000 ("0202000000", "2. KEBIJAKAN DAN PROSEDUR"),
	R_0202010000 ("0202010000", "KP 1. Kecukupan kebijakan dan prosedur penerapan program APU dan PPT"),
	R_0202020000 ("0202020000", "KP 2. Kecukupan kebijakan penilaian risiko APU dan PPT yang mencakup risiko nasabah, produk atau jasa, area geografis dan jaringan distribusi (distribution channel)"),
	R_0202030000 ("0202030000", "KP 3. Kecukupan kebijakan terkait proses analisis dan tata cara penetapan LTKM dan/atau LTKT serta pelaporan kepada PPATK "),
	R_0202040000 ("0202040000", "KP 4. Efektivitas pelaksanaan CDD sederhana, CDD, dan EDD terhadap calon Peserta"),
	R_0202050000 ("0202050000", "KP 5. Efektivitas tindak lanjut hasil identifikasi dan verifikasi calon debitur/debitur antara lain mencakup penerimaan/penolakan Calon Peserta dan/atau pengkinian data Peserta "),
	R_0202060000 ("0202060000", "KP 6. Efektivitas penilaian atas TKM dan TKT yang wajib dilaporkan kepada PPATK"),
//	R_0203000000 ("0203000000", "3. PENGENDALIAN INTERN"),
	R_0203010000 ("0203010000", "PI 1. Kecukupan organisasi pengendalian internal antara lain adanya batasan wewenang dan tanggung jawab antara first line, second line, dan third line of defense dalam penerapan program APU dan PPT"),
	R_0203020000 ("0203020000", "PI 2. Kecukupun akses informasi yang dimiliki oleh pejabat atau unit APU dan PPT serta satuan kerja audit internal"),
	R_0203030000 ("0203030000", "PI 3. Efektivitas pelaksanaan program audit internal terkait program APU dan PPT, antara lain mencakup penentuan prioritas pemeriksaan berdasarkan hasil penilaian risiko, kebijakan uji petik, dan kedalaman hasil pemeriksaan"),
	R_0203040000 ("0203040000", "PI 4. Efektivitas pelaksanaan evaluasi secara independen oleh satuan kerja audit internal terkait dengan penerapan program APU dan PPT"),
//	R_0204000000 ("0204000000", "4. SISTEM INFORMASI MANAJEMEN"),
	R_0204010000 ("0204010000", "SIM 1. Kecukupan Sistem Informasi dalam memantau dan pengkinian data Debitur terkait penerapan APU dan PPT"),
	R_0204020000 ("0204020000", "SIM 2. Kecukupan Sistem Informasi dalam memantau dan menganalisis transaksi yang berindikasikan risiko pencucian uang dan pendanaan terorisme"),
//	R_0204030000 ("0204030000", "SISTEM MANAJEMEN RISIKO"),
	R_0204040000 ("0204040000", "SIM 3. Kecukupan informasi atau database nasabah antara lain, terkait nasabah berisiko tinggi, Nasabah PEP, Nasabah terduga terorisme serta terlibat dalam pendanaan poliferasi senjata pemunah massal"),
	R_0204050000 ("0204050000", "SIM 4. Efektifitas pengelolaan dan pemeliharaan database Peserta dan transaksi antara lain dalam pengkinian data, pemantauan Peserta, dan analisis transaksi Peserta"),
	R_0204060000 ("0204060000", "SIM 5. Kecukupan sistem informasi dalam menyajikan laporan secara berkala kepada Direksi dan Dewan Komisaris serta pelaporan kepada PPATK terkait LTKM dan LTKT"),
//	R_0205000000 ("0205000000", "5. SUMBER DAYA MANUSIA DAN PELATIHAN"),
	R_0205010000 ("0205010000", "SDM 1. Kecukupan prosedur penerimaan pegawai dengan melakukan analisa profil pegawai"),
	R_0205020000 ("0205020000", "SDM 2. Kecukupan program pelatihan terhadap pejabat atau pegawai yang bertanggung jawab dalam pelaksanaan program APU dan PPT serta seluruh pegawai yang terlibat dalam pelaksanaan program APU dan PPT"),
	R_0205030000 ("0205030000", "SDM 3. Kecukupan materi pelatihan yang mencakup, antara lain mengenai seluruh kebijakan program APU dan PPT Perusahaan serta teknik, metode, dan modus atau tipologi pencucian uang dan/atau pendanaan terorisme"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER5001PosApuDplkk02 eEnum : ER5001PosApuDplkk02.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER5001PosApuDplkk02.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER5001PosApuDplkk02.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static FieldValidation genValidationPenilaian() {
		return UtilFieldValidation.genEqualsFixedValue("1|2|3|4|5");
	}
}
