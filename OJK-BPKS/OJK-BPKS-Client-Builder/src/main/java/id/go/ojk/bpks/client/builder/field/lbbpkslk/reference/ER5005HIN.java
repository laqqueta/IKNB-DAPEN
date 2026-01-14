package id.go.ojk.bpks.client.builder.field.lbbpkslk.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslk;
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
public enum ER5005HIN implements IObject<KeyValueString> {
  HIN0101000000("HIN0101000000", "a.Deposito"),
  HIN0102000000("HIN0102000000", "b.Sertifikat Deposito"),
  HIN0103000000("HIN0103000000", "c.Deposit on Call"),
  HIN0104000000("HIN0104000000", "Sub Total Investasi Setara Kas"),
  HIN0201000000("HIN0201000000", "a.Deposito"),
  HIN0202000000("HIN0202000000", "b.Sertifikat Deposito"),
  HIN0203000000("HIN0203000000", "c.Saham yang Tercatat di Bursa"),
  HIN0204000000("HIN0204000000", "d.Surat Utang Korporasi dan Sukuk Korporasi"),
  HIN0205000000("HIN0205000000", "e. Surat berharga yang Diterbitkan oleh Negara RI"),
  HIN0206000000("HIN0206000000", "f. Surat Berharga yang Diterbitkan oleh Bank Indonesia"),
  HIN0207000000("HIN0207000000", "g. Reksa Dana"),
  HIN0208000000("HIN0208000000", "h. Kontrak Investasi Kolektif Efek Beragun Aset"),
  HIN0209000000("HIN0209000000", "i. Dana Investasi Real Estat"),
  HIN0210000000("HIN0210000000", "j. Repurchase Agreement (REPO)"),
  HIN0211000000("HIN0211000000", "k. Lainnya"),
  HIN0212000000("HIN0212000000", "Sub Total Investasi Jangka Pendek"),
  HIN0301000000("HIN0301000000", "a.Deposito"),
  HIN0302000000("HIN0302000000", "b.Sertifikat Deposito"),
  HIN0303000000("HIN0303000000", "c.Surat Utang Korporasi dan Sukuk Korporasi"),
  HIN0304000000("HIN0304000000", "d.Surat Berharga yang Diterbitkan oleh Negara RI"),
  HIN0305000000("HIN0305000000", "e.Surat Berharga yang Diterbitkan oleh Bank Indonesia"),
  HIN0306000000("HIN0306000000", "f.Reksa Dana"),
  HIN0307000000("HIN0307000000", "g.Penyertaan Langsung"),
  HIN0308000000("HIN0308000000", "h.Kontrak Investasi Kolektif Efek Beragun Aset"),
  HIN0309000000("HIN0309000000", "i.Dana Investasi Real Estat"),
  HIN0310000000("HIN0310000000", "j.Lainnya"),
  HIN0311000000("HIN0311000000", "Sub Total Investasi Jangka Panjang"),
  HIN0401000000("HIN0401000000", "a.Penyertaan Langsung"),
  HIN0402000000("HIN0402000000", "b.Saham yang Tercatat di Bursa"),
  HIN0403000000("HIN0403000000", "Sub Total Investasi pada Entitas Asosiasi dan Entitas Anak"),
  HIN0501000000("HIN0501000000", "a.Tanah"),
  HIN0502000000("HIN0502000000", "b.Bangunan"),
  HIN0503000000("HIN0503000000", "c.Tanah dengan Bangunan"),
  HIN0504000000("HIN0504000000", "Sub Total Investasi pada Properti"),
  HIN0600000000("HIN0600000000", "TOTAL HASIL INVESTASI"),;

  @Getter
  private String key;
  @Getter
  private String value;

  public static final int[] POS_SUBTOTAL_HIN0104000000 = { 0, 1, 2 };
  public static final int[] POS_SUBTOTAL_HIN0212000000 = { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
  public static final int[] POS_SUBTOTAL_HIN0311000000 = { 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
  public static final int[] POS_SUBTOTAL_HIN0403000000 = { 27, 28 };
  public static final int[] POS_SUBTOTAL_HIN0504000000 = { 30, 31, 32 };
  public static final int[] POS_TOTAL = { 3, 15, 26, 29, 33 };
  public static final String SELECT_FIELDS = UtilMetadata.genDelimitedColumn(new int[] { 2, 3, 4 }, "|");

  public static String getName() {
    return ER5005HIN.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5005HIN.class.getSimpleName().substring(2, 6));
  }

  public String getFormKey() {
    return EFormLbbpkslk.HIN.getCode() + key;
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5005HIN eEnum : ER5005HIN.values()) {
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
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 6), getObjects());
  }

  public static String genFieldSaveForm() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 6), getObjects());
  }

  public static SegmentValidation genRowValidation05() {
    return genSubtotalValidation(SELECT_FIELDS, HIN0104000000, POS_SUBTOTAL_HIN0104000000);
  }

  public static SegmentValidation genRowValidation17() {
    return genSubtotalValidation(SELECT_FIELDS, HIN0212000000, POS_SUBTOTAL_HIN0212000000);
  }

  public static SegmentValidation genRowValidation28() {
    return genSubtotalValidation(SELECT_FIELDS, HIN0311000000, POS_SUBTOTAL_HIN0311000000);
  }

  public static SegmentValidation genRowValidation31() {
    return genSubtotalValidation(SELECT_FIELDS, HIN0403000000, POS_SUBTOTAL_HIN0403000000);
  }

  public static SegmentValidation genRowValidation35() {
    return genSubtotalValidation(SELECT_FIELDS, HIN0504000000, POS_SUBTOTAL_HIN0504000000);
  }

  public static SegmentValidation genRowValidation36() {
    return genSubtotalValidation(SELECT_FIELDS, HIN0600000000, POS_TOTAL);
  }

  public static FieldValidation genFieldValidation6() {
    return UtilFieldValidation.genEqualsPosByConst(UtilMetadata.genPlusColumn(new int[] { 3, 4 }), 2,
        UtilMetadata.genPipeRow(getObjects()), "2", "/");
  }

  public static FieldValidation genFieldValidation7() {
    return UtilFieldValidation.genEqualsRatio("2|5", 2);
  }

  private static SegmentValidation genSubtotalValidation(String selectField, IObject<KeyValueString> selectPosCode,
      int[] rows) {
    return UtilSegmentValidation.genEqualsFormula(selectField, selectPosCode.getObject().getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(selectPosCode.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }
}
