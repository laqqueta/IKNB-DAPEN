package id.go.ojk.conf.client;

import id.go.ojk.lib.client.model.update.UpdateHeader;

public class FromUpdateHeader extends BaseObjectToXml<UpdateHeader> {
	
	@Override
	protected void initXStream() {
        super.initXStream();
        xstream.processAnnotations(UpdateHeader.class);
//        xstream.useAttributeFor(UpdateHeader.class, "createdDatetime");
//        xstream.useAttributeFor(UpdateHeader.class, "createdBy");
	}
}
