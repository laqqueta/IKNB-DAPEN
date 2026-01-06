package id.go.ojk.asruk.client.builder.field.lb.reference;

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
public enum ER3010PosLbAsruk501 implements IObject<KeyValueString> {
//	R_1400000000 ("1400000000", "INVESTASI", "0.00"),
//	R_1401000000 ("1401000000", "Deposito Berjangka", "0.00"),
	R_1401010000 ("1401010000", "Kategori Khusus (sampai dengan 2 milyar per bank)", "0.00"),
//	R_1401020000 ("1401020000", "Kategori Lain, sesuai peringkat Bank:", "0.00"),
	R_1401020100 ("1401020100", "a. Peringkat klaster 1", "1.20"),
	R_1401020200 ("1401020200", "b. Peringkat klaster 2", "2.10"),
	R_1401020300 ("1401020300", "c. Peringkat klaster 3", "3.00"),
	R_1401020400 ("1401020400", "d. Peringkat klaster 4", "4.50"),
	R_1401020500 ("1401020500", "e. Peringkat klaster 5", "9.00"),
//	R_1402000000 ("1402000000", "Sertifikat Deposito", "0.00"),
	R_1402010000 ("1402010000", "Kategori Khusus (sampai dengan 2 milyar per bank)", "0.00"),
//	R_1402020000 ("1402020000", "Kategori Lain, sesuai peringkat Bank:", "0.00"),
	R_1402020100 ("1402020100", "a. Peringkat klaster 1", "1.20"),
	R_1402020200 ("1402020200", "b. Peringkat klaster 2", "2.10"),
	R_1402020300 ("1402020300", "c. Peringkat klaster 3", "3.00"),
	R_1402020400 ("1402020400", "d. Peringkat klaster 4", "4.50"),
	R_1402020500 ("1402020500", "e. Peringkat klaster 5", "9.00"),
//	R_1404000000 ("1404000000", "Obligasi Korporasi", "0.00"),
	R_1404010000 ("1404010000", "a. Peringkat Klaster 1", "1.60"),
	R_1404020000 ("1404020000", "b. Peringkat Klaster 2", "2.80"),
	R_1404030000 ("1404030000", "c. Peringkat Klaster 3", "4.00"),
	R_1404040000 ("1404040000", "d. Peringkat Klaster 4", "6.00"),
	R_1404050000 ("1404050000", "e. Peringkat Klaster 5", "12.00"),
//	R_1410000000 ("1410000000", "Obligasi / Sukuk Daerah", "0.00"),
	R_1410010000 ("1410010000", "a. Peringkat Klaster 1", "1.60"),
	R_1410020000 ("1410020000", "b. Peringkat Klaster 2", "2.80"),
	R_1410030000 ("1410030000", "c. Peringkat Klaster 3", "4.00"),
	R_1410040000 ("1410040000", "d. Peringkat Klaster 4", "6.00"),
	R_1410050000 ("1410050000", "e. Peringkat Klaster 5", "12.00"),
//	R_1405000000 ("1405000000", "MTN", "0.00"),
	R_1405010000 ("1405010000", "a. Peringkat klaster 1", "1.60"),
	R_1405020000 ("1405020000", "b. Peringkat klaster 2", "2.80"),
	R_1405030000 ("1405030000", "c. Peringkat klaster 3", "4.00"),
	R_1405040000 ("1405040000", "d. Peringkat klaster 4", "6.00"),
	R_1405050000 ("1405050000", "e. Peringkat Klaster 5", "12.00"),
	R_1406000000 ("1406000000", "Surat Berharga Yang Diterbitkan oleh Negara RI", "0.00"),
//	R_1407000000 ("1407000000", "Surat Berharga Yang Diterbitkan oleh Negara selain Negara RI ", "0.00"),
	R_1407010000 ("1407010000", "a. Peringkat klaster 1", "1.60"),
	R_1407020000 ("1407020000", "b. Peringkat klaster 2", "2.80"),
	R_1407030000 ("1407030000", "c. Peringkat klaster 3", "4.00"),
	R_1407040000 ("1407040000", "d. Peringkat klaster 4", "6.00"),
	R_1407050000 ("1407050000", "e. Peringkat klaster 5", "12.00"),
	R_1408000000 ("1408000000", "Surat Berharga yang Diterbitkan oleh Bank Indonesia", "0.00"),
	R_1409000000 ("1409000000", "Surat Berharga yang Diterbitkan oleh Lembaga Multinasional", "0.00"),
	R_1413000000 ("1413000000", "Repurchase Agreement", "1.00"),
//	R_1416000000 ("1416000000", "Pembiayaan Melalui Kerjasama dengan Pihak Lain*", "0.00"),
	R_1416010000 ("1416010000", "a. Sangat Sehat", "1.60"),
	R_1416020000 ("1416020000", "b. Sehat", "2.80"),
	R_1416030000 ("1416030000", "c. Kurang Sehat", "4.00"),
	R_1416040000 ("1416040000", "d. Tidak Sehat", "6.00"),
//	R_1418000000 ("1418000000", "Pinjaman yang Dijamin dengan Hak Tanggungan", "0.00"),
//	R_1415010000 ("1415010000", "Properti residensial", "0.00"),
	R_1415010100 ("1415010100", "a. LTV = 65%", "2.80"),
	R_1415010200 ("1415010200", "b. 65%  LTV  75%", "4.00"),
//	R_1415020000 ("1415020000", "Properti komersial lainnya", "0.00"),
	R_1415020100 ("1415020100", "a. LTV = 65%", "5.60"),
	R_1415020200 ("1415020200", "b. 65%  LTV  75%", "8.00"),
	R_1415030000 ("1415030000", "Properti yang tidak digunakan", "12.00"),
	R_1419000000 ("1419000000", "Pinjaman Polis", "0.00"),
//	R_1500000000 ("1500000000", "BUKAN INVESTASI", "0.00"),
	R_1501000000 ("1501000000", "Kas dan Bank", "0.00"),
	R_1502000000 ("1502000000", "Tagihan Premi Penutupan Langsung", "8.00"),
//	R_1504000000 ("1504000000", "Aset Reasuransi", "0.00"),
	R_1504010000 ("1504010000", "a. aset yang bersumber dari nilai estimasi pemulihan klaim atas porsi pertanggungan ulang (dicharge dalam Risiko Kredit b)", "0.00"),
	R_1504020000 ("1504020000", "b. aset yang bersumber dari perjanjian kontrak jangka panjang program reasuransi dukungan modal (capital oriented reinsurance)", "30.00"),
//	R_1505000000 ("1505000000", "Tagihan Klaim Koasuransi", "0.00"),
	R_1505010000 ("1505010000", "Dalam Negeri", "2.80"),
//	R_1505020000 ("1505020000", "Luar Negeri:", "0.00"),
	R_1505020100 ("1505020100", "a. Peringkat klaster 1", "2.80"),
	R_1505020200 ("1505020200", "b. Peringkat klaster 2", "4.00"),
	R_1505020300 ("1505020300", "c. Peringkat klaster 3", "6.00"),
	R_1505020400 ("1505020400", "d. Peringkat klaster 4", "12.00"),
	R_1505020500 ("1505020500", "e. Peringkat klaster 5", "15.00"),
//	R_1503000000 ("1503000000", "Tagihan Premi Reasuransi ", "0.00"),
	R_1503010000 ("1503010000", "Dalam Negeri", "2.80"),
//	R_1503020000 ("1503020000", "Luar Negeri:", "0.00"),
	R_1503020100 ("1503020100", "a. Peringkat klaster 1", "2.80"),
	R_1503020200 ("1503020200", "b. Peringkat klaster 2", "4.00"),
	R_1503020300 ("1503020300", "c. Peringkat klaster 3", "6.00"),
	R_1503020400 ("1503020400", "d. Peringkat klaster 4", "12.00"),
	R_1503020500 ("1503020500", "e. Peringkat klaster 5", "15.00"),
//	R_1506000000 ("1506000000", "Tagihan Klaim Reasuransi", "0.00"),
	R_1506010000 ("1506010000", "Dalam Negeri", "2.80"),
//	R_1506020000 ("1506020000", "Luar Negeri:", "0.00"),
	R_1506020100 ("1506020100", "a. Peringkat klaster 1", "2.80"),
	R_1506020200 ("1506020200", "b. Peringkat klaster 2", "4.00"),
	R_1506020300 ("1506020300", "c. Peringkat klaster 3", "6.00"),
	R_1506020400 ("1506020400", "d. Peringkat klaster 4", "12.00"),
	R_1506020500 ("1506020500", "e. Peringkat klaster 5", "15.00"),
//	R_1507000000 ("1507000000", "Tagihan Investasi", "0.00"),
	R_1507010000 ("1507010000", "a. Investasi yang belum diterima pembayarannya pada tanggal jatuh tempo", "2.00"),
	R_1507020000 ("1507020000", "b. Investasi yang gagal bayar pada tanggal jatuh tempo/saat dicairkan", "25.00"),
	R_1508000000 ("1508000000", "Tagihan Hasil Investasi", "2.00"),
	R_7301010000 ("7301010000", "Total Risiko Kredit a", "0.00"),
	;
	
	private String key;
	private String value;
	private String field2;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3010PosLbAsruk501 eEnum : ER3010PosLbAsruk501.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3|4|5|6|7", getObjects());
	}

	public static ConditionalRequired genConditionalMustEmpty2() {
		return UtilFieldConditional.genExistPos("N", "M", R_7301010000.key);
	}
	public static ConditionalRequired genConditionalMustEmpty56() {
		return UtilFieldConditional.genExistPos("N", "M", 
				UtilMetadata.genPipeRow(getObjects(), 36, 70));
	}

	public static FieldValidation genFieldValidation2() {
		return UtilFieldValidation.genPosLookup("1", UtilMetadata.genPipeRow(getObjects(), 0, 70), getLookup());
	}
	
	public static FieldValidation genFieldValidation4() {
		return UtilFieldValidation.genPosPercentage("2|3",
				UtilMetadata.genPipeRow(getObjects(), 0, 70));
	}

	public static FieldValidation genFieldValidation6() {
		return UtilFieldValidation.genPosPercentage("2|5",
				UtilMetadata.genPipeRow(getObjects(), 0, 35));
	}
	
	public static FieldValidation genFieldValidation7a() {
		return UtilFieldValidation.genEqualsPosFormula("4+6",
				UtilMetadata.genPipeRow(getObjects(), 0, 35));
	}
	
	public static FieldValidation genFieldValidation7b() {
		return UtilFieldValidation.genEqualsPosFormula("4",
				UtilMetadata.genPipeRow(getObjects(), 36, 70));
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("3|4|5|6|7", R_7301010000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 70), "Total resiko kredit|Penjumlahan resiko kredit");
	}
	
	private static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER3010PosLbAsruk501[] eEnums = ER3010PosLbAsruk501.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER3010PosLbAsruk501 eEnum = ER3010PosLbAsruk501.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.field2);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
