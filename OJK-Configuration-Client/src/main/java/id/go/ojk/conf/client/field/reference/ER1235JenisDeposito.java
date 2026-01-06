package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1235JenisDeposito implements IObject<KeyValueString> {
  R1 ("2002", "Deposito on call pada Bank"),
  R2 ("2003", "Deposito Berjangka pada Bank"),
  R3 ("2004", "Sertifikat Deposito pada Bank"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1235JenisDeposito eEnum : ER1235JenisDeposito.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1235JenisDeposito.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1235JenisDeposito.class.getSimpleName().substring(2, 6));
  }
}
