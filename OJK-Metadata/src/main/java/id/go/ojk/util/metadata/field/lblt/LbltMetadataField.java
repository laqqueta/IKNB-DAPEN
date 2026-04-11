package id.go.ojk.util.metadata.field.lblt;

import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.constants.SectorType;
import id.go.ojk.util.metadata.field.base.BaseMetadataField;
import lombok.Getter;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class LbltMetadataField<T extends Enum<T> & ILbltFieldMetadata> extends BaseMetadataField<T> {

    @Getter
    private ProgramType programType;

    public LbltMetadataField(Class<T> enumClass, SectorType sectorType) {
        super(enumClass, sectorType);
    }


    @Override
    protected List<T> enumValues() {
        if (getProgramType() == null) {
            throw new IllegalStateException("ProgramType is null");
        }

        return EnumSet.allOf(super.getEnumClass()).stream()
                .filter(e -> e.getProgramType().contains(getProgramType()))
                .collect(Collectors.toList());
    }

    public LbltMetadataField<T> setProgramType(ProgramType programType) {
        this.programType = programType;
        return this;
    }
}
