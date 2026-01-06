package id.go.ojk.fins.client.builder.field.lt.metadata;

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
import id.go.ojk.fins.client.builder.field.EFormLaporanTahunan;
import id.go.ojk.fins.client.builder.field.lt.reference.EHeaderMetadataLt;
import id.go.ojk.fins.client.builder.field.lt.reference.ER6014PosLtFins2913;

public class Lt2913 extends BaseMetadata {

	public Lt2913(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanTahunan eEnum = EFormLaporanTahunan.LT_2913;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER6014PosLtFins2913.genFieldSave(), ER6014PosLtFins2913.genFieldSave(),
				ER6014PosLtFins2913.getRequiredPos());
		res.addSegmentValidations(ER6014PosLtFins2913.genRowValidation2());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLt.R6014_LT2913.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama Beban", sv(C, 1, 1000, all).confRegex(patternLJKName)
				.confConditionalRequired(ER6014PosLtFins2913.genConditional())));
		fs.add(sf(3, null, "Jumlah", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Keterangan Tujuan penggunaan)", sv(C, 1, 1000, all).confRegex(patternLJKName)
				.confConditionalRequired(ER6014PosLtFins2913.genConditional())));
		return res;
	}
}
