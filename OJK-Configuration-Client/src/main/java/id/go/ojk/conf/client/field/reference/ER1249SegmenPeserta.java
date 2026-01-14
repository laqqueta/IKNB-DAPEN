package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1249SegmenPeserta implements IObject<KeyValueString> {
  R1 ("1.1", "Pekerja Penerima Upah, Penyelenggara Negara"),
  R2 ("1.2", "Pekerja Penerima Upah, Pegawai Swasta/Badan Usaha Milik Negara"),
  R3 ("1.3", "Pekerja Penerima Upah, Pekerja Lain"),
  R4 ("2.1", "Pekerja Bukan Penerima Upah, Pekerja Mandiri"),
  R5 ("2.2", "Pekerja Bukan Penerima Upah, Pekerja Perorangan"),
  R6 ("2.3", "Pekerja Bukan Penerima Upah, Pekerja Lain"),
  R7 ("3", "Pekerja Jasa Konstruksi"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1249SegmenPeserta eEnum : ER1249SegmenPeserta.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1249SegmenPeserta.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1249SegmenPeserta.class.getSimpleName().substring(2, 6));
  }
}
