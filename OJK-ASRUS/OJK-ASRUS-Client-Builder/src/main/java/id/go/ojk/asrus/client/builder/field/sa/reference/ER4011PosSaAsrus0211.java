package id.go.ojk.asrus.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrus.client.builder.field.EFormSelfAssessment;
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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4011PosSaAsrus0211 implements IObject<KeyValueString> {
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
		for (ER4011PosSaAsrus0211 eEnum : ER4011PosSaAsrus0211.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static ConditionalRequired genConditionalA() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 9 }));
	}

	public static ConditionalRequired genConditionalB() {
		return UtilFieldConditional.genExistPos("N", "O", UtilMetadata.genPipeRow(getObjects(), new int[] { 9 }));
	}

	public static FieldValidation genValidationPeringkatA() {
		return UtilFieldValidation.genEqualsFixedValue(ER1099Peringkat.getPipedKey());
	}

	public static FieldValidation genValidationPeringkatB() {
		return UtilFieldValidation.genEqualsFixedValueOptional(ER1099Peringkat.getPipedKey());
	}
	
	public static SegmentValidation genValidationRisikoStrategis2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211010000.key, EFormSelfAssessment.SA_0201.getCode(), "2", ER4001PosSaAsrus0201.R_02010201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoStrategis3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211010000.key, EFormSelfAssessment.SA_0201.getCode(), "2", ER4001PosSaAsrus0201.R_02010301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoStrategis4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211010000.key, EFormSelfAssessment.SA_0201.getCode(), "2", ER4001PosSaAsrus0201.R_02010303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoStrategis5() {
		return UtilSegmentValidation.genEqualsForm("5", R_0211010000.key, EFormSelfAssessment.SA_0201.getCode(), "2", ER4001PosSaAsrus0201.R_02010401000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoStrategis6() {
		return UtilSegmentValidation.genEqualsForm("6", R_0211010000.key, EFormSelfAssessment.SA_0201.getCode(), "2", ER4001PosSaAsrus0201.R_02010501000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoStrategis7() {
		return UtilSegmentValidation.genEqualsForm("7", R_0211010000.key, EFormSelfAssessment.SA_0201.getCode(), "2", ER4001PosSaAsrus0201.R_02010503000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoStrategis8() {
		return UtilSegmentValidation.genEqualsFormString("8", R_0211010000.key, EFormSelfAssessment.SA_0201.getCode(), "2", ER4001PosSaAsrus0201.R_02010600000000.getKey());
	}
	
	public static SegmentValidation genValidationRisikoOperasional2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211020000.key, EFormSelfAssessment.SA_0202.getCode(), "2", ER4002PosSaAsrus0202.R_02020201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoOperasional3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211020000.key, EFormSelfAssessment.SA_0202.getCode(), "2", ER4002PosSaAsrus0202.R_02020301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoOperasional4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211020000.key, EFormSelfAssessment.SA_0202.getCode(), "2", ER4002PosSaAsrus0202.R_02020303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoOperasional5() {
		return UtilSegmentValidation.genEqualsForm("5", R_0211020000.key, EFormSelfAssessment.SA_0202.getCode(), "2", ER4002PosSaAsrus0202.R_02020401000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoOperasional6() {
		return UtilSegmentValidation.genEqualsForm("6", R_0211020000.key, EFormSelfAssessment.SA_0202.getCode(), "2", ER4002PosSaAsrus0202.R_02020501000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoOperasional7() {
		return UtilSegmentValidation.genEqualsForm("7", R_0211020000.key, EFormSelfAssessment.SA_0202.getCode(), "2", ER4002PosSaAsrus0202.R_02020503000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoOperasional8() {
		return UtilSegmentValidation.genEqualsFormString("8", R_0211020000.key, EFormSelfAssessment.SA_0202.getCode(), "2", ER4002PosSaAsrus0202.R_02020600000000.getKey());
	}
	
	public static SegmentValidation genValidationRisikoAsuransi2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211030000.key, EFormSelfAssessment.SA_0203.getCode(), "2", ER4003PosSaAsrus0203.R_02030201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoAsuransi3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211030000.key, EFormSelfAssessment.SA_0203.getCode(), "2", ER4003PosSaAsrus0203.R_02030301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoAsuransi4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211030000.key, EFormSelfAssessment.SA_0203.getCode(), "2", ER4003PosSaAsrus0203.R_02030303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoAsuransi5() {
		return UtilSegmentValidation.genEqualsForm("5", R_0211030000.key, EFormSelfAssessment.SA_0203.getCode(), "2", ER4003PosSaAsrus0203.R_02030401000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoAsuransi6() {
		return UtilSegmentValidation.genEqualsForm("6", R_0211030000.key, EFormSelfAssessment.SA_0203.getCode(), "2", ER4003PosSaAsrus0203.R_02030501000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoAsuransi7() {
		return UtilSegmentValidation.genEqualsForm("7", R_0211030000.key, EFormSelfAssessment.SA_0203.getCode(), "2", ER4003PosSaAsrus0203.R_02030503000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoAsuransi8() {
		return UtilSegmentValidation.genEqualsFormString("8", R_0211030000.key, EFormSelfAssessment.SA_0203.getCode(), "2", ER4003PosSaAsrus0203.R_02030600000000.getKey());
	}
	
	public static SegmentValidation genValidationRisikoKredit2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211040000.key, EFormSelfAssessment.SA_0204.getCode(), "2", ER4004PosSaAsrus0204.R_02040201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKredit3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211040000.key, EFormSelfAssessment.SA_0204.getCode(), "2", ER4004PosSaAsrus0204.R_02040301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKredit4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211040000.key, EFormSelfAssessment.SA_0204.getCode(), "2", ER4004PosSaAsrus0204.R_02040303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKredit5() {
		return UtilSegmentValidation.genEqualsForm("5", R_0211040000.key, EFormSelfAssessment.SA_0204.getCode(), "2", ER4004PosSaAsrus0204.R_02040401000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKredit6() {
		return UtilSegmentValidation.genEqualsForm("6", R_0211040000.key, EFormSelfAssessment.SA_0204.getCode(), "2", ER4004PosSaAsrus0204.R_02040501000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKredit7() {
		return UtilSegmentValidation.genEqualsForm("7", R_0211040000.key, EFormSelfAssessment.SA_0204.getCode(), "2", ER4004PosSaAsrus0204.R_02040503000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKredit8() {
		return UtilSegmentValidation.genEqualsFormString("8", R_0211040000.key, EFormSelfAssessment.SA_0204.getCode(), "2", ER4004PosSaAsrus0204.R_02040600000000.getKey());
	}
	
	public static SegmentValidation genValidationRisikoPasar2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211050000.key, EFormSelfAssessment.SA_0205.getCode(), "2", ER4005PosSaAsrus0205.R_02050201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoPasar3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211050000.key, EFormSelfAssessment.SA_0205.getCode(), "2", ER4005PosSaAsrus0205.R_02050301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoPasar4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211050000.key, EFormSelfAssessment.SA_0205.getCode(), "2", ER4005PosSaAsrus0205.R_02050303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoPasar5() {
		return UtilSegmentValidation.genEqualsForm("5", R_0211050000.key, EFormSelfAssessment.SA_0205.getCode(), "2", ER4005PosSaAsrus0205.R_02050401000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoPasar6() {
		return UtilSegmentValidation.genEqualsForm("6", R_0211050000.key, EFormSelfAssessment.SA_0205.getCode(), "2", ER4005PosSaAsrus0205.R_02050501000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoPasar7() {
		return UtilSegmentValidation.genEqualsForm("7", R_0211050000.key, EFormSelfAssessment.SA_0205.getCode(), "2", ER4005PosSaAsrus0205.R_02050503000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoPasar8() {
		return UtilSegmentValidation.genEqualsFormString("8", R_0211050000.key, EFormSelfAssessment.SA_0205.getCode(), "2", ER4005PosSaAsrus0205.R_02050600000000.getKey());
	}
	
	public static SegmentValidation genValidationRisikoLikuiditas2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211060000.key, EFormSelfAssessment.SA_0206.getCode(), "2", ER4006PosSaAsrus0206.R_02060201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoLikuiditas3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211060000.key, EFormSelfAssessment.SA_0206.getCode(), "2", ER4006PosSaAsrus0206.R_02060301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoLikuiditas4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211060000.key, EFormSelfAssessment.SA_0206.getCode(), "2", ER4006PosSaAsrus0206.R_02060303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoLikuiditas5() {
		return UtilSegmentValidation.genEqualsForm("5", R_0211060000.key, EFormSelfAssessment.SA_0206.getCode(), "2", ER4006PosSaAsrus0206.R_02060401000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoLikuiditas6() {
		return UtilSegmentValidation.genEqualsForm("6", R_0211060000.key, EFormSelfAssessment.SA_0206.getCode(), "2", ER4006PosSaAsrus0206.R_02060501000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoLikuiditas7() {
		return UtilSegmentValidation.genEqualsForm("7", R_0211060000.key, EFormSelfAssessment.SA_0206.getCode(), "2", ER4006PosSaAsrus0206.R_02060503000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoLikuiditas8() {
		return UtilSegmentValidation.genEqualsFormString("8", R_0211060000.key, EFormSelfAssessment.SA_0206.getCode(), "2", ER4006PosSaAsrus0206.R_02060600000000.getKey());
	}
	
	public static SegmentValidation genValidationRisikoHukum2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211070000.key, EFormSelfAssessment.SA_0207.getCode(), "2", ER4007PosSaAsrus0207.R_02070201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoHukum3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211070000.key, EFormSelfAssessment.SA_0207.getCode(), "2", ER4007PosSaAsrus0207.R_02070301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoHukum4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211070000.key, EFormSelfAssessment.SA_0207.getCode(), "2", ER4007PosSaAsrus0207.R_02070303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoHukum5() {
		return UtilSegmentValidation.genEqualsForm("5", R_0211070000.key, EFormSelfAssessment.SA_0207.getCode(), "2", ER4007PosSaAsrus0207.R_02070401000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoHukum6() {
		return UtilSegmentValidation.genEqualsForm("6", R_0211070000.key, EFormSelfAssessment.SA_0207.getCode(), "2", ER4007PosSaAsrus0207.R_02070501000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoHukum7() {
		return UtilSegmentValidation.genEqualsForm("7", R_0211070000.key, EFormSelfAssessment.SA_0207.getCode(), "2", ER4007PosSaAsrus0207.R_02070503000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoHukum8() {
		return UtilSegmentValidation.genEqualsFormString("8", R_0211070000.key, EFormSelfAssessment.SA_0207.getCode(), "2", ER4007PosSaAsrus0207.R_02070600000000.getKey());
	}
	
	public static SegmentValidation genValidationRisikoKepatuhan2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211080000.key, EFormSelfAssessment.SA_0208.getCode(), "2", ER4008PosSaAsrus0208.R_02080201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKepatuhan3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211080000.key, EFormSelfAssessment.SA_0208.getCode(), "2", ER4008PosSaAsrus0208.R_02080301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKepatuhan4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211080000.key, EFormSelfAssessment.SA_0208.getCode(), "2", ER4008PosSaAsrus0208.R_02080303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKepatuhan5() {
		return UtilSegmentValidation.genEqualsForm("5", R_0211080000.key, EFormSelfAssessment.SA_0208.getCode(), "2", ER4008PosSaAsrus0208.R_02080401000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKepatuhan6() {
		return UtilSegmentValidation.genEqualsForm("6", R_0211080000.key, EFormSelfAssessment.SA_0208.getCode(), "2", ER4008PosSaAsrus0208.R_02080501000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKepatuhan7() {
		return UtilSegmentValidation.genEqualsForm("7", R_0211080000.key, EFormSelfAssessment.SA_0208.getCode(), "2", ER4008PosSaAsrus0208.R_02080503000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoKepatuhan8() {
		return UtilSegmentValidation.genEqualsFormString("8", R_0211080000.key, EFormSelfAssessment.SA_0208.getCode(), "2", ER4008PosSaAsrus0208.R_02080600000000.getKey());
	}
	
	public static SegmentValidation genValidationRisikoReputasi2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0211090000.key, EFormSelfAssessment.SA_0209.getCode(), "2", ER4009PosSaAsrus0209.R_02090201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoReputasi3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0211090000.key, EFormSelfAssessment.SA_0209.getCode(), "2", ER4009PosSaAsrus0209.R_02090301000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoReputasi4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211090000.key, EFormSelfAssessment.SA_0209.getCode(), "2", ER4009PosSaAsrus0209.R_02090303000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoReputasi5() {
		return UtilSegmentValidation.genEqualsForm("5", R_0211090000.key, EFormSelfAssessment.SA_0209.getCode(), "2", ER4009PosSaAsrus0209.R_02090401000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoReputasi6() {
		return UtilSegmentValidation.genEqualsForm("6", R_0211090000.key, EFormSelfAssessment.SA_0209.getCode(), "2", ER4009PosSaAsrus0209.R_02090501000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoReputasi7() {
		return UtilSegmentValidation.genEqualsForm("7", R_0211090000.key, EFormSelfAssessment.SA_0209.getCode(), "2", ER4009PosSaAsrus0209.R_02090503000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRisikoReputasi8() {
		return UtilSegmentValidation.genEqualsFormString("8", R_0211090000.key, EFormSelfAssessment.SA_0209.getCode(), "2", ER4009PosSaAsrus0209.R_02090600000000.getKey());
	}
	
	public static SegmentValidation genValidationPeringkatKomposit4() {
		return UtilSegmentValidation.genEqualsForm("4", R_0211100000.key, EFormSelfAssessment.SA_0210.getCode(), "2", ER4010PosSaAsrus0210.R_0210020100.getKey(), 0);
	}
	
	public static SegmentValidation genValidationPeringkatKomposit7() {
		return UtilSegmentValidation.genEqualsForm("7", R_0211100000.key, EFormSelfAssessment.SA_0210.getCode(), "2", ER4010PosSaAsrus0210.R_0210020200.getKey(), 0);
	}
	
	public static SegmentValidation genValidationPeringkatKomposit8() {
		return UtilSegmentValidation.genEqualsFormString("8", R_0211100000.key, EFormSelfAssessment.SA_0210.getCode(), "2", ER4010PosSaAsrus0210.R_0210020300.getKey());
	}
}
