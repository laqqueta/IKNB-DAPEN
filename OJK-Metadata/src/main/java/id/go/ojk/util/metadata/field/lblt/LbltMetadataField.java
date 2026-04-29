package id.go.ojk.util.metadata.field.lblt;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.constants.SectorType;
import id.go.ojk.util.metadata.field.base.BaseMetadataField;
import lombok.Getter;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LbltMetadataField<T extends Enum<T> & ILbltFieldMetadata> extends BaseMetadataField<T> {

    @Getter
    private ProgramType programType;

    private final Map<ProgramType, ReferenceMetadata> kodeKomponenReferences;

    private final int KODE_KOMPONEN_FIELD_INDEX = 1; // 0 Based index, Index 0 :: Flag -> Index 1 :: Kode Komponen

    public LbltMetadataField(Class<T> enumClass, List<SectorType> sectorType, Map<ProgramType, ReferenceMetadata> kodeKomponenReferences) {
        super(enumClass, sectorType);

        this.kodeKomponenReferences = kodeKomponenReferences;
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

    @Override
    protected Stream<SubmissionField> getfilteredFieldStream() {
        return super.getfilteredFieldStream()
                .peek(field -> {
                    if (field.getNumber() == KODE_KOMPONEN_FIELD_INDEX) {
                        field.getSimpleValidation().confReference(kodeKomponenReferences.get(programType));
                    }
                });
    }

    public LbltMetadataField<T> setProgramType(ProgramType programType) {
        this.programType = programType;
        return this;
    }
}
