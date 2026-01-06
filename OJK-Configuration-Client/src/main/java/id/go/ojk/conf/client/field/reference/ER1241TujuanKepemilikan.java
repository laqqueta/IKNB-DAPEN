package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1241TujuanKepemilikan implements IObject<KeyValueString> {
  R1 ("TJP1", "Dimiliki Hingga Jatuh Tempo (Held To Maturity / HTM)"),
  R2 ("TJP2", "Diperdagangkan (Held for Trading / Trading)"),
  R3 ("TJP3", "Tersedia Untuk Dijual (Available For Sale / AFS)"),
  R4 ("TJP4", "Pengaruh Signifikan"),
  R5 ("TJP5", "Tidak Memiliki Pengaruh Signifikan"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1241TujuanKepemilikan eEnum : ER1241TujuanKepemilikan.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1241TujuanKepemilikan.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1241TujuanKepemilikan.class.getSimpleName().substring(2, 6));
  }
}
