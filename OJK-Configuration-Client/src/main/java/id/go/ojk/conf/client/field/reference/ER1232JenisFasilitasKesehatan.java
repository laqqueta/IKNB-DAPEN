package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1232JenisFasilitasKesehatan implements IObject<KeyValueString> {
  R1("10", "FKTP - Puskesmas"),
  R2("11", "FKTP - Dokter Praktik Perorangan"),
  R3("12", "FKTP - Klinik Pratama"),
  R4("13", "FKTP - Rumah Sakit Kelas D-Pratama"),
  R5("14", "FKTP - Apotik"),
  R6("15", "FKTP - Lainnya"),
  R7("16", "FKTL - Rumah Sakit Pemerintah Kelas A"),
  R8("17", "FKTL - Rumah Sakit Pemerintah Kelas B"),
  R9("18", "FKTL - Rumah Sakit Pemerintah Kelas C"),
  R10("19", "FKTL - Rumah Sakit Pemerintah Kelas D"),
  R11("20", "FKTL - Rumah Sakit Swasta Kelas A"),
  R12("21", "FKTL - Rumah Sakit Swasta Kelas B"),
  R13("22", "FKTL - Rumah Sakit Swasta Kelas C"),
  R14("23", "FKTL - Rumah Sakit Swasta Kelas D"),
  R15("24", "FKTL - Rumah Sakit TNI Tingkat I"),
  R16("25", "FKTL - Rumah Sakit TNI Tingkat II"),
  R17("26", "FKTL - Rumah Sakit TNI Tingkat III"),
  R18("27", "FKTL - Rumah Sakit TNI Tingkat IV"),
  R19("28", "FKTL - Rumah Sakit POLRI Tingkat I"),
  R20("29", "FKTL - Rumah Sakit POLRI Tingkat II"),
  R21("30", "FKTL - Rumah Sakit POLRI Tingkat III"),
  R22("31", "FKTL - Rumah Sakit POLRI Tingkat IV"),
  R23("32", "FKRTL - Rumah Sakit Khusus Non Jiwa"),
  R24("33", "FKRTL - Rumah Sakit Khusus Jiwa"),
  R25("34", "FKTL - Klinik Utama"),
  R26("35", "FKTL - Apotik"),
  R27("36", "FKTL - Optik"),
  R28("37", "FKTL - Lainnya"),;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1232JenisFasilitasKesehatan eEnum : ER1232JenisFasilitasKesehatan.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1232JenisFasilitasKesehatan.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1232JenisFasilitasKesehatan.class.getSimpleName().substring(2, 6));
  }
}
