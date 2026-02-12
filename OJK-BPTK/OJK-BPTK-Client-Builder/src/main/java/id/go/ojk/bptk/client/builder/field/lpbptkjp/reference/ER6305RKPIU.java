package id.go.ojk.bptk.client.builder.field.lpbptkjp.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLpbptkjp;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.reference.ER5902RPIU;
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
public enum ER6305RKPIU implements IObject<KeyValueString> {
  RKPIU0100000000("RKPIU0100000000", "Rekapitulasi Kepesertaan Per Segmen Peserta"),
  RKPIU0301000000("RKPIU0301000000", "Kelompok Usaha Pertanian, Perikanan, Perkebunan & Kehutanan"),
  RKPIU0302000000("RKPIU0302000000", "Kelompok Usaha Pertambangan"),
  RKPIU0303000000("RKPIU0303000000", "Kelompok Usaha Industri Dasar & Kimia"),
  RKPIU0304000000("RKPIU0304000000", "Kelompok Usaha Aneka Industri"),
  RKPIU0305000000("RKPIU0305000000", "Kelompok Usaha Industri Barang Konsumsi"),
  RKPIU0306000000("RKPIU0306000000", "Kelompok Usaha Properti & Real Estate"),
  RKPIU0307000000("RKPIU0307000000", "Kelompok Usaha Energi, Telekomunikasi & Transportasi"),
  RKPIU0308000000("RKPIU0308000000", "Kelompok Usaha Keuangan & Investasi"),
  RKPIU0309000000("RKPIU0309000000", "Kelompok Usaha Perdagangan & Jasa"),
  RKPIU0400000000("RKPIU0400000000", "Total Kelompok Usaha"),
  RKPIU0501000000("RKPIU0501000000", "Jenis Kelamin Laki-Laki"),
  RKPIU0502000000("RKPIU0502000000", "Jenis Kelamin Perempuan"),
  RKPIU0600000000("RKPIU0600000000", "Total Jenis Kelamin"),
  RKPIU0701000000("RKPIU0701000000", "Kepesertaan Tenaga Kerja Masuk"),
  RKPIU0702000000("RKPIU0702000000", "Kepesertaan Tenaga Kerja Keluar"),
  RKPIU0703000000("RKPIU0703000000", "Kepesertaan Tenaga Kerja Aktif"),
  RKPIU0704000000("RKPIU0704000000", "Kepesertaan Tenaga Kerja Non Aktif"),
  RKPIU0901000000("RKPIU0901000000", "Kelompok Umur 20 tahun ke bawah"),
  RKPIU0902000000("RKPIU0902000000", "Kelompok Umur di atas 20 - 25 tahun"),
  RKPIU0903000000("RKPIU0903000000", "Kelompok Umur di atas 25 - 30 tahun"),
  RKPIU0904000000("RKPIU0904000000", "Kelompok Umur di atas 30 - 35 tahun"),
  RKPIU0905000000("RKPIU0905000000", "Kelompok Umur di atas 35 - 40 tahun"),
  RKPIU0906000000("RKPIU0906000000", "Kelompok Umur di atas 40 - 45 tahun"),
  RKPIU0907000000("RKPIU0907000000", "Kelompok Umur di atas 45 - 50 tahun"),
  RKPIU0908000000("RKPIU0908000000", "Kelompok Umur di atas 50 - 55 tahun"),
  RKPIU0909000000("RKPIU0909000000", "Kelompok Umur di atas 55 - 60 tahun"),
  RKPIU0910000000("RKPIU0910000000", "Kelompok Umur di atas 60 - 65 tahun"),
  RKPIU0911000000("RKPIU0911000000", "Kelompok Umur di atas 65 - 70 tahun"),
  RKPIU0912000000("RKPIU0912000000", "Kelompok Umur di atas 70 - 75 tahun"),
  RKPIU0914000000("RKPIU0914000000", "Kelompok Umur di atas 75 tahun"),
  RKPIU1000000000("RKPIU1000000000", "Total Kelompok Umur"),
  RKPIU1101000000("RKPIU1101000000", "Kewarganegaraan WNI"),
  RKPIU1102000000("RKPIU1102000000", "Kewarganegaraan WNA"),
  RKPIU1200000000("RKPIU1200000000", "Total Kewarganegaraan"),
  RKPIU1401000000("RKPIU1401000000", "Kelompok Upah 0-2 juta/bulan"),
  RKPIU1402000000("RKPIU1402000000", "Kelompok Upah > 2- 5 juta/bulan"),
  RKPIU1403000000("RKPIU1403000000", "Kelompok Upah > 5-10 juta/bulan"),
  RKPIU1404000000("RKPIU1404000000", "Kelompok Upah > 10-50 juta/bulan"),
  RKPIU1405000000("RKPIU1405000000", "Kelompok Upah > 50 juta/bulan"),
  RKPIU1500000000("RKPIU1500000000", "Total Kelompok Upah"),
  RKPIU1601000000("RKPIU1601000000", "Iuran Jatuh Tempo Sudah Rekon"),
  RKPIU1602000000("RKPIU1602000000", "Iuran Jatuh Tempo Belum Rekon"),
  RKPIU1603000000("RKPIU1603000000", "Iuran Dibayar Dimuka"),
  RKPIU1604000000("RKPIU1604000000", "Iuran Belum Rekon Tahun Lalu"),
  RKPIU1700000000("RKPIU1700000000", "Total Iuran"),
  RKPIU1801000000("RKPIU1801000000", "Saldo Awal Rekapitulasi Dana Program JP"),
  RKPIU1802000000("RKPIU1802000000", "Iuran tahun Berjalan Rekapitulasi Dana Program JP"),
  RKPIU1803000000("RKPIU1803000000", "Hasil Pengembangan Rekapitulasi Dana Program JP"),
  RKPIU1804000000("RKPIU1804000000", "Amalgamasi / Penyesuaian Rekapitulasi Dana Program JP"),
  RKPIU1805000000("RKPIU1805000000", "Klaim Rekapitulasi Dana Program JP"),
  RKPIU1900000000("RKPIU1900000000", "Total Rekapitulasi Dana Program JP"),;

  @Getter
  private String key;
  private String value;

  private static final String RKPST = EFormLpbptkjp.RKPST.getCode();
  private static final String RPIU = EFormLpbptkjp.RPIU.getCode();

  public static final int[] COLS_NON_TOTAL = { 2, 3 };

  public static String getName() {
    return ER6305RKPIU.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER6305RKPIU.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLpbptkjp.RKPIU.getCode() + key;
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
    for (ER6305RKPIU eEnum : ER6305RKPIU.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER6305RKPIU eEnum : ER6305RKPIU.values()) {
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
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 3), getObjects());
  }

  public static SegmentValidation genRegexValidationNumeric() {
    return UtilSegmentValidation.genRegexNumeric("2|3", UtilMetadata.genPipeRow(getObjects(), 0, 45));
  }

  public static SegmentValidation genRegexValidationNumericNegative() {
    return UtilSegmentValidation.genRegexNumericNegative("2|3", UtilMetadata.genPipeRow(getObjects(), 46, 51));
  }

  public static SegmentValidation genValidationTotalKelompokUsaha() {
    List<IObject<KeyValueString>> listKv = Arrays.asList(RKPIU0301000000, RKPIU0302000000, RKPIU0303000000,
        RKPIU0304000000, RKPIU0305000000, RKPIU0306000000, RKPIU0307000000, RKPIU0308000000, RKPIU0309000000);
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RKPIU0400000000, listKv);
  }

  public static SegmentValidation genValidationTotalJenisKelamin() {
    List<IObject<KeyValueString>> listKv = Arrays.asList(RKPIU0501000000, RKPIU0502000000);
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RKPIU0600000000, listKv);
  }

  public static SegmentValidation genValidationTotalKelompokUmur() {
    List<IObject<KeyValueString>> listKv = Arrays.asList(RKPIU0901000000, RKPIU0902000000, RKPIU0903000000,
        RKPIU0904000000, RKPIU0905000000, RKPIU0906000000, RKPIU0907000000, RKPIU0908000000, RKPIU0909000000,
        RKPIU0910000000, RKPIU0911000000, RKPIU0912000000, RKPIU0914000000);
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RKPIU1000000000, listKv);
  }

  public static SegmentValidation genValidationTotalKewarganegaraan() {
    List<IObject<KeyValueString>> listKv = Arrays.asList(RKPIU1101000000, RKPIU1102000000);
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RKPIU1200000000, listKv);
  }

  public static SegmentValidation genValidationTotalKelompokUpah() {
    List<IObject<KeyValueString>> listKv = Arrays.asList(RKPIU1401000000, RKPIU1402000000, RKPIU1403000000,
        RKPIU1404000000, RKPIU1405000000);
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RKPIU1500000000, listKv);
  }

  public static SegmentValidation genValidationTotalIuran() {
    List<IObject<KeyValueString>> listKv = Arrays.asList(RKPIU1601000000, RKPIU1602000000, RKPIU1603000000,
        RKPIU1604000000);
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RKPIU1700000000, listKv);
  }

  public static SegmentValidation genValidationTotalRekapDanaJp() {
    List<IObject<KeyValueString>> listKv = Arrays.asList(RKPIU1801000000, RKPIU1802000000, RKPIU1803000000,
        RKPIU1804000000, RKPIU1805000000);
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RKPIU1900000000, listKv);
  }

  public static FieldValidation genValidationTotalPemberiKerja() {
    int[] cols = { 2, 4, 6 };
    return UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(cols), RKPIU0100000000.getValue());
  }

  public static FieldValidation genValidationTotalPeserta() {
    int[] cols = { 3, 5, 7 };
    return UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(cols), RKPIU0100000000.getValue());
  }

  private static SegmentValidation genPlusValidation(String selectField, IObject<KeyValueString> selectPos,
      List<IObject<KeyValueString>> listKv) {
    String formula = UtilMetadata.joinKeys(listKv, UtilMetadata.PLUS).toString();
    String errMsg = UtilMetadata.genMessage(selectPos.getObject().getValue(),
        UtilMetadata.joinValues(listKv, UtilMetadata.PLUS).toString());
    return UtilSegmentValidation.genEqualsFormula(selectField, selectPos.getObject().getKey(), formula, errMsg);
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genValidatonFormTotalKelompokUsahaA() {
    String selectColumn = "2";
    String selectPosCode = RKPIU0400000000.key;
    int cols[] = { 8 };
    String comparatorColumn = UtilMetadata.genPlusColumn(cols);
    String errMsg = "Total Pemberi Kerja Penerima Upah|Total Pemberi Kerja Penerima Upah pada form " + RKPST;
    return UtilSegmentValidation.genEqualsFormColumCalculation(selectColumn, selectPosCode, comparatorColumn,
        ER6301RKPST.RKPST0200000000.getKeyForm(), errMsg, 2);
  }

  public static SegmentValidation genValidatonFormTotalKelompokUsahaB() {
    String selectColumn = "3";
    String selectPosCode = RKPIU0400000000.key;
    int cols[] = { 9 };
    String comparatorColumn = UtilMetadata.genPlusColumn(cols);
    String errMsg = "Total Peserta Penerima Upah|Total Peserta Penerima Upah pada form " + RKPST;
    return UtilSegmentValidation.genEqualsFormColumCalculation(selectColumn, selectPosCode, comparatorColumn,
        ER6301RKPST.RKPST0200000000.getKeyForm(), errMsg, 2);
  }

  public static SegmentValidation genValidatonFormTotalJenisKelamin() {
    String selectColumn = "3";
    String selectPosCode = RKPIU0600000000.key;
    int cols[] = { 24 };
    String comparatorColumn = UtilMetadata.genPlusColumn(cols);
    String errMsg = "Total Jenis Kelamin|Total Jenis Kelamin pada form " + RKPST;
    return UtilSegmentValidation.genEqualsFormColumCalculation(selectColumn, selectPosCode, comparatorColumn,
        ER6301RKPST.RKPST0200000000.getKeyForm(), errMsg, 2);
  }

  public static SegmentValidation genValidatonFormTotalKelompokUmur() {
    String selectColumn = "3";
    String selectPosCode = RKPIU1000000000.key;
    int cols[] = { 43 };
    String comparatorColumn = UtilMetadata.genPlusColumn(cols);
    String errMsg = "Total Kelompok Umur|Total Kelompok Umur pada form " + RKPST;
    return UtilSegmentValidation.genEqualsFormColumCalculation(selectColumn, selectPosCode, comparatorColumn,
        ER6301RKPST.RKPST0200000000.getKeyForm(), errMsg, 2);
  }

  public static SegmentValidation genValidatonFormTotalKewarganegaraan() {
    String selectColumn = "3";
    String selectPosCode = RKPIU1200000000.key;
    int cols[] = { 46 };
    String comparatorColumn = UtilMetadata.genPlusColumn(cols);
    String errMsg = "Total Kewarganegaraan|Total Kewarganegaraan pada form " + RKPST;
    return UtilSegmentValidation.genEqualsFormColumCalculation(selectColumn, selectPosCode, comparatorColumn,
        ER6301RKPST.RKPST0200000000.getKeyForm(), errMsg, 2);
  }

  public static SegmentValidation genValidatonFormTotalKelompokUpah() {
    String selectColumn = "3";
    String selectPosCode = RKPIU1500000000.key;
    int cols[] = { 14 };
    String comparatorColumn = UtilMetadata.genPlusColumn(cols);
    String errMsg = "Total Kelompok Upah|Total Kelompok Upah pada form " + RPIU;
    return UtilSegmentValidation.genEqualsFormColumCalculation(selectColumn, selectPosCode, comparatorColumn,
        ER5902RPIU.RPIU0200000000.getKeyForm(), errMsg, 2);
  }

  public static SegmentValidation genValidatonFormTotalIuran() {
    String selectColumn = "3";
    String selectPosCode = RKPIU1700000000.key;
    int cols[] = { 22 };
    String comparatorColumn = UtilMetadata.genPlusColumn(cols);
    String errMsg = "Total Iuran|Total Iuran yang diterima pada form " + RPIU;
    return UtilSegmentValidation.genEqualsFormColumCalculation(selectColumn, selectPosCode, comparatorColumn,
        ER5902RPIU.RPIU0200000000.getKeyForm(), errMsg, 2);
  }
}
