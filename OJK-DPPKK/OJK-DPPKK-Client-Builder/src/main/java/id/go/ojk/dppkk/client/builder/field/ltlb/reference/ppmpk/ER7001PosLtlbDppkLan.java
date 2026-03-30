package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1255JenisManfaat;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7001PosLtlbDppkLan implements IObject<KeyValueString> {

    R_LAN0101010000("LAN0101010000", "Deposito on call pada Bank"),
    R_LAN0101020000("LAN0101020000", "Deposito Berjangka pada Bank"),
    R_LAN0101030000("LAN0101030000", "Sertifikat Deposito pada Bank"),
    R_LAN0101040000("LAN0101040000", "Surat Berharga yang diterbitkan oleh Bank Indonesia"),
    R_LAN0101050000("LAN0101050000", "Surat Berharga Negara"),
    R_LAN0101060000("LAN0101060000", "Saham yang tercatat di Bursa Efek di Indonesia"),
    R_LAN0101070000("LAN0101070000", "Obligasi korporasi yang tercatat di Bursa Efek di indonesia"),
    R_LAN0101080000("LAN0101080000", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
    R_LAN0101090000("LAN0101090000", "Obligasi/Sukuk Daerah"),
    R_LAN0101100000("LAN0101100000", "Reksa Dana"),
    R_LAN0101110000("LAN0101110000", "MTN"),
    R_LAN0101120000("LAN0101120000", "Efek Beragun Aset"),
    R_LAN0101130000("LAN0101130000", "Dana investasi real estat berbentuk kontrak investasi kolektif"),
    R_LAN0101140000("LAN0101140000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
    R_LAN0101150000("LAN0101150000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia"),
    R_LAN0101160000("LAN0101160000", "REPO"),
    R_LAN0101170000("LAN0101170000", "Penyertaan langsung di Indonesia"),
    R_LAN0101180000("LAN0101180000", "Tanah di Indonesia"),
    R_LAN0101190000("LAN0101190000", "Bangunan di Indonesia"),
    R_LAN0101200000("LAN0101200000", "Tanah dan Bangunan di Indonesia"),
    R_LAN0102000000("LAN0102000000", "TOTAL INVESTASI"),
    R_LAN0103010000("LAN0103010000", "Kas dan Bank"),
//    R_LAN0103020000("LAN0103020000", "Piutang Iuran"),
    R_LAN0103030000("LAN0103030000", "- Iuran Normal Pemberi Kerja"),
    R_LAN0103040000("LAN0103040000", "- Iuran Normal Peserta"),
    R_LAN0103050000("LAN0103050000", "- Iuran Sukarela Peserta"),
    R_LAN0103060000("LAN0103060000", "Piutang Bunga Keterlambatan Iuran"),
    R_LAN0103070000("LAN0103070000", "Beban Dibayar di Muka"),
    R_LAN0103080000("LAN0103080000", "Piutang Investasi"),
    R_LAN0103090000("LAN0103090000", "Piutang Hasil Investasi"),
    R_LAN0103100000("LAN0103100000", "Piutang Lain-Lain"),
    R_LAN0104000000("LAN0104000000", "TOTAL ASET LANCAR DI LUAR INVESTASI"),
    R_LAN0104020000("LAN0104020000", "Tanah dan Bangunan"),
    R_LAN0104030000("LAN0104030000", "Kendaraan"),
    R_LAN0104040000("LAN0104040000", "Peralatan Komputer"),
    R_LAN0104050000("LAN0104050000", "Peralatan Kantor"),
    R_LAN0104060000("LAN0104060000", "Aset Operasional Lain"),
    R_LAN0105000000("LAN0105000000", "TOTAL ASET OPERASIONAL"),
    R_LAN0106000000("LAN0106000000", "ASET LAIN-LAIN"),
    R_LAN0107000000("LAN0107000000", "ASET TERSEDIA"),
    R_LAN0108020000("LAN0108020000", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo"),
    R_LAN0108030000("LAN0108030000", "Utang Manfaat Sukarela"),
    R_LAN0108040000("LAN0108040000", "Utang Investasi"),
    R_LAN0108050000("LAN0108050000", "Pendapatan Diterima di Muka"),
    R_LAN0108060000("LAN0108060000", "Beban yang Masih Harus Dibayar"),
    R_LAN0108070000("LAN0108070000", "Utang Lain-Lain"),
    R_LAN0108080000("LAN0108080000", "Utang Dana Ta'zir (bagi syariah)"),
    R_LAN0108090000("LAN0108090000", "Total Liabilitas di luar Liabilitas Manfaat Pensiun"),
    R_LAN0109000000("LAN0109000000", "TOTAL LIABILITAS"),
    R_LAN0110000000("LAN0110000000", "ASET NETO");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7001PosLtlbDppkLan eEnum : ER7001PosLtlbDppkLan.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7001PosLtlbDppkLan.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7001PosLtlbDppkLan.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects());
    }

    public static SegmentValidation getTestVal() {
        String sumField = "3";
        String rangeField = "6|6"; // I H J K
        String criteriaField = "9|12";
        String comparatorForms = EFormLaporanTahunanLaporanBulanan.LTLB_DPJKA.getCode() + "|" + EFormLaporanTahunanLaporanBulanan.LTLB_DPJKV.getCode();
        String comparatorRows = ER7023PosLtlbDppkDpjka.R_DPJKA010000.getObject().getKey() + "|" + ER7024PosLtlbDppkDpjkv.R_DPJKV010000.getObject().getKey();
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCond = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String sumConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
        String errMsg = "DPJKA|DPJKV|Jumlah Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain";

        return UtilSegmentValidation.genMultiFormSumIf(UtilMetadata.genPipeColumn(3, 12), R_LAN0101020000.key,
                comparatorForms, comparatorRows,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCond,
                errMsg, criteriaConditionErr, sumConditionErr);
    }
}
