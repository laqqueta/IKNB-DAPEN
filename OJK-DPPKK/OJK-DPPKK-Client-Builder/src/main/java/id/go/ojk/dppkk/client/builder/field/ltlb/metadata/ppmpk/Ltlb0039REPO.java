package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7038PosLtlbDppkRepo;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7040PosLtlbDppkProp;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0039REPO extends BaseMetadata {

    public Ltlb0039REPO(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_REPO;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7038PosLtlbDppkRepo.genFieldSave());
        res.setRequiredPos(ER7038PosLtlbDppkRepo.getRequiredPos());

        res.addSegmentValidations(ER7038PosLtlbDppkRepo.genValidation());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        
        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7038Repo.getObject())));

        fs.add(sf(2, null, "Counterparty",
                sv(C, 1, 100, alfaNumeric)
                        .confConditionalRequired(ER7038PosLtlbDppkRepo.genConditionForTotal())));

        fs.add(sf(3, null, "Jenis Jaminan (SBN/SBI/OBL)",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7038PosLtlbDppkRepo.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfa)
                        .confReference(EHeaderMetadataShared.R015.getObject())));

        fs.add(sf(4, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7038PosLtlbDppkRepo.genConditionForTotal())));

        fs.add(sf(5, null, "Nilai Jaminan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(6, null, "Peringkat Awal",
                sv(C, 1, 10, alfaNumeric)
                        .confConditionalRequired(ER7038PosLtlbDppkRepo.genConditionForTotal())));

        fs.add(sf(7, null, "Peringkat Akhir",
                sv(C, 1, 10, alfaNumeric)
                        .confConditionalRequired(ER7038PosLtlbDppkRepo.genConditionForTotal())));

        fs.add(sf(8, null, "Jangka Waktu(hari)",
                sv(C, 1, 5, numeric)
                        .confConditionalRequired(ER7038PosLtlbDppkRepo.genConditionForTotal())));

        fs.add(sf(9, null, "Kategori (KSEI/BIS4)",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7038PosLtlbDppkRepo.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R014.getObject())));

        fs.add(sf(10, null, "Nilai Perolehan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(11, null, "Margin(nominal) Nominal",
                sv(M, 1, 18, numeric)));

        fs.add(sf(12, null, "Margin(nominal) %",
                sv(C, 3, 5, numericDot)
                        .confConditionalRequired(ER7038PosLtlbDppkRepo.genConditionForTotal())));

        fs.add(sf(13, null, "Amortized Cost",
                sv(M, 1, 18, numeric)));

        fs.add(sf(14, null, "Nilai Jual",
                sv(M, 1, 18, numeric)));

        fs.add(sf(15, null, "Selisih Penilaian Investasi Nilai",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7038PosLtlbDppkRepo.genFieldValidationNilaiInvestasi()));

        fs.add(sf(16, null, "Selisih Penilaian Investasi %",
                sv(C, 3, 5, numericDot)
                        .confConditionalRequired(ER7038PosLtlbDppkRepo.genConditionForTotal()))
                .addFieldValidations(ER7038PosLtlbDppkRepo.genFieldValidationPersentaseInvestasi()));

        fs.add(sf(17, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7038PosLtlbDppkRepo.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(18, null, "Pengelolaan Swakelola/ KPD",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7038PosLtlbDppkRepo.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfa)
                        .confReference(EHeaderMetadataShared.R006.getObject())));

        fs.add(sf(19, null, "Pengelolaan Nama Manajer Investasi",
                sv(C, 1, 250, alfaNumeric)
                        .confConditionalRequired(ER7038PosLtlbDppkRepo.genConditionForTotal())
                        .confConditionalRequired(ER7038PosLtlbDppkRepo.genConditionNamaPengelola())));

        fs.add(sf(20, null, "Keterangan",
                sv(O, 1, 250, freeText)
                        .confConditionalRequired(ER7038PosLtlbDppkRepo.genConditionForTotalOptional())));


        return res;
    }
}
