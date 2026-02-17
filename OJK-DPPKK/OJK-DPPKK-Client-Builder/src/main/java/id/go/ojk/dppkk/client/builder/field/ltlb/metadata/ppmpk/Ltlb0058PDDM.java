package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7057PosLtlbDppkPddm;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7059PosLtlbDppkUtln;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0058PDDM extends BaseMetadata {

    public Ltlb0058PDDM(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_PDDM;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7057PosLtlbDppkPddm.genFieldSave());
        res.setRequiredPos(ER7057PosLtlbDppkPddm.getRequiredPos());

        res.addSegmentValidations(ER7057PosLtlbDppkPddm.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        
        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7057Pddm.getObject())));

        fs.add(sf(2, null, "Rincian Pendapatan Diterima Di Muka",
                sv(C, 1, 100, alfaNumeric)
                        .confConditionalRequired(ER7057PosLtlbDppkPddm.genConditionForTotal())));

        fs.add(sf(3, null, "Pihak",
                sv(C, 1, 100, alfaNumeric)
                        .confConditionalRequired(ER7057PosLtlbDppkPddm.genConditionForTotal())));

        fs.add(sf(4, null, "Nilai",
                sv(M, 1, 18, numeric)));

        fs.add(sf(5, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7057PosLtlbDppkPddm.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(6, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7057PosLtlbDppkPddm.genConditionForTotalOptional())));


        return res;
    }
}
