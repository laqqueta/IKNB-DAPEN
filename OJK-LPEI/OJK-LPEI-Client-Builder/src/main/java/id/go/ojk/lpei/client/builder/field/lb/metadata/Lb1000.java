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
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5006PosLbLpeig1000;

public class Lb1000 extends BaseMetadata {

	public Lb1000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_1000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 27, 27);

		res.setRequiredPos(ER5006PosLbLpeig1000.getRequiredPos());
		res.setUniquePos(ER5006PosLbLpeig1000.getUniquePos());
		res.setSavePos(ER5006PosLbLpeig1000.genFieldSave());

		res.addSegmentValidations(ER5006PosLbLpeig1000.genRowValidation02());
		res.addSegmentValidations(ER5006PosLbLpeig1000.genRowValidation03());
		res.addSegmentValidations(ER5006PosLbLpeig1000.genRowValidation11());
		res.addSegmentValidations(ER5006PosLbLpeig1000.genRowValidation17());
		res.addSegmentValidations(ER5006PosLbLpeig1000.genRowValidation20());
		res.addSegmentValidations(ER5006PosLbLpeig1000.genRowValidation21());
		res.addSegmentValidations(ER5006PosLbLpeig1000.genValidationNumeric());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R5006_LB1000.getObject())
				.confRegex(patternNumeric)));
		fs.add(sf(2, null, "L", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(3, null, "DPK", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(4, null, "KL", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(5, null, "D", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(6, null, "M", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(7, null, "Jumlah", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER5006PosLbLpeig1000.genFieldValidation07()));
		return res;
	}
}
