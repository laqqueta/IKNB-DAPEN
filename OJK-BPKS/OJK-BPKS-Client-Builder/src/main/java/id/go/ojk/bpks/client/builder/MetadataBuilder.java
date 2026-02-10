package id.go.ojk.bpks.client.builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import id.go.ojk.bpks.client.builder.field.lbbpksdjs.metadata.MetadataLbbpksdjs;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.metadata.MetadataLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.metadata.MetadataLbbpkslpp;
import id.go.ojk.client.model.config.SubmissionMetadata;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.BaseMetadataBuilder;
import id.go.ojk.lib.client.constant.LogTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MetadataBuilder extends BaseMetadataBuilder {

  public static void main(String[] args) {
    try {
      final String ROOT_FOLDER = args.length > 0 ? args[0] : "";
      log.info(LogTemplate.STARTING_BUILDER_METADATA);
      MetadataBuilder builder = new MetadataBuilder(ROOT_FOLDER, HomeController.homeButton);
      String jarFile = builder.buildAll();
      builder.testBundle(jarFile);
    } finally {
      log.info(LogTemplate.STOPPED);
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
    res.getFormats().addAll(MetadataLbbpkslk.getMetadata());
    res.getFormats().addAll(MetadataLbbpksdjs.getMetadata());
    res.getFormats().addAll(MetadataLbbpkslpp.getMetadata());
    return res;
  }

  private SubmissionMetadata genSummaryMetadata() {
    SubmissionMetadata res = genSubmissionMetadata();
    return res;
  }

  private SubmissionMetadata genSupervisionMetadata() {
    SubmissionMetadata res = genSubmissionMetadata();
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
