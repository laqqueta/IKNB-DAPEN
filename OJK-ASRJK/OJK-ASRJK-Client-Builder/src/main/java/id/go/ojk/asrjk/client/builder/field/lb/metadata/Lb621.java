package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3068PosLbAsrjk621;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb621 extends BaseMetadata {

	public Lb621(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_621;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3068PosLbAsrjk621.genFieldSave(), null,
				ER3068PosLbAsrjk621.getRequiredPos());
		res.addSegmentValidations(ER3068PosLbAsrjk621.genValidationTotalA());
		res.addSegmentValidations(ER3068PosLbAsrjk621.genValidationTotalB());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3068_LB621.getObject())));
		fs.add(sf(2, null, "Kelompok",
				sv(C, 1, 6, numeric).confConditionalRequired(ER3068PosLbAsrjk621.genConditionField2())));
		fs.add(sf(3, null, "Tingkat Derajat Kepemilikan",
				sv(C, 1, 6, numeric).confConditionalRequired(ER3068PosLbAsrjk621.genConditionField3())));
		fs.add(sf(4, null, "Nama Pemegang Saham",
				sv(C, 1, 50, all).confConditionalRequired(ER3068PosLbAsrjk621.genConditionField4())));
		fs.add(sf(5, null, "Kewarganegaraan/ Negara Tempat Badan Hukum Terdaftar",
				sv(C, 1, 50, all).confConditionalRequired(ER3068PosLbAsrjk621.genConditionField5())));
		fs.add(sf(6, null, "Jenis Usaha",
				sv(C, 1, 50, all).confConditionalRequired(ER3068PosLbAsrjk621.genConditionField6())));
		fs.add(sf(7, null, "Nama Otoritas Pengawas",
				sv(C, 1, 50, all).confConditionalRequired(ER3068PosLbAsrjk621.genConditionField7())));
		fs.add(sf(8, null, "Anak Usaha Perasuransian",
				sv(C, 1, 50, all).confConditionalRequired(ER3068PosLbAsrjk621.genConditionField8())));
		fs.add(sf(9, null, "Rating Badan Hukum",
				sv(C, 1, 50, all).confConditionalRequired(ER3068PosLbAsrjk621.genConditionField9())));
		fs.add(sf(10, null, "Lembaga Pemeringkat",
				sv(C, 1, 50, all).confConditionalRequired(ER3068PosLbAsrjk621.genConditionField10())));
		fs.add(sf(11, null, "Ekuitas",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3068PosLbAsrjk621.genConditionField11())));
		fs.add(sf(12, null, "Jumlah Nominal Saham (Rp)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3068PosLbAsrjk621.genConditionField12())));
		fs.add(sf(13, null, "Persentase Kepemilikan (%)",
				sv(C, 1, 16, numericDot).confConditionalRequired(ER3068PosLbAsrjk621.genConditionField13())));
		return res;
	}
}
