package id.go.ojk.bpks.client.builder.field.lbbpksdjs.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.DataType.year;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpksdjs;
import id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference.EHeaderMetadataLbbpksdjs;
import id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference.ER5109RPI;
import id.go.ojk.bpks.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbRpi extends BaseMetadata {
  public LbRpi(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpksdjs eEnum = EFormLbbpksdjs.RPI;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 1, null);

    res.setRequiredPos(ER5109RPI.genRequiredPos());
    res.setUniquePos(ER5109RPI.genUniquePos());
    res.setSavePos(ER5109RPI.genFieldSave());
    res.setSavePosForm(ER5109RPI.genFieldSave());

    res.addSegmentValidations(ER5109RPI.genValidationTotal());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpksdjs.R5109RPI.getObject()).confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Nama Peserta", sv(C, 1, 100, all)
        .confConditionalRequired(ER5109RPI.genConditionalExistB())));
    fs.add(sf(3, null, "Nama Perusahaan", sv(C, 1, 100, all)
        .confConditionalRequired(ER5109RPI.genConditionalExistB())));
    fs.add(sf(4, null, "Jenis Piutang Iuran", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.JENIS_PIUTANG_IURAN.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5109RPI.genConditionalExistA())));
    fs.add(sf(5, null, "Jumlah Kontrak", sv(M, 1, 10, numeric)));
    fs.add(sf(6, null, "Segmen Peserta", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.SEGMEN_PESERTA.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5109RPI.genConditionalExistA())));
    fs.add(sf(7, null, "Counterparty", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.COUNTER_PARTY.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5109RPI.genConditionalExistA())));
    fs.add(sf(8, null, "Tahun Piutang", sv(C, 4, 4, year)
        .confConditionalRequired(ER5109RPI.genConditionalExistB())));
    fs.add(sf(9, null, "Sektor Ekonomi", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.SEKTOR_EKONOMI.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5109RPI.genConditionalExistA())));
    fs.add(sf(10, null, "Lokasi", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.LOKASI_DATI_2.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5109RPI.genConditionalExistA())));
    fs.add(sf(11, null, "Kualitas", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.SEGMEN_KUALITAS.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5109RPI.genConditionalExistA())));
    fs.add(sf(12, null, "Piutang Bruto", sv(M, 1, 20, numeric)));
    fs.add(sf(13, null, "Penyisihan", sv(M, 1, 20, numeric)));
    fs.add(sf(14, null, "Saldo", sv(M, 1, 20, numeric)));
    return res;
  }
}
