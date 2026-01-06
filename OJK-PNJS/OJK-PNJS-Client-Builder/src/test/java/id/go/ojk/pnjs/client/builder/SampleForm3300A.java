package id.go.ojk.pnjs.client.builder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import id.go.ojk.conf.client.field.reference.ER1124SektorEkonomi;
import id.go.ojk.conf.client.field.reference.ER1135LokasiDati2;
import id.go.ojk.lib.client.model.KeyValueString;

public class SampleForm3300A extends BaseSampleForm {

	public SampleForm3300A(String folder, String periode, String ljk, String kodeKoreksi, int dataCount) {
		super(folder, periode, ljk, kodeKoreksi, dataCount);
	}

	@Override
	public String genFilename() {
		String filename = "LBPPNJS-3300A-{0}-M-{1}-{2}-02.txt";
		return genFilename(filename);
	}

	@Override
	public void writeHeader(BufferedWriter writer) throws IOException {
		final String[] HEADER = new String[] { "H01", "030404", "{ljk}", "{periode}", "LBPPNJS", "3300A", "{kodekoreksi}",
				"" };
		writeHeader(writer, HEADER);
	}

	@Override
	public void writeDetail(BufferedWriter writer) throws IOException {
		String[] detail = new String[] { "D01", "3300A10100", "LO:e1101", "3", "2", "3", "3", "2",
				"3", "3", "2", "3", "3", "2", "3", "3", "2", "3", "15", "10", "15" };
		int[] values = new int[15];
		Random random = new Random();
		List<KeyValueString> dati2 = ER1135LokasiDati2.getObjects();
		List<KeyValueString> sektorEkonomi = ER1124SektorEkonomi.getObjects();
		int maxDati2 = dati2.size() - 1;
		int idxDati2 = 0;
		int maxSektorEkonomi = sektorEkonomi.size() - 1;
		int idxSektorEkonomi = 0;
		int countColumns = detail.length;
		for (int i = 0; i < dataCount; i++) {
			detail[2] = getReferenceCode(dati2, idxDati2);
			for (int j = 0; j < values.length; j++) {
				int value = getRandomInt(random, 1000, 1000000);
				values[j] = value;
				detail[j + 3] = String.valueOf(value);
			}
			detail[18] = String.valueOf(values[0] + values[3] + values[6] + values[9] + values[12]);
			detail[19] = String.valueOf(values[1] + values[4] + values[7] + values[10] + values[13]);
			detail[20] = String.valueOf(values[2] + values[5] + values[8] + values[11] + values[14]);
			for (int j = 0; j < detail.length; j++) {
				writer.append(detail[j]);
				if (j < countColumns - 1) {
					writer.append('|');
				}
			}
			writer.newLine();
			idxDati2 = resetIdx(idxDati2, maxDati2);
			idxSektorEkonomi = resetIdx(idxSektorEkonomi, maxSektorEkonomi);
			writer.flush();
		}
	}
}
