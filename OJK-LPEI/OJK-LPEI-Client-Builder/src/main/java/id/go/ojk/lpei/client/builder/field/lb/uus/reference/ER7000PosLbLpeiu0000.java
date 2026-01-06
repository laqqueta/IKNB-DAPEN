package id.go.ojk.lpei.client.builder.field.lb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7000PosLbLpeiu0000 implements IObject<KeyValueString> {
	//	R_000001000000 ("000001000000","Porfil LPEI"),
	//	R_000002000000 ("000002000000","INFORMASI UUS"),
	R_000002010000 ("000002010000","Jenis Kegiatan Usaha Syariah yang Dilakukan"),
	R_000002020000 ("000002020000","Nomor Surat Pencatatan UUS"),
	R_000002030000 ("000002030000","Tanggal Pencatatan UUS"),
	R_000002040000 ("000002040000","Nama Pimpinan UUS"),
	//	R_000003000000 ("000003000000","ALAMAT UUS"),
	R_000003010000 ("000003010000","Alamat Lengkap"),
	R_000003020000 ("000003020000","Lokasi Kabupaten/Kota"),
	R_000003030000 ("000003030000","Kode Pos"),
	R_000003040000 ("000003040000","Nomor Telepon"),
	R_000003050000 ("000003050000","Status Kepemilikan Gedung Kantor"),
	R_000003060000 ("000003060000","Alamat Situs Web"),
	R_000003070000 ("000003070000","Alamat Surat Elektronik (Email)"),
	//	R_000004000000 ("000004000000","JUMLAH KANTOR PELAYANAN"),
	R_000005000000 ("000005000000","Jumlah Kantor di Luar Kantor Pusat UUS"),
	//	R_000006000000 ("000006000000","JUMLAH TENAGA KERJA"),
	R_000006010000 ("000006010000","Jumlah Tenaga Kerja Kantor Pusat UUS"),
	R_000006020000 ("000006020000","Jumlah Tenaga Kerja Kantor di Luar Kantor Pusat UUS"),
	//	R_000007000000 ("000007000000","DIREKTUR PELAKSANA PENANGGUNG JAWAB DAN PETUGAS PENYUSUN"),
	//	R_000007010000 ("000007010000","Direktur Pelaksana Penanggung Jawab Laporan"),
	R_000007010100 ("000007010100","Nama Lengkap"),
	R_000007010200 ("000007010200","Jabatan"),
	R_000007010300 ("000007010300","Nomor Telepon"),
	R_000007010400 ("000007010400","Alamat Surat Elektronik (Email)"),
	//	R_000007020000 ("000007020000","Petugas Penyusun Laporan"),
	R_000007020100 ("000007020100","Nama Lengkap"),
	R_000007020200 ("000007020200","Jabatan"),
	R_000007020300 ("000007020300","Nomor Telepon"),
	R_000007020400 ("000007020400","Alamat Surat Elektronik (Email)"),
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
		for (ER7000PosLbLpeiu0000 eEnum : ER7000PosLbLpeiu0000.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER7000PosLbLpeiu0000.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER7000PosLbLpeiu0000.class.getSimpleName().substring(2, 6));
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
				new int[] { 6 }), 5);
	}

	public static SegmentValidation genValidationLength8() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 2 }), 8);
	}

	public static SegmentValidation genValidationLength10() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 5, 8, 11, 15 }), 10);
	}

	public static SegmentValidation genValidationLength15() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 7, 16, 20 }), 15);
	}

	public static SegmentValidation genValidationLength25() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 1 }), 25);
	}

	/*
	 * Pattern validation
	 */
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 6, 7, 11, 12, 13, 16, 20 }));
	}

	public static SegmentValidation genValidationDate() {
		return UtilSegmentValidation.genRegexDate("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 2 }));
	}

	public static SegmentValidation genValidationWebAddress() {
		return UtilSegmentValidation.genRegexWebAddress("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 9 }));
	}

	public static SegmentValidation genValidationEmailAddress() {
		return UtilSegmentValidation.genRegexEmail("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 10, 21, 17 }));
	}

	public static SegmentValidation genValidationReference1() {
		return UtilSegmentValidation.genRegexReference1("2", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 5, 8, 15 }));
	}

	/*
	 * Reference validation
	 */
	public static SegmentValidation genValidationDati2() {
		return UtilSegmentValidation.genReference("2", R_000003020000.key, String.valueOf(EHeaderMetadataShared.R033.getNumber()));
	}

	public static SegmentValidation genValidationStatusKepemilikanGedung() {
		return UtilSegmentValidation.genReference("2", R_000003050000.key, String.valueOf(EHeaderMetadataShared.R032.getNumber()));
	}

	public static SegmentValidation genValidationJabatan() {
		return UtilSegmentValidation.genReference("2", R_000007010200.key, String.valueOf(EHeaderMetadataShared.R003.getNumber()));
	}

	/*
	 * Form validation
	 */
	public static SegmentValidation genRowValidation15() {
		return UtilSegmentValidation.genEqualsFormTotalRow(
				"2", R_000005000000.key, EFormLaporanBulananUus.LB_0020.getCode(),
				UtilMetadata.genMessage(R_000005000000.value, "Total baris pada form 0020"));
	}

	public static SegmentValidation genRowValidation16() {
		return UtilSegmentValidation.genEqualsForm("2", R_000006010000.key, EFormLaporanBulananUus.LB_0041.getCode(), "13",
				ER7003PosLbLpeiu0041.R_0041020000.getKey());
	}

	public static SegmentValidation genRowValidation17() {
		return UtilSegmentValidation.genEqualsForm("2", R_000006020000.key, EFormLaporanBulanan.LB_0041.getCode(), "13",
				ER7003PosLbLpeiu0041.R_0041040000.getKey());
	}
}
