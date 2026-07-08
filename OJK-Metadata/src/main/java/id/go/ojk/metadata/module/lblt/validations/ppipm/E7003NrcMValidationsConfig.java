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
import id.go.ojk.conf.client.field.reference.ER1255JenisManfaat;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.field.Dppk0003Nrc;
import id.go.ojk.metadata.module.lblt.reference.*;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.validation.ValidationConverter;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;

import static id.go.ojk.conf.client.UtilMetadata.genFormulaParser;
import static id.go.ojk.metadata.module.lblt.reference.ER7003PosLtlbDppkNrc.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPIPM;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7003NrcMValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUMIF_DOC(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101010000.getObject().getKey(), "6", "9",
                    EFormLaporanBulananTahunan.LTLB_DOC.getCode(),
                    ER7022PosLtlbDppkDoc.R_DOC010000.getObject().getKey(),
                    "DOC|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SRDP(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101030000.getObject().getKey(), "6", "9",
                    EFormLaporanBulananTahunan.LTLB_SRDP.getCode(),
                    ER7025PosLtlbDppkSrdp.R_SRDP010000.getObject().getKey(),
                    "SRDP|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SBI(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101040000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_SBI.getCode(),
                    ER7026PosLtlbDppkSbi.R_SBI010000.getObject().getKey(),
                    "SBI|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SHM(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101060000.getObject().getKey(), "6", "11",
                    EFormLaporanBulananTahunan.LTLB_SHM.getCode(),
                    ER7028PosLtlbDppkShm.R_SHM010000.getObject().getKey(),
                    "SHM|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_RSBN(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101050000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_RSBN.getCode(),
                    ER7027PosLtlbDppkRsbn.R_RSBN010000.getObject().getKey(),
                    "RSBN|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SUKUK(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101080000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_SUKUK.getCode(),
                    ER7030PosLtlbDppkSukuk.R_SUKUK010000.getObject().getKey(),
                    "SUKUK|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_OBLI(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101070000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_OBLI.getCode(),
                    ER7029PosLtlbDppkObli.R_OBLI010000.getObject().getKey(),
                    "OBLI|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_OBSUD(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101090000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_OBSUD.getCode(),
                    ER7031PosLtlbDppkObsud.R_OBSUD010000.getObject().getKey(),
                    "OBSUD|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_RKSD(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101100000.getObject().getKey(), "8", "12",
                    EFormLaporanBulananTahunan.LTLB_RKSD.getCode(),
                    ER7032PosLtlbDppkRksd.R_RKSD010000.getObject().getKey(),
                    "RKSD|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_MTN(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101110000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_MTN.getCode(),
                    ER7033PosLtlbDppkMtn.R_MTN010000.getObject().getKey(),
                    "MTN|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_EBA(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101120000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_EBA.getCode(),
                    ER7034PosLtlbDppkEba.R_EBA010000.getObject().getKey(),
                    "EBA|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_DIRE(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101130000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_DIRE.getCode(),
                    ER7035PosLtlbDppkDire.R_DIRE010000.getObject().getKey(),
                    "DIRE|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_DNFRA(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101140000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_DNFRA.getCode(),
                    ER7036PosLtlbDppkDnfra.R_DNFRA010000.getObject().getKey(),
                    "DNFRA|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_KOKB(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101150000.getObject().getKey(), "6", "10",
                    EFormLaporanBulananTahunan.LTLB_KOKB.getCode(),
                    ER7037PosLtlbDppkKokb.R_KOKB010000.getObject().getKey(),
                    "KOKB|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_REPO(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101160000.getObject().getKey(), "10", "17",
                    EFormLaporanBulananTahunan.LTLB_REPO.getCode(),
                    ER7038PosLtlbDppkRepo.R_REPO010000.getObject().getKey(),
                    "REPO|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PNYL(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101170000.getObject().getKey(), "11", "19",
                    EFormLaporanBulananTahunan.LTLB_PNYL.getCode(),
                    ER7039PosLtlbDppkPnyl.R_PNYL010000.getObject().getKey(),
                    "PNYL|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PPIN(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0103000000.getObject().getKey(), "3", "5",
                    EFormLaporanBulananTahunan.LTLB_PPIN.getCode(),
                    ER7060PosLtlbDppkPpin.R_PPIN010000.getObject().getKey(),
                    "PPIN|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),
    //
    SG_SUMIF_PROP(programs(PPIPM),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3")
                        + "$" + ER1250Properti.getPipedReferenceKeys(ER1250Properti.R_PR2);
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3")
                        + "$" + ER1250Properti.getPipedReferenceKeyValues(ER1250Properti.R_PR2);
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genMultiCriteriaSumIf(
                        "2", UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPIPM), 17, 20),
                        EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                        ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                        "8", "17|2", "2", criteriaCondition, sumCriteriaCondition,
                        "PROP|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Objek (Tanah/Bangunan/Tanah&Bangunan)",
                        criteriaConditionErr, sumCriteriaConditionErr, "0");
            }),

    SG_SUMIF_PIUT(programs(PPIPM),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genSumIf(
                        "2", UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPIPM), 24, 26),
                        EFormLaporanBulananTahunan.LTLB_PIUT.getCode(),
                        ER7042PosLtlbDppkPiut.R_PIUT010000.getObject().getKey(),
                        "5|8|9", "10", "2", criteriaCondition, sumCriteriaCondition,
                        "PIUT|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumCriteriaConditionErr,
                        "Piutang Iuran Peserta Total|Piutang Iuran Pemberi Kerja Total|Piutang Iuran Tambahan Total");
            }),
    //
    SG_SUMIF_ASLN(programs(PPIPM),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0108000000.getObject().getKey(), "5", "7",
                    EFormLaporanBulananTahunan.LTLB_ASLN.getCode(),
                    ER7053PosLtlbDppkAsln.R_ASLN010000.getObject().getKey(),
                    "ASLN|Nilai Aset|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_DPJKA_DPJKV(programs(PPIPM),
            () -> {
                String comparatorForms = EFormLaporanBulananTahunan.LTLB_DPJKA.getCode() + "|"
                        + EFormLaporanBulananTahunan.LTLB_DPJKV.getCode();
                String comparatorRows = ER7023PosLtlbDppkDpjka.R_DPJKA010000.getObject().getKey() + "|"
                        + ER7024PosLtlbDppkDpjkv.R_DPJKV010000.getObject().getKey();
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaCond = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                String sumConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genMultiFormSumIf(
                        "2", ER7003PosLtlbDppkNrc.R_NRC0101020000.getObject().getKey(),
                        comparatorForms, comparatorRows,
                        "6|6", "9|12", "2", criteriaCondition, sumCriteriaCond,
                        "DPJKA|DPJKV|Jumlah Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumConditionErr);
            }),

    SG_EQUALS_FORMULA_1(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("2",
                    ER7003PosLtlbDppkNrc.R_NRC0102000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPIPM), 0, 20),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0102000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPIPM), 0, 20)))),

    SG_EQUALS_FORMULA_2(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("2",
                    ER7003PosLtlbDppkNrc.R_NRC0105000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPIPM), 23, 31),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0105000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPIPM), 23, 31)))),

    SG_EQUALS_FORMULA_3(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("2",
                    ER7003PosLtlbDppkNrc.R_NRC0107000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(PPIPM), 33, 37) + "-NRC0106060000",
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0107000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(PPIPM), 33, 37) + "-'Akumulasi Penyusutan'"))),

    SG_EQUALS_FORMULA_5(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("2",
                    ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPIPM), new int[]{21, 22, 32, 39, 40}),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPIPM), new int[]{21, 22, 32, 39, 40})))),
    //
    SG_EQUALS_FORMULA_6(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("2",
                    ER7003PosLtlbDppkNrc.R_NRC0118000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPIPM), new int[]{42, 50}),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0118000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPIPM), new int[]{42, 50})))),
    //
    SG_FIELD_TOTAL_7(programs(PPIPM), () -> genTotalValidation(R_NRC0106010000.key,
            EFormLaporanBulananTahunan.LTLB_TNBG,
            ER7048PosLtlbDppkTnbg.getObjects(),
            "6", "Nilai Perolehan")),

    SG_FIELD_TOTAL_8(programs(PPIPM), () -> genTotalValidation(R_NRC0106020000.key,
            EFormLaporanBulananTahunan.LTLB_KNDR,
            ER7049PosLtlbDppkKndr.getObjects(),
            "5", "Nilai Perolahan")),

    SG_FIELD_TOTAL_9(programs(PPIPM), () -> genTotalValidation(R_NRC0106030000.key,
            EFormLaporanBulananTahunan.LTLB_PKOM,
            ER7050PosLtlbDppkPkom.getObjects(),
            "4", "Nilai Perolehan")),

    SG_FIELD_TOTAL_10(programs(PPIPM), () -> genTotalValidation(R_NRC0106040000.key,
            EFormLaporanBulananTahunan.LTLB_PKAN,
            ER7051PosLtlbDppkPkan.getObjects(),
            "4", "Nilai Perolehan")),

    SG_FIELD_TOTAL_11(programs(PPIPM), () -> genTotalValidation(R_NRC0106050000.key,
            EFormLaporanBulananTahunan.LTLB_ASOL,
            ER7052PosLtlbDppkAsol.getObjects(),
            "4", "Nilai Perolehan")),
    //
    SG_MULTI_SUM_NRC0106060000(programs(PPIPM), () -> {
        FormulaParserData operation = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(ER7048PosLtlbDppkTnbg.getObjects(), "1", "7", EFormLaporanBulananTahunan.LTLB_TNBG.getCode()),
                genFormulaParser(ER7049PosLtlbDppkKndr.getObjects(), "1", "6", EFormLaporanBulananTahunan.LTLB_KNDR.getCode()),
                genFormulaParser(ER7050PosLtlbDppkPkom.getObjects(), "1", "5", EFormLaporanBulananTahunan.LTLB_PKOM.getCode()),
                genFormulaParser(ER7051PosLtlbDppkPkan.getObjects(), "1", "5", EFormLaporanBulananTahunan.LTLB_PKAN.getCode()),
                genFormulaParser(ER7052PosLtlbDppkAsol.getObjects(), "1", "5", EFormLaporanBulananTahunan.LTLB_ASOL.getCode()),
        }, "+|+|+|+");

        String operationFormErr = "sama dengan Total Penjumlahan Kolom 'Akumulasi Penyusutan' pada form TNBG, KNDR, PKOM, PKAN, dan ASOL";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_NRC0106060000.key, operation.getFormula(), operationFormErr);
    }),

    SG_LIALIBILATAS_ALM(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        List<KeyValueString> formObject = ER7012PosLtlbDppkAlm.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "40", "16", "Total - Total", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " pada form ALM";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_NRC0113000000.key, operationForm, operationFormErr);
    }),

    GEN_VALIDATON_FORM_LAK(programs(PPIPM), () -> {
        KeyValueString selectPosCode = R_NRC0104010000.getObject();
        int[] cols = {2};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7005PosLtlbDppkLak.R_LAK0900000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("2", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm, errMsg, 2);
    }),

    //
    SG_EQUAL_TOTAL_LIABILITAS(programs(PPIPM), () -> {
        KeyValueString selectPosCode = R_NRC0109000000.getObject();
        int[] cols = {2};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_NERACA.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7003PosLtlbDppkNrc.R_NRC0118000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | " + comparatorPosCode.getValue();
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("2", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm, errMsg, 2);
    }),

    GEN_VALIDATON_FORM_UMPS(programs(PPIPM), () -> {
        KeyValueString selectPosCode = R_NRC0115020000.getObject();
        int[] cols = {4};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_UMPS.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7055PosLtlbDppkUmps.R_UMPS000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("2", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm, errMsg, 2);
    }),
    //
    SG_EQUALS_FORM_FORMULA_LAN_1(programs(PPIPM), () -> {
        String errMsg = UtilMetadata.genMessage(R_NRC0104010000.getObject().getValue(),
                ER7001PosLtlbDppkLan.R_LAN0103010000.getObject().getValue());

        return UtilSegmentValidationV2.genEqualsForm("2", R_NRC0104010000.getObject().getKey(),
                EFormLaporanBulananTahunan.LTLB_LAN.getCode(), "3",
                ER7001PosLtlbDppkLan.R_LAN0103010000.getObject().getKey(), errMsg + " pada form LAN");
    }),

    FV_MORE_THAN_ZERO(programs(PPIPM),
            validationFields(Dppk0003Nrc.MANFAAT_PENSIUN),
            () -> UtilFieldValidation.genPosGreaterValue(R_NRC0113000000.key, "0"));

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

    public static final BaseMetadataValidation<E7003NrcMValidationsConfig> VALIDATION_METADATA_PPIPM =
            new LbltMetadataValidation<>(E7003NrcMValidationsConfig.class, PPIPM);

    private static SegmentValidation sumIfValidationHelper(String posCode, String rangeField, String criteriaField, String formCode,
                                                           String formObjects, String errMsg) {
        String sumField = "2";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidationV2.genSumIf("2", posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }

    private static SegmentValidation genTotalValidation(String selectPosCode,
                                                        EFormLaporanBulananTahunan comparatorForm,
                                                        List<KeyValueString> formObject,
                                                        String comparatorFields, String fieldErrorMessage) {

        FormulaParserData operation2 = genFormulaParser(formObject,
                "1", /* 0 :: baris detail | 1 :: baris total
                                    kalo validasi lama ganti 1 biar langsung nembak ke baris total */
                comparatorFields, comparatorForm.getCode());

        String errMsg = "sama dengan 'Total' Kolom '" + fieldErrorMessage + "' pada Form " + comparatorForm.getCode();

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", selectPosCode, operation2.getFormula(),
                errMsg);
    }

    private static FormulaParserData multiFormulaFormatter(FormulaParserData[] formulas, String operand) {
        StringBuilder sbFormula = new StringBuilder();
        StringBuilder sbFormulaErr = new StringBuilder();
        String[] operands = StringUtils.split(operand, "|");

        if (formulas.length != operands.length + 1) throw new IllegalStateException();

        for (int i = 0; i < formulas.length; i++) {
            sbFormula.append(formulas[i].getFormula());
            sbFormulaErr.append("(").append(formulas[i].getErrMessage());
            if (i < formulas.length - 1) {
                sbFormula.append(operands[i]);
                sbFormulaErr.append(") ").append(operands[i]).append(" ");
            }
        }

        sbFormulaErr.append(")");

        return new FormulaParserData(sbFormula.toString(), sbFormulaErr.toString());
    }
}
