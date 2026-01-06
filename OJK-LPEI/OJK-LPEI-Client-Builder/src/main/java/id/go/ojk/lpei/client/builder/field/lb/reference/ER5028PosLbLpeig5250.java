package id.go.ojk.lpei.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5028PosLbLpeig5250 implements IObject<KeyValueString> {
	//	R_52500100000000 ("52500100000000","LAPORAN POSISI KEUANGAN"),
	R_52500101000000 ("52500101000000","Aset Valas"),
	R_52500101010000 ("52500101010000","Kas"),
	R_52500101020000 ("52500101020000","Penempatan pada Bank Indonesia"),
	R_52500101030000 ("52500101030000","Penempatan pada Bank"),
	R_52500101030100 ("52500101030100","Impairment"),
	R_52500101040000 ("52500101040000","Surat Berharga yang Dimiliki"),
	R_52500101050000 ("52500101050000","Tagihan Derivatif"),
	R_52500101050100 ("52500101050100","Impairment"),
	R_52500101060000 ("52500101060000","Tagihan Akseptasi"),
	R_52500101060100 ("52500101060100","Impairment"),
	R_52500101070000 ("52500101070000","Pembiayaan"),
	R_52500101070100 ("52500101070100","Bank"),
	R_52500101070200 ("52500101070200","Nonbank"),
	R_52500101070201 ("52500101070201","Impairment"),
	R_52500101080000 ("52500101080000","Pembiayaan berdasarkan Prinsip Syariah"),
	R_52500101080100 ("52500101080100","Impairment"),
	R_52500101090000 ("52500101090000","Piutang Premi Asuransi dan Imbal Jasa Penjaminan"),
	R_52500101090100 ("52500101090100","Impairment"),
	R_52500101100000 ("52500101100000","Piutang Reasuransi"),
	R_52500101110000 ("52500101110000","Penyertaan Modal"),
	R_52500101110100 ("52500101110100","Impairment"),
	R_52500101120000 ("52500101120000","Aset Tetap Kantor Cabang di Luar Negeri - Bersih"),
	R_52500101130000 ("52500101130000","Pendapatan yang Masih Harus Diterima"),
	R_52500101140000 ("52500101140000","Rupa-Rupa Aset"),
	R_52500102000000 ("52500102000000","Liabilitas Valas"),
	R_52500102010000 ("52500102010000","Liabilitas Akseptasi"),
	R_52500102020000 ("52500102020000","Surat Berharga/Surat Berharga Syariah yang Diterbitkan"),
	R_52500102030000 ("52500102030000","Liabilitas Derivatif"),
	R_52500102040000 ("52500102040000","Pendanaan yang Diterima"),
	R_52500102050000 ("52500102050000","Estimasi Kerugian Komitmen dan Kontinjensi"),
	R_52500102060000 ("52500102060000","Utang Klaim"),
	R_52500102070000 ("52500102070000","Utang Premi Reasuransi"),
	R_52500102080000 ("52500102080000","Utang Imbal Jasa Penjaminan Ulang"),
	R_52500102090000 ("52500102090000","Utang Komisi"),
	R_52500102100000 ("52500102100000","Premi Asuransi dan Imbal Jasa Penjaminan"),
	R_52500102110000 ("52500102110000","Estimasi Klaim Retensi Sendiri"),
	R_52500102120000 ("52500102120000","Rupa-Rupa Liabilitas"),
	R_52500102120100 ("52500102120100","Biaya Bunga yang Masih Harus Dibayar"),
	R_52500102120200 ("52500102120200","Jaminan Impor"),
	R_52500102120300 ("52500102120300","Transaksi Repo"),
	R_52500102120400 ("52500102120400","Lain-Lain"),
	R_52500103000000 ("52500103000000","POSISI DEVISA NETO LAPORAN POSISI KEUANGAN BERSIH"),
	//	R_52500200000000 ("52500200000000","REKENING ADMINISTRATIF"),
	R_52500201000000 ("52500201000000","Rekening Administratif Tagihan Valas dan Transaksi Derivatif"),
	R_52500201010000 ("52500201010000","Rekening Administratif"),
	R_52500201020000 ("52500201020000","Kontrak Pembelian Forward"),
	R_52500201030000 ("52500201030000","Kontrak Pembelian Futures"),
	R_52500201040000 ("52500201040000","Kontrak Pembelian SWAP"),
	R_52500201050000 ("52500201050000","Transaksi Derivatif di Luar Kontrak Pembelian Forward, Futures, dan Option"),
	R_52500202000000 ("52500202000000","Rekening Administratif Liabilitas Valas dan Transaksi Derivatif"),
	R_52500202010000 ("52500202010000","Rekening Administratif"),
	R_52500202020000 ("52500202020000","Kontrak Penjualan Forward"),
	R_52500202030000 ("52500202030000","Kontrak Penjualan Futures"),
	R_52500202040000 ("52500202040000","Kontrak Penjualan SWAP"),
	R_52500202050000 ("52500202050000","Transaksi Derivatif di Luar Kontrak Pembelian Forward, Futures, dan Option"),
	//	R_52500300000000 ("52500300000000","KONTRAK OPTION"),
	R_52500301000000 ("52500301000000","Kontrak Option"),
	R_52500301010000 ("52500301010000","Kontrak Penjualan Put Option (LPEI sebagai Writer)"),
	R_52500301020000 ("52500301020000","Kontrak Pembelian Put Option (LPEI sebagai Holder, Khusus Option yang Identik)"),
	R_52500301030000 ("52500301030000","Kontrak Penjualan Call Option (LPEI sebagai Writer)"),
	R_52500301040000 ("52500301040000","Kontrak Pembelian Call Option (LPEI sebagai Holder, Khusus Option yang Identik)"),
	R_52500302000000 ("52500302000000","Kontrak Option"),
	R_52500302010000 ("52500302010000","Kontrak Pembelian Put Option (LPEI sebagai writer)"),
	R_52500302020000 ("52500302020000","Kontrak Penjualan Put Option (LPEI sebagai Holder, Khusus Option yang Identik)"),
	R_52500302030000 ("52500302030000","Kontrak Pembelian Call Option (LPEI sebagai Writer)"),
	R_52500302040000 ("52500302040000","Kontrak Penjualan Call Option (LPEI sebagai Holder, Khusus Option yang Identik)"),
	R_52500303000000 ("52500303000000","POSISI DEVISA NETO REKENING ADMINISTRATIF BERSIH"),
	//	R_52500400000000 ("52500400000000","POSISI STRUKTURAL"),
	R_52500401000000 ("52500401000000","Posisi Struktural Aset"),
	R_52500402000000 ("52500402000000","Posisi Struktural Liabilitas"),
	R_52500403000000 ("52500403000000","POSISI STRUKTURAL BERSIH"),
	//	R_52500500000000 ("52500500000000","MODAL KPMM"),
	R_52500501000000 ("52500501000000","POSISI DEVISA NETO LAPORAN POSISI KEUANGAN (Absolut)"),
	R_52500502000000 ("52500502000000","POSISI DEVISA NETO KESELURUHAN (Absolut)"),
	R_52500503000000 ("52500503000000","RASIO POSISI DEVISA NETO LAPORAN POSISI KEUANGAN"),
	R_52500504000000 ("52500504000000","RASIO POSISI DEVISA NETO KESELURUHAN"),
	R_52500505000000 ("52500505000000","KURS REUTERS"),
	R_52500600000000 ("52500600000000","JUMLAH"),
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
		for (ER5028PosLbLpeig5250 eEnum : ER5028PosLbLpeig5250.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER5028PosLbLpeig5250.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER5028PosLbLpeig5250.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String getUniquePos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 10), getObjects());
	}

	public static FieldValidation genFieldValidation10() {
		return UtilFieldValidation.genEqualsPosFormula("3+5+7+9", UtilMetadata.genPipeRow(getObjects()));
	}

	public static SegmentValidation genRowValidation02() {
		StringBuilder formula = new StringBuilder(R_52500101010000.getKey()).append("+").append(R_52500101020000.getKey()).append("+") //L9+L10+
				.append(R_52500101030000.getKey()).append("-").append(R_52500101030100.getKey()).append("+") //(L11-L12)+
				.append(R_52500101040000.getKey()).append("+") //L13+
				.append(R_52500101050000.getKey()).append("-").append(R_52500101050100.getKey()).append("+") //(L14-L15)+
				.append(R_52500101060000.getKey()).append("-").append(R_52500101060100.getKey()).append("+") //(L16-L17)+
				.append(R_52500101070000.getKey()).append("-").append(R_52500101070201.getKey()).append("+") //(L18-L21)+
				.append(R_52500101080000.getKey()).append("-").append(R_52500101080100.getKey()).append("+") //(L22-L23)+
				.append(R_52500101090000.getKey()).append("-").append(R_52500101090100.getKey()).append("+") //(L24-L25)+
				.append(R_52500101100000.getKey()).append("+") //L26+
				.append(R_52500101110000.getKey()).append("-").append(R_52500101110100.getKey()).append("+") //(L27-L28)+
				.append(R_52500101120000.getKey()).append("+").append(R_52500101130000.getKey()).append("+").append(R_52500101140000.getKey()) //L29+L30+L31
				;

		StringBuilder errMessage = new StringBuilder(UtilMetadata.genPlusDesc(getObjects(), new int[] {1,2})).append("+")//L9+L10+
				.append(UtilMetadata.genMinusDesc(getObjects(), new int[] {3,4})).append("+") //(L11-L12)+
				.append(UtilMetadata.genPlusDesc(getObjects(), new int[] {5})).append("+") //L13+
				.append(UtilMetadata.genMinusDesc(getObjects(), new int[] {6,7})).append("+") //(L14-L15)+
				.append(UtilMetadata.genMinusDesc(getObjects(), new int[] {8,9})).append("+") //(L16-L17)+
				.append(UtilMetadata.genMinusDesc(getObjects(), new int[] {10,13})).append("+") //(L18-L21)+
				.append(UtilMetadata.genMinusDesc(getObjects(), new int[] {14,15})).append("+") //(L22-L23)+
				.append(UtilMetadata.genMinusDesc(getObjects(), new int[] {16,17})).append("+") //(L24-L25)+
				.append(UtilMetadata.genPlusDesc(getObjects(), new int[] {18})).append("+") //L26+
				.append(UtilMetadata.genMinusDesc(getObjects(), new int[] {19,20})).append("+") //(L27-L28)+
				.append(UtilMetadata.genPlusDesc(getObjects(), new int[] {21,22,23})) //L29+L30+L31
				;

		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] {2, 3, 4, 5, 6, 7, 8, 9}),
				R_52500101000000.key, formula.toString(), UtilMetadata.genMessage(R_52500101000000.value, "", errMessage.toString()));
	}

	public static SegmentValidation genRowValidation03() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500101010000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000101000000.getKey());
	}

	public static SegmentValidation genRowValidation04() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500101020000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000103000000.getKey());
	}

	public static SegmentValidation genRowValidation05() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500101030000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000104000000.getKey());
	}

	public static SegmentValidation genRowValidation06() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500101030100.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000104010000.getKey());
	}

	public static SegmentValidation genRowValidation07() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500101040000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000107000000.getKey());
	}

	public static SegmentValidation genRowValidation08() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500101050000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000110000000.getKey());
	}

	public static SegmentValidation genRowValidation09() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500101050100.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000110010000.getKey());
	}

	public static SegmentValidation genRowValidation10() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500101060000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000111000000.getKey());
	}

	public static SegmentValidation genRowValidation11() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500101060100.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000111010000.getKey());
	}

	public static SegmentValidation genRowValidation12A() {
		int[] fields = new int[] {11, 12};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 9), R_52500101070000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_52500101070000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation12B() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500101070000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000105000000.getKey());
	}

	public static SegmentValidation genRowValidation15() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500101070201.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000105040000.getKey());
	}

	public static SegmentValidation genRowValidation16() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500101080000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000106000000.getKey());
	}

	public static SegmentValidation genRowValidation17() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500101080100.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000106010000.getKey());
	}

	public static SegmentValidation genRowValidation18() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500101090000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000112000000.getKey());
	}

	public static SegmentValidation genRowValidation21() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500101110000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000109000000.getKey());
	}

	public static SegmentValidation genRowValidation22() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500101110100.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000109030000.getKey());
	}

	public static SegmentValidation genRowValidation25() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500101140000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000118000000.getKey());
	}

	public static SegmentValidation genRowValidation26() {
		int[] range = new int[] {25, 36};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 9), R_52500102000000.key,
				UtilMetadata.genPlusRow(getObjects(), range[0], range[1]),
				UtilMetadata.genMessage(R_52500102000000.value, "", UtilMetadata.genPlusDesc(getObjects(), range[0], range[1])));
	}

	public static SegmentValidation genRowValidation27() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500102010000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000304000000.getKey());
	}

	public static SegmentValidation genRowValidation28() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500102020000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000302000000.getKey());
	}

	public static SegmentValidation genRowValidation29() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500102030000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000303000000.getKey());
	}

	public static SegmentValidation genRowValidation30() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500102040000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000306000000.getKey());
	}

	public static SegmentValidation genRowValidation33() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500102070000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000309000000.getKey());
	}

	public static SegmentValidation genRowValidation34() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500102080000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000310000000.getKey());
	}

	public static SegmentValidation genRowValidation38A() {
		int[] range = new int[] {37, 40};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 9), R_52500102120000.key,
				UtilMetadata.genPlusRow(getObjects(), range[0], range[1]),
				UtilMetadata.genMessage(R_52500102120000.value, "", UtilMetadata.genPlusDesc(getObjects(), range[0], range[1])));
	}

	public static SegmentValidation genRowValidation38B() {
		return UtilSegmentValidation.genEqualsForm("10", R_52500102120000.key,
				EFormLaporanBulanan.LB_1100.getCode(), "3", ER5007PosLbLpeig1100.R_11000312000000.getKey());
	}

	public static SegmentValidation genRowValidation44() {
		int[] range = new int[] {43, 47};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 9), R_52500201000000.key,
				UtilMetadata.genPlusRow(getObjects(), range[0], range[1]),
				UtilMetadata.genMessage(R_52500201000000.value, "", UtilMetadata.genPlusDesc(getObjects(), range[0], range[1])));
	}

	public static SegmentValidation genRowValidation50() {
		int[] range = new int[] {49, 53};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 9), R_52500202000000.key,
				UtilMetadata.genPlusRow(getObjects(), range[0], range[1]),
				UtilMetadata.genMessage(R_52500202000000.value, "", UtilMetadata.genPlusDesc(getObjects(), range[0], range[1])));
	}

	public static SegmentValidation genRowValidation56() {
		int[] range = new int[] {55, 58};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 9), R_52500301000000.key,
				UtilMetadata.genPlusRow(getObjects(), range[0], range[1]),
				UtilMetadata.genMessage(R_52500301000000.value, "", UtilMetadata.genPlusDesc(getObjects(), range[0], range[1])));
	}

	public static SegmentValidation genRowValidation61() {
		int[] range = new int[] {60, 63};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 9), R_52500302000000.key,
				UtilMetadata.genPlusRow(getObjects(), range[0], range[1]),
				UtilMetadata.genMessage(R_52500302000000.value, "", UtilMetadata.genPlusDesc(getObjects(), range[0], range[1])));
	}
}