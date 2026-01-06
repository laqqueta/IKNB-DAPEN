package id.go.ojk.decrypt;

import java.util.Base64;

import id.go.ojk.conf.client.BaseExtract;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OjkDecrypt extends BaseExtract {
	
	public static void main(String[] args) {
		String submissionId = BaseExtract.getParameterSubmissionId(args);
		String sourceFolder = BaseExtract.getParameterSourceFolder(args);
		String privateKeyFile = BaseExtract.getParameterPrivateKeyFile(args);
		String destinationFolder = BaseExtract.getParameterDestinationFolder(args);
		OjkDecrypt extract = new OjkDecrypt();
		try {
//			extract.extract(submissionId, privateKeyFile, sourceFolder, destinationFolder);
			extract.decryptSignature();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	private void decryptSignature() throws Exception {
		String privateKey = "D:\\b64private.key";
		privateKey = "D:\\_workspace\\_other\\ojk\\OJK-BPRK-CLIENT\\main\\OJK-BPRK-Client-Launcher\\build\\build\\src\\rsaPrivate.key";
		String signature = "D:\\_workspace\\_other\\ojk\\IKNBClient\\IKNBClient-v3\\OJK-LPEI\\Pelaporan\\selesai\\LBLPIG.01.2400000099.20250616070126984\\siap-kirim\\LBLPEIG-R-M-20251231-2400000099-01.signature.part1";
		signature = "C:\\BPRKClient\\Pelaporan\\selesai\\KSBPRS.02.609999.20250630080853019\\siap-kirim\\TKSBPRSS-K-S-20241231-609999-02.signature.part1";
		byte[] res = decryptSignature(privateKey, signature);
		System.out.println("result=" + Base64.getEncoder().encodeToString(res));
	}
}
