package id.go.ojk.bptk.client.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.bptk.client.builder.field.EUpdateHeader;
import id.go.ojk.bptk.client.builder.field.setup.ESetupKeyValueStringFilename;
import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.conf.client.BaseDatBuilder;
import id.go.ojk.lib.client.constant.LogTemplate;
import id.go.ojk.lib.client.model.update.UpdateHeader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BptkDatBuilder extends BaseDatBuilder {
	private static final List<String> DUMMY_USERS = Arrays.asList("dev.external002@gmail.com", "apolo.sit014@gmail.com", "apolo.sit015@gmail.com", "apolo.sit016@gmail.com");
	private static final List<String> LJK_CODES = Arrays.asList("BPJSTK0001", "BPJSTK0002", "BPJSTK0003");

	public static void main(String[] args) {
		try {
			log.info(LogTemplate.STARTING_BUILDER);
			BptkDatBuilder builder = new BptkDatBuilder(args);
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
			log.info(LogTemplate.STOPPED);
		}
	}

	public BptkDatBuilder(String[] args) {
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
		return genDummyClientEntity(Constant.SECTOR.getCode(), LJK_CODES, DUMMY_USERS);
	}

	@Override
	protected Map<String, List<String>> genDummyUserAppAccess() {
		Map<String, List<String>> res = new HashMap<>();
		List<String> allAccess = new ArrayList<>();
		allAccess.add(EReport.BPTKLP.getId());
    allAccess.add(EReport.BPTKLB.getId());
    allAccess.add(EReport.BPTKLA.getId());
    allAccess.add(EReport.BPTKLT.getId());

    for (String user : DUMMY_USERS) {
      res.put(user, allAccess);
    }
		return res;
	}
}
