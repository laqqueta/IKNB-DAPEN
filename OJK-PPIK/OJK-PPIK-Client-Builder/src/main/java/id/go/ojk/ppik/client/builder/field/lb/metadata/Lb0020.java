package id.go.ojk.ppik.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.ppik.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.ppik.client.builder.field.lb.reference.ER3002PosLbPpik0020;
import id.go.ojk.ppik.client.builder.field.reference.EHeaderMetadataShared;

public class Lb0020 extends BaseMetadata {

	public Lb0020(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_0020;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		res.setSavePosForm(ER3002PosLbPpik0020.genFieldSave());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R3002_LB0020.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nomor Pencatatan Pelaporan Kantor Cabang", sv(O, 1, 35, all)));
		fs.add(sf(3, null, "Tanggal Pencatatan Pelaporan Kantor Cabang",
				sv(C, 8, 8, date).confConditionalRequired(ER3002PosLbPpik0020.genFieldCondition())));
		fs.add(sf(4, null, "Nama Kantor Cabang",
				sv(C, 1, 100, all).confConditionalRequired(ER3002PosLbPpik0020.genFieldCondition())));
		fs.add(sf(5, null, "Alamat",
				sv(C, 1, 200, all).confConditionalRequired(ER3002PosLbPpik0020.genFieldCondition())));
		fs.add(sf(6, null, "Kecamatan",
				sv(C, 1, 100, all).confConditionalRequired(ER3002PosLbPpik0020.genFieldCondition())));
		fs.add(sf(7, null, "Kabupaten/Kota",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R033.getObject())
						.confConditionalRequired(ER3002PosLbPpik0020.genFieldCondition())
						.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(8, null, "Kode Pos",
				sv(C, 1, 5, numeric).confConditionalRequired(ER3002PosLbPpik0020.genFieldCondition())));
		fs.add(sf(9, null, "Nomor Telepon",
				sv(C, 1, 20, numeric).confConditionalRequired(ER3002PosLbPpik0020.genFieldCondition())));
		fs.add(sf(10, null, "Jumlah Tenaga Kerja Kantor Cabang",
				sv(C, 1, 5, numeric).confConditionalRequired(ER3002PosLbPpik0020.genFieldCondition())));
		fs.add(sf(11, null, "Nama Kepala Cabang",
				sv(C, 1, 100, all).confConditionalRequired(ER3002PosLbPpik0020.genFieldCondition())));
		return res;
	}
}
