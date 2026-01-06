package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1246PenurunanNilai implements IObject<KeyValueString> {
  R1 ("Ya", "Ya"),
  R2 ("Tidak", "Tidak"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1246PenurunanNilai eEnum : ER1246PenurunanNilai.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1246PenurunanNilai.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1246PenurunanNilai.class.getSimpleName().substring(2, 6));
  }
}
