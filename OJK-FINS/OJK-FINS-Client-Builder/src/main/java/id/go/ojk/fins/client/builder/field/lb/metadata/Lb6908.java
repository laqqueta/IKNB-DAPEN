package id.go.ojk.fins.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_2;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.fins.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.fins.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.fins.client.builder.field.lb.reference.ER3013PosLbFins6908;

public class Lb6908 extends BaseMetadata {

	public Lb6908(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_6908;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 243, 243, ER3013PosLbFins6908.genFieldSave(), ER3013PosLbFins6908.genFieldSave(),
				ER3013PosLbFins6908.getRequiredPos());
		res.addSegmentValidations(ER3013PosLbFins6908.genValidationDecimal());
		res.addSegmentValidations(ER3013PosLbFins6908.genValidationNumeric());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation001());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation008());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation041());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation049());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation056());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation089());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation097());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation104());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation137());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation145());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation152());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation185());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation193());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation200());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation233());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation234());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation241());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation242());
		res.addSegmentValidations(ER3013PosLbFins6908.genRowValidation243());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R3013_LB6908.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Sandi Wilayah (DATI 1)", sv(C, 1, 6, all).confRegex(PATTERN_REFERENCE_2)
				.confConditionalRequired(ER3013PosLbFins6908.genConditional2())).addFieldValidations(ER3013PosLbFins6908.genFieldValidation2()));
		fs.add(sf(3, null,
				"Jumlah Unique Borrower yang masih memiliki pinjaman Outstanding hingga akhir Bulan Posisi Tanggal Laporan",
				sv(C, 1, 10, numericNegatif).confConditionalRequired(ER3013PosLbFins6908.genConditional3())));
		fs.add(sf(4, null, "Nilai Nominal Pinjaman Outstanding hingga akhir bulan Posisi Tanggal Laporan",
				sv(M, 1, 16, all)));
		return res;
	}
}
