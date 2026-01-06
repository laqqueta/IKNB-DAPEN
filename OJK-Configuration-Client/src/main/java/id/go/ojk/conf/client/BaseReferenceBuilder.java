package id.go.ojk.conf.client;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.lib.client.EncryptionCompressionUtil;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.compression.MemoryFile;
import id.go.ojk.lib.client.model.reference.ReferenceHeader;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.util.FileUtil;

public abstract class BaseReferenceBuilder extends BaseBuilder implements IReferenceBuilder {
	private static final Logger logger = LoggerFactory.getLogger(BaseReferenceBuilder.class);
	private String base64Key;
	private String referenceFolder;
	private final String REFERENCE_JAR = "references.jar";
	private final String FAQ_ZIP = "faq.zip";
	private final String MANUAL_PDF = "manual.pdf";
	private final String CONFIG_XML = "config.xml";
	private final String HEADER_XML = "header.xml";
	private final String VALIDATION_ERROR_CODE_XML = "errorCodes.xml";
	private final String MESSAGE_XML = "message.xml";
	private List<KeyValueString> configs;
	private List<KeyValueString> message;
	private ReferenceHeader referenceHeader;
	private Map<String, List<KeyValueString>> references;
	private Map<String, ValidationErrorCode> errorCodes;
	
	public BaseReferenceBuilder(String rootFolder, String base64Key) {
		super(rootFolder);
		this.base64Key = base64Key;
		initReferenceFolder();
	}
	
	@Override
	public String buildAll() {
		File folderInput = new File(referenceFolder);
		File fileOutput = new File(FileUtil.concat(jarFolder, REFERENCE_JAR));
		try {
			init();
			FileUtil.deleteDirContent(folderInput);
			buildConfigXml();
			buildMessageXml();
			buildHeaderXml();
			buildReferenceXml();
			buildValidationErrorCodesXml();
			getFaqZip();
			getManualPdf();
			EncryptionCompressionUtil.compressAndEncrypt(base64Key, folderInput, fileOutput);
		} catch (NoSuchAlgorithmException | ArchiveException | IOException e) {
			logger.error(e.getMessage(), e);
		}
		return fileOutput.getAbsolutePath();
	}

	@Override
	public String getFaqZip() {
		File srcFile = new File(FileUtil.concat(sourceFolder, FAQ_ZIP));
		File destFile = new File(FileUtil.concat(referenceFolder, FAQ_ZIP));
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return destFile.getAbsolutePath();
	}

	@Override
	public String getManualPdf() {
		File srcFile = new File(FileUtil.concat(sourceFolder, MANUAL_PDF));
		File destFile = new File(FileUtil.concat(referenceFolder, MANUAL_PDF));
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return destFile.getAbsolutePath();
	}

	@Override
	public String buildConfigXml() {
		String res = "";
		try {
			res = new FromReferenceHeader().toXml(FileUtil.concat(referenceFolder, CONFIG_XML), configs);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return res;
	}
	
	@Override
	public String buildMessageXml() {
		String res = "";
		try {
			res = new FromReferenceHeader().toXml(FileUtil.concat(referenceFolder, MESSAGE_XML), message);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return res;
	}
	
	@Override
	public String buildHeaderXml() {
		String res = "";
		try {
			res = new FromReferenceHeader().toXml(FileUtil.concat(referenceFolder, HEADER_XML), referenceHeader);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return res;
	}

	@Override
	public List<String> buildReferenceXml() {
		List<String> res = null;
		try {
			res = new FromKeyValueString().toXml(references, referenceFolder);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return res;
	}

	@Override
	public String buildValidationErrorCodesXml() {
		String res = "";
		try {
			res = new FromValidationErrorCode().toXml(FileUtil.concat(referenceFolder, VALIDATION_ERROR_CODE_XML), errorCodes);
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
	
	public void setConfigs(List<KeyValueString> configs) {
		this.configs = configs;
	}
	
	public void setMessage(List<KeyValueString> message) {
		this.message = message;
	}
	
	public void setErrorCodes(Map<String, ValidationErrorCode> errorCodes) {
		this.errorCodes = errorCodes;
	}
	
	public void setReferenceHeader(ReferenceHeader referenceHeader) {
		this.referenceHeader = referenceHeader;
	}
	
	public void setReferences(Map<String, List<KeyValueString>> references) {
		this.references = references;
	}

	private void initReferenceFolder() {
		referenceFolder = createFolders(rootFolder, "reference");
	}
}
