package id.go.ojk.bptk.client.builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.bptk.client.builder.field.labptkjht.reference.EHeaderMetadataLabptkjht;
import id.go.ojk.bptk.client.builder.field.labptkjkk.reference.EHeaderMetadataLabptkjkk;
import id.go.ojk.bptk.client.builder.field.labptkjkm.reference.EHeaderMetadataLabptkjkm;
import id.go.ojk.bptk.client.builder.field.labptkjkp.reference.EHeaderMetadataLabptkjkp;
import id.go.ojk.bptk.client.builder.field.labptkjp.reference.EHeaderMetadataLabptkjp;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.EHeaderMetadataLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkjht.reference.EHeaderMetadataLbbptkjht;
import id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference.EHeaderMetadataLbbptkjkk;
import id.go.ojk.bptk.client.builder.field.lbbptkjkm.reference.EHeaderMetadataLbbptkjkm;
import id.go.ojk.bptk.client.builder.field.lbbptkjkp.reference.EHeaderMetadataLbbptkjkp;
import id.go.ojk.bptk.client.builder.field.lbbptkjp.reference.EHeaderMetadataLbbptkjp;
import id.go.ojk.bptk.client.builder.field.lpbptkjht.reference.EHeaderMetadataLpbptkjht;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.reference.EHeaderMetadataLpbptkjkk;
import id.go.ojk.bptk.client.builder.field.lpbptkjkm.reference.EHeaderMetadataLpbptkjkm;
import id.go.ojk.bptk.client.builder.field.lpbptkjkp.reference.EHeaderMetadataLpbptkjkp;
import id.go.ojk.bptk.client.builder.field.lpbptkjp.reference.EHeaderMetadataLpbptkjp;
import id.go.ojk.bptk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.bptk.client.builder.field.setup.EMessage;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.BaseReferenceBuilder;
import id.go.ojk.conf.client.field.reference.EConfig;
import id.go.ojk.lib.client.constant.LogTemplate;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceHeader;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReferenceBuilder extends BaseReferenceBuilder {

	public static void main(String[] args) {
		try {
			final String ROOT_FOLDER = args.length > 0 ? args[0] : "";
			log.info(LogTemplate.STARTING_BUILDER_REFERENCE);
			ReferenceBuilder builder = new ReferenceBuilder(ROOT_FOLDER, HomeController.homeButton);
			String jarFile = builder.buildAll();
			builder.testBundle(jarFile);
		} finally {
			log.info(LogTemplate.STOPPED);
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
		res.putAll(EHeaderMetadataLbbptkbdn.getMap());
		res.putAll(EHeaderMetadataLbbptkjkk.getMap());
		res.putAll(EHeaderMetadataLbbptkjkm.getMap());
		res.putAll(EHeaderMetadataLbbptkjht.getMap());
		res.putAll(EHeaderMetadataLbbptkjkp.getMap());
		res.putAll(EHeaderMetadataLbbptkjp.getMap());
		// LPP
		res.putAll(EHeaderMetadataLpbptkjkk.getMap());
		res.putAll(EHeaderMetadataLpbptkjkm.getMap());
		res.putAll(EHeaderMetadataLpbptkjht.getMap());
		res.putAll(EHeaderMetadataLpbptkjkp.getMap());
		res.putAll(EHeaderMetadataLpbptkjp.getMap());
    // Aktuaris
    res.putAll(EHeaderMetadataLabptkjkk.getMap());
    res.putAll(EHeaderMetadataLabptkjkm.getMap());
    res.putAll(EHeaderMetadataLabptkjht.getMap());
    res.putAll(EHeaderMetadataLabptkjkp.getMap());
    res.putAll(EHeaderMetadataLabptkjp.getMap());
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
		res.addAll(EHeaderMetadataLbbptkbdn.getObjects());
		res.addAll(EHeaderMetadataLbbptkjkk.getObjects());
		res.addAll(EHeaderMetadataLbbptkjkm.getObjects());
		res.addAll(EHeaderMetadataLbbptkjht.getObjects());
		res.addAll(EHeaderMetadataLbbptkjkp.getObjects());
		res.addAll(EHeaderMetadataLbbptkjp.getObjects());
		// LPP
		res.addAll(EHeaderMetadataLpbptkjkk.getObjects());
    res.addAll(EHeaderMetadataLpbptkjkm.getObjects());
    res.addAll(EHeaderMetadataLpbptkjht.getObjects());
    res.addAll(EHeaderMetadataLpbptkjkp.getObjects());
    res.addAll(EHeaderMetadataLpbptkjp.getObjects());
    // Aktuaris
    res.addAll(EHeaderMetadataLabptkjkk.getObjects());
    res.addAll(EHeaderMetadataLabptkjkm.getObjects());
    res.addAll(EHeaderMetadataLabptkjht.getObjects());
    res.addAll(EHeaderMetadataLabptkjkp.getObjects());
    res.addAll(EHeaderMetadataLabptkjp.getObjects());
		return res;
	}
}
