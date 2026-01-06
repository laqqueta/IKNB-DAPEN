package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1223StatusKepemilikanGedungUnitUsaha implements IObject<KeyValueString> {
  R1 ("ST:e1", "Sewa"),
  R2 ("ST:e2", "Milik Sendiri"),
  R3 ("ST:e5", "Pinjam Pakai"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1223StatusKepemilikanGedungUnitUsaha eEnum : ER1223StatusKepemilikanGedungUnitUsaha.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1223StatusKepemilikanGedungUnitUsaha.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1223StatusKepemilikanGedungUnitUsaha.class.getSimpleName().substring(2, 6));
  }
}
