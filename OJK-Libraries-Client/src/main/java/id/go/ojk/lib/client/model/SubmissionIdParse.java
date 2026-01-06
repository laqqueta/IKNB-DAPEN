package id.go.ojk.lib.client.model;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.exception.SlikException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Builder
public class SubmissionIdParse {
	
	@Getter @Setter private String memberTypeCode;
	@Getter @Setter private String memberCode;
	@Getter @Setter private String yyyyMMddHHmmssSSS;
	
	@Tolerate
	public SubmissionIdParse(){
	}
	
	//~ static
	
	public static SubmissionIdParse fromStringThrowExceptionIfNotValid(String submissionId){
		Tupple2<SubmissionIdParse, String> submissionIdParseTupple = SubmissionIdParse.fromString(submissionId);
		if ( StringUtils.isNotEmpty(submissionIdParseTupple.getB()) ){
			throw new SlikException(submissionIdParseTupple.getB() + " submissionId " + submissionId);
		}
		return submissionIdParseTupple.getA();
	}
	
	public static Tupple2<SubmissionIdParse, String> fromString(String submissionId){
		String[] submissionIdSplited = submissionId.split("[.]");
		if ( submissionIdSplited.length != 3 ){
			return Tupple2.<SubmissionIdParse, String>builder()
					.a(null)
					.b("Format submissionid salah")
					.build();
		}		
		SubmissionIdParse result = SubmissionIdParse.builder()
			.memberTypeCode(submissionIdSplited[0])
			.memberCode(submissionIdSplited[1])
			.yyyyMMddHHmmssSSS(submissionIdSplited[2])
			.build();
		
		return Tupple2.<SubmissionIdParse, String>builder()
				.a(result)
				.b(null)
				.build();
	}
	
	public boolean isMatch(String memberTypeCode, String memberCode){
		return StringUtils.equals(this.memberTypeCode, memberTypeCode) && StringUtils.equals(this.memberCode, memberCode);
	}
}
