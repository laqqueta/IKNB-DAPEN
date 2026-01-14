package id.go.ojk.bpks.client.builder.field.lbbpkslk.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.EHeaderMetadataLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.ER5002LPE;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLpe extends BaseMetadata {
  public LbLpe(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslk eEnum = EFormLbbpkslk.LPE;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 19, 19);

    res.setRequiredPos(ER5002LPE.genRequiredPos());
    res.setUniquePos(ER5002LPE.genUniquePos());
    res.setSavePos(ER5002LPE.genFieldSave());

    res.addSegmentValidations(ER5002LPE.genColValidation03a());
    res.addSegmentValidations(ER5002LPE.genColValidation03b());
    res.addSegmentValidations(ER5002LPE.genColValidation04a());
    res.addSegmentValidations(ER5002LPE.genColValidation04b());
    res.addSegmentValidations(ER5002LPE.genColValidation05a());
    res.addSegmentValidations(ER5002LPE.genColValidation05b());
    res.addSegmentValidations(ER5002LPE.genColValidation06a());
    res.addSegmentValidations(ER5002LPE.genColValidation06b());
    res.addSegmentValidations(ER5002LPE.genColValidation07a());
    res.addSegmentValidations(ER5002LPE.genColValidation07b());
    res.addSegmentValidations(ER5002LPE.genColValidation08a());
    res.addSegmentValidations(ER5002LPE.genColValidation08b());
    res.addSegmentValidations(ER5002LPE.genColValidation09a());
    res.addSegmentValidations(ER5002LPE.genColValidation09b());
    res.addSegmentValidations(ER5002LPE.genColValidation10a());
    res.addSegmentValidations(ER5002LPE.genColValidation10b());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpkslk.R5002LPE.getObject()).confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(
        sf(2, null, "Modal", sv(C, 1, 20, numericNegatif).confConditionalRequired(ER5002LPE.genConditionalExist03())));
    fs.add(sf(3, null, "Saldo Penyesuaian Nilai Wajar Aset Keuangan Tersedia Untuk Dijual",
        sv(C, 1, 20, numericNegatif).confConditionalRequired(ER5002LPE.genConditionalExist04())));
    fs.add(sf(4, null, "Saldo Keuntungan (Kerugian) Aktuaria Liabilitas Pasca Kerja Imbalan Pasti",
        sv(C, 1, 20, numericNegatif).confConditionalRequired(ER5002LPE.genConditionalExist05())));
    fs.add(sf(5, null, "Saldo Bagian Penghasilan Komprehensif Lain Entitas Asosiasi Dan Entitas Anak",
        sv(C, 1, 20, numericNegatif).confConditionalRequired(ER5002LPE.genConditionalExist06())));
    fs.add(sf(6, null, "Saldo Selisih Transaksi Dengan Pihak Nonpengendali",
        sv(C, 1, 20, numericNegatif).confConditionalRequired(ER5002LPE.genConditionalExist07())));
    fs.add(sf(7, null, "Saldo Selisih Kombinasi Dan Pelepasan Bisnis Antar Entitas Sepengendali",
        sv(C, 1, 20, numericNegatif).confConditionalRequired(ER5002LPE.genConditionalExist08())));
    fs.add(sf(8, null, "Saldo Penghasilan (Beban) Neto",
        sv(C, 1, 20, numericNegatif).confConditionalRequired(ER5002LPE.genConditionalExist09())));
    fs.add(sf(9, null, "Jumlah", sv(M, 1, 20, numericNegatif)).addFieldValidations(ER5002LPE.genFieldValidation10()));
    return res;
  }
}
