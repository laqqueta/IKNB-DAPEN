package id.go.ojk.asrjs.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.asrjs.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrjs.client.builder.field.rb.reference.ER2025PosRbAsrjs1202;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb1202 extends BaseMetadata {

	public Rb1202(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1202;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 45, 45, ER2025PosRbAsrjs1202.genFieldSave(), null,
				ER2025PosRbAsrjs1202.getRequiredPos());
		res.addSegmentValidations(ER2025PosRbAsrjs1202.genValidationAsetA());
		res.addSegmentValidations(ER2025PosRbAsrjs1202.genValidationInvestasi());
		res.addSegmentValidations(ER2025PosRbAsrjs1202.genValidationBukanInvestasi());
		res.addSegmentValidations(ER2025PosRbAsrjs1202.genValidationLiabilitasDanEkuitas());
		res.addSegmentValidations(ER2025PosRbAsrjs1202.genValidationLiabilitas());
		res.addSegmentValidations(ER2025PosRbAsrjs1202.genValidationPenyisihanTeknis());
		res.addSegmentValidations(ER2025PosRbAsrjs1202.genValidationEkuitasDana());
		res.addSegmentValidations(ER2025PosRbAsrjs1202.genValidationAsetB());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2025_RB1202.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual per 30 Sept 20XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi per 31 Des 20xx - 1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi per 30 Jun 20xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi per 31 Des 20xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
