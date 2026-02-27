package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7016PosLtlbDppkSbn;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0017SBN extends BaseMetadata {

    public Ltlb0017SBN(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_SBN;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setRequiredPos(ER7016PosLtlbDppkSbn.getRequiredPos());
        res.setSavePos(ER7016PosLtlbDppkSbn.genFieldSave());
        res.setSavePosForm(ER7016PosLtlbDppkSbn.genFieldSave());

        res.addSegmentValidations(ER7016PosLtlbDppkSbn.genValidation());
        res.addSegmentValidations(ER7016PosLtlbDppkSbn.genRowValidation());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 9, 9, all)));

        fs.add(sf(2, null, "Jenis Investasi", sv(C, 1, 6, refTable)
                .confRegex(SimpleValidation.patternAlfaNumeric)
                .confReference(EHeaderMetadataShared.R022.getObject())
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForTotal())));

        fs.add(sf(3, null, "Nama Jenis Investasi", sv(C, 1, 100, freeText)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForTotal())));

        fs.add(sf(4, null, "Seri Efek", sv(C, 1, 100, freeText)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForTotal())));

        fs.add(sf(5, null, "Jenis Kepemilikan", sv(C, 1, 100, freeText)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForTotal())));

        fs.add(sf(6, null, "Rating", sv(C, 1, 100, freeText)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForTotal())));

        fs.add(sf(7, null, "Menajer Investasi", sv(C, 1, 100, freeText)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForTotal())));

        fs.add(sf(8, null, "Nilai Wajar", sv(C, 1, 18, numeric)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForTotal())));

        fs.add(sf(9, null, "% SBN dalam Reksadana", sv(C, 4, 6, numericDot)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForSaldo())));

        fs.add(sf(10, null, "Saldo", sv(C, 1, 18, numeric)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForSbn())));

        fs.add(sf(11, null, "Emiten Penerima Dana/Project", sv(C, 1, 100, alfa)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForTotal())));

        return res;
    }
}
