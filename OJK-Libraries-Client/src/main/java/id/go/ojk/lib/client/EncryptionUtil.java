package id.go.ojk.lib.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.lib.client.exception.CryptoException;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.bind.ProgressModel;

public class EncryptionUtil {

	private static Logger logger = LoggerFactory.getLogger(EncryptionUtil.class);

	private static final String SYMETRIC_ALGORITHM = "AES";
	private static final String SYMETRIC_TRANSFORMATION = "AES";
	
	public static String aesEncryptBase64(String base64Key, String plain) throws CryptoException {
		String encrypted = new String(Base64.getEncoder().encode(aesEncryption(Cipher.ENCRYPT_MODE, base64Key, plain.getBytes())));
		return encrypted;
	}
	
	public static String aesDecryptBase64(String base64Key, String encryptedBase64) throws CryptoException {
		String decrypted = new String(aesEncryption(Cipher.DECRYPT_MODE, base64Key, Base64.getDecoder().decode(encryptedBase64)));
		return decrypted;
	}
	
	//~ aes password 256 
	
	public static String aesDecrypt256BitString(String password, byte[] input) throws CryptoException {
		return new String(aesEncryption(Cipher.DECRYPT_MODE, password, 256, input));
	}

	public static byte[] aesEncrypt256BitString(String password, String input) throws CryptoException {
		return aesEncryption(Cipher.ENCRYPT_MODE, password, 256, input.getBytes());
	}

	public static byte[] aesDecrypt256Bit(String password, byte[] input) throws CryptoException {
		return aesEncryption(Cipher.DECRYPT_MODE, password, 256, input);
	}

	public static byte[] aesEncrypt256Bit(String password, byte[] input) throws CryptoException {
		return aesEncryption(Cipher.ENCRYPT_MODE, password, 256, input);
	}
	
	public static void aesDecrypt256Bit(String password, InputStream inputStream, OutputStream outputStream) throws CryptoException {
		aesEncryption(Cipher.DECRYPT_MODE, password, 256, inputStream, outputStream);
	}

	public static void aesEncrypt256Bit(String password, InputStream inputStream, OutputStream outputStream) throws CryptoException {
		aesEncryption(Cipher.ENCRYPT_MODE, password, 256, inputStream, outputStream);
	}
	
	//~ aes password
	
	public static String aesDecrypt128BitString(String password, byte[] input) throws CryptoException {
		return new String(aesEncryption128Bit(Cipher.DECRYPT_MODE, password, input));
	}

	public static byte[] aesEncrypt128BitString(String password, String input) throws CryptoException {
		return aesEncryption128Bit(Cipher.ENCRYPT_MODE, password, input.getBytes());
	}

	public static byte[] aesDecrypt128Bit(String password, byte[] input) throws CryptoException {
		return aesEncryption128Bit(Cipher.DECRYPT_MODE, password, input);
	}

	public static byte[] aesEncrypt128Bit(String password, byte[] input) throws CryptoException {
		return aesEncryption128Bit(Cipher.ENCRYPT_MODE, password, input);
	}
	
	public static void aesDecrypt128Bit(String password, InputStream inputStream, OutputStream outputStream) throws CryptoException {
		aesEncryption128Bit(Cipher.DECRYPT_MODE, password, inputStream, outputStream);
	}

	public static void aesEncrypt128Bit(String password, InputStream inputStream, OutputStream outputStream) throws CryptoException {
		aesEncryption128Bit(Cipher.ENCRYPT_MODE, password, inputStream, outputStream);
	}
	
	public static byte[] aesEncryption128Bit(int cipherMode, String password, byte[] input) throws CryptoException {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		aesEncryption128Bit(cipherMode, password, inputStream, outputStream);
		return outputStream.toByteArray();		
	}
	
//	private static final byte[] IV = {
//		0, 2, 4, 8, 16, 32, 64, 127, 
//		127, 64, 32, 16, 8, 4, 2, 0
//	};
	
	private static final byte[] IV = "AAAAAAAAAAAAAAAA".getBytes();
	private static String cekPlainText = "1234567890";
	
	public static void aesEncryption128Bit(int cipherMode, String password, InputStream inputStream, OutputStream outputStream) throws CryptoException {		
		CipherOutputStream out = null;
		try {
			byte[] aesKey = createAESKey(128, password);
			Key secretKey = new SecretKeySpec(aesKey, SYMETRIC_ALGORITHM);
			//Cipher cipher = Cipher.getInstance(SYMETRIC_TRANSFORMATION);
			//cipher.init(cipherMode, secretKey);
			
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			cipher.init(cipherMode, secretKey, new IvParameterSpec(IV));
			
			if ( cipherMode == Cipher.ENCRYPT_MODE ){
				out = new CipherOutputStream(outputStream, cipher);
				out.write(cekPlainText.getBytes());				
			} else {
				out = new CipherOutputStream(new SkipOutputStream(outputStream, cekPlainText.length()) , cipher);
			}
			IOUtils.copy(inputStream, out);

			out.flush();
		} catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IOException | InvalidAlgorithmParameterException ex) {
			logger.error("", ex);
			throw new CryptoException("Error encrypting/decrypting file", ex);
		} finally {
			IOUtils.closeQuietly(out);
		}		
	}
	
	public static byte[] aesEncryption(int cipherMode, String password, int length, byte[] input) throws CryptoException {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		aesEncryption(cipherMode, password, length, inputStream, outputStream);
		return outputStream.toByteArray();		
	}

	
	public static void aesEncryption(int cipherMode, String password, int length, InputStream inputStream, OutputStream outputStream) throws CryptoException {		
		CipherOutputStream out = null;
		try {
			byte[] aesKey = createAESKey(length, password);
			Key secretKey = new SecretKeySpec(aesKey, SYMETRIC_ALGORITHM);
			Cipher cipher = Cipher.getInstance(SYMETRIC_TRANSFORMATION);
			cipher.init(cipherMode, secretKey);

			out = new CipherOutputStream(outputStream, cipher);
			IOUtils.copy(inputStream, out);

			out.flush();
		} catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IOException ex) {
			logger.error("", ex);
			throw new CryptoException("Error encrypting/decrypting file", ex);
		} finally {
			IOUtils.closeQuietly(out);
		}		
	}


	//~ aes
	
	public static byte[] aesEncryption(int cipherMode, String base64Key, byte[] input) throws CryptoException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		CipherOutputStream out = null;
		try ( ByteArrayInputStream inputStream = new ByteArrayInputStream(input) ){
			Key secretKey = new SecretKeySpec(Base64.getDecoder().decode(base64Key), SYMETRIC_ALGORITHM);
			Cipher cipher = Cipher.getInstance(SYMETRIC_TRANSFORMATION);
			cipher.init(cipherMode, secretKey);

			out = new CipherOutputStream(outputStream, cipher);
			IOUtils.copy(inputStream, out);

			out.flush();
		} catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IOException ex) {
			logger.error("", ex);
			throw new CryptoException("Error encrypting/decrypting file", ex);
		} finally {
			IOUtils.closeQuietly(out);
		}
		return outputStream.toByteArray();
	}

	public static void aesEncryption(int cipherMode, String base64Key, List<File> inputFiles, OutputStream outputStream, MeteredIOCopyers ioCopyers) throws CryptoException {
		CipherOutputStream out = null;
		try {
			Key secretKey = new SecretKeySpec(Base64.getDecoder().decode(base64Key), SYMETRIC_ALGORITHM);
			Cipher cipher = Cipher.getInstance(SYMETRIC_TRANSFORMATION);
			cipher.init(cipherMode, secretKey);

			out = new CipherOutputStream(outputStream, cipher);

			InputStream inputStream = null;
			for (File inputFile : inputFiles) {
				try {
					inputStream = new FileInputStream(inputFile);
					if (ioCopyers != null)
						ioCopyers.copy(inputStream, out);
					else
						IOUtils.copy(inputStream, out);
				} finally {
					IOUtils.closeQuietly(inputStream);
				}
			}
			out.flush();
		} catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IOException ex) {
			logger.error("", ex);
			throw new CryptoException("Error encrypting/decrypting file", ex);
		} finally {
			IOUtils.closeQuietly(out);
		}
	}

	public static void aesEncryption(int cipherMode, String base64Key, InputStream inputStream, OutputStream outputStream, MeteredIOCopyers ioCopyers) throws CryptoException {
		CipherOutputStream out = null;
		try {
			Key secretKey = new SecretKeySpec(Base64.getDecoder().decode(base64Key), SYMETRIC_ALGORITHM);
			Cipher cipher = Cipher.getInstance(SYMETRIC_TRANSFORMATION);
			cipher.init(cipherMode, secretKey);

			out = new CipherOutputStream(outputStream, cipher);
			if (ioCopyers != null)
				ioCopyers.copy(inputStream, out);
			else
				IOUtils.copy(inputStream, out);

			out.flush();
		} catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IOException ex) {
			logger.error("", ex);
			throw new CryptoException("Error encrypting/decrypting file", ex);
		} finally {
			IOUtils.closeQuietly(out);
		}
	}

	public static void aesEncryption(int cipherMode, String base64Key, InputStream inputStream, OutputStream outputStream, MeteredIOCopyersPararel ioCopyers2) throws CryptoException {
		CipherOutputStream out = null;
		try {
			Key secretKey = new SecretKeySpec(Base64.getDecoder().decode(base64Key), SYMETRIC_ALGORITHM);
			Cipher cipher = Cipher.getInstance(SYMETRIC_TRANSFORMATION);
			cipher.init(cipherMode, secretKey);

			out = new CipherOutputStream(outputStream, cipher);
			if (ioCopyers2 != null)
				ioCopyers2.copy(inputStream, out);
			else
				IOUtils.copy(inputStream, out);

			out.flush();
		} catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IOException ex) {
			logger.error("", ex);
			throw new CryptoException("Error encrypting/decrypting file", ex);
		} finally {
			IOUtils.closeQuietly(out);
		}
	}
	
	//~ checksum

	public static String getChecksum(MessageDigest digest) {
		byte[] bytes = digest.digest();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
	
    public static String getChecksum(File file) throws NoSuchAlgorithmException, IOException {
    	return getChecksum(Arrays.asList(file));
    }

    public static String getChecksum(List<File> files) throws NoSuchAlgorithmException, IOException {
    	MessageDigest shaDigest = MessageDigest.getInstance("SHA-1");
    	for (File file : files) {
    		FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
				getChecksum(shaDigest, fis);
			} finally {
				IOUtils.closeQuietly(fis);
			}
		}
    	return getChecksum(shaDigest);
    }
    
	public static String getChecksum(String input) throws IOException, NoSuchAlgorithmException
	{
		MessageDigest shaDigest = MessageDigest.getInstance("SHA-1");
		getChecksum(shaDigest, new ByteArrayInputStream(input.getBytes()));
		return getChecksum(shaDigest);
	}

	private static void getChecksum(MessageDigest digest, InputStream inputStream) throws IOException
	{
	    //Create byte array to read data in chunks
	    byte[] byteArray = new byte[1024];
	    int bytesCount = 0;

	    //Read file data and update in message digest
	    while ((bytesCount = inputStream.read(byteArray)) != -1) {
	        digest.update(byteArray, 0, bytesCount);
	    };
	}
	
	public static String getFileChecksum(ProgressModel progressModel, double progressMultiplier, File file) {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			MessageDigest shaDigest = MessageDigest.getInstance("SHA-1");
			getChecksum(progressModel, progressMultiplier, shaDigest, inputStream);
			String shaChecksum = getChecksum(shaDigest);
			return shaChecksum;
		} catch ( Exception e ){
			throw new SlikException("Gagal menghitung checksum", e);
		} finally {
			IOUtils.closeQuietly(inputStream);
		}
	}

	private static void getChecksum(ProgressModel progressModel, double progressMultiplier, MessageDigest digest, InputStream inputStream) throws IOException {
	    byte[] byteArray = new byte[8000];
	    int bytesCount = 0;
	    int countTmp = 0;
	    int counter = 0;
	    while ((bytesCount = inputStream.read(byteArray)) != -1) {
	        digest.update(byteArray, 0, bytesCount);
	        countTmp += bytesCount;
	        counter++;
	        if ( counter >= 3000 ){
		    	progressModel.addProgress( (long)(countTmp * progressMultiplier) );
	        	countTmp = 0;
	        	counter = 0;
	        	if( progressModel.isStop() )
	        		break;
	        }
	    };
	    progressModel.addProgress(countTmp);
    	countTmp = 0;
	}
	
	//~ rsa
	
	public static PublicKey loadPublicKey(String keyBase64) throws NoSuchAlgorithmException, InvalidKeySpecException{
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec pkSpec = new X509EncodedKeySpec( Base64.getDecoder().decode(keyBase64) );
		PublicKey publicKey = keyFactory.generatePublic(pkSpec);
		return publicKey;
	}

	public static byte[] rsaEncryption(String publicKeyBase64, byte[] plain) throws CryptoException, NoSuchAlgorithmException, InvalidKeySpecException {
		return rsaEncryption(loadPublicKey(publicKeyBase64), plain);
	}
	
	public static byte[] rsaEncryption(PublicKey publicKey, byte[] plain) throws CryptoException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
            final Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[][] dataToEncrypts = EncryptionUtil.chunkArray(plain, 117);
            for (byte[] dataToEncrypt : dataToEncrypts) {
            	outputStream.write(cipher.doFinal(dataToEncrypt));
			}

			return outputStream.toByteArray();
		} catch (Exception ex) {
			throw new CryptoException("Error encrypting/decrypting file", ex);
		} finally {
			IOUtils.closeQuietly(outputStream);
		}
	}
	
//	public static void rsaEncryption(PublicKey publicKey, InputStream inputStream, OutputStream outputStream) throws CryptoException {
//		try {
//            final Cipher cipher = Cipher.getInstance("RSA");
//            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//            byte[] plain = IOUtils.toByteArray(inputStream);
//            byte[][] dataToEncrypts = EncryptionUtil.chunkArray(plain, 117);
//            for (byte[] dataToEncrypt : dataToEncrypts) {
//            	outputStream.write(cipher.doFinal(dataToEncrypt));
//			}
//		} catch (Exception ex) {
//			throw new CryptoException("Error encrypting/decrypting file", ex);
//		} 
//	}

	
	public static PrivateKey loadPrivateKey(String keyBase64) throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] key = Base64.getDecoder().decode(keyBase64);

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		KeySpec ks = new PKCS8EncodedKeySpec(key);
		RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(ks);
		return privateKey;
	}
	
	public static byte[] rsaDecryption(String keyBase64, byte[] encrypted) throws CryptoException, NoSuchAlgorithmException, InvalidKeySpecException {
		return rsaDecryption(loadPrivateKey(keyBase64), encrypted);
	}
	
	public static byte[] rsaDecryption(PrivateKey privateKey, byte[] encrypted) throws CryptoException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
            final Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            byte[][] dataToDecrypts = EncryptionUtil.chunkArray(encrypted, 256);
            for (byte[] dataToDecrypt : dataToDecrypts) {
            	outputStream.write(cipher.doFinal(dataToDecrypt));
			}

			return outputStream.toByteArray();
		} catch (Exception ex) {
			logger.error("", ex);
			throw new CryptoException("Error RSA decrypt", ex);
		} finally {
			IOUtils.closeQuietly(outputStream);
		}
	}

	public static PublicKey rsaGeneratePublicKey(String keyBase64) throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] key = Base64.getDecoder().decode(keyBase64);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		KeySpec ks = new PKCS8EncodedKeySpec(key);
		RSAPrivateKey privKey = (RSAPrivateKey) keyFactory.generatePrivate(ks);
		RSAPublicKeySpec keySpec = new RSAPublicKeySpec(privKey.getModulus(), BigInteger.valueOf(65537));

		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;		
	}

	public static String rsaGeneratePublicKeyBase64(String keyBase64) throws NoSuchAlgorithmException, InvalidKeySpecException {
		PublicKey publicKey = rsaGeneratePublicKey(keyBase64);
		String result = Base64.getEncoder().encodeToString(publicKey.getEncoded());
		return result;
	}

	//~ util
	
    public static byte[][] chunkArray(byte[] array, int chunkSize) {
        int numOfChunks = (int)Math.ceil((double)array.length / chunkSize);
        byte[][] output = new byte[numOfChunks][];

        for(int i = 0; i < numOfChunks; ++i) {
            int start = i * chunkSize;
            int length = Math.min(array.length - start, chunkSize);

            byte[] temp = new byte[length];
            System.arraycopy(array, start, temp, 0, length);
            output[i] = temp;
        }

        return output;
    }
    
	public static String generateRandomAESKeyBase64(int length) throws NoSuchAlgorithmException{
		byte[] encodedKey = generateRandomAESKey(length);
		String encodedKeyBase64 = Base64.getEncoder().encodeToString(encodedKey);
		return encodedKeyBase64;
	}
	
	public static byte[] generateRandomAESKey(int length) throws NoSuchAlgorithmException{
		KeyGenerator keyGen = KeyGenerator.getInstance(SYMETRIC_ALGORITHM);
		keyGen.init(length);
		SecretKey secretKey = keyGen.generateKey();
		byte[] encodedKey = secretKey.getEncoded();
		return encodedKey;
	}

	public static byte[] createAESKey(int length, String password) {
		return createAESKey(length, password, 'z');
	}

	public static byte[] createAESKey(int length, String password, char padding) {
		int charLength = length/8;
		String padPwd = StringUtils.rightPad(password, charLength, padding);
				
		return padPwd.getBytes();
	}

}
