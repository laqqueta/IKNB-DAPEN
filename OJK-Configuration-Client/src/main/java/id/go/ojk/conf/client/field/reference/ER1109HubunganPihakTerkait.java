package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1109HubunganPihakTerkait implements IObject<KeyValueString> {
	R_1 ("EN:e25", "Orang perseorangan atau badan usaha yang merupakan pengendali Perusahaan Pembiayaan"),
	R_2 ("EN:e26", "Badan usaha di mana Perusahaan Pembiayaan bertindak sebagai pengendali"),
	R_3 ("EN:e27", "Orang perseorangan atau badan usaha yang bertindak sebagai pengendali dari badan usaha sebagaimana dimaksud dalam sandi EN:e26 (Badan usaha di mana Perusahaan Pembiayaan bertindak sebagai pengendali)"),
	R_4 ("EN:e28", "Badan usaha yang pengendaliannya dilakukan oleh Orang perseorangan dan/atau badan usaha dalam Sandi EN:e25 (Orang perseorangan atau badan usaha yang merupakan pengendali Perusahaan Pembiayaan) atau Orang perseorangan dan/atau badan usaha dalam Sandi EN:e27 (Orang perseorangan atau badan usaha yang bertindak sebagai pengendali dari badan usaha sebagaimana dimaksud dalam sandi EN:e26 (Badan usaha di mana Perusahaan Pembiayaan bertindak sebagai pengendali))"),
	R_5 ("EN:e29", "Dewan komisaris atau Direksi Perusahaan Pembiayaan"),
	R_6 ("EN:e30", "Pihak yang mempunyai hubungan keluarga sampai derajat kedua, baik horizontal dan vertikal dari orang perseorangan yang merupakan pengendali dalam sandi EN:e25 (Orang perseorangan atau badan usaha yang merupakan pengendali Perusahaan Pembiayaan) dan/atau Dewan komisaris atau Direksi dalam Sandi EN:e29 (Dewan komisaris atau Direksi Perusahaan Pembiayaan)"),
	R_7 ("EN:e31", "Dewan komisaris atau Direksi pada badan usaha dalam Sandi EN:e25 (Orang perseorangan atau badan usaha yang merupakan pengendali Perusahaan Pembiayaan) sampai dengan Sandi EN:e28"),
	R_8 ("EN:e32", "Badan usaha yang Dewan komisaris atau Direksi adalah Dewan komisaris atau Direksi pada Perusahaan Pembiayaan atau Dewan komisaris atau Direksi pada badan usaha dalam Sandi EN:e25 (Orang perseorangan atau badan usaha yang merupakan pengendali Perusahaan Pembiayaan) sampai dengan Sandi EN:e28 (Badan usaha yang pengendaliannya dilakukan oleh Orang perseorangan dan/atau badan usaha dalam Sandi EN:e25 (Orang perseorangan atau badan usaha yang merupakan pengendali Perusahaan Pembiayaan) atau Orang perseorangan dan/atau badan usaha dalam Sandi EN:e27 (Orang perseorangan atau badan usaha yang bertindak sebagai pengendali dari badan usaha sebagaimana dimaksud dalam sandi EN:e26 (Badan usaha di mana Perusahaan Pembiayaan bertindak sebagai pengendali)))"),
	R_9 ("EN:e33", "Badan usaha dimana Dewan komisaris atau Direksi pada Perusahaan Pembiayaan sebagaimana Sandi EN:e29 (Dewan komisaris atau Direksi Perusahaan Pembiayaan) sebagai pengendali atau Dewan komisaris atau Direksi dalam Sandi EN:e25 (Orang perseorangan atau badan usaha yang merupakan pengendali Perusahaan Pembiayaan) sampai dengan Sandi EN:e28 bertindak sebagai pengendali"),
	R_10 ("EN:e34", "Badan usaha yang memiliki ketergantungan keuangan dengan Perusahaan Pembiayaan"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1109HubunganPihakTerkait eEnum : ER1109HubunganPihakTerkait.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1109HubunganPihakTerkait.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1109HubunganPihakTerkait.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1109HubunganPihakTerkait[] eEnums = ER1109HubunganPihakTerkait.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1109HubunganPihakTerkait eEnum = ER1109HubunganPihakTerkait.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
