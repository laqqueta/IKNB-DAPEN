package id.go.ojk.ppk.client.builder;

import id.go.ojk.client.constant.ESector;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
	public static final ESector SECTOR = ESector.PPK;
	public static final String METADATA_VERSION = "2.1.6";
	public static final String REFERENCE_VERSION = "2.1.2";
}

/*--Versioning-------------*/

/*Metadata = 
 *2.1.5 = versi awal
 *2.1.6 = penambahan komponen validasi di form 100402

 *Reference =
 *2.1.2 = versi awal 
 **/