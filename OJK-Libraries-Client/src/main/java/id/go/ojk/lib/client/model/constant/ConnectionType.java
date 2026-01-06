package id.go.ojk.lib.client.model.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;

public enum ConnectionType {
	internet("Internet", 					OjkClientConstant.getServerAddressList(false)),
	extranet("Leased Line (Ekstranet)", 	OjkClientConstant.getServerAddressList(true));

	private String label;
	private List<String> serverAddresses;

	private ConnectionType(String label, List<String> serverAddresses){
		this.label = label;
		this.serverAddresses = ImmutableList.copyOf(serverAddresses); 
	}

	public String getLabel() {
		return label;
	}
	
	public List<String> getServerAddresses() {
		return serverAddresses;
	}

	public String getRadioButtonId(){
		return name() + "_radio";
	}
	
	public static List<String> getValueList(){
		return Arrays.asList(ConnectionType.values()).stream().map( e -> e.name()).collect(Collectors.toList());
	}

}
