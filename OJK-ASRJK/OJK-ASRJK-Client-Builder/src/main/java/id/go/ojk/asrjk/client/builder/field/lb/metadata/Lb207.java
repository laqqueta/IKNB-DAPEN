package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3041PosLbAsrjk207;
import id.go.ojk.asrjk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb207 extends BaseMetadata {

	public Lb207(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_207;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3041PosLbAsrjk207.genFieldSave(), null,
				ER3041PosLbAsrjk207.getRequiredPos());
		res.addSegmentValidations(ER3041PosLbAsrjk207.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3041_LB207.getObject())));
		fs.add(sf(2, null, "Propinsi (DATI I)",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R005.getObject())
						.confConditionalRequired(ER3041PosLbAsrjk207.genConditionField2())));
		fs.add(sf(3, null, "Kota/Kabupaten (DATI II)",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R006.getObject())
						.confConditionalRequired(ER3041PosLbAsrjk207.genConditionField3()))
								.addFieldValidations(ER3041PosLbAsrjk207.genValidationDati2()));
		fs.add(sf(4, null, "Lini Usaha Kesehatan - Jumlah Premi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbAsrjk207.genConditionField())));
		fs.add(sf(5, null, "Lini Usaha Kesehatan - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbAsrjk207.genConditionField())));
		fs.add(sf(6, null, "Lini Usaha Kesehatan - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbAsrjk207.genConditionField())));
		fs.add(sf(7, null, "Selain Lini Usaha Kesehatan - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbAsrjk207.genConditionField())));
		fs.add(sf(8, null, "Selain Lini Usaha Kesehatan - Jumlah Premi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbAsrjk207.genConditionField())));
		fs.add(sf(9, null, "Selain Lini Usaha Kesehatan - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbAsrjk207.genConditionField())));
		fs.add(sf(10, null, "Selain Lini Usaha Kesehatan - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbAsrjk207.genConditionField())));
		fs.add(sf(11, null, "Selain Lini Usaha Kesehatan - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbAsrjk207.genConditionField())));
		fs.add(sf(12, null, "PAYDI - Jumlah Premi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbAsrjk207.genConditionField())));
		fs.add(sf(13, null, "PAYDI - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbAsrjk207.genConditionField())));
		fs.add(sf(14, null, "PAYDI - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbAsrjk207.genConditionField())));
		fs.add(sf(15, null, "PAYDI -  Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbAsrjk207.genConditionField())));
		fs.add(sf(16, null, "Total - Jumlah Premi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbAsrjk207.genConditionField()))
						.addFieldValidations(ER3041PosLbAsrjk207.genFieldValidation16()));
		fs.add(sf(17, null, "Total - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbAsrjk207.genConditionField()))
						.addFieldValidations(ER3041PosLbAsrjk207.genFieldValidation17()));
		fs.add(sf(18, null, "Total - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbAsrjk207.genConditionField()))
						.addFieldValidations(ER3041PosLbAsrjk207.genFieldValidation18()));
		fs.add(sf(19, null, "Total - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbAsrjk207.genConditionField()))
						.addFieldValidations(ER3041PosLbAsrjk207.genFieldValidation19()));
		return res;
	}
}
