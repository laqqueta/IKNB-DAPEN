package id.go.ojk.reask.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reask.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reask.client.builder.field.lb.reference.ER3011PosLbReask502;
import id.go.ojk.reask.client.builder.field.reference.EHeaderMetadataShared;

public class Lb502 extends BaseMetadata {

	public Lb502(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_502;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER3011PosLbReask502.genFieldSave(), null, ER3011PosLbReask502.getRequiredPos());
		res.addSegmentValidations(ER3011PosLbReask502.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3011_LB502.getObject())));
		fs.add(sf(2, null, "Nama Reasuradur",
				sv(C, 1, 100, all).confConditionalRequired(ER3011PosLbReask502.genConditionalMustEmpty2())));
		fs.add(sf(3, null, "Dalam Negeri/Luar Negeri",
				sv(C, 1, 20, refTable).confReference(EHeaderMetadataShared.R007.getObject())
						.confConditionalRequired(ER3011PosLbReask502.genConditionalMustEmpty348())));
		fs.add(sf(4, null, "Peringkat", sv(C, 1, 20, refTable).confReference(EHeaderMetadataShared.R008.getObject())
				.confConditionalRequired(ER3011PosLbReask502.genConditionalMustEmpty348())));
		fs.add(sf(5, null, "Cadangan Teknis Beban Reasuradur", sv(C, 1, 16, numericNegatif)
				.confConditionalRequired(ER3011PosLbReask502.genConditionalMustEmpty5679())));
		fs.add(sf(6, null, "Deposit dan/atau Premi yang Ditahan di Perusahaan Ceding", sv(C, 1, 16, numericNegatif)
				.confConditionalRequired(ER3011PosLbReask502.genConditionalMustEmpty5679())));
		fs.add(sf(7, null, "Eksposur Reasuransi Neto",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3011PosLbReask502.genConditionalMustEmpty5679()))
				.addFieldValidations(ER3011PosLbReask502.genFieldValidation7()));
		fs.add(sf(8, null, "Faktor",
				sv(C, 1, 6, numericDot).confConditionalRequired(ER3011PosLbReask502.genConditionalMustEmpty348()))
				.addFieldValidations(ER3011PosLbReask502.genFieldValidation8()));
		fs.add(sf(9, null, "Jumlah Deviasi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3011PosLbReask502.genConditionalMustEmpty5679()))
				.addFieldValidations(ER3011PosLbReask502.genFieldValidation9()));
		return res;
	}
}
