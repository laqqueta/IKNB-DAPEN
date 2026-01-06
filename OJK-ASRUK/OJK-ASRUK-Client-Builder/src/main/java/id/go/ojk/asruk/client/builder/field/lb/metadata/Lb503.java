package id.go.ojk.asruk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3012PosLbAsruk503;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb503 extends BaseMetadata {

	public Lb503(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_503;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 57, 57, ER3012PosLbAsruk503.genFieldSave(), null,
				ER3012PosLbAsruk503.getRequiredPos());
		res.addSegmentValidations(ER3012PosLbAsruk503.genValidationNumericNegatif());
		res.addSegmentValidations(ER3012PosLbAsruk503.genValidationNumericDot());
		res.addSegmentValidations(ER3012PosLbAsruk503.genValidationNumericDotLength());
		res.addSegmentValidations(ER3012PosLbAsruk503.genValidationInvestasi());
		res.addSegmentValidations(ER3012PosLbAsruk503.genValidationBukanInvestasi());
		res.addSegmentValidations(ER3012PosLbAsruk503.genValidationAset());
		res.addSegmentValidations(ER3012PosLbAsruk503.genValidationUtang());
		res.addSegmentValidations(ER3012PosLbAsruk503.genValidationCadanganTeknis());
		res.addSegmentValidations(ER3012PosLbAsruk503.genValidationLiabilitas());
		res.addSegmentValidations(ER3012PosLbAsruk503.genValidationLiabilitasDanAset());
		res.addSegmentValidations(ER3012PosLbAsruk503.genValidationDeviasi());
		res.addSegmentValidations(ER3012PosLbAsruk503.genValidationDeviasiPaydi());
		res.addSegmentValidations(ER3012PosLbAsruk503.genValidationTotalDeviasiUntukRisikoLikuiditas());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3012_LB503.getObject())).confUnique(U));
		fs.add(sf(2, null, "Sampai dengan 1 tahun", sv(C, 1, 16, numericNegatif)
				.confConditionalRequired(ER3012PosLbAsruk503.genConditionalMustEmpty23456())));
		fs.add(sf(3, null, "Lebih dari 1 tahun sampai dengan 3 tahun", sv(C, 1, 16, numericNegatif)
				.confConditionalRequired(ER3012PosLbAsruk503.genConditionalMustEmpty23456())));
		fs.add(sf(4, null, "Lebih dari 3 tahun sampai dengan 5 tahun", sv(C, 1, 16, numericNegatif)
				.confConditionalRequired(ER3012PosLbAsruk503.genConditionalMustEmpty23456())));
		fs.add(sf(5, null, "Lebih dari 5 tahun sampai dengan 10 tahun", sv(C, 1, 16, numericNegatif)
				.confConditionalRequired(ER3012PosLbAsruk503.genConditionalMustEmpty23456())));
		fs.add(sf(6, null, "Lebih dari 10 tahun", sv(C, 1, 16, numericNegatif)
				.confConditionalRequired(ER3012PosLbAsruk503.genConditionalMustEmpty23456())));
		fs.add(sf(7, null, "Jumlah",
				sv(C, 1, 16, all).confConditionalRequired(ER3012PosLbAsruk503.genConditionalMustEmpty7()))
						.addFieldValidations(ER3012PosLbAsruk503.genFieldValidationSum7()));
		return res;
	}
}
