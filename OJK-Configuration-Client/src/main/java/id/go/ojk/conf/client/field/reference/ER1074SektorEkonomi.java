package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1074SektorEkonomi implements IObject<KeyValueString> {
	R_2301 ("2301", "Pertanian, kehutanan dan perikanan"),
	R_2302 ("2302", "Pertambangan dan penggalian"),
	R_2303 ("2303", "Industri pengolahan"),
	R_2304 ("2304", "Pengadaan listrik, gas, uap/air panas dan udara dingin"),
	R_2305 ("2305", "Pengadaan air, pengelolaan sampah dan daur ulang, pembuangan dan pembersihan limbah dan sampah"),
	R_2306 ("2306", "Konstruksi"),
	R_2307 ("2307", "Perdagangan besar dan eceran; reparasi dan perawatan mobil dan sepeda motor"),
	R_2308 ("2308", "Transportasi dan pergudangan"),
	R_2309 ("2309", "Penyediaan akomodasi dan penyediaan makan minum"),
	R_2310 ("2310", "Informasi dan komunikasi"),
	R_2311 ("2311", "Jasa keuangan dan asuransi"),
	R_2312 ("2312", "Real Estat"),
	R_2313 ("2313", "Jasa profesional, ilmiah dan teknis"),
	R_2314 ("2314", "Jasa persewaan dan sewa guna usaha tanpa hak opsi, ketenagakerjaan, agen perjalanan dan penunjang usaha lainnya"),
	R_2315 ("2315", "Administrasi pemerintahan, pertahanan dan jaminan sosial wajib"),
	R_2316 ("2316", "Jasa pendidikan"),
	R_2317 ("2317", "Jasa kesehatan dan kegiatan sosial"),
	R_2318 ("2318", "Kesenian, hiburan dan rekreasi"),
	R_2319 ("2319", "Kegiatan jasa lainnya"),
	R_2320 ("2320", "Jasa perorangan yang melayani rumah tangga; kegiatan yang menghasilkan barang dan jasa oleh rumah tangga yang digunakan sendiri untuk memenuhi kebutuhan"),
	R_2321 ("2321", "Kegiatan badan internasional dan badan ekstra internasional lainnya"),
	R_2322 ("2322", "Rumah tangga"),
	R_2323 ("2323", "Bukan Lapangan Usaha Lainnya"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1074SektorEkonomi eEnum : ER1074SektorEkonomi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1074SektorEkonomi.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1074SektorEkonomi.class.getSimpleName().substring(2, 6));
	}
}
