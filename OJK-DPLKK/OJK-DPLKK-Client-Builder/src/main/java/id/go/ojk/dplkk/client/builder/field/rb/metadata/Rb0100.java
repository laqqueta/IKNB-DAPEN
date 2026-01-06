package id.go.ojk.dplkk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dplkk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dplkk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dplkk.client.builder.field.rb.reference.ER2000PosRbDplkk0100;

public class Rb0100 extends BaseMetadata {

	public Rb0100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 8, null, null, null,
				ER2000PosRbDplkk0100.getRequiredPos());
		res.addSegmentValidations(ER2000PosRbDplkk0100.genValidationKodePerusahaan());
		res.addSegmentValidations(ER2000PosRbDplkk0100.genValidationKodePerusahaanMaxLength());
		res.addSegmentValidations(ER2000PosRbDplkk0100.genValidationSkPengesahanMaxLength());
		res.addSegmentValidations(ER2000PosRbDplkk0100.genValidationFixedValue());
		res.addSegmentValidations(ER2000PosRbDplkk0100.genValidationNamaPerusahaanMaxLength());
		res.addSegmentValidations(ER2000PosRbDplkk0100.genValidationProgramMaxLength());
		res.addSegmentValidations(ER2000PosRbDplkk0100.genValidationPengurus());
		res.addSegmentValidations(ER2000PosRbDplkk0100.genValidationPengurusMaxLength());
		res.addSegmentValidations(ER2000PosRbDplkk0100.genValidationDewanPengawas());
		res.addSegmentValidations(ER2000PosRbDplkk0100.genValidationDewanPengawasMaxLength());
		res.addSegmentValidations(ER2000PosRbDplkk0100.genValidationTahunRencanaBisnisA());
		res.addSegmentValidations(ER2000PosRbDplkk0100.genValidationTahunRencanaBisnisB());
		res.addSegmentValidations(ER2000PosRbDplkk0100.genValidationTahunRencanaBisnisMaxLength());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2000_RB0100.getObject())));
		fs.add(sf(2, null, "Uraian", sv(M, 1, 500, all)));
		return res;
	}
}
