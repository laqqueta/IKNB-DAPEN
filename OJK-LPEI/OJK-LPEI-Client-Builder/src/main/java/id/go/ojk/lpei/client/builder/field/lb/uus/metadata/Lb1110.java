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
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.ER7008PosLbLpeiu1110;

public class Lb1110 extends BaseMetadata {

	public Lb1110(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_1110;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 31, 31);

		res.setRequiredPos(ER7008PosLbLpeiu1110.getRequiredPos());
		res.setUniquePos(ER7008PosLbLpeiu1110.getUniquePos());
		res.setSavePos(ER7008PosLbLpeiu1110.genFieldSave());

		res.addSegmentValidations(ER7008PosLbLpeiu1110.genRowValidation05());
		res.addSegmentValidations(ER7008PosLbLpeiu1110.genRowValidation10());
		res.addSegmentValidations(ER7008PosLbLpeiu1110.genRowValidation11());
		res.addSegmentValidations(ER7008PosLbLpeiu1110.genRowValidation13());
		res.addSegmentValidations(ER7008PosLbLpeiu1110.genRowValidation17());
		res.addSegmentValidations(ER7008PosLbLpeiu1110.genRowValidation21());
		res.addSegmentValidations(ER7008PosLbLpeiu1110.genRowValidation22());
		res.addSegmentValidations(ER7008PosLbLpeiu1110.genRowValidation23());
		res.addSegmentValidations(ER7008PosLbLpeiu1110.genRowValidation24());
		res.addSegmentValidations(ER7008PosLbLpeiu1110.genRowValidation27());
		res.addSegmentValidations(ER7008PosLbLpeiu1110.genRowValidation30());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
				.confReference(EHeaderMetadataLbUus.R7008_LB1110.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Rupiah", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(3, null, "Valas", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(4, null, "Jumlah", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER7008PosLbLpeiu1110.genFieldValidation04()));
		return res;
	}
}
