package id.go.ojk.conf.client;

import java.util.List;

public interface ISetupBuilder extends IBuilder {
	String buildHeaderXml();
	List<String> buildReferenceXml();
	String buildSetupXml();
	String buildUserXml();
}
