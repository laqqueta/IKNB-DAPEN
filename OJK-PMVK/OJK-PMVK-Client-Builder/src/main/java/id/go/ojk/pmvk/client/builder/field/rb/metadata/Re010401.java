package id.go.ojk.pmvk.client.builder.field.rb.metadata;

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
import id.go.ojk.pmvk.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.pmvk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pmvk.client.builder.field.rb.reference.ER2250PosRePmvk010401;

public class Re010401 extends BaseMetadata {

	public Re010401(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_010401;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 25, 25, ER2250PosRePmvk010401.genFieldSave(), null, ER2250PosRePmvk010401.getRequiredPos());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationNumeric());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationNumericDot());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationTotalPembiayaanPenyertaanModalVentura());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationPenyaluranPembiayaanBersamaPorsiPihakKetiga());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationFormTotalAset());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationFormTotalPembiayaanPenyertaanModalVentura());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationFormPenerbitanSuratBerharga());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationFormEkuitas());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationFormLaba());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationFormPenyaluran());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationFormRasioNpifBruto());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationFormRasioNpifNeto());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationFormRoa());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationFormRoe());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationFormBopo());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationFormCurrentRatio());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationFormCashRatio());
		res.addSegmentValidations(ER2250PosRePmvk010401.genValidationFormNilaiDanaVenturaYangdikelola());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2250_RE010401.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi - Juni xx", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Realisasi - Juni xx", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, all)).addFieldValidations(ER2250PosRePmvk010401.genValidationSum()));
		return res;
	}
}
