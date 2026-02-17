package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7011PosLtlbDppkRoism;
import id.go.ojk.lib.client.model.config.UniqueType;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0012ROISM extends BaseMetadata {

    public Ltlb0012ROISM(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_ROI_S_M;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 21, 21);

        res.setSavePos(ER7011PosLtlbDppkRoism.genFieldSave());
        res.setRequiredPos(ER7011PosLtlbDppkRoism.getRequiredPos());

        res.addSegmentValidations(ER7011PosLtlbDppkRoism.genValidationSumPosColEqual());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 15, 15, refTable)
                .confReference(EHeaderMetadataPpmpk.R7010Roiml.getObject())
                .confRegex(SimpleValidation.patternAlfaNumeric))
                .confUnique(UniqueType.U));
        fs.add(sf(2, null, "Hasil investasi yang terealisasi Bunga/ Bagi Hasil", sv(M, 1, 18, numeric)));
        fs.add(sf(3, null, "Hasil investasi yang terealisasi Dividen", sv(M, 1, 18, numeric)));
        fs.add(sf(4, null, "Hasil investasi yang terealisasi Sewa", sv(M, 1, 18, numeric)));
        fs.add(sf(5, null, "Hasil investasi yang terealisasi Laba/Rugi Pelepasan", sv(M, 1, 18, numeric)));
        fs.add(sf(6, null, "Hasil investasi yang terealisasi Lainnya", sv(M, 1, 18, numeric)));
        fs.add(sf(7, null, "Hasil Investasi yang Belum Terealisasi", sv(M, 1, 18, numeric)));
        fs.add(sf(8, null, "Beban Investasi", sv(M, 1, 18, numeric)));
        fs.add(sf(9, null, "Hasil investasi bersih", sv(M, 1, 18, numeric))
                .addFieldValidations(ER7011PosLtlbDppkRoism.genFieldValidation1()));
        fs.add(sf(10, null, "Rata-rata Investasi", sv(M, 1, 18, numeric)));
        fs.add(sf(11, null, "ROI", sv(M, 1, 18, numeric))
                .addFieldValidations(ER7011PosLtlbDppkRoism.genFieldValidation2()));

        return res;
    }
}
