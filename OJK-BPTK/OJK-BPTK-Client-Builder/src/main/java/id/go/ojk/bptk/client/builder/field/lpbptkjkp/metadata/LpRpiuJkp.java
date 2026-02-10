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
import id.go.ojk.bptk.client.builder.field.lpbptkjkp.reference.ER6202RPIU;
import id.go.ojk.bptk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LpRpiuJkp extends BaseMetadata {

  private final IForm form;

  public LpRpiuJkp(IForm form) {
    super(form.getReportCode(), ".txt");
    this.form = form;
  }

  @Override
  public SubmissionFormat get() {
    SubmissionFormat res = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(),
        extension, 1, null);

    res.setRequiredPos(ER6202RPIU.genRequiredPos());
    res.setUniquePos(ER6202RPIU.genUniquePos());
    res.setSavePos(ER6202RPIU.genFieldSave());

    res.addSegmentValidations(ER6202RPIU.genValidationTotal());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen", sv(M, 14, 20, refTable /*Huruf Angka*/)
        .confRegex(patternAlfaNumeric)
        .confReference(EHeaderMetadataLpbptkjkp.R6202RPIU.getObject())));
    fs.add(sf(2, null, "Kode Kantor Wilayah", sv(C, 1, 100, all)
        .confConditionalRequired(ER6202RPIU.genConditionalExistA())));
    fs.add(sf(3, null, "Kantor Wilayah", sv(C, 1, 100, all)
        .confConditionalRequired(ER6202RPIU.genConditionalExistA())));
    fs.add(sf(4, null, "Kode Kantor Cabang", sv(C, 1, 100, all)
        .confConditionalRequired(ER6202RPIU.genConditionalExistA())));
    fs.add(sf(5, null, "Kantor Cabang", sv(C, 1, 100, all)
        .confConditionalRequired(ER6202RPIU.genConditionalExistA())));
    fs.add(sf(6, null, "Lokasi DATI II", sv(C, 1, 8, refTable /*Huruf Angka :*/)
        .confConditionalRequired(ER6202RPIU.genConditionalExistA())
        .confRegex(PATTERN_REFERENCE_1).confReference(EHeaderMetadataShared.LOKASI_DATI_2.getObject()))
        .addFieldValidations(ER6202RPIU.genDati2Validation()));
    fs.add(sf(7, null, "Lokasi DATI I", sv(C, 1, 8, refTable /*Huruf Angka :*/)
        .confConditionalRequired(ER6202RPIU.genConditionalExistA())
        .confRegex(PATTERN_REFERENCE_1).confReference(EHeaderMetadataShared.LOKASI_DATI_1.getObject())));
    fs.add(sf(8, null, "Segmen Peserta", sv(C, 1, 8, refTable /*Huruf Angka .*/)
        .confConditionalRequired(ER6202RPIU.genConditionalExistA())
        .confRegex(PATTERN_REFERENCE_4)
        .confReference(EHeaderMetadataShared.SEGMEN_PESERTA_LPP.getObject())));
    fs.add(sf(9, null, "Kelompok Upah (TK) 1", sv(M, 1, 10, numeric)));
    fs.add(sf(10, null, "Kelompok Upah (TK) 2", sv(M, 1, 10, numeric)));
    fs.add(sf(11, null, "Kelompok Upah (TK) 3", sv(M, 1, 10, numeric)));
    fs.add(sf(12, null, "Kelompok Upah (TK) 4", sv(M, 1, 10, numeric)));
    fs.add(sf(13, null, "Kelompok Upah (TK) 5", sv(M, 1, 10, numeric)));
    fs.add(sf(14, null, "Total Kelompok Upah (TK)", sv(M, 1, 10, numeric))
        .addFieldValidations(ER6202RPIU.genValidationTotalKelompokUpah()));
    fs.add(sf(15, null, "Pembebanan Iuran Rekomposisi Iuran JKK", sv(M, 1, 20, numeric)));
    fs.add(sf(16, null, "Pembebanan Iuran Rekomposisi Iuran JKM", sv(M, 1, 20, numeric)));
    fs.add(sf(17, null, "Pembebanan Iuran Pemerintah", sv(M, 1, 20, numeric)));
    fs.add(sf(18, null, "Total Pembebanan Iuran", sv(M, 1, 20, numeric))
        .addFieldValidations(ER6202RPIU.genValidationTotalPembebananIuran()));
    fs.add(sf(19, null, "Iuran Yang Diterima Rekomposisi Iuran JKK", sv(M, 1, 20, numeric)));
    fs.add(sf(20, null, "Iuran Yang Diterima Rekomposisi Iuran JKM", sv(M, 1, 20, numeric)));
    fs.add(sf(21, null, "Iuran Yang Diterima Pemerintah", sv(M, 1, 20, numeric)));
    fs.add(sf(22, null, "Total Iuran Yang Diterima", sv(M, 1, 20, numeric))
        .addFieldValidations(ER6202RPIU.genValidationIuranYangDiterima()));
    fs.add(sf(23, null, "Target Iuran", sv(M, 1, 20, numeric)));
    return res;
  }
}
