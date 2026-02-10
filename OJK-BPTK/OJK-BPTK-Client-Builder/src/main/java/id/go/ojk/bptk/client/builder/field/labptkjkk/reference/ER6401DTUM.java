package id.go.ojk.bptk.client.builder.field.labptkjkk.reference;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLabptkjkk;
import id.go.ojk.bptk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER6401DTUM implements IObject<KeyValueString> {
  DTUM0101000000("DTUM0101000000", "Nama Perusahaan"),
  DTUM0102000000("DTUM0102000000", "Jenis Program"),
  DTUM0103000000("DTUM0103000000", "Alamat Kantor"),
  DTUM0104000000("DTUM0104000000", "Lokasi Kabupaten/Kota"),
  DTUM0105000000("DTUM0105000000", "Kode Pos"),
  DTUM0301000000("DTUM0301000000", "Nama Lengkap Penyusun Laporan"),
  DTUM0302000000("DTUM0302000000", "Jabatan Penyusun Laporan"),
  DTUM0303000000("DTUM0303000000", "Nomor Telepon Penyusun Laporan"),
  DTUM0304000000("DTUM0304000000", "Nomor Handphone Penyusun Laporan"),
  DTUM0305000000("DTUM0305000000", "Alamat Surat Elektronik (E-Mail) Penyusun Laporan"),
  DTUM0401000000("DTUM0401000000", "Nama Lengkap Penanggung Jawab Laporan"),
  DTUM0402000000("DTUM0402000000", "Jabatan Penanggung Jawab Laporan"),
  DTUM0403000000("DTUM0403000000", "Nomor Telepon Penanggung Jawab Laporan"),
  DTUM0404000000("DTUM0404000000", "Nomor Handphone Penanggung Jawab Laporan"),
  DTUM0405000000("DTUM0405000000", "Alamat Surat Elektronik (E-Mail) Penanggung Jawab Laporan"),
  DTUM0501000000("DTUM0501000000", "Nama Aktuaris"),
  DTUM0502000000("DTUM0502000000", "Tanggal Perhitungan Aktuaris"),
  DTUM0503000000("DTUM0503000000", "Nomor Laporan"),
  DTUM0504000000("DTUM0504000000", "Tanggal Laporan"),;

  @Getter
  private String key;
  private String value;

  private static final String PIPE = "|";
  private static final String KETERANGAN = "2";

  public static String getName() {
    return ER6401DTUM.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER6401DTUM.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLabptkjkk.DTUM.getCode() + key;
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
    for (ER6401DTUM eEnum : ER6401DTUM.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER6401DTUM eEnum : ER6401DTUM.values()) {
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
    return UtilMetadata.genFieldSave(KETERANGAN, getObjects());
  }

  public static SegmentValidation genReferenceValidation() {
    return UtilSegmentValidation.genReference(KETERANGAN, DTUM0102000000.key,
        String.valueOf(EHeaderMetadataShared.JENIS_PROGRAM.getNumber()));
  }

  public static SegmentValidation genValidationTypeAll() {
    StringJoiner joiner = new StringJoiner(PIPE)
        .add(DTUM0101000000.key)
        .add(DTUM0102000000.key)
        .add(DTUM0103000000.key)
        .add(DTUM0104000000.key)
        .add(DTUM0301000000.key)
        .add(DTUM0302000000.key)
        .add(DTUM0305000000.key)
        .add(DTUM0401000000.key)
        .add(DTUM0402000000.key)
        .add(DTUM0405000000.key)
        .add(DTUM0501000000.key)
        .add(DTUM0503000000.key);
    return UtilSegmentValidation.genRegexAll(KETERANGAN, joiner.toString());
  }

  public static SegmentValidation genValidationTypePhone() {
    StringJoiner joiner = new StringJoiner(PIPE)
        .add(DTUM0303000000.key)
        .add(DTUM0304000000.key)
        .add(DTUM0403000000.key)
        .add(DTUM0404000000.key);
    return UtilSegmentValidation.genRegexPhone2(KETERANGAN, joiner.toString());
  }

  public static SegmentValidation genValidationTypePostalCode() {
    StringJoiner joiner = new StringJoiner(PIPE)
        .add(DTUM0105000000.key);
    return UtilSegmentValidation.genRegexNumeric(KETERANGAN, joiner.toString());
  }

  public static SegmentValidation genValidationTypeDate() {
    StringJoiner joiner = new StringJoiner(PIPE)
        .add(DTUM0502000000.key)
        .add(DTUM0504000000.key);
    return UtilSegmentValidation.genRegexDate(KETERANGAN, joiner.toString());
  }

  public static SegmentValidation genLengthValidation05() {
    StringJoiner joiner = new StringJoiner(PIPE)
        .add(DTUM0105000000.key);
    return UtilSegmentValidation.genMaxLength(KETERANGAN, joiner.toString(), 5);
  }

  public static SegmentValidation genLengthValidation08() {
    StringJoiner joiner = new StringJoiner(PIPE)
        .add(DTUM0502000000.key)
        .add(DTUM0504000000.key);
    return UtilSegmentValidation.genMaxLength(KETERANGAN, joiner.toString(), 8);
  }

  public static SegmentValidation genLengthValidation15() {
    StringJoiner joiner = new StringJoiner(PIPE)
        .add(DTUM0303000000.key)
        .add(DTUM0304000000.key)
        .add(DTUM0403000000.key)
        .add(DTUM0404000000.key);
    return UtilSegmentValidation.genMaxLength(KETERANGAN, joiner.toString(), 15);
  }

  public static SegmentValidation genLengthValidation40() {
    StringJoiner joiner = new StringJoiner(PIPE)
        .add(DTUM0302000000.key)
        .add(DTUM0402000000.key);
    return UtilSegmentValidation.genMaxLength(KETERANGAN, joiner.toString(), 40);
  }

  public static SegmentValidation genLengthValidation50() {
    StringJoiner joiner = new StringJoiner(PIPE)
        .add(DTUM0305000000.key)
        .add(DTUM0405000000.key);
    return UtilSegmentValidation.genMaxLength(KETERANGAN, joiner.toString(), 50);
  }

  public static SegmentValidation genLengthValidation100() {
    StringJoiner joiner = new StringJoiner(PIPE)
        .add(DTUM0101000000.key)
        .add(DTUM0102000000.key)
        .add(DTUM0301000000.key)
        .add(DTUM0401000000.key)
        .add(DTUM0501000000.key)
        .add(DTUM0503000000.key);
    return UtilSegmentValidation.genMaxLength(KETERANGAN, joiner.toString(), 100);
  }

  public static SegmentValidation genLengthValidation200() {
    StringJoiner joiner = new StringJoiner(PIPE)
        .add(DTUM0103000000.key)
        .add(DTUM0104000000.key);
    return UtilSegmentValidation.genMaxLength(KETERANGAN, joiner.toString(), 200);
  }
}
