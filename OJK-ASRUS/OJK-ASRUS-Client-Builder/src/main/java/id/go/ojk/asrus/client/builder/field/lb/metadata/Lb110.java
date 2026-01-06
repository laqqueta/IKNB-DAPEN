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
import id.go.ojk.asrus.client.builder.field.lb.reference.ER3016PosLbAsrus110;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb110 extends BaseMetadata {

	public Lb110(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_110;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 23, 23, ER3016PosLbAsrus110.genFieldSave(), null,
				ER3016PosLbAsrus110.getRequiredPos());
		res.addSegmentValidations(ER3016PosLbAsrus110.genValidationNumericNegativeA());
		res.addSegmentValidations(ER3016PosLbAsrus110.genValidationNumericNegativeB());
		res.addSegmentValidations(ER3016PosLbAsrus110.genValidationNumericDotNegative());
		res.addSegmentValidations(ER3016PosLbAsrus110.genValidationMaxLength8());
		res.addSegmentValidations(ER3016PosLbAsrus110.genValidationTingkatSolvabilitas());
		res.addSegmentValidations(ER3016PosLbAsrus110.genValidationDTMBRAtauMMBR());
		res.addSegmentValidations(ER3016PosLbAsrus110.genValidationMmbrAtasPaydiDigaransi());
		res.addSegmentValidations(ER3016PosLbAsrus110.genValidationRisikoPaydiDigaransi());
		res.addSegmentValidations(ER3016PosLbAsrus110
				.genValidationRasioTingkatSolvabilitasSebelumMemperhitungkanAsetYangTersediaUntukQardh());
		res.addSegmentValidations(ER3016PosLbAsrus110
				.genValidationAsetYangTersediaUntukQardhYangDiperhitungkanSebagaiPenambahAydDanaTabarruDanTanahud());
		res.addSegmentValidations(
				ER3016PosLbAsrus110.genValidationKekuranganKelebihanTingkatSolvabilitasDariTargetInternal());
		res.addSegmentValidations(
				ER3016PosLbAsrus110.genValidationRasioTingkatSolvabilitasDanaTabarruDanDanaTanahudA());
		res.addSegmentValidations(
				ER3016PosLbAsrus110.genValidationRasioTingkatSolvabilitasDanaTabarruDanDanaTanahudB());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3016_LB110.getObject())).confUnique(U));
		fs.add(sf(2, null, "Dana Tabarru'",
				sv(C, 1, 16, all).confConditionalRequired(ER3016PosLbAsrus110.genConditional2())));
		fs.add(sf(3, null, "Dana Perusahaan", sv(M, 1, 16, all))
				.addFieldValidations(ER3016PosLbAsrus110.genValidation3()));
		return res;
	}
}
