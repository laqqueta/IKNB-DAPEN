package id.go.ojk.metadata.field.base;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import id.go.ojk.metadata.util.FieldUtil;
import id.go.ojk.metadata.util.constants.SectorType;
import id.go.ojk.metadata.validation.ValidationConverter;
import id.go.ojk.metadata.validation.base.IBaseMetadataValidation;
import org.apache.commons.lang3.SerializationUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static id.go.ojk.client.model.config.SimpleValidation.patternAll2;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;

public abstract class BaseMetadataField<T extends Enum<T> & IBaseFieldMetadata> {

    private final Class<T> enumClass;

    private final List<SectorType> sectorType;

    public BaseMetadataField(Class<T> enumClass, List<SectorType> sectorType) {
        this.enumClass = enumClass;
        this.sectorType = sectorType;
    }

    protected List<T> enumValues() {
        return new ArrayList<>(EnumSet.allOf(enumClass));
    }

    protected List<SubmissionField> reindex(List<SubmissionField> filtered, List<Integer> reindexNumber) {
        AtomicInteger idx = new AtomicInteger(0);
        return filtered.stream()
                .filter(f -> reindexNumber.contains(f.getNumber()))
                .peek(f -> {
                    int num = idx.getAndIncrement();
                    String pref = num < 10 ? "0" : "";
                    f.setNumber(num);
                    f.setCode("F" + pref + num);
                })
                .sorted(Comparator.comparingInt(SubmissionField::getNumber))
                .collect(Collectors.toList());
    }

    protected Stream<SubmissionField> getfilteredFieldStream() {
        return enumValues().stream()
                .filter(f -> f.getSectorTypes().stream()
                        .anyMatch(sectorType::contains))
                .map(IBaseFieldMetadata::getField);
    }

    public List<SubmissionField> getFields() {
        return getfilteredFieldStream()
                .map(SerializationUtils::clone)
                .sorted(Comparator.comparingInt(SubmissionField::getNumber))
                .collect(Collectors.toList());
    }

    public <V extends IBaseMetadataValidation> List<SubmissionField> getFields(Map<Integer, List<V>> fieldValidations) {
        return getfilteredFieldStream()
                .map(SerializationUtils::clone)
                .peek(field -> {
                    List<V> tmpValidations = fieldValidations.get(field.getNumber());

                    if (tmpValidations == null) return;
                    if (tmpValidations.isEmpty()) return;

                    tmpValidations.forEach(validation -> {
                        if (ValidationConverter.isValidation(validation, FieldValidation.class)) {
                            FieldValidation fv = ValidationConverter.toValidation(validation, FieldValidation.class);
                            field.addFieldValidations(fv);
                        } else if (field.getSimpleValidation().getRequiredCondition().equals(C) && ValidationConverter.isValidation(validation, ConditionalRequired.class)) {
                            ConditionalRequired cr = ValidationConverter.toValidation(validation, ConditionalRequired.class);
                            field.getSimpleValidation().setConditionalRequired(cr);
                        }
                    });

                })
                .sorted(Comparator.comparingInt(SubmissionField::getNumber))
                .collect(Collectors.toList());
    }

    // this func is to make all fields Optional and remove any validation
    // !!DO NOT USE IN PROD!!
    public List<SubmissionField> getClearedFields() {
        return getfilteredFieldStream()
                .map(SerializationUtils::clone)
                .peek(field -> {
                    if (field.getNumber() == 0 || field.getNumber() == 1) return;

                    field.getSimpleValidation().setRequiredCondition(RequiredCondition.O);
                    field.getSimpleValidation().setConditionalRequired(null);
                    field.getSimpleValidation().setDataType(all2);
                    field.getSimpleValidation().setRegex(patternAll2.c());
                    field.getSimpleValidation().setMaxLength(999);
                    field.getSimpleValidation().setMinLength(1);
                    field.setFieldValidations(new ArrayList<>());
                })
                .sorted(Comparator.comparingInt(SubmissionField::getNumber))
                .collect(Collectors.toList());
    }

    public List<SubmissionField> getReindexClearedFields(List<Integer> reindexNumber) {
        return reindex(getfilteredFieldStream()
                .map(SerializationUtils::clone)
                .peek(field -> {
                    if (field.getNumber() == 0 || field.getNumber() == 1) return;

                    field.getSimpleValidation().setRequiredCondition(RequiredCondition.O);
                    field.getSimpleValidation().setConditionalRequired(null);
                    field.setFieldValidations(new ArrayList<>());
                })
                .sorted(Comparator.comparingInt(SubmissionField::getNumber))
                .collect(Collectors.toList()), reindexNumber);
    }

    public List<SubmissionField> getReindexFields(List<Integer> reindexNumber) {
        return reindex(getFields(), reindexNumber);
    }

    public <V extends IBaseMetadataValidation> List<SubmissionField> getReindexFields(List<Integer> reindexNumber, Map<Integer, List<V>> fieldValidations) {
        return reindex(getFields(fieldValidations), reindexNumber);
    }

    protected Class<T> getEnumClass() {
        return enumClass;
    }

    protected List<SectorType> getSectorType() {
        return sectorType;
    }
}
