package id.go.ojk.asrus.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrus.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrus.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrus.client.builder.field.lb.reference.ER3017PosLbAsrus111;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb111 extends BaseMetadata {

	public Lb111(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_111;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 24, 24, ER3017PosLbAsrus111.genFieldSave(), null,
				ER3017PosLbAsrus111.getRequiredPos());
		res.addSegmentValidations(ER3017PosLbAsrus111.genValidationNumericNegativeA());
		res.addSegmentValidations(ER3017PosLbAsrus111.genValidationNumericNegativeB());
		res.addSegmentValidations(ER3017PosLbAsrus111.genValidationNumericDotNegativeA());
		res.addSegmentValidations(ER3017PosLbAsrus111.genValidationNumericDotNegativeB());
		res.addSegmentValidations(ER3017PosLbAsrus111.genValidationMaxLength8());
		res.addSegmentValidations(ER3017PosLbAsrus111.genValidationRasioLikuiditas());
		res.addSegmentValidations(ER3017PosLbAsrus111.genValidationRasioPerimbanganInvestasiDenganliabilitas());
		res.addSegmentValidations(ER3017PosLbAsrus111.genValidationRasioPendapatanInvestasiNeto());
		res.addSegmentValidations(ER3017PosLbAsrus111.genValidationRasioBebanKlaim());
		res.addSegmentValidations(ER3017PosLbAsrus111.genValidationPerubahanDana());
		res.addSegmentValidations(ER3017PosLbAsrus111.genValidationRasioPerubahanDana());
		res.addSegmentValidations(ER3017PosLbAsrus111.genValidationRasioAsetUnitSyariah());
		res.addSegmentValidations(ER3017PosLbAsrus111.genValidationPenghitunganQardhYangDiperlukanDanaTabarru());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3017_LB111.getObject())).confUnique(U));
		fs.add(sf(2, null, "Dana Tabarru'", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Dana Perusahaan",
				sv(C, 1, 16, all).confConditionalRequired(ER3017PosLbAsrus111.genConditional3())));
		fs.add(sf(4, null, "Dana Investasi Peserta",
				sv(C, 1, 16, all).confConditionalRequired(ER3017PosLbAsrus111.genConditional4())));
		fs.add(sf(5, null, "Gabungan", sv(M, 1, 16, all))
				.addFieldValidations(ER3017PosLbAsrus111.genFieldValidation5()));
		return res;
	}
}
