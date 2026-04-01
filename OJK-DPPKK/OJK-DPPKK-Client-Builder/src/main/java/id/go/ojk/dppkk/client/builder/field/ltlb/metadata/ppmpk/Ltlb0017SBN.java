package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7016PosLtlbDppkSbn;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.lib.client.model.config.UniqueType;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

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

//        res.addSegmentValidations(ER7016PosLtlbDppkSbn.genValidation());
//        res.addSegmentValidations(ER7016PosLtlbDppkSbn.genRowValidation());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(O, 9, 9, refTable)
                .confRegex(SimpleValidation.patternAlfaNumeric)
                .confReference(EHeaderMetadataPpmpk.R7016Sbn.getObject())));

        fs.add(sf(2, null, "Jenis Investasi", sv(O, 1, 6, refTable)
                .confRegex(SimpleValidation.patternAlfaNumeric)
                .confReference(EHeaderMetadataShared.R022.getObject())
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForTotal())));

        fs.add(sf(3, null, "Nama Jenis Investasi", sv(O, 1, 100, freeText)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForTotal())));

        fs.add(sf(4, null, "Seri Efek", sv(O, 1, 100, freeText)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForTotal())));

        fs.add(sf(5, null, "Jenis Kepemilikan", sv(O, 1, 100, freeText)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForTotal())));

        fs.add(sf(6, null, "Rating", sv(O, 1, 100, freeText)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForTotal())));

        fs.add(sf(7, null, "Menajer Investasi", sv(O, 1, 100, freeText)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForTotal())));

        fs.add(sf(8, null, "Nilai Wajar", sv(O, 1, 18, numeric)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForTotal())));

        fs.add(sf(9, null, "% SBN dalam Reksadana", sv(O, 4, 6, numericDot)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForSaldo())));

        fs.add(sf(10, null, "Saldo", sv(O, 1, 18, numeric)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForSbn())));

        fs.add(sf(11, null, "Emiten Penerima Dana/Project", sv(O, 1, 100, alfa)
                .confConditionalRequired(ER7016PosLtlbDppkSbn.genConditionForTotal())));

        return res;
    }
}
