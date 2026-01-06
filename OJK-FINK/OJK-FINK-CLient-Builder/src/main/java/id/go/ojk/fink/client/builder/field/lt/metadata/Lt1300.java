package id.go.ojk.fink.client.builder.field.lt.metadata;

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
import id.go.ojk.fink.client.builder.field.EFormLaporanTahunan;
import id.go.ojk.fink.client.builder.field.lt.reference.EHeaderMetadataLt;
import id.go.ojk.fink.client.builder.field.lt.reference.ER6004PosLtFink1300;

public class Lt1300 extends BaseMetadata {

	public Lt1300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanTahunan eEnum = EFormLaporanTahunan.LT_1300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 13, 13, ER6004PosLtFink1300.genFieldSave(), ER6004PosLtFink1300.genFieldSave(),
				ER6004PosLtFink1300.getRequiredPos());
		res.addSegmentValidations(ER6004PosLtFink1300.genRowValidation01());
		res.addSegmentValidations(ER6004PosLtFink1300.genRowValidation04());
		res.addSegmentValidations(ER6004PosLtFink1300.genRowValidation07());
		res.addSegmentValidations(ER6004PosLtFink1300.genRowValidation11());
		res.addSegmentValidations(ER6004PosLtFink1300.genRowValidation13());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLt.R6004_LT1300.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Nominal", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
