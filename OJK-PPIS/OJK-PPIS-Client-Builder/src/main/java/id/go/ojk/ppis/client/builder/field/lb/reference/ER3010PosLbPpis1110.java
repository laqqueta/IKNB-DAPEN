 package id.go.ojk.ppis.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1122JenisValuta;
import id.go.ojk.conf.client.field.reference.ER1131JenisInstrumenDerivatif;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3010PosLbPpis1110 implements IObject<KeyValueString> {
	R_11100100000000 ("11100100000000", "Fasilitas Pinjaman/Pendanaan yang Diterima dan Belum Ditarik"),
	R_11100101000000 ("11100101000000", "Pemerintah"),
	R_11100101010000 ("11100101010000", "Pemerintah Republik Indonesia"),
	R_11100101020000 ("11100101020000", "Pemerintah Asing"),
	R_11100102000000 ("11100102000000", "Organisasi Multilateral"),
	R_11100103000000 ("11100103000000", "Bank"),
	R_11100103010000 ("11100103010000", "Bank Dalam Negeri"),
	R_11100103020000 ("11100103020000", "Bank Luar Negeri"),
	R_11100104000000 ("11100104000000", "Lembaga Keuangan Non Bank"),
	R_11100104010000 ("11100104010000", "Lembaga Keuangan Non Bank Dalam Negeri"),
	R_11100104020000 ("11100104020000", "Lembaga Keuangan Non Bank Luar Negeri"),
	R_11100200000000 ("11100200000000", "Fasilitas Pinjaman/Pembiayaan yang Diberikan kepada Debitur/Nasabah dan Belum Ditarik"),
	R_11100300000000 ("11100300000000", "Penerbitan Surat Sanggup Bayar"),
	R_11100301000000 ("11100301000000", "Penerbitan Surat Sanggup Bayar untuk Pinjaman Dalam Negeri"),
	R_11100302000000 ("11100302000000", "Penerbitan Surat Sanggup Bayar untuk Pinjaman Luar Negeri"),
	R_11100400000000 ("11100400000000", "Nominal Instrumen Derivatif Untuk Lindung Nilai"),
	R_11100404000000 ("11100404000000", "Spot"),
	R_11100405000000 ("11100405000000", "Forward"),
	R_11100406000000 ("11100406000000", "Forward Agreement"),
	R_11100409000000 ("11100409000000", "Derivatif Lainnya"),
	R_11100500000000 ("11100500000000", "Nilai Fund yang Dikelola"),
	R_11100600000000 ("11100600000000", "Rekening Administratif Lainnya"),
	R_11100601000000 ("11100601000000", "Piutang Pembiayaan Hapus Buku"),
	R_11100602000000 ("11100602000000", "Piutang Pembiayaan Hapus Buku yang Berhasil Ditagih"),
	R_11100603000000 ("11100603000000", "Piutang Pembiayaan Hapus Tagih"),
	R_11100604000000 ("11100604000000", "Pembiayaan Alihan dengan Pengelolaan Penagihan"),
	R_11100700000000 ("11100700000000", "Rekening Administratif"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3010PosLbPpis1110 eEnum : ER3010PosLbPpis1110.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3010PosLbPpis1110.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3010PosLbPpis1110.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 3), getObjects());
	}
	
	public static FieldValidation genFieldValidation4() {
		return UtilFieldValidation.genEqualsFormula("2+3");
	}
	
	public static SegmentValidation genRowValidation02() {
		int[] fields = new int[] { 1, 4, 5, 8 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11100100000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11100100000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation03() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11100101000000.key,
				UtilMetadata.genPlusRow(getObjects(), 2, 3),
				UtilMetadata.genMessage(R_11100101000000.value, UtilMetadata.genPlusDesc(getObjects(), 2, 3)));
	}
	
	public static SegmentValidation genRowValidation07() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11100103000000.key,
				UtilMetadata.genPlusRow(getObjects(), 6, 7),
				UtilMetadata.genMessage(R_11100103000000.value, UtilMetadata.genPlusDesc(getObjects(), 6, 7)));
	}
	
	public static SegmentValidation genRowValidation10() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11100104000000.key,
				UtilMetadata.genPlusRow(getObjects(), 9, 10),
				UtilMetadata.genMessage(R_11100104000000.value, UtilMetadata.genPlusDesc(getObjects(), 9, 10)));
	}
	
	public static SegmentValidation genRowValidation14() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11100300000000.key,
				UtilMetadata.genPlusRow(getObjects(), 13, 14),
				UtilMetadata.genMessage(R_11100300000000.value, UtilMetadata.genPlusDesc(getObjects(), 13, 14)));
	}
	
	public static SegmentValidation genRowValidation17A() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11100400000000.key,
				UtilMetadata.genPlusRow(getObjects(), 16, 19),
				UtilMetadata.genMessage(R_11100400000000.value, UtilMetadata.genPlusDesc(getObjects(), 16, 19)));
	}

	public static SegmentValidation genRowValidation17B() {
		return UtilSegmentValidation.genEqualsFormulaFormNotEquals("3", R_11100400000000.key, "10",
				ER3023PosLbPpis3010.R_3010010000.getFormKey(), "6", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11100400000000.value, "Kolom nominal instrumen derivatif untuk lindung nilai (selain rupiah) pada form 3010"));
	}

	public static SegmentValidation genRowValidation21A() {
		String instrumen = ER1131JenisInstrumenDerivatif.R_8.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11100404000000.key, "10",
				ER3023PosLbPpis3010.R_3010010000.getFormKey(), "5|6", instrumen + "|" + ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11100404000000.value, messageForm3010Rupiah(instrumen)));
	}

	public static SegmentValidation genRowValidation21B() {
		String instrumen = ER1131JenisInstrumenDerivatif.R_8.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11100404000000.key, "10",
				ER3023PosLbPpis3010.R_3010010000.getFormKey(), "5", instrumen, "6", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11100404000000.value, messageForm3010NonRupiah(instrumen)));
	}

	public static SegmentValidation genRowValidation22A() {
		String instrumen = ER1131JenisInstrumenDerivatif.R_4.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11100405000000.key, "10",
				ER3023PosLbPpis3010.R_3010010000.getFormKey(), "5|6", instrumen + "|" + ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11100405000000.value, messageForm3010Rupiah(instrumen)));
	}

	public static SegmentValidation genRowValidation22B() {
		String instrumen = ER1131JenisInstrumenDerivatif.R_4.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11100405000000.key, "10",
				ER3023PosLbPpis3010.R_3010010000.getFormKey(), "5", instrumen, "6", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11100405000000.value, messageForm3010NonRupiah(instrumen)));
	}

	public static SegmentValidation genRowValidation23A() {
		String instrumen = ER1131JenisInstrumenDerivatif.R_9.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11100406000000.key, "10",
				ER3023PosLbPpis3010.R_3010010000.getFormKey(), "5|6", instrumen + "|" + ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11100406000000.value, messageForm3010Rupiah(instrumen)));
	}

	public static SegmentValidation genRowValidation23B() {
		String instrumen = ER1131JenisInstrumenDerivatif.R_9.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11100406000000.key, "10",
				ER3023PosLbPpis3010.R_3010010000.getFormKey(), "5", instrumen, "6", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11100406000000.value, messageForm3010NonRupiah(instrumen)));
	}

	public static SegmentValidation genRowValidation24A() {
		String instrumen = ER1131JenisInstrumenDerivatif.R_7.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11100409000000.key, "10",
				ER3023PosLbPpis3010.R_3010010000.getFormKey(), "5|6", instrumen + "|" + ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11100409000000.value, messageForm3010Rupiah(instrumen)));
	}

	public static SegmentValidation genRowValidation24B() {
		String instrumen = ER1131JenisInstrumenDerivatif.R_7.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11100409000000.key, "10",
				ER3023PosLbPpis3010.R_3010010000.getFormKey(), "5", instrumen, "6", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11100409000000.value, messageForm3010NonRupiah(instrumen)));
	}

	public static SegmentValidation genRowValidation26() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11100600000000.key,
				UtilMetadata.genPlusRow(getObjects(), 22, 25),
				UtilMetadata.genMessage(R_11100600000000.value, UtilMetadata.genPlusDesc(getObjects(), 22, 25)));
	}
	
	public static SegmentValidation genRowValidation31() {
		int[] fields = new int[] { 0, 11, 12, 15, 20, 21 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11100700000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11100700000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	private static String messageForm3010Rupiah(String kodeInstrumen) {
		return messageForm3010Rupiah(kodeInstrumen, true);
	}
	
	private static String messageForm3010NonRupiah(String kodeInstrumen) {
		return messageForm3010Rupiah(kodeInstrumen, false);
	}
	
	private static String messageForm3010Rupiah(String kodeInstrumen, boolean isRupiah) {
		return "Kolom nominal instrumen derivatif untuk lindung nilai [dengan dimensi Jenis Instrumen Derivatif terisi " + kodeInstrumen + "] (" + getOther(isRupiah) + "rupiah) pada form 3010";
	}
	
	private static String getOther(boolean isTrue) {
		return (isTrue ? "" : "selain ");
	}
}
