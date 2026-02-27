package id.go.ojk.dppkk.client.builder.field.ltlb.metadata;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataPPMPK {

    @Getter
    private static final List<SubmissionFormat> metadata = getFormMetadata();

    private static List<SubmissionFormat> getFormMetadata() {
        String REPORT_CODE = "PPMPK";
        return Arrays.asList(
//                new Ltlb0001DTUM(REPORT_CODE).get(),
//                new Ltlb0002LAN(REPORT_CODE).get(),
                new Ltlb0003LPAN(REPORT_CODE).get(),
////                new Ltlb0004NRC(REPORT_CODE).get(),
////                new Ltlb0005LPHU(REPORT_CODE).get(),
//                new Ltlb0006LAK(REPORT_CODE).get(),
//                new Ltlb0007PST(REPORT_CODE).get(),
////                new Ltlb0008KUP(REPORT_CODE).get(),
//                new Ltlb0009REKINV(REPORT_CODE).get(),
////                new Ltlb0010ROI(REPORT_CODE).get(),
//                new Ltlb0011ROIML(REPORT_CODE).get(),
//                new Ltlb0012ROISM(REPORT_CODE).get(),
//                new Ltlb0013ALM(REPORT_CODE).get(),
//                new Ltlb0014INSP(REPORT_CODE).get(),
//                new Ltlb0015INPT(REPORT_CODE).get(),
//                new Ltlb0016INBM(REPORT_CODE).get(),
//                new Ltlb0017SBN(REPORT_CODE).get()
////                new Ltlb0018RAS1(REPORT_CODE).get(),
//                new Ltlb0019RAS2(REPORT_CODE).get(),
//                new Ltlb0020PIUS(REPORT_CODE).get(),
//                new Ltlb0021PMI(REPORT_CODE).get(),
//                new Ltlb0022TBDSP(REPORT_CODE).get(),
//                new Ltlb0023DOC(REPORT_CODE).get(),
//                new Ltlb0024DPJKA(REPORT_CODE).get(),
//                new Ltlb0025DPJKV(REPORT_CODE).get(),
//                new Ltlb0026SRDP(REPORT_CODE).get(),
//                new Ltlb0027SBI(REPORT_CODE).get(),
//                new Ltlb0028RSBN(REPORT_CODE).get(),
//                new Ltlb0029SHM(REPORT_CODE).get(),
//                new Ltlb0030OBLI(REPORT_CODE).get(),
//                new Ltlb0031SUKUK(REPORT_CODE).get(),
//                new Ltlb0032OBSUD(REPORT_CODE).get(),
//                new Ltlb0033RKSD(REPORT_CODE).get(),
//                new Ltlb0034MTN(REPORT_CODE).get(),
//                new Ltlb0035EBA(REPORT_CODE).get(),
//                new Ltlb0036DIRE(REPORT_CODE).get(),
//                new Ltlb0037DNFRA(REPORT_CODE).get(),
//                new Ltlb0038KOKB(REPORT_CODE).get(),
//                new Ltlb0039REPO(REPORT_CODE).get(),
//                new Ltlb0040PNYL(REPORT_CODE).get(),
//                new Ltlb0041PROP(REPORT_CODE).get(),
//                new Ltlb0042KASB(REPORT_CODE).get(),
//                new Ltlb0043PIUT(REPORT_CODE).get(),
//                new Ltlb0044PIUB(REPORT_CODE).get(),
//                new Ltlb0045BBMK(REPORT_CODE).get(),
//                new Ltlb0046PIUI(REPORT_CODE).get(),
//                new Ltlb0047PIHI(REPORT_CODE).get(),
//                new Ltlb0048PILL(REPORT_CODE).get(),
//                new Ltlb0049TNBG(REPORT_CODE).get(),
//                new Ltlb0050KNDR(REPORT_CODE).get(),
//                new Ltlb0051PKOM(REPORT_CODE).get(),
//                new Ltlb0052PKAN(REPORT_CODE).get(),
//                new Ltlb0053ASOL(REPORT_CODE).get(),
//                new Ltlb0054ASLN(REPORT_CODE).get(),
//                new Ltlb0055UMPJ(REPORT_CODE).get(),
//                new Ltlb0056UMPS(REPORT_CODE).get(),
//                new Ltlb0057UTIN(REPORT_CODE).get(),
//                new Ltlb0058PDDM(REPORT_CODE).get(),
//                new Ltlb0059BMHB(REPORT_CODE).get(),
//                new Ltlb0060UTLN(REPORT_CODE).get(),
//                new Ltlb0061PPIN(REPORT_CODE).get(),
                new Ltlb0062IUR(REPORT_CODE).get()
//                new Ltlb0063PDIN(REPORT_CODE).get(),
//                new Ltlb0064PDPL(REPORT_CODE).get(),
//                new Ltlb0065BINV(REPORT_CODE).get(),
//                new Ltlb0066BOPR(REPORT_CODE).get(),
//                new Ltlb0067BIPR(REPORT_CODE).get(),
//                new Ltlb0068PPH(REPORT_CODE).get(),
//                new Ltlb0069PKPL(REPORT_CODE).get()
                );
    }
}
