package id.go.ojk.bpks.client.builder.field.lbbpkslk.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.EHeaderMetadataLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.ER5010RPRI;
import id.go.ojk.bpks.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbRpri extends BaseMetadata {
  public LbRpri(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslk eEnum = EFormLbbpkslk.RPRI;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 1, null);

    res.setRequiredPos(ER5010RPRI.genRequiredPos());
    res.setUniquePos(ER5010RPRI.genUniquePos());
    res.setSavePos(ER5010RPRI.genFieldSave());

    res.addSegmentValidations(ER5010RPRI.genValidationTotal());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5010RPRI.genRowValidation15());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 14, 14, refTable)
        .confReference(EHeaderMetadataLbbpkslk.R5010RPRI.getObject()).confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Jenis Properti",
        sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
            .confReference(EHeaderMetadataShared.JENIS_PROPERTI.getObject())
            .confConditionalRequired(ER5010RPRI.genConditionalExistA())));
    fs.add(sf(3, null, "Bukti Kepemilikan",
        sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
            .confReference(EHeaderMetadataShared.BUKTI_PEMILIKAN_TANAH_BANGUNAN.getObject())
            .confConditionalRequired(ER5010RPRI.genConditionalExistA())));
    fs.add(sf(4, null, "Status Kepemilikan",
        sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
            .confReference(EHeaderMetadataShared.STATUS_PEMILIKAN_TANAH_BANGUNAN.getObject())
            .confConditionalRequired(ER5010RPRI.genConditionalExistA())));
    fs.add(
        sf(5, null, "Tanggal Perolehan", sv(C, 8, 8, date).confConditionalRequired(ER5010RPRI.genConditionalExistA())));
    fs.add(sf(6, null, "Luas", sv(C, 1, 8, numeric).confConditionalRequired(ER5010RPRI.genConditionalExistA())));
    fs.add(sf(7, null, "Alamat", sv(C, 1, 100, all).confConditionalRequired(ER5010RPRI.genConditionalExistA())));
    fs.add(sf(8, null, "Lokasi", sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
        .confReference(EHeaderMetadataShared.LOKASI_DATI_2.getObject())
        .confConditionalRequired(ER5010RPRI.genConditionalExistA())));
    fs.add(sf(9, null, "Harga Perolehan", sv(M, 1, 20, numeric)));
    fs.add(sf(10, null, "Penyusutan", sv(M, 1, 20, numeric)));
    fs.add(sf(11, null, "Penurunan Nilai",
        sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
            .confReference(EHeaderMetadataShared.PENURUNAN_NILAI.getObject())
            .confConditionalRequired(ER5010RPRI.genConditionalExistA())));
    fs.add(sf(12, null, "Harga Pasar", sv(M, 1, 20, numeric)));
    fs.add(sf(13, null, "Hirarki Harga Pasar",
        sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
            .confReference(EHeaderMetadataShared.HIRARKI_HARGA_PASAR.getObject())
            .confConditionalRequired(ER5010RPRI.genConditionalExistA())));
    fs.add(sf(14, null, "Saldo", sv(M, 1, 20, numeric)));
    return res;
  }
}
