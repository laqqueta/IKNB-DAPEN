package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1216StatusPemilikanTanahBangunan implements IObject<KeyValueString> {
  R1 ("SP:e531", "Hak Milik (HM)"),
  R2 ("SP:e532", "Hak Guna Bangunan (HGB)"),
  R3 ("SP:e533", "Hak Guna Usaha (HGU)"),
  R4 ("SP:e535", "Hak Pakai (HP)"),
  R5 ("SP:e536", "Hak Milik Atas Satuan Rumah Susun (HMASRS)"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1216StatusPemilikanTanahBangunan eEnum : ER1216StatusPemilikanTanahBangunan.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1216StatusPemilikanTanahBangunan.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1216StatusPemilikanTanahBangunan.class.getSimpleName().substring(2, 6));
  }
}
