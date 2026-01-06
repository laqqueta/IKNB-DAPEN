package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1227BidangKeahlian implements IObject<KeyValueString> {
  R1 ("1", "Aktuaria"),
  R2 ("2", "Akuntansi, Audit dan Keuangan"),
  R3 ("3", "Asuransi dan Manajemen Risiko"),
  R4 ("4", "Dokter"),
  R5 ("5", "Teknologi Informasi"),
  R6 ("6", "Lainnya"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1227BidangKeahlian eEnum : ER1227BidangKeahlian.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1227BidangKeahlian.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1227BidangKeahlian.class.getSimpleName().substring(2, 6));
  }
}
