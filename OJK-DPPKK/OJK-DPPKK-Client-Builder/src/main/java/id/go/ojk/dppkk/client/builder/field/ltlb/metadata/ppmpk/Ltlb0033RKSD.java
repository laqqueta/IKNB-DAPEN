package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7032PosLtlbDppkRksd;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0033RKSD extends BaseMetadata {

    public Ltlb0033RKSD(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_RKSD;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7032PosLtlbDppkRksd.genFieldSave());
        res.setRequiredPos(ER7032PosLtlbDppkRksd.getRequiredPos());
        res.setSavePosForm(ER7032PosLtlbDppkRksd.getFieldFormSave());

        res.addSegmentValidations(ER7032PosLtlbDppkRksd.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        
        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7032Rksd.getObject())));

        fs.add(sf(2, null, "Kode",
                sv(C, 1, 20, alfaNumeric)
                        .confConditionalRequired(ER7032PosLtlbDppkRksd.genConditionForTotal())));

        fs.add(sf(3, null, "Nama Produk",
                sv(C, 1, 100, freeText)
                        .confConditionalRequired(ER7032PosLtlbDppkRksd.genConditionForTotal())));

        fs.add(sf(4, null, "Jenis Reksa Dana *)",
                sv(C, 1, 6, alfaNumeric)
                        .confConditionalRequired(ER7032PosLtlbDppkRksd.genConditionForTotal())));

        fs.add(sf(5, null, "Manajer Investasi",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7032PosLtlbDppkRksd.genConditionForTotal())));

        fs.add(sf(6, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7032PosLtlbDppkRksd.genConditionForTotal())));

        fs.add(sf(7, null, "Jumlah Unit",
                sv(M, 1, 13, numeric)));

        fs.add(sf(8, null, "Nilai Perolehan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(9, null, "Nilai Wajar",
                sv(M, 1, 18, numeric)));

        fs.add(sf(10, null, "Selisih Penilaian Investasi Nilai",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7032PosLtlbDppkRksd.genFieldValidationNilaiInvestasi()));

        fs.add(sf(11, null, "Selisih Penilaian Investasi %",
                sv(C, 4, 6, numericDot)
                        .confConditionalRequired(ER7032PosLtlbDppkRksd.genConditionForTotal()))
                .addFieldValidations(ER7032PosLtlbDppkRksd.genFieldValidationPersentaseInvestasi()));

        fs.add(sf(12, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7032PosLtlbDppkRksd.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(13, null, "Pengelolaan Swakelola/ KPD",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7032PosLtlbDppkRksd.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfa)
                        .confReference(EHeaderMetadataShared.R006.getObject())));

        fs.add(sf(14, null, "Pengelolaan Nama Manajer Investasi",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7032PosLtlbDppkRksd.genConditionForTotal())
                        .confConditionalRequired(ER7032PosLtlbDppkRksd.genConditionNamaPengelola())));

        fs.add(sf(15, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7032PosLtlbDppkRksd.genConditionForTotalOptional())));



        return res;
    }
}
