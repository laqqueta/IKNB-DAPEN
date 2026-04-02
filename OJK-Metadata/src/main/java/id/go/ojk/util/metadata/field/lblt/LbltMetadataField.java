package id.go.ojk.util.metadata.field.lblt;

import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.metadata.field.base.BaseMetadataField;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class LbltMetadataField<T extends Enum<T> & ILbltFieldMetadata> extends BaseMetadataField<T> {

    private final Class<T> enumClass;
    private final ProgramType programType;

    public LbltMetadataField(Class<T> enumClass, ProgramType programType) {
        super(enumClass);
        this.enumClass = enumClass;
        this.programType = programType;
    }

    @Override
    protected List<T> enumValues() {
        return EnumSet.allOf(enumClass).stream()
                .filter(e -> e.getProgramType().contains(programType))
                .collect(Collectors.toList());
    }


}
