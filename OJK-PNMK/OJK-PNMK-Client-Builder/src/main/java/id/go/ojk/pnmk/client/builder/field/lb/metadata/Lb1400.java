package id.go.ojk.pnmk.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
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
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnmk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnmk.client.builder.field.lb.reference.ER3006PosLbPnmk1400;

public class Lb1400 extends BaseMetadata {

	public Lb1400(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_1400;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 5, 5, ER3006PosLbPnmk1400.genFieldSave(), null, ER3006PosLbPnmk1400.getRequiredPos());
		res.addSegmentValidations(ER3006PosLbPnmk1400.genRowValidation6());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R3006_LB1400.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Aset", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Liabilitas", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Rasio Aset Terhadap Liabilitas %", sv(M, 1, 9, numericDot))
				.addFieldValidations(ER3006PosLbPnmk1400.genFieldValidation4()));
		fs.add(sf(5, null, "Rasio Aset Lancar Terhadap Aset Tidak Lancar (%)",
				sv(C, 1, 9, numericDot).confConditionalRequired(ER3006PosLbPnmk1400.genConditional())));
		fs.add(sf(6, null, "Rasio Liabilitas Lancar Terhadap Liabilitas Tidak Lancar (%)",
				sv(C, 1, 9, numericDot).confConditionalRequired(ER3006PosLbPnmk1400.genConditional())));
		fs.add(sf(7, null, "Rasio Aset Lancar Terhadap Liabilitas Lancar (%)",
				sv(C, 1, 9, numericDot).confConditionalRequired(ER3006PosLbPnmk1400.genConditional())));
		return res;
	}
}
