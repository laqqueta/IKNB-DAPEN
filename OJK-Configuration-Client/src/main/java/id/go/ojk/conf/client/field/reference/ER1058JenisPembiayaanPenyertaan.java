package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1058JenisPembiayaanPenyertaan implements IObject<KeyValueString> {
	R_AKe20 ("AK:e20", "Penyertaan Saham"),
	R_AKe21 ("AK:e21", "Penyertaan Melalui Pembelian Obligasi Konversi"),
	R_AKe22 ("AK:e22", "Pembiayaan Melalui Pembelian Surat Yang Diterbitkan Pasangan Usaha Pada Tahap Rintisan Awal (Start-Up) dan/atau Pengembangan Usaha"),
	R_AKe23 ("AK:e23", "Pembiayaan Usaha Produktif"),
	R_AKe28 ("AK:e28", "Kegiatan Usaha Lain Berdasarkan Persetujuan OJK"),
	R_AKe24 ("AK:e24", "Penyertaan Saham Berdasarkan Prinsip Syariah"),
	R_AKe25 ("AK:e25", "Pembelian Sukuk atau Obligasi Syariah Konversi"),
	R_AKe26 ("AK:e26", "Pembelian Sukuk dan Obligasi  Yang Diterbitkan Pasangan Usaha Pada Tahap Rintisan Awal (Start-Up) dan/atau Pengembangan Usaha"),
	R_AKe27 ("AK:e27", "Pembiayaan Berdasarkan Prinsip Bagi Hasil"),
	R_AKe45 ("AK:e45", "Kegiatan Usaha Berdasarkan Prinsip Syariah"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1058JenisPembiayaanPenyertaan eEnum : ER1058JenisPembiayaanPenyertaan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1058JenisPembiayaanPenyertaan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1058JenisPembiayaanPenyertaan.class.getSimpleName().substring(2, 6));
	}
}
