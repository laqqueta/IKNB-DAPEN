package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1115KategoriUsahaKeuanganBerkelanjutan implements IObject<KeyValueString> {
	R_1 ("EN:e3819", "Energi Terbarukan"),
	R_2 ("EN:e3820", "Efisiensi energi"),
	R_3 ("EN:e3821", "Pencegahan dan Pengendalian Polusi "),
	R_4 ("EN:e3822", "Pengelolaan Sumber Daya Alam Hayati dan Penggunaan Lahan Yang Berkelanjutan "),
	R_5 ("EN:e3823", "Konservasi Keanekaragaman Hayati Darat dan Air "),
	R_6 ("EN:e3824", "Transportasi Ramah Lingkungan "),
	R_7 ("EN:e3825", "Pengelolaan Air dan Air Limbah yang Berkelanjutan "),
	R_8 ("EN:e3826", "Adaptasi perubahan iklim"),
	R_9 ("EN:e3827", "Produk yang Dapat Mengurangi Penggunaan Sumber Daya Dan Menghasilkan Sedikit Polusi (Eco-efficient) "),
	R_10 ("EN:e3828", "Bangunan Berwawasan Lingkungan yang Memenuhi Standar atau Sertifikasi yang Diakui secara Nasional, Regional, atau Internasional "),
	R_11 ("EN:e3829", "Kegiatan Usaha dan/atau Kegiatan Lain yang Berwawasan Lingkungan Lainnya "),
	R_12 ("EN:e3830", "Kegiatan Usaha Mikro, Kecil, dan Menengah (UMKM)"),
	R_13 ("EN:e3881", "Tidak Termasuk Kategori Usaha Keuangan Berkelanjutan"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1115KategoriUsahaKeuanganBerkelanjutan eEnum : ER1115KategoriUsahaKeuanganBerkelanjutan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1115KategoriUsahaKeuanganBerkelanjutan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1115KategoriUsahaKeuanganBerkelanjutan.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1115KategoriUsahaKeuanganBerkelanjutan[] eEnums = ER1115KategoriUsahaKeuanganBerkelanjutan.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1115KategoriUsahaKeuanganBerkelanjutan eEnum = ER1115KategoriUsahaKeuanganBerkelanjutan.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
