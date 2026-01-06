package id.go.ojk.asruk.client.builder.field.rb.reference;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import id.go.ojk.asruk.client.builder.Constant;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.reference.ReferenceHeader;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReferenceHeader implements IObject<ReferenceHeader> {
	REFERENCE_HEADER (Constant.REFERENCE_VERSION, EHeaderMetadataRb.getObjects()),
	;
	
	private String version;
	private List<ReferenceMetadata> referenceMetadata;
	
	@Override
	public ReferenceHeader getObject() {
		ReferenceHeader res = new ReferenceHeader();
		res.setLastModified(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
		res.setReferenceMetadatas(referenceMetadata);
		res.setVersion(version);
		return res;
	}
}
