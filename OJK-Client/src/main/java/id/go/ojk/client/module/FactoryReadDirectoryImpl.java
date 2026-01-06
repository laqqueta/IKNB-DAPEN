package id.go.ojk.client.module;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.module.apu.ReadDirectoryApu;
import id.go.ojk.client.module.bpjs.ReadDirectoryBpjs;
import id.go.ojk.client.module.lb.ReadDirectoryLb;
import id.go.ojk.client.module.lbk.ReadDirectoryLbk;
import id.go.ojk.client.module.pls.ReadDirectoryPls;
import id.go.ojk.client.module.rb.ReadDirectoryRb;
import id.go.ojk.client.module.sa.ReadDirectorySa;
import id.go.ojk.client.module.tl.ReadDirectoryTl;
import id.go.ojk.client.module.tpp.ReadDirectoryTpp;
import id.go.ojk.client.validation.BaseReadDirectory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FactoryReadDirectoryImpl {

	public static BaseReadDirectory getImpl(String reportCode) {
		BaseReadDirectory res = null;
		if (EReport.isRb(reportCode)) {
			res = new ReadDirectoryRb();
		} else if (EReport.isLb(reportCode)) {
			res = new ReadDirectoryLb();
		} else if (EReport.isLbk(reportCode)) {
			res = new ReadDirectoryLbk();
		} else if (EReport.isSa(reportCode)) {
			res = new ReadDirectorySa();
		} else if (EReport.isApu(reportCode)) {
			res = new ReadDirectoryApu();
		} else if (EReport.isTl(reportCode)) {
			res = new ReadDirectoryTl();
		} else if (EReport.isPls(reportCode)) {
			res = new ReadDirectoryPls();
		} else if (EReport.isTpp(reportCode)) {
			res = new ReadDirectoryTpp();
		} else if (EReport.isBpjsKs(reportCode) || EReport.isBpjsTk(reportCode)) {
      res = new ReadDirectoryBpjs();
    }
		return res;
	}
}
