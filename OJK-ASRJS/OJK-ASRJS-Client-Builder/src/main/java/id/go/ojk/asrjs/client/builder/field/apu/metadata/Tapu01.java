package id.go.ojk.asrjs.client.builder.field.apu.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormApuPenilaian;
import id.go.ojk.asrjs.client.builder.field.apu.reference.EHeaderMetadataPenilaian;
import id.go.ojk.asrjs.client.builder.field.apu.reference.ER5000PosApuAsrjs01;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Tapu01 extends BaseMetadata {

	public Tapu01(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormApuPenilaian eEnum = EFormApuPenilaian.APU_01;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 61, 61, null, null, ER5000PosApuAsrjs01.getRequiredPos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataPenilaian.R000.getObject())).confUnique(U));
		fs.add(sf(2, null, "Total Pendapatan Premi 4 Produk (dalam jutaan rupiah)", sv(M, 1, 16, numeric)));
		return res;
	}
}
