package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7021PosLtlbDppkTbdsp;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0022TBDSP extends BaseMetadata {

    public Ltlb0022TBDSP(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_TBDSP;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7021PosLtlbDppkTbdsp.genFieldSave());
        res.setRequiredPos(ER7021PosLtlbDppkTbdsp.getRequiredPos());

//        ER7021PosLtlbDppkTbdsp.SEGMENTS_VALIDATION.forEach(res::addSegmentValidations);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(O, 15, 15, refTable)
                .confRegex(SimpleValidation.patternAlfaNumeric)
                .confReference(EHeaderMetadataPpmpk.R7021Tbdsp.getObject())));
        fs.add(sf(2, null, "Uraian", sv(O, 1, 100, freeText)
                .confConditionalRequired(ER7021PosLtlbDppkTbdsp.genConditionEmpty())));
        fs.add(sf(3, null, "Jumlah", sv(O, 1, 18, numeric)));
        fs.add(sf(4, null, "keterangan", sv(O, 1, 250, freeText)));

        return res;
    }
}
