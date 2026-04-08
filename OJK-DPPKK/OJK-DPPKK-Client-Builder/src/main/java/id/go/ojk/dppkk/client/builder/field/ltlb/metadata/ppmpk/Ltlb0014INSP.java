package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7013PosLtlbDppkInsp;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0014INSP extends BaseMetadata {

    public Ltlb0014INSP(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_INSP;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setRequiredPos(ER7013PosLtlbDppkInsp.getRequiredPos());
        res.setSavePos(ER7013PosLtlbDppkInsp.genFieldSave());
        res.setSavePosForm(ER7013PosLtlbDppkInsp.genFieldSave());

//        res.addSegmentValidations(ER7013PosLtlbDppkInsp.genValidation());
//        res.addSegmentValidations(ER7013PosLtlbDppkInsp.genRowValidation());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(O, 10, 10, refTable)
                .confReference(EHeaderMetadataPpmpk.R7013Insp.getObject())
                .confRegex(SimpleValidation.patternAlfaNumeric)));
        fs.add(sf(2, null, "Nama Pihak", sv(O, 1, 100, freeText)
                .confConditionalRequired(ER7013PosLtlbDppkInsp.genConditionForTotal())));
        fs.add(sf(3, null, "Investasi Jenis", sv(O, 1, 100, freeText)
                .confConditionalRequired(ER7013PosLtlbDppkInsp.genConditionForTotal())));

        fs.add(sf(4, null, "Investasi Jumlah", sv(O, 1, 18, numeric)));

        fs.add(sf(5, null, "Investasi Persentase Terhadap Total Investasi", sv(O, 4, 6, numericDot)
                .confConditionalRequired(ER7013PosLtlbDppkInsp.genConditionForTotal())));
        fs.add(sf(6, null, "Batasan Dalam Arahan Investasi", sv(O, 1, 18, numeric)
                .confConditionalRequired(ER7013PosLtlbDppkInsp.genConditionForTotal())));
        fs.add(sf(7, null, "Batasan Investasi Sesuai Ketentuan", sv(O, 1, 18, numeric)
                .confConditionalRequired(ER7013PosLtlbDppkInsp.genConditionForTotalOptional())));

        return res;
    }
}
