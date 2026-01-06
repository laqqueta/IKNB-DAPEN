package id.go.ojk.pnmk.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnmk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnmk.client.builder.field.lb.reference.ER3005PosLbPnmk1300;

public class Lb1300 extends BaseMetadata {

	public Lb1300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_1300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 57, 57, ER3005PosLbPnmk1300.genFieldSave(), ER3005PosLbPnmk1300.genFieldSave(),
				ER3005PosLbPnmk1300.getRequiredPos());
//		res.addSegmentValidations(ER3005PosLbPnmk1300.genRowValidation02());
		res.addSegmentValidations(ER3005PosLbPnmk1300.genRowValidation03());
		res.addSegmentValidations(ER3005PosLbPnmk1300.genRowValidation10());
		res.addSegmentValidations(ER3005PosLbPnmk1300.genRowValidation17());
//		res.addSegmentValidations(ER3005PosLbPnmk1300.genRowValidation18());
		res.addSegmentValidations(ER3005PosLbPnmk1300.genRowValidation19());
		res.addSegmentValidations(ER3005PosLbPnmk1300.genRowValidation27());
		res.addSegmentValidations(ER3005PosLbPnmk1300.genRowValidation33());
//		res.addSegmentValidations(ER3005PosLbPnmk1300.genRowValidation34());
		res.addSegmentValidations(ER3005PosLbPnmk1300.genRowValidation35());
		res.addSegmentValidations(ER3005PosLbPnmk1300.genRowValidation46());
		res.addSegmentValidations(ER3005PosLbPnmk1300.genRowValidation55());
//		res.addSegmentValidations(ER3005PosLbPnmk1300.genRowValidation56());
		res.addSegmentValidations(ER3005PosLbPnmk1300.genRowValidation58());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R3005_LB1300.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Jumlah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3005PosLbPnmk1300.genConditional())));
//		fs.add(sf(2, null, "Jumlah", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
