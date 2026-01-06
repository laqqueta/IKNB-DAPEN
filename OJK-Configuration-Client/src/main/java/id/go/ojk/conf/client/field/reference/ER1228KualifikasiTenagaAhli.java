package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1228KualifikasiTenagaAhli implements IObject<KeyValueString> {
  R1 ("5000", "Aktuaria - FSAI/ASAI/Lainnya"),
  R2 ("5001", "Akutansi, Audit dan Keuangan - CFA/WMI/CPA/CISA/ Akuntan/CA/QIA/ CFE/CIA/Lainnya"),
  R3 ("5002", "Asuransi dan Manajemen Risiko - AAIJ/AAAIJ/AAIK/AAAIK/ FLMI/ANZIF/ACII/BSMR/ AAK/AAAK/CRMP/Lainnya"),
  R4 ("5003", "Kesehatan - Dokter/Dokter Spesialis/Lainnya"),
  R5 ("5004", "Teknologi Informasi - Vendor Spesifik/Non Vendor Spesifik/Lainnya"),
  R6 ("5005", "Lainnya"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1228KualifikasiTenagaAhli eEnum : ER1228KualifikasiTenagaAhli.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1228KualifikasiTenagaAhli.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1228KualifikasiTenagaAhli.class.getSimpleName().substring(2, 6));
  }
}
