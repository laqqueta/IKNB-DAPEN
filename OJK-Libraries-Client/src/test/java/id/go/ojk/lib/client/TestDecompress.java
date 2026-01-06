package id.go.ojk.lib.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.compressors.CompressorException;

import id.go.ojk.lib.client.model.compression.ArchiveResult;
import id.go.ojk.lib.client.model.compression.FileIntegrity;

public class TestDecompress {

	public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException, CompressorException{
		
		File sourceDir = new File("D:\\_workspace\\wdg\\ojk\\v1.0.0\\OJK-ASRJK\\OJK-ASRJK-Client\\report\\pelaporan\\selesai\\RBAJK.01.2000000011.20200817085300429\\siap-kirim");
		File destDir = new File("D:\\__test\\tmp");
		
		String submissionId = "RBASRJK-R-A-20191231-2000000011-01";
		TestDecompress test = new TestDecompress();
		test.deCompress(submissionId, sourceDir, destDir);
	}
	
	private void deCompress(String submissionId, File sourceFolder, File destinationFolder) throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException, CompressorException {
		List<FileIntegrity> fileIntegrities = SubmissionFileUtil.getZipChunkFileIntegrityOrdered(submissionId, sourceFolder);
//		String key = "vFMRJaxD+ABgz9V4oN/9AVn50jC0pJqLthMYQjMDQVs=";
//		String key = "pGDqjLg1cPrZLNZWYa8rYrMXEqtmlaoBiSR+PywhTkY=";
		String key = getAesKey(submissionId, sourceFolder);
		ArchiveResult archiveResult = ArchiveUtil.deArchiveChecksumDecryptDecompress(fileIntegrities, key, destinationFolder);
		System.out.println(archiveResult.getHash());
	}
	
	private String getAesKey(String submisstionId, File sourceFolder) {
		String res = "";
		String signatureTxtFile = submisstionId + ".signature.part0";
		
		try (FileReader fileReader = new FileReader(sourceFolder.getAbsolutePath() + File.separator + signatureTxtFile);
				BufferedReader bufferedReader = new BufferedReader(fileReader);) {
			int idx = 0;
			String line = bufferedReader.readLine();
			while (line != null) {
				if (idx == 1) {
					res = line.substring(11, 11 + 44);
					break;
				}
				idx++;
				line = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
}
