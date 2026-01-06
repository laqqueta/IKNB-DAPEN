package id.go.ojk.reass.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reass.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reass.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reass.client.builder.field.lb.reference.ER3044PosLbReass236;
import id.go.ojk.reass.client.builder.field.reference.EHeaderMetadataShared;

public class Lb236 extends BaseMetadata {

	public Lb236(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_236;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3044_LB236.getObject())));
		fs.add(sf(2, null, "Jenis Saluran Pemasaran",
				sv(O, 1, 4, refTable).confReference(EHeaderMetadataShared.R027.getObject())));
		fs.add(sf(3, null, "Wilayah Pemasaran",
				sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R026.getObject())
						.confConditionalRequired(ER3044PosLbReass236.genConditional())));
		fs.add(sf(4, null, "Kategori Badan Hukum",
				sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R005.getObject())
						.confConditionalRequired(ER3044PosLbReass236.genConditional())));
		fs.add(sf(5, null, "Jumlah Badan Hukum",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3044PosLbReass236.genConditional())));
		fs.add(sf(6, null, "Jumlah Pemasar Perorangan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3044PosLbReass236.genConditional())));
		fs.add(sf(7, null, "Nama Produk Yang Dipasarkan",
				sv(C, 1, 100, all).confConditionalRequired(ER3044PosLbReass236.genConditional())));
		fs.add(sf(8, null, "Jumlah Peserta/Tertanggung*",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3044PosLbReass236.genConditional())));
		fs.add(sf(9, null, "Premi/Kontribusi Bruto (Rp)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3044PosLbReass236.genConditional())));
		return res;
	}
}
