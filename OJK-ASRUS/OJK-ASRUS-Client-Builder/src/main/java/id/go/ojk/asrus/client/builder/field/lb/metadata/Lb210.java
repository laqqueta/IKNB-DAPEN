package id.go.ojk.asrus.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrus.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrus.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrus.client.builder.field.lb.reference.ER3018PosLbAsrus210;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb210 extends BaseMetadata {

	public Lb210(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_210;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 3, 3, ER3018PosLbAsrus210.genFieldSave(), null,
				ER3018PosLbAsrus210.getRequiredPos());
		res.addSegmentValidations(ER3018PosLbAsrus210.genValidationTotalRisikoKredit());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3018_LB210.getObject())).confUnique(U));
		fs.add(sf(2, null, "Dana Tabarru", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Dana Perusahaan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "PAYDI (digaransi)", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
