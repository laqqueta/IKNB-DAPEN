package id.go.ojk.gdk.client.builder.field.apu.reference;

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
public enum ER5001PosApuGdk02 implements IObject<KeyValueString> {
//	R_0201000000 ("0201000000", "1. PENGAWASAN AKTIF DIREKSI DAN DEWAN KOMISARIS"),
	R_0201010000 ("0201010000", "PADK 1. Apakah dalam Pedoman Kebijakan Penerapan Program APU dan PPT telah terdapat tanda tangan pengesahan Direksi Perusahaan?"),
	R_0201020000 ("0201020000", "PADK 2. Apakah dalam Pedoman Kebijakan Penerapan Program APU dan PPT telah terdapat tanda tangan persetujuan Dewan Komisaris Perusahaan?"),
	R_0201030000 ("0201030000", "PADK 3. Apakah terdapat Surat Keputusan Direksi mengenai penunjukan pejabat atau pembentukan Unit Kerja Khusus sebagai penanggung jawab atas penerapan Program APU dan PPT?"),
	R_0201040000 ("0201040000", "PADK 4. Apakah Direksi pernah memberikan arahan kepada fungsi internal audit untuk dilakukan  pemeriksaan atas kepatuhan unit kerja di Perusahaan dalam menerapkan Program APU dan PPT ?"),
	R_0201050000 ("0201050000", "PADK 5. Apakah Direksi menetapkan rencana pelatihan bagi pegawai satuan terkait dan pegawai baru berkenaan dengan penerapan program APU dan PPT secara periodik?"),
	R_0201060000 ("0201060000", "PADK 6. Apakah pejabat atau pimpinan pada Unit Kerja Khusus yang bertanggung jawab atas penerapan program APU dan PPT dirangkap oleh fungsi internal audit atau fungsi-fungsi lain selain fungsi kepatuhan dan manajemen risiko?"),
	R_0201070000 ("0201070000", "PADK 7. Apakah pernah dilakukan pembahasan terkait dengan penerapan program APU dan PPT dalam rapat-rapat Direksi atau Komisaris?"),
	R_0201080000 ("0201080000", "PADK 8. Apakah Direksi telah menetapkan pedoman penilaian risiko APU dan PPT?"),
	R_0201090000 ("0201090000", "PADK 9. Apakah Perusahaan pernah mengidentifikasikan Transaksi Keuangan Mencurigakan (TKM) pada saat melakukan transaksi dengan debitur?"),
	R_0201100000 ("0201100000", "PADK 10. Apakah Perusahaan pernah menerima Transaksi Keuangan Tunai (TKT) lebih dari Rp500 juta dalam sehari oleh debitur?  "),
	R_0201110000 ("0201110000", "PADK 11. Apakah TKM dan TKT tersebut dilaporkan ke PPATK dan telah mendapatkan persetujuan Direks untuk dilaporkan?"),
	R_0201120000 ("0201120000", "PADK 12. Apakah Perusahaan telah melakukan pendaftaran pada sistem pelaporan PPATK?"),
//	R_0202000000 ("0202000000", "2. KEBIJAKAN DAN PROSEDUR"),
	R_0202010000 ("0202010000", "KP 1. Apakah dalam pedoman/kebijakan penerapan program APU dan PPT Perusahaan telah tercantum kebijakan mengenai identifikasi dan verifikasi nasabah?"),
	R_0202020000 ("0202020000", "KP 2. Apakah dalam pedoman/kebijakan penerapan program APU dan PPT Perusahaan telah tercantum kebijakan mengenai identifikasi dan verifikasi Beneficial Owner (BO)?"),
	R_0202030000 ("0202030000", "KP 3. Apakah dalam pedoman/kebijakan penerapan program APU dan PPT Perusahaan telah tercantum kebijakan mengenai penutupan hubungan usaha atau penolakan transaksi? "),
	R_0202040000 ("0202040000", "KP 4. Apakah dalam pedoman/kebijakan penerapan program APU dan PPT Perusahaan telah tercantum kebijakan mengenai pengelolaan risiko pencucian uang dan/atau pendanaan terorisme yang berkelanjutan terkait nasabah, negara, produk dan jasa, serta jaringan distribusi (distribution channel)? "),
	R_0202050000 ("0202050000", "KP 5. Apakah dalam pedoman/kebijakan penerapan program APU dan PPT Perusahaan telah tercantum kebijakan mengenai pemeliharaan data yang akurat terkait dengan transaksi, penatausahaan proses CDD, dan penatausahaan kebijakan dan prosedur? "),
	R_0202060000 ("0202060000", "KP 6. Apakah dalam pedoman/kebijakan penerapan program APU dan PPT Perusahaan telah tercantum kebijakan mengenai pengkinian dan pemantauan?"),
	R_0202070000 ("0202070000", "KP 7. Apakah dalam pedoman/kebijakan penerapan program APU dan PPT Perusahaan telah tercantum kebijakan mengenai pelaporan kepada Direksi dan Dewan Komisaris terkait penerapan program APU dan PPT?"),
	R_0202080000 ("0202080000", "KP 8. Apakah dalam pedoman/kebijakan penerapan program APU dan PPT Perusahaan telah tercantum kebijakan mengenai pelaporan TKM dan TKT kepada PPATK? "),
	R_0202090000 ("0202090000", "KP 9. Apakah Perusahaan telah mengelompokkan Nasabah berisiko tinggi?"),
	R_0202100000 ("0202100000", "KP 10. Apakah Perusahaan memiliki daftar konsumen yang tergolong sebagai Politically Exposed Person (PEP) termasuk anggota keluarga dan pihak-pihak yang terkait dengan PEP?"),
	R_0202110000 ("0202110000", "KP 11. Apakah Perusahaan memiliki daftar calon konsumen/konsumen yang ditolak atau dibatalkan pengajuan pembiayaannya?"),
	R_0202120000 ("0202120000", "KP 12. Apakah Perusahaan telah memiliki Daftar terduga teroris dan melakukan update terkait daftar terduga teroris yang bersumber dari pihak yang berwenang?"),
	R_0202130000 ("0202130000", "KP 13. Apakah dalam formulir permohonan pembiayaan saudara telah memuat persyaratan minimal data dan informasi sebagaimana dimaksud dalam Pasal 20, 21, Pasal 22, Pasal 23, Pasal 24, dan Pasal 28 Peraturan Otoritas Jasa Keuangan Nomor 12/POJK.01/2017 sebagaimana telah diubah dengan POJK No. 23/POJK.01/2019?"),
//	R_0203000000 ("0203000000", "3. PENGENDALIAN INTERN"),
	R_0203010000 ("0203010000", "PI 1. Apakah Perusahaan telah melakukan pemeriksaan secara independen (audit internal) untuk memastikan efektivitas penerapan program APU dan PPT?"),
	R_0203020000 ("0203020000", "PI 2. Apakah pemeriksaan terkait aspek penerapan program APU dan PPT dilakukan setiap tahun?"),
	R_0203030000 ("0203030000", "PI 3. Apakah audit internal terkait penerapan program APU dan PPT dilakukan berdasarkan risk based?"),
	R_0203040000 ("0203040000", "PI 4. Bagaimana mekanisme pelaporan hasil temuan audit?"),
//	R_0204000000 ("0204000000", "4. SISTEM INFORMASI MANAJEMEN"),
	R_0204010000 ("0204010000", "SIM 1. Apakah Perusahaan telah memiliki sistem informasi yang dapat mengidentifikasi, menganalisa, memantau dan menyediakan laporan secara efektif mengenai karakteristik transaksi yang dilakukan oleh Nasabah? Jelaskan sistem yang digunakan Perusahaan dalam penerapan program APU dan PPT?"),
	R_0204020000 ("0204020000", "SIM 2. Apakah Perusahaan telah mengintegrasikan nama-nama yang terdaftar dalam daftar terduga teroris yang diterbitkan pihak berwenang dalam sistem Perusahaan, sehingga memungkinkan Perusahaan dapat memantau kemiripan/kesamaan identitas terduga teroris dengan calon nasabah?"),
//	R_0204030000 ("0204030000", "SISTEM MANAJEMEN RISIKO"),
	R_0204040000 ("0204040000", "SIM 3. Apakah sistem yang dimiliki Perusahaan telah memungkinkan Perusahaan untuk menginput atau menyediakan informasi berkenaan dengan profil pekerjaan calon nasabah/nasabah yang termasuk dalam kategori Politically Exposed Person (PEP) antara lain profil pekerjaan sebagai pejabat eksekutif (gubernur, walikota, sekda, kapolda, dll), pejabat legislatif (anggota DPR/DPRD/DPD), pajabat partai politik (ketua partai, sekretaris partai, bendahara partai, dll)?"),
//	R_0205000000 ("0205000000", "5. SUMBER DAYA MANUSIA DAN PELATIHAN"),
	R_0205010000 ("0205010000", "SDM 1. Apakah Perusahaan telah memiliki prosedur penyaringan dalam rangka penerimaan karyawan baru (pre employee screening) dan pemantauan terhadap profil karyawan?"),
	R_0205020000 ("0205020000", "SDM 2. Apakah Perusahaan mengikutsertakan karyawan/pejabat dalam pelatihan terkait APU dan PPT setiap tahun? Berapa jumlah pelatihan APU dan PPT yang dilaksanakan setiap tahunnya?"),
	R_0205030000 ("0205030000", "SDM 3. Apakah pelatihan terkait APU dan PPT yang dilakukan telah menjelaskan penerapan ketentuan peraturan perundang-undangan yang terkait dengan program APU dan PPT; teknik, metode, dan tipologi Pencucian Uang dan/atau Pendanaan Terorisme; dan kebijakan dan prosedur penerapan program APU dan PPT serta peran dan tanggung jawab pegawai dalam mencegah dan memberantas Pencucian Uang dan/atau Pendanaan Terorisme?"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER5001PosApuGdk02 eEnum : ER5001PosApuGdk02.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER5001PosApuGdk02.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER5001PosApuGdk02.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static FieldValidation genValidationPenilaian() {
		return UtilFieldValidation.genEqualsFixedValue("1|2|3|4|5");
	}
}
