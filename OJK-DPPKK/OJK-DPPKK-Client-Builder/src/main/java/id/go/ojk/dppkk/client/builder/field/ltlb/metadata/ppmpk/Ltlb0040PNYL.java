package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.EHeaderMetadataPpmpk;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7039PosLtlbDppkPnyl;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0040PNYL extends BaseMetadata {

    public Ltlb0040PNYL(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_PNYL;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        res.setSavePos(ER7039PosLtlbDppkPnyl.genFieldSave());
        res.setRequiredPos(ER7039PosLtlbDppkPnyl.getRequiredPos());

//        res.addSegmentValidations(ER7039PosLtlbDppkPnyl.genValidation());

        List<SubmissionField> fs = res.getFields();


        fs.add(sf(0, null, "Flag",
                sv(M, 3, 3, alfaNumeric)
                        .confConstant("D01")));

        
        fs.add(sf(1, null, "Kode Komponen",
                sv(M, 10, 10, refTable)
                        .confRegex(SimpleValidation.patternAlfaNumeric)
                        .confReference(EHeaderMetadataPpmpk.R7039Pnyl.getObject())));

        fs.add(sf(2, null, "Nama Perusahaan(1)",
                sv(C, 1, 100, alfaNumeric)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())));

        fs.add(sf(3, null, "Perwakilan Dana Pensiun Nama",
                sv(C, 1, 100, alfa)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionValidationNamaPerusahaan())));

        fs.add(sf(4, null, "Perwakilan Dana Pensiun Jabatan",
                sv(C, 1, 50, alfaNumeric)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionValidationNamaPerusahaan())));

        fs.add(sf(5, null, "Kategori Penyertaan*)",
                sv(C, 1, 8, alfaNumeric)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionValidationNamaPerusahaan())));

        fs.add(sf(6, null, "Tanggal Perolehan",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionValidationNamaPerusahaan())));

        fs.add(sf(7, null, "Penempatan Awal Tanggal",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionValidationNamaPerusahaan())));

        fs.add(sf(8, null, "Penempatan Awal % Kepemilikan",
                sv(C, 2, 5, numericDot)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionValidationNamaPerusahaan())));

        fs.add(sf(9, null, "Penempatan Awal Total",
                sv(M, 1, 18, numeric)));

        fs.add(sf(10, null, "Nilai Perolehan Per tanggal laporan % Kepemilikan",
                sv(C, 3, 5, numericDot)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionValidationNamaPerusahaan())));

        fs.add(sf(11, null, "Nilai Perolehan Per tanggal laporan Total",
                sv(M, 1, 18, numeric)));

        fs.add(sf(12, null, "Nilai Apprasial/wajar Nama Penilai Publik/Independen",
                sv(C, 1, 100, alfa)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionValidationNamaPerusahaan())));

        fs.add(sf(13, null, "Nilai Apprasial/wajar Tanggal",
                sv(C, 8, 8, date)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionValidationNamaPerusahaan())));

        fs.add(sf(14, null, "Nilai Apprasial/wajar % Kepemilikan",
                sv(C, 2, 5, numericDot)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionValidationNamaPerusahaan())));

        fs.add(sf(15, null, "Nilai Apprasial/wajar Total",
                sv(M, 1, 18, numeric)));

        fs.add(sf(16, null, "Selisih Penilaian Investasi Nilai",
                sv(M, 1, 18, numeric)));

        fs.add(sf(17, null, "Selisih Penilaian Investasi %",
                sv(C, 2, 5, numericDot)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionValidationNamaPerusahaan())));

        fs.add(sf(18, null, "Sektor Ekonomi",
                sv(C, 1, 8, alfa)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionValidationNamaPerusahaan())));

        fs.add(sf(19, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                sv(C, 1, 6, alfaNumeric)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionValidationNamaPerusahaan())));

        fs.add(sf(20, null, "Keterangan",
                sv(C, 1, 250, freeText)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())));

        fs.add(sf(21, null, "Total Modal Disetor",
                sv(M, 1, 18, numeric)));

        fs.add(sf(22, null, "Presentase kepemilikan (v) Pendiri",
                sv(C, 2, 5, numericDot)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())));

        fs.add(sf(23, null, "Presentase kepemilikan (v) Dana Pensiun",
                sv(C, 2, 5, numericDot)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())));

        fs.add(sf(24, null, "Presentase kepemilikan (v) Mitra Pendiri",
                sv(C, 2, 5, numericDot)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())));

        fs.add(sf(25, null, "Presentase kepemilikan (v) Pengurus",
                sv(C, 2, 5, numericDot)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())));

        fs.add(sf(26, null, "Presentase kepemilikan (v) Penerima titipan",
                sv(C, 2, 5, numericDot)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())));

        fs.add(sf(27, null, "Presentase kepemilikan (v) Serikat Kerja yang Anggotanya Merupakan Peserta DP",
                sv(C, 2, 5, numericDot)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())));

        fs.add(sf(28, null, "Presentase kepemilikan (v) Lainnya",
                sv(C, 2, 5, numericDot)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())));

        fs.add(sf(29, null, "Anak Perusahaan dari Penyertaan Langsung(2)",
                sv(C, 1, 100, freeText)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionValidationNamaPerusahaan())));

        fs.add(sf(30, null, "Total Modal Disetor Anak Perusahaan dari Penyertaan Langsung",
                sv(M, 1, 18, numeric)));

        fs.add(sf(31, null, "Presentase Kepemilikan (e1) Pendiri",
                sv(C, 2, 5, numericDot)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())));

        fs.add(sf(32, null, "Presentase Kepemilikan (e1) Mitra Pendiri",
                sv(C, 2, 5, numericDot)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())));

        fs.add(sf(33, null, "Presentase Kepemilikan (e1) Pengurus",
                sv(C, 2, 5, numericDot)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())));

        fs.add(sf(34, null, "Presentase Kepemilikan (e1) Penerima Titipan",
                sv(C, 2, 5, numericDot)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())));

        fs.add(sf(35, null, "Presentase Kepemilikan (e1) Serikat Kerja yang Anggotanya Merupakan Peserta DP",
                sv(C, 2, 5, numericDot)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())));

        fs.add(sf(36, null, "Presentase Kepemilikan (e1) Lainnya",
                sv(C, 2, 5, numericDot)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())));

        fs.add(sf(37, null, "Presentase Kepemilikan (e1) Dividen Anak Perusahaan",
                sv(C, 1, 18, numeric)
                        .confConditionalRequired(ER7039PosLtlbDppkPnyl.genConditionForTotal())));


        return res;
    }
}
