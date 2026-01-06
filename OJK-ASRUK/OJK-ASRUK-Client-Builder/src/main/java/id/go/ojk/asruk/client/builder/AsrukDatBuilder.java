package id.go.ojk.asruk.client.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.asruk.client.builder.field.EUpdateHeader;
import id.go.ojk.asruk.client.builder.field.setup.ESetupKeyValueStringFilename;
import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.BaseDatBuilder;
import id.go.ojk.lib.client.model.update.UpdateHeader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AsrukDatBuilder extends BaseDatBuilder {
	private static final EReport REPORT_RB = EReport.RB_ASRUK;
	private static final EReport REPORT_RB_UUS = EReport.RB_ASRUU;
	private static final EReport REPORT_LB = EReport.LB_ASRUK;
	private static final EReport REPORT_SA = EReport.SA_ASRUK;
	private static final EReport REPORT_SA_UUS = EReport.SA_ASRUU;
	private static final EReport REPORT_APU = EReport.APU_ASRUK;
	private static final EReport REPORT_PLS = EReport.PLS_ASRUK;
	private static final EReport REPORT_PLS_UUS = EReport.PLS_ASRUU;
	private static final List<String> DUMMY_USER = Arrays.asList("asrukdummy@gmail.com", "dev.external002@gmail.com", "dev_asuransi_umum@outlook.com", "dev_asuransi_umum_uus@outlook.com", "apolo.sit001@gmail.com");

	public static void main(String[] args) {
		try {
			log.info("starting builder");
			AsrukDatBuilder builder = new AsrukDatBuilder(args);
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

	public AsrukDatBuilder(String[] args) {
		super(args, HomeController.homeButton, Constant.SECTOR);
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
	public void init() {
		super.init();
		setSetupReferences(ESetupKeyValueStringFilename.getMap());
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
		return genDummyClientEntity(Constant.SECTOR.getCode(), Arrays.asList("2000000021", "2000099992"), DUMMY_USER);
	}
	
	@Override
	protected Map<String, List<String>> genDummyUserAppAccess() {
		Map<String, List<String>> res = new HashMap<>();
		List<String> listAppAccess = new ArrayList<>();
		listAppAccess.add(REPORT_RB.getId());
		listAppAccess.add(REPORT_RB_UUS.getId());
		listAppAccess.add(REPORT_LB.getId());
		listAppAccess.add(REPORT_SA.getId());
		listAppAccess.add(REPORT_SA_UUS.getId());
		listAppAccess.add(REPORT_APU.getId());
		listAppAccess.add(REPORT_PLS.getId());
		listAppAccess.add(REPORT_PLS_UUS.getId());
		for (String user : DUMMY_USER) {
			res.put(user, listAppAccess);
		}
		return res;
	}
}
