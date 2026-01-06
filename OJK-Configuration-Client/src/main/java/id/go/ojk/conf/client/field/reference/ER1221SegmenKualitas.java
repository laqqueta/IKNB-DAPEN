package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1221SegmenKualitas implements IObject<KeyValueString> {
  R1 ("1", "Kurang dari 30 hari"),
  R2 ("2", "31 hari - 90 hari"),
  R3 ("3", "91 hari - 180 hari"),
  R4 ("4", "181 hari - 270 hari"),
  R5 ("5", "271 hari - 365 hari"),
  R6 ("6", "Di atas 365 hari"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1221SegmenKualitas eEnum : ER1221SegmenKualitas.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1221SegmenKualitas.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1221SegmenKualitas.class.getSimpleName().substring(2, 6));
  }
}
