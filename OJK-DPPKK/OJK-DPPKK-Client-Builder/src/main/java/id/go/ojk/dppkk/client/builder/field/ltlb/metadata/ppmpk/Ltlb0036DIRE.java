package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7035PosLtlbDppkDire;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0036DIRE extends BaseMetadata {

    public Ltlb0036DIRE(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_DIRE;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7035PosLtlbDppkDire.genFieldSave());
        res.setRequiredPos(ER7035PosLtlbDppkDire.getRequiredPos());

        res.addSegmentValidations(ER7035PosLtlbDppkDire.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        
        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7035Dire.getObject())));

        fs.add(sf(2, null, "Kode",
                sv(C, 1, 20, alfaNumeric)
                        .confConditionalRequired(ER7035PosLtlbDppkDire.genConditionForTotal())));

        fs.add(sf(3, null, "Nama Produk",
                sv(C, 1, 100, freeText)
                        .confConditionalRequired(ER7035PosLtlbDppkDire.genConditionForTotal())));

        fs.add(sf(4, null, "Manajer Investasi",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7035PosLtlbDppkDire.genConditionForTotal())));

        fs.add(sf(5, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7035PosLtlbDppkDire.genConditionForTotal())));

        fs.add(sf(6, null, "Jumlah Unit",
                sv(M, 1, 12, numeric)));

        fs.add(sf(7, null, "Nilai Perolehan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(8, null, "Nilai Wajar",
                sv(M, 1, 18, numeric)));

        fs.add(sf(9, null, "Selisih Penilaian Investasi Nilai",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7035PosLtlbDppkDire.genFieldValidationNilaiInvestasi()));

        fs.add(sf(10, null, "Selisih Penilaian Investasi %",
                sv(C, 4, 6, numericDot)
                        .confConditionalRequired(ER7035PosLtlbDppkDire.genConditionForTotal()))
                .addFieldValidations(ER7035PosLtlbDppkDire.genFieldValidationPersentaseInvestasi()));

        fs.add(sf(11, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7035PosLtlbDppkDire.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(12, null, "Pengelolaan Swakelola/ KPD",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7035PosLtlbDppkDire.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfa)
                        .confReference(EHeaderMetadataShared.R006.getObject())));

        fs.add(sf(13, null, "Pengelolaan Nama Manajer Investasi",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7035PosLtlbDppkDire.genConditionForTotal())
                        .confConditionalRequired(ER7035PosLtlbDppkDire.genConditionNamaPengelola())));

        fs.add(sf(14, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7035PosLtlbDppkDire.genConditionForTotalOptional())));


        return res;
    }
}
