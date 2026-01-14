package id.go.ojk.bptk.client.builder.field.labptkjht.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLabptkjht;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER6702RAS implements IObject<KeyValueString> {
  RAS0101000000("RAS0101000000", "a. Total Aset"),
  RAS0102000000("RAS0102000000", "b. Total Kewajiban Kepada Peserta"),
  RAS0102010000("RAS0102010000", "Dana Peserta"),
  RAS0102020000("RAS0102020000", "Hasil Pengembangan - Realized"),
  RAS0102030000("RAS0102030000", "Utang Jaminan"),
  RAS0103000000("RAS0103000000", "Rasio ( a. Total Aset : b. Total Kewajiban Kepada Peserta )"),
  ;

  @Getter
  private String key;
  private String value;

  private static final String NILAI_RASIO = "2";

  private static final String NUMERIC_ROWS = new StringJoiner(UtilMetadata.PIPE)
      .add(RAS0101000000.key)
      .add(RAS0102000000.key)
      .add(RAS0102010000.key)
      .add(RAS0102020000.key)
      .add(RAS0102030000.key)
      .toString();

  private static final String DECIMAL_ROWS = RAS0103000000.key;

  public static String getName() {
    return ER6702RAS.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER6702RAS.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLabptkjht.RAS.getCode() + key;
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
    for (ER6702RAS eEnum : ER6702RAS.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER6702RAS eEnum : ER6702RAS.values()) {
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

  public static SegmentValidation genRowValidation03() {
    List<IObject<KeyValueString>> listKv = Arrays.asList(RAS0102010000, RAS0102020000, RAS0102030000);
    String formula = UtilMetadata.joinKeys(listKv, UtilMetadata.PLUS).toString();
    String errMsg = UtilMetadata.genMessage(RAS0102000000.value, UtilMetadata.joinValues(listKv, UtilMetadata.PLUS).toString());
    return UtilSegmentValidation.genEqualsFormula(NILAI_RASIO, RAS0102000000.key, formula, errMsg);
  }

  public static SegmentValidation genRowValidation07() {
    List<IObject<KeyValueString>> listKv = Arrays.asList(RAS0101000000, RAS0102000000);
    String formula =  UtilMetadata.joinKeys(listKv, UtilMetadata.PIPE).toString();
    String errMsg = "Rasio " + UtilMetadata.joinValues(listKv, " : ").toString();
    return UtilSegmentValidation.genEqualsRatio2(NILAI_RASIO, RAS0103000000.key, formula, errMsg, false);
  }
}
