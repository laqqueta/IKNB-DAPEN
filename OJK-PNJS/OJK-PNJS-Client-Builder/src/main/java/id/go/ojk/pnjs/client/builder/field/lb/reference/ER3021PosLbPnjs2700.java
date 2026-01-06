package id.go.ojk.pnjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3021PosLbPnjs2700 implements IObject<KeyValueString> {
	R_2700010000 ("2700010000", "Detail"),
    R_2700000000 ("2700000000", "Total")
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3021PosLbPnjs2700 eEnum : ER3021PosLbPnjs2700.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3021PosLbPnjs2700.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3021PosLbPnjs2700.class.getSimpleName().substring(2, 6));
	}

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave("6", getObjects());
    }

    public static ConditionalRequired genConditionTotal() {
        return UtilFieldConditional.genExistPos("N", "M", R_2700000000.key);
    }

    public static SegmentValidation genValidation2() {
        return UtilSegmentValidation.genEqualsFormAdd("6", R_2700000000.key, "2|2",
                ER3004PosLbPnjs1100.R_11000201070000.getKeyForm() + "|" + ER3004PosLbPnjs1100.R_11000202070000.getKeyForm(),
                UtilMetadata.genMessage(R_2700000000.value,
                        "\"Total Penjumlahan Utang Klaim Co-Guarantee (Lancar + Tidak Lancar)\" yang dilaporkan pada form \"Laporan Posisi Keuangan\" (form 1100)"));
    }

    public static SegmentValidation genValidation1() {
        return UtilSegmentValidation.genEqualsFormula("6", R_2700000000.key, R_2700010000.key,
                UtilMetadata.genMessageTotal(R_2700000000.value, R_2700010000.value));
    }
}
