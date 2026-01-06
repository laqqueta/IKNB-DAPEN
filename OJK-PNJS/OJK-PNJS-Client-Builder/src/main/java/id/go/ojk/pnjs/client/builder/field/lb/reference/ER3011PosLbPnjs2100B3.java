package id.go.ojk.pnjs.client.builder.field.lb.reference;

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
public enum ER3011PosLbPnjs2100B3 implements IObject<KeyValueString> {
	R_2100B30100 ("2100B30100", "Surat Berharga Syariah Negara"),
	R_2100B30200 ("2100B30200", "Sukuk Infrastruktur"),
	R_2100B30300 ("2100B30300", "Reksadana Syariah Underlying SBN"),
	R_2100B30400 ("2100B30400", "TOTAL SBN"),
	R_2100B30500 ("2100B30500", "TOTAL INVESTASI SYARIAH"),
	R_2100B30600 ("2100B30600", "TOTAL SBN/TOTAL INVESTASI SYARIAH"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3011PosLbPnjs2100B3 eEnum : ER3011PosLbPnjs2100B3.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3011PosLbPnjs2100B3.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3011PosLbPnjs2100B3.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 5 }));
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDot("2", R_2100B30600.key);
	}
	
	public static SegmentValidation genValidation5() {
		return UtilSegmentValidation.genEqualsFormula("2", R_2100B30400.key, UtilMetadata.genPlusRow(getObjects(), 0, 2),
				UtilMetadata.genMessage(R_2100B30400.value, UtilMetadata.genPlusDesc(getObjects(), 0, 2)));
	}
	
	public static SegmentValidation genValidation6() {
		int[] field = new int[] { 1, 29 };
		return UtilSegmentValidation.genEqualsFormulaForm("2", R_2100B30500.key, "2",
				UtilMetadata.genPlusRow(ER3004PosLbPnjs1100.getObjectsForm(), field), 
				UtilMetadata.genMessage(R_2100B30500.value, "'investasi aset lancar'+'investasi aset tidak lancar' pada form 1100"));
	}
	
	public static SegmentValidation genValidation7() {
		return UtilSegmentValidation.genEqualsPercentage("2", R_2100B30600.key, R_2100B30400.key, R_2100B30500.key, 
				UtilMetadata.genMessage(R_2100B30600.value, UtilMetadata.genDevideDesc(getObjects(), new int[] { 3, 4 })), 2);
	}
}
