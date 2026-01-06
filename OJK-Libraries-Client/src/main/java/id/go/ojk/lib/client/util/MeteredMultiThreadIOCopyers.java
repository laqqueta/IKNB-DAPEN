package id.go.ojk.lib.client.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.lib.client.model.bind.ProgressModel;

public class MeteredMultiThreadIOCopyers {
	
	private static Logger logger = LoggerFactory.getLogger(MeteredMultiThreadIOCopyers.class);
	
	private ProgressModel progressModel;
	private PersentageCallBack persentageCallBack;
	private long totalByteCount = 0;
	private int maxCounter = 100;

	public MeteredMultiThreadIOCopyers(ProgressModel progressModel, long totalByteCount, PersentageCallBack persentageCallBack){
		this.progressModel = progressModel;
		this.totalByteCount = totalByteCount;
		this.persentageCallBack = persentageCallBack;
		
		if ( totalByteCount < 10000000 )
			maxCounter = 5;
	}

    public long copy(String fileName, final InputStream input, final OutputStream output) throws IOException {
        return copy(fileName, input, output, 8024);
    }

    public long copy(String fileName, final InputStream input, final OutputStream output, int buffersize) throws IOException {
        final byte[] buffer = new byte[buffersize];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            addByteCount(fileName, n);

			if ( progressModel.isStop() )
				break;
        }
        setCompressionProgressSize();
        
        Long tmp = byteCountMap.get(fileName);
        return tmp == null ? 0l : tmp;
    }

    private void setCompressionProgressSize(){
    	Long tmp = byteCountMap.entrySet().stream().mapToLong( e -> e.getValue()).sum();
    	double persentage = (double)tmp/(double)totalByteCount;
    	logger.info("persentage " + persentage);
    	persentageCallBack.updatePersentage(persentage);
    }

    public static interface PersentageCallBack {
    	void updatePersentage(double persentage);
    }
    
	volatile private int counter = 0;
    private ConcurrentMap<String, Long> byteCountMap = new ConcurrentHashMap<String, Long>();
    
    public synchronized void setByteCount(String fileName, long byteCount){
    	byteCountMap.put(fileName, byteCount);
        setCompressionProgressSize();
    }
    public synchronized void addByteCount(String fileName, long byteCount){
    	Long current = byteCountMap.get(fileName);
    	if ( current == null ){
    		byteCountMap.put(fileName, byteCount);
    	} else {
    		current += byteCount;
    		byteCountMap.put(fileName, current);
    	}
    	counter++;
    	if ( counter >= maxCounter ){
            setCompressionProgressSize();
            counter = 0;
    	}
    }
    
}
