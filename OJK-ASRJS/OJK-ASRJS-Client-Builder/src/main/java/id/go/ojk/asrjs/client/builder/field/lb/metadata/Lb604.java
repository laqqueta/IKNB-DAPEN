package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3043PosLbAsrjs604;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb604 extends BaseMetadata {

	public Lb604(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_604;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 47, 47, ER3043PosLbAsrjs604.genFieldSave(), null,
				ER3043PosLbAsrjs604.getRequiredPos());
		res.addSegmentValidations(ER3043PosLbAsrjs604.genValidationKontribusiTunggalSubTotal1());
		res.addSegmentValidations(ER3043PosLbAsrjs604.genValidationKontribusiRegulerSubTotal1());
		res.addSegmentValidations(ER3043PosLbAsrjs604.genValidationKontribusiTunggalSubTotal2());
		res.addSegmentValidations(ER3043PosLbAsrjs604.genValidationKontribusiRegulerSubTotal2());
		res.addSegmentValidations(ER3043PosLbAsrjs604.genValidationKontribusiTunggalSubTotal());
		res.addSegmentValidations(ER3043PosLbAsrjs604.genValidationKontribusiRegulerSubTotal());
		res.addSegmentValidations(ER3043PosLbAsrjs604.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3043_LB604.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kontribusi Pertanggungan Baru", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Kontribusi Lanjutan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbAsrjs604.genConditional3())));
		fs.add(sf(4, null, "Kontribusi Murni", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Ujroh Pertanggungan Baru", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Ujroh Lanjutan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Biaya Akuisisi Lainnya", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Biaya Pemeliharaan Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Biaya Lainnya", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Total Biaya", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(11, null, "Total Kontribusi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3043PosLbAsrjs604.genFieldValidation11()));
		return res;
	}
}
