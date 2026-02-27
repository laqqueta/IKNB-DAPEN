package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7028PosLtlbDppkShm;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0029SHM extends BaseMetadata {

    public Ltlb0029SHM(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_SHM;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7028PosLtlbDppkShm.genFieldSave());
        res.setRequiredPos(ER7028PosLtlbDppkShm.getRequiredPos());

        res.addSegmentValidations(ER7028PosLtlbDppkShm.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        
        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 9, 9, refTable)   // length follows original java code
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7028Shm.getObject())));

        fs.add(sf(2, null, "Kode Saham",
                sv(C, 1, 4, alfaNumeric)
                        .confConditionalRequired(ER7028PosLtlbDppkShm.genConditionForTotal())));

        fs.add(sf(3, null, "Nama Emiten /Penerbit",
                sv(C, 1, 100, freeText)
                        .confConditionalRequired(ER7028PosLtlbDppkShm.genConditionForTotal())));

        fs.add(sf(4, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7028PosLtlbDppkShm.genConditionForTotal())));

        fs.add(sf(5, null, "Jumlah Saham",
                sv(M, 1, 13, numeric)));

        fs.add(sf(6, null, "Nilai Perolehan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(7, null, "Nilai Pasar",
                sv(M, 1, 18, numeric)));

        fs.add(sf(8, null, "Selisih Penilaian Investasi Nilai",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7028PosLtlbDppkShm.genFieldValidationNilaiInvestasi()));

        fs.add(sf(9, null, "Selisih Penilaian Investasi %",
                sv(C, 4, 6, numericDot)
                        .confConditionalRequired(ER7028PosLtlbDppkShm.genConditionForTotal()))
                .addFieldValidations(ER7028PosLtlbDppkShm.genFieldValidationPersentaseInvestasi()));

        fs.add(sf(10, null, "Sektor Ekonomi",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7028PosLtlbDppkShm.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R007.getObject())));

        fs.add(sf(11, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7028PosLtlbDppkShm.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(12, null, "Pengelolaan Swakelola/ KPD",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7028PosLtlbDppkShm.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfa)
                        .confReference(EHeaderMetadataShared.R006.getObject())));

        fs.add(sf(13, null, "Pengelolaan Nama Manajer Investasi",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7028PosLtlbDppkShm.genConditionForTotal())
                        .confConditionalRequired(ER7028PosLtlbDppkShm.genConditionNamaPengelola())));

        fs.add(sf(14, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7028PosLtlbDppkShm.genConditionForTotalOptional())));


        return res;
    }
}
