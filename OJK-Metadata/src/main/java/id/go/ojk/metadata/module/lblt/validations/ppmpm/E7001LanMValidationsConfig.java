package id.go.ojk.metadata.module.lblt.validations.ppmpm;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.UtilSegmentValidationV2;
import id.go.ojk.conf.client.dto.FormulaParserData;
import id.go.ojk.conf.client.field.reference.ER1250Properti;
import id.go.ojk.conf.client.field.reference.ER1255JenisManfaat;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.reference.*;
import id.go.ojk.metadata.util.FieldUtil;
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
import static id.go.ojk.metadata.module.lblt.reference.ER7001PosLtlbDppkLan.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7001LanMValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUMIF_LAN0101010000(programs(PPMPM),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0101010000.getObject().getKey(), "6", "9",
                    EFormLaporanBulananTahunan.LTLB_DOC.getCode(),
                    ER7022PosLtlbDppkDoc.R_DOC010000.getObject().getKey(),
                    "DOC|Nilai Nominal"
            )),

    SG_SUMIF_LAN0101020000(programs(PPMPM),
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
                        "3", ER7001PosLtlbDppkLan.R_LAN0101020000.getObject().getKey(),
                        comparatorForms, comparatorRows,
                        "6|6", "9|12", "3", criteriaCondition, sumCriteriaCond,
                        "DPJKA|DPJKV|Jumlah Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumConditionErr);
            }),

    SG_SUMIF_LAN0101040000(FieldUtil.programs(PPMPM),
            () -> sumIfValidationHelper(R_LAN0101040000.key,
                    "8", "11",
                    EFormLaporanBulananTahunan.LTLB_SBI.getCode(),
                    ER7026PosLtlbDppkSbi.R_SBI010000.getObject().getKey(),
                    "SBI|Nilai Wajar")),

    SG_SUMIF_LAN0101050000(FieldUtil.programs(PPMPM),
            () -> sumIfValidationHelper(R_LAN0101050000.key,
                    "8", "11",
                    EFormLaporanBulananTahunan.LTLB_RSBN.getCode(),
                    ER7027PosLtlbDppkRsbn.R_RSBN010000.getObject().getKey(),
                    "RSBN|Nilai Wajar")),

    SG_SUMIF_LAN0101060000(FieldUtil.programs(PPMPM),
            () -> sumIfValidationHelper(R_LAN0101060000.key,
                    "7", "11",
                    EFormLaporanBulananTahunan.LTLB_SHM.getCode(),
                    ER7028PosLtlbDppkShm.R_SHM010000.getObject().getKey(),
                    "SHM|Nilai Perolehan")),

    SG_SUMIF_LAN0101070000(FieldUtil.programs(PPMPM),
            () -> sumIfValidationHelper(R_LAN0101070000.key,
                    "12", "16",
                    EFormLaporanBulananTahunan.LTLB_OBLI.getCode(),
                    ER7029PosLtlbDppkObli.R_OBLI010000.getObject().getKey(),
                    "OBLI|Nilai Wajar")),

    SG_SUMIF_LAN0101080000(FieldUtil.programs(PPMPM),
            () -> sumIfValidationHelper(R_LAN0101080000.key,
                    "12", "16",
                    EFormLaporanBulananTahunan.LTLB_SUKUK.getCode(),
                    ER7030PosLtlbDppkSukuk.R_SUKUK010000.getObject().getKey(),
                    "SUKUK|Nilai Wajar")),

    SG_SUMIF_LAN0101090000(FieldUtil.programs(PPMPM),
            () -> sumIfValidationHelper(R_LAN0101090000.key,
                    "12", "16",
                    EFormLaporanBulananTahunan.LTLB_OBSUD.getCode(),
                    ER7031PosLtlbDppkObsud.R_OBSUD010000.getObject().getKey(),
                    "OBSUD|Nilai Wajar")),

    SG_SUMIF_LAN0101100000(FieldUtil.programs(PPMPM),
            () -> sumIfValidationHelper(R_LAN0101100000.key,
                    "9", "12",
                    EFormLaporanBulananTahunan.LTLB_RKSD.getCode(),
                    ER7032PosLtlbDppkRksd.R_RKSD010000.getObject().getKey(),
                    "RKSD|Nilai Wajar")),

    SG_SUMIF_LAN0101110000(FieldUtil.programs(PPMPM),
            () -> sumIfValidationHelper(R_LAN0101110000.key,
                    "12", "16",
                    EFormLaporanBulananTahunan.LTLB_MTN.getCode(),
                    ER7033PosLtlbDppkMtn.R_MTN010000.getObject().getKey(),
                    "MTN|Nilai Wajar")),

    SG_SUMIF_LAN0101120000(FieldUtil.programs(PPMPM),
            () -> sumIfValidationHelper(R_LAN0101120000.key,
                    "12", "16",
                    EFormLaporanBulananTahunan.LTLB_EBA.getCode(),
                    ER7034PosLtlbDppkEba.R_EBA010000.getObject().getKey(),
                    "EBA|Nilai Wajar")),

    SG_SUMIF_LAN0101130000(FieldUtil.programs(PPMPM),
            () -> sumIfValidationHelper(R_LAN0101130000.key,
                    "8", "11",
                    EFormLaporanBulananTahunan.LTLB_DIRE.getCode(),
                    ER7035PosLtlbDppkDire.R_DIRE010000.getObject().getKey(),
                    "DIRE|Nilai Wajar")),

    SG_SUMIF_LAN0101140000(FieldUtil.programs(PPMPM),
            () -> sumIfValidationHelper(R_LAN0101140000.key,
                    "8", "11",
                    EFormLaporanBulananTahunan.LTLB_DNFRA.getCode(),
                    ER7036PosLtlbDppkDnfra.R_DNFRA010000.getObject().getKey(),
                    "DNFRA|Nilai Aktifa Bersih")),

    SG_SUMIF_LAN0101150000(FieldUtil.programs(PPMPM),
            () -> sumIfValidationHelper(R_LAN0101150000.key,
                    "7", "10",
                    EFormLaporanBulananTahunan.LTLB_KOKB.getCode(),
                    ER7037PosLtlbDppkKokb.R_KOKB010000.getObject().getKey(),
                    "KOKB|Nilai Wajar")),

    SG_SUMIF_LAN0101160000(FieldUtil.programs(PPMPM),
            () -> sumIfValidationHelper(R_LAN0101160000.key,
                    "14", "17",
                    EFormLaporanBulananTahunan.LTLB_REPO.getCode(),
                    ER7038PosLtlbDppkRepo.R_REPO010000.getObject().getKey(),
                    "REPO|Nilai Jual")),

    SG_SUMIF_LAN0101170000(FieldUtil.programs(PPMPM),
            () -> sumIfValidationHelper(R_LAN0101170000.key,
                    "15", "19",
                    EFormLaporanBulananTahunan.LTLB_PNYL.getCode(),
                    ER7039PosLtlbDppkPnyl.R_PNYL010000.getObject().getKey(),
                    "PNYL|Nilai Apprasial/wajar - Total")),

    SG_SUMIF_PROP(programs(PPMPM),
            () -> {
                // For Validation Kode Pos LAN0101180000, LAN0101190000, and LAN0101200000
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3")
                        + "$" + ER1250Properti.getPipedReferenceKeys();
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3")
                        + "$" + ER1250Properti.getPipedReferenceKeyValues();
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

                return UtilSegmentValidationV2.genMultiCriteriaSumIf("3", UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), 17, 19),
                        EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                        ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(), "11", "17|2", "3",
                        criteriaCondition, sumCriteriaCondition, "PROP|Nilai Appraisal/ Nilai Wajar|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Objek (Tanah/Bangunan/Tanah&Bangunan)",
                        criteriaConditionErr, sumCriteriaConditionErr, "0");
            }),

    SG_SUMIF_PIUT(programs(PPMPM),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genSumIf(
                        "3", UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), 22, 24),
                        EFormLaporanBulananTahunan.LTLB_PIUT.getCode(),
                        ER7042PosLtlbDppkPiut.R_PIUT010000.getObject().getKey(),
                        "5|8|12", "13", "3", criteriaCondition, sumCriteriaCondition,
                        "PIUT|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumCriteriaConditionErr,
                        "Piutang Iuran Peserta - Total|Piutang Iuran Pemberi Kerja - Total|Piutang Iuran Sukarela Peserta");
            }),

    SG_SUMIF_LAN0103060000(FieldUtil.programs(PPMPM), () -> {
        String posCode = R_LAN0103060000.key;
        String rangeField = "3#4";
        String criteriaField = "6";
        String formCode = EFormLaporanBulananTahunan.LTLB_PIUB.getCode();
        String formObjects = ER7043PosLtlbDppkPiub.R_PIUB010000.getObject().getKey();
        String errMsg = "PIUB|Piutang Bunga Iuran Peserta dan Piutang Bunga Iuran Pemberi Kerja|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF";

        String sumField = "3";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidationV2.genSumIfMultiField("3", posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }),

    SG_SUMIF_LAN0101030000(FieldUtil.programs(PPMPM), () -> sumIfValidationHelper(
            R_LAN0101030000.key, "6", "9",
            EFormLaporanBulananTahunan.LTLB_SRDP.getCode(),
            ER7025PosLtlbDppkSrdp.R_SRDP010000.getObject().getKey(),
            "SRDP|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
    )),


    SG_SUMIF_LAN0103070000(programs(PPMPM),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0103070000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_BBMK.getCode(),
                    ER7044PosLtlbDppkBbmk.R_BBMK010000.getObject().getKey(),
                    "BBMK|Jumlah"
            )),

    SG_SUMIF_LAN0103080000(programs(PPMPM),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0103080000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PIUI.getCode(),
                    ER7045PosLtlbDppkPiui.R_PIUI010000.getObject().getKey(),
                    "PIUI|Nominal"
            )),

    SG_SUMIF_LAN0103090000(programs(PPMPM),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0103090000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PIHI.getCode(),
                    ER7046PosLtlbDppkPihi.R_PIHI010000.getObject().getKey(),
                    "PIHI|Nominal"
            )),

    SG_SUMIF_LAN0103100000(programs(PPMPM),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0103100000.getObject().getKey(), "4", "6",
                    EFormLaporanBulananTahunan.LTLB_PILL.getCode(),
                    ER7047PosLtlbDppkPill.R_PILL010000.getObject().getKey(),
                    "PILL|Nominal"
            )),

    SG_SUMIF_LAN0106000000(programs(PPMPM),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0106000000.getObject().getKey(), "5", "7",
                    EFormLaporanBulananTahunan.LTLB_ASLN.getCode(),
                    ER7053PosLtlbDppkAsln.R_ASLN010000.getObject().getKey(),
                    "ASLN|Nilai Aset"
            )),

    SG_SUMIF_LAN0108020100(programs(PPMPM),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0108020100.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_UMPJ.getCode(),
                    ER7054PosLtlbDppkUmpj.R_UMPJ010000.getObject().getKey(),
                    "UMPJ|Total - Jumlah"
            )),

    SG_SUMIF_LAN0108020300(programs(PPMPM),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0108020300.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_UTIN.getCode(),
                    ER7056PosLtlbDppkUtin.R_UTIN010000.getObject().getKey(),
                    "UTIN|Nilai"
            )),

    SG_SUMIF_LAN0108020400(programs(PPMPM),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0108020400.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PDDM.getCode(),
                    ER7057PosLtlbDppkPddm.R_PDDM010000.getObject().getKey(),
                    "PDDM|Nilai"
            )),

    SG_SUMIF_LAN0108020500(programs(PPMPM),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0108020500.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_BMHB.getCode(),
                    ER7058PosLtlbDppkBmhb.R_BMHB010000.getObject().getKey(),
                    "BMHB|Nilai"
            )),

    SG_SUMIF_LAN0108020600(programs(PPMPM),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0108020600.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_UTLN.getCode(),
                    ER7059PosLtlbDppkUtln.R_UTLN010000.getObject().getKey(),
                    "UTLN|Nilai"
            )),

    SG_EQUALS_FORMULA_PERSENTASE_INVESTASI(programs(PPMPM),
            () -> UtilSegmentValidation.genEqualsFormulaLan("2",
                    ER7001PosLtlbDppkLan.R_LAN0102000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), 0, 19),
                    UtilMetadata.genMessage(ER7001PosLtlbDppkLan.R_LAN0102000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), 0, 19)), 2)),

    SG_EQUALS_FORMULA_1(programs(PPMPM),
            () -> UtilSegmentValidation.genEqualsFormula("3",
                    ER7001PosLtlbDppkLan.R_LAN0102000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), 0, 19),
                    UtilMetadata.genMessage(ER7001PosLtlbDppkLan.R_LAN0102000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), 0, 19)))),

    SG_EQUALS_FORMULA_2(programs(PPMPM),
            () -> UtilSegmentValidation.genEqualsFormula("3",
                    ER7001PosLtlbDppkLan.R_LAN0104000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), 21, 29),
                    UtilMetadata.genMessage(ER7001PosLtlbDppkLan.R_LAN0104000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), 21, 29)))),

    SG_EQUALS_FORMULA_3(programs(PPMPM),
            () -> UtilSegmentValidation.genEqualsFormula("3",
                    ER7001PosLtlbDppkLan.R_LAN0107000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), new int[]{20, 30, 36, 37}),
                    UtilMetadata.genMessage(ER7001PosLtlbDppkLan.R_LAN0107000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), new int[]{20, 30, 36, 37})))),

    SG_EQUALS_FORMULA_4(programs(PPMPM),
            () -> UtilSegmentValidation.genEqualsFormula("3",
                    ER7001PosLtlbDppkLan.R_LAN0111000000.getObject().getKey(),
                    UtilMetadata.genMinusRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), new int[]{38, 47}),
                    UtilMetadata.genMessage(ER7001PosLtlbDppkLan.R_LAN0111000000.getObject().getValue(),
                            UtilMetadata.genMinusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPM), new int[]{38, 47})))),

    SG_EQUALS_FORMULA_5(programs(PPMPM),
            () -> UtilSegmentValidation.genEqualsFormula("3",
                    ER7001PosLtlbDppkLan.R_LAN0109000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), 39, 45),
                    UtilMetadata.genMessage(ER7001PosLtlbDppkLan.R_LAN0109000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), 39, 45)))),

    SG_EQUALS_FORMULA_6(programs(PPMPM),
            () -> UtilSegmentValidation.genEqualsFormula("3",
                    ER7001PosLtlbDppkLan.R_LAN0110000000.getObject().getKey(), R_LAN0109000000.key,
                    UtilMetadata.genMessage(R_LAN0110000000.value, R_LAN0109000000.value))),

    SG_EQUALS_FORMULA_7(programs(PPMPM),
            () -> UtilSegmentValidation.genEqualsFormula("3",
                    ER7001PosLtlbDppkLan.R_LAN0105000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), 31, 35),
                    UtilMetadata.genMessage(ER7001PosLtlbDppkLan.R_LAN0105000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), 31, 35)))),

    SG_PERSENTASE_INVESTASI(programs(PPMPM),
            () -> UtilSegmentValidation.genEqualsRatioLan(
                    "2", UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), 0, 19),
                    UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), 0, 19), "3", R_LAN0102000000.key, "3",
                    "TOTAL INVESTASI", 2)),

    /* Update Pak Yahya */

    GEN_VALIDATON_FORM_NRC1(programs(PPMPM), () -> {
        int[] comparatorRows = {21, 22};
        String comparatorField = UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(PPMPM), comparatorRows);
        String plusDesc = UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(PPMPM), comparatorRows);
        String errMsg = UtilMetadata.genMessage(R_LAN0102000000.value, plusDesc + " pada form " + EFormLaporanBulananTahunan.LTLB_NERACA.getCode());
        return UtilSegmentValidationV2.genEqualsFormulaFormV2("3", R_LAN0102000000.key,
                EFormLaporanBulananTahunan.LTLB_NERACA.getCode(), "2", comparatorField, errMsg, 2);
    }),
    //
    GEN_VALIDATON_FORM_INSP(programs(PPMPM), () -> {
        KeyValueString selectPosCode = R_LAN0102000000.getObject();
        int[] cols = {4};
        String form = EFormLaporanBulananTahunan.LTLB_INSP.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorPosCode = ER7013PosLtlbDppkInsp.R_INSP000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Jumlah Investasi pada form " + form;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("3", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, form, errMsg, 2);
    }),

    SG_PERIODE_BERJALAN_REKINV(programs(PPMPM), () -> {
        String selectField = "3";
        String selectPosCode = R_LAN0102000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_REKINV.getCode();

        List<KeyValueString> formObject = ER7008PosLtlbDppkRekinv.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "20", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + "pada form REKINV sesuai dengan Periode Bulan Laporan Berjalan ({})";

        return UtilSegmentValidationV2.genFormulaParserlRekinvPeriodePelaporan(selectField, selectPosCode, operationForm, operationFormErr, 2);
    }),

    GEN_VALIDATON_FORM_LAK(programs(PPMPM), () -> {
        KeyValueString selectPosCode = R_LAN0103010000.getObject();
        int[] cols = {2};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7005PosLtlbDppkLak.R_LAK0900000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("3", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm, errMsg, 2);
    }),

    GEN_VALIDATON_FORM_TNBG(programs(PPMPM), () -> {
        KeyValueString selectPosCode = R_LAN0104020000.getObject();
        int[] cols = {8};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_TNBG.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorPosCode = ER7048PosLtlbDppkTnbg.R_TNBG000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("3", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, comparatorForm, errMsg, 2);
    }),

    GEN_VALIDATON_FORM_KNDR(programs(PPMPM), () -> {
        KeyValueString selectPosCode = R_LAN0104030000.getObject();
        int[] cols = {7};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_KNDR.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorPosCode = ER7049PosLtlbDppkKndr.R_KNDR000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("3", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, comparatorForm, errMsg, 2);
    }),

    GEN_VALIDATON_FORM_PKOM(programs(PPMPM), () -> {
        KeyValueString selectPosCode = R_LAN0104040000.getObject();
        int[] cols = {6};
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_PKOM.getCode();
        String comparatorPosCode = ER7050PosLtlbDppkPkom.R_PKOM000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("3", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, comparatorForm, errMsg, 2);
    }),

    GEN_VALIDATON_FORM_PKAN(programs(PPMPM), () -> {
        KeyValueString selectPosCode = R_LAN0104050000.getObject();
        int[] cols = {6};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_PKAN.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorPosCode = ER7051PosLtlbDppkPkan.R_PKAN000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("3", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, comparatorForm, errMsg, 2);
    }),

    GEN_VALIDATON_FORM_ASOL(programs(PPMPM), () -> {
        KeyValueString selectPosCode = R_LAN0104060000.getObject();
        int[] cols = {6};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ASOL.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorPosCode = ER7052PosLtlbDppkAsol.R_ASOL000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("3", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, comparatorForm, errMsg, 2);
    }),
    //
    GEN_VALIDATON_FORM_NRC2(programs(PPMPM), () -> {
        KeyValueString selectPosCode = R_LAN0107000000.getObject();
        int[] cols = {2};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_NERACA.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("3", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm, errMsg, 2);
    }),
    //
    GEN_VALIDATON_FORM_UMPS(programs(PPMPM), () -> {
        KeyValueString selectPosCode = R_LAN0108020200.getObject();
        int[] cols = {4};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_UMPS.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7055PosLtlbDppkUmps.R_UMPS000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("3", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm, errMsg, 2);
    }),

    GEN_VALIDATON_FORM_LPAN(programs(PPMPM), () -> {
        KeyValueString selectPosCode = R_LAN0111000000.getObject();
        int[] cols = {2};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7002PosLtlbDppkLpan.R_LPAN0500000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("3", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm, errMsg, 2);
    }),

    SG_ROW_DATA_TYPE_NUMERIC_DOT(programs(PPMPM), () ->
            UtilSegmentValidation.genRegexNumericDot("2",
                    UtilMetadata.genPipeRow(getObjects(PPMPM), 0, 20))),

    SG_ROW_DATA_TYPE_NUMERIC(programs(PPMPM), () ->
            UtilSegmentValidation.genRegexNumeric("3",
                    UtilMetadata.genPipeRow(getObjects(PPMPM), 0, 47))),

    SG_ROW_DATA_TYPE_NUMERIC_NEGATIVE(programs(PPMPM), () ->
            UtilSegmentValidation.genRegexNumericNegative("3",
                    UtilMetadata.genPipeRow(getObjects(PPMPM), new int[]{48}))),


    CR_EXIST_POS_N_PERSENTASE_INVESTASI(programs(PPMPM), validationFields(2),
            () -> UtilFieldConditional.genExistPos("N", "M",
                    UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM), 21, 48))),

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

    public static final BaseMetadataValidation<E7001LanMValidationsConfig> VALIDATION_METADATA_PPMPM =
            new LbltMetadataValidation<>(E7001LanMValidationsConfig.class, PPMPM);

    private static SegmentValidation sumIfValidationHelper(String posCode, String rangeField, String criteriaField, String formCode,
                                                           String formObjects, String errMsg) {
        String sumField = "3";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidationV2.genSumIf("3", posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                errMsg + "|" + "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain", criteriaConditionErr, sumCriteriaConditionErr);
    }

    private static SegmentValidation sumIfSpecFieldHelper(String posCode, String rangeField, String criteriaField, String specField,
                                                          String formCode, String formObjects, String errMsg) {
        String sumField = "3";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
        String specCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL2|MPL3|ML2|ML3|ML4|ML5|ML6");

        return UtilSegmentValidationV2.genSumIfSpecField(UtilMetadata.genPipeColumn(3, 12), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, specField, specCondition, criteriaCondition, sumCriteriaCondition,
                errMsg + "|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF", criteriaConditionErr, sumCriteriaConditionErr);
    }
}
