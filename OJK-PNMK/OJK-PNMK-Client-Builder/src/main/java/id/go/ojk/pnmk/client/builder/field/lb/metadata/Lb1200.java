package id.go.ojk.pnmk.client.builder.field.lb.metadata;

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
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnmk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnmk.client.builder.field.lb.reference.ER3004PosLbPnmk1200;

public class Lb1200 extends BaseMetadata {

	public Lb1200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_1200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 35, 35, ER3004PosLbPnmk1200.genFieldSave(), ER3004PosLbPnmk1200.genFieldSave(),
				ER3004PosLbPnmk1200.getRequiredPos());
		res.addSegmentValidations(ER3004PosLbPnmk1200.genRowValidation02());
		res.addSegmentValidations(ER3004PosLbPnmk1200.genRowValidation07());
		res.addSegmentValidations(ER3004PosLbPnmk1200.genRowValidation10());
		res.addSegmentValidations(ER3004PosLbPnmk1200.genRowValidation15());
		res.addSegmentValidations(ER3004PosLbPnmk1200.genRowValidation24());
		res.addSegmentValidations(ER3004PosLbPnmk1200.genRowValidation25());
		res.addSegmentValidations(ER3004PosLbPnmk1200.genRowValidation28());
		res.addSegmentValidations(ER3004PosLbPnmk1200.genRowValidation29());
		res.addSegmentValidations(ER3004PosLbPnmk1200.genRowValidation31());
		res.addSegmentValidations(ER3004PosLbPnmk1200.genRowValidation34());
		res.addSegmentValidations(ER3004PosLbPnmk1200.genRowValidation36());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R3004_LB1200.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Indonesian Rupiah", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
