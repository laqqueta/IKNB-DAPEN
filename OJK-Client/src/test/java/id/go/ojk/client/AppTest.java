package id.go.ojk.client;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.References;
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
//    	String tmp = "20201009";
//    	System.out.println(tmp.substring(0, 4));
//    	System.out.println(tmp.substring(4, 6));
//    	System.out.println(tmp.substring(6, 8));
//        testSplit();
//    	testSplitRegex();
//    	testPrecision();
//    	testScript();
    	try {
        	testArrayList();
        	assertTrue( true );
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private void testSplitRegex() {
//    	String regex = "(?<=[-+*/()@])|(?=[-+*/()])";
    	String regex = "(?<=[-+])|(?=[-+])";
    	String str = "-1234-45454+33";
    	String[] res = str.split(regex);
    	if (res != null) {
    		for (int i = 0; i < res.length; i++) {
    			System.out.println((i + 1) + "=" + res[i]);
    		}
    	}
    }
    
    private void testScript() {
    	long start = System.currentTimeMillis();
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
    	BigDecimal big1 = new BigDecimal("201.10");
    	BigDecimal big2 = new BigDecimal("201.9");
    	try {
			Object res = engine.eval(big1 + ".subtract" + big2);
			System.out.println("res=" + res);
    	} catch (ScriptException e) {
			e.printStackTrace();
		}
    	System.out.println("<<" + (System.currentTimeMillis() - start));
    }

    private void testPrecision() {
    	long start = System.currentTimeMillis();
    	BigDecimal big1 = new BigDecimal("3465");
    	BigDecimal big2 = new BigDecimal("123450");
    	System.out.println(">>" + (big1.divide(big2, 4, RoundingMode.HALF_UP)));
    	System.out.println("<<" + (System.currentTimeMillis() - start));
//    	Double leftResult = new Double("301.10");
//    	Double rightResult = new Double("200.10");
//    	Double res = Math.abs(leftResult + rightResult);
//    	System.out.println("res=" + res);
//    	System.out.println(">" + Double.sum(leftResult, rightResult));
//    	System.out.println(">>" + (leftResult - rightResult));
    }
    
    private void testXstream() {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("list", List.class);
        xstream.alias("reference", KeyValueString.class);
    	System.out.println(xstream.toXML(getReferences().getReferences()));
    }
    
    private References getReferences() {
    	References res = new References();
    	res.add(new KeyValueString("1111", "aaaaa", new String[] {}));
    	res.add(new KeyValueString("2222", "bbbbb", new String[] {}));
    	return res;
    }
    
    private void testSplit() {
//    	String str = "H01|31|2000000006|2019-03-31|RBASRJK|0104|0|\r\n";
    	String str = "";
    	String[] res = StringUtils.split(str, "|");
//    	String[] res = str.split("|");
    	System.out.println(">>" + res.length);
    }
    
    private void testArrayList() {
    	List<String> list = null;
    	if (!list.isEmpty()) {
    		for (int i = 0; i < list.size(); i++) {
        		System.out.println("list=" + list.get(i));
    		}
    	}
    }
}
