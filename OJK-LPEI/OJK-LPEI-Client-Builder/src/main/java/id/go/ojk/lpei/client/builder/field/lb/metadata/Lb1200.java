package id.go.ojk.lpei.client.builder.field.lb.metadata;

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
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lpei.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5009PosLbLpeig1200;

public class Lb1200 extends BaseMetadata {

	public Lb1200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_1200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 69, 69);

		res.setRequiredPos(ER5009PosLbLpeig1200.getRequiredPos());
		res.setUniquePos(ER5009PosLbLpeig1200.getUniquePos());
		res.setSavePos(ER5009PosLbLpeig1200.genFieldSave());
		res.setSavePosForm(ER5009PosLbLpeig1200.genFieldSave());

		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation00());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation03());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation07());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation13());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation14());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation18());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation22());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation27());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation31());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation32());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation36());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation37());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation47());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation53());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation54());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation57());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation58());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation61());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation62());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation68A());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation68B());
		res.addSegmentValidations(ER5009PosLbLpeig1200.genRowValidation68C());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
				.confReference(EHeaderMetadataLb.R5009_LB1200.getObject())
				.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Rupiah", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(3, null, "Valas", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(4, null, "Jumlah", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER5009PosLbLpeig1200.genFieldValidation04()));
		return res;
	}
}
