package id.go.ojk.dppkk.client.builder.field.ltlb;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.metadata.module.lblt.field.*;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.util.constants.SectorType;
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
        SectorType sectorType = SectorType.KONVENSIONAL;

        return Arrays.asList(
                Dppk0000Dtum.formMetadata(sectorType, programType),
                Dppk0001Lan.formMetadata(sectorType, programType),
                Dppk0002Lpan.formMetadata(sectorType, programType),
                Dppk0003Nrc.formMetadata(sectorType, programType),
                Dppk0004Lphu.formMetadata(sectorType, programType),
                Dppk0005Lak.formMetadata(sectorType, programType),
                Dppk0006Pst.formMetadata(sectorType, programType),
                Dppk0007Kup.formMetadata(sectorType, programType),
                Dppk0008Rekinv.formMetadata(sectorType, programType),
                Dppk0009Roi.formMetadata(sectorType, programType),
                /* Dppk0010Roiml.formMetadata(programType) ==> Tidak digunakan di Jenis Program PPMPM */
                Dppk0011Roism.formMetadata(sectorType, programType),
                Dppk0012Alm.formMetadata(sectorType, programType),
                Dppk0013Insp.formMetadata(sectorType, programType),
                Dppk0014Inpt.formMetadata(sectorType, programType),
                Dppk0015Inbm.formMetadata(sectorType, programType),
                Dppk0016Sbn.formMetadata(sectorType, programType),
                Dppk0017Ras1.formMetadata(sectorType, programType),
                Dppk0018Ras2.formMetadata(sectorType, programType),
                Dppk0019Pius.formMetadata(sectorType, programType),
                Dppk0020Pmi.formMetadata(sectorType, programType),
                Dppk0021Tbdsp.formMetadata(sectorType, programType),
                Dppk0022Doc.formMetadata(sectorType, programType),
                Dppk0023Dpjka.formMetadata(sectorType, programType),
                Dppk0024Dpjkv.formMetadata(sectorType, programType),
                Dppk0025Srdp.formMetadata(sectorType, programType),
                Dppk0026Sbi.formMetadata(sectorType, programType),
                Dppk0027Rsbn.formMetadata(sectorType, programType),
                Dppk0028Shm.formMetadata(sectorType, programType),
                Dppk0029Obli.formMetadata(sectorType, programType),
                Dppk0030Sukuk.formMetadata(sectorType, programType),
                Dppk0031Obsud.formMetadata(sectorType, programType),
                Dppk0032Rksd.formMetadata(sectorType, programType),
                Dppk0033Mtn.formMetadata(sectorType, programType),
                Dppk0034Eba.formMetadata(sectorType, programType),
                Dppk0035Dire.formMetadata(sectorType, programType),
                Dppk0036Dnfra.formMetadata(sectorType, programType),
                Dppk0037Kokb.formMetadata(sectorType, programType),
                Dppk0038Repo.formMetadata(sectorType, programType),
                Dppk0039Pnyl.formMetadata(sectorType, programType),
                Dppk0040Prop.formMetadata(sectorType, programType),
                Dppk0041Kasb.formMetadata(sectorType, programType),
                Dppk0042Piut.formMetadata(sectorType, programType),
                Dppk0043Piub.formMetadata(sectorType, programType),
                Dppk0044Bbmk.formMetadata(sectorType, programType),
                Dppk0045Piui.formMetadata(sectorType, programType),
                Dppk0046Pihi.formMetadata(sectorType, programType),
                Dppk0047Pill.formMetadata(sectorType, programType),
                Dppk0048Tnbg.formMetadata(sectorType, programType),
                Dppk0049Kndr.formMetadata(sectorType, programType),
                Dppk0050Pkom.formMetadata(sectorType, programType),
                Dppk0051Pkan.formMetadata(sectorType, programType),
                Dppk0052Asol.formMetadata(sectorType, programType),
                Dppk0053Asln.formMetadata(sectorType, programType),
                Dppk0054Umpj.formMetadata(sectorType, programType),
                Dppk0055Umps.formMetadata(sectorType, programType),
                Dppk0056Utin.formMetadata(sectorType, programType),
                Dppk0057Pddm.formMetadata(sectorType, programType),
                Dppk0058Bmhb.formMetadata(sectorType, programType),
                Dppk0059Utln.formMetadata(sectorType, programType),
                Dppk0060Ppin.formMetadata(sectorType, programType),
                Dppk0061Iur.formMetadata(sectorType, programType),
                Dppk0062Pdin.formMetadata(sectorType, programType),
                Dppk0063Pdpl.formMetadata(sectorType, programType),
                Dppk0064Binv.formMetadata(sectorType, programType),
                Dppk0065Bopr.formMetadata(sectorType, programType),
                Dppk0066Bipr.formMetadata(sectorType, programType),
                Dppk0067Pph.formMetadata(sectorType, programType),
                Dppk0068Pkpl.formMetadata(sectorType, programType),
                Dppk9999Cover.getFormMetadata(programType)
        );
    }

}
