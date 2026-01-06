package id.go.ojk.dppkk.client.builder.field.rb.metadata;

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
import id.go.ojk.dppkk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dppkk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dppkk.client.builder.field.rb.reference.ER2008PosRbDppkk0900;

public class Rb0900 extends BaseMetadata {

	public Rb0900(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0900;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 25, 25, ER2008PosRbDppkk0900.genFieldSave(), ER2008PosRbDppkk0900.genFieldSave(),
				ER2008PosRbDppkk0900.getRequiredPos());
		res.addSegmentValidations(ER2008PosRbDppkk0900.genValidationPendapatanInvestasi());
		res.addSegmentValidations(ER2008PosRbDppkk0900.genValidationIuranJatuhTempo());
		res.addSegmentValidations(ER2008PosRbDppkk0900.genValidationPenambahan());
		res.addSegmentValidations(ER2008PosRbDppkk0900.genValidationPengurangan());
		res.addSegmentValidations(ER2008PosRbDppkk0900.genValidationKenaikanAsetNeto());
		res.addSegmentValidations(ER2008PosRbDppkk0900.genValidationAsetNetoAkhirPeriode());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2008_RB0900.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual per 30 Sept XX-1", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi per 31 Desember XX-1", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi per 30 Juni XX", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi per 31 Desember XX", sv(M, 1, 20, numericNegatif)));
		return res;
	}
}
