package id.go.ojk.ppis.client.builder.field.lb.metadata;

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
import id.go.ojk.ppis.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.ppis.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.ppis.client.builder.field.lb.reference.ER3012PosLbPpis1300;

public class Lb1300 extends BaseMetadata {

	public Lb1300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_1300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 76, 76, ER3012PosLbPpis1300.genFieldSave(), ER3012PosLbPpis1300.genFieldSave(),
				ER3012PosLbPpis1300.getRequiredPos());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation02());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation03());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation04());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation12());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation19());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation24());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation25());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation33());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation40());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation48());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation49());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation57());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation63());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation64());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation68());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation75());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation77A());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation77B());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation77C());
		res.addSegmentValidations(ER3012PosLbPpis1300.genRowValidation77D());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataLb.R3012_LB1300.getObject())
						.confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Indonesian Rupiah", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Mata Uang Asing", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Total", sv(M, 1, 16, numericNegatif)).addFieldValidations(ER3012PosLbPpis1300.genFieldValidation4()));
		return res;
	}
}
