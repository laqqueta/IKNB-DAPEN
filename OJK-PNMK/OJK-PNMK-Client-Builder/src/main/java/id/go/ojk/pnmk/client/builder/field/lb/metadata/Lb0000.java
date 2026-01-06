package id.go.ojk.pnmk.client.builder.field.lb.metadata;

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
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnmk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnmk.client.builder.field.lb.reference.ER3000PosLbPnmk0000;

public class Lb0000 extends BaseMetadata {

	public Lb0000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_0000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 29, 29, null, null, ER3000PosLbPnmk0000.getRequiredPos());
		res.addSegmentValidations(ER3000PosLbPnmk0000.genRowValidation05());
		res.addSegmentValidations(ER3000PosLbPnmk0000.genRowValidation12());
		res.addSegmentValidations(ER3000PosLbPnmk0000.genRowValidation13());
		res.addSegmentValidations(ER3000PosLbPnmk0000.genRowValidation14());
		res.addSegmentValidations(ER3000PosLbPnmk0000.genRowValidation15());
		res.addSegmentValidations(ER3000PosLbPnmk0000.genValidationDate());
		res.addSegmentValidations(ER3000PosLbPnmk0000.genValidationNpwp());
		res.addSegmentValidations(ER3000PosLbPnmk0000.genValidationNumeric());
		res.addSegmentValidations(ER3000PosLbPnmk0000.genValidationPhone());
		res.addSegmentValidations(ER3000PosLbPnmk0000.genValidationLen100());
		res.addSegmentValidations(ER3000PosLbPnmk0000.genValidationLen15());
		res.addSegmentValidations(ER3000PosLbPnmk0000.genValidationLen2());
		res.addSegmentValidations(ER3000PosLbPnmk0000.genValidationLen20());
		res.addSegmentValidations(ER3000PosLbPnmk0000.genValidationLen6());
		res.addSegmentValidations(ER3000PosLbPnmk0000.genValidationLen4());
		res.addSegmentValidations(ER3000PosLbPnmk0000.genValidationLen50());
		res.addSegmentValidations(ER3000PosLbPnmk0000.genValidationLen8());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R3000_LB0000.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Analisis", sv(M, 1, 200, all)));
		return res;
	}
}
