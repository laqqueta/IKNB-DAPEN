package id.go.ojk.bpks.client.builder.field.lbbpkslk.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.lbbpksdjs.metadata.MetadataLbbpksdjs;
import id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference.ER5105HIN;
import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5009INV implements IObject<KeyValueString> {
  INV0100000000("INV0100000000", "Detail"),
  INV0200000000("INV0200000000", "Total"),;

  @Getter
  private String key;
  private String value;

  public static final int[] ROW_TOTAL = { 20, 22, 23, 25, 26 };

  public static String getName() {
    return ER5009INV.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5009INV.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5009INV eEnum : ER5009INV.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genRequiredPos() {
    return INV0200000000.key;
  }

  public static String genUniquePos() {
    return INV0200000000.key;
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(ROW_TOTAL), getObjects());
  }

  public static ConditionalRequired genConditionalExistA() {
    return UtilFieldConditional.genExistPosAndHasReference("M", "N", INV0100000000.key, getRefNumber(), "O");
  }

  public static ConditionalRequired genConditionalExistB() {
    return UtilFieldConditional.genExistPosAndHasReference("O", "N", INV0100000000.key, getRefNumber(), "O");
  }

  public static ConditionalRequired genConditional07() {
//    Wajib KOSONG jika kolom 3 = SB:e35
//    Wajib DIISI jika kolom 3 != SB:e35
//    Wajib KOSONG jika kode komponen != INV0100000000
    return UtilFieldConditional.genExistPosAndComparatorHasValue2("N", "M", "N", INV0100000000.key, getRefNumber(), "3", "SB:e35");
  }

  public static ConditionalRequired genConditional09() {
//  Wajib DIISI jika kolom 3 = SB:e21|SB:e22|SB:e23
//  Wajib KOSONG jika kolom 3 != SB:e21|SB:e22|SB:e23
//  Wajib KOSONG jika kode komponen != INV0100000000
    return UtilFieldConditional.genExistPosAndComparatorHasValue2("M", "N", "N", INV0100000000.key, getRefNumber(), "3", "SB:e21|SB:e22|SB:e23");
  }

  public static ConditionalRequired genConditional10() {
//  Wajib DIISI jika kolom 3 = SB:e21|SB:e22|SB:e23
//  Wajib KOSONG jika kolom 3 != SB:e21|SB:e22|SB:e23
//  Wajib KOSONG jika kode komponen != INV0100000000
    return UtilFieldConditional.genExistPosAndComparatorHasValue2("M", "N", "N", INV0100000000.key, getRefNumber(), "3", "SB:e21|SB:e22|SB:e23");
  }
  
  public static ConditionalRequired genConditional17() {
//  Wajib DIISI jika kolom 3 = SB:e18
//  Wajib KOSONG jika kolom 3 != SB:e18
//  Wajib KOSONG jika kode komponen != INV0100000000
    return UtilFieldConditional.genExistPosAndComparatorHasValue2("M", "N", "N", INV0100000000.key, getRefNumber(), "3", "SB:e18");
  }

  public static SegmentValidation genValidationTotal() {
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(ROW_TOTAL), INV0200000000.key,
        INV0100000000.key, "Total|Penjumlahan detail");
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation23(String reportCode) {
    KeyValueString selectPos = INV0200000000.getObject();
    KeyValueString comparatorPos = ER5005HIN.HIN0600000000.getObject(); //LK
    if(reportCode.equals(MetadataLbbpksdjs.REPORT_CODE)) {
      comparatorPos = ER5105HIN.HIN0500000000.getObject(); // DJS
    }

    String errMsg = "Total Hasil Investasi|" + comparatorPos.getValue() + " pada form HIN";
    return UtilSegmentValidation.genEqualsForm("22", selectPos.getKey(), "HIN", "2", comparatorPos.getKey(), errMsg);
  }
}
