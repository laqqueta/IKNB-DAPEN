package id.go.ojk.bpks.client.builder.field.lbbpkslk.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.EHeaderMetadataLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.ER5006ALM;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbAlm extends BaseMetadata {
  public LbAlm(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslk eEnum = EFormLbbpkslk.ALM;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 40, 40);

    res.setRequiredPos(ER5006ALM.genRequiredPos());
    res.setUniquePos(ER5006ALM.genUniquePos());
    res.setSavePos(ER5006ALM.genFieldSave());
    res.setSavePosForm(ER5006ALM.genFieldSave());

    
    ER5006ALM.genColValidationsA().forEach(v -> {
      res.addSegmentValidations(v);
    });

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5006ALM.genRowValidation26());
    res.addSegmentValidations(ER5006ALM.genRowValidation40());
    res.addSegmentValidations(ER5006ALM.genRowValidation41());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpkslk.R5006ALM.getObject()).confRegex(patternAlfaNumeric)).confUniqueType(U));
    fs.add(sf(2, null, "Jatuh tempo < 1 tahun(Rupiah (c))", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(3, null, "Jatuh tempo < 1 tahun(Non Rupiah(d))", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(4, null, "Jatuh tempo < 1 tahun(Total (e))", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5006ALM.genFieldValidation05()));
    fs.add(sf(5, null, "1 tahun <= jatuh tempo < 3 tahun(Rupiah(f))", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(6, null, "1 tahun <= jatuh tempo < 3 tahun(Non Rupiah(g))", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(7, null, "1 tahun <= jatuh tempo < 3 tahun(Total (h))", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5006ALM.genFieldValidation08()));
    fs.add(sf(8, null, "3 tahun <= jatuh tempo < 5 tahun(Rupiah(i))", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(9, null, "3 tahun <= jatuh tempo < 5 tahun(Non Rupiah(j))", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(10, null, "3 tahun <= jatuh tempo < 5 tahun(Total (k))", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5006ALM.genFieldValidation11()));
    fs.add(sf(11, null, "5 tahun <= jatuh tempo < 10 tahun(Rupiah(l))", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(12, null, "5 tahun <= jatuh tempo < 10 tahun(Non Rupiah(m))", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(13, null, "5 tahun <= jatuh tempo < 10 tahun(Total (n))", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5006ALM.genFieldValidation14()));
    fs.add(sf(14, null, "<= 10 tahun(Rupiah(o))", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(15, null, "<= 10 tahun(Non Rupiah(p))", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(16, null, "<= 10 tahun(Total (q))", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5006ALM.genFieldValidation17()));
    fs.add(sf(17, null, "Total ( jumlah (c) s.d. (t) )(Rupiah (c))", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5006ALM.genFieldValidation18()));
    fs.add(sf(18, null, "Total ( jumlah (c) s.d. (t) )(Non Rupiah(s))", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5006ALM.genFieldValidation19()));
    fs.add(sf(19, null, "Total ( jumlah (c) s.d. (t) )(Total (t))", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5006ALM.genFieldValidation20()));

    return res;
  }
}
