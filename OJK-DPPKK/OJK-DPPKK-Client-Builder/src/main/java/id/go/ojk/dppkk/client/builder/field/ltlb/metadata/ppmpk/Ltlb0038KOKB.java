package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7037PosLtlbDppkKokb;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7038PosLtlbDppkRepo;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0038KOKB extends BaseMetadata {

    public Ltlb0038KOKB(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_KOKB;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7037PosLtlbDppkKokb.genFieldSave());
        res.setRequiredPos(ER7037PosLtlbDppkKokb.getRequiredPos());

        res.addSegmentValidations(ER7037PosLtlbDppkKokb.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        
        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7037Kokb.getObject())));

        fs.add(sf(2, null, "Nama Emiten",
                sv(C, 1, 100, freeText)
                        .confConditionalRequired(ER7037PosLtlbDppkKokb.genConditionForTotal())));

        fs.add(sf(3, null, "Nama Pembeli",
                sv(C, 1, 100, freeText)
                        .confConditionalRequired(ER7037PosLtlbDppkKokb.genConditionForTotal())));

        fs.add(sf(4, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7037PosLtlbDppkKokb.genConditionForTotal())));

        fs.add(sf(5, null, "Jangka Waktu",
                sv(C, 1, 5, numeric)
                        .confConditionalRequired(ER7037PosLtlbDppkKokb.genConditionForTotal())));

        fs.add(sf(6, null, "Nilai Perolehan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(7, null, "Nilai Wajar",
                sv(M, 1, 18, numeric)));

        fs.add(sf(8, null, "Selisih Penilaian Investasi Nilai",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7037PosLtlbDppkKokb.genFieldValidationNilaiInvestasi()));

        fs.add(sf(9, null, "Selisih Penilaian Investasi %",
                sv(C, 4, 6, numericDot)
                        .confConditionalRequired(ER7037PosLtlbDppkKokb.genConditionForTotal()))
                .addFieldValidations(ER7037PosLtlbDppkKokb.genFieldValidationPersentaseInvestasi()));

        fs.add(sf(10, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7037PosLtlbDppkKokb.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(11, null, "Pengelolaan Swakelola/ KPD",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7037PosLtlbDppkKokb.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfa)
                        .confReference(EHeaderMetadataShared.R006.getObject())));

        fs.add(sf(12, null, "Pengelolaan Nama Manajer Investasi",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7037PosLtlbDppkKokb.genConditionForTotal())
                        .confConditionalRequired(ER7037PosLtlbDppkKokb.genConditionNamaPengelola())));

        fs.add(sf(13, null, "Keterangan",
                sv(O, 1, 250, freeText)
                        .confConditionalRequired(ER7037PosLtlbDppkKokb.genConditionForTotalOptional())));


        return res;
    }
}
