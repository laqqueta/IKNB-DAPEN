package id.go.ojk.client.model.config;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.lib.client.model.config.UniqueType;
import lombok.Getter;
import lombok.Setter;

@XStreamAlias("field")
public class SubmissionField {

	@XStreamAsAttribute
	private Integer number;

	@XStreamAsAttribute
	private String code;

	@XStreamAsAttribute
	private String name;

	@XStreamAsAttribute
	private UniqueType uniqueType;

	private String[] uniqueNames;

	private String relationTo;

	private SimpleValidation simpleValidation;

	private List<FieldValidation> fieldValidations = new ArrayList<FieldValidation>();

	/**
	 * only for server
	 */
	@Getter @Setter private String dataQueryColumnCode;

	public SubmissionField(){
	}

	public SubmissionField(Integer number, String code, String name, SimpleValidation simpleValidation){
		setNumber(number);

		if (code != null)
			setCode(code);
		else
			setCode("F" + new DecimalFormat("00").format(number));

		setName(name);
		setSimpleValidation(simpleValidation);
	}

	public SubmissionField confUniqueType(UniqueType uniqueType){
		setUniqueType(uniqueType);
		return this;
	}

	public SubmissionField confUnique(UniqueType uniqueType, String ... uniqueNames){
		setUniqueType(uniqueType);
		setUniqueNames(uniqueNames);
		return this;
	}

	public SubmissionField confRelationTo(String relationTo){
		setRelationTo(relationTo);
		return this;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UniqueType getUniqueType() {
		return uniqueType;
	}
	public void setUniqueType(UniqueType uniqueType) {
		this.uniqueType = uniqueType;
	}
	public boolean isUnique(){
		if ( uniqueType == UniqueType.U || uniqueType == UniqueType.D)
			return true;
		else
			return false;
	}

	public String[] getUniqueNames() {
		return uniqueNames;
	}
	public void setUniqueNames(String[] uniqueNames) {
		this.uniqueNames = uniqueNames;
	}

	public String getRelationTo() {
		return relationTo;
	};
	public void setRelationTo(String relationTo) {
		this.relationTo = relationTo;
	};

	public SimpleValidation getSimpleValidation() {
		return simpleValidation;
	}

	public void setSimpleValidation(SimpleValidation simpleValidation) {
		this.simpleValidation = simpleValidation;
	}

	//~ fieldValidations

	public List<FieldValidation> getFieldValidations() {
		return fieldValidations;
	}

	public void setFieldValidations(List<FieldValidation> fieldValidations) {
		this.fieldValidations = fieldValidations;
	}

	public SubmissionField addFieldValidations(FieldValidation fieldValidation) {
		if ( this.fieldValidations == null )
			this.fieldValidations = new ArrayList<FieldValidation>();
		this.fieldValidations.add(fieldValidation);
		return this;
	}

	public SubmissionField addFieldValidations(IValidationConverter validationConverter) {
		return addFieldValidations(validationConverter.toFieldValidation());
	}

}
