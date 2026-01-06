package id.go.ojk.conf.client;

import java.util.List;

import id.go.ojk.lib.client.model.KeyValueString;

public class FromKeyValueString extends BaseObjectToXml<List<KeyValueString>> {
	
	@Override
	protected void initXStream() {
		super.initXStream();
        xstream.alias("list", List.class);
        xstream.alias("reference", KeyValueString.class);
	}
}
