package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7006PosLtlbDppkPst;
import id.go.ojk.lib.client.model.config.UniqueType;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

public class Ltlb0007PST extends BaseMetadata {

    public Ltlb0007PST(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_PST;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 19, 19);

        res.setSavePos(ER7006PosLtlbDppkPst.genFieldSave());
        res.setRequiredPos(ER7006PosLtlbDppkPst.getRequiredPos());

        ER7006PosLtlbDppkPst.SEGMENT_VALIDATIONS.forEach(res::addSegmentValidations);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 13, 13, refTable)
                .confReference(EHeaderMetadataPpmpk.R7006Pst.getObject())
                .confRegex(SimpleValidation.patternAlfaNumeric))
                .confUnique(UniqueType.U));
        fs.add(sf(2, null, "Manfaat Pensiun", sv(M, 1, 18, numeric)));
        fs.add(sf(3, null, "Manfaat Pensiun Lainnya", sv(M, 1, 18, numeric)));
        fs.add(sf(4, null, "Manfaat  lain", sv(M, 1, 18, numeric)));
        fs.add(sf(5, null, "Jumlah", sv(M, 1, 18, numeric))
                .addFieldValidations(ER7006PosLtlbDppkPst.genFieldValidationSumRow()));

        return res;
    }
}
