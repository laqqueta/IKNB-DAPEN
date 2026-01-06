package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1233JenisKlaim implements IObject<KeyValueString> {
  R1 ("1", "Rawat Jalan Tingkat Pertama (RJTP) Kapitasi"),
  R2 ("2", "Klaim Non Kapitasi"),
  R3 ("3", "Rawat Inap Tingkat Pertama (RITP)"),
  R4 ("4", "Rawat Inap Tingkat Lanjutan (RITL) Ina CBGs"),
  R5 ("5", "Rawat Jalan Tingkat Lanjutan (RJTL) Ina CBGs"),
  R6 ("6", "Klaim Non Ina CBGs"),;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1233JenisKlaim eEnum : ER1233JenisKlaim.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1233JenisKlaim.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1233JenisKlaim.class.getSimpleName().substring(2, 6));
  }
}
