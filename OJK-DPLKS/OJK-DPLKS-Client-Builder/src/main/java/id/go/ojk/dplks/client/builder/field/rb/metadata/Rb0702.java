package id.go.ojk.dplks.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dplks.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dplks.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dplks.client.builder.field.rb.reference.ER2007PosRbDplks0702;

public class Rb0702 extends BaseMetadata {

	public Rb0702(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0702;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 21, 21, ER2007PosRbDplks0702.genFieldSave(), null, ER2007PosRbDplks0702.getRequiredPos());
		res.addSegmentValidations(ER2007PosRbDplks0702.genValidationInvestasi());
		res.addSegmentValidations(ER2007PosRbDplks0702.genValidationRatioInvestasi3());
		res.addSegmentValidations(ER2007PosRbDplks0702.genValidationRatioInvestasi5());
		res.addSegmentValidations(ER2007PosRbDplks0702.genValidationRatioInvestasi7());
		res.addSegmentValidations(ER2007PosRbDplks0702.genValidationRatioInvestasi9());
		res.addSegmentValidations(ER2007PosRbDplks0702.genValidationRatioInvestasi());
		res.addSegmentValidations(ER2007PosRbDplks0702.genValidationFixedValue());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2007_RB0702.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual per 30 Sep 20XX-1 Nominal", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(3, null, "Aktual per 30 Sep 20XX-1 Persentase", sv(M, 1, 10, numericDotNegatif)));
		fs.add(sf(4, null, "Proyeksi per 31 Des 20XX-1 Nominal", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi per 31 Des 20XX-1 Persentase", sv(M, 1, 10, numericDotNegatif)));
		fs.add(sf(6, null, "Proyeksi per 30 Jun 20XX Nominal", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(7, null, "Proyeksi per 30 Jun 20XX Persentase", sv(M, 1, 10, numericDotNegatif)));
		fs.add(sf(8, null, "Proyeksi per 31 Des 20XX Nominal", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(9, null, "Proyeksi per 31 Des 20XX Persentase", sv(M, 1, 10, numericDotNegatif)));
		return res;
	}
}
