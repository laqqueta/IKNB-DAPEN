package id.go.ojk.asruk.client.builder.field.sa.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1099Peringkat;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4107PosSaAsruu0208 implements IObject<KeyValueString> {
//	R_02080100000000 ("02080100000000", "Tabel II.H.1: Parameter atau Indikator Penilaian Risiko Inheren untuk Risiko Kepatuhan "),
//	R_02080101000000 ("02080101000000", "I Kuantitatif"),
//	R_02080101010000 ("02080101010000", "1.  Frekuensi pelanggaran terhadap peraturan yang berlaku"),
	R_02080101010100 ("02080101010100", " a. Jumlah pelanggaran atas ketentuan"),
	R_02080101010200 ("02080101010200", " b. Jumlah pelanggaran yang sama dalam 3 (tiga) tahun terakhir"),
//	R_02080101020000 ("02080101020000", "2.  Frekuensi tindak lanjut atas pelanggaran terhadap peraturan yang berlaku"),
	R_02080101020100 ("02080101020100", " Jumlah tindak lanjut atas pelanggaran terhadap ketentuan"),
	R_02080101030000 ("02080101030000", "3.  Jumlah denda"),
//	R_02080102000000 ("02080102000000", "II Kualitatif"),
//	R_02080102010000 ("02080102010000", "1.  Jenis dan signifikansi pelanggaran yang dilakukan "),
	R_02080102010100 ("02080102010100", "a. Jumlah sanksi adminstrasi berupa sanksi peringatan atau teguran yang dikenakan kepada Perusahaan dan Unit Syariah."),
	R_02080102010200 ("02080102010200", "b. Jumlah sanksi administrasi berupa denda kewajiban membayar yang dikenakan kepada Perusahaan dan Unit Syariah dari Otoritas Jasa Keuangan."),
	R_02080102010300 ("02080102010300", "c. Jenis pelanggaran atau ketidakpatuhan yang dilakukan oleh Perusahaan dan Unit Syariah."),
//	R_02080102020000 ("02080102020000", "2. Frekuensi pelanggaran termasuk sanksi yang dilakukan atau track record ketidakpatuhan Perusahaan "),
	R_02080102020100 ("02080102020100", "a. Jenis dan frekuensi pelanggaran yang sama yang ditemukan setiap tahunnya dalam 3 (tiga) tahun terakhir."),
	R_02080102020200 ("02080102020200", "b. Signifikansi temuan pelanggaran tersebut."),
//	R_02080102030000 ("02080102030000", "3. Pelanggaran atas ketentuan pada peraturan perundang-undangan, ketentuan yang berlaku bagi Perusahaan, atau standar bisnis yang berlaku umum"),
	R_02080102030100 ("02080102030100", " Frekuensi pelanggaran atas ketentuan pada transaksi keuangan tertentu karena tidak sesuai dengan standar yang berlaku umum."),
//	R_02080102040000 ("02080102040000", "4. Tindak lanjut atas pelanggaran termasuk pemenuhan atas rencana tindak (action plan) yang disampaikan kepada OJK."),
	R_02080102040100 ("02080102040100", " Tindak lanjut atas pelanggaran ketentuan termasuk pemenuhan atas rencana tindak (action plan) yang disampaikan kepada OJK."),
//	R_02080200000000 ("02080200000000", "Tabel II.H.2: Tingkat Risiko Inheren untuk Risiko Kepatuhan"),
	R_02080201000000 ("02080201000000", "Tingkat Risiko Inheren untuk Risiko Kepatuhan"),
//	R_02080300000000 ("02080300000000", "Tabel II.H.3: Kualitas Penerapan Manajemen Risiko untuk Risiko Kepatuhan"),
	R_02080301000000 ("02080301000000", "Kualitas Penerapan Manajemen Risiko untuk Risiko Kepatuhan"),
//	R_02080302000000 ("02080302000000", "Tingkat Risiko Kepatuhan"),
	R_02080303000000 ("02080303000000", "Tingkat Risiko Kepatuhan Net Risk"),
	R_02080400000000 ("02080400000000", "ANALISIS"),
	;
	
	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4107PosSaAsruu0208 eEnum : ER4107PosSaAsruu0208.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 3, 11, 12, 13 }));
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric1() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2 }), 10);
	}

	public static SegmentValidation genValidationMaxLengthNumeric2() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 3 }), 16);
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric3() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 11, 13), 1);
	}

	public static SegmentValidation genValidationPeringkat() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), 11, 13), ER1099Peringkat.getPipedKey());
	}
}
