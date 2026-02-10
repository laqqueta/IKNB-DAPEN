package id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference;

import java.util.ArrayList;
import java.util.List;

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
public enum ER5300DTUM implements IObject<KeyValueString> {
  DTUM0101000000("DTUM0101000000","Nama Perusahaan"),
  DTUM0102000000("DTUM0102000000","Nomor SID"),
  DTUM0103000000("DTUM0103000000","Jenis Program"),
  DTUM0104000000("DTUM0104000000","Alamat Kantor"),
  DTUM0105000000("DTUM0105000000","Lokasi Kabupaten/Kota"),
  DTUM0106000000("DTUM0106000000","Kode Pos"),
  DTUM0301000000("DTUM0301000000","Nama Lengkap Penyusun Laporan"),
  DTUM0302000000("DTUM0302000000","Jabatan Penyusun Laporan"),
  DTUM0303000000("DTUM0303000000","Nomor Telepon Penyusun Laporan"),
  DTUM0304000000("DTUM0304000000","Nomor Handphone Penyusun Laporan"),
  DTUM0305000000("DTUM0305000000","Alamat Surat Elektronik (E-Mail) Penyusun Laporan"),
  DTUM0401000000("DTUM0401000000","Nama Lengkap Penanggung Jawab Laporan"),
  DTUM0402000000("DTUM0402000000","Jabatan Penanggung Jawab Laporan"),
  DTUM0403000000("DTUM0403000000","Nomor Telepon Penanggung Jawab Laporan"),
  DTUM0404000000("DTUM0404000000","Nomor Handphone Penanggung Jawab Laporan"),
  DTUM0405000000("DTUM0405000000","Alamat Surat Elektronik (E-Mail) Penanggung Jawab Laporan"),
  ;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5300DTUM.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5300DTUM.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5300DTUM eEnum : ER5300DTUM.values()) {
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
    return UtilMetadata.genFieldSave("2", getObjects());
  }

  public static SegmentValidation genReferenceValidationA() {
    return UtilSegmentValidation.genReference("2", DTUM0103000000.key,
        String.valueOf(EHeaderMetadataShared.JENIS_PROGRAM.getNumber()));
  }

  public static SegmentValidation genValidationTypeReference() {
    int[] rows = { 5 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genRegexReference1("2", selectPosCode);
  }

  public static SegmentValidation genValidationTypePhone() {
    int[] rows = { 8, 9, 13, 14 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genRegexPhone2("2", selectPosCode);
  }
  
  public static SegmentValidation genValidationTypeAll() {
    int[] rows = { 0, 2, 3, 4, 6, 7, 10, 11, 12, 15 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genRegexAll("2", selectPosCode);
  }
  
  public static SegmentValidation genValidationAlfaNumeric() {
    int[] rows = { 1 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genRegexAlfaNumeric("2", selectPosCode);
  }

  public static SegmentValidation genLengthValidation05() {
    int[] rows = { 5 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genMaxLength("2", selectPosCode, 5);
  }

  public static SegmentValidation genLengthValidation15() {
    int[] rows = { 1, 8, 9, 13, 14 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genMaxLength("2", selectPosCode, 15);
  }

  public static SegmentValidation genLengthValidation40() {
    int[] rows = { 7, 12 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genMaxLength("2", selectPosCode, 40);
  }

  public static SegmentValidation genLengthValidation50() {
    int[] rows = { 10, 15 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genMaxLength("2", selectPosCode, 50);
  }

  public static SegmentValidation genLengthValidation100() {
    int[] rows = { 0, 2, 6, 11 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genMaxLength("2", selectPosCode, 100);
  }

  public static SegmentValidation genLengthValidation200() {
    int[] rows = { 3, 4 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genMaxLength("2", selectPosCode, 200);
  }
}
