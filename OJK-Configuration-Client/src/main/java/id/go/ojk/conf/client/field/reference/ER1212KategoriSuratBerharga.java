package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1212KategoriSuratBerharga implements IObject<KeyValueString> {
  R1 ("SB:e1101", "Setara Kas"),
  R2 ("SB:e1102", "Jangka Pendek"),
  R3 ("SB:e1103", "Jatuh Tempo"),
  R4 ("SB:e1104", "Setara Kas"),
  R5 ("SB:e1105", "Jangka Pendek"),
  R6 ("SB:e1106", "Jatuh Tempo"),
  R7 ("SB:e1701", "OBLIGASI JATUH TEMPO ≤ 1 TAHUN"),
  R8 ("SB:e1702", "OBLIGASI JATUH TEMPO > 1 TAHUN"),
  R9 ("SB:e1703", "OBLIGASI JATUH TEMPO"),
  R10 ("SB:e2001", "Reksadana Kelompok FVT OCI Sukuk"),
  R11 ("SB:e2002", "Reksadana Kelompok FVT OCI"),
  R12 ("SB:e2003", "Reksadana Kelompok FVTPL"),
  R13 ("SB:e1801", "SAHAM DIPERDAGANGKAN"),
  R14 ("SB:e1802", "SAHAM TERSEDIA DIJUAL"),
  R15 ("SB:e1803", "SAHAM DIMILIKI UNTUK DIJUAL"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1212KategoriSuratBerharga eEnum : ER1212KategoriSuratBerharga.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1212KategoriSuratBerharga.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1212KategoriSuratBerharga.class.getSimpleName().substring(2, 6));
  }
}
