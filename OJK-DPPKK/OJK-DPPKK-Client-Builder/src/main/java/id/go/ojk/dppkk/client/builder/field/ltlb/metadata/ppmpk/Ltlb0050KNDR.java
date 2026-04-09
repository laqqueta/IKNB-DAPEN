package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7049PosLtlbDppkKndr;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0050KNDR extends BaseMetadata {

    public Ltlb0050KNDR(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_KNDR;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7049PosLtlbDppkKndr.genFieldSave());
        res.setSavePosForm(ER7049PosLtlbDppkKndr.genFieldSaveForm());
        res.setRequiredPos(ER7049PosLtlbDppkKndr.getRequiredPos());

        res.addSegmentValidations(ER7049PosLtlbDppkKndr.genValidation());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7049Kndr.getObject())));

        fs.add(sf(2, null, "No Plat Kendaraan",
                sv(C, 1, 10, alfaNumeric)
                        .confConditionalRequired(ER7049PosLtlbDppkKndr.genConditionForTotal())));

        fs.add(sf(3, null, "Jenis Kendaraan",
                sv(C, 1, 50, alfaNumeric)
                        .confConditionalRequired(ER7049PosLtlbDppkKndr.genConditionForTotal())));

        fs.add(sf(4, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7049PosLtlbDppkKndr.genConditionForTotal())));

        fs.add(sf(5, null, "Nilai Perolehan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(6, null, "Akumulasi Penyusutan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(7, null, "Nilai Buku",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7049PosLtlbDppkKndr.genFieldValidationNilaiBuku()));

        fs.add(sf(8, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7049PosLtlbDppkKndr.genConditionForTotalOptional())));


        return res;
    }
}
