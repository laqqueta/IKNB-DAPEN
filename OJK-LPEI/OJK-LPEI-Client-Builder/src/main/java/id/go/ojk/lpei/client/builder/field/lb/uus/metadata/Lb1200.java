package id.go.ojk.lpei.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.ER7009PosLbLpeiu1200;

public class Lb1200 extends BaseMetadata {

	public Lb1200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_1200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 65, 65);

		res.setRequiredPos(ER7009PosLbLpeiu1200.getRequiredPos());
		res.setUniquePos(ER7009PosLbLpeiu1200.getUniquePos());
		res.setSavePos(ER7009PosLbLpeiu1200.genFieldSave());
		res.setSavePosForm(ER7009PosLbLpeiu1200.genFieldSave());

		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation06());
		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation11());
		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation12());
		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation16());
		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation20());
		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation25());
		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation29());
		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation30());
		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation34());
		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation35());
		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation45());
		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation51());
		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation52());
		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation55());
		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation56());
		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation59());
		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation60());
//		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation60B());
//		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation60C());
		res.addSegmentValidations(ER7009PosLbLpeiu1200.genRowValidation66A());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
				.confReference(EHeaderMetadataLbUus.R7009_LB1200.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Rupiah", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(3, null, "Valas", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(4, null, "Jumlah", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER7009PosLbLpeiu1200.genFieldValidation04()));
		return res;
	}
}
