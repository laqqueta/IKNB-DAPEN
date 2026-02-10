package id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpksdjs;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5103LPAN implements IObject<KeyValueString> {
  LPAN0101000000("LPAN0101000000", "Saldo Awal Aset Neto"),
  LPAN0102000000("LPAN0102000000", "Surplus (Defisit) Tahun Berjalan"),
  LPAN0103000000("LPAN0103000000", "Saldo Akhir Aset Neto"),
  LPAN0201000000("LPAN0201000000", "Saldo Awal Penghasilan Komprehensif Lain"),
  LPAN0202000000("LPAN0202000000", "Penghasilan Komprehensif Tahun Berjalan"),
  LPAN0203000000("LPAN0203000000", "Saldo Akhir Penghasilan Komprehensif Lain"),
  LPAN0300000000("LPAN0300000000", "TOTAL"),;

  @Getter
  private String key;
  private String value;

  public static final String LPK = EFormLbbpksdjs.LPK.getCode();
  public static final String LAV = EFormLbbpksdjs.LAV.getCode();

  public static String getName() {
    return ER5103LPAN.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5103LPAN.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5103LPAN eEnum : ER5103LPAN.values()) {
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
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 3), getObjects());
  }

  public static SegmentValidation genRowValidation04a() {
    int[] rows = { 0, 1 };
    return genRowValidation("2", LPAN0103000000, rows);
  }

  public static SegmentValidation genRowValidation04b() {
    int[] rows = { 0, 1 };
    return genRowValidation("3", LPAN0103000000, rows);
  }

  public static SegmentValidation genRowValidation07a() {
    int[] rows = { 3, 4 };
    return genRowValidation("2", LPAN0203000000, rows);
  }

  public static SegmentValidation genRowValidation07b() {
    int[] rows = { 3, 4 };
    return genRowValidation("3", LPAN0203000000, rows);
  }

  public static SegmentValidation genRowValidation08a() {
    int[] rows = { 2, 5 };
    return genRowValidation("2", LPAN0300000000, rows);
  }

  public static SegmentValidation genRowValidation08b() {
    int[] rows = { 2, 5 };
    return genRowValidation("3", LPAN0300000000, rows);
  }

  private static SegmentValidation genRowValidation(String selectField, IObject<KeyValueString> pos, int[] rows) {
    KeyValueString posCode = pos.getObject();
    String plusRows = UtilMetadata.genPlusRow(getObjects(), rows);
    String plusRowsDesc = UtilMetadata.genPlusDesc(getObjects(), rows);
    return UtilSegmentValidation.genEqualsFormula(selectField, posCode.getKey(), plusRows,
        UtilMetadata.genMessage(posCode.getValue(), plusRowsDesc));
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation04c() {
    String selecPosCode = LPAN0103000000.key;
    String comparatorPosCode = ER5100LPK.LPK0500000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation04d() {
    String selecPosCode = LPAN0103000000.key;
    String comparatorPosCode = ER5101LAV.LAV0600000000.getKey();
    return UtilSegmentValidation.genEqualsForm("3", selecPosCode, LAV, "2", comparatorPosCode);
  }
}
