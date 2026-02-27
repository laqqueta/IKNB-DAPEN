package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7008PosLtlbDppkRekinv;
import id.go.ojk.lib.client.model.config.UniqueType;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0009REKINV extends BaseMetadata {

    public Ltlb0009REKINV(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_REKINV;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 24, 24);

        res.setSavePos(ER7008PosLtlbDppkRekinv.genFieldSave());
        res.setRequiredPos(ER7008PosLtlbDppkRekinv.getRequiredPos());

        res.addSegmentValidations(ER7008PosLtlbDppkRekinv.genValidationSumPosColEqual());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 16, 16, refTable)
                .confRegex(SimpleValidation.patternAlfaNumeric)
                .confReference(EHeaderMetadataPpmpk.R7008Rekinv.getObject()))
                .confUnique(UniqueType.U));
        fs.add(sf(2, null, "Jan", sv(M, 1, 18, numeric)));
        fs.add(sf(3, null, "Feb", sv(M, 1, 18, numeric)));
        fs.add(sf(4, null, "Mar", sv(M, 1, 18, numeric)));
        fs.add(sf(5, null, "Apr", sv(M, 1, 18, numeric)));
        fs.add(sf(6, null, "Mei", sv(M, 1, 18, numeric)));
        fs.add(sf(7, null, "Jun", sv(M, 1, 18, numeric)));
        fs.add(sf(8, null, "Jul", sv(M, 1, 18, numeric)));
        fs.add(sf(9, null, "Agu", sv(M, 1, 18, numeric)));
        fs.add(sf(10, null, "Sep", sv(M, 1, 18, numeric)));
        fs.add(sf(11, null, "Okt", sv(M, 1, 18, numeric)));
        fs.add(sf(12, null, "Nov", sv(M, 1, 18, numeric)));
        fs.add(sf(13, null, "Des", sv(M, 1, 18, numeric)));

        return res;
    }
}
