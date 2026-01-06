package id.go.ojk.client.model.bind;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import lombok.Setter;

public class ProgressSegment {

	private SubmissionFormat submissionFormat;
	private Long totalRow;
	@Getter @Setter private GridPane pane;

	private List<ProgressSegmentFile> segmentFiles = new ArrayList<ProgressSegmentFile>();

	public ProgressSegment(){
	}

	public ProgressSegment(SubmissionFormat submissionFormat, List<ProgressSegmentFile> segmentFiles){
		setSubmissionFormat(submissionFormat);
		setSegmentFiles(segmentFiles);
	}

	//~ other method

	public long getTotalError(){
		return segmentFiles.stream().mapToLong(ProgressSegmentFile::getTotalError).sum();
	}

	//~ segmentFiles

	public void addSegmentFiles(ProgressSegmentFile segmentFile) {
		this.segmentFiles.add(segmentFile);
	}

	public List<ProgressSegmentFile> getSegmentFiles() {
		return segmentFiles;
	}

	public void setSegmentFiles(List<ProgressSegmentFile> segmentFiles) {
		this.segmentFiles = segmentFiles;
	}

	public int getTotalFile(){
		return segmentFiles == null ? 0 : segmentFiles.size();
	}

	public long getTotalFileSize(){
		return segmentFiles == null ? 0l : segmentFiles.stream().mapToLong(ProgressSegmentFile::getFileSize).sum();
	}

	public long getTotalProcessedSize(){
		return segmentFiles == null ? 0l : segmentFiles.stream().mapToLong(ProgressSegmentFile::getProcessedSize).sum();
	}

	public Long getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(Long totalRow) {
		this.totalRow = totalRow;
	}

	//~submissionFormat

	public SubmissionFormat getSubmissionFormat() {
		return submissionFormat;
	}

	public void setSubmissionFormat(SubmissionFormat submissionFormat) {
		this.submissionFormat = submissionFormat;
	}


}
