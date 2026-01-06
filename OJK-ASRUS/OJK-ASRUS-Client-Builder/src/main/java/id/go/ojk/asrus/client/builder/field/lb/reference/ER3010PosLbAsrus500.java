package id.go.ojk.asrus.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3010PosLbAsrus500 implements IObject<KeyValueString> {
//	R_5000000000 ("5000000000", "I. Investasi"),
	R_5000000001 ("5000000001", "Deposito"),
	R_5000000002 ("5000000002", "Sertifikat Deposito"),
	R_5000000003 ("5000000003", "Saham Syariah"),
	R_5000000004 ("5000000004", "Sukuk atau Obligasi Syariah"),
	R_5000000005 ("5000000005", "MTN Syariah"),
	R_5000000006 ("5000000006", "Surat Berharga Syariah Negara RI"),
	R_5000000007 ("5000000007", "Surat Berharga Syariah Bank Indonesia"),
	R_5000000008 ("5000000008", "Surat Berharga Syariah Negara Selain RI"),
	R_5000000009 ("5000000009", "Surat Berharga Syariah Lembaga Multinasional"),
	R_5000000010 ("5000000010", "Reksa Dana Syariah"),
	R_5000000011 ("5000000011", "Efek Beragun Aset Syariah"),
	R_5000000012 ("5000000012", "Dana Investasi Real Estat Syariah"),
	R_5000000013 ("5000000013", "REPO"),
	R_5000000014 ("5000000014", "Pembiayaan Melalui Kerjasama Dengan Pihak Lain (Executing)"),
	R_5000000015 ("5000000015", "Pembiayaan Syariah Dengan Hak Tanggungan"),
	R_5000000016 ("5000000016", "Penyertaan Langsung"),
	R_5000000017 ("5000000017", "Properti Investasi"),
	R_5000000018 ("5000000018", "Emas  Murni"),
	R_5000000019 ("5000000019", "Sukuk Daerah"),
	R_5000000020 ("5000000020", "Dana Investasi Infrastruktur berbentuk kontrak investasi kolektif"),
	R_5000000021 ("5000000021", "Investasi Lain"),
	R_5000000022 ("5000000022", "Jumlah Investasi"),
//	R_5000000023 ("5000000023", "II. Bukan Investasi"),
	R_5000000024 ("5000000024", "Kas dan Bank"),
	R_5000000025 ("5000000025", "Tagihan Ujrah Penutupan Langsung"),
	R_5000000026 ("5000000026", "Tagihan Ujrah Penutupan Tidak Langsung"),
	R_5000000027 ("5000000027", "Tagihan Hasil Investasi"),
	R_5000000028 ("5000000028", "Tagihan Investasi"),
	R_5000000029 ("5000000029", "Aset Reasuransi"),
	R_5000000030 ("5000000030", "Biaya Akuisisi Ditangguhkan"),
	R_5000000031 ("5000000031", "Property Bukan Investasi"),
	R_5000000032 ("5000000032", "Aset Lain"),
	R_5000000033 ("5000000033", "Jumlah Bukan Investasi"),
	R_5000000034 ("5000000034", "JUMLAH KEKAYAAN (I+II)"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3010PosLbAsrus500 eEnum : ER3010PosLbAsrus500.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 8), getObjects());
	}
	
	public static ConditionalRequired genConditional() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 20, 30 }));
	}
	
	public static FieldValidation genValidationField4() {
		return UtilFieldValidation.genEqualsPosFormula("2-3", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 21, 31, 32 }));
	}

	public static SegmentValidation genValidationJumlahInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 8), R_5000000022.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 20),
				"Jumlah Investasi|Penjumlahan Investasi");
	}

	public static SegmentValidation genValidationJumlahBukanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 8), R_5000000033.key, 
				UtilMetadata.genPlusRow(getObjects(), 22, 30),
				"Jumlah Bukan Investasi|Penjumlahan Bukan Investasi");
	}

	public static SegmentValidation genValidationJumlahKekayaan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 8), R_5000000034.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 21, 31 }),
				"Jumlah Kekayaan|Penjumlahan Kekayaan");
	}
}
