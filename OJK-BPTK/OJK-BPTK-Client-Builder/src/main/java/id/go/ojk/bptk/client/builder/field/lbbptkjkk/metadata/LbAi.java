package id.go.ojk.bptk.client.builder.field.lbbptkjkk.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjkk;
import id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference.EHeaderMetadataLbbptkjkk;
import id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference.ER5405AI;
import id.go.ojk.bptk.client.builder.field.lbbptkjkm.metadata.MetadataLbbptkjkm;
import id.go.ojk.bptk.client.builder.field.ltbptk.metadata.MetadataLtbptkjkk;
import id.go.ojk.bptk.client.builder.field.ltbptk.metadata.MetadataLtbptkjkm;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbAi extends BaseMetadata {
  public LbAi(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjkk eEnum = EFormLbbptkjkk.AI;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 11, 11);

    res.setRequiredPos(ER5405AI.genRequiredPos());
    res.setUniquePos(ER5405AI.genUniquePos());
    res.setSavePos(ER5405AI.genFieldSave());
    res.setSavePosForm(ER5405AI.genFieldSave());

    res.addSegmentValidations(ER5405AI.genRowValidation12a());

    /* -- ANTAR FORM -- */
    if (reportCode.equalsIgnoreCase(MetadataLbbptkjkk.REPORT_CODE) ||
        reportCode.equalsIgnoreCase(MetadataLtbptkjkk.REPORT_CODE)) {
      res.addSegmentValidations(ER5405AI.genRowValidation12Jkk());
    } else if (reportCode.equalsIgnoreCase(MetadataLbbptkjkm.REPORT_CODE) ||
        reportCode.equalsIgnoreCase(MetadataLtbptkjkm.REPORT_CODE)) {
      res.addSegmentValidations(ER5405AI.genRowValidation12Jkm());
    }

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
        .confReference(EHeaderMetadataLbbptkjkk.R5405AI.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
