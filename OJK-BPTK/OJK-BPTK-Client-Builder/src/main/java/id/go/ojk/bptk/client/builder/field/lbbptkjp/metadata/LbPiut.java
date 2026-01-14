package id.go.ojk.bptk.client.builder.field.lbbptkjp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.DataType.year;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjp;
import id.go.ojk.bptk.client.builder.field.lbbptkjp.reference.EHeaderMetadataLbbptkjp;
import id.go.ojk.bptk.client.builder.field.lbbptkjp.reference.ER5811PIUT;
import id.go.ojk.bptk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbPiut extends BaseMetadata {
  public LbPiut(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjp eEnum = EFormLbbptkjp.PIUT;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 0, null);

    res.setSavePos(ER5811PIUT.genFieldSave());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
        .confReference(EHeaderMetadataLbbptkjp.R5811PIUT.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Nama Peserta / Jumlah Peserta", sv(M, 1, 100, all)));
    fs.add(sf(3, null, "Nama Perusahaan", sv(M, 1, 100, all)));
    fs.add(sf(4, null, "Jumlah Kontrak", sv(M, 1, 16, numeric))
        .addFieldValidations(ER5811PIUT.genFieldValidationJumlahKontrak()));
    fs.add(sf(5, null, "Segmen Peserta", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.SEGMEN_PESERTA.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(6, null, "Counterparty", sv(M, 1, 100, all)));
    fs.add(sf(7, null, "Tahun Piutang", sv(M, 4, 4, year)));
    fs.add(sf(8, null, "Sektor Ekonomi", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.SEKTOR_EKONOMI.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(9, null, "Lokasi", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.LOKASI_DATI_2.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(10, null, "Kualitas", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.SEGMEN_KUALITAS.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(11, null, "Piutang Bruto", sv(M, 1, 20, numeric)));
    fs.add(sf(12, null, "Penyisihan", sv(M, 1, 20, numeric)));
    fs.add(sf(13, null, "Saldo", sv(M, 1, 20, numeric)));

    return res;
  }
}
