package id.go.ojk.client.model.config.validation.field;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.util.states.JenisProgramState;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@XStreamAlias("EqualsValueValidation")
public class EqualsJenisProgramValidation extends MapParamFieldValidation {

    private String selectCodePos;

    public EqualsJenisProgramValidation() {
    }

    public EqualsJenisProgramValidation(String parameter) {
        setParameter(parameter);
    }

    @Override
    public EqualsJenisProgramValidation initialized() {
        selectCodePos = getStringParameter("selectPosCode");
        return this;
    }

    ;

    @Override
    public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
        Logger logger = LoggerFactory.getLogger(EqualsJenisProgramValidation.class);
        String currentPosCode = validationResult.getColumn(1);

        if (!currentPosCode.equalsIgnoreCase(selectCodePos)) return;

        String realValue = validationResult.getColumn(field.getNumber());
        if (!realValue.equals(JenisProgramState.program)) {
            logger.error("{}|{}?{}", parameter, realValue, validationResult);

            validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E03_32_EQUAL_PENISUN,
                    JenisProgramState.program, JenisProgramState.selectedValue));
        }

    }


    private String genMessage(String[] arrFieldComparator) {
        StringBuilder res = new StringBuilder("nilai kolom ");
        int length = arrFieldComparator.length;
        for (int i = 0; i < length; i++) {
            res.append(Integer.parseInt(arrFieldComparator[i]) + 1);
            if (i + 1 < length) {
                res.append(" dan kolom ");
            }
        }
        return res.toString();
    }
}
