package id.go.ojk.lib.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

public class MeteredIOCopyers {
	private PersentageCallBack persentageCallBack;
	private MessageDigest messageDigest;
	private long totalByteCount = 0;

	public MeteredIOCopyers(long totalByteCount, PersentageCallBack persentageCallBack){
		this.totalByteCount = totalByteCount;
		this.persentageCallBack = persentageCallBack;
	}

    public long copy(final InputStream input, final OutputStream output) throws IOException {
        return copy(input, output, 8024);
    }

	private int counter = 0;
    private long readByteCount = 0;

    public long copy(final InputStream input, final OutputStream output, int buffersize) throws IOException {
        final byte[] buffer = new byte[buffersize];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            if ( messageDigest != null ) {
                messageDigest.update(buffer, 0, n);
            }

            readByteCount += n;
            counter++;
            if ( counter >= 1000 ){
            	setCompressionProgressSize(readByteCount);
            	counter = 0;
            }
            if( persentageCallBack.isStopProcess() )
            	break;
        }
        setCompressionProgressSize(readByteCount);
        return readByteCount;
    }

    private void setCompressionProgressSize(long readByteCount){
    	double persentage = (double)readByteCount/(double)totalByteCount;
    	persentageCallBack.updatePersentage(persentage);
    }

    public static interface PersentageCallBack {
    	boolean isStopProcess();
    	void updatePersentage(double persentage);
    }

    public static class EmptyPersentageCallBack implements PersentageCallBack {
    	public boolean isStopProcess(){
    		return false;
    	}
    	public void updatePersentage(double persentage){

    	}
    }

    public MessageDigest getMessageDigest() {
		return messageDigest;
	}
    public void setMessageDigest(MessageDigest messageDigest) {
		this.messageDigest = messageDigest;
	}

    public PersentageCallBack getPersentageCallBack() {
		return persentageCallBack;
	}
}
