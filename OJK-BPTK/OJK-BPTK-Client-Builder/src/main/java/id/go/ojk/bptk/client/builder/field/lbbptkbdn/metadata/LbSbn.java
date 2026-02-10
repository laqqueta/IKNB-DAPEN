package id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.EHeaderMetadataLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.ER5312SBN;
import id.go.ojk.bptk.client.builder.field.lbbptkjkk.metadata.MetadataLbbptkjkk;
import id.go.ojk.bptk.client.builder.field.lbbptkjkm.metadata.MetadataLbbptkjkm;
import id.go.ojk.bptk.client.builder.field.ltbptk.metadata.MetadataLtbptkbdn;
import id.go.ojk.bptk.client.builder.field.ltbptk.metadata.MetadataLtbptkjkk;
import id.go.ojk.bptk.client.builder.field.ltbptk.metadata.MetadataLtbptkjkm;
import id.go.ojk.bptk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbSbn extends BaseMetadata {
  public LbSbn(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkbdn eEnum = EFormLbbptkbdn.SBN;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 0, null);

    res.setSavePos(ER5312SBN.genFieldSave());

    /* -- ANTAR FORM -- */
    if (reportCode.equalsIgnoreCase(MetadataLbbptkbdn.REPORT_CODE) ||
        reportCode.equalsIgnoreCase(MetadataLtbptkbdn.REPORT_CODE)) {
      res.addSegmentValidations(ER5312SBN.genRowValidation03Bdn());
    } else if (reportCode.equalsIgnoreCase(MetadataLbbptkjkk.REPORT_CODE) ||
        reportCode.equalsIgnoreCase(MetadataLbbptkjkm.REPORT_CODE) ||
        reportCode.equalsIgnoreCase(MetadataLtbptkjkk.REPORT_CODE) ||
        reportCode.equalsIgnoreCase(MetadataLtbptkjkm.REPORT_CODE)) {
      res.addSegmentValidations(ER5312SBN.genRowValidation03Jkk());
    }

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkbdn.R5312SBN.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "SBN, Nama Jenis Investasi", sv(M, 1, 100, all)));
    fs.add(sf(3, null, "SBN, Saldo SAK", sv(M, 1, 20, numeric)));
    fs.add(sf(4, null, "Obligasi/Sukuk Infrastruktur, Nama Jenis Investasi", sv(M, 1, 100, all)));
    fs.add(sf(5, null, "Obligasi/Sukuk Infrastruktur, Seri Efek", sv(M, 1, 100, alfaNumeric)));
    fs.add(sf(6, null, "Obligasi/Sukuk Infrastruktur, Jenis Kepemilikan", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.TUJUAN_KEPEMILIKAN.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(7, null, "Obligasi/Sukuk Infrastruktur, Rating", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.PERINGKAT_SURAT_BERHARGA.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(8, null, "Obligasi/Sukuk Infrastruktur, Saldo SAK", sv(M, 1, 20, numeric)));
    fs.add(sf(9, null, "Reksadana Underlying SBN, Nama Jenis Investasi", sv(M, 1, 100, all)));
    fs.add(sf(10, null, "Reksadana Underlying SBN, Manajer Investasi", sv(M, 1, 100, all)));
    fs.add(sf(11, null, "Reksadana Underlying SBN, Emiten Penerima Dana/Project", sv(M, 1, 100, all)));
    fs.add(sf(12, null, "Reksadana Underlying SBN, Saldo SAK", sv(M, 1, 20, numeric)));
    fs.add(sf(13, null, "Reksadana Penyertaan Terbatas, Nama Jenis Investasi", sv(M, 1, 100, all)));
    fs.add(sf(14, null, "Reksadana Penyertaan Terbatas, Manajer Investasi", sv(M, 1, 100, all)));
    fs.add(sf(15, null, "Reksadana Penyertaan Terbatas, Emiten Penerima Dana/Project", sv(M, 1, 100, all)));
    fs.add(sf(16, null, "Reksadana Penyertaan Terbatas, Saldo SAK", sv(M, 1, 20, numeric)));
    fs.add(sf(17, null, "Efek Beragun Aset, Nama Jenis Investasi", sv(M, 1, 100, all)));
    fs.add(sf(18, null, "Efek Beragun Aset, Seri Efek", sv(M, 1, 100, alfaNumeric)));
    fs.add(sf(19, null, "Efek Beragun Aset, Jenis Kepemilikan", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.TUJUAN_KEPEMILIKAN.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(20, null, "Efek Beragun Aset, Rating", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.PERINGKAT_SURAT_BERHARGA.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(21, null, "Efek Beragun Aset, Saldo SAK", sv(M, 1, 20, numeric)));
    fs.add(sf(22, null, "Investasi Lain Untuk Pembiayaan Proyek Infrastruktur Pemerintah, Nama Jenis Investasi", sv(M, 1, 100, all)));
    fs.add(sf(23, null, "Investasi Lain Untuk Pembiayaan Proyek Infrastruktur Pemerintah, Saldo SAK", sv(M, 1, 20, numeric)));
    return res;
  }
}
