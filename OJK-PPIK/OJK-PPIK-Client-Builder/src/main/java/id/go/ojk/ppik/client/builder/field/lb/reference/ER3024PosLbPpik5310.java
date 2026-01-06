 package id.go.ojk.ppik.client.builder.field.lb.reference;

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
public enum ER3024PosLbPpik5310 implements IObject<KeyValueString> {
//	R_53100100000000 ("53100100000000", "I.    ASET"),
	R_53100101000000 ("53100101000000", "Pembiayaan"),
	R_53100101010000 ("53100101010000", "Pemberian Pinjaman Langsung (Direct Lending) untuk Pembiayaan Infrastruktur Neto"),
	R_53100101010100 ("53100101010100", "Pemberian Pinjaman Langsung (Direct Lending) untuk Pembiayaan Infrastruktur Pokok"),
	R_53100101010200 ("53100101010200", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Pemberian Pinjaman Langsung (Direct Lending) untuk Pembiayaan Infrastruktur"),
	R_53100101020000 ("53100101020000", "Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain Neto"),
	R_53100101020100 ("53100101020100", "Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain Pokok"),
	R_53100101020200 ("53100101020200", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain"),
	R_53100101030000 ("53100101030000", "Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur Neto"),
	R_53100101030100 ("53100101030100", "Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur Pokok"),
	R_53100101030200 ("53100101030200", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur"),
	R_53100101040000 ("53100101040000", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan Neto"),
	R_53100101040100 ("53100101040100", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan Pokok"),
	R_53100101040200 ("53100101040200", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan"),
	R_53100101050000 ("53100101050000", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah Neto"),
	R_53100101050100 ("53100101050100", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah Pokok"),
	R_53100101050200 ("53100101050200", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah"),
	R_53100101060000 ("53100101060000", "Piutang Pembiayaan Berdasarkan Prinsip Syariah"),
	R_53100101060100 ("53100101060100", "Pemberian Pembiayaan Langsung (Direct Financing) untuk Pembiayaan Infrastruktur Berdasarkan Prinsip Syariah Neto"),
	R_53100101060101 ("53100101060101", "Pemberian Pembiayaan Langsung (Direct Financing) untuk Pembiayaan Infrastruktur Berdasarkan Prinsip Syariah Pokok"),
	R_53100101060102 ("53100101060102", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Pemberian Pembiayaan Langsung (Direct Financing) untuk Pembiayaan Infrastruktur Berdasarkan Prinsip Syariah"),
	R_53100101060200 ("53100101060200", "Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain Berdasarkan Prinsip Syariah Neto"),
	R_53100101060201 ("53100101060201", "Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain Berdasarkan Prinsip Syariah Pokok"),
	R_53100101060202 ("53100101060202", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain Berdasarkan Prinsip Syariah"),
	R_53100101060300 ("53100101060300", "Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Prinsip Syariah Neto"),
	R_53100101060301 ("53100101060301", "Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Prinsip Syariah Pokok"),
	R_53100101060302 ("53100101060302", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Prinsip Syariah"),
	R_53100101060400 ("53100101060400", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan Berdasarkan Prinsip Syariah Neto "),
	R_53100101060401 ("53100101060401", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan Berdasarkan Prinsip Syariah Pokok "),
	R_53100101060402 ("53100101060402", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan Berdasarkan Prinsip Syariah"),
	R_53100101060500 ("53100101060500", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah Berdasarkan Prinsip Syariah Neto"),
	R_53100101060501 ("53100101060501", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah Berdasarkan Prinsip Syariah Pokok"),
	R_53100101060502 ("53100101060502", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah Berdasarkan Prinsip Syariah"),
	R_53100102000000 ("53100102000000", "Aset Non Pembiayaan"),
	R_53100200000000 ("53100200000000", "Total Aset"),
//	R_53100300000000 ("53100300000000", "II.  LIABILITAS"),
	R_53100301000000 ("53100301000000", "Pinjaman/Pendanaan yang Diterima "),
	R_53100302000000 ("53100302000000", "Surat Berharga yang Diterbitkan "),
	R_53100303000000 ("53100303000000", "Liabilitas Selain Pinjaman/Pendanaan dan Surat Berharga yang Diterbitkan"),
	R_53100400000000 ("53100400000000", "Total Liabilitas"),
	R_53100500000000 ("53100500000000", "Total Aset dan Liabilitas"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3024PosLbPpik5310 eEnum : ER3024PosLbPpik5310.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3024PosLbPpik5310.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3024PosLbPpik5310.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 16), getObjects());
	}
	
	public static FieldValidation genFieldValidation8() {
		return UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(2, 7));
	}
	
	public static FieldValidation genFieldValidation15() {
		return UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(9, 14));
	}
	
	public static FieldValidation genFieldValidation16() {
		return UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(new int[] { 8, 15 }));
	}
	
	public static SegmentValidation genRowValidation02() {
		int[] fields = new int[] { 1, 4, 7, 10, 13 };
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(2, 7) + "|" + UtilMetadata.genPipeColumn(9, 14), R_53100101000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_53100101000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation03() {
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(2, 7) + "|" + UtilMetadata.genPipeColumn(9, 14), R_53100101010000.key,
				UtilMetadata.genMinusRow(getObjects(), 2, 3),
				UtilMetadata.genMessage(R_53100101010000.value, UtilMetadata.genMinusDesc(getObjects(), 2, 3)));
	}
	
	public static SegmentValidation genRowValidation06() {
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(2, 7) + "|" + UtilMetadata.genPipeColumn(9, 14), R_53100101020000.key,
				UtilMetadata.genMinusRow(getObjects(), 5, 6),
				UtilMetadata.genMessage(R_53100101020000.value, UtilMetadata.genMinusDesc(getObjects(), 5, 6)));
	}
	
	public static SegmentValidation genRowValidation09() {
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(2, 7) + "|" + UtilMetadata.genPipeColumn(9, 14), R_53100101030000.key,
				UtilMetadata.genMinusRow(getObjects(), 8, 9),
				UtilMetadata.genMessage(R_53100101030000.value, UtilMetadata.genMinusDesc(getObjects(), 8, 9)));
	}
	
	public static SegmentValidation genRowValidation12() {
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(2, 7) + "|" + UtilMetadata.genPipeColumn(9, 14), R_53100101040000.key,
				UtilMetadata.genMinusRow(getObjects(), 11, 12),
				UtilMetadata.genMessage(R_53100101040000.value, UtilMetadata.genMinusDesc(getObjects(), 11, 12)));
	}
	
	public static SegmentValidation genRowValidation15() {
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(2, 7) + "|" + UtilMetadata.genPipeColumn(9, 14), R_53100101050000.key,
				UtilMetadata.genMinusRow(getObjects(), 14, 15),
				UtilMetadata.genMessage(R_53100101050000.value, UtilMetadata.genMinusDesc(getObjects(), 14, 15)));
	}
	
	public static SegmentValidation genRowValidation18() {
		int[] fields = new int[] { 17, 20, 23, 26, 29 };
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(2, 7) + "|" + UtilMetadata.genPipeColumn(9, 14), R_53100101060000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_53100101060000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation19() {
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(2, 7) + "|" + UtilMetadata.genPipeColumn(9, 14), R_53100101060100.key,
				UtilMetadata.genMinusRow(getObjects(), 18, 19),
				UtilMetadata.genMessage(R_53100101060100.value, UtilMetadata.genMinusDesc(getObjects(), 18, 19)));
	}
	
	public static SegmentValidation genRowValidation22() {
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(2, 7) + "|" + UtilMetadata.genPipeColumn(9, 14), R_53100101060200.key,
				UtilMetadata.genMinusRow(getObjects(), 21, 22),
				UtilMetadata.genMessage(R_53100101060200.value,
						UtilMetadata.genMinusDesc(getObjects(), 21, 22)));
	}
	
	public static SegmentValidation genRowValidation25() {
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(2, 7) + "|" + UtilMetadata.genPipeColumn(9, 14), R_53100101060300.key,
				UtilMetadata.genMinusRow(getObjects(), 24, 25),
				UtilMetadata.genMessage(R_53100101060300.value, UtilMetadata.genMinusDesc(getObjects(), 24, 25)));
	}
	
	public static SegmentValidation genRowValidation28() {
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(2, 7) + "|" + UtilMetadata.genPipeColumn(9, 14), R_53100101060400.key,
				UtilMetadata.genMinusRow(getObjects(), 27, 28),
				UtilMetadata.genMessage(R_53100101060400.value, UtilMetadata.genMinusDesc(getObjects(), 27, 28)));
	}
	
	public static SegmentValidation genRowValidation31() {
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(2, 7) + "|" + UtilMetadata.genPipeColumn(9, 14), R_53100101060500.key,
				UtilMetadata.genMinusRow(getObjects(), 30, 31),
				UtilMetadata.genMessage(R_53100101060500.value, UtilMetadata.genMinusDesc(getObjects(), 30, 31)));
	}

	public static SegmentValidation genRowValidation34A() {
		int[] fields = new int[] { 0, 9, 10, 69, 73, 76, 80, 83, 86, 87 };
		return UtilSegmentValidation.genEqualsFormulaForm("8", R_53100102000000.key, "2",
				UtilMetadata.genPlusRow(ER3009PosLbPpik1100.getFormObjects(), fields),
				UtilMetadata.genMessage(R_53100102000000.value, messageForm1100Rupiah(UtilMetadata.genPlusDesc(ER3009PosLbPpik1100.getObjects(), fields))));
	}

	public static SegmentValidation genRowValidation34B() {
		int[] fields = new int[] { 0, 9, 10, 69, 73, 76, 80, 83, 86, 87 };
		return UtilSegmentValidation.genEqualsFormulaForm("15", R_53100102000000.key, "3",
				UtilMetadata.genPlusRow(ER3009PosLbPpik1100.getFormObjects(), fields),
				UtilMetadata.genMessage(R_53100102000000.value, messageForm1100NonRupiah(UtilMetadata.genPlusDesc(ER3009PosLbPpik1100.getObjects(), fields))));
	}
	
	public static SegmentValidation genRowValidation35() {
		int[] fields = new int[] { 0, 16, 32 };
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(2, 7) + "|" + UtilMetadata.genPipeColumn(9, 14), R_53100200000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_53100200000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation38A() {
		int[] fields = new int[] { 89, 95, 96, 110, 111, 112, 115, 116 };
		return UtilSegmentValidation.genEqualsFormulaForm("8", R_53100303000000.key, "2",
				UtilMetadata.genPlusRow(ER3009PosLbPpik1100.getFormObjects(), fields),
				UtilMetadata.genMessage(R_53100303000000.value, messageForm1100Rupiah(UtilMetadata.genPlusDesc(ER3009PosLbPpik1100.getObjects(), fields))));
	}

	public static SegmentValidation genRowValidation38B() {
		int[] fields = new int[] { 89, 95, 96, 110, 111, 112, 115, 116 };
		return UtilSegmentValidation.genEqualsFormulaForm("15", R_53100303000000.key, "3",
				UtilMetadata.genPlusRow(ER3009PosLbPpik1100.getFormObjects(), fields),
				UtilMetadata.genMessage(R_53100303000000.value, messageForm1100NonRupiah(UtilMetadata.genPlusDesc(ER3009PosLbPpik1100.getObjects(), fields))));
	}
	
	public static SegmentValidation genRowValidation39A() {
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(2, 7) + "|" + UtilMetadata.genPipeColumn(9, 14), R_53100400000000.key,
				UtilMetadata.genPlusRow(getObjects(), 34, 36),
				UtilMetadata.genMessage(R_53100400000000.value, UtilMetadata.genPlusDesc(getObjects(), 34, 36)));
	}

	public static SegmentValidation genRowValidation39B() {
		int[] fields = new int[] { 89, 95, 96, 97, 109, 110, 111, 112, 115, 116 };
		return UtilSegmentValidation.genEqualsFormulaForm("8", R_53100400000000.key, "2",
				UtilMetadata.genPlusRow(ER3009PosLbPpik1100.getFormObjects(), fields),
				UtilMetadata.genMessage(R_53100400000000.value, messageForm1100Rupiah(UtilMetadata.genPlusDesc(ER3009PosLbPpik1100.getObjects(), fields))));
	}

	public static SegmentValidation genRowValidation39C() {
		int[] fields = new int[] { 89, 95, 96, 97, 109, 110, 111, 112, 115, 116 };
		return UtilSegmentValidation.genEqualsFormulaForm("15", R_53100400000000.key, "3",
				UtilMetadata.genPlusRow(ER3009PosLbPpik1100.getFormObjects(), fields),
				UtilMetadata.genMessage(R_53100400000000.value, messageForm1100NonRupiah(UtilMetadata.genPlusDesc(ER3009PosLbPpik1100.getObjects(), fields))));
	}
	
	public static SegmentValidation genRowValidation40() {
		int[] fields = new int[] { 33, 37 };
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(2, 7) + "|" + UtilMetadata.genPipeColumn(9, 14), R_53100500000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_53100500000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	private static String messageForm1100Rupiah(String fields) {
		return messageForm1100(fields, "rupiah");
	}
	
	private static String messageForm1100NonRupiah(String fields) {
		return messageForm1100(fields, "mata uang asing");
	}
	
	private static String messageForm1100(String fields, String valas) {
		return fields + " pada neraca (1100) kolom " + valas;
	}
}
