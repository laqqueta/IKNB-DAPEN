package id.go.ojk.ppk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.ER2503PosRbPpu040301;
import id.go.ojk.ppk.client.builder.field.reference.EHeaderMetadataShared;

public class Rb040301 extends BaseMetadata {

	public Rb040301(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_040301;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 3, null, ER2503PosRbPpu040301.genFieldSave(), null, ER2503PosRbPpu040301.getRequiredPos());
		res.addSegmentValidations(ER2503PosRbPpu040301.genValidationNumeric());
		res.addSegmentValidations(ER2503PosRbPpu040301.genValidationNumericDot());
		res.addSegmentValidations(ER2503PosRbPpu040301.genValidationTotalPenyaluranPembiayaankepadaPihakTerkait());
		res.addSegmentValidations(ER2503PosRbPpu040301.genValidationRasioEqual());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2503_RB040301.getObject())));
		fs.add(sf(2, null, "Nama Debitur Pihak Terkait",
				sv(C, 0, 255, all).confConditionalRequired(ER2503PosRbPpu040301.genConditionalFieldMustEmpty())));
		fs.add(sf(3, null, "Jenis Pembiayaan",
				sv(C, 0, 6, refTable).confReference(EHeaderMetadataShared.R001.getObject())
						.confConditionalRequired(ER2503PosRbPpu040301.genConditionalField1())));
		fs.add(sf(4, null, "Skema Pembiayaan",
				sv(C, 0, 6, refTable).confReference(EHeaderMetadataShared.R002.getObject())
						.confConditionalRequired(ER2503PosRbPpu040301.genConditionalField1())));
		fs.add(sf(5, null, "Kinerja Sept XX-1",
				sv(C, 0, 16, all).confConditionalRequired(ER2503PosRbPpu040301.genConditionalField2())));
		fs.add(sf(6, null, "Proyeksi - Desember XX-1",
				sv(C, 0, 16, all).confConditionalRequired(ER2503PosRbPpu040301.genConditionalField2())));
		fs.add(sf(7, null, "Proyeksi - Juni xx",
				sv(C, 0, 16, all).confConditionalRequired(ER2503PosRbPpu040301.genConditionalField2())));
		fs.add(sf(8, null, "Proyeksi - Desember XX-1",
				sv(C, 0, 16, all).confConditionalRequired(ER2503PosRbPpu040301.genConditionalField2())));
		return res;
	}
}
