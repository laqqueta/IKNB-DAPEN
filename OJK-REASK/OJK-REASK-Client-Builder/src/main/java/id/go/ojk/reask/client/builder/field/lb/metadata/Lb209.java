package id.go.ojk.reask.client.builder.field.lb.metadata;

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
import id.go.ojk.reask.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reask.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reask.client.builder.field.lb.reference.ER3042PosLbReask209;

public class Lb209 extends BaseMetadata {

	public Lb209(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_209;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 12, 12, ER3042PosLbReask209.genFieldSave(), null, ER3042PosLbReask209.getRequiredPos());
		res.addSegmentValidations(ER3042PosLbReask209.genValidationJumlahPremiProduksiBaruPerorangan());
		res.addSegmentValidations(ER3042PosLbReask209.genValidationJumlahPremiProduksiBaru());
		res.addSegmentValidations(ER3042PosLbReask209.genValidationJumlahPremiLanjutan());
		res.addSegmentValidations(ER3042PosLbReask209.genValidationJumlahPremiTopUp());
		res.addSegmentValidations(ER3042PosLbReask209.genValidationJumlahPendapatanPremi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3042_LB209.getObject())).confUnique(U));
		fs.add(sf(2, null, "Premi Risiko*", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Premi PAYDI Digaransi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Premi PAYDI Tidak Digaransi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Jumlah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3042PosLbReask209.genFieldValidation5()));
		return res;
	}
}
