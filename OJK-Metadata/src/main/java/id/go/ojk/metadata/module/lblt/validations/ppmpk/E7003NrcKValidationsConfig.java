package id.go.ojk.metadata.module.lblt.validations.ppmpk;

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
import static id.go.ojk.metadata.module.lblt.reference.ER7003PosLtlbDppkNrc.getObjects;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7003NrcKValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUMIF_DOC(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101010000.getObject().getKey(), "6", "9",
                    EFormLaporanBulananTahunan.LTLB_DOC.getCode(),
                    ER7022PosLtlbDppkDoc.R_DOC010000.getObject().getKey(),
                    "DOC|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SRDP(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101030000.getObject().getKey(), "6", "9",
                    EFormLaporanBulananTahunan.LTLB_SRDP.getCode(),
                    ER7025PosLtlbDppkSrdp.R_SRDP010000.getObject().getKey(),
                    "SRDP|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SBI(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101040000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_SBI.getCode(),
                    ER7026PosLtlbDppkSbi.R_SBI010000.getObject().getKey(),
                    "SBI|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SHM(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101060000.getObject().getKey(), "6", "11",
                    EFormLaporanBulananTahunan.LTLB_SHM.getCode(),
                    ER7028PosLtlbDppkShm.R_SHM010000.getObject().getKey(),
                    "SHM|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_RSBN(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101050000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_RSBN.getCode(),
                    ER7027PosLtlbDppkRsbn.R_RSBN010000.getObject().getKey(),
                    "RSBN|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SUKUK(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101080000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_SUKUK.getCode(),
                    ER7030PosLtlbDppkSukuk.R_SUKUK010000.getObject().getKey(),
                    "SUKUK|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_OBLI(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101070000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_OBLI.getCode(),
                    ER7029PosLtlbDppkObli.R_OBLI010000.getObject().getKey(),
                    "OBLI|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_OBSUD(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101090000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_OBSUD.getCode(),
                    ER7031PosLtlbDppkObsud.R_OBSUD010000.getObject().getKey(),
                    "OBSUD|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_RKSD(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101100000.getObject().getKey(), "8", "12",
                    EFormLaporanBulananTahunan.LTLB_RKSD.getCode(),
                    ER7032PosLtlbDppkRksd.R_RKSD010000.getObject().getKey(),
                    "RKSD|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_MTN(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101110000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_MTN.getCode(),
                    ER7033PosLtlbDppkMtn.R_MTN010000.getObject().getKey(),
                    "MTN|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_EBA(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101120000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_EBA.getCode(),
                    ER7034PosLtlbDppkEba.R_EBA010000.getObject().getKey(),
                    "EBA|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_DIRE(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101130000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_DIRE.getCode(),
                    ER7035PosLtlbDppkDire.R_DIRE010000.getObject().getKey(),
                    "DIRE|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_DNFRA(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101140000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_DNFRA.getCode(),
                    ER7036PosLtlbDppkDnfra.R_DNFRA010000.getObject().getKey(),
                    "DNFRA|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_KOKB(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101150000.getObject().getKey(), "6", "10",
                    EFormLaporanBulananTahunan.LTLB_KOKB.getCode(),
                    ER7037PosLtlbDppkKokb.R_KOKB010000.getObject().getKey(),
                    "KOKB|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_REPO(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101160000.getObject().getKey(), "10", "17",
                    EFormLaporanBulananTahunan.LTLB_REPO.getCode(),
                    ER7038PosLtlbDppkRepo.R_REPO010000.getObject().getKey(),
                    "REPO|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PNYL(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101170000.getObject().getKey(), "11", "19",
                    EFormLaporanBulananTahunan.LTLB_PNYL.getCode(),
                    ER7039PosLtlbDppkPnyl.R_PNYL010000.getObject().getKey(),
                    "PNYL|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PPIN(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0103000000.getObject().getKey(), "3", "5",
                    EFormLaporanBulananTahunan.LTLB_PPIN.getCode(),
                    ER7060PosLtlbDppkPpin.R_PPIN010000.getObject().getKey(),
                    "PPIN|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PROP(programs(PPMPK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                        + "$" + ER1250Properti.getPipedReferenceKeys();
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                        + "$" + ER1250Properti.getPipedReferenceKeyValues();
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genMultiCriteriaSumIf(
                        UtilMetadata.genPipeColumn(2, 11), UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 17, 19),
                        EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                        ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                        "8", "17|2", "2", criteriaCondition, sumCriteriaCondition,
                        "PROP|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Objek (Tanah/Bangunan/Tanah&Bangunan)",
                        criteriaConditionErr, sumCriteriaConditionErr, "0");
            }),

    SG_SUMIF_PROP_2(programs(PPMPK),
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
                        "9", "17|2", "2", criteriaCondition, sumCriteriaCondition,
                        "PROP|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Objek (Tanah/Bangunan/Tanah&Bangunan)",
                        criteriaConditionErr, sumCriteriaConditionErr, "0");
            }),

    SG_SUMIF_PIUT(programs(PPMPK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genSumIf(
                        UtilMetadata.genPipeColumn(2, 11), UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 24, 26),
                        EFormLaporanBulananTahunan.LTLB_PIUT.getCode(),
                        ER7042PosLtlbDppkPiut.R_PIUT010000.getObject().getKey(),
                        "5|8|12", "13", "2", criteriaCondition, sumCriteriaCondition,
                        "PIUT|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumCriteriaConditionErr,
                        "Piutang Iuran Peserta Total|Piutang Iuran Pemberi Kerja Total|Piutang Iuran Tambahan Total");
            }),

    SG_SUMIF_ASLN(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0108000000.getObject().getKey(), "5", "7",
                    EFormLaporanBulananTahunan.LTLB_ASLN.getCode(),
                    ER7053PosLtlbDppkAsln.R_ASLN010000.getObject().getKey(),
                    "ASLN|Nilai Aset|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_DPJKA_DPJKV(programs(PPMPK),
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
                        UtilMetadata.genPipeColumn(2, 11), ER7003PosLtlbDppkNrc.R_NRC0101020000.getObject().getKey(),
                        comparatorForms, comparatorRows,
                        "6|6", "9|12", "2", criteriaCondition, sumCriteriaCond,
                        "DPJKA|DPJKV|Jumlah Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumConditionErr);
            }),

    SG_EQUALS_FORMULA_1(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0102000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 0, 20),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0102000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 0, 20)))),

    SG_EQUALS_FORMULA_2(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0105000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 23, 32),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0105000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 23, 32)))),

    SG_EQUALS_FORMULA_5(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), new int[]{21, 22, 33, 40, 41}),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), new int[]{21, 22, 33, 40, 41})))),

    SG_EQUALS_FORMULA_6(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0118000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), new int[]{43, 44, 52}),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0118000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), new int[]{43, 44, 52})))),

    SG_EQUALS_GABUNGAN(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0107000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 34, 38) + "-NRC0106060000",
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0107000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 34, 38) + "-'Akumulasi Penyusutan'"))),

    SG_FIELD_TOTAL_7(programs(PPMPK), () -> genTotalValidation(R_NRC0106010000.key,
            EFormLaporanBulananTahunan.LTLB_TNBG,
            ER7048PosLtlbDppkTnbg.getObjects(),
            "6", "Nilai Perolehan", "Total")),

    SG_FIELD_TOTAL_8(programs(PPMPK), () -> genTotalValidation(R_NRC0106020000.key,
            EFormLaporanBulananTahunan.LTLB_KNDR,
            ER7049PosLtlbDppkKndr.getObjects(),
            "5", "Nilai Perolahan", "Total")),

    SG_FIELD_TOTAL_9(programs(PPMPK), () -> genTotalValidation(R_NRC0106030000.key,
            EFormLaporanBulananTahunan.LTLB_PKOM,
            ER7050PosLtlbDppkPkom.getObjects(),
            "4", "Nilai Perolehan", "Total")),

    SG_FIELD_TOTAL_10(programs(PPMPK), () -> genTotalValidation(R_NRC0106040000.key,
            EFormLaporanBulananTahunan.LTLB_PKAN,
            ER7051PosLtlbDppkPkan.getObjects(),
            "4", "Nilai Perolehan", "Total")),

    SG_FIELD_TOTAL_11(programs(PPMPK), () -> genTotalValidation(R_NRC0106050000.key,
            EFormLaporanBulananTahunan.LTLB_ASOL,
            ER7052PosLtlbDppkAsol.getObjects(),
            "4", "Nilai Perolehan", "Total")),

    SG_MULTI_SUM_NRC0106060000(programs(PPMPK), () -> {
        FormulaParserData operation = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(ER7048PosLtlbDppkTnbg.getObjects(), "1", "7", EFormLaporanBulananTahunan.LTLB_TNBG.getCode()),
                genFormulaParser(ER7049PosLtlbDppkKndr.getObjects(), "1", "6", EFormLaporanBulananTahunan.LTLB_KNDR.getCode()),
                genFormulaParser(ER7050PosLtlbDppkPkom.getObjects(), "1", "5", EFormLaporanBulananTahunan.LTLB_PKOM.getCode()),
                genFormulaParser(ER7051PosLtlbDppkPkan.getObjects(), "1", "5", EFormLaporanBulananTahunan.LTLB_PKAN.getCode()),
                genFormulaParser(ER7052PosLtlbDppkAsol.getObjects(), "1", "5", EFormLaporanBulananTahunan.LTLB_ASOL.getCode()),
        }, "+|+|+|+");

        String operationFormErr = "sama dengan Total Penjumlahan Kolom 'Akumulasi Penyusutan' pada form TNBG, KNDR, PKOM, PKAN, dan ASOL";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("12", R_NRC0106060000.key, operation.getFormula(), operationFormErr);
    }),

    GEN_VALIDATON_FORM_LAK(programs(PPMPK), () -> {
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

    GEN_VALIDATON_FORM_UMPS(programs(PPMPK), () -> {
        KeyValueString selectPosCode = R_NRC0115020000.getObject();
        int[] cols = {4};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_UMPS.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7055PosLtlbDppkUmps.R_UMPS000000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("12", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm, errMsg, 2);
    }),

    SG_EQUALS_FORM_FORMULA_LAN_1(programs(PPMPK), () -> genEqualsForm("2", "3")),
    SG_EQUALS_FORM_FORMULA_LAN_2(programs(PPMPK), () -> genEqualsForm("3", "4")),
    SG_EQUALS_FORM_FORMULA_LAN_3(programs(PPMPK), () -> genEqualsForm("4", "5")),
    SG_EQUALS_FORM_FORMULA_LAN_4(programs(PPMPK), () -> genEqualsForm("5", "6")),
    SG_EQUALS_FORM_FORMULA_LAN_5(programs(PPMPK), () -> genEqualsForm("6", "7")),
    SG_EQUALS_FORM_FORMULA_LAN_6(programs(PPMPK), () -> genEqualsForm("7", "8")),
    SG_EQUALS_FORM_FORMULA_LAN_7(programs(PPMPK), () -> genEqualsForm("8", "9")),
    SG_EQUALS_FORM_FORMULA_LAN_8(programs(PPMPK), () -> genEqualsForm("9", "10")),
    SG_EQUALS_FORM_FORMULA_LAN_9(programs(PPMPK), () -> genEqualsForm("10", "11")),
    SG_EQUALS_FORM_FORMULA_LAN_10(programs(PPMPK), () -> genEqualsForm("11", "12")),

    SG_ROW_DATA_TYPE_NUMERIC(programs(PPMPK), () ->
            UtilSegmentValidation.genRegexNumeric(UtilMetadata.genPipeColumn(2, 12),
                    UtilMetadata.genPipeRowExcept(getObjects(PPMPK), new int[] { 40 }))),

    SG_ROW_DATA_TYPE_NUMERIC_NEGATIVE(programs(PPMPK), () ->
            UtilSegmentValidation.genRegexNumericNegative(UtilMetadata.genPipeColumn(2, 12),
                    UtilMetadata.genPipeRow(getObjects(PPMPK), new int[] { 40 }))),

    FV_EQUALS_EXCEPT(programs(PPMPK), validationFields(12),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(
                    UtilMetadata.genPlusColumn(2, 11),
                    UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), new int[]{21, 33, 40, 42}),
                    2));

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

    public static final BaseMetadataValidation<E7003NrcKValidationsConfig> VALIDATION_METADATA_PPMPK =
            new LbltMetadataValidation<>(E7003NrcKValidationsConfig.class, PPMPK);

    private static SegmentValidation genEqualsForm(String selectField, String formComparatorField) {
        String msg = UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0104010000.getObject().getValue(),
                ER7001PosLtlbDppkLan.R_LAN0103010000.getObject().getValue());

        return UtilSegmentValidationV2.genEqualsForm(selectField, R_NRC0104010000.getObject().getKey(),
                EFormLaporanBulananTahunan.LTLB_LAN.getCode(), formComparatorField,
                ER7001PosLtlbDppkLan.R_LAN0103010000.getObject().getKey(), msg + " pada form LAN");
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
                                                        String comparatorFields, String fieldErrorMessage, String rowErrorMessage) {


        FormulaParserData operation2 = genFormulaParser(formObject,
                "1", /* 0 :: baris detail | 1 :: baris total
                                    kalo validasi lama ganti 1 biar langsung nembak ke baris total */
                comparatorFields, comparatorForm.getCode());

        String errMsg = "sama dengan 'Total' Kolom '" + fieldErrorMessage + "' pada Form " + comparatorForm.getCode();

        return UtilSegmentValidationV2.genFormulaParserValidationV2("12", selectPosCode, operation2.getFormula(),
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
