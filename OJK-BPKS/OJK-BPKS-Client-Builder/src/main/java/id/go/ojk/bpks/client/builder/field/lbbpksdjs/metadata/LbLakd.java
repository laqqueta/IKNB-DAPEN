package id.go.ojk.bpks.client.builder.field.lbbpksdjs.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.*;
import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpksdjs;
import id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference.EHeaderMetadataLbbpksdjs;
import id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference.ER5110LAKD;
import id.go.ojk.bpks.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLakd extends BaseMetadata {
  public LbLakd(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpksdjs eEnum = EFormLbbpksdjs.LAKD;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 1, null);

    res.setRequiredPos(ER5110LAKD.genRequiredPos());
    res.setUniquePos(ER5110LAKD.genUniquePos());
    res.setSavePos(ER5110LAKD.genFieldSave());

    res.addSegmentValidations(ER5110LAKD.genValidationTotal());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 14, 14, refTable)
        .confReference(EHeaderMetadataLbbpksdjs.R5110LAKD.getObject()).confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Lokasi", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.LOKASI_DATI_2.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5110LAKD.genConditionalExistA())));
    fs.add(sf(3, null, "Aset Kontijensi", sv(M, 1, 20, numeric)));
    fs.add(sf(4, null, "Pembayaran Aset Kontijensi - Periode", sv(C, 1, 20, all)
        .confConditionalRequired(ER5110LAKD.genConditionalExistA())));
    fs.add(sf(5, null, "Pembayaran Aset Kontijensi - Jumlah", sv(M, 1, 20, numeric)));
    fs.add(sf(6, null, "Rekonsiliasi Internal Tunggakan - Periode", sv(C, 1, 20, all)
        .confRegex(patternBirthPlace)
        .confConditionalRequired(ER5110LAKD.genConditionalExistA())));
    fs.add(sf(7, null, "Rekonsiliasi Internal Tunggakan - Jumlah", sv(M, 1, 20, numeric)));
    fs.add(sf(8, null, "Saldo Aset Kontijensi", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER5110LAKD.genFieldValidation03()));
    return res;
  }
}
