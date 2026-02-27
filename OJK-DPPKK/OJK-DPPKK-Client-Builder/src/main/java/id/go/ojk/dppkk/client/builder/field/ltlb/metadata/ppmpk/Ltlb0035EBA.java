package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7034PosLtlbDppkEba;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0035EBA extends BaseMetadata {

    public Ltlb0035EBA(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_EBA;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7034PosLtlbDppkEba.genFieldSave());
        res.setRequiredPos(ER7034PosLtlbDppkEba.getRequiredPos());

        res.addSegmentValidations(ER7034PosLtlbDppkEba.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        
        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 9, 9, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7034Eba.getObject())));

        fs.add(sf(2, null, "Kode",
                sv(C, 1, 20, alfaNumeric)
                        .confConditionalRequired(ER7034PosLtlbDppkEba.genConditionForTotal())));

        fs.add(sf(3, null, "Nama Produk",
                sv(C, 1, 100, freeText)
                        .confConditionalRequired(ER7034PosLtlbDppkEba.genConditionForTotal())));

        fs.add(sf(4, null, "Nama Penerbit",
                sv(C, 1, 100, freeText)
                        .confConditionalRequired(ER7034PosLtlbDppkEba.genConditionForTotal())));

        fs.add(sf(5, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7034PosLtlbDppkEba.genConditionForTotal())));

        fs.add(sf(6, null, "Nilai Nominal",
                sv(M, 1, 18, numeric)));

        fs.add(sf(7, null, "Kupon (%)",
                sv(C, 4, 6, numericDot)
                        .confConditionalRequired(ER7034PosLtlbDppkEba.genConditionForTotal())));

        fs.add(sf(8, null, "Tanggal Jatuh Tempo",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7034PosLtlbDppkEba.genConditionForTotal()))
                .addFieldValidations(ER7034PosLtlbDppkEba.genDateGreaterFieldValidation()));

        fs.add(sf(9, null, "Peringkat Awal",
                sv(C, 1, 10, alfaNumeric)
                        .confConditionalRequired(ER7034PosLtlbDppkEba.genConditionForTotal())));

        fs.add(sf(10, null, "Peringkat Akhir",
                sv(C, 1, 10, alfaNumeric)
                        .confConditionalRequired(ER7034PosLtlbDppkEba.genConditionForTotal())));

        fs.add(sf(11, null, "Nilai Perolehan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(12, null, "Nilai Wajar",
                sv(M, 1, 18, numeric)));

        fs.add(sf(13, null, "Selisih Penilaian Investasi Nilai",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7034PosLtlbDppkEba.genFieldValidationNilaiInvestasi()));

        fs.add(sf(14, null, "Selisih Penilaian Investasi %",
                sv(M, 4, 6, numericDot))
                .addFieldValidations(ER7034PosLtlbDppkEba.genFieldValidationPersentaseInvestasi()));

        fs.add(sf(15, null, "Sektor Ekonomi",
                sv(C, 1, 8, refTable)
                        .confConditionalRequired(ER7034PosLtlbDppkEba.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R007.getObject())));

        fs.add(sf(16, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7034PosLtlbDppkEba.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(17, null, "Pengelolaan Swakelola/ KPD",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7034PosLtlbDppkEba.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfa)
                        .confReference(EHeaderMetadataShared.R006.getObject())));

        fs.add(sf(18, null, "Pengelolaan Nama Manajer Investasi",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7034PosLtlbDppkEba.genConditionForTotal())
                        .confConditionalRequired(ER7034PosLtlbDppkEba.genConditionNamaPengelola())));


        fs.add(sf(19, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7034PosLtlbDppkEba.genConditionForTotalOptional())));


        return res;
    }
}
