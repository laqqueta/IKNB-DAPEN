package id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5200PRUM implements IObject<KeyValueString> {
  PRUM0100000000("PRUM0100000000", "1. Nama Institusi"),
  PRUM0201000000("PRUM0201000000", "a. Alamat Lengkap"),
  PRUM0202000000("PRUM0202000000", "b. Status Pemilikan Gedung"),
  PRUM0203000000("PRUM0203000000", "c. Sandi Lokasi"),
  PRUM0204000000("PRUM0204000000", "d. Nama Kota"),
  PRUM0205000000("PRUM0205000000", "e. Kode Pos"),
  PRUM0300000000("PRUM0300000000", "3. Telepon"),
  PRUM0400000000("PRUM0400000000", "4. Website"),
  PRUM0500000000("PRUM0500000000", "5. NPWP"),
  PRUM0601000000("PRUM0601000000", "a. Jumlah Kantor Kedeputian Wilayah"),
  PRUM0602000000("PRUM0602000000", "b. Jumlah Kantor Cabang"),
  PRUM0603000000("PRUM0603000000", "c. Total"),
  PRUM0701000000("PRUM0701000000", "a. Kantor Pusat"),
  PRUM0702000000("PRUM0702000000", "b. Kantor Kedeputian Wilayah"),
  PRUM0703000000("PRUM0703000000", "c. Kantor Cabang"),
  PRUM0704000000("PRUM0704000000", "d. Total"),
  PRUM0800000000("PRUM0800000000", "8. Nama Aktuaris"),
  PRUM0901000000("PRUM0901000000", "a. Jumlah Direksi"),
  PRUM0902000000("PRUM0902000000", "b. Jumlah Dewan Pengawas"),
  PRUM0903000000("PRUM0903000000", "c. Total"),
  PRUM1001010000("PRUM1001010000", "a. Nama Lengkap"),
  PRUM1001020000("PRUM1001020000", "b. Jabatan"),
  PRUM1001030000("PRUM1001030000", "c. Telepon"),
  PRUM1001040000("PRUM1001040000", "d. E-mail"),
  PRUM1002010000("PRUM1002010000", "a. Nama"),
  PRUM1002020000("PRUM1002020000", "b. Jabatan"),
  PRUM1002030000("PRUM1002030000", "c. Unit Kerja"),
  PRUM1002040000("PRUM1002040000", "d. Telepon"),
  PRUM1002050000("PRUM1002050000", "e. Email"),;

  @Getter
  private String key;
  private String value;

  public static final String PDK = EFormLbbpkslpp.PDK.getCode();
  public static final String DIR = EFormLbbpkslpp.DIR.getCode();
  public static final String DWAS = EFormLbbpkslpp.DWAS.getCode();

  public static String getName() {
    return ER5200PRUM.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5200PRUM.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5200PRUM eEnum : ER5200PRUM.values()) {
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
    return UtilSegmentValidation.genReference("2", PRUM0202000000.key,
        String.valueOf(EHeaderMetadataShared.STATUS_KEPEMILIKAN_GEDUNG_UNIT_USAHA.getNumber()));
  }

  public static SegmentValidation genReferenceValidationB() {
    return UtilSegmentValidation.genReference("2", PRUM0203000000.key,
        String.valueOf(EHeaderMetadataShared.LOKASI_DATI_2.getNumber()));
  }

  public static SegmentValidation genLengthValidation05() {
    int[] rows = { 5 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genMaxLength("2", selectPosCode, 5);
  }

  public static SegmentValidation genLengthValidation06() {
    int[] rows = { 17, 18, 19 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genMaxLength("2", selectPosCode, 6);
  }

  public static SegmentValidation genLengthValidation10() {
    int[] rows = { 2, 3, 9, 10, 11, 12, 13, 14, 15 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genMaxLength("2", selectPosCode, 10);
  }

  public static SegmentValidation genLengthValidation15() {
    int[] rows = { 6 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genMaxLength("2", selectPosCode, 15);
  }

  public static SegmentValidation genLengthValidation15to16() {
    int[] rows = { 8 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genLength("2", selectPosCode, 15, 16);
  }

  public static SegmentValidation genLengthValidation50() {
    int[] rows = { 4, 7 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genMaxLength("2", selectPosCode, 50);
  }

  public static SegmentValidation genLengthValidation100() {
    int[] rows = { 0, 16, 20, 21, 22, 23, 24, 25, 26, 27, 28 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genMaxLength("2", selectPosCode, 100);
  }

  public static SegmentValidation genLengthValidation200() {
    return UtilSegmentValidation.genMaxLength("2", PRUM0201000000.key, 200);
  }

  public static SegmentValidation genValidationTypeAll() {
    int[] rows = { 0, 1, 4, 6, 7, 16, 20, 21, 22, 23, 24, 25, 26, 27, 28 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genRegexAll("2", selectPosCode);
  }

  public static SegmentValidation genValidationTypeReference() {
    int[] rows = { 2, 3, 5 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genRegexReference1("2", selectPosCode);
  }

  public static SegmentValidation genValidationTypeNumeric() {
    int[] rows = { 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19 };
    String selectPosCode = UtilMetadata.genDelimitedRow(getObjects(), rows, "|");
    return UtilSegmentValidation.genRegexNumeric("2", selectPosCode);
  }

  public static SegmentValidation genRowValidation13() {
    int[] rows = { 9, 10 };
    String plusRows = UtilMetadata.genPlusRow(getObjects(), rows);
    String plusRowsDesc = UtilMetadata.genPlusDesc(getObjects(), rows);
    return UtilSegmentValidation.genEqualsFormula("2", PRUM0603000000.key, plusRows,
        UtilMetadata.genMessage(PRUM0603000000.value, plusRowsDesc));
  }

  public static SegmentValidation genRowValidation17a() {
    int[] rows = { 12, 13, 14 };
    String plusRows = UtilMetadata.genPlusRow(getObjects(), rows);
    String plusRowsDesc = UtilMetadata.genPlusDesc(getObjects(), rows);
    return UtilSegmentValidation.genEqualsFormula("2", PRUM0704000000.key, plusRows,
        UtilMetadata.genMessage(PRUM0704000000.value, plusRowsDesc));
  }

  public static SegmentValidation genRowValidation21() {
    int[] rows = { 17, 18 };
    String plusRows = UtilMetadata.genPlusRow(getObjects(), rows);
    String plusRowsDesc = UtilMetadata.genPlusDesc(getObjects(), rows);
    return UtilSegmentValidation.genEqualsFormula("2", PRUM0903000000.key, plusRows,
        UtilMetadata.genMessage(PRUM0903000000.value, plusRowsDesc));
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation17b() {
    String selecPosCode = PRUM0704000000.key;
    String comparatorPosCode = ER5205PDK.PDK0200000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, PDK, "5", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation19() {
    return UtilSegmentValidation.genEqualsFormTotalRow("2", PRUM0901000000.key, DIR,
        UtilMetadata.genMessage(PRUM0901000000.value, "jumlah Direksi pada form DIR"));
  }
  
  public static SegmentValidation genRowValidation20() {
    return UtilSegmentValidation.genEqualsFormTotalRow("2", PRUM0902000000.key, DWAS,
        UtilMetadata.genMessage(PRUM0902000000.value, "jumlah Dewan Pengawas pada form DWAS"));
  }
}
