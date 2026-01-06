package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1210BuktiPemilikanTanahBangunan implements IObject<KeyValueString> {
  R1 ("BP:e01", "Girik"),
  R2 ("BP:e02", "Akta Jual Beli"),
  R3 ("BP:e03", "Sertifikat"),
  R4 ("BP:e04", "Lainnya"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1210BuktiPemilikanTanahBangunan eEnum : ER1210BuktiPemilikanTanahBangunan.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1210BuktiPemilikanTanahBangunan.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1210BuktiPemilikanTanahBangunan.class.getSimpleName().substring(2, 6));
  }
}
