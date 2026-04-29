package id.go.ojk.dppks.client.builder.field.lblt;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.module.lblt.dppk.field.*;
import id.go.ojk.util.constants.ProgramType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataPPMPM {

    @Getter
    private static final List<SubmissionFormat> metadata = getFormMetadata();

    private static List<SubmissionFormat> getFormMetadata() {
        ProgramType programType = ProgramType.PPMPM;

        return Arrays.asList(
                Dppk0000Dtum.ppmpKonvensionalFormMetadata(programType),
                Dppk0019Pius.ppmpKonvensionalFormMetadata(programType),
                Dppk0020Pmi.ppmpKonvensionalFormMetadata(programType),
                Dppk0021Tbdsp.ppmpKonvensionalFormMetadata(programType),
                Dppk0022Doc.ppmpKonvensionalFormMetadata(programType),
                Dppk0023Dpjka.ppmpKonvensionalFormMetadata(programType),
                Dppk0024Dpjkv.ppmpKonvensionalFormMetadata(programType),
                Dppk0025Srdp.ppmpKonvensionalFormMetadata(programType),
                Dppk0026Sbi.ppmpKonvensionalFormMetadata(programType),
                Dppk0027Rsbn.ppmpKonvensionalFormMetadata(programType),
                Dppk0028Shm.ppmpKonvensionalFormMetadata(programType),
                Dppk0029Obli.ppmpKonvensionalFormMetadata(programType),
                Dppk0030Sukuk.ppmpKonvensionalFormMetadata(programType),
                Dppk0031Obsud.ppmpKonvensionalFormMetadata(programType),
                Dppk0032Rksd.ppmpKonvensionalFormMetadata(programType),
                Dppk0033Mtn.ppmpKonvensionalFormMetadata(programType),
                Dppk0034Eba.ppmpKonvensionalFormMetadata(programType),
                Dppk0035Dire.ppmpKonvensionalFormMetadata(programType),
                Dppk0036Dnfra.ppmpKonvensionalFormMetadata(programType),
                Dppk0037Kokb.ppmpKonvensionalFormMetadata(programType),
                Dppk0038Repo.ppmpKonvensionalFormMetadata(programType),
                Dppk0039Pnyl.ppmpKonvensionalFormMetadata(programType),
                Dppk0040Prop.ppmpKonvensionalFormMetadata(programType),
                Dppk0041Kasb.ppmpKonvensionalFormMetadata(programType),
                Dppk0042Piut.ppmpKonvensionalFormMetadata(programType),
                Dppk0043Piub.ppmpKonvensionalFormMetadata(programType),
                Dppk0044Bbmk.ppmpKonvensionalFormMetadata(programType),
                Dppk0045Piui.ppmpKonvensionalFormMetadata(programType),
                Dppk0046Pihi.ppmpKonvensionalFormMetadata(programType),
                Dppk0047Pill.ppmpKonvensionalFormMetadata(programType),
                Dppk0048Tnbg.ppmpKonvensionalFormMetadata(programType),
                Dppk0049Kndr.ppmpKonvensionalFormMetadata(programType),
                Dppk0050Pkom.ppmpKonvensionalFormMetadata(programType),
                Dppk0051Pkan.ppmpKonvensionalFormMetadata(programType),
                Dppk0052Asol.ppmpKonvensionalFormMetadata(programType),
                Dppk0053Asln.ppmpKonvensionalFormMetadata(programType),
                Dppk0054Umpj.ppmpKonvensionalFormMetadata(programType),
                Dppk0055Umps.ppmpKonvensionalFormMetadata(programType),
                Dppk0056Utin.ppmpKonvensionalFormMetadata(programType),
                Dppk0057Pddm.ppmpKonvensionalFormMetadata(programType),
                Dppk0058Bmhb.ppmpKonvensionalFormMetadata(programType),
                Dppk0059Utln.ppmpKonvensionalFormMetadata(programType),
                Dppk0060Ppin.ppmpKonvensionalFormMetadata(programType),
                Dppk0061Iur.ppmpKonvensionalFormMetadata(programType),
                Dppk0062Pdin.ppmpKonvensionalFormMetadata(programType),
                Dppk0063Pdpl.ppmpKonvensionalFormMetadata(programType),
                Dppk0064Binv.ppmpKonvensionalFormMetadata(programType),
                Dppk0065Bopr.ppmpKonvensionalFormMetadata(programType),
                Dppk0066Bipr.ppmpKonvensionalFormMetadata(programType),
                Dppk0067Pph.ppmpKonvensionalFormMetadata(programType),
                Dppk0068Pkpl.ppmpKonvensionalFormMetadata(programType),
                Dppk0099Cover.getFormMetadata(programType)
        );
    }

}
