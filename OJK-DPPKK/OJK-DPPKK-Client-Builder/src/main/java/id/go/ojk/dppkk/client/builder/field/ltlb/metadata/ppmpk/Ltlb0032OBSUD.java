package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7031PosLtlbDppkObsud;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0032OBSUD extends BaseMetadata {

    public Ltlb0032OBSUD(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_OBSUD;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7031PosLtlbDppkObsud.genFieldSave());
        res.setRequiredPos(ER7031PosLtlbDppkObsud.getRequiredPos());

        res.addSegmentValidations(ER7031PosLtlbDppkObsud.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        
        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 11, 11, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7031Obsud.getObject())));

        fs.add(sf(2, null, "Nama Penerbit",
                sv(C, 1, 100, freeText)
                        .confConditionalRequired(ER7031PosLtlbDppkObsud.genConditionForTotal())));

        fs.add(sf(3, null, "Kode Obligasi/ Sukuk Daerah",
                sv(C, 1, 30, alfaNumeric)
                        .confConditionalRequired(ER7031PosLtlbDppkObsud.genConditionForTotal())));

        fs.add(sf(4, null, "Nama Obligasi/ Sukuk Daerah",
                sv(C, 1, 100, freeText)
                        .confConditionalRequired(ER7031PosLtlbDppkObsud.genConditionForTotal())));

        fs.add(sf(5, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7031PosLtlbDppkObsud.genConditionForTotal())));

        fs.add(sf(6, null, "Nilai Nominal",
                sv(M, 1, 18, numeric)));

        fs.add(sf(7, null, "Kupon (%)",
                sv(C, 4, 6, numericDot)
                        .confConditionalRequired(ER7031PosLtlbDppkObsud.genConditionForTotal())));

        fs.add(sf(8, null, "Tanggal Jatuh Tempo",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7031PosLtlbDppkObsud.genConditionForTotal()))
                .addFieldValidations(ER7031PosLtlbDppkObsud.genDateGreaterFieldValidation()));

        fs.add(sf(9, null, "Peringkat Awal",
                sv(C, 1, 10, alfaNumeric)
                        .confConditionalRequired(ER7031PosLtlbDppkObsud.genConditionForTotal())));

        fs.add(sf(10, null, "Peringkat Akhir",
                sv(C, 1, 10, alfaNumeric)
                        .confConditionalRequired(ER7031PosLtlbDppkObsud.genConditionForTotal())));

        fs.add(sf(11, null, "Nilai Perolehan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(12, null, "Nilai Wajar",
                sv(M, 1, 18, numeric)));

        fs.add(sf(13, null, "Selisih Penilaian Investasi Nilai",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7031PosLtlbDppkObsud.genFieldValidationNilaiInvestasi()));

        fs.add(sf(14, null, "Selisih Penilaian Investasi %",
                sv(C, 4, 6, numericDot)
                        .confConditionalRequired(ER7031PosLtlbDppkObsud.genConditionForTotal()))
                .addFieldValidations(ER7031PosLtlbDppkObsud.genFieldValidationPersentaseInvestasi()));

        fs.add(sf(15, null, "Sektor Ekonomi",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7031PosLtlbDppkObsud.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R007.getObject())));

        fs.add(sf(16, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7031PosLtlbDppkObsud.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(17, null, "Metode Pencatatan",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7031PosLtlbDppkObsud.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfa)
                        .confReference(EHeaderMetadataShared.R005.getObject())));

        fs.add(sf(18, null, "Pengelolaan Swakelola/ KPD",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7031PosLtlbDppkObsud.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfa)
                        .confReference(EHeaderMetadataShared.R006.getObject())));

        fs.add(sf(19, null, "Pengelolaan Nama Manajer Investasi",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7031PosLtlbDppkObsud.genConditionForTotal())
                        .confConditionalRequired(ER7031PosLtlbDppkObsud.genConditionNamaPengelola())));

        fs.add(sf(20, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7031PosLtlbDppkObsud.genConditionForTotalOptional())));


        return res;
    }
}
