package id.go.ojk.lib.client;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

public class CollectionUtil {

	public static Map<String, String> toMap(String value, String separator, String keyValueSeparator, boolean order){
		Map<String, String> result = order ? new TreeMap<String, String>() : new HashMap<String, String>();
		if( value == null )
			return result;
		String[] valueSplited = value.split(separator);
		for (String item : valueSplited) {
			String itemSplited[] = item.split(keyValueSeparator);
			if ( itemSplited.length == 2 )
				result.put(itemSplited[0], itemSplited[1]);
		}
		return result;
	}

	public static Map<String, String> toMap(String value){
		return toMap(value, "&", "=", true);
	}

	public static int[] toIntArray(String value, String separator){
		String[] valueSplited = value.split(separator);
		int[] result = new int[valueSplited.length];
		for( int i=0; i<valueSplited.length ;i++ ){
			result[i] = Integer.parseInt(valueSplited[i]);
		}
		return result;
	}

	public static List<Integer> toIntList(String value){
		int[] intArray = toIntArray(value);
		List<Integer> result = new ArrayList<>();
		for (int i : intArray) {
			result.add(i);
		}
		return result;
	}

	public static int[] toIntArray(String value){
		return toIntArray(value, "[|]");
	}
	
	public static String intListToString(List<Integer> integers){
		return StringUtils.join(integers, "|");
	}
	
	public static String[] toStringArray(String value, String separator){
		String[] valueSplited = value.split(separator);
		return valueSplited;
	}

	public static String[] toStringArray(String value){
		return toStringArray(value, "[|]");
	}

	public static String arrayToString(String[] values){
		return arrayToString(values, "|");
	}

	public static String arrayToString(String[] values, String separator){
		if ( values == null || values.length == 0)
			return null;
		return StringUtils.join(values, separator);
	}

	public static boolean isNotEmpty(Collection<?> collections){
		return !isEmpty(collections);
	}
	
	public static boolean isEmpty(Collection<?> collections){
		return collections == null ? true : collections.isEmpty();
	}


	public static Integer[] toIntegerArray(String value, String separator){
		String[] valueSplited = value.split(separator);
		Integer[] result = new Integer[valueSplited.length];
		for( int i=0; i<valueSplited.length ;i++ ){
			result[i] = Integer.parseInt(valueSplited[i]);
		}
		return result;
	}

	public static Integer[] toIntegerArray(String value){
		return toIntegerArray(value, "[|]");
	}

	public static <E>List<E> toArrayList(E[] inputs){
		List<E> list = new ArrayList<>();
		for (E e : inputs) {
			list.add(e);
		}
		return list;
	}
	
	public static <E>E[] toArray(Class<E> c, List<E> inputList){
		@SuppressWarnings("unchecked")
		E[] result = (E[]) Array.newInstance(c, inputList.size());
		int index = 0;
		for (E e : inputList) {
			result[index++] = e;
		}
				
		return result;
	}

	
	public static String intArrayToString(int[] values){
		return intArrayToString(values, "|");
	}

	public static String intArrayToString(int[] values, String separator){
		List<Integer> integerList = new ArrayList<>();
		for (int i : values) {
			integerList.add(i);
		}
		if ( values == null || values.length == 0)
			return "";
		String result = StringUtils.join(integerList, separator);
		return result;
	}

	public static boolean isAllNotNull(Object ... objects){
		for (Object object : objects) {
			if ( object == null )
				return false;
		}
		return true;
	}
	
	public static List<String> toStringList(String input){
		String[] strings = toStringArray(input);
		ArrayList<String> resuls = new ArrayList<>();
		for (String string : strings) {
			resuls.add(string);
		}
		return resuls;
	}

	public static  Set<String> toStringSet(String input){
		String[] strings = toStringArray(input);
		HashSet<String> resuls = new HashSet<>();
		for (String string : strings) {
			resuls.add(string);
		}
		return resuls;
	}

	
	public static int[] toIntArrayDetailOrRange(String value){
		if ( StringUtils.isEmpty(value) )
			return new int[0];
		
		if ( value.contains("-") ) {
			String[] values = value.split("[-]");
			List<Integer> tmp = IntStream
				.rangeClosed(Integer.parseInt(values[0]), Integer.parseInt(values[1]))
				.boxed().collect(Collectors.toList());
			int[] result = new int[tmp.size()];
			for (int i=0 ; i <result.length; i++) {
				result[i] = tmp.get(i).intValue();
			}
			return result;
		} else {
			return toIntArray(value);
		}
	}
	
	public static String rangeIntConcate(int start, int end){
		return IntStream.rangeClosed(start, end).boxed().map( e -> e.toString()).collect(Collectors.joining("|"));
	}

}
