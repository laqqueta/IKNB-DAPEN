package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7043PosLtlbDppkPiub;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7044PosLtlbDppkBbmk;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0044PIUB extends BaseMetadata {

    public Ltlb0044PIUB(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_PIUB;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7043PosLtlbDppkPiub.genFieldSave());
        res.setRequiredPos(ER7043PosLtlbDppkPiub.getRequiredPos());

        res.addSegmentValidations(ER7043PosLtlbDppkPiub.genValidation());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        
        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7043Piub.getObject())));

        fs.add(sf(2, null, "Nama Pemberi Kerja(Pendiri/Mitra Pendiri)",
                sv(C, 1, 100, freeText)
                        .confConditionalRequired(ER7043PosLtlbDppkPiub.genConditionForTotal())));

        fs.add(sf(3, null, "Piutang Bunga Iuran Peserta",
                sv(M, 1, 18, numeric)));

        fs.add(sf(4, null, "Piutang Bunga Iuran Pemberi Kerja",
                sv(M, 1, 18, numeric)));

        fs.add(sf(5, null, "Piutang Bunga Iuran Tambahan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(6, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7043PosLtlbDppkPiub.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(7, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7043PosLtlbDppkPiub.genConditionForTotalOptional())));


        return res;
    }
}
