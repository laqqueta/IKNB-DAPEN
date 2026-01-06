package id.go.ojk.asrus.client.builder.field.lb.reference;

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
public enum ER3021PosLbAsrus213 implements IObject<KeyValueString> {
	R_6201000000 ("6201000000", "Aset"),
	R_6201000001 ("6201000001", "Investasi"),
	R_6201000002 ("6201000002", "Deposito Berjangka "),
	R_6201000003 ("6201000003", "Sertifikat Deposito"),
	R_6201000004 ("6201000004", "Saham Syariah"),
	R_6201000005 ("6201000005", "Sukuk / Obligasi Korporasi Syariah"),
	R_6201000006 ("6201000006", "MTN Syariah"),
	R_6201000007 ("6201000007", "Surat Berharga Syariah Negara"),
	R_6201000008 ("6201000008", "Surat Berharga yang Diterbitkan oleh Bank Indonesia"),
	R_6201000009 ("6201000009", "Surat Berharga yang Diterbitkan oleh Negara Selain Negara RI "),
	R_6201000010 ("6201000010", "Surat Berharga yang Diterbitkan oleh Lembaga Multinasional"),
	R_6201000011 ("6201000011", "Reksa Dana Syariah"),
	R_6201000012 ("6201000012", "Efek Beragun Aset Syariah"),
	R_6201000013 ("6201000013", "Dana Investasi Real Estat"),
	R_6201000014 ("6201000014", "REPO"),
	R_6201000015 ("6201000015", "Pembiayaan Melalui Kerjasama dengan Pihak Lain (Executing)"),
	R_6201000016 ("6201000016", "Pembiayaan Syariah dengan Hak Tanggungan"),
	R_6201000017 ("6201000017", "Penyertaan Langsung"),
	R_6201000018 ("6201000018", "Property Investasi"),
	R_6201000019 ("6201000019", "Emas Murni"),
	R_6201000020 ("6201000020", "Sukuk Daerah"),
	R_6201000021 ("6201000021", "Dana Investasi Infrastruktur berbentuk kontrak investasi kolektif"),
	R_6201000022 ("6201000022", "Investasi Lain"),
	R_6201000023 ("6201000023", "Bukan Investasi"),
	R_6201000024 ("6201000024", "Kas dan Bank"),
	R_6201000025 ("6201000025", "Tagihan Kontribusi/ujroh Penutupan Langsung"),
	R_6201000026 ("6201000026", "Tagihan Kontribusi/ujroh Reasuransi"),
	R_6201000027 ("6201000027", "Aset Reasuransi"),
	R_6201000028 ("6201000028", "Tagihan Klaim Koasuransi"),
	R_6201000029 ("6201000029", "Tagihan Recovery Klaim Reasuransi"),
	R_6201000030 ("6201000030", "Tagihan Investasi"),
	R_6201000031 ("6201000031", "Tagihan Hasil Investasi"),
	R_6201000032 ("6201000032", "Property Bukan Investasi"),
	R_6201000033 ("6201000033", "Biaya Akuisisi yang Ditangguhkan"),
	R_6201000034 ("6201000034", "Aset Tetap Lain"),
	R_6201000035 ("6201000035", "Aset Lain"),
//	R_6201000036 ("6201000036", "Liabilitas dan Ekuitas"),
	R_6201000037 ("6201000037", "Liabilitas"),
	R_6201000038 ("6201000038", "Utang"),
	R_6201000039 ("6201000039", "Utang Klaim atau manfaat investasi"),
	R_6201000040 ("6201000040", "Utang Koasuransi"),
	R_6201000041 ("6201000041", "Utang Reasuransi"),
	R_6201000042 ("6201000042", "Utang Ujroh"),
	R_6201000043 ("6201000043", "Utang Pajak"),
	R_6201000044 ("6201000044", "Biaya yang Masih Harus Dibayar"),
	R_6201000045 ("6201000045", "Utang Lain"),
	R_6201000046 ("6201000046", "Penyisihan Teknis"),
	R_6201000047 ("6201000047", "Penyisihan ujroh"),
	R_6201000048 ("6201000048", "Penyisihan PAYDI yang memberikan garansi pokok investasi"),
	R_6201000049 ("6201000049", "Penyisihan kontribusi"),
	R_6201000050 ("6201000050", "Penyisihan kontribusi yang belum merupakan pendapatan"),
	R_6201000051 ("6201000051", "Penyisihan klaim"),
	R_6201000052 ("6201000052", "Penyisihan atas risiko bencana"),
	R_6201000053 ("6201000053", "Akumulasi Dana Investasi Peserta"),
	R_6201000054 ("6201000054", "SELISIH LIABILITAS DAN ASET"),
	R_6201000055 ("6201000055", "DEVIASI (4% X (Maks (Li - AYDi), 0))"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3021PosLbAsrus213 eEnum : ER3021PosLbAsrus213.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 19), getObjects());
	}
	
	public static FieldValidation genValidation7() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 6), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 1, 23, 36, 37, 45, 53, 54 }));
	}
	
	public static FieldValidation genValidation13() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(8, 12), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 1, 23, 36, 37, 45, 53, 54 }));
	}
	
	public static FieldValidation genValidation19() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(14, 18), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 1, 23, 36, 37, 45, 53, 54 }));
	}
	
	public static SegmentValidation genValidationAset() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 19), R_6201000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 1, 23 }), 
				"Total Aset|Penjumlahan Aset");
	}
	
	public static SegmentValidation genValidationInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 19), R_6201000001.key, 
				UtilMetadata.genPlusRow(getObjects(), 2, 22),  "Total Investasi|Penjumlahan Investasi");
	}
	
	public static SegmentValidation genValidationBukanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 19), R_6201000023.key, 
				UtilMetadata.genPlusRow(getObjects(), 24, 35),  "Total Bukan Investasi|Penjumlahan Bukan Investasi");
	}
	
	public static SegmentValidation genValidationLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 19), R_6201000037.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 37, 45 }),  "Total Liabilitas|Penjumlahan Liabilitas");
	}
	
	public static SegmentValidation genValidationUtang() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 19), R_6201000038.key, 
				UtilMetadata.genPlusRow(getObjects(), 38, 44),  "Total Utang|Penjumlahan Utang");
	}
	
	public static SegmentValidation genValidationPenyisihanTeknis() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 19), R_6201000046.key, 
				UtilMetadata.genPlusRow(getObjects(), 46, 52),  "Total Penyisihan Teknis|Penjumlahan Penyisihan Teknis");
	}
	
	public static SegmentValidation genValidationSelisihLiabilitasDanAset() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 19), R_6201000054.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 36, 0 }),  "Selisih Liabilitas Dan Aset|Perhitungan Selisih Liabilitas Dan Aset");
	}
	
	public static SegmentValidation genValidationDeviasi() {
		return UtilSegmentValidation.genDeviationMax(UtilMetadata.genPipeColumn(2, 19), R_6201000055.key, 
				R_6201000054.key, "0", "0.04", "Deviasi|Perhitungan Deviasi");
	}
}
