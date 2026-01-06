package id.go.ojk.client.service.validation;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.io.IOUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionMetadata;
import id.go.ojk.client.model.config.validation.field.FieldValidationFactory;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidationFactory;
import id.go.ojk.client.service.base.BaseService;
import id.go.ojk.client.vc.HomeController;
import id.go.ojk.lib.client.EncryptionCompressionUtil;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.compression.MemoryFile;
import id.go.ojk.lib.client.service.context.ApplicationContext;

public class MetadataService extends BaseService {
	
	public final static File metadataFile = new File("resources/metadata.jar");

	@Override
	public void initialize() {
	}

	public SubmissionMetadata getSubmissionMetadata(MetadataType metadataType) throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException {
		return readMetadatas(metadataType);
	}

	public SubmissionMetadata readMetadatas(MetadataType metadataType) throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException{
		Map<String, MemoryFile> memoryFileMap = EncryptionCompressionUtil.decryptAndDecompressToMemoryMap(HomeController.homeButton, metadataFile);
		return readMetadatas(memoryFileMap, metadataType, appContext);
	}

	public SubmissionMetadata readMetadatas(Map<String, MemoryFile> memoryFileMap, MetadataType metadataType, ApplicationContext appContext) throws FileNotFoundException, NoSuchAlgorithmException, ArchiveException, IOException{

		XStream xstream = instanceXStream();
		SubmissionMetadata submissionMetadata = (SubmissionMetadata) xstream.fromXML(new ByteArrayInputStream(memoryFileMap.get(metadataType.getFilePath()).getContent()));

		// SegmentValidation.setApplicationContext 
		submissionMetadata.getFormats().stream()
			.flatMap( e -> e.getSegmentValidations().stream() )
			.forEach( e -> e.setApplicationContext(appContext));

		// ConditionalRequired.setApplicationContext
		submissionMetadata.getFormats().stream()
			.flatMap( e -> e.getConditionalRequireds() == null ? null : e.getConditionalRequireds().stream() )
			.forEach( e -> e.setApplicationContext(appContext));

		// SimpleValidation.initializeDefauldRegex
		submissionMetadata.getFormats().stream()
			.flatMap( e -> e.getFields().stream() )
			.map(SubmissionField::getSimpleValidation)
			.forEach( e -> e.initializeDefaultRegex());

		// SimpleValidation.ConditionalRequired.setApplicationContext
		submissionMetadata.getFormats().stream()
			.flatMap( e -> e.getFields().stream() )
			.forEach( e -> {
				if ( e.getSimpleValidation().getConditionalRequired() != null ){
					e.getSimpleValidation().getConditionalRequired().setApplicationContext(appContext);
				}
			});

		// SubmissionField.FieldValidation.setApplicationContext and initialized
		submissionMetadata.getFormats().stream()
			.flatMap( e -> e.getFields().stream() )
			.forEach(
				e -> {
					if ( e.getFieldValidations() != null )  {
						e.getFieldValidations().stream().forEach( 
							f -> {
								f.setApplicationContext(appContext);
								f.initialized();
							}
						);
					}
				}
			);
		return submissionMetadata;
	}


	public SubmissionMetadata readMetadatas(File file){
		XStream xstream = instanceXStream();
		SubmissionMetadata submissionMetadata = (SubmissionMetadata) xstream.fromXML(file);

		submissionMetadata.getFormats().stream()
			.flatMap( e-> e.getSegmentValidations().stream() )
			.forEach( e -> e.setApplicationContext(appContext));

		submissionMetadata.getFormats().stream()
			.flatMap( e-> e.getFields().stream() )
			.map(SubmissionField::getSimpleValidation)
			.forEach( e -> e.initializeDefaultRegex());
		return submissionMetadata;
	}

	public void saveReferences(File file, SubmissionMetadata metadata) {
		XStream xstream = instanceXStream();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			xstream.toXML(metadata, fos);
		} catch (FileNotFoundException e) {
			throw new SlikException("", e);
		} finally {
			IOUtils.closeQuietly(fos);
		}
	}

	public XStream instanceXStream(){
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(
			new Class[]{
				SubmissionMetadata.class, SubmissionFormat.class, SubmissionField.class, SimpleValidation.class
				
//				,
//				AmountBaseConditionFieldValidation.class, CollectibilityFieldValidation.class, MinMaxFieldValidation.class,  
//				OriCurrencyFieldValidation.class,  RestructureFreqFieldValidation.class, DateFieldRelativeValidation.class, NewRenewalFieldValidation.class, 
//				ReferenceLabelFieldValidation.class, YearMonthFieldRelativeValidation.class
				
//				,
//				ContractDateValidation.class, DateFieldCompare.class, DateFieldCompare.RightDateField.class, DateMatrixSegmentValidation.class, OverdueValidation.class, RefForSummary.class,
//				AllExistConditional.class, ComparisonConditional.class, RefConditional.class, RefLabelConditional.class,
//				K01SegmentValidation.class, S01SegmentValidation.class, EstablismentDateValidation.class
				
			}
		);
		
		xstream.processAnnotations(FieldValidationFactory.clazzs);
		xstream.processAnnotations(SegmentValidationFactory.clazzs);

		return xstream;
	}

	public enum MetadataType {
		normal("metadata.xml"),
		summary("summary-metadata.xml"),
		supervision("supervision-metadata.xml"),
		;

		private String filePath;

		private MetadataType(String filePath){
			this.filePath = filePath;
		}

		public String getFilePath() {
			return filePath;
		}
	}

}
