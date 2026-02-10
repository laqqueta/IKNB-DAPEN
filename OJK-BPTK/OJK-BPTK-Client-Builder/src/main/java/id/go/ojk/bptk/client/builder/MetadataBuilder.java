package id.go.ojk.bptk.client.builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import id.go.ojk.bptk.client.builder.field.labptkjht.metadata.MetadataLabptkjht;
import id.go.ojk.bptk.client.builder.field.labptkjkk.metadata.MetadataLabptkjkk;
import id.go.ojk.bptk.client.builder.field.labptkjkm.metadata.MetadataLabptkjkm;
import id.go.ojk.bptk.client.builder.field.labptkjkp.metadata.MetadataLabptkjkp;
import id.go.ojk.bptk.client.builder.field.labptkjp.metadata.MetadataLabptkjp;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata.MetadataLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkjht.metadata.MetadataLbbptkjht;
import id.go.ojk.bptk.client.builder.field.lbbptkjkk.metadata.MetadataLbbptkjkk;
import id.go.ojk.bptk.client.builder.field.lbbptkjkm.metadata.MetadataLbbptkjkm;
import id.go.ojk.bptk.client.builder.field.lbbptkjkp.metadata.MetadataLbbptkjkp;
import id.go.ojk.bptk.client.builder.field.lbbptkjp.metadata.MetadataLbbptkjp;
import id.go.ojk.bptk.client.builder.field.lpbptkjht.metadata.MetadataLpbptkjht;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata.MetadataLpbptkjkk;
import id.go.ojk.bptk.client.builder.field.lpbptkjkm.metadata.MetadataLpbptkjkm;
import id.go.ojk.bptk.client.builder.field.lpbptkjkp.metadata.MetadataLpbptkjkp;
import id.go.ojk.bptk.client.builder.field.lpbptkjp.metadata.MetadataLpbptkjp;
import id.go.ojk.bptk.client.builder.field.ltbptk.metadata.MetadataLtbptkbdn;
import id.go.ojk.bptk.client.builder.field.ltbptk.metadata.MetadataLtbptkjht;
import id.go.ojk.bptk.client.builder.field.ltbptk.metadata.MetadataLtbptkjkk;
import id.go.ojk.bptk.client.builder.field.ltbptk.metadata.MetadataLtbptkjkm;
import id.go.ojk.bptk.client.builder.field.ltbptk.metadata.MetadataLtbptkjkp;
import id.go.ojk.bptk.client.builder.field.ltbptk.metadata.MetadataLtbptkjp;
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
    // LB
    res.getFormats().addAll(MetadataLbbptkbdn.getMetadata());
    res.getFormats().addAll(MetadataLbbptkjkk.getMetadata());
    res.getFormats().addAll(MetadataLbbptkjkm.getMetadata());
    res.getFormats().addAll(MetadataLbbptkjht.getMetadata());
    res.getFormats().addAll(MetadataLbbptkjkp.getMetadata());
    res.getFormats().addAll(MetadataLbbptkjp.getMetadata());
    // LT
    res.getFormats().addAll(MetadataLtbptkbdn.getMetadata());
    res.getFormats().addAll(MetadataLtbptkjkk.getMetadata());
    res.getFormats().addAll(MetadataLtbptkjkm.getMetadata());
    res.getFormats().addAll(MetadataLtbptkjht.getMetadata());
    res.getFormats().addAll(MetadataLtbptkjkp.getMetadata());
    res.getFormats().addAll(MetadataLtbptkjp.getMetadata());
    // LPP
    res.getFormats().addAll(MetadataLpbptkjkk.getMetadata());
    res.getFormats().addAll(MetadataLpbptkjkm.getMetadata());
    res.getFormats().addAll(MetadataLpbptkjht.getMetadata());
    res.getFormats().addAll(MetadataLpbptkjkp.getMetadata());
    res.getFormats().addAll(MetadataLpbptkjp.getMetadata());
    // Aktuaris
    res.getFormats().addAll(MetadataLabptkjkk.getMetadata());
    res.getFormats().addAll(MetadataLabptkjkm.getMetadata());
    res.getFormats().addAll(MetadataLabptkjht.getMetadata());
    res.getFormats().addAll(MetadataLabptkjkp.getMetadata());
    res.getFormats().addAll(MetadataLabptkjp.getMetadata());
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
