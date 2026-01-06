package id.go.ojk.pnmk.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
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
import id.go.ojk.pnmk.client.builder.field.lb.uus.reference.ER3115PosLbPnmu2900;

public class Lb2900 extends BaseMetadata {

	public Lb2900(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2900;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 11, 11, ER3115PosLbPnmu2900.genFieldSave(), ER3115PosLbPnmu2900.genFieldSave());
		res.addSegmentValidations(ER3115PosLbPnmu2900.genValidationNumeric());
		res.addSegmentValidations(ER3115PosLbPnmu2900.genValidationNumericNegative());
		res.addSegmentValidations(ER3115PosLbPnmu2900.genRowValidation02());
		res.addSegmentValidations(ER3115PosLbPnmu2900.genRowValidation06());
		res.addSegmentValidations(ER3115PosLbPnmu2900.genRowValidation10());
		res.addSegmentValidations(ER3115PosLbPnmu2900.genRowValidation12());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R3115_LB2900.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Jumlah", sv(M, 1, 16, all)));
		return res;
	}
}
