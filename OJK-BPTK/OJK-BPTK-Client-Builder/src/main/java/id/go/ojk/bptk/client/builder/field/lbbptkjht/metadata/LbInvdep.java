package id.go.ojk.bptk.client.builder.field.lbbptkjht.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjht;
import id.go.ojk.bptk.client.builder.field.lbbptkjht.reference.EHeaderMetadataLbbptkjht;
import id.go.ojk.bptk.client.builder.field.lbbptkjht.reference.ER5607INVDEP;
import id.go.ojk.bptk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbInvdep extends BaseMetadata {
  public LbInvdep(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjht eEnum = EFormLbbptkjht.INVDEP;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 1, null);

    res.setRequiredPos(ER5607INVDEP.genRequiredPos());
    res.setUniquePos(ER5607INVDEP.genUniquePos());
    res.setSavePos(ER5607INVDEP.genFieldSave());

    res.addSegmentValidations(ER5607INVDEP.genValidationTotal());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 16, 16, refTable)
        .confReference(EHeaderMetadataLbbptkjht.R5607INVDEP.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Jenis Deposito", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.JENIS_DEPOSITO.getObject())
        .confRegex(patternNumeric)
        .confConditionalRequired(ER5607INVDEP.genConditionalExistA())));
    fs.add(sf(3, null, "Penerbit, Nama Bank", sv(C, 1, 100, all)
        .confConditionalRequired(ER5607INVDEP.genConditionalExistA())));
    fs.add(sf(4, null, "Penerbit, Jenis Bank", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.COUNTER_PARTY.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5607INVDEP.genConditionalExistA()))
        .addFieldValidations(ER5607INVDEP.genFieldValidation05()));
    fs.add(sf(5, null, "Penerbit, Sandi Bank", sv(C, 1, 100, refTable)
        .confReference(EHeaderMetadataShared.SANDI_BANK.getObject())
        .confRegex(patternAlfaNumeric)
        .confConditionalRequired(ER5607INVDEP.genConditionalExistA())));
    fs.add(sf(6, null, "Penerbit, Cabang Bank", sv(C, 1, 100, all)
        .confConditionalRequired(ER5607INVDEP.genConditionalExistA())));
    fs.add(sf(7, null, "Penerbit, Nomor Bilyet", sv(C, 1, 35, all)
        .confConditionalRequired(ER5607INVDEP.genConditionalExistA())));
    fs.add(sf(8, null, "Penerbit, Syariah/Konvensional", sv(C, 1, 5, refTable)
        .confReference(EHeaderMetadataShared.SYARIAH_KONVENSIONAL.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5607INVDEP.genConditionalExistA())));
    fs.add(sf(9, null, "Penerbit, Nilai", sv(M, 1, 20, numeric)));
    fs.add(sf(10, null, "Penerbit, Tingkat Suku Bunga", sv(C, 1, 6, numericDot)
        .confConditionalRequired(ER5607INVDEP.genConditionalExistA()))
        .addFieldValidations(ER5607INVDEP.genFieldValidation10()));
    fs.add(sf(11, null, "Jangka Waktu, Mulai", sv(C, 8, 8, date)
        .confConditionalRequired(ER5607INVDEP.genConditionalExistA()))
        .addFieldValidations(ER5607INVDEP.genFieldValidation12()));
    fs.add(sf(12, null, "Jangka Waktu, Jatuh Tempo", sv(C, 8, 8, date)
        .confConditionalRequired(ER5607INVDEP.genConditionalExistA()))
        .addFieldValidations(ER5607INVDEP.genFieldValidation13()));
    fs.add(sf(13, null, "Jangka Waktu, Tenor", sv(C, 1, 8, numeric)
        .confConditionalRequired(ER5607INVDEP.genConditionalExistA()))
        .addFieldValidations(ER5607INVDEP.genFieldValidation14()));
    fs.add(sf(14, null, "Keterangan Automatic Roll Over (ARO)",sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.KETERANGAN_ARO.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5607INVDEP.genConditionalExistA())));
    fs.add(sf(15, null, "CKPN, Individual", sv(C, 1, 20, numeric)
        .confConditionalRequired(ER5607INVDEP.genConditionalExist16())));
    fs.add(sf(16, null, "CKPN, Kolektif", sv(C, 1, 20, numeric)
        .confConditionalRequired(ER5607INVDEP.genConditionalExist17())));
    fs.add(sf(17, null, "Jumlah Neto", sv(M, 1, 20, numeric))
        .addFieldValidations(ER5607INVDEP.genFieldValidation18()));
    return res;
  }
}
