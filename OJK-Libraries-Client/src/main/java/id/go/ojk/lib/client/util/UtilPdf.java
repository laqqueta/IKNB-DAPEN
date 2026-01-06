package id.go.ojk.lib.client.util;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.icepdf.core.pobjects.Document;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class UtilPdf {

	public static boolean isPdf(final String pdfFile) {
		try (PDDocument document = Loader.loadPDF(new File(pdfFile))) {
            return document != null;
        } catch (IOException e) {
            return false;
        }
	}
	
	public static boolean validatePdf(final String pdfFile) {
		Document document = new Document();
		try {
            document.setFile(pdfFile);
            int pages = document.getNumberOfPages();
            log.debug("{} page count={}", pdfFile, pages);
            return true;
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
        } finally {
            document.dispose();
        }
		return false;
	}
}
