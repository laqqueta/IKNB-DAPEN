package id.go.ojk.client.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple3;
import id.go.ojk.lib.client.util.CrLfType;
import id.go.ojk.lib.client.util.CustomBufferedReader;

public class SaveMapValue {
	private final Logger logger = LoggerFactory.getLogger(SaveMapValue.class);
	protected SubmissionFormat submissionFormat;
	protected File file;

	public SaveMapValue(ProgressSegment progressSegment, File file) {
		this.submissionFormat = progressSegment.getSubmissionFormat();
		this.file = file;
	}
	
	public Map<String, Map<String, String>> getMapping() {
		Map<String, Map<String, String>> res = new HashMap<>();
		try (InputStream inputStream = new FileInputStream(file);
				CustomBufferedReader bufferedReader = new CustomBufferedReader(new InputStreamReader(inputStream));) {
			Tupple3<Long, String, CrLfType> positionLine = null;
			int rowCounter = 1;
			SaveMapParam saveMapParam = getSaveMapParam();
			while ((positionLine = bufferedReader.readLineWithStartPosition()) != null) {
				ValidationResult validationResult = new ValidationResult(1, rowCounter, positionLine);
				if (!saveMapParam.isEmpty() && submissionFormat.getFields().size() == validationResult.getColumnLength() && 
						validationResult.isDetail()) {
					res.put(getKeyMapping(validationResult, saveMapParam), getValueMapping(validationResult, saveMapParam.getArrField()));
				}
				rowCounter++;
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return res;
	}
	
	protected SaveMapParam getSaveMapParam() {
		return new SaveMapParam(submissionFormat.getSavePos());
	}
	
	protected String getKeyMapping(ValidationResult validationResult, SaveMapParam saveMapParam) {
		String posCode = validationResult.getColumn(1);
		String res = posCode;
		try {
			String[] arrPosCode = saveMapParam.getArrPosCode();
			if (arrPosCode != null) {
				for (String multiKeyCode : arrPosCode) {
					if (posCode.contains(multiKeyCode)) {
						res =  res + "-"+ validationResult.lineNumber;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return res;
	}
	
	private Map<String, String> getValueMapping(ValidationResult validationResult, String[] arrField) {
		Map<String, String> res = new HashMap<>();
		for (String field : arrField) {
			res.put(field, validationResult.getColumn(Integer.parseInt(field)));
		}
		return res;
	}
	
	protected class SaveMapParam {
		private String field;
		private String[] arrField;
		private String posCode;
		private String[] arrPosCode;
		
		public SaveMapParam(String saveMapParam) {
			if (StringUtils.isNotEmpty(saveMapParam)) {
				String[] arrSaveMapParam = StringUtils.isNotEmpty(saveMapParam) ? StringUtils.split(saveMapParam, "&") : null;
				int length = arrSaveMapParam.length;
				if (length > 0) {
					setField(arrSaveMapParam[0]);
				}
				if (length > 1) {
					setPosCode(arrSaveMapParam[1]);
				}
			}
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
			this.arrField = StringUtils.isNotEmpty(field) ? StringUtils.split(field, "|") : null;
		}
		
		public String[] getArrField() {
			return arrField;
		}

		public String getPosCode() {
			return posCode;
		}
		
		public void setPosCode(String posCode) {
			this.posCode = posCode;
			this.arrPosCode = StringUtils.isNotEmpty(posCode) ? StringUtils.split(posCode, "|") : null;
		}
		
		public String[] getArrPosCode() {
			return arrPosCode;
		}
		
		public boolean isEmpty() {
			return !StringUtils.isNoneEmpty(field, posCode);
		}
	}
}
