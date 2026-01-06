package id.go.ojk.lib.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.utils.IOUtils;

import id.go.ojk.lib.client.model.compression.FileIntegrity;

public class ZipSplitOutputStream extends FilterOutputStream {

	private File destFile;
	private long splitFileSize;

    private long bytesWritten = 0;
    private List<FileIntegrity> fileIntegrities = new ArrayList<FileIntegrity>();

    private ZipSplitOutputStream(final OutputStream out) {
        super(out);
    }

    public ZipSplitOutputStream(File destFile, long splitFileSize) throws FileNotFoundException {
        super(null);
        this.destFile = destFile;
        this.splitFileSize = splitFileSize;
        createNewOutputStream();
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
        count(1);
    }
    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        out.write(b, off, len);
        count(len);
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

    private NumberFormat partFormat = new DecimalFormat("000");
    private void createNewOutputStream() throws FileNotFoundException {
    	if ( this.out != null) {
    		IOUtils.closeQuietly(this.out);
    		fileIntegrities.add( new FileIntegrity(currentFile, null) );
    	}
    	String filePath = destFile.getAbsolutePath() + "." + partFormat.format(fileIntegrities.size() + 1);
    	this.currentFile = new File(filePath);

    	this.currentSize = 0l;
    	this.out = new FileOutputStream(currentFile);
    }

    private boolean closed = false; 
    @Override
    public void close() throws IOException {
    	super.close();
    	if ( !closed ){
        	fileIntegrities.add( new FileIntegrity(currentFile, null) );
        	closed = true;
    	}
    }

    public List<FileIntegrity> getFileIntegrities() {
		return fileIntegrities;
	}

}
