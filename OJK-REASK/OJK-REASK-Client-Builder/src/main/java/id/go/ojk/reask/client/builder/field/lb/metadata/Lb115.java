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
import id.go.ojk.reask.client.builder.field.lb.reference.ER3040PosLbReask115;

public class Lb115 extends BaseMetadata {

	public Lb115(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_115;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 51, 51, ER3040PosLbReask115.genFieldSave(), null, ER3040PosLbReask115.getRequiredPos());
		res.addSegmentValidations(ER3040PosLbReask115.genValidationInvestasi());
		res.addSegmentValidations(ER3040PosLbReask115.genValidationBukanInvestasi());
		res.addSegmentValidations(ER3040PosLbReask115.genValidationAsetLancar());
		res.addSegmentValidations(ER3040PosLbReask115.genValidationCadanganTeknis());
		res.addSegmentValidations(ER3040PosLbReask115.genValidationUtang());
		res.addSegmentValidations(ER3040PosLbReask115.genValidationLiabilitasLancar());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3040_LB115.getObject())).confUnique(U));
		fs.add(sf(2, null, "Per  Triwulan Berjalan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Per  Triwulan Sama Tahun Sebelumnya", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
