package id.go.ojk.pnmk.client.builder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import id.go.ojk.conf.client.field.reference.ER1124SektorEkonomi;
import id.go.ojk.conf.client.field.reference.ER1135LokasiDati2;
import id.go.ojk.conf.client.field.reference.ER1159JenisIjarah;
import id.go.ojk.lib.client.model.KeyValueString;

public class SampleFormUus2500 extends BaseSampleForm {

	public SampleFormUus2500(String folder, String periode, String ljk, String kodeKoreksi, int dataCount) {
		super(folder, periode, ljk, kodeKoreksi, dataCount);
	}

	@Override
	public String genFilename() {
		String filename = "LBPNMU-2500-{0}-M-{1}-{2}-03.txt";
		return genFilename(filename);
	}

	@Override
	public void writeHeader(BufferedWriter writer) throws IOException {
		final String[] HEADER = new String[] { "H01", "030491", "{ljk}", "{periode}", "LBPNMU", "2500", "{kodekoreksi}",
				"" };
		writeHeader(writer, HEADER);
	}

	@Override
	public void writeDetail(BufferedWriter writer) throws IOException {
		String[] DETAIL = new String[] { "D01", "2500010000", "LO:e32", "LO:e1107", "cabang", "unit", "SE:e01111", "konsumen",
				"3131321212313", "1231321", "JK:e73", "20220630", "20230630", "10", "0", "0", "20", "1", "aset", "30" };
		Random random = new Random();
		List<KeyValueString> dati2 = ER1135LokasiDati2.getObjects();
		List<KeyValueString> sektorEkonomi = ER1124SektorEkonomi.getObjects();
		List<KeyValueString> jenisIjarah = ER1159JenisIjarah.getObjects();
		int maxDati2 = dati2.size() - 1;
		int idxDati2 = 0;
		int maxSektorEkonomi = sektorEkonomi.size() - 1;
		int idxSektorEkonomi = 0;
		int maxJenisIjarah = jenisIjarah.size() - 1;
		int idxJenisIjarah = 0;
		for (int i = 0; i < dataCount; i++) {
			String field03 = getReferenceCode(dati2, idxDati2);
			String field02 = getDati1(field03);
			String field04 = getNamaCabang(i);
			String field05 = getNamaUnit(i);
			String field06 = getReferenceCode(sektorEkonomi, idxSektorEkonomi);
			String field07 = getNamaDebitur(i);
			String field08 = getRandomInt(random);
			String field09 = getUuid();
			String field10 = getReferenceCode(jenisIjarah, idxJenisIjarah);
			String field13 = getRandomInt(random);
			String field16 = getKualitas(random);
			String field17 = getRandomInt(random);
			String field18 = getNamaProduk(i);
			String field19 = getRandomInt(random);
			writer.append(DETAIL[0]).append('|');
			writer.append(DETAIL[1]).append('|');
			writer.append(field02).append('|');
			writer.append(field03).append('|');
			writer.append(field04).append('|');
			writer.append(field05).append('|');
			writer.append(field06).append('|');
			writer.append(field07).append('|');
			writer.append(field08).append('|');
			writer.append(field09).append('|');
			writer.append(field10).append('|');
			writer.append(DETAIL[11]).append('|');
			writer.append(DETAIL[12]).append('|');
			writer.append(field13).append('|');
			writer.append(DETAIL[14]).append('|');
			writer.append(DETAIL[15]).append('|');
			writer.append(field16).append('|');
			writer.append(field17).append('|');
			writer.append(field18).append('|');
			writer.append(field19);
			writer.newLine();
			idxDati2 = resetIdx(idxDati2, maxDati2);
			idxSektorEkonomi = resetIdx(idxSektorEkonomi, maxSektorEkonomi);
			idxJenisIjarah = resetIdx(idxJenisIjarah, maxJenisIjarah);
			writer.flush();
		}
	}

	private String getNamaCabang(int idx) {
		return getNama("cabang", idx);
	}

	private String getNamaUnit(int idx) {
		return getNama("unit", idx);
	}

	private String getNamaDebitur(int idx) {
		return getNama("debitur", idx);
	}

	private String getNamaProduk(int idx) {
		return getNama("produk", idx);
	}

	private String getKualitas(Random random) {
		return String.valueOf(random.nextInt(4) + 1);
	}
}
