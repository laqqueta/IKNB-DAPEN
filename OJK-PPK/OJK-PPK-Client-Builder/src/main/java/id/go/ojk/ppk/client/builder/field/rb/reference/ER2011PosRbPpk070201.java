package id.go.ojk.ppk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.ppk.client.builder.field.EFormRencanaBisnis;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2011PosRbPpk070201 implements IObject<KeyValueString> {
//	R_07020101000000 ("07020101000000", "Penerimaan Pendanaan Baru:"),
	R_07020101010000 ("07020101010000", "Rupiah"),
	R_07020101020000 ("07020101020000", "Dollar Amerika Serikat (Dikonversikan ke dalam Rupiah)"),
	R_07020101030000 ("07020101030000", "Yen Jepang (Dikonversikan ke dalam Rupiah)"),
	R_07020101040000 ("07020101040000", "Mata Uang Lainnya (Dikonversikan ke dalam Rupiah)"),
	R_07020101050000 ("07020101050000", "Total Penerimaan Pendanaan Baru (Dikonversikan ke dalam Rupiah)"),
//	R_07020102000000 ("07020102000000", "Saldo Penerimaan Pendanaan (Outstanding):"),
	R_07020102010000 ("07020102010000", "Rupiah"),
	R_07020102020000 ("07020102020000", "Dollar Amerika Serikat (Dikonversikan ke dalam Rupiah)"),
	R_07020102030000 ("07020102030000", "Yen Jepang (Dikonversikan ke dalam Rupiah)"),
	R_07020102040000 ("07020102040000", "Mata Uang Lainnya (Dikonversikan ke dalam Rupiah)"), 
	R_07020102050000 ("07020102050000", "Total Saldo Penerimaan Pendanaan (Outstanding) (Dikonversikan ke dalam Rupiah)"),;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2011PosRbPpk070201 eEnum : ER2011PosRbPpk070201.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2011PosRbPpk070201.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2011PosRbPpk070201.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationFormPenerimaanPendanaanBaru() {
		String comparatorFormCode = EFormRencanaBisnis.RB_070101.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_07020101050000.key, comparatorFormCode, 
				ER2010PosRbPpk070101.R_07010101090000.getKey(), 
				"Total Penerimaan Pendanaan Baru|Total Penerimaan Pendanaan Baru form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormSaldoPenerimaanPendanaan() {
		String comparatorFormCode = EFormRencanaBisnis.RB_070101.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_07020102050000.key, comparatorFormCode, 
				ER2010PosRbPpk070101.R_07010102090000.getKey(), 
				"Rasio Saldo Penerimaan Pendanaan|Total Saldo Penerimaan Pendanaan form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationTotalPenerimaanPendanaanBaru() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_07020101050000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 3),
				"Total Penerimaan Pendanaan Baru|Penjumlahan Penerimaan Pendanaan Baru");
	}

	public static SegmentValidation genValidationTotalSaldoPenerimaanPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_07020102050000.key,
				UtilMetadata.genPlusRow(getObjects(), 5, 8),
				"Total Saldo Penerimaan Pendanaan|Penjumlahan Saldo Penerimaan Pendanaan");
	}
}
