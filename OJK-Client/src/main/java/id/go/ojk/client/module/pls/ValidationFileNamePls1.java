package id.go.ojk.client.module.pls;

import java.io.File;
import java.util.List;

import id.go.ojk.client.constant.EValidExtension;
import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.module.ValidationFileName1;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;

public class ValidationFileNamePls1 extends ValidationFileName1 {

	public ValidationFileNamePls1(List<File> files, ReportInfo reportInfo) {
		super(files, reportInfo);
	}

	public ValidationFileNamePls1(List<File> files, ReportInfo reportInfo, ReadSubmissionDirModel readDirModel) {
		super(files, reportInfo, readDirModel);
	}

	@Override
	protected boolean validateExtention(ValidFile validFile, List<String> listError) {
		boolean res = false;
		EValidExtension validExtension = getValidExtension();
		String extension = validFile.getExtension();
		List<String> listExtension = validExtension.getExtension();
		for (int i = 0; i < listExtension.size(); i++) {
			if ((res = extension.equalsIgnoreCase(listExtension.get(i)))) {
				break;
			}
		}
		if (!res) {
			listError.add(String.format("File '%S' ekstensi harus %S", validFile.getFullFileName(),
					validExtension.getExtensionAsString("atau")));
		}
		return res;
	}
	
	private EValidExtension getValidExtension() {
		return reportInfo.getReportGroup().getValidExtension();
	}
}
