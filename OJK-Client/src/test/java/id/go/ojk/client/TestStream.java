package id.go.ojk.client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {


	public static void main(String[] args) {
		List<List<String>> tmps = new ArrayList<List<String>>();
		for( int i = 0; i< 3; i++ ){
			List<String> tmp = new ArrayList<String>();
			for( int j = 0; j< 3; j++ ){
				tmp.add(i + "-" + j);
			}
			tmps.add(tmp);
		}

		String huhu = tmps.stream().flatMap(e -> e.stream()).collect(Collectors.joining("|"));
		System.out.println(huhu);
	}

}
