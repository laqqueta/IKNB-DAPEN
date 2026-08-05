package id.go.ojk.metadata.validation.lblt;

import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import lombok.Setter;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class LbltMetadataValidation<T extends Enum<T> & ILbltMetadataValidation> extends BaseMetadataValidation<T> {

    private final Class<T> enumClass;

    @Setter
    private ProgramType programType;

    public LbltMetadataValidation(Class<T> enumClass, ProgramType programType) {
        super(enumClass);
        this.enumClass = enumClass;
        this.programType = programType;
    }

    public LbltMetadataValidation(Class<T> enumClazz) {
        super(enumClazz);
        this.enumClass = enumClazz;
    }

    @Override
    protected List<T> enumValues() {
        List<T> enumVals = EnumSet.allOf(enumClass).stream()
                .filter(e -> e.getProgramTypes().contains(programType) || e.getProgramTypes().contains(ProgramType.ALL))
                .collect(Collectors.toList());

//        if (enumVals.isEmpty()) throw new IllegalStateException("empty metadata validation");

        return enumVals;
    }

}
