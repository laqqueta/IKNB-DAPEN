package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7010PosLtlbDppkRoiml;
import id.go.ojk.lib.client.model.config.UniqueType;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

public class Ltlb0011ROIML extends BaseMetadata {

    public Ltlb0011ROIML(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_ROI_ML;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 21, 21);

        res.setSavePos(ER7010PosLtlbDppkRoiml.genFieldSave());
        res.setSavePosForm(ER7010PosLtlbDppkRoiml.genFieldSaveForm());
        res.setRequiredPos(ER7010PosLtlbDppkRoiml.getRequiredPos());

//        res.addSegmentValidations(ER7010PosLtlbDppkRoiml.genValidationSumPosColEqual());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(O, 15, 15, refTable)
                .confReference(EHeaderMetadataPpmpk.R7010Roiml.getObject())
                .confRegex(SimpleValidation.patternAlfaNumeric))
                .confUnique(UniqueType.U));
        fs.add(sf(2, null, "Hasil investasi yang terealisasi Bunga/ Bagi Hasil", sv(O, 1, 18, numeric)));
        fs.add(sf(3, null, "Hasil investasi yang terealisasi Dividen", sv(O, 1, 18, numeric)));
        fs.add(sf(4, null, "Hasil investasi yang terealisasi Sewa", sv(O, 1, 18, numeric)));
        fs.add(sf(5, null, "Hasil investasi yang terealisasi Laba/Rugi Pelepasan", sv(O, 1, 18, numeric)));
        fs.add(sf(6, null, "Hasil investasi yang terealisasi Lainnya", sv(O, 1, 18, numeric)));
        fs.add(sf(7, null, "Hasil Investasi yang Belum Terealisasi", sv(O, 1, 18, numeric)));
        fs.add(sf(8, null, "Beban Investasi", sv(O, 1, 18, numeric)));
        fs.add(sf(9, null, "Hasil investasi bersih", sv(O, 1, 18, numeric))
                .addFieldValidations(ER7010PosLtlbDppkRoiml.genFieldValidation1()));
        fs.add(sf(10, null, "Rata-rata Investasi", sv(O, 1, 18, numeric)));
        fs.add(sf(11, null, "ROI", sv(O, 3, 18, numericDot))
                .addFieldValidations(ER7010PosLtlbDppkRoiml.genFieldValidation2()));

        return res;
    }
}
