package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7041PosLtlbDppkKasb;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0042KASB extends BaseMetadata {

    public Ltlb0042KASB(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_KASB;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7041PosLtlbDppkKasb.genFieldSave());
        res.setSavePosForm(ER7041PosLtlbDppkKasb.genFieldSave());
        res.setRequiredPos(ER7041PosLtlbDppkKasb.getRequiredPos());

        res.addSegmentValidations(ER7041PosLtlbDppkKasb.genValidation());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7041Kasb.getObject())));

        fs.add(sf(2, null, "Nama Bank",
                sv(C, 1, 100, freeText)
                        .confConditionalRequired(ER7041PosLtlbDppkKasb.genConditionForTotalOptional())));

        fs.add(sf(3, null, "Cabang",
                sv(C, 1, 100, freeText)
                        .confConditionalRequired(ER7041PosLtlbDppkKasb.genConditionForTotalOptional())));

        fs.add(sf(4, null, "Kode Bank",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7041PosLtlbDppkKasb.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R011.getObject())));

        fs.add(sf(5, null, "No Rekening",
                sv(C, 1, 20, alfaNumeric)
                        .confConditionalRequired(ER7041PosLtlbDppkKasb.genConditionForTotal())));

        fs.add(sf(6, null, "Nominal",
                sv(M, 1, 18, numeric)));

        fs.add(sf(7, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7041PosLtlbDppkKasb.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(8, null, "Keterangan (Tujuan penggunaan)",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7041PosLtlbDppkKasb.genConditionForTotalOptional())));

        return res;
    }
}
