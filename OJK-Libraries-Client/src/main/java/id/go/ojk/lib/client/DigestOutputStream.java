package id.go.ojk.lib.client;

import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestOutputStream extends FilterOutputStream {

	private MessageDigest digest;

    private long bytesWritten = 0;

    public DigestOutputStream(OutputStream out) throws NoSuchAlgorithmException {
        super(out);
        this.digest = MessageDigest.getInstance("SHA-1");;
    }

    public DigestOutputStream(OutputStream out, MessageDigest digest) {
        super(out);
        this.digest = digest;
    }
    
    public void setOut(OutputStream out){
    	this.out = out;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
        digest.update((byte)b);
        count(1);
    }

    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        out.write(b, off, len);
        digest.update(b, 0, len);
        count(len);
    }

    protected void count(long written) throws FileNotFoundException {
        if (written != -1) {
            bytesWritten += written;
        }
    }

    public long getBytesWritten() {
        return bytesWritten;
    }


    @Override
    public void close() throws IOException {
    	super.close();
    }
    
    public String getChecksum(){
    	return EncryptionUtil.getChecksum(digest);
    }

}
