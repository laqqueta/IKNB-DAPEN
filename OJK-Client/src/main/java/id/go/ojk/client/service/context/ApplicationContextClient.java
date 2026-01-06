package id.go.ojk.client.service.context;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.db.JdbcService;
import id.go.ojk.client.service.ApplicationUpdateService;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.DecryptDecompressService;
import id.go.ojk.client.service.HttpService;
import id.go.ojk.client.service.PreStartService;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.client.service.UserService;
import id.go.ojk.client.service.encryption.EncryptionService;
import id.go.ojk.client.service.ftp.FtpService;
import id.go.ojk.client.service.impl.ReferenceServiceClient;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.service.validation.MetadataService;
import id.go.ojk.client.service.validation.MetadataService.MetadataType;
import id.go.ojk.client.service.validation.ValidationService;

public class ApplicationContextClient extends ApplicationContextBase {

	private static ApplicationContextClient instance;

	public static ApplicationContextClient getInstance() {
		if ( instance == null ) {
			instance = new ApplicationContextClient();
			instance.initialize();
		}
		return instance;
	}

	private ApplicationContextClient(){
	}
	
	private ThreadPoolExecutor executor;

	@Override
	public void initialize(){
		executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

		setService(PreStartService.class, 			"preStartService", 			new PreStartService());
		setService(SetupService.class, 				"setupService", 			new SetupService());
		setService(ConfigService.class, 			"configService", 			new ConfigService());
		setService(HttpService.class, 				"httpService", 				new HttpService());
		setService(SecurityService.class, 			"securityService", 			new SecurityService());
		setService(UserService.class, 				"userService", 				new UserService());
		setService(MetadataService.class, 			"metadataService", 			new MetadataService());
		
		ReferenceServiceClient referenceServiceClient = new ReferenceServiceClient();
		setService(ReferenceService.class, 			"referenceService", 		referenceServiceClient);
		setService(ReferenceServiceClient.class, 	"referenceServiceClient", 	referenceServiceClient);
		
		setService(null, 							"submissionService", 		new SubmissionService(MetadataType.normal));
		setService(null, 							"summarySubmissionService", new SubmissionService(MetadataType.summary));
		setService(null, ClientConstant.SUBMISSIION_SERVICE_RBB1, 	new SubmissionService(MetadataType.normal));
		setService(null, ClientConstant.SUBMISSIION_SERVICE_RBB2, 	new SubmissionService(MetadataType.summary));
		setService(null, ClientConstant.SUBMISSIION_SERVICE_RBB3, 	new SubmissionService(MetadataType.supervision));
		setService(null, ClientConstant.SUBMISSIION_SERVICE_LB1,	new SubmissionService(MetadataType.normal));
		setService(null, ClientConstant.SUBMISSIION_SERVICE_LT1,	new SubmissionService(MetadataType.normal));
		setService(null, ClientConstant.SUBMISSIION_SERVICE_SA1,	new SubmissionService(MetadataType.normal));
		setService(null, ClientConstant.SUBMISSIION_SERVICE_SA2,	new SubmissionService(MetadataType.summary));
		setService(null, ClientConstant.SUBMISSIION_SERVICE_APU1, 	new SubmissionService(MetadataType.normal));
		setService(null, ClientConstant.SUBMISSIION_SERVICE_APU2, 	new SubmissionService(MetadataType.summary));
		setService(null, ClientConstant.SUBMISSIION_SERVICE_APU3, 	new SubmissionService(MetadataType.supervision));
		setService(null, ClientConstant.SUBMISSIION_SERVICE_PLS,	new SubmissionService(MetadataType.normal));
		setService(null, ClientConstant.SUBMISSIION_SERVICE_TL1,	new SubmissionService(MetadataType.normal));
		setService(null, ClientConstant.SUBMISSIION_SERVICE_TPP, new SubmissionService(MetadataType.normal));
		setService(null, ClientConstant.SUBMISSIION_SERVICE_BPJS,  new SubmissionService(MetadataType.normal));
//		setService(null, 							"submissionServiceRBB2", 	new SubmissionService(MetadataType.normal));
//		setService(null, 							"submissionServiceRBB3", 	new SubmissionService(MetadataType.normal));
//		setService(null, 							"submissionServiceRBB4", 	new SubmissionService(MetadataType.summary));
//		setService(null, 							"submissionServiceLBBPRK2",	new SubmissionService(MetadataType.normal));
//		setService(null, 							"submissionServiceLBBPRK3",	new SubmissionService(MetadataType.normal));
//		setService(null, 							"submissionServiceLBBPRK4",	new SubmissionService(MetadataType.normal));
		setService(ValidationService.class, 		"validationService", 		new ValidationService());
		setService(EncryptionService.class, 		"encryptionService", 		new EncryptionService());
		setService(FtpService.class, 				"ftpService", 				new FtpService());
		setService(DecryptDecompressService.class,	"decryptDecompressService", new DecryptDecompressService());
		setService(ApplicationUpdateService.class,	"applicationUpdateService", new ApplicationUpdateService());
		setService(JdbcService.class, JdbcService.SERVICE_NAME, new JdbcService());
	}

	public ThreadPoolExecutor getExecutor() {
		return executor;
	}

	@Override
	public void shutdown(){
		super.shutdown();
		executor.shutdown();
	}

}
