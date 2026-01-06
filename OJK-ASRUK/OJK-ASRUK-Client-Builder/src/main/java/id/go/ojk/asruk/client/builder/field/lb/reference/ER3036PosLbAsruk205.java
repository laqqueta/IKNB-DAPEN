package id.go.ojk.asruk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
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
public enum ER3036PosLbAsruk205 implements IObject<KeyValueString> {
//	R_4501000099 ("4501000099", "Penempatan Investasi Pada Bukan-Afiliasi"),
	R_4501010000 ("4501010000", "Deposito Berjangka"),
	R_4501020000 ("4501020000", "Sertifikat Deposito"),
	R_4501030000 ("4501030000", "Saham"),
	R_4501040000 ("4501040000", "Obligasi Korporasi"),
	R_4501200000 ("4501200000", "Obligasi Daerah"),
	R_4501050000 ("4501050000", "MTN"),
	R_4501060000 ("4501060000", "Surat Berharga yang Diterbitkan oleh Negara RI"),
	R_4501070000 ("4501070000", "Surat Berharga yang Diterbitkan oleh Negara Selain Negara RI"),
	R_4501080000 ("4501080000", "Surat Berharga yang Diterbitkan oleh Bank Indonesia"),
	R_4501090000 ("4501090000", "Surat Berharga yang Diterbitkan oleh Lembaga Multinasional"),
	R_4501100000 ("4501100000", "Reksa Dana"),
	R_4501110000 ("4501110000", "Efek Beragun Aset"),
	R_4501120000 ("4501120000", "Dana Investasi Real Estat"),
	R_4501210000 ("4501210000", "Dana Investasi Infrastruktur Berbentuk Kontrak Investasi Kolekti"),
	R_4501130000 ("4501130000", "REPO"),
	R_4501140000 ("4501140000", "Penyertaan Langsung"),
	R_4501150000 ("4501150000", "Tanah, Bangunan dengan Hak Strata, atau Tanah dengan Bangunan, untuk Investasi"),
	R_4501160000 ("4501160000", "Pembiayaan Melalui Kerjasama dengan Pihak Lain"),
	R_4501170000 ("4501170000", "Emas Murni"),
	R_4501180000 ("4501180000", "Pinjaman yang Dijamin dengan Hak Tanggungan"),
	R_4501190000 ("4501190000", "Pinjaman Polis"),
	R_4501990000 ("4501990000", "Investasi Lain"),
	R_4501000000 ("4501000000", "Sub Total"),
//	R_4502000000 ("4502000000", "Penempatan Investasi Pada Afiliasi"),
	R_4502010000 ("4502010000", "Deposito Berjangka"),
	R_4502020000 ("4502020000", "Sertifikat Deposito"),
	R_4502030000 ("4502030000", "Saham"),
	R_4502040000 ("4502040000", "Obligasi Korporasi"),
	R_4502200000 ("4502200000", "Obligasi Daerah"),
	R_4502050000 ("4502050000", "MTN"),
	R_4502060000 ("4502060000", "Surat Berharga yang Diterbitkan oleh Negara RI"),
	R_4502070000 ("4502070000", "Surat Berharga yang Diterbitkan oleh Negara Selain Negara"),
	R_4502080000 ("4502080000", "Surat Berharga yang Diterbitkan oleh Bank Indonesia"),
	R_4502090000 ("4502090000", "Surat Berharga yang Diterbitkan oleh Lembaga Multinasional"),
	R_4502100000 ("4502100000", "Reksa Dana"),
	R_4502110000 ("4502110000", "Efek Beragun Aset"),
	R_4502120000 ("4502120000", "Dana Investasi Real Estat"),
	R_4502210000 ("4502210000", "Dana Investasi Infrastruktur Berbentuk Kontrak Investasi Kolekti"),
	R_4502130000 ("4502130000", "REPO"),
	R_4502140000 ("4502140000", "Penyertaan Langsung"),
	R_4502150000 ("4502150000", "Tanah, Bangunan dengan Hak Strata, atau Tanah dengan Bangunan, untuk Investasi"),
	R_4502160000 ("4502160000", "Pembiayaan Melalui Kerjasama dengan Pihak Lain"),
	R_4502170000 ("4502170000", "Emas Murni"),
	R_4502180000 ("4502180000", "Pinjaman yang Dijamin dengan Hak Tanggungan"),
	R_4502190000 ("4502190000", "Pinjaman Polis"),
	R_4502990000 ("4502990000", "Investasi Lain"),
	R_4502000099 ("4502000099", "Sub Total"),
	R_4503000000 ("4503000000", "Hasil Investasi Bruto"),
	R_4504000000 ("4504000000", "Beban Investasi"),
	R_4505000000 ("4505000000", "Hasil Investasi Neto"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3036PosLbAsruk205 eEnum : ER3036PosLbAsruk205.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}
	public static FieldValidation genFieldValidation5() {
		return UtilFieldValidation.genEqualsPosFormula("2+3+4", 
				UtilMetadata.genPipeRow(getObjects(), 0, 21) + "|" + 
						UtilMetadata.genPipeRow(getObjects(), 23, 44) + "|" + R_4504000000.key);
	}

	public static SegmentValidation genFormValidationHasilInvestasiNeto() {
		return UtilSegmentValidation.genEqualsForm("5", R_4505000000.key, EFormLaporanBulanan.LB_200.getCode(), "2", 
				ER3006PosLbAsruk200.R_5600000000.getKey());
	}
	
	public static SegmentValidation genValidationHasilInvestasiBruto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_4503000000.key, UtilMetadata.genPlusRow(getObjects(), new int[] { 22, 45 }), 
				"Total hasil investasi bruto|Penjumlahan hasil investasi bruto");
	}

	public static SegmentValidation genValidationHasilInvestasiNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_4505000000.key, UtilMetadata.genMinusRow(getObjects(), new int[] { 46, 47 }), 
				"Total hasil investasi neto|Penjumlahan hasil investasi neto");
	}
	
	public static SegmentValidation genValidationPenempatanInvestasiPadaAfiliasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_4502000099.key, UtilMetadata.genPlusRow(getObjects(), 23, 44), 
				"Total penempatan investasi pada afiliasi|Penjumlahan penempatan investasi pada afiliasi");
	}
	
	public static SegmentValidation genValidationPenempatanInvestasiPadaBukanAfiliasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_4501000000.key, UtilMetadata.genPlusRow(getObjects(), 0, 21), 
				"Total penempatan investasi pada bukan-afiliasi|Penjumlahan penempatan investasi pada bukan-afiliasi");
	}
}
