package id.go.ojk.asrjk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.asrjk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrjk.client.builder.field.rb.reference.ER2014PosRbAsrjk1302;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb1302 extends BaseMetadata {

	public Rb1302(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1302;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 60, 60, ER2014PosRbAsrjk1302.genFieldSave(), null,
				ER2014PosRbAsrjk1302.getRequiredPos());
		res.addSegmentValidations(ER2014PosRbAsrjk1302.genValidationInvestasi());
		res.addSegmentValidations(ER2014PosRbAsrjk1302.genValidationBukanInvestasi());
		res.addSegmentValidations(ER2014PosRbAsrjk1302.genValidationAset());
		res.addSegmentValidations(ER2014PosRbAsrjk1302.genValidationHutang());
		res.addSegmentValidations(ER2014PosRbAsrjk1302.genValidationCadanganTeknis());
		res.addSegmentValidations(ER2014PosRbAsrjk1302.genValidationLiabilitas());
		res.addSegmentValidations(ER2014PosRbAsrjk1302.genValidationEkuitas());
		res.addSegmentValidations(ER2014PosRbAsrjk1302.genValidationLiabilitasEkuitas());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2014_RB1302.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual per 30 Sept 20XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi per 31 Des 20xx - 1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi per 30 Jun 20xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi per 31 Des 20xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
