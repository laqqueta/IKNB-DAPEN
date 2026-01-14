package id.go.ojk.bpks.client.builder.field.lbbpkslk.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.EHeaderMetadataLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.ER5011SBN;
import id.go.ojk.bpks.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbSbn extends BaseMetadata {
  public LbSbn(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslk eEnum = EFormLbbpkslk.SBN;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 1, null);

    res.setRequiredPos(ER5011SBN.genRequiredPos());
    res.setUniquePos(ER5011SBN.genUniquePos());
    res.setSavePos(ER5011SBN.genFieldSave());

    res.addSegmentValidations(ER5011SBN.genValidationTotal());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpkslk.R5011SBN.getObject()).confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "SBN - Nama Jenis Investasi",
        sv(C, 1, 100, all).confConditionalRequired(ER5011SBN.genConditionalExistA())));
    fs.add(sf(3, null, "SBN - Saldo SAK", sv(M, 1, 20, numeric)));
    fs.add(sf(4, null, "Obligasi/Sukuk Infrastruktur - Nama Jenis Investasi",
        sv(C, 1, 100, all).confConditionalRequired(ER5011SBN.genConditionalExistA())));
    fs.add(sf(5, null, "Obligasi/Sukuk Infrastruktur - Seri Efek",
        sv(C, 1, 100, all).confConditionalRequired(ER5011SBN.genConditionalExistB())));
    fs.add(sf(6, null, "Obligasi/Sukuk Infrastruktur - Jenis Kepemilikan",
        sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.JENIS_KEPEMILIKAN.getObject())
            .confRegex(PATTERN_REFERENCE_1).confConditionalRequired(ER5011SBN.genConditionalExistA())));
    fs.add(sf(7, null, "Obligasi/Sukuk Infrastruktur - Rating",
        sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.PERINGKAT_SURAT_BERHARGA.getObject())
            .confRegex(PATTERN_REFERENCE_1).confConditionalRequired(ER5011SBN.genConditionalExistA())));
    fs.add(sf(8, null, "Obligasi/Sukuk Infrastruktur - Saldo SAK", sv(M, 1, 20, numeric)));
    fs.add(sf(9, null, "Reksadana Underlying SBN - Nama Jenis Investasi",
        sv(C, 1, 100, all).confConditionalRequired(ER5011SBN.genConditionalExistA())));
    fs.add(sf(10, null, "Reksadana Underlying SBN - Manajer Investasi",
        sv(C, 1, 100, all).confConditionalRequired(ER5011SBN.genConditionalExistA())));
    fs.add(sf(11, null, "Reksadana Underlying SBN - Saldo SAK", sv(M, 1, 20, numeric)));
    fs.add(sf(12, null, "Reksadana Penyertaan Terbatas - Nama Jenis Investasi",
        sv(C, 1, 100, all).confConditionalRequired(ER5011SBN.genConditionalExistA())));
    fs.add(sf(13, null, "Reksadana Penyertaan Terbatas - Manajer Investasi",
        sv(C, 1, 100, all).confConditionalRequired(ER5011SBN.genConditionalExistA())));
    fs.add(sf(14, null, "Reksadana Penyertaan Terbatas - Emiten Penerima Dana/Project",
        sv(C, 1, 100, all).confConditionalRequired(ER5011SBN.genConditionalExistA())));
    fs.add(sf(15, null, "Reksadana Penyertaan Terbatas - Saldo SAK", sv(M, 1, 20, numeric)));
    fs.add(sf(16, null, "Efek Beragun Aset - Nama Jenis Investasi",
        sv(C, 1, 100, all).confConditionalRequired(ER5011SBN.genConditionalExistA())));
    fs.add(sf(17, null, "Efek Beragun Aset - Seri Efek",
        sv(C, 1, 100, alfaNumeric).confConditionalRequired(ER5011SBN.genConditionalExistA())));
    fs.add(sf(18, null, "Efek Beragun Aset - Jenis Kepemilikan",
        sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.JENIS_KEPEMILIKAN.getObject())
            .confRegex(PATTERN_REFERENCE_1).confConditionalRequired(ER5011SBN.genConditionalExistA())));
    fs.add(sf(19, null, "Efek Beragun Aset - Rating",
        sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
            .confReference(EHeaderMetadataShared.PERINGKAT_SURAT_BERHARGA.getObject())
            .confConditionalRequired(ER5011SBN.genConditionalExistA())));
    fs.add(sf(20, null, "Efek Beragun Aset - Saldo SAK", sv(M, 1, 20, numeric)));
    fs.add(sf(21, null, "Investasi Lain Untuk Pembiayaan Proyek Infrastruktur Pemerintah - Nama Jenis Investasi",
        sv(C, 1, 100, all).confConditionalRequired(ER5011SBN.genConditionalExistA())));
    fs.add(sf(22, null, "Investasi Lain Untuk Pembiayaan Proyek Infrastruktur Pemerintah - Saldo SAK",
        sv(M, 1, 20, numeric)));
    return res;
  }
}
