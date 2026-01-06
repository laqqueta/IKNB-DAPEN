package id.go.ojk.lpei.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5000PosLbLpeig0000 implements IObject<KeyValueString> {
	//	R_000001000000 ("000001000000", "Profil LPEI"),
	//	R_000002000000 ("000002000000", "Informasi Perusahaan"),
	R_000002010000 ("000002010000", "Kode Perusahaan"),
	R_000002020000 ("000002020000", "Nama Perusahaan"),
	R_000002030000 ("000002030000", "Nomor NPWP"),
	R_000002040000 ("000002040000", "Single Investor Identification (SID)"),
	R_000002050000 ("000002050000", "Tanggal Pendirian"),
	R_000002060000 ("000002060000", "Jenis Kegiatan Usaha yang Dilakukan"),
	R_000002070000 ("000002070000", "Alamat Perusahaan"),
	R_000002080000 ("000002080000", "Lokasi Kota/Kabupaten"),
	R_000002090000 ("000002090000", "Kode Pos"),
	R_000002100000 ("000002100000", "Nomor Telepon"),
	R_000002110000 ("000002110000", "Status Kepemilikan Gedung Kantor"),
	R_000002120000 ("000002120000", "Alamat Situs Web"),
	R_000002130000 ("000002130000", "Alamat Surat Elektronik (email)"),
	//	R_000003000000 ("000003000000", "Jumlah Kantor Pelayanan"),
	R_000003010000 ("000003010000", "Jumlah Kantor Diluar Kantor Pusat"),
	//	R_000004000000 ("000004000000", "Jumlah Tenaga Kerja"),
	R_000004010000 ("000004010000", "Jumlah Tenaga Kerja Kantor Pusat"),
	R_000004020000 ("000004020000", "Jumlah Tenaga Kerja Kantor Diluar Kantor Pusat"),
	//	R_000005000000 ("000005000000", "Direktur Pelaksana Penanggung Jawab Dan Petugas Penyusun"),
	//	R_000005010000 ("000005010000", "Direktur Pelaksana Penanggung Jawab Laporan"),
	R_000005010100 ("000005010100", "Nama Lengkap"),
	R_000005010200 ("000005010200", "Jabatan"),
	R_000005010300 ("000005010300", "Nomor Telepon"),
	R_000005010400 ("000005010400", "Alamat Surat Elektronik (email)"),
	//	R_000006010000 ("000006010000", "Petugas Penyusun Laporan"),
	R_000006010100 ("000006010100", "Nama Lengkap"),
	R_000006010200 ("000006010200", "Jabatan"),
	R_000006010300 ("000006010300", "Nomor Telepon"),
	R_000006010400 ("000006010400", "Alamat Surat Elektronik (email)"),
	;

	@Getter
	private String key;
	private String value;

	@Override
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER5000PosLbLpeig0000 eEnum : ER5000PosLbLpeig0000.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER5000PosLbLpeig0000.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER5000PosLbLpeig0000.class.getSimpleName().substring(2, 6));
	}

	/*
	 * Unique and required validation
	 */
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String getUniquePos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}

	/*
	 * Length validation
	 */
	public static SegmentValidation genValidationLength5() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 8 }), 5);
	}

	public static SegmentValidation genValidationLength8() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 4 }), 8);
	}

	public static SegmentValidation genValidationLength10() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 0, 7, 10, 13, 14, 15, 17}), 10);
	}

	public static SegmentValidation genValidationLength12() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 9, 18, 22 }), 12);
	}

	public static SegmentValidation genValidationLength15to16() {
		return UtilSegmentValidation.genLength("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 2 }), 15, 16);
	}

	public static SegmentValidation genValidationLength50() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 11, 12, 19, 23 }), 50);
	}

	/*
	 * Pattern validation
	 */
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 0, 2, 8, 9, 13, 14, 15, 18, 22 }));
	}

	public static SegmentValidation genValidationAlfanumeric() {
		return UtilSegmentValidation.genRegexAlfaNumeric("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 3 }));
	}

	public static SegmentValidation genValidationAlfa() {
		return UtilSegmentValidation.genRegexAlfa("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 5 }));
	}

	public static SegmentValidation genValidationDate() {
		return UtilSegmentValidation.genRegexDate("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 4 }));
	}

	public static SegmentValidation genValidationNpwp() {
		return UtilSegmentValidation.genRegexNpwp("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 2 }));
	}

	public static SegmentValidation genValidationWebAddress() {
		return UtilSegmentValidation.genRegexWebAddress("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 11 }));
	}

	public static SegmentValidation genValidationReference1() {
		return UtilSegmentValidation.genRegexReference1("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 7, 10, 17 }));
	}

	/*
	 * Reference validation
	 */
	public static SegmentValidation genValidationDati2() {
		return UtilSegmentValidation.genReference("2", R_000002080000.key, String.valueOf(EHeaderMetadataShared.R033.getNumber()));
	}

	public static SegmentValidation genValidationStatusKepemilikanGedung() {
		return UtilSegmentValidation.genReference("2", R_000002110000.key, String.valueOf(EHeaderMetadataShared.R032.getNumber()));
	}

	public static SegmentValidation genValidationJabatan() {
		return UtilSegmentValidation.genReference("2", R_000005010200.key, String.valueOf(EHeaderMetadataShared.R003.getNumber()));
	}

	/*
	 * Form validation
	 */
	public static SegmentValidation genRowValidation15() {
		return UtilSegmentValidation.genEqualsFormTotalRow(
				"2", R_000003010000.key, EFormLaporanBulanan.LB_0020.getCode(),
				UtilMetadata.genMessage(R_000003010000.value, "Total baris pada form 0020"));
	}

	public static SegmentValidation genRowValidation16() {
		return UtilSegmentValidation.genEqualsForm("2", R_000004010000.key, EFormLaporanBulanan.LB_0041.getCode(), "13",
				ER5003PosLbLpeig0041.R_0041020000.getKey());
	}

	public static SegmentValidation genRowValidation17() {
		return UtilSegmentValidation.genEqualsForm("2", R_000004020000.key, EFormLaporanBulanan.LB_0041.getCode(), "13",
				ER5003PosLbLpeig0041.R_0041040000.getKey());
	}
}
