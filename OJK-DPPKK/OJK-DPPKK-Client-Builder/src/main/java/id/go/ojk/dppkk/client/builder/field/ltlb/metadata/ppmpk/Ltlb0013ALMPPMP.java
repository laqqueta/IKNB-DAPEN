package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7012PosLtlbDppkAlmppmp;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0013ALMPPMP extends BaseMetadata {

    public Ltlb0013ALMPPMP(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_ALMPPMP;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 51, 51);

        res.setSavePos(ER7012PosLtlbDppkAlmppmp.genFieldSave());
        res.setRequiredPos(ER7012PosLtlbDppkAlmppmp.getRequiredPos());

        res.addSegmentValidations(ER7012PosLtlbDppkAlmppmp.genValidationSumPosColEqual1());
        res.addSegmentValidations(ER7012PosLtlbDppkAlmppmp.genValidationSumPosColEqual2());
        res.addSegmentValidations(ER7012PosLtlbDppkAlmppmp.genValidationSumPosColEqual3());
        res.addSegmentValidations(ER7012PosLtlbDppkAlmppmp.genValidationSumPosColEqual4());

        res.addSegmentValidations(ER7012PosLtlbDppkAlmppmp.genValidationSumPosColEqual5());
        res.addSegmentValidations(ER7012PosLtlbDppkAlmppmp.genValidationSumPosColEqual6());
        res.addSegmentValidations(ER7012PosLtlbDppkAlmppmp.genValidationSumPosColEqual7());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 17, 17, all)));
        fs.add(sf(2, null, "Jatuh tempo < 1 tahun - Rupiah", sv(M, 1, 18, numeric)));
        fs.add(sf(3, null, "Jatuh tempo < 1 tahun - Non Rupiah", sv(M, 1, 18, numeric)));
        fs.add(sf(4, null, "Jatuh tempo < 1 tahun - Total", sv(C, 1, 18, numeric)
                .confConditionalRequired(ER7012PosLtlbDppkAlmppmp.genConditionForPersentase()))
                .addFieldValidations(ER7012PosLtlbDppkAlmppmp.genFieldJtaValidation()));

        fs.add(sf(5, null, "1 tahun <= jatuh tempo < 5 tahun - Rupiah", sv(M, 1, 18, numeric)));
        fs.add(sf(6, null, "1 tahun <= jatuh tempo < 5 tahun - Non Rupiah", sv(M, 1, 18, numeric)));
        fs.add(sf(7, null, "1 tahun <= jatuh tempo < 5 tahun - Total", sv(C, 1, 18, numeric)
                .confConditionalRequired(ER7012PosLtlbDppkAlmppmp.genConditionForPersentase()))
                .addFieldValidations(ER7012PosLtlbDppkAlmppmp.genFieldJtbValidation()));

        fs.add(sf(8, null, "5 tahun <= jatuh tempo < 10 tahun - Rupiah", sv(M, 1, 18, numeric)));
        fs.add(sf(9, null, "5 tahun <= jatuh tempo < 10 tahun - Non Rupiah", sv(M, 1, 18, numeric)));
        fs.add(sf(10, null, "5 tahun <= jatuh tempo < 10 tahun - Total", sv(C, 1, 18, numeric)
                .confConditionalRequired(ER7012PosLtlbDppkAlmppmp.genConditionForPersentase()))
                .addFieldValidations(ER7012PosLtlbDppkAlmppmp.genFieldJtcValidation()));

        fs.add(sf(11, null, "Jatuh Tempo >= 10 Tahun - Rupiah", sv(M, 1, 18, numeric)));
        fs.add(sf(12, null, "Jatuh Tempo >= 10 - Non Rupiah", sv(M, 1, 18, numeric)));
        fs.add(sf(13, null, "Jatuh Tempo >= 10 - Total", sv(C, 1, 18, numeric)
                .confConditionalRequired(ER7012PosLtlbDppkAlmppmp.genConditionForPersentase()))
                .addFieldValidations(ER7012PosLtlbDppkAlmppmp.genFieldJtdValidation()));

        fs.add(sf(14, null, "Total - Rupiah", sv(M, 1, 18, numeric))
                .addFieldValidations(ER7012PosLtlbDppkAlmppmp.genFieldTotal1Validation()));
        fs.add(sf(15, null, "Total - Non Rupiah", sv(M, 1, 18, numeric))
                .addFieldValidations(ER7012PosLtlbDppkAlmppmp.genFieldTotal2Validation()));
        fs.add(sf(16, null, "Total - Total", sv(C, 1, 18, numeric)
                .confConditionalRequired(ER7012PosLtlbDppkAlmppmp.genConditionForPersentase()))
                .addFieldValidations(ER7012PosLtlbDppkAlmppmp.genFieldTotal3Validation()));

        return res;
    }
}
