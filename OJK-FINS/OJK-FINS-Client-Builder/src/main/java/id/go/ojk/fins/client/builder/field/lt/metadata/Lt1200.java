package id.go.ojk.fins.client.builder.field.lt.metadata;

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
import id.go.ojk.fins.client.builder.field.EFormLaporanTahunan;
import id.go.ojk.fins.client.builder.field.lt.reference.EHeaderMetadataLt;
import id.go.ojk.fins.client.builder.field.lt.reference.ER6002PosLtFins1200;

public class Lt1200 extends BaseMetadata {

	public Lt1200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanTahunan eEnum = EFormLaporanTahunan.LT_1200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 27, 27, ER6002PosLtFins1200.genFieldSave(), ER6002PosLtFins1200.genFieldSave(),
				ER6002PosLtFins1200.getRequiredPos());
		res.addSegmentValidations(ER6002PosLtFins1200.genRowValidation03());
		res.addSegmentValidations(ER6002PosLtFins1200.genRowValidation07());
		res.addSegmentValidations(ER6002PosLtFins1200.genRowValidation09());
		res.addSegmentValidations(ER6002PosLtFins1200.genRowValidation12());
		res.addSegmentValidations(ER6002PosLtFins1200.genRowValidation13());
		res.addSegmentValidations(ER6002PosLtFins1200.genRowValidation16A());
		res.addSegmentValidations(ER6002PosLtFins1200.genRowValidation16B());
		res.addSegmentValidations(ER6002PosLtFins1200.genRowValidation21());
		res.addSegmentValidations(ER6002PosLtFins1200.genRowValidation22());
		res.addSegmentValidations(ER6002PosLtFins1200.genRowValidation24());
		res.addSegmentValidations(ER6002PosLtFins1200.genRowValidation26());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLt.R6002_LT1200.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Nominal", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
