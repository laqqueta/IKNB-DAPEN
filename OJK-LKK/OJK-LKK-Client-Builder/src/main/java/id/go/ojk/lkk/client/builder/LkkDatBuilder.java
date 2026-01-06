package id.go.ojk.lkk.client.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.BaseDatBuilder;
import id.go.ojk.lib.client.model.update.UpdateHeader;
import id.go.ojk.lpei.client.Constant;
import id.go.ojk.lpei.client.builder.field.EUpdateHeader;
import id.go.ojk.lpei.client.builder.field.setup.ESetupKeyValueStringFilename;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LkkDatBuilder extends BaseDatBuilder {
	private static final EReport REPORT_LB_LPEIG = EReport.LB_LPEIG;
	private static final EReport REPORT_LB_LPEIU = EReport.LB_LPEIU;
	private static final EReport REPORT_LB_PNMK = EReport.LB_PNMK;
	private static final EReport REPORT_LB_PNMU = EReport.LB_PNMU;
	private static final List<String> DUMMY_USER = Arrays.asList("dev.external001@gmail.com", "dev.external04@yahoo.com", "dev.external05@yahoo.com",
			"lpeidummy@gmail.com", "iknbdummy@gmail.com", "apolo.sit004@gmail.com", "apolo.sit005@gmail.com");

	public static void main(String[] args) {
		try {
			log.info("starting builder");
			Constant.initAppVersion();
			LkkDatBuilder builder = new LkkDatBuilder(args);
			builder.setLjkCodeMinLen(10);
			builder.setLjkCodeMaxLen(10);
			builder.buildAll();
			List<String> listDatEntity = builder.getListDatEntity();
			if (listDatEntity != null) {
				for (int i = 0; i < listDatEntity.size(); i++) {
					builder.testBundle(listDatEntity.get(i));
				}
			}
		} finally {
			log.info("stopped");
		}
	}

	public LkkDatBuilder(String[] args) {
		super(args, HomeController.homeButton, Constant.SECTOR);
	}

	@Override
	public void init() {
		super.init();
		setSetupReferences(ESetupKeyValueStringFilename.getMap());
	}

	@Override
	public String buildMetadataJar() {
		MetadataBuilder builder = new MetadataBuilder(rootFolder, base64Key);
		return builder.buildAll();
	}

	@Override
	public String buildReferenceJar() {
		ReferenceBuilder builder = new ReferenceBuilder(rootFolder, base64Key);
		return builder.buildAll();
	}

	@Override
	protected UpdateHeader initUpdateHeader() {
		return EUpdateHeader.UPDATE_HEADER.getObject();
	}

	@Override
	protected UpdateHeader initUpdateHeaderFtp() {
		return EUpdateHeader.FTP_UPDATE_HEADER.getObject();
	}

	@Override
	protected String initVersion() {
		return EUpdateHeader.FTP_UPDATE_HEADER.getVersion();
	}

	@Override
	protected String genDummyClientEntity() {
		return genDummyClientEntity(Constant.SECTOR.getCodeAlias(), Arrays.asList("2400000099"), DUMMY_USER);
	}

	@Override
	protected Map<String, List<String>> genDummyUserAppAccess() {
		Map<String, List<String>> res = new HashMap<>();
		List<String> listAppAccess = new ArrayList<>();
		listAppAccess.add(REPORT_LB_LPEIG.getId());
		listAppAccess.add(REPORT_LB_LPEIU.getId());
		listAppAccess.add(REPORT_LB_PNMK.getId());
		listAppAccess.add(REPORT_LB_PNMU.getId());
		for (String user : DUMMY_USER) {
			res.put(user, listAppAccess);
		}
		return res;
	}
}
