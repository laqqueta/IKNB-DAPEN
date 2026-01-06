package id.go.ojk.conf.client;

import java.util.List;

public interface IReferenceBuilder extends IBuilder {
	String buildConfigXml();
	String buildMessageXml();
	String buildHeaderXml();
	List<String> buildReferenceXml();
	String buildValidationErrorCodesXml();
	String getFaqZip();
	String getManualPdf();
}
