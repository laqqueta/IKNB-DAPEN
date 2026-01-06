package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1219JenisPiutangIuran implements IObject<KeyValueString> {
  R1 ("1100", "PIUTANG IURAN PEMERINTAH DAERAH"),
  R2 ("1200", "PIUTANG IURAN PNS DAERAH"),
  R3 ("1300", "PIUTANG IURAN PEGAWAI  NON PNS PEMERINTAH DAERAH"),
  R4 ("1400", "KONTRIBUSI IURAN PBI"),
  R5 ("1510", "Bantuan Iuran PBPU dan BP Kelas III"),
  R6 ("1520", "Bantuan Iuran PD Pemda"),
  R7 ("1600", "PIUTANG IURAN PENERIMA BANTUAN IURAN (PBI) DAERAH/JAMKESDA"),
  R8 ("2100", "PIUTANG IURAN PNS "),
  R9 ("2200", "PIUTANG IURAN TNI "),
  R10 ("2300", "PIUTANG IURAN POLRI"),
  R11 ("2400", "PIUTANG IURAN PPNPN PUSAT"),
  R12 ("2500", "PIUTANG IURAN PEMERINTAH PUSAT"),
  R13 ("2600", "PIUTANG IURAN PENSIUNAN PNS, TNI DAN POLRI"),
  R14 ("2700", "PIUTANG IURAN PESERTA BUKAN PENERIMA UPAH (PBPU)"),
  R15 ("3100", "PIUTANG IURAN BADAN USAHA (SWASTA)"),
  R16 ("3200", "KEPALA DESA DAN PERANGKAT DESA"),
  R17 ("3310", "Piutang Bantuan Iuran Pemerintah Pusat atas PBPU"),
  R18 ("3320", "Piutang Bantuan Iuran Pemerintah Pusat atas PD PEMDA"),
  R19 ("3400", "PIUTANG IURAN JPK EKS JAMSOSTEK"),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1219JenisPiutangIuran eEnum : ER1219JenisPiutangIuran.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1219JenisPiutangIuran.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1219JenisPiutangIuran.class.getSimpleName().substring(2, 6));
  }
}
