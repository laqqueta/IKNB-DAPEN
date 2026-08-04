package id.go.ojk.metadata.module.lblt.header;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import id.go.ojk.metadata.module.lblt.reference.*;
import id.go.ojk.metadata.util.constants.ProgramType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataLkdpPpmpppipk implements IObject<ReferenceMetadata> {
//    R7500Dtum(ER7000PosLtlbDppkDtum.getRefNumber(7500), ER7000PosLtlbDppkDtum.getName(), ER7000PosLtlbDppkDtum.getObjects()),
    R7501Lan(ER7001PosLtlbDppkLan.getRefNumber(7501), ER7001PosLtlbDppkLan.getName(), ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPPPIPK)),
//    R7502Lpan(ER7002PosLtlbDppkLpan.getRefNumber(7502), ER7002PosLtlbDppkLpan.getName(), ER7002PosLtlbDppkLpan.getObjects(ProgramType.PPMPK)),
//    R7503Nrc(ER7003PosLtlbDppkNrc.getRefNumber(7503), ER7003PosLtlbDppkNrc.getName(), ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK)),
//    R7504Lphu(ER7004PosLtlbDppkLphu.getRefNumber(7504), ER7004PosLtlbDppkLphu.getName(), ER7004PosLtlbDppkLphu.getObjects()),
//    R7505Lak(ER7005PosLtlbDppkLak.getRefNumber(7505), ER7005PosLtlbDppkLak.getName(), ER7005PosLtlbDppkLak.getObjects()),
//    R7506Pst(ER7006PosLtlbDppkPst.getRefNumber(7506), ER7006PosLtlbDppkPst.getName(), ER7006PosLtlbDppkPst.getObjects()),
//    R7507Kup(ER7007PosLtlbDppkKup.getRefNumber(7507), ER7007PosLtlbDppkKup.getName(), ER7007PosLtlbDppkKup.getObjects(ProgramType.PPMPK)),
//    R7508Rekinv(ER7008PosLtlbDppkRekinv.getRefNumber(7508), ER7008PosLtlbDppkRekinv.getName(), ER7008PosLtlbDppkRekinv.getObjects(ProgramType.PPMPK)),
//    R7509Lcf(ER7201PosLtlbDppkLcf.getRefNumber(7509), ER7201PosLtlbDppkLcf.getName(), ER7201PosLtlbDppkLcf.getObjects()),
//    R7510Roi(ER7009PosLtlbDppkRoi.getRefNumber(7510), ER7009PosLtlbDppkRoi.getName(), ER7009PosLtlbDppkRoi.getObjects()),
//    R7511Roiml(ER7010PosLtlbDppkRoiml.getRefNumber(7511), ER7010PosLtlbDppkRoiml.getName(), ER7010PosLtlbDppkRoiml.getObjects()),
//    R7512Roism(ER7011PosLtlbDppkRoism.getRefNumber(7512), ER7011PosLtlbDppkRoism.getName(), ER7011PosLtlbDppkRoism.getObjects()),
//    R7513Roimpl(ER7101PosLtlbDppkRoimpl.getRefNumber(7513), ER7101PosLtlbDppkRoimpl.getName(), ER7101PosLtlbDppkRoimpl.getObjects()),
//    R7514Alm(ER7012PosLtlbDppkAlm.getRefNumber(7514), ER7012PosLtlbDppkAlm.getName(), ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK)),
//    R7515Insp(ER7013PosLtlbDppkInsp.getRefNumber(7515), ER7013PosLtlbDppkInsp.getName(), ER7013PosLtlbDppkInsp.getObjects()),
//    R7516Inpt(ER7014PosLtlbDppkInpt.getRefNumber(7516), ER7014PosLtlbDppkInpt.getName(), ER7014PosLtlbDppkInpt.getObjects()),
//    R7517Inbm(ER7015PosLtlbDppkInbm.getRefNumber(7517), ER7015PosLtlbDppkInbm.getName(), ER7015PosLtlbDppkInbm.getObjects()),
//    R7518Sbn(ER7016PosLtlbDppkSbn.getRefNumber(7518), ER7016PosLtlbDppkSbn.getName(), ER7016PosLtlbDppkSbn.getObjects()),
//    R7519Ras1(ER7017PosLtlbDppkRas1.getRefNumber(7519), ER7017PosLtlbDppkRas1.getName(), ER7017PosLtlbDppkRas1.getObjects(ProgramType.PPMPK)),
//    R7520Ras2(ER7018PosLtlbDppkRas2.getRefNumber(7520), ER7018PosLtlbDppkRas2.getName(), ER7018PosLtlbDppkRas2.getObjects()),
//    R7521Pinv(ER7102PosLtlbDppkPinv.getRefNumber(7521), ER7102PosLtlbDppkPinv.getName(), ER7102PosLtlbDppkPinv.getObjects(ProgramType.DPLK)),
//    R7522Pinvs(ER7103PosLtlbDppkPinvs.getRefNumber(7522), ER7103PosLtlbDppkPinvs.getName(), ER7103PosLtlbDppkPinvs.getObjects(ProgramType.DPLK)),
//    R7523Mpbk(ER7104PosLtlbDppkMpbk.getRefNumber(7523), ER7104PosLtlbDppkMpbk.getName(), ER7104PosLtlbDppkMpbk.getObjects()),
//    R7524Pmbk(ER7105PosLtlbDppkPmbk.getRefNumber(7524), ER7105PosLtlbDppkPmbk.getName(), ER7105PosLtlbDppkPmbk.getObjects()),
//    R7525Pius(ER7019PosLtlbDppkPius.getRefNumber(7525), ER7019PosLtlbDppkPius.getName(), ER7019PosLtlbDppkPius.getObjects()),
//    R7526Pmi(ER7020PosLtlbDppkPmi.getRefNumber(7526), ER7020PosLtlbDppkPmi.getName(), ER7020PosLtlbDppkPmi.getObjects()),
//    R7527Tbdsp(ER7021PosLtlbDppkTbdsp.getRefNumber(7527), ER7021PosLtlbDppkTbdsp.getName(), ER7021PosLtlbDppkTbdsp.getObjects()),
//    R7528Doc(ER7022PosLtlbDppkDoc.getRefNumber(7528), ER7022PosLtlbDppkDoc.getName(), ER7022PosLtlbDppkDoc.getObjects()),
//    R7529Dpjka(ER7023PosLtlbDppkDpjka.getRefNumber(7529), ER7023PosLtlbDppkDpjka.getName(), ER7023PosLtlbDppkDpjka.getObjects()),
//    R7530Dpjkv(ER7024PosLtlbDppkDpjkv.getRefNumber(7530), ER7024PosLtlbDppkDpjkv.getName(), ER7024PosLtlbDppkDpjkv.getObjects()),
//    R7531Srdp(ER7025PosLtlbDppkSrdp.getRefNumber(7531), ER7025PosLtlbDppkSrdp.getName(), ER7025PosLtlbDppkSrdp.getObjects()),
//    R7532Sbi(ER7026PosLtlbDppkSbi.getRefNumber(7532), ER7026PosLtlbDppkSbi.getName(), ER7026PosLtlbDppkSbi.getObjects()),
//    R7533Rsbn(ER7027PosLtlbDppkRsbn.getRefNumber(7533), ER7027PosLtlbDppkRsbn.getName(), ER7027PosLtlbDppkRsbn.getObjects()),
//    R7534Shm(ER7028PosLtlbDppkShm.getRefNumber(7534), ER7028PosLtlbDppkShm.getName(), ER7028PosLtlbDppkShm.getObjects()),
//    R7535Obli(ER7029PosLtlbDppkObli.getRefNumber(7535), ER7029PosLtlbDppkObli.getName(), ER7029PosLtlbDppkObli.getObjects()),
//    R7536Sukuk(ER7030PosLtlbDppkSukuk.getRefNumber(7536), ER7030PosLtlbDppkSukuk.getName(), ER7030PosLtlbDppkSukuk.getObjects()),
//    R7537Obsud(ER7031PosLtlbDppkObsud.getRefNumber(7537), ER7031PosLtlbDppkObsud.getName(), ER7031PosLtlbDppkObsud.getObjects()),
//    R7538Rksd(ER7032PosLtlbDppkRksd.getRefNumber(7538), ER7032PosLtlbDppkRksd.getName(), ER7032PosLtlbDppkRksd.getObjects()),
//    R7539Mtn(ER7033PosLtlbDppkMtn.getRefNumber(7539), ER7033PosLtlbDppkMtn.getName(), ER7033PosLtlbDppkMtn.getObjects()),
//    R7540Eba(ER7034PosLtlbDppkEba.getRefNumber(7540), ER7034PosLtlbDppkEba.getName(), ER7034PosLtlbDppkEba.getObjects()),
//    R7541Dire(ER7035PosLtlbDppkDire.getRefNumber(7541), ER7035PosLtlbDppkDire.getName(), ER7035PosLtlbDppkDire.getObjects()),
//    R7542Dnfra(ER7036PosLtlbDppkDnfra.getRefNumber(7542), ER7036PosLtlbDppkDnfra.getName(), ER7036PosLtlbDppkDnfra.getObjects()),
//    R7543Kokb(ER7037PosLtlbDppkKokb.getRefNumber(7543), ER7037PosLtlbDppkKokb.getName(), ER7037PosLtlbDppkKokb.getObjects()),
//    R7544Repo(ER7038PosLtlbDppkRepo.getRefNumber(7544), ER7038PosLtlbDppkRepo.getName(), ER7038PosLtlbDppkRepo.getObjects()),
//    R7545Pnyl(ER7039PosLtlbDppkPnyl.getRefNumber(7545), ER7039PosLtlbDppkPnyl.getName(), ER7039PosLtlbDppkPnyl.getObjects()),
//    R7546Prop(ER7040PosLtlbDppkProp.getRefNumber(7546), ER7040PosLtlbDppkProp.getName(), ER7040PosLtlbDppkProp.getObjects()),
//    R7547Kasb(ER7041PosLtlbDppkKasb.getRefNumber(7547), ER7041PosLtlbDppkKasb.getName(), ER7041PosLtlbDppkKasb.getObjects()),
//    R7548Piut(ER7042PosLtlbDppkPiut.getRefNumber(7548), ER7042PosLtlbDppkPiut.getName(), ER7042PosLtlbDppkPiut.getObjects()),
//    R7549Piub(ER7043PosLtlbDppkPiub.getRefNumber(7549), ER7043PosLtlbDppkPiub.getName(), ER7043PosLtlbDppkPiub.getObjects()),
//    R7550Bbmk(ER7044PosLtlbDppkBbmk.getRefNumber(7550), ER7044PosLtlbDppkBbmk.getName(), ER7044PosLtlbDppkBbmk.getObjects()),
//    R7551Piui(ER7045PosLtlbDppkPiui.getRefNumber(7551), ER7045PosLtlbDppkPiui.getName(), ER7045PosLtlbDppkPiui.getObjects()),
//    R7552Pihi(ER7046PosLtlbDppkPihi.getRefNumber(7552), ER7046PosLtlbDppkPihi.getName(), ER7046PosLtlbDppkPihi.getObjects()),
//    R7553Pill(ER7047PosLtlbDppkPill.getRefNumber(7553), ER7047PosLtlbDppkPill.getName(), ER7047PosLtlbDppkPill.getObjects()),
//    R7554Tnbg(ER7048PosLtlbDppkTnbg.getRefNumber(7554), ER7048PosLtlbDppkTnbg.getName(), ER7048PosLtlbDppkTnbg.getObjects()),
//    R7555Kndr(ER7049PosLtlbDppkKndr.getRefNumber(7555), ER7049PosLtlbDppkKndr.getName(), ER7049PosLtlbDppkKndr.getObjects()),
//    R7556Pkom(ER7050PosLtlbDppkPkom.getRefNumber(7556), ER7050PosLtlbDppkPkom.getName(), ER7050PosLtlbDppkPkom.getObjects()),
//    R7557Pkan(ER7051PosLtlbDppkPkan.getRefNumber(7557), ER7051PosLtlbDppkPkan.getName(), ER7051PosLtlbDppkPkan.getObjects()),
//    R7558Asol(ER7052PosLtlbDppkAsol.getRefNumber(7558), ER7052PosLtlbDppkAsol.getName(), ER7052PosLtlbDppkAsol.getObjects()),
//    R7559Asln(ER7053PosLtlbDppkAsln.getRefNumber(7559), ER7053PosLtlbDppkAsln.getName(), ER7053PosLtlbDppkAsln.getObjects()),
//    R7560Umpj(ER7054PosLtlbDppkUmpj.getRefNumber(7560), ER7054PosLtlbDppkUmpj.getName(), ER7054PosLtlbDppkUmpj.getObjects()),
//    R7561Umps(ER7055PosLtlbDppkUmps.getRefNumber(7561), ER7055PosLtlbDppkUmps.getName(), ER7055PosLtlbDppkUmps.getObjects()),
//    R7562Utin(ER7056PosLtlbDppkUtin.getRefNumber(7562), ER7056PosLtlbDppkUtin.getName(), ER7056PosLtlbDppkUtin.getObjects()),
//    R7563Pddm(ER7057PosLtlbDppkPddm.getRefNumber(7563), ER7057PosLtlbDppkPddm.getName(), ER7057PosLtlbDppkPddm.getObjects()),
//    R7564Bmhb(ER7058PosLtlbDppkBmhb.getRefNumber(7564), ER7058PosLtlbDppkBmhb.getName(), ER7058PosLtlbDppkBmhb.getObjects()),
//    R7565Utln(ER7059PosLtlbDppkUtln.getRefNumber(7565), ER7059PosLtlbDppkUtln.getName(), ER7059PosLtlbDppkUtln.getObjects()),
//    R7566Ppin(ER7060PosLtlbDppkPpin.getRefNumber(7566), ER7060PosLtlbDppkPpin.getName(), ER7060PosLtlbDppkPpin.getObjects()),
//    R7567Iur(ER7061PosLtlbDppkIur.getRefNumber(7567), ER7061PosLtlbDppkIur.getName(), ER7061PosLtlbDppkIur.getObjects()),
//    R7568Pdin(ER7062PosLtlbDppkPdin.getRefNumber(7568), ER7062PosLtlbDppkPdin.getName(), ER7062PosLtlbDppkPdin.getObjects()),
//    R7569Pdpl(ER7063PosLtlbDppkPdpl.getRefNumber(7569), ER7063PosLtlbDppkPdpl.getName(), ER7063PosLtlbDppkPdpl.getObjects()),
//    R7570Binv(ER7064PosLtlbDppkBinv.getRefNumber(7570), ER7064PosLtlbDppkBinv.getName(), ER7064PosLtlbDppkBinv.getObjects()),
//    R7571Bopr(ER7065PosLtlbDppkBopr.getRefNumber(7571), ER7065PosLtlbDppkBopr.getName(), ER7065PosLtlbDppkBopr.getObjects()),
//    R7572Bipr(ER7066PosLtlbDppkBipr.getRefNumber(7572), ER7066PosLtlbDppkBipr.getName(), ER7066PosLtlbDppkBipr.getObjects()),
//    R7573Pph(ER7067PosLtlbDppkPph.getRefNumber(7573), ER7067PosLtlbDppkPph.getName(), ER7067PosLtlbDppkPph.getObjects()),
//    R7574Pkpl(ER7068PosLtlbDppkPkpl.getRefNumber(7574), ER7068PosLtlbDppkPkpl.getName(), ER7068PosLtlbDppkPkpl.getObjects())
//
;

    private final int number;
    private final String name;
    private final List<KeyValueString> references;

    public String getFileName() {
        StringBuilder res = new StringBuilder("R");
        res.append(number);
        res.append(name);
        res.append(".xml");
        return res.toString();
    }

    public String getDescription() {
//        return name;
        return "R" + number + name;
    }

    @Override
    public ReferenceMetadata getObject() {
        ReferenceMetadata res = new ReferenceMetadata(number, name, ReferenceType.keyValue, getDescription(), "");
        res.setPerSegment(false);
        res.setLabel1Map(null);
        return res;
    }

    public static List<ReferenceMetadata> getObjects() {
        List<ReferenceMetadata> res = new ArrayList<>();
        for (EHeaderMetadataLkdpPpmpppipk eEnum : EHeaderMetadataLkdpPpmpppipk.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static Map<String, List<KeyValueString>> getMap() {
        Map<String, List<KeyValueString>> res = new HashMap<>();
        for (EHeaderMetadataLkdpPpmpppipk eEnum : EHeaderMetadataLkdpPpmpppipk.values()) {
            res.put(eEnum.getFileName(), eEnum.references);
        }
        return res;
    }
}
