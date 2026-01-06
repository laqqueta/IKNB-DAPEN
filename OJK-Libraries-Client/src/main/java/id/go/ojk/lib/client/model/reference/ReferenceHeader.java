package id.go.ojk.lib.client.model.reference;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("referenceHeader")
public class ReferenceHeader {

	@XStreamAsAttribute
    private String version;

	@XStreamAsAttribute
    private String lastModified;
	
	@XStreamOmitField
	public static String jarVersion;

    private List<ReferenceMetadata> referenceMetadatas = new ArrayList<>();

    public ReferenceHeader(){
    }

    //~ getter setter

    public String getVersion() {
		return version;
	}

    public void setVersion(String version) {
		this.version = version;
		jarVersion = version;
	}

    public String getLastModified() {
		return lastModified;
	}

    public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

    public List<ReferenceMetadata> getReferenceMetadatas() {
		return referenceMetadatas;
	}

    public void setReferenceMetadatas(List<ReferenceMetadata> referenceMetadatas) {
		this.referenceMetadatas = referenceMetadatas;
	}

    public ReferenceHeader addMedatata(ReferenceMetadata referenceMetadata) {
		this.referenceMetadatas.add(referenceMetadata);
		return this;
	}
}