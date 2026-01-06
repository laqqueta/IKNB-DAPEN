package id.go.ojk.lib.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

import id.go.ojk.lib.client.model.bind.ProgressModel;

public class MeteredIOCopyersPararel {
	private PersentageCallBack persentageCallBack;
	private MessageDigest messageDigest;

	public MeteredIOCopyersPararel(PersentageCallBack persentageCallBack){
		this.persentageCallBack = persentageCallBack;
	}

	public MeteredIOCopyersPararel(ProgressModel progressModel){
		this.persentageCallBack = new PersentageCallBack() {

			@Override
			public boolean isStopProcess() {
				return progressModel.isStop();
			}

			@Override
			public void addProgress(long byteLong) {
				progressModel.addProgress(byteLong);
			}
		};
	}

    public long copy(final InputStream input, final OutputStream output) throws IOException {
//    	return copy(input, output, 8024 * 4);
    	return copy(input, output, 1024 * 10);
    }


    public long copy(final InputStream input, final OutputStream output, int buffersize) throws IOException {
        final byte[] buffer = new byte[buffersize];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            if ( messageDigest != null ) {
                messageDigest.update(buffer, 0, n);
            }

            addCompressionProgressSize(n, false);
            if( persentageCallBack.isStopProcess() )
            	break;
        }
        addCompressionProgressSize(0, true);
        return n;
    }

	private int counter = 0;
    private long readByteCount = 0;

    private synchronized void addCompressionProgressSize(int add, boolean updateUI){
        readByteCount += add;
        counter++;

        if ( updateUI || counter >= 2000 ){
        	persentageCallBack.addProgress(readByteCount);
        	readByteCount = 0;
        	counter = 0;
        }
    }

    public MessageDigest getMessageDigest() {
		return messageDigest;
	}
    public void setMessageDigest(MessageDigest messageDigest) {
		this.messageDigest = messageDigest;
	}

    public static interface PersentageCallBack {
    	boolean isStopProcess();
    	void addProgress(long byteLong);
    }

    public static class EmptyPersentageCallBack implements PersentageCallBack {
    	@Override
    	public boolean isStopProcess(){
    		return false;
    	}

    	@Override
		public void addProgress(long byteLong) {
		}
    }

}
