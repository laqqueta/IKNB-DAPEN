package id.go.ojk.fins.client.builder.field.lb.metadata;

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
import id.go.ojk.fins.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.fins.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.fins.client.builder.field.lb.reference.ER3007PosLbFins1300;

public class Lb1300 extends BaseMetadata {

	public Lb1300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_1300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 13, 13, ER3007PosLbFins1300.genFieldSave(), ER3007PosLbFins1300.genFieldSave(),
				ER3007PosLbFins1300.getRequiredPos());
		res.addSegmentValidations(ER3007PosLbFins1300.genRowValidation01());
		res.addSegmentValidations(ER3007PosLbFins1300.genRowValidation04());
		res.addSegmentValidations(ER3007PosLbFins1300.genRowValidation07());
		res.addSegmentValidations(ER3007PosLbFins1300.genRowValidation11());
		res.addSegmentValidations(ER3007PosLbFins1300.genRowValidation13());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R3007_LB1300.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Nominal", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
