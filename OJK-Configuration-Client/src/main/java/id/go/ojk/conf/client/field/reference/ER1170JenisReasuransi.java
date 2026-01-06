package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1170JenisReasuransi implements IObject<KeyValueString> {
	R_1 ("JR:e01","Asuransi atas risiko kegagalan ekspor"),
	R_2 ("JR:e02","Asuransi atas risiko kegagalan bayar"),
	R_3 ("JR:e03","Asuransi atas investasi yang dilakukan oleh perusahaan Indonesia di luar negeri"),
	R_4 ("JR:e04","Asuransi atas risiko politik di suatu negara yang menjadi tujuan ekspor"),
	R_5 ("JR:e05","Penjaminan bagi eksportir Indonesia atas pembayaran yang diterima dari pembeli barang dan/atau jasa di luar negeri"),
	R_6 ("JR:e06","Penjaminan bagi importir barang dan jasa Indonesia di luar negeri atas pembayaran yang telah diberikan atau akan diberikan kepada eksportir Indonesia untuk pembiayaan kontrak ekspor atas penjualan barang dan/atau jasa atau pemenuhan pekerjaan atau jasa yang dilakukan oleh suatu perusahaan Indonesia"),
	R_7 ("JR:e07","Penjaminan bagi bank yang menjadi mitra penyediaan pembiayaan transaksi ekspor yang telah diberikan kepada eksportir Indonesia"),
	R_8 ("JR:e08","Penjaminan dalam rangka tender terkait dengan pelaksanaan proyek yang seluruhnya atau sebagian merupakan kegiatan yang menunjang ekspor"),
	;

	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1170JenisReasuransi eEnum : ER1170JenisReasuransi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1170JenisReasuransi.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1170JenisReasuransi.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1170JenisReasuransi[] eEnums = ER1170JenisReasuransi.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1170JenisReasuransi eEnum = ER1170JenisReasuransi.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
