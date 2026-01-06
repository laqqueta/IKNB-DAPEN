package id.go.ojk.client.service.validation;

import static id.go.ojk.client.model.config.SimpleValidation.patternAccountNumber;
import static id.go.ojk.client.model.config.SimpleValidation.patternAkadNumber;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfa;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaDotHypen;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumColonPlusMin;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumericDotHypen;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumericSpace;
import static id.go.ojk.client.model.config.SimpleValidation.patternAll;
import static id.go.ojk.client.model.config.SimpleValidation.patternBirthPlace;
import static id.go.ojk.client.model.config.SimpleValidation.patternCollateralAppaiser;
import static id.go.ojk.client.model.config.SimpleValidation.patternCollateralRating;
import static id.go.ojk.client.model.config.SimpleValidation.patternCompanyName;
import static id.go.ojk.client.model.config.SimpleValidation.patternCompanyPlace;
import static id.go.ojk.client.model.config.SimpleValidation.patternDecimal;
import static id.go.ojk.client.model.config.SimpleValidation.patternDescription;
import static id.go.ojk.client.model.config.SimpleValidation.patternDistrict;
import static id.go.ojk.client.model.config.SimpleValidation.patternEmail;
import static id.go.ojk.client.model.config.SimpleValidation.patternManagementName;
import static id.go.ojk.client.model.config.SimpleValidation.patternName;
import static id.go.ojk.client.model.config.SimpleValidation.patternNameGuaranteed;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumericNegatif;
import static id.go.ojk.client.model.config.SimpleValidation.patternProofOwnership;
import static id.go.ojk.client.model.config.SimpleValidation.patternRating;
import static id.go.ojk.client.model.config.SimpleValidation.patternRatingAgency;
import static id.go.ojk.client.model.config.SimpleValidation.patternRatingAgency2;
import static id.go.ojk.client.model.config.SimpleValidation.patternSignInteger;
import static id.go.ojk.client.model.config.SimpleValidation.patternSubDistrict;
import static id.go.ojk.client.model.config.SimpleValidation.patternUnsignInteger;
import static id.go.ojk.client.model.config.SimpleValidation.patternWorkPlace;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import org.junit.Test;

public class TestRegex {

	@Test
	public void testUnsignIntegerRegx(){
		assertTrue(Pattern.matches(patternUnsignInteger.getPattern(), "0"));
		assertTrue(Pattern.matches(patternUnsignInteger.getPattern(), "1"));
		assertTrue(Pattern.matches(patternUnsignInteger.getPattern(), "123"));
		assertTrue(Pattern.matches(patternUnsignInteger.getPattern(), "10"));
		assertTrue(Pattern.matches(patternUnsignInteger.getPattern(), "101"));
		assertTrue(Pattern.matches(patternUnsignInteger.getPattern(), "1234567890"));
		assertTrue(Pattern.matches(patternUnsignInteger.getPattern(), "101"));
		
		assertFalse(Pattern.matches(patternUnsignInteger.getPattern(), "A01"));
		assertFalse(Pattern.matches(patternUnsignInteger.getPattern(), "00"));
		assertFalse(Pattern.matches(patternUnsignInteger.getPattern(), "000"));
		assertFalse(Pattern.matches(patternUnsignInteger.getPattern(), "01"));
		assertFalse(Pattern.matches(patternUnsignInteger.getPattern(), "01121212"));
		assertFalse(Pattern.matches(patternUnsignInteger.getPattern(), "0000"));
		assertFalse(Pattern.matches(patternUnsignInteger.getPattern(), "00001"));
		assertFalse(Pattern.matches(patternUnsignInteger.getPattern(), "0,"));
		assertFalse(Pattern.matches(patternUnsignInteger.getPattern(), "0,121212,"));
		assertFalse(Pattern.matches(patternUnsignInteger.getPattern(), ","));
	}
	
	@Test
	public void testSignIntegerRegx(){
		assertTrue(Pattern.matches(patternSignInteger.getPattern(), "0"));
		assertTrue(Pattern.matches(patternSignInteger.getPattern(), "1"));
		assertTrue(Pattern.matches(patternSignInteger.getPattern(), "123"));
		assertTrue(Pattern.matches(patternSignInteger.getPattern(), "10"));
		assertTrue(Pattern.matches(patternSignInteger.getPattern(), "101"));
		assertTrue(Pattern.matches(patternSignInteger.getPattern(), "1234567890"));
		assertTrue(Pattern.matches(patternSignInteger.getPattern(), "-1"));
		assertTrue(Pattern.matches(patternSignInteger.getPattern(), "-12"));
		
		assertFalse(Pattern.matches(patternSignInteger.getPattern(), "--12"));
		assertFalse(Pattern.matches(patternSignInteger.getPattern(), "-0"));
		assertFalse(Pattern.matches(patternSignInteger.getPattern(), "--0"));
		assertFalse(Pattern.matches(patternSignInteger.getPattern(), "A01"));
		assertFalse(Pattern.matches(patternSignInteger.getPattern(), "00"));
		assertFalse(Pattern.matches(patternSignInteger.getPattern(), "000"));
		assertFalse(Pattern.matches(patternSignInteger.getPattern(), "01"));
		assertFalse(Pattern.matches(patternSignInteger.getPattern(), "01121212"));
		assertFalse(Pattern.matches(patternSignInteger.getPattern(), "0000"));
		assertFalse(Pattern.matches(patternSignInteger.getPattern(), "00001"));
		assertFalse(Pattern.matches(patternSignInteger.getPattern(), "0,"));
		assertFalse(Pattern.matches(patternSignInteger.getPattern(), "0,121212,"));
		assertFalse(Pattern.matches(patternSignInteger.getPattern(), ","));
	}

	@Test
	public void testDecimalRegx(){
		assertTrue(Pattern.matches(patternDecimal.getPattern(), "0,1"));
		assertTrue(Pattern.matches(patternDecimal.getPattern(), "0"));
		assertTrue(Pattern.matches(patternDecimal.getPattern(), "121212"));
		assertTrue(Pattern.matches(patternDecimal.getPattern(), "0,12"));
		assertTrue(Pattern.matches(patternDecimal.getPattern(), "0,121212"));
		assertTrue(Pattern.matches(patternDecimal.getPattern(), "121212,121212"));
		assertTrue(Pattern.matches(patternDecimal.getPattern(), "0,00"));
		
		assertFalse(Pattern.matches(patternDecimal.getPattern(), "0,"));
		assertFalse(Pattern.matches(patternDecimal.getPattern(), "0,121212,"));
		assertFalse(Pattern.matches(patternDecimal.getPattern(), ","));
	}
	
//	@Test
//	public void testPasswordRegx(){
//		
//		//^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$
//		
////		System.out.println("000121212".replaceAll("(?<!\\d)0+(?=\\d+)", ""));;
//		
//		String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$";
//		System.out.println("aA1223 " + Pattern.matches(pattern, "aA!12345"));
//		
////		String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
////		System.out.println("aA@12345 " + Pattern.matches(pattern, "aA@12345"));
//
//	}

	@Test
	public void testPatternAll(){
		assertTrue(Pattern.matches(patternAll.getPattern(), "aA1@#$%^&(){}[]<=>~_-+"));
		assertTrue(Pattern.matches(patternAll.getPattern(), "aA1@#$%^&(){}[]<=>~_-+`"));
		assertTrue(Pattern.matches(patternAll.getPattern(), "aA1@#$%^&(){}[]<=>~_-+`'"));
		assertTrue(Pattern.matches(patternAll.getPattern(), "aA1@#$%^&(){}[]<=>~_-+`'\""));
		assertTrue(Pattern.matches(patternAll.getPattern(), "aA1@#$%^&(){}[]<=>~_-+`'\"."));
		assertTrue(Pattern.matches(patternAll.getPattern(), "aA1@#$%^&(){}[]<=>~_-+`'\".,"));
		assertTrue(Pattern.matches(patternAll.getPattern(), "aA1@#$%^&(){}[]<=>~_-+`'\".,:"));
		assertTrue(Pattern.matches(patternAll.getPattern(), "aA1@#$%^&(){}[]<=>~_-+`'\".,:;"));
		assertTrue(Pattern.matches(patternAll.getPattern(), "aA1@#$%^&(){}[]<=>~_-+`'\".,:;\\"));
		assertTrue(Pattern.matches(patternAll.getPattern(), "aA1@#$%^&(){}[]<=>~_-+`'\".,:;\\"));
		assertTrue(Pattern.matches(patternAll.getPattern(), "aA1@#$%^&(){}[]<=>~_-+`'\".,:;\\/"));
		assertTrue(Pattern.matches(patternAll.getPattern(), "aA1@#$%^&(){}[]<=>~_-+`'\".,:;\\/?"));
		assertTrue(Pattern.matches(patternAll.getPattern(), "aA1@#$%^&(){}[]<=>~_-+`'\".,:;\\/?!"));
		assertTrue(Pattern.matches(patternAll.getPattern(), "aA1@#$%^&*(){}[]<=>~_-+`'\".,:;\\/?!"));

		//assertFalse(Pattern.matches(patternAll.getPattern(), "aA1@#$%^&*(){}[]<=>~_-+`'\".,:;\\|/?!"));
	}

	@Test
	public void testPatternNumeric(){
		assertTrue(Pattern.matches(patternNumeric.getPattern(), "1"));
		assertTrue(Pattern.matches(patternNumeric.getPattern(), "1234567890"));

		assertFalse(Pattern.matches(patternNumeric.getPattern(), "1a"));
		assertFalse(Pattern.matches(patternNumeric.getPattern(), "abc"));
		assertFalse(Pattern.matches(patternNumeric.getPattern(), "123@"));
		assertFalse(Pattern.matches(patternNumeric.getPattern(), "1 "));
	}

	@Test
	public void testPatternNumericNegatif(){
		assertTrue(Pattern.matches(patternNumericNegatif.getPattern(), "1"));
		assertTrue(Pattern.matches(patternNumericNegatif.getPattern(), "1234567890"));
		assertTrue(Pattern.matches(patternNumericNegatif.getPattern(), "-1"));
		assertTrue(Pattern.matches(patternNumericNegatif.getPattern(), "-0"));
		assertTrue(Pattern.matches(patternNumericNegatif.getPattern(), "-123456"));

		assertFalse(Pattern.matches(patternNumericNegatif.getPattern(), "-"));
		assertFalse(Pattern.matches(patternNumericNegatif.getPattern(), "--0"));
		assertFalse(Pattern.matches(patternNumericNegatif.getPattern(), "-0-"));
		assertFalse(Pattern.matches(patternNumericNegatif.getPattern(), "+0"));
		assertFalse(Pattern.matches(patternNumericNegatif.getPattern(), "1a"));
		assertFalse(Pattern.matches(patternNumericNegatif.getPattern(), "abc"));
		assertFalse(Pattern.matches(patternNumericNegatif.getPattern(), "123@"));
		assertFalse(Pattern.matches(patternNumericNegatif.getPattern(), "1 "));
	}

	@Test
	public void testPatternDecimal(){
		
		assertTrue(Pattern.matches(patternDecimal.getPattern(), "0,1"));
		assertTrue(Pattern.matches(patternDecimal.getPattern(), "0"));
		assertTrue(Pattern.matches(patternDecimal.getPattern(), "121212"));
		assertTrue(Pattern.matches(patternDecimal.getPattern(), "0,12"));
		assertTrue(Pattern.matches(patternDecimal.getPattern(), "0,121212"));
		assertTrue(Pattern.matches(patternDecimal.getPattern(), "121212,121212"));
		
		assertFalse(Pattern.matches(patternDecimal.getPattern(), "50,,5"));
		assertFalse(Pattern.matches(patternDecimal.getPattern(), ",00"));
		assertFalse(Pattern.matches(patternDecimal.getPattern(), "0,"));
		assertFalse(Pattern.matches(patternDecimal.getPattern(), "0,121212,"));
		assertFalse(Pattern.matches(patternDecimal.getPattern(), ","));

		assertTrue(Pattern.matches(patternDecimal.getPattern(), "1"));
		assertTrue(Pattern.matches(patternDecimal.getPattern(), "12345678,90"));

		assertFalse(Pattern.matches(patternDecimal.getPattern(), "1,a"));
		assertFalse(Pattern.matches(patternDecimal.getPattern(), "abc"));
		assertFalse(Pattern.matches(patternDecimal.getPattern(), "123@"));
		assertFalse(Pattern.matches(patternDecimal.getPattern(), "1 ,"));
	}

	@Test
	public void testPatternAlfa(){
		assertTrue(Pattern.matches(patternAlfa.getPattern(), "a"));
		assertTrue(Pattern.matches(patternAlfa.getPattern(), "abcdef"));

		assertFalse(Pattern.matches(patternAlfa.getPattern(), "1a"));
		assertFalse(Pattern.matches(patternAlfa.getPattern(), "as,"));
		assertFalse(Pattern.matches(patternAlfa.getPattern(), ","));
		assertFalse(Pattern.matches(patternAlfa.getPattern(), " "));
	}

	@Test
	public void testPatternAlfaNumeric(){
		assertTrue(Pattern.matches(patternAlfaNumeric.getPattern(), "a"));
		assertTrue(Pattern.matches(patternAlfaNumeric.getPattern(), "abcdef"));
		assertTrue(Pattern.matches(patternAlfaNumeric.getPattern(), "1"));
		assertTrue(Pattern.matches(patternAlfaNumeric.getPattern(), "123"));
		assertTrue(Pattern.matches(patternAlfaNumeric.getPattern(), "abc123"));

		assertFalse(Pattern.matches(patternAlfaNumeric.getPattern(), "1a;"));
		assertFalse(Pattern.matches(patternAlfaNumeric.getPattern(), "1a "));
		assertFalse(Pattern.matches(patternAlfaNumeric.getPattern(), "as,"));
		assertFalse(Pattern.matches(patternAlfaNumeric.getPattern(), ","));
		assertFalse(Pattern.matches(patternAlfaNumeric.getPattern(), " "));
	}

	@Test
	public void testPatternAlfaNumericSpace(){
		assertTrue(Pattern.matches(patternAlfaNumericSpace.getPattern(), "a"));
		assertTrue(Pattern.matches(patternAlfaNumericSpace.getPattern(), "abcdef"));
		assertTrue(Pattern.matches(patternAlfaNumericSpace.getPattern(), "1"));
		assertTrue(Pattern.matches(patternAlfaNumericSpace.getPattern(), "123"));
		assertTrue(Pattern.matches(patternAlfaNumericSpace.getPattern(), "abc123"));
		assertTrue(Pattern.matches(patternAlfaNumericSpace.getPattern(), "abc123 "));
		assertTrue(Pattern.matches(patternAlfaNumericSpace.getPattern(), " "));
		assertTrue(Pattern.matches(patternAlfaNumericSpace.getPattern(), "   "));

		assertFalse(Pattern.matches(patternAlfaNumericSpace.getPattern(), "1a;"));
		assertFalse(Pattern.matches(patternAlfaNumericSpace.getPattern(), "1a."));
		assertFalse(Pattern.matches(patternAlfaNumericSpace.getPattern(), "as,"));
		assertFalse(Pattern.matches(patternAlfaNumericSpace.getPattern(), ","));
	}

	@Test
	public void testPatternEmail(){
		assertTrue(Pattern.matches(patternEmail.getPattern(), "arif.ananto@gmail.com"));
		assertTrue(Pattern.matches(patternEmail.getPattern(), "a@a.com"));

		assertFalse(Pattern.matches(patternEmail.getPattern(), " a@a.c"));
		assertFalse(Pattern.matches(patternEmail.getPattern(), "a"));
		assertFalse(Pattern.matches(patternEmail.getPattern(), "a@"));
		assertFalse(Pattern.matches(patternEmail.getPattern(), ";"));
		assertFalse(Pattern.matches(patternEmail.getPattern(), " "));
	}

	@Test
	public void testPatternAlfaDotHypen(){
		assertTrue(Pattern.matches(patternAlfaDotHypen.getPattern(), "a"));
		assertTrue(Pattern.matches(patternAlfaDotHypen.getPattern(), "abcdeABCDE"));
		assertTrue(Pattern.matches(patternAlfaDotHypen.getPattern(), "."));
		assertTrue(Pattern.matches(patternAlfaDotHypen.getPattern(), "-"));
		assertTrue(Pattern.matches(patternAlfaDotHypen.getPattern(), "aA.-"));

		assertFalse(Pattern.matches(patternAlfaDotHypen.getPattern(), "a1"));
		assertFalse(Pattern.matches(patternAlfaDotHypen.getPattern(), "123"));
		assertFalse(Pattern.matches(patternAlfaDotHypen.getPattern(), " "));
		assertFalse(Pattern.matches(patternAlfaDotHypen.getPattern(), ";"));
		assertFalse(Pattern.matches(patternAlfaDotHypen.getPattern(), "a@"));
		assertFalse(Pattern.matches(patternAlfaDotHypen.getPattern(), ";"));
		assertFalse(Pattern.matches(patternAlfaDotHypen.getPattern(), ";'"));
	}

	@Test
	public void testPatternAlfaNumericDotHypen(){
		assertTrue(Pattern.matches(patternAlfaNumericDotHypen.getPattern(), "a"));
		assertTrue(Pattern.matches(patternAlfaNumericDotHypen.getPattern(), "abcdeABCDE"));
		assertTrue(Pattern.matches(patternAlfaNumericDotHypen.getPattern(), "."));
		assertTrue(Pattern.matches(patternAlfaNumericDotHypen.getPattern(), "-"));
		assertTrue(Pattern.matches(patternAlfaNumericDotHypen.getPattern(), "aA.-"));
		assertTrue(Pattern.matches(patternAlfaNumericDotHypen.getPattern(), "a1"));
		assertTrue(Pattern.matches(patternAlfaNumericDotHypen.getPattern(), "123"));

		assertFalse(Pattern.matches(patternAlfaNumericDotHypen.getPattern(), " "));
		assertFalse(Pattern.matches(patternAlfaNumericDotHypen.getPattern(), ";"));
		assertFalse(Pattern.matches(patternAlfaNumericDotHypen.getPattern(), "a@"));
		assertFalse(Pattern.matches(patternAlfaNumericDotHypen.getPattern(), ";"));
		assertFalse(Pattern.matches(patternAlfaNumericDotHypen.getPattern(), ";'"));
	}

//	@Test
//	public void testPatternAlfaNumericCollonPlusMinus(){
//		assertTrue(Pattern.matches(patternAlfaNumericCollonPlusMinus.getPattern(), "a"));
//		assertTrue(Pattern.matches(patternAlfaNumericCollonPlusMinus.getPattern(), "abcdeABCDE"));
//		assertTrue(Pattern.matches(patternAlfaNumericCollonPlusMinus.getPattern(), "("));
//		assertTrue(Pattern.matches(patternAlfaNumericCollonPlusMinus.getPattern(), "_"));
//		assertTrue(Pattern.matches(patternAlfaNumericCollonPlusMinus.getPattern(), "-"));
//		assertTrue(Pattern.matches(patternAlfaNumericCollonPlusMinus.getPattern(), "+"));
//		assertTrue(Pattern.matches(patternAlfaNumericCollonPlusMinus.getPattern(), "abc123()+-"));
//
//		assertFalse(Pattern.matches(patternAlfaNumericCollonPlusMinus.getPattern(), " "));
//		assertFalse(Pattern.matches(patternAlfaNumericCollonPlusMinus.getPattern(), " abc123()+-"));
//		assertFalse(Pattern.matches(patternAlfaNumericCollonPlusMinus.getPattern(), "a@"));
//		assertFalse(Pattern.matches(patternAlfaNumericCollonPlusMinus.getPattern(), ";"));
//		assertFalse(Pattern.matches(patternAlfaNumericCollonPlusMinus.getPattern(), ";'"));
//	}

	/**
	 * huruf, spasi dan karakter -'.
	 */
	@Test
	public void testPatternName(){
		assertTrue(Pattern.matches(patternName.getPattern(), "a"));
		assertTrue(Pattern.matches(patternName.getPattern(), " "));
		assertTrue(Pattern.matches(patternName.getPattern(), " a'-."));

		assertFalse(Pattern.matches(patternName.getPattern(), "_"));
		assertFalse(Pattern.matches(patternName.getPattern(), "12"));
		assertFalse(Pattern.matches(patternName.getPattern(), " a& ( ) - ' . , /"));
		assertFalse(Pattern.matches(patternName.getPattern(), "?"));
	}
	
	/**
	 * patternAccountNumber 		= new Regex("[ a-zA-Z0-9]+", 			"huruf, angka dan spasi")
	 */
	@Test
	public void testPatternAccountNumber(){
		assertTrue(Pattern.matches(patternAccountNumber.getPattern(), "a"));
		assertTrue(Pattern.matches(patternAccountNumber.getPattern(), "1"));
		assertTrue(Pattern.matches(patternAccountNumber.getPattern(), "abc1234"));

		assertFalse(Pattern.matches(patternAccountNumber.getPattern(), " 1"));
		assertFalse(Pattern.matches(patternAccountNumber.getPattern(), "_"));
		assertFalse(Pattern.matches(patternAccountNumber.getPattern(), "12,"));
		assertFalse(Pattern.matches(patternAccountNumber.getPattern(), " a& ( ) - ' . , /"));
		assertFalse(Pattern.matches(patternAccountNumber.getPattern(), "?"));
	}
	
	/**
	 * spasi huruf angka & , ( ) - ' /
	 */
//	@Test
//	public void testPatternAddress(){
//		assertTrue(Pattern.matches(patternAddress.getPattern(), "aA123"));
//		assertTrue(Pattern.matches(patternAddress.getPattern(), " "));
//		assertTrue(Pattern.matches(patternAddress.getPattern(), "12"));
//		assertTrue(Pattern.matches(patternAddress.getPattern(), " a1& , ( ) - ' /"));
//		assertTrue(Pattern.matches(patternAddress.getPattern(), " a1-'/,"));
//		
//		assertFalse(Pattern.matches(patternAddress.getPattern(), ".*"));
//		assertFalse(Pattern.matches(patternAddress.getPattern(), "*"));
//		assertFalse(Pattern.matches(patternAddress.getPattern(), "_"));
//		assertFalse(Pattern.matches(patternAddress.getPattern(), " a1-'/,_"));
//	}
	
	/**
	 * huruf, angka, spasi dan karakter &()-'./
	 */
//	@Test
//	public void testPatternGuarantorAddress(){
//		assertTrue(Pattern.matches(patternGuarantorAddress.getPattern(), "aA123"));
//		assertTrue(Pattern.matches(patternGuarantorAddress.getPattern(), " "));
//		assertTrue(Pattern.matches(patternGuarantorAddress.getPattern(), "12"));
//		
//		assertFalse(Pattern.matches(patternGuarantorAddress.getPattern(), " a1& , ( ) - ' /"));
//		assertFalse(Pattern.matches(patternGuarantorAddress.getPattern(), " a1-'/,"));
//		assertFalse(Pattern.matches(patternGuarantorAddress.getPattern(), ".*"));
//		assertFalse(Pattern.matches(patternGuarantorAddress.getPattern(), "*"));
//		assertFalse(Pattern.matches(patternGuarantorAddress.getPattern(), "_"));
//		assertFalse(Pattern.matches(patternGuarantorAddress.getPattern(), " a1-'/,_"));
//	}

	/**
	 * spasi huruf  - ' /
	 * patternDistrict
	 * patternSubDistrict
	 */
	@Test
	public void testPatternDistrict(){
		assertTrue(Pattern.matches(patternDistrict.getPattern(), "a"));
		assertTrue(Pattern.matches(patternDistrict.getPattern(), " "));
		assertTrue(Pattern.matches(patternDistrict.getPattern(), " a-'/"));
		assertTrue(Pattern.matches(patternDistrict.getPattern(), "12"));
		assertFalse(Pattern.matches(patternDistrict.getPattern(), " a1-'/,"));
		assertFalse(Pattern.matches(patternDistrict.getPattern(), ","));
		
		assertTrue(Pattern.matches(patternSubDistrict.getPattern(), "a"));
		assertTrue(Pattern.matches(patternSubDistrict.getPattern(), " "));
		assertTrue(Pattern.matches(patternSubDistrict.getPattern(), " a-'/"));
		assertTrue(Pattern.matches(patternSubDistrict.getPattern(), "12"));
		assertFalse(Pattern.matches(patternSubDistrict.getPattern(), " a1-'/,"));
		assertFalse(Pattern.matches(patternSubDistrict.getPattern(), ","));

	}

	/**
	 * huruf, angka, spasi dan karakter &-',.()
	 */
	@Test
	public void testPatternWorkPlace(){
		assertTrue(Pattern.matches(patternWorkPlace.getPattern(), "a"));
		assertTrue(Pattern.matches(patternWorkPlace.getPattern(), " "));
		assertTrue(Pattern.matches(patternWorkPlace.getPattern(), " a1&-',.()"));

		assertFalse(Pattern.matches(patternWorkPlace.getPattern(), " a1&-',.>"));
		assertFalse(Pattern.matches(patternWorkPlace.getPattern(), ":"));
	}

	@Test
	public void testPatternAlfaNumColonPlusMin(){
		assertTrue(Pattern.matches(patternAlfaNumColonPlusMin.getPattern(), "a"));
		assertTrue(Pattern.matches(patternAlfaNumColonPlusMin.getPattern(), "12"));
		assertTrue(Pattern.matches(patternAlfaNumColonPlusMin.getPattern(), "a1()+-"));

		assertFalse(Pattern.matches(patternAlfaNumColonPlusMin.getPattern(), " "));
		assertFalse(Pattern.matches(patternAlfaNumColonPlusMin.getPattern(), " a1()+-"));
		assertFalse(Pattern.matches(patternAlfaNumColonPlusMin.getPattern(), " "));
	}

	/**
	 * huruf angka ( ) _- ' . /
	 *
	 */
	@Test
	public void testPatternAkadNumber(){
		assertTrue(Pattern.matches(patternAkadNumber.getPattern(), "a"));
		assertTrue(Pattern.matches(patternAkadNumber.getPattern(), "12"));
		assertTrue(Pattern.matches(patternAkadNumber.getPattern(), "a1()_-'./"));
		assertTrue(Pattern.matches(patternAkadNumber.getPattern(), " a1()_- './"));

		assertFalse(Pattern.matches(patternAkadNumber.getPattern(), "a1()_-'./,"));
		assertFalse(Pattern.matches(patternAkadNumber.getPattern(), " ,"));
		assertFalse(Pattern.matches(patternAkadNumber.getPattern(), "?"));
		assertFalse(Pattern.matches(patternAkadNumber.getPattern(), "12x+"));
	}

	/**
	 * huruf, angka, spasi dan karakter ()-'.,
	 */
	@Test
	public void testPatternCompanyName(){
		assertTrue(Pattern.matches(patternCompanyName.getPattern(), "a"));
		assertTrue(Pattern.matches(patternCompanyName.getPattern(), "12"));
		assertTrue(Pattern.matches(patternCompanyName.getPattern(), " a1()-'.,"));

		assertFalse(Pattern.matches(patternCompanyName.getPattern(), " a1* ( ) - ' . ?"));
		assertFalse(Pattern.matches(patternCompanyName.getPattern(), "?"));
		assertFalse(Pattern.matches(patternCompanyName.getPattern(), "12x+"));
	}

	/**
	 * huruf, spasi dan karakter - ' . ,
	 */
	@Test
	public void testPatternCompanyPlace(){
		assertTrue(Pattern.matches(patternCompanyPlace.getPattern(), "a"));
		assertTrue(Pattern.matches(patternCompanyPlace.getPattern(), " a- ' . ,"));
		assertTrue(Pattern.matches(patternCompanyPlace.getPattern(), "kota batam"));
		assertTrue(Pattern.matches(patternCompanyPlace.getPattern(), "kota  batam"));

		assertFalse(Pattern.matches(patternCompanyPlace.getPattern(), "12"));
		assertFalse(Pattern.matches(patternCompanyPlace.getPattern(), " a1* ( ) - ' . ?"));
		assertFalse(Pattern.matches(patternCompanyPlace.getPattern(), "?"));
		assertFalse(Pattern.matches(patternCompanyPlace.getPattern(), "12x+"));
	}

//	/**
//	 * huruf, angka, spasi dan karakter *()_"/
//	 */
//	@Test
//	public void testPatternCompanyAddress(){
//		assertTrue(Pattern.matches(patternCompanyAddress.getPattern(), "a"));
//		assertTrue(Pattern.matches(patternCompanyAddress.getPattern(), " a1*()_\"/"));
//
//		assertFalse(Pattern.matches(patternCompanyAddress.getPattern(), " a1*()_\"/#"));
//		assertFalse(Pattern.matches(patternCompanyAddress.getPattern(), "?"));
//		assertFalse(Pattern.matches(patternCompanyAddress.getPattern(), "12x+"));
//	}

	/**
	 * huruf, angka dan karakter ()_-/+
	 */
	@Test
	public void testPatternRating(){
		assertTrue(Pattern.matches(patternRating.getPattern(), "a"));
		assertTrue(Pattern.matches(patternRating.getPattern(), "a1()_-/+"));

		assertFalse(Pattern.matches(patternRating.getPattern(), " a1()_-/"));
		assertFalse(Pattern.matches(patternRating.getPattern(), "?"));
		assertFalse(Pattern.matches(patternRating.getPattern(), "12x+,"));
	}
	
	//public static Regex patternRatingInstitution 	= new Regex("[0-9[&()_'.,]]+", 				""				);
//	/**
//	 * angka dan karakter & ( ) _ '. ,
//	 */
//	@Test
//	public void testPatternRatingInstitution(){
//		assertTrue(Pattern.matches(patternRatingInstitution.getPattern(), "1"));
//		assertTrue(Pattern.matches(patternRatingInstitution.getPattern(), ","));
//		assertTrue(Pattern.matches(patternRatingInstitution.getPattern(), "123&()_'.,"));
//
//		assertFalse(Pattern.matches(patternRatingInstitution.getPattern(), "a"));
//		assertFalse(Pattern.matches(patternRatingInstitution.getPattern(), " "));
//		assertFalse(Pattern.matches(patternRatingInstitution.getPattern(), " 123&()_'.,"));
//		assertFalse(Pattern.matches(patternRatingInstitution.getPattern(), "a123&()_'.,"));
//	}

	/**
	 * angka dan karakter &()_'.,
	 */
	@Test
	public void testPatternRatingAgency(){
		assertTrue(Pattern.matches(patternRatingAgency.getPattern(), "1"));
		assertTrue(Pattern.matches(patternRatingAgency.getPattern(), "1&()_'.,"));

		assertFalse(Pattern.matches(patternRatingAgency.getPattern(), "abc"));
		assertFalse(Pattern.matches(patternRatingAgency.getPattern(), " 1&()_'.,"));
		assertFalse(Pattern.matches(patternRatingAgency.getPattern(), "?"));
		assertFalse(Pattern.matches(patternRatingAgency.getPattern(), "12x+"));
	}

	//public static Regex patternRatingAgency2 		= new Regex("[a-zA-Z0-9[ -\\+\\-]]+", 		""			);

	/**
	 * huruf, angka, spasi dan karakter - +
	 */
	@Test
	public void testPatternRatingAgency2(){
		assertTrue(Pattern.matches(patternRatingAgency2.getPattern(), "a1 "));
		assertTrue(Pattern.matches(patternRatingAgency2.getPattern(), "a123 -+"));

		assertFalse(Pattern.matches(patternRatingAgency2.getPattern(), "_"));
		assertFalse(Pattern.matches(patternRatingAgency2.getPattern(), "abc."));
		assertFalse(Pattern.matches(patternRatingAgency2.getPattern(), "?"));
		assertFalse(Pattern.matches(patternRatingAgency2.getPattern(), "12x+,"));
	}

	/**
	 * huruf, angka spasi dan karakter &()-'.,
	 */
	@Test
	public void testPatternManagementName(){
		assertTrue(Pattern.matches(patternManagementName.getPattern(), "1"));
		assertTrue(Pattern.matches(patternManagementName.getPattern(), " a1&()-'."));

		assertFalse(Pattern.matches(patternManagementName.getPattern(), " a1&()-'.?"));
		assertFalse(Pattern.matches(patternManagementName.getPattern(), "?"));
		assertFalse(Pattern.matches(patternManagementName.getPattern(), "12x+"));
	}

	/**
	 * huruf, angka spasi dan karakter @#$%^&*(){}[]<>~_-`'\".,:;/?!
	 */
	@Test
	public void testPatternDescription(){
		assertTrue(Pattern.matches(patternDescription.getPattern(), "1"));
		assertTrue(Pattern.matches(patternDescription.getPattern(), " a1@#$%^&*(){}[]<>~_-`'\".,:;/?!"));

		assertFalse(Pattern.matches(patternDescription.getPattern(), " a1@#$%^&*(){}[]<>~_-`'\".,:;/?!+"));
		assertFalse(Pattern.matches(patternDescription.getPattern(), "+"));
		assertFalse(Pattern.matches(patternDescription.getPattern(), "12x+"));
	}

	/**
	 * huruf, angka dan karakter ()_-+/
	 */
	@Test
	public void testPatternCollateralRating(){
		assertTrue(Pattern.matches(patternCollateralRating.getPattern(), "1"));
		assertTrue(Pattern.matches(patternCollateralRating.getPattern(), "a1()_-+/"));

		assertFalse(Pattern.matches(patternCollateralRating.getPattern(), " a1()_-+/"));
		assertFalse(Pattern.matches(patternCollateralRating.getPattern(), "?"));
		assertFalse(Pattern.matches(patternCollateralRating.getPattern(), "12x+*"));
	}

	//public static Regex patternCollateralAppaiser 	= new Regex("[\\w[ \\-'.,]]+", 		"huruf, spasi dan karakter -'.,"				);

	@Test
	public void testPatternCollateralAppaiser(){
		assertTrue(Pattern.matches(patternCollateralAppaiser.getPattern(), "a"));
		assertTrue(Pattern.matches(patternCollateralAppaiser.getPattern(), " a-'.,"));

		assertFalse(Pattern.matches(patternCollateralAppaiser.getPattern(), " a-'.,1"));
		assertFalse(Pattern.matches(patternCollateralAppaiser.getPattern(), "?"));
		assertFalse(Pattern.matches(patternCollateralAppaiser.getPattern(), "12x+*"));
	}

	//public static Regex patternProofOwnership		= new Regex("[a-zA-Z0-9[ \\-.,/]]+", 		"huruf, spasi, angka dan karakter -.,/"				);
	@Test
	public void testPatternProofOwnership(){
		assertTrue(Pattern.matches(patternProofOwnership.getPattern(), "a"));
		assertTrue(Pattern.matches(patternProofOwnership.getPattern(), " a-.,/"));

		assertFalse(Pattern.matches(patternProofOwnership.getPattern(), "&a-'.,1"));
		assertFalse(Pattern.matches(patternProofOwnership.getPattern(), "?"));
		assertFalse(Pattern.matches(patternProofOwnership.getPattern(), "12x+*"));
	}

	//public static Regex patternNameGuaranteed 		= new Regex("[a-zA-Z0-9[()_-'./]]+", 	"huruf, angka dan karakter ( ) _ - ' . /"			);
	@Test
	public void testPatternNameGuaranteed(){
		assertTrue(Pattern.matches(patternNameGuaranteed.getPattern(), "a1()_-'./"));
		assertTrue(Pattern.matches(patternNameGuaranteed.getPattern(), "a"));
		assertTrue(Pattern.matches(patternNameGuaranteed.getPattern(), "1"));
		assertTrue(Pattern.matches(patternNameGuaranteed.getPattern(), "-"));

		assertFalse(Pattern.matches(patternNameGuaranteed.getPattern(), " a-'.,1"));
		assertFalse(Pattern.matches(patternNameGuaranteed.getPattern(), "?"));
		assertFalse(Pattern.matches(patternNameGuaranteed.getPattern(), "12x+*"));
	}

	//public static Regex patternBirthPlace 			= new Regex("[a-zA-Z0-9[ \\-]]+", 			"huruf, angka, spasi dan karakter -");
	@Test
	public void testPatternBirthPlace(){
		assertTrue(Pattern.matches(patternBirthPlace.getPattern(), "123 abc -"));
		assertTrue(Pattern.matches(patternBirthPlace.getPattern(), "1234"));
		assertTrue(Pattern.matches(patternBirthPlace.getPattern(), "aaaaabbbbccc"));
		assertTrue(Pattern.matches(patternBirthPlace.getPattern(), "----"));
		assertTrue(Pattern.matches(patternBirthPlace.getPattern(), "----aaa"));

		assertFalse(Pattern.matches(patternBirthPlace.getPattern(), ","));
	}
	
}
