package id.go.ojk.client.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.client.service.base.BaseService;
import id.go.ojk.lib.client.DateUtil;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.SetupHeader;
import id.go.ojk.lib.client.model.compression.MemoryFile;
import id.go.ojk.lib.client.model.config.Config;
import id.go.ojk.lib.client.model.config.MessageConfig;
import id.go.ojk.lib.client.model.reference.ReferenceHeader;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

public abstract class ReferenceServiceBase extends BaseService implements ReferenceService {

	public static final String fileName_header		= "header.xml";
	public static final String fileName_errorCodes	= "errorCodes.xml";
	public static final String fileName_config 		= "config.xml";
	public static final String fileName_message 	= "message.xml";

	@Override
	public void initialize() {
		try {
			loadReference();
		} catch (NoSuchAlgorithmException | ArchiveException | IOException e) {
			throw new SlikException("Fail load reference", e);
		}
	}

	//~ method

	@Override
	public String getVersion(){
		return referenceHeader.getVersion();
	}

	@Override
	public LocalDateTime getLastModified(){
		return DateUtil.parseLocalDateTime(referenceHeader.getLastModified());
	}
	
	@Override
	public void validate(SubmissionField field, String code, List<Integer> referenceNumbers, List<ValidationError> errors){
		if ( referenceNumbers.size() == 1 ){
			validate(field, code, referenceNumbers.get(0), errors);
		} else {
			boolean valid = false;
			for (Integer referenceNumber : referenceNumbers) {
				ImmutableList<String> references = referenceDataList.get(referenceNumber);
				if( references == null ){
					errors.add(new ValidationError(field, ValidationErrorCode.E12_00_REFERENCE, referenceNumber));
					return;
				}
				if (StringUtils.isEmpty(code)) {
					errors.add(new ValidationError(field, ValidationErrorCode.E13_00_MANDATORY));
					return;
				}
				if ( references.indexOf(code) >= 0 ){
					valid = true;
					break;
				}
			}
			if ( !valid ){
				errors.add(
					new ValidationError(
						field, ValidationErrorCode.E12_01_REFERENCE, 
						referenceNumbers.stream().map(e -> referenceDescriptions.get(e)).collect(Collectors.joining(", "))
					)
				);
				return;
			}
		}
	}

	private void validate(SubmissionField field, String code, Integer referenceNumber, List<ValidationError> errors){
		ImmutableList<String> references = referenceDataList.get(referenceNumber);
		if( references == null ){
			errors.add(new ValidationError(field, ValidationErrorCode.E12_00_REFERENCE, referenceNumber));
			return;
		}
		if (StringUtils.isEmpty(code)) {
			errors.add(new ValidationError(field, ValidationErrorCode.E13_00_MANDATORY));
			return;
		}
		if ( references.indexOf(code) < 0 ){
			String errorMessage = referenceErrorMessage.get(referenceNumber);
			if ( errorMessage != null ){
				errors.add(new ValidationError(field, ValidationErrorCode.E12_02_REFERENCE, errorMessage));
			} else {
				errors.add(new ValidationError(field, ValidationErrorCode.E12_01_REFERENCE, referenceDescriptions.get(referenceNumber)));				
			}
			return;
		}
	}
	
	//========================
	
	@Override
	public void validatePerSegment(SubmissionField field, String code, String segmentCode, List<Integer> referenceNumbers, List<ValidationError> errors){
		if ( referenceNumbers.size() == 1 ){
			validatePerSegment(field, code, segmentCode, referenceNumbers.get(0), errors);
		} else {
			throw new SlikException("validatePerSegment dengan multi reference belum di implementasikan");
		}
	}

	private void validatePerSegment(SubmissionField field, String code, String segmentCode, Integer referenceNumber, List<ValidationError> errors){
		Map<String, List<String>> segmentReferences = referenceDataSegmentList.get(referenceNumber);
		List<String> references = segmentReferences == null ? null : segmentReferences.get(segmentCode);		
		if( references == null ){
			errors.add(new ValidationError(field, ValidationErrorCode.E12_00_REFERENCE, referenceNumber));
			return;
		}
		if (StringUtils.isEmpty(code)) {
			errors.add(new ValidationError(field, ValidationErrorCode.E13_00_MANDATORY));
			return;
		}
		if ( references.indexOf(code) < 0 ){
			String errorMessage = referenceErrorMessage.get(referenceNumber);
			if ( errorMessage != null ){
				errors.add(new ValidationError(field, ValidationErrorCode.E12_02_REFERENCE, errorMessage));
			} else {
				errors.add(new ValidationError(field, ValidationErrorCode.E12_01_REFERENCE, referenceDescriptions.get(referenceNumber)));				
			}
			return;
		}
	}
	
	//========================
	
	
	@Override
	public void validateLabel1(SubmissionField field, String code, String label1, Integer referenceNumber, List<ValidationError> errors){
		ImmutableMap<String, String> references = referenceDataLabel1.get(referenceNumber);
		if( references == null ){
			errors.add(new ValidationError(field, ValidationErrorCode.E12_00_REFERENCE, referenceNumber));
			return;
		}
		
		String refLabel1 = references.get(code);

		if ( refLabel1 == null || !StringUtils.equals(refLabel1, label1) ){
			String errorMessage = referenceErrorMessage.get(referenceNumber);
			if ( errorMessage != null ){
				errors.add(new ValidationError(field, ValidationErrorCode.E12_02_REFERENCE, errorMessage));
			} else {
				errors.add(new ValidationError(field, ValidationErrorCode.E12_01_REFERENCE, referenceDescriptions.get(referenceNumber)));				
			}
			return;
		}
	}

	@Override
	public String getLabel(Integer referenceNumber, int labelNumber, String key){
		ImmutableMap<String, String> keyLabel = null;
		if (labelNumber == 0) {
			keyLabel = referenceDataLabel1.get(referenceNumber);
		} else if ( labelNumber == 1 ){
			keyLabel = referenceDataLabel2.get(referenceNumber);
		}
		return keyLabel == null ? null : keyLabel.get(key);
	}
	
	private ReferenceMetadata getReferenceMetadata(int refNumber){
		return referenceMetadatas.get(refNumber);
	}
	
	@Override
	public String getLabel1Description(int refNumber, String label1){
		ReferenceMetadata referenceMetadata = getReferenceMetadata(refNumber);
		if ( referenceMetadata == null )
			return label1;
		return referenceMetadata.getLabel1Description(label1);
	}

	//~ load

	protected ReferenceHeader referenceHeader;
	protected ImmutableMap<Integer, ReferenceMetadata> referenceMetadatas;
	protected ImmutableMap<Integer, String> referenceDescriptions;
	protected ImmutableMap<Integer, String> referenceErrorMessage;
	protected ImmutableMap<Integer, ImmutableList<String>> referenceDataList;
	
	protected ImmutableMap<Integer, Map<String, List<String>>> referenceDataSegmentList;
	protected ImmutableMap<Integer, Map<String, String>> referenceKeyValue;
	
	protected ImmutableMap<Integer, ImmutableMap<String, String>> referenceDataLabel1;
	protected ImmutableMap<Integer, ImmutableMap<String, String>> referenceDataLabel2;
	protected Map<String, String> configXml = new HashMap<>();
	protected Map<String, String> messageXml = new HashMap<>();

	protected abstract void loadReference() throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException;
	
	protected void loadReference(Map<String, MemoryFile> memoryFileMap) throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException{
		loadReferenceHeader(memoryFileMap);
		loadReferenceDataList(memoryFileMap);

		//Error code message
		MemoryFile memoryFile = memoryFileMap.get(fileName_errorCodes);
		if( memoryFile != null ){
			Map<String, ValidationErrorCode> errorCodeMapFromFile = readErrorCodes(memoryFile.getContent());
			for (Entry<String, ValidationErrorCode> entry : ValidationErrorCode.getMap().entrySet()) {
				ValidationErrorCode errorCodeFromFile = errorCodeMapFromFile.get(entry.getKey());
				if ( errorCodeFromFile != null ){
					entry.getValue().setMessageFormat(errorCodeFromFile.getMessageFormat());
				}
			}
		}
		
		//config
		MemoryFile configMemoryFile = memoryFileMap.get(fileName_config);
		if( configMemoryFile != null ){
			configXml = readConfig(configMemoryFile.getContent());
		}
		
		//message
		MemoryFile messageMemoryFile = memoryFileMap.get(fileName_message);
		if( messageMemoryFile != null ){
			messageXml = readConfig(messageMemoryFile.getContent());
		}
		
	}

	protected void loadReferenceHeader(Map<String, MemoryFile> memoryFileMap) {
		referenceHeader = readHeader(memoryFileMap.get(fileName_header).getContent());

		Builder<Integer, ReferenceMetadata> builder0 = new Builder<>();
		Builder<Integer, String> builder = new Builder<>();
		Builder<Integer, String> builder2 = new Builder<>();
		for (ReferenceMetadata referenceMetadata : referenceHeader.getReferenceMetadatas()) {
			builder0.put(referenceMetadata.getNumber(), referenceMetadata);
			builder.put(
				referenceMetadata.getNumber(),
				referenceMetadata.getDescription()
			);
			if (StringUtils.isNotEmpty(referenceMetadata.getErrorDescription())){
				builder2.put(
						referenceMetadata.getNumber(),
						referenceMetadata.getErrorDescription()
					);				
			}
		}
		referenceMetadatas = builder0.build();
		referenceDescriptions = builder.build();
		referenceErrorMessage = builder2.build();
	}

	protected void loadReferenceDataList(Map<String, MemoryFile> memoryFileMap) throws FileNotFoundException, IOException{
		Builder<Integer, ImmutableList<String>> builder = new Builder<>();
		Builder<Integer, Map<String, String>> builderKeyValue = new Builder<>();
		
		Builder<Integer, Map<String, List<String>>> builderPersegment = new Builder<>();
		
		//protected ImmutableMap<Integer, ImmutableMap<String, ImmutableList<String>>> referenceDataSegmentList;
		
		Builder<Integer, ImmutableMap<String, String>> builderLabel1 = new Builder<>();
		Builder<Integer, ImmutableMap<String, String>> builderLabel2 = new Builder<>();

		for (ReferenceMetadata referenceMetadata : referenceHeader.getReferenceMetadatas()) {

			String fileName = "R" + referenceMetadata.getNumber() + referenceMetadata.getName() + ".xml";
			List<KeyValueString> references = null;
			if ( fileName.equals(SetupService.fileName_R3Branch) ){
				continue;
				//references = appContext.getSetupService().getBranchReference();
			} else {
				references = readReferences(memoryFileMap.get(fileName).getContent());
			}
			builderKeyValue.put(referenceMetadata.getNumber(), listToMap(references));
			if ( referenceMetadata.isPerSegment() ){
				builderPersegment.put(
					referenceMetadata.getNumber(), 
					readReferencePerSegmentList(references)
				);
			} else {
				builder.put(
					referenceMetadata.getNumber(),
					readReferencesList(references)
				);				
			}

			if (referenceMetadata.getType() == ReferenceType.keyValueLabel1){
				builderLabel1.put(
					referenceMetadata.getNumber(),
					readReferencesListLabel(references, 0)
				);
			} else if ( referenceMetadata.getType() == ReferenceType.keyValueLabel2 ) {
				builderLabel1.put(
					referenceMetadata.getNumber(),
					readReferencesListLabel(references, 0)
				);
				builderLabel2.put(
					referenceMetadata.getNumber(),
					readReferencesListLabel(references, 1)
				);				
			}

		}
		loadBranch(builder);

		referenceKeyValue = builderKeyValue.build();
		referenceDataList = builder.build();
		referenceDataSegmentList = builderPersegment.build();
		referenceDataLabel1 = builderLabel1.build();
		referenceDataLabel2 = builderLabel2.build();
	}
	
	private Map<String, String> listToMap(List<KeyValueString> list) {
		Map<String, String> res = new HashMap<>();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				KeyValueString keyValue = list.get(i);
				res.put(keyValue.getKey(), keyValue.getValue());
			}
		}
		return res;
	}
	
	protected abstract void loadBranch(Builder<Integer, ImmutableList<String>> builder);
	
	//~ config
		
	@Override
	public <V> V getConfig(Config<V> config){
		return config.getValueMap(configXml);
	}
	
	@Override
	public String getMessage(MessageConfig messageConfig){
		return getMessage(messageConfig, new Object[0]);
	}
	
	@Override
	public String getMessage(MessageConfig messageConfig, Object[] args){
		try {
			if ( messageXml == null )
				return messageConfig.getDefValue();
			
			String value = messageXml.get(messageConfig.getCode());
			if ( value == null ){
				//return messageConfig.getDefValue();
				return args == null ? messageConfig.getDefValue() : String.format(messageConfig.getDefValue(), args);
			}
			
			return args == null ? value : String.format(value, args);	
		} catch (Throwable t){
			logger.error("", t);
			return messageConfig.getDefValue();
		}
	}

	//~ serialize and deserialize
	
	protected Map<String, String> readConfig(byte[] data) {
		List<KeyValueString> keyValueStrings = readReferences(data);
		Map<String, String> map = new HashMap<>();
		for (KeyValueString keyValueString : keyValueStrings) {
			map.put(keyValueString.getKey(), keyValueString.getValue());
		}
		return map;
	}

	@Override
	public List<KeyValueString> readReferences(byte[] data) {
		XStream xstream = instanceXStream();
		List<KeyValueString> result = (List<KeyValueString>) xstream.fromXML(new ByteArrayInputStream(data));
		return result;
	}
	
	protected ImmutableList<String> readReferencesList(List<KeyValueString> references) {
		ImmutableList.Builder<String> builder = new ImmutableList.Builder<>();
		for (KeyValueString keyValue : references) {
			builder.add(keyValue.getKey());
		}
		return builder.build();
	}
	
	protected Map<String, List<String>> readReferencePerSegmentList (List<KeyValueString> references) {
		Map<String, List<String>> result = new HashMap<>();
		references.stream()
			.filter( e -> e.getSegments() != null )
			.flatMap( e -> Arrays.asList(e.getSegments()).stream() )
			.distinct()
			.forEach( e -> {
				result.put(e, new ArrayList<>());
			});
				
		for (KeyValueString keyValue : references) {
			if( keyValue.getSegments() != null ){
				for (String segmentCode : keyValue.getSegments()) {
					result.get(segmentCode).add(keyValue.getKey());
				}
			}
		}
		
		return result;
	}

	protected ImmutableMap<String, String> readReferencesListLabel(List<KeyValueString> references, int labelNumber) {
		ImmutableMap.Builder<String, String> builder = new ImmutableMap.Builder<>();
		for (KeyValueString keyValue : references) {
			builder.put(keyValue.getKey(), keyValue.getLabels()[labelNumber]);
		}
		return builder.build();
	}

	public ReferenceHeader readHeader(byte[] data) {
		XStream xstream = instanceXStream();
		return (ReferenceHeader) xstream.fromXML(new ByteArrayInputStream(data));
	}

	public void saveHeader(File file, ReferenceHeader header) throws FileNotFoundException, IOException {
		file.getParentFile().mkdirs();
		XStream xstream = instanceXStream();
		try ( FileOutputStream fos = new FileOutputStream(file)){
			xstream.toXML(header, fos);
		}
	}

	public Map<String, ValidationErrorCode> readErrorCodes(byte[] data) {
		XStream xstream = instanceXStream();
		Map<String, ValidationErrorCode> result = (Map<String, ValidationErrorCode>) xstream.fromXML(new ByteArrayInputStream(data));
		return result;
	}

	public void saveErrorCodes(File file, Map<String, ValidationErrorCode> validationErrorCodeMap) throws FileNotFoundException, IOException{
		XStream xstream = instanceXStream();
		try ( FileOutputStream fos = new FileOutputStream(file)){
			xstream.toXML(validationErrorCodeMap, fos);
		}
	}

	public XStream instanceXStream(){
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(
				new Class[]{
					SetupHeader.class, ReferenceHeader.class, ReferenceMetadata.class,
					KeyValueString.class,
					ValidationErrorCode.class
				}
			);
		xstream.alias("reference", KeyValueString.class);
		return xstream;
	}
	
	@Override
	public Map<Integer, Map<String, String>> getReferenceMap() {
		//only for edit online
		return referenceKeyValue;
	}
	
	public Map<Integer, Map<String, Map<String, String>>> getReferenceMapPerSegment(){
		//only for edit online
		return null;
	}
	
	@Override
	public Map<String, String> getReference(Integer refNumber) {
		//only for edit online
		return referenceKeyValue.get(refNumber);
	}
	
	@Override
	public Map<String, String> getDataLabel1Map(Integer refNumber) {
		return referenceDataLabel1.get(refNumber);
	}
	
	@Override
	public Map<String, String> getDataLabel2Map(Integer refNumber) {
		return referenceDataLabel2.get(refNumber);
	}

	@Override
	public String getReferenceDescription(Integer refNumber) {
		return referenceDescriptions.get(refNumber);
	}
}
