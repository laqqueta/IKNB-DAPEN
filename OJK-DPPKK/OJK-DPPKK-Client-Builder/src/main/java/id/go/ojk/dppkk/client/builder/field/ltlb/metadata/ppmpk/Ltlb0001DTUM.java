package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7000PosLtlbDppkDtum;
import id.go.ojk.lib.client.model.config.UniqueType;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

public class Ltlb0001DTUM extends BaseMetadata {

    public Ltlb0001DTUM(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_DTUM;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 60, 60);

        res.setRequiredPos(ER7000PosLtlbDppkDtum.getRequiredPos());

        ER7000PosLtlbDppkDtum.SEGMENT_VALIDATIONS.forEach(res::addSegmentValidations);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 10, 10, refTable)
                .confRegex(SimpleValidation.patternAlfaNumeric)
                .confReference(EHeaderMetadataPpmpk.R7000Dtum.getObject()))
                .confUnique(UniqueType.U));
        fs.add(sf(2, null, "Field", sv(M, 1, 100, all2)));
        fs.add(sf(3, null, "Keterangan", sv(M, 1, 1000, all2)));

        return res;
    }
}
