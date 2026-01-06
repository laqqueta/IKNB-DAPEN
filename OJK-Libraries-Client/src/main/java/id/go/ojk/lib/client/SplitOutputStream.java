package id.go.ojk.lib.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.model.bind.ProgressModel;
import id.go.ojk.lib.client.model.compression.FileIntegrity;

public class SplitOutputStream extends FilterOutputStream {

	private ProgressModel progressModel;
	private File destFile;
	private long splitFileSize;

    private long bytesWritten = 0;
    private List<FileIntegrity> fileIntegrities = new ArrayList<FileIntegrity>();
    private MessageDigest messageDigest;

    private SplitOutputStream(final OutputStream out) {
        super(out);
    }

    public SplitOutputStream(ProgressModel progressModel, File destFile, long splitFileSize) throws FileNotFoundException {
        super(null);
        this.progressModel = progressModel;
        this.destFile = destFile;
        this.splitFileSize = splitFileSize;
        createNewOutputStream();
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
        count(1);
        if ( messageDigest != null )
        	messageDigest.update((byte)b);
    }
    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        out.write(b, off, len);
        count(len);
        if ( messageDigest != null )
        	messageDigest.update(b, off, len);
    }

    protected void count(long written) throws FileNotFoundException {
        if (written != -1) {
            bytesWritten += written;
            currentSize += written;
            if ( currentSize > splitFileSize ){
            	createNewOutputStream();
            }
        }
    }

    public long getBytesWritten() {
        return bytesWritten;
    }

    private File currentFile;
    private long currentSize = 0;

    private void createNewOutputStream() throws FileNotFoundException {
    	if ( this.out != null) {
    		IOUtils.closeQuietly(this.out);
    		fileIntegrities.add( new FileIntegrity(currentFile, null) );
    	}
    	String filePath = destFile.getAbsolutePath() + ".part" + fileIntegrities.size();
    	this.currentFile = new File(filePath);

		progressModel.writeProcessLog(
			StringUtils.join(
				"Kompresi - file tujuan ", this.currentFile.getName()
			)
		);

    	this.currentSize = 0l;
    	this.out = new FileOutputStream(currentFile);
    }

    private boolean closed = false;
    @Override
    public void close() throws IOException {
    	if ( !closed ){
        	fileIntegrities.add( new FileIntegrity(currentFile, null) );
    		closed = true;
    	}
    	super.close();
    }

    public List<FileIntegrity> getFileIntegrities() {
		return fileIntegrities;
	}

    public void setMessageDigest(MessageDigest messageDigest) {
		this.messageDigest = messageDigest;
	}
    public MessageDigest getMessageDigest() {
		return messageDigest;
	}

}
