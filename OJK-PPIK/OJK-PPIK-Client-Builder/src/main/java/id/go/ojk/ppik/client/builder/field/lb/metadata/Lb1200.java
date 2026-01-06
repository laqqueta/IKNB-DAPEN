package id.go.ojk.ppik.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.ppik.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.ppik.client.builder.field.lb.reference.ER3011PosLbPpik1200;

public class Lb1200 extends BaseMetadata {

	public Lb1200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_1200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 91, 91, ER3011PosLbPpik1200.genFieldSave(), ER3011PosLbPpik1200.genFieldSave(),
				ER3011PosLbPpik1200.getRequiredPos());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation02());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation03());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation04());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation05());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation10());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation11());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation20());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation27());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation33());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation39());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation43());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation44());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation45());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation51());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation56());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation57());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation63());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation71());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation81());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation82());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation85A());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation85B());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation85C());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation85D());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation86A());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation86B());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation86C());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation86D());
		res.addSegmentValidations(ER3011PosLbPpik1200.genRowValidation92());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 16, 16, refTable).confReference(EHeaderMetadataLb.R3011_LB1200.getObject())
						.confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Indonesian Rupiah", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Mata Uang Asing", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Total", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3011PosLbPpik1200.genFieldValidation4()));
		return res;
	}
}
