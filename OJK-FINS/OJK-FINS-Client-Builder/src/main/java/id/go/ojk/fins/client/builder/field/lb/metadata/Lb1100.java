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
import id.go.ojk.fins.client.builder.field.lb.reference.ER3004PosLbFins1100;

public class Lb1100 extends BaseMetadata {

	public Lb1100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_1100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 50, 50, ER3004PosLbFins1100.genFieldSave(), ER3004PosLbFins1100.genFieldSave(),
				ER3004PosLbFins1100.getRequiredPos());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation01A());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation01B());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation02());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation10A());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation10B());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation14());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation15());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation16());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation18());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation21A());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation21B());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation25());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation26A());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation26B());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation29A());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation29B());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation33());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation34());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation35A());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation35B());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation40());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation41());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation46());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation48A());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation48B());
		res.addSegmentValidations(ER3004PosLbFins1100.genRowValidation49());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R3004_LB1100.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Nominal", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
