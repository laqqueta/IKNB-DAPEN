package id.go.ojk.pnjk.client.builder;

import java.io.BufferedWriter;
import java.io.IOException;

public interface ISampleForm {
	void genFile();
	String genFilename();
	void writeHeader(BufferedWriter writer) throws IOException;
	void writeDetail(BufferedWriter writer) throws IOException;
}
