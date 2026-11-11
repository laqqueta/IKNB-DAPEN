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
import id.go.ojk.metadata.module.lblt.field.Dppk0001Lan;
import id.go.ojk.metadata.module.lblt.reference.*;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.validation.ValidationConverter;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;

import static id.go.ojk.conf.client.UtilMetadata.genFormulaParser;
import static id.go.ojk.metadata.module.lblt.reference.ER7001PosLtlbDppkLan.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPPPIPK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7001LanGabunganValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUMIF_LAN0101010000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(
                    ER7001PosLtlbDppkLan.R_LAN0101010000.getObject().getKey(), "7", "10",
                    EFormLaporanBulananTahunan.LTLB_DOC.getCode(),
                    ER7022PosLtlbDppkDoc.R_DOC010000.getObject().getKey(),
                    "DOC|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0101020000_PPMP(programs(PPMPPPIPK),
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
                        UtilMetadata.genPipeColumn(4, 13), ER7001PosLtlbDppkLan.R_LAN0101020000.getObject().getKey(),
                        comparatorForms, comparatorRows,
                        "7|7", "10|13", "4", criteriaCondition, sumCriteriaCond,
                        "2", "PPMP",
                        "DPJKA|DPJKV|Jumlah Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumConditionErr);
            }),

    SG_SUMIF_LAN0101030000_PPMP(programs(PPMPPPIPK), () -> sumIfValidationHelper_PPMP(
            ER7001PosLtlbDppkLan.R_LAN0101030000.getObject().getKey(), "7", "10",
            EFormLaporanBulananTahunan.LTLB_SRDP.getCode(),
            ER7025PosLtlbDppkSrdp.R_SRDP010000.getObject().getKey(),
            "SRDP|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
    )),

    SG_SUMIF_LAN0101040000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(R_LAN0101040000.key,
                    "9", "12",
                    EFormLaporanBulananTahunan.LTLB_SBI.getCode(),
                    ER7026PosLtlbDppkSbi.R_SBI010000.getObject().getKey(),
                    "SBI|Nilai Wajar|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF")),

    SG_SUMIF_LAN0101050000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(R_LAN0101050000.key,
                    "9", "12",
                    EFormLaporanBulananTahunan.LTLB_RSBN.getCode(),
                    ER7027PosLtlbDppkRsbn.R_RSBN010000.getObject().getKey(),
                    "RSBN|Nilai Wajar")),

    SG_SUMIF_LAN0101060000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(R_LAN0101060000.key,
                    "8", "12",
                    EFormLaporanBulananTahunan.LTLB_SHM.getCode(),
                    ER7028PosLtlbDppkShm.R_SHM010000.getObject().getKey(),
                    "SHM|Nilai Perolehan")),

    SG_SUMIF_LAN0101070000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(R_LAN0101070000.key,
                    "13", "17",
                    EFormLaporanBulananTahunan.LTLB_OBLI.getCode(),
                    ER7029PosLtlbDppkObli.R_OBLI010000.getObject().getKey(),
                    "OBLI|Nilai Wajar")),

    SG_SUMIF_LAN0101080000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(R_LAN0101080000.key,
                    "13", "17",
                    EFormLaporanBulananTahunan.LTLB_SUKUK.getCode(),
                    ER7030PosLtlbDppkSukuk.R_SUKUK010000.getObject().getKey(),
                    "SUKUK|Nilai Wajar")),

    SG_SUMIF_LAN0101090000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(R_LAN0101090000.key,
                    "13", "17",
                    EFormLaporanBulananTahunan.LTLB_OBSUD.getCode(),
                    ER7031PosLtlbDppkObsud.R_OBSUD010000.getObject().getKey(),
                    "OBSUD|Nilai Wajar")),

    SG_SUMIF_LAN0101100000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(R_LAN0101100000.key,
                    "10", "13",
                    EFormLaporanBulananTahunan.LTLB_RKSD.getCode(),
                    ER7032PosLtlbDppkRksd.R_RKSD010000.getObject().getKey(),
                    "RKSD|Nilai Wajar")),

    SG_SUMIF_LAN0101110000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(R_LAN0101110000.key,
                    "13", "17",
                    EFormLaporanBulananTahunan.LTLB_MTN.getCode(),
                    ER7033PosLtlbDppkMtn.R_MTN010000.getObject().getKey(),
                    "MTN|Nilai Wajar")),

    SG_SUMIF_LAN0101120000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(R_LAN0101120000.key,
                    "13", "17",
                    EFormLaporanBulananTahunan.LTLB_EBA.getCode(),
                    ER7034PosLtlbDppkEba.R_EBA010000.getObject().getKey(),
                    "EBA|Nilai Wajar")),

    SG_SUMIF_LAN0101130000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(R_LAN0101130000.key,
                    "9", "12",
                    EFormLaporanBulananTahunan.LTLB_DIRE.getCode(),
                    ER7035PosLtlbDppkDire.R_DIRE010000.getObject().getKey(),
                    "DIRE|Nilai Wajar")),

    SG_SUMIF_LAN0101140000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(R_LAN0101140000.key,
                    "9", "12",
                    EFormLaporanBulananTahunan.LTLB_DNFRA.getCode(),
                    ER7036PosLtlbDppkDnfra.R_DNFRA010000.getObject().getKey(),
                    "DNFRA|Nilai Aktifa Bersih")),

    SG_SUMIF_LAN0101150000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(R_LAN0101150000.key,
                    "8", "11",
                    EFormLaporanBulananTahunan.LTLB_KOKB.getCode(),
                    ER7037PosLtlbDppkKokb.R_KOKB010000.getObject().getKey(),
                    "KOKB|Nilai Wajar")),

    SG_SUMIF_LAN0101160000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(R_LAN0101160000.key,
                    "15", "18",
                    EFormLaporanBulananTahunan.LTLB_REPO.getCode(),
                    ER7038PosLtlbDppkRepo.R_REPO010000.getObject().getKey(),
                    "REPO|Nilai Jual")),

    SG_SUMIF_LAN0101170000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(R_LAN0101170000.key,
                    "16", "20",
                    EFormLaporanBulananTahunan.LTLB_PNYL.getCode(),
                    ER7039PosLtlbDppkPnyl.R_PNYL010000.getObject().getKey(),
                    "PNYL|Nilai Apprasial/wajar - Total")),

    SG_SUMIF_PROP_PPMP(programs(PPMPPPIPK),
            () -> {
                // For Validation Kode Pos LAN0101180000, LAN0101190000, and LAN0101200000
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                        + "$" + ER1250Properti.getPipedReferenceKeys();
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                        + "$" + ER1250Properti.getPipedReferenceKeyValues();
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genMultiCriteriaSumIf(
                        UtilMetadata.genPipeColumn(4, 13), UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), 17, 19),
                        EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                        ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                        "12", "18|3", "4", criteriaCondition, sumCriteriaCondition,
                        "2", "PPMP",
                        "PROP|Nilai Appraisal/ Nilai Wajar|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Objek (Tanah/Bangunan/Tanah dan Bangunan)",
                        criteriaConditionErr, sumCriteriaConditionErr, "0");
            }),

    SG_SUMIF_LAN0103010000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(R_LAN0103010000.key,
                    "7", "8",
                    EFormLaporanBulananTahunan.LTLB_KASB.getCode(),
                    ER7041PosLtlbDppkKasb.R_KASB010000.getObject().getKey(),
                    "KASB|Nominal")),

    SG_SUMIF_PIUT_PPMP(programs(PPMPPPIPK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genSumIfFilter(
                        UtilMetadata.genPipeColumn(4, 13), UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), 22, 24),
                        EFormLaporanBulananTahunan.LTLB_PIUT.getCode(),
                        ER7042PosLtlbDppkPiut.R_PIUT010000.getObject().getKey(),
                        "6|9|13", "14", "4", criteriaCondition, sumCriteriaCondition,
                        "2", "PPMP",
                        "PIUT|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumCriteriaConditionErr,
                        "Piutang Iuran Pemberi Kerja - Total|Piutang Iuran Peserta - Total|Piutang Iuran Sukarela Peserta");
            }),

    SG_SUMIF_LAN0103060000_PPMP(programs(PPMPPPIPK), () -> {
        String posCode = R_LAN0103060000.key;
        String rangeField = "4#6";
        String criteriaField = "7";
        String formCode = EFormLaporanBulananTahunan.LTLB_PIUB.getCode();
        String formObjects = ER7043PosLtlbDppkPiub.R_PIUB010000.getObject().getKey();
        String errMsg = "PIUB|Piutang Bunga Iuran Peserta dan Piutang Bunga Iuran Tambahan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF";

        String sumField = "4";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidationV2.genSumIfMultiField(UtilMetadata.genPipeColumn(4, 13), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                "2", "PPMP",
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }),

    SG_SUMIF_LAN0103070000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(
                    ER7001PosLtlbDppkLan.R_LAN0103070000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_BBMK.getCode(),
                    ER7044PosLtlbDppkBbmk.R_BBMK010000.getObject().getKey(),
                    "BBMK|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0103080000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(
                    ER7001PosLtlbDppkLan.R_LAN0103080000.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_PIUI.getCode(),
                    ER7045PosLtlbDppkPiui.R_PIUI010000.getObject().getKey(),
                    "PIUI|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0103090000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(
                    ER7001PosLtlbDppkLan.R_LAN0103090000.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_PIHI.getCode(),
                    ER7046PosLtlbDppkPihi.R_PIHI010000.getObject().getKey(),
                    "PIHI|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0103100000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(
                    ER7001PosLtlbDppkLan.R_LAN0103100000.getObject().getKey(), "5", "7",
                    EFormLaporanBulananTahunan.LTLB_PILL.getCode(),
                    ER7047PosLtlbDppkPill.R_PILL010000.getObject().getKey(),
                    "PILL|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0106000000_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(
                    ER7001PosLtlbDppkLan.R_LAN0106000000.getObject().getKey(), "6", "8",
                    EFormLaporanBulananTahunan.LTLB_ASLN.getCode(),
                    ER7053PosLtlbDppkAsln.R_ASLN010000.getObject().getKey(),
                    "ASLN|Nilai Aset|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_LAN0108020100_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(
                    ER7001PosLtlbDppkLan.R_LAN0108020100.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_UMPJ.getCode(),
                    ER7054PosLtlbDppkUmpj.R_UMPJ010000.getObject().getKey(),
                    "UMPJ|Total - Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0108020300_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(
                    ER7001PosLtlbDppkLan.R_LAN0108020300.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_UTIN.getCode(),
                    ER7056PosLtlbDppkUtin.R_UTIN010000.getObject().getKey(),
                    "UTIN|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0108020400_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(
                    ER7001PosLtlbDppkLan.R_LAN0108020400.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_PDDM.getCode(),
                    ER7057PosLtlbDppkPddm.R_PDDM010000.getObject().getKey(),
                    "PDDM|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0108020500_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(
                    ER7001PosLtlbDppkLan.R_LAN0108020500.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_BMHB.getCode(),
                    ER7058PosLtlbDppkBmhb.R_BMHB010000.getObject().getKey(),
                    "BMHB|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0108020600_PPMP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPMP(
                    ER7001PosLtlbDppkLan.R_LAN0108020600.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_UTLN.getCode(),
                    ER7059PosLtlbDppkUtln.R_UTLN010000.getObject().getKey(),
                    "UTLN|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_EQUALS_FORMULA_1(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13),
                    ER7001PosLtlbDppkLan.R_LAN0102000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), 0, 19),
                    UtilMetadata.genMessage(ER7001PosLtlbDppkLan.R_LAN0102000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), 0, 19)))),

    SG_EQUALS_FORMULA_2(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13),
                    ER7001PosLtlbDppkLan.R_LAN0104000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), 21, 29),
                    UtilMetadata.genMessage(ER7001PosLtlbDppkLan.R_LAN0104000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), 21, 29)))),

    SG_EQUALS_FORMULA_3(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13),
                    ER7001PosLtlbDppkLan.R_LAN0107000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), new int[]{20, 30, 36, 37}),
                    UtilMetadata.genMessage(ER7001PosLtlbDppkLan.R_LAN0107000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), new int[]{20, 30, 36, 37})))),

    SG_EQUALS_FORMULA_4(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13),
                    R_LAN0111000000.getObject().getKey(),
                    UtilMetadata.genMinusRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), new int[]{38, 47}),
                    UtilMetadata.genMessage(R_LAN0111000000.getObject().getValue(),
                            UtilMetadata.genMinusDesc(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), new int[]{38, 47})))),

    SG_EQUALS_FORMULA_5(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13),
                    ER7001PosLtlbDppkLan.R_LAN0109000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), 39, 45),
                    UtilMetadata.genMessage(ER7001PosLtlbDppkLan.R_LAN0109000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), 39, 45)))),

    SG_EQUALS_FORMULA_6(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13),
                    ER7001PosLtlbDppkLan.R_LAN0110000000.getObject().getKey(),
                    ER7001PosLtlbDppkLan.R_LAN0109000000.getObject().getKey(),
                    UtilMetadata.genMessage(ER7001PosLtlbDppkLan.R_LAN0110000000.getObject().getValue(),
                            ER7001PosLtlbDppkLan.R_LAN0109000000.getObject().getValue()))),

    /* Update Pak Yahya */

    GEN_VALIDATON_FORM_NRC1_PPMP(programs(PPMPPPIPK), () -> {
        int[] comparatorRows = {21, 22};
        String comparatorField = UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(PPMPPPIPK), comparatorRows);
        String plusDesc = UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(PPMPPPIPK), comparatorRows);
        String errMsg = UtilMetadata.genMessage(R_LAN0102000000.value, plusDesc + " pada form " + EFormLaporanBulananTahunan.LTLB_NERACA.getCode());
        return UtilSegmentValidationV2.genEqualsFormulaFormV2("14", R_LAN0102000000.key,
                EFormLaporanBulananTahunan.LTLB_NERACA.getCode(), "13", comparatorField,
                "2", "PPMP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_NRC1_PPIP(programs(PPMPPPIPK), () -> {
        int[] comparatorRows = {21, 22};
        String comparatorField = UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(PPMPPPIPK), comparatorRows);
        String plusDesc = UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(PPMPPPIPK), comparatorRows);
        String errMsg = UtilMetadata.genMessage(R_LAN0102000000.value, plusDesc + " pada form " + EFormLaporanBulananTahunan.LTLB_NERACA.getCode());
        return UtilSegmentValidationV2.genEqualsFormulaFormV2("18", R_LAN0102000000.key,
                EFormLaporanBulananTahunan.LTLB_NERACA.getCode(), "17", comparatorField,
                "2", "PPIP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_INSP_PPIP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0102000000.getObject();
        int[] cols = {5};
        String form = EFormLaporanBulananTahunan.LTLB_INSP.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorPosCode = ER7013PosLtlbDppkInsp.R_INSP000000.key;
        String errMsg = selectPosCode.getValue() + " |Total Jumlah Investasi pada form " + form;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("18", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, form, "2", "PPIP", errMsg, 2);
    }),

    GEN_VALIDATON_FORM_INSP_PPMP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0102000000.getObject();
        int[] cols = {5};
        String form = EFormLaporanBulananTahunan.LTLB_INSP.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorPosCode = ER7013PosLtlbDppkInsp.R_INSP000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Jumlah Investasi pada form " + form;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("14", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, form, "2", "PPMP", errMsg, 2);
    }),

    SG_PERIODE_BERJALAN_REKINV_PPIP(programs(PPMPPPIPK), () -> {
        String selectField = "18";
        String selectPosCode = R_LAN0102000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_REKINV.getCode();
        List<KeyValueString> formObject = ER7008PosLtlbDppkRekinv.getObjects(PPMPPPIPK);
        FormulaParserData operation2 = genFormulaParser(formObject, "20", "4", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + "pada form REKINV sesuai dengan Periode Bulan Laporan Berjalan ({})";

        return UtilSegmentValidationV2.genFormulaParserlRekinvPeriodePelaporan(selectField, selectPosCode, operationForm,
                "2", "PPIP",
                operationFormErr, 2);
    }),

    SG_PERIODE_BERJALAN_REKINV_PPMP(programs(PPMPPPIPK), () -> {
        String selectField = "14";
        String selectPosCode = R_LAN0102000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_REKINV.getCode();
        List<KeyValueString> formObject = ER7008PosLtlbDppkRekinv.getObjects(PPMPPPIPK);
        FormulaParserData operation2 = genFormulaParser(formObject, "20", "4", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + "pada form REKINV sesuai dengan Periode Bulan Laporan Berjalan ({})";

        return UtilSegmentValidationV2.genFormulaParserlRekinvPeriodePelaporan(selectField, selectPosCode, operationForm,
                "2", "PPMP",
                operationFormErr, 2);
    }),

    GEN_VALIDATON_FORM_KASB_PPMP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0103010000.getObject();
        int[] cols = {7};
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String form = EFormLaporanBulananTahunan.LTLB_KASB.getCode();
        String comparatorPosCode = ER7041PosLtlbDppkKasb.R_KASB000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Nominal pada form " + form;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("14", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, form,
                "2", "PPMP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_LAK_PPMP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0103010000.getObject();
        int[] cols = {13};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7005PosLtlbDppkLak.R_LAK0900000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("14", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm,
                "2", "PPMP",
                errMsg, 2);
    }),


    GEN_VALIDATON_FORM_TNBG_PPMP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0104020000.getObject();
        int[] cols = {9};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_TNBG.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorPosCode = ER7048PosLtlbDppkTnbg.R_TNBG000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("14", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, comparatorForm,
                "2", "PPMP",
                errMsg, 2);
    }),


    GEN_VALIDATON_FORM_KNDR_PPMP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0104030000.getObject();
        int[] cols = {8};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_KNDR.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorPosCode = ER7049PosLtlbDppkKndr.R_KNDR000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("14", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, comparatorForm,
                "2", "PPMP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_PKOM_PPMP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0104040000.getObject();
        int[] cols = {7};
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_PKOM.getCode();
        String comparatorPosCode = ER7050PosLtlbDppkPkom.R_PKOM000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("14", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, comparatorForm,
                "2", "PPMP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_PKAN_PPMP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0104050000.getObject();
        int[] cols = {7};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_PKAN.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorPosCode = ER7051PosLtlbDppkPkan.R_PKAN000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("14", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, comparatorForm,
                "2", "PPMP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_ASOL_PPMP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0104060000.getObject();
        int[] cols = {7};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ASOL.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorPosCode = ER7052PosLtlbDppkAsol.R_ASOL000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("13", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, comparatorForm,
                "2", "PPMP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_NRC2_PPMP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0107000000.getObject();
        int[] cols = {13};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_NERACA.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("14", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm,
                "2", "PPMP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_UMPS_PPMP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0108020200.getObject();
        int[] cols = {5};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_UMPS.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7055PosLtlbDppkUmps.R_UMPS000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("14", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm,
                "2", "PPMP",
                errMsg, 2);
    }),


    GEN_VALIDATON_FORM_LPAN_PPMP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0111000000.getObject();
        int[] cols = {13};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7002PosLtlbDppkLpan.R_LPAN0500000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("14", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm,
                "2", "PPMP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_PST_PPMP(programs(PPMPPPIPK), () -> {
        String selectExpr = "> 0";
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_PST.getCode();
        KeyValueString comparator = ER7006PosLtlbDppkPst.R_PST0400000000.getObject();
        String comparatorExpr = "> 0";
        String errMsg = comparator.getValue() + "|" + R_LAN0111000000.value;
        return UtilSegmentValidationV2.genEqualsFormConditionalExpression2("14", R_LAN0111000000.key, selectExpr, comparatorForm, "6",
                comparator.getKey(), comparatorExpr, "e",
                "2", "PPMP",
                2, errMsg);
    }),

    /* PPIP SEGMENT VALIDATIONS */


    SG_SUMIF_LAN0101010000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(
                    ER7001PosLtlbDppkLan.R_LAN0101010000.getObject().getKey(), "7", "10",
                    EFormLaporanBulananTahunan.LTLB_DOC.getCode(),
                    ER7022PosLtlbDppkDoc.R_DOC010000.getObject().getKey(),
                    "DOC|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0101020000_PPIP(programs(PPMPPPIPK),
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
                        UtilMetadata.genPipeColumnExcept(4, 17, new int[]{14}), ER7001PosLtlbDppkLan.R_LAN0101020000.getObject().getKey(),
                        comparatorForms, comparatorRows,
                        "7|7", "10|13", "4", criteriaCondition, sumCriteriaCond,
                        "2", "PPIP",
                        "DPJKA|DPJKV|Jumlah Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumConditionErr);
            }),

    SG_SUMIF_LAN0101030000_PPIP(programs(PPMPPPIPK), () -> sumIfValidationHelper_PPIP(
            ER7001PosLtlbDppkLan.R_LAN0101030000.getObject().getKey(), "7", "10",
            EFormLaporanBulananTahunan.LTLB_SRDP.getCode(),
            ER7025PosLtlbDppkSrdp.R_SRDP010000.getObject().getKey(),
            "SRDP|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
    )),
    SG_SUMIF_LAN0101040000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(R_LAN0101040000.key,
                    "9", "12",
                    EFormLaporanBulananTahunan.LTLB_SBI.getCode(),
                    ER7026PosLtlbDppkSbi.R_SBI010000.getObject().getKey(),
                    "SBI|Nilai Wajar|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF")),
    
    SG_SUMIF_LAN0101050000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(R_LAN0101050000.key,
                    "9", "12",
                    EFormLaporanBulananTahunan.LTLB_RSBN.getCode(),
                    ER7027PosLtlbDppkRsbn.R_RSBN010000.getObject().getKey(),
                    "RSBN|Nilai Wajar")),
    SG_SUMIF_LAN0101060000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(R_LAN0101060000.key,
                    "8", "12",
                    EFormLaporanBulananTahunan.LTLB_SHM.getCode(),
                    ER7028PosLtlbDppkShm.R_SHM010000.getObject().getKey(),
                    "SHM|Nilai Perolehan")),
    SG_SUMIF_LAN0101070000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(R_LAN0101070000.key,
                    "13", "17",
                    EFormLaporanBulananTahunan.LTLB_OBLI.getCode(),
                    ER7029PosLtlbDppkObli.R_OBLI010000.getObject().getKey(),
                    "OBLI|Nilai Wajar")),
    SG_SUMIF_LAN0101080000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(R_LAN0101080000.key,
                    "13", "17",
                    EFormLaporanBulananTahunan.LTLB_SUKUK.getCode(),
                    ER7030PosLtlbDppkSukuk.R_SUKUK010000.getObject().getKey(),
                    "SUKUK|Nilai Wajar")),
    SG_SUMIF_LAN0101090000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(R_LAN0101090000.key,
                    "13", "17",
                    EFormLaporanBulananTahunan.LTLB_OBSUD.getCode(),
                    ER7031PosLtlbDppkObsud.R_OBSUD010000.getObject().getKey(),
                    "OBSUD|Nilai Wajar")),
    SG_SUMIF_LAN0101100000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(R_LAN0101100000.key,
                    "10", "13",
                    EFormLaporanBulananTahunan.LTLB_RKSD.getCode(),
                    ER7032PosLtlbDppkRksd.R_RKSD010000.getObject().getKey(),
                    "RKSD|Nilai Wajar")),

    SG_SUMIF_LAN0101110000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(R_LAN0101110000.key,
                    "13", "17",
                    EFormLaporanBulananTahunan.LTLB_MTN.getCode(),
                    ER7033PosLtlbDppkMtn.R_MTN010000.getObject().getKey(),
                    "MTN|Nilai Wajar")),

    SG_SUMIF_LAN0101120000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(R_LAN0101120000.key,
                    "13", "17",
                    EFormLaporanBulananTahunan.LTLB_EBA.getCode(),
                    ER7034PosLtlbDppkEba.R_EBA010000.getObject().getKey(),
                    "EBA|Nilai Wajar")),

    SG_SUMIF_LAN0101130000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(R_LAN0101130000.key,
                    "9", "12",
                    EFormLaporanBulananTahunan.LTLB_DIRE.getCode(),
                    ER7035PosLtlbDppkDire.R_DIRE010000.getObject().getKey(),
                    "DIRE|Nilai Wajar")),

    SG_SUMIF_LAN0101140000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(R_LAN0101140000.key,
                    "9", "12",
                    EFormLaporanBulananTahunan.LTLB_DNFRA.getCode(),
                    ER7036PosLtlbDppkDnfra.R_DNFRA010000.getObject().getKey(),
                    "DNFRA|Nilai Aktifa Bersih")),

    SG_SUMIF_LAN0101150000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(R_LAN0101150000.key,
                    "8", "11",
                    EFormLaporanBulananTahunan.LTLB_KOKB.getCode(),
                    ER7037PosLtlbDppkKokb.R_KOKB010000.getObject().getKey(),
                    "KOKB|Nilai Wajar")),

    SG_SUMIF_LAN0101160000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(R_LAN0101160000.key,
                    "15", "18",
                    EFormLaporanBulananTahunan.LTLB_REPO.getCode(),
                    ER7038PosLtlbDppkRepo.R_REPO010000.getObject().getKey(),
                    "REPO|Nilai Jual")),

    SG_SUMIF_LAN0101170000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(R_LAN0101170000.key,
                    "16", "20",
                    EFormLaporanBulananTahunan.LTLB_PNYL.getCode(),
                    ER7039PosLtlbDppkPnyl.R_PNYL010000.getObject().getKey(),
                    "PNYL|Nilai Apprasial/wajar - Total")),

    SG_SUMIF_PROP_PPIP(programs(PPMPPPIPK),
            () -> {
                // For Validation Kode Pos LAN0101180000, LAN0101190000, and LAN0101200000
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3")
                        + "$" + ER1250Properti.getPipedReferenceKeys();
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3")
                        + "$" + ER1250Properti.getPipedReferenceKeyValues();
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genMultiCriteriaSumIf(
                        UtilMetadata.genPipeColumnExcept(4, 17, new int[]{14}), UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), 17, 19),
                        EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                        ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                        "12", "18|3", "4", criteriaCondition, sumCriteriaCondition,
                        "2", "PPIP",
                        "PROP|Nilai Appraisal/ Nilai Wajar|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Objek (Tanah/Bangunan/Tanah dan Bangunan)",
                        criteriaConditionErr, sumCriteriaConditionErr, "0");
            }),

    SG_SUMIF_LAN0103010000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(R_LAN0103010000.key,
                    "7", "8",
                    EFormLaporanBulananTahunan.LTLB_KASB.getCode(),
                    ER7041PosLtlbDppkKasb.R_KASB010000.getObject().getKey(),
                    "KASB|Nominal")),

    SG_SUMIF_PIUT_PPIP(programs(PPMPPPIPK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genSumIfFilter(
                        UtilMetadata.genPipeColumnExcept(4, 17, new int[]{14}), UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), 22, 24),
                        EFormLaporanBulananTahunan.LTLB_PIUT.getCode(),
                        ER7042PosLtlbDppkPiut.R_PIUT010000.getObject().getKey(),
                        "6|9|13", "14", "4", criteriaCondition, sumCriteriaCondition,
                        "2", "PPIP",
                        "PIUT|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumCriteriaConditionErr,
                        "Piutang Iuran Pemberi Kerja - Total|Piutang Iuran Peserta - Total|Piutang Iuran Sukarela Peserta");
            }),

    SG_SUMIF_LAN0103060000_PPIP(programs(PPMPPPIPK), () -> {
        String posCode = R_LAN0103060000.key;
        String rangeField = "4#6";
        String criteriaField = "7";
        String formCode = EFormLaporanBulananTahunan.LTLB_PIUB.getCode();
        String formObjects = ER7043PosLtlbDppkPiub.R_PIUB010000.getObject().getKey();
        String errMsg = "PIUB|Piutang Bunga Iuran Peserta dan Piutang Bunga Iuran Tambahan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF";

        String sumField = "4";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidationV2.genSumIfMultiField(UtilMetadata.genPipeColumnExcept(4, 17, new int[]{14}), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                "2", "PPIP",
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }),

    SG_SUMIF_LAN0103070000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(
                    ER7001PosLtlbDppkLan.R_LAN0103070000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_BBMK.getCode(),
                    ER7044PosLtlbDppkBbmk.R_BBMK010000.getObject().getKey(),
                    "BBMK|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_LAN0103080000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(
                    ER7001PosLtlbDppkLan.R_LAN0103080000.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_PIUI.getCode(),
                    ER7045PosLtlbDppkPiui.R_PIUI010000.getObject().getKey(),
                    "PIUI|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),
    SG_SUMIF_LAN0103090000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(
                    ER7001PosLtlbDppkLan.R_LAN0103090000.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_PIHI.getCode(),
                    ER7046PosLtlbDppkPihi.R_PIHI010000.getObject().getKey(),
                    "PIHI|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),
    SG_SUMIF_LAN0103100000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(
                    ER7001PosLtlbDppkLan.R_LAN0103100000.getObject().getKey(), "5", "7",
                    EFormLaporanBulananTahunan.LTLB_PILL.getCode(),
                    ER7047PosLtlbDppkPill.R_PILL010000.getObject().getKey(),
                    "PILL|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),
    SG_SUMIF_LAN0106000000_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(
                    ER7001PosLtlbDppkLan.R_LAN0106000000.getObject().getKey(), "6", "8",
                    EFormLaporanBulananTahunan.LTLB_ASLN.getCode(),
                    ER7053PosLtlbDppkAsln.R_ASLN010000.getObject().getKey(),
                    "ASLN|Nilai Aset|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),
    SG_SUMIF_LAN0108020100_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(
                    ER7001PosLtlbDppkLan.R_LAN0108020100.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_UMPJ.getCode(),
                    ER7054PosLtlbDppkUmpj.R_UMPJ010000.getObject().getKey(),
                    "UMPJ|Total - Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),
    SG_SUMIF_LAN0108020300_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(
                    ER7001PosLtlbDppkLan.R_LAN0108020300.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_UTIN.getCode(),
                    ER7056PosLtlbDppkUtin.R_UTIN010000.getObject().getKey(),
                    "UTIN|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),
    SG_SUMIF_LAN0108020400_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(
                    ER7001PosLtlbDppkLan.R_LAN0108020400.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_PDDM.getCode(),
                    ER7057PosLtlbDppkPddm.R_PDDM010000.getObject().getKey(),
                    "PDDM|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),
    SG_SUMIF_LAN0108020500_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(
                    ER7001PosLtlbDppkLan.R_LAN0108020500.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_BMHB.getCode(),
                    ER7058PosLtlbDppkBmhb.R_BMHB010000.getObject().getKey(),
                    "BMHB|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),
    SG_SUMIF_LAN0108020600_PPIP(programs(PPMPPPIPK),
            () -> sumIfValidationHelper_PPIP(
                    ER7001PosLtlbDppkLan.R_LAN0108020600.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_UTLN.getCode(),
                    ER7059PosLtlbDppkUtln.R_UTLN010000.getObject().getKey(),
                    "UTLN|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    GEN_VALIDATON_FORM_LPAN_PPIP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0111000000.getObject();
        int[] cols = {17};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7002PosLtlbDppkLpan.R_LPAN0500000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("18", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm,
                "2", "PPIP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_PST_PPIP(programs(PPMPPPIPK), () -> {
        String selectExpr = "> 0";
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_PST.getCode();
        KeyValueString comparator = ER7006PosLtlbDppkPst.R_PST0400000000.getObject();
        String comparatorExpr = "> 0";
        String errMsg = comparator.getValue() + "|" + R_LAN0111000000.value;
        return UtilSegmentValidationV2.genEqualsFormConditionalExpression2("18", R_LAN0111000000.key, selectExpr, comparatorForm, "6",
                comparator.getKey(), comparatorExpr, "e",
                "2", "PPIP",
                2, errMsg);
    }),

    GEN_VALIDATON_FORM_KASB_PPIP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0103010000.getObject();
        int[] cols = {7};
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String form = EFormLaporanBulananTahunan.LTLB_KASB.getCode();
        String comparatorPosCode = ER7041PosLtlbDppkKasb.R_KASB000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Nominal pada form " + form;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("18", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, form,
                "2", "PPIP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_LAK_PPIP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0103010000.getObject();
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

    GEN_VALIDATON_FORM_TNBG_PPIP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0104020000.getObject();
        int[] cols = {9};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_TNBG.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorPosCode = ER7048PosLtlbDppkTnbg.R_TNBG000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("18", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, comparatorForm,
                "2", "PPIP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_KNDR_PPIP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0104030000.getObject();
        int[] cols = {8};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_KNDR.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorPosCode = ER7049PosLtlbDppkKndr.R_KNDR000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("18", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, comparatorForm,
                "2", "PPIP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_PKOM_PPIP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0104040000.getObject();
        int[] cols = {7};
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_PKOM.getCode();
        String comparatorPosCode = ER7050PosLtlbDppkPkom.R_PKOM000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("18", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, comparatorForm, errMsg, 2);
    }),

    GEN_VALIDATON_FORM_PKAN_PPIP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0104050000.getObject();
        int[] cols = {7};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_PKAN.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorPosCode = ER7051PosLtlbDppkPkan.R_PKAN000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("18", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, comparatorForm,
                "2", "PPIP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_ASOL_PPIP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0104060000.getObject();
        int[] cols = {7};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ASOL.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        String comparatorPosCode = ER7052PosLtlbDppkAsol.R_ASOL000000.key;
        String errMsg = selectPosCode.getValue() + " | Total Nilai Buku pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("18", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCode, comparatorForm,
                "2", "PPIP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_NRC2_PPIP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0107000000.getObject();
        int[] cols = {17};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_NERACA.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("18", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm,
                "2", "PPIP",
                errMsg, 2);
    }),

    GEN_VALIDATON_FORM_UMPS_PPIP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_LAN0108020200.getObject();
        int[] cols = {5};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_UMPS.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7055PosLtlbDppkUmps.R_UMPS000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("18", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm,
                "2", "PPIP",
                errMsg, 2);
    }),

    /* SHARED PPMP & PPIP VALIDATIONS */

    SG_EQUALS_FORMULA_PERSENTASE_INVESTASI(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genEqualsFormulaLan("3",
                    ER7001PosLtlbDppkLan.R_LAN0102000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), 0, 19),
                    "2", "PPM|PPIP",
                    UtilMetadata.genMessage(ER7001PosLtlbDppkLan.R_LAN0102000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), 0, 19)), 2)),

    SG_PERSENTASE_INVESTASI(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genEqualsRatioLan(
                    "3", UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), 0, 19),
                    UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), 0, 19), "14", R_LAN0102000000.key, "14",
                    "2", "PPMP|PPIP",
                    "TOTAL INVESTASI", 2)),

    SG_ROW_DATA_TYPE_NUMERIC_DOT(programs(PPMPPPIPK), () ->
            UtilSegmentValidation.genRegexNumericDot("3",
                    UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), 0, 20))),

    SG_ROW_DATA_TYPE_NUMERIC(programs(PPMPPPIPK), () ->
            UtilSegmentValidation.genRegexNumeric(UtilMetadata.genPipeColumn(4, 18),
                    UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), 0, 47))),

    SG_ROW_DATA_TYPE_NUMERIC_NEGATIVE(programs(PPMPPPIPK), () ->
            UtilSegmentValidation.genRegexNumericNegative(UtilMetadata.genPipeColumn(4, 18),
                    UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), new int[]{48}))),

    FV_GABUNGAN_EQUALS_EXCEPT(programs(PPMPPPIPK), validationFields(Dppk0001Lan.GABUNGAN),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(
                    UtilMetadata.genPlusColumn(4, 13),
                    UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), new int[]{20, 30, 38, 48}),
                    2)),

    FV_TOTAL_EQUALS_EXCEPT(programs(PPMPPPIPK), validationFields(Dppk0001Lan.TOTAL),
            () -> UtilFieldValidation.genEqualsExceptPosFormulaFilter(
                    UtilMetadata.genPlusColumn(14, 17),
                    UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), new int[]{20, 30, 38, 48}),
                    "2", "PPIP", 2)),

    CR_EXIST_POS_N_PERSENTASE_INVESTASI(programs(PPMPPPIPK), validationFields(2),
            () -> UtilFieldConditional.genExistPos("N", "M",
                    UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK), 21, 48))),

    CR_EXISTS_POS_M(programs(PPMPPPIPK), validationFields(1001, 1002, 1003, 1004),
            () -> UtilFieldConditional.genExistPosAndComparatorHasValue("N", "M",
                    UtilMetadata.genPipeRow(ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK)), "2", "PPMP")),

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

    public static final BaseMetadataValidation<E7001LanGabunganValidationsConfig> VALIDATION_METADATA_PPMPPPIPK =
            new LbltMetadataValidation<>(E7001LanGabunganValidationsConfig.class, PPMPPPIPK);

    private static SegmentValidation sumIfValidationHelper_PPMP(String posCode, String rangeField, String criteriaField, String formCode,
                                                                String formObjects, String errMsg) {
        String sumField = "4";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidationV2.genSumIfFilter(UtilMetadata.genPipeColumn(4, 13), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                "2", "PPMP",
                errMsg + "|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF", criteriaConditionErr, sumCriteriaConditionErr);
    }

    private static SegmentValidation sumIfValidationHelper_PPIP(String posCode, String rangeField, String criteriaField, String formCode,
                                                                String formObjects, String errMsg) {
        String sumField = "4";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidationV2.genSumIfFilter(UtilMetadata.genPipeColumnExcept(4, 17, new int[]{14}), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                "2", "PPIP",
                errMsg + "|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF", criteriaConditionErr, sumCriteriaConditionErr);
    }
}
