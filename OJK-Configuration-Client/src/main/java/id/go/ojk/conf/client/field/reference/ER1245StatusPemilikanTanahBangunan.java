package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1245StatusPemilikanTanahBangunan implements IObject<KeyValueString> {
  R1 ("SP1", "Hak Milik (HM)"),
  R2 ("SP2", "Hak Guna Bangunan (HGB)"),
  R3 ("SP3", "Hak Guna Usaha (HGU)"),
  R4 ("SP4", "Hak Pakai (HP)"),
  R5 ("SP5", "Hak Milik Atas Satuan Rumah Susun (HMASRS)"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1245StatusPemilikanTanahBangunan eEnum : ER1245StatusPemilikanTanahBangunan.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1245StatusPemilikanTanahBangunan.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1245StatusPemilikanTanahBangunan.class.getSimpleName().substring(2, 6));
  }
}
