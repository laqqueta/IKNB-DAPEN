package id.go.ojk.pmvk.client.builder.field.rb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pmvk.client.builder.field.EFormRealisasiBisnisUus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2753PosRePmvu040301 implements IObject<KeyValueString> {
//	R_04030101000000 ("04030101000000", "Pembiayaan/Penyertaan Baru:"),
	R_04030101010000 ("04030101010000", "Jawa Barat"),
	R_04030101020000 ("04030101020000", "Banten"),
	R_04030101030000 ("04030101030000", "Daerah Khusus Ibukota Jakarta"),
	R_04030101040000 ("04030101040000", "Daerah Istimewa Yogyakarta"),
	R_04030101050000 ("04030101050000", "Jawa Tengah"),
	R_04030101060000 ("04030101060000", "Jawa Timur"),
	R_04030101070000 ("04030101070000", "Bengkulu"),
	R_04030101080000 ("04030101080000", "Jambi"),
	R_04030101090000 ("04030101090000", "Nanggroe Aceh Darussalam"),
	R_04030101100000 ("04030101100000", "Sumatera Utara"),
	R_04030101110000 ("04030101110000", "Sumatera Barat"),
	R_04030101120000 ("04030101120000", "Riau"),
	R_04030101130000 ("04030101130000", "Sumatera Selatan"),
	R_04030101140000 ("04030101140000", "Kepulauan Bangka Belitung"),
	R_04030101150000 ("04030101150000", "Kepulauan Riau"),
	R_04030101160000 ("04030101160000", "Lampung"),
	R_04030101170000 ("04030101170000", "Kalimantan Selatan"),
	R_04030101180000 ("04030101180000", "Kalimantan Barat"),
	R_04030101190000 ("04030101190000", "Kalimantan Timur"),
	R_04030101200000 ("04030101200000", "Kalimantan Tengah"),
	R_04030101210000 ("04030101210000", "Kalimantan Utara"),
	R_04030101220000 ("04030101220000", "Sulawesi Tengah"),
	R_04030101230000 ("04030101230000", "Sulawesi Selatan"),
	R_04030101240000 ("04030101240000", "Sulawesi Utara"),
	R_04030101250000 ("04030101250000", "Gorontalo"),
	R_04030101260000 ("04030101260000", "Sulawesi Barat"),
	R_04030101270000 ("04030101270000", "Sulawesi Tenggara"),
	R_04030101280000 ("04030101280000", "Nusa Tenggara Barat"),
	R_04030101290000 ("04030101290000", "Bali"),
	R_04030101300000 ("04030101300000", "Nusa Tenggara Timur"),
	R_04030101310000 ("04030101310000", "Maluku"),
	R_04030101320000 ("04030101320000", "Maluku Utara"),
	R_04030101330000 ("04030101330000", "Papua"),
	R_04030101340000 ("04030101340000", "Papua Barat"),
	R_04030101350000 ("04030101350000", "Di Luar Indonesia"),
	R_04030101360000 ("04030101360000", "Total Rencana Penyaluran Pembiayaan Baru"),
//	R_04030102000000 ("04030102000000", "Saldo Posisi (Outstanding Principal):"),
	R_04030102010000 ("04030102010000", "Jawa Barat"),
	R_04030102020000 ("04030102020000", "Banten"),
	R_04030102030000 ("04030102030000", "Daerah Khusus Ibukota Jakarta"),
	R_04030102040000 ("04030102040000", "Daerah Istimewa Yogyakarta"),
	R_04030102050000 ("04030102050000", "Jawa Tengah"),
	R_04030102060000 ("04030102060000", "Jawa Timur"),
	R_04030102070000 ("04030102070000", "Bengkulu"),
	R_04030102080000 ("04030102080000", "Jambi"),
	R_04030102090000 ("04030102090000", "Nanggroe Aceh Darussalam"),
	R_04030102100000 ("04030102100000", "Sumatera Utara"),
	R_04030102110000 ("04030102110000", "Sumatera Barat"),
	R_04030102120000 ("04030102120000", "Riau"),
	R_04030102130000 ("04030102130000", "Sumatera Selatan"),
	R_04030102140000 ("04030102140000", "Kepulauan Bangka Belitung"),
	R_04030102150000 ("04030102150000", "Kepulauan Riau"),
	R_04030102160000 ("04030102160000", "Lampung"),
	R_04030102170000 ("04030102170000", "Kalimantan Selatan"),
	R_04030102180000 ("04030102180000", "Kalimantan Barat"),
	R_04030102190000 ("04030102190000", "Kalimantan Timur"),
	R_04030102200000 ("04030102200000", "Kalimantan Tengah"),
	R_04030102210000 ("04030102210000", "Kalimantan Utara"),
	R_04030102220000 ("04030102220000", "Sulawesi Tengah"),
	R_04030102230000 ("04030102230000", "Sulawesi Selatan"),
	R_04030102240000 ("04030102240000", "Sulawesi Utara"),
	R_04030102250000 ("04030102250000", "Gorontalo"),
	R_04030102260000 ("04030102260000", "Sulawesi Barat"),
	R_04030102270000 ("04030102270000", "Sulawesi Tenggara"),
	R_04030102280000 ("04030102280000", "Nusa Tenggara Barat"),
	R_04030102290000 ("04030102290000", "Bali"),
	R_04030102300000 ("04030102300000", "Nusa Tenggara Timur"),
	R_04030102310000 ("04030102310000", "Maluku"),
	R_04030102320000 ("04030102320000", "Maluku Utara"),
	R_04030102330000 ("04030102330000", "Papua"),
	R_04030102340000 ("04030102340000", "Papua Barat"),
	R_04030102350000 ("04030102350000", "Di Luar Indonesia"),
	R_04030102360000 ("04030102360000", "Total Saldo Posisi (Outstanding Principal)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2753PosRePmvu040301 eEnum : ER2753PosRePmvu040301.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2753PosRePmvu040301.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2753PosRePmvu040301.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4", getObjects());
	}
	
	public static FieldValidation genValidationSum() {
		return UtilFieldValidation.genEqualsPosFormula("3-2", 0, UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 35, 71 }));
	}

	public static SegmentValidation genValidationTotalRencanaPenyaluranPembiayaanBaru() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_04030101360000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 34),
				"Total Rencana Penyaluran Pembiayaan Baru|Penjumlahan Rencana Penyaluran Pembiayaan Baru");
	}

	public static SegmentValidation genValidationTotalSaldoPosisi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_04030102360000.key, 
				UtilMetadata.genPlusRow(getObjects(), 36, 70),
				"Total Saldo Posisi (Outstanding Principal)|Penjumlahan Saldo Posisi (Outstanding Principal)");
	}

	public static SegmentValidation genValidationFormTotalRencanaPenyaluranPembiayaanBaru() {
		String comparatorFormCode = EFormRealisasiBisnisUus.RE_040102.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_04030101360000.key, comparatorFormCode, 
				ER2751PosRePmvu040102.R_04010201060000.getKey(), 
				"Total Rencana Penyaluran Pembiayaan Baru|Total Rencana Investasi Modal Ventura Berdasarkan Prinsip Syariah Baru form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormTotalSaldoPosisi() {
		String comparatorFormCode = EFormRealisasiBisnisUus.RE_040102.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_04030102360000.key, comparatorFormCode, 
				ER2751PosRePmvu040102.R_04010202060000.getKey(), 
				"Total Saldo Posisi (Outstanding Principal)|Total Saldo Posisi (Outstanding Principal) form " + comparatorFormCode + " #kolom#");
	}
}
