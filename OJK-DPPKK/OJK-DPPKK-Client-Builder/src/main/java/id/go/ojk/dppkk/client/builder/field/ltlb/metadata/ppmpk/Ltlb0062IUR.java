package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7061PosLtlbDppkIur;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.freeText;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0062IUR extends BaseMetadata {

    /*
    *
    * NOT YET USED
    *
    * */

    public Ltlb0062IUR(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_IUR;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7061PosLtlbDppkIur.genFieldSave());
        res.setSavePosForm(ER7061PosLtlbDppkIur.genFieldFormSave());
        res.setRequiredPos(ER7061PosLtlbDppkIur.getRequiredPos());

        res.addSegmentValidations(ER7061PosLtlbDppkIur.genValidation());

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 9, 9, refTable)
                .confRegex(SimpleValidation.patternAlfaNumeric)
                .confReference(EHeaderMetadataPpmpk.R7061Iur.getObject())));

        fs.add(sf(2, null, "Nama Pendiri/Mitra Pendiri",
                sv(C, 1, 100, alfaNumeric)
                        .confConditionalRequired(ER7061PosLtlbDppkIur.genConditionForTotal())));

        fs.add(sf(3, null, "PhDP", sv(C, 4, 6, numericDot)
                .confConditionalRequired(ER7061PosLtlbDppkIur.genConditionForTotal())));

        fs.add(sf(4, null, "Iuran Jatuh Tempo - Iuran Normal Peserta %",
                sv(C, 1, 18, numeric)
                        .confConditionalRequired(ER7061PosLtlbDppkIur.genConditionForTotal())));

        fs.add(sf(5, null, "Iuran Jatuh Tempo - Iuran Normal Peserta Jumlah", sv(M, 1, 18, numeric)));

        fs.add(sf(6, null, "Iuran Jatuh Tempo - Iuran Normal Pemberi Kerja %",
                sv(C, 4, 6, numericDot)
                        .confConditionalRequired(ER7061PosLtlbDppkIur.genConditionForTotal())));

        fs.add(sf(7, null, "Iuran Jatuh Tempo - Iuran Normal Pemberi Kerja Jumlah", sv(M, 4, 6, numericDot)));
        fs.add(sf(8, null, "Iuran Jatuh Tempo - Iuran Sukarela Peserta", sv(M, 1, 18, numeric)));
        fs.add(sf(9, null, "Iuran Jatuh Tempo - Iuran Tambahan", sv(M, 1, 18, numeric)));
        fs.add(sf(10, null, "Penerimaan Iuran - Iuran Normal Peserta", sv(M, 1, 18, numeric)));
        fs.add(sf(11, null, "Penerimaan Iuran - Iuran Normal Pemberi Kerja", sv(M, 1, 18, numeric)));
        fs.add(sf(12, null, "Penerimaan Iuran - Iuran Tambahan", sv(M, 1, 18, numeric)));
        fs.add(sf(13, null, "Penerimaan Iuran - Iuran Sukarela Peserta", sv(M, 1, 18, numeric)));
        fs.add(sf(14, null, "Kurang/Lebih bayar - Iuran Normal Peserta", sv(M, 1, 18, numeric)));
        fs.add(sf(15, null, "Kurang/Lebih bayar - Iuran Normal Pemberi Kerja", sv(M, 1, 18, numeric)));
        fs.add(sf(16, null, "Kurang/Lebih bayar - Iuran Tambahan", sv(M, 1, 18, numeric)));

        fs.add(sf(17, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, alfaNumeric)
                        .confConditionalRequired(ER7061PosLtlbDppkIur.genConditionForTotal())));

        fs.add(sf(18, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7061PosLtlbDppkIur.genConditionForTotal())));

        return res;
    }
}
