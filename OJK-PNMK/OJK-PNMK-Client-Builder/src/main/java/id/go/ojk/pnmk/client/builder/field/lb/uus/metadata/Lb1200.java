package id.go.ojk.pnmk.client.builder.field.lb.uus.metadata;

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
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.pnmk.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.pnmk.client.builder.field.lb.uus.reference.ER3104PosLbPnmu1200;

public class Lb1200 extends BaseMetadata {

	public Lb1200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_1200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 49, 49, ER3104PosLbPnmu1200.genFieldSave(), ER3104PosLbPnmu1200.genFieldSave(),
				ER3104PosLbPnmu1200.getRequiredPos());
		res.addSegmentValidations(ER3104PosLbPnmu1200.genRowValidation02());
		res.addSegmentValidations(ER3104PosLbPnmu1200.genRowValidation08());
		res.addSegmentValidations(ER3104PosLbPnmu1200.genRowValidation17());
		res.addSegmentValidations(ER3104PosLbPnmu1200.genRowValidation24());
		res.addSegmentValidations(ER3104PosLbPnmu1200.genRowValidation31());
		res.addSegmentValidations(ER3104PosLbPnmu1200.genRowValidation38());
		res.addSegmentValidations(ER3104PosLbPnmu1200.genRowValidation39());
		res.addSegmentValidations(ER3104PosLbPnmu1200.genRowValidation42());
		res.addSegmentValidations(ER3104PosLbPnmu1200.genRowValidation43());
		res.addSegmentValidations(ER3104PosLbPnmu1200.genRowValidation45());
		res.addSegmentValidations(ER3104PosLbPnmu1200.genRowValidation48());
		res.addSegmentValidations(ER3104PosLbPnmu1200.genRowValidation50());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R3104_LB1200.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Indonesian Rupiah", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
