package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7026PosLtlbDppkSbi;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0027SBI extends BaseMetadata {

    public Ltlb0027SBI(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_SBI;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7026PosLtlbDppkSbi.genFieldSave());
        res.setRequiredPos(ER7026PosLtlbDppkSbi.getRequiredPos());
        res.setSavePosForm(ER7026PosLtlbDppkSbi.getFieldFormSave());

        res.addSegmentValidations(ER7026PosLtlbDppkSbi.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 9, 9, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7026Sbi.getObject())));

        fs.add(sf(2, null, "Kode Surat Berharga",
                sv(C, 1, 50, freeText)
                        .confConditionalRequired(ER7026PosLtlbDppkSbi.genConditionForTotal())));

        fs.add(sf(3, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7026PosLtlbDppkSbi.genConditionForTotal())));

        fs.add(sf(4, null, "Nilai Nominal",
                sv(M, 1, 18, numeric)));

        fs.add(sf(5, null, "Kupon (%)",
                sv(C, 4, 6, numericDot)
                        .confConditionalRequired(ER7026PosLtlbDppkSbi.genConditionForTotal())));

        fs.add(sf(6, null, "Tanggal Jatuh Tempo",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7026PosLtlbDppkSbi.genConditionForTotal()))
                .addFieldValidations(ER7026PosLtlbDppkSbi.genDateGreaterFieldValidation()));

        fs.add(sf(7, null, "Nilai Perolehan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(8, null, "Nilai Wajar",
                sv(M, 1, 18, numeric)));

        fs.add(sf(9, null, "Selisih Penilaian Investasi Nilai",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7026PosLtlbDppkSbi.genFieldValidationNilaiInvestasi()));

        fs.add(sf(10, null, "Selisih Penilaian Investasi %",
                sv(C, 4, 6, numericDot)
                        .confConditionalRequired(ER7026PosLtlbDppkSbi.genConditionForTotal()))
                .addFieldValidations(ER7026PosLtlbDppkSbi.genFieldValidationPersentaseInvestasi()));

        fs.add(sf(11, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7026PosLtlbDppkSbi.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(12, null, "Pengelolaan Swakelola/ KPD",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7026PosLtlbDppkSbi.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfa)
                        .confReference(EHeaderMetadataShared.R006.getObject())));

        fs.add(sf(13, null, "Pengelolaan Nama Manajer Investasi",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7026PosLtlbDppkSbi.genConditionForTotal())
                        .confConditionalRequired(ER7026PosLtlbDppkSbi.genConditionNamaPengelola())));

        fs.add(sf(14, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7026PosLtlbDppkSbi.genConditionForTotalOptional())));


        return res;
    }
}
