package id.go.ojk.lib.client.lab;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

import org.apache.commons.compress.utils.IOUtils;

import id.go.ojk.lib.client.EncryptionUtil;
import id.go.ojk.lib.client.exception.CryptoException;

public class JasperEncryption {
	
	public static void main(String args[]) throws NoSuchAlgorithmException, InvalidKeySpecException{
		String rsaPublicKeyBase64 = "b00f268c5d73b2d7ec449623db657214e36d7d28a75e33f0d0817ce2201c93fbcba224b467a84d4521c9299e6c417d6e34bb2f341530e02959fff604a7f882922c804ab33aeadda4062a689e5e2bba80f4167dc3f6489ad22375ffb63f5fbab28c2773c73eb9cf3fbb50e3e798ca62ad5490bbb4cd27eb76189c50afe73db44f";
		PublicKey rsaPublicKey = loadPublicKey(rsaPublicKeyBase64);
	}
	
	private static  PublicKey loadPublicKey(String keyBase64) throws NoSuchAlgorithmException, InvalidKeySpecException{
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec pkSpec = new X509EncodedKeySpec( Base64.getDecoder().decode(keyBase64) );
		PublicKey publicKey = keyFactory.generatePublic(pkSpec);
		return publicKey;
	}

	private static byte[] rsaEncryption(PublicKey publicKey, byte[] plain) throws CryptoException {
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

}
