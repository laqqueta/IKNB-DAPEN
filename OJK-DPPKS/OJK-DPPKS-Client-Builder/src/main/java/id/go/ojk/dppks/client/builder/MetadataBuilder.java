package id.go.ojk.dppks.client.builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import id.go.ojk.client.model.config.SubmissionMetadata;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.BaseMetadataBuilder;
import id.go.ojk.dppks.client.builder.field.lblt.MetadataPPIPK;
import id.go.ojk.dppks.client.builder.field.lblt.MetadataPPIPM;
import id.go.ojk.dppks.client.builder.field.lblt.MetadataPPMPK;
import id.go.ojk.dppks.client.builder.field.lblt.MetadataPPMPM;
import id.go.ojk.dppks.client.builder.field.rb.metadata.MetadataRb;
import id.go.ojk.dppks.client.builder.field.rb.metadata.MetadataRe;
import id.go.ojk.dppks.client.builder.field.rb.metadata.MetadataRp;
import id.go.ojk.dppks.client.builder.field.sa.metadata.MetadataSaa;
import id.go.ojk.dppks.client.builder.field.sa.metadata.MetadataSai;
import id.go.ojk.dppks.client.builder.field.tl.metadata.MetadataTl;
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
		res.getFormats().addAll(MetadataSaa.getMetadata());
		res.getFormats().addAll(MetadataTl.getMetadata());
		res.getFormats().addAll(MetadataPPMPK.getMetadata());
		res.getFormats().addAll(MetadataPPMPM.getMetadata());
		res.getFormats().addAll(MetadataPPIPK.getMetadata());
		res.getFormats().addAll(MetadataPPIPM.getMetadata());
		return res;
	}

	private SubmissionMetadata genSummaryMetadata() {
		SubmissionMetadata res = genSubmissionMetadata();
		res.getFormats().addAll(MetadataRe.getMetadata());
		res.getFormats().addAll(MetadataSai.getMetadata());
		return res;
	}

	private SubmissionMetadata genSupervisionMetadata() {
		SubmissionMetadata res = genSubmissionMetadata();
		res.getFormats().addAll(MetadataRp.getMetadata());
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
