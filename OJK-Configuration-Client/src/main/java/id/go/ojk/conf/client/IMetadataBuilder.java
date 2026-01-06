package id.go.ojk.conf.client;

public interface IMetadataBuilder extends IBuilder {
	String buildMetadataXml();
	String buildSummaryMetadataXml();
	String buildSupervisionMetadataXml();
}
