package id.go.ojk.asrjs.client.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.asrjs.client.builder.field.EUpdateHeader;
import id.go.ojk.asrjs.client.builder.field.setup.ESetupKeyValueStringFilename;
import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.BaseDatBuilder;
import id.go.ojk.lib.client.model.update.UpdateHeader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AsrjsDatBuilder extends BaseDatBuilder {
	private static final EReport REPORT_RB = EReport.RB_ASRJS;
	private static final EReport REPORT_LB = EReport.LB_ASRJS;
	private static final EReport REPORT_SA = EReport.SA_ASRJS;
	private static final EReport REPORT_APU = EReport.APU_ASRJS;
	private static final EReport REPORT_PLS = EReport.PLS_ASRJS;
	private static final List<String> DUMMY_USER = Arrays.asList("asrjsdummy@gmail.com", "dev_asuransi_jiwa_syariah@outlook.co.id");

	public static void main(String[] args) {
		try {
			log.info("starting builder");
			AsrjsDatBuilder builder = new AsrjsDatBuilder(args);
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

	public AsrjsDatBuilder(String[] args) {
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
		return genDummyClientEntity(Constant.SECTOR.getCode(), Arrays.asList("2000000041", "2000099994"), DUMMY_USER);
	}
	
	@Override
	protected Map<String, List<String>> genDummyUserAppAccess() {
		Map<String, List<String>> res = new HashMap<>();
		List<String> listAppAccess = new ArrayList<>();
		listAppAccess.add(REPORT_RB.getId());
		listAppAccess.add(REPORT_LB.getId());
		listAppAccess.add(REPORT_SA.getId());
		listAppAccess.add(REPORT_APU.getId());
		listAppAccess.add(REPORT_PLS.getId());
		for (String user : DUMMY_USER) {
			res.put(user, listAppAccess);
		}
		return res;
	}
}
