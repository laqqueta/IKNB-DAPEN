package id.go.ojk.fink.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.fink.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.fink.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3000PosLbFink0000 implements IObject<KeyValueString> {
	R_000001000000("000001000000", "Nama Perusahaan "),
	R_000002000000("000002000000", "Nama Platform"),
	R_000003000000("000003000000", "Alamat Website"),
	R_000004000000("000004000000", "Mobile Platform (ada atau tidak ada)"),
	R_000005000000("000005000000", "Nama Mobile Platform"),
	R_000006000000("000006000000", "Bulan dan Tahun mulai beroperasi"),
	R_000007000000("000007000000", "Tanggal Terdaftar"),
	R_000008000000("000008000000", "Tanggal Berizin"),
	R_000009000000("000009000000", "Nama Direktur Utama"),
	R_000010000000("000010000000", "Nomor HP Direktur Utama"),
	R_000011000000("000011000000", "Email Direktur Utama"),
	R_000012000000("000012000000", "Nama Contact Person"),
	R_000013000000("000013000000", "Jabatan Contact Person"),
	R_000014000000("000014000000", "Nomor HP Contact Person"),
	R_000015000000("000015000000", "Email Contact Person"),
	R_000016000000("000016000000", "Alamat Kantor"),
	R_000017000000("000017000000", "DATI I (Provinsi)"),
	R_000018000000("000018000000", "DATI II (Kabupaten/Kotamadya)"),
	R_000019000000("000019000000", "Telepon Kantor"),
	R_000020000000("000020000000", "TKB 90 (dalam %)"),
	R_000021000000("000021000000", "Nilai Pendanaan Outstanding"),
	R_000022000000("000022000000", "Nama Produk Layanan Pendanaan"),
	R_000023000000("000023000000", "Jumlah Tenaga Kerja Pria"),
	R_000024000000("000024000000", "Jumlah Tenaga Kerja Wanita"),
	R_000025000000("000025000000", "Jumlah Kantor Cabang"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3000PosLbFink0000 eEnum : ER3000PosLbFink0000.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3000PosLbFink0000.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3000PosLbFink0000.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static ConditionalRequired genConditional() {
		return UtilFieldConditional.genFintech("M", R_000008000000.key, "O", R_000005000000.key, R_000004000000.key,
				"1", "M", "N");
	}
	
	public static SegmentValidation genValidationLjkName() {
		return UtilSegmentValidation.genRegexLjkName("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 4 }));
	}
	
	public static SegmentValidation genValidationName2() {
		return UtilSegmentValidation.genRegexName2("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 2 }));
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 3, 20, 22, 23, 24 }));
	}
	
	public static SegmentValidation genValidationDate() {
		return UtilSegmentValidation.genRegexDate("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 5, 6, 7 }));
	}
	
	public static SegmentValidation genValidationName4() {
		return UtilSegmentValidation.genRegexName4("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 8, 11 }));
	}
	
	public static SegmentValidation genValidationPhone() {
		return UtilSegmentValidation.genRegexPhone("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 9, 13, 18 }));
	}
	
	public static SegmentValidation genValidationEmail() {
		return UtilSegmentValidation.genRegexEmail("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 10, 14 }));
	}
	
	public static SegmentValidation genValidationAlfaNumericSpace() {
		return UtilSegmentValidation.genRegexAlfaNumericSpace("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 12 }));
	}
	
	public static SegmentValidation genValidationLjkAddress() {
		return UtilSegmentValidation.genRegexLjkAddress("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 15 }));
	}
	
	public static SegmentValidation genValidationAlfaNumeric() {
		return UtilSegmentValidation.genRegexAlfaNumeric("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 16, 17 }));
	}
	
	public static SegmentValidation genValidationDecimal() {
		return UtilSegmentValidation.genRegexNumericDot("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 19 }));
	}

	public static SegmentValidation genValidationLen100() {
		return UtilSegmentValidation.genMaxLength("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 4, 12 }), 100);
	}
	
	public static SegmentValidation genValidationLen1() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 3 }),
				1);
	}

	public static SegmentValidation genValidationLen8() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 5, 6, 7 }), 8);
	}

	public static SegmentValidation genValidationLen150() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 8, 11 }), 150);
	}

	public static SegmentValidation genValidationLen25() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 9, 13, 18 }),
				25);
	}

	public static SegmentValidation genValidationLen75() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 10, 14 }), 75);
	}

	public static SegmentValidation genValidationLen200() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 15, 21 }),
				200);
	}

	public static SegmentValidation genValidationLen4() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 16, 17 }), 4);
	}

	public static SegmentValidation genValidationLen6() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 19 }), 6);
	}

	public static SegmentValidation genValidationLen16() {
		return UtilSegmentValidation.genMaxLength("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 20, 22, 23, 24 }), 16);
	}

	public static SegmentValidation genValidationReferenceAvailable() {
		return UtilSegmentValidation.genReference("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 3 }),
				EHeaderMetadataShared.R002.getNumber());
	}

	public static SegmentValidation genValidationReferenceDati1() {
		return UtilSegmentValidation.genReference("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 16 }),
				EHeaderMetadataShared.R000.getNumber());
	}

	public static SegmentValidation genValidationReferenceDati2() {
		return UtilSegmentValidation.genReference("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 17 }),
				EHeaderMetadataShared.R001.getNumber());
	}

	public static SegmentValidation genRowValidation20A() {
		return UtilSegmentValidation.genEqualsForm3("2", R_000020000000.key, EFormLaporanBulanan.LB_6903.getCode(), "2",
				ER3011PosLbFink6903.R_690305000000.getKey(), "100",
				UtilMetadata.genMessage(R_000020000000.value, "100% - Rasio Pendanaan Macet pada form 6903"));
	}

	public static SegmentValidation genRowValidation20B() {
		return UtilSegmentValidation.genEqualsForm("2", R_000020000000.key, EFormLaporanBulanan.LB_6908.getCode(), "4",
				ER3013PosLbFink6908.R_690807000000.getKey(),
				UtilMetadata.genMessage(R_000020000000.value, "TKB 90 (dalam %) pada form 6908 kolom 5"));
	}

	public static SegmentValidation genRowValidation21A() {
		return UtilSegmentValidation.genEqualsForm("2", R_000021000000.key, EFormLaporanBulanan.LB_6902.getCode(), "3",
				ER3010PosLbFink6902.R_690203030000.getKey(),
				UtilMetadata.genMessage(R_000021000000.value, "Agregat (Total) pada form 6902"));
	}

	public static SegmentValidation genRowValidation21B() {
		return UtilSegmentValidation.genEqualsForm("2", R_000021000000.key, EFormLaporanBulanan.LB_6908.getCode(), "4",
				ER3013PosLbFink6908.R_690806000000.getKey(),
				UtilMetadata.genMessage(R_000021000000.value, "Total Pendanaan pada form 6908 kolom 5"));
	}
}
