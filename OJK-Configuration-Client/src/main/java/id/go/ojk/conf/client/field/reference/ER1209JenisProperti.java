package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1209JenisProperti implements IObject<KeyValueString> {
  R1 ("JP:e01", "Tanah"),
  R2 ("JP:e02", "Bangunan"),
  R3 ("JP:e03", "Tanah dan Bangunan"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1209JenisProperti eEnum : ER1209JenisProperti.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1209JenisProperti.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1209JenisProperti.class.getSimpleName().substring(2, 6));
  }
}
