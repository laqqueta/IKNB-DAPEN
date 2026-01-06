package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1238JenisSuratBerharga implements IObject<KeyValueString> {
  R1 ("2005", "Surat Berharga yang diterbitkan oleh Bank Indonesia"),
  R2 ("2006", "Surat Berharga Negara"),
  R3 ("2007", "Saham yang tercatat di Bursa Efek di Indonesia"),
  R4 ("2008", "Obligasi korporasi yang tercatat di bursa efek di indonesia "),
  R5 ("2009", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
  R6 ("2010", "Obligasi/Sukuk Daerah "),
  R7 ("2011", "Reksa Dana"),
  R8 ("2012", "MTN"),
  R9 ("2013", "Efek Beragun Aset "),
  R10 ("2014", "Dana investasi real estat berbentuk kontrak investasi kolektif "),
  R11 ("2015", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
  R12 ("2016", "Kontrak opsi dan kontrak berjangka efek yang tercatat di Bursa Efek di Indonesia"),
  R13 ("2017", "REPO "),
  R14 ("2018", "Penyertaan langsung"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1238JenisSuratBerharga eEnum : ER1238JenisSuratBerharga.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1238JenisSuratBerharga.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1238JenisSuratBerharga.class.getSimpleName().substring(2, 6));
  }
}
