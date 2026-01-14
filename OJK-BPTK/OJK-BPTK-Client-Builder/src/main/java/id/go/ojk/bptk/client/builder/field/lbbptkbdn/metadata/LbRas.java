package id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.EHeaderMetadataLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.ER5307RAS;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbRas extends BaseMetadata {
  public LbRas(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkbdn eEnum = EFormLbbptkbdn.RAS;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 27, 27);

    res.setRequiredPos(ER5307RAS.genRequiredPos());
    res.setUniquePos(ER5307RAS.genUniquePos());
    res.setSavePos(ER5307RAS.genFieldSave());

    res.addSegmentValidations(ER5307RAS.genRegexValidation01());
    res.addSegmentValidations(ER5307RAS.genRegexValidation02());
    res.addSegmentValidations(ER5307RAS.genMaxLengthValidation());
    res.addSegmentValidations(ER5307RAS.genMaxLengthValidation2());

    res.addSegmentValidations(ER5307RAS.genRowValidation04());
    res.addSegmentValidations(ER5307RAS.genRowValidation08());
    res.addSegmentValidations(ER5307RAS.genRowValidation11());
    res.addSegmentValidations(ER5307RAS.genRowValidation14());
    res.addSegmentValidations(ER5307RAS.genRowValidation17());
    res.addSegmentValidations(ER5307RAS.genRowValidation21());
    res.addSegmentValidations(ER5307RAS.genRowValidation22());
    res.addSegmentValidations(ER5307RAS.genRowValidation25());
    res.addSegmentValidations(ER5307RAS.genRowValidation28());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkbdn.R5307RAS.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Rasio", sv(M, 1, Integer.MAX_VALUE, all2)));
    return res;
  }
}
