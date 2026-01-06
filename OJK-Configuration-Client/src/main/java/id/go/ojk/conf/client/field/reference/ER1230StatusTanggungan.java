package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1230StatusTanggungan implements IObject<KeyValueString> {
  R1("10", "Peserta"),
  R2("20", "Suami/Istri"),
  R3("30", "Anak"),
  R4("40", "Tambahan"),;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1230StatusTanggungan eEnum : ER1230StatusTanggungan.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1230StatusTanggungan.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1230StatusTanggungan.class.getSimpleName().substring(2, 6));
  }
}
