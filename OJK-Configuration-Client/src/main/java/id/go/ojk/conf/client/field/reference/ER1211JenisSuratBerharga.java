package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1211JenisSuratBerharga implements IObject<KeyValueString> {
  R1 ("SB:e11", "Deposito"),
  R2 ("SB:e12", "Sertifikat Deposito"),
  R3 ("SB:e13", "SBI/SBIs"),
  R4 ("SB:e14", "SBN-SUN-SPN"),
  R5 ("SB:e15", "SBN-SUN-ON"),
  R6 ("SB:e16", "SBN-SBSN"),
  R7 ("SB:e17", "Obligasi"),
  R8 ("SB:e18", "Saham"),
  R9 ("SB:e21", "Reksadana-KIK EBA"),
  R10 ("SB:e22", "Reksadana-DIRE"),
  R11 ("SB:e23", "Reksadana-Lainnya"),
  R12 ("SB:e31", "Repo"),
  R13 ("SB:e35", "Lainnya"),
	;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1211JenisSuratBerharga eEnum : ER1211JenisSuratBerharga.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1211JenisSuratBerharga.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1211JenisSuratBerharga.class.getSimpleName().substring(2, 6));
  }
}
