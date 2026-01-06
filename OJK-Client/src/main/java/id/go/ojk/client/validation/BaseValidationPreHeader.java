package id.go.ojk.client.validation;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

public abstract class BaseValidationPreHeader extends BaseValidationContent {
	protected int sumRow;
	
	protected BaseValidationPreHeader(int sumRow, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		super(submissionFormat, validationResult);
		this.sumRow = sumRow;
	}
	
	protected void sumRow(ValidationResult validationResult) {
		// validasi jumlah baris
		if (submissionFormat.getMaxRow() != null) {
			if (sumRow != (submissionFormat.getMinRow() + 1) && !submissionFormat.getCode().equals("0008")) {
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_21_FILE_ROWCOUNT,
						(sumRow), (submissionFormat.getMinRow() + 1)));
			}
			SubmissionFormat.setHeaders(validationResult.rowSplited);
			
			String periodeSplit[] = validationResult.getColumn(3).split("[-]");
			if (submissionFormat.getCode().equals("0008") && periodeSplit.length == 3) {
				Integer periodeMonth = Integer.parseInt(periodeSplit[1]);					
				if((periodeMonth % 3) == 0) {
					if (submissionFormat.getTotalRow() <= 1) {
						String msg = "karena merupakan laporan triwulanan";
						validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_24_HEADER_WITH_DATA, msg));
					}
				} else {
					if (submissionFormat.getTotalRow() > 1) {
						String msg = "karena bukan merupakan laporan triwulanan";
						validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_23_HEADER_NO_DATA, msg));
					}
				}
			}
		} else {			
			if (sumRow < 1 && submissionFormat.getMinRow() == 0) {
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_21_FILE_ROWCOUNT,
						(sumRow), (submissionFormat.getMinRow() + 1)));
			}
			
			if (submissionFormat.getCode().equals("0900") || submissionFormat.getCode().equals("1000") || submissionFormat.getCode().equals("1400")) {
				Integer officeCount = SubmissionFormat.listRincianKantor.size();
				Integer requireRow = officeCount * submissionFormat.getMinRow();
				
				if (sumRow < (requireRow + 1)) {
					validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_22_MIN_ROWCOUNT, requireRow));
				}
			} else if (submissionFormat.getCode().equals("0100") || submissionFormat.getCode().equals("0101") || submissionFormat.getCode().equals("0200")) {
				Integer officeCount = SubmissionFormat.listRincianKantor.size() + 1; // Plus sandi gabungan
				Integer requireRow = officeCount * submissionFormat.getMinRow();
				
				if (sumRow < (requireRow + 1)) {
					validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_22_MIN_ROWCOUNT, requireRow));
				}
			} else if (sumRow < (submissionFormat.getMinRow() + 1) && submissionFormat.getMinRow() > 0) {
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_22_MIN_ROWCOUNT,
						submissionFormat.getMinRow()));
			}
			
			if (submissionFormat.getCode().equals("0901") || submissionFormat.getCode().equals("1401")) {
				String formCode = submissionFormat.getCode().substring(0, 2);
				if (SubmissionFormat.tempOtherCondition != null) {
					if(SubmissionFormat.tempOtherCondition && submissionFormat.getTotalRow() <= 1) {
						String msg = "karena nilai pos Lainnya pada form " + formCode + " >= 25% dari total kolom Jumlah pada form " + formCode;
						validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_24_HEADER_WITH_DATA, msg));
					} 
					
					if(!SubmissionFormat.tempOtherCondition && submissionFormat.getTotalRow() > 1) {
						String msg = "karena nilai pos Lainnya pada form " + formCode + " <= 25% dari total kolom Jumlah pada form " + formCode;
						validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_23_HEADER_NO_DATA, msg));
					}
				}
			}
		}
	}
}
