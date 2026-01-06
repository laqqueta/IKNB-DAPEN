package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1213TujuanKepemilikan implements IObject<KeyValueString> {
  R1 ("TK:e51", "Dimiliki Hingga Jatuh Tempo (Held To Maturity/HTM)"),
  R2 ("TK:e52", "Diperdagangkan (Held for Trading/Trading)"),
  R3 ("TK:e53", "Tersedia Untuk Dijual (Available For Sale/AFS)"),
  R4 ("TK:e55", "Pengaruh Signifikan"),
  R5 ("TK:e56", "Tidak Memiliki Pengaruh Signifikan"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1213TujuanKepemilikan eEnum : ER1213TujuanKepemilikan.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1213TujuanKepemilikan.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1213TujuanKepemilikan.class.getSimpleName().substring(2, 6));
  }
}
