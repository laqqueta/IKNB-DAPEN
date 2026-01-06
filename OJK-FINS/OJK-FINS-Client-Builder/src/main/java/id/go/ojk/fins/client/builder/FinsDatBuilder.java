package id.go.ojk.fins.client.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.BaseDatBuilder;
import id.go.ojk.fins.client.Constant;
import id.go.ojk.fins.client.builder.field.EUpdateHeader;
import id.go.ojk.fins.client.builder.field.setup.ESetupKeyValueStringFilename;
import id.go.ojk.lib.client.model.update.UpdateHeader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FinsDatBuilder extends BaseDatBuilder {
	private static final EReport REPORT_LBK = EReport.LFINS;
	private static final EReport REPORT_APU = EReport.APU_FINS;
	private static final EReport REPORT_TPP = EReport.TPP_FINS;

	private static final List<String> DUMMY_USER = Arrays.asList(
            "finsdummy@gmail.com",
            "apolo.ojk.sit011@gmail.com",
            // Apolo PM 2025
            "dev@local",
            "airdev.test02@gmail.com",
            "apolo.sit004@gmail.com"
    );

	public static void main(String[] args) {
		try {
			log.info("starting builder");
			Constant.initAppVersion();
			FinsDatBuilder builder = new FinsDatBuilder(args);
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

	public FinsDatBuilder(String[] args) {
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
		return genDummyClientEntity(Constant.SECTOR.getCode(), Arrays.asList("999998"), DUMMY_USER);
	}
	
	@Override
	protected Map<String, List<String>> genDummyUserAppAccess() {
		Map<String, List<String>> res = new HashMap<>();
		List<String> listAppAccess = new ArrayList<>();
		listAppAccess.add(REPORT_LBK.getId());
		listAppAccess.add(REPORT_APU.getId());
		listAppAccess.add(REPORT_TPP.getId());
		for (String user : DUMMY_USER) {
			res.put(user, listAppAccess);
		}
		return res;
	}
}
