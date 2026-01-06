package id.go.ojk.pmvs.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2267PosRePmvs100502 implements IObject<KeyValueString> {
	R_10050201000000 ("10050201000000", "Fasilitas Pendanaan yang Belum Ditarik"),
	R_10050201010000 ("10050201010000", "Dalam Negeri"),
	R_10050201010100 ("10050201010100", "Bank Syariah"),
	R_10050201010200 ("10050201010200", "Lembaga Jasa Keuangan Nonbank Syariah"),
	R_10050201010300 ("10050201010300", "Lainnya"),
	R_10050201020000 ("10050201020000", "Luar Negeri"),
	R_10050201020100 ("10050201020100", "Bank Syariah"),
	R_10050201020200 ("10050201020200", "Lembaga Jasa Keuangan Nonbank Syariah"),
	R_10050201020300 ("10050201020300", "Lainnya"),
	R_10050202000000 ("10050202000000", "Fasilitas Pembiayaan/Penyertaan kepada Pasangan Usaha yang Belum Ditarik"),
	R_10050203000000 ("10050203000000", "Nilai Dana Ventura yang Dikelola "),
	R_10050204000000 ("10050204000000", "Penerbitan Surat Sanggup Bayar dengan Prinsip Syariah"),
	R_10050204010000 ("10050204010000", "Penerbitan Surat Sanggup Bayar di Dalam Negeri"),
	R_10050204020000 ("10050204020000", "Penerbitan Surat Sanggup Bayar di Luar Negeri"),
	R_10050205000000 ("10050205000000", "Penyaluran Pembiayaan dengan skema Pembiayaan Penerusan (Channeling)"),
	R_10050206000000 ("10050206000000", "Instrumen Derivatif untuk Lindung Nilai Syariah"),
	R_10050206010000 ("10050206010000", "Spot"),
	R_10050206020000 ("10050206020000", "Forward Agreement"),
	R_10050207000000 ("10050207000000", "Rekening Administratif Lainnya"),
	R_10050207010000 ("10050207010000", "Aset Investasi Hapus Buku "),
	R_10050207020000 ("10050207020000", "Aset Investasi Hapus Buku yang Berhasil Ditagih"),
	R_10050207030000 ("10050207030000", "Aset Investasi Hapus Tagih"),
	R_10050207040000 ("10050207040000", "Pembiayaan Alihan dengan Pengelolaan Penagihan"),
	R_10050208000000 ("10050208000000", "Jumlah"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2267PosRePmvs100502 eEnum : ER2267PosRePmvs100502.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2267PosRePmvs100502.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2267PosRePmvs100502.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4", getObjects());
	}
	
	public static FieldValidation genValidationSum() {
		return UtilFieldValidation.genEqualsPosFormula("3-2", 0, UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 1, 5, 11, 15, 18, 23 }));
	}

	public static SegmentValidation genValidationFasilitasPendanaanBelumDitarik() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10050201000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 1, 5 }),
				"Total Fasilitas Pendanaan yang Belum Ditarik|Penjumlahan Fasilitas Pendanaan yang Belum Ditarik");
	}

	public static SegmentValidation genValidationFasilitasPendanaanBelumDitarikDalamNegeri() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10050201010000.key,
				UtilMetadata.genPlusRow(getObjects(), 2, 4),
				"Total Fasilitas Pendanaan yang Belum Ditarik Dalam Negeri|Penjumlahan Fasilitas Pendanaan yang Belum Ditarik Dalam Negeri");
	}

	public static SegmentValidation genValidationFasilitasPendanaanBelumDitarikLuarNegeri() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10050201020000.key,
				UtilMetadata.genPlusRow(getObjects(), 6, 8),
				"Total Fasilitas Pendanaan yang Belum Ditarik Luar Negeri|Penjumlahan Fasilitas Pendanaan yang Belum Ditarik Luar Negeri");
	}

	public static SegmentValidation genValidationPenerbitanSuratSanggupBayar() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10050204000000.key,
				UtilMetadata.genPlusRow(getObjects(), 12, 13),
				"Total Penerbitan Surat Sanggup Bayar dengan Prinsip Syariah|Penjumlahan Penerbitan Surat Sanggup Bayar dengan Prinsip Syariah");
	}

	public static SegmentValidation genValidationInstrumenDerivatifUntukLindungNilai() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10050206000000.key,
				UtilMetadata.genPlusRow(getObjects(), 16, 17),
				"Total Instrumen Derivatif untuk Lindung Nilai Syariah|Penjumlahan Instrumen Derivatif untuk Lindung Nilai Syariah");
	}

	public static SegmentValidation genValidationRekeningAdministratifLainnya() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10050207000000.key,
				UtilMetadata.genPlusRow(getObjects(), 19, 22),
				"Total Rekening Administratif Lainnya|Penjumlahan Rekening Administratif Lainnya");
	}

	public static SegmentValidation genValidationJumlah() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10050208000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 9, 10, 11, 14, 15, 18 }), "Total|Penjumlahan dari rincian");
	}
}
