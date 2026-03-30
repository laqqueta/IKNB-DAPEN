package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7065PosLtlbDppkBopr;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7068PosLtlbDppkPkpl;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0066BOPR extends BaseMetadata {

    public Ltlb0066BOPR(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_BOPR;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7065PosLtlbDppkBopr.genFieldSave());
        res.setRequiredPos(ER7065PosLtlbDppkBopr.getRequiredPos());
        res.setSavePosForm(ER7065PosLtlbDppkBopr.genFormFieldSave());

        res.addSegmentValidations(ER7065PosLtlbDppkBopr.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        
        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7065Bopr.getObject())));

        fs.add(sf(2, null, "Jenis Beban",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7065PosLtlbDppkBopr.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R018.getObject())));

        fs.add(sf(3, null, "Jumlah",
                sv(M, 1, 18, numeric)));

        fs.add(sf(4, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7065PosLtlbDppkBopr.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(5, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7065PosLtlbDppkBopr.genConditionForTotalOptional())));


        return res;
    }
}
