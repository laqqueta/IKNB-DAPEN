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
import id.go.ojk.dplkk.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.dplkk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dplkk.client.builder.field.rb.reference.ER2017PosReDplkk0100;

public class Re0100 extends BaseMetadata {

	public Re0100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 9, null, null, null,
				ER2017PosReDplkk0100.getRequiredPos());
		res.addSegmentValidations(ER2017PosReDplkk0100.genValidationNamaPerusahaanMaxLength());
		res.addSegmentValidations(ER2017PosReDplkk0100.genValidationKodePerusahaan());
		res.addSegmentValidations(ER2017PosReDplkk0100.genValidationKodePerusahaanMaxLength());
		res.addSegmentValidations(ER2017PosReDplkk0100.genValidationSkPengesahanMaxLength());
		res.addSegmentValidations(ER2017PosReDplkk0100.genValidationProgramA());
		res.addSegmentValidations(ER2017PosReDplkk0100.genValidationProgramB());
		res.addSegmentValidations(ER2017PosReDplkk0100.genValidationProgramMaxLength());
		res.addSegmentValidations(ER2017PosReDplkk0100.genValidationPengurus());
		res.addSegmentValidations(ER2017PosReDplkk0100.genValidationPengurusMaxLength());
		res.addSegmentValidations(ER2017PosReDplkk0100.genValidationDewanPengawas());
		res.addSegmentValidations(ER2017PosReDplkk0100.genValidationDewanPengawasMaxLength());
		res.addSegmentValidations(ER2017PosReDplkk0100.genValidationPeriodeRealisasiSemesterA());
		res.addSegmentValidations(ER2017PosReDplkk0100.genValidationPeriodeRealisasiSemesterB());
		res.addSegmentValidations(ER2017PosReDplkk0100.genValidationPeriodeRealisasiSemesterMaxLength());
		res.addSegmentValidations(ER2017PosReDplkk0100.genValidationTahunRencanaBisnisA());
		res.addSegmentValidations(ER2017PosReDplkk0100.genValidationTahunRencanaBisnisB());
		res.addSegmentValidations(ER2017PosReDplkk0100.genValidationTahunRencanaBisnisMaxLength());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2017_RE0100.getObject())));
		fs.add(sf(2, null, "Uraian", sv(M, 1, 500, all)));
		return res;
	}
}
