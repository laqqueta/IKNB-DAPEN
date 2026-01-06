package id.go.ojk.pnjk.client.builder;

import java.util.*;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.BaseDatBuilder;
import id.go.ojk.lib.client.model.update.UpdateHeader;
import id.go.ojk.pnjk.client.Constant;
import id.go.ojk.pnjk.client.builder.field.EUpdateHeader;
import id.go.ojk.pnjk.client.builder.field.setup.ESetupKeyValueStringFilename;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PnjkDatBuilder extends BaseDatBuilder {
	private static final EReport REPORT_LB = EReport.LB_PNJK;
	private static final EReport REPORT_LB_UUS = EReport.LB_PNJU;
	private static final List<String> DUMMY_USER = Arrays.asList("dev.external003@gmail.com", "dev.external04@yahoo.com", "dev@local");

	public static void main(String[] args) {
		try {
			log.info("starting builder");
			Constant.initAppVersion();
			PnjkDatBuilder builder = new PnjkDatBuilder(args);
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

	public PnjkDatBuilder(String[] args) {
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
		return genDummyClientEntity(Constant.SECTOR.getCode(), Arrays.asList("2500000099"), DUMMY_USER);
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
