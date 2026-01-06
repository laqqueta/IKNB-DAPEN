package id.go.ojk.lib.client;

import java.io.IOException;

import id.go.ojk.lib.client.util.UtilPdf;

public class SamplePdf {

	public static void main(String[] args) {
		try {
			System.out.println("<start>");
			checkPdf();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("<end>");
		}
	}

	private static void checkPdf() throws IOException {
		String filename = "D:\\application.pdf";
		String filename2 = "D:\\Anabatic-Technical Intro_17Jun22.pdf";
		String filename3 = "D:\\myTmp.pdf";
		boolean res = UtilPdf.isPdf(filename3);
//		boolean res = UtilPdf.validatePdf(filename);
		System.out.println("res=" + res);
	}
}
