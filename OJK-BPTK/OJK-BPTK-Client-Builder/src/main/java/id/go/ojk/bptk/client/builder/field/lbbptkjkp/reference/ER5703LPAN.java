package id.go.ojk.bptk.client.builder.field.lbbptkjkp.reference;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjkp;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5703LPAN implements IObject<KeyValueString> {
  LPAN0101000000("LPAN0101000000", "Saldo Awal Aset Neto Tanpa Pembatasan dari Pemberi Sumberdaya"),
  LPAN0102000000("LPAN0102000000", "Surplus (defisit) tahun berjalan, Aset Neto Tanpa Pembatasan dari Pemberi Sumberdaya"),
  LPAN0103000000("LPAN0103000000", "Aset neto yang dibebaskan dari pembatasan, Aset Neto Tanpa Pembatasan dari Pemberi Sumberdaya"),
  LPAN0104000000("LPAN0104000000", "Saldo Akhir Aset Neto Tanpa Pembatasan dari Pemberi Sumberdaya"),
  LPAN0201000000("LPAN0201000000", "Saldo Awal Penghasilan Komprehensif Lain"),
  LPAN0202000000("LPAN0202000000", "Penghasilan komprehensif tahun berjalan Penghasilan Komprehensif Lain"),
  LPAN0203000000("LPAN0203000000", "Saldo Akhir Penghasilan Komprehensif Lain"),
  LPAN0300000000("LPAN0300000000", "Jumlah Aset Neto Tanpa Pembatasan dari Pemberi Sumberdaya"),
  LPAN0401000000("LPAN0401000000", "Saldo Awal Aset Neto Dengan Pembatasan Dari Pemberi Sumber Daya"),
  LPAN0402000000("LPAN0402000000", "Surplus (defisit) tahun berjalan, Aset Neto Dengan Pembatasan Dari Pemberi Sumber Daya"),
  LPAN0403000000("LPAN0403000000", "Aset neto yang dibebaskan dari pembatasan, Aset Neto Dengan Pembatasan Dari Pemberi Sumber Daya"),
  LPAN0404000000("LPAN0404000000", "Saldo Akhir Aset Neto Dengan Pembatasan Dari Pemberi Sumber Daya"),
  LPAN0406000000("LPAN0406000000", "Saldo Awal Penghasilan Komprehensif Lain"),
  LPAN0407000000("LPAN0407000000", "Penghasilan komprehensif tahun berjalan Penghasilan Komprehensif Lain"),
  LPAN0408000000("LPAN0408000000", "Saldo Akhir Penghasilan Komprehensif Lain"),
  LPAN0409000000("LPAN0409000000", "Jumlah Aset Neto Dengan Pembatasan Dari Pemberi Sumber Daya"),
  LPAN0500000000("LPAN0500000000", "Total Aset Neto"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5703LPAN.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5703LPAN.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLbbptkjkp.LPAN.getCode() + key;
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
    for (ER5703LPAN eEnum : ER5703LPAN.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5703LPAN eEnum : ER5703LPAN.values()) {
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

  public static SegmentValidation genRowValidation05() {
    int[] rows = { 0, 1, 2 };
    return genPlusValidation("2", LPAN0104000000, rows);
  };

  public static SegmentValidation genRowValidation08() {
    int[] rows = { 4, 5 };
    return genPlusValidation("2", LPAN0203000000, rows);
  };

  public static SegmentValidation genRowValidation09() {
    int[] rows = { 3, 6 };
    return genPlusValidation("2", LPAN0300000000, rows);
  };

  public static SegmentValidation genRowValidation13() {
    int[] rows = { 8, 9, 10 };
    return genPlusValidation("2", LPAN0404000000, rows);
  };

  public static SegmentValidation genRowValidation16() {
    int[] rows = { 12, 13 };
    return genPlusValidation("2", LPAN0408000000, rows);
  };

  public static SegmentValidation genRowValidation17() {
    int[] rows = { 11, 14 };
    return genPlusValidation("2", LPAN0409000000, rows);
  };

  public static SegmentValidation genRowValidation18() {
    int[] rows = { 7, 15 };
    return genPlusValidation("2", LPAN0500000000, rows);
  };

  private static SegmentValidation genPlusValidation(String selectField, IObject<KeyValueString> pos, int[] rows) {
    return UtilSegmentValidation.genEqualsFormula(selectField, pos.getObject().getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(pos.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }
}
