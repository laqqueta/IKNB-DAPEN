package id.go.ojk.lib.client.lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RSAKeyUtil {
	private static Logger logger = LoggerFactory.getLogger(RSAKeyUtil.class);
	public static final String privateKeyFile = "other/key/private.key";
	public static final String publicKeyFile = "other/key/public.key";

	public static void generateKeyPair(){
        try {
        	KeyPairGenerator keyPairGenerator =  KeyPairGenerator.getInstance("RSA");
        	keyPairGenerator.initialize(2048);
        	KeyPair keyPair = keyPairGenerator.generateKeyPair();

        	//private
        	PKCS8EncodedKeySpec pkcsKeySpec = new PKCS8EncodedKeySpec(keyPair.getPrivate().getEncoded());
        	FileOutputStream fos = new FileOutputStream(privateKeyFile);
        	fos.write(pkcsKeySpec.getEncoded());
        	fos.close();

        	//public
        	X509EncodedKeySpec x509ks = new X509EncodedKeySpec(keyPair.getPublic().getEncoded());
            fos = new FileOutputStream(publicKeyFile);
            fos.write(x509ks.getEncoded());
            fos.close();

        } catch (Exception e) {
            logger.error("Algorithm not supported! " + e.getMessage() + "!", e);
        }
	}

	public static PublicKey loadPublicKey() throws FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeySpecException{
		 byte[] encodedKey = IOUtils.toByteArray(new FileInputStream(publicKeyFile));
		    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		    X509EncodedKeySpec pkSpec = new X509EncodedKeySpec(encodedKey);
		    PublicKey publicKey = keyFactory.generatePublic(pkSpec);
		    return publicKey;
	}

	public static PrivateKey loadPrivateKey() throws FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeySpecException{
		byte[] encodedKey = IOUtils.toByteArray(new FileInputStream(privateKeyFile));
	    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	    PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(
	            encodedKey);
	    PrivateKey privateKey = keyFactory.generatePrivate(privKeySpec);
	    return privateKey;
	}


	public static void main(String args[]){
		generateKeyPair();
	}

}
