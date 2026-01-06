package id.go.ojk.conf.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.thoughtworks.xstream.XStream;

import id.go.ojk.lib.client.util.FileUtil;
import id.go.ojk.lib.client.util.XStreamUtil;

public class BaseObjectToXml<T> {
	protected XStream xstream;
	
	public BaseObjectToXml() {
		initXStream();
	}

	public List<String> toXml(Map<String, T> referenceFilename, String outputFolder) throws IOException {
		List<String> res = new ArrayList<>();
		if (referenceFilename != null) {
            Iterator<Entry<String, T>> iterator = referenceFilename.entrySet().iterator();
            while (iterator.hasNext()) {
            	Entry<String, T> entry = iterator.next();
                String filename = entry.getKey();
                T reference = entry.getValue();
                res.add(toXml(FileUtil.concat(outputFolder, filename), reference));
            }
        }
		return res;
	}
	
	public String toXml(String filename, Object reference) throws IOException {
		return XStreamUtil.writeToXml(xstream, reference, filename);
	}
	
	protected void initXStream() {
		xstream = XStreamUtil.instanceStream();
	}
}
