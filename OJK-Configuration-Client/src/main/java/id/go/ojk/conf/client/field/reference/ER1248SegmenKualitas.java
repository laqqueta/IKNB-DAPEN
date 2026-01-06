package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1248SegmenKualitas implements IObject<KeyValueString> {
  R1 ("KL1", "Kurang dari 30 hari"),
  R2 ("KL2", "31 hari - 90 hari"),
  R3 ("KL3", "91 hari - 180 hari"),
  R4 ("KL4", "181 hari - 270 hari"),
  R5 ("KL5", "271 hari - 365 hari"),
  R6 ("KL6", "Di atas 365 hari"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1248SegmenKualitas eEnum : ER1248SegmenKualitas.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1248SegmenKualitas.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1248SegmenKualitas.class.getSimpleName().substring(2, 6));
  }
}
