package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1222SegmenPeserta implements IObject<KeyValueString> {
  R1 ("1", "Penerima Bantuan Iuran "),
  R2 ("2", "Pekerja Penerima Upah (PPU) - ASN"),
  R3 ("3", "PPU – TNI/POLRI/ASN Kemhan/Polri"),
  R4 ("4", "PPU – Pejabat Negara (PN)"),
  R5 ("5", "PPU- Pegawai Pemerintah Non PNS "),
  R6 ("6", "PPU – Pegawai Swasta/BUMN/Lainnya"),
  R7 ("7", "PPU- Pekerja Penerima Upah selain sandi "),
  R8 ("8", "Warga Asing bekerja >=6 bulan "),
  R9 ("9", "Pekerja Bukan Penerima Upah (PBPU) – Pekerja Mandiri (PM) "),
  R10 ("10", "PBPU selain PM"),
  R11 ("11", "Bukan Pekerja (BP) – Investor"),
  R12 ("12", "BP – Pemberi Kerja "),
  R13 ("13", "BP – Penerima Pensiun (PP)"),
  R14 ("14", "BP – Veteran "),
  R15 ("15", "BP – Perintis Kemerdekaan (PK)"),
  R16 ("16", "BP – Mampu Bayar Lainnya"),
  R17 ("17", "Jamkesda dan PJKMU Askes (transisi) "),
  ;

  private String key;
  private String value;

  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER1222SegmenPeserta eEnum : ER1222SegmenPeserta.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getName() {
    return ER1222SegmenPeserta.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER1222SegmenPeserta.class.getSimpleName().substring(2, 6));
  }
}
