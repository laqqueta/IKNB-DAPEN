package id.go.ojk.reass.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3012PosLbReass600 implements IObject<KeyValueString> {
//	R_7001000099 ("7001000099", "I. Investasi"),
	R_7001010000 ("7001010000", "Deposito"),
	R_7001020000 ("7001020000", "Sertifikat Deposito"),
	R_7001000000 ("7001000000", "Saham Syariah"),
	R_7002000099 ("7002000099", "Sukuk atau Obligasi Syariah"),
	R_7002010000 ("7002010000", "MTN Syariah"),
	R_7002020000 ("7002020000", "Surat Berharga Syariah Negara RI"),
	R_7002030000 ("7002030000", "Surat Berharga Syariah Bank Indonesia"),
	R_7002000000 ("7002000000", "Surat Berharga Syariah Negara Selain RI"),
	R_7003000099 ("7003000099", "Surat Berharga Syariah Lembaga Multinasional"),
	R_7003010000 ("7003010000", "Reksa Dana Syariah"),
	R_7003020000 ("7003020000", "Efek Beragun Aset Syariah"),
	R_7003000000 ("7003000000", "Dana Investasi Real Estat Syariah"),
	R_7004000099 ("7004000099", "REPO"),
	R_7004010000 ("7004010000", "Pembiayaan Melalui Kerjasama Dengan Pihak Lain (Executing)"),
	R_7004020000 ("7004020000", "Emas  Murni"),
	R_7004030000 ("7004030000", "Sukuk Daerah"),
	R_7004040000 ("7004040000", "Dana Investasi Infrastruktur berbentuk kontrak investasi kolektif"),
	R_7004050000 ("7004050000", "Investasi Lain"),
	R_7004060000 ("7004060000", "Jumlah Investasi"),
//	R_7004070000 ("7004070000", "II. Bukan Investasi"),
	R_7004000000 ("7004000000", "Kas dan Bank"),
	R_7005000000 ("7005000000", "Tagihan Kontribusi Penutupan Langsung"),
	R_1400000000 ("1400000000", "Tagihan Kontribusi  Penutupan Tidak Langsung"),
	R_7005010000 ("7005010000", "Tagihan Reasuransi"),
	R_7005030000 ("7005030000", "Tagihan Kontribusi Koasuransi"),
	R_7006000099 ("7006000099", "Tagihan Recovery Klaim Reasuransi"),
	R_3000000000 ("3000000000", "Tagihan Hasil Investasi"),
	R_7006010000 ("7006010000", "Tagihan Investasi"),
	R_7006000000 ("7006000000", "Aset Reasuransi"),
	R_7007000099 ("7007000099", "Aset Lain"),
	R_7002000098 ("7002000098", "Jumlah Bukan Investasi"),
	R_7007010000 ("7007010000", "JUMLAH ASET (I+II)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3012PosLbReass600 eEnum : ER3012PosLbReass600.values()) {
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
	
	public static FieldValidation genFieldValidation4() {
		return UtilFieldValidation.genEqualsPosFormula("2-3", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 18, 27, 28 }));
	}
	
	public static SegmentValidation genValidationJumlahInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 8), R_7004060000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 17), "Jumlah Investasi|Penjumlahan Investasi");
	}
	
	public static SegmentValidation genValidationJumlahBukanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 8), R_7002000098.key, 
				UtilMetadata.genPlusRow(getObjects(), 19, 28), "Jumlah Bukan Investasi|Penjumlahan Bukan Investasi");
	}
	
	public static SegmentValidation genValidationJumlahAset() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 8), R_7007010000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 18, 29 }), "Jumlah Aset|Penjumlahan Aset");
	}
}
