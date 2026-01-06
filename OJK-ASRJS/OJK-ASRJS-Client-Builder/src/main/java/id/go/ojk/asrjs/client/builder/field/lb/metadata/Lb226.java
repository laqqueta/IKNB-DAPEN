package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumericSpace;
import static id.go.ojk.lib.client.model.config.DataType.alfaSpace;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3034PosLbAsrjs226;
import id.go.ojk.asrjs.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb226 extends BaseMetadata {

	public Lb226(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_226;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3034_LB226.getObject())));
		fs.add(sf(2, null, "Nama Aset", sv(O, 1, 100, alfaSpace)));
		fs.add(sf(3, null, "Dasar Penilaian",
				sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R021.getObject())
						.confConditionalRequired(ER3034PosLbAsrjs226.genConditional())));
		fs.add(sf(4, null, "Jenis Dana", sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R006.getObject())
				.confConditionalRequired(ER3034PosLbAsrjs226.genConditional())));
		fs.add(sf(5, null, "Saldo",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3034PosLbAsrjs226.genConditional())));
		fs.add(sf(6, null, "Keterangan",
				sv(C, 1, 100, alfaNumericSpace).confConditionalRequired(ER3034PosLbAsrjs226.genConditional())));
		return res;
	}
}
