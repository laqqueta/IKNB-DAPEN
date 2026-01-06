package id.go.ojk.dplkk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dplkk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dplkk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dplkk.client.builder.field.rb.reference.ER2013PosRbDplkk1400;

public class Rb1400 extends BaseMetadata {

	public Rb1400(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1400;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER2013PosRbDplkk1400.genFieldSave(), null,
				ER2013PosRbDplkk1400.getRequiredPos());
		res.addSegmentValidations(ER2013PosRbDplkk1400.genTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2013_RB1400.getObject())));
		fs.add(sf(2, null, "Level Jabatan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2013PosRbDplkk1400.genConditional2())));
		fs.add(sf(3, null, "Jumlah SDM per 30 Sept 20xx-1",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2013PosRbDplkk1400.genConditional())));
		fs.add(sf(4, null, "Jumlah SDM Triwulan IV 20xx-1 (+)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2013PosRbDplkk1400.genConditional())));
		fs.add(sf(5, null, "Jumlah SDM Triwulan IV 20xx-1 (-)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2013PosRbDplkk1400.genConditional())));
		fs.add(sf(6, null, "Jumlah SDM Triwulan I 20xx (+)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2013PosRbDplkk1400.genConditional())));
		fs.add(sf(7, null, "Jumlah SDM Triwulan I 20xx (-)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2013PosRbDplkk1400.genConditional())));
		fs.add(sf(8, null, "Jumlah SDM Triwulan II 20xx (+)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2013PosRbDplkk1400.genConditional())));
		fs.add(sf(9, null, "Jumlah SDM Triwulan II 20xx (-)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2013PosRbDplkk1400.genConditional())));
		fs.add(sf(10, null, "Jumlah SDM Triwulan III 20xx (+)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2013PosRbDplkk1400.genConditional())));
		fs.add(sf(11, null, "Jumlah SDM Triwulan III 20xx (-)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2013PosRbDplkk1400.genConditional())));
		fs.add(sf(12, null, "Jumlah SDM Triwulan IV 20xx (+)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2013PosRbDplkk1400.genConditional())));
		fs.add(sf(13, null, "Jumlah SDM Triwulan IV 20xx (-)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2013PosRbDplkk1400.genConditional())));
		return res;
	}
}
