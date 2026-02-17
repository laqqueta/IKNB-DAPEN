package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7013PosLtlbDppkInsp;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7014PosLtlbDppkInpt;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0015INPT extends BaseMetadata {

    public Ltlb0015INPT(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_INPT;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setRequiredPos(ER7014PosLtlbDppkInpt.getRequiredPos());
        res.setSavePos(ER7014PosLtlbDppkInpt.genFieldSave());

        res.addSegmentValidations(ER7014PosLtlbDppkInpt.genValidation());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 10, 10, all)));
        fs.add(sf(2, null, "Nama Pihak", sv(C, 1, 100, freeText)
                .confConditionalRequired(ER7014PosLtlbDppkInpt.genConditionForTotal())));
        fs.add(sf(3, null, "Investasi Jenis", sv(C, 1, 100, freeText)
                .confConditionalRequired(ER7014PosLtlbDppkInpt.genConditionForTotal())));
        fs.add(sf(4, null, "Investasi Jumlah", sv(M, 1, 18, numeric)));
        fs.add(sf(5, null, "Investasi Persentase Terhadap Total Investasi", sv(C, 3, 5, numericDot)
                .confConditionalRequired(ER7014PosLtlbDppkInpt.genConditionForTotal())));
        fs.add(sf(6, null, "Hubungan Afiliasi", sv(C, 1, 100, freeText)
                .confConditionalRequired(ER7014PosLtlbDppkInpt.genConditionForTotal())));
        fs.add(sf(7, null, "Keterangan", sv(C, 1, 250, freeText)
                .confConditionalRequired(ER7014PosLtlbDppkInpt.genConditionForTotalOptional())));

        return res;
    }
}
