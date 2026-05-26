package id.go.ojk.dppkk.client.builder.field.ltlb.metadata;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.metadata.module.lblt.dppk.field.*;
import id.go.ojk.metadata.util.constants.ProgramType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataPPIPK {

    @Getter
    private static final List<SubmissionFormat> metadata = getFormMetadata();

    private static List<SubmissionFormat> getFormMetadata() {
        ProgramType programType = ProgramType.PPIPK;

        return Arrays.asList(
                Dppk0000Dtum.formMetadata(programType),
                Dppk0001Lan.formMetadata(programType),
                Dppk0002Lpan.formMetadata(programType),
                Dppk0003Nrc.formMetadata(programType),
                Dppk0004Lphu.formMetadata(programType),
                Dppk0005Lak.formMetadata(programType),
                Dppk0006Pst.formMetadata(programType),
//                Dppk0007Kup.formMetadata(programType),
                Dppk0008Rekinv.formMetadata(programType),
                Dppk0009Roi.formMetadata(programType),
                Dppk0010Roiml.formMetadata(programType),
                Dppk0011Roism.formMetadata(programType),
                Dppk0101Roimpl.formMetadata(programType),
                Dppk0012Alm.formMetadata(programType),
                Dppk0013Insp.formMetadata(programType),
                Dppk0014Inpt.formMetadata(programType),
                Dppk0015Inbm.formMetadata(programType),
                Dppk0016Sbn.formMetadata(programType),
                Dppk0017Ras1.formMetadata(programType),
                Dppk0018Ras2.formMetadata(programType),
                Dppk0102Pinv.formMetadata(programType),
                Dppk0103Pinvs.formMetadata(programType),
                Dppk0104Mpbk.formMetadata(programType),
                Dppk0105Pmbk.formMetadata(programType),
                Dppk0019Pius.formMetadata(programType),
                Dppk0020Pmi.formMetadata(programType),
                Dppk0021Tbdsp.formMetadata(programType),
                Dppk0022Doc.formMetadata(programType),
                Dppk0023Dpjka.formMetadata(programType),
                Dppk0024Dpjkv.formMetadata(programType),
                Dppk0025Srdp.formMetadata(programType),
                Dppk0026Sbi.formMetadata(programType),
                Dppk0027Rsbn.formMetadata(programType),
                Dppk0028Shm.formMetadata(programType),
                Dppk0029Obli.formMetadata(programType),
                Dppk0030Sukuk.formMetadata(programType),
                Dppk0031Obsud.formMetadata(programType),
                Dppk0032Rksd.formMetadata(programType),
                Dppk0033Mtn.formMetadata(programType),
                Dppk0034Eba.formMetadata(programType),
                Dppk0035Dire.formMetadata(programType),
                Dppk0036Dnfra.formMetadata(programType),
                Dppk0037Kokb.formMetadata(programType),
                Dppk0038Repo.formMetadata(programType),
                Dppk0039Pnyl.formMetadata(programType),
                Dppk0040Prop.formMetadata(programType),
                Dppk0041Kasb.formMetadata(programType),
                Dppk0042Piut.formMetadata(programType),
                Dppk0043Piub.formMetadata(programType),
                Dppk0044Bbmk.formMetadata(programType),
                Dppk0045Piui.formMetadata(programType),
                Dppk0046Pihi.formMetadata(programType),
                Dppk0047Pill.formMetadata(programType),
                Dppk0048Tnbg.formMetadata(programType),
                Dppk0049Kndr.formMetadata(programType),
                Dppk0050Pkom.formMetadata(programType),
                Dppk0051Pkan.formMetadata(programType),
                Dppk0052Asol.formMetadata(programType),
                Dppk0053Asln.formMetadata(programType),
                Dppk0054Umpj.formMetadata(programType),
                Dppk0055Umps.formMetadata(programType),
                Dppk0056Utin.formMetadata(programType),
                Dppk0057Pddm.formMetadata(programType),
                Dppk0058Bmhb.formMetadata(programType),
                Dppk0059Utln.formMetadata(programType),
                Dppk0060Ppin.formMetadata(programType),
                Dppk0061Iur.formMetadata(programType),
                Dppk0062Pdin.formMetadata(programType),
                Dppk0063Pdpl.formMetadata(programType),
                Dppk0064Binv.formMetadata(programType),
                Dppk0065Bopr.formMetadata(programType),
                Dppk0066Bipr.formMetadata(programType),
                Dppk0067Pph.formMetadata(programType),
                Dppk0068Pkpl.formMetadata(programType),
                Dppk9999Cover.getFormMetadata(programType)
        );
    }

}
