package id.go.ojk.bptk.client.builder.field.lbbptkjp.reference;

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
public enum ER5812NKA implements IObject<KeyValueString> {
  NKA0100000000("NKA0100000000", "Manfaat Pensiun Hari Tua"),
  NKA0200000000("NKA0200000000", "Manfaat Pensiun Janda Duda"),
  NKA0300000000("NKA0300000000", "Manfaat Pensiun Anak"),
  NKA0400000000("NKA0400000000", "Manfaat Pensiun Orangtua"),
  NKA0500000000("NKA0500000000", "Lumpsump"),
  NKA0600000000("NKA0600000000", "Pekerja migran Indonesia"),
  NKA0700000000("NKA0700000000", "Nilai Kini aktuarial akhir tahun"),
  NKA0800000000("NKA0800000000", "Aset Neto tersedia untuk manfaat Jaminan Pensiun"),
  NKA0900000000("NKA0900000000", "Defisit"),
  NKA1000000000("NKA1000000000", "Metode Menghitung Nilai JP Terjanjikan"),
  NKA1100000000("NKA1100000000", "Asumsi tingkat inflasi"),
  NKA1200000000("NKA1200000000", "Asumsi tingkat hasil inflasi (YOI)"),
  NKA1300000000("NKA1300000000", "Asumsi produk domestik bruto (PDB)"),
  NKA1400000000("NKA1400000000", "Asumsi tingkat kenaikan upah"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5812NKA.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5812NKA.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5812NKA eEnum : ER5812NKA.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave("2|3", getObjects());
  }

  public static String genRequiredPos() {
    return UtilMetadata.genPipeRow(getObjects());
  }

  public static String genUniquePos() {
    return UtilMetadata.genPipeRow(getObjects());
  }

  public static SegmentValidation genValidationTypeNumericNegative() {
    return UtilSegmentValidation.genRegexNumericNegative(UtilMetadata.genPipeColumn(2, 3),
        UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 }));
  }

  public static SegmentValidation genValidationTypeAll() {
    return UtilSegmentValidation.genRegexAll(UtilMetadata.genPipeColumn(2, 3),
        UtilMetadata.genPipeRow(getObjects(), new int[] { 9 }));
  }

  public static SegmentValidation genValidationTypeDecimal() {
    return UtilSegmentValidation.genRegexNumericDotNegative(UtilMetadata.genPipeColumn(2, 3),
        UtilMetadata.genPipeRow(getObjects(), new int[] { 10, 11, 12, 13 }));
  }

  public static SegmentValidation genValidationLength20() {
    String selectPosCode = UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 9 });
    return UtilSegmentValidation.genMaxLength("2|3", selectPosCode, 20);
  }

  public static SegmentValidation genValidationLength100() {
    int[] rows = { 9 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genMaxLength("2|3", selectPosCode, 100);
  }

  public static SegmentValidation genRowValidation08() {
    int[] rows = { 0, 1, 2, 3, 4, 5 };
    return genPlusValidation("2|3", NKA0700000000, rows);
  }

  public static SegmentValidation genRowValidation10() {
    int[] rows = { 7, 6 };
    return genMinusValidation("2|3", NKA0900000000, rows);
  }

  private static SegmentValidation genPlusValidation(String selectField, IObject<KeyValueString> pos, int[] rows) {
    return UtilSegmentValidation.genEqualsFormula(selectField, pos.getObject().getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(pos.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  private static SegmentValidation genMinusValidation(String selectField, IObject<KeyValueString> pos, int[] rows) {
    return UtilSegmentValidation.genEqualsFormula(selectField, pos.getObject().getKey(),
        UtilMetadata.genMinusRow(getObjects(), rows),
        UtilMetadata.genMessage(pos.getObject().getValue(), UtilMetadata.genMinusDesc(getObjects(), rows)));
  }
}
