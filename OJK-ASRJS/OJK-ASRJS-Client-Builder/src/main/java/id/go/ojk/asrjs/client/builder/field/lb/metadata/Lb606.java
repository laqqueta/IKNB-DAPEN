package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3045PosLbAsrjs606;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb606 extends BaseMetadata {

	public Lb606(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_606;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 13, 13, ER3045PosLbAsrjs606.genFieldSave(), null,
				ER3045PosLbAsrjs606.getRequiredPos());
		res.addSegmentValidations(ER3045PosLbAsrjs606.genValidationJumlah1());
		res.addSegmentValidations(ER3045PosLbAsrjs606.genValidationJumlah2());
		res.addSegmentValidations(ER3045PosLbAsrjs606.genValidationPertanggunganPadaAkhirTahun());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3045_LB606.getObject())).confUnique(U));
		fs.add(sf(2, null, "Ekawarsa - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Ekawarsa - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Kematian Berjangka - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Kematian Berjangka - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Dwiguna - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Dwiguna - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Dwiguna Kombinasi - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Dwiguna Kombinasi - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Seumur Hidup - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(11, null, "Seumur Hidup - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(12, null, "Seumur Hidup Kombinasi - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(13, null, "Seumur Hidup Kombinasi - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(14, null, "Anuitas Umum - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(15, null, "Anuitas Umum - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(16, null, "Anuitas Dana Pensiun - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(17, null, "Anuitas Dana Pensiun - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(18, null, "Kecelakaan Diri - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(19, null, "Kecelakaan Diri - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(20, null, "Kesehatan - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(21, null, "Kesehatan - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(22, null, "Produk Investasi - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(23, null, "Produk Investasi - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(24, null, "Total - Jml Polis", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3045PosLbAsrjs606.genFieldValidation24()));
		fs.add(sf(25, null, "Total - JUP", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3045PosLbAsrjs606.genFieldValidation25()));
		return res;
	}
}
