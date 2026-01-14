package id.go.ojk.bptk.client.builder.field.lpbptkjkk.reference;

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
public enum ER5905RKPMF implements IObject<KeyValueString> {
  RKPMF0101000000("RKPMF0101000000", "Jenis Manfaat, Cacat Sebagian Anatomis"),
  RKPMF0102000000("RKPMF0102000000", "Jenis Manfaat, Cacat Sebagian Fungsi"),
  RKPMF0103000000("RKPMF0103000000", "Jenis Manfaat, Cacat Total Tetap"),
  RKPMF0104000000("RKPMF0104000000", "Jenis Manfaat, Masih Pengobatan"),
  RKPMF0105000000("RKPMF0105000000", "Jenis Manfaat, Meninggal Dunia"),
  RKPMF0106000000("RKPMF0106000000", "Jenis Manfaat, Kasus Sembuh"),
  RKPMF0107000000("RKPMF0107000000", "Jenis Manfaat, Beasiswa"),
  RKPMF0200000000("RKPMF0200000000", "Total Jenis Manfaat"),
  RKPMF0401000000("RKPMF0401000000", "Jumlah Status Klaim Diajukan"),
  RKPMF0402000000("RKPMF0402000000", "Nilai Status Klaim Diajukan"),
  RKPMF0501000000("RKPMF0501000000", "Jumlah Status Klaim Ditetapkan"),
  RKPMF0502000000("RKPMF0502000000", "Nilai Status Klaim Ditetapkan"),
  RKPMF0601000000("RKPMF0601000000", "Jumlah Status Klaim Ditolak"),
  RKPMF0602000000("RKPMF0602000000", "Nilai Status Klaim Ditolak"),
  RKPMF0701000000("RKPMF0701000000", "Jumlah Status Klaim Dibayarkan"),
  RKPMF0702000000("RKPMF0702000000", "Nilai Status Klaim Dibayarkan"),;

  @Getter
  private String key;
  private String value;

  private static final String RPMF = EFormLpbptkjkk.RPMF.getCode();
  private static final String RPMF0200000000_KEYFORM = ER5903RPMF.RPMF0200000000.getKeyForm();
  public static final int[] COLS_NON_TOTAL = { 2, 3, 4, 5, 6, 7 };

  public static String getName() {
    return ER5905RKPMF.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5905RKPMF.class.getSimpleName().substring(2, 6));
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
    for (ER5905RKPMF eEnum : ER5905RKPMF.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5905RKPMF eEnum : ER5905RKPMF.values()) {
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

  public static SegmentValidation genValidationTotalJenisManfaat() {
    List<IObject<KeyValueString>> listKv = Arrays.asList(RKPMF0101000000, RKPMF0102000000, RKPMF0103000000,
        RKPMF0104000000, RKPMF0105000000, RKPMF0106000000, RKPMF0107000000);
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RKPMF0200000000, listKv);
  }

  public static FieldValidation genValidationTotalPemberiKerja() {
    int[] cols = { 2, 4, 6 };
    return UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(cols));
  }

  public static FieldValidation genValidationTotalPeserta() {
    int[] cols = { 3, 5, 7 };
    return UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(cols));
  }

  private static SegmentValidation genPlusValidation(String selectField, IObject<KeyValueString> selectPos,
      List<IObject<KeyValueString>> listKv) {
    String formula = UtilMetadata.joinKeys(listKv, UtilMetadata.PLUS).toString();
    String errMsg = UtilMetadata.genMessage(selectPos.getObject().getValue(),
        UtilMetadata.joinValues(listKv, UtilMetadata.PLUS).toString());
    return UtilSegmentValidation.genEqualsFormula(selectField, selectPos.getObject().getKey(), formula, errMsg);
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genValidatonFormTotalJenisManfaat() {
    String errMsg = "Total Jenis Manfaat|Total Jenis Manfaat, pada form " + RPMF;
    return genEqualsFormColumn("9", RKPMF0200000000, new int[] { 16 }, RPMF0200000000_KEYFORM, errMsg);
  }

  public static SegmentValidation genValidatonFormJumlahDiajukan() {
    String errMsg = "Jumlah Diajukan|Jumlah Status Klaim 1, pada form " + RPMF;
    return genEqualsFormColumn("9", RKPMF0401000000, new int[] { 17 }, RPMF0200000000_KEYFORM, errMsg);
  }

  public static SegmentValidation genValidatonFormNilaiDiajukan() {
    String errMsg = "Nilai Diajukan|Jumlah Status Klaim 1, pada form " + RPMF;
    return genEqualsFormColumn("9", RKPMF0402000000, new int[] { 18 }, RPMF0200000000_KEYFORM, errMsg);
  }
  
  public static SegmentValidation genValidatonFormJumlahDitetapkan() {
    String errMsg = "Jumlah Ditetapkan|Jumlah Status Klaim 2, pada form " + RPMF;
    return genEqualsFormColumn("9", RKPMF0501000000, new int[] { 19 }, RPMF0200000000_KEYFORM, errMsg);
  }

  public static SegmentValidation genValidatonFormNilaiDitetapkan() {
    String errMsg = "Nilai Ditetapkan|Jumlah Status Klaim 2, pada form " + RPMF;
    return genEqualsFormColumn("9", RKPMF0502000000, new int[] { 20 }, RPMF0200000000_KEYFORM, errMsg);
  }

  public static SegmentValidation genValidatonFormJumlahDitolak() {
    String errMsg = "Jumlah Ditolak|Jumlah Status Klaim 3, pada form " + RPMF;
    return genEqualsFormColumn("9", RKPMF0601000000, new int[] { 21 }, RPMF0200000000_KEYFORM, errMsg);
  }

  public static SegmentValidation genValidatonFormNilaiDitolak() {
    String errMsg = "Nilai Ditolak|Jumlah Status Klaim 3, pada form " + RPMF;
    return genEqualsFormColumn("9", RKPMF0602000000, new int[] { 22 }, RPMF0200000000_KEYFORM, errMsg);
  }

  public static SegmentValidation genValidatonFormJumlahDibayarkan() {
    String errMsg = "Jumlah Dibayarkan|Jumlah Status Klaim 4, pada form " + RPMF;
    return genEqualsFormColumn("9", RKPMF0701000000, new int[] { 23 }, RPMF0200000000_KEYFORM, errMsg);
  }

  public static SegmentValidation genValidatonFormNilaiDibayarkan() {
    String errMsg = "Nilai Dibayarkan|Jumlah Status Klaim 4, pada form " + RPMF;
    return genEqualsFormColumn("9", RKPMF0702000000, new int[] { 24 }, RPMF0200000000_KEYFORM, errMsg);
  }

  private static SegmentValidation genEqualsFormColumn(String selectColumn, IObject<KeyValueString> selectPosCode,
      int[] comparatorColumns, String comparatorRowCode, String errMsg) {
    String comparatorColumn = UtilMetadata.genPlusColumn(comparatorColumns);
    return UtilSegmentValidation.genEqualsFormColumCalculation(selectColumn, selectPosCode.getObject().getKey(),
        comparatorColumn, comparatorRowCode, errMsg, 2);
  }
}
