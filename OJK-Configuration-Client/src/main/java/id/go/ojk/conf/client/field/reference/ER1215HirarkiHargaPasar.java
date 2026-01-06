package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1215HirarkiHargaPasar implements IObject<KeyValueString> {
  R1 ("HI:e01", "Harga Dikutip/Kuotasi Harga Pasar Aktif"),
  R2 ("HI:e02", "Pasar yang dapat diamati"),
  R3 ("HI:e03", "Model Perhitungan (appraisal)"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1215HirarkiHargaPasar eEnum : ER1215HirarkiHargaPasar.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1215HirarkiHargaPasar.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1215HirarkiHargaPasar.class.getSimpleName().substring(2, 6));
  }
}
