package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1015Dati1 implements IObject<KeyValueString> {
	R_E248 ("e248", "ProvinsiJawaBarat"),
	R_E249 ("e249", "ProvinsiBanten"),
	R_E250 ("e250", "DaerahKhususIbukotaJakarta"),
	R_E251 ("e251", "DaerahIstimewaYogyakarta"),
	R_E252 ("e252", "ProvinsiJawaTengah"),
	R_E253 ("e253", "ProvinsiJawaTimur"),
	R_E254 ("e254", "ProvinsiBengkulu"),
	R_E255 ("e255", "ProvinsiJambi"),
	R_E256 ("e256", "ProvinsiNangroeAcehDarussalam"),
	R_E257 ("e257", "ProvinsiSumateraUtara"),
	R_E258 ("e258", "ProvinsiSumateraBarat"),
	R_E259 ("e259", "ProvinsiRiau"),
	R_E260 ("e260", "ProvinsiSumateraSelatan"),
	R_E261 ("e261", "ProvinsiKepulauanBangkaBelitung"),
	R_E262 ("e262", "ProvinsiKepulauanRiau"),
	R_E263 ("e263", "ProvinsiLampung"),
	R_E264 ("e264", "ProvinsiKalimantanSelatan"),
	R_E265 ("e265", "ProvinsiKalimantanBarat"),
	R_E266 ("e266", "ProvinsiKalimantanTimur"),
	R_E267 ("e267", "ProvinsiKalimantanTengah"),
	R_E268 ("e268", "ProvinsiSulawesiTengah"),
	R_E269 ("e269", "ProvinsiSulawesiSelatan"),
	R_E270 ("e270", "ProvinsiSulawesiUtara"),
	R_E271 ("e271", "ProvinsiGorontalo"),
	R_E272 ("e272", "ProvinsiSulawesiBarat"),
	R_E273 ("e273", "ProvinsiSulawesiTenggara"),
	R_E274 ("e274", "ProvinsiNusaTenggaraBarat"),
	R_E275 ("e275", "ProvinsiBali"),
	R_E276 ("e276", "ProvinsiNusaTenggaraTimur"),
	R_E277 ("e277", "ProvinsiMaluku"),
	R_E278 ("e278", "ProvinsiPapua"),
	R_E279 ("e279", "ProvinsiMalukuUtara"),
	R_E280 ("e280", "ProvinsiPapuaBarat"),
	R_E796 ("e796", "ProvinsiKalimantanUtara"),
	R_E244 ("e244", "ProvinsiPapuaTengah"),
	R_E245 ("e245", "ProvinsiPapuaPegunungan"),
	R_E246 ("e246", "ProvinsiPapuaSelatan"),
	R_E247 ("e247", "ProvinsiPapuaBaratDaya"),
	R_LOE1 ("LO_e1", "LuarNegeri"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1015Dati1 eEnum : ER1015Dati1.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1015Dati1.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1015Dati1.class.getSimpleName().substring(2, 6));
	}
}
