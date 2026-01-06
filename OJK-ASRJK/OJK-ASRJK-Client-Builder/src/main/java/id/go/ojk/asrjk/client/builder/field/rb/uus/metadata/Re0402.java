package id.go.ojk.asrjk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.asrjk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.asrjk.client.builder.field.rb.uus.reference.ER2147PosReAsrju0402;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Re0402 extends BaseMetadata {

	public Re0402(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_0402;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 34, 34, ER2147PosReAsrju0402.genFieldSave(), null,
				ER2147PosReAsrju0402.getRequiredPos());
		res.addSegmentValidations(ER2147PosReAsrju0402.genValidationNumeric());
		res.addSegmentValidations(ER2147PosReAsrju0402.genValidationNumericDot());
		res.addSegmentValidations(ER2147PosReAsrju0402.genValidationTingkatSolvabilitas());
		res.addSegmentValidations(ER2147PosReAsrju0402
				.genValidationRasioTingkatSolvabilitasSebelumMemperhitungkanAsetYangTersediaUntukQardh());
		res.addSegmentValidations(ER2147PosReAsrju0402
				.genValidationAsetYgTersediaUntukQardhYgDiperhitungkanSebagaiPenambahAYDDanaTabarruDanTanahud());
		res.addSegmentValidations(ER2147PosReAsrju0402.genValidationKekuranganTingkatSolvabilitasDariTargetInternal());
		res.addSegmentValidations(ER2147PosReAsrju0402.genValidationRasioTingkatSolvabilitasDanaPerusahaan());
		res.addSegmentValidations(ER2147PosReAsrju0402.genValidationRasioLikuiditas());
		res.addSegmentValidations(ER2147PosReAsrju0402.genValidationRasioPerimbanganInvestasiDenganLiabilitas());
		res.addSegmentValidations(ER2147PosReAsrju0402.genValidationRasioPendapatanInvestasiNeto());
		res.addSegmentValidations(ER2147PosReAsrju0402.genValidationRasioBebanKlaim());
		res.addSegmentValidations(ER2147PosReAsrju0402.genValidationPerubahanDanaPerusahaan());
		res.addSegmentValidations(ER2147PosReAsrju0402.genValidationRasioPerubahanDana());
		res.addSegmentValidations(ER2147PosReAsrju0402.genValidationQardhYangDiperlukanDanaTabarru());
		res.addSegmentValidations(ER2147PosReAsrju0402.genValidationQardhYangDiperlukanDanaTanahud());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2147_RE0402.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, all))
				.addFieldValidations(ER2147PosReAsrju0402.genValidationField4()));
		return res;
	}
}
