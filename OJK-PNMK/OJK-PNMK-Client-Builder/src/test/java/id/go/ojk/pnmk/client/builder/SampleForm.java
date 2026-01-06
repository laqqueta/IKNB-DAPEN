package id.go.ojk.pnmk.client.builder;

public class SampleForm {

	public static void main(String[] args) {
		try {
			System.out.println("<start>");
			genForm();
//			genFormUus();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("<end>");
		}
	}
	
	private static void genFormUus() {
		String folder = "D:\\";
		String periode = "2023-07-31";
		String ljk = "2023071800";
		String kodeKoreksi = "0";//0 or 2
		String noSurat = "LBPNMU-2";
		genFormUus2400(folder, periode, ljk, kodeKoreksi, noSurat);
//		genFormUus2500(folder, periode, ljk, kodeKoreksi, noSurat);
	}
	
	private static void genFormUus2400(String folder, String periode, String ljk, String kodeKoreksi, String noSurat) {
		SampleFormUus2400 form = new SampleFormUus2400(folder, periode,ljk, kodeKoreksi, 15000000);
		form.setNoSurat(noSurat);
		form.genFile();
	}

	private static void genFormUus2500(String folder, String periode, String ljk, String kodeKoreksi, String noSurat) {
		SampleFormUus2500 form = new SampleFormUus2500(folder, periode,ljk, kodeKoreksi, 100);
		form.setNoSurat(noSurat);
		form.genFile();
	}
	
	private static void genForm() {
		String folder = "D:\\";
		String periode = "2023-04-30";
		String ljk = "2300000099";//"2023071800";
		String kodeKoreksi = "0";//0 or 2
		String noSurat = "23072012104776";
		genForm2400(folder, periode, ljk, kodeKoreksi, noSurat);
		genForm2500(folder, periode, ljk, kodeKoreksi, noSurat);
	}
	
	private static void genForm2400(String folder, String periode, String ljk, String kodeKoreksi, String noSurat) {
		SampleForm2400 form = new SampleForm2400(folder, periode,ljk, kodeKoreksi, 200000);
		form.setNoSurat(noSurat);
		form.genFile();
	}

	private static void genForm2500(String folder, String periode, String ljk, String kodeKoreksi, String noSurat) {
		SampleForm2500 form = new SampleForm2500(folder, periode,ljk, kodeKoreksi, 700000);
		form.setNoSurat(noSurat);
		form.genFile();
	}
}
