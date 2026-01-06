package id.go.ojk.asrjk.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormSelfAssessment;
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
public enum ER4011PosSaAsrjk0211 implements IObject<KeyValueString> {
	R_0211010000 ("0211010000", "Risiko Strategis"),
	R_0211020000 ("0211020000", "Risiko Operasional"),
	R_0211030000 ("0211030000", "Risiko Asuransi"),
	R_0211040000 ("0211040000", "Risiko Kredit"),
	R_0211050000 ("0211050000", "Risiko Pasar"),
	R_0211060000 ("0211060000", "Risiko Likuiditas"),
	R_0211070000 ("0211070000", "Risiko Hukum"),
	R_0211080000 ("0211080000", "Risiko Kepatuhan"),
	R_0211090000 ("0211090000", "Risiko Reputasi"),
	R_0211100000 ("0211100000", "Peringkat Komposit"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4011PosSaAsrjk0211 eEnum : ER4011PosSaAsrjk0211.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER4011PosSaAsrjk0211.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER4011PosSaAsrjk0211.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static FieldValidation genValidationPeringkat() {
		return UtilFieldValidation.genEqualsFixedValue("1|2|3|4|5");
	}
	
	public static SegmentValidation genValidationRisikoStrategis2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211010000.key, EFormSelfAssessment.SA_0201.getCode(), "2", ER4001PosSaAsrjk0201.R_02010201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoStrategis3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211010000.key, EFormSelfAssessment.SA_0201.getCode(), "2", ER4001PosSaAsrjk0201.R_02010301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoOperasional2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211020000.key, EFormSelfAssessment.SA_0202.getCode(), "2", ER4002PosSaAsrjk0202.R_02020201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoOperasional3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211020000.key, EFormSelfAssessment.SA_0202.getCode(), "2", ER4002PosSaAsrjk0202.R_02020301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoAsuransi2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211030000.key, EFormSelfAssessment.SA_0203.getCode(), "2", ER4003PosSaAsrjk0203.R_02030201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoAsuransi3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211030000.key, EFormSelfAssessment.SA_0203.getCode(), "2", ER4003PosSaAsrjk0203.R_02030301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKredit2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211040000.key, EFormSelfAssessment.SA_0204.getCode(), "2", ER4004PosSaAsrjk0204.R_02040201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKredit3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211040000.key, EFormSelfAssessment.SA_0204.getCode(), "2", ER4004PosSaAsrjk0204.R_02040301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoPasar2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211050000.key, EFormSelfAssessment.SA_0205.getCode(), "2", ER4005PosSaAsrjk0205.R_02050201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoPasar3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211050000.key, EFormSelfAssessment.SA_0205.getCode(), "2", ER4005PosSaAsrjk0205.R_02050301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoLikuiditas2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211060000.key, EFormSelfAssessment.SA_0206.getCode(), "2", ER4006PosSaAsrjk0206.R_02060201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoLikuiditas3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211060000.key, EFormSelfAssessment.SA_0206.getCode(), "2", ER4006PosSaAsrjk0206.R_02060301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoHukum2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211070000.key, EFormSelfAssessment.SA_0207.getCode(), "2", ER4007PosSaAsrjk0207.R_02070201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoHukum3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211070000.key, EFormSelfAssessment.SA_0207.getCode(), "2", ER4007PosSaAsrjk0207.R_02070301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKepatuhan2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211080000.key, EFormSelfAssessment.SA_0208.getCode(), "2", ER4008PosSaAsrjk0208.R_02080201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKepatuhan3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211080000.key, EFormSelfAssessment.SA_0208.getCode(), "2", ER4008PosSaAsrjk0208.R_02080301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoReputasi2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211090000.key, EFormSelfAssessment.SA_0209.getCode(), "2", ER4009PosSaAsrjk0209.R_02090201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoReputasi3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211090000.key, EFormSelfAssessment.SA_0209.getCode(), "2", ER4009PosSaAsrjk0209.R_02090301000000.getKey(), 0);
	}
}
