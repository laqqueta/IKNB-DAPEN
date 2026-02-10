package id.go.ojk.bptk.client.builder.field.lbbptkjp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjp;
import id.go.ojk.bptk.client.builder.field.lbbptkjp.reference.EHeaderMetadataLbbptkjp;
import id.go.ojk.bptk.client.builder.field.lbbptkjp.reference.ER5812NKA;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbNka extends BaseMetadata {
  public LbNka(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjp eEnum = EFormLbbptkjp.NKA;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 0, null);

    res.setSavePos(ER5812NKA.genFieldSave());
    res.setRequiredPos(ER5812NKA.genRequiredPos());
    res.setUniquePos(ER5812NKA.genUniquePos());

    res.addSegmentValidations(ER5812NKA.genValidationLength20());
    res.addSegmentValidations(ER5812NKA.genValidationLength100());
    res.addSegmentValidations(ER5812NKA.genValidationTypeNumericNegative());
    res.addSegmentValidations(ER5812NKA.genValidationTypeAll());
    res.addSegmentValidations(ER5812NKA.genValidationTypeDecimal());

    res.addSegmentValidations(ER5812NKA.genRowValidation08());
    res.addSegmentValidations(ER5812NKA.genRowValidation10());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkjp.R5812NKA.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Periode Bulan Laporan", sv(M, 1, Integer.MAX_VALUE, all2)));
    fs.add(sf(3, null, "Desember tahun x-1", sv(M, 1, Integer.MAX_VALUE, all2)));
    return res;
  }
}
