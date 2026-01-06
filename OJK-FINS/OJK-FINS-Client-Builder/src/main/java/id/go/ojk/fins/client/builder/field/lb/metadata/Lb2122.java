package id.go.ojk.fins.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_ALL_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
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
import id.go.ojk.fins.client.builder.field.lb.reference.ER3030PosLbFins2122;

public class Lb2122 extends BaseMetadata {

	public Lb2122(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2122;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER3030PosLbFins2122.genFieldSave(), null, ER3030PosLbFins2122.getRequiredPos());
		res.addSegmentValidations(ER3030PosLbFins2122.genRowValidation2());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R3030_LB2122.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama Produk Asuransi/Penjaminan", sv(C, 1, 1000, all).confRegex(PATTERN_ALL_1)
				.confConditionalRequired(ER3030PosLbFins2122.genConditional())));
		fs.add(sf(3, null, "Nama Pihak Penyedia Jasa Asuransi/Penjaminan", sv(C, 1, 1000, all).confRegex(PATTERN_ALL_1)
				.confConditionalRequired(ER3030PosLbFins2122.genConditional())));
		fs.add(sf(4, null, "Jumlah Transaksi Pendanaan yang disalurkan pada bulan tersebut",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Jumlah Nominal Transaksi Pendanaan yang disalurkan pada bulan tersebut",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Jumlah Transaksi Pendanaan yang outstanding", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Jumlah Nominal Transaksi Pendanaan yang outstanding", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Jumlah premi yang dibayarkan pada bulan berjalan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Jumlah polis yang sudah diklaim pada bulan berjalan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Keterangan", sv(C, 1, 1000, all).confRegex(PATTERN_ALL_1)
				.confConditionalRequired(ER3030PosLbFins2122.genConditional())));
		return res;
	}
}
