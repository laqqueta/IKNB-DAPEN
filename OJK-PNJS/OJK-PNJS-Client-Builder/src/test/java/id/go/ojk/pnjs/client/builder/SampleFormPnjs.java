package id.go.ojk.pnjs.client.builder;

public class SampleFormPnjs {

	public static void main(String[] args) {
		try {
			System.out.println("<start>");
			genForm();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("<end>");
		}
	}

	private static void genForm() {
		String folder = "D:\\";
		String periode = "2024-01-31";
		String ljk = "2600000099";
		;
		String kodeKoreksi = "0";// 0, 1 or 2
		String noSurat = "LBPNJS-20240131";
		genForm3100(folder, periode, ljk, kodeKoreksi, noSurat);
//		genForm3300A(folder, periode, ljk, kodeKoreksi, noSurat);
//		genForm3300B(folder, periode, ljk, kodeKoreksi, noSurat);
	}

	private static void genForm3100(String folder, String periode, String ljk, String kodeKoreksi, String noSurat) {
		SampleForm3100 form = new SampleForm3100(folder, periode, ljk, kodeKoreksi, 2000000);
		form.setNoSurat(noSurat);
		form.genFile();
	}

	private static void genForm3300A(String folder, String periode, String ljk, String kodeKoreksi, String noSurat) {
		SampleForm3300A form = new SampleForm3300A(folder, periode, ljk, kodeKoreksi, 25000);
		form.setNoSurat(noSurat);
		form.genFile();
	}

	private static void genForm3300B(String folder, String periode, String ljk, String kodeKoreksi, String noSurat) {
		SampleForm3300B form = new SampleForm3300B(folder, periode, ljk, kodeKoreksi, 15000);
		form.setNoSurat(noSurat);
		form.genFile();
	}
}
