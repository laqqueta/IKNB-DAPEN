package id.go.ojk.client;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.service.security.BCryptPasswordEncoder;


public class TestBcrypt {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String plain = "aA@123";

		List<String> hashs = new ArrayList<>();
		for( int i=0; i<3; i++ ){
			hashs.add(passwordEncoder.encode(plain));
		}

		for (String hash : hashs) {
			System.out.println("hash " + hash);
			System.out.println(plain);
			System.out.println( passwordEncoder.matches(plain, hash));
		}

		System.out.println("================");

		for (String hash : hashs) {
			System.out.println("hash " + hash);
			System.out.println( passwordEncoder.matches("123451", hash));
		}

	}

}
