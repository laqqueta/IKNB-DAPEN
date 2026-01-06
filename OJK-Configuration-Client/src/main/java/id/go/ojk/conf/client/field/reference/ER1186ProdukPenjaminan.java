package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1186ProdukPenjaminan implements IObject<KeyValueString> {
    R_1 ("EN:e3831", "Surety Bond Jaminan Penawaran"),
    R_2 ("EN:e3832", "Surety Bond Jaminan Pelaksanaan"),
    R_3 ("EN:e3833", "Surety Bond Uang Muka"),
    R_4 ("EN:e3834", "Surety Bond Jaminan Pemeliharaan"),
    R_5 ("EN:e3835", "Surety Bond Jaminan Lainnya"),
    R_6 ("EN:e3838", "Kontra Bank Garansi Bid Bonds"),
    R_7 ("EN:e3839", "Kontra Bank Garansi performance bonds"),
    R_8 ("EN:e3840", "Kontra Bank Garansi Advanced Payment Bonds"),
    R_9 ("EN:e3841", "Kontra Bank Garansi Shipping Guarantee"),
    R_10 ("EN:e3842", "Kontra Bank Garansi Standby L/C"),
    R_11 ("EN:e3843", "Kontra Bank Garansi Endorsement atas surat berharga"),
    R_12 ("EN:e3844", "Kontra Bank Garansi Custom Bonds"),
    R_13 ("EN:e3845", "Kontra Bank Garansi Excise Bonds"),
    R_14 ("EN:e3846", "Kontra Bank Garansi Jaminan Transaksi Dagang"),
    R_15 ("EN:e3847", "Kontra Bank Garansi Lainnya"),
    R_16 ("EN:e3848", "Penjaminan KUKPEDES"),
    R_17 ("EN:e3849", "Penjaminan Kredit/Pembiayaan Serba Guna"),
    R_18 ("EN:e3850", "Penjaminan Kredit/Pembiayaan Multiguna dan Multijasa"),
    R_19 ("EN:e3851", "Penjaminan Kredit/Pembiayaan Modal Kerja"),
    R_20 ("EN:e3852", "Penjaminan Kredit/Pembiayaan KPR"),
    R_21 ("EN:e3853", "Penjaminan Kredit/Pembiayaan Non Program UMKM"),
    R_22 ("EN:e3854", "Penjaminan Kredit/Pembiayaan Non Program Ultra Mikro"),
    R_23 ("EN:e3855", "Penjaminan Kredit/Pembiayaan Non Program Lainnya"),
    R_24 ("EN:e3856", "Penjaminan Kredit/Pembiayaan KUR – Super Mikro"),
    R_25 ("EN:e3857", "Penjaminan Kredit/Pembiayaan KUR – Mikro"),
    R_26 ("EN:e3858", "Penjaminan Kredit/Pembiayaan KUR – Kecil"),
    R_27 ("EN:e3859", "Penjaminan Kredit/Pembiayaan KUR – Penempatan Pekerja Migran Indonesia"),
    R_28 ("EN:e3860", "Penjaminan Kredit/Pembiayaan KUR – Khusus"),
    R_29 ("EN:e3861", "Penjaminan Kredit/Pembiayaan PEN"),
    R_30 ("EN:e3862", "Penjaminan Kredit/Pembiayaan Program Ultra Mikro"),
    R_31 ("EN:e3863", "Penjaminan Kredit/Pembiayaan Program Kepemilikan Rumah Bersubsidi"),
    R_32 ("EN:e3864", "Penjaminan Kredit/Pembiayaan Program Pemerintah Lainnya"),
    R_33 ("EN:e3865", "Penjaminan atas Kategori Usaha Keuangan Berkelanjutan"),
    R_34 ("EN:e3866", "Penjaminan Kredit/Pembiayaan Lainnya"),

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
		for (ER1186ProdukPenjaminan eEnum : ER1186ProdukPenjaminan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1186ProdukPenjaminan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1186ProdukPenjaminan.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1186ProdukPenjaminan[] eEnums = ER1186ProdukPenjaminan.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1186ProdukPenjaminan eEnum = ER1186ProdukPenjaminan.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
