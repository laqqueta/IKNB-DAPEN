package id.go.ojk.dppks.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppks.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dppks.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dppks.client.builder.field.rb.reference.ER2004PosRbDppks0403;

public class Rb0403 extends BaseMetadata {

	public Rb0403(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0403;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2004_RB0403.getObject())));
		fs.add(sf(2, null, "Target", sv(O, 0, 300, all)));
		fs.add(sf(3, null, "Kebijakan",
				sv(C, 0, 300, all).confConditionalRequired(ER2004PosRbDppks0403.genConditionalAllExist())));
		fs.add(sf(4, null, "Strategi",
				sv(C, 0, 300, all).confConditionalRequired(ER2004PosRbDppks0403.genConditionalAllExist())));
		return res;
	}
}
