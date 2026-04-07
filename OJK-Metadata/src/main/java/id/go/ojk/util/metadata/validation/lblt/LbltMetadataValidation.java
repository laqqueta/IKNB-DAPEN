package id.go.ojk.util.metadata.validation.lblt;

import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class LbltMetadataValidation<T extends Enum<T> & ILbltMetadataValidation> extends BaseMetadataValidation<T> {

    private final Class<T> enumClass;
    private final ProgramType programType;

    public LbltMetadataValidation(Class<T> enumClass, ProgramType programType) {
        super(enumClass);
        this.enumClass = enumClass;
        this.programType = programType;
    }

    @Override
    protected List<T> enumValues() {
        return EnumSet.allOf(enumClass).stream()
                .filter(e -> e.getProgramTypes().contains(programType))
                .collect(Collectors.toList());
    }
}
