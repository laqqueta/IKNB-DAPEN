package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7017PosLtlbDppkRas1;
import id.go.ojk.lib.client.model.config.UniqueType;

public class Ltlb0018RAS1 extends BaseMetadata {
    public Ltlb0018RAS1(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {
        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_RAS_1;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
            extension, 60, 60);

        res.setRequiredPos(ER7017PosLtlbDppkRas1.genRequiredPos());
        res.setUniquePos(ER7017PosLtlbDppkRas1.genUniquePos());
        res.setSavePos(ER7017PosLtlbDppkRas1.genFieldSave());

        res.addSegmentValidations(ER7017PosLtlbDppkRas1.genValidationTypeInteger());
        res.addSegmentValidations(ER7017PosLtlbDppkRas1.genValidationTypeDecimal());

        ER7017PosLtlbDppkRas1.genAllValidationRatioAB().forEach(res::addSegmentValidations);

        /* -- ANTAR FORM -- */
        res.addSegmentValidations(ER7017PosLtlbDppkRas1.genRowValidation02A());
//        res.addSegmentValidations(ER7017PosLtlbDppkRas1.genRowValidation02B());
//        res.addSegmentValidations(ER7017PosLtlbDppkRas1.genRowValidation02C());
        res.addSegmentValidations(ER7017PosLtlbDppkRas1.genRowValidation03A());
        res.addSegmentValidations(ER7017PosLtlbDppkRas1.genRowValidation03B());
        res.addSegmentValidations(ER7017PosLtlbDppkRas1.genRowValidation05A());
//        res.addSegmentValidations(ER7017PosLtlbDppkRas1.genRowValidation05B());
//        res.addSegmentValidations(ER7017PosLtlbDppkRas1.genRowValidation05C());
        res.addSegmentValidations(ER7017PosLtlbDppkRas1.genRowValidation06A());
        res.addSegmentValidations(ER7017PosLtlbDppkRas1.genRowValidation06B());
        res.addSegmentValidations(ER7017PosLtlbDppkRas1.genRowValidation06C());

        List<SubmissionField> fs = res.getFields();
        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 14, 14, refTable)
            .confRegex(SimpleValidation.patternAlfaNumeric)
            .confReference(EHeaderMetadataPpmpk.R7017Ras1.getObject()))
            .confUnique(UniqueType.U));
        fs.add(sf(2, null, "Manfaat Pensiun", sv(M, 1, 18, all2))
            .addFieldValidations(ER7017PosLtlbDppkRas1.genFieldValidation03A()));
        fs.add(sf(3, null, "Manfaat Pensiun Lainnya", sv(M, 1, 18, all2)));
        fs.add(sf(4, null, "Manfaat lain", sv(M, 1, 18, all2)));
        fs.add(sf(5, null, "Total", sv(C, 1, 18, all2)
            .confConditionalRequired(ER7017PosLtlbDppkRas1.genConditionalTotalMustEmpty()))
            .addFieldValidations(ER7017PosLtlbDppkRas1.genFieldValidation06A())
            .addFieldValidations(ER7017PosLtlbDppkRas1.genFieldValidation06B()));
        return res;
    }
}
