package id.go.ojk.lib.client.model;

import lombok.Getter;
import lombok.Setter;

public class KeyValueString {

	@Getter @Setter private String key;
	@Getter @Setter private String value;
	@Getter @Setter private String[] labels;
	@Getter @Setter private String[] segments;

	public KeyValueString(){
	}
	
	public KeyValueString(String key, String value, String[] labels, String[] segments){
		this(key, value, labels);
		setSegments(segments);
	}

	public KeyValueString(String key, String value, String[] labels){
		setKey(key);
		setValue(value);
		setLabels(labels);
	}

//	public String getKey() {
//		return key;
//	}
//	public void setKey(String key) {
//		this.key = key;
//	}
//
//	public String getValue() {
//		return value;
//	}
//	public void setValue(String value) {
//		this.value = value;
//	}
//
//	public String[] getLabels() {
//		return labels;
//	}
//	public void setLabels(String[] labels) {
//		this.labels = labels;
//	}

}
