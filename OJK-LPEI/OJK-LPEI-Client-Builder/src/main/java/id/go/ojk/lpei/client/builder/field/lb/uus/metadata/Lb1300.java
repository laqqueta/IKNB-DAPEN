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
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.ER7010PosLbLpeiu1300;

public class Lb1300 extends BaseMetadata {

	public Lb1300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_1300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 36, 36);

		res.setRequiredPos(ER7010PosLbLpeiu1300.getRequiredPos());
		res.setUniquePos(ER7010PosLbLpeiu1300.getUniquePos());
		res.setSavePos(ER7010PosLbLpeiu1300.genFieldSave());
		res.setSavePosForm(ER7010PosLbLpeiu1300.genFieldSave());

//		res.addSegmentValidations(ER7010PosLbLpeiu1300.genRowValidation37A());
//		res.addSegmentValidations(ER7010PosLbLpeiu1300.genRowValidation37B());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
				.confReference(EHeaderMetadataLbUus.R7010_LB1300.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Rupiah", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(3, null, "Valas", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(4, null, "Jumlah", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER7010PosLbLpeiu1300.genFieldValidation04()));
		return res;
	}
}
