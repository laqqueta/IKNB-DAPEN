package id.go.ojk.client.service.validation;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import id.go.ojk.client.model.validation.ValidationError;

public class TestValidationUtil {

	@Test
	public void validateDateTest(){
		List<ValidationError> errors = new ArrayList<>();
		LocalDate localDate = ValidationUtil.validateDate(null, "20160431", errors, null, null, true);
		assertEquals(1, errors.size());
//		System.out.println(errors.size());
//		System.out.println(localDate);
		
		errors = new ArrayList<>();
		localDate = ValidationUtil.validateDate(null, "20160430", errors, null, null, true);
		assertEquals(0, errors.size());
		//assertNull(object);
//		System.out.println(errors.size());
//		System.out.println(localDate);
	}
	
	@Test
	public void hashTest(){
		System.out.println(ValidationUtil.createHashCode(new int[]{1,3,5}, new String[] {"0a", "1	B", "2c", "3 d", "4e", "5       F", "6G", "7h"}));
		System.out.println(ValidationUtil.createHashCode(new int[]{1,3,5}, new String[] {"0a", "1	B", "2c", "3 d", "4e", "5       F", "6G", "7h"}));
		System.out.println(ValidationUtil.createHashCode(new int[]{1,3,5}, new String[] {"0a", "1	B", "2c", "3 d", "4e", "5       F", "6G", "7h"}));
	}

}
