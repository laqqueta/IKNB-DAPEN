package id.go.ojk.lib.client.service.validation;

import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.model.config.UniqueCombineField;

public class ValidationCombineUnique {
	private UniqueCombineField combineField;
	private HashSet<String> values;

	private int[] columns;
	private int columnsLength;
	private String separator;

	public ValidationCombineUnique(UniqueCombineField combineField){
		this.combineField = combineField;
		this.values = new HashSet<>();

		this.columns = combineField.getColumns();
		this.columnsLength = this.columns.length;
		this.separator = combineField.getSeparator();
	}

	public UniqueCombineField getCombineField() {
		return combineField;
	}

	public HashSet<String> getValues() {
		return values;
	}

	//~ method

	public boolean cekUniqueAndPut(String rowSplited[]) {
		String value = getKey(rowSplited);
		boolean contain = values.contains(value);
		if( !contain ){
			values.add(value);
		}
		
		return !contain;
	}

	private String getKey(String rowSplited[]){
		if ( columnsLength == 2 ) {
			return StringUtils.join(rowSplited[columns[0]], separator, rowSplited[columns[1]]);
		} else {
			StringBuilder builder = new StringBuilder();
			builder.append(rowSplited[columns[0]]);
			for(int i=1; i<columnsLength; i++ ){
				builder.append("#").append(rowSplited[columns[i]]);
			}
			return builder.toString();
		}
	}

}
