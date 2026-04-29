package id.go.ojk.module.lblt.dppk.header;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import id.go.ojk.module.lblt.dppk.reference.*;
import id.go.ojk.util.constants.ProgramType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataPpmpm implements IObject<ReferenceMetadata> {
    R7000Dtum(ER7000PosLtlbDppkDtum.getRefNumber(7100), ER7000PosLtlbDppkDtum.getName(), ER7000PosLtlbDppkDtum.getObjects()),
    R7001Lan(ER7001PosLtlbDppkLan.getRefNumber(7101), ER7001PosLtlbDppkLan.getName(), ER7001PosLtlbDppkLan.getObjects(ProgramType.PPMPM)),
    R7002Lpan(ER7002PosLtlbDppkLpan.getRefNumber(7102), ER7002PosLtlbDppkLpan.getName(), ER7002PosLtlbDppkLpan.getObjects(ProgramType.PPMPM)),
    R7003Nrc(ER7003PosLtlbDppkNrc.getRefNumber(7103), ER7003PosLtlbDppkNrc.getName(), ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPM)),
    R7004Lphu(ER7004PosLtlbDppkLphu.getRefNumber(7104), ER7004PosLtlbDppkLphu.getName(), ER7004PosLtlbDppkLphu.getObjects()),
    R7005Lak(ER7005PosLtlbDppkLak.getRefNumber(7105), ER7005PosLtlbDppkLak.getName(), ER7005PosLtlbDppkLak.getObjects()),
    R7006Pst(ER7006PosLtlbDppkPst.getRefNumber(7106), ER7006PosLtlbDppkPst.getName(), ER7006PosLtlbDppkPst.getObjects()),
    R7007Kup(ER7007PosLtlbDppkKup.getRefNumber(7107), ER7007PosLtlbDppkKup.getName(), ER7007PosLtlbDppkKup.getObjects(ProgramType.PPMPM)),
    R7008Rekinv(ER7008PosLtlbDppkRekinv.getRefNumber(7108), ER7008PosLtlbDppkRekinv.getName(), ER7008PosLtlbDppkRekinv.getObjects(ProgramType.PPMPM)),
    R7009Roi(ER7009PosLtlbDppkRoi.getRefNumber(7109), ER7009PosLtlbDppkRoi.getName(), ER7009PosLtlbDppkRoi.getObjects()),
    R7010Roiml(ER7010PosLtlbDppkRoiml.getRefNumber(7110), ER7010PosLtlbDppkRoiml.getName(), ER7010PosLtlbDppkRoiml.getObjects()),
    R7011Roism(ER7011PosLtlbDppkRoism.getRefNumber(7111), ER7011PosLtlbDppkRoism.getName(), ER7011PosLtlbDppkRoism.getObjects()),
    R7012Alm(ER7012PosLtlbDppkAlm.getRefNumber(7112), ER7012PosLtlbDppkAlm.getName(), ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPM)),
    R7013Insp(ER7013PosLtlbDppkInsp.getRefNumber(7113), ER7013PosLtlbDppkInsp.getName(), ER7013PosLtlbDppkInsp.getObjects()),
    R7014Inpt(ER7014PosLtlbDppkInpt.getRefNumber(7114), ER7014PosLtlbDppkInpt.getName(), ER7014PosLtlbDppkInpt.getObjects()),
    R7015Inbm(ER7015PosLtlbDppkInbm.getRefNumber(7115), ER7015PosLtlbDppkInbm.getName(), ER7015PosLtlbDppkInbm.getObjects()),
    R7016Sbn(ER7016PosLtlbDppkSbn.getRefNumber(7116), ER7016PosLtlbDppkSbn.getName(), ER7016PosLtlbDppkSbn.getObjects()),
    R7017Ras1(ER7017PosLtlbDppkRas1.getRefNumber(7117), ER7017PosLtlbDppkRas1.getName(), ER7017PosLtlbDppkRas1.getObjects(ProgramType.PPMPM)),
    R7018Ras2(ER7018PosLtlbDppkRas2.getRefNumber(7118), ER7018PosLtlbDppkRas2.getName(), ER7018PosLtlbDppkRas2.getObjects()),
    R7019Pius(ER7019PosLtlbDppkPius.getRefNumber(7119), ER7019PosLtlbDppkPius.getName(), ER7019PosLtlbDppkPius.getObjects()),
    R7020Pmi(ER7020PosLtlbDppkPmi.getRefNumber(7120), ER7020PosLtlbDppkPmi.getName(), ER7020PosLtlbDppkPmi.getObjects()),
    R7021Tbdsp(ER7021PosLtlbDppkTbdsp.getRefNumber(7121), ER7021PosLtlbDppkTbdsp.getName(), ER7021PosLtlbDppkTbdsp.getObjects()),
    R7022Doc(ER7022PosLtlbDppkDoc.getRefNumber(7122), ER7022PosLtlbDppkDoc.getName(), ER7022PosLtlbDppkDoc.getObjects()),
    R7023Dpjka(ER7023PosLtlbDppkDpjka.getRefNumber(7123), ER7023PosLtlbDppkDpjka.getName(), ER7023PosLtlbDppkDpjka.getObjects()),
    R7024Dpjkv(ER7024PosLtlbDppkDpjkv.getRefNumber(7124), ER7024PosLtlbDppkDpjkv.getName(), ER7024PosLtlbDppkDpjkv.getObjects()),
    R7025Srdp(ER7025PosLtlbDppkSrdp.getRefNumber(7125), ER7025PosLtlbDppkSrdp.getName(), ER7025PosLtlbDppkSrdp.getObjects()),
    R7026Sbi(ER7026PosLtlbDppkSbi.getRefNumber(7126), ER7026PosLtlbDppkSbi.getName(), ER7026PosLtlbDppkSbi.getObjects()),
    R7027Rsbn(ER7027PosLtlbDppkRsbn.getRefNumber(7127), ER7027PosLtlbDppkRsbn.getName(), ER7027PosLtlbDppkRsbn.getObjects()),
    R7028Shm(ER7028PosLtlbDppkShm.getRefNumber(7128), ER7028PosLtlbDppkShm.getName(), ER7028PosLtlbDppkShm.getObjects()),
    R7029Obli(ER7029PosLtlbDppkObli.getRefNumber(7129), ER7029PosLtlbDppkObli.getName(), ER7029PosLtlbDppkObli.getObjects()),
    R7030Sukuk(ER7030PosLtlbDppkSukuk.getRefNumber(7130), ER7030PosLtlbDppkSukuk.getName(), ER7030PosLtlbDppkSukuk.getObjects()),
    R7031Obsud(ER7031PosLtlbDppkObsud.getRefNumber(7131), ER7031PosLtlbDppkObsud.getName(), ER7031PosLtlbDppkObsud.getObjects()),
    R7032Rksd(ER7032PosLtlbDppkRksd.getRefNumber(7132), ER7032PosLtlbDppkRksd.getName(), ER7032PosLtlbDppkRksd.getObjects()),
    R7033Mtn(ER7033PosLtlbDppkMtn.getRefNumber(7133), ER7033PosLtlbDppkMtn.getName(), ER7033PosLtlbDppkMtn.getObjects()),
    R7034Eba(ER7034PosLtlbDppkEba.getRefNumber(7134), ER7034PosLtlbDppkEba.getName(), ER7034PosLtlbDppkEba.getObjects()),
    R7035Dire(ER7035PosLtlbDppkDire.getRefNumber(7135), ER7035PosLtlbDppkDire.getName(), ER7035PosLtlbDppkDire.getObjects()),
    R7036Dnfra(ER7036PosLtlbDppkDnfra.getRefNumber(7136), ER7036PosLtlbDppkDnfra.getName(), ER7036PosLtlbDppkDnfra.getObjects()),
    R7037Kokb(ER7037PosLtlbDppkKokb.getRefNumber(7137), ER7037PosLtlbDppkKokb.getName(), ER7037PosLtlbDppkKokb.getObjects()),
    R7038Repo(ER7038PosLtlbDppkRepo.getRefNumber(7138), ER7038PosLtlbDppkRepo.getName(), ER7038PosLtlbDppkRepo.getObjects()),
    R7039Pnyl(ER7039PosLtlbDppkPnyl.getRefNumber(7139), ER7039PosLtlbDppkPnyl.getName(), ER7039PosLtlbDppkPnyl.getObjects()),
    R7040Prop(ER7040PosLtlbDppkProp.getRefNumber(7140), ER7040PosLtlbDppkProp.getName(), ER7040PosLtlbDppkProp.getObjects()),
    R7041Kasb(ER7041PosLtlbDppkKasb.getRefNumber(7141), ER7041PosLtlbDppkKasb.getName(), ER7041PosLtlbDppkKasb.getObjects()),
    R7042Piut(ER7042PosLtlbDppkPiut.getRefNumber(7142), ER7042PosLtlbDppkPiut.getName(), ER7042PosLtlbDppkPiut.getObjects()),
    R7043Piub(ER7043PosLtlbDppkPiub.getRefNumber(7143), ER7043PosLtlbDppkPiub.getName(), ER7043PosLtlbDppkPiub.getObjects()),
    R7044Bbmk(ER7044PosLtlbDppkBbmk.getRefNumber(7144), ER7044PosLtlbDppkBbmk.getName(), ER7044PosLtlbDppkBbmk.getObjects()),
    R7045Piui(ER7045PosLtlbDppkPiui.getRefNumber(7145), ER7045PosLtlbDppkPiui.getName(), ER7045PosLtlbDppkPiui.getObjects()),
    R7046Pihi(ER7046PosLtlbDppkPihi.getRefNumber(7146), ER7046PosLtlbDppkPihi.getName(), ER7046PosLtlbDppkPihi.getObjects()),
    R7047Pill(ER7047PosLtlbDppkPill.getRefNumber(7147), ER7047PosLtlbDppkPill.getName(), ER7047PosLtlbDppkPill.getObjects()),
    R7048Tnbg(ER7048PosLtlbDppkTnbg.getRefNumber(7148), ER7048PosLtlbDppkTnbg.getName(), ER7048PosLtlbDppkTnbg.getObjects()),
    R7049Kndr(ER7049PosLtlbDppkKndr.getRefNumber(7149), ER7049PosLtlbDppkKndr.getName(), ER7049PosLtlbDppkKndr.getObjects()),
    R7050Pkom(ER7050PosLtlbDppkPkom.getRefNumber(7150), ER7050PosLtlbDppkPkom.getName(), ER7050PosLtlbDppkPkom.getObjects()),
    R7051Pkan(ER7051PosLtlbDppkPkan.getRefNumber(7151), ER7051PosLtlbDppkPkan.getName(), ER7051PosLtlbDppkPkan.getObjects()),
    R7052Asol(ER7052PosLtlbDppkAsol.getRefNumber(7152), ER7052PosLtlbDppkAsol.getName(), ER7052PosLtlbDppkAsol.getObjects()),
    R7053Asln(ER7053PosLtlbDppkAsln.getRefNumber(7153), ER7053PosLtlbDppkAsln.getName(), ER7053PosLtlbDppkAsln.getObjects()),
    R7054Umpj(ER7054PosLtlbDppkUmpj.getRefNumber(7154), ER7054PosLtlbDppkUmpj.getName(), ER7054PosLtlbDppkUmpj.getObjects()),
    R7055Umps(ER7055PosLtlbDppkUmps.getRefNumber(7155), ER7055PosLtlbDppkUmps.getName(), ER7055PosLtlbDppkUmps.getObjects()),
    R7056Utin(ER7056PosLtlbDppkUtin.getRefNumber(7156), ER7056PosLtlbDppkUtin.getName(), ER7056PosLtlbDppkUtin.getObjects()),
    R7057Pddm(ER7057PosLtlbDppkPddm.getRefNumber(7157), ER7057PosLtlbDppkPddm.getName(), ER7057PosLtlbDppkPddm.getObjects()),
    R7058Bmhb(ER7058PosLtlbDppkBmhb.getRefNumber(7158), ER7058PosLtlbDppkBmhb.getName(), ER7058PosLtlbDppkBmhb.getObjects()),
    R7059Utln(ER7059PosLtlbDppkUtln.getRefNumber(7159), ER7059PosLtlbDppkUtln.getName(), ER7059PosLtlbDppkUtln.getObjects()),
    R7060Ppin(ER7060PosLtlbDppkPpin.getRefNumber(7160), ER7060PosLtlbDppkPpin.getName(), ER7060PosLtlbDppkPpin.getObjects()),
    R7061Iur(ER7061PosLtlbDppkIur.getRefNumber(7161), ER7061PosLtlbDppkIur.getName(), ER7061PosLtlbDppkIur.getObjects()),
    R7062Pdin(ER7062PosLtlbDppkPdin.getRefNumber(7162), ER7062PosLtlbDppkPdin.getName(), ER7062PosLtlbDppkPdin.getObjects()),
    R7063Pdpl(ER7063PosLtlbDppkPdpl.getRefNumber(7163), ER7063PosLtlbDppkPdpl.getName(), ER7063PosLtlbDppkPdpl.getObjects()),
    R7064Binv(ER7064PosLtlbDppkBinv.getRefNumber(7164), ER7064PosLtlbDppkBinv.getName(), ER7064PosLtlbDppkBinv.getObjects()),
    R7065Bopr(ER7065PosLtlbDppkBopr.getRefNumber(7165), ER7065PosLtlbDppkBopr.getName(), ER7065PosLtlbDppkBopr.getObjects()),
    R7066Bipr(ER7066PosLtlbDppkBipr.getRefNumber(7166), ER7066PosLtlbDppkBipr.getName(), ER7066PosLtlbDppkBipr.getObjects()),
    R7067Pph(ER7067PosLtlbDppkPph.getRefNumber(7167), ER7067PosLtlbDppkPph.getName(), ER7067PosLtlbDppkPph.getObjects()),
    R7068Pkpl(ER7068PosLtlbDppkPkpl.getRefNumber(7168), ER7068PosLtlbDppkPkpl.getName(), ER7068PosLtlbDppkPkpl.getObjects());


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
        for (EHeaderMetadataPpmpm eEnum : EHeaderMetadataPpmpm.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static Map<String, List<KeyValueString>> getMap() {
        Map<String, List<KeyValueString>> res = new HashMap<>();
        for (EHeaderMetadataPpmpm eEnum : EHeaderMetadataPpmpm.values()) {
            res.put(eEnum.getFileName(), eEnum.references);
        }
        return res;
    }
}
