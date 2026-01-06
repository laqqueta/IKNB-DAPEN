package id.go.ojk.fink.client.builder.field.lt.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternLJKName;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.fink.client.builder.field.EFormLaporanTahunan;
import id.go.ojk.fink.client.builder.field.lt.reference.EHeaderMetadataLt;
import id.go.ojk.fink.client.builder.field.lt.reference.ER6016PosLtFink2310;

public class Lt2310 extends BaseMetadata {

	public Lt2310(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanTahunan eEnum = EFormLaporanTahunan.LT_2310;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 10, null, ER6016PosLtFink2310.genFieldSave(), null, ER6016PosLtFink2310.getRequiredPos());
		res.addSegmentValidations(ER6016PosLtFink2310.genRowValidation01A());
		res.addSegmentValidations(ER6016PosLtFink2310.genRowValidation01B());
		res.addSegmentValidations(ER6016PosLtFink2310.genRowValidation03A());
		res.addSegmentValidations(ER6016PosLtFink2310.genRowValidation03B());
		res.addSegmentValidations(ER6016PosLtFink2310.genRowValidation05A());
		res.addSegmentValidations(ER6016PosLtFink2310.genRowValidation05B());
		res.addSegmentValidations(ER6016PosLtFink2310.genRowValidation06A());
		res.addSegmentValidations(ER6016PosLtFink2310.genRowValidation06B());
		res.addSegmentValidations(ER6016PosLtFink2310.genRowValidation08A());
		res.addSegmentValidations(ER6016PosLtFink2310.genRowValidation08B());
		res.addSegmentValidations(ER6016PosLtFink2310.genRowValidation10A());
		res.addSegmentValidations(ER6016PosLtFink2310.genRowValidation10B());
		res.addSegmentValidations(ER6016PosLtFink2310.genRowValidation11A());
		res.addSegmentValidations(ER6016PosLtFink2310.genRowValidation11B());
		res.addSegmentValidations(ER6016PosLtFink2310.genRowValidation13());
		res.addSegmentValidations(ER6016PosLtFink2310.genRowValidation15());
		res.addSegmentValidations(ER6016PosLtFink2310.genRowValidation17());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLt.R6016_LT2310.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Keterangan", sv(C, 1, 100, all).confRegex(patternLJKName)
				.confConditionalRequired(ER6016PosLtFink2310.genConditional())));
		fs.add(sf(3, null, "Jumlah", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
