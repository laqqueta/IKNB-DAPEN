package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7055PosLtlbDppkUmps;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.freeText;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0056UMPS extends BaseMetadata {

    public Ltlb0056UMPS(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_UMPS;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7055PosLtlbDppkUmps.genFieldSave());
        res.setSavePosForm(ER7055PosLtlbDppkUmps.genFieldSaveForm());
        res.setRequiredPos(ER7055PosLtlbDppkUmps.getRequiredPos());

        res.addSegmentValidations(ER7055PosLtlbDppkUmps.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        
        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7055Umps.getObject())));

        fs.add(sf(2, null, "Jumlah <= 1 tahun",
                sv(M, 1, 18, numeric)));

        fs.add(sf(3, null, "Jumlah > 1 tahun",
                sv(M, 1, 18, numeric)));

        fs.add(sf(4, null, "Jumlah Total",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7055PosLtlbDppkUmps.genFieldValidationTotal()));

        fs.add(sf(5, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7055PosLtlbDppkUmps.genConditionForTotalOptional())));


        return res;
    }
}
