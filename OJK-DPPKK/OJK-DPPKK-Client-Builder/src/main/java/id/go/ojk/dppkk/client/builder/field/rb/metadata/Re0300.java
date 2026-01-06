package id.go.ojk.dppkk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.dppkk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dppkk.client.builder.field.rb.reference.ER2019PosReDppkk0300;

public class Re0300 extends BaseMetadata {

	public Re0300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 25, 25, ER2019PosReDppkk0300.genFieldSave(), ER2019PosReDppkk0300.genFieldSave(),
				ER2019PosReDppkk0300.getRequiredPos());
		res.addSegmentValidations(ER2019PosReDppkk0300.genValidationPendapatanInvestasi());
		res.addSegmentValidations(ER2019PosReDppkk0300.genValidationIuranJatuhTempo());
		res.addSegmentValidations(ER2019PosReDppkk0300.genValidationPenambahan());
		res.addSegmentValidations(ER2019PosReDppkk0300.genValidationPengurangan());
		res.addSegmentValidations(ER2019PosReDppkk0300.genValidationKenaikanAsetNeto());
		res.addSegmentValidations(ER2019PosReDppkk0300.genValidationAsetNetoAkhirPeriode());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2019_RE0300.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(4, null, "Pencapaian (%)", sv(M, 1, 10, numericDotNegatif))
				.addFieldValidations(ER2019PosReDppkk0300.genValidation4()));
		fs.add(sf(5, null, "Deviasi (nominal)", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER2019PosReDppkk0300.genValidation5()));
		return res;
	}
}
