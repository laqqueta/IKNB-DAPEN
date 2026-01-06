package id.go.ojk.pnmk.client.builder.field.lb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1152JenisKantorSelainKantorPusat;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulananUus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3100PosLbPnmu0000 implements IObject<KeyValueString> {
//	R_000001000000 ("000001000000", "Informasi Perusahaan"),
	R_000001010000 ("000001010000", "Nama Perusahaan"),
	R_000001020000 ("000001020000", "Nomor Pokok Wajib Pajak (NPWP)"),
	R_000001030000 ("000001030000", "Alamat Kantor"),
	R_000001040000 ("000001040000", "Periode Pelaporan"),
//	R_000001050000 ("000001050000", "Organ Perusahaan"),
	R_000001050100 ("000001050100", "Jumlah Dewan Komisaris"),
	R_000001050200 ("000001050200", "Jumlah Anggota Direksi"),
	R_000001050300 ("000001050300", "Jumlah Dewan Pengawas Syariah"),
	R_000001060000 ("000001060000", "Nama Pimpinan UUS"),
	R_000001070000 ("000001070000", "Direktur yang Membawahi UUS"),
//	R_000001080000 ("000001080000", "Data Jaringan Kantor"),
	R_000001080100 ("000001080100", "Kantor Pusat UUS"),
//	R_000001080200 ("000001080200", "Kantor selain Kantor Pusat"),
	R_000001080201 ("000001080201", "Kantor Cabang Unit Layanan Modal Mikro (ULaMM) Syariah"),
	R_000001080202 ("000001080202", "Kantor Unit ULaMM Syariah"),
	R_000001080203 ("000001080203", "Kantor Cabang Membina Ekonomi Keluarga Sejahtera (Mekaar Syariah)"),
	R_000001090000 ("000001090000", "Total Jumlah Pegawai"),
	R_000001090100 ("000001090100", "Kantor Pusat UUS"),
//	R_000001090200 ("000001090200", "Kantor selain Kantor Pusat"),
	R_000001090201 ("000001090201", "Kantor Cabang ULaMM Syariah"),
	R_000001090202 ("000001090202", "Kantor Unit ULaMM Syariah"),
	R_000001090203 ("000001090203", "Kantor Cabang Mekaar Syariah"),
//	R_000002000000 ("000002000000", "Penyusun dan Penanggung Jawab Laporan"),
//	R_000002010000 ("000002010000", "Penyusun Laporan"),
	R_000002010100 ("000002010100", "Nama Lengkap"),
	R_000002010200 ("000002010200", "Jabatan"),
	R_000002010300 ("000002010300", "Nomor Telepon "),
	R_000002010400 ("000002010400", "Nomor Handphone"),
	R_000002010500 ("000002010500", "Alamat Surat Elektronik (Email)"),
//	R_000002020000 ("000002020000", "Penanggung Jawab Laporan"),
	R_000002020100 ("000002020100", "Nama Lengkap"),
	R_000002020200 ("000002020200", "Jabatan "),
	R_000002020300 ("000002020300", "Nomor Telepon "),
	R_000002020400 ("000002020400", "Nomor Handphone"),
	R_000002020500 ("000002020500", "Alamat Surat Elektronik (Email)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3100PosLbPnmu0000 eEnum : ER3100PosLbPnmu0000.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3100PosLbPnmu0000.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3100PosLbPnmu0000.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationLen100() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 7, 8, 18, 23 }),
				100);
	}

	public static SegmentValidation genValidationLen15() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 1 }),
				15);
	}

	public static SegmentValidation genValidationLen8() {
		return UtilSegmentValidation.genLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 3 }), 8, 8);
	}

	public static SegmentValidation genValidationLen2() {
		return UtilSegmentValidation.genMaxLength("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 4, 5, 6 }), 2);
	}

	public static SegmentValidation genValidationLen6() {
		return UtilSegmentValidation.genMaxLength("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 13, 14, 15, 16, 17 }), 6);
	}

	public static SegmentValidation genValidationLen4() {
		return UtilSegmentValidation.genMaxLength("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 9, 10, 11, 12 }), 4);
	}

	public static SegmentValidation genValidationLen50() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 19, 22, 24, 27 }), 50);
	}

	public static SegmentValidation genValidationLen20() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 20, 21, 25, 26 }), 20);
	}

	public static SegmentValidation genValidationNpwp() {
		return UtilSegmentValidation.genRegexNpwp("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 1 }));
	}

	public static SegmentValidation genValidationDate() {
		return UtilSegmentValidation.genRegexDate("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 3 }));
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 4, 5, 6, 9, 10, 11, 12, 13, 14, 15, 16, 17 }));
	}

	public static SegmentValidation genValidationPhone() {
		return UtilSegmentValidation.genRegexPhone("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 20, 21, 25, 26 }));
	}

	public static SegmentValidation genRowValidation05() {
		return UtilSegmentValidation.genHeaderPeriod("2", R_000001040000.key);
	}

	public static SegmentValidation genRowValidation12() {
		ER1152JenisKantorSelainKantorPusat kantor = ER1152JenisKantorSelainKantorPusat.R_1;
		return UtilSegmentValidation.genEqualsFormTotalRow("2", R_000001080201.key,
				EFormLaporanBulananUus.LB_0020.getCode(), "2", kantor.getKey(),
				UtilMetadata.genMessage(R_000001080201.value, messageForm0020(kantor.getValue())));
	}

	public static SegmentValidation genRowValidation13() {
		ER1152JenisKantorSelainKantorPusat kantor = ER1152JenisKantorSelainKantorPusat.R_2;
		return UtilSegmentValidation.genEqualsFormTotalRow("2", R_000001080202.key,
				EFormLaporanBulananUus.LB_0020.getCode(), "2", kantor.getKey(),
				UtilMetadata.genMessage(R_000001080202.value, messageForm0020(kantor.getValue())));
	}

	public static SegmentValidation genRowValidation14() {
		ER1152JenisKantorSelainKantorPusat kantor = ER1152JenisKantorSelainKantorPusat.R_3;
		return UtilSegmentValidation.genEqualsFormTotalRow("2", R_000001080203.key,
				EFormLaporanBulananUus.LB_0020.getCode(), "2", kantor.getKey(),
				UtilMetadata.genMessage(R_000001080203.value, messageForm0020(kantor.getValue())));
	}

	public static SegmentValidation genRowValidation15() {
		String form = EFormLaporanBulananUus.LB_0030.getCode();
		return UtilSegmentValidation.genEqualsFormColumCalculation("2", R_000001090000.key, "2+3", 
				ER3102PosLbPnmu0030.R_0030040000.getFormKey(),
				UtilMetadata.genMessage(R_000001090000.value, "jumlah Konvensional + UUS pada Rincian Jumlah Pegawai (Form " + form + ")"), 0);
	}
	
	private static String messageForm0020(String kantor) {
		return "jumlah " + kantor + " pada Rincian Kantor Selain Kantor Pusat (Form 0020)";
	}
}
