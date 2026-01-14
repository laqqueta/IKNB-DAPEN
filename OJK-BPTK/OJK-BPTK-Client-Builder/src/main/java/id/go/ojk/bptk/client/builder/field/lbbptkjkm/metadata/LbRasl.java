package id.go.ojk.bptk.client.builder.field.lbbptkjkm.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjkm;
import id.go.ojk.bptk.client.builder.field.lbbptkjkm.reference.EHeaderMetadataLbbptkjkm;
import id.go.ojk.bptk.client.builder.field.lbbptkjkm.reference.ER5508RASL;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbRasl extends BaseMetadata {
  public LbRasl(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjkm eEnum = EFormLbbptkjkm.RASL;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 30, 30);

    res.setRequiredPos(ER5508RASL.genRequiredPos());
    res.setUniquePos(ER5508RASL.genUniquePos());
    res.setSavePos(ER5508RASL.genFieldSave());

    res.addSegmentValidations(ER5508RASL.genRowValidation18a());
    res.addSegmentValidations(ER5508RASL.genRowValidation20());
    res.addSegmentValidations(ER5508RASL.genRowValidation24());
    res.addSegmentValidations(ER5508RASL.genRowValidation30());
    res.addSegmentValidations(ER5508RASL.genRowValidation31());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5508RASL.genRowValidation18b());
    res.addSegmentValidations(ER5508RASL.genRowValidation41());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
        .confReference(EHeaderMetadataLbbptkjkm.R5508RASL.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Jatuh Tempo Aset dan Liabilitas, Jatuh tempo < 1 thn, Rp", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(3, null, "Jatuh Tempo Aset dan Liabilitas, Jatuh tempo < 1 thn, Non Rp", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(4, null, "Jatuh Tempo Aset dan Liabilitas, Jatuh tempo < 1 thn, Total", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5508RASL.genFieldValidation05()));
    fs.add(sf(5, null, "Jatuh Tempo Aset dan Liabilitas, 1 thn ≤ jatuh tempo < 3 thn, Rp", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(6, null, "Jatuh Tempo Aset dan Liabilitas, 1 thn ≤ jatuh tempo < 3 thn, Non Rp", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(7, null, "Jatuh Tempo Aset dan Liabilitas, 1 thn ≤ jatuh tempo < 3 thn, Total", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5508RASL.genFieldValidation08()));
    fs.add(sf(8, null, "Jatuh Tempo Aset dan Liabilitas, 3 thn ≤ jatuh tempo < 5 thn, Rp", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(9, null, "Jatuh Tempo Aset dan Liabilitas, 3 thn ≤ jatuh tempo < 5 thn, Non Rp", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(10, null, "Jatuh Tempo Aset dan Liabilitas, 3 thn ≤ jatuh tempo < 5 thn, Total", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5508RASL.genFieldValidation11()));
    fs.add(sf(11, null, "Jatuh Tempo Aset dan Liabilitas, 5 thn ≤ jatuh tempo < 10 thn, Rp", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(12, null, "Jatuh Tempo Aset dan Liabilitas, 5 thn ≤ jatuh tempo < 10 thn, Non Rp", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(13, null, "Jatuh Tempo Aset dan Liabilitas, 5 thn ≤ jatuh tempo < 10 thn, Total", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5508RASL.genFieldValidation14()));
    fs.add(sf(14, null, "Jatuh Tempo Aset dan Liabilitas, ≥ 10 thn, Rp", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(15, null, "Jatuh Tempo Aset dan Liabilitas, ≥ 10 thn, Non Rp", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(16, null, "Jatuh Tempo Aset dan Liabilitas, ≥ 10 thn, Total", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5508RASL.genFieldValidation17()));
    fs.add(sf(17, null, "Jatuh Tempo Aset dan Liabilitas, Total, Rp", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(18, null, "Jatuh Tempo Aset dan Liabilitas, Total, Non Rp", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(19, null, "Jatuh Tempo Aset dan Liabilitas, Total, Total", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5508RASL.genFieldValidation20()));
    return res;
  }
}
