package id.go.ojk.asruk.client.builder.field.sa.reference;

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
public enum ER4004PosSaAsruk0204 implements IObject<KeyValueString> {
//	R_02040100000000 ("02040100000000", "Tabel II.D.1: Parameter atau Indikator Penilaian Risiko Inheren untuk Risiko Kredit"),
//	R_02040101000000 ("02040101000000", "I Kuantitatif"),
	R_02040101010000 ("02040101010000", "1.  Rasio aset berisiko"),
	R_02040101020000 ("02040101020000", "2.  Pertumbuhan premi reasuransi dibandingkan dengan pertumbuhan premi asuransi (dihitung yoy)"),
	R_02040101030000 ("02040101030000", "3.  Rasio penempatan reasuransi luar negeri terhadap total reasuransi"),
	R_02040101040000 ("02040101040000", "4.  Pertumbuhan tagihan reasuransi"),
	R_02040101050000 ("02040101050000", "5.  Pertumbuhan risiko kredit (dari MMBR)"),
	R_02040101060000 ("02040101060000", "6.  Rasio Aset Yang Diperkenankan (AYD) piutang reasuransi terhadap total piutang reasuransi (bisa dari Premi/claim recovery)"),
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
	;
	
	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4004PosSaAsruk0204 eEnum : ER4004PosSaAsruk0204.values()) {
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
	public static SegmentValidation genValidationMaxLengthNumeric() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 11, 12 }), 1);
	}

	public static SegmentValidation genValidationMaxLengthNumericDotNegative() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 0, 5), 8);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 11, 12 }));
	}
	
	public static SegmentValidation genValidationNumericDotNegative() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2", UtilMetadata.genPipeRow(getObjects(), 0, 5));
	}

	public static SegmentValidation genValidationPeringkat() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 11, 12 }), ER1099Peringkat.getPipedKey());
	}
}
