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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3010PosLbPnjs2100B2 implements IObject<KeyValueString> {
	R_2100B20100 ("2100B20100", "Detail"),
    R_2100B20000 ("2100B20000", "Total")
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3010PosLbPnjs2100B2 eEnum : ER3010PosLbPnjs2100B2.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3010PosLbPnjs2100B2.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3010PosLbPnjs2100B2.class.getSimpleName().substring(2, 6));
	}

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave("20", getObjects());
    }

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
	}

    public static ConditionalRequired genCondition(String comparatorField) {
        return UtilFieldConditional.genExistPosAndComparatorNotEmptyExcept("N", "M",
                UtilMetadata.genPipeRow(getObjects(), new int[] { 0 }), comparatorField, R_2100B20000.key, "N");
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
        return UtilFieldValidation.genEqualsExceptPosFormula("17-18-19", R_2100B20000.key);
    }

    public static ConditionalRequired genConditionTotal() {
        return UtilFieldConditional.genExistPos("N", "M", R_2100B20000.key);
    }

    public static SegmentValidation genValidationTotal() {
        return UtilSegmentValidation.genEqualsFormula("20", R_2100B20000.key, R_2100B20100.key,
                UtilMetadata.genMessageTotal(R_2100B20000.value, R_2100B20100.value));
    }

    public static SegmentValidation genValidation1() {
        int[] comparePos = new int[] {31,32,33,34,35,36,37,38,39,42};
        String compareField = "2|2|2|2|2|2|2|2|2|2";

        return UtilSegmentValidation.genEqualsFormAdd("20", R_2100B20000.key, compareField,
                UtilMetadata.genPipeRow(ER3004PosLbPnjs1100.getObjectsForm(), comparePos),
                UtilMetadata.genMessage(R_2100B20000.value,
                        "\"Total Penjumlahan Akun L42+L43+L44+L45+L46+L47+L48+L49+L50+L53\" yang dilaporkan pada form \"Laporan Posisi Keuangan\" (form 1100)"));
    }
}
