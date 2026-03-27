package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1249SegmenPeserta implements IObject<KeyValueString> {
  R1 ("1.1", "Penyelenggara Negara Pekerja Penerima Upah"),
  R2 ("1.2", "Pegawai Swasta/Badan Usaha Milik Negara Pekerja Penerima Upah"),
  R3 ("1.3", "Pekerja Lain Pekerja Penerima Upah"),
  R4 ("2.1", "Pekerja Mandiri Pekerja Bukan Penerima Upah"),
  R5 ("2.2", "Pekerja Perorangan Pekerja Bukan Penerima Upah"),
  R6 ("2.3", "Pekerja Lain Pekerja Bukan Penerima Upah"),
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
