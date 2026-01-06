package id.go.ojk.asrus.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrus.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrus.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrus.client.builder.field.lb.reference.ER3036PosLbAsrus228;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb228 extends BaseMetadata {

	public Lb228(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_228;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 34, 34, ER3036PosLbAsrus228.genFieldSave(), null,
				ER3036PosLbAsrus228.getRequiredPos());
		res.addSegmentValidations(ER3036PosLbAsrus228.genValidationPenyisihanUjrohKontribusiA());
		res.addSegmentValidations(ER3036PosLbAsrus228.genValidationPenyisihanUjrohKontribusiB());
		res.addSegmentValidations(ER3036PosLbAsrus228.genValidationPKYBMPA());
		res.addSegmentValidations(ER3036PosLbAsrus228.genValidationPKYBMPB());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3036_LB228.getObject())).confUnique(U));
		fs.add(sf(2, null, "Dana Perusahaan - Penyisihan Ujroh", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Dana Perusahaan - Penyisihan Ujroh atas PAYDI",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3036PosLbAsrus228.genConditional3())));
		fs.add(sf(4, null, "Dana Perusahaan - Jumlah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3036PosLbAsrus228.genValidation4A())
				.addFieldValidations(ER3036PosLbAsrus228.genValidation4B()));
		fs.add(sf(5, null, "Dana Tabarru' - Penyisihan Risiko", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Dana Tabarru' - Penyisihan Risiko atas PAYDI",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3036PosLbAsrus228.genConditional6())));
		fs.add(sf(7, null, "Dana Tabarru' - Jumlah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3036PosLbAsrus228.genValidation7A())
				.addFieldValidations(ER3036PosLbAsrus228.genValidation7B()));
		fs.add(sf(8, null, "Gabungan - Penyisihan Risiko", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3036PosLbAsrus228.genValidation8()));
		fs.add(sf(9, null, "Gabungan - Penyisihan Risiko atas PAYDI",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3036PosLbAsrus228.genConditional9()))
						.addFieldValidations(ER3036PosLbAsrus228.genValidation9()));
		fs.add(sf(10, null, "Gabungan - Jumlah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3036PosLbAsrus228.genValidation10A())
				.addFieldValidations(ER3036PosLbAsrus228.genValidation10B()));
		return res;
	}
}
