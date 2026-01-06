package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3059PosLbAsrjk616;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb616 extends BaseMetadata {

	public Lb616(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_616;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 25, 25, ER3059PosLbAsrjk616.genFieldSave(), null,
				ER3059PosLbAsrjk616.getRequiredPos());
		res.addSegmentValidations(ER3059PosLbAsrjk616.genValidationTotal1());
		res.addSegmentValidations(ER3059PosLbAsrjk616.genValidationTotal2());
		res.addSegmentValidations(ER3059PosLbAsrjk616.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3059_LB616.getObject())).confUnique(U));
		fs.add(sf(2, null, "Dalam Negeri - Premi Dibayar", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Dalam Negeri - Komisi Diterima", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Dalam Negeri - Claim Recovery", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Luar Negeri - ASEAN - Premi Dibayar", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Luar Negeri - ASEAN - Komisi Diterima", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Luar Negeri - ASEAN - Claim Recovery", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Luar Negeri - NON ASEAN - Premi Dibayar", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Luar Negeri - NON ASEAN - Komisi Diterima", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Luar Negeri - NON ASEAN - Claim Recovery", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
