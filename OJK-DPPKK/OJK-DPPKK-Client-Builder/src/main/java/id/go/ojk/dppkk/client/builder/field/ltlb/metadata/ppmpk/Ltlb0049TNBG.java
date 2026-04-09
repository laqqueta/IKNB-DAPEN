package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7048PosLtlbDppkTnbg;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0049TNBG extends BaseMetadata {

    public Ltlb0049TNBG(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_TNBG;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7048PosLtlbDppkTnbg.genFieldSave());
        res.setSavePosForm(ER7048PosLtlbDppkTnbg.genFieldSaveForm());
        res.setRequiredPos(ER7048PosLtlbDppkTnbg.getRequiredPos());

        res.addSegmentValidations(ER7048PosLtlbDppkTnbg.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        
        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7048Tnbg.getObject())));

        fs.add(sf(2, null, "Jenis Objek (Tanah/Bangunan/Tanah & Bangunan)",
                sv(C, 1, 8, refTable)
                        .confRegex(SimpleValidation.patternNumeric)
                        .confReference(EHeaderMetadataShared.R004.getObject())
                        .confConditionalRequired(ER7048PosLtlbDppkTnbg.genConditionForTotal())));

        fs.add(sf(3, null, "Nomor Sertifikat",
                sv(C, 1, 20, alfaNumeric)
                        .confConditionalRequired(ER7048PosLtlbDppkTnbg.genConditionForTotal())));

        fs.add(sf(4, null, "Alamat Lokasi",
                sv(C, 1, 250, alfaNumeric)
                        .confConditionalRequired(ER7048PosLtlbDppkTnbg.genConditionForTotal())));

        fs.add(sf(5, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7048PosLtlbDppkTnbg.genConditionForTotal())));

        fs.add(sf(6, null, "Nilai Perolehan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(7, null, "Akumulasi Penyusutan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(8, null, "Nilai Buku",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7048PosLtlbDppkTnbg.genFieldValidationNilaiBuku()));

        fs.add(sf(9, null, "Nilai Perolehan Pada Tanggal Laporan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(10, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7048PosLtlbDppkTnbg.genConditionForTotalOptional())));

        return res;
    }
}
