package id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5111LKPS implements IObject<KeyValueString> {
  LKPS0100000000("LKPS0100000000", "Penerima Bantuan Iuran"),
  LKPS0200000000("LKPS0200000000", "Pekerja Penerima Upah (PPU)-ASN"),
  LKPS0300000000("LKPS0300000000", "PPU- TNI/POLRI/ASN Kemhan/Polri"),
  LKPS0400000000("LKPS0400000000", "PPU- Pejabat Negara (PN)"),
  LKPS0500000000("LKPS0500000000", "PPU- Pegawai Pemerintah Non ASN"),
  LKPS0600000000("LKPS0600000000", "PPU- Pegawai Swasta/BUMN/Lainnya"),
  LKPS0700000000("LKPS0700000000", "PPU- Pekerja Penerima Upah selain sandi"),
  LKPS0800000000("LKPS0800000000", "Warga Asing bekerja >= 6 bulan"),
  LKPS0900000000("LKPS0900000000", "Pekerja Bukan Penerima Upah (PBPU) - Pekerja Mandiri (PM)"),
  LKPS1000000000("LKPS1000000000", "PBPU selain PM"),
  LKPS1100000000("LKPS1100000000", "Bukan Pekerja (BP) - Investor"),
  LKPS1200000000("LKPS1200000000", "BP - Pemberi Kerja"),
  LKPS1300000000("LKPS1300000000", "BP - Penerima Pensiun (PP)"),
  LKPS1400000000("LKPS1400000000", "BP - Veteran"),
  LKPS1500000000("LKPS1500000000", "BP - Perintis Kemerdekaan (PK)"),
  LKPS1600000000("LKPS1600000000", "BP - Mampu Bayar Lainnya"),
  LKPS1700000000("LKPS1700000000", "Jamkesda dan PJKMU Askes (transisi)"),
  LKPS1800000000("LKPS1800000000", "Jumlah"),;

  @Getter
  private String key;
  private String value;

  public static final int[] POS_TOTAL = { 2 };

  public static String getName() {
    return ER5111LKPS.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5111LKPS.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5111LKPS eEnum : ER5111LKPS.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genRequiredPos() {
    return UtilMetadata.genPipeRow(getObjects());
  }

  public static String genUniquePos() {
    return UtilMetadata.genPipeRow(getObjects());
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(POS_TOTAL), getObjects());
  }

  public static SegmentValidation genValidationTotal() {
    int[] rows = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    KeyValueString posCode = LKPS1800000000.getObject();
    String selectField = "2";

    String plusRows = UtilMetadata.genPlusRow(getObjects(), rows);
    String plusRowsDesc = UtilMetadata.genPlusDesc(getObjects(), rows);
    return UtilSegmentValidation.genEqualsFormula(selectField, posCode.getKey(), plusRows,
        UtilMetadata.genMessage(posCode.getValue(), plusRowsDesc));
  }
}
