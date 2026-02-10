package id.go.ojk.bpks.client.builder.field.lbbpkslk.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslk;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5004AI implements IObject<KeyValueString> {
  AI0101000000("AI0101000000", "a.Deposito"),
  AI0102000000("AI0102000000", "b.Sertifikat Deposito"),
  AI0103000000("AI0103000000", "c.Deposit on Call"),
  AI0104000000("AI0104000000", "Sub Total Investasi Setara Kas"),
  AI0201000000("AI0201000000", "a.Deposito"),
  AI0202000000("AI0202000000", "b.Sertifikat Deposito"),
  AI0203000000("AI0203000000", "c.Saham yang Tercatat di Bursa"),
  AI0204000000("AI0204000000", "d.Surat Utang Korporasi dan Sukuk Korporasi"),
  AI0205000000("AI0205000000", "e. Surat Berharga yang Diterbitkan oleh Negara RI"),
  AI0206000000("AI0206000000", "f. Surat Berharga yang Diterbitkan oleh Bank Indonesia"),
  AI0207000000("AI0207000000", "g. Reksa Dana"),
  AI0208000000("AI0208000000", "h. Kontrak Investasi Kolektif Efek Beragun Aset"),
  AI0209000000("AI0209000000", "i. Dana Investasi Real Estat"),
  AI0210000000("AI0210000000", "j. Repurchase agreement (REPO)"),
  AI0211000000("AI0211000000", "k. Lainnya"),
  AI0212000000("AI0212000000", "Sub Total Investasi Jangka Pendek"),
  AI0301000000("AI0301000000", "a.Deposito"),
  AI0302000000("AI0302000000", "b.Sertifikat Deposito"),
  AI0303000000("AI0303000000", "c.Surat Utang Korporasi dan Sukuk Korporasi"),
  AI0304000000("AI0304000000", "d.Surat Berharga yang Diterbitkan oleh Negara RI"),
  AI0305000000("AI0305000000", "e.Surat Berharga yang Diterbitkan oleh Bank Indonesia"),
  AI0306000000("AI0306000000", "f.Reksa Dana"),
  AI0307000000("AI0307000000", "g.Penyertaan Langsung"),
  AI0308000000("AI0308000000", "h.Kontrak Investasi Kolektif Efek Beragun Aset"),
  AI0309000000("AI0309000000", "i.Dana Investasi Real Estat"),
  AI0310000000("AI0310000000", "j.Lainnya"),
  AI0311000000("AI0311000000", "Sub Total Investasi Jangka Panjang"),
  AI0401000000("AI0401000000", "a.Penyertaan Langsung"),
  AI0402000000("AI0402000000", "b.Saham yang Tercatat di Bursa"),
  AI0403000000("AI0403000000", "Sub Total Investasi pada Entitas Asosiasi dan Entitas Anak"),
  AI0501000000("AI0501000000", "a.Tanah"),
  AI0502000000("AI0502000000", "b.Bangunan"),
  AI0503000000("AI0503000000", "c.Tanah dengan Bangunan"),
  AI0504000000("AI0504000000", "Sub Total Investasi pada Properti"),
  AI0600000000("AI0600000000", "TOTAL INVESTASI"),;

  @Getter
  private String key;
  private String value;

  public static final String POS_SALDO = "2";

  public static String getName() {
    return ER5004AI.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5004AI.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5004AI eEnum : ER5004AI.values()) {
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
    return UtilMetadata.genFieldSave(POS_SALDO, getObjects());
  }

  public static SegmentValidation genRowValidation5() {
    int[] rows = { 0, 1, 2 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, AI0104000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(AI0104000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation17() {
    int[] rows = { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, AI0212000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(AI0212000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation28() {
    int[] rows = { 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, AI0311000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(AI0311000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation31() {
    int[] rows = { 27, 28 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, AI0403000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(AI0403000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation35() {
    int[] rows = { 30, 31, 32 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, AI0504000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(AI0504000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation36() {
    int[] rows = { 3, 15, 26, 29, 33 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, AI0600000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(AI0600000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation17b() {
    int[] rows = { 1, 10 };
    String comparatorField = UtilMetadata.genPlusRow(ER5000LPK.getObjectsForm(), rows);
    String errMsg = UtilMetadata.genMessage(AI0212000000.value,
        UtilMetadata.genPlusDesc(ER5000LPK.getObjects(), rows) + " pada form " + EFormLbbpkslk.LPK.getCode());
    return UtilSegmentValidation.genEqualsFormulaForm("2", AI0212000000.key, "2", comparatorField, errMsg, 2);
  }

  public static SegmentValidation genRowValidation28b() {
    String selecPosCode = AI0311000000.key;
    String comparatorPosCode = ER5000LPK.LPK0103010000.getKey();
    String errMsg = AI0311000000.value + "|" + ER5000LPK.LPK0103010000.getValue() + " pada form " + EFormLbbpkslk.LPK.getCode();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, EFormLbbpkslk.LPK.getCode(), "2", comparatorPosCode, errMsg);
  }
}
