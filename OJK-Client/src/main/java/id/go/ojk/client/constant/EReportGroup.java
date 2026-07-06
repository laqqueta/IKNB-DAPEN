package id.go.ojk.client.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReportGroup {
    RB("Laporan Rencana Bisnis"),
    LB("Laporan Bulanan"),
    LT("Laporan Tahunan"),
    SA("Laporan Self Assessment"),
    APU("Laporan APU-PPT"),
    LBK("Laporan Berkala"),
    TL("Laporan Tindak Lanjut"),
    PLS("Laporan Polis"),
    TPP("Laporan TPPU, TPPT, PPSPM"),
    BPKSLB("Laporan Bulanan"),
    BPTKLKB("Laporan Keuangan Bulanan"),
    BPTKLPP("Laporan Pengelolaan Program (LPP)"),
    BPTKLKT("Laporan Keuangan Tahunan"),
    BPTKLAT("Laporan Aktuaris Tahunan Jaminan Sosial Ketenagakerjaan"),
    LKBT("Laporan Keuangan Bulanan dan Tahunan"),
    ;

    @Getter
    private String name;
}
