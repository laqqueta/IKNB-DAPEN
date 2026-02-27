package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7058PosLtlbDppkBmhb;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0059BMHB extends BaseMetadata {

    public Ltlb0059BMHB(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_BMHB;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7058PosLtlbDppkBmhb.genFieldSave());
        res.setRequiredPos(ER7058PosLtlbDppkBmhb.getRequiredPos());

        res.addSegmentValidations(ER7058PosLtlbDppkBmhb.genValidation());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7058Bmhb.getObject())));

        fs.add(sf(2, null, "Rincian Pendapatan Diterima Di Muka",
                sv(C, 1, 100, alfaNumeric)
                        .confConditionalRequired(ER7058PosLtlbDppkBmhb.genConditionForTotal())));

        fs.add(sf(3, null, "Pihak",
                sv(C, 1, 100, alfaNumeric)
                        .confConditionalRequired(ER7058PosLtlbDppkBmhb.genConditionForTotal())));

        fs.add(sf(4, null, "Nilai",
                sv(M, 1, 18, numeric)));

        fs.add(sf(5, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7058PosLtlbDppkBmhb.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(6, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7058PosLtlbDppkBmhb.genConditionForTotalOptional())));


        return res;
    }
}
