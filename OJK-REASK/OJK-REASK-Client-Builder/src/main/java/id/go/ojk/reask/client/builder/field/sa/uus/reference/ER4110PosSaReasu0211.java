package id.go.ojk.reask.client.builder.field.sa.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1099Peringkat;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.reask.client.builder.field.EFormSelfAssessmentUus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4110PosSaReasu0211 implements IObject<KeyValueString> {
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

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4110PosSaReasu0211 eEnum : ER4110PosSaReasu0211.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static ConditionalRequired genConditional() {
		return UtilFieldConditional.genExistPos("N", "M", R_0211100000.key);
	}
	
	public static FieldValidation genValidationPeringkatA() {
		return UtilFieldValidation.genPosEqualsFixedValue(ER1099Peringkat.getPipedKey(), UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 9 }));
	}
	
	public static FieldValidation genValidationPeringkatB() {
		return UtilFieldValidation.genEqualsFixedValue(ER1099Peringkat.getPipedKey());
	}
	
	public static SegmentValidation genValidationRisikoStrategis2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211010000.key, EFormSelfAssessmentUus.SA_0201.getCode(), "2", ER4100PosSaReasu0201.R_02010201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoStrategis3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211010000.key, EFormSelfAssessmentUus.SA_0201.getCode(), "2", ER4100PosSaReasu0201.R_02010301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoStrategis4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211010000.key, EFormSelfAssessmentUus.SA_0201.getCode(), "2", ER4100PosSaReasu0201.R_02010303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoStrategis5() {
		return UtilSegmentValidation.genEqualsFormString("5", R_0211010000.key, EFormSelfAssessmentUus.SA_0201.getCode(), "2", ER4100PosSaReasu0201.R_02010400000000.getKey());
	}
	
	public static SegmentValidation genValidationRisikoOperasional2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211020000.key, EFormSelfAssessmentUus.SA_0202.getCode(), "2", ER4101PosSaReasu0202.R_02020201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoOperasional3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211020000.key, EFormSelfAssessmentUus.SA_0202.getCode(), "2", ER4101PosSaReasu0202.R_02020301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoOperasional4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211020000.key, EFormSelfAssessmentUus.SA_0202.getCode(), "2", ER4101PosSaReasu0202.R_02020303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoOperasional5() {
		return UtilSegmentValidation.genEqualsFormString("5", R_0211020000.key, EFormSelfAssessmentUus.SA_0202.getCode(), "2", ER4101PosSaReasu0202.R_02020400000000.getKey());
	}
	
	public static SegmentValidation genValidationRisikoAsuransi2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211030000.key, EFormSelfAssessmentUus.SA_0203.getCode(), "2", ER4102PosSaReasu0203.R_02030201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoAsuransi3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211030000.key, EFormSelfAssessmentUus.SA_0203.getCode(), "2", ER4102PosSaReasu0203.R_02030301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoAsuransi4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211030000.key, EFormSelfAssessmentUus.SA_0203.getCode(), "2", ER4102PosSaReasu0203.R_02030303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoAsuransi5() {
		return UtilSegmentValidation.genEqualsFormString("5", R_0211030000.key, EFormSelfAssessmentUus.SA_0203.getCode(), "2", ER4102PosSaReasu0203.R_02030400000000.getKey());
	}
	
	public static SegmentValidation genValidationRisikoKredit2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211040000.key, EFormSelfAssessmentUus.SA_0204.getCode(), "2", ER4103PosSaReasu0204.R_02040201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKredit3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211040000.key, EFormSelfAssessmentUus.SA_0204.getCode(), "2", ER4103PosSaReasu0204.R_02040301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKredit4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211040000.key, EFormSelfAssessmentUus.SA_0204.getCode(), "2", ER4103PosSaReasu0204.R_02040303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKredit5() {
		return UtilSegmentValidation.genEqualsFormString("5", R_0211040000.key, EFormSelfAssessmentUus.SA_0204.getCode(), "2", ER4103PosSaReasu0204.R_02040400000000.getKey());
	}
	
	public static SegmentValidation genValidationRisikoPasar2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211050000.key, EFormSelfAssessmentUus.SA_0205.getCode(), "2", ER4104PosSaReasu0205.R_02050201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoPasar3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211050000.key, EFormSelfAssessmentUus.SA_0205.getCode(), "2", ER4104PosSaReasu0205.R_02050301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoPasar4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211050000.key, EFormSelfAssessmentUus.SA_0205.getCode(), "2", ER4104PosSaReasu0205.R_02050303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoPasar5() {
		return UtilSegmentValidation.genEqualsFormString("5", R_0211050000.key, EFormSelfAssessmentUus.SA_0205.getCode(), "2", ER4104PosSaReasu0205.R_02050400000000.getKey());
	}
	
	public static SegmentValidation genValidationRisikoLikuiditas2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211060000.key, EFormSelfAssessmentUus.SA_0206.getCode(), "2", ER4105PosSaReasu0206.R_02060201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoLikuiditas3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211060000.key, EFormSelfAssessmentUus.SA_0206.getCode(), "2", ER4105PosSaReasu0206.R_02060301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoLikuiditas4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211060000.key, EFormSelfAssessmentUus.SA_0206.getCode(), "2", ER4105PosSaReasu0206.R_02060303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoLikuiditas5() {
		return UtilSegmentValidation.genEqualsFormString("5", R_0211060000.key, EFormSelfAssessmentUus.SA_0206.getCode(), "2", ER4105PosSaReasu0206.R_02060400000000.getKey());
	}
	
	public static SegmentValidation genValidationRisikoHukum2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211070000.key, EFormSelfAssessmentUus.SA_0207.getCode(), "2", ER4106PosSaReasu0207.R_02070201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoHukum3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211070000.key, EFormSelfAssessmentUus.SA_0207.getCode(), "2", ER4106PosSaReasu0207.R_02070301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoHukum4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211070000.key, EFormSelfAssessmentUus.SA_0207.getCode(), "2", ER4106PosSaReasu0207.R_02070303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoHukum5() {
		return UtilSegmentValidation.genEqualsFormString("5", R_0211070000.key, EFormSelfAssessmentUus.SA_0207.getCode(), "2", ER4106PosSaReasu0207.R_02070400000000.getKey());
	}
	
	public static SegmentValidation genValidationRisikoKepatuhan2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211080000.key, EFormSelfAssessmentUus.SA_0208.getCode(), "2", ER4107PosSaReasu0208.R_02080201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKepatuhan3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211080000.key, EFormSelfAssessmentUus.SA_0208.getCode(), "2", ER4107PosSaReasu0208.R_02080301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKepatuhan4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211080000.key, EFormSelfAssessmentUus.SA_0208.getCode(), "2", ER4107PosSaReasu0208.R_02080303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKepatuhan5() {
		return UtilSegmentValidation.genEqualsFormString("5", R_0211080000.key, EFormSelfAssessmentUus.SA_0208.getCode(), "2", ER4107PosSaReasu0208.R_02080400000000.getKey());
	}
	
	public static SegmentValidation genValidationRisikoReputasi2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211090000.key, EFormSelfAssessmentUus.SA_0209.getCode(), "2", ER4108PosSaReasu0209.R_02090201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoReputasi3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211090000.key, EFormSelfAssessmentUus.SA_0209.getCode(), "2", ER4108PosSaReasu0209.R_02090301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoReputasi4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211090000.key, EFormSelfAssessmentUus.SA_0209.getCode(), "2", ER4108PosSaReasu0209.R_02090303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoReputasi5() {
		return UtilSegmentValidation.genEqualsFormString("5", R_0211090000.key, EFormSelfAssessmentUus.SA_0209.getCode(), "2", ER4108PosSaReasu0209.R_02090400000000.getKey());
	}
	
	public static SegmentValidation genValidationPeringkatKomposit4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211100000.key, EFormSelfAssessmentUus.SA_0210.getCode(), "2", ER4109PosSaReasu0210.R_0210020100.getKey(), 0);
	}
	
	public static SegmentValidation genValidationPeringkatKomposit5() {
		return UtilSegmentValidation.genEqualsFormString("5", R_0211100000.key, EFormSelfAssessmentUus.SA_0210.getCode(), "2", ER4109PosSaReasu0210.R_0210020300.getKey());
	}
}
