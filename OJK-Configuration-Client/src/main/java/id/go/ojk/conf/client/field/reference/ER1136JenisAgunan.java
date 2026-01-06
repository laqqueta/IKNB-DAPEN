package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1136JenisAgunan implements IObject<KeyValueString> {
	R_1 ("BJ:e2", "Alat-alat Berat"),
	R_2 ("BJ:e3", "Alat-alat Kantor"),
	R_3 ("BJ:e5", "Alat-alat Foto"),
	R_4 ("BJ:e6", "Alat-alat Medis"),
	R_5 ("BJ:e7", "Alat-alat Printer"),
	R_6 ("BJ:e8", "Mesin-mesin"),
	R_7 ("BJ:e9", "Mobil Pengangkutan"),
	R_8 ("BJ:e10", "Gedung"),
	R_9 ("BJ:e11", "Komputer"),
	R_10 ("BJ:e12", "Barang Produktif - Rumah Toko Baru"),
	R_11 ("BJ:e13", "Barang Produktif - Rumah Toko Bekas"),
	R_12 ("BJ:e14", "Barang Produktif - Rumah Kantor Baru"),
	R_13 ("BJ:e15", "Barang Produktif - Rumah Kantor Bekas"),
	R_14 ("BJ:e16", "Barang Produktif - Flat dan Apartemen Baru Pertama"),
	R_15 ("BJ:e17", "Barang Produktif - Flat dan Apartemen Baru Kedua dan seterusnya"),
	R_16 ("BJ:e18", "Barang Produktif - Flat dan Apartemen Bekas Pertama"),
	R_17 ("BJ:e19", "Barang Produktif - Flat dan Apartemen Bekas Kedua dan seterusnya"),
	R_18 ("BJ:e20", "Barang Produktif Lainnya"),
	R_19 ("BJ:e36", "Kendaraan Bermotor Roda Dua Baru"),
	R_20 ("BJ:e37", "Kendaraan Bermotor Roda Dua Bekas"),
	R_21 ("BJ:e38", "Kendaraan Bermotor Roda Empat Baru"),
	R_22 ("BJ:e39", "Kendaraan Bermotor Roda Empat Bekas"),
	R_23 ("BJ:e40", "Rumah Tinggal Baru Pertama"),
	R_24 ("BJ:e41", "Rumah Tinggal Baru Kedua dan seterusnya"),
	R_25 ("BJ:e42", "Rumah Tinggal Bekas Pertama"),
	R_26 ("BJ:e43", "Rumah Tinggal Bekas Kedua dan seterusnya"),
	R_27 ("BJ:e44", "Barang Konsumsi - Rumah Toko Baru"),
	R_28 ("BJ:e45", "Barang Konsumsi - Rumah Toko Bekas"),
	R_29 ("BJ:e46", "Barang Konsumsi - Rumah Kantor Baru"),
	R_30 ("BJ:e47", "Barang Konsumsi - Rumah Kantor Bekas"),
	R_31 ("BJ:e48", "Barang Konsumsi - Flat dan Apartemen Baru Pertama"),
	R_32 ("BJ:e49", "Barang Konsumsi - Flat dan Apartemen Baru Kedua dan seterusnya"),
	R_33 ("BJ:e50", "Barang Konsumsi - Flat dan Apartemen Bekas Pertama"),
	R_34 ("BJ:e51", "Barang Konsumsi - Flat dan Apartemen Bekas Kedua dan seterusnya"),
	R_35 ("BJ:e52", "Alat-alat Rumah Tangga Non Elektronik"),
	R_36 ("BJ:e53", "Barang-barang Elektronik"),
	R_37 ("BJ:e86", "Pesawat Terbang"),
	R_38 ("BJ:e87", "Kapal Laut/Alat Transportasi Air"),
	R_39 ("BJ:e88", "Perahu Nelayan"),
	R_40 ("BJ:e54", "Barang Konsumsi Lainnya"),
	R_41 ("BJ:e63", "Deposito"),
	R_42 ("BJ:e64", "Deposito Mudharabah"),
	R_43 ("BJ:e66", "Emas"),
	R_44 ("BJ:e67", "Logam Mulia Lainnya"),
	R_45 ("BJ:e69", "Sertifikat Bank Indonesia (SBI)"),
	R_46 ("BJ:e70", "Sertifikat Bank Indonesia Syariah"),
	R_47 ("BJ:e71", "Surat Utang Negara (SUN)"),
	R_48 ("BJ:e72", "Surat Perbendaharaan Negara (SPN)"),
	R_49 ("BJ:e73", "Surat Perbendaharaan Negara (SPN) Syariah"),
	R_50 ("BJ:e74", "Obligasi Negara (ON)"),
	R_51 ("BJ:e75", "Obligasi Ritel"),
	R_52 ("BJ:e76", "Surat Berharga Syariah Negara (SBSN)"),
	R_53 ("BJ:e77", "Sukuk Lainnya"),
	R_54 ("BJ:e78", "Saham"),
	R_55 ("BJ:e79", "Reksa Dana"),
	R_56 ("BJ:e80", "Resi Gudang"),
	R_57 ("BJ:e81", "Surat Berharga Lainnya"),
	R_58 ("BJ:e82", "Perhiasan Emas"),
	R_59 ("BJ:e84", "Jaminan Pemerintah"),
	R_60 ("BJ:e85", "Jenis Agunan/Jaminan Lainnya"),
	R_61 ("BJ:e92", "Piutang"),
	R_62 ("BJ:e120", "Standby Letter of Credit (L/C)"),
	R_63 ("BJ:e123", "Asuransi Kredit/Pembiayaan"),
	R_64 ("BJ:e121", "Garansi"),
	R_65 ("BJ:e127", "Tidak Ada Agunan/Jaminan"),
	R_66 ("BJ:e124", "Hak Pakai/Hak Garap"),
	R_67 ("BJ:e125", "Cessie/Hak Tagih"),
	R_68 ("BJ:e94", "Kas"),
	R_69 ("BJ:e95", "Giro"),
	R_70 ("BJ:e96", "Giro Wadiah"),
	R_71 ("BJ:e97", "Tabungan"),
	R_72 ("BJ:e98", "Tabungan Wadiah"),
	R_73 ("BJ:e99", "Tabungan Mudharabah"),
	R_74 ("BJ:e100", "Setoran Jaminan"),
	R_75 ("BJ:e102", "Tanah dan Bangunan"),
	R_76 ("BJ:e103", "Properti Komersial"),
	R_77 ("BJ:e104", "Gedung/Ruang Kantor"),
	R_78 ("BJ:e105", "Gudang"),
	R_79 ("BJ:e106", "Rumah Toko/Rumah Kantor"),
	R_80 ("BJ:e108", "Properti Komersial Lainnya"),
	R_81 ("BJ:e109", "Properti Residensial"),
	R_82 ("BJ:e110", "Rumah Tinggal"),
	R_83 ("BJ:e111", "Apartemen/Rumah Susun"),
	R_84 ("BJ:e112", "Tanah"),
	R_85 ("BJ:e117", "Persediaan"),
	R_86 ("BJ:e118", "Barang Inventaris"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1136JenisAgunan eEnum : ER1136JenisAgunan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1136JenisAgunan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1136JenisAgunan.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1136JenisAgunan[] eEnums = ER1136JenisAgunan.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1136JenisAgunan eEnum = ER1136JenisAgunan.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
