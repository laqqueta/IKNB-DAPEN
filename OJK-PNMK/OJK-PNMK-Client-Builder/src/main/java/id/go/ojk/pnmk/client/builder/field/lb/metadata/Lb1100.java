package id.go.ojk.pnmk.client.builder.field.lb.metadata;

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
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnmk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnmk.client.builder.field.lb.reference.ER3003PosLbPnmk1100;

public class Lb1100 extends BaseMetadata {

	public Lb1100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_1100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 57, 57, ER3003PosLbPnmk1100.genFieldSave(), null, ER3003PosLbPnmk1100.getRequiredPos());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genValidationNumeric());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation02A());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation02B());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation03A());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation03B());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation04());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation05());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation07());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation14());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation20A());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation20B());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation28A());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation28B());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation34());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation41());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation42());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation46());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation49());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation51());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation52());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation57());
		res.addSegmentValidations(ER3003PosLbPnmk1100.genRowValidation58());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R3003_LB1100.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Jumlah", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
