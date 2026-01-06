package id.go.ojk.client.service.validation;

import java.util.HashSet;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.lib.client.model.config.UniqueType;
import lombok.Getter;
import lombok.Setter;

public class ValidationUnique {
	private UniqueType uniqueType;
	private String uniqueName;
	private SubmissionField submissionField;
	private HashSet<String> values;
	private HashSet<String> tmpValues;
	
	@Getter @Setter private boolean onlyPut;

	public ValidationUnique(UniqueType uniqueType, String uniqueName, SubmissionField submissionField, HashSet<String> values){
		this.uniqueType = uniqueType;
		this.uniqueName = uniqueName;
		this.submissionField = submissionField;
		this.values = values;
		if ( values == null )
			this.values = new HashSet<>();
		if ( uniqueType == UniqueType.D )
			this.tmpValues = new HashSet<>();
		
		this.onlyPut = false;
	}

	public UniqueType getUniqueType() {
		return uniqueType;
	}

	public String getUniqueName() {
		return uniqueName;
	}

	public SubmissionField getSubmissionField() {
		return submissionField;
	}

	public HashSet<String> getValues() {
		return values;
	}

	public HashSet<String> getTmpValues() {
		return tmpValues;
	}

	//~ method

	public boolean cekUniqueAndPut(String rowSplited[]) {
		String value = UtilValidation.getArray(rowSplited, submissionField.getNumber(), "");
		boolean contain = values.contains(value);
		if ( uniqueType == UniqueType.D ) {
			tmpValues.add(value);
			return !contain;
		} else {
			if( !contain ){
				values.add(value);
			}
			return !contain;
		}
	}

}
