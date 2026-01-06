package id.go.ojk.fink.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.fink.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.fink.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.fink.client.builder.field.lb.reference.ER3011PosLbFink6903;

public class Lb6903 extends BaseMetadata {

	public Lb6903(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_6903;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 70, 70, ER3011PosLbFink6903.genFieldSave(), ER3011PosLbFink6903.genFieldSave(),
				ER3011PosLbFink6903.getRequiredPos());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation01());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation02());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation03());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation04());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation05());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation06A());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation06B());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation10());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation11A());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation11B());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation13());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation14A());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation14B());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation15A());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation117A());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation17B());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation45());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation46A());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation46B());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation47());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation55());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation63());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation66());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation67A());
		res.addSegmentValidations(ER3011PosLbFink6903.genRowValidation67B());
		res.addSegmentValidations(ER3011PosLbFink6903.genValidationLen1());
		res.addSegmentValidations(ER3011PosLbFink6903.genValidationPeriod());
		res.addSegmentValidations(ER3011PosLbFink6903.genValidationDecimalA());
		res.addSegmentValidations(ER3011PosLbFink6903.genValidationDecimalB());
		res.addSegmentValidations(ER3011PosLbFink6903.genValidationNumericA());
		res.addSegmentValidations(ER3011PosLbFink6903.genValidationNumericB());
		res.addSegmentValidations(ER3011PosLbFink6903.genValidationReferenceAvailable());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R3011_LB6903.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Sejak Perusahaan didirikan sampai dengan Akhir Posisi Bulan Laporan",
				sv(C, 1, 50, all).confConditionalRequired(ER3011PosLbFink6903.genConditional2()))
				.addFieldValidations(ER3011PosLbFink6903.genFieldValidation()));
		fs.add(sf(3, null, "Posisi Bulan Laporan", sv(C, 1, 50, all).confConditionalRequired(ER3011PosLbFink6903.genConditional3()))
				.addFieldValidations(ER3011PosLbFink6903.genFieldValidation()));
		return res;
	}
}
