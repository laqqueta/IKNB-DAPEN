package id.go.ojk.dppkk.client.builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import id.go.ojk.client.model.config.SubmissionMetadata;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.BaseMetadataBuilder;
import id.go.ojk.dppkk.client.builder.field.ltlb.metadata.MetadataPPIPK;
import id.go.ojk.dppkk.client.builder.field.ltlb.metadata.MetadataPPMPK;
import id.go.ojk.dppkk.client.builder.field.ltlb.metadata.MetadataPPMPM;
import id.go.ojk.dppkk.client.builder.field.rb.metadata.MetadataRb;
import id.go.ojk.dppkk.client.builder.field.rb.metadata.MetadataRe;
import id.go.ojk.dppkk.client.builder.field.rb.metadata.MetadataRp;
import id.go.ojk.dppkk.client.builder.field.rb.uus.metadata.MetadataRbUus;
import id.go.ojk.dppkk.client.builder.field.rb.uus.metadata.MetadataReUus;
import id.go.ojk.dppkk.client.builder.field.rb.uus.metadata.MetadataRpUus;
import id.go.ojk.dppkk.client.builder.field.sa.metadata.MetadataSaa;
import id.go.ojk.dppkk.client.builder.field.sa.metadata.MetadataSai;
import id.go.ojk.dppkk.client.builder.field.sa.uus.metadata.MetadataSaaUus;
import id.go.ojk.dppkk.client.builder.field.sa.uus.metadata.MetadataSaiUus;
import id.go.ojk.dppkk.client.builder.field.tl.metadata.MetadataTl;
import id.go.ojk.dppkk.client.builder.field.tl.uus.metadata.MetadataTlUus;
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
		res.getFormats().addAll(MetadataRbUus.getMetadata());
		res.getFormats().addAll(MetadataSaa.getMetadata());
		res.getFormats().addAll(MetadataSaaUus.getMetadata());
		res.getFormats().addAll(MetadataTl.getMetadata());
		res.getFormats().addAll(MetadataTlUus.getMetadata());
		res.getFormats().addAll(MetadataPPMPK.getMetadata());
		res.getFormats().addAll(MetadataPPMPM.getMetadata());
		res.getFormats().addAll(MetadataPPIPK.getMetadata());
		return res;
	}

	private SubmissionMetadata genSummaryMetadata() {
		SubmissionMetadata res = genSubmissionMetadata();
		res.getFormats().addAll(MetadataRe.getMetadata());
		res.getFormats().addAll(MetadataReUus.getMetadata());
		res.getFormats().addAll(MetadataSai.getMetadata());
		res.getFormats().addAll(MetadataSaiUus.getMetadata());
		return res;
	}

	private SubmissionMetadata genSupervisionMetadata() {
		SubmissionMetadata res = genSubmissionMetadata();
		res.getFormats().addAll(MetadataRp.getMetadata());
		res.getFormats().addAll(MetadataRpUus.getMetadata());
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
