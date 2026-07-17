package id.go.ojk.metadata.module.lblt.validations.dplk;

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

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;

import static id.go.ojk.conf.client.UtilMetadata.genFormulaParser;
import static id.go.ojk.metadata.module.lblt.reference.ER7003PosLtlbDppkNrc.*;
import static id.go.ojk.metadata.module.lblt.reference.ER7045PosLtlbDppkPiui.R_PIUI000000;
import static id.go.ojk.metadata.module.lblt.reference.ER7045PosLtlbDppkPiui.R_PIUI010000;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.DPLK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7003NrcKValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUMIF_DOC(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101010000.getObject().getKey(), "6", "9",
                    EFormLaporanBulananTahunan.LTLB_DOC.getCode(),
                    ER7022PosLtlbDppkDoc.R_DOC010000.getObject().getKey(),
                    "DOC|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SRDP(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101030000.getObject().getKey(), "6", "9",
                    EFormLaporanBulananTahunan.LTLB_SRDP.getCode(),
                    ER7025PosLtlbDppkSrdp.R_SRDP010000.getObject().getKey(),
                    "SRDP|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SBI(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101040000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_SBI.getCode(),
                    ER7026PosLtlbDppkSbi.R_SBI010000.getObject().getKey(),
                    "SBI|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_RSBN(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101050000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_RSBN.getCode(),
                    ER7027PosLtlbDppkRsbn.R_RSBN010000.getObject().getKey(),
                    "RSBN|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SHM(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101060000.getObject().getKey(), "6", "11",
                    EFormLaporanBulananTahunan.LTLB_SHM.getCode(),
                    ER7028PosLtlbDppkShm.R_SHM010000.getObject().getKey(),
                    "SHM|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_SUKUK(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101080000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_SUKUK.getCode(),
                    ER7030PosLtlbDppkSukuk.R_SUKUK010000.getObject().getKey(),
                    "SUKUK|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_OBLI(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101070000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_OBLI.getCode(),
                    ER7029PosLtlbDppkObli.R_OBLI010000.getObject().getKey(),
                    "OBLI|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_OBSUD(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101090000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_OBSUD.getCode(),
                    ER7031PosLtlbDppkObsud.R_OBSUD010000.getObject().getKey(),
                    "OBSUD|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_RKSD(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101100000.getObject().getKey(), "8", "12",
                    EFormLaporanBulananTahunan.LTLB_RKSD.getCode(),
                    ER7032PosLtlbDppkRksd.R_RKSD010000.getObject().getKey(),
                    "RKSD|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_MTN(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101110000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_MTN.getCode(),
                    ER7033PosLtlbDppkMtn.R_MTN010000.getObject().getKey(),
                    "MTN|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_EBA(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101120000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_EBA.getCode(),
                    ER7034PosLtlbDppkEba.R_EBA010000.getObject().getKey(),
                    "EBA|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_DIRE(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101130000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_DIRE.getCode(),
                    ER7035PosLtlbDppkDire.R_DIRE010000.getObject().getKey(),
                    "DIRE|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_DNFRA(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101140000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_DNFRA.getCode(),
                    ER7036PosLtlbDppkDnfra.R_DNFRA010000.getObject().getKey(),
                    "DNFRA|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_KOKB(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101150000.getObject().getKey(), "6", "10",
                    EFormLaporanBulananTahunan.LTLB_KOKB.getCode(),
                    ER7037PosLtlbDppkKokb.R_KOKB010000.getObject().getKey(),
                    "KOKB|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_REPO(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101160000.getObject().getKey(), "10", "17",
                    EFormLaporanBulananTahunan.LTLB_REPO.getCode(),
                    ER7038PosLtlbDppkRepo.R_REPO010000.getObject().getKey(),
                    "REPO|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PNYL(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101170000.getObject().getKey(), "11", "19",
                    EFormLaporanBulananTahunan.LTLB_PNYL.getCode(),
                    ER7039PosLtlbDppkPnyl.R_PNYL010000.getObject().getKey(),
                    "PNYL|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PPIN(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0103000000.getObject().getKey(), "3", "5",
                    EFormLaporanBulananTahunan.LTLB_PPIN.getCode(),
                    ER7060PosLtlbDppkPpin.R_PPIN010000.getObject().getKey(),
                    "PPIN|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PROP(programs(DPLK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                        + "$" + ER1250Properti.getPipedReferenceKeys();
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                        + "$" + ER1250Properti.getPipedReferenceKeyValues();
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genMultiCriteriaSumIf(
                        UtilMetadata.genPipeColumn(2, 11), UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.DPLK), 17, 19),
                        EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                        ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                        "8", "17|2", "2", criteriaCondition, sumCriteriaCondition,
                        "PROP|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Objek (Tanah/Bangunan/Tanah&Bangunan)",
                        criteriaConditionErr, sumCriteriaConditionErr, "0");
            }),

    SG_SUMIF_PROP_2(programs(DPLK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                        + "$" + ER1250Properti.getKey("2005");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                        + "$" + ER1250Properti.getKeyValue("2005");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genMultiCriteriaSumIf(
                        UtilMetadata.genPipeColumn(2, 11), R_NRC0101210000.key,
                        EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                        ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                        "8", "17|2", "2", criteriaCondition, sumCriteriaCondition,
                        "PROP|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Objek (Tanah/Bangunan/Tanah&Bangunan)",
                        criteriaConditionErr, sumCriteriaConditionErr, "0");
            }),

    SG_SUMIF_BBMK(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0104020000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_BBMK.getCode(),
                    ER7044PosLtlbDppkBbmk.R_BBMK010000.getObject().getKey(),
                    "BBMK|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PIUI(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0104020100.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PIUI.getCode(),
                    ER7045PosLtlbDppkPiui.R_PIUI010000.getObject().getKey(),
                    "PIUI|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PIHI(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0104020200.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PIHI.getCode(),
                    ER7046PosLtlbDppkPihi.R_PIHI010000.getObject().getKey(),
                    "PIHI|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PILL(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0104020300.getObject().getKey(), "4", "6",
                    EFormLaporanBulananTahunan.LTLB_PILL.getCode(),
                    ER7047PosLtlbDppkPill.R_PILL010000.getObject().getKey(),
                    "PILL|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_ASLN(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0106000000.getObject().getKey(), "4", "6",
                    EFormLaporanBulananTahunan.LTLB_ASLN.getCode(),
                    ER7053PosLtlbDppkAsln.R_ASLN010000.getObject().getKey(),
                    "ASLN|Nilai Aset|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_UMPJ(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0108020000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_UMPJ.getCode(),
                    ER7054PosLtlbDppkUmpj.R_UMPJ010000.getObject().getKey(),
                    "UMPJ|Total|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_UTIN(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0108040000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_UTIN.getCode(),
                    ER7056PosLtlbDppkUtin.R_UTIN010000.getObject().getKey(),
                    "UTIN|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PDDM(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0108050000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PDDM.getCode(),
                    ER7057PosLtlbDppkPddm.R_PDDM010000.getObject().getKey(),
                    "PDDM|Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_BMHB(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0108050000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_BMHB.getCode(),
                    ER7058PosLtlbDppkBmhb.R_BMHB010000.getObject().getKey(),
                    "BMHB|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_UTLN(programs(DPLK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0108070000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_UTLN.getCode(),
                    ER7059PosLtlbDppkUtln.R_UTLN010000.getObject().getKey(),
                    "UTLN|Nilai|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_EQUALS_FORMULA_1(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0102000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.DPLK), 0, 20),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0102000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.DPLK), 0, 20)))),

    SG_EQUALS_FORMULA_2(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0105000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.DPLK), 23, 27),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0105000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.DPLK), 23, 27)))),

    SG_EQUALS_FORMULA_3(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0107000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.DPLK), new int[]{21, 22, 28, 29}),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0107000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.DPLK), new int[]{21, 22, 28, 29})))),

    SG_EQUALS_FORMULA_4(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0108010400.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.DPLK), 31, 33),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0108010400.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.DPLK), 31, 33)))),

    SG_EQUALS_FORMULA_5(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.DPLK), 35, 40),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.DPLK), 35, 40)))),

    SG_EQUALS_FORMULA_6(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0110000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.DPLK), new int[]{34, 41}),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0110000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.DPLK), new int[]{34, 41})))),

    SG_TOTAL_LIABILITAS_EQ(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula("12", R_NRC0107000000.key, R_NRC0110000000.key,
                    UtilMetadata.genMessageTotal(R_NRC0107000000.value, R_NRC0110000000.value))),

    GEN_VALIDATON_FORM_LAK(programs(DPLK), () -> {
        KeyValueString selectPosCode = R_NRC0104010000.getObject();
        int[] cols = {12};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7005PosLtlbDppkLak.R_LAK0900000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("12", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm, errMsg, 2);
    }),

    GEN_VALIDATON_FORM_ALM(programs(DPLK), () -> {
        KeyValueString selectPosCode = R_NRC0108010400.getObject();
        int[] cols = {16};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7012PosLtlbDppkAlm.R_ALM0600000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("12", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm, errMsg, 2);
    }),

    FV_EQUALS_EXCEPT_1(programs(DPLK), validationFields(Dppk0003Nrc.GABUNGAN),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(
                    UtilMetadata.genPlusColumn(2, 11),
                    UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.DPLK), new int[]{21}),2)),

    FV_GREATER(programs(DPLK), validationFieldsDelimited(UtilMetadata.genPipeColumn(2, 12), "|"),
            () -> UtilFieldValidation.genPosGreaterValue(R_NRC0108010400.getObject().getKey(), "0")),

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

    public static final BaseMetadataValidation<E7003NrcKValidationsConfig> VALIDATION_METADATA_DPLK =
            new LbltMetadataValidation<>(E7003NrcKValidationsConfig.class, DPLK);

    private static SegmentValidation genEqualsForm(String selectField, String formComparatorField, KeyValueString form, KeyValueString comparatorForm, String msg) {
        return UtilSegmentValidationV2.genEqualsForm(selectField, form.getKey(),
                EFormLaporanBulananTahunan.LTLB_LAN.getCode(), formComparatorField, comparatorForm.getKey(), msg);
    }

    private static SegmentValidation sumIfValidationHelper(String posCode, String rangeField, String criteriaField, String formCode,
                                                           String formObjects, String errMsg) {
        String sumField = "2";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidationV2.genSumIf(UtilMetadata.genPipeColumn(2, 11), posCode,
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

        return UtilSegmentValidationV2.genFormulaParserValidationV2("16", selectPosCode, operation2.getFormula(),
                errMsg);
    }

    public static List<SegmentValidation> additionalSegmentLan() {
        int maxField = 16;
        KeyValueString[] kvsForm = {R_NRC0104010000.getObject(), R_NRC0108030000.getObject()};
        KeyValueString[] kvsComparator = {ER7001PosLtlbDppkLan.R_LAN0103010000.getObject(), ER7001PosLtlbDppkLan.R_LAN0107010200.getObject()};
        String msg;

        List<SegmentValidation> segmentValidations = new ArrayList<>();

        for (int i = 0; i < kvsForm.length; i++) {
            for (int j = 2; j < maxField; j++) {
                if (j == 12) j++;
                else {
                    msg = UtilMetadata.genMessage(kvsForm[i].getValue(), kvsComparator[i].getValue()) + " pada form LAN";
                    segmentValidations.add(genEqualsForm(String.valueOf(j), String.valueOf(j + 1), kvsForm[i], kvsComparator[i], msg));
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
