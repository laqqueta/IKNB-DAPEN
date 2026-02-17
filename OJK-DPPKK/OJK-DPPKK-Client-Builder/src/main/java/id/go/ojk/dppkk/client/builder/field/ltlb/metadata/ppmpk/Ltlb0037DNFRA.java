package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7036PosLtlbDppkDnfra;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7037PosLtlbDppkKokb;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0037DNFRA extends BaseMetadata {

    public Ltlb0037DNFRA(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_DNFRA;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7036PosLtlbDppkDnfra.genFieldSave());
        res.setRequiredPos(ER7036PosLtlbDppkDnfra.getRequiredPos());

        res.addSegmentValidations(ER7036PosLtlbDppkDnfra.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        
        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 11, 11, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7036Dnfra.getObject())));

        fs.add(sf(2, null, "Kode",
                sv(C, 1, 50, alfaNumeric)
                        .confConditionalRequired(ER7036PosLtlbDppkDnfra.genConditionForTotal())));

        fs.add(sf(3, null, "Nama Produk",
                sv(C, 1, 100, alfaNumeric)
                        .confConditionalRequired(ER7036PosLtlbDppkDnfra.genConditionForTotal())));

        fs.add(sf(4, null, "Manajer Investasi",
                sv(C, 1, 250, alfaNumeric)
                        .confConditionalRequired(ER7036PosLtlbDppkDnfra.genConditionForTotal())));

        fs.add(sf(5, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7036PosLtlbDppkDnfra.genConditionForTotal())));

        fs.add(sf(6, null, "Jumlah Unit",
                sv(M, 1, 5, numeric)));

        fs.add(sf(7, null, "Nilai Perolehan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(8, null, "Nilai Aktiva Bersih",
                sv(M, 1, 18, numeric)));

        fs.add(sf(9, null, "Selisih Penilaian Investasi Nilai",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7036PosLtlbDppkDnfra.genFieldValidationNilaiInvestasi()));

        fs.add(sf(10, null, "Selisih Penilaian Investasi %",
                sv(C, 3, 5, numericDot)
                        .confConditionalRequired(ER7036PosLtlbDppkDnfra.genConditionForTotal()))
                .addFieldValidations(ER7036PosLtlbDppkDnfra.genFieldValidationPersentaseInvestasi()));

        fs.add(sf(11, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7036PosLtlbDppkDnfra.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(12, null, "Pengelolaan Swakelola/ KPD",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7036PosLtlbDppkDnfra.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfa)
                        .confReference(EHeaderMetadataShared.R006.getObject())));

        fs.add(sf(13, null, "Pengelolaan Nama Manajer Investasi",
                sv(C, 1, 250, alfa)
                        .confConditionalRequired(ER7036PosLtlbDppkDnfra.genConditionForTotal())
                        .confConditionalRequired(ER7036PosLtlbDppkDnfra.genConditionNamaPengelola())));

        fs.add(sf(14, null, "Keterangan",
                sv(O, 1, 250, freeText)
                        .confConditionalRequired(ER7036PosLtlbDppkDnfra.genConditionForTotalOptional())));



        return res;
    }
}
