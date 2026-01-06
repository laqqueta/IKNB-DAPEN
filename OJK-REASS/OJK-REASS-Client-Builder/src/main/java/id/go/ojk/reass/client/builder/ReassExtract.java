package id.go.ojk.reass.client.builder;

import id.go.ojk.conf.client.BaseExtract;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReassExtract extends BaseExtract {

	public static void main(String[] args) {
		String submissionId = args[0];
		String sourceFolder = args[1];
		String privateKeyFile = args[2];
		String destinationFolder = args[3];
		ReassExtract extract = new ReassExtract();
		try {
			extract.extract(submissionId, sourceFolder, privateKeyFile, destinationFolder);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
}
