package id.go.ojk.client.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.lib.client.model.config.MessageConfig;

public class SystemMessageUtil {

	private static Logger logger = LoggerFactory.getLogger(SystemMessageUtil.class);
	
	public static String getMessage(ReferenceService referenceService, MessageConfig messageConfig){
		if ( referenceService == null ){
			return messageConfig.getDefValue();
		} else {
			return referenceService.getMessage(messageConfig);
		}
	}
	
	public static String getMessage(ReferenceService referenceService, MessageConfig messageConfig, Object[] args){
		if ( referenceService == null ){
			return messageConfig.getDefValue();
		} else {
			return referenceService.getMessage(messageConfig, args);
		}		
	}

	//~only avalible on SLIK Client
	
	public static String getSlikClientMessage(MessageConfig messageConfig){
		ReferenceService referenceService = getSlikClientReferenceService();
		if ( referenceService == null ){
			return messageConfig.getDefValue();
		} else {
			return referenceService.getMessage(messageConfig);
		}
	}
	
	public static String getSlikClientMessage(MessageConfig messageConfig, Object[] args){
		ReferenceService referenceService = getSlikClientReferenceService();
		if ( referenceService == null ){
			return messageConfig.getDefValue();
		} else {
			return referenceService.getMessage(messageConfig, args);
		}		
	}
	
	public static ReferenceService getSlikClientReferenceService(){
		ReferenceService referenceService = null;
		try {
			referenceService = ApplicationContextClient.getInstance().getService(ReferenceService.class);			
		} catch (Throwable t){
			logger.error("", t);
		}
		return referenceService;
	}

	//chaced
	
	private static String msgSuccess 	= "Sukses";
	private static String msgFail 		= "Gagal";
	
	public static void initMessage(ReferenceService referenceService){
		try {
			msgSuccess = referenceService.getMessage(ReferenceService.messageConfig_success);
			msgFail = referenceService.getMessage(ReferenceService.messageConfig_fail);
		} catch (Throwable t){
			logger.error("initMessage", t);
		}
	}
	
	public static String getMsgSuccess() {
		return msgSuccess;
	}
	
	public static String getMsgFail() {
		return msgFail;
	}

}
