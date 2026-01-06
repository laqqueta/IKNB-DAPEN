package id.go.ojk.conf.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import id.go.ojk.conf.client.field.reference.ER1042JenisLiabilitas;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	System.out.println(ER1042JenisLiabilitas.getName());
    	String test = "1234567890";
    	try {
			System.out.println(test.length() + "|" + test.getBytes("UTF-8").length);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	Properties props = new Properties();
//    	props.put("id", "aaaa");
//    	props.put("mail.smtp.starttls.enable", "true");
//    	props.put("mail.smtp.starttls.enable", "false");
//    	System.out.println(props.toString());
//    	builderTest();
    	assertTrue( true );
    }
    
    private void builderTest() {
//        try {
//			FromKeyValueString.toXml(EMetadataKeyValueStringFilename.getMap(), "D:\\");
//			new FromValidationErrorCode().toXml("D:\\" + EReferenceValidationErrorCodeFilename.VALIDATION_ERROR_CODE.getFilename(), EReferenceValidationErrorCodeFilename.VALIDATION_ERROR_CODE.getReferences());
//			new FromReferenceHeader().toXml("D:\\" + EReferenceHeaderFilename.HEADER_2_1_1.getFilename(), EReferenceHeaderFilename.HEADER_2_1_1.getReferences());
//			new FromMap().toXml("D:\\" + ESetupFilename.SETUP.getFilename(), ESetupFilename.SETUP.getReferences());
//			new FromSetupHeader().toXml("D:\\" + ESetupHeaderFilename.HEADER_1_0_0.getFilename(), ESetupHeaderFilename.HEADER_1_0_0.getReferences());
//			new FromKeyValueString().toXml("D:\\" + ESetupKeyValueStringFilename.R3.getFilename(), ESetupKeyValueStringFilename.R3.getReferences());
//			new FromUser().toXml("D:\\" + ESetupUserFilename.USER.getFilename(), ESetupUserFilename.USER.getReferences());
//			new FromUpdateHeader().toXml("D:\\" + EUpdateHeaderFilename.UPDATE_HEADER_1.getFilename(), EUpdateHeaderFilename.UPDATE_HEADER_1.getObject());
//			new FromClientEntity().toXml("D:\\" + EClientEntityFilename.CLIENT_ENTITY.getFilename(), EClientEntityFilename.CLIENT_ENTITY.getReferences());
//        } catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
}
