package id.go.ojk.ppk.client.builder.field.rb.uus.metadata;

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
import id.go.ojk.ppk.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.ER2750PosRePpu010402;

public class Re010402 extends BaseMetadata {

	public Re010402(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_010402;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 22, 22, ER2750PosRePpu010402.genFieldSave(), null, ER2750PosRePpu010402.getRequiredPos());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationNumeric());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationNumericDot());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationTotalPiutangPembiayaan());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationPenyaluranPembiayaanBersamaPorsiPihakKetiga());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationFormTotalAset());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationFormPiutang());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationFormPenerbitanSuratBerharga());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationFormEkuitas());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationFormLaba());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationFormPenyaluran());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationFormRasioPermodalan());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationFormRasioNpfBruto());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationFormRasioNpfNeto());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationFormRoa());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationFormRoe());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationFormBopo());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationFormNim());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationFormCurrentRatio());
		res.addSegmentValidations(ER2750PosRePpu010402.genValidationFormCashRatio());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2750_RE010402.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, all)).addFieldValidations(ER2750PosRePpu010402.genValidationSum()));
		return res;
	}
}
