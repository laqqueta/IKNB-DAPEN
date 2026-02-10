package id.go.ojk.bpks.client.builder.field.lbbpksdjs.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpksdjs;
import id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference.EHeaderMetadataLbbpksdjs;
import id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference.ER5107ALM;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbAlm extends BaseMetadata {
  public LbAlm(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpksdjs eEnum = EFormLbbpksdjs.ALM;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 32, 32, null, null);

    res.setRequiredPos(ER5107ALM.genRequiredPos());
    res.setUniquePos(ER5107ALM.genUniquePos());
    res.setSavePos(ER5107ALM.genFieldSave());
    res.setSavePosForm(ER5107ALM.genFieldSaveForm());

    res.addSegmentValidations(ER5107ALM.genRowValidation17());
    res.addSegmentValidations(ER5107ALM.genRowValidation21());
    res.addSegmentValidations(ER5107ALM.genRowValidation27());
    res.addSegmentValidations(ER5107ALM.genRowValidation32a());
    res.addSegmentValidations(ER5107ALM.genRowValidation33a());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5107ALM.genRowValidation29());
    res.addSegmentValidations(ER5107ALM.genRowValidation32b());
    res.addSegmentValidations(ER5107ALM.genRowValidation32c());
    res.addSegmentValidations(ER5107ALM.genRowValidation33b());
    res.addSegmentValidations(ER5107ALM.genRowValidation33c());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpksdjs.R5107ALM.getObject()).confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Jatuh tempo < 1 tahun - Rupiah", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(3, null, "Jatuh tempo < 1 tahun - Non Rupiah ", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(4, null, "Jatuh tempo < 1 tahun - Total ", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5107ALM.genFieldValidation05()));
    fs.add(sf(5, null, "1 tahun <= jatuh tempo < 3 tahun - Rupiah", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(6, null, "1 tahun <= jatuh tempo < 3 tahun - Non Rupiah ", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(7, null, "1 tahun <= jatuh tempo < 3 tahun - Total ", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5107ALM.genFieldValidation08()));
    fs.add(sf(8, null, "3 tahun <= jatuh tempo < 5 tahun - Rupiah", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(9, null, "3 tahun <= jatuh tempo < 5 tahun - Non Rupiah ", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(10, null, "3 tahun <= jatuh tempo < 5 tahun - Total ", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5107ALM.genFieldValidation11()));
    fs.add(sf(11, null, "5 tahun <= jatuh tempo < 10 tahun - Rupiah", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(12, null, "5 tahun <= jatuh tempo < 10 tahun - Non Rupiah ", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(13, null, "5 tahun <= jatuh tempo < 10 tahun - Total ", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5107ALM.genFieldValidation14()));
    fs.add(sf(14, null, ">= 10 tahun - Rupiah", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(15, null, ">= 10 tahun - Non Rupiah ", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(16, null, ">= 10 tahun - Total ", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5107ALM.genFieldValidation17()));
    fs.add(sf(17, null, "Total - Rupiah", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5107ALM.genFieldValidation18()));
    fs.add(sf(18, null, "Total - Non Rupiah ", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5107ALM.genFieldValidation19()));
    fs.add(sf(19, null, "Total - Total ", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5107ALM.genFieldValidation20()));
    return res;
  }
}
