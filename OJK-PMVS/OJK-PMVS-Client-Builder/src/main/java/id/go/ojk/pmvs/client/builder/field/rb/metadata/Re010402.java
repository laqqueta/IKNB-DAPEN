package id.go.ojk.pmvs.client.builder.field.rb.metadata;

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
import id.go.ojk.pmvs.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.pmvs.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pmvs.client.builder.field.rb.reference.ER2250PosRePmvs010402;

public class Re010402 extends BaseMetadata {

	public Re010402(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_010402;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 24, 24, ER2250PosRePmvs010402.genFieldSave(), null, ER2250PosRePmvs010402.getRequiredPos());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationNumeric());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationNumericDot());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationTotalPembiayaanPenyertaanModalVentura());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationPenyaluranPembiayaanBersamaPorsiPihakKetiga());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationFormTotalAset());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationFormTotalPembiayaanPenyertaanModalVentura());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationFormPenerbitanSuratBerharga());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationFormEkuitas());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationFormLaba());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationFormPembiayaanPenerusan());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationFormRasioNpifBruto());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationFormRasioNpifNeto());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationFormRoa());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationFormRoe());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationFormBopo());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationFormCurrentRatio());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationFormCashRatio());
		res.addSegmentValidations(ER2250PosRePmvs010402.genValidationFormNilaiDanaVenturaYangdikelola());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2250_RE010402.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi - Juni xx", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Realisasi - Juni xx", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, all)).addFieldValidations(ER2250PosRePmvs010402.genValidationSum()));
		return res;
	}
}
