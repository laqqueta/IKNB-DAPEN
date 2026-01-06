package id.go.ojk.asrjk.client.builder.field.lb.reference;

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

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3034PosLbAsrjk203 implements IObject<KeyValueString> {
	R_4402000001 ("4402000001", "Kematian Jangka Warsa"),
	R_4402000002 ("4402000002", "Endowment dan/atau Kombinasinya"),
	R_4402000003 ("4402000003", "Seumur Hidup"),
	R_4402000004 ("4402000004", "Anuitas"),
	R_4402000005 ("4402000005", "Kematian Ekawarsa"),
	R_4402000006 ("4402000006", "Kecelakaan Diri"),
	R_4402000007 ("4402000007", "Kesehatan"),
	R_4402000008 ("4402000008", "Lainnya"),
	R_4402000000 ("4402000000", "Total"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3034PosLbAsrjk203 eEnum : ER3034PosLbAsrjk203.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3034PosLbAsrjk203.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3034PosLbAsrjk203.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 9), getObjects());
	}

	public static FieldValidation genFieldValidation5() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 4), 
				UtilMetadata.genPipeRow(getObjects(), 0, 7));
	}

	public static FieldValidation genFieldValidation9() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(6, 8), 
				UtilMetadata.genPipeRow(getObjects(), 0, 7));
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 9), R_4402000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 7), 
				"Total|Penjumlahan detail");
	}
}
