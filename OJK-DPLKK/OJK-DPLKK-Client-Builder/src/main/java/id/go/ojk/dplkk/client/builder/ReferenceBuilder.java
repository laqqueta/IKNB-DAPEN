package id.go.ojk.dplkk.client.builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.BaseReferenceBuilder;
import id.go.ojk.conf.client.field.reference.EConfig;
import id.go.ojk.dplkk.client.builder.field.apu.reference.EHeaderMetadataPenilaian;
import id.go.ojk.dplkk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dplkk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.dplkk.client.builder.field.sa.reference.EHeaderMetadataSa;
import id.go.ojk.dplkk.client.builder.field.setup.EMessage;
import id.go.ojk.dplkk.client.builder.field.tl.reference.EHeaderMetadataTl;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceHeader;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataLkdpDplk;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataSharedLblt;
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
		res.putAll(EHeaderMetadataShared.getMap());
		res.putAll(EHeaderMetadataRb.getMap());
		res.putAll(EHeaderMetadataSa.getMap());
		res.putAll(EHeaderMetadataPenilaian.getMap());
		res.putAll(EHeaderMetadataTl.getMap());
		res.putAll(EHeaderMetadataSharedLblt.getMap());
		res.putAll(EHeaderMetadataLkdpDplk.getMap());
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
		res.addAll(EHeaderMetadataShared.getObjects());
		res.addAll(EHeaderMetadataRb.getObjects());
		res.addAll(EHeaderMetadataSa.getObjects());
		res.addAll(EHeaderMetadataPenilaian.getObjects());
		res.addAll(EHeaderMetadataTl.getObjects());
		res.addAll(EHeaderMetadataSharedLblt.getObjects());
		res.addAll(EHeaderMetadataLkdpDplk.getObjects());
		return res;
	}
}
