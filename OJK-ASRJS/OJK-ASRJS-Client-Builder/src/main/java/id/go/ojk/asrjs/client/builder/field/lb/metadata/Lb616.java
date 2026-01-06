package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3050PosLbAsrjs616;
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
				new ArrayList<>(), extension, 25, 25, ER3050PosLbAsrjs616.genFieldSave(), null,
				ER3050PosLbAsrjs616.getRequiredPos());
		res.addSegmentValidations(ER3050PosLbAsrjs616.genValidationPertanggunganPerorangan());
		res.addSegmentValidations(ER3050PosLbAsrjs616.genValidationPertanggunganKumpulan());
		res.addSegmentValidations(ER3050PosLbAsrjs616.genValidationJumlah());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3050_LB616.getObject())).confUnique(U));
		fs.add(sf(2, null, "Dalam Negeri - Kontribusi Dibayar", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Dalam Negeri - Ujroh Diterima", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Dalam Negeri - Claim Recovery", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "ASEAN - Kontribusi Dibayar", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "ASEAN -Ujroh Diterima", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "ASEAN -Claim Recovery", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "NON ASEAN -Kontribusi Dibayar", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "NON ASEAN -Ujroh Diterima", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "NON ASEAN -Claim Recovery", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
