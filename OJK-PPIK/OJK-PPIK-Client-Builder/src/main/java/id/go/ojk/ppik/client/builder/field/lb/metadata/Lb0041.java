package id.go.ojk.ppik.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.ppik.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.ppik.client.builder.field.lb.reference.ER3006PosLbPpik0041;

public class Lb0041 extends BaseMetadata {

	public Lb0041(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_0041;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 13, 13, ER3006PosLbPpik0041.genFieldSave(), ER3006PosLbPpik0041.genFieldSave(),
				ER3006PosLbPpik0041.getRequiredPos());
		res.addSegmentValidations(ER3006PosLbPpik0041.genRowValidation07());
		res.addSegmentValidations(ER3006PosLbPpik0041.genRowValidation13());
		res.addSegmentValidations(ER3006PosLbPpik0041.genRowValidation14());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R3006_LB0041.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Tenaga Kerja Tetap - Laki-Laki", sv(M, 1, 4, numeric)));
		fs.add(sf(3, null, "Tenaga Kerja Tetap - Perempuan", sv(M, 1, 4, numeric)));
		fs.add(sf(4, null, "Tenaga Kerja Tetap - Total", sv(M, 1, 4, numeric))
				.addFieldValidations(ER3006PosLbPpik0041.genFieldValidation4()));
		fs.add(sf(5, null, "Tenaga Kerja Kontrak - Laki-Laki", sv(M, 1, 4, numeric)));
		fs.add(sf(6, null, "Tenaga Kerja Kontrak - Perempuan", sv(M, 1, 4, numeric)));
		fs.add(sf(7, null, "Tenaga Kerja Kontrak - Total", sv(M, 1, 4, numeric))
				.addFieldValidations(ER3006PosLbPpik0041.genFieldValidation7()));
		fs.add(sf(8, null, "Tenaga Kerja Outsourcing - Laki-Laki", sv(M, 1, 4, numeric)));
		fs.add(sf(9, null, "Tenaga Kerja Outsourcing - Perempuan", sv(M, 1, 4, numeric)));
		fs.add(sf(10, null, "Tenaga Kerja Outsourcing - Total", sv(M, 1, 4, numeric))
				.addFieldValidations(ER3006PosLbPpik0041.genFieldValidation10()));
		fs.add(sf(11, null, "Total Keseluruhan", sv(M, 1, 4, numeric))
				.addFieldValidations(ER3006PosLbPpik0041.genFieldValidation11()));
		return res;
	}
}
