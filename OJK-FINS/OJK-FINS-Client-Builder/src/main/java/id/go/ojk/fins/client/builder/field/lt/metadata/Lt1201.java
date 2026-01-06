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
import id.go.ojk.fins.client.builder.field.lt.reference.ER6003PosLtFins1201;

public class Lt1201 extends BaseMetadata {

	public Lt1201(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanTahunan eEnum = EFormLaporanTahunan.LT_1201;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 6, 6, ER6003PosLtFins1201.genFieldSave(), ER6003PosLtFins1201.genFieldSave(),
				ER6003PosLtFins1201.getRequiredPos());
//		res.addSegmentValidations(ER6003PosLtFins1201.genRowValidation2());//disable, request by OJK
		res.addSegmentValidations(ER6003PosLtFins1201.genRowValidation3());
		res.addSegmentValidations(ER6003PosLtFins1201.genRowValidation6());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLt.R6003_LT1201.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Nominal", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
