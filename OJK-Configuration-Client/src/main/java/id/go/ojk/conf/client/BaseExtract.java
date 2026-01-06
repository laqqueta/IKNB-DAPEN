package id.go.ojk.conf.client;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.List;

import javax.crypto.Cipher;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.lib.client.ArchiveUtil;
import id.go.ojk.lib.client.EncryptionUtil;
import id.go.ojk.lib.client.SubmissionFileUtil;
import id.go.ojk.lib.client.model.compression.ArchiveResult;
import id.go.ojk.lib.client.model.compression.FileIntegrity;

public class BaseExtract {
	private static final Logger logger = LoggerFactory.getLogger(BaseExtract.class);
	private enum EParameter {
		SUBMISSION_ID ("--submissionId"),
		PRIVATE_KEY_FILE ("--privateKeyFile"),
		SOURCE_FOLDER ("--sourceFolder"),
		DESTINATION_FOLDER ("--destinationFolder"),
		;
		private String key;
		
		private EParameter(String key) {
			this.key = key;
		}
	}
	
	public static void main(String[] args) {
		String submissionId = args[0];
		String sourceFolder = args[1];
		String privateKeyFile = args[2];
		String destinationFolder = args[3];
		BaseExtract baseExtract = new BaseExtract();
		try {
			baseExtract.extract(submissionId, sourceFolder, privateKeyFile, destinationFolder);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	protected byte[] decryptSignature(String privateKeyFile, String signatureFile) throws Exception {
		File signature = new File(signatureFile);
		File key = new File(privateKeyFile);
		byte[] keys = IOUtils.toByteArray(new FileInputStream(key));
		byte[] encryptedSignature = IOUtils.toByteArray(new FileInputStream(signature));
		EncryptionUtil.rsaDecryption(IOUtils.toString(new FileInputStream(key)), encryptedSignature);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(keys));
		PrivateKey privateKey = keyFactory.generatePrivate(privKeySpec);
		byte[] secret = decrypt(privateKey, encryptedSignature);
		logger.info("secret={}", logger.isInfoEnabled() ? new String(secret) : "");
		return secret;
	}
	
	protected ArchiveResult extract(String submissionId, String privateKeyFile, String sourceFolder, String destinationFolder) throws Exception {
		logger.info("submissionId={}|privateKeyFile={}|sourceFolder={}|destinationFolder={}", submissionId, privateKeyFile, sourceFolder, destinationFolder);
		File signature = new File(sourceFolder + File.separator + submissionId + ".signature.part1");
		File key = new File(privateKeyFile);
		File sourceDir = new File(sourceFolder);
		File destDir = new File(destinationFolder);
		BufferedReader bfReader = null;
		String aesKey = null;
		String aesKey2 = null;
		String aesKey3 = null;
		try {
			byte[] keys = IOUtils.toByteArray(new FileInputStream(key));
			byte[] encryptedSignature = IOUtils.toByteArray(new FileInputStream(signature));
			EncryptionUtil.rsaDecryption(IOUtils.toString(new FileInputStream(key)), encryptedSignature);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(keys));
			PrivateKey privateKey = keyFactory.generatePrivate(privKeySpec);
			byte[] secret = decrypt(privateKey, encryptedSignature);
			logger.info("secret={}", logger.isInfoEnabled() ? new String(secret) : "");
			try (InputStream is = new ByteArrayInputStream(secret);) {
				bfReader = new BufferedReader(new InputStreamReader(is));
				String temp = null;
				while ((temp = bfReader.readLine()) != null) {
					if (temp.contains("Enkripsi")) {
						aesKey = temp;
						break;
					}
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		aesKey2 = aesKey != null ? aesKey.substring(9) : "";
		StringBuilder sb = new StringBuilder(aesKey2);
		sb.deleteCharAt(aesKey2.length() - 2);
		aesKey3 = sb.toString();
		List<FileIntegrity> fileIntegrities = SubmissionFileUtil.getZipChunkFileIntegrityOrdered(submissionId,
				sourceDir);
		logger.info(submissionId);
		return ArchiveUtil.deArchiveChecksumDecryptDecompress(fileIntegrities, aesKey3, destDir);
	}

	private byte[] decrypt(PrivateKey privateKey, byte[] encrypted) throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(2, privateKey);
		byte[][] dataToDecrypts = chunkArray(encrypted, 256);
		for (byte[] dataToDecrypt : dataToDecrypts)
			outputStream.write(cipher.doFinal(dataToDecrypt));
		return outputStream.toByteArray();
	}

	private byte[][] chunkArray(byte[] array, int chunkSize) {
		int numOfChunks = (int) Math.ceil(array.length / chunkSize);
		byte[][] output = new byte[numOfChunks][];
		for (int i = 0; i < numOfChunks; i++) {
			int start = i * chunkSize;
			int length = Math.min(array.length - start, chunkSize);
			byte[] temp = new byte[length];
			System.arraycopy(array, start, temp, 0, length);
			output[i] = temp;
		}
		return output;
	}
	
	public static String getParameterSubmissionId(String[] args) {
		return getParameter(EParameter.SUBMISSION_ID, args);
	}
	
	public static String getParameterPrivateKeyFile(String[] args) {
		return getParameter(EParameter.PRIVATE_KEY_FILE, args);
	}
	
	public static String getParameterSourceFolder(String[] args) {
		return getParameter(EParameter.SOURCE_FOLDER, args);
	}
	
	public static String getParameterDestinationFolder(String[] args) {
		return getParameter(EParameter.DESTINATION_FOLDER, args);
	}
	
	private static String getParameter(EParameter eEnum, String[] args) {
		String res = "";
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				String[] splitted = StringUtils.split(args[i], "=");
				if (splitted.length > 1 && eEnum.key.equals(splitted[0])) {
					res = splitted[1];
					break;
				}
			}
		}
		return res;
	}
}
