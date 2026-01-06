package id.go.ojk.conf.client;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.util.XStreamUtil;

public class ReferenceXmlToEnum {

	public static void main(String[] args) {
		final String FOLDER = "D:\\my\\ojk\\client-app\\ReferensiASRJ\\ReferensiLain\\";
		try {
			System.out.println("start...");
			keyValueStringBuilder(FOLDER + "R2205SandiBank.xml", 
					"R_", "d:\\result.txt");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("end...");
		}
	}

	public static void keyValueStringBuilder(String filename, String enumHeader, String outputFile) throws IOException {
        if (filename != null) {
    		XStream xstream = XStreamUtil.instanceStream();
            xstream.alias("list", List.class);
            xstream.alias("reference", KeyValueString.class);
            @SuppressWarnings("unchecked")
			List<KeyValueString> result = (List<KeyValueString>) xstream.fromXML(new File(filename));
            if (result != null) {
            	File file = new File(outputFile);
            	try (PrintWriter pw = new PrintWriter(file)) {
            		pw.print("");
            	}
            	try (FileWriter fr = new FileWriter(file, true)) {
                	for (KeyValueString value : result) {
                		StringBuilder builder = new StringBuilder(enumHeader + value.getKey());
                		builder.append(" (");
                		builder.append("\"" + value.getKey() + "\"");
                		builder.append(", ");
                		builder.append("\"" + value.getValue() + "\"");
                		String[] labels = value.getLabels();
                		if (labels != null && labels.length > 0) {
                    		builder.append(", ");
                    		builder.append("new String[] {");
                    		builder.append("\"" + value.getValue() + "\"");
                    		builder.append("}");
                		}
                		builder.append("),\n");
                    	fr.write(builder.toString());
                	}
            	}
            }
        }
	}

}
