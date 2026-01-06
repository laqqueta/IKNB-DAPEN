package id.go.ojk.reask.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.reask.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.reask.client.builder.field.rb.reference.ER2005PosRbReask0601;
import id.go.ojk.reask.client.builder.field.reference.EHeaderMetadataShared;

public class Rb0601 extends BaseMetadata {

	public Rb0601(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0601;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER2005PosRbReask0601.genFieldSave(), null, ER2005PosRbReask0601.getRequiredPos());
		res.addSegmentValidations(ER2005PosRbReask0601.genValidationInvestasi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2005_RB0601.getObject())));
		fs.add(sf(2, null, "Jenis Investasi",
				sv(C, 0, 1000, refTable).confReference(EHeaderMetadataShared.R001.getObject())
						.confConditionalRequired(ER2005PosRbReask0601.genConditionalField2())));
		fs.add(sf(3, null, "Aktual per 30 Sept 20XX-1",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER2005PosRbReask0601.genConditionalField())));
		fs.add(sf(4, null, "Proyeksi per 31 Des 20XX-1",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER2005PosRbReask0601.genConditionalField())));
		fs.add(sf(5, null, "Per 30 Jun 20xx",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER2005PosRbReask0601.genConditionalField())));
		fs.add(sf(6, null, "Per 31 Des 20xx",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER2005PosRbReask0601.genConditionalField())));
		return res;
	}
}
