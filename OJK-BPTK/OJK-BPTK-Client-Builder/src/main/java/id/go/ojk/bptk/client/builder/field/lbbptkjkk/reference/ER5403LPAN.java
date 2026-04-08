package id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjkk;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5403LPAN implements IObject<KeyValueString> {
  LPAN0200000000("LPAN0200000000", "Saldo Awal Aset Neto Tanpa Pembatasan dari Pemberi Sumberdaya"),
  LPAN0201000000("LPAN0201000000", "Penyesuaian PSAK Baru, Aset Neto Tanpa Pembatasan dari Pemberi Sumberdaya"),
  LPAN0300000000("LPAN0300000000", "Saldo Awal Setelah Penyesuaian, Aset Neto Tanpa Pembatasan dari Pemberi Sumberdaya"),
  LPAN0400000000("LPAN0400000000", "Surplus (Defisit) Tahun Berjalan, Aset Neto Tanpa Pembatasan dari Pemberi Sumberdaya"),
  LPAN0500000000("LPAN0500000000", "Aset Neto yang Dibebaskan dari Pembatasan, Aset Neto Tanpa Pembatasan dari Pemberi Sumberdaya"),
  LPAN0600000000("LPAN0600000000", "Saldo Akhir Aset Neto Tanpa Pembatasan dari Pemberi Sumberdaya"),
  LPAN0800000000("LPAN0800000000", "Saldo Awal Penghasilan Komperensif Lain"),
  LPAN0900000000("LPAN0900000000", "Penghasilan Komprehensif Tahun Berjalan, Penghasilan Komperensif Lain"),
  LPAN1000000000("LPAN1000000000", "Saldo Akhir Penghasilan Komperensif Lain"),
  LPAN1100000000("LPAN1100000000", "Jumlah Penghasilan Komprehensif Lain"),
  LPAN1300000000("LPAN1300000000", "Saldo Awal Aset Neto Dengan Pembatasan Dari Pemberi Sumber Daya"),
  LPAN1301000000("LPAN1301000000", "Penyesuaian PSAK Baru, Aset Neto Dengan Pembatasan Dari Pemberi Sumber Daya"),
  LPAN1400000000("LPAN1400000000", "Saldo Awal Setelah Penyesuaian, Aset Neto Dengan Pembatasan Dari Pemberi Sumber Daya"),
  LPAN1500000000("LPAN1500000000", "Surplus (defisit) Tahun Berjalan, Aset Neto Dengan Pembatasan Dari Pemberi Sumber Daya"),
  LPAN1600000000("LPAN1600000000", "Aset Neto Yang Dibebaskan Dari Pembatasan, Aset Neto Dengan Pembatasan Dari Pemberi Sumber Daya"),
  LPAN1700000000("LPAN1700000000", "Saldo Akhir Aset Neto Dengan Pembatasan Dari Pemberi Sumber Daya"),
  LPAN1800000000("LPAN1800000000", "Jumlah Aset Neto"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5403LPAN.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5403LPAN.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLbbptkjkk.LPAN.getCode() + key;
  }

  public String getValue() {
    String marker = ". ";
    value = StringUtils.strip(value, "-").trim();
    int idx = value.indexOf(marker);
    return idx > -1 ? value.substring(idx + 1).trim() : value;
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public KeyValueString getObjectForm() {
    return new KeyValueString(getKeyForm(), getValue(), new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5403LPAN eEnum : ER5403LPAN.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5403LPAN eEnum : ER5403LPAN.values()) {
      res.add(eEnum.getObjectForm());
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
    return UtilMetadata.genFieldSave("2", getObjects());
  }

  public static SegmentValidation genRowValidation07() {
    int[] rows = { 2, 3, 4 };
    return genPlusValidation("2", LPAN0600000000, rows);
  };

  public static SegmentValidation genRowValidation11() {
    int[] rows = { 5, 8 };
    return genPlusValidation("2", LPAN1100000000, rows);
  };

  public static SegmentValidation genRowValidation18() {
    int[] rows = { 9, 15 };
    return genPlusValidation("2", LPAN1800000000, rows);
  };

  private static SegmentValidation genPlusValidation(String selectField, IObject<KeyValueString> pos, int[] rows) {
    return UtilSegmentValidation.genEqualsFormula(selectField, pos.getObject().getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(pos.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }
}
