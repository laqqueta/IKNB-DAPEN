package id.go.ojk.pnjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pnjs.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3037PosLbPnjs7100 implements IObject<KeyValueString> {
	R_7100010000 ("7100010000", "Nilai Kafalah Yang Ditanggung Sendiri"),
	R_7100020000 ("7100020000", "Modal Sendiri Bersih"),
	R_7100030000 ("7100030000", "Gearing Ratio (Nilai Baris 1:2)"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3037PosLbPnjs7100 eEnum : ER3037PosLbPnjs7100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3037PosLbPnjs7100.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3037PosLbPnjs7100.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4", getObjects());
	}

	public static FieldValidation genFieldValidation4() {
		return UtilFieldValidation.genEqualsPosFormula("2+3",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0 }));
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2|3|4",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0 }));
	}

    public static SegmentValidation genValidationNumeric2() {
        return UtilSegmentValidation.genRegexNumeric("4", R_7100020000.key);
    }
	
	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDot("4", R_7100030000.key);
	}
	
	public static SegmentValidation genValidation4() {
		int[] field = new int[] { 0, 1 };
		return UtilSegmentValidation.genEqualsRatio("4", R_7100030000.key, R_7100010000.key, R_7100020000.key,
				UtilMetadata.genMessage(R_7100030000.value, UtilMetadata.genDevideDesc(getObjects(), field)), 2);
	}

    public static SegmentValidation genValidation5() {
        return UtilSegmentValidation.genEqualsForm("4", R_7100010000.key, EFormLaporanBulanan.LB_3100.getCode(), "20",
                ER3025PosLbPnjs3100.R_3100000000.getKey());
    }

    public static SegmentValidation genValidation6() {
        return UtilSegmentValidation.genEqualsForm("4", R_7100020000.key, EFormLaporanBulanan.LB_1100.getCode(), "2",
                ER3004PosLbPnjs1100.R_11000302000000.getKey(),
                UtilMetadata.genMessage("",
                        "sama dengan Jumlah Equitas pada form \"Daftar Rincian Penjaminan\" (form 1100)"));
    }

    public static ConditionalRequired genValidationMustEmpty1() {
        return UtilFieldConditional.genMustEmpty("M", "N", "2",
                UtilMetadata.genPipeRow(getObjects(), new int[] { 1, 2 }));
    }

    public static ConditionalRequired genValidationMustEmpty2() {
        return UtilFieldConditional.genMustEmpty("M", "N", "3",
                UtilMetadata.genPipeRow(getObjects(), new int[] { 1, 2 }));
    }
}
