package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7040PosLtlbDppkProp;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7041PosLtlbDppkKasb;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0041PROP extends BaseMetadata {

    public Ltlb0041PROP(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_PROP;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null );

        res.setSavePos(ER7040PosLtlbDppkProp.genFieldSave());
        res.setRequiredPos(ER7040PosLtlbDppkProp.getRequiredPos());

        res.addSegmentValidations(ER7040PosLtlbDppkProp.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7040Prop.getObject())));

        fs.add(sf(2, null, "Jenis Objek (Tanah/Bangunan/Tanah&Bangunan)",
                sv(C, 1, 8, refTable)
                        .confConditionalRequired(ER7040PosLtlbDppkProp.genConditionForTotal())
                        .confRegex(SimpleValidation.patternNumeric)
                        .confReference(EHeaderMetadataShared.R004.getObject())));

        fs.add(sf(3, null, "Alamat Lengkap",
                sv(C, 1, 250, alfaNumeric)
                        .confConditionalRequired(ER7040PosLtlbDppkProp.genConditionForTotal())));

        fs.add(sf(4, null, "Luas(m2)",
                sv(C, 1, 10, numeric)
                        .confConditionalRequired(ER7040PosLtlbDppkProp.genConditionForTotal())));

        fs.add(sf(5, null, "Jenis Bukti Kepemilikan",
                sv(C, 1, 8, alfaNumeric)
                        .confConditionalRequired(ER7040PosLtlbDppkProp.genConditionForTotal())));

        fs.add(sf(6, null, "Nomor Surat Kepemilikan",
                sv(C, 1, 20, refTable)
                        .confConditionalRequired(ER7040PosLtlbDppkProp.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfa)
                        .confReference(EHeaderMetadataShared.R016.getObject())));

        fs.add(sf(7, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7040PosLtlbDppkProp.genConditionForTotal())));

        fs.add(sf(8, null, "Nilai Perolehan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(9, null, "Akumulasi Penyusutan",
                sv(M, 1, 18, numeric)));

        fs.add(sf(10, null, "Nilai Buku",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7040PosLtlbDppkProp.genFieldValidationNilaiBuku()));

        fs.add(sf(11, null, "Nilai Appraisal/ Nilai Wajar",
                sv(M, 1, 18, numeric)));

        fs.add(sf(12, null, "Tanggal Appraisal",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7040PosLtlbDppkProp.genConditionForTotal())));

        fs.add(sf(13, null, "Nama Penilai Publik/Independen",
                sv(C, 1, 100, alfaNumeric)
                        .confConditionalRequired(ER7040PosLtlbDppkProp.genConditionForTotal())));

        fs.add(sf(14, null, "Nama KJPP",
                sv(C, 1, 100, alfaNumeric)
                        .confConditionalRequired(ER7040PosLtlbDppkProp.genConditionForTotal())));

        fs.add(sf(15, null, "Selisih Penilaian Investasi Nilai",
                sv(M, 1, 18, numeric))
                .addFieldValidations(ER7040PosLtlbDppkProp.genFieldValidationNilaiInvestasi()));

        fs.add(sf(16, null, "Selisih Penilaian Investasi %",
                sv(C, 3, 5, numericDot)
                        .confConditionalRequired(ER7040PosLtlbDppkProp.genConditionForTotal()))
                .addFieldValidations(ER7040PosLtlbDppkProp.genFieldValidationPersentaseInvestasi()));

        fs.add(sf(17, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, refTable)
                        .confConditionalRequired(ER7040PosLtlbDppkProp.genConditionForTotal())
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R009.getObject())));

        fs.add(sf(18, null, "Pendapatan Sewa",
                sv(C, 1, 18, numeric)
                        .confConditionalRequired(ER7040PosLtlbDppkProp.genConditionForTotal())));

        fs.add(sf(19, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7040PosLtlbDppkProp.genConditionForTotalOptional())));

        return res;
    }
}
