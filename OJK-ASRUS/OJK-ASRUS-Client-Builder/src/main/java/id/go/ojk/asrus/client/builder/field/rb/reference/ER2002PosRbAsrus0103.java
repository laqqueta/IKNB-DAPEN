package id.go.ojk.asrus.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2002PosRbAsrus0103 implements IObject<KeyValueString> {
	R_0103010000 ("0103010000", "Aset"),
	R_0103020000 ("0103020000", "Investasi"),
	R_0103030000 ("0103030000", "Liabilitas"),
	R_0103040000 ("0103040000", "Hasil Investasi"),
	R_0103050000 ("0103050000", "Akumulasi Dana Investasi Peserta"),
	R_0103060000 ("0103060000", "Kontribusi Alokasi Dana Investasi Peserta"),
	R_0103070000 ("0103070000", "Penarikan Dana Investasi Peserta yang telah jatuh tempo"),
	R_0103080000 ("0103080000", "Penarikan/Penebusan Dana Investasi Peserta (belum jatuh tempo)"),
	;
	
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2002PosRbAsrus0103 eEnum : ER2002PosRbAsrus0103.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2002PosRbAsrus0103.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2002PosRbAsrus0103.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
