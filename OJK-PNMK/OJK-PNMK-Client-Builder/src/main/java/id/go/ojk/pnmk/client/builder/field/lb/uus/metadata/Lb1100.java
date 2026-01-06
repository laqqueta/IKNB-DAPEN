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
import id.go.ojk.pnmk.client.builder.field.lb.uus.reference.ER3103PosLbPnmu1100;

public class Lb1100 extends BaseMetadata {

	public Lb1100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_1100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 61, 61, ER3103PosLbPnmu1100.genFieldSave(), null, ER3103PosLbPnmu1100.getRequiredPos());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genValidationNumeric());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation02A());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation02B());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation03A());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation03B());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation04());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation05());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation07());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation15A());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation15B());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation17());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation21());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation27A());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation27B());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation34A());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation34B());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation39());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation47());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation48());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation50());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation53());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation55());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation56());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation61());
		res.addSegmentValidations(ER3103PosLbPnmu1100.genRowValidation62());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R3103_LB1100.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Jumlah", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
