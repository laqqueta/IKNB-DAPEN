package id.go.ojk.bptk.client.builder.field.lpbptkjkp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_4;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.IForm;
import id.go.ojk.bptk.client.builder.field.lpbptkjkp.reference.EHeaderMetadataLpbptkjkp;
import id.go.ojk.bptk.client.builder.field.lpbptkjkp.reference.ER6203RPMF;
import id.go.ojk.bptk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LpRpmfJkp extends BaseMetadata {

  private final IForm form;

  public LpRpmfJkp(IForm form) {
    super(form.getReportCode(), ".txt");
    this.form = form;
  }

  @Override
  public SubmissionFormat get() {
    SubmissionFormat res = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(),
        extension, 1, null);

    res.setRequiredPos(ER6203RPMF.genRequiredPos());
    res.setUniquePos(ER6203RPMF.genUniquePos());
    res.setSavePos(ER6203RPMF.genFieldSave());
    res.setSavePosForm(ER6203RPMF.genFieldSaveForm());

    res.addSegmentValidations(ER6203RPMF.genValidationTotal());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen", sv(M, 14, 20, refTable /*Huruf Angka*/)
        .confRegex(patternAlfaNumeric)
        .confReference(EHeaderMetadataLpbptkjkp.R6203RPMF.getObject())));
    fs.add(sf(2, null, "Kode Kantor Wilayah", sv(C, 1, 100, all)
        .confConditionalRequired(ER6203RPMF.genConditionalExistA())));
    fs.add(sf(3, null, "Kantor Wilayah", sv(C, 1, 100, all)
        .confConditionalRequired(ER6203RPMF.genConditionalExistA())));
    fs.add(sf(4, null, "Kode Kantor Cabang", sv(C, 1, 100, all)
        .confConditionalRequired(ER6203RPMF.genConditionalExistA())));
    fs.add(sf(5, null, "Kantor Cabang", sv(C, 1, 100, all)
        .confConditionalRequired(ER6203RPMF.genConditionalExistA())));
    fs.add(sf(6, null, "Lokasi DATI II", sv(C, 1, 8, refTable /*Huruf Angka :*/)
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER6203RPMF.genConditionalExistA())
        .confReference(EHeaderMetadataShared.LOKASI_DATI_2.getObject()))
        .addFieldValidations(ER6203RPMF.genDati2Validation()));
    fs.add(sf(7, null, "Lokasi DATI I", sv(C, 1, 8, refTable /*Huruf Angka :*/)
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER6203RPMF.genConditionalExistA())
        .confReference(EHeaderMetadataShared.LOKASI_DATI_1.getObject())));
    fs.add(sf(8, null, "Segmen Peserta", sv(C, 1, 8, refTable /*Huruf Angka .*/)
        .confRegex(PATTERN_REFERENCE_4)
        .confConditionalRequired(ER6203RPMF.genConditionalExistA())
        .confReference(EHeaderMetadataShared.SEGMEN_PESERTA_LPP.getObject())));
    fs.add(sf(9, null, "Jenis Manfaat 1", sv(M, 1, 10, numeric)));
    fs.add(sf(10, null, "Jenis Manfaat 2", sv(M, 1, 10, numeric)));
    fs.add(sf(11, null, "Jenis Manfaat 3", sv(M, 1, 10, numeric)));
    fs.add(sf(12, null, "Total Jenis Manfaat", sv(M, 1, 10, numeric))
        .addFieldValidations(ER6203RPMF.genValidationTotalJenisManfaat()));
    fs.add(sf(13, null, "Jumlah Status Klaim 1", sv(M, 1, 10, numeric)));
    fs.add(sf(14, null, "Nilai Status Klaim 1", sv(M, 1, 20, numeric)));
    fs.add(sf(15, null, "Jumlah Status Klaim 2", sv(M, 1, 10, numeric)));
    fs.add(sf(16, null, "Nilai Status Klaim 2", sv(M, 1, 20, numeric)));
    fs.add(sf(17, null, "Jumlah Status Klaim 3", sv(M, 1, 10, numeric)));
    fs.add(sf(18, null, "Nilai Status Klaim 3", sv(M, 1, 20, numeric)));
    fs.add(sf(19, null, "Jumlah Status Klaim 4", sv(M, 1, 10, numeric)));
    fs.add(sf(20, null, "Nilai Status Klaim 4", sv(M, 1, 20, numeric)));
    return res;
  }

}
