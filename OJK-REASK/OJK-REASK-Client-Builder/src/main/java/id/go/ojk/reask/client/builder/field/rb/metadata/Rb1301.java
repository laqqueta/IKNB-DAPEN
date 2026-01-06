package id.go.ojk.reask.client.builder.field.rb.metadata;

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
import id.go.ojk.reask.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.reask.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.reask.client.builder.field.rb.reference.ER2014PosRbReask1301;

public class Rb1301 extends BaseMetadata {

	public Rb1301(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1301;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 60, 60, ER2014PosRbReask1301.genFieldSave(), null, ER2014PosRbReask1301.getRequiredPos());
		res.addSegmentValidations(ER2014PosRbReask1301.genValidasiInvestasi());
		res.addSegmentValidations(ER2014PosRbReask1301.genValidasiBukanInvestasi());
		res.addSegmentValidations(ER2014PosRbReask1301.genValidasiAset());
		res.addSegmentValidations(ER2014PosRbReask1301.genValidasiHutang());
		res.addSegmentValidations(ER2014PosRbReask1301.genValidasiCadanganTeknis());
		res.addSegmentValidations(ER2014PosRbReask1301.genValidasiLiabilitas());
		res.addSegmentValidations(ER2014PosRbReask1301.genValidasiEkuitas());
		res.addSegmentValidations(ER2014PosRbReask1301.genValidasiLiabilitasEkuitas());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2014_RB1301.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual per 30 Sept 20XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi per 31 Des 20xx - 1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi per 30 Jun 20xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi per 31 Des 20xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
