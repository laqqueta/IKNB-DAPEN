package id.go.ojk.client.service.encryption;

import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_aesKey;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_applicationVersion;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_branchVersion;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_checksum;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_dataYearMonth;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_fileChecksumList;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_fileList;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_fileSizeList;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_jenisPelaporan;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_memberCode;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_memberType;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_metadataVersion;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_referenceDataVersion;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_setupVersion;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_submissionFTP;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_submissionID;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_submissionTime;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_totalFileSize;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_userID;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_validationStatus;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.utils.IOUtils;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.service.ApplicationUpdateService;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.client.service.base.BaseService;
import id.go.ojk.client.util.RuntimeUtil;
import id.go.ojk.lib.client.ArchiveUtil;
import id.go.ojk.lib.client.CompressionUtilBig;
import id.go.ojk.lib.client.EncryptionCompressionUtilBig;
import id.go.ojk.lib.client.EncryptionUtil;
import id.go.ojk.lib.client.TimeCounter;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.bind.ProgressModel;
import id.go.ojk.lib.client.model.bind.StatusCallback;
import id.go.ojk.lib.client.model.compression.ArchiveResult;
import id.go.ojk.lib.client.model.compression.FileIntegrity;
import id.go.ojk.lib.client.model.constant.OjkClientConstant;
import id.go.ojk.lib.client.model.encryption.EncryptionResult;
import javafx.application.Platform;

public class EncryptionService extends BaseService {

	private static final String ALGORITHM = "AES";

	private SetupService setupService;
	private ReferenceService referenceService;
	private ConfigService configService;

	@Override
	public void initialize() {
		super.initialize();
		this.setupService = appContext.getService(SetupService.class);
		this.referenceService = appContext.getService(ReferenceService.class);
		this.configService = appContext.getService(ConfigService.class);
	}

	public void compressAndEncrypt(ProgressPreparationAndSending progressModel)
			throws NoSuchAlgorithmException, FileNotFoundException, ArchiveException, IOException {
		// int numberOfThread = Runtime.getRuntime().availableProcessors() -1;
		int numberOfThread = RuntimeUtil.getNumberOfThread();

		if (numberOfThread > 3)
			numberOfThread = 3;
		TimeCounter timeCounter = new TimeCounter();
		progressModel.writeProcessLog(String.format("Kompresi, enkripsi - Mulai"), false);

		List<FileIntegrity> sourceFileIntegrities = progressModel.getSegments().stream()
				.flatMap(e -> e.getSegmentFiles().stream()).map(e -> e.getFileIntegrity()).collect(Collectors.toList());

		EncryptionResult encryptionResult = new EncryptionResult();
		encryptionResult.setAesKey(generateRandomAESKey());

		// ~ Compress and Encrypt

		progressModel.getCompressionEncryptionProgressModel().updateStatus(StatusCallback.start);

		long encryptSlitSize = progressModel.getTotalFileSize() / (numberOfThread * 3);
		if (encryptSlitSize < 100000000l)
			encryptSlitSize = 100000000l;
		if (encryptSlitSize > 500000000l)
			encryptSlitSize = 500000000l;
		progressModel.writeProcessLog(
				String.format("Kompresi, enkripsi dan archive - ukuran split data asli %1$s ", encryptSlitSize), false);
		progressModel.getEncryptionDir().mkdirs();
//		progressModel.getCompressionEncryptionProgressModel().setTotalLength( sourceFileIntegrities.stream().mapToLong(e -> e.getLength()).sum() );
		List<FileIntegrity> comEncs = EncryptionCompressionUtilBig.compressAndEncryptChunckFileIntegrities(
				progressModel.getCompressionEncryptionProgressModel(), CompressionUtilBig.GZIP,
				encryptionResult.getAesKey(), sourceFileIntegrities, encryptSlitSize, progressModel.getEncryptionDir(),
				numberOfThread);

		if (progressModel.isRequestStop())
			return;
		progressModel.getCompressionEncryptionProgressModel().updateStatus(StatusCallback.success);

		progressModel.writeProcessLog(
				String.format("Kompresi dan enkripsi selesai dalam %1$s ", timeCounter.getTimeElapseFormated()), true);

		// ~ Archive and signature file

		timeCounter = new TimeCounter();
		progressModel.writeProcessLog(String.format("Pembentukan File Kirim - Mulai"), false);

		progressModel.getArchiveProgressModel().updateStatus(StatusCallback.start);
		progressModel.getArchiveProgressModel().setTotalLength(comEncs.stream().mapToLong(e -> e.getLength()).sum());
//		File archiveFile = new File(progressModel.getArchiveDir() + "/" + progressModel.getSubmissionId() + ".zip");
		File archiveFile = new File(progressModel.getArchiveDir() + "/" + progressModel.getSubmissionFTP() + ".zip");
		archiveFile.getParentFile().mkdirs();
		Long splitFileSize = configService.getProperties(ConfigService.splitFileSize);
		if (splitFileSize.longValue() < 1 || splitFileSize.longValue() > 20) {
			splitFileSize = 20L;
		}
		splitFileSize = splitFileSize * 1024 * 1024;
		ArchiveResult archiveResult = ArchiveUtil.archive(progressModel.getArchiveProgressModel(), splitFileSize, comEncs, archiveFile);

		if (progressModel.isRequestStop())
			return;

		encryptionResult.setEncryptionDir(archiveFile.getParentFile());
		encryptionResult.setEncResultFiles(archiveResult.getFileIntegrities());
		encryptionResult.setHash(archiveResult.getHash());
		progressModel.setEncryptionResult(encryptionResult);
		createSignature(progressModel);

		// delete file enc
		for (FileIntegrity fileIntegrity : comEncs) {
			fileIntegrity.getFile().delete();
		}
		progressModel.getEncryptionDir().delete();

		// move file
		encryptionResult.moveToReady(progressModel.getReadyToTransferDir());

		progressModel.writeProcessLog(
				String.format("Pembentukan file kirim selesai dalam %1$s ", timeCounter.getTimeElapseFormated()), true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				progressModel.getCompressionEncryptionProgressModel().setProgress(1d);
			}
		});
		progressModel.getArchiveProgressModel().updateStatus(StatusCallback.success);
	}

	public void createSignature(ProgressPreparationAndSending progressModel) {
		SetupService setupService = appContext.getService(SetupService.class);
		ApplicationUpdateService applicationUpdateService = appContext.getService(ApplicationUpdateService.class);

		EncryptionResult encryptionResult = progressModel.getEncryptionResult();

		Properties signature = new Properties();

		signature.setProperty(sigKey_submissionID, progressModel.getSubmissionId());
		signature.setProperty(sigKey_submissionFTP, progressModel.getSubmissionFTP());
		signature.setProperty(sigKey_jenisPelaporan, progressModel.getJenisPelaporan());
		signature.setProperty(sigKey_userID, progressModel.getUserId());
		signature.setProperty(sigKey_memberType, setupService.getMemberTypeCode());
		signature.setProperty(sigKey_memberCode, setupService.getMemberCode());
		signature.setProperty(sigKey_aesKey, encryptionResult.getAesKey());
		signature.setProperty(sigKey_totalFileSize, encryptionResult.getTotalSize() + "");
		signature.setProperty(sigKey_validationStatus, "sukses");

		signature.setProperty(sigKey_applicationVersion, OjkClientConstant.applicationVersion);
		signature.setProperty(sigKey_referenceDataVersion, referenceService.getVersion());
		signature.setProperty(sigKey_metadataVersion, progressModel.getMetadata().getVersion());
		signature.setProperty(sigKey_setupVersion, applicationUpdateService.getSetupVersion());
		signature.setProperty(sigKey_branchVersion, applicationUpdateService.getSetupBranchModified());

		signature.setProperty(sigKey_dataYearMonth,
				progressModel.getSubmissionData().getDataYear() + progressModel.getSubmissionData().getDataMonth());
		signature.setProperty(sigKey_submissionTime,
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));

		signature.setProperty(sigKey_fileList,
				progressModel.getSegments().stream().map(e -> e.getSegmentFiles()).flatMap(e -> e.stream())
						.map(e -> e.getFileIntegrity().getFile().getName()).collect(Collectors.joining("|")));
		signature.setProperty(sigKey_fileSizeList,
				progressModel.getSegments().stream().map(e -> e.getSegmentFiles()).flatMap(e -> e.stream())
						.map(e -> e.getFileIntegrity().getFile().length() + "").collect(Collectors.joining("|")));
		signature.setProperty(sigKey_fileChecksumList,
				progressModel.getSegments().stream().map(e -> e.getSegmentFiles()).flatMap(e -> e.stream())
						.map(e -> e.getFileIntegrity().getChecksum()).collect(Collectors.joining("|")));

		signature.setProperty(sigKey_checksum, encryptionResult.getHash());

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		// Create txt signature
		File signatureTxt = new File(progressModel.getArchiveDir().getAbsolutePath() + "/"
				+ progressModel.getSubmissionFTP() + ".signature.part0");
		signatureTxt.getParentFile().mkdirs();
		// File signatureFile = new File(progressModel.getArchiveDir().getAbsolutePath()
		// + "/" + progressModel.getSubmissionId() + ".signature.part1");
		File signatureFile = new File(progressModel.getArchiveDir().getAbsolutePath() + "/"
				+ progressModel.getSubmissionFTP() + ".signature.part1");
		signatureFile.getParentFile().mkdirs();

		FileOutputStream fos = null;
		BufferedWriter bw = null;
		try {
			signature.store(outputStream, "SLIK-Client");
			// byte[] encrypted =
			// rsaEncryption(appContext.getService(SetupService.class).getRsaPublicKey(),
			// outputStream.toByteArray());
			byte[] encrypted = EncryptionUtil.rsaEncryption(setupService.getRsaPublicKey(), outputStream.toByteArray());

//			 byte[] decrypted = EncryptionUtil.rsaDecryption("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCrFjTL5QTG/CQmDZQGnqS2nJ881bZu5HTrCXh5YR5Pjl6MhUdmJs1ft/1riq8WmCILsI1KzgK0PvwWVCkKL624ceS37Rn56CSr6s2lDrckEOF9TWG4V4cOQM1n/pqdb+EvPnWXX3L3LKrXczfin0AHA0VoRb91YIdKSbS+k0HA/WDCdaxsw40XVFFr+2JH69ydFY7GZ4RMlihD9OtEfUVjHJhV5984MGPfiynA01WkCsUoz2re7cRKlAGLOXObq5eh0QftQ8JivBfoVC9m3cQ66MAEvELig0BMxp8WZOyh/69Z1DghF5UOJ3QohAaBPML3/QQrCM6jAFo46qrPG5iVAgMBAAECggEBAI+zxD7qq1uT160axJXW1NUJsvq/K0/zln0A5G9XcsUx+Rqgq/sSZniaq0KUJ0KcICSfc948MatCKC19HUeQCqOdDpaqkaIGKh84xuh39r5Va4D66TSUWD1RkvZhtW691XAAT3cI1iDlJM542Z0BVB9P0RGnXAx0Os7cH/Pe7mDxUDJxf5vnxfOElE3i2dB3Pil0sfUsF+n641N1GQYNsuhA9s6iIsvSck8Ez3A+c7ux7CnqI46IxsZDaZZeNkevhkGW5xQBF4WTUPMTCyeqUyjZYBb4Ota/fAIgDOsuWG2ldOo1fpitVYDPgHlFzUXnKCpn/QlBGVNrgw2HaZIkaYECgYEA66qrh+KR8UX7UuqLrCnQb49fzBD2Fc+xzCgC4BiRLWBH/SWg+GRb+D/5VZ0287YOG7tscqiNHqlFYR/RrZU20ykW6uscAYOEnrbsvc3cUV2gB44NKFdivnzK4PpSStYiZuynlCAf5Fa/Pj7kbbQ1w9d1pI1vEzriWDce5ogMjvUCgYEAudkdg2Z5wh+H04SpxBAtrAJ+VUk87k7384QmG/RscfGrpMjaaUC/6llmuZyrn2B/5G4Kee/dMBdkwTdmIi5xUSfOa1RBdGUUWZAIr/HQvUqUTUtTQqxghymTi95Tb1VBul30r5U5MolVdntvqAAVffpjhSr4/KzQ80h6U1AHnyECgYALruVcEjZsAK0p+ii8e0IzFaeJJVod0LMezOj/lRg1aK2I9kGZrtgEYZ+JyAZ+ZIskgtEoigSc/YVMAFjTwy75nvLc6JT12kBL4gOwkTEX841IcpliY5qomOUx7BcCUMVZ1uej50fNeSN4AYQvkByOPfM+GijkiinId8sXYK1GtQKBgQC5HReWkHXq8/kYqGVokyzKzlkDnkWAoUu8VP6YjaeO/0cWhbF3cTU3ugDmFLWltDrvTuREfLT2d/a1tfaXSWc5jMrAgVYJF71jUGI2zkg6o5SAQO0X1hb3ymPax4KXvHYRqhBU6+/i9IQZ1e1ri1nc95A1To5fL8uY57JgVbChwQKBgFhwSpuj+RnutoDnvXWIkAUPs1e/lhjxzudcX1dR0bv3AuPvqANIEUgLiTDcBB6107ot6bbKvr/nakXFYlea8zMm3Jgp0aOkrHtHaQFE0l44Ce2+sCI7DPovahIieX9HXYkmsj9RzK0RhkqUYOFS00AGUGlQi3Y8uGitZ3K7qftM", encrypted);
			// String decString = new String(decrypted);

//			String dateNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
			fos = new FileOutputStream(signatureFile);
			fos.write(encrypted);

			encryptionResult.setSignatureFile(signatureFile);

			bw = new BufferedWriter(new FileWriter(signatureTxt));
//			bw.write("D01|" + progressModel.getUserId() + "|" + dateNow + "|" + dateNow + "|\n");
			bw.write(applicationUpdateService.getSetupVersion() + "|" + progressModel.getMetadata().getVersion() + "|"
					+ referenceService.getVersion() + "|" + OjkClientConstant.applicationVersion);
			bw.write("\n");
			bw.write(randomString(11) + encryptionResult.getAesKey() + randomString(12));
			bw.write("\n");
			bw.write(String.valueOf(progressModel.getEncryptionResult().getEncResultFiles().size()));
			bw.flush();
//			bw.write("D03|A" + SlikClientConstant.applicationVersion + "|R" + referenceService.getVersion() 
//					+ "|M" + progressModel.getMetadata().getVersion() + "|S" + applicationUpdateService.getSetupVersion());

		} catch (Exception e) {
			logger.error("", e);
		} finally {
			IOUtils.closeQuietly(outputStream);
			IOUtils.closeQuietly(fos);
			IOUtils.closeQuietly(bw);
		}
	}

	private String generateRandomAESKey() throws NoSuchAlgorithmException {
		String encodedKey = EncryptionUtil.generateRandomAESKeyBase64(OjkClientConstant.encAesKeyLength);
		return encodedKey;
	}

	private String randomString(int len) {
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}

		return sb.toString();
	}

//	private static byte[] rsaEncryption(PublicKey publicKey, byte[] plain) throws CryptoException {
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//		try {
//            final Cipher cipher = Cipher.getInstance("RSA");
//            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//
//            byte[][] dataToEncrypts = EncryptionUtil.chunkArray(plain, 117);
//            for (byte[] dataToEncrypt : dataToEncrypts) {
//            	outputStream.write(cipher.doFinal(dataToEncrypt));
//			}
//
//			return outputStream.toByteArray();
//		} catch (Exception ex) {
//			throw new CryptoException("Error encrypting/decrypting file", ex);
//		} finally {
//			IOUtils.closeQuietly(outputStream);
//		}
//	}

	public String getFileChecksum(ProgressModel progressModel, File file) {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			// Use SHA-1 algorithm
			MessageDigest shaDigest = MessageDigest.getInstance("SHA-1");

			getChecksum(progressModel, shaDigest, inputStream);

			// SHA-1 checksum
			String shaChecksum = getChecksum(shaDigest);

			// see checksum
			return shaChecksum;
		} catch (Exception e) {
			throw new SlikException("Gagal menghitung checksum", e);
		} finally {
			IOUtils.closeQuietly(inputStream);
		}
	}

	private String getChecksum(MessageDigest digest) {
		byte[] bytes = digest.digest();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	private static void getChecksum(ProgressModel progressModel, MessageDigest digest, InputStream inputStream)
			throws IOException {
		// Create byte array to read data in chunks
		byte[] byteArray = new byte[8000];
		int bytesCount = 0;

		// Read file data and update in message digest

		int countTmp = 0;

		while ((bytesCount = inputStream.read(byteArray)) != -1) {
			digest.update(byteArray, 0, bytesCount);
			countTmp += bytesCount;
			if (countTmp >= 10000) {
				progressModel.addProgress(countTmp);
				countTmp = 0;
				if (progressModel.isStop())
					break;
			}
		}
		;

		progressModel.addProgress(countTmp);
		countTmp = 0;
	}

}
