package id.go.ojk.bptk.client.builder.field.lpbptkjht.reference;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLpbptkjkk;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER6105RKPIU implements IObject<KeyValueString> {
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
  RKPIU1801000000("RKPIU1801000000", "Saldo Awal Rekapitulasi Dana Program JHT"),
  RKPIU1802000000("RKPIU1802000000", "Iuran tahun Berjalan Rekapitulasi Dana Program JHT"),
  RKPIU1803000000("RKPIU1803000000", "Hasil Pengembangan Rekapitulasi Dana Program JHT"),
  RKPIU1804000000("RKPIU1804000000", "Amalgamasi / Penyesuaian Rekapitulasi Dana Program JHT"),
  RKPIU1805000000("RKPIU1805000000", "Klaim Rekapitulasi Dana Program JHT"),
  RKPIU1900000000("RKPIU1900000000", "Total Rekapitulasi Dana Program JHT"),
  ;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER6105RKPIU.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER6105RKPIU.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLpbptkjkk.RKPIU.getCode() + key;
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
    for (ER6105RKPIU eEnum : ER6105RKPIU.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER6105RKPIU eEnum : ER6105RKPIU.values()) {
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
}
