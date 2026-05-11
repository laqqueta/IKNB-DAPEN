package id.go.ojk.metadata.module.lblt.dppk.validations.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1250Properti;
import id.go.ojk.conf.client.field.reference.ER1255JenisManfaat;
import id.go.ojk.metadata.module.lblt.dppk.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.dppk.reference.*;

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

import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7001PosLtlbDppkLan.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7001LanValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUMIF_LAN0101010000(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0101010000.getObject().getKey(), "6", "9",
                    EFormLaporanBulananTahunan.LTLB_DOC.getCode(),
                    ER7022PosLtlbDppkDoc.R_DOC010000.getObject().getKey(),
                    "DOC|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0101020000(programs(PPMPK),
            () -> {
                String comparatorForms = EFormLaporanBulananTahunan.LTLB_DPJKA.getCode() + "|"
                        + EFormLaporanBulananTahunan.LTLB_DPJKV.getCode();
                String comparatorRows = ER7023PosLtlbDppkDpjka.R_DPJKA010000.getObject().getKey() + "|"
                        + ER7024PosLtlbDppkDpjkv.R_DPJKV010000.getObject().getKey();
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
                String sumCriteriaCond = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
                String sumConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidation.genMultiFormSumIf(
                        UtilMetadata.genPipeColumn(2, 11), ER7001PosLtlbDppkLan.R_LAN0101020000.getObject().getKey(),
                        comparatorForms, comparatorRows,
                        "6|6", "9|12", "3", criteriaCondition, sumCriteriaCond,
                        "DPJKA|DPJKV|Jumlah Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumConditionErr);
            }),

    SG_SUMIF_LAN0101040000(FieldUtil.programs(PPMPK),
            () -> sumIfSpecFieldHelper(R_LAN0101040000.key,
                    "8", "11", "7",
                    EFormLaporanBulananTahunan.LTLB_SBI.getCode(),
                    ER7026PosLtlbDppkSbi.R_SBI010000.getObject().getKey(),
                    "SBI|Nilai Wajar|Nilai Perolehan")),

    SG_SUMIF_LAN0101050000(FieldUtil.programs(PPMPK),
            () -> sumIfSpecFieldHelper(R_LAN0101050000.key,
                    "8", "11", "7",
                    EFormLaporanBulananTahunan.LTLB_RSBN.getCode(),
                    ER7027PosLtlbDppkRsbn.R_RSBN010000.getObject().getKey(),
                    "RSBN|Nilai Wajar|Nilai Perolehan")),

    SG_SUMIF_LAN0101060000(FieldUtil.programs(PPMPK),
            () -> sumIfSpecFieldHelper(R_LAN0101060000.key,
                    "6", "11", "7",
                    EFormLaporanBulananTahunan.LTLB_SHM.getCode(),
                    ER7028PosLtlbDppkShm.R_SHM010000.getObject().getKey(),
                    "SHM|Nilai Perolehan|Nilai Pasar")),

    SG_SUMIF_LAN0101070000(FieldUtil.programs(PPMPK),
            () -> sumIfSpecFieldHelper(R_LAN0101070000.key,
                    "12", "16", "11",
                    EFormLaporanBulananTahunan.LTLB_OBLI.getCode(),
                    ER7029PosLtlbDppkObli.R_OBLI010000.getObject().getKey(),
                    "OBLI|Nilai Wajar|Nilai Perolehan")),

    SG_SUMIF_LAN0101080000(FieldUtil.programs(PPMPK),
            () -> sumIfSpecFieldHelper(R_LAN0101080000.key,
                    "12", "16", "11",
                    EFormLaporanBulananTahunan.LTLB_SUKUK.getCode(),
                    ER7030PosLtlbDppkSukuk.R_SUKUK010000.getObject().getKey(),
                    "SUKUK|Nilai Wajar|Nilai Perolehan")),

    SG_SUMIF_LAN0101090000(FieldUtil.programs(PPMPK),
            () -> sumIfSpecFieldHelper(R_LAN0101090000.key,
                    "12", "16", "11",
                    EFormLaporanBulananTahunan.LTLB_OBSUD.getCode(),
                    ER7031PosLtlbDppkObsud.R_OBSUD010000.getObject().getKey(),
                    "OBSUD|Nilai Wajar|Nilai Perolehan")),

    SG_SUMIF_LAN0101100000(FieldUtil.programs(PPMPK),
            () -> sumIfSpecFieldHelper(R_LAN0101100000.key,
                    "9", "12", "8",
                    EFormLaporanBulananTahunan.LTLB_RKSD.getCode(),
                    ER7032PosLtlbDppkRksd.R_RKSD010000.getObject().getKey(),
                    "RKSD|Nilai Wajar|Nilai Perolehan")),

    SG_SUMIF_LAN0101110000(FieldUtil.programs(PPMPK),
            () -> sumIfSpecFieldHelper(R_LAN0101110000.key,
                    "12", "16", "11",
                    EFormLaporanBulananTahunan.LTLB_MTN.getCode(),
                    ER7033PosLtlbDppkMtn.R_MTN010000.getObject().getKey(),
                    "MTN|Nilai Wajar|Nilai Perolehan")),

    SG_SUMIF_LAN0101120000(FieldUtil.programs(PPMPK),
            () -> sumIfSpecFieldHelper(R_LAN0101120000.key,
                    "12", "16", "11",
                    EFormLaporanBulananTahunan.LTLB_EBA.getCode(),
                    ER7034PosLtlbDppkEba.R_EBA010000.getObject().getKey(),
                    "EBA|Nilai Wajar|Nilai Perolehan")),

    SG_SUMIF_LAN0101130000(FieldUtil.programs(PPMPK),
            () -> sumIfSpecFieldHelper(R_LAN0101130000.key,
                    "8", "16", "7",
                    EFormLaporanBulananTahunan.LTLB_DIRE.getCode(),
                    ER7035PosLtlbDppkDire.R_DIRE010000.getObject().getKey(),
                    "DIRE|Nilai Wajar|Nilai Perolehan")),

    SG_SUMIF_LAN0101140000(FieldUtil.programs(PPMPK),
            () -> sumIfSpecFieldHelper(R_LAN0101130000.key,
                    "8", "11", "7",
                    EFormLaporanBulananTahunan.LTLB_DNFRA.getCode(),
                    ER7036PosLtlbDppkDnfra.R_DNFRA010000.getObject().getKey(),
                    "DNFRA|Nilai Aktifa Bersih|Nilai Perolehan")),

    SG_SUMIF_LAN0101150000(FieldUtil.programs(PPMPK),
            () -> sumIfSpecFieldHelper(R_LAN0101150000.key,
                    "7", "10", "6",
                    EFormLaporanBulananTahunan.LTLB_KOKB.getCode(),
                    ER7037PosLtlbDppkKokb.R_KOKB010000.getObject().getKey(),
                    "KOKB|Nilai Wajar|Nilai Perolehan")),

    SG_SUMIF_LAN0101160000(FieldUtil.programs(PPMPK),
            () -> sumIfSpecFieldHelper(R_LAN0101160000.key,
                    "14", "17", "10",
                    EFormLaporanBulananTahunan.LTLB_REPO.getCode(),
                    ER7038PosLtlbDppkRepo.R_REPO010000.getObject().getKey(),
                    "REPO|Nilai Jual|Nilai Perolehan")),

    SG_SUMIF_LAN0101170000(FieldUtil.programs(PPMPK),
            () -> sumIfSpecFieldHelper(R_LAN0101170000.key,
                    "15", "19", "11",
                    EFormLaporanBulananTahunan.LTLB_PNYL.getCode(),
                    ER7039PosLtlbDppkPnyl.R_PNYL000000.getObject().getKey(),
                    "PNYL|Nilai Apprasial/wajar - Total|Nilai Perolehan Per tanggal laporan - Total")),

    SG_SUMIF_PROP(programs(PPMPK),
            () -> {
                // For Validation Kode Pos LAN0101180000, LAN0101190000, and LAN0101200000
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                        + "$" + ER1250Properti.getPipedReferenceKeys();
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                        + "$" + ER1250Properti.getPipedReferenceKeyValues();
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                String fieldSpec = "8";
                String specCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL2|MPL3|ML2|ML3|ML4|ML5|ML6");
                return UtilSegmentValidation.genMultiSpecFieldCriteriaSumIf(
                        UtilMetadata.genPipeColumn(3, 12), UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPK), 17, 19),
                        EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                        ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                        "11", "17|2", "3", fieldSpec, specCondition, criteriaCondition, sumCriteriaCondition,
                        "PROP|Nilai Appraisal/ Nilai Wajar|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Objek (Tanah/Bangunan/Tanah&Bangunan)",
                        criteriaConditionErr, sumCriteriaConditionErr, "0");
            }),

    SG_SUMIF_PIUT(programs(PPMPK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidation.genSumIf(
                        UtilMetadata.genPipeColumn(3, 12), UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPK), 24, 26),
                        EFormLaporanBulananTahunan.LTLB_PIUT.getCode(),
                        ER7042PosLtlbDppkPiut.R_PIUT010000.getObject().getKey(),
                        "5|8|12", "13", "3", criteriaCondition, sumCriteriaCondition,
                        "PIUT|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumCriteriaConditionErr,
                        "Piutang Iuran Peserta Total|Piutang Iuran Pemberi Kerja Total|Piutang Iuran Tambahan Total");
            }),

    SG_SUMIF_LAN0103060000(FieldUtil.programs(PPMPK), () -> {
        String posCode = R_LAN0103060000.key;
        String rangeField = "3#4";
        String criteriaField = "6";
        String formCode = EFormLaporanBulananTahunan.LTLB_PIUB.getCode();
        String formObjects = ER7043PosLtlbDppkPiub.R_PIUB010000.getObject().getKey();
        String errMsg = "PIUB|Piutang Bunga Iuran Peserta dan Piutang Bunga Iuran Pemberi Kerja|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF";

        String sumField = "3";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidation.genSumIfMultiField(UtilMetadata.genPipeColumn(3, 12), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }),

    SG_SUMIF_LAN0101030000(FieldUtil.programs(PPMPK), () -> {
        String sumField = "3";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        String posCode = R_LAN0101030000.key;
        String rangeField = "6";
        String criteriaField = "9";
        String specField = "6";
        String criteriaSpecField = "9";
        String specCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL2|MPL3|ML2|ML3|ML4|ML5|ML6");
        String formSpec = EFormLaporanBulananTahunan.LTLB_DPJKA.getCode();
        String formRowSpec = ER7023PosLtlbDppkDpjka.R_DPJKA010000.getObject().getKey();
        String formCode = EFormLaporanBulananTahunan.LTLB_SRDP.getCode();
        String formObjects = ER7025PosLtlbDppkSrdp.R_SRDP010000.getObject().getKey();
        String errMsg = "SRDP|DPJKA|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF";

        return UtilSegmentValidation.genSumIfSpecForm(UtilMetadata.genPipeColumn(3, 12), posCode,
                formCode, formObjects, rangeField, criteriaField, sumField,
                specField, specCondition, criteriaSpecField, formSpec, formRowSpec, criteriaCondition, sumCriteriaCondition,
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }),


    SG_SUMIF_LAN0103070000(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0103070000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_BBMK.getCode(),
                    ER7044PosLtlbDppkBbmk.R_BBMK010000.getObject().getKey(),
                    "BBMK|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0103080000(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0103080000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PIUI.getCode(),
                    ER7045PosLtlbDppkPiui.R_PIUI010000.getObject().getKey(),
                    "PIUI|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0103090000(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0103090000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PIHI.getCode(),
                    ER7046PosLtlbDppkPihi.R_PIHI010000.getObject().getKey(),
                    "PIHI|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0103100000(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0103100000.getObject().getKey(), "4", "6",
                    EFormLaporanBulananTahunan.LTLB_PILL.getCode(),
                    ER7047PosLtlbDppkPill.R_PILL010000.getObject().getKey(),
                    "PILL|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0106000000(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0106000000.getObject().getKey(), "5", "7",
                    EFormLaporanBulananTahunan.LTLB_ASLN.getCode(),
                    ER7053PosLtlbDppkAsln.R_ASLN010000.getObject().getKey(),
                    "ASLN|Nilai Aset|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_LAN0108020100(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0108020100.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_UMPJ.getCode(),
                    ER7054PosLtlbDppkUmpj.R_UMPJ010000.getObject().getKey(),
                    "UMPJ|Total - Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0108020300(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0108020300.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_UTIN.getCode(),
                    ER7056PosLtlbDppkUtin.R_UTIN010000.getObject().getKey(),
                    "UTIN|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0108020400(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0108020400.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PDDM.getCode(),
                    ER7057PosLtlbDppkPddm.R_PDDM010000.getObject().getKey(),
                    "PDDM|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0108020500(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0108020500.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_BMHB.getCode(),
                    ER7058PosLtlbDppkBmhb.R_BMHB010000.getObject().getKey(),
                    "BMHB|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0108020600(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7001PosLtlbDppkLan.R_LAN0108020600.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_UTLN.getCode(),
                    ER7059PosLtlbDppkUtln.R_UTLN010000.getObject().getKey(),
                    "UTLN|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_EQUALS_FORMULA_1(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13),
                    ER7001PosLtlbDppkLan.R_LAN0102000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPK), 0, 19),
                    UtilMetadata.genMessage(ER7001PosLtlbDppkLan.R_LAN0102000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPK), 0, 19)))),

    SG_EQUALS_FORMULA_2(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 13),
                    ER7001PosLtlbDppkLan.R_LAN0104000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPK), 21, 29),
                    UtilMetadata.genMessage(ER7001PosLtlbDppkLan.R_LAN0104000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPK), 21, 29)))),

    SG_EQUALS_FORMULA_3(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 13),
                    ER7001PosLtlbDppkLan.R_LAN0107000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPK), new int[]{21, 30, 36, 37}),
                    UtilMetadata.genMessage(ER7001PosLtlbDppkLan.R_LAN0107000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), new int[]{21, 30, 36, 37})))),

    SG_EQUALS_FORMULA_4(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 13),
                    ER7001PosLtlbDppkLan.R_LAN0111000000.getObject().getKey(),
                    UtilMetadata.genMinusRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPK), new int[]{38, 47}),
                    UtilMetadata.genMessage(ER7001PosLtlbDppkLan.R_LAN0111000000.getObject().getValue(),
                            UtilMetadata.genMinusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), new int[]{38, 47})))),

    SG_PERSENTASE_INVESTASI(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsRatioLan(
                    "2", UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPK), 0, 19),
                    UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPK), 0, 19), "13", R_LAN0102000000.key, "13",
                    "TOTAL INVESTASI", 2)),

    FV_GABUNGAN_EQUALS_EXCEPT(programs(PPMPK), validationFields(13),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(
                    UtilMetadata.genPlusColumn(3, 12),
                    UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPK), new int[]{20, 30, 38, 48}),
                    0)),

    CR_EXIST_POS_N_PERSENTASE_INVESTASI(programs(PPMPK), validationFields(2),
            () -> UtilFieldConditional.genExistPos("N", "M",
                    UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPK), 21, 48))),

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

    public static final BaseMetadataValidation<E7001LanValidationsConfig> VALIDATION_METADATA_PPMPK =
            new LbltMetadataValidation<>(E7001LanValidationsConfig.class, PPMPK);

    private static SegmentValidation sumIfValidationHelper(String posCode, String rangeField, String criteriaField, String formCode,
                                                           String formObjects, String errMsg) {
        String sumField = "2";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidation.genSumIf(UtilMetadata.genPipeColumn(2, 11), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }

    private static SegmentValidation sumIfSpecFieldHelper(String posCode, String rangeField, String criteriaField, String specField,
                                                          String formCode, String formObjects, String errMsg) {
        String sumField = "3";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
        String specCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL2|MPL3|ML2|ML3|ML4|ML5|ML6");

        return UtilSegmentValidation.genSumIfSpecField(UtilMetadata.genPipeColumn(3, 12), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, specField, specCondition, criteriaCondition, sumCriteriaCondition,
                errMsg + "|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF", criteriaConditionErr, sumCriteriaConditionErr);
    }
}
