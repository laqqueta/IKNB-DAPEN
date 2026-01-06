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
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5010PosLbLpeig1300;

public class Lb1300 extends BaseMetadata {

	public Lb1300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_1300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 51, 51);

		res.setRequiredPos(ER5010PosLbLpeig1300.getRequiredPos());
		res.setUniquePos(ER5010PosLbLpeig1300.getUniquePos());
		res.setSavePos(ER5010PosLbLpeig1300.genFieldSave());
		res.setSavePosForm(ER5010PosLbLpeig1300.genFieldSave());

		res.addSegmentValidations(ER5010PosLbLpeig1300.genRowValidation00());
		res.addSegmentValidations(ER5010PosLbLpeig1300.genRowValidation01());
		res.addSegmentValidations(ER5010PosLbLpeig1300.genRowValidation07());
		res.addSegmentValidations(ER5010PosLbLpeig1300.genRowValidation08());
		res.addSegmentValidations(ER5010PosLbLpeig1300.genRowValidation17());
		res.addSegmentValidations(ER5010PosLbLpeig1300.genRowValidation18());
		res.addSegmentValidations(ER5010PosLbLpeig1300.genRowValidation27());
		res.addSegmentValidations(ER5010PosLbLpeig1300.genRowValidation33());
		res.addSegmentValidations(ER5010PosLbLpeig1300.genRowValidation34());
		res.addSegmentValidations(ER5010PosLbLpeig1300.genRowValidation40());
		res.addSegmentValidations(ER5010PosLbLpeig1300.genRowValidation46());
		//TODO: Yahya - Test validasi 52A, B dan C
		res.addSegmentValidations(ER5010PosLbLpeig1300.genRowValidation52A());
		res.addSegmentValidations(ER5010PosLbLpeig1300.genRowValidation52B());
		res.addSegmentValidations(ER5010PosLbLpeig1300.genRowValidation52C());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
				.confReference(EHeaderMetadataLb.R5010_LB1300.getObject())
				.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Rupiah", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(3, null, "Valas", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(4, null, "Jumlah", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER5010PosLbLpeig1300.genFieldValidation04()));
		return res;
	}
}
