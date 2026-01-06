package id.go.ojk.lpei.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.ER7007PosLbLpeiu1100;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.ER7011PosLbLpeiu2000;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2000 extends BaseMetadata {

	public Lb2000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null);
		res.setSavePosForm(ER7011PosLbLpeiu2000.genFieldSave());
		res.setSavePos(ER7011PosLbLpeiu2000.genFieldSave());
		res.addSegmentValidations(ER7011PosLbLpeiu2000.genRowValidation02());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R7011_LB2000.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Jenis",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R051.getObject())
						.confConditionalRequired(ER7011PosLbLpeiu2000.genConditionalExist())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(3, null, "Jenis Valuta",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R020.getObject())
						.confConditionalRequired(ER7011PosLbLpeiu2000.genConditionalExist())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(4, null, "Jumlah", sv(M, 1, 20, DataType.numeric)));
		fs.add(sf(5, null, "Persentase Terhadap Modal",
				sv(C, 1, 10, DataType.numericDot).confConditionalRequired(ER7011PosLbLpeiu2000.genConditionalExist()))
				.addFieldValidations(UtilFieldValidation.genEqualsDivisionForm("4", "5",
						EFormLaporanBulananUus.LB_1100.getCode(), ER7007PosLbLpeiu1100.R_11000600000000.getKey(), "4",
						"Kolom Jumlah di form 2000 dibagi Total Ekuitas (11000600000000) Pada Kolom Jumlah di Form 1100")));
		return res;
	}
}
