package id.go.ojk.lib.client;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

import id.go.ojk.lib.client.model.FileChunk;

public class ChunkInputStream extends FilterInputStream {

	private long startOffset;
	private long endOffset;
	private long bytePosition;

	public ChunkInputStream(FileChunk fileChunk, long additionalOffset) throws IOException {
		this(new FileInputStream(fileChunk.getFile()), fileChunk.getByteOffset() + additionalOffset, fileChunk.getByteOffset() + fileChunk.getByteLength(), fileChunk);
	}

	private ChunkInputStream(InputStream in, long startOffset, long endOffset, FileChunk fileChunk) throws IOException {
		super(in);
		this.startOffset = startOffset;
		this.endOffset = endOffset;
		this.bytePosition = this.startOffset;
		in.skip(this.startOffset);
	}

    public int read() throws IOException {
    	if ( bytePosition + 1 > endOffset ){
    		return -1;
    	}
        int result = in.read();
        if ( result != -1 ){
        	bytePosition++;
        }
        return result;
    }

    public int read(byte b[]) throws IOException {
    	return read(b, 0, b.length);
    }

    public int read(byte b[], int off, int len) throws IOException {
    	int lengthToRead = len;
    	if ( bytePosition + lengthToRead >= endOffset ){
    		lengthToRead = (int)(endOffset - bytePosition);
    	}

    	if ( lengthToRead == 0 ) {
    		return -1;
    	}

        int result = in.read(b, off, lengthToRead);
        if ( result != -1 ){
        	bytePosition += result;
        }
        return result;
    }

    public long skip(long n) throws IOException {
    	long lengthToSkip = n;
    	if ( bytePosition + lengthToSkip >= endOffset ){
    		lengthToSkip = endOffset - bytePosition;
    	}

    	if ( lengthToSkip <= 0 )
    		return -1;

    	long result = in.skip(lengthToSkip);
        if ( result != -1 ){
        	bytePosition += result;
        }
        return result;
    }

    public int available() throws IOException {
        return 0;
    }

    public void close() throws IOException {
        in.close();
    }

    public synchronized void mark(int readlimit) {
        in.mark(readlimit);
    }

    public synchronized void reset() throws IOException {
        in.reset();
    }

    public boolean markSupported() {
        return false;
    }
}
