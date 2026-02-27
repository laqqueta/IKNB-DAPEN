package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7024PosLtlbDppkDpjkv;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0025DPJKV extends BaseMetadata {

    public Ltlb0025DPJKV(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_DPJKV;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7024PosLtlbDppkDpjkv.genFieldSave());
        res.setRequiredPos(ER7024PosLtlbDppkDpjkv.getRequiredPos());

        res.addSegmentValidations(ER7024PosLtlbDppkDpjkv.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 11, 11, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7024Dpjkv.getObject())));

        fs.add(sf(2, null, "Nama Bank",
                sv(C, 1, 32, alfaNumeric)
                        .confConditionalRequired(ER7024PosLtlbDppkDpjkv.genConditionForTotal())));

        fs.add(sf(3, null, "Kode Bank",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7024PosLtlbDppkDpjkv.genConditionForTotalOptional())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R011.getObject())));

        fs.add(sf(4, null, "Cabang",
                sv(C, 1, 100, freeText)
                        .confConditionalRequired(ER7024PosLtlbDppkDpjkv.genConditionForTotalOptional())));

        fs.add(sf(5, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7024PosLtlbDppkDpjkv.genConditionForTotal())));

        fs.add(sf(6, null, "Nilai Nominal",
                sv(M, 1, 18, numeric)));

        fs.add(sf(7, null, "Nilai Wajar",
                sv(M, 1, 18, numeric)));

        fs.add(sf(8, null, "Selisih Penilaian Investasi Nilai",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7024PosLtlbDppkDpjkv.genFieldValidation()));

        fs.add(sf(9, null, "Selisih Penilaian Investasi %",
                sv(C, 4, 6, numericDot)
                        .confConditionalRequired(ER7024PosLtlbDppkDpjkv.genConditionForTotal()))
                .addFieldValidations(ER7024PosLtlbDppkDpjkv.genFieldValidationPercentage()));

        fs.add(sf(10, null, "Jangka Waktu (Hari)",
                sv(C, 1, 3, numeric)
                        .confConditionalRequired(ER7024PosLtlbDppkDpjkv.genConditionForTotal())));

        fs.add(sf(11, null, "Tingkat Bunga/Nisbah (%)",
                sv(C, 4, 6, numericDot)
                        .confConditionalRequired(ER7024PosLtlbDppkDpjkv.genConditionForTotal())));

        fs.add(sf(12, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7024PosLtlbDppkDpjkv.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(13, null, "Pengelolaan Swakelola/ KPD",
                sv(C, 1, 6, refTable)
                        .confRegex(SimpleValidation.patternAlfa)
                        .confConditionalRequired(ER7024PosLtlbDppkDpjkv.genConditionForTotal())
                        .confReference(EHeaderMetadataShared.R006.getObject())));

        fs.add(sf(14, null, "Pengelolaan Nama Manajer Investasi",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7024PosLtlbDppkDpjkv.genConditionForTotal())
                        .confConditionalRequired(ER7024PosLtlbDppkDpjkv.genConditionOptional())));

        fs.add(sf(15, null, "Jenis Mata Uang",
                sv(C, 1, 8, refTable)
                        .confConditionalRequired(ER7024PosLtlbDppkDpjkv.genConditionForTotal())
                        .confRegex(SimpleValidation.PATTERN_REFERENCE_3)
                        .confReference(EHeaderMetadataShared.R010.getObject())));

        fs.add(sf(16, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7024PosLtlbDppkDpjkv.genConditionForTotalOptional())));


        return res;
    }
}
