package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1207JenisKepemilikan implements IObject<KeyValueString> {
  R1 ("JK:e10", "BUMN"),
  R2 ("JK:e20", "BUMD"),
  R3 ("JK:e30", "Anak Perusahaan BUMN/BUMD"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1207JenisKepemilikan eEnum : ER1207JenisKepemilikan.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1207JenisKepemilikan.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1207JenisKepemilikan.class.getSimpleName().substring(2, 6));
  }
}
