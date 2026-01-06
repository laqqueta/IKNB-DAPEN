package id.go.ojk.pmvk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2017PosRbPmvk100501 implements IObject<KeyValueString> {
	R_10050101000000 ("10050101000000", "Fasilitas Pinjaman yang Belum Ditarik"),
	R_10050101010000 ("10050101010000", "Dalam Negeri"),
	R_10050101010100 ("10050101010100", "Bank"),
	R_10050101010200 ("10050101010200", "Lembaga Jasa Keuangan Nonbank"),
	R_10050101010300 ("10050101010300", "Lainnya"),
	R_10050101020000 ("10050101020000", "Luar Negeri"),
	R_10050101020100 ("10050101020100", "Bank"),
	R_10050101020200 ("10050101020200", "Lembaga Jasa Keuangan Nonbank"),
	R_10050101020300 ("10050101020300", "Lainnya"),
	R_10050102000000 ("10050102000000", "Fasilitas Pembiayaan/Penyertaan kepada Debitur/Konsumen yang Belum Ditarik"),
	R_10050103000000 ("10050103000000", "Nilai Dana Ventura yang Dikelola "),
	R_10050104000000 ("10050104000000", "Penerbitan Surat Sanggup Bayar"),
	R_10050104010000 ("10050104010000", "Penerbitan Surat Sanggup Bayar di Dalam Negeri"),
	R_10050104020000 ("10050104020000", "Penerbitan Surat Sanggup Bayar di Luar Negeri"),
	R_10050105000000 ("10050105000000", "Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga"),
	R_10050105010000 ("10050105010000", "Kegiatan Pembiayaan Penerusan (Channeling)"),
	R_10050105020000 ("10050105020000", "Kegiatan Pembiayaan Bersama (Joint Financing)"),
	R_10050106000000 ("10050106000000", "Instrumen Derivatif untuk Lindung Nilai"),
	R_10050106010000 ("10050106010000", "Interest Rate Swap"),
	R_10050106020000 ("10050106020000", "Currency Swap"),
	R_10050106030000 ("10050106030000", "Cross Currency Swap"),
	R_10050106040000 ("10050106040000", "Forward"),
	R_10050106050000 ("10050106050000", "Option"),
	R_10050106060000 ("10050106060000", "Future"),
	R_10050106070000 ("10050106070000", "Lainnya"),
	R_10050107000000 ("10050107000000", "Rekening Administratif Lainnya"),
	R_10050107010000 ("10050107010000", "Piutang Pembiayaan Hapus Buku "),
	R_10050107020000 ("10050107020000", "Piutang Pembiayaan Hapus Buku yang Berhasil Ditagih"),
	R_10050107030000 ("10050107030000", "Piutang Pembiayaan Hapus Tagih"),
	R_10050107040000 ("10050107040000", "Pembiayaan Alihan dengan Pengelolaan Penagihan"),
	R_10050108000000 ("10050108000000", "Jumlah"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2017PosRbPmvk100501 eEnum : ER2017PosRbPmvk100501.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2017PosRbPmvk100501.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2017PosRbPmvk100501.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationFasilitasPinjamanBelumDitarik() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10050101000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 1, 5 }),
				"Total Fasilitas Pinjaman yang Belum Ditarik|Penjumlahan Fasilitas Pinjaman yang Belum Ditarik");
	}

	public static SegmentValidation genValidationFasilitasPinjamanBelumDitarikDalamNegeri() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10050101010000.key,
				UtilMetadata.genPlusRow(getObjects(), 2, 4),
				"Total Fasilitas Pinjaman yang Belum Ditarik Dalam Negeri|Penjumlahan Fasilitas Pinjaman yang Belum Ditarik Dalam Negeri");
	}

	public static SegmentValidation genValidationFasilitasPinjamanBelumDitarikLuarNegeri() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10050101020000.key,
				UtilMetadata.genPlusRow(getObjects(), 6, 8),
				"Total Fasilitas Pinjaman yang Belum Ditarik Luar Negeri|Penjumlahan Fasilitas Pinjaman yang Belum Ditarik Luar Negeri");
	}

	public static SegmentValidation genValidationPenerbitanSuratSanggupBayar() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10050104000000.key,
				UtilMetadata.genPlusRow(getObjects(), 12, 13),
				"Total Penerbitan Surat Sanggup Bayar|Penjumlahan Penerbitan Surat Sanggup Bayar");
	}

	public static SegmentValidation genValidationPenyaluranPembiayaanBersamaPorsiPihakKetiga() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10050105000000.key,
				UtilMetadata.genPlusRow(getObjects(), 15, 16),
				"Total Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga|Penjumlahan Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga");
	}

	public static SegmentValidation genValidationInstrumenDerivatifUntukLindungNilai() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10050106000000.key,
				UtilMetadata.genPlusRow(getObjects(), 18, 24),
				"Total Instrumen Derivatif untuk Lindung Nilai|Penjumlahan Instrumen Derivatif untuk Lindung Nilai");
	}

	public static SegmentValidation genValidationRekeningAdministratifLainnya() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10050107000000.key,
				UtilMetadata.genPlusRow(getObjects(), 26, 29),
				"Total Rekening Administratif Lainnya|Penjumlahan Rekening Administratif Lainnya");
	}

	public static SegmentValidation genValidationJumlah() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10050108000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 9, 10, 11, 14, 17, 25 }), "Jumlah|Penjumlahan dari rincian");
	}
}
