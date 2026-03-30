package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7001PosLtlbDppkLan;
import id.go.ojk.lib.client.model.config.UniqueType;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

public class Ltlb0002LAN extends BaseMetadata {

    public Ltlb0002LAN(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_LAN;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 49, 49);

        res.setSavePos(ER7001PosLtlbDppkLan.genFieldSave());
        res.setSavePosForm(ER7001PosLtlbDppkLan.genFieldSave());
        res.setRequiredPos(ER7001PosLtlbDppkLan.getRequiredPos());

//        res.addSegmentValidations(ER7001PosLtlbDppkLan.getTestVal());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen",
                sv(O, 13, 13, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7001Lan.getObject()))
                .confUnique(UniqueType.U));
        fs.add(sf(2, null, "Persentase Investasi", sv(O, 4, 6, numericDot)));
        fs.add(sf(3, null, "Manfaat Pensiun", sv(O, 1, 18, numeric)));
        fs.add(sf(4, null, "Manfaat Pensiun Lainnya Manfaat Tambahan", sv(O, 1, 18, numeric)));
        fs.add(sf(5, null, "Manfaat Pensiun Lainnya Kompensasi Pascakerja", sv(O, 1, 18, numeric)));
        fs.add(sf(6, null, "Manfaat Pensiun Lainnya Lainnya", sv(O, 1, 18, numeric)));
        fs.add(sf(7, null, "Manfaat Lain Kompensasi Pascakerja", sv(O, 1, 18, numeric)));
        fs.add(sf(8, null, "Manfaat Lain Kesehatan", sv(O, 1, 18, numeric)));
        fs.add(sf(9, null, "Manfaat Lain Santunan Kematian", sv(O, 1, 18, numeric)));
        fs.add(sf(10, null, "Manfaat Lain Ibadah Keagamaan", sv(O, 1, 18, numeric)));
        fs.add(sf(11, null, "Manfaat Lain Pendidikan", sv(O, 1, 18, numeric)));
        fs.add(sf(12, null, "Manfaat Lain Lainnya", sv(O, 1, 18, numeric)));
        fs.add(sf(13, null, "Gabungan", sv(O, 1, 18, numeric)));

        return res;
    }
}
