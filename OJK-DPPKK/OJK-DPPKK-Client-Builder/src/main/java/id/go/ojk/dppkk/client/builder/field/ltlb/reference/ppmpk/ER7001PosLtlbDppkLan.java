package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1255JenisManfaat;
import id.go.ojk.dppkk.client.builder.constant.JenisProgram;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7001PosLtlbDppkLan implements IObject<KeyValueString> {

    R_LAN0101010000("LAN0101010000", "Deposito on call pada Bank", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101020000("LAN0101020000", "Deposito Berjangka pada Bank", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101030000("LAN0101030000", "Sertifikat Deposito pada Bank", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101040000("LAN0101040000", "Surat Berharga yang diterbitkan oleh Bank Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101050000("LAN0101050000", "Surat Berharga Negara", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101060000("LAN0101060000", "Saham yang tercatat di Bursa Efek di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101070000("LAN0101070000", "Obligasi korporasi yang tercatat di Bursa Efek di indonesia", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101080000("LAN0101080000", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101090000("LAN0101090000", "Obligasi/Sukuk Daerah", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101100000("LAN0101100000", "Reksa Dana", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101110000("LAN0101110000", "MTN", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101120000("LAN0101120000", "Efek Beragun Aset", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101130000("LAN0101130000", "Dana investasi real estat berbentuk kontrak investasi kolektif", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101140000("LAN0101140000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101150000("LAN0101150000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101160000("LAN0101160000", "REPO", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101170000("LAN0101170000", "Penyertaan langsung di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101180000("LAN0101180000", "Tanah di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101190000("LAN0101190000", "Bangunan di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_LAN0101200000("LAN0101200000", "Tanah dan Bangunan di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_LAN0102000000("LAN0102000000", "TOTAL INVESTASI", EnumSet.of(JenisProgram.ALL)),
    R_LAN0103010000("LAN0103010000", "Kas dan Bank", EnumSet.of(JenisProgram.ALL)),
    R_LAN0103030000("LAN0103030000", "- Iuran Normal Pemberi Kerja", EnumSet.of(JenisProgram.ALL)),
    R_LAN0103040000("LAN0103040000", "- Iuran Normal Peserta", EnumSet.of(JenisProgram.ALL)),
    R_LAN0103050000("LAN0103050000", "- Iuran Sukarela Peserta", EnumSet.of(JenisProgram.ALL)),
    R_LAN0103060000("LAN0103060000", "Piutang Bunga Keterlambatan Iuran", EnumSet.of(JenisProgram.ALL)),
    R_LAN0103070000("LAN0103070000", "Beban Dibayar di Muka", EnumSet.of(JenisProgram.ALL)),
    R_LAN0103080000("LAN0103080000", "Piutang Investasi", EnumSet.of(JenisProgram.ALL)),
    R_LAN0103090000("LAN0103090000", "Piutang Hasil Investasi", EnumSet.of(JenisProgram.ALL)),
    R_LAN0103100000("LAN0103100000", "Piutang Lain-Lain", EnumSet.of(JenisProgram.ALL)),
    R_LAN0104000000("LAN0104000000", "TOTAL ASET LANCAR DI LUAR INVESTASI", EnumSet.of(JenisProgram.ALL)),
    R_LAN0104020000("LAN0104020000", "Tanah dan Bangunan", EnumSet.of(JenisProgram.ALL)),
    R_LAN0104030000("LAN0104030000", "Kendaraan", EnumSet.of(JenisProgram.ALL)),
    R_LAN0104040000("LAN0104040000", "Peralatan Komputer", EnumSet.of(JenisProgram.ALL)),
    R_LAN0104050000("LAN0104050000", "Peralatan Kantor", EnumSet.of(JenisProgram.ALL)),
    R_LAN0104060000("LAN0104060000", "Aset Operasional Lain", EnumSet.of(JenisProgram.ALL)),
    R_LAN0105000000("LAN0105000000", "TOTAL ASET OPERASIONAL", EnumSet.of(JenisProgram.ALL)),
    R_LAN0106000000("LAN0106000000", "ASET LAIN-LAIN", EnumSet.of(JenisProgram.ALL)),
    R_LAN0107000000("LAN0107000000", "ASET TERSEDIA", EnumSet.of(JenisProgram.ALL)),
    R_LAN0108020000("LAN0108020000", "Liabilitas di luar Nilai Kini Aktuarial",
            EnumSet.of(JenisProgram.PPMPM)),
//    R_LAN0108010000("LAN0108010000", "Liabilitas di luar Liabilitas Manfaat Pensiun",
//            EnumSet.of(JenisProgram.PPIPM, JenisProgram.PPIPK, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),
    R_LAN0108020100("LAN0108020100", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo", EnumSet.of(JenisProgram.ALL)),
    R_LAN0108020200("LAN0108020200", "Utang Manfaat Sukarela", EnumSet.of(JenisProgram.ALL)),
    R_LAN0108020300("LAN0108020300", "Utang Investasi", EnumSet.of(JenisProgram.ALL)),
    R_LAN0108020400("LAN0108020400", "Pendapatan Diterima di Muka", EnumSet.of(JenisProgram.ALL)),
    R_LAN0108020500("LAN0108020500", "Beban yang Masih Harus Dibayar", EnumSet.of(JenisProgram.ALL)),
    R_LAN0108020600("LAN0108020600", "Utang Lain-Lain", EnumSet.of(JenisProgram.ALL)),
    R_LAN0108020700("LAN0108020700", "Utang Dana Ta'zir (bagi syariah)", EnumSet.of(JenisProgram.ALL)),
    R_LAN0109000000("LAN0109000000", "Total Liabilitas di luar Liabilitas Manfaat Pensiun", EnumSet.of(JenisProgram.ALL)),
    R_LAN0110000000("LAN0110000000", "TOTAL LIABILITAS", EnumSet.of(JenisProgram.ALL)),
    R_LAN0111000000("LAN0111000000", "ASET NETO", EnumSet.of(JenisProgram.ALL))

    ;

    private final String key;
    private final String value;
    private final EnumSet<JenisProgram> jenisProgram;

    private static final String COL_GABUNGAN = "13";
    private static final String INSP = "INSP";
    private static final String KASB = "KASB";
    private static final String LAK = "LAK";
    private static final String TNBG = "TNBG";
    private static final String KNDR = "KNDR";
    private static final String PKOM = "PKOM";
    private static final String PKAN = "PKAN";
    private static final String ASOL = "ASOL";
    private static final String NRC = "NRC";
    private static final String UMPS = "UMPS";
    private static final String LPAN = "LPAN";
    private static final String PST = "PST";

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects(JenisProgram jenisProgram) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7001PosLtlbDppkLan eEnum : ER7001PosLtlbDppkLan.values()) {
            if (eEnum.jenisProgram.contains(jenisProgram) || eEnum.jenisProgram.contains(JenisProgram.ALL) ) {
                res.add(eEnum.getObject());
            }

        }
        return res;
    }

    public static String getName() {
        return ER7001PosLtlbDppkLan.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7001PosLtlbDppkLan.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave(JenisProgram jenisProgram) {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects(jenisProgram));
    }

    public static String getRequiredPos(JenisProgram jenisProgram) {
        return UtilMetadata.genPipeRow(getObjects(jenisProgram));
    }

    public static SegmentValidation getTestVal() {
        String sumField = "3";
        String rangeField = "6|6"; // I H J K
        String criteriaField = "9|12";
        String comparatorForms = EFormLaporanTahunanLaporanBulanan.LTLB_DPJKA.getCode() + "|" + EFormLaporanTahunanLaporanBulanan.LTLB_DPJKV.getCode();
        String comparatorRows = ER7023PosLtlbDppkDpjka.R_DPJKA010000.getObject().getKey() + "|" + ER7024PosLtlbDppkDpjkv.R_DPJKV010000.getObject().getKey();
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCond = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String sumConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
        String errMsg = "DPJKA|DPJKV|Jumlah Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain";

        return UtilSegmentValidation.genMultiFormSumIf(UtilMetadata.genPipeColumn(3, 12), R_LAN0101020000.key,
                comparatorForms, comparatorRows,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCond,
                errMsg, criteriaConditionErr, sumConditionErr);
    }

    public static SegmentValidation genValidatonFormINSP() {
      KeyValueString selectPosCode = R_LAN0102000000.getObject();
      int cols[] = { 4 };
      String comparatorColumn = UtilMetadata.genPlusColumn(cols);
      String comparatorPosCode = INSP + ER7013PosLtlbDppkInsp.R_INSP000000.getKey();
      String errMsg = selectPosCode.getValue() + " | Total Jumlah Investasi pada form " + INSP;
      return UtilSegmentValidation.genEqualsFormColumCalculation(COL_GABUNGAN, selectPosCode.getKey(), comparatorColumn,
          comparatorPosCode, errMsg, 2);
    }

    public static SegmentValidation genValidatonFormKASB() {
      KeyValueString selectPosCode = R_LAN0103010000.getObject();
      int cols[] = { 6 };
      String comparatorColumn = UtilMetadata.genPlusColumn(cols);
      String comparatorPosCode = KASB + ER7041PosLtlbDppkKasb.R_KASB000000.getKey();
      String errMsg = selectPosCode.getValue() + " | Total Nominal pada form " + KASB;
      return UtilSegmentValidation.genEqualsFormColumCalculation(COL_GABUNGAN, selectPosCode.getKey(), comparatorColumn,
          comparatorPosCode, errMsg, 2);
    }

    public static SegmentValidation genValidatonFormLAK() {
      KeyValueString selectPosCode = R_LAN0103010000.getObject();
      int cols[] = { 12 };
      String comparatorColumn = UtilMetadata.genPlusColumn(cols);
      KeyValueString comparatorPosCode = ER7005PosLtlbDppkLak.R_LAK0900000000.getObject();
      String comparatorPosCodeForm = LAK + comparatorPosCode.getKey();
      String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + LAK;
      return UtilSegmentValidation.genEqualsFormColumCalculation(COL_GABUNGAN, selectPosCode.getKey(), comparatorColumn,
          comparatorPosCodeForm, errMsg, 2);
    }

    public static SegmentValidation genValidatonFormTNBG() {
      KeyValueString selectPosCode = R_LAN0104020000.getObject();
      int cols[] = { 8 };
      String comparatorColumn = UtilMetadata.genPlusColumn(cols);
      String comparatorPosCode = TNBG + ER7048PosLtlbDppkTnbg.R_TNBG000000.getKey();
      String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + TNBG;
      return UtilSegmentValidation.genEqualsFormColumCalculation(COL_GABUNGAN, selectPosCode.getKey(), comparatorColumn,
          comparatorPosCode, errMsg, 2);
    }

    public static SegmentValidation genValidatonFormKNDR() {
      KeyValueString selectPosCode = R_LAN0104030000.getObject();
      int cols[] = { 7 };
      String comparatorColumn = UtilMetadata.genPlusColumn(cols);
      String comparatorPosCode = KNDR + ER7049PosLtlbDppkKndr.R_KNDR000000.getKey();
      String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + KNDR;
      return UtilSegmentValidation.genEqualsFormColumCalculation(COL_GABUNGAN, selectPosCode.getKey(), comparatorColumn,
          comparatorPosCode, errMsg, 2);
    }

    public static SegmentValidation genValidatonFormPKOM() {
      KeyValueString selectPosCode = R_LAN0104040000.getObject();
      int cols[] = { 6 };
      String comparatorColumn = UtilMetadata.genPlusColumn(cols);
      String comparatorPosCode = PKOM + ER7050PosLtlbDppkPkom.R_PKOM000000.getKey();
      String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + PKOM;
      return UtilSegmentValidation.genEqualsFormColumCalculation(COL_GABUNGAN, selectPosCode.getKey(), comparatorColumn,
          comparatorPosCode, errMsg, 2);
    }

    public static SegmentValidation genValidatonFormPKAN() {
      KeyValueString selectPosCode = R_LAN0104050000.getObject();
      int cols[] = { 6 };
      String comparatorColumn = UtilMetadata.genPlusColumn(cols);
      String comparatorPosCode = PKAN + ER7051PosLtlbDppkPkan.R_PKAN000000.getKey();
      String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + PKAN;
      return UtilSegmentValidation.genEqualsFormColumCalculation(COL_GABUNGAN, selectPosCode.getKey(), comparatorColumn,
          comparatorPosCode, errMsg, 2);
    }

    public static SegmentValidation genValidatonFormASOL() {
      KeyValueString selectPosCode = R_LAN0104060000.getObject();
      int cols[] = { 6 };
      String comparatorColumn = UtilMetadata.genPlusColumn(cols);
      String comparatorPosCode = ASOL + ER7052PosLtlbDppkAsol.R_ASOL000000.getKey();
      String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + ASOL;
      return UtilSegmentValidation.genEqualsFormColumCalculation(COL_GABUNGAN, selectPosCode.getKey(), comparatorColumn,
          comparatorPosCode, errMsg, 2);
    }

    public static SegmentValidation genValidatonFormNRC() {
      KeyValueString selectPosCode = R_LAN0107000000.getObject();
      int cols[] = { 12 };
      String comparatorColumn = UtilMetadata.genPlusColumn(cols);
      KeyValueString comparatorPosCode = ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject();
      String comparatorPosCodeForm = NRC + comparatorPosCode.getKey();
      String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + NRC;
      return UtilSegmentValidation.genEqualsFormColumCalculation(COL_GABUNGAN, selectPosCode.getKey(), comparatorColumn,
          comparatorPosCodeForm, errMsg, 2);
    }

    public static SegmentValidation genValidatonFormUMPS() {
      KeyValueString selectPosCode = R_LAN0108020200.getObject();
      int cols[] = { 4 };
      String comparatorColumn = UtilMetadata.genPlusColumn(cols);
      KeyValueString comparatorPosCode = ER7055PosLtlbDppkUmps.R_UMPS000000.getObject();
      String comparatorPosCodeForm = UMPS + comparatorPosCode.getKey();
      String errMsg = selectPosCode.getValue() + " | " + comparatorPosCode.getValue() + " pada form " + UMPS;
      return UtilSegmentValidation.genEqualsFormColumCalculation(COL_GABUNGAN, selectPosCode.getKey(), comparatorColumn,
          comparatorPosCodeForm, errMsg, 2);
    }

    public static SegmentValidation genValidatonFormLPAN() {
      KeyValueString selectPosCode = R_LAN0111000000.getObject();
      int cols[] = { 12 };
      String comparatorColumn = UtilMetadata.genPlusColumn(cols);
      KeyValueString comparatorPosCode = ER7002PosLtlbDppkLpan.R_LPAN0500000000.getObject();
      String comparatorPosCodeForm = LPAN + comparatorPosCode.getKey();
      String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + LPAN;
      return UtilSegmentValidation.genEqualsFormColumCalculation(COL_GABUNGAN, selectPosCode.getKey(), comparatorColumn,
          comparatorPosCodeForm, errMsg, 2);
    }

    public static SegmentValidation genValidatonFormPST() {
      String selecPosCode = R_LAN0111000000.key;
      String selectExpr = "> 0";
      KeyValueString comparator = ER7006PosLtlbDppkPst.R_PST0400000000.getObject();
      String comparatorExpr = "> 0";
      String errMsg = R_LAN0111000000.value + "|" + comparator.getValue();
      return UtilSegmentValidation.genEqualsFormExpression("13", selecPosCode, selectExpr, PST, "5",
          comparator.getKey(), comparatorExpr, "e", 2, errMsg);
    }
}
