package id.go.ojk.bptk.client.builder.field.lbbptkjht.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5608INVSB implements IObject<KeyValueString> {
  INVSB0100000000("INVSB0100000000", "Detail"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5608INVSB.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5608INVSB.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5608INVSB eEnum : ER5608INVSB.values()) {
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

  public static FieldValidation genFieldValidation23() {
    int[] cols = { 21, 20 };
    return UtilFieldValidation.genEqualsFormula(UtilMetadata.genMinusColumn(cols));
  }

  public static ConditionalRequired genConditionalBagianPenyertaan() {
//  Wajib DIISI jika kolom 2 = 2018
//  Wajib KOSONG jika kolom 2 != 2018
//  Boleh KOSONG jika kode komponen != INVSB0100000000
    return UtilFieldConditional.genExistPosAndComparatorHasValue2("M", "N", "O", INVSB0100000000.key, getRefNumber(), "2", "2018");
  }
}
