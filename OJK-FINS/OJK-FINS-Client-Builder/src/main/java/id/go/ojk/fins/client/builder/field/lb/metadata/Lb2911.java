package id.go.ojk.fins.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternLJKName;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.fins.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.fins.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.fins.client.builder.field.lb.reference.ER3031PosLbFins2911;

public class Lb2911 extends BaseMetadata {

	public Lb2911(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2911;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER3031PosLbFins2911.genFieldSave(), null, ER3031PosLbFins2911.getRequiredPos());
		res.addSegmentValidations(ER3031PosLbFins2911.genRowValidation2());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R3031_LB2911.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama Pihak Ketiga", sv(C, 1, 100, all).confRegex(patternLJKName)
				.confConditionalRequired(ER3031PosLbFins2911.genConditional())));
		fs.add(sf(3, null, "Tanggal Pengalihan",
				sv(C, 1, 8, date).confConditionalRequired(ER3031PosLbFins2911.genConditional())));
		fs.add(sf(4, null, "Jumlah Borrower yang Dialihkan (Satuan Akun)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Jumlah Borrower yang Menerima Pendanaan (satuan Akun)", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
