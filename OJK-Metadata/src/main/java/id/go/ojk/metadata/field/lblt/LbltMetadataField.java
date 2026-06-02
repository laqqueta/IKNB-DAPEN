package id.go.ojk.metadata.field.lblt;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.util.constants.SectorType;
import id.go.ojk.metadata.field.base.BaseMetadataField;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.SerializationUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LbltMetadataField<T extends Enum<T> & ILbltFieldMetadata> extends BaseMetadataField<T> {

    @Setter
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

        return super.enumValues()
                .stream()
                .filter(f -> f.getSectorTypes().stream()
                        .anyMatch(getSectorType()::contains))
                .filter(e -> e.getProgramType().contains(getProgramType()))
                .collect(Collectors.toList());
    }

    @Override
    protected Stream<SubmissionField> getfilteredFieldStream() {
        AtomicBoolean changed = new AtomicBoolean(false);

        return enumValues().stream()
                .map(v -> SerializationUtils.clone(v.getField()))
                .peek(sf -> {
                    if (changed.get()) return;

                    if (sf.getNumber() == KODE_KOMPONEN_FIELD_INDEX) {
                        sf.getSimpleValidation()
                                .confReference(kodeKomponenReferences.get(programType));

                        changed.set(true);
                    }
                });
    }

}
