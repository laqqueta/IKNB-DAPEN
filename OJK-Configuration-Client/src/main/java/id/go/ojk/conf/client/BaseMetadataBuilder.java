package id.go.ojk.conf.client;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.compress.archivers.ArchiveException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.model.config.SubmissionMetadata;
import id.go.ojk.lib.client.EncryptionCompressionUtil;
import id.go.ojk.lib.client.model.compression.MemoryFile;
import id.go.ojk.lib.client.util.FileUtil;
import lombok.Setter;

public abstract class BaseMetadataBuilder extends BaseBuilder implements IMetadataBuilder {
	private static final Logger logger = LoggerFactory.getLogger(BaseMetadataBuilder.class);
	private String base64Key;
	private String metadataFolder;
	private final String METADATA_JAR = "metadata.jar";
	private final String METADATA_XML = "metadata.xml";
	private final String SUMMARY_METADATA_XML = "summary-metadata.xml";
	private final String SUPERVISION_METADATA_XML = "supervision-metadata.xml";
	@Setter private SubmissionMetadata metadata;
	@Setter private SubmissionMetadata summaryMetadata;
	@Setter private SubmissionMetadata supervisionMetadata;

	public BaseMetadataBuilder(String rootFolder, String base64Key) {
		super(rootFolder);
		this.base64Key = base64Key;
		initMetadataFolder();
	}
	
	@Override
	public String buildAll() {
		File folderInput = new File(metadataFolder);
		File fileOutput = new File(FileUtil.concat(jarFolder, METADATA_JAR));
		try {
			init();
			FileUtil.deleteDirContent(folderInput);
			buildMetadataXml();
			buildSummaryMetadataXml();
			buildSupervisionMetadataXml();
			EncryptionCompressionUtil.compressAndEncrypt(base64Key, folderInput, fileOutput);
		} catch (NoSuchAlgorithmException | ArchiveException | IOException e) {
			logger.error(e.getMessage(), e);
		}
		return fileOutput.getAbsolutePath();
	}

	@Override
	public String buildMetadataXml() {
		String res = "";
		try {
			res = new FromSubmissionMetadata().toXml(FileUtil.concat(metadataFolder, METADATA_XML), metadata);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return res;
	}

	@Override
	public String buildSummaryMetadataXml() {
		String res = "";
		try {
			res = new FromSubmissionMetadata().toXml(FileUtil.concat(metadataFolder, SUMMARY_METADATA_XML), summaryMetadata);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return res;
	}
	
	@Override
	public String buildSupervisionMetadataXml() {
		String res = "";
		try {
			res = new FromSubmissionMetadata().toXml(FileUtil.concat(metadataFolder, SUPERVISION_METADATA_XML), supervisionMetadata);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return res;
	}
	
	@Override
	public void testBundle(String filename) {
		File file = new File(filename);
		try {
			List<MemoryFile> memoryFiles = EncryptionCompressionUtil.decryptAndDecompressToMemory(base64Key, 
					Arrays.asList(file), null);
			if (memoryFiles != null) {
				for (MemoryFile memoryFile : memoryFiles) {
					logger.info(memoryFile.getName() + "=" + new String(memoryFile.getContent()));
				}
			} else {
				logger.error("Null result");
			}
		} catch (NoSuchAlgorithmException | ArchiveException | IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	private void initMetadataFolder() {
		metadataFolder = createFolders(rootFolder, "metadata");
	}
}
