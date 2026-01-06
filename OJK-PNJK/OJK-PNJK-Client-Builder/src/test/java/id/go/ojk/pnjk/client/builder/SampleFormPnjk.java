package id.go.ojk.pnjk.client.builder;

public class SampleFormPnjk {

	public static void main(String[] args) {
		try {
			System.out.println("<start>");
			genForm();
			genFormUus();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("<end>");
		}
	}

	private static void genFormUus() {
		String folder = "D:\\";
		String periode = "2024-11-30";
		String ljk = "200000PNJK";
		String kodeKoreksi = "2";// 0, 1 or 2
		String noSurat = "LBPNJU-20241130";
		genFormUus3100(folder, periode, ljk, kodeKoreksi, noSurat);
//		genFormUus3300A(folder, periode, ljk, kodeKoreksi, noSurat);
//		genFormUus3300B(folder, periode, ljk, kodeKoreksi, noSurat);
	}

	private static void genFormUus3100(String folder, String periode, String ljk, String kodeKoreksi, String noSurat) {
		SampleForm3100Uus form = new SampleForm3100Uus(folder, periode, ljk, kodeKoreksi, 2000000);
		form.setNoSurat(noSurat);
		form.genFile();
	}

	private static void genFormUus3300A(String folder, String periode, String ljk, String kodeKoreksi, String noSurat) {
		SampleForm3300AUus form = new SampleForm3300AUus(folder, periode, ljk, kodeKoreksi, 25000);
		form.setNoSurat(noSurat);
		form.genFile();
	}

	private static void genFormUus3300B(String folder, String periode, String ljk, String kodeKoreksi, String noSurat) {
		SampleForm3300BUus form = new SampleForm3300BUus(folder, periode, ljk, kodeKoreksi, 15000);
		form.setNoSurat(noSurat);
		form.genFile();
	}

	private static void genForm() {
		String folder = "D:\\";
		String periode = "2024-11-30";
		String ljk = "200000PNJK";
		;
		String kodeKoreksi = "2";// 0, 1 or 2
		String noSurat = "LBPNJK-20241130";
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
