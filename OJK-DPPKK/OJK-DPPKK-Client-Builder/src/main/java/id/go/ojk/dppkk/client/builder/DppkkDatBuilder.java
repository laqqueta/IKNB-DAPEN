package id.go.ojk.dppkk.client.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.BaseDatBuilder;
import id.go.ojk.dppkk.client.builder.field.EUpdateHeader;
import id.go.ojk.dppkk.client.builder.field.setup.ESetupKeyValueStringFilename;
import id.go.ojk.lib.client.model.update.UpdateHeader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DppkkDatBuilder extends BaseDatBuilder {
	private static final EReport REPORT_RB = EReport.RB_DPPKK;
	private static final EReport REPORT_RB_UUS = EReport.RB_DPPKU;
	private static final EReport REPORT_SA = EReport.SA_DPPKK;
	private static final EReport REPORT_SA_UUS = EReport.SA_DPPKU;
	private static final EReport REPORT_TL = EReport.TL_DPPKK;
	private static final EReport REPORT_TL_UUS = EReport.TL_DPPKU;
    private static final EReport REPORT_LKTB = EReport.LKTB_DPPKK;
	private static final List<String> DUMMY_USER = Arrays.asList("dppkkdummy@gmail.com", "dev.external05@gmail.com", "airdev.test01@gmail.com", "airdev.test02@gmail.com", "apolo.sit006@gmail.com", "apolo.sit007@gmail.com", "dev@local");

	public static void main(String[] args) {
		try {
			log.info("starting builder");
			DppkkDatBuilder builder = new DppkkDatBuilder(args);
			builder.setLjkCodeMinLen(5);
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

	public DppkkDatBuilder(String[] args) {
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
		return genDummyClientEntity(Constant.SECTOR.getCode(), Arrays.asList("2000004732", "2000099998"), DUMMY_USER);
	}
	
	@Override
	protected Map<String, List<String>> genDummyUserAppAccess() {
		Map<String, List<String>> res = new HashMap<>();
		List<String> listAppAccess = new ArrayList<>();
		listAppAccess.add(REPORT_RB.getId());
		listAppAccess.add(REPORT_RB_UUS.getId());
		listAppAccess.add(REPORT_SA.getId());
		listAppAccess.add(REPORT_SA_UUS.getId());
		listAppAccess.add(REPORT_TL.getId());
		listAppAccess.add(REPORT_TL_UUS.getId());
        listAppAccess.add(REPORT_LKTB.getId());
		for (String user : DUMMY_USER) {
			res.put(user, listAppAccess);
		}
		return res;
	}
}
