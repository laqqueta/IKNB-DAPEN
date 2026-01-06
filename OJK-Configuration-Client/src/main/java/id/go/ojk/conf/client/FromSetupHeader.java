package id.go.ojk.conf.client;

import id.go.ojk.lib.client.model.SetupHeader;

public class FromSetupHeader extends BaseObjectToXml<SetupHeader> {
	
	@Override
	protected void initXStream() {
        super.initXStream();
        xstream.processAnnotations(SetupHeader.class);
	}
}
