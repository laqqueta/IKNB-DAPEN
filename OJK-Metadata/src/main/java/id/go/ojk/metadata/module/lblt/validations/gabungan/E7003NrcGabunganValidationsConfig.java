package id.go.ojk.metadata.module.lblt.validations.gabungan;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.*;
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

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;

import static id.go.ojk.conf.client.UtilMetadata.genFormulaParser;
import static id.go.ojk.metadata.module.lblt.reference.ER7003PosLtlbDppkNrc.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPPPIPK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7003NrcGabunganValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUMIF_DOC_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0101010000.getObject().getKey(), "7", "10",
                    EFormLaporanBulananTahunan.LTLB_DOC.getCode(),
                    ER7022PosLtlbDppkDoc.R_DOC010000.getObject().getKey(),
                    "DOC|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_DPJKA_DPJKV_PPMP(programs(PPMPPPIPK),
            () -> {
                String comparatorForms = EFormLaporanBulananTahunan.LTLB_DPJKA.getCode() + "|"
                        + EFormLaporanBulananTahunan.LTLB_DPJKV.getCode();
                String comparatorRows = ER7023PosLtlbDppkDpjka.R_DPJKA010000.getObject().getKey() + "|"
                        + ER7024PosLtlbDppkDpjkv.R_DPJKV010000.getObject().getKey();
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
                String sumCriteriaCond = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
                String sumConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genMultiFormSumIf(
                        UtilMetadata.genPipeColumn(3, 12), ER7003PosLtlbDppkNrc.R_NRC0101020000.getObject().getKey(),
                        comparatorForms, comparatorRows,
                        "7|7", "10|11", "3", criteriaCondition, sumCriteriaCond,
                        "2", "PPMP",
                        "DPJKA|DPJKV|Jumlah Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumConditionErr);
            }),

    SG_SUMIF_SRDP_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0101030000.getObject().getKey(), "7", "10",
                    EFormLaporanBulananTahunan.LTLB_SRDP.getCode(),
                    ER7025PosLtlbDppkSrdp.R_SRDP010000.getObject().getKey(),
                    "SRDP|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SBI_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0101040000.getObject().getKey(), "8", "12",
                    EFormLaporanBulananTahunan.LTLB_SBI.getCode(),
                    ER7026PosLtlbDppkSbi.R_SBI010000.getObject().getKey(),
                    "SBI|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_RSBN_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0101050000.getObject().getKey(), "8", "12",
                    EFormLaporanBulananTahunan.LTLB_RSBN.getCode(),
                    ER7027PosLtlbDppkRsbn.R_RSBN010000.getObject().getKey(),
                    "RSBN|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SHM_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0101060000.getObject().getKey(), "7", "12",
                    EFormLaporanBulananTahunan.LTLB_SHM.getCode(),
                    ER7028PosLtlbDppkShm.R_SHM010000.getObject().getKey(),
                    "SHM|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_OBLI_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0101070000.getObject().getKey(), "12", "17",
                    EFormLaporanBulananTahunan.LTLB_OBLI.getCode(),
                    ER7029PosLtlbDppkObli.R_OBLI010000.getObject().getKey(),
                    "OBLI|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_SUKUK_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0101080000.getObject().getKey(), "12", "17",
                    EFormLaporanBulananTahunan.LTLB_SUKUK.getCode(),
                    ER7030PosLtlbDppkSukuk.R_SUKUK010000.getObject().getKey(),
                    "SUKUK|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_OBSUD_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0101090000.getObject().getKey(), "12", "17",
                    EFormLaporanBulananTahunan.LTLB_OBSUD.getCode(),
                    ER7031PosLtlbDppkObsud.R_OBSUD010000.getObject().getKey(),
                    "OBSUD|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_RKSD_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0101100000.getObject().getKey(), "9", "13",
                    EFormLaporanBulananTahunan.LTLB_RKSD.getCode(),
                    ER7032PosLtlbDppkRksd.R_RKSD010000.getObject().getKey(),
                    "RKSD|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_MTN_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0101110000.getObject().getKey(), "12", "17",
                    EFormLaporanBulananTahunan.LTLB_MTN.getCode(),
                    ER7033PosLtlbDppkMtn.R_MTN010000.getObject().getKey(),
                    "MTN|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_EBA_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0101120000.getObject().getKey(), "12", "17",
                    EFormLaporanBulananTahunan.LTLB_EBA.getCode(),
                    ER7034PosLtlbDppkEba.R_EBA010000.getObject().getKey(),
                    "EBA|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_DIRE_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0101130000.getObject().getKey(), "8", "12",
                    EFormLaporanBulananTahunan.LTLB_DIRE.getCode(),
                    ER7035PosLtlbDppkDire.R_DIRE010000.getObject().getKey(),
                    "DIRE|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_DNFRA_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0101140000.getObject().getKey(), "8", "12",
                    EFormLaporanBulananTahunan.LTLB_DNFRA.getCode(),
                    ER7036PosLtlbDppkDnfra.R_DNFRA010000.getObject().getKey(),
                    "DNFRA|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_KOKB_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0101150000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_KOKB.getCode(),
                    ER7037PosLtlbDppkKokb.R_KOKB010000.getObject().getKey(),
                    "KOKB|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_REPO_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0101160000.getObject().getKey(), "11", "18",
                    EFormLaporanBulananTahunan.LTLB_REPO.getCode(),
                    ER7038PosLtlbDppkRepo.R_REPO010000.getObject().getKey(),
                    "REPO|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PNYL_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0101170000.getObject().getKey(), "12", "20",
                    EFormLaporanBulananTahunan.LTLB_PNYL.getCode(),
                    ER7039PosLtlbDppkPnyl.R_PNYL010000.getObject().getKey(),
                    "PNYL|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PROP_1_PPMP(programs(PPMPPPIPK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                        + "$" + ER1250Properti.getPipedReferenceKeys();
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                        + "$" + ER1250Properti.getPipedReferenceKeyValues();
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genMultiCriteriaSumIf(
                        UtilMetadata.genPipeColumn(3, 12), UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), 17, 19),
                        EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                        ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                        "9", "18|3", "3", criteriaCondition, sumCriteriaCondition,
                        "2", "PPMP",
                        "PROP|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Objek (Tanah/Bangunan/Tanah dan Bangunan)",
                        criteriaConditionErr, sumCriteriaConditionErr, "0");
            }),

    SG_SUMIF_PROP_2_PPMP(programs(PPMPPPIPK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                        + "$" + ER1250Properti.getKey("2005") + "|" + ER1250Properti.getKey("2010");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                        + "$" + ER1250Properti.getKeyValue("2005") + "|" + ER1250Properti.getKeyValue("2010");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genMultiCriteriaSumIf2(
                        UtilMetadata.genPipeColumn(3, 12), R_NRC0101210000.key,
                        EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                        ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                        "10", "18|3", "3", criteriaCondition, sumCriteriaCondition,
                        "2", "PPMP",
                        "PROP|Akumulasi Penyusutan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Objek (Tanah/Bangunan/Tanah dan Bangunan)",
                        criteriaConditionErr, sumCriteriaConditionErr, "0");
            }),

    SG_SUMIF_PPIN_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0103000000.getObject().getKey(), "4", "6",
                    EFormLaporanBulananTahunan.LTLB_PPIN.getCode(),
                    ER7060PosLtlbDppkPpin.R_PPIN010000.getObject().getKey(),
                    "PPIN|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PIUT_PPMP(programs(PPMPPPIPK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genSumIfFilter(
                        UtilMetadata.genPipeColumn(3, 12), UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), 24, 27),
                        EFormLaporanBulananTahunan.LTLB_PIUT.getCode(),
                        ER7042PosLtlbDppkPiut.R_PIUT010000.getObject().getKey(),
                        "6|9|13|12", "14", "3", criteriaCondition, sumCriteriaCondition,
                        "2", "PPMP",
                        "PIUT|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumCriteriaConditionErr,
                        "Piutang Iuran Peserta Total|Piutang Iuran Pemberi Kerja Total|Piutang Iuran Sukarela Peserta|Piutang Iuran Tambahan Total");
            }),

    SG_SUMIF_PIUB_PPMP(programs(PPMPPPIPK), () -> {
        String posCode = R_NRC0104030000_TMP_GABUNGAN.key;
        String rangeField = "4#5";
        String criteriaField = "6";
        String formCode = EFormLaporanBulananTahunan.LTLB_PIUB.getCode();
        String formObjects = ER7043PosLtlbDppkPiub.R_PIUB010000.getObject().getKey();
        String errMsg = "PIUB|Piutang Bunga Iuran Peserta dan Piutang Bunga Iuran Pemberi Kerja|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF";

        String sumField = "3";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidationV2.genSumIfMultiField(UtilMetadata.genPipeColumn(3, 12), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                "2", "PPMP",
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }),

    SG_SUMIF_BBMK_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0104040000_TMP_GABUNGAN.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_BBMK.getCode(),
                    ER7044PosLtlbDppkBbmk.R_BBMK010000.getObject().getKey(),
                    "BBMK|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PIUI_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0104050000_TMP_GABUNGAN.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_PIUI.getCode(),
                    ER7045PosLtlbDppkPiui.R_PIUI010000.getObject().getKey(),
                    "PIUI|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PIHI_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0104060000_TMP_GABUNGAN.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_PIHI.getCode(),
                    ER7046PosLtlbDppkPihi.R_PIHI010000.getObject().getKey(),
                    "PIHI|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PILL_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0104070000_TMP_GABUNGAN.getObject().getKey(), "5", "7",
                    EFormLaporanBulananTahunan.LTLB_PILL.getCode(),
                    ER7047PosLtlbDppkPill.R_PILL010000.getObject().getKey(),
                    "PILL|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_ASLN_PPMP(programs(PPMPPPIPK),
            () -> {
                String sumField = "3";
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

                return UtilSegmentValidationV2.genSumIfFilter(UtilMetadata.genPipeColumn(3, 12),
                        ER7003PosLtlbDppkNrc.R_NRC0108000000.getObject().getKey(),
                        EFormLaporanBulananTahunan.LTLB_ASLN.getCode(),
                        ER7053PosLtlbDppkAsln.R_ASLN010000.getObject().getKey(),
                        "6", "8", sumField, criteriaCondition, sumCriteriaCondition,
                        "2", "PPMP",
                        "ASLN|Nilai Aset|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain", criteriaConditionErr, sumCriteriaConditionErr);
            }),

    SG_SUMIF_UMPJ_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0115010000.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_UMPJ.getCode(),
                    ER7054PosLtlbDppkUmpj.R_UMPJ010000.getObject().getKey(),
                    "UMPJ|Jumlah - Total|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_UTIN_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0115030000.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_UTIN.getCode(),
                    ER7056PosLtlbDppkUtin.R_UTIN010000.getObject().getKey(),
                    "UTIN|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PDDM_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0115040000.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_PDDM.getCode(),
                    ER7057PosLtlbDppkPddm.R_PDDM010000.getObject().getKey(),
                    "PDDM|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_BMHB_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0115050000.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_BMHB.getCode(),
                    ER7058PosLtlbDppkBmhb.R_BMHB010000.getObject().getKey(),
                    "BMHB|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_UTLN_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPMP(
                    ER7003PosLtlbDppkNrc.R_NRC0115060000.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_UTLN.getCode(),
                    ER7059PosLtlbDppkUtln.R_UTLN010000.getObject().getKey(),
                    "UTLN|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),


    SG_EQUALS_FORMULA_1_PPMP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0102000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(PPMPPPIPK), 0, 19) + "-NRC0101210000",
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0102000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(PPMPPPIPK), 0, 19) + "-'Akumulasi Penyusutan Bangunan'"))),

    SG_EQUALS_FORMULA_2_PPMP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0105000000_TMP_GABUNGAN.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), 23, 31),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0105000000_TMP_GABUNGAN.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), 23, 31)))),

    SG_EQUALS_FORMULA_3_PPMP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0107000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), 33, 37) + "-NRC0106060000",
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0107000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), 33, 37) + "-'Akumulasi Penyusutan'"))),

    SG_EQUALS_FORMULA_5_PPMP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), new int[]{21, 22, 32, 39, 40}),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), new int[]{21, 22, 32, 39, 40})))),

    SG_EQUALS_FORMULA_6_PPMP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0118000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), new int[]{42, 50}),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0118000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), new int[]{42, 50})))),

    SG_EQUALS_FORMULA_7_PPMP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0117000000_TMP_GABUNGAN.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), 43, 49),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0117000000_TMP_GABUNGAN.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), 43, 49)))),

    SG_FIELD_TOTAL_7_PPMP(programs(PPMPPPIPK), () -> genTotalValidationPPMP(R_NRC0106010000.key,
            EFormLaporanBulananTahunan.LTLB_TNBG,
            ER7048PosLtlbDppkTnbg.getObjects(),
            "10", "Nilai Perolehan Pada Tanggal Laporan")),

    SG_FIELD_TOTAL_8_PPMP(programs(PPMPPPIPK), () -> genTotalValidationPPMP(R_NRC0106020000.key,
            EFormLaporanBulananTahunan.LTLB_KNDR,
            ER7049PosLtlbDppkKndr.getObjects(),
            "6", "Nilai Perolahan")),

    SG_FIELD_TOTAL_9_PPMP(programs(PPMPPPIPK), () -> genTotalValidationPPMP(R_NRC0106030000.key,
            EFormLaporanBulananTahunan.LTLB_PKOM,
            ER7050PosLtlbDppkPkom.getObjects(),
            "5", "Nilai Perolehan")),

    SG_FIELD_TOTAL_10_PPMP(programs(PPMPPPIPK), () -> genTotalValidationPPMP(R_NRC0106040000.key,
            EFormLaporanBulananTahunan.LTLB_PKAN,
            ER7051PosLtlbDppkPkan.getObjects(),
            "5", "Nilai Perolehan")),

    SG_FIELD_TOTAL_11_PPMP(programs(PPMPPPIPK), () -> genTotalValidationPPMP(R_NRC0106050000.key,
            EFormLaporanBulananTahunan.LTLB_ASOL,
            ER7052PosLtlbDppkAsol.getObjects(),
            "5", "Nilai Perolehan")),

    SG_MULTI_SUM_NRC0106060000_PPMP(programs(PPMPPPIPK), () -> {
        FormulaParserData operation = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(ER7048PosLtlbDppkTnbg.getObjects(), "1", "8", EFormLaporanBulananTahunan.LTLB_TNBG.getCode()),
                genFormulaParser(ER7049PosLtlbDppkKndr.getObjects(), "1", "7", EFormLaporanBulananTahunan.LTLB_KNDR.getCode()),
                genFormulaParser(ER7050PosLtlbDppkPkom.getObjects(), "1", "6", EFormLaporanBulananTahunan.LTLB_PKOM.getCode()),
                genFormulaParser(ER7051PosLtlbDppkPkan.getObjects(), "1", "6", EFormLaporanBulananTahunan.LTLB_PKAN.getCode()),
                genFormulaParser(ER7052PosLtlbDppkAsol.getObjects(), "1", "6", EFormLaporanBulananTahunan.LTLB_ASOL.getCode()),
        }, "+|+|+|+");

        String operationFormErr = "sama dengan Total Penjumlahan Kolom 'Akumulasi Penyusutan' pada form TNBG, KNDR, PKOM, PKAN, dan ASOL";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("13", R_NRC0106060000.key, operation.getFormula(),
                "2", "PPMP",
                operationFormErr, 2);
    }),

    GEN_VALIDATON_FORM_LAK_PPMP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_NRC0104010000.getObject();
        int[] cols = {13};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7005PosLtlbDppkLak.R_LAK0900000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("13", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm,
                "2", "PPMP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_UMPS_PPMP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_NRC0115020000.getObject();
        int[] cols = {5};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_UMPS.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7055PosLtlbDppkUmps.R_UMPS000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("13", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm,
                "2", "PPMP",
                errMsg, 2);
    }),

    // PPIP VALIDATIONS

    SG_SUMIF_DOC_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0101010000.getObject().getKey(), "7", "10",
                    EFormLaporanBulananTahunan.LTLB_DOC.getCode(),
                    ER7022PosLtlbDppkDoc.R_DOC010000.getObject().getKey(),
                    "DOC|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_DPJKA_DPJKV_PPIP(programs(PPMPPPIPK),
            () -> {
                String comparatorForms = EFormLaporanBulananTahunan.LTLB_DPJKA.getCode() + "|"
                        + EFormLaporanBulananTahunan.LTLB_DPJKV.getCode();
                String comparatorRows = ER7023PosLtlbDppkDpjka.R_DPJKA010000.getObject().getKey() + "|"
                        + ER7024PosLtlbDppkDpjkv.R_DPJKV010000.getObject().getKey();
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
                String sumCriteriaCond = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
                String sumConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genMultiFormSumIf(
                        UtilMetadata.genPipeColumnExcept(3, 16, new int[]{13}), ER7003PosLtlbDppkNrc.R_NRC0101020000.getObject().getKey(),
                        comparatorForms, comparatorRows,
                        "7|7", "10|11", "3", criteriaCondition, sumCriteriaCond,
                        "2", "PPIP",
                        "DPJKA|DPJKV|Jumlah Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumConditionErr);
            }),

    SG_SUMIF_SRDP_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0101030000.getObject().getKey(), "7", "10",
                    EFormLaporanBulananTahunan.LTLB_SRDP.getCode(),
                    ER7025PosLtlbDppkSrdp.R_SRDP010000.getObject().getKey(),
                    "SRDP|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SBI_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0101040000.getObject().getKey(), "8", "12",
                    EFormLaporanBulananTahunan.LTLB_SBI.getCode(),
                    ER7026PosLtlbDppkSbi.R_SBI010000.getObject().getKey(),
                    "SBI|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_RSBN_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0101050000.getObject().getKey(), "8", "12",
                    EFormLaporanBulananTahunan.LTLB_RSBN.getCode(),
                    ER7027PosLtlbDppkRsbn.R_RSBN010000.getObject().getKey(),
                    "RSBN|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SHM_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0101060000.getObject().getKey(), "7", "12",
                    EFormLaporanBulananTahunan.LTLB_SHM.getCode(),
                    ER7028PosLtlbDppkShm.R_SHM010000.getObject().getKey(),
                    "SHM|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_OBLI_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0101070000.getObject().getKey(), "12", "17",
                    EFormLaporanBulananTahunan.LTLB_OBLI.getCode(),
                    ER7029PosLtlbDppkObli.R_OBLI010000.getObject().getKey(),
                    "OBLI|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_SUKUK_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0101080000.getObject().getKey(), "12", "17",
                    EFormLaporanBulananTahunan.LTLB_SUKUK.getCode(),
                    ER7030PosLtlbDppkSukuk.R_SUKUK010000.getObject().getKey(),
                    "SUKUK|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_OBSUD_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0101090000.getObject().getKey(), "12", "17",
                    EFormLaporanBulananTahunan.LTLB_OBSUD.getCode(),
                    ER7031PosLtlbDppkObsud.R_OBSUD010000.getObject().getKey(),
                    "OBSUD|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_RKSD_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0101100000.getObject().getKey(), "9", "13",
                    EFormLaporanBulananTahunan.LTLB_RKSD.getCode(),
                    ER7032PosLtlbDppkRksd.R_RKSD010000.getObject().getKey(),
                    "RKSD|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_MTN_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0101110000.getObject().getKey(), "12", "17",
                    EFormLaporanBulananTahunan.LTLB_MTN.getCode(),
                    ER7033PosLtlbDppkMtn.R_MTN010000.getObject().getKey(),
                    "MTN|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_EBA_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0101120000.getObject().getKey(), "12", "17",
                    EFormLaporanBulananTahunan.LTLB_EBA.getCode(),
                    ER7034PosLtlbDppkEba.R_EBA010000.getObject().getKey(),
                    "EBA|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_DIRE_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0101130000.getObject().getKey(), "8", "12",
                    EFormLaporanBulananTahunan.LTLB_DIRE.getCode(),
                    ER7035PosLtlbDppkDire.R_DIRE010000.getObject().getKey(),
                    "DIRE|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_DNFRA_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0101140000.getObject().getKey(), "8", "12",
                    EFormLaporanBulananTahunan.LTLB_DNFRA.getCode(),
                    ER7036PosLtlbDppkDnfra.R_DNFRA010000.getObject().getKey(),
                    "DNFRA|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_KOKB_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0101150000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_KOKB.getCode(),
                    ER7037PosLtlbDppkKokb.R_KOKB010000.getObject().getKey(),
                    "KOKB|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_REPO_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0101160000.getObject().getKey(), "11", "18",
                    EFormLaporanBulananTahunan.LTLB_REPO.getCode(),
                    ER7038PosLtlbDppkRepo.R_REPO010000.getObject().getKey(),
                    "REPO|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PNYL_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0101170000.getObject().getKey(), "12", "20",
                    EFormLaporanBulananTahunan.LTLB_PNYL.getCode(),
                    ER7039PosLtlbDppkPnyl.R_PNYL010000.getObject().getKey(),
                    "PNYL|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PROP_1_PPIP(programs(PPMPPPIPK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3")
                        + "$" + ER1250Properti.getPipedReferenceKeys();
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3")
                        + "$" + ER1250Properti.getPipedReferenceKeyValues();
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genMultiCriteriaSumIf(
                        UtilMetadata.genPipeColumnExcept(3, 16, new int[]{13}), UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), 17, 19),
                        EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                        ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                        "9", "18|3", "3", criteriaCondition, sumCriteriaCondition,
                        "2", "PPIP",
                        "PROP|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Objek (Tanah/Bangunan/Tanah dan Bangunan)",
                        criteriaConditionErr, sumCriteriaConditionErr, "0");
            }),

    SG_SUMIF_PROP_2_PPIP(programs(PPMPPPIPK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3")
                        + "$" + ER1250Properti.getKey("2005") + "|" + ER1250Properti.getKey("2010");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3")
                        + "$" + ER1250Properti.getKeyValue("2005") + "|" + ER1250Properti.getKeyValue("2010");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genMultiCriteriaSumIf2(
                        UtilMetadata.genPipeColumnExcept(3, 16, new int[]{13}), R_NRC0101210000.key,
                        EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                        ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                        "10", "18|3", "3", criteriaCondition, sumCriteriaCondition,
                        "2", "PPIP",
                        "PROP|Akumulasi Penyusutan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Objek (Tanah/Bangunan/Tanah dan Bangunan)",
                        criteriaConditionErr, sumCriteriaConditionErr, "0");
            }),

    SG_SUMIF_PPIN_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0103000000.getObject().getKey(), "4", "6",
                    EFormLaporanBulananTahunan.LTLB_PPIN.getCode(),
                    ER7060PosLtlbDppkPpin.R_PPIN010000.getObject().getKey(),
                    "PPIN|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PIUT_PPIP(programs(PPMPPPIPK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genSumIfFilter(
                        UtilMetadata.genPipeColumnExcept(3, 16, new int[]{13}), UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), 24, 27),
                        EFormLaporanBulananTahunan.LTLB_PIUT.getCode(),
                        ER7042PosLtlbDppkPiut.R_PIUT010000.getObject().getKey(),
                        "6|9|13|12", "14", "3", criteriaCondition, sumCriteriaCondition,
                        "2", "PPIP",
                        "PIUT|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumCriteriaConditionErr,
                        "Piutang Iuran Peserta Total|Piutang Iuran Pemberi Kerja Total|Piutang Iuran Sukarela Peserta|Piutang Iuran Tambahan Total");
            }),

    SG_SUMIF_PIUB_PPIP(programs(PPMPPPIPK), () -> {
        String posCode = R_NRC0104030000_TMP_GABUNGAN.key;
        String rangeField = "4#5";
        String criteriaField = "6";
        String formCode = EFormLaporanBulananTahunan.LTLB_PIUB.getCode();
        String formObjects = ER7043PosLtlbDppkPiub.R_PIUB010000.getObject().getKey();
        String errMsg = "PIUB|Piutang Bunga Iuran Peserta dan Piutang Bunga Iuran Pemberi Kerja|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF";

        String sumField = "3";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidationV2.genSumIfMultiField(UtilMetadata.genPipeColumnExcept(3, 16, new int[]{13}), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                "2", "PPIP",
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }),

    SG_SUMIF_BBMK_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0104040000_TMP_GABUNGAN.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_BBMK.getCode(),
                    ER7044PosLtlbDppkBbmk.R_BBMK010000.getObject().getKey(),
                    "BBMK|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PIUI_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0104050000_TMP_GABUNGAN.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_PIUI.getCode(),
                    ER7045PosLtlbDppkPiui.R_PIUI010000.getObject().getKey(),
                    "PIUI|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PIHI_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0104060000_TMP_GABUNGAN.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_PIHI.getCode(),
                    ER7046PosLtlbDppkPihi.R_PIHI010000.getObject().getKey(),
                    "PIHI|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PILL_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0104070000_TMP_GABUNGAN.getObject().getKey(), "5", "7",
                    EFormLaporanBulananTahunan.LTLB_PILL.getCode(),
                    ER7047PosLtlbDppkPill.R_PILL010000.getObject().getKey(),
                    "PILL|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_ASLN_PPIP(programs(PPMPPPIPK),
            () -> {
                String sumField = "3";
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

                return UtilSegmentValidationV2.genSumIfFilter(UtilMetadata.genPipeColumn(3, 12),
                        ER7003PosLtlbDppkNrc.R_NRC0108000000.getObject().getKey(),
                        EFormLaporanBulananTahunan.LTLB_ASLN.getCode(),
                        ER7053PosLtlbDppkAsln.R_ASLN010000.getObject().getKey(),
                        "6", "8", sumField, criteriaCondition, sumCriteriaCondition,
                        "2", "PPIP",
                        "ASLN|Nilai Aset|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain", criteriaConditionErr, sumCriteriaConditionErr);
            }),

    SG_SUMIF_UMPJ_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0115010000.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_UMPJ.getCode(),
                    ER7054PosLtlbDppkUmpj.R_UMPJ010000.getObject().getKey(),
                    "UMPJ|Jumlah - Total|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_UTIN_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0115030000.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_UTIN.getCode(),
                    ER7056PosLtlbDppkUtin.R_UTIN010000.getObject().getKey(),
                    "UTIN|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PDDM_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0115040000.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_PDDM.getCode(),
                    ER7057PosLtlbDppkPddm.R_PDDM010000.getObject().getKey(),
                    "PDDM|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_BMHB_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0115050000.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_BMHB.getCode(),
                    ER7058PosLtlbDppkBmhb.R_BMHB010000.getObject().getKey(),
                    "BMHB|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_UTLN_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelperPPIP(
                    ER7003PosLtlbDppkNrc.R_NRC0115060000.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_UTLN.getCode(),
                    ER7059PosLtlbDppkUtln.R_UTLN010000.getObject().getKey(),
                    "UTLN|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),


    SG_EQUALS_FORMULA_1_PPIP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 17),
                    ER7003PosLtlbDppkNrc.R_NRC0102000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(PPMPPPIPK), 0, 19) + "-NRC0101210000",
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0102000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(PPMPPPIPK), 0, 19) + "-'Akumulasi Penyusutan Bangunan'"))),

    SG_EQUALS_FORMULA_2_PPIP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 17),
                    ER7003PosLtlbDppkNrc.R_NRC0105000000_TMP_GABUNGAN.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), 23, 31),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0105000000_TMP_GABUNGAN.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), 23, 31)))),

    SG_EQUALS_FORMULA_3_PPIP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 17),
                    ER7003PosLtlbDppkNrc.R_NRC0107000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), 33, 37) + "-NRC0106060000",
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0107000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), 33, 37) + "-'Akumulasi Penyusutan'"))),

    SG_EQUALS_FORMULA_5_PPIP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 17),
                    ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), new int[]{21, 22, 32, 39, 40}),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), new int[]{21, 22, 32, 39, 40})))),

    SG_EQUALS_FORMULA_6_PPIP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 17),
                    ER7003PosLtlbDppkNrc.R_NRC0118000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), new int[]{42, 50}),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0118000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), new int[]{42, 50})))),

    SG_EQUALS_FORMULA_7_PPIP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 17),
                    ER7003PosLtlbDppkNrc.R_NRC0117000000_TMP_GABUNGAN.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), 43, 49),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0117000000_TMP_GABUNGAN.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), 43, 49)))),

    SG_FIELD_TOTAL_7_PPIP(programs(PPMPPPIPK), () -> genTotalValidationPPIP(R_NRC0106010000.key,
            EFormLaporanBulananTahunan.LTLB_TNBG,
            ER7048PosLtlbDppkTnbg.getObjects(),
            "10", "Nilai Perolehan Pada Tanggal Laporan")),

    SG_FIELD_TOTAL_8_PPIP(programs(PPMPPPIPK), () -> genTotalValidationPPIP(R_NRC0106020000.key,
            EFormLaporanBulananTahunan.LTLB_KNDR,
            ER7049PosLtlbDppkKndr.getObjects(),
            "6", "Nilai Perolahan")),

    SG_FIELD_TOTAL_9_PPIP(programs(PPMPPPIPK), () -> genTotalValidationPPIP(R_NRC0106030000.key,
            EFormLaporanBulananTahunan.LTLB_PKOM,
            ER7050PosLtlbDppkPkom.getObjects(),
            "5", "Nilai Perolehan")),

    SG_FIELD_TOTAL_10_PPIP(programs(PPMPPPIPK), () -> genTotalValidationPPIP(R_NRC0106040000.key,
            EFormLaporanBulananTahunan.LTLB_PKAN,
            ER7051PosLtlbDppkPkan.getObjects(),
            "5", "Nilai Perolehan")),

    SG_FIELD_TOTAL_11_PPIP(programs(PPMPPPIPK), () -> genTotalValidationPPIP(R_NRC0106050000.key,
            EFormLaporanBulananTahunan.LTLB_ASOL,
            ER7052PosLtlbDppkAsol.getObjects(),
            "5", "Nilai Perolehan")),

    SG_MULTI_SUM_NRC0106060000_PPIP(programs(PPMPPPIPK), () -> {
        FormulaParserData operation = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(ER7048PosLtlbDppkTnbg.getObjects(), "1", "8", EFormLaporanBulananTahunan.LTLB_TNBG.getCode()),
                genFormulaParser(ER7049PosLtlbDppkKndr.getObjects(), "1", "7", EFormLaporanBulananTahunan.LTLB_KNDR.getCode()),
                genFormulaParser(ER7050PosLtlbDppkPkom.getObjects(), "1", "6", EFormLaporanBulananTahunan.LTLB_PKOM.getCode()),
                genFormulaParser(ER7051PosLtlbDppkPkan.getObjects(), "1", "6", EFormLaporanBulananTahunan.LTLB_PKAN.getCode()),
                genFormulaParser(ER7052PosLtlbDppkAsol.getObjects(), "1", "6", EFormLaporanBulananTahunan.LTLB_ASOL.getCode()),
        }, "+|+|+|+");

        String operationFormErr = "sama dengan Total Penjumlahan Kolom 'Akumulasi Penyusutan' pada form TNBG, KNDR, PKOM, PKAN, dan ASOL";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("17", R_NRC0106060000.key, operation.getFormula(),
                "2", "PPIP",
                operationFormErr, 2);
    }),

    GEN_VALIDATON_FORM_LAK_PPIP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_NRC0104010000.getObject();
        int[] cols = {17};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7005PosLtlbDppkLak.R_LAK0900000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("17", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm,
                "2", "PPIP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_UMPS_PPIP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_NRC0115020000.getObject();
        int[] cols = {5};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_UMPS.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7055PosLtlbDppkUmps.R_UMPS000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("17", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm,
                "2", "PPIP",
                errMsg, 2);
    }),

    // SHARED VALIDTAIONS

    FV_EQUALS_EXCEPT_1(programs(PPMPPPIPK), validationFields(Dppk0003Nrc.GABUNGAN),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(
                    UtilMetadata.genPlusColumn(3, 12),
                    UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), new int[]{21, 32, 39, 41, 50, 51}),
                    2)),

    FV_EQUALS_EXCEPT_2(programs(PPMPPPIPK), validationFields(Dppk0003Nrc.TOTAL),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(
                    UtilMetadata.genPlusColumn(13, 16),
                    UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK), new int[]{21, 32, 39, 41, 50, 51}),
                    2)),

    CR_EXISTS_POS_M(programs(PPMPPPIPK), validationFields(1001, 1002, 1003, 1004),
            () -> UtilFieldConditional.genExistPosAndComparatorHasValue("N", "M",
                    UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(PPMPPPIPK)), "2", "PPMP")),

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

    public static final BaseMetadataValidation<E7003NrcGabunganValidationsConfig> VALIDATION_METADATA_PPMPPPIPK =
            new LbltMetadataValidation<>(E7003NrcGabunganValidationsConfig.class, PPMPPPIPK);

    private static SegmentValidation genEqualsFormPPIP(String selectField, String formComparatorField, KeyValueString form, KeyValueString comparatorForm, String msg) {
        return UtilSegmentValidationV2.genEqualsForm(selectField, form.getKey(),
                EFormLaporanBulananTahunan.LTLB_LAN.getCode(), formComparatorField, comparatorForm.getKey(),
                "2", "PPIP",
                msg, 2);
    }

    private static SegmentValidation genEqualsFormPPMP(String selectField, String formComparatorField, KeyValueString form, KeyValueString comparatorForm, String msg) {
        return UtilSegmentValidationV2.genEqualsForm(selectField, form.getKey(),
                EFormLaporanBulananTahunan.LTLB_LAN.getCode(), formComparatorField, comparatorForm.getKey(),
                "2", "PPMP",
                msg, 2);
    }

    private static SegmentValidation sumIfValidationHelperPPIP(String posCode, String rangeField, String criteriaField, String formCode,
                                                               String formObjects, String errMsg) {
        String sumField = "3";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidationV2.genSumIfFilter(UtilMetadata.genPipeColumnExcept(3, 16, new int[]{13}), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                "2", "PPIP",
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }

    private static SegmentValidation sumIfValidationHelperPPMP(String posCode, String rangeField, String criteriaField, String formCode,
                                                               String formObjects, String errMsg) {
        String sumField = "3";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidationV2.genSumIfFilter(UtilMetadata.genPipeColumn(3, 12), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                "2", "PPMP",
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }

    private static SegmentValidation genTotalValidationPPIP(String selectPosCode,
                                                            EFormLaporanBulananTahunan comparatorForm,
                                                            List<KeyValueString> formObject,
                                                            String comparatorFields, String fieldErrorMessage) {

        FormulaParserData operation2 = genFormulaParser(formObject,
                "1", /* 0 :: baris detail | 1 :: baris total
                                    kalo validasi lama ganti 1 biar langsung nembak ke baris total */
                comparatorFields, comparatorForm.getCode());

        String errMsg = "sama dengan 'Total' Kolom '" + fieldErrorMessage + "' pada Form " + comparatorForm.getCode();

        return UtilSegmentValidationV2.genFormulaParserValidationV2("17", selectPosCode, operation2.getFormula(),
                "2", "PPIP",
                errMsg, 2);
    }

    private static SegmentValidation genTotalValidationPPMP(String selectPosCode,
                                                            EFormLaporanBulananTahunan comparatorForm,
                                                            List<KeyValueString> formObject,
                                                            String comparatorFields, String fieldErrorMessage) {

        FormulaParserData operation2 = genFormulaParser(formObject,
                "1", /* 0 :: baris detail | 1 :: baris total
                                    kalo validasi lama ganti 1 biar langsung nembak ke baris total */
                comparatorFields, comparatorForm.getCode());

        String errMsg = "sama dengan 'Total' Kolom '" + fieldErrorMessage + "' pada Form " + comparatorForm.getCode();

        return UtilSegmentValidationV2.genFormulaParserValidationV2("13", selectPosCode, operation2.getFormula(),
                "2", "PPMP",
                errMsg, 2);
    }

    public static List<SegmentValidation> additionalSegmentLanGabungan(String type) {
        KeyValueString[] kvsForm = {R_NRC0104010000.getObject(), R_NRC0115020000.getObject()};
        KeyValueString[] kvsComparator = {ER7001PosLtlbDppkLan.R_LAN0103010000.getObject(), ER7001PosLtlbDppkLan.R_LAN0108020200.getObject()};
        List<SegmentValidation> segmentValidations = new ArrayList<>();
        String msg;

        int maxField = 17;
        if (type.equals("PPMP")) {
            maxField = 13;
        }

        for (int i = 0; i < kvsForm.length; i++) {
            for (int j = 3; j < maxField; j++) {
                if (j == 13) j++;
                else {
                    msg = UtilMetadata.genMessage(kvsForm[i].getValue(), kvsComparator[i].getValue()) + " pada form LAN";
                    if (type.equalsIgnoreCase("PPIP"))
                        segmentValidations.add(genEqualsFormPPIP(String.valueOf(j), String.valueOf(j + 1), kvsForm[i], kvsComparator[i], msg));
                    else {
                        segmentValidations.add(genEqualsFormPPMP(String.valueOf(j), String.valueOf(j + 1), kvsForm[i], kvsComparator[i], msg));
                    }
                }
            }
        }

        return segmentValidations;
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
