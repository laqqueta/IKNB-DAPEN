package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7053PosLtlbDppkAsln;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7054PosLtlbDppkUmpj;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0054ASLN extends BaseMetadata {

    public Ltlb0054ASLN(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_ASLN;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7053PosLtlbDppkAsln.genFieldSave());
        res.setRequiredPos(ER7053PosLtlbDppkAsln.getRequiredPos());
        res.setSavePosForm(ER7053PosLtlbDppkAsln.getFieldFormSave());

        res.addSegmentValidations(ER7053PosLtlbDppkAsln.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7053Asln.getObject())));

        fs.add(sf(2, null, "Jenis Aset Lain",
                sv(C, 1, 50, alfaNumeric)
                        .confConditionalRequired(ER7053PosLtlbDppkAsln.genConditionForTotal())));

        fs.add(sf(3, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7053PosLtlbDppkAsln.genConditionForTotal())));

        fs.add(sf(4, null, "Tanggal Reklasifikasi menjadi Aset Lain",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7053PosLtlbDppkAsln.genConditionForTotal())));

        fs.add(sf(5, null, "Nilai Aset",
                sv(M, 1, 18, numeric)));

        fs.add(sf(6, null, "Pencatatan Sebelum Menjadi Aset Lain",
                sv(C, 1, 100, alfaNumeric)
                        .confConditionalRequired(ER7053PosLtlbDppkAsln.genConditionForTotal())));

        fs.add(sf(7, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7053PosLtlbDppkAsln.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(8, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7053PosLtlbDppkAsln.genConditionForTotalOptional())));

        return res;
    }
}
