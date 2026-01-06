package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1005SkemaPembiayaan implements IObject<KeyValueString> {
	R_JKE16 ("JK:e16", "Sewa Pembiayaan (Finance Lease)"),
	R_JKE17 ("JK:e17", "Jual dan Sewa Balik (Sale and Leaseback)"),
	R_JKE18 ("JK:e18", "Anjak Piutang with Recourse"),
	R_JKE19 ("JK:e19", "Anjak Piutang without Recourse"),
	R_JKE21 ("JK:e21", "Pembiayaan Proyek"),
	R_JKE22 ("JK:e22", "Pembiayaan Infrastruktur"),
	R_JKE23 ("JK:e23", "Fasilitas Modal Usaha"),
	R_JKE66 ("JK:e66", "Fasilitas Dana"),
	R_JKE24 ("JK:e24", "Cara Pembiayaan Lain Dengan Persetujuan OJK"),
	R_JKE25 ("JK:e25", "Pembiayaan Jual Beli Berdasarkan Prinsip Syariah"),
	R_JKE26 ("JK:e26", "Murabahah"),
	R_JKE27 ("JK:e27", "Salam"),
	R_JKE28 ("JK:e28", "Istishna"),
	R_JKE29 ("JK:e29", "Pembiayaan Jual Beli dengan akad lainnya Berdasarkan Prinsip Syariah"),
	R_JKE30 ("JK:e30", "Pembiayaan Investasi Berdasarkan Prinsip Syariah"),
	R_JKE31 ("JK:e31", "Mudharabah"),
	R_JKE32 ("JK:e32", "Musyarakah"),
	R_JKE33 ("JK:e33", "Mudharabah Musytarakah"),
	R_JKE34 ("JK:e34", "Musyarakah Mutanaqisah"),
	R_JKE35 ("JK:e35", "pembiayaan Investasi dengan akad lainnya Berdasarkan Prinsip Syariah"),
	R_JKE36 ("JK:e36", "Pembiayaan jasa Berdasarkan Prinsip Syariah"),
	R_JKE37 ("JK:e37", "Ijarah"),
	R_JKE38 ("JK:e38", "Ijarah Muntahiyah Bittamlik"),
	R_JKE46 ("JK:e46", "Qardh"),
	R_JKE47 ("JK:e47", "Pembiayaan Jasa dengan Akad Lainnya Berdasarkan Prinsip Syariah"),
	R_JKE70 ("JK:e70", "Pembelian dengan Pembayaran secara Angsuran - Kartu Kredit"),
	R_JKE71 ("JK:e71", "Pembelian dengan Pembayaran secara Angsuran - Non Kartu Kredit"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1005SkemaPembiayaan eEnum : ER1005SkemaPembiayaan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1005SkemaPembiayaan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1005SkemaPembiayaan.class.getSimpleName().substring(2, 6));
	}
}
