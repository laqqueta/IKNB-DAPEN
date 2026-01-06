package id.go.ojk.ppik.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.ppik.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.ppik.client.builder.field.lb.uus.reference.ER3106PosLbPpiu0043;

public class Lb0043 extends BaseMetadata {

	public Lb0043(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_0043;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 12, 12, ER3106PosLbPpiu0043.genFieldSave(), ER3106PosLbPpiu0043.genFieldSave(),
				ER3106PosLbPpiu0043.getRequiredPos());
		res.addSegmentValidations(ER3106PosLbPpiu0043.genRowValidation12());
		res.addSegmentValidations(ER3106PosLbPpiu0043.genRowValidation13());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLbUus.R3107_LB0043.getObject())
						.confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Tenaga Kerja Tetap - Tenaga Manajerial sampai satu level di bawah Direksi",
				sv(M, 1, 4, numeric)));
		fs.add(sf(3, null, "Tenaga Kerja Tetap - Staf dan Tingkat Tenaga Kerja Lainnya", sv(M, 1, 4, numeric)));
		fs.add(sf(4, null, "Tenaga Kerja Kontrak - Tenaga Manajerial sampai satu level di bawah Direksi",
				sv(M, 1, 4, numeric)));
		fs.add(sf(5, null, "Tenaga Kerja Kontrak - Staf dan Tingkat Tenaga Kerja Lainnya", sv(M, 1, 4, numeric)));
		fs.add(sf(6, null, "Tenaga Kerja Outsourcing - Tenaga Manajerial sampai satu level di bawah Direksi",
				sv(M, 1, 4, numeric)));
		fs.add(sf(7, null, "Tenaga Kerja Outsourcing - Staf dan Tingkat Tenaga Kerja Lainnya", sv(M, 1, 4, numeric)));
		fs.add(sf(8, null, "Total Tenaga Kerja - Tenaga Manajerial sampai satu level di bawah Direksi",
				sv(M, 1, 4, numeric)).addFieldValidations(ER3106PosLbPpiu0043.genFieldValidation8()));
		fs.add(sf(9, null, "Total Tenaga Kerja - Staf dan Tingkat Tenaga Kerja Lainnya", sv(M, 1, 4, numeric))
				.addFieldValidations(ER3106PosLbPpiu0043.genFieldValidation9()));
		fs.add(sf(10, null, "Total Tenaga Kerja Keseluruhan", sv(M, 1, 4, numeric))
				.addFieldValidations(ER3106PosLbPpiu0043.genFieldValidation10()));
		fs.add(sf(11, null, "Keterangan Rangkap Jabatan",
				sv(C, 1, 500, all).confConditionalRequired(ER3106PosLbPpiu0043.genFieldCondition11())));
		return res;
	}
}
