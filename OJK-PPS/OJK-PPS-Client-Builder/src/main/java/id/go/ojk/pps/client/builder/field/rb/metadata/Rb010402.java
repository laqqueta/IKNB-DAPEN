package id.go.ojk.pps.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pps.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.pps.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pps.client.builder.field.rb.reference.ER2000PosRbPps010402;

public class Rb010402 extends BaseMetadata {

	public Rb010402(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_010402;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 22, 22, ER2000PosRbPps010402.genFieldSave(), null, ER2000PosRbPps010402.getRequiredPos());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationNumeric());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationNumericDot());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationTotalPiutangPembiayaan());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationPenyaluranPembiayaanBersamaPorsiPihakKetiga());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationFormBopo());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationFormCashRatio());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationFormCurrentRatio());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationFormEkuitas());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationFormLaba());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationFormNim());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationFormPenerbitanSuratBerharga());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationFormPenyaluran());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationFormPiutang());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationFormRasioNpfBruto());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationFormRasioNpfNeto());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationFormRasioPermodalan());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationFormRoa());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationFormRoe());
		res.addSegmentValidations(ER2000PosRbPps010402.genValidationFormTotalAset());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2000_RB010402.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Proyeksi - Juni", sv(M, 1, 16, all)));
		fs.add(sf(5, null, "Proyeksi - Desember", sv(M, 1, 16, all)));
		return res;
	}
}
