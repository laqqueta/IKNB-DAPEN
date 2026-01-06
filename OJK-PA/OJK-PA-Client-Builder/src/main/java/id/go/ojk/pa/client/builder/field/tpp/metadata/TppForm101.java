package id.go.ojk.pa.client.builder.field.tpp.metadata;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.field.ColumnConditionValidation;
import id.go.ojk.client.model.config.validation.field.MinMaxFieldValidation;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.pa.client.builder.field.tpp.EFormTpp;
import id.go.ojk.pa.client.builder.field.tpp.reference.EHeaderMetadataTpp;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class TppForm101 extends BaseMetadata {
    public TppForm101(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormTpp form = EFormTpp.TPP_101;
        SubmissionFormat subFormat = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(), extension, 30, 30, null);
        List<SubmissionField> fsList = subFormat.getFields();

        fsList.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fsList.add(sf(1, null, "Kode Komponen", sv(M, 12, 12, refTable)
                .confReference(EHeaderMetadataTpp.R1000_Pos81A101.getObject())
                .confRegex(SimpleValidation.patternNumeric))
                .confUnique(UniqueType.U));
        fsList.add(sf(2, null, "Jumlah Tertanggung yang akan dikinikan", sv(M, 1, 9, numeric)));
        fsList.add(sf(3, null, "% Terhadap Jumlah seluruh tertanggung", sv(M, 4, 6, numericDot))
                .addFieldValidations(new ColumnConditionValidation("fieldCondition=2&trueConditionValue=0&operator=e&trueValue=0.00&msgFormula=diisi dengan 0.00"))
                .addFieldValidations(new MinMaxFieldValidation("maxValue=100.00&maxEqual=true")));
        fsList.add(sf(4, null, "Informasi yang akan dikinikan", sv(M, 1, 1000, freeText).confRegex(SimpleValidation.FREE_TEXT_PATTERN)));
        fsList.add(sf(5, null, "Metode atau strategi", sv(M, 1, 1000, freeText).confRegex(SimpleValidation.FREE_TEXT_PATTERN)));
        fsList.add(sf(6, null, "Persentase pemenuhan Tertanggung yang telah dikinikan", sv(M, 1, 1000, freeText).confRegex(SimpleValidation.FREE_TEXT_PATTERN)));

        return subFormat;
    }
}
