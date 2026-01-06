package id.go.ojk.pnmk.client.builder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.model.KeyValueString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseSampleForm implements ISampleForm {
	protected final String folder;
	protected final String periode;
	protected final String ljk;
	protected final String kodeKoreksi;
	protected final int dataCount;
	protected String noSurat;

	protected BaseSampleForm(String folder, String periode, String ljk, String kodeKoreksi, int dataCount) {
		this.folder = folder;
		this.periode = periode;
		this.ljk = ljk;
		this.kodeKoreksi = kodeKoreksi;
		this.dataCount = dataCount;
	}

	public void setNoSurat(String noSurat) {
		this.noSurat = noSurat;
	}
	
	@Override
	public void genFile() {
		String fullFilename = folder + genFilename();
		log.info("-write file {}- ", fullFilename);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullFilename, false))) {
			writeHeader(writer);
			writeDetail(writer);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	protected String genFilename(String filename) {
		filename = StringUtils.replace(filename, "{0}", kodeKoreksi.equals("0") ? "R" : "K");
		filename = StringUtils.replace(filename, "{1}", StringUtils.replace(periode, "-", ""));
		filename = StringUtils.replace(filename, "{2}", ljk);
		return filename;
	}
	
	public void writeHeader(BufferedWriter writer, String[] defaultHeader) throws IOException {
		writer.append(defaultHeader[0]).append('|');
		writer.append(defaultHeader[1]).append('|');
		writer.append(ljk).append('|');
		writer.append(periode).append('|');
		writer.append(defaultHeader[4]).append('|');
		writer.append(defaultHeader[5]).append('|');
		writer.append(kodeKoreksi).append('|');
		writer.append(kodeKoreksi.equals("2") ? noSurat : "");
		writer.newLine();
		writer.flush();
	}

	protected int resetIdx(int current, int max) {
		return current >= max ? 0 : current + 1;
	}

	protected String getNama(String nama, int idx) {
		return nama + "-" + idx;
	}

	protected String getDati1(String dati2) {
		return dati2.substring(0, 6);
	}

	protected String getReferenceCode(List<KeyValueString> source, int idx) {
		KeyValueString res = source.get(idx);
		return res.getKey();
	}

	protected String getUuid() {
		return StringUtils.replace(UUID.randomUUID().toString(), "-", "").substring(0, 30);
	}

	protected String getRandomInt(Random random) {
		return String.valueOf(random.nextInt(Integer.MAX_VALUE));
	}
}
