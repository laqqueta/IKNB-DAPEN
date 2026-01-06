package id.go.ojk.pnjk.client.builder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import id.go.ojk.conf.client.field.reference.ER1124SektorEkonomi;
import id.go.ojk.conf.client.field.reference.ER1135LokasiDati2;
import id.go.ojk.conf.client.field.reference.ER1185JenisPenjaminan;
import id.go.ojk.conf.client.field.reference.ER1186ProdukPenjaminan;
import id.go.ojk.conf.client.field.reference.ER1193JenisPenerimaJaminan;
import id.go.ojk.lib.client.model.KeyValueString;

public class SampleForm3100Uus extends BaseSampleForm {
	private final String[] tanggalSertifikat = new String[] {"20230101", "20230201", "20230301", "20230401", "20230501", "20230601", "20230701",
			"20230801", "20230901", "20231001", "20231101", "20231201"};
	private final String[] tanggalAwal = new String[] {"20230101", "20230201", "20230301", "20230401", "20230501", "20230601", "20230701",
			"20230801", "20230901", "20231001", "20231101", "20231201"};
	private final String[] tanggalAkhir = new String[] {"20240101", "20240201", "20240301", "20240401", "20240501", "20240601", "20240701",
			"20240801", "20240901", "20241001", "20241101", "20241201"};

	public SampleForm3100Uus(String folder, String periode, String ljk, String kodeKoreksi, int dataCount) {
		super(folder, periode, ljk, kodeKoreksi, dataCount);
	}

	@Override
	public String genFilename() {
		String filename = "LBPPNJU-3100-{0}-M-{1}-{2}-03.txt";
		return genFilename(filename);
	}

	@Override
	public void writeHeader(BufferedWriter writer) throws IOException {
		final String[] HEADER = new String[] { "H01", "030403", "{ljk}", "{periode}", "LBPPNJU", "3100",
				"{kodekoreksi}", "" };
		writeHeader(writer, HEADER);
	}

	@Override
	public void writeDetail(BufferedWriter writer) throws IOException {
		String[] detail = new String[] { "D01", "3100010000", "3", "4", "5", "6", "7", "8", "9", "10", "11",
				"12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22" };
		Random random = new Random();
		List<KeyValueString> dati2 = ER1135LokasiDati2.getObjects();
		List<KeyValueString> sektorEkonomi = ER1124SektorEkonomi.getObjects();
		List<KeyValueString> jenisPenjaminan = ER1185JenisPenjaminan.getObjects();
		List<KeyValueString> produkPenjaminan = ER1186ProdukPenjaminan.getObjects();
		List<KeyValueString> jenisPenerimaJaminan = ER1193JenisPenerimaJaminan.getObjects();
		int countNotPenjaminanNonProductif = 0;
		int countColumns = detail.length;
		for (int i = 0; i < dataCount; i++) {
			detail[2] = getRandomAlphaNumeric(random, 10, 20);
			detail[3] = getTanggal(tanggalSertifikat, random);
			detail[4] = getRandomAlphaNumeric(random, 10, 100);
			detail[5] = getRandomNumeric(random, 18, 20);
			detail[6] = getReference(sektorEkonomi, random);
			String codeJenisPenjaminam = getReference(jenisPenjaminan, random);
			if (!codeJenisPenjaminam.equals(ER1185JenisPenjaminan.R_14.getKey())) {
				countNotPenjaminanNonProductif++;
			}
			detail[7] = codeJenisPenjaminam;
			detail[8] = getReference(produkPenjaminan, random);
			detail[9] = getRandomAlphaNumeric(random, 10, 100);
			detail[10] = getReference(jenisPenerimaJaminan, random);
			detail[11] = getReference(dati2, random);
			detail[12] = getTanggal(tanggalAwal, random);
			detail[13] = getTanggal(tanggalAkhir, random);
			detail[14] = getRandomNumeric(random, 10, 16);
			detail[15] = getRandomNumeric(random, 10, 16);
			detail[16] = getRandomNumeric(random, 10, 16);
			detail[17] = getRandomNumeric(random, 10, 16);
			detail[18] = getRandomNumeric(random, 10, 16);
			detail[19] = getRandomNumeric(random, 10, 16);
			detail[20] = getRandomNumeric(random, 10, 16);
			detail[21] = getRandomNumeric(random, 10, 16);
			for (int j = 0; j < detail.length; j++) {
				writer.append(detail[j]);
				if (j < countColumns - 1) {
					writer.append('|');
				}
			}
			writer.newLine();
			writer.flush();
		}
		System.out.println("countNotPenjaminanNonProductif=" + countNotPenjaminanNonProductif);
		System.out.println("countPenjaminanNonProductif=" + (dataCount - countNotPenjaminanNonProductif));
	}
	
	private String getReference(List<KeyValueString> references, Random random) {
		int idx = getRandomInt(random, 0, references.size());
		return references.get(idx).getKey();
	}
	
	private String getTanggal(String[] tanggal, Random random) {
		int idx = getRandomInt(random, 0, tanggal.length);
		return tanggal[idx];
	}
}
