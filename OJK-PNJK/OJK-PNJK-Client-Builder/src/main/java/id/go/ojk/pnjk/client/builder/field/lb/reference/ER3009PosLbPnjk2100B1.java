package id.go.ojk.pnjk.client.builder.field.lb.reference;

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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3009PosLbPnjk2100B1 implements IObject<KeyValueString> {
	R_2100B10100 ("2100B10100", "Detail"),
    R_2100B10000 ("2100B10000", "Total")
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3009PosLbPnjk2100B1 eEnum : ER3009PosLbPnjk2100B1.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3009PosLbPnjk2100B1.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3009PosLbPnjk2100B1.class.getSimpleName().substring(2, 6));
	}

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave("20", getObjects());
    }

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
	}
	
//	public static ConditionalRequired genCondition(String comparatorField) {
//		return UtilFieldConditional.genExistPosAndComparatorNotEmpty("N", "M",
//				UtilMetadata.genPipeRow(getObjects(), new int[] { 0 }), comparatorField);
//	}

    public static ConditionalRequired genCondition(String comparatorField) {
        return UtilFieldConditional.genExistPosAndComparatorNotEmptyExcept("N", "M",
                UtilMetadata.genPipeRow(getObjects(), new int[] { 0 }), comparatorField, R_2100B10000.key, "N");
    }
	
	public static FieldValidation genFieldValidationGreater(String value) {
		return UtilFieldValidation.genPosGreaterValue(UtilMetadata.genPipeRow(getObjects(), new int[] {0}), value);
	}
	
	public static FieldValidation genFieldValidation10() {
		return UtilFieldValidation.genDateLessPos("11", UtilMetadata.genPipeRow(getObjects(), new int[] {0}));
	}
	
	public static FieldValidation genFieldValidation11() {
		return UtilFieldValidation.genDateGreaterPos("10", UtilMetadata.genPipeRow(getObjects(), new int[] {0}));
	}
	
	public static FieldValidation genFieldValidation20() {
		return UtilFieldValidation.genEqualsExceptPosFormula("17-18-19", R_2100B10000.key);
	}

    public static ConditionalRequired genConditionTotal() {
        return UtilFieldConditional.genExistPos("N", "M", R_2100B10000.key);
    }

    public static SegmentValidation genValidation1() {
        return UtilSegmentValidation.genEqualsFormula("20", R_2100B10000.key, R_2100B10100.key,
                UtilMetadata.genMessageTotal(R_2100B10000.value, R_2100B10100.value));
    }

    public static SegmentValidation genValidation2() {
        int[] comparePos = new int[] {3,4,5,6,7,8,9,10,11,14};
        String compareField = "2|2|2|2|2|2|2|2|2|2";

        return UtilSegmentValidation.genEqualsFormAdd("20", R_2100B10000.key, compareField,
                UtilMetadata.genPipeRow(ER3004PosLbPnjk1100.getObjectsKeyForm(), comparePos),
                UtilMetadata.genMessage(R_2100B10000.value,
                        "\"Total Penjumlahan Akun L13+L14+L15+L16+L17+L18+L19+L20+L21+L24\" yang dilaporkan pada form \"Laporan Posisi Keuangan\" (form 1100)"));
    }

}
