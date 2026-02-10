package id.go.ojk.bpks.client.builder.field.lbbpkslk.reference;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
public enum ER5000LPK implements IObject<KeyValueString> {
  LPK0101010000("LPK0101010000", "Kas dan setara kas"),
  LPK0101020000("LPK0101020000", "Deposito berjangka"),
  LPK0101030000("LPK0101030000", "Piutang biaya operasional"),
  LPK0101040000("LPK0101040000", "Piutang talangan"),
  LPK0101050000("LPK0101050000", "Piutang investasi"),
  LPK0101060000("LPK0101060000", "Piutang hasil investasi"),
  LPK0101070000("LPK0101070000", "Piutang lain"),
  LPK0101080000("LPK0101080000", "Uang muka"),
  LPK0101090000("LPK0101090000", "Pajak dibayar di muka"),
  LPK0101100000("LPK0101100000", "Biaya dibayar di muka"),
  LPK0101110000("LPK0101110000", "Investasi jangka pendek"),
  LPK0101120000("LPK0101120000", "Perlengkapan kantor"),
  LPK0101130000("LPK0101130000", "Aset dimiliki untuk dijual"),
  LPK0101140000("LPK0101140000", "Aset lancar lain"),
  LPK0102000000("LPK0102000000", "Jumlah Aset Lancar"),
  LPK0103010000("LPK0103010000", "Investasi jangka panjang"),
  LPK0103020000("LPK0103020000", "Investasi pada entitas asosiasi dan entitas anak"),
  LPK0103030000("LPK0103030000", "Properti Investasi"),
  LPK0103040000("LPK0103040000", "Aset tetap"),
  LPK0103050000("LPK0103050000", "Aset Hak Guna"),
  LPK0103060000("LPK0103060000", "Aset tidak berwujud"),
  LPK0103070000("LPK0103070000", "Aset pajak tangguhan"),
  LPK0103080000("LPK0103080000", "Aset tidak lancar lain"),
  LPK0104000000("LPK0104000000", "Jumlah Aset Tidak Lancar"),
  LPK0200000000("LPK0200000000", "JUMLAH ASET"),
  LPK0301010000("LPK0301010000", "Utang kepada pihak ketiga"),
  LPK0301020000("LPK0301020000", "Utang pajak"),
  LPK0301030000("LPK0301030000", "Utang kontribusi kepada program"),
  LPK0301040000("LPK0301040000", "Utang insentif"),
  LPK0301050000("LPK0301050000", "Biaya yang masih harus dibayar"),
  LPK0301060000("LPK0301060000", "Pendapatan diterima dimuka"),
  LPK0301070000("LPK0301070000", "Liabilitas jangka pendek lain"),
  LPK0301080000("LPK0301080000", "Liabilitas Sewa Jangka Pendek"),
  LPK0302000000("LPK0302000000", "Jumlah Liabilitas Jangka Pendek"),
  LPK0303010000("LPK0303010000", "Pendapatan diterima dimuka"),
  LPK0303020000("LPK0303020000", "Liabilitas imbalan pascakerja"),
  LPK0303030000("LPK0303030000", "Liabilitas pajak tangguhan"),
  LPK0303040000("LPK0303040000", "Liabilitas jangka panjang lain"),
  LPK0303050000("LPK0303050000", "Liabilitas Sewa Jangka Panjang"),
  LPK0304000000("LPK0304000000", "Jumlah Liabilitas Jangka Panjang"),
  LPK0400000000("LPK0400000000", "JUMLAH LIABILITAS"),
  LPK0501000000("LPK0501000000", "Modal"),
  LPK0502000000("LPK0502000000", "Saldo penyesuaian nilai wajar aset keuangan tersedia untuk dijual"),
  LPK0503000000("LPK0503000000", "Saldo keuntungan dan kerugian aktuaria liabilitas pascakerja imbalan pasti"),
  LPK0504000000("LPK0504000000", "Saldo bagian penghasilan komprehensif lain entitas asosiasi dan entitas anak"),
  LPK0505000000("LPK0505000000", "Saldo selisih transaksi dengan pihak nonpengendali"),
  LPK0506000000("LPK0506000000", "Saldo selisih kombinasi dan pelepasan bisnis antar entitas sepengendali"),
  LPK0507000000("LPK0507000000", "Saldo penghasilan (beban) neto"),
  LPK0600000000("LPK0600000000", "JUMLAH EKUITAS"),
  LPK0700000000("LPK0700000000", "JUMLAH LIABILITAS DAN EKUITAS"),;

  @Getter
  private String key;
  private String value;

  public static final String POS_SALDO = "2";

  public static String getName() {
    return ER5000LPK.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5000LPK.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLbbpkslk.LPK.getCode() + key;
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
    for (ER5000LPK eEnum : ER5000LPK.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5000LPK eEnum : ER5000LPK.values()) {
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
    return UtilMetadata.genFieldSave(POS_SALDO, getObjects());
  }

  public static SegmentValidation genRowValidation16() {
    int[] rows = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LPK0102000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LPK0102000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation25() {
    int[] rows = { 15, 16, 17, 18, 19, 20, 21, 22 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LPK0104000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LPK0104000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation26() {
    int[] rows = { 14, 23 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LPK0200000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LPK0200000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation35() {
    int[] rows = { 25, 26, 27, 28, 29, 30, 31, 32 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LPK0302000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LPK0302000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation41() {
    int[] rows = { 34, 35, 36, 37, 38 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LPK0304000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LPK0304000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation42() {
    int[] rows = { 33, 39 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LPK0400000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LPK0400000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation50() {
    int[] rows = { 41, 42, 43, 44, 45, 46, 47 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LPK0600000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LPK0600000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation51a() {
    int[] rows = { 40, 48 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LPK0700000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LPK0700000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation51b() {
    int[] rows = { 24 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LPK0700000000.key, LPK0200000000.key,
        UtilMetadata.genMessage(LPK0700000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }
}
