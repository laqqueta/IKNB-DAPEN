package id.go.ojk.asruk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3019PosLbAsruk102 implements IObject<KeyValueString> {
//	R_1400010001 ("1400010001", "Penempatan di Dalam Negeri"),
	R_1401010000 ("1401010000", "Deposito Berjangka"),
	R_1402010000 ("1402010000", "Sertifikat Deposito"),
	R_1403010000 ("1403010000", "Saham "),
	R_1404010000 ("1404010000", "Obligasi Korporasi"),
	R_1420010000 ("1420010000", "Obligasi / Sukuk Daerah"),
	R_1405010000 ("1405010000", "MTN"),
	R_1406010000 ("1406010000", "Surat Berharga yang Diterbitkan oleh Negara RI"),
	R_1407010000 ("1407010000", "Surat Berharga yang Diterbitkan oleh Negara Selain Negara RI "),
	R_1408010000 ("1408010000", "Surat Berharga yang Diterbitkan oleh Bank Indonesia"),
	R_1409010000 ("1409010000", "Surat Berharga yang Diterbitkan oleh Lembaga Multinasional"),
	R_1410010000 ("1410010000", "Reksa Dana"),
	R_1411010000 ("1411010000", "Efek Beragun Aset"),
	R_1412010000 ("1412010000", "Dana Investasi Real Estat"),
	R_1421010000 ("1421010000", "Dana Investasi Infrastruktur Berbentuk Kontrak Investasi Kolektif"),
	R_1413010000 ("1413010000", "REPO"),
	R_1414010000 ("1414010000", "Penyertaan Langsung"),
	R_1415010000 ("1415010000", "Tanah, Bangunan dengan Hak Strata atau Tanah dengan Bangunan untuk Investasi"),
	R_1416010000 ("1416010000", "Pembiayaan Melalui Kerjasama dengan Pihak Lain"),
	R_1417010000 ("1417010000", "Emas Murni"),
	R_1418010000 ("1418010000", "Pinjaman yang Dijamin dengan Hak Tanggungan"),
	R_1419010000 ("1419010000", "Pinjaman Polis"),
	R_1400010000 ("1400010000", "Sub Total"),
//	R_1400020001 ("1400020001", "Penempatan di Luar Negeri"),
	R_1401020000 ("1401020000", "Saham"),
	R_1402020000 ("1402020000", "Obligasi Korporasi"),
	R_1403020000 ("1403020000", "Surat Berharga yang Diterbitkan oleh Negara Selain Negara RI "),
	R_1404020000 ("1404020000", "Surat Berharga yang Diterbitkan oleh Lembaga Multinasional"),
	R_1405020000 ("1405020000", "Reksa Dana"),
	R_1406020000 ("1406020000", "Penyertaan Langsung"),
	R_1400020000 ("1400020000", "Sub Total"),
	R_1400000000 ("1400000000", "Total Sub A"),
	;
	
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3019PosLbAsruk102 eEnum : ER3019PosLbAsruk102.values()) {
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
	public static SegmentValidation genValidationTotalPenempatan() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1400000000.key, UtilMetadata.genPlusRow(getObjects(), new int[] { 21, 28 }), 
				"Total penempatan|Penjumlahan penempatan");
	}

	public static SegmentValidation genValidationTotalPenempatanDiDalamNegeri() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1400010000.key, UtilMetadata.genPlusRow(getObjects(), 0, 20), 
				"Total penempatan di dalam negeri|Penjumlahan penempatan di dalam negeri");
	}
	
	public static SegmentValidation genValidationTotalPenempatanDiLuarNegeri() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1400020000.key, UtilMetadata.genPlusRow(getObjects(), 22, 27), 
				"Total penempatan di luar negeri|Penjumlahan penempatan di luar negeri");
	}
}
