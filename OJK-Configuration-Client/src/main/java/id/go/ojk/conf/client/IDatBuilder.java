package id.go.ojk.conf.client;

import id.go.ojk.lib.client.model.security.ClientEntity;

public interface IDatBuilder extends IBuilder {
	String buildHeaderFtpXml();
	String buildVersionTxt();
	String buildHeaderXml();
	String buildMetadataJar();
	String buildReferenceJar();
	String buildSetupJar(ClientEntity clientEntity);
}
