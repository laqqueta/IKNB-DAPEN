package id.go.ojk.conf.client;

import id.go.ojk.lib.client.model.security.ClientEntityList;

public class FromClientEntity extends BaseObjectToXml<ClientEntityList> {
	
	@Override
	protected void initXStream() {
		super.initXStream();
		xstream.processAnnotations(ClientEntityList.class);
		xstream.addImplicitCollection(ClientEntityList.class, "clientEntityList");
	}
}
