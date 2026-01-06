package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1247SegmenPeserta implements IObject<KeyValueString> {
  R1 ("PST1", "Penerima Bantuan Iuran"),
  R2 ("PST2", "Peserta Bukan Pekerja"),
  R3 ("PST3", "Peserta Pekerja Mandiri"),
  R4 ("PST4", "Swasta"),
  R5 ("PST5", "Pegawai Negeri Sipil"),
  R6 ("PST6", "Penyelenggara Negara non PNS"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1247SegmenPeserta eEnum : ER1247SegmenPeserta.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1247SegmenPeserta.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1247SegmenPeserta.class.getSimpleName().substring(2, 6));
  }
}
