package id.go.ojk.bptk.client.builder.field.lpbptkjkk.reference;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLpbptkjkk;
import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5901RKPST implements IObject<KeyValueString> {
  RKPST0100000000("RKPST0100000000", "Detail"),
  RKPST0200000000("RKPST0200000000", "Total"),;

  @Getter
  private String key;
  private String value;

  // public static final String IDX_TOTAL_PESERTA = "33";
  public static final String IDX_TOTAL_KELOMPOK_UMUR = "47";
  public static final String IDX_TOTAL_WN = "50";

  public static String getName() {
    return ER5901RKPST.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5901RKPST.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLpbptkjkk.RKPST.getCode() + key;
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
    for (ER5901RKPST eEnum : ER5901RKPST.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5901RKPST eEnum : ER5901RKPST.values()) {
      res.add(eEnum.getObjectForm());
    }
    return res;
  }

  public static String genRequiredPos() {
    return RKPST0200000000.key;
  }

  public static String genUniquePos() {
    return RKPST0200000000.key;
  }
  
  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumnExcept(8, 51, new int[] { 14 }), getObjects());
  }

  public static String genFieldSaveForm() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(new int[] { 8, 9, 10, 11, 25, 28, 33, 47, 50 }), getObjects());
  }

  public static ConditionalRequired genConditionalExistA() {
    return UtilFieldConditional.genExistPosAndHasReference("M", "N", RKPST0100000000.key, getRefNumber(), "O");
  }

  public static SegmentValidation genValidationTotal() {
    String errMsg = "Total|Penjumlahan detail";
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumnExcept(8, 51, new int[] { 14 }), RKPST0200000000.key, RKPST0100000000.key, errMsg);
  }

  public static FieldValidation genValidationTotalLapanganUsaha() {
    return UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(16, 24), RKPST0200000000.key);
  }

  public static FieldValidation genValidationTotalJenisKelaminA() {
    return UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(26, 27), RKPST0200000000.key);
  }

  public static FieldValidation genValidationTotalJenisKelaminB() {
    String errMsg = "Total Jenis Kelamin|Total Kelompok Umur";
    return UtilFieldValidation.genEqualsPosFormula2(IDX_TOTAL_KELOMPOK_UMUR, RKPST0200000000.key, errMsg);
  }

  public static FieldValidation genValidationTotalPeserta() {
    return UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(31, 32), RKPST0200000000.key);
  }

  public static FieldValidation genValidationTotalKelompokUmurA() {
    return UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(34, 46), RKPST0200000000.key);
  }
  
  public static FieldValidation genValidationTotalKelompokUmurB() {
    String errMsg = "Total Kelompok Umur|Total Kewarganegaraan";
    return UtilFieldValidation.genEqualsPosFormula2(IDX_TOTAL_WN, RKPST0200000000.key, errMsg);
  }

  public static FieldValidation genValidationTotalKewarganegaraan() {
    return UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(48, 49), RKPST0200000000.key);
  }
}
