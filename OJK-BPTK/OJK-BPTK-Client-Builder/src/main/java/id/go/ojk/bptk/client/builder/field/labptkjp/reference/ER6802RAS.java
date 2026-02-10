package id.go.ojk.bptk.client.builder.field.labptkjp.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLabptkjp;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER6802RAS implements IObject<KeyValueString> {
  RAS0101000000("RAS0101000000", "a. Total Aset Neto"),
  RAS0102000000("RAS0102000000", "b. Total Nilai Kini Aktuaria"),
  RAS0103000000("RAS0103000000", "Rasio ( a. Total Aset Neto : b. Total Nilai Kini Aktuaria )"),
  RAS0300000000("RAS0300000000", "PV(Proyeksi Penerimaan Iuran 3 tahun ke depan)"),
  RAS0400000000("RAS0400000000", "PV(Proyeksi Penerimaan Iuran 3 tahun ke depan)"),
  ;

  @Getter
  private String key;
  private String value;
  
  private static final String NILAI_RASIO = "2";

  private static final String NUMERIC_ROWS = new StringJoiner(UtilMetadata.PIPE)
      .add(RAS0101000000.key)
      .add(RAS0102000000.key)
      .add(RAS0300000000.key)
      .add(RAS0400000000.key)
      .toString();

  private static final String DECIMAL_ROWS = RAS0103000000.key;

  public static String getName() {
    return ER6802RAS.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER6802RAS.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLabptkjp.RAS.getCode() + key;
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
    for (ER6802RAS eEnum : ER6802RAS.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER6802RAS eEnum : ER6802RAS.values()) {
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
    return UtilMetadata.genFieldSave(NILAI_RASIO, getObjects());
  }

  public static SegmentValidation genValidationTypeNumeric() {
    return UtilSegmentValidation.genRegexNumericNegative(NILAI_RASIO, NUMERIC_ROWS);
  }

  public static SegmentValidation genValidationTypeDecimal() {
    return UtilSegmentValidation.genRegexNumericDotNegative(NILAI_RASIO, DECIMAL_ROWS);
  }

  public static SegmentValidation genValidationLengthNumeric() {
    return UtilSegmentValidation.genMaxLength(NILAI_RASIO, NUMERIC_ROWS, 20);
  }

  public static SegmentValidation genValidationLengthDecimal() {
    return UtilSegmentValidation.genMaxLength(NILAI_RASIO, DECIMAL_ROWS, 6);
  }

  public static SegmentValidation genValidationRAS0103000000() {
    List<IObject<KeyValueString>> listKv = Arrays.asList(RAS0101000000, RAS0102000000);
    String formula =  UtilMetadata.joinKeys(listKv, UtilMetadata.PIPE).toString();
    String errMsg = "Rasio " + UtilMetadata.joinValues(listKv, " : ").toString();
    return UtilSegmentValidation.genEqualsRatio2(NILAI_RASIO, RAS0103000000.key, formula, errMsg, false);
  }
}
