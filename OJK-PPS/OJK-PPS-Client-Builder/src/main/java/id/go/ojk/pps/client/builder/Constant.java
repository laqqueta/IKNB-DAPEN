package id.go.ojk.pps.client.builder;

import id.go.ojk.client.constant.ESector;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
	public static final ESector SECTOR = ESector.PPS;
	public static String METADATA_VERSION = "2.1.6";
	public static String REFERENCE_VERSION = "2.1.2";
}

/*--Versioning-------------*/

/*Metadata = 
 *2.1.5 = versi awal
 *2.1.6 = penambahan komponen validasi di form 100402

 *Reference =
 *2.1.2 = versi awal 
 **/