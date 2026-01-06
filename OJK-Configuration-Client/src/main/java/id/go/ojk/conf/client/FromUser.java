package id.go.ojk.conf.client;

import java.util.ArrayList;
import java.util.Map;

import id.go.ojk.lib.client.model.security.User;
import id.go.ojk.lib.client.model.security.UserRole;

public class FromUser extends BaseObjectToXml<Map<String, User>> {
	
	@Override
	protected void initXStream() {
        super.initXStream();
        xstream.processAnnotations(User.class);
        xstream.alias("role", UserRole.class);
        xstream.alias("appAccess", ArrayList.class);
	}
}
