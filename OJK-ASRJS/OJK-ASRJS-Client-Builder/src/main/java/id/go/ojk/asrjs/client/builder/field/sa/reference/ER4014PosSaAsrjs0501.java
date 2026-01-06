package id.go.ojk.asrjs.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormSelfAssessment;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1099Peringkat;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4014PosSaAsrjs0501 implements IObject<KeyValueString> {
//	R_0501010000 ("0501010000", "A.       Laporan Hasil Penilaian Tingkat Kesehatan Perusahaan"),
	R_0501010100 ("0501010100", "1"),
	R_0501010200 ("0501010200", "2"),
	R_0501010300 ("0501010300", "3"),
	R_0501010400 ("0501010400", "4"),
	R_0501010500 ("0501010500", "Peringkat Tingkat Kesehatan Perusahaan "),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4014PosSaAsrjs0501 eEnum : ER4014PosSaAsrjs0501.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static FieldValidation genValidationPeringkat2() {
		return UtilFieldValidation.genEqualsFixedValue(ER1099Peringkat.getPipedKey());
	}

	public static FieldValidation genValidationPeringkat3() {
		return UtilFieldValidation.genEqualsFixedValueOptional(ER1099Peringkat.getPipedKey());
	}
	
	public static SegmentValidation genValidationTataKelolaPerusahaanYangBaikBagiPerusahaan2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0501010100.key, EFormSelfAssessment.SA_0100.getCode(), "2", ER4000PosSaAsrjs0100.R_01000201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationTataKelolaPerusahaanYangBaikBagiPerusahaan3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0501010100.key, EFormSelfAssessment.SA_0100.getCode(), "2", ER4000PosSaAsrjs0100.R_01000202000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationTataKelolaPerusahaanYangBaikBagiPerusahaan4() {
		return UtilSegmentValidation.genEqualsFormString("4", R_0501010100.key, EFormSelfAssessment.SA_0100.getCode(), "2", ER4000PosSaAsrjs0100.R_01000202010000.getKey());
	}
	
	public static SegmentValidation genValidationProfilRisiko2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0501010200.key, EFormSelfAssessment.SA_0210.getCode(), "2", ER4010PosSaAsrjs0210.R_0210020100.getKey(), 0);
	}
	
	public static SegmentValidation genValidationProfilRisiko3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0501010200.key, EFormSelfAssessment.SA_0210.getCode(), "2", ER4010PosSaAsrjs0210.R_0210020200.getKey(), 0);
	}
	
	public static SegmentValidation genValidationProfilRisiko4() {
		return UtilSegmentValidation.genEqualsFormString("4", R_0501010200.key, EFormSelfAssessment.SA_0210.getCode(), "2", ER4010PosSaAsrjs0210.R_0210020300.getKey());
	}
	
	public static SegmentValidation genValidationRentabilitas2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0501010300.key, EFormSelfAssessment.SA_0300.getCode(), "2", ER4012PosSaAsrjs0300.R_03000201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRentabilitas3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0501010300.key, EFormSelfAssessment.SA_0300.getCode(), "2", ER4012PosSaAsrjs0300.R_03000202000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationRentabilitas4() {
		return UtilSegmentValidation.genEqualsFormString("4", R_0501010300.key, EFormSelfAssessment.SA_0300.getCode(), "2", ER4012PosSaAsrjs0300.R_03000203000000.getKey());
	}
	
	public static SegmentValidation genValidationPermodalan2() {
		return UtilSegmentValidation.genEqualsForm("2", R_0501010400.key, EFormSelfAssessment.SA_0400.getCode(), "2", ER4013PosSaAsrjs0400.R_04000201000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationPermodalan3() {
		return UtilSegmentValidation.genEqualsForm("3", R_0501010400.key, EFormSelfAssessment.SA_0400.getCode(), "2", ER4013PosSaAsrjs0400.R_04000202000000.getKey(), 0);
	}
	
	public static SegmentValidation genValidationPermodalan4() {
		return UtilSegmentValidation.genEqualsFormString("4", R_0501010400.key, EFormSelfAssessment.SA_0400.getCode(), "2", ER4013PosSaAsrjs0400.R_04000203000000.getKey());
	}
}
