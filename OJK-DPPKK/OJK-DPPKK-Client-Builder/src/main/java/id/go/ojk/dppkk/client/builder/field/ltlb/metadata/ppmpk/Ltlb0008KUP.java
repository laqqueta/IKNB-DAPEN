package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.constant.JenisProgram;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7007PosLtlbDppkKup;
import id.go.ojk.lib.client.model.config.UniqueType;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0008KUP extends BaseMetadata {

    public Ltlb0008KUP(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_KUP;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7007PosLtlbDppkKup.genFieldSave(JenisProgram.PPMPK));
        res.setRequiredPos(ER7007PosLtlbDppkKup.getRequiredPos(JenisProgram.PPMPK));
        res.setSavePosForm(ER7007PosLtlbDppkKup.genFieldSave(JenisProgram.PPMPK));

//        ER7007PosLtlbDppkKup.getPpmpkSegmentValidations()
//                .forEach(res::addSegmentValidations);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(O, 13, 13, refTable)
                .confRegex(SimpleValidation.patternAlfaNumeric)
                .confReference(EHeaderMetadataPpmpk.R7007Kup.getObject()))
                /*.confUnique(UniqueType.U)*/);
        fs.add(sf(2, null, "Uraian Tambahan", sv(O, 1, 100, freeText)));
        fs.add(sf(3, null, "Nilai Program Manfaat Pensiun", sv(O, 1, 18, freeText)));
        fs.add(sf(4, null, "Nilai Program Manfaat Pensiun Lainnya", sv(O, 1, 18, freeText)));
        fs.add(sf(5, null, "Nilai Program Manfaat Lain", sv(O, 1, 18, freeText)));

        return res;
    }
}
