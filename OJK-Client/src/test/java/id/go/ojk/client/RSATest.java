package id.go.ojk.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import id.go.ojk.lib.client.lab.RSAKeyUtilBase64;

public class RSATest {


    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException, InvalidKeySpecException, IOException {
    	PublicKey publicKey = RSAKeyUtilBase64.loadPublicKey();
    	PrivateKey privateKey = RSAKeyUtilBase64.loadPrivateKey();

        try {
            final Cipher cipher = Cipher.getInstance("RSA");
            String plaintext = "\"javacirecep\n";
            for(int i=0; i<100 ; i++){
            	plaintext += "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa baris ke - " + i + "\n";
            }
            plaintext += "\"";

            // ENCRYPT using the PUBLIC key
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[][] dataToEncrypts = chunkArray(plaintext.getBytes(), 117);
            List<byte[]> encryptedBytes = new ArrayList<byte[]>();

            for (byte[] dataToEncrypt : dataToEncrypts) {
            	encryptedBytes.add(cipher.doFinal(dataToEncrypt));
			}

            for (byte[] bs : encryptedBytes) {
				System.out.println("aaaa" + bs.length);
			}


            // DECRYPT using the PRIVATE key
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

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
            System.out.println("decrypted (plaintext) = " + decryptedString);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Algorithm not supported! " + e.getMessage() + "!");
        } catch (NoSuchPaddingException | InvalidKeyException e) {
            System.err.println("Cipher cannot be created!");
            e.printStackTrace();
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            System.err.println("An error occurred during the encryption!");
            e.printStackTrace();
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