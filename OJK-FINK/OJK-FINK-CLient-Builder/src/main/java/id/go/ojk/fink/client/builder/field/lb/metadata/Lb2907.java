package id.go.ojk.fink.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.fink.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.fink.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.fink.client.builder.field.lb.reference.ER3012PosLbFink2907;

public class Lb2907 extends BaseMetadata {

	public Lb2907(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2907;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 33, 33, ER3012PosLbFink2907.genFieldSave(), null, ER3012PosLbFink2907.getRequiredPos());
		res.addSegmentValidations(ER3012PosLbFink2907.genRowValidation01());
		res.addSegmentValidations(ER3012PosLbFink2907.genRowValidation02());
		res.addSegmentValidations(ER3012PosLbFink2907.genRowValidation04());
		res.addSegmentValidations(ER3012PosLbFink2907.genRowValidation08());
		res.addSegmentValidations(ER3012PosLbFink2907.genRowValidation17());
		res.addSegmentValidations(ER3012PosLbFink2907.genRowValidation20());
		res.addSegmentValidations(ER3012PosLbFink2907.genRowValidation27A());
		res.addSegmentValidations(ER3012PosLbFink2907.genRowValidation27B());
		res.addSegmentValidations(ER3012PosLbFink2907.genRowValidation27C());
		res.addSegmentValidations(ER3012PosLbFink2907.genRowValidation28());
		res.addSegmentValidations(ER3012PosLbFink2907.genRowValidation31());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R3012_LB2907.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Detail Outstanding Perusahaan X Jumlah Unique Account", sv(M, 1, 10, numericNegatif)));
		fs.add(sf(3, null, "Detail Outstanding Perusahaan X Jumlah Nominal", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
