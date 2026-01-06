package id.go.ojk.lib.client;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestInputStream extends FilterInputStream {

	private MessageDigest messageDigest;
	protected DigestInputStream(InputStream in) throws NoSuchAlgorithmException {
		super(in);
		this.messageDigest = MessageDigest.getInstance("SHA-1");;
	}

    public int read() throws IOException {
        int result = in.read();

        if ( result != -1)
        	messageDigest.update((byte)result);

        return result;
    }

    public int read(byte b[]) throws IOException {
        int result = read(b, 0, b.length);

        return result;
    }

    public int read(byte b[], int off, int len) throws IOException {
        int result = in.read(b, off, len);

        if ( result != -1)
        	messageDigest.update(b, off, result);

        return result;
    }

    public String getChecksum(){
    	return EncryptionUtil.getChecksum(messageDigest);
    }
}
