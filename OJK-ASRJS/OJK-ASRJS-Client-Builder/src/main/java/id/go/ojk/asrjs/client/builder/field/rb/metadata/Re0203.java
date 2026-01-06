package id.go.ojk.asrjs.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.asrjs.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrjs.client.builder.field.rb.reference.ER2042PosReAsrjs0203;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Re0203 extends BaseMetadata {

	public Re0203(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0203;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 16, 16, ER2042PosReAsrjs0203.genFieldSave(), null,
				ER2042PosReAsrjs0203.getRequiredPos());
		res.addSegmentValidations(ER2042PosReAsrjs0203.genValidationHasilInvestasi());
		res.addSegmentValidations(ER2042PosReAsrjs0203.genValidationHasilInvestasiDanKontribusiAlokasiInvestasi());
		res.addSegmentValidations(ER2042PosReAsrjs0203.genValidationBebanKlaim());
		res.addSegmentValidations(ER2042PosReAsrjs0203.genValidationLabaUsahaAsuransi());
		res.addSegmentValidations(ER2042PosReAsrjs0203.genValidationLabaSebelumPajak());
		res.addSegmentValidations(ER2042PosReAsrjs0203.genValidationLabaSetelahPajak());
		res.addSegmentValidations(ER2042PosReAsrjs0203.genValidationKinerjaSeluruhDana());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2042_RE0203.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi-Rupiah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2042PosReAsrjs0203.genValidationField4()));
		fs.add(sf(5, null, "Deviasi-%", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER2042PosReAsrjs0203.genValidationField5()));
		return res;
	}
}
