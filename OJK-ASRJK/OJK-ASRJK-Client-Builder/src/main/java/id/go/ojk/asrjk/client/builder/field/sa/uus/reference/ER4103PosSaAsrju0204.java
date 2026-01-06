package id.go.ojk.asrjk.client.builder.field.sa.uus.reference;

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
public enum ER4103PosSaAsrju0204 implements IObject<KeyValueString> {
//	R_02040100000000 ("02040100000000", "Tabel II.D.1: Parameter atau Indikator Penilaian Risiko Inheren untuk Risiko Kredit"),
//	R_02040101000000 ("02040101000000", "I Kuantitatif"),
	R_02040101010000 ("02040101010000", "1.  Rasio aset berisiko"),
//	R_02040101020000 ("02040101020000", "2.  Reinsurance expense movement"),
	R_02040101020100 ("02040101020100", "     Dana Tabarru'"),
	R_02040101020200 ("02040101020200", "     Dana Perusahaan"),
	R_02040101030000 ("02040101030000", "3.  Rasio penempatan reasuransi luar negeri terhadap total reasuransi (dana tabarru’)"),
	R_02040101040000 ("02040101040000", "4.  Rasio pertumbuhan tagihan reasuransi (dana tabarru’)"),
//	R_02040101050000 ("02040101050000", "5.  Pertumbuhan risiko kredit"),
	R_02040101050100 ("02040101050100", "     Dana Tabarru' (DTMBR)"),
	R_02040101050200 ("02040101050200", "     Dana Perusahaan (MMBR)"),
	R_02040101050300 ("02040101050300", "     Dana Perusahaan (MMBR atas PAYDI digaransi)"),
	R_02040101060000 ("02040101060000", "6.  Rasio AYD tagihan reasuransi terhadap total tagihan reasuransi (bisa dari kontribusi / claim recovery)"),
//	R_02040102000000 ("02040102000000", "II Kualitatif"),
//	R_02040102010000 ("02040102010000", "1.  Risiko dari pengelolaan piutang"),
	R_02040102010100 ("02040102010100", "Risiko Kredit secara umum diindikasikan oleh tingkat ketertagihan piutang yang dipengaruhi oleh kondisi tertanggung dan upaya penagihan yang dilakukan oleh Perusahaan."),
//	R_02040102020000 ("02040102020000", "2.   Risiko konsentrasi penempatan investasi dan rating counterparty dimana investasi ditempatkan"),
	R_02040102020100 ("02040102020100", " a. Konsentrasi penempatan investasi"),
	R_02040102020200 ("02040102020200", " b. rating counterparty"),
//	R_02040102030000 ("02040102030000", "3.  Risiko kegagalan reasuradur"),
	R_02040102030100 ("02040102030100", "a. Konsentrasi penempatan reasuransi; dan"),
	R_02040102030200 ("02040102030200", "b. Rating penempatan reasuransi"),
//	R_02040200000000 ("02040200000000", "Tabel II.D.2: Tingkat Risiko Inheren untuk Risiko Kredit"),
	R_02040201000000 ("02040201000000", "Tingkat Risiko Inheren untuk Risiko Kredit"),
//	R_02040300000000 ("02040300000000", "Tabel II.D.3: Kualitas Penerapan Manajemen Risiko untuk Risiko Kredit"),
	R_02040301000000 ("02040301000000", "Kualitas Penerapan Manajemen Risiko untuk Risiko Kredit"),
//	R_02040302000000 ("02040302000000", "Tingkat Risiko Kredit"),
	R_02040303000000 ("02040303000000", "Tingkat Risiko Kredit Net Risk"),
	R_02040400000000 ("02040400000000", "ANALISIS"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4103PosSaAsrju0204 eEnum : ER4103PosSaAsrju0204.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER4103PosSaAsrju0204.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER4103PosSaAsrju0204.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2", UtilMetadata.genPipeRow(getObjects(), 0, 8));
	}
	
	public static SegmentValidation genValidationMaxLengthNumericDot() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 0, 8), 10);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), 14, 16));
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 14, 16), 1);
	}
	
	public static SegmentValidation genValidationPeringkat() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), 14, 16), ER1099Peringkat.getPipedKey());
	}
}
