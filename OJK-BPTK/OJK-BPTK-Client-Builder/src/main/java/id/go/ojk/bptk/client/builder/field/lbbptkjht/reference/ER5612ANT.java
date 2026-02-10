package id.go.ojk.bptk.client.builder.field.lbbptkjht.reference;

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
public enum ER5612ANT implements IObject<KeyValueString> {
  ANT0101000000("ANT0101000000", "Penerima upah dan pekerja migran Indonesia"),
  ANT0102000000("ANT0102000000", "Bukan penerima upah"),
  ANT0103000000("ANT0103000000", "Total"),
  ANT0201000000("ANT0201000000", "Penerima upah"),
  ANT0202000000("ANT0202000000", "Bukan penerima upah"),
  ANT0203000000("ANT0203000000", "Pekerja migran Indonesia"),
  ANT0204000000("ANT0204000000", "Total"),
  ANT0301000000("ANT0301000000", "Penerima upah"),
  ANT0400000000("ANT0400000000", "JUMLAH"),
  ANT0500000000("ANT0500000000", "Surplus (defisit) awal periode"),
  ANT0601000000("ANT0601000000", "Hasil pengembangan - realized"),
  ANT0602000000("ANT0602000000", "Hasil pengembangan - unrealized"),
  ANT0603000000("ANT0603000000", "Total"),
  ANT0701000000("ANT0701000000", "Hasil pengembangan atas klaim tahun berjalan"),
  ANT0702000000("ANT0702000000", "Distribusi hasil pengembangan JHT"),
  ANT0703000000("ANT0703000000", "Total"),
  ANT0800000000("ANT0800000000", "Surplus/Defisit"),
  ANT0900000000("ANT0900000000", "Jumlah"),
  ANT1001000000("ANT1001000000", "Layanan konvensional"),
  ANT1002000000("ANT1002000000", "Layanan syariah"),;

  @Getter
  private String key;
  private String value;

  public static final int[] ALL_COLS = { 2, 3 };

  public static String getName() {
    return ER5612ANT.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5612ANT.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5612ANT eEnum : ER5612ANT.values()) {
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
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(ALL_COLS), getObjects());
  }

  public static SegmentValidation genRegexValidation01() {
    return UtilSegmentValidation.genRegexNumericNegative(UtilMetadata.genPipeColumn(ALL_COLS),
        UtilMetadata.genPipeRow(getObjects(), 0, 17));
  }

  public static SegmentValidation genRegexValidation02() {
    return UtilSegmentValidation.genRegexNumericDotNegative(UtilMetadata.genPipeColumn(ALL_COLS),
        UtilMetadata.genPipeRow(getObjects(), 18, 19));
  }

  public static SegmentValidation genRowValidation04() {
    int[] rows = { 0, 1 };
    return genPlusValidation(UtilMetadata.genPipeColumn(ALL_COLS), ANT0103000000, rows);
  };

  public static SegmentValidation genRowValidation08() {
    int[] rows = { 3, 4, 5 };
    return genPlusValidation(UtilMetadata.genPipeColumn(ALL_COLS), ANT0204000000, rows);
  };

  public static SegmentValidation genRowValidation10() {
    int[] rows = { 2, 6, 7 };
    return genPlusValidation(UtilMetadata.genPipeColumn(ALL_COLS), ANT0400000000, rows);
  };

  public static SegmentValidation genRowValidation14() {
    int[] rows = { 10, 11 };
    return genPlusValidation(UtilMetadata.genPipeColumn(ALL_COLS), ANT0603000000, rows);
  };

  public static SegmentValidation genRowValidation17() {
    int[] rows = { 13, 14 };
    return genPlusValidation(UtilMetadata.genPipeColumn(ALL_COLS), ANT0703000000, rows);
  };

  public static SegmentValidation genRowValidation18() {
    int[] rows = { 12, 15 };
    return genPlusValidation(UtilMetadata.genPipeColumn(ALL_COLS), ANT0800000000, rows);
  };

  public static SegmentValidation genRowValidation19() {
    int[] rows = { 8, 16 };
    return genPlusValidation(UtilMetadata.genPipeColumn(ALL_COLS), ANT0900000000, rows);
  };

  private static SegmentValidation genPlusValidation(String selectField, IObject<KeyValueString> pos, int[] rows) {
    return UtilSegmentValidation.genEqualsFormula(selectField, pos.getObject().getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(pos.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }
}
