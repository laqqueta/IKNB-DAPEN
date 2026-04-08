package id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata.MetadataLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference.ER5401LPK;
import id.go.ojk.bptk.client.builder.field.ltbptk.metadata.MetadataLtbptkbdn;
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
public enum ER5310INVSB implements IObject<KeyValueString> {
  INVSB0100000000("INVSB0100000000", "Detail"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5310INVSB.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5310INVSB.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5310INVSB eEnum : ER5310INVSB.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 30), getObjects());
  }

  public static FieldValidation genFieldValidation11() {
    return UtilFieldValidation.genDateLess("11");
  }

  public static FieldValidation genFieldValidation12() {
    return UtilFieldValidation.genDateGreater("10");
  }

  public static FieldValidation genFieldValidation17() {
    return UtilFieldValidation.genGreaterValue("0");
  }

  public static FieldValidation genFieldValidation22() {
    int[] cols = { 20, 19 };
    return UtilFieldValidation.genEqualsFormula(UtilMetadata.genMinusColumn(cols));
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation31(String reportCode) {
    if (reportCode.equalsIgnoreCase(MetadataLbbptkbdn.REPORT_CODE) ||
        reportCode.equalsIgnoreCase(MetadataLtbptkbdn.REPORT_CODE)) {
      return genRowValidation31Bdn();
    } else {
      return genRowValidation31Jkk();
    }
  }

  private static SegmentValidation genRowValidation31Bdn() {
    int[] rows = { 14, 15, 16, 17, 18, 19, 28, 29, 30, 31, 32 };
    String comparatorField = UtilMetadata.genPlusRow(ER5301LPK.getObjectsForm(), rows);
    String errMsg = UtilMetadata.genMessage("Total Saldo",
        UtilMetadata.genPlusDesc(ER5301LPK.getObjects(), rows) + " pada form LPK");
    return UtilSegmentValidation.genEqualsFormulaForm4("30", INVSB0100000000.key, "2", comparatorField, errMsg, 2);
  }

  private static SegmentValidation genRowValidation31Jkk() {
    int[] rows = { 7, 8, 9, 10, 11, 12, 13, 14 };
    String comparatorField = UtilMetadata.genPlusRow(ER5401LPK.getObjectsForm(), rows);
    String errMsg = UtilMetadata.genMessage("Total Saldo",
        UtilMetadata.genPlusDesc(ER5401LPK.getObjects(), rows) + " pada form LPK");
    return UtilSegmentValidation.genEqualsFormulaForm4("30", INVSB0100000000.key, "2", comparatorField, errMsg, 2);
  }

  public static ConditionalRequired genConditionalUnitPenyertaan() {
    return UtilFieldConditional.genComparatorHasValue("M", "N", "2", "2007|2011|20111|20112|20113|20114");
  }

  public static ConditionalRequired genConditionalBagianPenyertaan() {
//  Wajib DIISI jika kolom 2 = 2018
//  Wajib KOSONG jika kolom 2 != 2018
//  Boleh KOSONG jika kode komponen != INVSB0100000000
    return UtilFieldConditional.genExistPosAndComparatorHasValue2("M", "N", "O", INVSB0100000000.key, getRefNumber(), "2", "2018");
  }
}
