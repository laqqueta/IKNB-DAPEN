package id.go.ojk.pnmk.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.pnmk.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.pnmk.client.builder.field.lb.uus.reference.ER3105PosLbPnmu1300;

public class Lb1300 extends BaseMetadata {

	public Lb1300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_1300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 62, 62, ER3105PosLbPnmu1300.genFieldSave(), ER3105PosLbPnmu1300.genFieldSave(),
				ER3105PosLbPnmu1300.getRequiredPos());
//		res.addSegmentValidations(ER3105PosLbPnmu1300.genRowValidation02());
		res.addSegmentValidations(ER3105PosLbPnmu1300.genRowValidation03());
		res.addSegmentValidations(ER3105PosLbPnmu1300.genRowValidation12());
		res.addSegmentValidations(ER3105PosLbPnmu1300.genRowValidation22());
//		res.addSegmentValidations(ER3105PosLbPnmu1300.genRowValidation23());
		res.addSegmentValidations(ER3105PosLbPnmu1300.genRowValidation24());
		res.addSegmentValidations(ER3105PosLbPnmu1300.genRowValidation32());
		res.addSegmentValidations(ER3105PosLbPnmu1300.genRowValidation38());
//		res.addSegmentValidations(ER3105PosLbPnmu1300.genRowValidation39());
		res.addSegmentValidations(ER3105PosLbPnmu1300.genRowValidation40());
		res.addSegmentValidations(ER3105PosLbPnmu1300.genRowValidation51());
		res.addSegmentValidations(ER3105PosLbPnmu1300.genRowValidation60());
//		res.addSegmentValidations(ER3105PosLbPnmu1300.genRowValidation61());
		res.addSegmentValidations(ER3105PosLbPnmu1300.genRowValidation63());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R3105_LB1300.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Jumlah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3105PosLbPnmu1300.genConditional())));
//		fs.add(sf(2, null, "Jumlah", sv(C, 1, 16, numericNegatif)));
		return res;
	}
}
