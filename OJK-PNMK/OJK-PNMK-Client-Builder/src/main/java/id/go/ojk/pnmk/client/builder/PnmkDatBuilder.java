package id.go.ojk.pnmk.client.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.BaseDatBuilder;
import id.go.ojk.lib.client.model.update.UpdateHeader;
import id.go.ojk.pnmk.client.Constant;
import id.go.ojk.pnmk.client.builder.field.EUpdateHeader;
import id.go.ojk.pnmk.client.builder.field.setup.ESetupKeyValueStringFilename;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PnmkDatBuilder extends BaseDatBuilder {
	private static final EReport REPORT_LB = EReport.LB_PNMK;
	private static final EReport REPORT_LB_UUS = EReport.LB_PNMU;
	private static final List<String> DUMMY_USER = Arrays.asList("pnmkdummy@gmail.com", "iknbdummy@gmail.com");

	public static void main(String[] args) {
		try {
			log.info("starting builder");
			Constant.initAppVersion();
			PnmkDatBuilder builder = new PnmkDatBuilder(args);
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

	public PnmkDatBuilder(String[] args) {
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
		return genDummyClientEntity(Constant.SECTOR.getCode(), Arrays.asList("2300000099", "2023071800"), DUMMY_USER);
	}
	
	@Override
	protected Map<String, List<String>> genDummyUserAppAccess() {
		Map<String, List<String>> res = new HashMap<>();
		List<String> listAppAccess = new ArrayList<>();
		listAppAccess.add(REPORT_LB.getId());
		listAppAccess.add(REPORT_LB_UUS.getId());
		for (String user : DUMMY_USER) {
			res.put(user, listAppAccess);
		}
		return res;
	}
}
