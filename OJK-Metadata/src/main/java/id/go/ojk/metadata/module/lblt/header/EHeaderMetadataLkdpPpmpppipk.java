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
    R7000Dtum(ER7000PosLtlbDppkDtum.getRefNumber(7500), ER7000PosLtlbDppkDtum.getName(), ER7000PosLtlbDppkDtum.getObjects()),
    R7001Lan(ER7001PosLtlbDppkLan.getRefNumber(7501), ER7001PosLtlbDppkLan.getName(), ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPPPIPK)),
    R7002Lpan(ER7002PosLtlbDppkLpan.getRefNumber(7502), ER7002PosLtlbDppkLpan.getName(), ER7002PosLtlbDppkLpan.getObjects(ProgramType.PPMPPPIPK)),
    R7003Nrc(ER7003PosLtlbDppkNrc.getRefNumber(7503), ER7003PosLtlbDppkNrc.getName(), ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPPPIPK)),
    R7004Lphu(ER7004PosLtlbDppkLphu.getRefNumber(7504), ER7004PosLtlbDppkLphu.getName(), ER7004PosLtlbDppkLphu.getObjects(ProgramType.PPMPPPIPK)),
    R7005Lak(ER7005PosLtlbDppkLak.getRefNumber(7505), ER7005PosLtlbDppkLak.getName(), ER7005PosLtlbDppkLak.getObjects(ProgramType.PPMPPPIPK)),
    R7006Pst(ER7006PosLtlbDppkPst.getRefNumber(7506), ER7006PosLtlbDppkPst.getName(), ER7006PosLtlbDppkPst.getObjects(ProgramType.PPMPPPIPK)),
    R7007Kup(ER7007PosLtlbDppkKup.getRefNumber(7507), ER7007PosLtlbDppkKup.getName(), ER7007PosLtlbDppkKup.getObjects(ProgramType.PPMPPPIPK)),
    R7008Rekinv(ER7008PosLtlbDppkRekinv.getRefNumber(7508), ER7008PosLtlbDppkRekinv.getName(), ER7008PosLtlbDppkRekinv.getObjects(ProgramType.PPMPPPIPK)),
    R7009Lcf(ER7201PosLtlbDppkLcf.getRefNumber(7509), ER7201PosLtlbDppkLcf.getName(), ER7201PosLtlbDppkLcf.getObjectsGabungan()),
    R7010Roi(ER7009PosLtlbDppkRoi.getRefNumber(7510), ER7009PosLtlbDppkRoi.getName(), ER7009PosLtlbDppkRoi.getObjects(ProgramType.PPMPPPIPK)),
    R7011Roiml(ER7010PosLtlbDppkRoiml.getRefNumber(7511), ER7010PosLtlbDppkRoiml.getName(), ER7010PosLtlbDppkRoiml.getObjects(ProgramType.PPMPPPIPK)),
    R7012Roism(ER7011PosLtlbDppkRoism.getRefNumber(7512), ER7011PosLtlbDppkRoism.getName(), ER7011PosLtlbDppkRoism.getObjects(ProgramType.PPMPPPIPK)),
    R7013Roimpl(ER7101PosLtlbDppkRoimpl.getRefNumber(7513), ER7101PosLtlbDppkRoimpl.getName(), ER7101PosLtlbDppkRoimpl.getObjects()),
    R7014Alm(ER7012PosLtlbDppkAlm.getRefNumber(7514), ER7012PosLtlbDppkAlm.getName(), ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPPPIPK)),
    R7015Insp(ER7013PosLtlbDppkInsp.getRefNumber(7515), ER7013PosLtlbDppkInsp.getName(), ER7013PosLtlbDppkInsp.getObjectsGabungan()),
    R7016Inpt(ER7014PosLtlbDppkInpt.getRefNumber(7516), ER7014PosLtlbDppkInpt.getName(), ER7014PosLtlbDppkInpt.getObjectsGabungan()),
    R7017Inbm(ER7015PosLtlbDppkInbm.getRefNumber(7517), ER7015PosLtlbDppkInbm.getName(), ER7015PosLtlbDppkInbm.getObjectsGabungan()),
    R7018Sbn(ER7016PosLtlbDppkSbn.getRefNumber(7518), ER7016PosLtlbDppkSbn.getName(), ER7016PosLtlbDppkSbn.getObjectsGabungan()),
    R7019Ras1(ER7017PosLtlbDppkRas1.getRefNumber(7519), ER7017PosLtlbDppkRas1.getName(), ER7017PosLtlbDppkRas1.getObjects(ProgramType.PPMPPPIPK)),
    R7020Ras2(ER7018PosLtlbDppkRas2.getRefNumber(7520), ER7018PosLtlbDppkRas2.getName(), ER7018PosLtlbDppkRas2.getObjects(ProgramType.PPMPPPIPK)),
    R7021Pinv(ER7102PosLtlbDppkPinv.getRefNumber(7521), ER7102PosLtlbDppkPinv.getName(), ER7102PosLtlbDppkPinv.getObjects(ProgramType.PPMPPPIPK)),
    R7022Pinvs(ER7103PosLtlbDppkPinvs.getRefNumber(7522), ER7103PosLtlbDppkPinvs.getName(), ER7103PosLtlbDppkPinvs.getObjects(ProgramType.PPMPPPIPK)),
    R7023Mpbk(ER7104PosLtlbDppkMpbk.getRefNumber(7523), ER7104PosLtlbDppkMpbk.getName(), ER7104PosLtlbDppkMpbk.getObjectsGabungan()),
    R7024Pmbk(ER7105PosLtlbDppkPmbk.getRefNumber(7524), ER7105PosLtlbDppkPmbk.getName(), ER7105PosLtlbDppkPmbk.getObjectsGabungan()),
    R7025Pius(ER7019PosLtlbDppkPius.getRefNumber(7525), ER7019PosLtlbDppkPius.getName(), ER7019PosLtlbDppkPius.getObjectsGabungan()),
    R7026Pmi(ER7020PosLtlbDppkPmi.getRefNumber(7526), ER7020PosLtlbDppkPmi.getName(), ER7020PosLtlbDppkPmi.getObjectsGabungan()),
    R7027Tbdsp(ER7021PosLtlbDppkTbdsp.getRefNumber(7527), ER7021PosLtlbDppkTbdsp.getName(), ER7021PosLtlbDppkTbdsp.getObjects(ProgramType.PPMPPPIPK)),
    R7028Doc(ER7022PosLtlbDppkDoc.getRefNumber(7528), ER7022PosLtlbDppkDoc.getName(), ER7022PosLtlbDppkDoc.getObjectsGabungan()),
    R7029Dpjka(ER7023PosLtlbDppkDpjka.getRefNumber(7529), ER7023PosLtlbDppkDpjka.getName(), ER7023PosLtlbDppkDpjka.getObjectsGabungan()),
    R7030Dpjkv(ER7024PosLtlbDppkDpjkv.getRefNumber(7530), ER7024PosLtlbDppkDpjkv.getName(), ER7024PosLtlbDppkDpjkv.getObjectsGabungan()),
    R7031Srdp(ER7025PosLtlbDppkSrdp.getRefNumber(7531), ER7025PosLtlbDppkSrdp.getName(), ER7025PosLtlbDppkSrdp.getObjectsGabungan()),
    R7032Sbi(ER7026PosLtlbDppkSbi.getRefNumber(7532), ER7026PosLtlbDppkSbi.getName(), ER7026PosLtlbDppkSbi.getObjectsGabungan()),
    R7033Rsbn(ER7027PosLtlbDppkRsbn.getRefNumber(7533), ER7027PosLtlbDppkRsbn.getName(), ER7027PosLtlbDppkRsbn.getObjectsGabungan()),
    R7034Shm(ER7028PosLtlbDppkShm.getRefNumber(7534), ER7028PosLtlbDppkShm.getName(), ER7028PosLtlbDppkShm.getObjectsGabungan()),
    R7035Obli(ER7029PosLtlbDppkObli.getRefNumber(7535), ER7029PosLtlbDppkObli.getName(), ER7029PosLtlbDppkObli.getObjectsGabungan()),
    R7036Sukuk(ER7030PosLtlbDppkSukuk.getRefNumber(7536), ER7030PosLtlbDppkSukuk.getName(), ER7030PosLtlbDppkSukuk.getObjectsGabungan()),
    R7037Obsud(ER7031PosLtlbDppkObsud.getRefNumber(7537), ER7031PosLtlbDppkObsud.getName(), ER7031PosLtlbDppkObsud.getObjectsGabungan()),
    R7038Rksd(ER7032PosLtlbDppkRksd.getRefNumber(7538), ER7032PosLtlbDppkRksd.getName(), ER7032PosLtlbDppkRksd.getObjectsGabungan()),
    R7039Mtn(ER7033PosLtlbDppkMtn.getRefNumber(7539), ER7033PosLtlbDppkMtn.getName(), ER7033PosLtlbDppkMtn.getObjectsGabungan()),
    R7040Eba(ER7034PosLtlbDppkEba.getRefNumber(7540), ER7034PosLtlbDppkEba.getName(), ER7034PosLtlbDppkEba.getObjectsGabungan()),
    R7041Dire(ER7035PosLtlbDppkDire.getRefNumber(7541), ER7035PosLtlbDppkDire.getName(), ER7035PosLtlbDppkDire.getObjectsGabungan()),
    R7042Dnfra(ER7036PosLtlbDppkDnfra.getRefNumber(7542), ER7036PosLtlbDppkDnfra.getName(), ER7036PosLtlbDppkDnfra.getObjectsGabungan()),
    R7043Kokb(ER7037PosLtlbDppkKokb.getRefNumber(7543), ER7037PosLtlbDppkKokb.getName(), ER7037PosLtlbDppkKokb.getObjectsGabungan()),
    R7044Repo(ER7038PosLtlbDppkRepo.getRefNumber(7544), ER7038PosLtlbDppkRepo.getName(), ER7038PosLtlbDppkRepo.getObjectsGabungan()),
    R7045Pnyl(ER7039PosLtlbDppkPnyl.getRefNumber(7545), ER7039PosLtlbDppkPnyl.getName(), ER7039PosLtlbDppkPnyl.getObjectsGabungan()),
    R7046Prop(ER7040PosLtlbDppkProp.getRefNumber(7546), ER7040PosLtlbDppkProp.getName(), ER7040PosLtlbDppkProp.getObjectsGabungan()),
    R7047Kasb(ER7041PosLtlbDppkKasb.getRefNumber(7547), ER7041PosLtlbDppkKasb.getName(), ER7041PosLtlbDppkKasb.getObjectsGabungan()),
    R7048Piut(ER7042PosLtlbDppkPiut.getRefNumber(7548), ER7042PosLtlbDppkPiut.getName(), ER7042PosLtlbDppkPiut.getObjectsGabungan()),
    R7049Piub(ER7043PosLtlbDppkPiub.getRefNumber(7549), ER7043PosLtlbDppkPiub.getName(), ER7043PosLtlbDppkPiub.getObjectsGabungan()),
    R7050Bbmk(ER7044PosLtlbDppkBbmk.getRefNumber(7550), ER7044PosLtlbDppkBbmk.getName(), ER7044PosLtlbDppkBbmk.getObjectsGabungan()),
    R7051Piui(ER7045PosLtlbDppkPiui.getRefNumber(7551), ER7045PosLtlbDppkPiui.getName(), ER7045PosLtlbDppkPiui.getObjectsGabungan()),
    R7052Pihi(ER7046PosLtlbDppkPihi.getRefNumber(7552), ER7046PosLtlbDppkPihi.getName(), ER7046PosLtlbDppkPihi.getObjectsGabungan()),
    R7053Pill(ER7047PosLtlbDppkPill.getRefNumber(7553), ER7047PosLtlbDppkPill.getName(), ER7047PosLtlbDppkPill.getObjectsGabungan()),
    R7054Tnbg(ER7048PosLtlbDppkTnbg.getRefNumber(7554), ER7048PosLtlbDppkTnbg.getName(), ER7048PosLtlbDppkTnbg.getObjectsGabungan()),
    R7055Kndr(ER7049PosLtlbDppkKndr.getRefNumber(7555), ER7049PosLtlbDppkKndr.getName(), ER7049PosLtlbDppkKndr.getObjectsGabungan()),
    R7056Pkom(ER7050PosLtlbDppkPkom.getRefNumber(7556), ER7050PosLtlbDppkPkom.getName(), ER7050PosLtlbDppkPkom.getObjectsGabungan()),
    R7057Pkan(ER7051PosLtlbDppkPkan.getRefNumber(7557), ER7051PosLtlbDppkPkan.getName(), ER7051PosLtlbDppkPkan.getObjectsGabungan()),
    R7058Asol(ER7052PosLtlbDppkAsol.getRefNumber(7558), ER7052PosLtlbDppkAsol.getName(), ER7052PosLtlbDppkAsol.getObjectsGabungan()),
    R7059Asln(ER7053PosLtlbDppkAsln.getRefNumber(7559), ER7053PosLtlbDppkAsln.getName(), ER7053PosLtlbDppkAsln.getObjectsGabungan()),
    R7060Umpj(ER7054PosLtlbDppkUmpj.getRefNumber(7560), ER7054PosLtlbDppkUmpj.getName(), ER7054PosLtlbDppkUmpj.getObjectsGabungan()),
    R7061Umps(ER7055PosLtlbDppkUmps.getRefNumber(7561), ER7055PosLtlbDppkUmps.getName(), ER7055PosLtlbDppkUmps.getObjectsGabungan()),
    R7062Utin(ER7056PosLtlbDppkUtin.getRefNumber(7562), ER7056PosLtlbDppkUtin.getName(), ER7056PosLtlbDppkUtin.getObjectsGabungan()),
    R7063Pddm(ER7057PosLtlbDppkPddm.getRefNumber(7563), ER7057PosLtlbDppkPddm.getName(), ER7057PosLtlbDppkPddm.getObjectsGabungan()),
    R7064Bmhb(ER7058PosLtlbDppkBmhb.getRefNumber(7564), ER7058PosLtlbDppkBmhb.getName(), ER7058PosLtlbDppkBmhb.getObjectsGabungan()),
    R7065Utln(ER7059PosLtlbDppkUtln.getRefNumber(7565), ER7059PosLtlbDppkUtln.getName(), ER7059PosLtlbDppkUtln.getObjectsGabungan()),
    R7066Ppin(ER7060PosLtlbDppkPpin.getRefNumber(7566), ER7060PosLtlbDppkPpin.getName(), ER7060PosLtlbDppkPpin.getObjectsGabungan()),
    R7067Iur(ER7061PosLtlbDppkIur.getRefNumber(7567), ER7061PosLtlbDppkIur.getName(), ER7061PosLtlbDppkIur.getObjectsGabungan()),
    R7068Pdin(ER7062PosLtlbDppkPdin.getRefNumber(7568), ER7062PosLtlbDppkPdin.getName(), ER7062PosLtlbDppkPdin.getObjectsGabungan()),
    R7069Pdpl(ER7063PosLtlbDppkPdpl.getRefNumber(7569), ER7063PosLtlbDppkPdpl.getName(), ER7063PosLtlbDppkPdpl.getObjectsGabungan()),
    R7070Binv(ER7064PosLtlbDppkBinv.getRefNumber(7570), ER7064PosLtlbDppkBinv.getName(), ER7064PosLtlbDppkBinv.getObjectsGabungan()),
    R7071Bopr(ER7065PosLtlbDppkBopr.getRefNumber(7571), ER7065PosLtlbDppkBopr.getName(), ER7065PosLtlbDppkBopr.getObjectsGabungan()),
    R7072Bipr(ER7066PosLtlbDppkBipr.getRefNumber(7572), ER7066PosLtlbDppkBipr.getName(), ER7066PosLtlbDppkBipr.getObjectsGabungan()),
    R7073Pph(ER7067PosLtlbDppkPph.getRefNumber(7573), ER7067PosLtlbDppkPph.getName(), ER7067PosLtlbDppkPph.getObjectsGabungan()),
    R7074Pkpl(ER7068PosLtlbDppkPkpl.getRefNumber(7574), ER7068PosLtlbDppkPkpl.getName(), ER7068PosLtlbDppkPkpl.getObjectsGabungan())
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
