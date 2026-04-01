package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7020PosLtlbDppkPmi;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

public class Ltlb0021PMI extends BaseMetadata {

    public Ltlb0021PMI(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_PMI;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7020PosLtlbDppkPmi.genFieldSave());
        res.setRequiredPos(ER7020PosLtlbDppkPmi.getRequiredPos());

//        res.addSegmentValidations(ER7020PosLtlbDppkPmi.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(O, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        fs.add(sf(1, null, "Kode Komponen",
                sv(O, 9, 9, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7020Pmi.getObject())));

        fs.add(sf(2, null, "Nama Manajer Investasi",
                sv(O, 1, 100, freeText)
                        .confConditionalRequired(ER7020PosLtlbDppkPmi.genConditionForTotal())));

        fs.add(sf(3, null, "Nomor Kontrak",
                sv(O, 1, 100, freeText)
                        .confConditionalRequired(ER7020PosLtlbDppkPmi.genConditionForTotal())));

        fs.add(sf(4, null, "Tanggal Kontrak",
                sv(O, 8, 8, numeric)
                        .confConditionalRequired(ER7020PosLtlbDppkPmi.genConditionForTotal())));

        fs.add(sf(5, null, "Masa Perjanjian",
                sv(O, 1, 18, numeric)
                        .confConditionalRequired(ER7020PosLtlbDppkPmi.genConditionForTotal())));

        fs.add(sf(6, null, "Jenis Investasi",
                sv(O, 1, 6, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataShared.R022.getObject())
                        .confConditionalRequired(ER7020PosLtlbDppkPmi.genConditionForTotal())));

        fs.add(sf(7, null, "Jumlah Nilai Wajar Dana Kelolaan (Rp)",
                sv(O, 1, 18, numeric)));

        fs.add(sf(8, null, "Nilai Perolehan (yang dikelola Manajer Investasi)",
                sv(O, 1, 18, numeric)));

        fs.add(sf(9, null, "Selisih Penilaian Investasi",
                sv(O, 1, 18, numeric))
                .addFieldValidations(ER7020PosLtlbDppkPmi.genFieldValidationPenilaianInvesatsi()));

        fs.add(sf(10, null, "Return (%)",
                sv(O, 4, 6, numericDot)
                        .confConditionalRequired(ER7020PosLtlbDppkPmi.genConditionForTotal())));

        fs.add(sf(11, null, "Tingkat Hasil Investasi Bersih (Rp)",
                sv(O, 1, 18, numeric)));

        fs.add(sf(12, null, "Jumlah Biaya Pengelolaan yang dibebankan (Rp)",
                sv(O, 1, 18, numeric)));

        fs.add(sf(13, null, "Terafiliasi dengan Dana Pensiun (Ya/Tidak)",
                sv(O, 1, 10, alfa)
                        .confConditionalRequired(ER7020PosLtlbDppkPmi.genConditionForTotal())));


        return res;
    }
}
