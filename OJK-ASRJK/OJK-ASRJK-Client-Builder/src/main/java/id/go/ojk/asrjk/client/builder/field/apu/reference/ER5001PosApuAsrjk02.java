package id.go.ojk.asrjk.client.builder.field.apu.reference;

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
public enum ER5001PosApuAsrjk02 implements IObject<KeyValueString> {
//	R_0201000000 ("0201000000", "1. PENGAWASAN AKTIF DIREKSI DAN DEWAN KOMISARIS"),
	R_0201010000 ("0201010000", "PADK 1.  Apakah Perusahaan telah melakukan hal hal sebagai berikut: 1. Pendokumentasian penilaian risiko; 2. Pengukuran tingkat risiko dan mitigasi risiko 3. Pengkinian penilaian risiko secara berkala 4. Mekanisme yang memadai terkait penyediaan informasi penilaian risiko kepada instansi yang berwenan"),
	R_0201020000 ("0201020000", "PADK 2.  Apakah direksi dan dewan komisaris telah memberikan persetujuan atas kebijakan/pedoman penerapan program APU dan PPT Perusahaan?"),
	R_0201030000 ("0201030000", "PADK 3.  Apakah pembentukan unit kerja khusus dan/atau pejabat yang bertanggung jawab program APU dan PPT telah disetujui melalui surat keputusan direksi?"),
	R_0201040000 ("0201040000", "PADK 4. Apakah telah terdapat mekanisme pembahasan terkait penerapan program APU dan PPT dalam rapat direksi dan komisaris?"),
	R_0201050000 ("0201050000", "PADK 5. Apakah persyaratan  UKK dan  pejabat yang bertanggung jawab dalam penerapan program APU dan PPT telah sesuai dengan ketentuan POJK 12/POJK.01/2017 tentang Penerapan Program Anti Pencucian Uang dan Pencegahan Pendanaan Terorisme di Sektor Jasa Keuangan (POJK 12/2017)? "),
	R_0201060000 ("0201060000", "PADK 6. Apakah struktur organisasi Perusahaan telah memuat unit kerja khusus (UKK) atau pejabat sebagai penanggung jawab penerapan program APU dan PPT?"),
	R_0201070000 ("0201070000", "PADK 7. Apakah unit kerja khusus dan/atau pejabat yang bertanggung jawab atas penerapan program APU dan PPT memiliki sertifikasi atau  dokumentasi pelatihan terkait program APU dan PPT?"),
	R_0201080000 ("0201080000", "PADK 8.  Apakah penanggung jawab Program APU dan PPT memiliki hak akses sistem atas seluruh data nasabah?"),
	R_0201090000 ("0201090000", "PADK 9. Apakah Perusahaan pernah dikenakan sanksi terkait kewajiban penyampaian laporan sesuai dengan POJK 12/2017 oleh OJK?"),
//	R_0202000000 ("0202000000", "2. KEBIJAKAN DAN PROSEDUR"),
	R_0202010000 ("0202010000", "KP 1. Apakah Perusahaan telah memiliki kebijakan dan prosedur untuk mengelola dan memitigasi risiko TPPU dan TPPT yang diidentifikasikan sesuai dengan penilaian risiko? "),
	R_0202020000 ("0202020000", "KP 2. Apakah kebijakan dan prosedur tertulis terkait penerapan program APU dan PPT yang dimiliki Perusahaan telah disesuaikan dengan POJK 12/2017?"),
	R_0202030000 ("0202030000", "KP 3. Apakah penerapan kebijakan dan prosedur penerapan program APU dan PPT telah dilaksanakan secara konsisten dan berkesinambungan?"),
	R_0202040000 ("0202040000", "KP 4. Apakah Perusahaan telah mengidentifikasi dan melakukan penilaian risiko TPPU dan TPPT terkait dengan pengembangan produk dan praktik usaha baru sebelum produk, praktik usaha dan teknologi diluncurkan atau digunakan secara memadai?"),
	R_0202050000 ("0202050000", "KP 5. Apakah Perusahaan telah melakukan prosedur CDD yang memadai?"),
	R_0202060000 ("0202060000", "KP 6. Apakah PJK telah mengidentifikasi dan mengklasifikasikan Calon Nasabah atau Nasabah ke dalam kelompok orang perseorangan (natural person), Korporasi, dan perikatan lainnya (legal arrangement)?"),
	R_0202070000 ("0202070000", "KP 7. Apakah Perusahaan melakukan penolakan hubungan usaha apabila Calon Nasabah atau Nasabah menolak untuk mematuhi peraturan yang terkait dengan penerapan program APU dan PPT; atau PJK tidak dapat meyakini kebenaran identitas dan kelengkapan dokumen Calon Nasabah atau Nasabah?"),
	R_0202080000 ("0202080000", "KP 8. Apakah PJK telah  memahami profil, maksud dan tujuan hubungan usaha, dan transaksi yang dilakukan Nasabah dan Pemilik Manfaat (Beneficial Owner) melalui identifikasi dan verifikasi?"),
	R_0202090000 ("0202090000", "KP 9. Apakah PJK telah melakukan identifikasi dan verifikasi identitas BO sebagaimana pasal 28 POJK 12 dalam hal calon nasabah bukan merupakan pemilik manfaat?"),
	R_0202100000 ("0202100000", "KP 10. Apakah Perusahaan telah memiliki sistem manajemen risiko yang memadai untuk menentukan apakah Calon Nasabah, Nasabah, Pemilik Manfaat (Beneficial Owner), atau WIC termasuk kriteria berisiko tinggi?"),
	R_0202110000 ("0202110000", "KP 11. Apakah Perusahaan telah melakukan penilaian untuk menentukan Nasabah, Pemilik Manfaat (Beneficial Owner), atau WIC adalah PEP?"),
	R_0202120000 ("0202120000", "KP 12. Dalam hal Calon Nasabah, Nasabah, Pemilik Manfaat (Beneficial Owner), atau WIC tergolong berisiko tinggi, termasuk PEP, apakah Perusahaan telah melakukan EDD?"),
	R_0202130000 ("0202130000", "KP 13. Apakah Perusahaan telah menerapkan proses identifikasi (CDD maupun EDD) yang memadai terhadap PEP asing dan PEP domestik sesuai dengan ketentuan pasal 32 dan 33 POJK 12/2017?"),
	R_0202140000 ("0202140000", "KP 14. Apakah Perusahaan telah memiliki daftar tersendiri atas calon nasabah/nasabah/BO yang memenuhi kriteria berisiko tinggi"),
	R_0202150000 ("0202150000", "KP 15. Terkait hubungan usaha dengan nasabah dan/atau melakukan transaksi yang berasal negara berisiko tinggi yang dipublikasikan oleh FATF,  apakah PJK telah melakukan EDD dengan konfirmasi dan klarifikasi ke otoritas terkait?"),
	R_0202160000 ("0202160000", "KP 16. Apakah Perusahaan telah melakukan CDD terhadap penerima manfaat (beneficiary) untuk polis asuransi jiwa dan produk investasi lain terkait polis asuransi pada saat pembayaran klaim sesuai ketentuan pasal 37 s.d.39  POJK 12?"),
	R_0202170000 ("0202170000", "KP 17. Apakah Perusahaan memiliki kerjasama dengan pihak ketiga dalam hal pelaksanaan CDD? Apabila ada, apakah Pelaksanaan CDD terhadap pihak ketiga telah dilakukan secara memadai?"),
	R_0202180000 ("0202180000", "KP 18. Apakah Perusahaan telah melakukan pemantauan hubungan usaha dengan nasabah dengan memantau transaksi Nasabah, melakukan pengkinian data, serta mendokumentasikan upaya pengkinian data?"),
	R_0202190000 ("0202190000", "KP 19. Apakah Perusahaan melakukan analisis terhadap seluruh transaksi yang tidak sesuai dengan profil Nasabah?"),
	R_0202200000 ("0202200000", "KP 20. Apakah Perusahaan telah memiliki daftar terduga teroris dan organisasi teroris?"),
	R_0202210000 ("0202210000", "KP 21. Apakah Perusahaan telah menatausahakan dokumen yang terkait dengan data Nasabah secara periodik sesuai dengan ketentuan POJK 12/2017?"),
//	R_0203000000 ("0203000000", "3. PENGENDALIAN INTERN"),
	R_0203010000 ("0203010000", "PI 1. Apakah Perusahaan telah melakukan pemeriksaan secara independen (audit internal) untuk memastikan efektivitas penerapan program APU dan PPT?"),
	R_0203020000 ("0203020000", "PI 2. Apakah pemeriksaan terkait aspek penerapan program APU dan PPT dilakukan setiap tahun?"),
	R_0203030000 ("0203030000", "PI 3. Apakah audit internal terkait penerapan program APU dan PPT dilakukan berdasarkan risk based?"),
	R_0203040000 ("0203040000", "PI 4. Bagaimana mekanisme pelaporan hasil temuan audit?"),
//	R_0203050000 ("0203050000", "FUNGSI KEPATUHAN"),
	R_0203060000 ("0203060000", "PI 5. Apakah jumlah karyawan yang memiliki tugas dan fungsi untuk memastikan kepatuhan perusahaan terhadap ketentuan yang berlaku telah memadai?"),
	R_0203070000 ("0203070000", "PI 6. Apakah seluruh karyawan yang terlibat dalam pelaksanaan program APU dan PPT Perusahaan telah memahami ketentuan terkait APU dan PPT?"),
	R_0203080000 ("0203080000", "PI 7. Apakah pejabat/unit kerja APU dan PPT memiliki akses  GRIPS/SIPESAT (Sistem PPATK)?"),
	R_0203090000 ("0203090000", "PI 8. Apakah Perusahaan pernah melaporkan TKM kepada PPPATK? Bagaimana prosedur yang dilakukan (mulai dari prosedur penentuan TKM hingga pelaporan kepada PPATK)?"),
//	R_0204000000 ("0204000000", "4. SISTEM INFORMASI MANAJEMEN"),
	R_0204010000 ("0204010000", "SIM 1. Apakah Perusahaan telah memiliki sistem informasi yang dapat mengidentifikasi, menganalisa, memantau dan menyediakan laporan secara efektif mengenai karakteristik transaksi yang dilakukan oleh Nasabah. Jelaskan sistem yang digunakan Perusahaan dalam penerapan program APU dan PPT?"),
	R_0204020000 ("0204020000", "SIM 2. Apakah sistem tersebut dikembangkan dengan menggunakan vendor/pihak ketiga?"),
//	R_0204030000 ("0204030000", "SISTEM MANAJEMEN RISIKO"),
	R_0204040000 ("0204040000", "SIM 3. Siapa pihak/bagian yang berwenang melakukan identifikasi risiko  APU dan PPT nasabah?"),
	R_0204050000 ("0204050000", "SIM 4. Apakah Perusahaan telah mengelompokkan Calon Nasabah dan Nasabah berdasarkan tingkat risiko terjadinya Pencucian Uang dan/atau Pendanaan Terorisme?"),
	R_0204060000 ("0204060000", "SIM 5. Apakah parameter yang digunakan dalam pengkategorian risiko nasabah telah dinilai memadai?"),
	R_0204070000 ("0204070000", "SIM 6. Apakah Perusahaan telah melakukan pengkinian risiko nasabah? Seberapa sering pengkinian risiko tersebut dilakukan?"),
	R_0204080000 ("0204080000", "SIM 7. Apakah Perusahaan memiliki pihak/bagian khusus untuk menentukan risiko APU dan PPT Perusahaan? Apakah pihak/bagian tersebut juga memiliki tugas/fungsi untuk menentukan risiko Perusahaan secara keseluruhan?"),
	R_0204090000 ("0204090000", "SIM 8. Berapa banyak waktu yang Perusahaan perlukan untuk melakukan pengawasan terkait APU dan PPT?"),
//	R_0205000000 ("0205000000", "5. SUMBER DAYA MANUSIA DAN PELATIHAN"),
	R_0205010000 ("0205010000", "SDM 1. Apakah Perusahaan telah memiliki prosedur penyaringan dalam rangka penerimaan karyawan baru (pre employee screening); dan pemantauan terhadap profil karyawan?"),
	R_0205020000 ("0205020000", "SDM 2. Apakah pelatihan terkait APU dan PPT dilaksanakan setiap tahun? Berapa jumlah pelatihan yang telah dilaksanakan setiap tahunnya?"),
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
		for (ER5001PosApuAsrjk02 eEnum : ER5001PosApuAsrjk02.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER5001PosApuAsrjk02.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER5001PosApuAsrjk02.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static FieldValidation genValidationPenilaian() {
		return UtilFieldValidation.genEqualsFixedValue("1|2|3|4|5");
	}
}
