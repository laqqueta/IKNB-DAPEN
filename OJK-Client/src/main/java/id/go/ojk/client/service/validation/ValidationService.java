package id.go.ojk.client.service.validation;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.FactoryValidationContentHandlerImpl;
import id.go.ojk.client.service.base.BaseService;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.util.RuntimeUtil;
import id.go.ojk.lib.client.TaskExecutorUtil;
import id.go.ojk.lib.client.TimeCounter;
import id.go.ojk.lib.client.instance.ValueByRowCode;
import id.go.ojk.lib.client.model.constant.OjkClientConstant;
import id.go.ojk.lib.client.service.validation.ValidationRelationModel;
import id.go.ojk.lib.client.util.FormatUtil;
import javafx.application.Platform;

public class ValidationService extends BaseService {
	private MainApplication mainApplication;
	private SecurityService securityService;
	private ScriptEngineManager scriptEngineManager;
	private ScriptEngine scriptEngine;
	
	@Override
	public void initialize() {
		mainApplication = appContext.getService(MainApplication.class);
		securityService = appContext.getService(SecurityService.class);
		scriptEngineManager = new ScriptEngineManager();
		scriptEngine = scriptEngineManager.getEngineByName("javascript");
	}

	public ScriptEngineManager getScriptEngineManager() {
    return scriptEngineManager;
  }

	public ScriptEngine getScriptEngine() {
    return scriptEngine;
  }

	public void validate(ProgressPreparationAndSending progressModel, int reportFormGroupCode){
		//progressModel.setValidationRelationModel(new ValidationRelationModel());
		progressModel.getSubmissionData().setValidationRelationModel(new ValidationRelationModel());

		TimeCounter timeCounter = new TimeCounter();
		progressModel.writeProcessLog(
			String.format(
				"Validasi - Mulai - direktori pelaporan %1$s, direktori kesalahan ",
				progressModel.getSubmissionDirectory().getAbsolutePath(),
				progressModel.getValidationErrorDir().getAbsolutePath()
			), 
			false
		);

		if ( !OjkClientConstant.isSkipValidation() ){
			List<SubmissionFormat> formats = progressModel.getMetadata().getFormats();
			formats.stream()
				.flatMap(e -> e.getFields().stream())
				.flatMap(e -> e.getFieldValidations().stream())
				.forEach(e -> e.beforeValidationStart(progressModel.getSubmissionData()));
			
			//ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() -1);
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(RuntimeUtil.getNumberOfThread());
	    	String reportCode = securityService.getUserSession().getReportCode();
//	    	System.out.println(reportCode);
			
			ValueByRowCode.getInstance().clear();
			for (ProgressSegment progressSegment : progressModel.getSegments()) {
				if ( progressModel.isRequestStop() )
					break;
				
				Platform.runLater(new Runnable() {
				    @Override
				    public void run() {
				    	mainApplication.getCustomForm().progressSegment(progressSegment, reportCode, reportFormGroupCode);
//				    	if (reportCode.startsWith("LB")) {
//				    		progressSegmentLb(progressSegment, reportFormGroupCode);
//				    	} else if (reportCode.startsWith("SA")) {
//					    	progressSegmentSa(progressSegment, reportFormGroupCode);
//				    	} else {
//				    		progressSegmentRbb(progressSegment, reportFormGroupCode);
//				    	}
				    }
				});
				FactoryValidationContentHandlerImpl factory = new FactoryValidationContentHandlerImpl(reportCode, progressModel, progressSegment, executor);
				factory.startValidation(reportFormGroupCode);
			}
			
			if ( executor != null ) {
				if ( TaskExecutorUtil.waitAllTaskFinish(executor) > 0 ){
					progressModel.writeProcessLog("Validasi - Ada proses yang belum selesai", false);
				} else {
					progressModel.writeProcessLog("Validasi - Semua Task Validasi sudah berhenti", false);
				}
				executor.shutdown();
			}
			
			
			long totalError = progressModel.getTotalError();
			if ( totalError > 0 ){
				progressModel.writeProcessLog( String.format("Validasi total kesalahan %1$s ", FormatUtil.formatWithThousandSeparator(totalError) ), true);
			}
			progressModel.getSubmissionData().setValidationRelationModel(null);
//			System.gc();
		} else {
			//progressModel.getValidationProgressModel().setProgress(1);
		}

		progressModel.writeProcessLog( String.format("Validasi selesai dalam %1$s", timeCounter.getTimeElapseFormated()), true);
	}
//
//	private void progressSegmentRbb(ProgressSegment progressSegment, int reportFormGroupCode) {
//		FormRbb formRBB = mainApplication.getCustomForm().getFormRbb();
//		switch (reportFormGroupCode) {
//		case 1:
//		case 2:
//		case 3:
//			formRBB.getPelaporan().getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
//			break;
//		case 4:
//			formRBB.getRealisasi().getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
//			break;
//		case 5:
//			formRBB.getPengawasan().getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
//			break;
//		default:
//			break;
//		}
//	}
//
//	private void progressSegmentLb(ProgressSegment progressSegment, int reportFormGroupCode) {
//		FormLb formLB = mainApplication.getCustomForm().getFormLb();
//		switch (reportFormGroupCode) {
//		case 1:
//			formLB.getPelaporan().getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
//			break;
//		case 2:
//			formLB.getPerubahan().getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
//			break;
//		case 3:
//			formLB.getPenyesuaian().getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
//			break;
//		case 4:
//			formLB.getPenyesuaianKap().getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
//			break;
//		default:
//			break;
//		}
//	}
//
//	private void progressSegmentSa(ProgressSegment progressSegment, int reportFormGroupCode) {
//		FormSa form = mainApplication.getCustomForm().getFormSa();
//		switch (reportFormGroupCode) {
//		case 1:
//			form.getPelaporan().getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
//			break;
//		case 2:
//			form.getPelaporanKoreksi().getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
//			break;
//		case 3:
//			form.getPengkinian().getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
//			break;
//		case 4:
//			form.getPengkinianKoreksi().getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
//			break;
//		default:
//			break;
//		}
//	}
}
