package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7002PosLtlbDppkLpan;
import id.go.ojk.lib.client.model.config.UniqueType;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0003LPAN extends BaseMetadata {

    public Ltlb0003LPAN(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_LPAN;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 25,  25);

        res.setSavePos(ER7002PosLtlbDppkLpan.genFieldSave());
        res.setRequiredPos(ER7002PosLtlbDppkLpan.getRequiredPos());

        ER7002PosLtlbDppkLpan.SEGMENT_VALIDATIONS.forEach(res::addSegmentValidations);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 14, 14, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7002Lpan.getObject()))
                .confUnique(UniqueType.U));

        fs.add(sf(2, null, "Manfaat Pensiun", sv(M, 1, 18, numericNegatif)));
        fs.add(sf(3, null, "Manfaat Pensiun Lainnya Manfaat Tambahan", sv(M, 1, 18, numericNegatif)));
        fs.add(sf(4, null, "Manfaat Pensiun Lainnya Kompensasi Pascakerja", sv(M, 1, 18, numericNegatif)));
        fs.add(sf(5, null, "Manfaat Pensiun Lainnya Lainnya", sv(M, 1, 18, numericNegatif)));
        fs.add(sf(6, null, "Manfaat Lain Kompensasi Pascakerja", sv(M, 1, 18, numericNegatif)));
        fs.add(sf(7, null, "Manfaat Lain Kesehatan", sv(M, 1, 18, numericNegatif)));
        fs.add(sf(8, null, "Manfaat Lain Santunan Kematian", sv(M, 1, 18, numericNegatif)));
        fs.add(sf(9, null, "Manfaat Lain Ibadah Keagamaan", sv(M, 1, 18, numericNegatif)));
        fs.add(sf(10, null, "Manfaat Lain Pendidikan", sv(M, 1, 18, numericNegatif)));
        fs.add(sf(11, null, "Manfaat Lain Lainnya", sv(M, 1, 18, numericNegatif)));
        fs.add(sf(12, null, "Gabungan", sv(M, 1, 18, numericNegatif))
                .addFieldValidations(ER7002PosLtlbDppkLpan.genFieldValidation1()));
        return res;
    }
}
