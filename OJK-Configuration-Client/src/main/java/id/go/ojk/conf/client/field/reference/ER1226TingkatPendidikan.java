package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1226TingkatPendidikan implements IObject<KeyValueString> {
  R1 ("9110", "SD - Kantor Pusat"),
  R2 ("9120", "SMP - Kantor Pusat"),
  R3 ("9130", "SMA - Kantor Pusat"),
  R4 ("9140", "D1 - Kantor Pusat"),
  R5 ("9150", "D2 - Kantor Pusat"),
  R6 ("9160", "D3 - Kantor Pusat"),
  R7 ("9170", "S1/D4 - Kantor Pusat"),
  R8 ("9180", "S2 - Kantor Pusat"),
  R9 ("9190", "S3 - Kantor Pusat"),
  R10 ("9200", "Tenaga Asing - Kantor Pusat"),
  R11 ("9210", "SD - Selain Kantor Pusat"),
  R12 ("9220", "SMP - Selain Kantor Pusat"),
  R13 ("9230", "SMA - Selain Kantor Pusat"),
  R14 ("9240", "D1 - Selain Kantor Pusat"),
  R15 ("9250", "D2 - Selain Kantor Pusat"),
  R16 ("9260", "D3 - Selain Kantor Pusat"),
  R17 ("9270", "S1/D4 - Selain Kantor Pusat"),
  R18 ("9280", "S2 - Selain Kantor Pusat"),
  R19 ("9290", "S3 - Selain Kantor Pusat"),
  R20 ("9300", "Tenaga Asing - Selain Kantor Pusat"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1226TingkatPendidikan eEnum : ER1226TingkatPendidikan.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1226TingkatPendidikan.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1226TingkatPendidikan.class.getSimpleName().substring(2, 6));
  }
}
