package id.go.ojk.util;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.constants.SectorType;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.Collectors;

public class FieldUtil {
    public static SubmissionField sf(Integer number, String code, String name, SimpleValidation simpleValidation) {
        return new SubmissionField(number, code, name, simpleValidation);
    }

    public static SimpleValidation sv(RequiredCondition requiredCondition, int minLength, int maxLength, DataType dataType) {
        return new SimpleValidation(requiredCondition, minLength, maxLength, dataType);
    }

    public static EnumSet<SectorType> sectors(SectorType ...sectors) {
        return EnumSet.copyOf(Arrays.stream(sectors).collect(Collectors.toList()));
    }

    public static EnumSet<ProgramType> programs(ProgramType ...programs) {
        return EnumSet.copyOf(Arrays.stream(programs).collect(Collectors.toList()));
    }
}
