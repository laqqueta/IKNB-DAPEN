package id.go.ojk.client.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import id.go.ojk.lib.client.model.YearMonth;

public class YearMonthTest {

	@Test
	public void test1FromLocalDate(){
		YearMonth yearMonth = YearMonth.from(LocalDate.of(2016, 5, 1));
		assertTrue(yearMonth.compareTo(new YearMonth(2016, 5)) == 0);
	}
	
	@Test
	public void test1FromString(){
		YearMonth yearMonth = YearMonth.from("201605");
		assertTrue(yearMonth.compareTo(new YearMonth(2016, 5)) == 0);
	}

	@Test
	public void test1Compare(){
		assertTrue((new YearMonth(2016, 5)).compareTo(new YearMonth(2016, 5)) == 0);
		
		assertTrue((new YearMonth(2016, 5)).compareTo(new YearMonth(2016, 4)) > 0);
		assertTrue((new YearMonth(2016, 5)).compareTo(new YearMonth(2016, 6)) < 0);
		
		assertTrue((new YearMonth(2016, 5)).compareTo(new YearMonth(2015, 5)) > 0);
		assertTrue((new YearMonth(2016, 5)).compareTo(new YearMonth(2017, 5)) < 0);
	}

	@Test
	public void test1MontDifference(){
		assertEquals(0, (new YearMonth(2016, 5)).monthDifference(new YearMonth(2016, 5)));
		assertEquals(2, (new YearMonth(2016, 5)).monthDifference(new YearMonth(2016, 3)));
		assertEquals(-2, (new YearMonth(2016, 5)).monthDifference(new YearMonth(2016, 7)));
		
		assertEquals(12, (new YearMonth(2016, 5)).monthDifference(new YearMonth(2015, 5)));
		assertEquals(-12, (new YearMonth(2016, 5)).monthDifference(new YearMonth(2017, 5)));		
	}
	
	@Test
	public void test1lagi(){
		assertEquals(new YearMonth(2016, 6), (new YearMonth(2016, 5)).addMonth(1) );
		assertEquals(new YearMonth(2016, 4), (new YearMonth(2016, 5)).addMonth(-1) );
		
		assertEquals(new YearMonth(2016, 12), (new YearMonth(2016, 5)).addMonth(7) );
		assertEquals(new YearMonth(2017, 1), (new YearMonth(2016, 5)).addMonth(8) );
		assertEquals(new YearMonth(2015, 12), (new YearMonth(2016, 5)).addMonth(-5) );
		assertEquals(new YearMonth(2015, 11), (new YearMonth(2016, 5)).addMonth(-6) );
	}

	
}
