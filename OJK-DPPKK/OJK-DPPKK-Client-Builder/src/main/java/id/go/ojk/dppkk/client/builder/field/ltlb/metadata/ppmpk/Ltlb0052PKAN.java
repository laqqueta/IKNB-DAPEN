package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7051PosLtlbDppkPkan;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;


public class Ltlb0052PKAN extends BaseMetadata {

    public Ltlb0052PKAN(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_PKAN;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7051PosLtlbDppkPkan.genFieldSave());
        res.setSavePosForm(ER7051PosLtlbDppkPkan.genFieldSaveForm());
        res.setRequiredPos(ER7051PosLtlbDppkPkan.getRequiredPos());

        res.addSegmentValidations(ER7051PosLtlbDppkPkan.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        
        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7051Pkan.getObject())));

        fs.add(sf(2, null, "Jenis Peralatan Kantor",
                sv(C, 1, 50, alfaNumeric)
                        .confConditionalRequired(ER7051PosLtlbDppkPkan.genConditionForTotal())));

        fs.add(sf(3, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7051PosLtlbDppkPkan.genConditionForTotal())));

        fs.add(sf(4, null, "Nilai Perolehan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(5, null, "Akumulasi Penyusutan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(6, null, "Nilai Buku",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7051PosLtlbDppkPkan.genFieldValidationNilaiBuku()));

        fs.add(sf(7, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7051PosLtlbDppkPkan.genConditionForTotalOptional())));


        return res;
    }
}
