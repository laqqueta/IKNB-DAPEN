package id.go.ojk.bptk.client.builder.field.lpbptkjkm.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLpbptkjkk;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER6005RKPMF implements IObject<KeyValueString> {
  RKPMF0101000000("RKPMF0101000000","Jenis Klaim, Meninggal Dunia Pada Masa Aktif"),
  RKPMF0102000000("RKPMF0102000000","Jenis Klaim, Beasiswa"),
  RKPMF0200000000("RKPMF0200000000","Total Jenis Klaim"),
  RKPMF0401000000("RKPMF0401000000","Jumlah Status Klaim Diajukan"),
  RKPMF0402000000("RKPMF0402000000","Nilai Status Klaim Diajukan"),
  RKPMF0501000000("RKPMF0501000000","Jumlah Status Klaim Ditetapkan"),
  RKPMF0502000000("RKPMF0502000000","Nilai Status Klaim Ditetapkan"),
  RKPMF0601000000("RKPMF0601000000","Jumlah Status Klaim Ditolak"),
  RKPMF0602000000("RKPMF0602000000","Nilai Status Klaim Ditolak"),
  RKPMF0701000000("RKPMF0701000000","Jumlah Status Klaim Dibayarkan"),
  RKPMF0702000000("RKPMF0702000000","Nilai Status Klaim Dibayarkan"),
  ;

  @Getter
  private String key;
  private String value;

  public static final int[] COLS_NON_TOTAL = { 2, 3, 4, 5, 6, 7 };

  public static String getName() {
    return ER6005RKPMF.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER6005RKPMF.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLpbptkjkk.RKPMF.getCode() + key;
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
    for (ER6005RKPMF eEnum : ER6005RKPMF.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER6005RKPMF eEnum : ER6005RKPMF.values()) {
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
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 9), getObjects());
  }

  public static FieldValidation genValidationTotalJenisKlaimPemberiKerja() {
    int[] cols = { 2, 4, 6 };
    return UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(cols));
  }

  public static FieldValidation genValidationTotalJenisKlaimPeserta() {
    int[] cols = { 3, 5, 7 };
    return UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(cols));
  }

  public static SegmentValidation genValidationTotalJenisKlaim() {
    List<IObject<KeyValueString>> listKv = Arrays.asList(RKPMF0101000000, RKPMF0102000000);
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RKPMF0200000000, listKv);
  }

  private static SegmentValidation genPlusValidation(String selectField, IObject<KeyValueString> selectPos,
      List<IObject<KeyValueString>> listKv) {
    String formula = UtilMetadata.joinKeys(listKv, UtilMetadata.PLUS).toString();
    String errMsg = UtilMetadata.genMessage(selectPos.getObject().getValue(),
        UtilMetadata.joinValues(listKv, UtilMetadata.PLUS).toString());
    return UtilSegmentValidation.genEqualsFormula(selectField, selectPos.getObject().getKey(), formula, errMsg);
  }
}
