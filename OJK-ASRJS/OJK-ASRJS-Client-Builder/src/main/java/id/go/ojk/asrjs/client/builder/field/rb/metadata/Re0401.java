package id.go.ojk.asrjs.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.asrjs.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrjs.client.builder.field.rb.reference.ER2046PosReAsrjs0401;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Re0401 extends BaseMetadata {

	public Re0401(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0401;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 25, 25, ER2046PosReAsrjs0401.genFieldSave(), null,
				ER2046PosReAsrjs0401.getRequiredPos());
		res.addSegmentValidations(ER2046PosReAsrjs0401.genValidationNumeric());
		res.addSegmentValidations(ER2046PosReAsrjs0401.genValidationNumericDot());
		res.addSegmentValidations(ER2046PosReAsrjs0401.genValidationTingkatSolvabilitas());
		res.addSegmentValidations(ER2046PosReAsrjs0401
				.genValidationRasioTingkatSolvabilitasSebelumMemperhitungkanAsetYangTersediaUntukQardh());
		res.addSegmentValidations(ER2046PosReAsrjs0401
				.genValidationAsetYgTersediaUntukQardhYgDiperhitungkanSebagaiPenambahAYDDanaTabarruDanTanahud());
		res.addSegmentValidations(ER2046PosReAsrjs0401.genValidationKekuranganTingkatSolvabilitasDariTargetInternal());
		res.addSegmentValidations(ER2046PosReAsrjs0401.genValidationRasioTingkatSolvabilitasDanaPerusahaan());
		res.addSegmentValidations(ER2046PosReAsrjs0401.genValidationRasioLikuiditas());
		res.addSegmentValidations(ER2046PosReAsrjs0401.genValidationRasioPendapatanInvestasiNeto());
		res.addSegmentValidations(ER2046PosReAsrjs0401.genValidationPerubahanDanaPerusahaan());
		res.addSegmentValidations(ER2046PosReAsrjs0401.genValidationRasioPerubahanDana());
		res.addSegmentValidations(ER2046PosReAsrjs0401.genValidationRasioAsetUnitSyariah());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2046_RE0401.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, all))
				.addFieldValidations(ER2046PosReAsrjs0401.genValidationField4()));
		return res;
	}
}
