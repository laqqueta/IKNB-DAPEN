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
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5007PosLbLpeig1100;

public class Lb1100 extends BaseMetadata {

	public Lb1100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_1100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 75, 75);

		res.setRequiredPos(ER5007PosLbLpeig1100.getRequiredPos());
		res.setUniquePos(ER5007PosLbLpeig1100.getUniquePos());
		res.setSavePos(ER5007PosLbLpeig1100.genFieldSave());
		res.setSavePosForm(ER5007PosLbLpeig1100.genFieldSave());

		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation04());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation05());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation07());
//		TODO: Yahya - genRowValidation12 lepas validasi menunggu konfirmasi.
//		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation12());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation14());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation16());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation20());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation21());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation22());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation24());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation26());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation27());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation28());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation31());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation39());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation40());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation42());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation43());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation44());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation46());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation48());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation54());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation55());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation56());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation60());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation61());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation65A());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation65B());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation67());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation68());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation74A());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation74B());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation75());
		res.addSegmentValidations(ER5007PosLbLpeig1100.genRowValidation76());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
				.confReference(EHeaderMetadataLb.R5007_LB1100.getObject())
				.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Rupiah", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(3, null, "Valas", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(4, null, "Jumlah", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER5007PosLbLpeig1100.genFieldValidation04()));
		return res;
	}
}
