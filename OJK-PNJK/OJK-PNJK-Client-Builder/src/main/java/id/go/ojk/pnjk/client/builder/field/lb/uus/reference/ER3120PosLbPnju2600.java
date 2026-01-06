package id.go.ojk.pnjk.client.builder.field.lb.uus.reference;

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
public enum ER3120PosLbPnju2600 implements IObject<KeyValueString> {
	R_2600010000 ("2600010000", "Detail"),
    R_2600000000 ("2600000000", "Total")
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3120PosLbPnju2600 eEnum : ER3120PosLbPnju2600.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3120PosLbPnju2600.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3120PosLbPnju2600.class.getSimpleName().substring(2, 6));
	}

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave("6", getObjects());
    }

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
	}

    public static ConditionalRequired genConditionForTotal() {
        return UtilFieldConditional.genExistPos("N", "M", R_2600000000.key);
    }

    public static SegmentValidation genValidation1() {
        return UtilSegmentValidation.genEqualsFormula("6", R_2600000000.key, R_2600010000.key,
                UtilMetadata.genMessageTotal(R_2600000000.value, R_2600010000.value));
    }

    public static SegmentValidation genValidation2() {
        return UtilSegmentValidation.genEqualsFormAdd("6", R_2600000000.key, "2|2",
                ER3104PosLbPnju1100.R_11000201060000.getKeyForm() + "|" + ER3104PosLbPnju1100.R_11000202060000.getKeyForm(),
                UtilMetadata.genMessage(R_2600000000.value,
                        "\"Total Penjumlahan Utang Komisi (Lancar + Tidak Lancar)\" yang dilaporkan pada form \"Laporan Posisi Keuangan\" (form 1100)"));
    }
}
