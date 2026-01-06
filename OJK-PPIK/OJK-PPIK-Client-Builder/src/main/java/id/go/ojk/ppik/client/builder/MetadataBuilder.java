package id.go.ojk.ppik.client.builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import id.go.ojk.client.model.config.SubmissionMetadata;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.BaseMetadataBuilder;
import id.go.ojk.ppik.client.Constant;
import id.go.ojk.ppik.client.builder.field.lb.metadata.MetadataLb;
import id.go.ojk.ppik.client.builder.field.lb.uus.metadata.MetadataLbUus;
import id.go.ojk.ppik.client.builder.field.sa.metadata.MetadataSaa;
import id.go.ojk.ppik.client.builder.field.sa.metadata.MetadataSai;
import id.go.ojk.ppik.client.builder.field.sa.uus.metadata.MetadataSaaUus;
import id.go.ojk.ppik.client.builder.field.sa.uus.metadata.MetadataSaiUus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MetadataBuilder extends BaseMetadataBuilder {

	public static void main(String[] args) {
		try {
			final String ROOT_FOLDER = args.length > 0 ? args[0] : "";
			log.info("starting builder");
			MetadataBuilder builder = new MetadataBuilder(ROOT_FOLDER, HomeController.homeButton);
			String jarFile = builder.buildAll();
			builder.testBundle(jarFile);
		} finally {
			log.info("stopped");
		}
	}

	public MetadataBuilder(String rootFolder, String base64Key) {
		super(rootFolder, base64Key);
	}

	@Override
	public void init() {
		setMetadata(genMetadata());
		setSummaryMetadata(genSummaryMetadata());
		setSupervisionMetadata(genSupervisionMetadata());
	}

	private SubmissionMetadata genMetadata() {
		SubmissionMetadata res = genSubmissionMetadata();
		res.getFormats().addAll(MetadataLb.getMetadata());
		res.getFormats().addAll(MetadataLbUus.getMetadata());
		res.getFormats().addAll(MetadataSaa.getMetadata());
		res.getFormats().addAll(MetadataSaaUus.getMetadata());
		return res;
	}

	private SubmissionMetadata genSummaryMetadata() {
		SubmissionMetadata res = genSubmissionMetadata();
		res.getFormats().addAll(MetadataSai.getMetadata());
		res.getFormats().addAll(MetadataSaiUus.getMetadata());
		return res;
	}

	private SubmissionMetadata genSupervisionMetadata() {
		return genSubmissionMetadata();
	}

	private SubmissionMetadata genSubmissionMetadata() {
		SubmissionMetadata res = new SubmissionMetadata();
		res.setVersion(Constant.METADATA_VERSION);
		res.setLastModified(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
		res.setEntityTypeCode(Constant.SECTOR.getType().getCode());
		res.setEntityTypeDesc(Constant.SECTOR.getName());
		return res;
	}
}
