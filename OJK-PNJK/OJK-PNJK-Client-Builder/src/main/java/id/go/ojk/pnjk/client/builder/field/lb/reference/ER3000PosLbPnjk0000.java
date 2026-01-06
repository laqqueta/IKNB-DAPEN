package id.go.ojk.pnjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3000PosLbPnjk0000 implements IObject<KeyValueString> {
//	R_000001000000 ("000001000000", "Profil Perusahaan"),
	R_000001010000("000001010000", "Nama Perusahaan"), 
	R_000001020000("000001020000", "Nomor Pokok Wajib Pajak (NPWP)"),
	R_000001030000("000001030000", "Alamat Kantor"), 
	R_000001040000("000001040000", "Lokasi Kabupaten/Kota"),
	R_000001050000("000001050000", "Kode Pos"), 
	R_000001060000("000001060000", "Status Kepemilikan Perusahaan"),
	R_000001070000("000001070000", "Bentuk Badan Hukum"), 
	R_000001080000("000001080000", "Tanggal Pendirian"),
	R_000001090000("000001090000", "Jenis Kegiatan Usaha yang Dilakukan"),
//	R_000002000000 ("000002000000", "Organ Perusahaan"),
	R_000002010000("000002010000", "Jumlah Dewan Komisaris"), 
	R_000002020000("000002020000", "Jumlah Direksi"),
	R_000002030000("000002030000", "Jumlah Dewan Pengawas Syariah"),
	R_000002040000("000002040000", "Nama Pimpinan Unit Usaha Syariah (UUS)"),
//	R_000003000000 ("000003000000", "Data Jaringan Kantor"),
	R_000003010000("000003010000", "Jumlah Kantor Pusat"), 
	R_000003020000("000003020000", "Jumlah Kantor UUS"),
	R_000003030000("000003030000", "Jumlah Kantor Cabang"), 
	R_000004000000("000004000000", "Jumlah Pegawai"),
	R_000004010000("000004010000", "Kantor Pusat"), 
	R_000004020000("000004020000", "Kantor UUS"),
	R_000004030000("000004030000", "Kantor Cabang"),
//	R_000005000000 ("000005000000", "Penyusun dan Penanggung Jawab Laporan"),
//	R_000005010000 ("000005010000", "Penyusun Laporan"),
	R_000005010100("000005010100", "Nama Lengkap"), 
	R_000005010200("000005010200", "Jabatan"),
	R_000005010300("000005010300", "Nomor Telepon"), 
	R_000005010400("000005010400", "Nomor Handphone"),
	R_000005010500("000005010500", "Alamat Surat Elektronik (E-Mail)"),
//	R_000005020000 ("000005020000", "Penanggung Jawab Laporan"),
	R_000005020100("000005020100", "Nama Lengkap"), 
	R_000005020200("000005020200", "Jabatan"),
	R_000005020300("000005020300", "Nomor Telepon"), 
	R_000005020400("000005020400", "Nomor Handphone"),
	R_000005020500("000005020500", "Alamat Surat Elektronik (E-Mail)"),;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3000PosLbPnjk0000 eEnum : ER3000PosLbPnjk0000.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3000PosLbPnjk0000.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3000PosLbPnjk0000.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 8 });
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static ConditionalRequired genCondition() {
		return UtilFieldConditional.genExistPos("O", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 11, 12 }));
	}

	public static SegmentValidation genValidationLen100() {
		return UtilSegmentValidation.genMaxLength("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 12, 20, 25 }), 100);
	}

	public static SegmentValidation genValidationLenNpwp() {
		return UtilSegmentValidation.genLength("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 1 }), 15, 16);
	}

	public static SegmentValidation genValidationLen10() {
		return UtilSegmentValidation.genMaxLength("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 3, 5, 6, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19 }), 10);
	}

	public static SegmentValidation genValidationLen5() {
		return UtilSegmentValidation.genLength("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 4 }), 5, 5);
	}

	public static SegmentValidation genValidationLen8() {
		return UtilSegmentValidation.genLength("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 7 }), 8, 8);
	}

	public static SegmentValidation genValidationLen40() {
		return UtilSegmentValidation.genMaxLength("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 21, 26 }), 40);
	}

	public static SegmentValidation genValidationLen15() {
		return UtilSegmentValidation.genMaxLength("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 22, 23, 27, 28 }), 15);
	}

	public static SegmentValidation genValidationLen50() {
		return UtilSegmentValidation.genMaxLength("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 24, 29 }), 50);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 1, 7, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19 }));
	}
	
	public static SegmentValidation genValidationReference1() {
		return UtilSegmentValidation.genRegexReference1("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 3, 4, 5, 6, 8 }));
	}
	
	public static SegmentValidation genValidationPhone() {
		return UtilSegmentValidation.genRegexPhone("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 22, 23, 27, 28 }));
	}
	
	public static SegmentValidation genValidationDate() {
		return UtilSegmentValidation.genRegexDate("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 7 }));
	}
	
	public static SegmentValidation genValidationReference(int rowIdx, int referenceNumber) {
		return UtilSegmentValidation.genReference("2", UtilMetadata.genPipeRow(getObjects(), 
				new int[] { rowIdx }), referenceNumber);
	}
	
	public static SegmentValidation genValidation10() {
		return UtilSegmentValidation.genUniqueValueByRowCode("2", R_000001090000.key);
	}

	public static SegmentValidation genValidation17() {
		return UtilSegmentValidation.genEqualsFormTotalRow("2", R_000003030000.key,
				EFormLaporanBulanan.LB_0020.getCode(), UtilMetadata.genMessage(R_000003030000.value,
						"jumlah kantor yang dilaporkan pada form Rincian Kantor Cabang (form 0020)"));
	}

	public static SegmentValidation genValidation18A() {
		return UtilSegmentValidation.genEqualsFormula("2", R_000004000000.key,
				UtilMetadata.genPlusRow(getObjects(), 17, 19),
				UtilMetadata.genMessage(R_000004000000.key, UtilMetadata.genPlusDesc(getObjects(), 17, 19)));
	}

	public static SegmentValidation genValidation18B() {
		return UtilSegmentValidation.genEqualsFormColumCalculation("2", R_000004000000.key,
				UtilMetadata.genPlusColumn(2, 5), ER3002PosLbPnjk0030.R_0030010000.getKeyForm(),
				UtilMetadata.genMessage(R_000004000000.key,
						"Jumlah pegawai konvensional dan syariah yang dilaporkan pada form \"Rincian Jumlah Pegawai\" (form 0030)"),
				0);
	}
}
