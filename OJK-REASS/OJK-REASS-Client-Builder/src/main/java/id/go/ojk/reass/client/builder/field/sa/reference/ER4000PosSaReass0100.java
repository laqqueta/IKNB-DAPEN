package id.go.ojk.reass.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1099Peringkat;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4000PosSaReass0100 implements IObject<KeyValueString> {
//	R_01000100000000 ("01000100000000", "Tabel I.A: Kertas Kerja Penilaian Sendiri (Self Assesment) Faktor Tata Kelola Perusahaan yang Baik Bagi Perusahaan "),
//	R_01000101000000 ("01000101000000", "Pelaksanaan tugas dan tanggung jawab Direksi:"),
	R_01000101010000 ("01000101010000", "a.       Struktur tata kelola (governance structure) "),
	R_01000101020000 ("01000101020000", "b.       Proses tata kelola (governance process) "),
	R_01000101030000 ("01000101030000", "c.        Hasil penerapan tata kelola (governance outcome)"),
//	R_01000102000000 ("01000102000000", "Pelaksanaan tugas dan tanggung jawab Dewan Komisaris "),
	R_01000102010000 ("01000102010000", "a.   Struktur tata kelola (governance structure) "),
	R_01000102020000 ("01000102020000", "b.   Proses tata kelola (governance process) "),
	R_01000102030000 ("01000102030000", "c.   Hasil penerapan tata kelola (governance outcome)"),
//	R_01000103000000 ("01000103000000", "Pelaksanaan tugas dan tanggung jawab DPS untuk Perusahaan Asuransi Syariah dan UUS."),
	R_01000103010000 ("01000103010000", "a.       Struktur tata kelola (governance structure)"),
	R_01000103020000 ("01000103020000", "b.       Proses tata kelola (governance process)"),
	R_01000103030000 ("01000103030000", "c.        Hasil penerapan tata kelola (governance outcome)"),
//	R_01000104000000 ("01000104000000", "Pelaksanaan tugas dan tanggung jawab pemegang saham atau yang setara"),
	R_01000104010000 ("01000104010000", "a.       Struktur tata kelola (governance structure)"),
	R_01000104020000 ("01000104020000", "b.       Proses tata kelola (governance process)"),
	R_01000104030000 ("01000104030000", "c.        Hasil penerapan tata kelola (governance outcome)"),
//	R_01000105000000 ("01000105000000", "Pelaksanaan tugas dan tanggung jawab komite dan satuan kerja atau fungsi di perusahaan"),
//	R_01000105010000 ("01000105010000", " I.        Pelaksanaan tugas dan tanggung jawab satuan kerja atau fungsi di perusahaan (Dibawah Direksi)"),
	R_01000105010100 ("01000105010100", "a.      Struktur tata kelola (governance structure)"),
	R_01000105010200 ("01000105010200", "b.      Proses tata kelola (governance process)"),
	R_01000105010300 ("01000105010300", "c.      Hasil penerapan tata kelola (governance outcome)"),
//	R_01000105020000 ("01000105020000", " II.        Pelaksanaan tugas dan tanggung jawab komite"),
	R_01000105020100 ("01000105020100", "a.      Struktur tata kelola (governance structure)"),
	R_01000105020200 ("01000105020200", "b.      Proses tata kelola (governance process)"),
	R_01000105020300 ("01000105020300", "c.      Hasil penerapan tata kelola (governance outcome)"),
//	R_01000106000000 ("01000106000000", "Penerapan fungsi kepatuhan Perusahaan "),
	R_01000106010000 ("01000106010000", "a.     Struktur tata kelola (governance structure)"),
	R_01000106020000 ("01000106020000", "b.     Proses tata kelola (governance process)"),
	R_01000106030000 ("01000106030000", "c.     Hasil penerapan tata kelola (governance outcome)"),
//	R_01000107000000 ("01000107000000", "Penerapan fungsi audit internal "),
	R_01000107010000 ("01000107010000", "a.       Struktur tata kelola (governance structure)  "),
	R_01000107020000 ("01000107020000", "b.       Proses tata kelola (governance process)  "),
	R_01000107030000 ("01000107030000", "c.        Hasil penerapan tata kelola (governance outcome) "),
//	R_01000108000000 ("01000108000000", "Penerapan fungsi audit eksternal "),
	R_01000108010000 ("01000108010000", "a.       Struktur tata kelola (governance structure)"),
	R_01000108020000 ("01000108020000", "b.        Proses tata kelola (governance process) "),
	R_01000108030000 ("01000108030000", "c.         Hasil penerapan tata kelola (governance outcome) "),
//	R_01000109000000 ("01000109000000", "Penerapan manajemen risiko termasuk sistem pengendalian internal dan penerapan tata kelola teknologi informasi"),
	R_01000109010000 ("01000109010000", "a.        Struktur tata kelola (governance structure) "),
	R_01000109020000 ("01000109020000", "b.       Proses tata kelola (governance process)  "),
	R_01000109030000 ("01000109030000", "c.         Hasil penerapan tata kelola (governance outcome) "),
//	R_01000110000000 ("01000110000000", "Penanganan Benturan Kepentingan "),
	R_01000110010000 ("01000110010000", "a.       Struktur tata kelola (governance structure) "),
	R_01000110020000 ("01000110020000", "b.       Proses tata kelola (governance process) "),
	R_01000110030000 ("01000110030000", "c.         Hasil penerapan tata kelola (governance outcome) "),
//	R_01000111000000 ("01000111000000", "Transparansi Kondisi Keuangan Dan Non-Keuangan"),
	R_01000111010000 ("01000111010000", "a.      Struktur tata kelola (governance structure) "),
	R_01000111020000 ("01000111020000", "b.       Proses tata kelola (governance process) "),
	R_01000111030000 ("01000111030000", "c.        Hasil penerapan tata kelola (governance outcome)"),
//	R_01000112000000 ("01000112000000", "Rencana strategis Perusahaan "),
	R_01000112010000 ("01000112010000", "a.       Struktur tata kelola (governance structure)  "),
	R_01000112020000 ("01000112020000", "b.       Proses tata kelola (governance process)"),
	R_01000112030000 ("01000112030000", "c.       Hasil penerapan tata kelola (governance outcome) "),
//	R_01000113000000 ("01000113000000", "Kesimpulan:"),
	R_01000113010000 ("01000113010000", "A.       Struktur tata kelola (governance structure) "),
	R_01000113020000 ("01000113020000", "B.       Proses tata kelola (governance process)"),
	R_01000113030000 ("01000113030000", "C.       Hasil penerapan tata kelola (governance outcome) "),
//	R_01000200000000 ("01000200000000", "Tabel I.B: Peringkat Faktor tata kelola Perusahaan yang Baik "),
	R_01000201000000 ("01000201000000", "Peringkat Faktor tata kelola Perusahaan yang Baik"),
	R_01000202000000 ("01000202000000", "Peringkat Faktor Profil Risiko Konsolidasi"),
	R_01000202010000 ("01000202010000", "Analisis"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4000PosSaReass0100 eEnum : ER4000PosSaReass0100.values()) {
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
	
	public static ConditionalRequired genConditional2() {
		return UtilFieldConditional.genExistPos("O", "M", UtilMetadata.genPipeRow(getObjects(),  new int[] { 43 }));
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), 42, 43));
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 42, 43), 1);
	}
	
	public static SegmentValidation genValidationPeringkat1() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 42 }), ER1099Peringkat.getPipedKey());
	}
	
	public static SegmentValidation genValidationPeringkat2() {
		return UtilSegmentValidation.genFixedValueOptional("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 43 }), ER1099Peringkat.getPipedKey());
	}
}
