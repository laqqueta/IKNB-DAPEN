package id.go.ojk.metadata.module.lblt.validations.ppipm;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.UtilSegmentValidationV2;
import id.go.ojk.conf.client.dto.FormulaParserData;
import id.go.ojk.conf.client.field.reference.ER1250Properti;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.reference.*;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.validation.ValidationConverter;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;

import static id.go.ojk.conf.client.UtilMetadata.genFormulaParser;
import static id.go.ojk.metadata.module.lblt.reference.ER7012PosLtlbDppkAlm.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPIPM;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7012AlmMValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA_1(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    ER7012PosLtlbDppkAlm.R_ALM0121000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM), 0, 19),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0121000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM), 0, 19)))),

    SG_EQUAL_FORMULA_2(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    ER7012PosLtlbDppkAlm.R_ALM0211000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM), 21, 30),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0211000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM), 21, 30)))),

    SG_EQUAL_FORMULA_3(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    ER7012PosLtlbDppkAlm.R_ALM0306000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM), 32, 36),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0306000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM), 32, 36)))),

    SG_EQUAL_FORMULA_4(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    ER7012PosLtlbDppkAlm.R_ALM0908000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM), 41, 47),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0908000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM), 41, 47)))),

    SG_EQUAL_FORMULA_5(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("16",
                    ER7012PosLtlbDppkAlm.R_ALM0500000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM), new int[]{20, 31, 37, 38}),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0500000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM), new int[]{20, 31, 37, 38})))),

    SG_EQUAL_FORMULA_6(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("16",
                    ER7012PosLtlbDppkAlm.R_ALM1000000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM), new int[]{40, 48}),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM1000000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM), new int[]{40, 48})))),

    SG_EQUAL_FORMULA_7(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("16",
                    ER7012PosLtlbDppkAlm.R_ALM1100000000.getObject().getKey(),
                    UtilMetadata.genMinusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM), new int[]{39, 49}),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM1100000000.getObject().getValue(),
                            UtilMetadata.genMinusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM), new int[]{39, 49})))),

    SG_FIELD_TOTAL_1(programs(PPIPM), () -> genTotalValidation(R_ALM0101000000.key,
            EFormLaporanBulananTahunan.LTLB_DOC,
            ER7022PosLtlbDppkDoc.getObjects(),
            "6", "Nilai Wajar")),

    SG_FIELD_TOTAL_2(programs(PPIPM), () -> genTotalValidation(R_ALM0102000000.key,
            EFormLaporanBulananTahunan.LTLB_DPJKA,
            ER7023PosLtlbDppkDpjka.getObjects(),
            "6", "Nilai Wajar")),

    SG_FIELD_TOTAL_3(programs(PPIPM), () -> genTotalValidation(R_ALM0103000000.key,
            EFormLaporanBulananTahunan.LTLB_SRDP,
            ER7025PosLtlbDppkSrdp.getObjects(),
            "6", "Nilai Wajar")),

    SG_FIELD_TOTAL_4(programs(PPIPM), () -> genTotalValidation(R_ALM0104000000.key,
            EFormLaporanBulananTahunan.LTLB_SBI,
            ER7026PosLtlbDppkSbi.getObjects(),
            "8", "Nilai Nominal")),

    SG_FIELD_TOTAL_5(programs(PPIPM), () -> genTotalValidation(R_ALM0105000000.key,
            EFormLaporanBulananTahunan.LTLB_RSBN,
            ER7027PosLtlbDppkRsbn.getObjects(),
            "8", "Nilai Wajar")),

    SG_FIELD_TOTAL_6(programs(PPIPM), () -> genTotalValidation(R_ALM0106000000.key,
            EFormLaporanBulananTahunan.LTLB_SHM,
            ER7028PosLtlbDppkShm.getObjects(),
            "6", "Nilai Perolehan")),

    SG_FIELD_TOTAL_7(programs(PPIPM), () -> genTotalValidation(R_ALM0107000000.key,
            EFormLaporanBulananTahunan.LTLB_OBLI,
            ER7029PosLtlbDppkObli.getObjects(),
            "12", "Nilai Wajar")),

    SG_FIELD_TOTAL_8(programs(PPIPM), () -> genTotalValidation(R_ALM0108000000.key,
            EFormLaporanBulananTahunan.LTLB_SUKUK,
            ER7030PosLtlbDppkSukuk.getObjects(),
            "12", "Nilai Wajar")),

    SG_FIELD_TOTAL_9(programs(PPIPM), () -> genTotalValidation(R_ALM0109000000.key,
            EFormLaporanBulananTahunan.LTLB_OBSUD,
            ER7031PosLtlbDppkObsud.getObjects(),
            "12", "Nilai Wajar")),

    SG_FIELD_TOTAL_10(programs(PPIPM), () -> genTotalValidation(R_ALM0110000000.key,
            EFormLaporanBulananTahunan.LTLB_RKSD,
            ER7032PosLtlbDppkRksd.getObjects(),
            "9", "Nilai Wajar")),

    SG_FIELD_TOTAL_11(programs(PPIPM), () -> genTotalValidation(R_ALM0111000000.key,
            EFormLaporanBulananTahunan.LTLB_MTN,
            ER7033PosLtlbDppkMtn.getObjects(),
            "12", "Nilai Wajar")),

    SG_FIELD_TOTAL_12(programs(PPIPM), () -> genTotalValidation(R_ALM0112000000.key,
            EFormLaporanBulananTahunan.LTLB_EBA,
            ER7034PosLtlbDppkEba.getObjects(),
            "12", "Nilai Wajar")),

    SG_FIELD_TOTAL_13(programs(PPIPM), () -> genTotalValidation(R_ALM0113000000.key,
            EFormLaporanBulananTahunan.LTLB_DIRE,
            ER7035PosLtlbDppkDire.getObjects(),
            "8", "Nilai Perolehan")),

    SG_FIELD_TOTAL_14(programs(PPIPM), () -> genTotalValidation(R_ALM0114000000.key,
            EFormLaporanBulananTahunan.LTLB_DNFRA,
            ER7036PosLtlbDppkDnfra.getObjects(),
            "7", "Nilai Perolehan")),

    SG_FIELD_TOTAL_15(programs(PPIPM), () -> genTotalValidation(R_ALM0115000000.key,
            EFormLaporanBulananTahunan.LTLB_KOKB,
            ER7037PosLtlbDppkKokb.getObjects(),
            "7", "Nilai Wajar")),

    SG_FIELD_TOTAL_16(programs(PPIPM), () -> genTotalValidation(R_ALM0116000000.key,
            EFormLaporanBulananTahunan.LTLB_REPO,
            ER7038PosLtlbDppkRepo.getObjects(),
            "10", "Nilai Perolehan")),

    SG_FIELD_TOTAL_17(programs(PPIPM), () -> genTotalValidation(R_ALM0117000000.key,
            EFormLaporanBulananTahunan.LTLB_PNYL,
            ER7039PosLtlbDppkPnyl.getObjects(),
            "15", "Nilai Apprasial/wajar - Total")),

    SG_FIELD_TOTAL_18(programs(PPIPM), () -> genTotalValidation(R_ALM0201000000.key,
            EFormLaporanBulananTahunan.LTLB_KASB,
            ER7041PosLtlbDppkKasb.getObjects(),
            "6", "Nominal")),

    SG_FIELD_TOTAL_19(programs(PPIPM), () -> genTotalValidation(R_ALM0207000000.key,
            EFormLaporanBulananTahunan.LTLB_BBMK,
            ER7044PosLtlbDppkBbmk.getObjects(),
            "3", "Jumlah")),

    SG_FIELD_TOTAL_20(programs(PPIPM), () -> genTotalValidation(R_ALM0208000000.key,
            EFormLaporanBulananTahunan.LTLB_PIUI,
            ER7045PosLtlbDppkPiui.getObjects(),
            "4", "Nominal")),

    SG_FIELD_TOTAL_21(programs(PPIPM), () -> genTotalValidation(R_ALM0209000000.key,
            EFormLaporanBulananTahunan.LTLB_PIHI,
            ER7046PosLtlbDppkPihi.getObjects(),
            "4", "Nominal")),

    SG_FIELD_TOTAL_22(programs(PPIPM), () -> genTotalValidation(R_ALM0210000000.key,
            EFormLaporanBulananTahunan.LTLB_PILL,
            ER7047PosLtlbDppkPill.getObjects(),
            "4", "Nominal")),

    SG_FIELD_TOTAL_23(programs(PPIPM), () -> genTotalValidation(R_ALM0301000000.key,
            EFormLaporanBulananTahunan.LTLB_TNBG,
            ER7048PosLtlbDppkTnbg.getObjects(),
            "6", "Nilai Perolehan")),

    SG_FIELD_TOTAL_24(programs(PPIPM), () -> genTotalValidation(R_ALM0302000000.key,
            EFormLaporanBulananTahunan.LTLB_KNDR,
            ER7049PosLtlbDppkKndr.getObjects(),
            "5", "Nilai Perolahan")),

    SG_FIELD_TOTAL_25(programs(PPIPM), () -> genTotalValidation(R_ALM0303000000.key,
            EFormLaporanBulananTahunan.LTLB_PKOM,
            ER7050PosLtlbDppkPkom.getObjects(),
            "4", "Nilai Perolehan")),

    SG_FIELD_TOTAL_26(programs(PPIPM), () -> genTotalValidation(R_ALM0304000000.key,
            EFormLaporanBulananTahunan.LTLB_PKAN,
            ER7051PosLtlbDppkPkan.getObjects(),
            "4", "Nilai Perolehan")),

    SG_FIELD_TOTAL_27(programs(PPIPM), () -> genTotalValidation(R_ALM0305000000.key,
            EFormLaporanBulananTahunan.LTLB_ASOL,
            ER7052PosLtlbDppkAsol.getObjects(),
            "4", "Nilai Perolehan")),

    SG_FIELD_TOTAL_28(programs(PPIPM), () -> genTotalValidation(R_ALM0400000000.key,
            EFormLaporanBulananTahunan.LTLB_ASLN,
            ER7053PosLtlbDppkAsln.getObjects(),
            "5", "Nilai Aset")),

    SG_FIELD_TOTAL_29(programs(PPIPM), () -> genTotalValidation(R_ALM0901000000.key,
            EFormLaporanBulananTahunan.LTLB_UMPJ,
            ER7054PosLtlbDppkUmpj.getObjects(),
            "4", "Jumlah - Total")),

    SG_FIELD_TOTAL_30(programs(PPIPM), () -> genTotalValidation(R_ALM0902000000.key,
            EFormLaporanBulananTahunan.LTLB_UMPS,
            ER7055PosLtlbDppkUmps.getObjects(),
            "4", "Jumlah - Total")),

    SG_FIELD_TOTAL_31(programs(PPIPM), () -> genTotalValidation(R_ALM0903000000.key,
            EFormLaporanBulananTahunan.LTLB_UTIN,
            ER7056PosLtlbDppkUtin.getObjects(),
            "4", "Nilai")),

    SG_FIELD_TOTAL_32(programs(PPIPM), () -> genTotalValidation(R_ALM0904000000.key,
            EFormLaporanBulananTahunan.LTLB_PDDM,
            ER7057PosLtlbDppkPddm.getObjects(),
            "4", "Nilai")),

    SG_FIELD_TOTAL_33(programs(PPIPM), () -> genTotalValidation(R_ALM0905000000.key,
            EFormLaporanBulananTahunan.LTLB_BMHB,
            ER7058PosLtlbDppkBmhb.getObjects(),
            "4", "Nilai")),

    SG_FIELD_TOTAL_34(programs(PPIPM), () -> genTotalValidation(R_ALM0906000000.key,
            EFormLaporanBulananTahunan.LTLB_UTLN,
            ER7059PosLtlbDppkUtln.getObjects(),
            "4", "Nilai")),

    SG_FIELD_TOTAL_35(programs(PPIPM), () -> genTotalValidation(R_ALM0203000000.key,
            EFormLaporanBulananTahunan.LTLB_PIUT,
            ER7042PosLtlbDppkPiut.getObjects(),
            "5", "Piutang Iuran Pemberi Kerja - Total")),

    SG_FIELD_TOTAL_36(programs(PPIPM), () -> genTotalValidation(R_ALM0204000000.key,
            EFormLaporanBulananTahunan.LTLB_PIUT,
            ER7042PosLtlbDppkPiut.getObjects(),
            "8", "Piutang Iuran Peserta - Total")),

    SG_FIELD_TOTAL_37(programs(PPIPM), () -> genTotalValidation(R_ALM0205000000.key,
            EFormLaporanBulananTahunan.LTLB_PIUT,
            ER7042PosLtlbDppkPiut.getObjects(),
            "9", "Piutang Iuran Sukarela Peserta - Total")),

    SG_FIELD_TOTAL_ALM0202000000(programs(PPIPM), () -> {
        String selectField = "16";
        String selectPosCode = R_ALM0202000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_PIUT.getCode();
        List<KeyValueString> formObject = ER7042PosLtlbDppkPiut.getObjects();
        String fieldsName = "Piutang Iuran Pemberi Kerja - Total|Piutang Iuran Peserta - Total|Piutang Iuran Sukarela Peserta";
        FormulaParserData operation2 = genFormulaParser(formObject, "0", "5+8+9", fieldsName, comparatorForm);
        String errMsg = "sama dengan Total" + operation2.getErrMessage()
                .replace("'Detail'", "")
                .replace("Kolom ", "") + " pada form PIUT";

        return UtilSegmentValidationV2.genFormulaParserValidationV2(selectField, selectPosCode, operation2.getFormula(), errMsg);
    }),

    SG_FIELD_TOTAL_ALM0206000000(programs(PPIPM), () -> {
        String selectField = "16";
        String selectPosCode = R_ALM0206000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_PIUB.getCode();
        List<KeyValueString> formObject = ER7043PosLtlbDppkPiub.getObjects();
        String fieldsName = "Piutang Bunga Iuran Peserta - Total|Piutang Bunga Iuran Pemberi Kerja - Total";
        FormulaParserData operation2 = genFormulaParser(formObject, "0", "3+4", fieldsName, comparatorForm);
        String errMsg = "sama dengan Total" + operation2.getErrMessage()
                .replace("'Detail'", "")
                .replace("Kolom ", "") + " pada form PIUB";

        return UtilSegmentValidationV2.genFormulaParserValidationV2(selectField, selectPosCode, operation2.getFormula(), errMsg);
    }),

    SG_SUMIF_PROP_ALM0118000000(programs(PPIPM),
            () -> sumIfValidationHelper(
                    R_ALM0118000000.key, "11", "2",
                    EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                    ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                    "PROP|Nilai Appraisal/Nilai Wajar|Jenis Objek (Tanah/Bangunan/Tanah&Bangunan)", "2001"
            )),

    SG_SUMIF_PROP_ALM0119000000(programs(PPIPM),
            () -> sumIfValidationHelper(
                    R_ALM0119000000.key, "11", "2",
                    EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                    ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                    "PROP|Nilai Appraisal/Nilai Wajar|Jenis Objek (Tanah/Bangunan/Tanah&Bangunan)", "2005"
            )),

    SG_SUMIF_PROP_ALM0120000000(programs(PPIPM),
            () -> sumIfValidationHelper(
                    R_ALM0120000000.key, "11", "2",
                    EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                    ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                    "PROP|Nilai Appraisal/Nilai Wajar|Jenis Objek (Tanah/Bangunan/Tanah & Bangunan)", "2010"
            )),

//    SG_NUMERIC_DECIMAL(programs(ALL),
//            () -> UtilSegmentValidation.genRegexNumericDot(UtilMetadata.genPipeColumnExcept(2, 16, new int[] {4, 7, 10, 13, 16}),
//                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(PPMPK), new int[] { 51 }))),
//
//    SG_NUMERIC(programs(ALL),
//            () -> UtilSegmentValidation.genRegexNumericDot(UtilMetadata.genPipeColumn(2, 16),
//                    UtilMetadata.genPipeRowExcept(ER7012PosLtlbDppkAlm.getObjects(PPMPK), new int[] { 51 }))),

    FV_TOTAL1_EQUAL(programs(PPIPM), validationFields(14),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("2+5+8+11",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM),
                            new int[]{20, 31, 37, 39, 38, 40, 48, 49, 50}))),

    FV_TOTAL2_EQUAL(programs(PPIPM), validationFields(15),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("3+6+9+12",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM),
                            new int[]{20, 31, 37, 39, 38, 40, 48, 49, 50}))),

    FV_TOTAL3_EQUAL(programs(PPIPM), validationFields(16),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("14+15",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM),
                            new int[]{20, 31, 37, 39, 38, 40, 48, 49, 50}))),

    FV_JTD_EQUAL(programs(PPIPM), validationFields(13),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("11+12",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM),
                            new int[]{20, 31, 37, 39, 38, 40, 48, 49, 50}))),

    FV_JTC_EQUAL(programs(PPIPM), validationFields(10),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("8+9",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM),
                            new int[]{20, 31, 37, 39, 38, 40, 48, 49, 50}))),

    FV_JTB_EQUAL(programs(PPIPM), validationFields(7),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("5+6",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM),
                            new int[]{20, 31, 37, 39, 38, 40, 48, 49, 50}))),

    FV_JTA_EQUAL(programs(PPIPM), validationFields(4),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("2+3",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPIPM),
                            new int[]{20, 31, 37, 39, 38, 40, 48, 49, 50}))),

    ;

    private final EnumSet<ProgramType> programTypes;
    private List<Integer> fieldIndexes;
    private final Supplier<? extends IValidation> supplier;

    @Override
    public Supplier<? extends IValidation> getSupplier() {
        return supplier;
    }

    @Override
    public List<Integer> getFieldsIndex() {
        return fieldIndexes;
    }

    @Override
    public EnumSet<ProgramType> getProgramTypes() {
        return programTypes;
    }

    @Override
    public SegmentValidation toSegmentValidation() {
        return ValidationConverter
                .toValidation(this, SegmentValidation.class);
    }

    @Override
    public FieldValidation toFieldValidation() {
        return ValidationConverter
                .toValidation(this, FieldValidation.class);
    }

    @Override
    public ConditionalRequired toFieldConditional() {
        return ValidationConverter
                .toValidation(this, ConditionalRequired.class);
    }

    public static final BaseMetadataValidation<E7012AlmMValidationsConfig> VALIDATION_METADATA_PPIPM =
            new LbltMetadataValidation<>(E7012AlmMValidationsConfig.class, PPIPM);

    private static SegmentValidation genTotalValidation(String selectPosCode,
                                                        EFormLaporanBulananTahunan comparatorForm,
                                                        List<KeyValueString> formObject,
                                                        String comparatorFields, String fieldErrorMessage) {

        FormulaParserData operation2 = genFormulaParser(formObject,
                "1", /* 0 :: baris detail | 1 :: baris total
                                    kalo validasi lama ganti 1 biar langsung nembak ke baris total */
                comparatorFields, comparatorForm.getCode());

        String errMsg = "sama dengan '" + "Total" + "' Kolom '" + fieldErrorMessage + "' pada Form " + comparatorForm.getCode();

        return UtilSegmentValidationV2.genFormulaParserValidationV2("16", selectPosCode, operation2.getFormula(),
                errMsg);
    }

    private static SegmentValidation sumIfValidationHelper(String posCode, String rangeField, String criteriaField, String formCode,
                                                           String formObjects, String errMsg, String keys) {

        String criteriaCondition = ER1250Properti.getKey(keys);
        String criteriaConditionErr = ER1250Properti.getKeyValue(keys)
                .replace("&", "dan");

        return UtilSegmentValidationV2.genSumIf("16", posCode,
                formCode, formObjects,
                rangeField, criteriaField, criteriaCondition,
                errMsg, criteriaConditionErr);
    }
}
