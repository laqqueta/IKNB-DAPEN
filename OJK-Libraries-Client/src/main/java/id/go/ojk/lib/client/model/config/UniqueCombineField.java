package id.go.ojk.lib.client.model.config;

import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.lib.client.CollectionUtil;
import lombok.Getter;
import lombok.Setter;

@XStreamAlias("uniqueCombineField")
public class UniqueCombineField {

	@Getter @Setter private String name;
	@Getter @Setter private int[] columns;
	@Getter @Setter private String columnForPosNotUCF; // modif : UCF -> uniqueCombineField
	@Getter @Setter private String[] pos; // modif
	@Getter @Setter private String separator = "#";

	public UniqueCombineField(String parameter){
		Map<String, String> parameterMap = CollectionUtil.toMap(parameter);
		this.name = parameterMap.get("name");
		this.columns = CollectionUtil.toIntArray(parameterMap.get("columns"));
		this.columnForPosNotUCF = parameterMap.get("columnForPosNotUCF"); // modif
		this.pos = CollectionUtil.toStringArray(parameterMap.get("pos")); // modif
	}

	// RBB Version
	public UniqueCombineField(String name, String[] pos, String columnForPosNotUCF, int ... columns){
		this.name = name;
		this.columns = columns;
		this.columnForPosNotUCF = columnForPosNotUCF; // modif
		this.pos = pos; // modif
	}
	
	// SLIK Version
	public UniqueCombineField(String name, int ... columns){
		this.name = name;
		this.columns = columns;
	}
}