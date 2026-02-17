package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7027PosLtlbDppkRsbn;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0028RSBN extends BaseMetadata {

    public Ltlb0028RSBN(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_RSBN;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7027PosLtlbDppkRsbn.genFieldSave());
        res.setRequiredPos(ER7027PosLtlbDppkRsbn.getRequiredPos());

        res.addSegmentValidations(ER7027PosLtlbDppkRsbn.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7027Rsbn.getObject())));

        fs.add(sf(2, null, "Kode Surat Berharga",
                sv(C, 1, 50, alfaNumeric)
                        .confConditionalRequired(ER7027PosLtlbDppkRsbn.genConditionForTotal())));

        fs.add(sf(3, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7027PosLtlbDppkRsbn.genConditionForTotal())));

        fs.add(sf(4, null, "Nilai Nominal",
                sv(M, 1, 18, numeric)));

        fs.add(sf(5, null, "Kupon (%)",
                sv(C, 3, 5, numericDot)
                        .confConditionalRequired(ER7027PosLtlbDppkRsbn.genConditionForTotal())));

        fs.add(sf(6, null, "Tanggal Jatuh Tempo",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7027PosLtlbDppkRsbn.genConditionForTotal()))
                .addFieldValidations(ER7027PosLtlbDppkRsbn.genDateGreaterFieldValidation()));

        fs.add(sf(7, null, "Nilai Perolehan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(8, null, "Nilai Wajar",
                sv(M, 1, 18, numeric)));

        fs.add(sf(9, null, "Selisih Penilaian Investasi Nilai",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7027PosLtlbDppkRsbn.genFieldValidationNilaiInvestasi()));

        fs.add(sf(10, null, "Selisih Penilaian Investasi %",
                sv(C, 3, 5, numericDot)
                        .confConditionalRequired(ER7027PosLtlbDppkRsbn.genConditionForTotal()))
                .addFieldValidations(ER7027PosLtlbDppkRsbn.genFieldValidationPersentaseInvestasi()));

        fs.add(sf(11, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7027PosLtlbDppkRsbn.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(12, null, "Metode Pencatatan",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7027PosLtlbDppkRsbn.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfa)
                        .confReference(EHeaderMetadataShared.R005.getObject())));

        fs.add(sf(13, null, "Pengelolaan Swakelola/ KPD",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7027PosLtlbDppkRsbn.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfa)
                        .confReference(EHeaderMetadataShared.R006.getObject())));

        fs.add(sf(14, null, "Pengelolaan Nama Manajer Investasi",
                sv(C, 1, 250, alfa)
                        .confConditionalRequired(ER7027PosLtlbDppkRsbn.genConditionForTotal())
                        .confConditionalRequired(ER7027PosLtlbDppkRsbn.genConditionNamaPengelola())));

        fs.add(sf(15, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7027PosLtlbDppkRsbn.genConditionForTotalOptional())));


        return res;
    }
}
