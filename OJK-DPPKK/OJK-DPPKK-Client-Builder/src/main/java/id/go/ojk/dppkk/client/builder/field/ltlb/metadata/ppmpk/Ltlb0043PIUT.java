package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7042PosLtlbDppkPiut;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7046PosLtlbDppkPihi;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0043PIUT extends BaseMetadata {

    public Ltlb0043PIUT(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_PIUT;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7042PosLtlbDppkPiut.genFieldSave());
        res.setRequiredPos(ER7042PosLtlbDppkPiut.getRequiredPos());

        res.addSegmentValidations(ER7042PosLtlbDppkPiut.genValidation());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7042Piut.getObject())));

        fs.add(sf(2, null, "Nama Pemberi Kerja(Pendiri/Mitra Pendiri)",
                sv(C, 1, 100, freeText)
                        .confConditionalRequired(ER7042PosLtlbDppkPiut.genConditionForTotal())));

        fs.add(sf(3, null, "Piutang Iuran Pemberi Kerja Usia Piutang <=1 Bulan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(4, null, "Piutang Iuran Pemberi Kerja Usia Piutang >1 Bulan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(5, null, "Piutang Iuran Pemberi Kerja Total",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7042PosLtlbDppkPiut.genFieldValidationPemberiKerja()));

        fs.add(sf(6, null, "Piutang Iuran Peserta Usia Piutang <=1 Bulan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(7, null, "Piutang Iuran Peserta Usia Piutang >1 Bulan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(8, null, "Piutang Iuran Peserta Total",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7042PosLtlbDppkPiut.genFieldValidationPeserta()));

        fs.add(sf(9, null, "Piutang Iuran Tambahan Usia Piutang <=1 Bulan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(10, null, "Piutang Iuran Tambahan Usia Piutang >1 Bulan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(11, null, "Piutang Iuran Tambahan Total",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7042PosLtlbDppkPiut.genFieldValidationTambahan()));

        fs.add(sf(12, null, "Piutang Iuran Sukarela Peserta",
                sv(M, 1, 18, numeric)));

        fs.add(sf(13, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7042PosLtlbDppkPiut.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(14, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7042PosLtlbDppkPiut.genConditionForTotalOptional())));

        return res;
    }
}
