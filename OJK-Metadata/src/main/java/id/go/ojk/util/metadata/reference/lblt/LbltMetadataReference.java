package id.go.ojk.util.metadata.reference.lblt;

import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.metadata.reference.base.BaseMetadataReference;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class LbltMetadataReference<T extends Enum<T> & ILbltReferenceValidation> extends BaseMetadataReference<T> {

    private final Class<T> enumClass;
    private final ProgramType programType;

    public LbltMetadataReference(Class<T> enumClass, ProgramType programType) {
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
