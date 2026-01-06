package id.go.ojk.asrjs.client.builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import id.go.ojk.asrjs.client.builder.field.apu.metadata.MetadataPenilaian;
import id.go.ojk.asrjs.client.builder.field.apu.metadata.MetadataRealisasi;
import id.go.ojk.asrjs.client.builder.field.apu.metadata.MetadataRencana;
import id.go.ojk.asrjs.client.builder.field.lb.metadata.MetadataLb;
import id.go.ojk.asrjs.client.builder.field.pls.metadata.MetadataPls;
import id.go.ojk.asrjs.client.builder.field.rb.metadata.MetadataRb;
import id.go.ojk.asrjs.client.builder.field.rb.metadata.MetadataRe;
import id.go.ojk.asrjs.client.builder.field.rb.metadata.MetadataRp;
import id.go.ojk.asrjs.client.builder.field.sa.metadata.MetadataSaa;
import id.go.ojk.asrjs.client.builder.field.sa.metadata.MetadataSai;
import id.go.ojk.client.model.config.SubmissionMetadata;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.BaseMetadataBuilder;
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
		res.getFormats().addAll(MetadataRb.getMetadata());
		res.getFormats().addAll(MetadataLb.getMetadata());
		res.getFormats().addAll(MetadataSaa.getMetadata());
		res.getFormats().addAll(MetadataPenilaian.getMetadata());
		res.getFormats().addAll(MetadataPls.getMetadata());
		return res;
	}

	private SubmissionMetadata genSummaryMetadata() {
		SubmissionMetadata res = genSubmissionMetadata();
		res.getFormats().addAll(MetadataRe.getMetadata());
		res.getFormats().addAll(MetadataSai.getMetadata());
		res.getFormats().addAll(MetadataRencana.getMetadata());
		return res;
	}

	private SubmissionMetadata genSupervisionMetadata() {
		SubmissionMetadata res = genSubmissionMetadata();
		res.getFormats().addAll(MetadataRp.getMetadata());
		res.getFormats().addAll(MetadataRealisasi.getMetadata());
		return res;
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
