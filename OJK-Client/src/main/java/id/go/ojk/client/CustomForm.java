package id.go.ojk.client;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.vc.HomeMetroBpjsController;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import lombok.Getter;

public class CustomForm extends BaseCustomForm {
    @Getter
    private FormRbb formRbb;
    @Getter
    private FormLb formLb;
    @Getter
    private FormLbk formLbk;
    @Getter
    private FormSa formSa;
    @Getter
    private FormApu formApu;
    @Getter
    private FormTl formTl;
    @Getter
    private FormPls formPls;
    @Getter
    private FormTpp formTpp;
    @Getter
    private FormBpjsKs formBpjsKs;
    @Getter
    private FormBpjsTk formBpjsTk;
    @Getter
    private FormLktb formLktb;

    public CustomForm(ApplicationContext appContext, MainApplication mainApplication) {
        super(appContext, mainApplication);
        init();
    }

    @Override
    protected void init() {
        formRbb = new FormRbb(appContext, mainApplication);
        formLb = new FormLb(appContext, mainApplication);
        formLbk = new FormLbk(appContext, mainApplication);
        formSa = new FormSa(appContext, mainApplication);
        formApu = new FormApu(appContext, mainApplication);
        formTl = new FormTl(appContext, mainApplication);
        formPls = new FormPls(appContext, mainApplication);
        formTpp = new FormTpp(appContext, mainApplication);
        formBpjsKs = new FormBpjsKs(appContext, mainApplication);
        formBpjsTk = new FormBpjsTk(appContext, mainApplication);
        formLktb = new FormLktb(appContext, mainApplication);
    }

    public void logout() {
        if (formLb != null) {
            formLb.getHome(null).getB().logout();
            formLb.cleanUp();
        }
        if (formLbk != null) {
            formLbk.getHome(null).getB().logout();
            formLbk.cleanUp();
        }
        if (formSa != null) {
            formSa.getHome().getB().logout();
            formSa.cleanUp();
        }
        if (formApu != null) {
            formApu.getHome(null).getB().logout();
            formApu.cleanUp();
        }
        if (formRbb != null) {
            formRbb.getHome().getB().logout();
            formRbb.cleanUp();
        }
        if (formTl != null) {
            formTl.getHome(null).getB().logout();
            formTl.cleanUp();
        }
        if (formPls != null) {
            formPls.getHome(null).getB().logout();
            formPls.cleanUp();
        }
        if (formTpp != null) {
            formTpp.getHome(null).getB().logout();
            formTpp.cleanUp();
        }
        if (formBpjsKs != null) {
            formBpjsKs.cleanUp();
        }
        if (formBpjsTk != null) {
            formBpjsTk.cleanUp();
        }
        if (formLktb != null) {
            formLktb.cleanUp();
        }

    }

    public void progressSegment(ProgressSegment progressSegment, String reportCode, int reportFormGroupCode) {
        if (EReport.isLb(reportCode)) {
            formLb.progressSegment(progressSegment, reportFormGroupCode);
        } else if (EReport.isLbk(reportCode)) {
            formLbk.progressSegment(progressSegment, reportFormGroupCode);
        } else if (EReport.isSa(reportCode)) {
            formSa.progressSegment(progressSegment, reportFormGroupCode);
        } else if (EReport.isApu(reportCode)) {
            formApu.progressSegment(progressSegment, reportFormGroupCode);
        } else if (EReport.isTl(reportCode)) {
            formTl.progressSegment(progressSegment, reportFormGroupCode);
        } else if (EReport.isPls(reportCode)) {
            formPls.progressSegment(progressSegment, reportFormGroupCode);
        } else if (EReport.isTpp(reportCode)) {
            formTpp.progressSegment(progressSegment, reportFormGroupCode);
        } else if (EReport.isBpjsKs(reportCode)) {
            formBpjsKs.progressSegment(progressSegment, reportFormGroupCode);
        } else if (EReport.isBpjsTk(reportCode)) {
            formBpjsTk.ensureVisibleScrollPane(progressSegment, reportFormGroupCode);
        } else if (EReport.isLktb(reportCode)) {
            formLktb.progressSegment(progressSegment, reportFormGroupCode);
        } else {
            formRbb.progressSegment(progressSegment, reportFormGroupCode);
        }
    }

    public void loginSucceed(UserSession userSession) {
        String reportCode = userSession.getReportCode();
        if (EReport.isLb(reportCode)) {
            formLb.getHome(userSession).getB().loginSuccess(userSession);
        } else if (EReport.isLbk(reportCode)) {
            formLbk.getHome(userSession).getB().loginSuccess(userSession);
        } else if (EReport.isSa(reportCode)) {
            formSa.getHome().getB().loginSuccess(userSession);
        } else if (EReport.isApu(reportCode)) {
            if (reportCode.equals(EReport.APU_FINK.getCode()) || reportCode.equals(EReport.APU_FINS.getCode())) {
                formApu.getHome3(userSession).getB().loginSuccess(userSession);
            } else {
                formApu.getHome(userSession).getB().loginSuccess(userSession);
            }
        } else if (EReport.isTl(reportCode)) {
            formTl.getHome(userSession).getB().loginSuccess(userSession);
        } else if (EReport.isPls(reportCode)) {
            formPls.getHome(userSession).getB().loginSuccess(userSession);
        } else if (EReport.isTpp(reportCode)) {
            formTpp.getHome(userSession).getB().loginSuccess(userSession);
        } else if (EReport.isLktb(reportCode)) {
            formLktb.getHome(userSession).getB().loginSuccess(userSession);
        } else if (EReport.isBpjsKs(reportCode)) {
            if (formBpjsKs.isHomeLBBPKS(reportCode)) {
                formBpjsKs.getHomeLBBPKS().getB().loginSuccess(userSession);
            }
        } else if (EReport.isBpjsTk(reportCode)) {
            ((HomeMetroBpjsController) formBpjsTk.getHome(reportCode).getB()).loginSuccess(userSession);
        } else {
            formRbb.getHome().getB().loginSuccess(userSession);
        }
    }

    public void showHome(UserSession userSession) {
        String reportCode = userSession.getReportCode();
        if (EReport.isLb(reportCode)) {
            formLb.showHome(userSession);
        } else if (EReport.isLbk(reportCode)) {
            formLbk.showHome(userSession);
        } else if (EReport.isSa(reportCode)) {
            formSa.showHome();
        } else if (EReport.isApu(reportCode)) {
            formApu.showHome(userSession);
        } else if (EReport.isTl(reportCode)) {
            formTl.showHome(userSession);
        } else if (EReport.isPls(reportCode)) {
            formPls.showHome(userSession);
        } else if (EReport.isTpp(reportCode)) {
            formTpp.showHome(userSession);
        } else if (EReport.isBpjsKs(reportCode)) {
            formBpjsKs.showHome(userSession);
        } else if (EReport.isBpjsTk(reportCode)) {
            formBpjsTk.initHome(userSession);
        } else if (EReport.isLktb(reportCode)) {
            formLktb.showHome(userSession);
        } else {
            formRbb.showHome();
        }
    }

    public void handleMainMenu() {
        DisplayScene displayScene = mainApplication.getDisplayScene();
        switch (displayScene) {
            case pelaporanPreparationRbb:
                formRbb.showPelaporanData();
                break;
            case perubahanPreparationRbb:
                formRbb.showPelaporanData();
                break;
            case penyesuaianPreparationRbb:
                formRbb.showPelaporanData();
                break;
            case realisasiPreparationRbb:
                formRbb.showRealisasiData();
                break;
            case pengawasanPreparationRbb:
                formRbb.showPengawasanData();
                break;
            case rutinPreparationLb:
                formLb.showPelaporan();
                break;
            case perubahanPreparationLb:
                formLb.showPerubahan();
                break;
            case penyesuaianPreparationLb:
                formLb.showPenyesuaian();
                break;
            case penyesuaianPreparationLb2:
                formLb.showPenyesuaian2();
                break;
            case penyesuaianKapPreparationLb:
                formLb.showPenyesuaianKap();
                break;
            case lbkBulananPreparation:
                formLbk.showPelaporanBulanan();
                break;
            case lbkTahunanPreparation:
                formLbk.showPelaporanTahunan();
                break;
            case pelaporanPreparationSa:
                formSa.showPelaporan();
                break;
            case pelaporanKoreksiPreparationSa:
                formSa.showPelaporanKoreksi();
                break;
            case pengkinianPreparationSa:
                formSa.showPengkinian();
                break;
            case pengkinianKoreksiPreparationSa:
                formSa.showPengkinianKoreksi();
                break;
            case penilaianPreparationApu:
                formApu.showPenilaian();
                break;
            case penilaianPreparationApu2:
                formApu.showPenilaian2();
                break;
            case rencanaPreparationApu:
                formApu.showRencana();
                break;
            case realisasiPreparationApu:
                formApu.showRealisasi();
                break;
            case pelaporanPreparationTl:
                formTl.showPelaporan();
                break;
            case koreksiPreparationTl:
                formTl.showPenyesuaian();
                break;
            case pelaporanPreparationPls:
                formPls.showPelaporan();
                break;
            case koreksiPreparationPls:
                formPls.showKoreksi();
                break;
            case rencanaPrepartionTpp:
                formTpp.showRencana();
                break;
            case realisasiPreprationTpp:
                formTpp.showRealisasi();
                break;
            case penilaianPreprationTpp:
                formTpp.showPenilaianResiko();
                break;
            case LBBPKSLK:
                formBpjsKs.showLBBPKSLK();
                break;
            case LBBPKSDJS:
                formBpjsKs.showLBBPKSDJS();
                break;
            case LBBPKSLPP:
                formBpjsKs.showLBBPKSLPP();
                break;
            case LKB_DP:
                formLktb.showBulanan();
                break;
            case LKT_DP:
                formLktb.showTahunan();
                break;
            default:
                formBpjsTk.showForm(displayScene);
                break;
        }
    }

}
