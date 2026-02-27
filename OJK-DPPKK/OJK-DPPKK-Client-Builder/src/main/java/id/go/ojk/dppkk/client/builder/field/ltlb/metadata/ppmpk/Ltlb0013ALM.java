package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7012PosLtlbDppkAlm;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0013ALM extends BaseMetadata {

    public Ltlb0013ALM(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_ALM;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 52, 52);

        res.setSavePos(ER7012PosLtlbDppkAlm.genFieldSave());
        res.setRequiredPos(ER7012PosLtlbDppkAlm.getRequiredPos());

        res.addSegmentValidations(ER7012PosLtlbDppkAlm.genValidationSumPosColEqual1());
        res.addSegmentValidations(ER7012PosLtlbDppkAlm.genValidationSumPosColEqual2());
        res.addSegmentValidations(ER7012PosLtlbDppkAlm.genValidationSumPosColEqual3());
        res.addSegmentValidations(ER7012PosLtlbDppkAlm.genValidationSumPosColEqual4());

        res.addSegmentValidations(ER7012PosLtlbDppkAlm.genValidationSumPosColEqual5());
        res.addSegmentValidations(ER7012PosLtlbDppkAlm.genValidationSumPosColEqual6());
        res.addSegmentValidations(ER7012PosLtlbDppkAlm.genValidationSumPosColEqual7());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 17, 17, all)));
        fs.add(sf(2, null, "Jatuh tempo < 1 tahun - Rupiah", sv(M, 1, 18, numeric)));
        fs.add(sf(3, null, "Jatuh tempo < 1 tahun - Non Rupiah", sv(M, 1, 18, numeric)));
        fs.add(sf(4, null, "Jatuh tempo < 1 tahun - Total", sv(C, 1, 18, numeric)
                .confConditionalRequired(ER7012PosLtlbDppkAlm.genConditionForPersentase()))
                .addFieldValidations(ER7012PosLtlbDppkAlm.genFieldJtaValidation()));

        fs.add(sf(5, null, "1 tahun <= jatuh tempo < 5 tahun - Rupiah", sv(M, 1, 18, numeric)));
        fs.add(sf(6, null, "1 tahun <= jatuh tempo < 5 tahun - Non Rupiah", sv(M, 1, 18, numeric)));
        fs.add(sf(7, null, "1 tahun <= jatuh tempo < 5 tahun - Total", sv(C, 1, 18, numeric)
                .confConditionalRequired(ER7012PosLtlbDppkAlm.genConditionForPersentase()))
                .addFieldValidations(ER7012PosLtlbDppkAlm.genFieldJtbValidation()));

        fs.add(sf(8, null, "5 tahun <= jatuh tempo < 10 tahun - Rupiah", sv(M, 1, 18, numeric)));
        fs.add(sf(9, null, "5 tahun <= jatuh tempo < 10 tahun - Non Rupiah", sv(M, 1, 18, numeric)));
        fs.add(sf(10, null, "5 tahun <= jatuh tempo < 10 tahun - Total", sv(C, 1, 18, numeric)
                .confConditionalRequired(ER7012PosLtlbDppkAlm.genConditionForPersentase()))
                .addFieldValidations(ER7012PosLtlbDppkAlm.genFieldJtcValidation()));

        fs.add(sf(11, null, "Jatuh Tempo >= 10 Tahun - Rupiah", sv(M, 1, 18, numeric)));
        fs.add(sf(12, null, "Jatuh Tempo >= 10 - Non Rupiah", sv(M, 1, 18, numeric)));
        fs.add(sf(13, null, "Jatuh Tempo >= 10 - Total", sv(C, 1, 18, numeric)
                .confConditionalRequired(ER7012PosLtlbDppkAlm.genConditionForPersentase()))
                .addFieldValidations(ER7012PosLtlbDppkAlm.genFieldJtdValidation()));

        fs.add(sf(14, null, "Total - Rupiah", sv(M, 1, 18, numeric))
                .addFieldValidations(ER7012PosLtlbDppkAlm.genFieldTotal1Validation()));
        fs.add(sf(15, null, "Total - Non Rupiah", sv(M, 1, 18, numeric))
                .addFieldValidations(ER7012PosLtlbDppkAlm.genFieldTotal2Validation()));
        fs.add(sf(16, null, "Total - Total", sv(C, 1, 18, numeric)
                .confConditionalRequired(ER7012PosLtlbDppkAlm.genConditionForPersentase()))
                .addFieldValidations(ER7012PosLtlbDppkAlm.genFieldTotal3Validation()));

        return res;
    }
}
