package id.go.ojk.asruk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3050PosLbAsruk601;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb601 extends BaseMetadata {

	public Lb601(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_601;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 39, 39, ER3050PosLbAsruk601.genFieldSave(), null,
				ER3050PosLbAsruk601.getRequiredPos());
		res.addSegmentValidations(ER3050PosLbAsruk601.genValidationNumericNegatif());
		res.addSegmentValidations(ER3050PosLbAsruk601.genValidationNumericDotNegatif());
		res.addSegmentValidations(ER3050PosLbAsruk601.genValidationRasioLikuiditas());
		res.addSegmentValidations(ER3050PosLbAsruk601.genValidationRasioKecukupanInvestasi());
		res.addSegmentValidations(
				ER3050PosLbAsruk601.genValidationRasioPerimbanganHasilInvestasiDenganPendapatanPremiNeto());
		res.addSegmentValidations(ER3050PosLbAsruk601.genValidationRasioI());
		res.addSegmentValidations(ER3050PosLbAsruk601.genValidationRasioII());
		res.addSegmentValidations(ER3050PosLbAsruk601.genValidationRasioIII());
		res.addSegmentValidations(ER3050PosLbAsruk601.genValidationTotalRasio123());
		res.addSegmentValidations(ER3050PosLbAsruk601.genValidationPertumbuhanInvestasi());
		res.addSegmentValidations(ER3050PosLbAsruk601.genValidationPertumbuhanEkuitas());
		res.addSegmentValidations(ER3050PosLbAsruk601.genValidationPertumbuhanRKI());
		res.addSegmentValidations(ER3050PosLbAsruk601.genValidationPertumbuhanRBC());
		res.addSegmentValidations(ER3050PosLbAsruk601.genValidationPertumbuhanAset());
		res.addSegmentValidations(ER3050PosLbAsruk601.genValidationPertumbuhanPremi());
		res.addSegmentValidations(ER3050PosLbAsruk601.genValidationPertumbuhanKlaim());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3050_LB601.getObject())).confUnique(U));
		fs.add(sf(2, null, "Jumlah", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Penjelasan",
				sv(C, 1, 100, all).confConditionalRequired(ER3050PosLbAsruk601.genConditionalField3())));
		return res;
	}
}
