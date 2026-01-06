package id.go.ojk.reask.client.builder.field.rb.uus.metadata;

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
import id.go.ojk.reask.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.reask.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.reask.client.builder.field.rb.uus.reference.ER2135PosReReasu0402;

public class Re0402 extends BaseMetadata {

	public Re0402(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_0402;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 34, 34, ER2135PosReReasu0402.genFieldSave(), null, ER2135PosReReasu0402.getRequiredPos());
		res.addSegmentValidations(ER2135PosReReasu0402.genValidationNumeric());
		res.addSegmentValidations(ER2135PosReReasu0402.genValidationNumericDot());
		res.addSegmentValidations(ER2135PosReReasu0402.genValidationTingkatSolvabilitas());
		res.addSegmentValidations(ER2135PosReReasu0402
				.genValidationRasioTingkatSolvabilitasSebelumMemperhitungkanAsetYangTersediaUntukQardh());
		res.addSegmentValidations(ER2135PosReReasu0402.genValidationRasioLikuiditas());
		res.addSegmentValidations(ER2135PosReReasu0402.genValidationRasioPerimbanganInvestasiDenganLiabilitas());
		res.addSegmentValidations(ER2135PosReReasu0402.genValidationRasioPendapatanInvestasiNeto());
		res.addSegmentValidations(ER2135PosReReasu0402.genValidationRasioBebanKlaim());
		res.addSegmentValidations(ER2135PosReReasu0402.genValidationPerubahanDanaPerusahaan());
		res.addSegmentValidations(ER2135PosReReasu0402.genValidationRasioPerubahanDana());
		res.addSegmentValidations(ER2135PosReReasu0402.genValidationQardhYangDiperlukanDanaTabarru());
		res.addSegmentValidations(ER2135PosReReasu0402.genValidationQardhYangDiperlukanDanaTanahud());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2135_RE0402.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, all))
				.addFieldValidations(ER2135PosReReasu0402.genValidationField4()));
		return res;
	}
}
