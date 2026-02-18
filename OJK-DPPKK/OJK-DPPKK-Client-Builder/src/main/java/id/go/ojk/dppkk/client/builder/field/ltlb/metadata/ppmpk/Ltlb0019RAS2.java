package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7018PosLtlbDppkRas2;
import id.go.ojk.lib.client.model.config.UniqueType;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0019RAS2 extends BaseMetadata {

    public Ltlb0019RAS2(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_RAS_2;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7018PosLtlbDppkRas2.genFieldSave());
        res.setRequiredPos(ER7018PosLtlbDppkRas2.getRequiredPos());

        ER7018PosLtlbDppkRas2.SEGMENTS_VALIDATIONS
                .forEach(res::addSegmentValidations);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 14, 14, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7018Ras2.getObject()))
                .confUnique(UniqueType.U));

        fs.add(sf(2, null, "Realisasi Tahun Sebelumnya",
                sv(C, 1, 18, numeric)
                        .confConditionalRequired(ER7018PosLtlbDppkRas2.genConditionEmpty1())));

        fs.add(sf(3, null, "Anggaran",
                sv(C, 1, 18, all2)
                        .confConditionalRequired(ER7018PosLtlbDppkRas2.genConditionEmpty2())));

        fs.add(sf(4, null, "Realisasi",
                sv(C, 1, 18, all2)
                        .confConditionalRequired(ER7018PosLtlbDppkRas2.genConditionEmpty2())));

        return res;
    }
}
