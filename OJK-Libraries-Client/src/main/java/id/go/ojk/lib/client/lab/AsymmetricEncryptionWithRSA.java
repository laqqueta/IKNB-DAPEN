package id.go.ojk.lib.client.lab;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsymmetricEncryptionWithRSA {
	private static Logger logger = LoggerFactory.getLogger(AsymmetricEncryptionWithRSA.class);
    private static KeyPair keyPair;

    private static KeyPair initKeyPair() {
        try {
        	KeyPairGenerator keyPairGenerator =  KeyPairGenerator.getInstance("RSA");
        	keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
        	logger.error(e.getMessage(), e);
        }

        return keyPair;
    }

    public static void main(String[] args) {
        initKeyPair();
        try {
            final Cipher cipher = Cipher.getInstance("RSA");
            String plaintext = "\"javacirecep\n";
            for(int i=0; i<100 ; i++){
            	plaintext += "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa baris ke - " + i + "\n";
            }
            plaintext += "\"";

            // ENCRYPT using the PUBLIC key
            cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());

            byte[][] dataToEncrypts = chunkArray(plaintext.getBytes(), 117);
            List<byte[]> encryptedBytes = new ArrayList<byte[]>();

            for (byte[] dataToEncrypt : dataToEncrypts) {
            	encryptedBytes.add(cipher.doFinal(dataToEncrypt));
			}

            // DECRYPT using the PRIVATE key
            cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());

            List<byte[]> decryptedBytes = new ArrayList<byte[]>();

            for (byte[] encryptedByte : encryptedBytes) {
            	decryptedBytes.add(cipher.doFinal(encryptedByte));
			}

            for (byte[] bs : decryptedBytes) {
				System.out.println(bs.length);
			}

            String decryptedString = "";
            for (byte[] bs : decryptedBytes) {
            	decryptedString += new String(bs);
			}
            logger.debug("decrypted (plaintext)=" + decryptedString);
        } catch (NoSuchAlgorithmException e) {
            logger.error("Algorithm not supported! " + e.getMessage() + "!", e);
        } catch (NoSuchPaddingException | InvalidKeyException e) {
        	logger.error("Cipher cannot be created!", e);
        } catch (BadPaddingException | IllegalBlockSizeException e) {
        	logger.error("An error occurred during the encryption!", e);
        }
    }

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
}