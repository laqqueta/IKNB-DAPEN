package id.go.ojk.reask.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
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
import id.go.ojk.reask.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reask.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reask.client.builder.field.lb.reference.ER3006PosLbReask200;

public class Lb200 extends BaseMetadata {

	public Lb200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 38, 38, ER3006PosLbReask200.genFieldSave(), ER3006PosLbReask200.genFieldSave(),
				ER3006PosLbReask200.getRequiredPos());
		res.addSegmentValidations(ER3006PosLbReask200.genValidationPendapatanPremi());
		res.addSegmentValidations(ER3006PosLbReask200.genValidationPremiBruto());
		res.addSegmentValidations(ER3006PosLbReask200.genValidationPremiReasuransi());
		res.addSegmentValidations(ER3006PosLbReask200.genValidationPremiNetto());
		res.addSegmentValidations(ER3006PosLbReask200.genValidationCadanganPremi());
		res.addSegmentValidations(ER3006PosLbReask200.genValidationPendapatanPremiNetto());
		res.addSegmentValidations(ER3006PosLbReask200.genValidationPendapatanUnderwriting());
		res.addSegmentValidations(ER3006PosLbReask200.genValidationBebanKlaimNetto());
		res.addSegmentValidations(ER3006PosLbReask200.genValidationBebanUnderwriting());
		res.addSegmentValidations(ER3006PosLbReask200.genValidationUnderwriting());
		res.addSegmentValidations(ER3006PosLbReask200.genValidationBebanUsaha());
		res.addSegmentValidations(ER3006PosLbReask200.genValidationLabaUsahaAsuransi());
		res.addSegmentValidations(ER3006PosLbReask200.genValidationLabaSebelumPajak());
		res.addSegmentValidations(ER3006PosLbReask200.genValidationLabaSetelahPajak());
		res.addSegmentValidations(ER3006PosLbReask200.genValidationLabaKomprehensif());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3006_LB200.getObject())).confUnique(U));
		fs.add(sf(2, null, "Tradisional",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3006PosLbReask200.genConditionalExistPos2())));
		fs.add(sf(3, null, "PAYDI",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3006PosLbReask200.genConditionalExistPos3())));
		fs.add(sf(4, null, "Jurnal Eliminasi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3006PosLbReask200.genConditionalExistPos4())));
		fs.add(sf(5, null, "Gabungan", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3006PosLbReask200.genValidationSum5()));
		return res;
	}
}
