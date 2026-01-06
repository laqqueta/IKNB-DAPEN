package id.go.ojk.lib.client.model.constant;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Comparation {
	e	( 	"=", 	"sama dengan", 				(d1, d2) -> d1.compareTo(d2) == 0,	(d1, d2) -> d1 == d2,	(d1, d2) -> d1 == d2,	(d1, d2) -> d1.equals(d2)	),
	ne	( 	"!=", 	"tidak sama dengan", 		(d1, d2) -> d1.compareTo(d2) != 0,	(d1, d2) -> d1 != d2,	(d1, d2) -> d1 != d2,	(d1, d2) -> !d1.equals(d2)	),
	lt	( 	"<", 	"lebih kecil", 				(d1, d2) -> d1.compareTo(d2) < 0, 	(d1, d2) -> d1 < d2, 	(d1, d2) -> d1 < d2,	(d1, d2) -> false			),
	lte	( 	"<=", 	"lebih kecil/sama dengan", 	(d1, d2) -> d1.compareTo(d2) <= 0, 	(d1, d2) -> d1 <= d2, 	(d1, d2) -> d1 <= d2,	(d1, d2) -> false			),
	gt	( 	">", 	"lebih besar", 				(d1, d2) -> d1.compareTo(d2) > 0, 	(d1, d2) -> d1 > d2, 	(d1, d2) -> d1 > d2,	(d1, d2) -> false			),
	gte	( 	">=", 	"lebih besar/sama dengan", 	(d1, d2) -> d1.compareTo(d2) >= 0, 	(d1, d2) -> d1 >= d2, 	(d1, d2) -> d1 >= d2,	(d1, d2) -> false			),
	na	( 	"", 	"Not Applicable", 			(d1, d2) -> true, 					(d1, d2) -> true, 		(d1, d2) -> true,		(d1, d2) -> false			)
	;

	private String code;
	private String desc;
	private ComparationTester<LocalDate> localDateTest;
	private LongComparationTester longTest;
	private DoubleComparationTester doubleTest;
	private ComparationTester<String> stringTest;

	private Comparation(String code, String desc, ComparationTester<LocalDate> localDateTest, LongComparationTester longTest, DoubleComparationTester doubleTest, ComparationTester<String> stringTest){
		this.code = code;
		this.desc = desc;
		this.localDateTest = localDateTest;
		this.longTest = longTest;
		this.doubleTest = doubleTest;
		this.stringTest = stringTest;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public boolean testCompareDate(LocalDate d1, LocalDate d2){
		return localDateTest.test(d1, d2);
	}

	public boolean testCompareLong(long d1, long d2){
		return longTest.test(d1, d2);
	}

	public boolean testCompareDouble(double d1, double d2){
		return doubleTest.test(d1, d2);
	}


	public boolean testCompareString(String v1, String v2){
		return stringTest.test(v1, v2);
	}

	
	public static List<String> getValueList(){
		return Arrays.asList(Comparation.values()).stream().map( e -> e.name()).collect(Collectors.toList());
	}

}



