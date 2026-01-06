package id.go.ojk.lib.client.model.reference;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import id.go.ojk.lib.client.model.KeyValueString;

@XmlRootElement(name = "references")
public class References {

    private List<KeyValueString> references = new ArrayList<>();

    @XmlElement(name = "reference")
    public List<KeyValueString> getReferences() {
		return references;
	}

    public void setReferences(List<KeyValueString> references) {
		this.references = references;
	}

    public void add(KeyValueString keyValue){
    	references.add(keyValue);
    }

}