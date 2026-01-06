package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1185JenisPenjaminan implements IObject<KeyValueString> {
	R_1 ("BJ:e137", "Penjaminan Kredit Produktif – UMKM"),
	R_2 ("BJ:e138", "Penjaminan Kredit Produktif – Non UMKM"),
	R_3 ("BJ:e139", "Penjaminan Lainnya – Penjaminan atas surat utang"),
	R_4 ("BJ:e140", "Penjaminan Lainnya – Penjaminan pembelian secara angsuran"),
	R_5 ("BJ:e141", "Penjaminan Lainnya – Penjaminan transaksi dagang"),
	R_6 ("BJ:e142", "Penjaminan Lainnya – Penjaminan pengadaan barang dan/atau jasa (surety bond)"),
	R_7 ("BJ:e143", "Penjaminan Lainnya – Penjaminan bank garansi (kontra bank garansi)"),
	R_8 ("BJ:e144", "Penjaminan Lainnya – Penjaminan surat kredit berdokumen dalam negeri"),
	R_9 ("BJ:e145", "Penjaminan Lainnya – Penjaminan letter of credit"),
	R_10 ("BJ:e146", "Penjaminan Lainnya – Penjaminan kepabeanan (customs bond)"),
	R_11 ("BJ:e147", "Penjaminan Lainnya – Penjaminan cukai"),
	R_12 ("BJ:e148", "Penjaminan Lainnya – Pemberian jasa konsultasi manajemen terkait dengan kegiatan usaha penjaminan"),
	R_13 ("BJ:e149", "Penjaminan Lainnya – Kegiatan usaha lainnya setelah mendapat persetujuan dari Otoritas Jasa Keuangan"),
	R_14 ("BJ:e150", "Penjaminan Non Produktif"),
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
		for (ER1185JenisPenjaminan eEnum : ER1185JenisPenjaminan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1185JenisPenjaminan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1185JenisPenjaminan.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1185JenisPenjaminan[] eEnums = ER1185JenisPenjaminan.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1185JenisPenjaminan eEnum = ER1185JenisPenjaminan.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
