 package id.go.ojk.ppik.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.ppik.client.builder.field.reference.EHeaderMetadataShared;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3000PosLbPpik0000 implements IObject<KeyValueString> {
//	R_000001000000 ("000001000000", "Informasi Perusahaan"),
	R_000001010000 ("000001010000", "Nama Sebutan/Singkatan Perusahaan Pembiayaan Infrastruktur"),
	R_000001020000 ("000001020000", "Nomor Pokok Wajib Pajak (NPWP)"),
	R_000001030000 ("000001030000", "Single Investor Identification (SID)"),
	R_000001040000 ("000001040000", "Status Kepemilikan Perusahaan Pembiayaan Infrastruktur"),
	R_000001050000 ("000001050000", "Bentuk Badan Hukum"),
	R_000001060000 ("000001060000", "Jenis Kegiatan Usaha Syariah yang Dilakukan"),
	R_000001070000 ("000001070000", "Jenis Kegiatan Usaha yang Dilakukan"),
	R_000001080000 ("000001080000", "Status Perusahaan Pembiayaan Infrastruktur"),
	R_000001090000 ("000001090000", "Tanggal Pendirian"),
//	R_000002000000 ("000002000000", "Informasi Alamat Perusahaan"),
	R_000002010000 ("000002010000", "Alamat Lengkap"),
	R_000002020000 ("000002020000", "Lokasi Kabupaten/Kota"),
	R_000002030000 ("000002030000", "Kode Pos"),
	R_000002040000 ("000002040000", "Nomor Telepon"),
	R_000002050000 ("000002050000", "Status Kepemilikan Gedung Kantor"),
	R_000002060000 ("000002060000", "Alamat Situs Web"),
	R_000002070000 ("000002070000", "Alamat Surat Elektronik (Email)"),
//	R_000003000000 ("000003000000", "Informasi Jumlah Pelayanan"),
	R_000003010000 ("000003010000", "Jumlah Kantor Cabang"),
//	R_000004000000 ("000004000000", "Informasi Tenaga Kerja"),
	R_000004010000 ("000004010000", "Jumlah Tenaga Kerja Kantor Pusat"),
	R_000004020000 ("000004020000", "Jumlah Tenaga Kerja Kantor Cabang"),
//	R_000005000000 ("000005000000", "Informasi Penanggung Jawab dan Petugas Penyusun Laporan"),
//	R_000005010000 ("000005010000", "Anggota Direksi Penanggung Jawab Laporan"),
	R_000005010100 ("000005010100", "Nama Lengkap"),
	R_000005010200 ("000005010200", "Jabatan"),
	R_000005010300 ("000005010300", "Nomor Telepon "),
	R_000005010400 ("000005010400", "Alamat Surat Elektronik (Email)"),
//	R_000005020000 ("000005020000", "Petugas Penyusun Laporan"),
	R_000005020100 ("000005020100", "Nama Lengkap"),
	R_000005020200 ("000005020200", "Jabatan "),
	R_000005020300 ("000005020300", "Nomor Telepon "),
	R_000005020400 ("000005020400", "Alamat Surat Elektronik (Email)"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3000PosLbPpik0000 eEnum : ER3000PosLbPpik0000.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3000PosLbPpik0000.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3000PosLbPpik0000.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 5 });
	}
	
	public static String getUniquePos() {
		return UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 5, 6 });
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationLen100() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 19, 23 }),
				100);
	}

	public static SegmentValidation genValidationLen50() {
		return UtilSegmentValidation.genMaxLength("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 14, 15, 22, 26 }), 50);
	}

	public static SegmentValidation genValidationLen20() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 1 }), 20);
	}

	public static SegmentValidation genValidationLen15() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 12, 21, 25 }),
				15);
	}

	public static SegmentValidation genValidationLen16() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 2 }), 16);
	}

	public static SegmentValidation genValidationLen10() {
		return UtilSegmentValidation.genMaxLength("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 3, 4, 5, 6, 7, 10, 16, 17, 18 }), 10);
	}

	public static SegmentValidation genValidationLen8() {
		return UtilSegmentValidation.genLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 8 }), 8, 8);
	}

	public static SegmentValidation genValidationLen5() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 11 }), 5);
	}

	public static SegmentValidation genValidationLen40() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 20, 24 }), 40);
	}

	public static SegmentValidation genValidationNpwp() {
		return UtilSegmentValidation.genRegexNpwp("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 1 }));
	}

	public static SegmentValidation genValidationAlfanumeric() {
		return UtilSegmentValidation.genRegexAlfaNumeric("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 2 }));
	}

	public static SegmentValidation genValidationReference1() {
		return UtilSegmentValidation.genRegexReference1("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 3, 4, 5, 6, 7, 10, 13 }));
	}

	public static SegmentValidation genValidationDate() {
		return UtilSegmentValidation.genRegexDate("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 8 }));
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 11, 16, 17, 18 }));
	}

	public static SegmentValidation genValidationPhone() {
		return UtilSegmentValidation.genRegexPhone2("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 12, 21, 25 }));
	}

	public static SegmentValidation genValidationReferenceStatusKepemilikan() {
		return UtilSegmentValidation.genReference("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 3 }),
				EHeaderMetadataShared.R000.getNumber());
	}

	public static SegmentValidation genValidationReferenceBentukBadanHukum() {
		return UtilSegmentValidation.genReference("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 4 }),
				EHeaderMetadataShared.R001.getNumber());
	}

	public static SegmentValidation genValidationReferenceJenisKegiatanUsahaSyariahYangDilakukan() {
		return UtilSegmentValidation.genReference("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 5 }),
				EHeaderMetadataShared.R039.getNumber());
	}

	public static SegmentValidation genValidationReferenceJenisKegiatanUsahaYangDilakukan() {
		return UtilSegmentValidation.genReference("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 6 }),
				EHeaderMetadataShared.R006.getNumber());
	}

	public static SegmentValidation genValidationReferenceStatusPerusahaanPembiayaanInfrastruktur() {
		return UtilSegmentValidation.genReference("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 7 }),
				EHeaderMetadataShared.R004.getNumber());
	}

	public static SegmentValidation genValidationReferenceLokasiDati2() {
		return UtilSegmentValidation.genReference("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 10 }),
				EHeaderMetadataShared.R033.getNumber());
	}

	public static SegmentValidation genValidationReferenceStatusKepemilikanGedungUnitUsaha() {
		return UtilSegmentValidation.genReference("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 13 }),
				EHeaderMetadataShared.R032.getNumber());
	}

	public static SegmentValidation genRowValidation07() {
		return UtilSegmentValidation.genUniqueValueByRowCode("2", R_000001060000.key);
	}

	public static SegmentValidation genRowValidation08() {
		return UtilSegmentValidation.genUniqueValueByRowCode("2", R_000001070000.key);
	}

	public static SegmentValidation genRowValidation18() {
		return UtilSegmentValidation.genEqualsFormTotalRow("2", R_000003010000.key,
				EFormLaporanBulanan.LB_0020.getCode(),
				UtilMetadata.genMessage(R_000003010000.value, "jumlah kantor yang dilaporkan pada form Rincian Kantor Cabang (form 0020)"));
	}

	public static SegmentValidation genRowValidation19() {
		return UtilSegmentValidation.genEqualsForm("2", R_000004010000.key, EFormLaporanBulanan.LB_0041.getCode(), "11",
				ER3006PosLbPpik0041.R_0041020000.getKey(), R_000004010000.value);
	}

	public static SegmentValidation genRowValidation20A() {
		return UtilSegmentValidation.genEqualsForm("2", R_000004020000.key, EFormLaporanBulanan.LB_0041.getCode(), "11",
				ER3006PosLbPpik0041.R_0041040000.getKey(), R_000004020000.value);
	}

	public static SegmentValidation genRowValidation20B() {
		return UtilSegmentValidation.genEqualsForm("2", R_000004020000.key, EFormLaporanBulanan.LB_0020.getCode(), "10",
				ER3002PosLbPpik0020.R_0020010000.getKey(), R_000004020000.value);
	}
}
