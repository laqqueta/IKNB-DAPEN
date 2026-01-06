package id.go.ojk.pnjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pnjs.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3004PosLbPnjs1100 implements IObject<KeyValueString> {
//	R_11000100000000 ("11000100000000", "Aset"),
//	R_11000101000000 ("11000101000000", "Aset Lancar"),
	R_11000101010000 ("11000101010000", "Kas dan Giro Bank"),
	R_11000101020000 ("11000101020000", "Investasi"),
	R_11000101020100 ("11000101020100", "Deposito Pada Bank"),
	R_11000101020200 ("11000101020200", "Surat Berharga Syariah Negara"),
	R_11000101020300 ("11000101020300", "Surat Berharga Syariah yang Diterbitkan oleh Bank Indonesia"),
	R_11000101020400 ("11000101020400", "Sukuk Korporasi"),
	R_11000101020500 ("11000101020500", "Saham yang Tercatat di Bursa Efek Indonesia"),
	R_11000101020600 ("11000101020600", "Efek Beragun Aset Syariah"),
	R_11000101020700 ("11000101020700", "Reksa Dana Syariah"),
	R_11000101020800 ("11000101020800", "Medium Term Notes Syariah"),
	R_11000101020900 ("11000101020900", "Repurchase Agreement Syariah"),
	R_11000101021000 ("11000101021000", "Dana Investasi Real Estat Syariah Berbentuk Kontrak Investasi Kolektif"),
	R_11000101021100 ("11000101021100", "Tanah dan Bangunan"),
	R_11000101021200 ("11000101021200", "Penyertaan Langsung pada Perusahaan di Sektor Jasa Keuangan Syariah di Indonesia"),
	R_11000101021300 ("11000101021300", "Sukuk Daerah"),
	R_11000101021400 ("11000101021400", "Dana Investasi Infrastruktur Berbentuk Kontrak Investasi Kolektif"),
	R_11000101021500 ("11000101021500", "Lainnya"),
	R_11000101030000 ("11000101030000", "Piutang Imbal Jasa Kafalah (Piutang IJK)"),
	R_11000101040000 ("11000101040000", "Piutang Penjaminan Bersama (Piutang Co-Guarantee)"),
	R_11000101050000 ("11000101050000", "Piutang Reasuransi Syariah/Penjaminan Ulang Syariah"),
	R_11000101060000 ("11000101060000", "Pendapatan Yang Masih Harus Diterima"),
	R_11000101070000 ("11000101070000", "Beban Dibayar Di Muka"),
	R_11000101080000 ("11000101080000", "Beban Dibayar di Muka Reasuransi"),
	R_11000101090000 ("11000101090000", "Piutang Dalam Rangka Restrukturisasi Penjaminan"),
	R_11000101100000 ("11000101100000", "Aset Pajak Tangguhan"),
	R_11000101110000 ("11000101110000", "Aset Tetap – Neto"),
	R_11000101120000 ("11000101120000", "Aset Tidak Berwujud – Neto"),
	R_11000101130000 ("11000101130000", "Aset Lain-Lain"),
	R_11000101140000 ("11000101140000", "Jumlah Aset Lancar"),
//	R_11000102000000 ("11000102000000", "Aset Tidak Lancar"),
	R_11000102010000 ("11000102010000", "Investasi"),
	R_11000102010100 ("11000102010100", "Deposito Pada Bank"),
	R_11000102010200 ("11000102010200", "Surat Berharga Syariah Negara"),
	R_11000102010300 ("11000102010300", "Surat Berharga Syariah yang Diterbitkan oleh Bank Indonesia"),
	R_11000102010400 ("11000102010400", "Sukuk Korporasi"),
	R_11000102010500 ("11000102010500", "Saham yang Tercatat di Bursa Efek Indonesia"),
	R_11000102010600 ("11000102010600", "Efek Beragun Aset Syariah"),
	R_11000102010700 ("11000102010700", "Reksa Dana"),
	R_11000102010800 ("11000102010800", "Medium Term Notes Syariah"),
	R_11000102010900 ("11000102010900", "Repurchase Agreement Syariah"),
	R_11000102011000 ("11000102011000", "Dana Investasi Real Estat Syariah Berbentuk Kontrak Investasi Kolektif"),
	R_11000102011100 ("11000102011100", "Tanah dan Bangunan"),
	R_11000102011200 ("11000102011200", "Penyertaan Langsung pada Perusahaan di Sektor Jasa Keuangan Syariah di Indonesia"),
	R_11000102011300 ("11000102011300", "Sukuk Daerah"),
	R_11000102011400 ("11000102011400", "Dana Investasi Infrastruktur Berbentuk Kontrak Investasi Kolektif"),
	R_11000102011500 ("11000102011500", "Lainnya"),
	R_11000102020000 ("11000102020000", "Piutang IJK"),
	R_11000102030000 ("11000102030000", "Piutang Co-Guarantee"),
	R_11000102040000 ("11000102040000", "Piutang Reasuransi Syariah/Penjaminan Ulang Syariah"),
	R_11000102050000 ("11000102050000", "Pendapatan Yang Masih Harus Diterima"),
	R_11000102060000 ("11000102060000", "Beban Dibayar di Muka"),
	R_11000102070000 ("11000102070000", "Piutang Dalam Rangka Restrukturisasi Penjaminan"),
	R_11000102080000 ("11000102080000", "Aset Pajak Tangguhan"),
	R_11000102090000 ("11000102090000", "Aset Tetap – Neto"),
	R_11000102100000 ("11000102100000", "Aset Tidak Berwujud – Neto"),
	R_11000102110000 ("11000102110000", "Aset Lain-Lain"),
	R_11000102120000 ("11000102120000", "Jumlah Aset Tidak Lancar"),
	R_11000103000000 ("11000103000000", "Jumlah Aset"),
//	R_11000200000000 ("11000200000000", "Liabilitas"),
//	R_11000201000000 ("11000201000000", "Liabilitas Lancar"),
	R_11000201010000 ("11000201010000", "Utang Klaim"),
	R_11000201020000 ("11000201020000", "Cadangan Klaim"),
	R_11000201030000 ("11000201030000", "Penampungan IJK"),
	R_11000201040000 ("11000201040000", "IJK Ditangguhkan"),
	R_11000201050000 ("11000201050000", "Utang Pajak"),
	R_11000201060000 ("11000201060000", "Utang Komisi"),
	R_11000201070000 ("11000201070000", "Utang Klaim Co-Guarantee"),
	R_11000201080000 ("11000201080000", "Utang IJK Co-Guarantee"),
	R_11000201090000 ("11000201090000", "Utang Premi Reasuransi/IJK Penjaminan Ulang"),
	R_11000201100000 ("11000201100000", "Beban Yang Masih Harus Dibayar"),
	R_11000201110000 ("11000201110000", "Liabilitas Pajak Tangguhan"),
	R_11000201120000 ("11000201120000", "Sukuk Wajib Konversi"),
	R_11000201130000 ("11000201130000", "Liabilitas Imbalan Pasca Kerja"),
	R_11000201140000 ("11000201140000", "Liabilitas Lain-Lain"),
	R_11000201150000 ("11000201150000", "Jumlah Liabilitas Lancar"),
//	R_11000202000000 ("11000202000000", "Liabilitas Tidak Lancar"),
	R_11000202010000 ("11000202010000", "Utang Klaim"),
	R_11000202020000 ("11000202020000", "Cadangan Klaim"),
	R_11000202030000 ("11000202030000", "Penampungan IJK"),
	R_11000202040000 ("11000202040000", "IJK Ditangguhkan"),
	R_11000202050000 ("11000202050000", "Utang Pajak"),
	R_11000202060000 ("11000202060000", "Utang Komisi"),
	R_11000202070000 ("11000202070000", "Utang Klaim Co-Guarantee"),
	R_11000202080000 ("11000202080000", "Utang IJK Co-Guarantee"),
	R_11000202090000 ("11000202090000", "Utang Premi Reasuransi/IJK Penjaminan Ulang"),
	R_11000202100000 ("11000202100000", "Beban Yang Masih Harus Dibayar"),
	R_11000202110000 ("11000202110000", "Liabilitas Pajak Tangguhan"),
	R_11000202120000 ("11000202120000", "Sukuk Wajib Konversi"),
	R_11000202130000 ("11000202130000", "Liabilitas Imbalan Pasca Kerja"),
	R_11000202140000 ("11000202140000", "Liabilitas Lain-Lain"),
	R_11000202150000 ("11000202150000", "Jumlah Liabilitas Tidak Lancar"),
	R_11000203000000 ("11000203000000", "Jumlah Liabilitas"),
//	R_11000300000000 ("11000300000000", "Ekuitas"),
	R_11000301000000 ("11000301000000", "Modal"),
	R_11000301010000 ("11000301010000", "Modal Disetor/Modal Kerja UUS"),
	R_11000301010100 ("11000301010100", "Setoran Modal Diterima di Muka"),
	R_11000301020000 ("11000301020000", "Cadangan"),
	R_11000301020100 ("11000301020100", "Cadangan Umum"),
	R_11000301020200 ("11000301020200", "Cadangan Tujuan"),
	R_11000301020300 ("11000301020300", "Cadangan Lainnya"),
	R_11000301030000 ("11000301030000", "Hibah"),
	R_11000301040000 ("11000301040000", "Saldo Laba/(Rugi)"),
	R_11000301050000 ("11000301050000", "Laba/(Rugi) Tahun Berjalan"),
	R_11000301060000 ("11000301060000", "Pendapatan Komprehensif Lainnya"),
	R_11000302000000 ("11000302000000", "Jumlah Ekuitas"),
	;

	@Getter
	private String key;
	private String value;

    private static final int[] negativeFields = {95, 96, 97, 98};
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3004PosLbPnjs1100 eEnum : ER3004PosLbPnjs1100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public String getKeyForm() {
		return EFormLaporanBulanan.LB_1100.getCode() + key;
	}
	
	public KeyValueString getObjectForm() {
		return new KeyValueString(getKeyForm(), value, new String[] {});
	}

	public static List<KeyValueString> getObjectsForm() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3004PosLbPnjs1100 eEnum : ER3004PosLbPnjs1100.values()) {
			res.add(eEnum.getObjectForm());
		}
		return res;
	}
	
	public static String getName() {
		return ER3004PosLbPnjs1100.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3004PosLbPnjs1100.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2",
				UtilMetadata.genPipeRowExcept(getObjects(), negativeFields));
	}
	
	public static SegmentValidation genValidationNumericNegative() {
		return UtilSegmentValidation.genRegexNumericNegative("2",
				UtilMetadata.genPipeRow(getObjects(), negativeFields));
	}
	
	public static SegmentValidation genValidation003() {
		return UtilSegmentValidation.genEqualsFormula("2", R_11000101020000.key, UtilMetadata.genPlusRow(getObjects(), 2, 16),
				UtilMetadata.genMessage(R_11000101020000.value, UtilMetadata.genPlusDesc(getObjects(), 2, 16)));
	}
	
	public static SegmentValidation genValidation030() {
		int[] field = new int[] { 0, 1, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27 };
		return UtilSegmentValidation.genEqualsFormula("2", R_11000101140000.key, UtilMetadata.genPlusRow(getObjects(), field),
				UtilMetadata.genMessage(R_11000101140000.value, UtilMetadata.genPlusDesc(getObjects(), field)));
	}
	
	public static SegmentValidation genValidation031() {
		return UtilSegmentValidation.genEqualsFormula("2", R_11000102010000.key, UtilMetadata.genPlusRow(getObjects(), 30, 44),
				UtilMetadata.genMessage(R_11000102010000.value, UtilMetadata.genPlusDesc(getObjects(), 30, 44)));
	}
	
	public static SegmentValidation genValidation057() {
		int[] field = new int[] { 29, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54 };
		return UtilSegmentValidation.genEqualsFormula("2", R_11000102120000.key, UtilMetadata.genPlusRow(getObjects(), field),
				UtilMetadata.genMessage(R_11000102120000.value, UtilMetadata.genPlusDesc(getObjects(), field)));
	}
	
	public static SegmentValidation genValidation058() {
		int[] field = new int[] { 28, 55 };
		return UtilSegmentValidation.genEqualsFormula("2", R_11000103000000.key, UtilMetadata.genPlusRow(getObjects(), field),
				UtilMetadata.genMessage(R_11000103000000.value, UtilMetadata.genPlusDesc(getObjects(), field)));
	}

    public static SegmentValidation genValidation059() {
        int[] field = new int[] { 87, 99 };
        return UtilSegmentValidation.genEqualsFormula("2", R_11000103000000.key, UtilMetadata.genPlusRow(getObjects(), field),
                UtilMetadata.genMessage(R_11000103000000.value, UtilMetadata.genPlusDesc(getObjects(), field)));
    }
	
	public static SegmentValidation genValidation073() {
		return UtilSegmentValidation.genEqualsFormula("2", R_11000201150000.key, UtilMetadata.genPlusRow(getObjects(), 57, 70),
				UtilMetadata.genMessage(R_11000201150000.value, UtilMetadata.genPlusDesc(getObjects(), 57, 70)));
	}
	
	public static SegmentValidation genValidation088() {
		return UtilSegmentValidation.genEqualsFormula("2", R_11000202150000.key, UtilMetadata.genPlusRow(getObjects(), 72, 85),
				UtilMetadata.genMessage(R_11000202150000.value, UtilMetadata.genPlusDesc(getObjects(), 72, 85)));
	}
	
	public static SegmentValidation genValidation089() {
		int[] field = new int[] { 71, 86 };
		return UtilSegmentValidation.genEqualsFormula("2", R_11000203000000.key, UtilMetadata.genPlusRow(getObjects(), field),
				UtilMetadata.genMessage(R_11000203000000.value, UtilMetadata.genPlusDesc(getObjects(), field)));
	}
	
	public static SegmentValidation genValidation090() {
		return UtilSegmentValidation.genEqualsFormula("2", R_11000301000000.key, UtilMetadata.genPlusRow(getObjects(), 89, 90),
				UtilMetadata.genMessage(R_11000301000000.value, UtilMetadata.genPlusDesc(getObjects(), 89, 90)));
	}
	
	public static SegmentValidation genValidation093() {
		return UtilSegmentValidation.genEqualsFormula("2", R_11000301020000.key, UtilMetadata.genPlusRow(getObjects(), 92, 94),
				UtilMetadata.genMessage(R_11000301020000.value, UtilMetadata.genPlusDesc(getObjects(), 92, 94)));
	}
	
	public static SegmentValidation genValidation101() {
		int[] field = new int[] { 88, 91, 95, 96, 97, 98 };
		return UtilSegmentValidation.genEqualsFormula("2", R_11000302000000.key, UtilMetadata.genPlusRow(getObjects(), field),
				UtilMetadata.genMessage(R_11000302000000.value, UtilMetadata.genPlusDesc(getObjects(), field)));
	}

    public static SegmentValidation genValidationR11000202140000() {
        return UtilSegmentValidation.genEqualsForm("2", R_11000202140000.key, EFormLaporanBulanan.LB_2900.getCode(), "4",
                ER3023PosLbPnjs2900.R_2900000000.getKey());
    }

    public static SegmentValidation genValidationR11000201140000() {
        return UtilSegmentValidation.genEqualsForm("2", R_11000201140000.key, EFormLaporanBulanan.LB_2900.getCode(), "3",
                ER3023PosLbPnjs2900.R_2900000000.getKey());
    }

    public static SegmentValidation genValidationR11000101130000() {
        return UtilSegmentValidation.genEqualsForm("2", R_11000101130000.key, EFormLaporanBulanan.LB_2400.getCode(), "3",
                ER3018PosLbPnjs2400.R_2400000000.getKey());
    }

    public static SegmentValidation genValidationR11000102110000() {
        return UtilSegmentValidation.genEqualsForm("2", R_11000102110000.key, EFormLaporanBulanan.LB_2400.getCode(), "4",
                ER3018PosLbPnjs2400.R_2400000000.getKey());
    }

    public static SegmentValidation genValidationR11000101020100() {
        return UtilSegmentValidation.genEqualsForm("2", R_11000101020100.key, EFormLaporanBulanan.LB_2100A1.getCode(), "14",
                ER3007PosLbPnjs2100A1.R_2100A10000.getKey());
    }

    public static SegmentValidation genValidationR11000102010100() {
        return UtilSegmentValidation.genEqualsForm("2", R_11000102010100.key, EFormLaporanBulanan.LB_2100A2.getCode(), "14",
                ER3008PosLbPnjs2100A2.R_2100A20000.getKey());
    }

    public static SegmentValidation genValidationR11000101021200() {
        return UtilSegmentValidation.genEqualsForm("2", R_11000101021200.key, EFormLaporanBulanan.LB_2100D1.getCode(), "10",
                ER3014PosLbPnjs2100D1.R_2100D10000.getKey());
    }

    public static SegmentValidation genValidationR11000102011200() {
        return UtilSegmentValidation.genEqualsForm("2", R_11000102011200.key, EFormLaporanBulanan.LB_2100D2.getCode(), "10",
                ER3015PosLbPnjs2100D2.R_2100D20000.getKey());
    }

    public static SegmentValidation genValidationR11000101021100() {
        return UtilSegmentValidation.genEqualsForm("2", R_11000101021100.key, EFormLaporanBulanan.LB_2100C1.getCode(), "9",
                ER3012PosLbPnjs2100C1.R_2100C10000.getKey());
    }

    public static SegmentValidation genValidationR11000102011100() {
        return UtilSegmentValidation.genEqualsForm("2", R_11000102011100.key, EFormLaporanBulanan.LB_2100C2.getCode(), "9",
                ER3013PosLbPnjs2100C2.R_2100C20000.getKey());
    }

    // Validation M : M
    public static SegmentValidation genRowValidationMulti1() {
        String comparatorPosCode = UtilMetadata.genPipeRow(ER3016PosLbPnjs2200.getObjects(), new int[] { 0 });
        String selectPosCode = R_11000101030000.key + "|" + R_11000102020000.key;
        String errMsg = "Nilai Piutang Imbal Jasa Penjaminan (Aset Lancar) + Nilai Piutang IJP (Aset tidak lancar) harus sama dengan Total Jumlah Netto pada form 2200";

        return UtilSegmentValidation.genEqualsForm4("2", selectPosCode,
                EFormLaporanBulanan.LB_2200.getCode(), "11", comparatorPosCode,
                "subtract", "add", errMsg,
                R_11000101030000.key);
    }

    public static SegmentValidation genRowValidationMulti2() {
        String comparatorPosCode = UtilMetadata.genPipeRow(ER3022PosLbPnjs2800.getObjects(), new int[] { 0 });
        String selectPosCode = UtilMetadata.genPipeRow(getObjects(), new int[] { 79, 64, 80, 65 }); // 81, 66, 82, 67
        String errMsg = "Penjumlahan Utang IJK CoGar (Lancar + Tidak Lancar) dan Utang Premi Reas/IJK PU (Lancar + Tidak Lancar) harus sama dengan Total Utang IJP - Total CKPN pada form 2800)";

        return UtilSegmentValidation.genEqualsForm4("2", selectPosCode,
                EFormLaporanBulanan.LB_2800.getCode(), "23|24", comparatorPosCode,
                "subtract", "add", errMsg,
                R_11000201080000.key);
    }

    public static SegmentValidation genRowValidationMulti3() {
        String comparatorPosCode = UtilMetadata.genPipeRow(ER3017PosLbPnjs2300.getObjects(), new int[] { 0 });
        String selectPosCode = UtilMetadata.genPipeRow(getObjects(), new int[] { 18, 46, 47, 19 }); // 20 48 49 21
        String errMsg = "Penjumlahan Nilai Piutang Penjaminan Bersama (Piutang Co-Guarantee) (Aset Lancar, Aset tidak lancar) + Piutang Reasuransi/Penjaminan Ulang Syariah (Aset lancar, Aset tidak lancar) harus sama dengan Total Piutang Claim - Total CKPN pada form 2300)";

        return UtilSegmentValidation.genEqualsForm4("2", selectPosCode,
                EFormLaporanBulanan.LB_2300.getCode(), "14|16", comparatorPosCode,
                "subtract", "add", errMsg,
                R_11000101040000.key);
    }
}
