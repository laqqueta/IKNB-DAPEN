package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1208PeringkatSuratBerharga implements IObject<KeyValueString> {
  R1 ("100", "100"),
  R2 ("101", "101"),
  R3 ("102", "102"),
  R4 ("103", "103"),
  R5 ("104", "104"),
  R6 ("105", "105"),
  R7 ("106", "106"),
  R8 ("200", "200"),
  R9 ("201", "201"),
  R10 ("202", "202"),
  R11 ("203", "203"),
  R12 ("204", "204"),
  R13 ("205", "205"),
  R14 ("206", "206"),
  R15 ("207", "207"),
  R16 ("208", "208"),
  R17 ("300", "300"),
  R18 ("301", "301"),
  R19 ("302", "302"),
  R20 ("303", "303"),
  R21 ("304", "304"),
  R22 ("305", "305"),
  R23 ("306", "306"),
  R24 ("307", "307"),
  R25 ("308", "308"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1208PeringkatSuratBerharga eEnum : ER1208PeringkatSuratBerharga.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1208PeringkatSuratBerharga.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1208PeringkatSuratBerharga.class.getSimpleName().substring(2, 6));
  }
}
