package id.go.ojk.asrjs.client.builder.field.lb.reference;

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

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3014PosLbAsrjs700 implements IObject<KeyValueString> {
//	R_1000000099 ("1000000099", "I. Investasi"),
	R_1400000099 ("1400000099", "Deposito"),
	R_1401000000 ("1401000000", "Sertifikat Deposito"),
	R_1402000000 ("1402000000", "Saham Syariah"),
	R_1403000000 ("1403000000", "Sukuk atau Obligasi Syariah"),
	R_1404000000 ("1404000000", "MTN Syariah"),
	R_1420000000 ("1420000000", "Surat Berharga Syariah Negara RI"),
	R_1405000000 ("1405000000", "Surat Berharga Syariah Bank Indonesia"),
	R_1406000000 ("1406000000", "Surat Berharga Syariah Negara Selain RI"),
	R_1407000000 ("1407000000", "Surat Berharga Syariah Lembaga Multinasional"),
	R_1408000000 ("1408000000", "Reksa Dana Syariah"),
	R_1409000000 ("1409000000", "Efek Beragun Aset Syariah"),
	R_1410000000 ("1410000000", "Dana Investasi Real Estat Syariah"),
	R_1411000000 ("1411000000", "REPO"),
	R_1412000000 ("1412000000", "Pembiayaan Melalui Kerjasama Dengan Pihak Lain (Executing)"),
	R_1421000000 ("1421000000", "Pembiayaan dengan Hak Tanggungan"),
	R_1413000000 ("1413000000", "Penyertaan Langsung"),
	R_1414000000 ("1414000000", "Properti Investasi"),
	R_1415000000 ("1415000000", "Emas  Murni"),
	R_1416000000 ("1416000000", "Sukuk Daerah"),
	R_1417000000 ("1417000000", "Dana Investasi Infrastruktur berbentuk kontrak investasi kolektif"),
	R_1418000000 ("1418000000", "Investasi Lain"),
	R_1419000000 ("1419000000", "Jumlah Investasi"),
//	R_1499000000 ("1499000000", "II. Bukan Investasi"),
	R_1400000000 ("1400000000", "Kas dan Bank"),
	R_1500000099 ("1500000099", "Tagihan Ujrah Penutupan Langsung"),
	R_1501000000 ("1501000000", "Tagihan Recovery Klaim Reasuransi"),
	R_1501000001 ("1501000001", "Tagihan Hasil Investasi"),
	R_1501000002 ("1501000002", "Tagihan Investasi"),
	R_1501000003 ("1501000003", "Aset Reasuransi"),
	R_1501000004 ("1501000004", "Biaya Akuisisi Ditangguhkan"),
	R_1501000005 ("1501000005", "Property Bukan Investasi"),
	R_1501000006 ("1501000006", "Aset Lain"),
	R_1501000007 ("1501000007", "Jumlah Bukan Investasi"),
	R_1501000008 ("1501000008", "JUMLAH KEKAYAAN (I+II)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3014PosLbAsrjs700 eEnum : ER3014PosLbAsrjs700.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 5), getObjects());
	}
	
	public static ConditionalRequired genConditional3() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 30 }));
	}
	
	public static FieldValidation genValidation4() {
		return UtilFieldValidation.genEqualsPosFormula("2-3", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 21, 31, 32 }));
	}
	
	public static SegmentValidation genValidationJumlahInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5), R_1419000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 20), "Jumlah investasi|Penjumlahan investasi");
	}
	
	public static SegmentValidation genValidationJumlahBukanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5), R_1501000007.key,
				UtilMetadata.genPlusRow(getObjects(), 22, 30), "Jumlah bukan investasi|Penjumlahan bukan investasi");
	}
	
	public static SegmentValidation genValidationJumlahKekayaan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5), R_1501000008.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 21, 31 }), "Jumlah Kekayaan|Penjumlahan Kekayaan");
	}
}
	