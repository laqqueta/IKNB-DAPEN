package id.go.ojk.pa.client.builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.BaseReferenceBuilder;
import id.go.ojk.conf.client.field.reference.EConfig;
import id.go.ojk.conf.client.field.reference.EMessage;
import id.go.ojk.pa.client.Constant;
import id.go.ojk.pa.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceHeader;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.pa.client.builder.field.tpp.reference.EHeaderMetadataTpp;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReferenceBuilder extends BaseReferenceBuilder {

	public static void main(String[] args) {
		try {
			final String ROOT_FOLDER = args.length > 0 ? args[0] : "";
			log.info("starting builder");
			ReferenceBuilder builder = new ReferenceBuilder(ROOT_FOLDER, HomeController.homeButton);
			String jarFile = builder.buildAll();
			builder.testBundle(jarFile);
		} finally {
			log.info("stopped");
		}
	}

	public ReferenceBuilder(String rootFolder, String base64Key) {
		super(rootFolder, base64Key);
	}

	@Override
	public void init() {
		setConfigs(EConfig.getObjects());
		setMessage(EMessage.getObjects());
		setErrorCodes(ValidationErrorCode.getMap());
		setReferenceHeader(getReferenceHeader());
		setReferences(getReferences());
	}
	
	private Map<String, List<KeyValueString>> getReferences() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		res.putAll(EHeaderMetadataTpp.getMap());
		res.putAll(EHeaderMetadataShared.getMap());
		return res;
	}

	private ReferenceHeader getReferenceHeader() {
		ReferenceHeader res = new ReferenceHeader();
		res.setLastModified(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
		res.setReferenceMetadatas(getReferenceMetadata());
		res.setVersion(Constant.REFERENCE_VERSION);
		return res;
	}
	
	private List<ReferenceMetadata> getReferenceMetadata() {
		List<ReferenceMetadata> res = new ArrayList<>();
		res.addAll(EHeaderMetadataTpp.getObjects());
		res.addAll(EHeaderMetadataShared.getObjects());
		return res;
	}
}
