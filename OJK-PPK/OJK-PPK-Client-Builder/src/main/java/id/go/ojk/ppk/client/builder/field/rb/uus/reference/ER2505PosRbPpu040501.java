package id.go.ojk.ppk.client.builder.field.rb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.ppk.client.builder.field.EFormRencanaBisnisUus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2505PosRbPpu040501 implements IObject<KeyValueString> {
//	R_04050101000000 ("04050101000000", "Rencana Penyaluran Pembiayaan Baru:"),
	R_04050101010000 ("04050101010000", "Jawa Barat"), 
	R_04050101020000 ("04050101020000", "Banten"),
	R_04050101030000 ("04050101030000", "Daerah Khusus Ibukota Jakarta"),
	R_04050101040000 ("04050101040000", "Daerah Istimewa Yogyakarta"), 
	R_04050101050000 ("04050101050000", "Jawa Tengah"),
	R_04050101060000 ("04050101060000", "Jawa Timur"), 
	R_04050101070000 ("04050101070000", "Bengkulu"),
	R_04050101080000 ("04050101080000", "Jambi"), 
	R_04050101090000 ("04050101090000", "Nanggroe Aceh Darussalam"),
	R_04050101100000 ("04050101100000", "Sumatera Utara"), 
	R_04050101110000 ("04050101110000", "Sumatera Barat"),
	R_04050101120000 ("04050101120000", "Riau"), 
	R_04050101130000 ("04050101130000", "Sumatera Selatan"),
	R_04050101140000 ("04050101140000", "Kepulauan Bangka Belitung"), 
	R_04050101150000 ("04050101150000", "Kepulauan Riau"),
	R_04050101160000 ("04050101160000", "Lampung"), 
	R_04050101170000 ("04050101170000", "Kalimantan Selatan"),
	R_04050101180000 ("04050101180000", "Kalimantan Barat"), 
	R_04050101190000 ("04050101190000", "Kalimantan Timur"),
	R_04050101200000 ("04050101200000", "Kalimantan Tengah"), 
	R_04050101210000 ("04050101210000", "Kalimantan Utara"),
	R_04050101220000 ("04050101220000", "Sulawesi Tengah"), 
	R_04050101230000 ("04050101230000", "Sulawesi Selatan"),
	R_04050101240000 ("04050101240000", "Sulawesi Utara"), 
	R_04050101250000 ("04050101250000", "Gorontalo"),
	R_04050101260000 ("04050101260000", "Sulawesi Barat"), 
	R_04050101270000 ("04050101270000", "Sulawesi Tenggara"),
	R_04050101280000 ("04050101280000", "Nusa Tenggara Barat"), 
	R_04050101290000 ("04050101290000", "Bali"),
	R_04050101300000 ("04050101300000", "Nusa Tenggara Timur"), 
	R_04050101310000 ("04050101310000", "Maluku"),
	R_04050101320000 ("04050101320000", "Maluku Utara"), 
	R_04050101330000 ("04050101330000", "Papua"),
	R_04050101340000 ("04050101340000", "Papua Barat"), 
	R_04050101350000 ("04050101350000", "Di Luar Indonesia"),
	R_04050101360000 ("04050101360000", "Total Rencana Penyaluran Pembiayaan Baru"),
//	R_04050102000000 ("04050102000000", "Saldo Piutang Pembiayaan (Outstanding Principal):"),
	R_04050102010000 ("04050102010000", "Jawa Barat"), 
	R_04050102020000 ("04050102020000", "Banten"),
	R_04050102030000 ("04050102030000", "Daerah Khusus Ibukota Jakarta"),
	R_04050102040000 ("04050102040000", "Daerah Istimewa Yogyakarta"), 
	R_04050102050000 ("04050102050000", "Jawa Tengah"),
	R_04050102060000 ("04050102060000", "Jawa Timur"), 
	R_04050102070000 ("04050102070000", "Bengkulu"),
	R_04050102080000 ("04050102080000", "Jambi"), 
	R_04050102090000 ("04050102090000", "Nanggroe Aceh Darussalam"),
	R_04050102100000 ("04050102100000", "Sumatera Utara"), 
	R_04050102110000 ("04050102110000", "Sumatera Barat"),
	R_04050102120000 ("04050102120000", "Riau"), 
	R_04050102130000 ("04050102130000", "Sumatera Selatan"),
	R_04050102140000 ("04050102140000", "Kepulauan Bangka Belitung"), 
	R_04050102150000 ("04050102150000", "Kepulauan Riau"),
	R_04050102160000 ("04050102160000", "Lampung"), 
	R_04050102170000 ("04050102170000", "Kalimantan Selatan"),
	R_04050102180000 ("04050102180000", "Kalimantan Barat"), 
	R_04050102190000 ("04050102190000", "Kalimantan Timur"),
	R_04050102200000 ("04050102200000", "Kalimantan Tengah"), 
	R_04050102210000 ("04050102210000", "Kalimantan Utara"),
	R_04050102220000 ("04050102220000", "Sulawesi Tengah"), 
	R_04050102230000 ("04050102230000", "Sulawesi Selatan"),
	R_04050102240000 ("04050102240000", "Sulawesi Utara"), 
	R_04050102250000 ("04050102250000", "Gorontalo"),
	R_04050102260000 ("04050102260000", "Sulawesi Barat"), 
	R_04050102270000 ("04050102270000", "Sulawesi Tenggara"),
	R_04050102280000 ("04050102280000", "Nusa Tenggara Barat"), 
	R_04050102290000 ("04050102290000", "Bali"),
	R_04050102300000 ("04050102300000", "Nusa Tenggara Timur"), 
	R_04050102310000 ("04050102310000", "Maluku"),
	R_04050102320000 ("04050102320000", "Maluku Utara"), 
	R_04050102330000 ("04050102330000", "Papua"),
	R_04050102340000 ("04050102340000", "Papua Barat"), 
	R_04050102350000 ("04050102350000", "Di Luar Indonesia"),
	R_04050102360000 ("04050102360000", "Total Saldo Piutang Pembiayaan (Outstanding Principal)"),;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2505PosRbPpu040501 eEnum : ER2505PosRbPpu040501.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2505PosRbPpu040501.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2505PosRbPpu040501.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationFormRencanaPenyaluranPembiayaanBaru() {
		String comparatorFormCode = EFormRencanaBisnisUus.RB_040102.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_04050101360000.key, comparatorFormCode, 
				ER2501PosRbPpu040102.R_04010201040000.getKey(), "Total Rencana Penyaluran Pembiayaan Baru|Total Rencana Penyaluran Pembiayaan Syariah Baru form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormSaldoPiutangPembiayaan() {
		String comparatorFormCode = EFormRencanaBisnisUus.RB_040102.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_04050102360000.key, comparatorFormCode, 
				ER2501PosRbPpu040102.R_04010202040000.getKey(), "Total Saldo Piutang Pembiayaan (Outstanding Principal)|Total Saldo Piutang Pembiayaan Syariah (Outstanding Principal) form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationTotalRencanaPenyaluranPembiayaanBaru() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_04050101360000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 34),
				"Total Rencana Penyaluran Pembiayaan Baru|Penjumlahan Rencana Penyaluran Pembiayaan Baru");
	}

	public static SegmentValidation genValidationTotalSaldoPiutangPembiayaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_04050102360000.key,
				UtilMetadata.genPlusRow(getObjects(), 36, 70),
				"Total Saldo Piutang Pembiayaan (Outstanding Principal)|Penjumlahan Saldo Piutang Pembiayaan (Outstanding Principal)");
	}
}
