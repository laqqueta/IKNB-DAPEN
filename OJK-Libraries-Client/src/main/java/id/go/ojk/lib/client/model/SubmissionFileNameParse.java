package id.go.ojk.lib.client.model;

import org.apache.commons.lang3.math.NumberUtils;

import id.go.ojk.lib.client.model.Tupple2;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Builder
public class SubmissionFileNameParse {
	
	@Getter @Setter private String memberTypeCode;
	@Getter @Setter private String memberCode;
	@Getter @Setter private String year;
	@Getter @Setter private String month;
	@Getter @Setter private String formatCode;
	@Getter @Setter private int sequence;
	@Getter @Setter private String ext;
	
	@Tolerate
	public SubmissionFileNameParse(){
	}	
	
	//~ static
	
	public static Tupple2<SubmissionFileNameParse, String> fromFileName(String filename){
		String[] filenameSplited = filename.split("[.]");
		if ( filenameSplited.length != 7 ){
			return Tupple2.<SubmissionFileNameParse, String>builder()
					.a(null)
					.b("Format nama file salah")
					.build();
		}
		int sequence = NumberUtils.toInt(filenameSplited[5], -1);
		if ( sequence == -1 ){
			return Tupple2.<SubmissionFileNameParse, String>builder()
					.a(null)
					.b("Format nama file salah, sequence harus numeric dan > 0")
					.build();
		}
		SubmissionFileNameParse result = SubmissionFileNameParse.builder()
			.memberTypeCode(filenameSplited[0])
			.memberCode(filenameSplited[1])
			.year(filenameSplited[2])
			.month(filenameSplited[3])
			.formatCode(filenameSplited[4])
			.sequence(sequence)
			.ext(filenameSplited[6])
			.build();
		
		return Tupple2.<SubmissionFileNameParse, String>builder()
				.a(result)
				.b(null)
				.build();
	}
	
}
