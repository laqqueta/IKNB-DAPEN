package id.go.ojk.dppks.client.builder.field.rb.metadata;

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
import id.go.ojk.dppks.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dppks.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dppks.client.builder.field.rb.reference.ER2013PosRbDppks1002;

public class Rb1002 extends BaseMetadata {

	public Rb1002(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1002;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER2013PosRbDppks1002.genFieldSave(), null, ER2013PosRbDppks1002.getRequiredPos());
		res.addSegmentValidations(ER2013PosRbDppks1002.genValidationTotalSDM());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2013_RB1002.getObject())));
		fs.add(sf(2, null, "Level Jabatan",
				sv(C, 0, 100, all).confConditionalRequired(ER2013PosRbDppks1002.genConditionalMustEmpty())));
		fs.add(sf(3, null, "Jumlah SDM per 30 Sept 20xx-1",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER2013PosRbDppks1002.genConditionalAllExist())));
		fs.add(sf(4, null, "Jumlah SDM Triwulan IV 20xx-1 (+)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER2013PosRbDppks1002.genConditionalAllExist())));
		fs.add(sf(5, null, "Jumlah SDM Triwulan IV 20xx-1 (-)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER2013PosRbDppks1002.genConditionalAllExist())));
		fs.add(sf(6, null, "Jumlah SDM Triwulan I 20xx (+)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER2013PosRbDppks1002.genConditionalAllExist())));
		fs.add(sf(7, null, "Jumlah SDM Triwulan I 20xx (-)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER2013PosRbDppks1002.genConditionalAllExist())));
		fs.add(sf(8, null, "Jumlah SDM Triwulan II 20xx (+)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER2013PosRbDppks1002.genConditionalAllExist())));
		fs.add(sf(9, null, "Jumlah SDM Triwulan II 20xx (-)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER2013PosRbDppks1002.genConditionalAllExist())));
		fs.add(sf(10, null, "Jumlah SDM Triwulan III 20xx (+)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER2013PosRbDppks1002.genConditionalAllExist())));
		fs.add(sf(11, null, "Jumlah SDM Triwulan III 20xx (-)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER2013PosRbDppks1002.genConditionalAllExist())));
		fs.add(sf(12, null, "Jumlah SDM Triwulan IV 20xx (+)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER2013PosRbDppks1002.genConditionalAllExist())));
		fs.add(sf(13, null, "Jumlah SDM Triwulan IV 20xx (-)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER2013PosRbDppks1002.genConditionalAllExist())));
		return res;
	}
}
