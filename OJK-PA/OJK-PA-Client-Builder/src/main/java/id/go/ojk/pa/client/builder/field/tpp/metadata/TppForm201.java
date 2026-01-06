package id.go.ojk.pa.client.builder.field.tpp.metadata;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.field.DeviasiFieldValidation;
import id.go.ojk.client.model.config.validation.field.MinMaxFieldValidation;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.pa.client.builder.field.tpp.EFormTpp;
import id.go.ojk.pa.client.builder.field.tpp.reference.EHeaderMetadataTpp;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class TppForm201 extends BaseMetadata {

    public TppForm201(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {
        EFormTpp form = EFormTpp.TPP_201;
        SubmissionFormat subFormat = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(), extension, 30, 30, null);
        List<SubmissionField> fsList = subFormat.getFields();

        fsList.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fsList.add(sf(1, null, "Kode Komponen", sv(M, 12, 12, refTable)
                .confReference(EHeaderMetadataTpp.R1001_Pos81A201.getObject())
                .confRegex(SimpleValidation.patternNumeric))
                .confUnique(UniqueType.U));
        fsList.add(sf(2, null, "Target Perkembangan", sv(M, 1, 9, numeric)));
        fsList.add(sf(3, null, "Realisasi Perkembangan", sv(M, 1, 9, numeric)));
        fsList.add(sf(4, null, "Deviasi (%) Perkembangan", sv(M, 4, 14, numericDotNegatif))
                .addFieldValidations(new DeviasiFieldValidation("conditionField=2|3"))
                .addFieldValidations(new MinMaxFieldValidation("minValue=-100.00&minEqual=true")));
        fsList.add(sf(5, null, "Kendala", sv(M, 1, 1000, freeText).confRegex(SimpleValidation.FREE_TEXT_PATTERN)));
        fsList.add(sf(6, null, "Upaya yang akan dilakukan", sv(M, 1, 1000, freeText).confRegex(SimpleValidation.FREE_TEXT_PATTERN)));

        return subFormat;
    }
}
