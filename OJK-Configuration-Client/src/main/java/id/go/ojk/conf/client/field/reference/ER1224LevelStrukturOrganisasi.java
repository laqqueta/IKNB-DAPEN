package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1224LevelStrukturOrganisasi implements IObject<KeyValueString> {
  R1 ("1", "Direksi"),
  R2 ("2", "Bidang"),
  R3 ("3", "Kedeputian Wilayah"),
  R4 ("4", "Cabang"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1224LevelStrukturOrganisasi eEnum : ER1224LevelStrukturOrganisasi.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1224LevelStrukturOrganisasi.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1224LevelStrukturOrganisasi.class.getSimpleName().substring(2, 6));
  }
}
