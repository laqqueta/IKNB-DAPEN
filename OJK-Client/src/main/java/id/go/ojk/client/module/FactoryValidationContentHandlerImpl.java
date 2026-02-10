package id.go.ojk.client.module;

import java.util.concurrent.ThreadPoolExecutor;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.module.apu.ValidationHandlerApu;
import id.go.ojk.client.module.bpjs.ValidationHandlerBpjs;
import id.go.ojk.client.module.lb.ValidationHandlerLb;
import id.go.ojk.client.module.lbk.ValidationHandlerLbk;
import id.go.ojk.client.module.lktb.ValidationHandlerLktb;
import id.go.ojk.client.module.pls.ValidationHandlerPls;
import id.go.ojk.client.module.rb.ValidationHandlerRb;
import id.go.ojk.client.module.sa.ValidationHandlerSa;
import id.go.ojk.client.module.tl.ValidationHandlerTl;
import id.go.ojk.client.module.tpp.ValidationHandlerTpp;
import id.go.ojk.client.validation.IValidationContentHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class FactoryValidationContentHandlerImpl {
	private String reportCode;
	private ProgressPreparationAndSending progressModel;
	private ProgressSegment progressSegment;
	private ThreadPoolExecutor executor;

	public void startValidation(int reportFormGroupCode) {
		IValidationContentHandler handler = getImpl();
		if (handler != null) {
			handler.startValidation(reportFormGroupCode);
		} else {
			log.error("ValidationContentHandler is null!!!");
		}
	}

	private IValidationContentHandler getImpl() {
		IValidationContentHandler res = null;
		if (EReport.isRb(reportCode)) {
			res = new ValidationHandlerRb(progressModel, progressSegment, executor);
		} else if (EReport.isLb(reportCode)) {
			res = new ValidationHandlerLb(progressModel, progressSegment, executor);
		} else if (EReport.isLbk(reportCode)) {
			res = new ValidationHandlerLbk(progressModel, progressSegment, executor);
		} else if (EReport.isSa(reportCode)) {
			res = new ValidationHandlerSa(progressModel, progressSegment, executor);
		} else if (EReport.isApu(reportCode)) {
			res = new ValidationHandlerApu(progressModel, progressSegment, executor);
		} else if (EReport.isTl(reportCode)) {
			res = new ValidationHandlerTl(progressModel, progressSegment, executor);
		} else if (EReport.isPls(reportCode)) {
			res = new ValidationHandlerPls(progressModel, progressSegment, executor);
		} else if (EReport.isLktb(reportCode)) {
			res = new ValidationHandlerLktb(progressModel, progressSegment, executor);
		} else if (EReport.isTpp(reportCode)) {
			res = new ValidationHandlerTpp(progressModel, progressSegment, executor);
    } else if (EReport.isBpjsKs(reportCode) || EReport.isBpjsTk(reportCode)) {
      res = new ValidationHandlerBpjs(progressModel, progressSegment, executor);
    }
		return res;
	}
}
