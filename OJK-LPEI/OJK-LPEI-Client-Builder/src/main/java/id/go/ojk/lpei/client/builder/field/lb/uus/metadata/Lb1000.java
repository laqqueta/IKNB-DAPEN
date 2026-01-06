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
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.ER7006PosLbLpeiu1000;

public class Lb1000 extends BaseMetadata {

	public Lb1000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_1000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 34, 34);

		res.setRequiredPos(ER7006PosLbLpeiu1000.getRequiredPos());
		res.setUniquePos(ER7006PosLbLpeiu1000.getUniquePos());
		res.setSavePos(ER7006PosLbLpeiu1000.genFieldSave());

		res.addSegmentValidations(ER7006PosLbLpeiu1000.genRowValidation02());
		res.addSegmentValidations(ER7006PosLbLpeiu1000.genRowValidation03());
		res.addSegmentValidations(ER7006PosLbLpeiu1000.genRowValidation04());
		res.addSegmentValidations(ER7006PosLbLpeiu1000.genRowValidation18());
		res.addSegmentValidations(ER7006PosLbLpeiu1000.genRowValidation25());
		res.addSegmentValidations(ER7006PosLbLpeiu1000.genRowValidation28());
		res.addSegmentValidations(ER7006PosLbLpeiu1000.genValidationNumeric());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLbUus.R7006_LB1000.getObject())
				.confRegex(patternNumeric)));
		fs.add(sf(2, null, "L", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(3, null, "DPK", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(4, null, "KL", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(5, null, "D", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(6, null, "M", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(7, null, "Jumlah", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER7006PosLbLpeiu1000.genFieldValidation07()));
		return res;
	}
}
