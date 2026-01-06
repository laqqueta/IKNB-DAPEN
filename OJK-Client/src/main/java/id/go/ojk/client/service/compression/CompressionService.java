package id.go.ojk.client.service.compression;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.compress.archivers.ArchiveException;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.service.base.BaseService;

public class CompressionService extends BaseService {

	public void compress(ProgressPreparationAndSending progressModel) throws IOException, ArchiveException, NoSuchAlgorithmException{
//		File destFile = new File(progressModel.getCompressionDir().getAbsoluteFile() + "/" + progressModel.getSubmissionId());
//		compress(progressModel, destFile);
	}

	public void compress(ProgressPreparationAndSending submissionProgressModel, File destFile) throws IOException, ArchiveException, NoSuchAlgorithmException{
//		destFile.getParentFile().mkdir();
//		long splitFileSize = appContext.getConfigService().getProperties(ConfigService.splitFileSize);
//		ProgressModel progressModel = submissionProgressModel.getCompressionProgressModel();
//		progressModel.setTotalLength(submissionProgressModel.getTotalFileSize());
//
//		List<FileIntegrity> sourceFiles =
//			submissionProgressModel.getSegments().stream()
//			.flatMap( e -> e.getSegmentFiles().stream())
//			.map(e -> e.getFileIntegrity()).collect(Collectors.toList());
//
//		CompressionResult compressionResult =  CompressionUtil.compress(progressModel, splitFileSize, sourceFiles, destFile);
//		submissionProgressModel.setCompressionResult(compressionResult);

	}




}
