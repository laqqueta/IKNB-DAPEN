package id.go.ojk.dppks.client.builder;

import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.BaseReferenceBuilder;
import id.go.ojk.conf.client.field.reference.EConfig;
import id.go.ojk.dppks.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dppks.client.builder.field.sa.reference.EHeaderMetadataSa;
import id.go.ojk.dppks.client.builder.field.setup.EMessage;
import id.go.ojk.dppks.client.builder.field.tl.reference.EHeaderMetadataTl;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceHeader;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.metadata.module.lblt.dppk.header.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		res.putAll(EHeaderMetadataRb.getMap());
		res.putAll(EHeaderMetadataSa.getMap());
		res.putAll(EHeaderMetadataTl.getMap());
		res.putAll(EHeaderMetadataSharedLkbt.getMap());
		res.putAll(EHeaderMetadataPpmpk.getMap());
		res.putAll(EHeaderMetadataPpmpm.getMap());
		res.putAll(EHeaderMetadataPpipk.getMap());
		res.putAll(EHeaderMetadataPpipm.getMap());
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
		res.addAll(EHeaderMetadataRb.getObjects());
		res.addAll(EHeaderMetadataSa.getObjects());
		res.addAll(EHeaderMetadataTl.getObjects());
		res.addAll(EHeaderMetadataSharedLkbt.getObjects());
		res.addAll(EHeaderMetadataPpmpk.getObjects());
		res.addAll(EHeaderMetadataPpmpm.getObjects());
		res.addAll(EHeaderMetadataPpipk.getObjects());
		res.addAll(EHeaderMetadataPpipm.getObjects());
		return res;
	}
}
