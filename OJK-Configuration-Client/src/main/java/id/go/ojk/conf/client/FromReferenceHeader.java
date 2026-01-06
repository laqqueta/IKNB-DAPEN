package id.go.ojk.conf.client;

import id.go.ojk.lib.client.model.reference.ReferenceHeader;

public class FromReferenceHeader extends BaseObjectToXml<ReferenceHeader> {
	
	@Override
	protected void initXStream() {
		super.initXStream();
		xstream.processAnnotations(ReferenceHeader.class);
//		xstream.useAttributeFor(ReferenceHeader.class, "version");
//		xstream.useAttributeFor(ReferenceHeader.class, "lastModified");
//		xstream.useAttributeFor(ReferenceMetadata.class, "number");
//		xstream.useAttributeFor(ReferenceMetadata.class, "name");
//		xstream.useAttributeFor(ReferenceMetadata.class, "type");
	}
}
