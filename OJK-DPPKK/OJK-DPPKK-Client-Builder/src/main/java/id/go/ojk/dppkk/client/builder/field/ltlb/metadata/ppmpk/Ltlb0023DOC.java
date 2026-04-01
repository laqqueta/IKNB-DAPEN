package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7022PosLtlbDppkDoc;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0023DOC extends BaseMetadata {

    public Ltlb0023DOC(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_DOC;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7022PosLtlbDppkDoc.genFieldSave());
        res.setRequiredPos(ER7022PosLtlbDppkDoc.getRequiredPos());
        res.setSavePosForm(ER7022PosLtlbDppkDoc.getFieldFormSave());

        res.addSegmentValidations(ER7022PosLtlbDppkDoc.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 9, 9, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7022Doc.getObject())));

        fs.add(sf(2, null, "Nama Bank",
                sv(C, 1, 100, freeText)
                        .confConditionalRequired(ER7022PosLtlbDppkDoc.genConditionForTotalOptional())));

        fs.add(sf(3, null, "Cabang",
                sv(C, 1, 100, freeText)
                        .confConditionalRequired(ER7022PosLtlbDppkDoc.genConditionForTotalOptional())));

        fs.add(sf(4, null, "Kode Bank",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7022PosLtlbDppkDoc.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R011.getObject())));

        fs.add(sf(5, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7022PosLtlbDppkDoc.genConditionForTotal())));

        fs.add(sf(6, null, "Nilai Nominal",
                sv(M, 1, 18, numeric)));

        fs.add(sf(7, null, "Jangka Waktu (Hari)",
                sv(C, 1, 3, numeric)
                        .confConditionalRequired(ER7022PosLtlbDppkDoc.genConditionForTotal())));

        fs.add(sf(8, null, "Tingkat Bunga/Nisbah (%)",
                sv(C, 4, 6, numericDot)
                        .confConditionalRequired(ER7022PosLtlbDppkDoc.genConditionForTotal())));

        fs.add(sf(9, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7022PosLtlbDppkDoc.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(10, null, "Pengelolaan Swakelola/ KPD",
                sv(C, 1, 6, refTable)
                        .confRegex(SimpleValidation.patternAlfa)
                        .confConditionalRequired(ER7022PosLtlbDppkDoc.genConditionForTotal())
                        .confReference(EHeaderMetadataShared.R006.getObject())));

        fs.add(sf(11, null, "Pengelolaan Nama Manajer Investasi",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7022PosLtlbDppkDoc.genConditionForTotal())
                        .confConditionalRequired(ER7022PosLtlbDppkDoc.genConditionOptional())));

        fs.add(sf(12, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7022PosLtlbDppkDoc.genConditionForTotalOptional())));


        return res;
    }
}
