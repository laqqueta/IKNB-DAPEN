package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7015PosLtlbDppkInbm;
import id.go.ojk.lib.client.model.config.UniqueType;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0016INBM extends BaseMetadata {

    public Ltlb0016INBM(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_INBM;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7015PosLtlbDppkInbm.genFieldSave());
        res.setRequiredPos(ER7015PosLtlbDppkInbm.getRequiredPos());

//        res.addSegmentValidations(ER7015PosLtlbDppkInbm.genValidation());
//        res.addSegmentValidations(ER7015PosLtlbDppkInbm.genRowValidation());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(O, 10, 10, refTable)
                .confRegex(SimpleValidation.patternAlfaNumeric)
                .confReference(EHeaderMetadataPpmpk.R7015Inbm.getObject())));
        fs.add(sf(2, null, "Nama Pihak", sv(O, 1, 100, freeText)
                .confConditionalRequired(ER7015PosLtlbDppkInbm.genConditionForTotal())));
        fs.add(sf(3, null, "Investasi Jenis", sv(O, 1, 100, freeText)
                .confConditionalRequired(ER7015PosLtlbDppkInbm.genConditionForTotal())));
        fs.add(sf(4, null, "Investasi Jumlah", sv(O, 1, 18, numeric)));
        fs.add(sf(5, null, "Investasi Persentase Terhadap Total Investasi", sv(O, 4, 6, numericDot)
                .confConditionalRequired(ER7015PosLtlbDppkInbm.genConditionForTotal())));
        fs.add(sf(6, null, "Kategori Bermasalah", sv(O, 1, 250, freeText)
                .confConditionalRequired(ER7015PosLtlbDppkInbm.genConditionForTotal())));
        fs.add(sf(7, null, "Keterangan", sv(O, 1, 250, freeText)
                .confConditionalRequired(ER7015PosLtlbDppkInbm.genConditionForTotalOptional())));

        return res;
    }
}
