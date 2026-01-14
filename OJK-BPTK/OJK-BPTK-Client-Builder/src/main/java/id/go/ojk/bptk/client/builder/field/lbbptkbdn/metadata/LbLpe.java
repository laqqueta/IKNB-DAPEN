package id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.EHeaderMetadataLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.ER5303LPE;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLpe extends BaseMetadata {
  public LbLpe(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkbdn eEnum = EFormLbbptkbdn.LPE;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 39, 39);

    res.setRequiredPos(ER5303LPE.genRequiredPos());
    res.setUniquePos(ER5303LPE.genUniquePos());
    res.setSavePos(ER5303LPE.genFieldSave());

    res.addSegmentValidations(ER5303LPE.genRowValidation22());
    res.addSegmentValidations(ER5303LPE.genRowValidation40());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkbdn.R5303LPE.getObject())
        .confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Modal", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(3, null, "Tambahan Modal Disetor", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(4, null, "Saldo Penghasilan (Beban) Neto-SKP", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(5, null, "Saldo Penghasilan (Beban) Neto-Operasional", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(6, null, "Komponen Ekuitas Lainnya", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(7, null, "Jumlah Ekuitas", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(8, null, "Kepentingan Non Pengendali", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(9, null, "Jumlah Ekuitas", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
