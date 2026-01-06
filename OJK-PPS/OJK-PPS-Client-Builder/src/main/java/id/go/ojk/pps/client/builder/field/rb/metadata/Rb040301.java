package id.go.ojk.pps.client.builder.field.rb.metadata;

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
import id.go.ojk.pps.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.pps.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pps.client.builder.field.rb.reference.ER2003PosRbPps040301;
import id.go.ojk.pps.client.builder.field.reference.EHeaderMetadataShared;

public class Rb040301 extends BaseMetadata {

	public Rb040301(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_040301;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 3, null, ER2003PosRbPps040301.genFieldSave(), null, ER2003PosRbPps040301.getRequiredPos());
		res.addSegmentValidations(ER2003PosRbPps040301.genValidationNumeric());
		res.addSegmentValidations(ER2003PosRbPps040301.genValidationNumericDot());
		res.addSegmentValidations(ER2003PosRbPps040301.genValidationTotalPenyaluranPembiayaankepadaPihakTerkait());
		res.addSegmentValidations(ER2003PosRbPps040301.genValidationRasioEqual());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2003_RB040301.getObject())));
		fs.add(sf(2, null, "Nama Debitur Pihak Terkait",
				sv(C, 0, 255, all).confConditionalRequired(ER2003PosRbPps040301.genConditionalFieldMustEmpty())));
		fs.add(sf(3, null, "Jenis Pembiayaan",
				sv(C, 0, 6, refTable).confReference(EHeaderMetadataShared.R001.getObject())
						.confConditionalRequired(ER2003PosRbPps040301.genConditionalField1())));
		fs.add(sf(4, null, "Skema Pembiayaan",
				sv(C, 0, 6, refTable).confReference(EHeaderMetadataShared.R002.getObject())
						.confConditionalRequired(ER2003PosRbPps040301.genConditionalField1())));
		fs.add(sf(5, null, "Kinerja Sept XX-1",
				sv(C, 0, 16, all).confConditionalRequired(ER2003PosRbPps040301.genConditionalField2())));
		fs.add(sf(6, null, "Proyeksi - Desember XX-1",
				sv(C, 0, 16, all).confConditionalRequired(ER2003PosRbPps040301.genConditionalField2())));
		fs.add(sf(7, null, "Proyeksi - Juni xx",
				sv(C, 0, 16, all).confConditionalRequired(ER2003PosRbPps040301.genConditionalField2())));
		fs.add(sf(8, null, "Proyeksi - Desember XX-1",
				sv(C, 0, 16, all).confConditionalRequired(ER2003PosRbPps040301.genConditionalField2())));
		return res;
	}
}
