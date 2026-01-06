package id.go.ojk.client.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.config.Config;
import id.go.ojk.lib.client.model.config.ConfigLocalDate;
import id.go.ojk.lib.client.model.config.ConfigString;
import id.go.ojk.lib.client.model.config.MessageConfig;
import id.go.ojk.lib.client.service.base.Service;

public interface ReferenceService extends Service {

	public final static ConfigString summaryStartYearMonth 	= new ConfigString("AC.summaryStartYearMonth", 	"summaryStartYearMonth",	"201604", 					false);
	public final static ConfigLocalDate minAllDate 			= new ConfigLocalDate("AC.minAllDate", 			"minAllDate",				LocalDate.of(1900, 1, 1), 	false);
	public final static ConfigLocalDate maxAllDate 			= new ConfigLocalDate("AC.maxAllDate", 			"maxAllDate",				LocalDate.of(2999, 1, 1), 	false);
	
	public final static ConfigString passwordRegex 		= new ConfigString("AC.passwordRegex", 			"passwordRegex",			"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=~!?()-])[0-9a-zA-Z@#$%^&+=~!?()-]{8,}$", 					false);
	public final static ConfigString passwordErrorMessage 	= new ConfigString("AC.passwordErrorMessage", 	"passwordErrorMessage",		"Password harus kompleks yaitu terdiri dari alfabet, angka dan karakter khusus(@#$%^&+=~!?()-), serta lower dan upper case, minimal panjang 8 karakter.", 					false);
	
	public final static MessageConfig messageConfig_ojkPhone 	= MessageConfig.builder().code("CLI-phone")		.defValue("(021) 2960 0000 ext. 7000").build();
	public final static MessageConfig messageConfig_ojkFax 		= MessageConfig.builder().code("CLI-fax")		.defValue("(021) 385 8321").build();
	public final static MessageConfig messageConfig_ojkEmail 	= MessageConfig.builder().code("CLI-email")		.defValue("helpdesk@ojk.go.id").build();
	public final static MessageConfig messageConfig_ojkHomeName = MessageConfig.builder().code("CLI-homeName")	.defValue("Otoritas Jasa Keuangan").build();
	public final static MessageConfig messageConfig_ojkAddress 	= MessageConfig.builder().code("CLI-address")	.defValue("").build();
	
	public final static MessageConfig messageConfig_err_title 						= MessageConfig.builder().code("CLI-err-title")						.defValue("Kesalahan").build();
	public final static MessageConfig messageConfig_err_header 						= MessageConfig.builder().code("CLI-err-header")					.defValue("Kesalahan!").build();
	public final static MessageConfig messageConfig_info_title 						= MessageConfig.builder().code("CLI-info-title")					.defValue("Informasi").build();
	public final static MessageConfig messageConfig_info_header 					= MessageConfig.builder().code("CLI-info-header")					.defValue("Informasi").build();
	public final static MessageConfig messageConfig_warn_title 						= MessageConfig.builder().code("CLI-warn-title")					.defValue("Peringatan").build();
	public final static MessageConfig messageConfig_warn_header 					= MessageConfig.builder().code("CLI-warn-header")					.defValue("Peringatan").build();
	public final static MessageConfig messageConfig_confirm_title 					= MessageConfig.builder().code("CLI-confirm-title")					.defValue("Konfirmasi").build();
	public final static MessageConfig messageConfig_confirm_header 					= MessageConfig.builder().code("CLI-confirm-header")				.defValue("Konfirmasi!").build();
	
	public final static MessageConfig messageConfig_prepFileSuccess_title 			= MessageConfig.builder().code("CLI-prepFileSuccess-title")			.defValue("Persiapan data sukses").build();
	public final static MessageConfig messageConfig_prepFileSuccess_header 			= MessageConfig.builder().code("CLI-prepFileSuccess-header")		.defValue("Persiapan data sukses!").build();
	public final static MessageConfig messageConfig_prepFileSuccess					= MessageConfig.builder().code("CLI-prepFileSuccess")				.defValue("File kirim sudah berhasil dibentuk, silahkan dilanjutkan dengan pengiriman melalui: \n 1. Menu Kirim Data pada Aplikasi Client, atau \n 2. Web APOLO, atau \n 3. Pengiriman Offline melalui Kantor OJK Terdekat.").build();
	public final static MessageConfig messageConfig_prepOkAndSendFailed_title		= MessageConfig.builder().code("CLI-prepOkAndSendFailed-title")		.defValue("Persiapan data sukses dan pengiriman data gagal").build();
	public final static MessageConfig messageConfig_prepOkAndSendFailed_header 		= MessageConfig.builder().code("CLI-prepOkAndSendFailed-header")	.defValue("Persiapan data sukses dan pengiriman data gagal!").build();
	public final static MessageConfig messageConfig_prepOkAndSendFailed				= MessageConfig.builder().code("CLI-prepOkAndSendFailed")			.defValue("Pengiriman file gagal tetapi file kirim sudah berhasil dibentuk, silahkan ulangi kembali atau dilanjutkan dengan pengiriman melalui: \n 1. Menu Kirim Data pada Aplikasi Client, atau \n 2. Web APOLO, atau \n 3. Pengiriman Offline melalui Kantor OJK Terdekat.").build();
	public final static MessageConfig messageConfig_prepAndSendFileSuccess_title 	= MessageConfig.builder().code("CLI-prepAndSendFileSuccess-title")	.defValue("Persiapan dan pengiriman data sukses").build();
	public final static MessageConfig messageConfig_prepAndSendFileSuccess_header 	= MessageConfig.builder().code("CLI-prepAndSendFileSuccess-header")	.defValue("Persiapan dan pengiriman data sukses!").build();
	public final static MessageConfig messageConfig_prepAndSendFileSuccess			= MessageConfig.builder().code("CLI-prepAndSendFileSuccess")		.defValue("Persiapan dan pengiriman data ke Server Apolo telah sukses!").build();
	public final static MessageConfig messageConfig_SendFileSuccess_title 			= MessageConfig.builder().code("CLI-sendFileSuccess-title")			.defValue("Pengiriman data sukses").build();
	public final static MessageConfig messageConfig_SendFileSuccess_header 			= MessageConfig.builder().code("CLI-sendFileSuccess-header")		.defValue("Pengiriman data sukses!").build();
	public final static MessageConfig messageConfig_SendFileSuccess					= MessageConfig.builder().code("CLI-sendFileSuccess")				.defValue("File kirim telah berhasil dikirim ke server OJK!").build();
	
	
	public final static MessageConfig messageConfig_success							= MessageConfig.builder().code("CLI-success")						.defValue("Sukses").build();
	public final static MessageConfig messageConfig_fail							= MessageConfig.builder().code("CLI-fail")							.defValue("Gagal").build();
	
	public String getVersion();

	public LocalDateTime getLastModified();
	
	public void validate(SubmissionField field, String code, List<Integer> referenceNumbers, List<ValidationError> errors);
	
	public void validatePerSegment(SubmissionField field, String code, String segmentCode, List<Integer> referenceNumbers, List<ValidationError> errors);
	
	public void validateLabel1(SubmissionField field, String code, String label1, Integer referenceNumber, List<ValidationError> errors);

	public String getLabel(Integer referenceNumber, int labelNumber, String key);
		
	public String getLabel1Description(int refNumber, String label1);
	
	public List<KeyValueString> readReferences(byte[] data);

	public <V> V getConfig(Config<V> config);
	
	public String getMessage(MessageConfig messageConfig);
	
	public String getMessage(MessageConfig messageConfig, Object[] args);
	
	public Map<Integer, Map<String, String>> getReferenceMap();
	
	public Map<Integer, Map<String, Map<String, String>>> getReferenceMapPerSegment();
	
	public Map<String, String> getReference(Integer refNumber);
	
	//~ label
	
	public Map<String, String> getDataLabel1Map(Integer refNumber);
	
	public Map<String, String> getDataLabel2Map(Integer refNumber);
	
	public String getReferenceDescription(Integer refNumber);
}
