package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.constant.JenisProgram;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7012PosLtlbDppkAlm;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.validations.ppmpk.EAlmValidationsConfig;
import id.go.ojk.lib.client.model.config.UniqueType;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

public class Ltlb0013ALM extends BaseMetadata {

    public Ltlb0013ALM(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_ALM;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 52, 52);

        res.setSavePos(ER7012PosLtlbDppkAlm.genFieldSave(JenisProgram.PPMPK));
        res.setRequiredPos(ER7012PosLtlbDppkAlm.getRequiredPos(JenisProgram.PPMPK));

//        ER7012PosLtlbDppkAlm.getPpmpkSegmentValidations().forEach(res::addSegmentValidations);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(O, 17, 17, refTable)
                .confRegex(SimpleValidation.patternAlfaNumeric)
                .confReference(EHeaderMetadataPpmpk.R7012Alm.getObject()))
                .confUnique(UniqueType.U));
        fs.add(sf(2, null, "Jatuh tempo < 1 tahun - Rupiah", sv(O, 1, 18, numeric)));
        fs.add(sf(3, null, "Jatuh tempo < 1 tahun - Non Rupiah", sv(O, 1, 18, numeric)));
        fs.add(sf(4, null, "Jatuh tempo < 1 tahun - Total", sv(O, 1, 18, numeric)
                .confConditionalRequired(EAlmValidationsConfig.genConditionForPersentase()))
                .addFieldValidations(EAlmValidationsConfig.FV_JTA_EQUAL.toFieldValidation()));

        fs.add(sf(5, null, "1 tahun <= jatuh tempo < 5 tahun - Rupiah", sv(O, 1, 18, numeric)));
        fs.add(sf(6, null, "1 tahun <= jatuh tempo < 5 tahun - Non Rupiah", sv(O, 1, 18, numeric)));
        fs.add(sf(7, null, "1 tahun <= jatuh tempo < 5 tahun - Total", sv(O, 1, 18, numeric)
                .confConditionalRequired(EAlmValidationsConfig.genConditionForPersentase()))
                .addFieldValidations(EAlmValidationsConfig.FV_JTB_EQUAL.toFieldValidation()));

        fs.add(sf(8, null, "5 tahun <= jatuh tempo < 10 tahun - Rupiah", sv(O, 1, 18, numeric)));
        fs.add(sf(9, null, "5 tahun <= jatuh tempo < 10 tahun - Non Rupiah", sv(O, 1, 18, numeric)));
        fs.add(sf(10, null, "5 tahun <= jatuh tempo < 10 tahun - Total", sv(O, 1, 18, numeric)
                .confConditionalRequired(EAlmValidationsConfig.genConditionForPersentase()))
                .addFieldValidations(EAlmValidationsConfig.FV_JTC_EQUAL.toFieldValidation()));

        fs.add(sf(11, null, "Jatuh Tempo >= 10 Tahun - Rupiah", sv(O, 1, 18, numeric)));
        fs.add(sf(12, null, "Jatuh Tempo >= 10 - Non Rupiah", sv(O, 1, 18, numeric)));
        fs.add(sf(13, null, "Jatuh Tempo >= 10 - Total", sv(O, 1, 18, numeric)
                .confConditionalRequired(EAlmValidationsConfig.genConditionForPersentase()))
                .addFieldValidations(EAlmValidationsConfig.FV_JTD_EQUAL.toFieldValidation()));

        fs.add(sf(14, null, "Total - Rupiah", sv(O, 1, 18, numeric))
                .addFieldValidations(EAlmValidationsConfig.FV_TOTAL1_EQUAL.toFieldValidation()));
        fs.add(sf(15, null, "Total - Non Rupiah", sv(O, 1, 18, numeric))
                .addFieldValidations(EAlmValidationsConfig.FV_TOTAL2_EQUAL.toFieldValidation()));
        fs.add(sf(16, null, "Total - Total", sv(O, 1, 18, numeric)
                .confConditionalRequired(EAlmValidationsConfig.genConditionForPersentase()))
                .addFieldValidations(EAlmValidationsConfig.FV_TOTAL3_EQUAL.toFieldValidation()));

        return res;
    }
}
