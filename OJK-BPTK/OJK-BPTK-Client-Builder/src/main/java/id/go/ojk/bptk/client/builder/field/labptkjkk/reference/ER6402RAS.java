package id.go.ojk.bptk.client.builder.field.labptkjkk.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLabptkjkk;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER6402RAS implements IObject<KeyValueString> {
  RAS0101000000("RAS0101000000", "a. Aset Neto Akhir Periode"),
  RAS0102000000("RAS0102000000", "b. Pembayaran Klaim 12 Bulan Terakhir"),
  RAS0103000000("RAS0103000000", "Rasio [ a. Aset Neto Akhir Periode : ( b. Pembayaran Klaim 12 Bulan Terakhir / 12 ) ]"),
  ;

  @Getter
  private String key;
  private String value;

  private static final String PIPE = "|";
  private static final String NILAI_RASIO = "2";

  private static final String NUMERIC_ROWS = new StringJoiner(PIPE)
      .add(RAS0101000000.key)
      .add(RAS0102000000.key)
      .toString();

  private static final String DECIMAL_ROWS = RAS0103000000.key;

  public static String getName() {
    return ER6402RAS.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER6402RAS.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLabptkjkk.RAS.getCode() + key;
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
    for (ER6402RAS eEnum : ER6402RAS.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER6402RAS eEnum : ER6402RAS.values()) {
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

  public static SegmentValidation genValidationRatio() {
    List<IObject<KeyValueString>> listKv = Arrays.asList(RAS0101000000, RAS0102000000);
    String rightFormula =  UtilMetadata.joinKeys(listKv, UtilMetadata.PIPE).toString();
    String leftConstFormula = "12*";
    String errMsg = "Rasio " + RAS0101000000.value + " : (" + RAS0102000000.value + " / 12 )";
    return UtilSegmentValidation.genEqualsRatio2("2", RAS0103000000.key, rightFormula, errMsg, leftConstFormula, null);
  }
}
